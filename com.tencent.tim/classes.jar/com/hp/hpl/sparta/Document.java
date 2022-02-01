package com.hp.hpl.sparta;

import com.hp.hpl.sparta.xpath.Step;
import com.hp.hpl.sparta.xpath.XPath;
import com.hp.hpl.sparta.xpath.XPathException;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class Document
  extends Node
{
  private static final boolean DEBUG = false;
  static final Enumeration EMPTY = new EmptyEnumeration();
  private static final Integer ONE = new Integer(1);
  private final Hashtable indexible_ = (Hashtable)null;
  private Sparta.Cache indices_ = Sparta.newCache();
  private Vector observers_ = new Vector();
  private Element rootElement_ = null;
  private String systemId_;
  
  public Document()
  {
    this.systemId_ = "MEMORY";
  }
  
  Document(String paramString)
  {
    this.systemId_ = paramString;
  }
  
  private XPathVisitor visitor(String paramString, boolean paramBoolean)
    throws XPathException
  {
    String str = paramString;
    if (paramString.charAt(0) != '/') {
      str = "/" + paramString;
    }
    return visitor(XPath.get(str), paramBoolean);
  }
  
  public void addObserver(Observer paramObserver)
  {
    this.observers_.addElement(paramObserver);
  }
  
  public Object clone()
  {
    Document localDocument = new Document(this.systemId_);
    localDocument.rootElement_ = ((Element)this.rootElement_.clone());
    return localDocument;
  }
  
  protected int computeHashCode()
  {
    return this.rootElement_.hashCode();
  }
  
  public void deleteObserver(Observer paramObserver)
  {
    this.observers_.removeElement(paramObserver);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Document)) {
      return false;
    }
    paramObject = (Document)paramObject;
    return this.rootElement_.equals(paramObject.rootElement_);
  }
  
  public Element getDocumentElement()
  {
    return this.rootElement_;
  }
  
  public String getSystemId()
  {
    return this.systemId_;
  }
  
  void monitor(XPath paramXPath)
    throws XPathException
  {}
  
  void notifyObservers()
  {
    Enumeration localEnumeration = this.observers_.elements();
    for (;;)
    {
      if (!localEnumeration.hasMoreElements()) {
        return;
      }
      ((Observer)localEnumeration.nextElement()).update(this);
    }
  }
  
  public void setDocumentElement(Element paramElement)
  {
    this.rootElement_ = paramElement;
    this.rootElement_.setOwnerDocument(this);
    notifyObservers();
  }
  
  public void setSystemId(String paramString)
  {
    this.systemId_ = paramString;
    notifyObservers();
  }
  
  public String toString()
  {
    return this.systemId_;
  }
  
  public void toString(Writer paramWriter)
    throws IOException
  {
    this.rootElement_.toString(paramWriter);
  }
  
  public void toXml(Writer paramWriter)
    throws IOException
  {
    paramWriter.write("<?xml version=\"1.0\" ?>\n");
    this.rootElement_.toXml(paramWriter);
  }
  
  XPathVisitor visitor(XPath paramXPath, boolean paramBoolean)
    throws XPathException
  {
    if (paramXPath.isStringValue() != paramBoolean)
    {
      if (paramBoolean) {}
      for (String str = "evaluates to element not string";; str = "evaluates to string not element") {
        throw new XPathException(paramXPath, "\"" + paramXPath + "\" evaluates to " + str);
      }
    }
    return new XPathVisitor(this, paramXPath);
  }
  
  public boolean xpathEnsure(String paramString)
    throws ParseException
  {
    Step[] arrayOfStep;
    try
    {
      if (xpathSelectElement(paramString) != null) {
        return false;
      }
      Object localObject1 = XPath.get(paramString);
      Object localObject2 = ((XPath)localObject1).getSteps();
      int i = 0;
      if (!((Enumeration)localObject2).hasMoreElements())
      {
        localObject1 = ((XPath)localObject1).getSteps();
        localObject2 = (Step)((Enumeration)localObject1).nextElement();
        arrayOfStep = new Step[i - 1];
        i = 0;
        label64:
        if (i < arrayOfStep.length) {
          break label113;
        }
        if (this.rootElement_ != null) {
          break label134;
        }
        setDocumentElement(makeMatching(null, (Step)localObject2, paramString));
      }
      for (;;)
      {
        if (arrayOfStep.length == 0)
        {
          return true;
          ((Enumeration)localObject2).nextElement();
          i += 1;
          break;
          label113:
          arrayOfStep[i] = ((Step)((Enumeration)localObject1).nextElement());
          i += 1;
          break label64;
          label134:
          if (xpathSelectElement("/" + localObject2) == null) {
            throw new ParseException("Existing root element <" + this.rootElement_.getTagName() + "...> does not match first step \"" + localObject2 + "\" of \"" + paramString);
          }
        }
      }
    }
    catch (XPathException localXPathException)
    {
      throw new ParseException(paramString, localXPathException);
    }
    boolean bool = this.rootElement_.xpathEnsure(XPath.get(false, arrayOfStep).toString());
    return bool;
  }
  
  public Index xpathGetIndex(String paramString)
    throws ParseException
  {
    try
    {
      Index localIndex2 = (Index)this.indices_.get(paramString);
      Index localIndex1 = localIndex2;
      if (localIndex2 == null)
      {
        localIndex1 = new Index(XPath.get(paramString));
        this.indices_.put(paramString, localIndex1);
      }
      return localIndex1;
    }
    catch (XPathException paramString)
    {
      throw new ParseException("XPath problem", paramString);
    }
  }
  
  public boolean xpathHasIndex(String paramString)
  {
    return this.indices_.get(paramString) != null;
  }
  
  public Element xpathSelectElement(String paramString)
    throws ParseException
  {
    String str = paramString;
    try
    {
      if (paramString.charAt(0) != '/') {
        str = "/" + paramString;
      }
      paramString = XPath.get(str);
      monitor(paramString);
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
    String str = paramString;
    try
    {
      if (paramString.charAt(0) != '/') {
        str = "/" + paramString;
      }
      paramString = XPath.get(str);
      monitor(paramString);
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
  
  public class Index
    implements Document.Observer
  {
    private final String attrName_;
    private transient Sparta.Cache dict_ = null;
    private final XPath xpath_;
    
    Index(XPath paramXPath)
      throws XPathException
    {
      this.attrName_ = paramXPath.getIndexingAttrName();
      this.xpath_ = paramXPath;
      Document.this.addObserver(this);
    }
    
    /* Error */
    private void regenerate()
      throws ParseException
    {
      // Byte code:
      //   0: aload_0
      //   1: invokestatic 53	com/hp/hpl/sparta/Sparta:newCache	()Lcom/hp/hpl/sparta/Sparta$Cache;
      //   4: putfield 28	com/hp/hpl/sparta/Document$Index:dict_	Lcom/hp/hpl/sparta/Sparta$Cache;
      //   7: aload_0
      //   8: getfield 26	com/hp/hpl/sparta/Document$Index:this$0	Lcom/hp/hpl/sparta/Document;
      //   11: aload_0
      //   12: getfield 38	com/hp/hpl/sparta/Document$Index:xpath_	Lcom/hp/hpl/sparta/xpath/XPath;
      //   15: iconst_0
      //   16: invokevirtual 57	com/hp/hpl/sparta/Document:visitor	(Lcom/hp/hpl/sparta/xpath/XPath;Z)Lcom/hp/hpl/sparta/XPathVisitor;
      //   19: invokevirtual 63	com/hp/hpl/sparta/XPathVisitor:getResultEnumeration	()Ljava/util/Enumeration;
      //   22: astore_3
      //   23: aload_3
      //   24: invokeinterface 69 1 0
      //   29: ifne +4 -> 33
      //   32: return
      //   33: aload_3
      //   34: invokeinterface 73 1 0
      //   39: checkcast 75	com/hp/hpl/sparta/Element
      //   42: astore 4
      //   44: aload 4
      //   46: aload_0
      //   47: getfield 36	com/hp/hpl/sparta/Document$Index:attrName_	Ljava/lang/String;
      //   50: invokevirtual 79	com/hp/hpl/sparta/Element:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
      //   53: astore 5
      //   55: aload_0
      //   56: getfield 28	com/hp/hpl/sparta/Document$Index:dict_	Lcom/hp/hpl/sparta/Sparta$Cache;
      //   59: aload 5
      //   61: invokeinterface 85 2 0
      //   66: checkcast 87	java/util/Vector
      //   69: astore_2
      //   70: aload_2
      //   71: astore_1
      //   72: aload_2
      //   73: ifnonnull +25 -> 98
      //   76: new 87	java/util/Vector
      //   79: dup
      //   80: iconst_1
      //   81: invokespecial 90	java/util/Vector:<init>	(I)V
      //   84: astore_1
      //   85: aload_0
      //   86: getfield 28	com/hp/hpl/sparta/Document$Index:dict_	Lcom/hp/hpl/sparta/Sparta$Cache;
      //   89: aload 5
      //   91: aload_1
      //   92: invokeinterface 94 3 0
      //   97: pop
      //   98: aload_1
      //   99: aload 4
      //   101: invokevirtual 98	java/util/Vector:addElement	(Ljava/lang/Object;)V
      //   104: goto -81 -> 23
      //   107: astore_1
      //   108: new 47	com/hp/hpl/sparta/ParseException
      //   111: dup
      //   112: ldc 100
      //   114: aload_1
      //   115: invokespecial 103	com/hp/hpl/sparta/ParseException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   118: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	119	0	this	Index
      //   71	28	1	localVector1	Vector
      //   107	8	1	localXPathException	XPathException
      //   69	4	2	localVector2	Vector
      //   22	12	3	localEnumeration	Enumeration
      //   42	58	4	localElement	Element
      //   53	37	5	str	String
      // Exception table:
      //   from	to	target	type
      //   0	23	107	com/hp/hpl/sparta/xpath/XPathException
      //   23	32	107	com/hp/hpl/sparta/xpath/XPathException
      //   33	70	107	com/hp/hpl/sparta/xpath/XPathException
      //   76	98	107	com/hp/hpl/sparta/xpath/XPathException
      //   98	104	107	com/hp/hpl/sparta/xpath/XPathException
    }
    
    /* Error */
    public Enumeration get(String paramString)
      throws ParseException
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 28	com/hp/hpl/sparta/Document$Index:dict_	Lcom/hp/hpl/sparta/Sparta$Cache;
      //   6: ifnonnull +7 -> 13
      //   9: aload_0
      //   10: invokespecial 106	com/hp/hpl/sparta/Document$Index:regenerate	()V
      //   13: aload_0
      //   14: getfield 28	com/hp/hpl/sparta/Document$Index:dict_	Lcom/hp/hpl/sparta/Sparta$Cache;
      //   17: aload_1
      //   18: invokeinterface 85 2 0
      //   23: checkcast 87	java/util/Vector
      //   26: astore_1
      //   27: aload_1
      //   28: ifnonnull +11 -> 39
      //   31: getstatic 110	com/hp/hpl/sparta/Document:EMPTY	Ljava/util/Enumeration;
      //   34: astore_1
      //   35: aload_0
      //   36: monitorexit
      //   37: aload_1
      //   38: areturn
      //   39: aload_1
      //   40: invokevirtual 113	java/util/Vector:elements	()Ljava/util/Enumeration;
      //   43: astore_1
      //   44: goto -9 -> 35
      //   47: astore_1
      //   48: aload_0
      //   49: monitorexit
      //   50: aload_1
      //   51: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	52	0	this	Index
      //   0	52	1	paramString	String
      // Exception table:
      //   from	to	target	type
      //   2	13	47	finally
      //   13	27	47	finally
      //   31	35	47	finally
      //   39	44	47	finally
    }
    
    public int size()
      throws ParseException
    {
      try
      {
        if (this.dict_ == null) {
          regenerate();
        }
        int i = this.dict_.size();
        return i;
      }
      finally {}
    }
    
    public void update(Document paramDocument)
    {
      try
      {
        this.dict_ = null;
        return;
      }
      finally
      {
        paramDocument = finally;
        throw paramDocument;
      }
    }
  }
  
  public static abstract interface Observer
  {
    public abstract void update(Document paramDocument);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.Document
 * JD-Core Version:    0.7.0.1
 */