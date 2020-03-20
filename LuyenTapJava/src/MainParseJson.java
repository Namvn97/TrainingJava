import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class MainParseJson {
    public static void main(String[] args) throws TransformerException {
        String str = "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "<SOAP-ENV:Header/>\n" +
                "<SOAP-ENV:Body>\n" +
                "<ns2:searchResponse xmlns:ns2=\"http://shb.com.vn/ecm\"><ns2:returnValue>\n" +
                "<ns2:code>200</ns2:code>\n" +
                "<ns2:message>Success!</ns2:message>\n" +
                "<ns2:value>\n" +
                "[{\"SHB_POS\":\"POS110201\",\"SHB_Sgiaodch\":\"123\",\"SHB_CaseTypeID\":\"{C950C42C-0652-4950-A413-4BCA34E0DE74}\",\"SHB_POSSend\":\"PGD CẦU GIẤY\",\n" +
                "\"SHB_AmountExchange\":\"4343\",\"type\":\"Folder\",\n" +
                "\"SHB_CIF\":\"0100009257\",\"SHB_ExchangeType\":\"TM10001\"}]\n" +
                "</ns2:value>\n" +
                "</ns2:returnValue></ns2:searchResponse>\n" +
                "</SOAP-ENV:Body>\n" +
                "</SOAP-ENV:Envelope>";

//        String str2 = "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
//                "<SOAP-ENV:Header/>\n" +
//                "<SOAP-ENV:Body>\n" +
//                "<ns2:searchResponse xmlns:ns2=\"http://shb.com.vn/ecm\">\n" +
//                "<ns2:returnValue>\n" +
//                "<ns2:code>200</ns2:code>\n" +
//                "<ns2:message>Success!</ns2:message>\n" +
//                "<ns2:value>[{\"STT\":\"1\",\"CIFNo\":\"0100009257\",\"FileType\":\"Chuyển tiền quốc tế\",\"AccountNo\":\"\"," +
//                "\"RefNo\":\"1\",\"FileName\":\"0100009257_CTQT_0000000089_TKTT_20200205.000001.02.pdf\"," +
//                "\"DocumentId\":\"{10EAF070-0000-C51F-9313-8B6B2629D121}\",\"DateCreated\":\"19-03-2020\",\"type\":\"InternationalMoneyTransferDoc\"}," +
//                ",{\"STT\":\"2\",\"CIFNo\":\"0100009257\",\"FileType\":\"Chuyển tiền quốc tế\",\"AccountNo\":\"\"," +
//                "\"RefNo\":\"1\",\"FileName\":\"0100009257_CTQT_BRD_ECM_SHB_Phan loai va luu tru ho so_v.0.3.docx\"," +
//                "\"DocumentId\":\"{10EAF070-0100-C11D-AAB3-00BB052E6BD8}\",\"DateCreated\":\"19-03-2020\",\"type\":\"InternationalMoneyTransferDoc\"}]" +
//                "</ns2:value>\n" +
//                "</ns2:returnValue>\n" +
//                "</ns2:searchResponse>\n" +
//                "</SOAP-ENV:Body>\n" +
//                "</SOAP-ENV:Envelope>";
//
//        Document doc = stringToXml(str2);
//        System.out.println(doc.toString());
//
        stringToXml(str);
    }

    public static void stringToXml(String str){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        try
        {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse( new InputSource( new StringReader(str) ) );
            NodeList nodeList = doc.getElementsByTagName("ns2:value");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    JSONParser parser = new JSONParser();
                    String content = nNode.getTextContent();
                    JSONArray json = (JSONArray) parser.parse(content);
                    System.out.println("=========="+json);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String nodeToString(Node node) throws TransformerConfigurationException, TransformerException {
        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer transformer = transFactory.newTransformer();
        StringWriter buffer = new StringWriter();
        transformer.transform(new DOMSource(node), new StreamResult(buffer));
        return buffer.toString();
    }

    private static Document toXmlDocument(String str) {

        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        docBuilderFactory.setNamespaceAware(true);

        DocumentBuilder docBuilder = null;
        try {
            docBuilder = docBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = null;
        try {
            StringReader reader = new StringReader(str);
            InputSource inputSource = new InputSource();
            inputSource.setCharacterStream(reader);
            document = docBuilder.parse(inputSource);

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    private static Document convertXMLFileToXMLDocument(String filePath)
    {
        //Parser that produces DOM object trees from XML content
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //API to obtain DOM Document instance
        DocumentBuilder builder = null;
        try
        {
            //Create DocumentBuilder with default configuration
            builder = factory.newDocumentBuilder();

            //Parse the content to Document object
            Document doc = builder.parse(new File(filePath));
            return doc;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
