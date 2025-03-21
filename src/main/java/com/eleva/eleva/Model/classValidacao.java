/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eleva.eleva.Model;

import com.eleva.eleva.Controller.DatabaseManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Gustavo
 */


public class classValidacao {
    
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    
    public boolean ValidaEmail(String emailValidacao){
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(emailValidacao);
        return matcher.matches();
    }
    
    public boolean ValidacaoCadastroFuncionario(
        JTextField tfAtuacao, JTextField tfCEP, JTextField tfCPF, 
        JTextField tfContato, JTextField tfEmail, JTextField tfEndereco, 
        JTextArea tfResumo, JPasswordField tfSenha, JPasswordField tfSenhaConfirma
    ) {
        if (tfAtuacao.getText().trim().isEmpty()) {
            showError("Campo Área de Atuação é obrigatório!");
            return false;
        }
        if (tfCEP.getText().trim().isEmpty()) {
            showError("Campo CEP é obrigatório!");
            return false;
        }
        if (tfCPF.getText().trim().isEmpty()) {
            showError("Campo CPF é obrigatório!");
            return false;
        }
        if (tfContato.getText().trim().isEmpty()) {
            showError("Campo Contato é obrigatório!");
            return false;
        }
        if (tfEmail.getText().trim().isEmpty()) {
            showError("Campo Email é obrigatório!");
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

        // Verifica se o usuário já existe no banco
        try {
            String loginDuplo = DatabaseManager.login(tfEmail.getText(), senha);
            if (loginDuplo != null || !loginDuplo.equals("Usuário não encontrado")) {
                showError("Usuário já existente! Utilize outros dados.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            showError("Erro ao verificar usuário! Tente novamente.");
            return false;
        }

        return true;
    }

    private static void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.ERROR_MESSAGE);
    }
 
    public boolean ValidacaoCadastroRecrutador(
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
        if (tfResponsavel.getText().trim().isEmpty()) {
            showError("Campo Nome é obrigatório!");
            return false;
        }
        if (tfEmail.getText().trim().isEmpty()) {
            showError("Campo Email é obrigatório!");
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
 
}
