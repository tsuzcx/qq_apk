package com.hp.hpl.sparta;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class Parser
{
  public static Document parse(String paramString)
    throws ParseException, IOException
  {
    return parse(paramString.toCharArray());
  }
  
  public static Document parse(String paramString, InputStream paramInputStream)
    throws ParseException, IOException
  {
    BuildDocument localBuildDocument = new BuildDocument();
    new ParseByteStream(paramString, paramInputStream, null, null, localBuildDocument);
    return localBuildDocument.getDocument();
  }
  
  public static Document parse(String paramString, InputStream paramInputStream, ParseLog paramParseLog)
    throws ParseException, IOException
  {
    BuildDocument localBuildDocument = new BuildDocument();
    new ParseByteStream(paramString, paramInputStream, paramParseLog, null, localBuildDocument);
    return localBuildDocument.getDocument();
  }
  
  public static Document parse(String paramString1, InputStream paramInputStream, ParseLog paramParseLog, String paramString2)
    throws ParseException, IOException
  {
    BuildDocument localBuildDocument = new BuildDocument();
    new ParseByteStream(paramString1, paramInputStream, paramParseLog, paramString2, localBuildDocument);
    return localBuildDocument.getDocument();
  }
  
  public static Document parse(String paramString, Reader paramReader)
    throws ParseException, IOException
  {
    BuildDocument localBuildDocument = new BuildDocument();
    new ParseCharStream(paramString, paramReader, null, null, localBuildDocument);
    return localBuildDocument.getDocument();
  }
  
  public static Document parse(String paramString, Reader paramReader, ParseLog paramParseLog)
    throws ParseException, IOException
  {
    BuildDocument localBuildDocument = new BuildDocument();
    new ParseCharStream(paramString, paramReader, paramParseLog, null, localBuildDocument);
    return localBuildDocument.getDocument();
  }
  
  public static Document parse(String paramString1, Reader paramReader, ParseLog paramParseLog, String paramString2)
    throws ParseException, EncodingMismatchException, IOException
  {
    BuildDocument localBuildDocument = new BuildDocument();
    new ParseCharStream(paramString1, paramReader, paramParseLog, paramString2, localBuildDocument);
    return localBuildDocument.getDocument();
  }
  
  public static Document parse(byte[] paramArrayOfByte)
    throws ParseException, IOException
  {
    BuildDocument localBuildDocument = new BuildDocument();
    new ParseByteStream("file:anonymous-string", new ByteArrayInputStream(paramArrayOfByte), null, null, localBuildDocument);
    return localBuildDocument.getDocument();
  }
  
  public static Document parse(char[] paramArrayOfChar)
    throws ParseException, IOException
  {
    BuildDocument localBuildDocument = new BuildDocument();
    new ParseCharStream("file:anonymous-string", paramArrayOfChar, null, null, localBuildDocument);
    return localBuildDocument.getDocument();
  }
  
  public static void parse(String paramString, ParseHandler paramParseHandler)
    throws ParseException, IOException
  {
    parse(paramString.toCharArray(), paramParseHandler);
  }
  
  public static void parse(String paramString, InputStream paramInputStream, ParseHandler paramParseHandler)
    throws ParseException, IOException
  {
    new ParseByteStream(paramString, paramInputStream, null, null, paramParseHandler);
  }
  
  public static void parse(String paramString, InputStream paramInputStream, ParseLog paramParseLog, ParseHandler paramParseHandler)
    throws ParseException, IOException
  {
    new ParseByteStream(paramString, paramInputStream, paramParseLog, null, paramParseHandler);
  }
  
  public static void parse(String paramString1, InputStream paramInputStream, ParseLog paramParseLog, String paramString2, ParseHandler paramParseHandler)
    throws ParseException, IOException
  {
    new ParseByteStream(paramString1, paramInputStream, paramParseLog, paramString2, paramParseHandler);
  }
  
  public static void parse(String paramString, Reader paramReader, ParseHandler paramParseHandler)
    throws ParseException, IOException
  {
    new ParseCharStream(paramString, paramReader, null, null, paramParseHandler);
  }
  
  public static void parse(String paramString, Reader paramReader, ParseLog paramParseLog, ParseHandler paramParseHandler)
    throws ParseException, IOException
  {
    new ParseCharStream(paramString, paramReader, paramParseLog, null, paramParseHandler);
  }
  
  public static void parse(String paramString1, Reader paramReader, ParseLog paramParseLog, String paramString2, ParseHandler paramParseHandler)
    throws ParseException, EncodingMismatchException, IOException
  {
    new ParseCharStream(paramString1, paramReader, paramParseLog, paramString2, paramParseHandler);
  }
  
  public static void parse(byte[] paramArrayOfByte, ParseHandler paramParseHandler)
    throws ParseException, IOException
  {
    new ParseByteStream("file:anonymous-string", new ByteArrayInputStream(paramArrayOfByte), null, null, paramParseHandler);
  }
  
  public static void parse(char[] paramArrayOfChar, ParseHandler paramParseHandler)
    throws ParseException, IOException
  {
    new ParseCharStream("file:anonymous-string", paramArrayOfChar, null, null, paramParseHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.Parser
 * JD-Core Version:    0.7.0.1
 */