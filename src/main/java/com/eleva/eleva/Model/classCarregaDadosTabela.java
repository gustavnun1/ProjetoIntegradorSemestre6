/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eleva.eleva.Model;

import com.eleva.eleva.Controller.DatabaseManager;
import javax.swing.JTable;

/**
 *
 * @author Gustavo
 */
public class classCarregaDadosTabela {
    public static void carregaTabela(JTable tbCandidatos){
        DatabaseManager.carregarDados(tbCandidatos);
    }
}
