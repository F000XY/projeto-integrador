package projetointegradorConn.model.cadastro;

public class Telefone {
    private int idTelefone;
    private String telefone; // Alterei para armazenar o telefone como String

    public int getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(int idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
