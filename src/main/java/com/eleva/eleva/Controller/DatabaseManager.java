package com.eleva.eleva.Controller;

import com.eleva.eleva.View.formRecrutador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.eleva.eleva.Model.classCarregaCandidatos;
import com.eleva.eleva.Model.classCarregaEmpresa; 
import com.eleva.eleva.View.formPerfilCandidato;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
            String senha, String resumoPessoal, String nome, byte[] curriculo, String nascimento) {
        String sql = "INSERT INTO eCandidatos (Area_Atuacao, CEP, CPF, Contato, Email, Endereco, Senha, Resumo_Profissional, NOME, Curriculo, Data_Nascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            pstmt.setBytes(10, curriculo);
            pstmt.setString(11, nascimento);
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
                        ", Area de Atuação: " + rs.getString("Area_Atuacao") +
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

    public static void carregarDados(JTable tbCandidatos) {  
        String sql = "SELECT Nome, Email, Contato, Area_Atuacao, Curriculo FROM eCandidatos"; // Ajuste conforme necessário

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            DefaultTableModel modelo = (DefaultTableModel) tbCandidatos.getModel();
            modelo.setRowCount(0); // Limpa os dados existentes

            // Adiciona os dados à tabela
            while (rs.next()) {
                Object[] linha = {
                    rs.getString("Nome"),
                    rs.getString("Email"),
                    rs.getString("Contato"),
                    rs.getString("Area_Atuacao"),
                    rs.getString("Curriculo") 
                };
                modelo.addRow(linha);
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
     
    
    public static classCarregaCandidatos carregarDadosCandidato(String email) {  
        String sql = "SELECT Nome, Senha, Email, CPF, Contato, Endereco, Area_Atuacao, Resumo_profissional, CEP, Curriculo, Data_Nascimento FROM eCandidatos WHERE Email = ?"; 

        classCarregaCandidatos dados = new classCarregaCandidatos();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    dados.nome = rs.getString("Nome");
                    dados.senha = rs.getString("Senha");
                    dados.cpf = rs.getString("CPF");
                    dados.email = rs.getString("Email");
                    dados.contato = rs.getString("Contato");
                    dados.endereco = rs.getString("Endereco");
                    dados.experiencia = rs.getString("Area_Atuacao");
                    dados.resumo = rs.getString("Resumo_profissional");
                    dados.cep = rs.getString("CEP");
                    dados.curriculo = rs.getBytes("curriculo");
                    dados.nascimento = rs.getString("Data_Nascimento");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dados;
    }
    
    
    public static classCarregaEmpresa carregarDadosEmpresa(String email) {  
        String sql = "SELECT Area_Atuacao, CEP, CNPJ, EMAIL, Empresa, Endereco, Senha, Resumo, NOME_RESPONSAVEL FROM eRecrutadores WHERE EMAIL = ?"; 

        
        classCarregaEmpresa empresa = new classCarregaEmpresa();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email); // Define o parâmetro antes da execução

            try (ResultSet rs = pstmt.executeQuery()) { // Executa a consulta

                if (rs.next()) { // Verifica se há resultados antes de acessar os campos
                    
                    empresa.AreaAtuacao = (rs.getString("Area_Atuacao"));
                    empresa.CEP =(rs.getString("CEP")); 
                    empresa.CNPJ = rs.getString("CNPJ");
                    empresa.Email = (rs.getString("EMAIL"));
                    empresa.Empresa = (rs.getString("Empresa"));
                    empresa.Endereco = (rs.getString("Endereco"));
                    empresa.Senha = (rs.getString("Senha"));
                    empresa.ResumoEmpresa = (rs.getString("Resumo"));
                    empresa.NomeResponsavel = (rs.getString("NOME_RESPONSAVEL")); 
                } 
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empresa;
    }
    /////////////////////////////////SELECT//////////////////////////////////////    


    
    
    /////////////////////////////////UPDATE//////////////////////////////////////
    public static void updateCandidatos(String areaAtuacao, String cep, String cpf, String contato, String email, String endereco, String senha, String resumoPessoal, String usuario, byte[] curriculo) {
        String sqlUpdate = "UPDATE eCandidatos SET Area_Atuacao = ?, CEP = ?, CPF = ?, Contato = ?, Email = ?, Endereco = ?, Senha = ?, Resumo_Profissional = ?, NOME = ?, Curriculo = ? WHERE CPF = ?";
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
            pstmt.setBytes(10, curriculo); 
            pstmt.setString(11, cpf);
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
        String sqlUpdate = "UPDATE eRecrutadores SET Area_Atuacao = ?, CEP = ?, CNPJ = ?, Email = ?, Empresa = ?, Endereco = ?, Senha = ?, Resumo = ?, NOME_RESPONSAVEL = ? WHERE CNPJ = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {
            pstmt.setString(1, Area_Atuacao);
            pstmt.setString(2, CEP);
            pstmt.setString(3, CNPJ);
            pstmt.setString(4, email);
            pstmt.setString(5, Nome_Empresa);
            pstmt.setString(6, Endereco);
            pstmt.setString(7, SENHA);
            pstmt.setString(8, Resumo);
            pstmt.setString(9, nome_usuario);  
            pstmt.setString(10, CNPJ);
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
    
    
    
    
    ////////////////////////////////MENSAGERIA///////////////////////////////////
    public static boolean enviaMensagem(String email, String empresa, String mensagem){
        String sql = "INSERT INTO Mensageria (Empresa_Remetente, Email_Destinatario, Mensagem, Data_Envio) VALUES (?, ?, ?, GETDATE())";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, empresa);
            pstmt.setString(2, email);
            pstmt.setString(3, mensagem);
            pstmt.executeUpdate();
            
            System.out.println("Mensagem enviada com sucesso!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao enviar mensagem: " + e.getMessage());
            return false;
        }
    }
    
    public static void carregaMensagens(String email) {  
        String sql = "SELECT * FROM Mensageria WHERE Email_Destinatario = ?"; 
 
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);  

            try (ResultSet rs = pstmt.executeQuery()) { // Executa a consulta

                boolean temMensagens = false;

                 
                while (rs.next()){
                    temMensagens = true;
                    JOptionPane.showMessageDialog(
                        null,
                        "Mensagem de " + rs.getString("Empresa_Remetente") + "\n\n"
                        + rs.getString("Mensagem") + "\n\n"
                        + "Enviado para: " + rs.getString("Email_Destinatario") + "\n"
                        + "Data de Envio: " + rs.getString("Data_Envio"),
                        "Envio realizado por: " + rs.getString("Empresa_Remetente"),
                        JOptionPane.INFORMATION_MESSAGE
                    );
                } 

                if (!temMensagens) {
                    JOptionPane.showMessageDialog(
                        null,
                        "No momento, você não possui mais mensagens. Volte novamente mais tarde!",
                        "Sem Mensagens",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    public static void updateMensageria(String email, String email_antigo) {
        String sqlUpdate = "UPDATE Mensageria SET Email_Destinatario = ? WHERE Email_Destinatario = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {
            pstmt.setString(1, email); 
            pstmt.setString(2, email_antigo); 
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Registro atualizado com sucesso.");
            } else {
                System.out.println("Nenhum registro encontrado com o e-mail: " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    ////////////////////////////////MENSAGERIA///////////////////////////////////
    
    ////////////////////////////////RECUPERA SENHA///////////////////////////////////
    public static void updateRecuperaSenha(String email, String email_antigo) {
        String sqlUpdate = "UPDATE RecuperaSenha SET email = ? WHERE email = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {
            pstmt.setString(1, email); 
            pstmt.setString(2, email_antigo); 
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Registro atualizado com sucesso.");
            } else {
                System.out.println("Nenhum registro encontrado com o e-mail: " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void gravaRecuperacaoSenha(String email, String opcao, String resposta){
        String sql = "INSERT INTO RecuperaSenha (email, pergunta_secreta, resposta_correta) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, opcao);
            pstmt.setString(3, resposta);
            pstmt.executeUpdate();
            
            System.out.println("Recuperação gravada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao realizar gravação: " + e.getMessage());
        }
    }
    
    public static String carregaRecuperacaoSenha(String email) {  
        String sql = "SELECT * FROM RecuperaSenha WHERE email = ?"; 
 
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email); // Define o parâmetro antes da execução

            try (ResultSet rs = pstmt.executeQuery()) {  
 
                if (rs.next()) {
                    return rs.getString("pergunta_secreta");
                } 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static boolean confirmaRecuperacaoSenha(String email) {  
        String sql = "SELECT * FROM RecuperaSenha WHERE email = ? and resposta_correta = ?"; 
 
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email); // Define o parâmetro antes da execução

            try (ResultSet rs = pstmt.executeQuery()) {  
 
                if (rs.next()) {
                    return true;
                } 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    ////////////////////////////////RECUPERA SENHA///////////////////////////////////
}
