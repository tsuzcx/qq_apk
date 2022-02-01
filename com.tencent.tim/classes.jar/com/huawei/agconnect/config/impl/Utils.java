package com.huawei.agconnect.config.impl;

import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public final class Utils
{
  private static final int BUFF_SIZE = 4096;
  private static final String TAG = "Utils";
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      Log.e("Utils", "Exception when closing the 'Closeable'.");
    }
  }
  
  public static void copy(Reader paramReader, Writer paramWriter)
    throws IOException
  {
    copy(paramReader, paramWriter, new char[4096]);
  }
  
  public static void copy(Reader paramReader, Writer paramWriter, char[] paramArrayOfChar)
    throws IOException
  {
    for (;;)
    {
      int i = paramReader.read(paramArrayOfChar);
      if (-1 == i) {
        break;
      }
      paramWriter.write(paramArrayOfChar, 0, i);
    }
  }
  
  public static String toString(InputStream paramInputStream, String paramString)
    throws UnsupportedEncodingException, IOException
  {
    StringWriter localStringWriter = new StringWriter();
    copy(new InputStreamReader(paramInputStream, paramString), localStringWriter);
    return localStringWriter.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.agconnect.config.impl.Utils
 * JD-Core Version:    0.7.0.1
 */