package com.tencent.mobileqq.msf.core.a;

import java.io.InputStream;
import java.util.Map;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class c
{
  public static void a(InputStream paramInputStream, Map paramMap, String paramString)
  {
    try
    {
      SAXParserFactory.newInstance().newSAXParser().parse(paramInputStream, new f(paramString, paramMap));
      paramInputStream.close();
      return;
    }
    catch (Exception paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.a.c
 * JD-Core Version:    0.7.0.1
 */