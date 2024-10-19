package projetointegradorConn.model;
import projetointegradorConn.controler.Conn;
import projetointegradorConn.model.cadastro.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {
    public void inserirCliente(Cliente cliente) {
        // Inserir Email, Endereco e Telefone
        String sqlEmail = "INSERT INTO Email (email) VALUES (?)";
        String sqlEndereco = "INSERT INTO Endereco (rua, cep, bairro, cidade) VALUES (?, ?, ?, ?)";
        String sqlTelefone = "INSERT INTO Telefone (telefone) VALUES (?)";
        String sqlCliente = "INSERT INTO Cliente (idCliente, nome, idEndereco, idEmail, idTelefone) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conn.getConexao()) {
            // Inserindo Email
            int emailId = 0;
            try (PreparedStatement pstmtEmail = conn.prepareStatement(sqlEmail, PreparedStatement.RETURN_GENERATED_KEYS)) {
                pstmtEmail.setString(1, cliente.getEmail().getEmail());
                pstmtEmail.executeUpdate();
                // Obtendo o ID gerado para o Email
                try (ResultSet generatedKeys = pstmtEmail.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        emailId = generatedKeys.getInt(1);
                    }
                }
            }

            // Inserindo Endereço
            int enderecoId = 0;
            try (PreparedStatement pstmtEndereco = conn.prepareStatement(sqlEndereco, PreparedStatement.RETURN_GENERATED_KEYS)) {
                pstmtEndereco.setString(1, cliente.getEndereco().getRua());
                pstmtEndereco.setInt(2, cliente.getEndereco().getCep());
                pstmtEndereco.setString(3, cliente.getEndereco().getBairro());
                pstmtEndereco.setString(4, cliente.getEndereco().getCidade());
                pstmtEndereco.executeUpdate();
                // Obtendo o ID gerado para o Endereço
                try (ResultSet generatedKeys = pstmtEndereco.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        enderecoId = generatedKeys.getInt(1);
                    }
                }
            }

            // Inserindo Telefone
            int telefoneId = 0;
            try (PreparedStatement pstmtTelefone = conn.prepareStatement(sqlTelefone, PreparedStatement.RETURN_GENERATED_KEYS)) {
                pstmtTelefone.setString(1, cliente.getTelefone().getTelefone());
                pstmtTelefone.executeUpdate();
                // Obtendo o ID gerado para o Telefone
                try (ResultSet generatedKeys = pstmtTelefone.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        telefoneId = generatedKeys.getInt(1);
                    }
                }
            }

            // Inserindo Cliente
            try (PreparedStatement pstmtCliente = conn.prepareStatement(sqlCliente)) {
                pstmtCliente.setInt(1, cliente.getIdCliente());
                pstmtCliente.setString(2, cliente.getNome());
                pstmtCliente.setInt(3, enderecoId); // ID do Endereço
                pstmtCliente.setInt(4, emailId);    // ID do Email
                pstmtCliente.setInt(5, telefoneId);  // ID do Telefone
                pstmtCliente.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}