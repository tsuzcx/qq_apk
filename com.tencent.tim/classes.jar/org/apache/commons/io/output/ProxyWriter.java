package org.apache.commons.io.output;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class ProxyWriter
  extends FilterWriter
{
  public ProxyWriter(Writer paramWriter)
  {
    super(paramWriter);
  }
  
  protected void afterWrite(int paramInt)
    throws IOException
  {}
  
  public Writer append(char paramChar)
    throws IOException
  {
    try
    {
      beforeWrite(1);
      this.out.append(paramChar);
      afterWrite(1);
      return this;
    }
    catch (IOException localIOException)
    {
      handleIOException(localIOException);
    }
    return this;
  }
  
  public Writer append(CharSequence paramCharSequence)
    throws IOException
  {
    int i = 0;
    if (paramCharSequence != null) {}
    try
    {
      i = paramCharSequence.length();
      beforeWrite(i);
      this.out.append(paramCharSequence);
      afterWrite(i);
      return this;
    }
    catch (IOException paramCharSequence)
    {
      handleIOException(paramCharSequence);
    }
    return this;
  }
  
  public Writer append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      beforeWrite(paramInt2 - paramInt1);
      this.out.append(paramCharSequence, paramInt1, paramInt2);
      afterWrite(paramInt2 - paramInt1);
      return this;
    }
    catch (IOException paramCharSequence)
    {
      handleIOException(paramCharSequence);
    }
    return this;
  }
  
  protected void beforeWrite(int paramInt)
    throws IOException
  {}
  
  public void close()
    throws IOException
  {
    try
    {
      this.out.close();
      return;
    }
    catch (IOException localIOException)
    {
      handleIOException(localIOException);
    }
  }
  
  public void flush()
    throws IOException
  {
    try
    {
      this.out.flush();
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
  
  public void write(int paramInt)
    throws IOException
  {
    try
    {
      beforeWrite(1);
      this.out.write(paramInt);
      afterWrite(1);
      return;
    }
    catch (IOException localIOException)
    {
      handleIOException(localIOException);
    }
  }
  
  public void write(String paramString)
    throws IOException
  {
    int i = 0;
    if (paramString != null) {}
    try
    {
      i = paramString.length();
      beforeWrite(i);
      this.out.write(paramString);
      afterWrite(i);
      return;
    }
    catch (IOException paramString)
    {
      handleIOException(paramString);
    }
  }
  
  public void write(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      beforeWrite(paramInt2);
      this.out.write(paramString, paramInt1, paramInt2);
      afterWrite(paramInt2);
      return;
    }
    catch (IOException paramString)
    {
      handleIOException(paramString);
    }
  }
  
  public void write(char[] paramArrayOfChar)
    throws IOException
  {
    int i = 0;
    if (paramArrayOfChar != null) {}
    try
    {
      i = paramArrayOfChar.length;
      beforeWrite(i);
      this.out.write(paramArrayOfChar);
      afterWrite(i);
      return;
    }
    catch (IOException paramArrayOfChar)
    {
      handleIOException(paramArrayOfChar);
    }
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      beforeWrite(paramInt2);
      this.out.write(paramArrayOfChar, paramInt1, paramInt2);
      afterWrite(paramInt2);
      return;
    }
    catch (IOException paramArrayOfChar)
    {
      handleIOException(paramArrayOfChar);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.output.ProxyWriter
 * JD-Core Version:    0.7.0.1
 */