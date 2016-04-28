package net.lorenscode.Teste;

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
public class LerArquivoDeOutraForma {

    public static void main(String[] args) {

        try {
            XMLReader leitor = XMLReaderFactory.createXMLReader();
            leitor.setContentHandler(new LeitorXML());
            InputStream stream = new FileInputStream("src/vendas.xml");
            InputSource is = new InputSource(stream);
            leitor.parse(is);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
