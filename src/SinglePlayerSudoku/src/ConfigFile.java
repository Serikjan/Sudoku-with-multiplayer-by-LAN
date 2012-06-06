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
	public boolean help;
	private int usePause;
	private int min;
	private int sec;
	private static ConfigFile the_instance = null;
	
	//ConfigFile method is read data from config.xml
	private ConfigFile()
	{
		try 
		{
			File configFile = new File("config.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(configFile);
			
			NodeList nList = doc.getElementsByTagName("options");
			for (int temp = 0; temp < nList.getLength(); temp++)
			{
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE)
				{
					Element eElement = (Element) nNode;
					int i = Integer.parseInt(getTagValue("difficult", eElement));
					setDifficult(i);
					boolean b = Boolean.parseBoolean(getTagValue("nodeChecker", eElement));
					setUseNode(b);
					b = Boolean.parseBoolean(getTagValue("showPoint", eElement));
					setShowPoint(b);
					help = Boolean.parseBoolean(getTagValue("useSolver", eElement));
					setUseSolve(help);
					i = Integer.parseInt(getTagValue("usePause", eElement));
					setUsePause(i);
					i = Integer.parseInt(getTagValue("minute", eElement));
					setMin(i);
					i = Integer.parseInt(getTagValue("second", eElement));
					setSec(i);
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
		//writeDataToFile("config.xml");
	}
	
	private static String getTagValue(String sTag, Element eElement)
	{
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        return nValue.getNodeValue();
	}
	
	public void setDifficult(int diff)
	{
		this.difficult = diff;
	}
	
	public int getDifficult()
	{
		return this.difficult;
	}
	
	public void setUseNode(boolean uNode)
	{
		this.useNode = uNode;
	}
	
	public boolean getUseNode()
	{
		return this.useNode;
	}
	
	public void setShowPoint(boolean sPoint)
	{
		this.showPoint = sPoint;
	}
	
	public boolean getShowPoint()
	{
		return this.showPoint;
	}
	
	public void setUseSolve(boolean uSolve)
	{
		this.help = uSolve;
	}
	
	public boolean getUseSolve()
	{
		return this.help;
	}
	
	public void setUsePause(int uPause)
	{
		this.usePause = uPause;
	}
	
	public int getUsePause()
	{
		return this.usePause;
	}
	
	public void setMin(int m)
	{
		this.min = m;
	}
	
	public int getMin()
	{
		return this.min;
	}
	
	public void setSec(int s)
	{
		this.sec = s;
	}
	
	public int getSec()
	{
		return this.sec;
	}
}