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


public class classValidaCampos { 
    public static boolean ValidaLength(String Email, String Senha, String Atuacao, String Endereco, String CEP, String Resumo, String Nome_Responsavel,
            String contato, String Nome_ou_Empresa, String tipoUsuario){
        
        if (tipoUsuario == "Empresa"){
            if (Nome_Responsavel.length() > 100) {
                JOptionPane.showMessageDialog(null, "Nome maior que o permitido! Abrevie ou altere o nome.", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            } 
            else if (Nome_Responsavel.length() <= 1) {
                JOptionPane.showMessageDialog(null, "Nome menor que o permitido! Digite novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            } 
            
            if (Email.length() > 150) {
                JOptionPane.showMessageDialog(null, "Campo e-mail com mais caracteres que o limite! Reduza ou insira outro e-mail", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            }
        
            if (Senha.length() > 50) {
                JOptionPane.showMessageDialog(null, "Senha maior que o limite. Reduza sua senha!", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            }
            else if (Senha.length() <= 4) {
                JOptionPane.showMessageDialog(null, "Senha deve ser forte!", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            }
            
            if (Atuacao.length() > 100) {
                JOptionPane.showMessageDialog(null, "Área de Atuação maior que o limite. Diminua seu resumo!", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            }
            else if (Atuacao.length() <= 5) {
                JOptionPane.showMessageDialog(null, "Área de Atuação muito pequena. Conte mais sobre a empresa!", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            }
            if (CEP.length() < 9) {
                JOptionPane.showMessageDialog(null, "CEP não encontrado, digite um endereço CEP válido!", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            }
            
            if (Endereco.length() > 200) {
                JOptionPane.showMessageDialog(null, "Endereço maior que o permitido, abrevie ou selecione outro endereço!", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            }
            else if (Endereco.length() < 10) {
                JOptionPane.showMessageDialog(null, "Complemente seu endereço!", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            }
                       
            if (Resumo.length() > 300) {
                JOptionPane.showMessageDialog(null, "Resumo maior que o permitido, reduza!", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            }
            else if (Resumo.length() <= 10) {
                JOptionPane.showMessageDialog(null, "Resumo pequeno. Conte mais sobre a empresa!", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            }
        
            if (Nome_ou_Empresa.length() > 100) {
                JOptionPane.showMessageDialog(null, "Empresa com nome maior que o permitido! Abrevie ou altere o nome.", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            } 
            else if (Nome_ou_Empresa.length() <= 1) {
                JOptionPane.showMessageDialog(null, "Empresa com nome menor que o permitido! Digite novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            } 
              
        }
        else if (tipoUsuario == "Candidato"){
            if (Email.length() > 150) {
                JOptionPane.showMessageDialog(null, "Campo e-mail com mais caracteres que o limite! Reduza ou insira outro e-mail", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            } 
            
            if (Senha.length() > 50) {
                JOptionPane.showMessageDialog(null, "Senha maior que o limite. Reduza sua senha!", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            }
            else if (Senha.length() <= 4) {
                JOptionPane.showMessageDialog(null, "Senha deve ser forte!", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            }
        
            if (Atuacao.length() > 50) {
                JOptionPane.showMessageDialog(null, "Área de Atuação maior que o limite. Diminua seu resumo!", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            }
            else if (Atuacao.length() <= 5) {
                JOptionPane.showMessageDialog(null, "Área de Atuação muito pequena! Diga mais sobre.", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            }
            
            if (CEP.length() < 9) {
                JOptionPane.showMessageDialog(null, "CEP não encontrado, digite um endereço CEP válido!", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            }
            
            if (Endereco.length() > 200) {
                JOptionPane.showMessageDialog(null, "Endereço maior que o permitido, abrevie ou selecione outro endereço!", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            }
            else if (Endereco.length() < 10) {
                JOptionPane.showMessageDialog(null, "Complemente seu endereço!", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            }
        
            if (Resumo.length() > 300) {
                JOptionPane.showMessageDialog(null, "Resumo maior que o permitido, reduza!", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            }
            else if (Resumo.length() <= 40) {
                JOptionPane.showMessageDialog(null, "Resumo pequeno. Conte mais sobre você!", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            }
        
            if (Nome_ou_Empresa.length() > 100) {
                JOptionPane.showMessageDialog(null, "Nome maior que o permitido! Abrevie ou altere o nome.", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            } 
            else if (Nome_ou_Empresa.length() <= 1) {
                JOptionPane.showMessageDialog(null, "Nome menor que o permitido! Digite novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            } 
            
            if (contato.length() < 14){
                JOptionPane.showMessageDialog(null, "Contato não encontrado! Verifique.", "Erro", JOptionPane.ERROR_MESSAGE);
                return false; 
            }
        }
        return true;  
    }
 
}
