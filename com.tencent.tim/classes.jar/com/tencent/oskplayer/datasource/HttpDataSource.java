package com.tencent.oskplayer.datasource;

import com.tencent.oskplayer.util.Predicate;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract interface HttpDataSource
  extends UriDataSource
{
  public abstract void clearAllRequestProperties();
  
  public abstract void clearRequestProperty(String paramString);
  
  public abstract void close()
    throws HttpDataSource.HttpDataSourceException;
  
  public abstract long getContentLength();
  
  public abstract Predicate<String> getContentPredicator();
  
  public abstract Map<String, List<String>> getResponseHeaders();
  
  public abstract long getTotalLength();
  
  public abstract long open(DataSpec paramDataSpec)
    throws HttpDataSource.HttpDataSourceException;
  
  public abstract int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws HttpDataSource.HttpDataSourceException;
  
  public abstract void setRequestProperty(String paramString1, String paramString2);
  
  public static class HttpDataSourceException
    extends IOException
  {
    public final DataSpec dataSpec;
    
    public HttpDataSourceException(DataSpec paramDataSpec)
    {
      this.dataSpec = paramDataSpec;
    }
    
    public HttpDataSourceException(IOException paramIOException, DataSpec paramDataSpec)
    {
      super();
      this.dataSpec = paramDataSpec;
    }
    
    public HttpDataSourceException(String paramString, DataSpec paramDataSpec)
    {
      super();
      this.dataSpec = paramDataSpec;
    }
    
    public HttpDataSourceException(String paramString, IOException paramIOException, DataSpec paramDataSpec)
    {
      super(paramIOException);
      this.dataSpec = paramDataSpec;
    }
  }
  
  public static final class InterruptConnectServerException
    extends HttpDataSource.HttpDataSourceException
  {
    public InterruptConnectServerException(String paramString, DataSpec paramDataSpec)
    {
      super(paramDataSpec);
    }
    
    public InterruptConnectServerException(String paramString, IOException paramIOException, DataSpec paramDataSpec)
    {
      super(paramIOException, paramDataSpec);
    }
  }
  
  public static final class InterruptReadException
    extends HttpDataSource.HttpDataSourceException
  {
    public InterruptReadException(String paramString, DataSpec paramDataSpec)
    {
      super(paramDataSpec);
    }
  }
  
  public static final class InvalidContentException
    extends HttpDataSource.HttpDataSourceException
  {
    public InvalidContentException(String paramString, DataSpec paramDataSpec)
    {
      super(paramDataSpec);
    }
  }
  
  public static final class InvalidContentTypeException
    extends HttpDataSource.HttpDataSourceException
  {
    public final String contentType;
    public final Map<String, List<String>> headerFields;
    
    public InvalidContentTypeException(String paramString, Map<String, List<String>> paramMap, DataSpec paramDataSpec)
    {
      super(paramDataSpec);
      this.contentType = paramString;
      this.headerFields = paramMap;
    }
  }
  
  public static final class InvalidResponseCodeException
    extends HttpDataSource.HttpDataSourceException
  {
    public final Map<String, List<String>> headerFields;
    public final int responseCode;
    
    public InvalidResponseCodeException(int paramInt, Map<String, List<String>> paramMap, DataSpec paramDataSpec)
    {
      super(paramDataSpec);
      this.responseCode = paramInt;
      this.headerFields = paramMap;
    }
  }
  
  public static final class MalformedResponseException
    extends HttpDataSource.HttpDataSourceException
  {
    public MalformedResponseException(String paramString, DataSpec paramDataSpec)
    {
      super(paramDataSpec);
    }
  }
  
  public static final class UnableConnectServerException
    extends HttpDataSource.HttpDataSourceException
  {
    public UnableConnectServerException(String paramString, IOException paramIOException, DataSpec paramDataSpec)
    {
      super(paramIOException, paramDataSpec);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.HttpDataSource
 * JD-Core Version:    0.7.0.1
 */