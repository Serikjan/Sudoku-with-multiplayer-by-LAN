import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class ConfigFile
{
	private int difficult;
	private boolean useNode;
	private boolean showPoint;
	private int useSolve;
	private int usePause;
	private boolean timeDefault;
	private int min;
	private int sec;
	private static ConfigFile the_instance = null;
	
	private ConfigFile()
	{
		
		//readDataFromFile(“config.ini”);
		try 
		{
			File configFile = new File("config.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(configFile);
			
			System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("options");
			
			for (int temp = 0; temp < nList.getLength(); temp++)
			{
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE)
				{
					Element eElement = (Element) nNode; 
					//NodeList nlList = eElement.getElementsByTagName("useSolver").item(0).getChildNodes();
			        //Node nValue = (Node) nlList.item(0);
					System.out.println("Difficulty : " + getTagValue("difficult", eElement));
					System.out.println("Node checker : " + getTagValue("nodeChecker", eElement));
					System.out.println("Show point : " + getTagValue("showPoint", eElement));
					System.out.println("Use solver : " + getTagValue("useSolver", eElement));
					System.out.println("Use pause : " + getTagValue("usePause", eElement));
					System.out.println("Time : " + getTagValue("time", eElement));
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static ConfigFile getInstance()
	{
		if (the_instance == null)
			the_instance = new ConfigFile();
		return the_instance;
	}
	
	public void writeConfig()
	{
		//writeDataToFile(“config.ini”);
	}
	
	private static String getTagValue(String sTag, Element eElement)
	{
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        return nValue.getNodeValue();
	}
}