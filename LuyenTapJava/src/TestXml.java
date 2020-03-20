import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;

public class TestXml {
    public static void main(String[] args) {
        String outputString = "<?xml version='1.0' encoding='utf-8'?>" +
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                "<soapenv:Body>" +
                "<ns:listUsersResponse xmlns:ns=\"http://org.apache.axis2/xsd\" xmlns:ax2754=\"http://common.mgt.user.carbon.wso2.org/xsd\">" +
                "<ns:return>admin</ns:return>" +
                "<ns:return>admin@wso2.com</ns:return>" +
                "<ns:return>is530@wso2.com</ns:return><ns:return>kavitha@gmail.com</ns:return><ns:return>normal1@gmail.com</ns:return>" +
                "<ns:return>normal2@gmail.com</ns:return><ns:return>normal3@gmail.com</ns:return>" +
                "<ns:return>sales1@gmail.com</ns:return><ns:return>sales2@gmail.com</ns:return>" +
                "<ns:return>sales3@gmail.com</ns:return><ns:return>sales4@gmail.com</ns:return>" +
                "</ns:listUsersResponse>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>\n";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;

        try
        {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse( new InputSource( new StringReader(outputString) ) );

            System.out.println(" doc >>>");
            System.out.println(doc);
//            NodeList nodeList = doc.getElementsByTagName("ns:listUsersResponse xmlns:ns=\"http://org.apache.axis2/xsd\" xmlns:ax2754=\"http://common.mgt.user.carbon.wso2.org/xsd");
            NodeList nodeList = doc.getElementsByTagNameNS("http://org.apache.axis2/xsd",
                    "listUsersResponse");

            System.out.println(" nodeList >>>");
            System.out.println(nodeList);

            if (nodeList.getLength() > 0) {
                Element element = (Element)nodeList.item(0);
                System.out.println(element.getElementsByTagName("ns:return")
                        .item(0).getTextContent());
            }
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    JSONParser parser = new JSONParser();
                    JSONArray json = (JSONArray) parser.parse(nNode.getTextContent());
                    System.out.println(json);
                }
            }

            System.out.println(nodeToString(doc));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static String nodeToString(Node node) throws TransformerException {
        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer transformer = transFactory.newTransformer();
        StringWriter buffer = new StringWriter();
        transformer.transform(new DOMSource(node), new StreamResult(buffer));
        return buffer.toString();
    }
}
