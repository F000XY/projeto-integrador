package projetointegradorConn.model.DAO;

import projetointegradorConn.model.conn.Conn;
import projetointegradorConn.model.servicos.Servicos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class

ServicosDAO {
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
    public void deletarServico(int idOs) {
        String sqlGetOs = "SELECT * FROM Servicos WHERE idOs = ?";
        String sqlDeleteOs = "DELETE FROM Servicos WHERE idOs = ?";

        //TESTE PARA CONN -->
        try (Connection conn = Conn.getConexao()) {
            int itemOs = 0;

            try (PreparedStatement pstmtGetCliente = conn.prepareStatement(sqlGetOs)) {
                pstmtGetCliente.setInt(1, idOs);
                try (ResultSet rs = pstmtGetCliente.executeQuery()) {
                    if (rs.next()) {
                        itemOs = rs.getInt("idOs");

                    }
                }
            }
            // Deletar OS
            try (PreparedStatement pstmtEstoque = conn.prepareStatement(sqlDeleteOs)) {
                pstmtEstoque.setInt(1, idOs);
                pstmtEstoque.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
