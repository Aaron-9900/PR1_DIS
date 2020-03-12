package xml_feed;

import java.io.IOException;
// DOM
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
// SAX
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.InputSource;

public class XMLUtils {

  private XMLUtils() {}
   
  // validate using DOM (DTD as defined in the XML)
  public static boolean validateWithDTDUsingDOM(String xml) 
    throws ParserConfigurationException, IOException
  {
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setValidating(true);
      factory.setNamespaceAware(true);

      DocumentBuilder builder = factory.newDocumentBuilder();

      builder.setErrorHandler(
          new ErrorHandler() {
            public void warning(SAXParseException e) throws SAXException {
              System.out.println("WARNING : " + e.getMessage()); // do nothing
            }

            public void error(SAXParseException e) throws SAXException {
              System.out.println("ERROR : " + e.getMessage());
              throw e;
            }

            public void fatalError(SAXParseException e) throws SAXException {
              System.out.println("FATAL : " + e.getMessage());
              throw e;
            }
          }
          );
      builder.parse(new InputSource(xml));
      return true;
    }
    catch (ParserConfigurationException pce) {
      throw pce;
    } 
    catch (IOException io) {
      throw io;
    }
    catch (SAXException se){
      return false;
    }
  }
  
  
  // validate using SAX (DTD as defined in the XML)
  public static boolean validateWithDTDUsingSAX(String xml) 
    throws ParserConfigurationException, IOException
  {
    try {
      
      SAXParserFactory factory = SAXParserFactory.newInstance();
      factory.setValidating(true);
      factory.setNamespaceAware(true);

      SAXParser parser = factory.newSAXParser();

      XMLReader reader = parser.getXMLReader();
      reader.setErrorHandler(
          new ErrorHandler() {
            public void warning(SAXParseException e) throws SAXException {
              System.out.println("WARNING : " + e.getMessage()); // do nothing
            }

            public void error(SAXParseException e) throws SAXException {
              System.out.println("ERROR : " + e.getMessage());
              throw e;
            }

            public void fatalError(SAXParseException e) throws SAXException {
              System.out.println("FATAL : " + e.getMessage());
              throw e;
            }
          }
          );
      reader.parse(new InputSource( xml ));
      return true;
    }
    catch (ParserConfigurationException pce) {
      throw pce;
    } 
    catch (IOException io) {
      throw io;
    }
    catch (SAXException se){
      return false;
    }
  }
  
  public static void main (String args[]) throws Exception{ 
    
    System.out.println(XMLUtils.validateWithDTDUsingDOM("xmlFile.xml"));
    System.out.println(XMLUtils.validateWithDTDUsingSAX("xmlFile.xml"));
    /*
      output :
               true
               true
    */           
  }
}
