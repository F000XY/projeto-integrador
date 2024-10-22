package projetointegradorConn.model.DAO;

import projetointegradorConn.model.conn.Conn;
import projetointegradorConn.model.venda.Venda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendaDAO {
    public void inserirVenda(Venda venda) {
        String sql = "INSERT INTO Venda (idEstoque, quantidade) VALUES (?, ?)";

        try (Connection conn = Conn.getConexao();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, venda.getIdEstoque());
            pstmt.setInt(2, venda.getQuantidade());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarVenda(int idVenda) {
        String sqlGetVenda = "SELECT * FROM Venda WHERE idVenda = ?";
        String sqlDeleteVenda = "DELETE FROM Venda WHERE idVenda = ?";
        //TESTE PARA CONN -->
        try (Connection conn = Conn.getConexao()) {
            int vendaId = 0;
            // Obter serviço
            try (PreparedStatement pstmtGetVenda = conn.prepareStatement(sqlGetVenda)) {
                pstmtGetVenda.setInt(1, idVenda);
                try (ResultSet rs = pstmtGetVenda.executeQuery()) {
                    if (rs.next()) {
                        vendaId = rs.getInt("idVenda");

                    }
                }
            }
            // Deletar o serviço
            try (PreparedStatement pstmtEstoque = conn.prepareStatement(sqlDeleteVenda)) {
                pstmtEstoque.setInt(1, idVenda);
                pstmtEstoque.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
