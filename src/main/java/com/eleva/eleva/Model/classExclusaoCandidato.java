/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eleva.eleva.Model;

import com.eleva.eleva.Controller.DatabaseManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class classExclusaoCandidato {
    public static boolean confirmaExclusao(String CPF, String senha){
        String confirmacao = JOptionPane.showInputDialog(null, "Deseja realmente excluir sua conta da nossa plataforma? Todos os dados serão apagados!\n S/N", "Atenção!", 
        JOptionPane.OK_OPTION);
        
        if (confirmacao.equalsIgnoreCase("S")){
            String senhaCorreta = JOptionPane.showInputDialog(null, "Digite sua senha para excluir a conta.", "Atenção", JOptionPane.OK_OPTION); 
        
            if (senhaCorreta != null && senhaCorreta.equals(senha)) {
                try {
                    DatabaseManager.deleteCandidato(CPF);
                    return true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e.getMessage());
                    return false;
                } 
            }
        }      
        return false;
    }
}
