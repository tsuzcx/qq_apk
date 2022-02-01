package org.apache.commons.cli;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class TypeHandler
{
  public static Class createClass(String paramString)
    throws ParseException
  {
    try
    {
      Class localClass = Class.forName(paramString);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new ParseException("Unable to find the class: " + paramString);
    }
  }
  
  public static Date createDate(String paramString)
    throws ParseException
  {
    throw new UnsupportedOperationException("Not yet implemented");
  }
  
  public static File createFile(String paramString)
    throws ParseException
  {
    return new File(paramString);
  }
  
  public static File[] createFiles(String paramString)
    throws ParseException
  {
    throw new UnsupportedOperationException("Not yet implemented");
  }
  
  public static Number createNumber(String paramString)
    throws ParseException
  {
    try
    {
      if (paramString.indexOf('.') != -1) {
        return Double.valueOf(paramString);
      }
      paramString = Long.valueOf(paramString);
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      throw new ParseException(paramString.getMessage());
    }
  }
  
  /* Error */
  public static Object createObject(String paramString)
    throws ParseException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 20	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   4: astore_1
    //   5: aload_1
    //   6: invokevirtual 83	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   9: astore_1
    //   10: aload_1
    //   11: areturn
    //   12: astore_1
    //   13: new 13	org/apache/commons/cli/ParseException
    //   16: dup
    //   17: new 22	java/lang/StringBuffer
    //   20: dup
    //   21: invokespecial 23	java/lang/StringBuffer:<init>	()V
    //   24: ldc 25
    //   26: invokevirtual 29	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   29: aload_0
    //   30: invokevirtual 29	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   33: invokevirtual 33	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   36: invokespecial 36	org/apache/commons/cli/ParseException:<init>	(Ljava/lang/String;)V
    //   39: athrow
    //   40: astore_1
    //   41: new 13	org/apache/commons/cli/ParseException
    //   44: dup
    //   45: new 22	java/lang/StringBuffer
    //   48: dup
    //   49: invokespecial 23	java/lang/StringBuffer:<init>	()V
    //   52: aload_1
    //   53: invokevirtual 87	java/lang/Object:getClass	()Ljava/lang/Class;
    //   56: invokevirtual 90	java/lang/Class:getName	()Ljava/lang/String;
    //   59: invokevirtual 29	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   62: ldc 92
    //   64: invokevirtual 29	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   67: aload_0
    //   68: invokevirtual 29	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   71: invokevirtual 33	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   74: invokespecial 36	org/apache/commons/cli/ParseException:<init>	(Ljava/lang/String;)V
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramString	String
    //   4	7	1	localObject	Object
    //   12	1	1	localClassNotFoundException	ClassNotFoundException
    //   40	13	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	5	12	java/lang/ClassNotFoundException
    //   5	10	40	java/lang/Exception
  }
  
  public static URL createURL(String paramString)
    throws ParseException
  {
    try
    {
      URL localURL = new URL(paramString);
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new ParseException("Unable to parse the URL: " + paramString);
    }
  }
  
  public static Object createValue(String paramString, Class paramClass)
    throws ParseException
  {
    if (PatternOptionBuilder.STRING_VALUE == paramClass) {
      return paramString;
    }
    if (PatternOptionBuilder.OBJECT_VALUE == paramClass) {
      return createObject(paramString);
    }
    if (PatternOptionBuilder.NUMBER_VALUE == paramClass) {
      return createNumber(paramString);
    }
    if (PatternOptionBuilder.DATE_VALUE == paramClass) {
      return createDate(paramString);
    }
    if (PatternOptionBuilder.CLASS_VALUE == paramClass) {
      return createClass(paramString);
    }
    if (PatternOptionBuilder.FILE_VALUE == paramClass) {
      return createFile(paramString);
    }
    if (PatternOptionBuilder.EXISTING_FILE_VALUE == paramClass) {
      return createFile(paramString);
    }
    if (PatternOptionBuilder.FILES_VALUE == paramClass) {
      return createFiles(paramString);
    }
    if (PatternOptionBuilder.URL_VALUE == paramClass) {
      return createURL(paramString);
    }
    return null;
  }
  
  public static Object createValue(String paramString, Object paramObject)
    throws ParseException
  {
    return createValue(paramString, (Class)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.cli.TypeHandler
 * JD-Core Version:    0.7.0.1
 */