package projetointegradorConn.model;

import projetointegradorConn.controler.Conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstoqueDAO {
    public void inserirEstoque(Estoque estoque) {
        String sqlEstoque = "INSERT INTO Estoque (idItem, nome, custo, revenda, lucro) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conn.getConexao()) {
            try (PreparedStatement pstmtEstoque = conn.prepareStatement(sqlEstoque)) {
                pstmtEstoque.setInt(1, estoque.getIdItem());
                pstmtEstoque.setString(2, estoque.getNome());
                pstmtEstoque.setInt(3, estoque.getCusto());
                pstmtEstoque.setInt(4, estoque.getRevenda());
                pstmtEstoque.setInt(5, estoque.getLucro());
                pstmtEstoque.executeUpdate();
                System.out.println("Item inserido com sucesso: " + estoque.getNome()); // Mensagem de sucesso
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
                estoque.setIdItem(rs.getInt("idItem"));
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
}
