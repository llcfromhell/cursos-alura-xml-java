package net.lorenscode.Model;

/**
 * Created by lourenco.cunha on 12/04/2016.
 */
public class Produto {
    private String nome;
    private Double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Produto(){}
}
