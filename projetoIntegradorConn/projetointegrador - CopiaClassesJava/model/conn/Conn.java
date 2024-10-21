package projetointegradorConn.model.conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conn {

    public static Connection getConexao() {
        try {
            String endereco = "jdbc:mysql://localhost:3306/ztech";
            String usuario = "root";
            String senha = "teste2024";
//ztech.cfo46s026fom.us-east-2.rds.amazonaws.com
// jdbc:mysql://localhost:3306/ztech
            // Carregar o driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Estabelecer a conexão
            Connection conectar = DriverManager.getConnection(endereco, usuario, senha);

            // Retorna a conexão estabelecida
            return conectar;
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado: " + e);
        } catch (SQLException e) {
            System.out.println("Erro ao tentar conectar-se: " + e);
        }

        return null;
    }

    public static void main(String[] args) {
        Connection conn = getConexao(); // Chama o método para obter a conexão

        if (conn != null) {
            System.out.println("Conexão estabelecida com sucesso!");

            // Fechar a conexão após o uso
            try {
                conn.close();
                System.out.println("Conexão fechada com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao tentar fechar a conexão: " + e);
            }
        } else {
            System.out.println("Erro ao estabelecer a conexão.");
        }
    }
}