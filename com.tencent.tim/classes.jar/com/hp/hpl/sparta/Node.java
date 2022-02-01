package com.hp.hpl.sparta;

import com.hp.hpl.sparta.xpath.BooleanExpr;
import com.hp.hpl.sparta.xpath.ElementTest;
import com.hp.hpl.sparta.xpath.Step;
import com.hp.hpl.sparta.xpath.XPathException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;

public abstract class Node
{
  private Object annotation_ = null;
  private Document doc_ = null;
  private int hash_ = 0;
  private Node nextSibling_ = null;
  private Element parentNode_ = null;
  private Node previousSibling_ = null;
  
  protected static void htmlEncode(Writer paramWriter, String paramString)
    throws IOException
  {
    int j = 0;
    int m = paramString.length();
    int i = 0;
    if (i >= m)
    {
      if (j < m) {
        paramWriter.write(paramString, j, m - j);
      }
      return;
    }
    int k = paramString.charAt(i);
    String str;
    if (k >= 128) {
      str = "&#" + k + ";";
    }
    for (;;)
    {
      k = j;
      if (str != null)
      {
        paramWriter.write(paramString, j, i - j);
        paramWriter.write(str);
        k = i + 1;
      }
      i += 1;
      j = k;
      break;
      switch (k)
      {
      default: 
        str = null;
        break;
      case 60: 
        str = "&lt;";
        break;
      case 62: 
        str = "&gt;";
        break;
      case 38: 
        str = "&amp;";
        break;
      case 34: 
        str = "&quot;";
        break;
      case 39: 
        str = "&#39;";
      }
    }
  }
  
  public abstract Object clone();
  
  protected abstract int computeHashCode();
  
  public Object getAnnotation()
  {
    return this.annotation_;
  }
  
  public Node getNextSibling()
  {
    return this.nextSibling_;
  }
  
  public Document getOwnerDocument()
  {
    return this.doc_;
  }
  
  public Element getParentNode()
  {
    return this.parentNode_;
  }
  
  public Node getPreviousSibling()
  {
    return this.previousSibling_;
  }
  
  public int hashCode()
  {
    if (this.hash_ == 0) {
      this.hash_ = computeHashCode();
    }
    return this.hash_;
  }
  
  void insertAtEndOfLinkedList(Node paramNode)
  {
    this.previousSibling_ = paramNode;
    if (paramNode != null) {
      paramNode.nextSibling_ = this;
    }
  }
  
  Element makeMatching(Element paramElement, Step paramStep, String paramString)
    throws ParseException, XPathException
  {
    Object localObject = paramStep.getNodeTest();
    if (!(localObject instanceof ElementTest)) {
      throw new ParseException("\"" + localObject + "\" in \"" + paramString + "\" is not an element test");
    }
    localObject = ((ElementTest)localObject).getTagName();
    Element localElement = new Element((String)localObject);
    paramStep.getPredicate().accept(new Node.1(this, localElement, paramElement, paramString, (String)localObject));
    return localElement;
  }
  
  void notifyObservers()
  {
    this.hash_ = 0;
    if (this.doc_ != null) {
      this.doc_.notifyObservers();
    }
  }
  
  void removeFromLinkedList()
  {
    if (this.previousSibling_ != null) {
      this.previousSibling_.nextSibling_ = this.nextSibling_;
    }
    if (this.nextSibling_ != null) {
      this.nextSibling_.previousSibling_ = this.previousSibling_;
    }
    this.nextSibling_ = null;
    this.previousSibling_ = null;
  }
  
  void replaceInLinkedList(Node paramNode)
  {
    if (this.previousSibling_ != null) {
      this.previousSibling_.nextSibling_ = paramNode;
    }
    if (this.nextSibling_ != null) {
      this.nextSibling_.previousSibling_ = paramNode;
    }
    paramNode.nextSibling_ = this.nextSibling_;
    paramNode.previousSibling_ = this.previousSibling_;
    this.nextSibling_ = null;
    this.previousSibling_ = null;
  }
  
  public void setAnnotation(Object paramObject)
  {
    this.annotation_ = paramObject;
  }
  
  void setOwnerDocument(Document paramDocument)
  {
    this.doc_ = paramDocument;
  }
  
