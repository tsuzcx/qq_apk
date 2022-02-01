package com.hp.hpl.sparta;

import com.hp.hpl.sparta.xpath.XPath;
import com.hp.hpl.sparta.xpath.XPathException;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class Element
  extends Node
{
  private static final boolean DEBUG = false;
  private Vector attributeNames_ = null;
  private Hashtable attributes_ = null;
  private Node firstChild_ = null;
  private Node lastChild_ = null;
  private String tagName_ = null;
  
  Element() {}
  
  public Element(String paramString)
  {
    this.tagName_ = Sparta.intern(paramString);
  }
  
  private void checkInvariant() {}
  
  private boolean removeChildNoChecking(Node paramNode)
  {
    Node localNode = this.firstChild_;
    int i = 0;
    for (;;)
    {
      if (localNode == null) {
        return false;
      }
      if (localNode.equals(paramNode))
      {
        if (this.firstChild_ == localNode) {
          this.firstChild_ = localNode.getNextSibling();
        }
        if (this.lastChild_ == localNode) {
          this.lastChild_ = localNode.getPreviousSibling();
        }
        localNode.removeFromLinkedList();
        localNode.setParentNode(null);
        localNode.setOwnerDocument(null);
        return true;
      }
      i += 1;
      localNode = localNode.getNextSibling();
    }
  }
  
  private void replaceChild_(Node paramNode1, Node paramNode2)
    throws DOMException
  {
    int i = 0;
    for (Node localNode = this.firstChild_;; localNode = localNode.getNextSibling())
    {
      if (localNode == null) {
        throw new DOMException((short)8, "Cannot find " + paramNode2 + " in " + this);
      }
      if (localNode == paramNode2)
      {
        if (this.firstChild_ == paramNode2) {
          this.firstChild_ = paramNode1;
        }
        if (this.lastChild_ == paramNode2) {
          this.lastChild_ = paramNode1;
        }
        paramNode2.replaceInLinkedList(paramNode1);
        paramNode1.setParentNode(this);
        paramNode2.setParentNode(null);
        return;
      }
      i += 1;
    }
  }
  
  private XPathVisitor visitor(String paramString, boolean paramBoolean)
    throws XPathException
  {
    XPath localXPath = XPath.get(paramString);
    if (localXPath.isStringValue() != paramBoolean)
    {
      if (paramBoolean) {}
      for (paramString = "evaluates to element not string";; paramString = "evaluates to string not element") {
        throw new XPathException(localXPath, "\"" + localXPath + "\" evaluates to " + paramString);
      }
    }
    return new XPathVisitor(this, localXPath);
  }
  
  public void appendChild(Node paramNode)
  {
    if (!canHaveAsDescendent(paramNode)) {
      paramNode = (Element)paramNode.clone();
    }
    for (;;)
    {
      appendChildNoChecking(paramNode);
      notifyObservers();
      return;
    }
  }
  
  void appendChildNoChecking(Node paramNode)
  {
    Element localElement = paramNode.getParentNode();
    if (localElement != null) {
      localElement.removeChildNoChecking(paramNode);
    }
    paramNode.insertAtEndOfLinkedList(this.lastChild_);
    if (this.firstChild_ == null) {
      this.firstChild_ = paramNode;
    }
    paramNode.setParentNode(this);
    this.lastChild_ = paramNode;
    paramNode.setOwnerDocument(getOwnerDocument());
  }
  
  boolean canHaveAsDescendent(Node paramNode)
  {
    if (paramNode == this) {
      return false;
    }
    Element localElement = getParentNode();
    if (localElement == null) {
      return true;
    }
    return localElement.canHaveAsDescendent(paramNode);
  }
  
  public Object clone()
  {
    return cloneElement(true);
  }
  
  public Element cloneElement(boolean paramBoolean)
  {
    Element localElement = new Element(this.tagName_);
    if (this.attributeNames_ != null)
    {
      localObject = this.attributeNames_.elements();
      if (((Enumeration)localObject).hasMoreElements()) {}
    }
    else if (!paramBoolean) {}
    for (Object localObject = this.firstChild_;; localObject = ((Node)localObject).getNextSibling())
    {
      if (localObject == null)
      {
        return localElement;
        String str = (String)((Enumeration)localObject).nextElement();
        localElement.setAttribute(str, (String)this.attributes_.get(str));
        break;
      }
      localElement.appendChild((Node)((Node)localObject).clone());
    }
  }
  
  public Element cloneShallow()
  {
    return cloneElement(false);
  }
  
  protected int computeHashCode()
  {
    int i = this.tagName_.hashCode();
    Object localObject;
    if (this.attributes_ != null)
    {
      localObject = this.attributes_.keys();
      if (((Enumeration)localObject).hasMoreElements()) {}
    }
    for (;;)
    {
      for (localObject = this.firstChild_;; localObject = ((Node)localObject).getNextSibling())
      {
        if (localObject == null)
        {
          return i;
          String str = (String)((Enumeration)localObject).nextElement();
          int j = str.hashCode();
          i = ((String)this.attributes_.get(str)).hashCode() + (i * 31 + j) * 31;
          break;
        }
        i = i * 31 + ((Node)localObject).hashCode();
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    int i;
    label57:
    int j;
    label66:
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (!(paramObject instanceof Element));
        paramObject = (Element)paramObject;
        bool1 = bool2;
      } while (!this.tagName_.equals(paramObject.tagName_));
      if (this.attributes_ != null) {
        break;
      }
      i = 0;
      if (paramObject.attributes_ != null) {
        break label130;
      }
      j = 0;
      bool1 = bool2;
    } while (i != j);
    Object localObject;
    if (this.attributes_ != null)
    {
      localObject = this.attributes_.keys();
      label91:
      if (((Enumeration)localObject).hasMoreElements()) {}
    }
    else
    {
      localObject = this.firstChild_;
    }
    for (paramObject = paramObject.firstChild_;; paramObject = paramObject.getNextSibling())
    {
      if (localObject == null)
      {
        return true;
        i = this.attributes_.size();
        break label57;
        label130:
        j = paramObject.attributes_.size();
        break label66;
        String str = (String)((Enumeration)localObject).nextElement();
        if (((String)this.attributes_.get(str)).equals((String)paramObject.attributes_.get(str))) {
          break label91;
        }
        return false;
      }
      bool1 = bool2;
      if (!localObject.equals(paramObject)) {
        break;
      }
      localObject = ((Node)localObject).getNextSibling();
    }
  }
  
  public String getAttribute(String paramString)
  {
    if (this.attributes_ == null) {
      return null;
    }
    return (String)this.attributes_.get(paramString);
  }
  
  public Enumeration getAttributeNames()
  {
    if (this.attributeNames_ == null) {
      return Document.EMPTY;
    }
    return this.attributeNames_.elements();
  }
  
  public Node getFirstChild()
  {
    return this.firstChild_;
  }
  
  public Node getLastChild()
  {
    return this.lastChild_;
  }
  
  public String getTagName()
  {
    return this.tagName_;
  }
  
  public void removeAttribute(String paramString)
  {
    if (this.attributes_ == null) {
      return;
    }
    this.attributes_.remove(paramString);
    this.attributeNames_.removeElement(paramString);
    notifyObservers();
  }
  
  public void removeChild(Node paramNode)
    throws DOMException
  {
    if (!removeChildNoChecking(paramNode)) {
      throw new DOMException((short)8, "Cannot find " + paramNode + " in " + this);
    }
    notifyObservers();
  }
  
  public void replaceChild(Element paramElement, Node paramNode)
    throws DOMException
  {
    replaceChild_(paramElement, paramNode);
    notifyObservers();
  }
  
  public void replaceChild(Text paramText, Node paramNode)
    throws DOMException
  {
    replaceChild_(paramText, paramNode);
    notifyObservers();
  }
  
  public void setAttribute(String paramString1, String paramString2)
  {
    if (this.attributes_ == null)
    {
      this.attributes_ = new Hashtable();
      this.attributeNames_ = new Vector();
    }
    if (this.attributes_.get(paramString1) == null) {
      this.attributeNames_.addElement(paramString1);
    }
    this.attributes_.put(paramString1, paramString2);
    notifyObservers();
  }
  
  public void setTagName(String paramString)
  {
    this.tagName_ = Sparta.intern(paramString);
    notifyObservers();
  }
  
  void toString(Writer paramWriter)
    throws IOException
  {
    for (Node localNode = this.firstChild_;; localNode = localNode.getNextSibling())
    {
      if (localNode == null) {
        return;
      }
      localNode.toString(paramWriter);
    }
  }
  
  public void toXml(Writer paramWriter)
    throws IOException
  {
    paramWriter.write("<" + this.tagName_);
    if (this.attributeNames_ != null) {
      localObject = this.attributeNames_.elements();
    }
    for (;;)
    {
      if (!((Enumeration)localObject).hasMoreElements())
      {
        if (this.firstChild_ != null) {
          break;
        }
        paramWriter.write("/>");
        return;
      }
      String str1 = (String)((Enumeration)localObject).nextElement();
      String str2 = (String)this.attributes_.get(str1);
      paramWriter.write(" " + str1 + "=\"");
      Node.htmlEncode(paramWriter, str2);
      paramWriter.write("\"");
    }
    paramWriter.write(">");
    for (Object localObject = this.firstChild_;; localObject = ((Node)localObject).getNextSibling())
    {
      if (localObject == null)
      {
        paramWriter.write("</" + this.tagName_ + ">");
        return;
      }
      ((Node)localObject).toXml(paramWriter);
    }
  }
  
  /* Error */
  public boolean xpathEnsure(String paramString)
    throws ParseException
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 271	com/hp/hpl/sparta/Element:xpathSelectElement	(Ljava/lang/String;)Lcom/hp/hpl/sparta/Element;
    //   5: ifnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_1
    //   11: invokestatic 105	com/hp/hpl/sparta/xpath/XPath:get	(Ljava/lang/String;)Lcom/hp/hpl/sparta/xpath/XPath;
    //   14: astore_3
    //   15: aload_3
    //   16: invokevirtual 274	com/hp/hpl/sparta/xpath/XPath:getSteps	()Ljava/util/Enumeration;
    //   19: astore 4
    //   21: iconst_0
    //   22: istore_2
    //   23: aload 4
    //   25: invokeinterface 169 1 0
    //   30: ifne +60 -> 90
    //   33: iload_2
    //   34: iconst_1
    //   35: isub
    //   36: anewarray 276	com/hp/hpl/sparta/xpath/Step
    //   39: astore 5
    //   41: aload_3
    //   42: invokevirtual 274	com/hp/hpl/sparta/xpath/XPath:getSteps	()Ljava/util/Enumeration;
    //   45: astore 4
    //   47: iconst_0
    //   48: istore_2
    //   49: iload_2
    //   50: aload 5
    //   52: arraylength
    //   53: if_icmplt +52 -> 105
    //   56: aload 4
    //   58: invokeinterface 172 1 0
    //   63: checkcast 276	com/hp/hpl/sparta/xpath/Step
    //   66: astore 4
    //   68: aload 5
    //   70: arraylength
    //   71: ifne +55 -> 126
    //   74: aload_0
    //   75: astore_3
    //   76: aload_3
    //   77: aload_0
    //   78: aload_3
    //   79: aload 4
    //   81: aload_1
    //   82: invokevirtual 280	com/hp/hpl/sparta/Node:makeMatching	(Lcom/hp/hpl/sparta/Element;Lcom/hp/hpl/sparta/xpath/Step;Ljava/lang/String;)Lcom/hp/hpl/sparta/Element;
    //   85: invokevirtual 136	com/hp/hpl/sparta/Element:appendChildNoChecking	(Lcom/hp/hpl/sparta/Node;)V
    //   88: iconst_1
    //   89: ireturn
    //   90: aload 4
    //   92: invokeinterface 172 1 0
    //   97: pop
    //   98: iload_2
    //   99: iconst_1
    //   100: iadd
    //   101: istore_2
    //   102: goto -79 -> 23
    //   105: aload 5
    //   107: iload_2
    //   108: aload 4
    //   110: invokeinterface 172 1 0
    //   115: checkcast 276	com/hp/hpl/sparta/xpath/Step
    //   118: aastore
    //   119: iload_2
    //   120: iconst_1
    //   121: iadd
    //   122: istore_2
    //   123: goto -74 -> 49
    //   126: aload_3
    //   127: invokevirtual 283	com/hp/hpl/sparta/xpath/XPath:isAbsolute	()Z
    //   130: aload 5
    //   132: invokestatic 286	com/hp/hpl/sparta/xpath/XPath:get	(Z[Lcom/hp/hpl/sparta/xpath/Step;)Lcom/hp/hpl/sparta/xpath/XPath;
    //   135: invokevirtual 287	com/hp/hpl/sparta/xpath/XPath:toString	()Ljava/lang/String;
    //   138: astore_3
    //   139: aload_0
    //   140: aload_3
    //   141: invokevirtual 288	java/lang/String:toString	()Ljava/lang/String;
    //   144: invokevirtual 290	com/hp/hpl/sparta/Element:xpathEnsure	(Ljava/lang/String;)Z
    //   147: pop
    //   148: aload_0
    //   149: aload_3
    //   150: invokevirtual 271	com/hp/hpl/sparta/Element:xpathSelectElement	(Ljava/lang/String;)Lcom/hp/hpl/sparta/Element;
    //   153: astore_3
    //   154: goto -78 -> 76
    //   157: astore_3
    //   158: new 267	com/hp/hpl/sparta/ParseException
    //   161: dup
    //   162: aload_1
    //   163: aload_3
    //   164: invokespecial 293	com/hp/hpl/sparta/ParseException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	Element
    //   0	168	1	paramString	String
    //   22	101	2	i	int
    //   14	140	3	localObject1	Object
    //   157	7	3	localXPathException	XPathException
    //   19	90	4	localObject2	Object
    //   39	92	5	arrayOfStep	com.hp.hpl.sparta.xpath.Step[]
    // Exception table:
    //   from	to	target	type
    //   0	8	157	com/hp/hpl/sparta/xpath/XPathException
    //   10	21	157	com/hp/hpl/sparta/xpath/XPathException
    //   23	47	157	com/hp/hpl/sparta/xpath/XPathException
    //   49	74	157	com/hp/hpl/sparta/xpath/XPathException
    //   76	88	157	com/hp/hpl/sparta/xpath/XPathException
    //   90	98	157	com/hp/hpl/sparta/xpath/XPathException
    //   105	119	157	com/hp/hpl/sparta/xpath/XPathException
    //   126	154	157	com/hp/hpl/sparta/xpath/XPathException
  }
  
  public Element xpathSelectElement(String paramString)
    throws ParseException
  {
    try
    {
      paramString = visitor(paramString, false).getFirstResultElement();
      return paramString;
    }
    catch (XPathException paramString)
    {
      throw new ParseException("XPath problem", paramString);
    }
  }
  
  public Enumeration xpathSelectElements(String paramString)
    throws ParseException
  {
    try
    {
      paramString = visitor(paramString, false).getResultEnumeration();
      return paramString;
    }
    catch (XPathException paramString)
    {
      throw new ParseException("XPath problem", paramString);
    }
  }
  
  public String xpathSelectString(String paramString)
    throws ParseException
  {
    try
    {
      paramString = visitor(paramString, true).getFirstResultString();
      return paramString;
    }
    catch (XPathException paramString)
    {
      throw new ParseException("XPath problem", paramString);
    }
  }
  
  public Enumeration xpathSelectStrings(String paramString)
    throws ParseException
  {
    try
    {
      paramString = visitor(paramString, true).getResultEnumeration();
      return paramString;
    }
    catch (XPathException paramString)
    {
      throw new ParseException("XPath problem", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.Element
 * JD-Core Version:    0.7.0.1
 */