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
public class classAtualizaCandidato {
    public static void atualizaCandidato(String areaAtuacao, String cep, String cpf, String contato, String email, String endereco, String senha, String resumoPessoal, String usuario, byte[] curriculo){
        try{
            DatabaseManager.updateCandidatos(areaAtuacao, cep, cpf, contato, email, endereco, senha, resumoPessoal, usuario, curriculo);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar dados: " + e.getMessage(), "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Para depuração no console
        }
    }
}
