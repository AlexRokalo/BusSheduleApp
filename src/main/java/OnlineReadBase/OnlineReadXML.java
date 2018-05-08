package OnlineReadBase;

import BusesShedule.BusSchedule;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class OnlineReadXML implements OnlineRead {
    private STAXBuilder staxBuilder = new STAXBuilder();

    public BusSchedule makeSchedule() {
        try {
            URL url = new URL("http://kiparo.ru/t/bus_schedule.xml");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = factory.createXMLEventReader(new BufferedReader
                    (new InputStreamReader(connection.getInputStream())));

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        staxBuilder.startELem(qName);
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        staxBuilder.body(event.asCharacters());
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        staxBuilder.endElement(event.asEndElement());
                        break;
                }

            }

            return new BusSchedule.BusScheduleBuilder().setSchedule(staxBuilder.getBuses()).crate();
        } catch (MalformedURLException e) {
            System.out.println("Ошибка в чтениие XML Файла! :" + e.getMessage());
        } catch (XMLStreamException e) {
            System.out.println("Ошибка в чтениие XML Файла! :" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка в записи :" + e.getMessage());
        }
        return null;
    }
}