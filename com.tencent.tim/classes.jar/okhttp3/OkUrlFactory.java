package okhttp3;

import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import okhttp3.internal.URLFilter;
import okhttp3.internal.annotations.EverythingIsNonNull;
import okhttp3.internal.huc.OkHttpURLConnection;
import okhttp3.internal.huc.OkHttpsURLConnection;

@EverythingIsNonNull
public final class OkUrlFactory
  implements Cloneable, URLStreamHandlerFactory
{
  private OkHttpClient client;
  private URLFilter urlFilter;
  
  public OkUrlFactory(OkHttpClient paramOkHttpClient)
  {
    this.client = paramOkHttpClient;
  }
  
  public OkHttpClient client()
  {
    return this.client;
  }
  
  public OkUrlFactory clone()
  {
    return new OkUrlFactory(this.client);
  }
  
  public URLStreamHandler createURLStreamHandler(String paramString)
  {
    if ((!paramString.equals("http")) && (!paramString.equals("https"))) {
      return null;
    }
    return new OkUrlFactory.1(this, paramString);
  }
  
  public HttpURLConnection open(URL paramURL)
  {
    return open(paramURL, this.client.proxy());
  }
  
  HttpURLConnection open(URL paramURL, Proxy paramProxy)
  {
    String str = paramURL.getProtocol();
    paramProxy = this.client.newBuilder().proxy(paramProxy).build();
    if (str.equals("http")) {
      return new OkHttpURLConnection(paramURL, paramProxy, this.urlFilter);
    }
    if (str.equals("https")) {
      return new OkHttpsURLConnection(paramURL, paramProxy, this.urlFilter);
    }
    throw new IllegalArgumentException("Unexpected protocol: " + str);
  }
  
  public OkUrlFactory setClient(OkHttpClient paramOkHttpClient)
  {
    this.client = paramOkHttpClient;
    return this;
  }
  
  void setUrlFilter(URLFilter paramURLFilter)
  {
    this.urlFilter = paramURLFilter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.OkUrlFactory
 * JD-Core Version:    0.7.0.1
 */