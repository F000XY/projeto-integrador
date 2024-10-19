package projetointegradorConn.model;

import projetointegradorConn.controler.Conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
