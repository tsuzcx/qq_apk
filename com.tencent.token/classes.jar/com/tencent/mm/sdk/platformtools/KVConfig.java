package com.tencent.mm.sdk.platformtools;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class KVConfig
{
  private static boolean E = false;
  
  private static void a(Map paramMap)
  {
    if ((paramMap == null) || (paramMap.size() <= 0)) {
      Log.v("MicroMsg.SDK.KVConfig", "empty values");
    }
    for (;;)
    {
      return;
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        Log.v("MicroMsg.SDK.KVConfig", "key=" + (String)localEntry.getKey() + " value=" + (String)localEntry.getValue());
      }
    }
  }
  
  private static void a(Map paramMap, String paramString, Node paramNode, int paramInt)
  {
    int i = 0;
    if (paramNode.getNodeName().equals("#text")) {
      paramMap.put(paramString, paramNode.getNodeValue());
    }
    for (;;)
    {
      return;
      if (paramNode.getNodeName().equals("#cdata-section"))
      {
        paramMap.put(paramString, paramNode.getNodeValue());
        return;
      }
      Object localObject = new StringBuilder().append(paramString).append(".").append(paramNode.getNodeName());
      if (paramInt > 0) {}
      Node localNode;
      for (paramString = Integer.valueOf(paramInt);; paramString = "")
      {
        paramString = paramString;
        paramMap.put(paramString, paramNode.getNodeValue());
        localObject = paramNode.getAttributes();
        if (localObject == null) {
          break;
        }
        paramInt = 0;
        while (paramInt < ((NamedNodeMap)localObject).getLength())
        {
          localNode = ((NamedNodeMap)localObject).item(paramInt);
          paramMap.put(paramString + ".$" + localNode.getNodeName(), localNode.getNodeValue());
          paramInt += 1;
        }
      }
      localObject = new HashMap();
      paramNode = paramNode.getChildNodes();
      paramInt = i;
      while (paramInt < paramNode.getLength())
      {
        localNode = paramNode.item(paramInt);
        i = Util.nullAsNil((Integer)((HashMap)localObject).get(localNode.getNodeName()));
        a(paramMap, paramString, localNode, i);
        ((HashMap)localObject).put(localNode.getNodeName(), Integer.valueOf(i + 1));
        paramInt += 1;
      }
    }
  }
  
  public static Map parseIni(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      paramString = null;
    }
    HashMap localHashMap;
    do
    {
      return paramString;
      localHashMap = new HashMap();
      paramString = paramString.split("\n");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject1 = paramString[i];
        if ((localObject1 != null) && (localObject1.length() > 0))
        {
          Object localObject2 = localObject1.trim().split("=", 2);
          if ((localObject2 != null) && (localObject2.length >= 2))
          {
            localObject1 = localObject2[0];
            localObject2 = localObject2[1];
            if ((localObject1 != null) && (localObject1.length() > 0) && (localObject1.matches("^[a-zA-Z0-9_]*"))) {
              localHashMap.put(localObject1, localObject2);
            }
          }
        }
        i += 1;
      }
      paramString = localHashMap;
    } while (!E);
    a(localHashMap);
    return localHashMap;
  }
  
  public static Map parseXml(String paramString1, String paramString2, String paramString3)
  {
    int i;
    if (paramString1 == null)
    {
      i = -1;
      if (i >= 0) {
        break label29;
      }
      Log.e("MicroMsg.SDK.KVConfig", "text not in xml format");
    }
    label29:
    Object localObject;
    do
    {
      return null;
      i = paramString1.indexOf('<');
      break;
      localObject = paramString1;
      if (i > 0)
      {
        Log.w("MicroMsg.SDK.KVConfig", "fix xml header from + %d", new Object[] { Integer.valueOf(i) });
        localObject = paramString1.substring(i);
      }
    } while ((localObject == null) || (((String)localObject).length() <= 0));
    HashMap localHashMap = new HashMap();
    paramString1 = DocumentBuilderFactory.newInstance();
    try
    {
      paramString1 = paramString1.newDocumentBuilder();
      if (paramString1 == null)
      {
        Log.e("MicroMsg.SDK.KVConfig", "new Document Builder failed");
        return null;
      }
    }
    catch (ParserConfigurationException paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    try
    {
      localObject = new InputSource(new ByteArrayInputStream(((String)localObject).getBytes()));
      if (paramString3 != null) {
        ((InputSource)localObject).setEncoding(paramString3);
      }
      paramString1 = paramString1.parse((InputSource)localObject);
      paramString1 = paramString1.getDocumentElement();
    }
    catch (DOMException paramString3)
    {
      for (;;)
      {
        try
        {
          paramString1.normalize();
          if (paramString1 != null) {
            continue;
          }
          Log.e("MicroMsg.SDK.KVConfig", "new Document failed");
          return null;
        }
        catch (DOMException paramString3)
        {
          continue;
        }
        paramString3 = paramString3;
        paramString1 = null;
        paramString3.printStackTrace();
      }
    }
    catch (SAXException paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    if (paramString1 == null)
    {
      Log.e("MicroMsg.SDK.KVConfig", "getDocumentElement failed");
      return null;
    }
    if ((paramString2 != null) && (paramString2.equals(paramString1.getNodeName()))) {
      a(localHashMap, "", paramString1, 0);
    }
    for (;;)
    {
      if (E) {
        a(localHashMap);
      }
      return localHashMap;
      paramString1 = paramString1.getElementsByTagName(paramString2);
      if (paramString1.getLength() <= 0)
      {
        Log.e("MicroMsg.SDK.KVConfig", "parse item null");
        return null;
      }
      if (paramString1.getLength() > 1) {
        Log.w("MicroMsg.SDK.KVConfig", "parse items more than one");
      }
      a(localHashMap, "", paramString1.item(0), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.KVConfig
 * JD-Core Version:    0.7.0.1
 */