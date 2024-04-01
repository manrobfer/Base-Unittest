package br.com.unittests.unittest.controller;

import br.com.unittests.unittest.dto.ClerkDTO;
import br.com.unittests.unittest.model.Clerk;
import br.com.unittests.unittest.service.ClerkService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Collections;
import java.util.Date;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
public class ClerkControllerTest {

    @InjectMocks
    private ClerkController clerkController;

    @Mock
    ClerkService clerkService;

    private MockMvc mockMvc;

    private String url;

    private String json;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private ClerkDTO clerkDTO;

    private Clerk clerk;

    @BeforeEach
    void setup() throws JsonProcessingException {

        mockMvc = MockMvcBuilders.standaloneSetup(clerkController).alwaysDo(print()).build();
        url = "/clerk";
        clerkDTO = ClerkDTO.builder().age(30).
                                      code(10).
                                      name("Manoel").
                                      wages(10.00).
                                      birthDate(new Date(2004,07,12)).
                                      build();

        clerk = Clerk.builder().age(10)
                               .name("Manoel")
                               .wages(10000)
                               .code(1)
                               .birthDate(new Date(2004, 07, 12))
                               .build();

        json = objectMapper.writeValueAsString(clerkDTO);
    }


    @Test
    public void checaSeBuscaTodosOsItens() throws Exception {
            when(clerkService.getAllByName(clerkDTO)).thenReturn(Collections.singletonList(clerk));

            mockMvc.perform(post(url + "/findAllByName")
                   .contentType(MediaType.APPLICATION_JSON)
                   .content(json)
                   .accept(MediaType.APPLICATION_JSON))
                   .andExpect(status().isOk());

            verify(clerkService).getAllByName(clerkDTO);
            verifyNoMoreInteractions(clerkService);
    }

    @Test
    public void deveRetonarUmUsuarioSemParametro() throws Exception {

        when(clerkService.findByName()).thenReturn(clerk);

        mockMvc.perform(post( url + "/findByOneName")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(clerkService).findByName();
        verifyNoMoreInteractions(clerkService);
    }

    @Test
    public void naoDeveEnviarClerkNulo() throws Exception {

        mockMvc.perform(post(url + "/findAllByName")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isBadRequest());

        //verify(clerkService).getAllByName(clerkDTO);
        verifyNoInteractions(clerkService);

    }
}
