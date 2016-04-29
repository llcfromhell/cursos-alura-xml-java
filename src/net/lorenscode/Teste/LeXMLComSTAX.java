package net.lorenscode.Teste;

import net.lorenscode.Model.Produto;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lorens on 28/04/2016.
 */
public class LeXMLComSTAX {

    public static void main(String[] args) throws Exception {

        InputStream is = new FileInputStream("src/vendas.xml");
        XMLEventReader eventos = XMLInputFactory.newInstance().createXMLEventReader(is);


        List<Produto> list = new ArrayList<Produto>();
        Produto p =  new Produto();

        while (eventos.hasNext()) {

            XMLEvent evento = eventos.nextEvent();

            if (evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("produto")) {

                p = makeProduto(eventos);
                list.add(p);

            }

        }

        System.out.println(list);

    }

    public static Produto makeProduto(XMLEventReader eventos) throws Exception {

        Produto p = new Produto();

        while (eventos.hasNext()) {

            XMLEvent evento = eventos.nextEvent();

            if (evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("nome")) {

                evento = eventos.nextEvent();
                p.setNome(evento.asCharacters().getData());

            } else if (evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("preco")) {

                evento = eventos.nextEvent();
                p.setPreco(Double.parseDouble(evento.asCharacters().getData()));
            } else if (evento.isEndElement() && evento.asEndElement().getName().getLocalPart().equals("produto")) {
                break;
            }

        }

        return  p;

    }
}
