package br.com.unittests.unittest;

import br.com.unittests.unittest.model.Clerk;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UnittestApplicationTests {

	@Test
	void contextLoads() {
	}

	Clerk funcionario;

	@BeforeEach
	public void setUp(){
		funcionario = new Clerk(2,"Teste Dois",17, Date.valueOf("7/01/2008"),2000);
	}

}
