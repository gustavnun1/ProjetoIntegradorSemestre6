/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eleva.eleva.Model;

import com.eleva.eleva.View.formPerfilCandidato;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Gustavo
 */
public class classCurriculo {
    /*
    public static void salvarCurriculo(byte[] pdfBytes) { 
        if (pdfBytes == null || pdfBytes.length == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum conteúdo de PDF disponível para salvar.");
            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File("arquivo_salvo.pdf"));
        int resultado = fileChooser.showSaveDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File arquivo = fileChooser.getSelectedFile();

            try (FileOutputStream fos = new FileOutputStream(arquivo)) {
                fos.write(pdfBytes);
                JOptionPane.showMessageDialog(null, "PDF salvo com sucesso!");
                return;
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo: " + e.getMessage());
            }
        } 
    }
    */
    public static boolean salvarCurriculoParaTestar(byte[] pdfBytes) { 
        if (pdfBytes == null || pdfBytes.length == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum conteúdo de PDF disponível para salvar.");
            return false;
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File("arquivo_salvo.pdf"));
        int resultado = fileChooser.showSaveDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File arquivo = fileChooser.getSelectedFile();

            try (FileOutputStream fos = new FileOutputStream(arquivo)) {
                fos.write(pdfBytes);
                JOptionPane.showMessageDialog(null, "PDF salvo com sucesso!");
                return true;
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo: " + e.getMessage());
                return false;
            }
        }
        return false;
    }
    
    public static byte[] editarCurriculo(){
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos PDF", "pdf");
        fileChooser.setFileFilter(filtro);

        int resultado = fileChooser.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File arquivo = fileChooser.getSelectedFile();
  
            try (FileInputStream fis = new FileInputStream(arquivo)) {
                return fis.readAllBytes();  
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo: " + e.getMessage());
            }
        }

        return null; 
    }
    
    public static byte[] buscarCurriculo() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos PDF", "pdf");
        fileChooser.setFileFilter(filtro);

        int resultado = fileChooser.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File arquivo = fileChooser.getSelectedFile();
  
            try (FileInputStream fis = new FileInputStream(arquivo)) {
                return fis.readAllBytes();  
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo: " + e.getMessage());
            }
        }

        return null;
    }
}
