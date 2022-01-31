package com.tencent.mobileqq.data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class KeywordAndRemarkInfo
{
  public int aio_display_limit = 0;
  public int aio_request_limit = 0;
  public int frequency_message = 0;
  public int frequency_time = 0;
  public ArrayList keyword_list = new ArrayList();
  public int message_request_limit = 0;
  public int task = 0;
  
  public KeywordAndRemarkInfo(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new File(paramString);
        if (!paramString.exists()) {
          continue;
        }
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(paramString);
        NodeList localNodeList = paramString.getElementsByTagName("tipsbanner");
        int i = 0;
        if (i >= localNodeList.getLength()) {
          continue;
        }
        this.task = Integer.parseInt(paramString.getElementsByTagName("task").item(i).getFirstChild().getNodeValue());
        this.aio_request_limit = Integer.parseInt(paramString.getElementsByTagName("aio_request_limit").item(i).getFirstChild().getNodeValue());
        this.message_request_limit = Integer.parseInt(paramString.getElementsByTagName("message_request_limit").item(i).getFirstChild().getNodeValue());
        Object localObject = paramString.getElementsByTagName("keyword_list").item(i).getFirstChild().getNodeValue();
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          if (((String)localObject).contains("|")) {
            break label391;
          }
          this.keyword_list.add(localObject);
        }
        for (;;)
        {
          this.frequency_time = Integer.parseInt(((Element)paramString.getElementsByTagName("frequency").item(i)).getElementsByTagName("time").item(0).getFirstChild().getNodeValue());
          this.frequency_message = Integer.parseInt(((Element)paramString.getElementsByTagName("frequency").item(i)).getElementsByTagName("message").item(0).getFirstChild().getNodeValue());
          this.aio_display_limit = Integer.parseInt(paramString.getElementsByTagName("aio_display_limit").item(i).getFirstChild().getNodeValue());
          i += 1;
          break;
          label391:
          localObject = ((String)localObject).split("\\|");
          int j = 0;
          while (j < localObject.length)
          {
            this.keyword_list.add(localObject[j]);
            j += 1;
          }
        }
        return;
      }
      catch (ParserConfigurationException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      catch (SAXException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.KeywordAndRemarkInfo
 * JD-Core Version:    0.7.0.1
 */