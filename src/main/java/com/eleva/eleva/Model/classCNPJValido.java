/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eleva.eleva.Model;

/**
 *
 * @author Gustavo
 */
public class classCNPJValido {
    public static boolean isCNPJValido(String cnpj) {
        // Remove caracteres não numéricos
        cnpj = cnpj.replaceAll("[^\\d]", "");

        // Verifica se tem 14 dígitos
        if (cnpj.length() != 14) return false;

        // Verifica se todos os dígitos são iguais (CNPJs inválidos)
        if (cnpj.matches("(\\d)\\1{13}")) return false;

        // Calcula os dígitos verificadores
        int[] pesos1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] pesos2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        String cnpjSemDigitos = cnpj.substring(0, 12);
        int digito1 = calcularDigito(cnpjSemDigitos, pesos1);
        int digito2 = calcularDigito(cnpjSemDigitos + digito1, pesos2);

        String cnpjCalculado = cnpjSemDigitos + digito1 + digito2;
        return cnpj.equals(cnpjCalculado);
    }
     private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int i = 0; i < str.length(); i++) {
            soma += Character.getNumericValue(str.charAt(i)) * peso[i];
        }
        int resto = soma % 11;
        return (resto < 2) ? 0 : 11 - resto;
    }
}
