package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okio.GzipSource;
import okio.Okio;
import okio.Source;

public final class BridgeInterceptor
  implements Interceptor
{
  private final CookieJar cookieJar;
  
  public BridgeInterceptor(CookieJar paramCookieJar)
  {
    this.cookieJar = paramCookieJar;
  }
  
  private String cookieHeader(List<Cookie> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      if (i > 0) {
        localStringBuilder.append("; ");
      }
      Cookie localCookie = (Cookie)paramList.get(i);
      localStringBuilder.append(localCookie.name()).append('=').append(localCookie.value());
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    int j = 0;
    Object localObject1 = paramChain.request();
    Object localObject2 = ((Request)localObject1).newBuilder();
    Object localObject3 = ((Request)localObject1).body();
    if (localObject3 != null)
    {
      MediaType localMediaType = ((RequestBody)localObject3).contentType();
      if (localMediaType != null) {
        ((Request.Builder)localObject2).header("Content-Type", localMediaType.toString());
      }
      long l = ((RequestBody)localObject3).contentLength();
      if (l == -1L) {
        break label374;
      }
      ((Request.Builder)localObject2).header("Content-Length", Long.toString(l));
      ((Request.Builder)localObject2).removeHeader("Transfer-Encoding");
    }
    for (;;)
    {
      if (((Request)localObject1).header("Host") == null) {
        ((Request.Builder)localObject2).header("Host", Util.hostHeader(((Request)localObject1).url(), false));
      }
      if (((Request)localObject1).header("Connection") == null) {
        ((Request.Builder)localObject2).header("Connection", "Keep-Alive");
      }
      int i = j;
      if (((Request)localObject1).header("Accept-Encoding") == null)
      {
        i = j;
        if (((Request)localObject1).header("Range") == null)
        {
          i = 1;
          ((Request.Builder)localObject2).header("Accept-Encoding", "gzip");
        }
      }
      localObject3 = this.cookieJar.loadForRequest(((Request)localObject1).url());
      if (!((List)localObject3).isEmpty()) {
        ((Request.Builder)localObject2).header("Cookie", cookieHeader((List)localObject3));
      }
      if (((Request)localObject1).header("User-Agent") == null) {
        ((Request.Builder)localObject2).header("User-Agent", Version.userAgent());
      }
      paramChain = paramChain.proceed(((Request.Builder)localObject2).build());
      HttpHeaders.receiveHeaders(this.cookieJar, ((Request)localObject1).url(), paramChain.headers());
      localObject1 = paramChain.newBuilder().request((Request)localObject1);
      if ((i != 0) && ("gzip".equalsIgnoreCase(paramChain.header("Content-Encoding"))) && (HttpHeaders.hasBody(paramChain)))
      {
        localObject2 = new GzipSource(paramChain.body().source());
        ((Response.Builder)localObject1).headers(paramChain.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build());
        ((Response.Builder)localObject1).body(new RealResponseBody(paramChain.header("Content-Type"), -1L, Okio.buffer((Source)localObject2)));
      }
      return ((Response.Builder)localObject1).build();
      label374:
      ((Request.Builder)localObject2).header("Transfer-Encoding", "chunked");
      ((Request.Builder)localObject2).removeHeader("Content-Length");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.internal.http.BridgeInterceptor
 * JD-Core Version:    0.7.0.1
 */