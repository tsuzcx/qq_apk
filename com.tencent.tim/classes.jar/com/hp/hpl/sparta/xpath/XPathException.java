package com.hp.hpl.sparta.xpath;

import java.io.IOException;

public class XPathException
  extends Exception
{
  private Throwable cause_ = null;
  
  XPathException(XPath paramXPath, Exception paramException)
  {
    super(paramXPath + " " + paramException);
    this.cause_ = paramException;
  }
  
  public XPathException(XPath paramXPath, String paramString)
  {
    super(paramXPath + " " + paramString);
  }
  
  XPathException(XPath paramXPath, String paramString1, SimpleStreamTokenizer paramSimpleStreamTokenizer, String paramString2)
  {
    this(paramXPath, paramString1 + " got \"" + toString(paramSimpleStreamTokenizer) + "\" instead of expected " + paramString2);
  }
  
  private static String toString(SimpleStreamTokenizer paramSimpleStreamTokenizer)
  {
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(tokenToString(paramSimpleStreamTokenizer));
      if (paramSimpleStreamTokenizer.ttype != -1)
      {
        paramSimpleStreamTokenizer.nextToken();
        localStringBuffer.append(tokenToString(paramSimpleStreamTokenizer));
        paramSimpleStreamTokenizer.pushBack();
      }
      paramSimpleStreamTokenizer = localStringBuffer.toString();
      return paramSimpleStreamTokenizer;
    }
    catch (IOException paramSimpleStreamTokenizer) {}
    return "(cannot get  info: " + paramSimpleStreamTokenizer + ")";
  }
  
  private static String tokenToString(SimpleStreamTokenizer paramSimpleStreamTokenizer)
  {
    switch (paramSimpleStreamTokenizer.ttype)
    {
    default: 
      return (char)paramSimpleStreamTokenizer.ttype + "";
    case -1: 
      return "<end of expression>";
    case -2: 
      return paramSimpleStreamTokenizer.nval + "";
    }
    return paramSimpleStreamTokenizer.sval;
  }
  
  public Throwable getCause()
  {
    return this.cause_;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.xpath.XPathException
 * JD-Core Version:    0.7.0.1
 */