package net.lorenscode.Teste;

import net.lorenscode.Handlers.ProdutosHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lourenco.cunha on 26/04/2016.
 */
public class LeXMLComSax {

    public static void main(String[] args) {

        try {
            XMLReader leitor = XMLReaderFactory.createXMLReader();
            ProdutosHandler produtosHandler = new ProdutosHandler();
            leitor.setContentHandler(produtosHandler);
            InputStream stream = new FileInputStream("src/vendas.xml");
            InputSource is = new InputSource(stream);
            leitor.parse(is);

            System.out.println(produtosHandler.getList());

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
