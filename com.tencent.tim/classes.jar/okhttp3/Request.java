package okhttp3;

import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

public final class Request
{
  @Nullable
  final RequestBody body;
  @Nullable
  private volatile CacheControl cacheControl;
  final Headers headers;
  final String method;
  final Map<Class<?>, Object> tags;
  final HttpUrl url;
  
  Request(Builder paramBuilder)
  {
    this.url = paramBuilder.url;
    this.method = paramBuilder.method;
    this.headers = paramBuilder.headers.build();
    this.body = paramBuilder.body;
    this.tags = Util.immutableMap(paramBuilder.tags);
  }
  
  @Nullable
  public RequestBody body()
  {
    return this.body;
  }
  
  public CacheControl cacheControl()
  {
    CacheControl localCacheControl = this.cacheControl;
    if (localCacheControl != null) {
      return localCacheControl;
    }
    localCacheControl = CacheControl.parse(this.headers);
    this.cacheControl = localCacheControl;
    return localCacheControl;
  }
  
  @Nullable
  public String header(String paramString)
  {
    return this.headers.get(paramString);
  }
  
  public List<String> headers(String paramString)
  {
    return this.headers.values(paramString);
  }
  
  public Headers headers()
  {
    return this.headers;
  }
  
  public boolean isHttps()
  {
    return this.url.isHttps();
  }
  
  public String method()
  {
    return this.method;
  }
  
  public Builder newBuilder()
  {
    return new Builder(this);
  }
  
  @Nullable
  public Object tag()
  {
    return tag(Object.class);
  }
  
  @Nullable
  public <T> T tag(Class<? extends T> paramClass)
  {
    return paramClass.cast(this.tags.get(paramClass));
  }
  
  public String toString()
  {
    return "Request{method=" + this.method + ", url=" + this.url + ", tags=" + this.tags + '}';
  }
  
  public HttpUrl url()
  {
    return this.url;
  }
  
  public static class Builder
  {
    @Nullable
    RequestBody body;
    Headers.Builder headers;
    String method;
    Map<Class<?>, Object> tags = Collections.emptyMap();
    @Nullable
    HttpUrl url;
    
    public Builder()
    {
      this.method = "GET";
      this.headers = new Headers.Builder();
    }
    
    Builder(Request paramRequest)
    {
      this.url = paramRequest.url;
      this.method = paramRequest.method;
      this.body = paramRequest.body;
      if (paramRequest.tags.isEmpty()) {}
      for (Object localObject = Collections.emptyMap();; localObject = new LinkedHashMap(paramRequest.tags))
      {
        this.tags = ((Map)localObject);
        this.headers = paramRequest.headers.newBuilder();
        return;
      }
    }
    
    public Builder addHeader(String paramString1, String paramString2)
    {
      this.headers.add(paramString1, paramString2);
      return this;
    }
    
    public Request build()
    {
      if (this.url == null) {
        throw new IllegalStateException("url == null");
      }
      return new Request(this);
    }
    
    public Builder cacheControl(CacheControl paramCacheControl)
    {
      paramCacheControl = paramCacheControl.toString();
      if (paramCacheControl.isEmpty()) {
        return removeHeader("Cache-Control");
      }
      return header("Cache-Control", paramCacheControl);
    }
    
    public Builder delete()
    {
      return delete(Util.EMPTY_REQUEST);
    }
    
    public Builder delete(@Nullable RequestBody paramRequestBody)
    {
      return method("DELETE", paramRequestBody);
    }
    
    public Builder get()
    {
      return method("GET", null);
    }
    
    public Builder head()
    {
      return method("HEAD", null);
    }
    
    public Builder header(String paramString1, String paramString2)
    {
      this.headers.set(paramString1, paramString2);
      return this;
    }
    
    public Builder headers(Headers paramHeaders)
    {
      this.headers = paramHeaders.newBuilder();
      return this;
    }
    
    public Builder method(String paramString, @Nullable RequestBody paramRequestBody)
    {
      if (paramString == null) {
        throw new NullPointerException("method == null");
      }
      if (paramString.length() == 0) {
        throw new IllegalArgumentException("method.length() == 0");
      }
      if ((paramRequestBody != null) && (!HttpMethod.permitsRequestBody(paramString))) {
        throw new IllegalArgumentException("method " + paramString + " must not have a request body.");
      }
      if ((paramRequestBody == null) && (HttpMethod.requiresRequestBody(paramString))) {
        throw new IllegalArgumentException("method " + paramString + " must have a request body.");
      }
      this.method = paramString;
      this.body = paramRequestBody;
      return this;
    }
    
    public Builder patch(RequestBody paramRequestBody)
    {
      return method("PATCH", paramRequestBody);
    }
    
    public Builder post(RequestBody paramRequestBody)
    {
      return method("POST", paramRequestBody);
    }
    
    public Builder put(RequestBody paramRequestBody)
    {
      return method("PUT", paramRequestBody);
    }
    
    public Builder removeHeader(String paramString)
    {
      this.headers.removeAll(paramString);
      return this;
    }
    
    public <T> Builder tag(Class<? super T> paramClass, @Nullable T paramT)
    {
      if (paramClass == null) {
        throw new NullPointerException("type == null");
      }
      if (paramT == null)
      {
        this.tags.remove(paramClass);
        return this;
      }
      if (this.tags.isEmpty()) {
        this.tags = new LinkedHashMap();
      }
      this.tags.put(paramClass, paramClass.cast(paramT));
      return this;
    }
    
    public Builder tag(@Nullable Object paramObject)
    {
      return tag(Object.class, paramObject);
    }
    
    public Builder url(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException("url == null");
      }
      String str;
      if (paramString.regionMatches(true, 0, "ws:", 0, 3)) {
        str = "http:" + paramString.substring(3);
      }
      for (;;)
      {
        return url(HttpUrl.get(str));
        str = paramString;
        if (paramString.regionMatches(true, 0, "wss:", 0, 4)) {
          str = "https:" + paramString.substring(4);
        }
      }
    }
    
    public Builder url(URL paramURL)
    {
      if (paramURL == null) {
        throw new NullPointerException("url == null");
      }
      return url(HttpUrl.get(paramURL.toString()));
    }
    
    public Builder url(HttpUrl paramHttpUrl)
    {
      if (paramHttpUrl == null) {
        throw new NullPointerException("url == null");
      }
      this.url = paramHttpUrl;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.Request
 * JD-Core Version:    0.7.0.1
 */