package projetointegradorConn.model;
public class Estoque {
    private int idItem;
    private String nome;
    private double custo;
    private double revenda;
    private double lucro;

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public double getRevenda() {
        return revenda;
    }

    public void setRevenda(double revenda) {
        this.revenda = revenda;
    }

    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }
}
