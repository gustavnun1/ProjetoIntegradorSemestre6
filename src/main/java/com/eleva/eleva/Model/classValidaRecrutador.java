/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eleva.eleva.Model;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Gustavo
 */
public class classValidaRecrutador { 
    public static boolean ValidacaoCadastroRecrutador(
        JTextField tfAreaAtuacao, JTextField tfCEP, JTextField tfCNPJ,
        JTextField tfResponsavel, JTextField tfEmail, JTextField tfEndereco,
        JTextArea tfResumo, JPasswordField tfSenha, JPasswordField tfSenhaConfirma
    ) {
        if (tfAreaAtuacao.getText().trim().isEmpty()) {
            showError("Campo Área de Atuação é obrigatório!");
            return false;
        }
        if (tfCEP.getText().trim().isEmpty()) {
            showError("Campo CEP é obrigatório!");
            return false;
        }
        
        if (tfCNPJ.getText().trim().isEmpty()) {
            showError("Campo CNPJ é obrigatório!");
            return false;
        }
        else if (!classCNPJValido.isCNPJValido(tfCNPJ.getText())){
            showError("CNPJ Inválido!");
            return false;
        }
        
        if (tfResponsavel.getText().trim().isEmpty()) {
            showError("Campo Nome é obrigatório!");
            return false;
        }
        else if (classRecusaNumeros.contemNumeros(tfResponsavel.getText())){
            showError("Campo Nome não deve conter números!");
            return false;
        }
        
        if (tfEmail.getText().trim().isEmpty()) {
            showError("Campo Email é obrigatório!");
            return false;
        }
        else if (!classEmail.Validacao(tfEmail.getText())){
            showError("Digite um e-mail válido!");
            return false;
        }
        
        if (tfEndereco.getText().trim().isEmpty()) {
            showError("Campo Endereço é obrigatório!");
            return false;
        }
        if (tfResumo.getText().trim().isEmpty()) {
            showError("Campo Resumo é obrigatório!");
            return false;
        }
        
        if (tfSenha.getPassword().length == 0) {
            showError("Campo Senha é obrigatório!");
            return false;
        }
        else if (tfSenha.getPassword().length < 4){
            showError("Senha deve conter mais que 4 digitos!");
            return false;
        }
        
        if (tfSenhaConfirma.getPassword().length == 0) {
            showError("Campo Confirmar Senha é obrigatório!");
            return false;
        }

        // Verifica se as senhas coincidem
        String senha = new String(tfSenha.getPassword());
        String senhaConfirma = new String(tfSenhaConfirma.getPassword());
        if (!senha.equals(senhaConfirma)) {
            showError("As senhas não coincidem!");
            return false;
        }

        return true;
    }
    private static void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.ERROR_MESSAGE);
    }
 
}
