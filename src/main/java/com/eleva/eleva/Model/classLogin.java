/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eleva.eleva.Model;

import com.eleva.eleva.Controller.DatabaseManager;
import com.eleva.eleva.View.formPerfilCandidato;
import com.eleva.eleva.View.formRecrutador;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Gustavo
 */
public class classLogin {
    
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
    
    public static String retornaTipologin (String email, String senha){
        String tipoLogin;
        tipoLogin = DatabaseManager.login(email, senha); 
        
        return tipoLogin;
    }
    
    public static boolean tryLogin (String loginType, String email, String senha){ 
        if (loginType == null || loginType.equals("") || loginType.equals("Usuário não encontrado")) {
            JOptionPane.showMessageDialog(null, "E-mail e/ou senha incorretos ou inexistentes! Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        JOptionPane.showMessageDialog(null, "Login realizado como: " + loginType + "\n Seja Bem-Vindo!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        
        if (loginType.equals("Recrutador")) {
            formRecrutador telaRecruiter = new formRecrutador();
            telaRecruiter.setEmail(email);
            telaRecruiter.setVisible(true);
        } else { 
            formPerfilCandidato perfilCandidato = new formPerfilCandidato("Candidato", email); 
            perfilCandidato.setVisible(true);
        }
        return true;
    }
}
