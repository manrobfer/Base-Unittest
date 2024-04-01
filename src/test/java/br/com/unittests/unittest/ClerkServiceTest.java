package br.com.unittests.unittest;

import br.com.unittests.unittest.daos.ClerkDao;
import br.com.unittests.unittest.exceptions.ServiceException;
import br.com.unittests.unittest.model.Clerk;
import br.com.unittests.unittest.service.ClerkService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClerkServiceTest {

    @InjectMocks
    ClerkService clerkService;

    @Mock
    ClerkDao clerkDao;

    Clerk clerk;

    @BeforeEach
    public void setup(){
        clerk =  new Clerk(14,"Teste Quatra",6, new Date(),2600);
    }

    @Test
    void shouldFindClerkByName(){
        System.out.println(clerk.getName());
          when(clerkDao.findOneByName(clerk.getName())).thenReturn(clerk);
          Clerk clerkFound = clerkService.getByNome(clerk.getName());

          Assertions.assertEquals(clerk,clerkFound );
          verify(clerkDao).findOneByName(clerk.getName());
          verifyNoMoreInteractions(clerkDao);
    }

    @Test
    void shouldNotInvokeDaoWhenNameNull() {
        final ServiceException exception = assertThrows(ServiceException.class, () -> {
            clerkService.getByNome(null);   });

            assertThat(exception.getMessage(), is("Possível erro de digitação ao localizar nome null "));
            assertThat(exception, notNullValue());
            //assertThat(exception.getCause().getMessage(), is("Nome é obrigatório"));
    }


}
