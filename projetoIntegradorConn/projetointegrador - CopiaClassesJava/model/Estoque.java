package projetointegradorConn.model;
public class Estoque {
    private int idItem;
    private String nome;
    private int custo;
    private int revenda;
    private int lucro;

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

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public int getRevenda() {
        return revenda;
    }

    public void setRevenda(int revenda) {
        this.revenda = revenda;
    }

    public int getLucro() {
        return lucro;
    }

    public void setLucro(int lucro) {
        this.lucro = lucro;
    }
}
