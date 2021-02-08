package support;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class XMLHelper {
    private static String CONFIG_XML_FILE = "src/test/resources/properties/config.xml";

    private static void loadProperties()  {
        File xmlFile = new File(CONFIG_XML_FILE);
        if(ConfigHelper.configProperties==null)
            ConfigHelper.configProperties = new HashMap<>();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            NodeList nodeList = doc.getElementsByTagName("config");
            Node configNode = nodeList.item(0);
            NodeList configValueNodes = configNode.getChildNodes();

            for (int index = 0; index < configValueNodes.getLength(); index++) {
                Node node = configValueNodes.item(index);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String propertyName = element.getNodeName();
                    String propertyValue = element.getTextContent();
                    if (System.getProperty(propertyName) == null) {
                        ConfigHelper.configProperties.put(propertyName, propertyValue);
                        System.setProperty(propertyName, propertyValue);
                    } else {
                        ConfigHelper.configProperties.put(propertyName, System.getProperty(propertyName));
                    }
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException  e) {
            e.printStackTrace();
        }
    }

    public static void initialize() throws IOException, SAXException, ParserConfigurationException {
        loadProperties();
    }

}
