package okhttp3.internal.http;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.CertificatePinner;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.connection.StreamAllocation;

public final class RetryAndFollowUpInterceptor
  implements Interceptor
{
  private static final int MAX_FOLLOW_UPS = 20;
  private Object callStackTrace;
  private volatile boolean canceled;
  private final OkHttpClient client;
  private final boolean forWebSocket;
  private volatile StreamAllocation streamAllocation;
  
  public RetryAndFollowUpInterceptor(OkHttpClient paramOkHttpClient, boolean paramBoolean)
  {
    this.client = paramOkHttpClient;
    this.forWebSocket = paramBoolean;
  }
  
  private Address createAddress(HttpUrl paramHttpUrl)
  {
    CertificatePinner localCertificatePinner = null;
    SSLSocketFactory localSSLSocketFactory;
    HostnameVerifier localHostnameVerifier;
    if (paramHttpUrl.isHttps())
    {
      localSSLSocketFactory = this.client.sslSocketFactory();
      localHostnameVerifier = this.client.hostnameVerifier();
      localCertificatePinner = this.client.certificatePinner();
    }
    for (;;)
    {
      return new Address(paramHttpUrl.host(), paramHttpUrl.port(), this.client.dns(), this.client.socketFactory(), localSSLSocketFactory, localHostnameVerifier, localCertificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
      localHostnameVerifier = null;
      localSSLSocketFactory = null;
    }
  }
  
  private Request followUpRequest(Response paramResponse, Route paramRoute)
    throws IOException
  {
    Object localObject = null;
    if (paramResponse == null) {
      throw new IllegalStateException();
    }
    int i = paramResponse.code();
    String str = paramResponse.request().method();
    switch (i)
    {
    }
    label364:
    do
    {
      do
      {
        HttpUrl localHttpUrl;
        do
        {
          do
          {
            do
            {
              return null;
              if (paramRoute.proxy().type() != Proxy.Type.HTTP) {
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
              }
              return this.client.proxyAuthenticator().authenticate(paramRoute, paramResponse);
              return this.client.authenticator().authenticate(paramRoute, paramResponse);
            } while (((!str.equals("GET")) && (!str.equals("HEAD"))) || (!this.client.followRedirects()));
            paramRoute = paramResponse.header("Location");
          } while (paramRoute == null);
          localHttpUrl = paramResponse.request().url().resolve(paramRoute);
        } while ((localHttpUrl == null) || ((!localHttpUrl.scheme().equals(paramResponse.request().url().scheme())) && (!this.client.followSslRedirects())));
        Request.Builder localBuilder = paramResponse.request().newBuilder();
        boolean bool;
        if (HttpMethod.permitsRequestBody(str))
        {
          bool = HttpMethod.redirectsWithBody(str);
          if (!HttpMethod.redirectsToGet(str)) {
            break label364;
          }
          localBuilder.method("GET", null);
        }
        for (;;)
        {
          if (!bool)
          {
            localBuilder.removeHeader("Transfer-Encoding");
            localBuilder.removeHeader("Content-Length");
            localBuilder.removeHeader("Content-Type");
          }
          if (!sameConnection(paramResponse, localHttpUrl)) {
            localBuilder.removeHeader("Authorization");
          }
          return localBuilder.url(localHttpUrl).build();
          paramRoute = localObject;
          if (bool) {
            paramRoute = paramResponse.request().body();
          }
          localBuilder.method(str, paramRoute);
        }
      } while ((!this.client.retryOnConnectionFailure()) || ((paramResponse.request().body() instanceof UnrepeatableRequestBody)) || ((paramResponse.priorResponse() != null) && (paramResponse.priorResponse().code() == 408)) || (retryAfter(paramResponse, 0) > 0));
      return paramResponse.request();
    } while (((paramResponse.priorResponse() != null) && (paramResponse.priorResponse().code() == 503)) || (retryAfter(paramResponse, 2147483647) != 0));
    return paramResponse.request();
  }
  
  private boolean isRecoverable(IOException paramIOException, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramIOException instanceof ProtocolException)) {}
    do
    {
      return false;
      if ((paramIOException instanceof InterruptedIOException))
      {
        if (((paramIOException instanceof SocketTimeoutException)) && (!paramBoolean)) {}
        for (paramBoolean = bool;; paramBoolean = false) {
          return paramBoolean;
        }
      }
    } while ((((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException))) || ((paramIOException instanceof SSLPeerUnverifiedException)));
    return true;
  }
  
  private boolean recover(IOException paramIOException, StreamAllocation paramStreamAllocation, boolean paramBoolean, Request paramRequest)
  {
    paramStreamAllocation.streamFailed(paramIOException);
    if (!this.client.retryOnConnectionFailure()) {}
    while (((paramBoolean) && (requestIsUnrepeatable(paramIOException, paramRequest))) || (!isRecoverable(paramIOException, paramBoolean)) || (!paramStreamAllocation.hasMoreRoutes())) {
      return false;
    }
    return true;
  }
  
  private boolean requestIsUnrepeatable(IOException paramIOException, Request paramRequest)
  {
    return ((paramRequest.body() instanceof UnrepeatableRequestBody)) || ((paramIOException instanceof FileNotFoundException));
  }
  
  private int retryAfter(Response paramResponse, int paramInt)
  {
    paramResponse = paramResponse.header("Retry-After");
    if (paramResponse == null) {
      return paramInt;
    }
    if (paramResponse.matches("\\d+")) {
      return Integer.valueOf(paramResponse).intValue();
    }
    return 2147483647;
  }
  
  private boolean sameConnection(Response paramResponse, HttpUrl paramHttpUrl)
  {
    paramResponse = paramResponse.request().url();
    return (paramResponse.host().equals(paramHttpUrl.host())) && (paramResponse.port() == paramHttpUrl.port()) && (paramResponse.scheme().equals(paramHttpUrl.scheme()));
  }
  
  public void cancel()
  {
    this.canceled = true;
    StreamAllocation localStreamAllocation = this.streamAllocation;
    if (localStreamAllocation != null) {
      localStreamAllocation.cancel();
    }
  }
  
  /* Error */
  public Response intercept(okhttp3.Interceptor.Chain paramChain)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 302 1 0
    //   6: astore 4
    //   8: aload_1
    //   9: checkcast 304	okhttp3/internal/http/RealInterceptorChain
    //   12: astore 7
    //   14: aload 7
    //   16: invokevirtual 308	okhttp3/internal/http/RealInterceptorChain:call	()Lokhttp3/Call;
    //   19: astore 8
    //   21: aload 7
    //   23: invokevirtual 312	okhttp3/internal/http/RealInterceptorChain:eventListener	()Lokhttp3/EventListener;
    //   26: astore 9
    //   28: new 257	okhttp3/internal/connection/StreamAllocation
    //   31: dup
    //   32: aload_0
    //   33: getfield 25	okhttp3/internal/http/RetryAndFollowUpInterceptor:client	Lokhttp3/OkHttpClient;
    //   36: invokevirtual 316	okhttp3/OkHttpClient:connectionPool	()Lokhttp3/ConnectionPool;
    //   39: aload_0
    //   40: aload 4
    //   42: invokevirtual 165	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   45: invokespecial 318	okhttp3/internal/http/RetryAndFollowUpInterceptor:createAddress	(Lokhttp3/HttpUrl;)Lokhttp3/Address;
    //   48: aload 8
    //   50: aload 9
    //   52: aload_0
    //   53: getfield 320	okhttp3/internal/http/RetryAndFollowUpInterceptor:callStackTrace	Ljava/lang/Object;
    //   56: invokespecial 323	okhttp3/internal/connection/StreamAllocation:<init>	(Lokhttp3/ConnectionPool;Lokhttp3/Address;Lokhttp3/Call;Lokhttp3/EventListener;Ljava/lang/Object;)V
    //   59: astore_1
    //   60: aload_0
    //   61: aload_1
    //   62: putfield 293	okhttp3/internal/http/RetryAndFollowUpInterceptor:streamAllocation	Lokhttp3/internal/connection/StreamAllocation;
    //   65: iconst_0
    //   66: istore_2
    //   67: aconst_null
    //   68: astore 5
    //   70: aload_0
    //   71: getfield 291	okhttp3/internal/http/RetryAndFollowUpInterceptor:canceled	Z
    //   74: ifeq +18 -> 92
    //   77: aload_1
    //   78: invokevirtual 326	okhttp3/internal/connection/StreamAllocation:release	()V
    //   81: new 94	java/io/IOException
    //   84: dup
    //   85: ldc_w 328
    //   88: invokespecial 329	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   91: athrow
    //   92: aload 7
    //   94: aload 4
    //   96: aload_1
    //   97: aconst_null
    //   98: aconst_null
    //   99: invokevirtual 333	okhttp3/internal/http/RealInterceptorChain:proceed	(Lokhttp3/Request;Lokhttp3/internal/connection/StreamAllocation;Lokhttp3/internal/http/HttpCodec;Lokhttp3/internal/connection/RealConnection;)Lokhttp3/Response;
    //   102: astore 6
    //   104: aload 6
    //   106: astore 4
    //   108: aload 5
    //   110: ifnull +28 -> 138
    //   113: aload 6
    //   115: invokevirtual 336	okhttp3/Response:newBuilder	()Lokhttp3/Response$Builder;
    //   118: aload 5
    //   120: invokevirtual 336	okhttp3/Response:newBuilder	()Lokhttp3/Response$Builder;
    //   123: aconst_null
    //   124: invokevirtual 341	okhttp3/Response$Builder:body	(Lokhttp3/ResponseBody;)Lokhttp3/Response$Builder;
    //   127: invokevirtual 343	okhttp3/Response$Builder:build	()Lokhttp3/Response;
    //   130: invokevirtual 346	okhttp3/Response$Builder:priorResponse	(Lokhttp3/Response;)Lokhttp3/Response$Builder;
    //   133: invokevirtual 343	okhttp3/Response$Builder:build	()Lokhttp3/Response;
    //   136: astore 4
    //   138: aload_0
    //   139: aload 4
    //   141: aload_1
    //   142: invokevirtual 350	okhttp3/internal/connection/StreamAllocation:route	()Lokhttp3/Route;
    //   145: invokespecial 352	okhttp3/internal/http/RetryAndFollowUpInterceptor:followUpRequest	(Lokhttp3/Response;Lokhttp3/Route;)Lokhttp3/Request;
    //   148: astore 6
    //   150: aload 6
    //   152: ifnonnull +90 -> 242
    //   155: aload_1
    //   156: invokevirtual 326	okhttp3/internal/connection/StreamAllocation:release	()V
    //   159: aload 4
    //   161: areturn
    //   162: astore 6
    //   164: aload_0
    //   165: aload 6
    //   167: invokevirtual 356	okhttp3/internal/connection/RouteException:getLastConnectException	()Ljava/io/IOException;
    //   170: aload_1
    //   171: iconst_0
    //   172: aload 4
    //   174: invokespecial 358	okhttp3/internal/http/RetryAndFollowUpInterceptor:recover	(Ljava/io/IOException;Lokhttp3/internal/connection/StreamAllocation;ZLokhttp3/Request;)Z
    //   177: ifne -107 -> 70
    //   180: aload 6
    //   182: invokevirtual 361	okhttp3/internal/connection/RouteException:getFirstConnectException	()Ljava/io/IOException;
    //   185: athrow
    //   186: astore 4
    //   188: aload_1
    //   189: aconst_null
    //   190: invokevirtual 261	okhttp3/internal/connection/StreamAllocation:streamFailed	(Ljava/io/IOException;)V
    //   193: aload_1
    //   194: invokevirtual 326	okhttp3/internal/connection/StreamAllocation:release	()V
    //   197: aload 4
    //   199: athrow
    //   200: astore 6
    //   202: aload 6
    //   204: instanceof 363
    //   207: ifne +21 -> 228
    //   210: iconst_1
    //   211: istore_3
    //   212: aload_0
    //   213: aload 6
    //   215: aload_1
    //   216: iload_3
    //   217: aload 4
    //   219: invokespecial 358	okhttp3/internal/http/RetryAndFollowUpInterceptor:recover	(Ljava/io/IOException;Lokhttp3/internal/connection/StreamAllocation;ZLokhttp3/Request;)Z
    //   222: ifne -152 -> 70
    //   225: aload 6
    //   227: athrow
    //   228: iconst_0
    //   229: istore_3
    //   230: goto -18 -> 212
    //   233: astore 4
    //   235: aload_1
    //   236: invokevirtual 326	okhttp3/internal/connection/StreamAllocation:release	()V
    //   239: aload 4
    //   241: athrow
    //   242: aload 4
    //   244: invokevirtual 366	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   247: invokestatic 372	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   250: iload_2
    //   251: iconst_1
    //   252: iadd
    //   253: istore_2
    //   254: iload_2
    //   255: bipush 20
    //   257: if_icmple +35 -> 292
    //   260: aload_1
    //   261: invokevirtual 326	okhttp3/internal/connection/StreamAllocation:release	()V
    //   264: new 128	java/net/ProtocolException
    //   267: dup
    //   268: new 374	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 375	java/lang/StringBuilder:<init>	()V
    //   275: ldc_w 377
    //   278: invokevirtual 381	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: iload_2
    //   282: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   285: invokevirtual 387	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokespecial 133	java/net/ProtocolException:<init>	(Ljava/lang/String;)V
    //   291: athrow
    //   292: aload 6
    //   294: invokevirtual 222	okhttp3/Request:body	()Lokhttp3/RequestBody;
    //   297: instanceof 227
    //   300: ifeq +23 -> 323
    //   303: aload_1
    //   304: invokevirtual 326	okhttp3/internal/connection/StreamAllocation:release	()V
    //   307: new 389	java/net/HttpRetryException
    //   310: dup
    //   311: ldc_w 391
    //   314: aload 4
    //   316: invokevirtual 102	okhttp3/Response:code	()I
    //   319: invokespecial 394	java/net/HttpRetryException:<init>	(Ljava/lang/String;I)V
    //   322: athrow
    //   323: aload_0
    //   324: aload 4
    //   326: aload 6
    //   328: invokevirtual 165	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   331: invokespecial 210	okhttp3/internal/http/RetryAndFollowUpInterceptor:sameConnection	(Lokhttp3/Response;Lokhttp3/HttpUrl;)Z
    //   334: ifne +55 -> 389
    //   337: aload_1
    //   338: invokevirtual 326	okhttp3/internal/connection/StreamAllocation:release	()V
    //   341: new 257	okhttp3/internal/connection/StreamAllocation
    //   344: dup
    //   345: aload_0
    //   346: getfield 25	okhttp3/internal/http/RetryAndFollowUpInterceptor:client	Lokhttp3/OkHttpClient;
    //   349: invokevirtual 316	okhttp3/OkHttpClient:connectionPool	()Lokhttp3/ConnectionPool;
    //   352: aload_0
    //   353: aload 6
    //   355: invokevirtual 165	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   358: invokespecial 318	okhttp3/internal/http/RetryAndFollowUpInterceptor:createAddress	(Lokhttp3/HttpUrl;)Lokhttp3/Address;
    //   361: aload 8
    //   363: aload 9
    //   365: aload_0
    //   366: getfield 320	okhttp3/internal/http/RetryAndFollowUpInterceptor:callStackTrace	Ljava/lang/Object;
    //   369: invokespecial 323	okhttp3/internal/connection/StreamAllocation:<init>	(Lokhttp3/ConnectionPool;Lokhttp3/Address;Lokhttp3/Call;Lokhttp3/EventListener;Ljava/lang/Object;)V
    //   372: astore_1
    //   373: aload_0
    //   374: aload_1
    //   375: putfield 293	okhttp3/internal/http/RetryAndFollowUpInterceptor:streamAllocation	Lokhttp3/internal/connection/StreamAllocation;
    //   378: aload 4
    //   380: astore 5
    //   382: aload 6
    //   384: astore 4
    //   386: goto -316 -> 70
    //   389: aload_1
    //   390: invokevirtual 398	okhttp3/internal/connection/StreamAllocation:codec	()Lokhttp3/internal/http/HttpCodec;
    //   393: ifnull +38 -> 431
    //   396: new 96	java/lang/IllegalStateException
    //   399: dup
    //   400: new 374	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 375	java/lang/StringBuilder:<init>	()V
    //   407: ldc_w 400
    //   410: invokevirtual 381	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: aload 4
    //   415: invokevirtual 403	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   418: ldc_w 405
    //   421: invokevirtual 381	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: invokevirtual 387	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokespecial 406	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   430: athrow
    //   431: goto -53 -> 378
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	this	RetryAndFollowUpInterceptor
    //   0	434	1	paramChain	okhttp3.Interceptor.Chain
    //   66	216	2	i	int
    //   211	19	3	bool	boolean
    //   6	167	4	localObject1	Object
    //   186	32	4	localRequest	Request
    //   233	146	4	localIOException1	IOException
    //   384	30	4	localObject2	Object
    //   68	313	5	localIOException2	IOException
    //   102	49	6	localObject3	Object
    //   162	19	6	localRouteException	okhttp3.internal.connection.RouteException
    //   200	183	6	localIOException3	IOException
    //   12	81	7	localRealInterceptorChain	RealInterceptorChain
    //   19	343	8	localCall	okhttp3.Call
    //   26	338	9	localEventListener	okhttp3.EventListener
    // Exception table:
    //   from	to	target	type
    //   92	104	162	okhttp3/internal/connection/RouteException
    //   92	104	186	finally
    //   164	186	186	finally
    //   202	210	186	finally
    //   212	228	186	finally
    //   92	104	200	java/io/IOException
    //   138	150	233	java/io/IOException
  }
  
  public boolean isCanceled()
  {
    return this.canceled;
  }
  
  public void setCallStackTrace(Object paramObject)
  {
    this.callStackTrace = paramObject;
  }
  
  public StreamAllocation streamAllocation()
  {
    return this.streamAllocation;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.internal.http.RetryAndFollowUpInterceptor
 * JD-Core Version:    0.7.0.1
 */