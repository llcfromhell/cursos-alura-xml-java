package net.lorenscode.Teste;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by Lorens on 28/04/2016.
 */
public class ConversorParaHtml {

    public static void main(String[] args) throws Exception {

        InputStream xsl = new FileInputStream("src/xmlToHtml.xsl");
        InputStream xml = new FileInputStream("src/vendas.xml");

        Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(xsl));

        StreamResult outputTarget = new StreamResult("src/vendas.html");
        transformer.transform(new StreamSource(xml), outputTarget);

    }
}
