package projetointegradorConn.model.DAO;

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
                pstmtEstoque.setString(1, estoque.getNome()); // Corrigido para 1
                pstmtEstoque.setDouble(2, estoque.getCusto()); // Corrigido para 2
                pstmtEstoque.setDouble(3, estoque.getRevenda()); // Corrigido para 3
                pstmtEstoque.setDouble(4, estoque.getLucro()); // Corrigido para 4
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
}
