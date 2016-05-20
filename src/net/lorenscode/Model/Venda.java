package net.lorenscode.Model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lorens on 29/04/2016.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Venda {

    private String formaPagamento;
    @XmlElementWrapper(name = "produtos")
    @XmlElement(name = "produto")
    private List<Produto> produtos = new ArrayList<Produto>();

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "formaPagamento='" + formaPagamento + '\'' +
                ", produtos=" + produtos +
                '}';
    }
}
