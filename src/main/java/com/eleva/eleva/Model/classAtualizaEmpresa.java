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
public class classAtualizaEmpresa {
    public static void atualizaEmpresa(String nome_usuario, String email,String SENHA ,String CNPJ , String Nome_Empresa , String CEP , String Endereco ,
    String Area_Atuacao , String Resumo){ 
        try {
            DatabaseManager.updateEmpresa(nome_usuario, email, SENHA ,CNPJ ,Nome_Empresa , CEP , Endereco ,Area_Atuacao , Resumo); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar dados: " + e.getMessage(), "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Para depuração no console
        }
    }
}
