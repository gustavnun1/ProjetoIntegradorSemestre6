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
public class classAtualizaTabelasAux {
    public static boolean atualizaAux(String email, String email_anterior){ 
        try {
            DatabaseManager.updateRecuperaSenha(email, email_anterior); 
            DatabaseManager.updateMensageria(email, email_anterior); 
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar dados: " + e.getMessage(), "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Para depuração no console
            return false;
        }
    }
}
