/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eleva.eleva.Model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class classValidaData { 
    public static boolean dataNascimentoValida(String dataStr) {
        if (dataStr == null || dataStr.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Data de nascimento não pode ser nula!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // Garante que datas inválidas como 31/02 sejam rejeitadas

        try {
            Date data = sdf.parse(dataStr);
            Date hoje = new Date();

            // Verifica se é uma data futura
            if (data.after(hoje)) {
                JOptionPane.showMessageDialog(null, "Data de nascimento inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Verifica se é mais de 130 anos atrás
            Calendar limite = Calendar.getInstance();
            limite.add(Calendar.YEAR, -130); // Subtrai 130 anos da data atual

            if (data.before(limite.getTime())) {
                JOptionPane.showMessageDialog(null, "Data de nascimento inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            return true;
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar data de nascimento!\n Tente novamente ou contate nosso suporte!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false; // Data inválida
        }
    } 
}
 
