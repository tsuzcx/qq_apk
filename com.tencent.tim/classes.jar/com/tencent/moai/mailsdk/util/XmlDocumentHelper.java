package com.tencent.moai.mailsdk.util;

import android.util.Log;
import com.tencent.moai.mailsdk.util.aswbxml.ASWBXML;
import com.tencent.moai.mailsdk.util.aswbxml.ASWBXML.StreamHandler;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlDocumentHelper
{
  private static final boolean DEBUG = false;
  private static final String TAG = "XmlDocumentHelper";
  private static DocumentBuilderFactory factory = ;
  
  public static Document bytes2XmlDoc(byte[] paramArrayOfByte)
  {
    try
    {
      ASWBXML localASWBXML = new ASWBXML();
      localASWBXML.loadBytes(paramArrayOfByte);
      printXml("response xml", localASWBXML.getXml());
      paramArrayOfByte = localASWBXML.getXmlDocument();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      Logger.log(6, "XmlDocumentHelper", "bytes to xml failed " + Log.getStackTraceString(paramArrayOfByte));
    }
    return null;
  }
  
  public static Document bytesToXmlDoc(byte[] paramArrayOfByte)
  {
    factory.setNamespaceAware(true);
    try
    {
      paramArrayOfByte = factory.newDocumentBuilder().parse(new ByteArrayInputStream(paramArrayOfByte));
      Logger.log(6, "XmlDocumentHelper", "bytesToXmlDoc failed " + Log.getStackTraceString(localException1));
    }
    catch (Exception localException1)
    {
      try
      {
        printXml("response xml", paramArrayOfByte);
        return paramArrayOfByte;
      }
      catch (Exception localException2)
      {
        break label36;
      }
      localException1 = localException1;
      paramArrayOfByte = null;
    }
    label36:
    return paramArrayOfByte;
  }
  
  public static String elpasedInMillis(long paramLong)
  {
    long l = System.nanoTime();
    return String.format(Locale.getDefault(), "%.2f", new Object[] { Float.valueOf((float)(l - paramLong) / 1000.0F / 1000.0F) });
  }
  
  public static int getChildIntContent(Document paramDocument, String paramString1, String paramString2)
  {
    paramDocument = getChildText(paramDocument, paramString1, paramString2);
    if (paramDocument != null) {
      try
      {
        int i = Integer.parseInt(paramDocument);
        return i;
      }
      catch (Exception paramDocument)
      {
        Logger.log(5, "XmlDocumentHelper", "getChildIntContent failed, parent: " + paramString1 + ", child: " + paramString2 + " " + Log.getStackTraceString(paramDocument));
      }
    }
    return 0;
  }
  
  public static int getChildIntContent(Node paramNode, String paramString)
  {
    paramNode = getChildText(paramNode, paramString);
    if (paramNode != null) {
      try
      {
        int i = Integer.parseInt(paramNode);
        return i;
      }
      catch (Exception paramNode)
      {
        Logger.log(5, "XmlDocumentHelper", "getChildIntContent, tag: " + paramString + " " + Log.getStackTraceString(paramNode));
      }
    }
    return 0;
  }
  
  public static Node getChildNode(Node paramNode, String paramString)
  {
    Node localNode;
    if ((paramNode == null) || (paramNode.getChildNodes().getLength() == 0))
    {
      localNode = null;
      return localNode;
    }
    for (paramNode = paramNode.getChildNodes().item(0);; paramNode = paramNode.getNextSibling())
    {
      if (paramNode == null) {
        break label64;
      }
      localNode = paramNode;
      if (paramString.equals(paramNode.getNodeName())) {
        break;
      }
    }
    label64:
    return null;
  }
  
  public static Node getChildNodeByLocalName(Node paramNode, String paramString)
  {
    Node localNode;
    if ((paramNode == null) || (paramNode.getChildNodes().getLength() == 0))
    {
      localNode = null;
      return localNode;
    }
    for (paramNode = paramNode.getChildNodes().item(0);; paramNode = paramNode.getNextSibling())
    {
      if (paramNode == null) {
        break label64;
      }
      localNode = paramNode;
      if (paramString.equals(paramNode.getLocalName())) {
        break;
      }
    }
    label64:
    return null;
  }
  
  public static ArrayList<Node> getChildNodes(Node paramNode, String paramString)
  {
    if ((paramNode == null) || (paramNode.getChildNodes().getLength() == 0))
    {
      paramNode = null;
      return paramNode;
    }
    ArrayList localArrayList = new ArrayList();
    for (Node localNode = paramNode.getChildNodes().item(0);; localNode = localNode.getNextSibling())
    {
      paramNode = localArrayList;
      if (localNode == null) {
        break;
      }
      if (paramString.equals(localNode.getNodeName())) {
        localArrayList.add(localNode);
      }
    }
  }
  
  public static ArrayList<Node> getChildNodesByLocalName(Node paramNode, String paramString)
  {
    if ((paramNode == null) || (paramNode.getChildNodes().getLength() == 0))
    {
      paramNode = null;
      return paramNode;
    }
    ArrayList localArrayList = new ArrayList();
    for (Node localNode = paramNode.getChildNodes().item(0);; localNode = localNode.getNextSibling())
    {
      paramNode = localArrayList;
      if (localNode == null) {
        break;
      }
      if (paramString.equals(localNode.getLocalName())) {
        localArrayList.add(localNode);
      }
    }
  }
  
  public static String getChildText(Document paramDocument, String paramString1, String paramString2)
  {
    paramDocument = paramDocument.getElementsByTagName(paramString1);
    if (paramDocument.getLength() == 0) {}
    for (;;)
    {
      return null;
      paramDocument = paramDocument.item(0).getChildNodes();
      if (paramDocument.getLength() != 0) {
        for (paramDocument = paramDocument.item(0); paramDocument != null; paramDocument = paramDocument.getNextSibling()) {
          if (paramString2.equals(paramDocument.getNodeName())) {
            return paramDocument.getTextContent();
          }
        }
      }
    }
  }
  
  public static String getChildText(Node paramNode, String paramString)
  {
    paramNode = getChildNode(paramNode, paramString);
    if (paramNode != null) {
      return paramNode.getTextContent();
    }
    return null;
  }
  
  public static String getChildTextByLocalName(Node paramNode, String paramString)
  {
    paramNode = getChildNodeByLocalName(paramNode, paramString);
    if (paramNode != null) {
      return paramNode.getTextContent();
    }
    return null;
  }
  
  public static int getIntContent(Node paramNode)
  {
    try
    {
      int i = Integer.parseInt(paramNode.getTextContent());
      return i;
    }
    catch (Exception paramNode)
    {
      Logger.log(5, "XmlDocumentHelper", "getIntContent failed " + Log.getStackTraceString(paramNode));
    }
    return 0;
  }
  
  public static long getLongContent(Node paramNode)
  {
    try
    {
      long l = Long.parseLong(paramNode.getTextContent());
      return l;
    }
    catch (Exception paramNode)
    {
      Logger.log(5, "XmlDocumentHelper", "getLongContent failed" + Log.getStackTraceString(paramNode));
    }
    return 0L;
  }
  
  public static boolean isNodeExist(Document paramDocument, String paramString)
  {
    return paramDocument.getElementsByTagName(paramString).getLength() > 0;
  }
  
  public static boolean isNodeExist(Document paramDocument, String paramString1, String paramString2)
  {
    paramDocument = paramDocument.getElementsByTagName(paramString1);
    if (paramDocument.getLength() == 0) {}
    while (getChildNode(paramDocument.item(0), paramString2) == null) {
      return false;
    }
    return true;
  }
  
  public static void printXml(String paramString1, String paramString2) {}
  
  public static void printXml(String paramString, Document paramDocument) {}
  
  public static Document stream2XmlDoc(InputStream paramInputStream, ArrayList<Long> paramArrayList, ASWBXML.StreamHandler paramStreamHandler)
  {
    try
    {
      ASWBXML localASWBXML = new ASWBXML();
      localASWBXML.loadStream(paramInputStream, paramArrayList, paramStreamHandler);
      printXml("response xml", localASWBXML.getXml());
      paramInputStream = localASWBXML.getXmlDocument();
      return paramInputStream;
    }
    catch (Exception paramInputStream)
    {
      Logger.log(6, "XmlDocumentHelper", "bytes to xml failed " + Log.getStackTraceString(paramInputStream));
    }
    return null;
  }
  
  public static byte[] xml2Bytes(String paramString)
  {
    try
    {
      Object localObject = new ASWBXML();
      ((ASWBXML)localObject).loadXml(paramString);
      printXml("request xml", ((ASWBXML)localObject).getXml());
      localObject = ((ASWBXML)localObject).getBytes();
      return localObject;
    }
    catch (Exception localException)
    {
      Logger.log(6, "XmlDocumentHelper", "xml to bytes failed " + Log.getStackTraceString(localException) + " " + paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.XmlDocumentHelper
 * JD-Core Version:    0.7.0.1
 */