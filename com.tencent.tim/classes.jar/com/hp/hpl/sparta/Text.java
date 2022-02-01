package com.hp.hpl.sparta;

import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;

public class Text
  extends Node
{
  private StringBuffer text_;
  
  public Text(char paramChar)
  {
    this.text_ = new StringBuffer();
    this.text_.append(paramChar);
  }
  
  public Text(String paramString)
  {
    this.text_ = new StringBuffer(paramString);
  }
  
  public void appendData(char paramChar)
  {
    this.text_.append(paramChar);
    notifyObservers();
  }
  
  public void appendData(String paramString)
  {
    this.text_.append(paramString);
    notifyObservers();
  }
  
  public void appendData(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this.text_.append(paramArrayOfChar, paramInt1, paramInt2);
    notifyObservers();
  }
  
  public Object clone()
  {
    return new Text(this.text_.toString());
  }
  
  protected int computeHashCode()
  {
    return this.text_.toString().hashCode();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Text)) {
      return false;
    }
    paramObject = (Text)paramObject;
    return this.text_.toString().equals(paramObject.text_.toString());
  }
  
  public String getData()
  {
    return this.text_.toString();
  }
  
  public void setData(String paramString)
  {
    this.text_ = new StringBuffer(paramString);
    notifyObservers();
  }
  
  void toString(Writer paramWriter)
    throws IOException
  {
    paramWriter.write(this.text_.toString());
  }
  
  void toXml(Writer paramWriter)
    throws IOException
  {
    String str = this.text_.toString();
    if (str.length() < 50)
    {
      Node.htmlEncode(paramWriter, str);
      return;
    }
    paramWriter.write("<![CDATA[");
    paramWriter.write(str);
    paramWriter.write("]]>");
  }
  
  public Element xpathSelectElement(String paramString)
  {
    throw new Error("Sorry, not implemented");
  }
  
  public Enumeration xpathSelectElements(String paramString)
  {
    throw new Error("Sorry, not implemented");
  }
  
  public String xpathSelectString(String paramString)
  {
    throw new Error("Sorry, not implemented");
  }
  
  public Enumeration xpathSelectStrings(String paramString)
  {
    throw new Error("Sorry, not implemented");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.Text
 * JD-Core Version:    0.7.0.1
 */