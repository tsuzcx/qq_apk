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
  
  private static void a(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        StringBuilder localStringBuilder = new StringBuilder("key=");
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append(" value=");
        localStringBuilder.append((String)localEntry.getValue());
        Log.v("MicroMsg.SDK.KVConfig", localStringBuilder.toString());
      }
      return;
    }
    Log.v("MicroMsg.SDK.KVConfig", "empty values");
  }
  
  private static void a(Map<String, String> paramMap, String paramString, Node paramNode, int paramInt)
  {
    if (paramNode.getNodeName().equals("#text")) {}
    while (paramNode.getNodeName().equals("#cdata-section"))
    {
      paramMap.put(paramString, paramNode.getNodeValue());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".");
    ((StringBuilder)localObject).append(paramNode.getNodeName());
    if (paramInt > 0) {
      paramString = Integer.valueOf(paramInt);
    } else {
      paramString = "";
    }
    ((StringBuilder)localObject).append(paramString);
    paramString = ((StringBuilder)localObject).toString();
    paramMap.put(paramString, paramNode.getNodeValue());
    localObject = paramNode.getAttributes();
    int i = 0;
    Node localNode;
    if (localObject != null)
    {
      paramInt = 0;
      while (paramInt < ((NamedNodeMap)localObject).getLength())
      {
        localNode = ((NamedNodeMap)localObject).item(paramInt);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(".$");
        localStringBuilder.append(localNode.getNodeName());
        paramMap.put(localStringBuilder.toString(), localNode.getNodeValue());
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
  
  public static Map<String, String> parseIni(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      HashMap localHashMap = new HashMap();
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
      if (E) {
        a(localHashMap);
      }
      return localHashMap;
    }
    return null;
  }
  
  public static Map<String, String> parseXml(String paramString1, String paramString2, String paramString3)
  {
    int i;
    if (paramString1 == null) {
      i = -1;
    } else {
      i = paramString1.indexOf('<');
    }
    if (i < 0) {
      paramString1 = "text not in xml format";
    }
    for (;;)
    {
      Log.e("MicroMsg.SDK.KVConfig", paramString1);
      return null;
      Object localObject = paramString1;
      if (i > 0)
      {
        Log.w("MicroMsg.SDK.KVConfig", "fix xml header from + %d", new Object[] { Integer.valueOf(i) });
        localObject = paramString1.substring(i);
      }
      if (localObject != null)
      {
        if (((String)localObject).length() <= 0) {
          return null;
        }
        HashMap localHashMap = new HashMap();
        paramString1 = DocumentBuilderFactory.newInstance();
        try
        {
          paramString1 = paramString1.newDocumentBuilder();
          if (paramString1 == null)
          {
            paramString1 = "new Document Builder failed";
          }
          else
          {
            try
            {
              localObject = new InputSource(new ByteArrayInputStream(((String)localObject).getBytes()));
              if (paramString3 != null) {
                ((InputSource)localObject).setEncoding(paramString3);
              }
              paramString1 = paramString1.parse((InputSource)localObject);
              try
              {
                paramString1.normalize();
              }
              catch (DOMException paramString3) {}
              paramString3.printStackTrace();
            }
            catch (Exception paramString1)
            {
              paramString1.printStackTrace();
              return null;
            }
            catch (IOException paramString1)
            {
              paramString1.printStackTrace();
              return null;
            }
            catch (SAXException paramString1)
            {
              paramString1.printStackTrace();
              return null;
            }
            catch (DOMException paramString3)
            {
              paramString1 = null;
            }
            if (paramString1 == null)
            {
              paramString1 = "new Document failed";
            }
            else
            {
              paramString1 = paramString1.getDocumentElement();
              if (paramString1 == null)
              {
                paramString1 = "getDocumentElement failed";
              }
              else
              {
                if ((paramString2 != null) && (paramString2.equals(paramString1.getNodeName()))) {}
                for (;;)
                {
                  a(localHashMap, "", paramString1, 0);
                  break label296;
                  paramString1 = paramString1.getElementsByTagName(paramString2);
                  if (paramString1.getLength() <= 0)
                  {
                    paramString1 = "parse item null";
                    break;
                  }
                  if (paramString1.getLength() > 1) {
                    Log.w("MicroMsg.SDK.KVConfig", "parse items more than one");
                  }
                  paramString1 = paramString1.item(0);
                }
                label296:
                if (E) {
                  a(localHashMap);
                }
                return localHashMap;
              }
            }
          }
        }
        catch (ParserConfigurationException paramString1)
        {
          paramString1.printStackTrace();
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.KVConfig
 * JD-Core Version:    0.7.0.1
 */