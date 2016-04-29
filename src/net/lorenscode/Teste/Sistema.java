package net.lorenscode.Teste;

import com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;


/**
 * Created by lourenco.cunha on 12/04/2016.
 */
public class Sistema {

    public static void main(String[] args) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            factory.setValidating(true);
            factory.setNamespaceAware(true);
            factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document xml = builder.parse("src/vendas.xml");

            Element venda = xml.getDocumentElement();

            //System.out.println(venda.getAttribute("moeda").toString());

            String exp = "/venda/produtos/produto[contains(nome,'02')] ";
            XPath path = XPathFactory.newInstance().newXPath();
            XPathExpression xExp = path.compile(exp);

            NodeList produtos = (NodeList) xExp.evaluate(xml, XPathConstants.NODESET);

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
