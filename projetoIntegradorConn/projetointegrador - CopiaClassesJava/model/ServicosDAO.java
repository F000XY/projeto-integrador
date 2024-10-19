package projetointegradorConn.model;

import projetointegradorConn.controler.Conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServicosDAO {
    public void inserirServico(Servicos servicos) {
        String sql = "INSERT INTO Servicos (idCliente, idEstoque) VALUES (?, ?)";

        try (Connection conn = Conn.getConexao();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, servicos.getIdCliente());
            pstmt.setInt(2, servicos.getIdEstoque());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
