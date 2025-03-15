package com.eleva.eleva.Controller;

import com.eleva.eleva.View.formRecrutador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=dbEleva;encrypt=false";
    private static final String USER = "AdministradorEleva";
    private static final String PASSWORD = "admin123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    } 

    
    /////////////////////////////////INSERT//////////////////////////////////////
    public static void insertCandidatos(String areaAtuacao, String cep, String cpf, String contato, String email, String endereco, 
            String senha, String resumoPessoal, String nome, String curriculo ) {
        String sql = "INSERT INTO eCandidatos (Area_Atuacao, CEP, CPF, Contato, Email, Endereco, Senha, Resumo_Profissional, NOME, Curriculo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, areaAtuacao);
            pstmt.setString(2, cep);
            pstmt.setString(3, cpf);
            pstmt.setString(4, contato);
            pstmt.setString(5, email);
            pstmt.setString(6, endereco);
            pstmt.setString(7, senha);
            pstmt.setString(8, resumoPessoal);
            pstmt.setString(9, nome); 
            pstmt.setString(10, curriculo); 
            pstmt.executeUpdate();
            System.out.println("Registro inserido com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void insertRecrutador(String nome_usuario, String email,String SENHA ,String CNPJ , String Nome_Empresa , String CEP , String Endereco ,
    String Area_Atuacao , String Resumo ) {
        String sql = "INSERT INTO eRecrutadores (NOME_RESPONSAVEL, EMAIL, SENHA, CNPJ, Empresa, CEP, Endereco, Area_Atuacao, Resumo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome_usuario);
            pstmt.setString(2, email);
            pstmt.setString(3, SENHA);
            pstmt.setString(4, CNPJ);
            pstmt.setString(5, Nome_Empresa);
            pstmt.setString(6, CEP);
            pstmt.setString(7, Endereco);
            pstmt.setString(8, Area_Atuacao);
            pstmt.setString(9, Resumo);  
            pstmt.executeUpdate();
            System.out.println("Registro inserido com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /////////////////////////////////INSERT//////////////////////////////////////
    
    
    
    
    
    /////////////////////////////////SELECT//////////////////////////////////////
    public static void readCandidatos() {
        String sql = "SELECT * FROM eCandidatos";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID") +
                        ", Area de Atuação: " + rs.getString("AreaAtuacao") +
                        ", CEP: " + rs.getString("CEP") +
                        ", CPF: " + rs.getString("CPF") +
                        ", Contato: " + rs.getString("Contato") +
                        ", Email: " + rs.getString("Email") +
                        ", Endereço: " + rs.getString("Endereco") +
                        ", Resumo Pessoal: " + rs.getString("ResumoPessoal") +
                        ", Usuário: " + rs.getString("Usuario"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readRecruiters() {
        String sql = "SELECT * FROM eRecrutadores";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID") +
                        ", Area de Atuação: " + rs.getString("AreaAtuacao") +
                        ", CEP: " + rs.getString("CEP") +
                        ", CPF: " + rs.getString("CPF") +
                        ", Contato: " + rs.getString("Contato") +
                        ", Email: " + rs.getString("Email") +
                        ", Endereço: " + rs.getString("Endereco") +
                        ", Resumo Pessoal: " + rs.getString("ResumoPessoal") +
                        ", Usuário: " + rs.getString("Usuario"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static String login(String email, String senha) {
        String sqlRecrutadores = "SELECT 'Recrutador' AS Tipo FROM eRecrutadores WHERE Email = ? AND Senha = ?";
        String sqlCandidatos   = "SELECT 'Candidato' AS Tipo FROM eCandidatos WHERE Email = ? AND Senha = ?";

        try (Connection conn = getConnection()) {
            // Verifica em eRecrutadores
            try (PreparedStatement pstmt = conn.prepareStatement(sqlRecrutadores)) {
                pstmt.setString(1, email);
                pstmt.setString(2, senha);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        return "Recrutador";
                    }
                }
            }

            // Verifica em eCandidatos
            try (PreparedStatement pstmt = conn.prepareStatement(sqlCandidatos)) {
                pstmt.setString(1, email);
                pstmt.setString(2, senha);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        return "Candidato";
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return "Usuário não encontrado";
    }
     
    /////////////////////////////////SELECT//////////////////////////////////////    


    
    
    /////////////////////////////////UPDATE//////////////////////////////////////
    public static void updateCandidatos(int id, String areaAtuacao, String cep, String cpf, String contato, String email, String endereco, String senha, String resumoPessoal, String usuario) {
        String sqlUpdate = "UPDATE eCandidatos SET AreaAtuacao = ?, CEP = ?, CPF = ?, Contato = ?, Email = ?, Endereco = ?, Senha = ?, ResumoPessoal = ?, Usuario = ? WHERE ID = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {
            pstmt.setString(1, areaAtuacao);
            pstmt.setString(2, cep);
            pstmt.setString(3, cpf);
            pstmt.setString(4, contato);
            pstmt.setString(5, email);
            pstmt.setString(6, endereco);
            pstmt.setString(7, senha);
            pstmt.setString(8, resumoPessoal);
            pstmt.setString(9, usuario);
            pstmt.setInt(10, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Registro atualizado com sucesso.");
            } else {
                System.out.println("Nenhum registro encontrado com o CPF: " + cpf);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void updateEmpresa(String nome_usuario, String email,String SENHA ,String CNPJ , String Nome_Empresa , String CEP , String Endereco ,
    String Area_Atuacao , String Resumo) {
        String sqlUpdate = "UPDATE eRecrutadores SET AreaAtuacao = ?, CEP = ?, CPF = ?, Contato = ?, Email = ?, Endereco = ?, Senha = ?, ResumoPessoal = ?, Usuario = ? WHERE ID = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {
            pstmt.setString(1, nome_usuario);
            pstmt.setString(2, email);
            pstmt.setString(3, SENHA);
            pstmt.setString(4, CNPJ);
            pstmt.setString(5, Nome_Empresa);
            pstmt.setString(6, CEP);
            pstmt.setString(7, Endereco);
            pstmt.setString(8, Area_Atuacao);
            pstmt.setString(9, Resumo);  
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Registro atualizado com sucesso.");
            } else {
                System.out.println("Nenhum registro encontrado com o CNPJ: " + CNPJ);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /////////////////////////////////UPDATE//////////////////////////////////////
    
    
    
    /////////////////////////////////DELETE//////////////////////////////////////
    public static void deleteCandidato(String CPF) {
        String sqlDelete = "DELETE FROM eCandidatos WHERE CPF = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlDelete)) {
            pstmt.setString(1, CPF);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Registro excluído com sucesso.");
            } else {
                System.out.println("Nenhum registro encontrado com o CPF: " + CPF);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void deleteEmpresa(String CNPJ) {
        String sqlDelete = "DELETE FROM eRecrutadores WHERE CNPJ = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlDelete)) {
            pstmt.setString(1, CNPJ);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Registro excluído com sucesso.");
            } else {
                System.out.println("Nenhum registro encontrado com o CNPJ: " + CNPJ);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /////////////////////////////////DELETE//////////////////////////////////////
}
