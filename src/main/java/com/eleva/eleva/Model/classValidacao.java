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
    
    public static boolean ValidaEmail(String emailValidacao){        
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(emailValidacao);
        return matcher.matches();
    }
    
    public static boolean ValidacaoCadastroFuncionario(
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
    
    public static boolean ValidacaoLogin(JTextField email, JPasswordField senha) { 
        if (email.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo E-mail é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } 
        if (senha.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Campo Senha é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true; 
    }
    
    public static boolean ValidaLength(String Email, String Senha, String Atuacao, String Endereco, String Resumo, String Empresa){
        
        if (Email.length() > 150) {
           JOptionPane.showMessageDialog(null, "Campo e-mail com mais caracteres que o limite! Reduza ou insira outro e-mail", "Erro", JOptionPane.ERROR_MESSAGE);
           return false; 
        }
        
        if (Senha.length() > 50) {
           JOptionPane.showMessageDialog(null, "Senha maior que o limite. Reduza sua senha!", "Erro", JOptionPane.ERROR_MESSAGE);
           return false; 
        }
        
        if (Atuacao.length() > 100) {
           JOptionPane.showMessageDialog(null, "Área de Atuação maior que o limite. Diminua seu resumo!", "Erro", JOptionPane.ERROR_MESSAGE);
           return false; 
        }
        
        if (Endereco.length() > 200) {
           JOptionPane.showMessageDialog(null, "Endereço maior que o permitido, abrevie ou selecione outro endereço!", "Erro", JOptionPane.ERROR_MESSAGE);
           return false; 
        }
        
        if (Resumo.length() > 300) {
           JOptionPane.showMessageDialog(null, "Resumo maior que o permitido, reduza!", "Erro", JOptionPane.ERROR_MESSAGE);
           return false; 
        }
        
        if (Empresa.length() > 100) {
           JOptionPane.showMessageDialog(null, "Empresa com nome maior que o permitido! Abrevie ou altere o nome.", "Erro", JOptionPane.ERROR_MESSAGE);
           return false; 
        }
        return true;
    }
 
}
