package com.tencent.mobileqq.msf.core.a;

import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class f
  extends DefaultHandler
{
  Map a;
  String b;
  private String c = null;
  
  public f(String paramString, Map paramMap)
  {
    this.b = paramString;
    this.a = paramMap;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws SAXException
  {
    if (this.c != null)
    {
      paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
      if (paramArrayOfChar != null) {
        this.a.put(this.b + this.c, paramArrayOfChar);
      }
    }
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
    throws SAXException
  {
    this.c = null;
  }
  
  public void startDocument()
    throws SAXException
  {}
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
    this.c = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.a.f
 * JD-Core Version:    0.7.0.1
 */