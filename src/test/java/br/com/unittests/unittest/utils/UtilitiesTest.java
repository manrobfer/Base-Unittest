package br.com.unittests.unittest.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.*;

public class UtilitiesTest {

    Utilities utilities = new Utilities();

    @Test
    public void testaSeTesteFunciona(){
        int esperado = 10;
        int atual = 10;

        assertEquals(esperado, atual);

      }

      @Test
      public void testaSeRetornaSomaCorrera(){
           int valor1 = 100;
           int valor2 = 200;

           int somando = utilities.soma(valor1, valor2);
           int esperado = 300;
          assertEquals(esperado, somando);

    }

    @Test
    public void testaSeRetornaMultiplicaCorrera(){
        int valor1 = 100;
        int valor2 = 200;

        int somando = utilities.soma(valor1, valor2);
        int esperado = 300;
        assertEquals(esperado, somando);

    }

    @Test
    public void testaSeRetornaDivide() throws Exception {
        int valor1 = 0;
        int valor2 = 200;

       // int somando = utilities.divide(valor1, valor2);
        int esperado = 300;
        Exception exception = assertThrows(Exception.class, () -> {
            utilities.divide(valor1, valor2);
        });
        String messageExpected = "Valor não pode ser zero";
        String messageReturned = exception.getMessage();

        assertTrue(messageReturned.contains(messageExpected));



    }
}

