/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eleva.eleva.Model;

import com.eleva.eleva.Controller.DatabaseManager;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author Gustavo
 */
public class classConfirmaCandidato {
    
    public static boolean confirmaCandidato(String senhaAnterior, JPasswordField tfSenha, String areaAtuacao, String cep, String cpf, String contato, String email, String endereco, String resumoPessoal, String usuario, byte[] curriculo){
        String senhaCorreta = JOptionPane.showInputDialog(null, "Para alterar os dados, digite sua senha abaixo.", "Atenção", JOptionPane.OK_OPTION);
        String senhaAtualizada = new String(tfSenha.getPassword());
        if (senhaCorreta != null && senhaCorreta.equals(senhaAnterior)) {
            classAtualizaCandidato.atualizaCandidato(areaAtuacao, cep, cpf, contato, email, endereco, senhaAtualizada, resumoPessoal, usuario, curriculo); 
            JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } 
        else{
            JOptionPane.showMessageDialog(null, "Senha incorreta ou incompleta! Tente Novamente", "Erro", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
    }
}
