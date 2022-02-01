package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

@Beta
@GwtIncompatible
public final class Resources
{
  public static ByteSource asByteSource(URL paramURL)
  {
    return new UrlByteSource(paramURL, null);
  }
  
  public static CharSource asCharSource(URL paramURL, Charset paramCharset)
  {
    return asByteSource(paramURL).asCharSource(paramCharset);
  }
  
  public static void copy(URL paramURL, OutputStream paramOutputStream)
    throws IOException
  {
    asByteSource(paramURL).copyTo(paramOutputStream);
  }
  
  public static URL getResource(Class<?> paramClass, String paramString)
  {
    URL localURL = paramClass.getResource(paramString);
    if (localURL != null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "resource %s relative to %s not found.", paramString, paramClass.getName());
      return localURL;
    }
  }
  
  @CanIgnoreReturnValue
  public static URL getResource(String paramString)
  {
    URL localURL = ((ClassLoader)MoreObjects.firstNonNull(Thread.currentThread().getContextClassLoader(), Resources.class.getClassLoader())).getResource(paramString);
    if (localURL != null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "resource %s not found.", paramString);
      return localURL;
    }
  }
  
  @CanIgnoreReturnValue
  public static <T> T readLines(URL paramURL, Charset paramCharset, LineProcessor<T> paramLineProcessor)
    throws IOException
  {
    return asCharSource(paramURL, paramCharset).readLines(paramLineProcessor);
  }
  
  public static List<String> readLines(URL paramURL, Charset paramCharset)
    throws IOException
  {
    return (List)readLines(paramURL, paramCharset, new Resources.1());
  }
  
  public static byte[] toByteArray(URL paramURL)
    throws IOException
  {
    return asByteSource(paramURL).read();
  }
  
  public static String toString(URL paramURL, Charset paramCharset)
    throws IOException
  {
    return asCharSource(paramURL, paramCharset).read();
  }
  
  static final class UrlByteSource
    extends ByteSource
  {
    private final URL url;
    
    private UrlByteSource(URL paramURL)
    {
      this.url = ((URL)Preconditions.checkNotNull(paramURL));
    }
    
    public InputStream openStream()
      throws IOException
    {
      return this.url.openStream();
    }
    
    public String toString()
    {
      return "Resources.asByteSource(" + this.url + ")";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.Resources
 * JD-Core Version:    0.7.0.1
 */