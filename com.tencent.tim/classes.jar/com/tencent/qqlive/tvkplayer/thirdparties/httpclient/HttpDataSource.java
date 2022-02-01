package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

import android.support.annotation.Nullable;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract interface HttpDataSource
  extends DataSource
{
  public abstract void clearAllRequestProperties();
  
  public abstract void clearRequestProperty(String paramString);
  
  public abstract void close()
    throws HttpDataSource.HttpDataSourceException;
  
  public abstract Map<String, List<String>> getResponseHeaders();
  
  public abstract long open(DataSpec paramDataSpec)
    throws HttpDataSource.HttpDataSourceException;
  
  public abstract int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws HttpDataSource.HttpDataSourceException;
  
  public abstract void setRequestProperty(String paramString1, String paramString2);
  
  public static abstract class BaseFactory
    implements HttpDataSource.Factory
  {
    private final HttpDataSource.RequestProperties defaultRequestProperties = new HttpDataSource.RequestProperties();
    
    @Deprecated
    public final void clearAllDefaultRequestProperties()
    {
      this.defaultRequestProperties.clear();
    }
    
    @Deprecated
    public final void clearDefaultRequestProperty(String paramString)
    {
      this.defaultRequestProperties.remove(paramString);
    }
    
    public final HttpDataSource createDataSource()
    {
      return createDataSourceInternal(this.defaultRequestProperties);
    }
    
    public final HttpDataSource createDataSource(int paramInt)
    {
      return createDataSourceInternal(paramInt, this.defaultRequestProperties);
    }
    
    protected abstract HttpDataSource createDataSourceInternal(int paramInt, HttpDataSource.RequestProperties paramRequestProperties);
    
    protected abstract HttpDataSource createDataSourceInternal(HttpDataSource.RequestProperties paramRequestProperties);
    
    public final HttpDataSource.RequestProperties getDefaultRequestProperties()
    {
      return this.defaultRequestProperties;
    }
    
    @Deprecated
    public final void setDefaultRequestProperty(String paramString1, String paramString2)
    {
      this.defaultRequestProperties.set(paramString1, paramString2);
    }
  }
  
  public static abstract interface Factory
    extends DataSource.Factory
  {
    @Deprecated
    public abstract void clearAllDefaultRequestProperties();
    
    @Deprecated
    public abstract void clearDefaultRequestProperty(String paramString);
    
    public abstract HttpDataSource createDataSource();
    
    public abstract HttpDataSource createDataSource(int paramInt);
    
    public abstract HttpDataSource.RequestProperties getDefaultRequestProperties();
    
    @Deprecated
    public abstract void setDefaultRequestProperty(String paramString1, String paramString2);
  }
  
  public static class HttpDataSourceException
    extends IOException
  {
    public static final int TYPE_CLOSE = 3;
    public static final int TYPE_OPEN = 1;
    public static final int TYPE_READ = 2;
    public final DataSpec dataSpec;
    public final int type;
    
    public HttpDataSourceException(DataSpec paramDataSpec, int paramInt)
    {
      this.dataSpec = paramDataSpec;
      this.type = paramInt;
    }
    
    public HttpDataSourceException(IOException paramIOException, DataSpec paramDataSpec, int paramInt)
    {
      super();
      this.dataSpec = paramDataSpec;
      this.type = paramInt;
    }
    
    public HttpDataSourceException(String paramString, DataSpec paramDataSpec, int paramInt)
    {
      super();
      this.dataSpec = paramDataSpec;
      this.type = paramInt;
    }
    
    public HttpDataSourceException(String paramString, IOException paramIOException, DataSpec paramDataSpec, int paramInt)
    {
      super(paramIOException);
      this.dataSpec = paramDataSpec;
      this.type = paramInt;
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public static @interface Type {}
  }
  
  public static final class InvalidContentTypeException
    extends HttpDataSource.HttpDataSourceException
  {
    public final String contentType;
    
    public InvalidContentTypeException(String paramString, DataSpec paramDataSpec)
    {
      super(paramDataSpec, 1);
      this.contentType = paramString;
    }
  }
  
  public static final class InvalidResponseCodeException
    extends HttpDataSource.HttpDataSourceException
  {
    public final Map<String, List<String>> headerFields;
    public final int responseCode;
    @Nullable
    public final String responseMessage;
    
    public InvalidResponseCodeException(int paramInt, @Nullable String paramString, Map<String, List<String>> paramMap, DataSpec paramDataSpec)
    {
      super(paramDataSpec, 1);
      this.responseCode = paramInt;
      this.responseMessage = paramString;
      this.headerFields = paramMap;
    }
  }
  
  public static final class RequestProperties
  {
    private final Map<String, String> requestProperties = new HashMap();
    private Map<String, String> requestPropertiesSnapshot;
    
    public void clear()
    {
      try
      {
        this.requestPropertiesSnapshot = null;
        this.requestProperties.clear();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void clearAndSet(Map<String, String> paramMap)
    {
      try
      {
        this.requestPropertiesSnapshot = null;
        this.requestProperties.clear();
        this.requestProperties.putAll(paramMap);
        return;
      }
      finally
      {
        paramMap = finally;
        throw paramMap;
      }
    }
    
    public Map<String, String> getSnapshot()
    {
      try
      {
        if (this.requestPropertiesSnapshot == null) {
          this.requestPropertiesSnapshot = Collections.unmodifiableMap(new HashMap(this.requestProperties));
        }
        Map localMap = this.requestPropertiesSnapshot;
        return localMap;
      }
      finally {}
    }
    
    public void remove(String paramString)
    {
      try
      {
        this.requestPropertiesSnapshot = null;
        this.requestProperties.remove(paramString);
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
    
    public void set(String paramString1, String paramString2)
    {
      try
      {
        this.requestPropertiesSnapshot = null;
        this.requestProperties.put(paramString1, paramString2);
        return;
      }
      finally
      {
        paramString1 = finally;
        throw paramString1;
      }
    }
    
    public void set(Map<String, String> paramMap)
    {
      try
      {
        this.requestPropertiesSnapshot = null;
        this.requestProperties.putAll(paramMap);
        return;
      }
      finally
      {
        paramMap = finally;
        throw paramMap;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.HttpDataSource
 * JD-Core Version:    0.7.0.1
 */