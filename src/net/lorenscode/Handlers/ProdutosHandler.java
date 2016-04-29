package net.lorenscode.Handlers;

import net.lorenscode.Model.Produto;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by lourenco.cunha on 28/04/2016.
 */
public class ProdutosHandler extends DefaultHandler {

    private List<Produto> list = new ArrayList<Produto>();
    private Produto p;
    private StringBuilder sb = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equals("produto")) {
            p = new Produto();
        }

        sb = new StringBuilder();

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        sb.append(new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("produto")) {
            list.add(p);
        } else if (qName.equals("nome")) {
            p.setNome(sb.toString());
        } else if (qName.equals("preço")) {
            p.setPreco(Double.parseDouble(sb.toString()));
        }
    }

    public List<Produto> getList() {
        return list;
    }
}
