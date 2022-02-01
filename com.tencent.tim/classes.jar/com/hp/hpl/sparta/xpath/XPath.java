package com.hp.hpl.sparta.xpath;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;

public class XPath
{
  private static final int ASSERTION = 0;
  private static Hashtable cache_ = new Hashtable();
  private boolean absolute_;
  private Stack steps_ = new Stack();
  private String string_;
  
  private XPath(String paramString)
    throws XPathException
  {
    this(paramString, new InputStreamReader(new ByteArrayInputStream(paramString.getBytes())));
  }
  
  private XPath(String paramString, Reader paramReader)
    throws XPathException
  {
    for (;;)
    {
      try
      {
        this.string_ = paramString;
        paramString = new SimpleStreamTokenizer(paramReader);
        paramString.ordinaryChar('/');
        paramString.ordinaryChar('.');
        paramString.wordChars(':', ':');
        paramString.wordChars('_', '_');
        if (paramString.nextToken() != 47) {
          break label152;
        }
        this.absolute_ = true;
        if (paramString.nextToken() == 47)
        {
          paramString.nextToken();
          bool = true;
          this.steps_.push(new Step(this, bool, paramString));
          if (paramString.ttype == 47) {
            break;
          }
          if (paramString.ttype == -1) {
            return;
          }
          throw new XPathException(this, "at end of XPATH expression", paramString, "end of expression");
        }
      }
      catch (IOException paramString)
      {
        throw new XPathException(this, paramString);
      }
      bool = false;
      continue;
      label152:
      this.absolute_ = false;
      bool = false;
    }
    if (paramString.nextToken() == 47) {
      paramString.nextToken();
    }
    for (boolean bool = true;; bool = false)
    {
      this.steps_.push(new Step(this, bool, paramString));
      break;
    }
  }
  
  private XPath(boolean paramBoolean, Step[] paramArrayOfStep)
  {
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfStep.length)
      {
        this.absolute_ = paramBoolean;
        this.string_ = null;
        return;
      }
      this.steps_.addElement(paramArrayOfStep[i]);
      i += 1;
    }
  }
  
  private String generateString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Enumeration localEnumeration = this.steps_.elements();
    for (int i = 1;; i = 0)
    {
      if (!localEnumeration.hasMoreElements()) {
        return localStringBuffer.toString();
      }
      Step localStep = (Step)localEnumeration.nextElement();
      if ((i == 0) || (this.absolute_))
      {
        localStringBuffer.append('/');
        if (localStep.isMultiLevel()) {
          localStringBuffer.append('/');
        }
      }
      localStringBuffer.append(localStep.toString());
    }
  }
  
  public static XPath get(String paramString)
    throws XPathException
  {
    synchronized (cache_)
    {
      XPath localXPath2 = (XPath)cache_.get(paramString);
      XPath localXPath1 = localXPath2;
      if (localXPath2 == null)
      {
        localXPath1 = new XPath(paramString);
        cache_.put(paramString, localXPath1);
      }
      return localXPath1;
    }
  }
  
  public static XPath get(boolean paramBoolean, Step[] arg1)
  {
    XPath localXPath1 = new XPath(paramBoolean, ???);
    String str = localXPath1.toString();
    synchronized (cache_)
    {
      XPath localXPath2 = (XPath)cache_.get(str);
      if (localXPath2 == null)
      {
        cache_.put(str, localXPath1);
        return localXPath1;
      }
      return localXPath2;
    }
  }
  
  public static boolean isStringValue(String paramString)
    throws XPathException, IOException
  {
    return get(paramString).isStringValue();
  }
  
  public Object clone()
  {
    Step[] arrayOfStep = new Step[this.steps_.size()];
    Enumeration localEnumeration = this.steps_.elements();
    int i = 0;
    for (;;)
    {
      if (i >= arrayOfStep.length) {
        return new XPath(this.absolute_, arrayOfStep);
      }
      arrayOfStep[i] = ((Step)localEnumeration.nextElement());
      i += 1;
    }
  }
  
  public String getIndexingAttrName()
    throws XPathException
  {
    BooleanExpr localBooleanExpr = ((Step)this.steps_.peek()).getPredicate();
    if (!(localBooleanExpr instanceof AttrExistsExpr)) {
      throw new XPathException(this, "has no indexing attribute name (must end with predicate of the form [@attrName]");
    }
    return ((AttrExistsExpr)localBooleanExpr).getAttrName();
  }
  
  public String getIndexingAttrNameOfEquals()
    throws XPathException
  {
    BooleanExpr localBooleanExpr = ((Step)this.steps_.peek()).getPredicate();
    if ((localBooleanExpr instanceof AttrEqualsExpr)) {
      return ((AttrEqualsExpr)localBooleanExpr).getAttrName();
    }
    return null;
  }
  
  public Enumeration getSteps()
  {
    return this.steps_.elements();
  }
  
  public boolean isAbsolute()
  {
    return this.absolute_;
  }
  
  public boolean isStringValue()
  {
    return ((Step)this.steps_.peek()).isStringValue();
  }
  
  public String toString()
  {
    if (this.string_ == null) {
      this.string_ = generateString();
    }
    return this.string_;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.xpath.XPath
 * JD-Core Version:    0.7.0.1
 */