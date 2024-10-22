package projetointegradorConn.model.DAO;
import projetointegradorConn.model.conn.Conn;
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
        String sqlCliente = "INSERT INTO Cliente (nome, idEndereco, idEmail, idTelefone) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conn.getConexao()) {
            // Inserir Email
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

            // Inserir Endereço
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

            // Inserir Telefone
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

            // Inserir Cliente
            try (PreparedStatement pstmtCliente = conn.prepareStatement(sqlCliente)) {
                pstmtCliente.setString(1, cliente.getNome()); // Nome do Cliente
                pstmtCliente.setInt(2, enderecoId);           // ID do Endereço
                pstmtCliente.setInt(3, emailId);              // ID do Email
                pstmtCliente.setInt(4, telefoneId);           // ID do Telefone
                pstmtCliente.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCliente(Cliente cliente) {
        String sqlGetCliente = "SELECT idEmail, idEndereco, idTelefone FROM Cliente WHERE idCliente = ?";
        String sqlUpdateEmail = "UPDATE Email SET email = ? WHERE idEmail = ?";
        String sqlUpdateEndereco = "UPDATE Endereco SET rua = ?, cep = ?, bairro = ?, cidade = ? WHERE idEndereco = ?";
        String sqlUpdateTelefone = "UPDATE Telefone SET telefone = ? WHERE idTelefone = ?";
        String sqlUpdateCliente = "UPDATE Cliente SET nome = ? WHERE idCliente = ?";

        try (Connection conn = Conn.getConexao()) {
            // Obtendo os IDs do cliente
            int idCliente = cliente.getIdCliente();
            int idEmail, idEndereco, idTelefone;

            try (PreparedStatement pstmtGet = conn.prepareStatement(sqlGetCliente)) {
                pstmtGet.setInt(1, idCliente);
                try (ResultSet rs = pstmtGet.executeQuery()) {
                    if (rs.next()) {
                        idEmail = rs.getInt("idEmail");
                        idEndereco = rs.getInt("idEndereco");
                        idTelefone = rs.getInt("idTelefone");
                    } else {
                        throw new SQLException("Cliente não encontrado.");
                    }
                }
            }

            // Atualizando Email
            if (cliente.getEmail() != null) {
                try (PreparedStatement pstmtEmail = conn.prepareStatement(sqlUpdateEmail)) {
                    pstmtEmail.setString(1, cliente.getEmail().getEmail());
                    pstmtEmail.setInt(2, idEmail); // ID do Email obtido
                    pstmtEmail.executeUpdate();
                }
            }

            // Atualizando Endereço
            if (cliente.getEndereco() != null) {
                try (PreparedStatement pstmtEndereco = conn.prepareStatement(sqlUpdateEndereco)) {
                    pstmtEndereco.setString(1, cliente.getEndereco().getRua());
                    pstmtEndereco.setInt(2, cliente.getEndereco().getCep());
                    pstmtEndereco.setString(3, cliente.getEndereco().getBairro());
                    pstmtEndereco.setString(4, cliente.getEndereco().getCidade());
                    pstmtEndereco.setInt(5, idEndereco); // ID do Endereço obtido
                    pstmtEndereco.executeUpdate();
                }
            }

            // Atualizando Telefone
            if (cliente.getTelefone() != null) {
                try (PreparedStatement pstmtTelefone = conn.prepareStatement(sqlUpdateTelefone)) {
                    pstmtTelefone.setString(1, cliente.getTelefone().getTelefone());
                    pstmtTelefone.setInt(2, idTelefone); // ID do Telefone obtido
                    pstmtTelefone.executeUpdate();
                }
            }

            // Atualizando Cliente
            try (PreparedStatement pstmtCliente = conn.prepareStatement(sqlUpdateCliente)) {
                pstmtCliente.setString(1, cliente.getNome());
                pstmtCliente.setInt(2, idCliente); // ID do Cliente
                pstmtCliente.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Função para deletar o Cliente e seus dados relacionados (email, endereço, telefone)
    //SQL -->
    public void deleteCliente(int idCliente) {
        String sqlGetCliente = "SELECT idEmail, idEndereco, idTelefone FROM Cliente WHERE idCliente = ?";
        String sqlDeleteCliente = "DELETE FROM Cliente WHERE idCliente = ?";
        String sqlDeleteEmail = "DELETE FROM Email WHERE idEmail = ?";
        String sqlDeleteEndereco = "DELETE FROM Endereco WHERE idEndereco = ?";
        String sqlDeleteTelefone = "DELETE FROM Telefone WHERE idTelefone = ?";
       //TESTE PARA CONN -->
        try (Connection conn = Conn.getConexao()) {
            int emailId = 0;
            int enderecoId = 0;
            int telefoneId = 0;

            // Obter os IDs relacionados (Email, Endereço, Telefone) antes de deletar o Cliente
            try (PreparedStatement pstmtGetCliente = conn.prepareStatement(sqlGetCliente)) {
                pstmtGetCliente.setInt(1, idCliente);
                try (ResultSet rs = pstmtGetCliente.executeQuery()) {
                    if (rs.next()) {
                        emailId = rs.getInt("idEmail");
                        enderecoId = rs.getInt("idEndereco");
                        telefoneId = rs.getInt("idTelefone");
                    }
                }
            }

            // Deletar o Cliente
            try (PreparedStatement pstmtCliente = conn.prepareStatement(sqlDeleteCliente)) {
                pstmtCliente.setInt(1, idCliente);
                pstmtCliente.executeUpdate();
            }

            // Deletar o Email
            try (PreparedStatement pstmtEmail = conn.prepareStatement(sqlDeleteEmail)) {
                pstmtEmail.setInt(1, emailId);
                pstmtEmail.executeUpdate();
            }

            // Deletar o Endereço
            try (PreparedStatement pstmtEndereco = conn.prepareStatement(sqlDeleteEndereco)) {
                pstmtEndereco.setInt(1, enderecoId);
                pstmtEndereco.executeUpdate();
            }

            // Deletar o Telefone
            try (PreparedStatement pstmtTelefone = conn.prepareStatement(sqlDeleteTelefone)) {
                pstmtTelefone.setInt(1, telefoneId);
                pstmtTelefone.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}