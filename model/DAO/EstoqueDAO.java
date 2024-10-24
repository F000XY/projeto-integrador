package projetointegradorConn.model.DAO;

import projetointegradorConn.model.cadastro.Cliente;
import projetointegradorConn.model.conn.Conn;
import projetointegradorConn.model.estoque.Estoque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstoqueDAO {
    public void inserirEstoque(Estoque estoque) {
        String sqlEstoque = "INSERT INTO Estoque (nome, custo, revenda, lucro) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conn.getConexao()) {
            try (PreparedStatement pstmtEstoque = conn.prepareStatement(sqlEstoque)) {
                pstmtEstoque.setString(1, estoque.getNome());
                pstmtEstoque.setDouble(2, estoque.getCusto());
                pstmtEstoque.setDouble(3, estoque.getRevenda());
                pstmtEstoque.setDouble(4, estoque.getLucro());
                pstmtEstoque.executeUpdate();
                System.out.println("Item inserido com sucesso: " + estoque.getNome());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar item por ID
    public Estoque buscarPorId(int idItem) {
        Estoque estoque = null;
        String sql = "SELECT * FROM Estoque WHERE idItem = ?";

        try (Connection conn = Conn.getConexao();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idItem);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                estoque = new Estoque();
                estoque.setNome(rs.getString("nome"));
                estoque.setCusto(rs.getInt("custo"));
                estoque.setRevenda(rs.getInt("revenda"));
                estoque.setLucro(rs.getInt("lucro"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estoque;
    }
    public void atualizarEstoque(Estoque estoque) {
        String sqlUpdate = "UPDATE Estoque SET nome = ?, custo = ?, revenda = ?, lucro = ? WHERE idItem = ?";

        try (Connection conn = Conn.getConexao();
             PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {
            pstmt.setString(1, estoque.getNome());
            pstmt.setDouble(2, estoque.getCusto());
            pstmt.setDouble(3, estoque.getRevenda());
            pstmt.setDouble(4, estoque.getLucro());
            pstmt.setInt(5, estoque.getIdItem()); // Supondo que você tenha um método getIdItem() na classe Estoque
            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Item atualizado com sucesso: " + estoque.getNome());
            } else {
                System.out.println("Nenhum item encontrado para atualizar com o ID: " + estoque.getIdItem());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deletarItem(int idEstoque) {
        String sqlGetEstoque = "SELECT * FROM Estoque WHERE idItem = ?";
        String sqlDeleteEstoque = "DELETE FROM Estoque WHERE idItem = ?";

        //TESTE PARA CONN -->
        try (Connection conn = Conn.getConexao()) {
            int itemId = 0;

            // Obter serviço
            try (PreparedStatement pstmtGetCliente = conn.prepareStatement(sqlGetEstoque)) {
                pstmtGetCliente.setInt(1, idEstoque);
                try (ResultSet rs = pstmtGetCliente.executeQuery()) {
                    if (rs.next()) {
                        itemId = rs.getInt("idItem");

                    }
                }
            }

            // Deletar o serviço
            try (PreparedStatement pstmtEstoque = conn.prepareStatement(sqlDeleteEstoque)) {
                pstmtEstoque.setInt(1, idEstoque);
                pstmtEstoque.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
