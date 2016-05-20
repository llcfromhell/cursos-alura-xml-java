package net.lorenscode.Teste;

import net.lorenscode.Model.Produto;
import net.lorenscode.Model.Venda;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lorens on 29/04/2016.
 */
public class MapeiaXML {

    public static void main (String[] args) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Venda.class);

        xmlParaObjeto(jaxbContext);
        objetoParaXml(jaxbContext);
    }

    private static void objetoParaXml(JAXBContext jaxbContext) throws JAXBException {

        Marshaller marshaller = jaxbContext.createMarshaller();
        Venda venda = new Venda();
        venda.setFormaPagamento("Crediário");
        List<Produto> produtos = new ArrayList<Produto>();
        produtos.add(new Produto("livro 02", 20.00));
        venda.setProdutos(produtos);
        StringWriter writer = new StringWriter();
        marshaller.marshal(venda, writer);

        System.out.println(writer);

    }

    private static void xmlParaObjeto(JAXBContext jaxbContext) throws JAXBException {

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Venda venda = (Venda) unmarshaller.unmarshal(new File("src/vendas.xml"));
        System.out.println(venda);
    }
}
