package org.apache.commons.io.input;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

public abstract class ProxyReader
  extends FilterReader
{
  public ProxyReader(Reader paramReader)
  {
    super(paramReader);
  }
  
  protected void afterRead(int paramInt)
    throws IOException
  {}
  
  protected void beforeRead(int paramInt)
    throws IOException
  {}
  
  public void close()
    throws IOException
  {
    try
    {
      this.in.close();
      return;
    }
    catch (IOException localIOException)
    {
      handleIOException(localIOException);
    }
  }
  
  protected void handleIOException(IOException paramIOException)
    throws IOException
  {
    throw paramIOException;
  }
  
  public void mark(int paramInt)
    throws IOException
  {
    try
    {
      this.in.mark(paramInt);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        handleIOException(localIOException);
      }
    }
    finally {}
  }
  
  public boolean markSupported()
  {
    return this.in.markSupported();
  }
  
  public int read()
    throws IOException
  {
    int i = 1;
    try
    {
      beforeRead(1);
      int j = this.in.read();
      if (j != -1) {}
      for (;;)
      {
        afterRead(i);
        return j;
        i = -1;
      }
      return -1;
    }
    catch (IOException localIOException)
    {
      handleIOException(localIOException);
    }
  }
  
  public int read(CharBuffer paramCharBuffer)
    throws IOException
  {
    if (paramCharBuffer != null) {}
    for (;;)
    {
      try
      {
        i = paramCharBuffer.length();
        beforeRead(i);
        i = this.in.read(paramCharBuffer);
        afterRead(i);
        return i;
      }
      catch (IOException paramCharBuffer)
      {
        int i;
        handleIOException(paramCharBuffer);
      }
      i = 0;
    }
    return -1;
  }
  
  public int read(char[] paramArrayOfChar)
    throws IOException
  {
    if (paramArrayOfChar != null) {}
    for (;;)
    {
      try
      {
        i = paramArrayOfChar.length;
        beforeRead(i);
        i = this.in.read(paramArrayOfChar);
        afterRead(i);
        return i;
      }
      catch (IOException paramArrayOfChar)
      {
        int i;
        handleIOException(paramArrayOfChar);
      }
      i = 0;
    }
    return -1;
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      beforeRead(paramInt2);
      paramInt1 = this.in.read(paramArrayOfChar, paramInt1, paramInt2);
      afterRead(paramInt1);
      return paramInt1;
    }
    catch (IOException paramArrayOfChar)
    {
      handleIOException(paramArrayOfChar);
    }
    return -1;
  }
  
  public boolean ready()
    throws IOException
  {
    try
    {
      boolean bool = this.in.ready();
      return bool;
    }
    catch (IOException localIOException)
    {
      handleIOException(localIOException);
    }
    return false;
  }
  
  public void reset()
    throws IOException
  {
    try
    {
      this.in.reset();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        handleIOException(localIOException);
      }
    }
    finally {}
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    try
    {
      paramLong = this.in.skip(paramLong);
      return paramLong;
    }
    catch (IOException localIOException)
    {
      handleIOException(localIOException);
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.input.ProxyReader
 * JD-Core Version:    0.7.0.1
 */