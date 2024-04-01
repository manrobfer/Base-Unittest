package br.com.unittests.unittest.utils;

public class Utilities {


    public int soma(int valor1, int valor2) {
        return valor1 + valor2;
    }

    public int multiplica(int valor1, int valor2) {
        return valor1 * valor2;
    }

    public int divide(int valor1, int valor2) throws Exception {
        if ((valor1 < 1) || (valor1 == 0)) {
            throw new Exception("Valor não pode ser zero");
        } else {
                return valor1 / valor2;
        }
    }
}
