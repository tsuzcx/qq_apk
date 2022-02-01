package com.tencent.mobileqq.mini.cache;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;

public final class Util
{
  static final Charset US_ASCII = Charset.forName("US-ASCII");
  static final Charset UTF_8 = Charset.forName("UTF-8");
  
  static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      throw paramCloseable;
    }
    catch (Exception paramCloseable) {}
  }
  
  public static String[] decode(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf(":");
      if ((i != -1) && (paramString.length() > i + 1)) {
        return new String[] { paramString.substring(0, i), paramString.substring(i + 1) };
      }
    }
    return null;
  }
  
  static void deleteContents(File paramFile)
    throws IOException
  {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null) {
      throw new IOException("not a readable directory: " + paramFile);
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      paramFile = arrayOfFile[i];
      if (paramFile.isDirectory()) {
        deleteContents(paramFile);
      }
      if (!paramFile.delete()) {
        throw new IOException("failed to delete file: " + paramFile);
      }
      i += 1;
    }
  }
  
  public static String dencrypt(String paramString)
  {
    return null;
  }
  
  public static String encode(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      return paramString1 + ":" + paramString2;
    }
    return null;
  }
  
  public static String encrypt(String paramString)
  {
    return null;
  }
  
  static String readFully(Reader paramReader)
    throws IOException
  {
    try
    {
      StringWriter localStringWriter = new StringWriter();
      char[] arrayOfChar = new char[1024];
      for (;;)
      {
        int i = paramReader.read(arrayOfChar);
        if (i == -1) {
          break;
        }
        localStringWriter.write(arrayOfChar, 0, i);
      }
      str = localObject.toString();
    }
    finally
    {
      paramReader.close();
    }
    String str;
    paramReader.close();
    return str;
  }
  
  public static JSONArray setToJSONArray(Set paramSet)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramSet != null)
    {
      paramSet = paramSet.iterator();
      while (paramSet.hasNext()) {
        localJSONArray.put(paramSet.next());
      }
    }
    return localJSONArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.cache.Util
 * JD-Core Version:    0.7.0.1
 */