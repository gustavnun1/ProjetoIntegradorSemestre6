/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eleva.eleva.Model;

/**
 *
 * @author Gustavo
 */
public class classCPFInvalido {
    public static boolean isCPFValido(String cpf) {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^\\d]", "");

        // Verifica se tem 11 dígitos
        if (cpf.length() != 11) return false;

        // Verifica se todos os dígitos são iguais (tipo "111.111.111-11" — inválido)
        if (cpf.matches("(\\d)\\1{10}")) return false;

        // Calcula os dois dígitos verificadores
        int digito1 = calcularDigito(cpf.substring(0, 9), 10);
        int digito2 = calcularDigito(cpf.substring(0, 9) + digito1, 11);

        String cpfCalculado = cpf.substring(0, 9) + digito1 + digito2;
        return cpf.equals(cpfCalculado);
    }

    private static int calcularDigito(String str, int pesoInicial) {
        int soma = 0;
        for (int i = 0; i < str.length(); i++) {
            soma += Character.getNumericValue(str.charAt(i)) * (pesoInicial - i);
        }
        int resto = soma % 11;
        return (resto < 2) ? 0 : 11 - resto;
    }
}
