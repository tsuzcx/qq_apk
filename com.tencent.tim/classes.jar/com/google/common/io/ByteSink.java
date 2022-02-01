package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

@GwtIncompatible
public abstract class ByteSink
{
  public CharSink asCharSink(Charset paramCharset)
  {
    return new AsCharSink(paramCharset, null);
  }
  
  public OutputStream openBufferedStream()
    throws IOException
  {
    OutputStream localOutputStream = openStream();
    if ((localOutputStream instanceof BufferedOutputStream)) {
      return (BufferedOutputStream)localOutputStream;
    }
    return new BufferedOutputStream(localOutputStream);
  }
  
  public abstract OutputStream openStream()
    throws IOException;
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    Preconditions.checkNotNull(paramArrayOfByte);
    Closer localCloser = Closer.create();
    try
    {
      OutputStream localOutputStream = (OutputStream)localCloser.register(openStream());
      localOutputStream.write(paramArrayOfByte);
      localOutputStream.flush();
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      throw localCloser.rethrow(paramArrayOfByte);
    }
    finally
    {
      localCloser.close();
    }
  }
  
  @CanIgnoreReturnValue
  public long writeFrom(InputStream paramInputStream)
    throws IOException
  {
    Preconditions.checkNotNull(paramInputStream);
    Closer localCloser = Closer.create();
    try
    {
      OutputStream localOutputStream = (OutputStream)localCloser.register(openStream());
      long l = ByteStreams.copy(paramInputStream, localOutputStream);
      localOutputStream.flush();
      return l;
    }
    catch (Throwable paramInputStream)
    {
      throw localCloser.rethrow(paramInputStream);
    }
    finally
    {
      localCloser.close();
    }
  }
  
  final class AsCharSink
    extends CharSink
  {
    private final Charset charset;
    
    private AsCharSink(Charset paramCharset)
    {
      this.charset = ((Charset)Preconditions.checkNotNull(paramCharset));
    }
    
    public Writer openStream()
      throws IOException
    {
      return new OutputStreamWriter(ByteSink.this.openStream(), this.charset);
    }
    
    public String toString()
    {
      return ByteSink.this.toString() + ".asCharSink(" + this.charset + ")";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.ByteSink
 * JD-Core Version:    0.7.0.1
 */