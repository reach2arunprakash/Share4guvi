package guvi;


import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
 
public class GUVIPlayList {
 
	public static final String strFilename = "src//artifacts//PList.xml";
	NodeList nodeList;
	
	public Boolean getPlaylist()
	{
		try {
		
			   File file = new File(strFilename);
			 
				DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
			                             .newDocumentBuilder();
			 
				Document doc = dBuilder.parse(file);
			 
				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			 
				if (doc.hasChildNodes()) {
			 
					nodeList = doc.getChildNodes();
					printNote();
			 
				}
			 
			    } catch (Exception e) {
				System.out.println(e.getMessage());
			    }
			 

		return true;
	}
  public static void main(String[] args) {
	  GUVIPlayList gpl = new GUVIPlayList();
	  gpl.getPlaylist();
      }
 
  private void printNote() {
 
    for (int count = 0; count < nodeList.getLength(); count++) {
 
	Node tempNode = nodeList.item(count);
 
	// make sure it's element node.
	if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
 
		// get node name and value
		System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
		System.out.println("Node Value =" + tempNode.getTextContent());
 
		if (tempNode.hasAttributes()) {
 
			// get attributes names and values
			NamedNodeMap nodeMap = tempNode.getAttributes();
 
			for (int i = 0; i < nodeMap.getLength(); i++) {
 
				Node node = nodeMap.item(i);
				System.out.println("attr name : " + node.getNodeName());
				System.out.println("attr value : " + node.getNodeValue());
 
			}
 
		}
 
		if (tempNode.hasChildNodes()) {
 
			// loop again if has child nodes
			printNote();
 
		}
 
		System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");
 
	}
 
    }
 
  }
 
}