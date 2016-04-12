package net.lorenscode.Teste;

import com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by lourenco.cunha on 12/04/2016.
 */
public class Sistema {

    public static void main(String[] args) {

        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xml = builder.parse("src/vendas.xml");

            Element venda = xml.getDocumentElement();

            System.out.println(venda.getAttribute("moeda").toString());

            NodeList produtos = xml.getElementsByTagName("produto");

            for (int i = 0; i < produtos.getLength(); i++) {

                String nome = ((Element)produtos.item(i)).getElementsByTagName("nome").item(0).getTextContent();
                String preco = ((Element)produtos.item(i)).getElementsByTagName("preco").item(0).getTextContent();

                System.out.println("Nome: " + nome);
                System.out.println("Preço: " + preco);
                System.out.println("--------");

            }



        } catch (Exception e) {
            e.printStackTrace();
        }


        //DocumentBuilder

    }
}
