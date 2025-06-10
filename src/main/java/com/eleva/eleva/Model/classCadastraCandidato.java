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
public class classCadastraCandidato {
    
    public static boolean cadastraCandidato (String sAreaAtuacao, String sCEP, String sCPF, String sContato, String sEmail, 
            String sEndereco, String sSenha, String sResumoPessoal, String sNomeUsuario, byte[] pathCurriculo, String nascimento) {
        try {
            DatabaseManager.insertCandidatos(sAreaAtuacao, sCEP, sCPF, sContato, sEmail, sEndereco, sSenha, sResumoPessoal, sNomeUsuario, pathCurriculo, nascimento);
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Sucesso", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e.getMessage(), "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Para depuração no console
            return false;
        }  
    } 
    
}