  void setParentNode(Element paramElement)
  {
    this.parentNode_ = paramElement;
  }
  
  public String toString()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter((OutputStream)localObject);
      toString(localOutputStreamWriter);
      localOutputStreamWriter.flush();
      localObject = new String(((ByteArrayOutputStream)localObject).toByteArray());
      return localObject;
    }
    catch (IOException localIOException) {}
    return super.toString();
  }
  
  abstract void toString(Writer paramWriter)
    throws IOException;
  
  public String toXml()
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(localByteArrayOutputStream);
    toXml(localOutputStreamWriter);
    localOutputStreamWriter.flush();
    return new String(localByteArrayOutputStream.toByteArray());
  }
  
  abstract void toXml(Writer paramWriter)
    throws IOException;
  
  public abstract Element xpathSelectElement(String paramString)
    throws ParseException;
  
  public abstract Enumeration xpathSelectElements(String paramString)
    throws ParseException;
  
  public abstract String xpathSelectString(String paramString)
    throws ParseException;
  
  public abstract Enumeration xpathSelectStrings(String paramString)
    throws ParseException;
  
  public boolean xpathSetStrings(String paramString1, String paramString2)
    throws ParseException
  {
    int i;
    Object localObject1;
    try
    {
      i = paramString1.lastIndexOf('/');
      if ((!paramString1.substring(i + 1).equals("text()")) && (paramString1.charAt(i + 1) != '@')) {
        throw new ParseException("Last step of Xpath expression \"" + paramString1 + "\" is not \"text()\" and does not start with a '@'. It starts with a '" + paramString1.charAt(i + 1) + "'");
      }
    }
    catch (DOMException paramString1)
    {
      throw new Error("Assertion failed " + paramString1);
      localObject2 = paramString1.substring(0, i);
      if (paramString1.charAt(i + 1) != '@') {
        break label275;
      }
      localObject1 = paramString1.substring(i + 2);
      if (((String)localObject1).length() == 0) {
        throw new ParseException("Xpath expression \"" + paramString1 + "\" specifies zero-length attribute name\"");
      }
    }
    catch (IndexOutOfBoundsException paramString2)
    {
      throw new ParseException("Xpath expression \"" + paramString1 + "\" is not in the form \"xpathExpression/@attributeName\"");
    }
    Object localObject2 = xpathSelectElements((String)localObject2);
    boolean bool = false;
    Element localElement;
    for (;;)
    {
      if (!((Enumeration)localObject2).hasMoreElements()) {
        return bool;
      }
      localElement = (Element)((Enumeration)localObject2).nextElement();
      if (!paramString2.equals(localElement.getAttribute((String)localObject1)))
      {
        localElement.setAttribute((String)localObject1, paramString2);
        bool = true;
      }
    }
    label275:
    localObject2 = xpathSelectElements((String)localObject2);
    bool = ((Enumeration)localObject2).hasMoreElements();
    for (;;)
    {
      Vector localVector;
      if (((Enumeration)localObject2).hasMoreElements())
      {
        localElement = (Element)((Enumeration)localObject2).nextElement();
        localVector = new Vector();
        for (localObject1 = localElement.getFirstChild();; localObject1 = ((Node)localObject1).getNextSibling())
        {
          if (localObject1 == null)
          {
            if (localVector.size() != 0) {
              break label405;
            }
            localObject1 = new Text(paramString2);
            if (((Text)localObject1).getData().length() <= 0) {
              break;
            }
            localElement.appendChild((Node)localObject1);
            bool = true;
            break;
          }
          if ((localObject1 instanceof Text)) {
            localVector.addElement((Text)localObject1);
          }
        }
        label405:
        localObject1 = (Text)localVector.elementAt(0);
        if (!((Text)localObject1).getData().equals(paramString2))
        {
          localVector.removeElementAt(0);
          ((Text)localObject1).setData(paramString2);
          bool = true;
          break label488;
        }
      }
      while (i < localVector.size())
      {
        localElement.removeChild((Text)localVector.elementAt(i));
        i += 1;
        bool = true;
        continue;
        break label488;
        return bool;
        label488:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.Node
 * JD-Core Version:    0.7.0.1
 */