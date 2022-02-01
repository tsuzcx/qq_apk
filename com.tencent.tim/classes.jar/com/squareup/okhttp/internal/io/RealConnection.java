package com.squareup.okhttp.internal.io;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.ConnectionSpecSelector;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import com.squareup.okhttp.internal.framed.FramedConnection;
import com.squareup.okhttp.internal.framed.FramedConnection.Builder;
import com.squareup.okhttp.internal.http.Http1xStream;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.RouteException;
import com.squareup.okhttp.internal.http.StreamAllocation;
import com.squareup.okhttp.internal.tls.TrustRootIndex;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.List;
import java.util.List<Lcom.squareup.okhttp.ConnectionSpec;>;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;

public final class RealConnection
  implements Connection
{
  private static SSLSocketFactory lastSslSocketFactory;
  private static TrustRootIndex lastTrustRootIndex;
  public final List<Reference<StreamAllocation>> allocations = new ArrayList();
  public volatile FramedConnection framedConnection;
  private Handshake handshake;
  public long idleAtNanos = 9223372036854775807L;
  public boolean noNewStreams;
  private Protocol protocol;
  private Socket rawSocket;
  private final Route route;
  public BufferedSink sink;
  public Socket socket;
  public BufferedSource source;
  public int streamCount;
  
  public RealConnection(Route paramRoute)
  {
    this.route = paramRoute;
  }
  
  private void connectSocket(int paramInt1, int paramInt2, int paramInt3, ConnectionSpecSelector paramConnectionSpecSelector)
    throws IOException
  {
    this.rawSocket.setSoTimeout(paramInt2);
    for (;;)
    {
      try
      {
        Platform.get().connectSocket(this.rawSocket, this.route.getSocketAddress(), paramInt1);
        this.source = Okio.buffer(Okio.source(this.rawSocket));
        this.sink = Okio.buffer(Okio.sink(this.rawSocket));
        if (this.route.getAddress().getSslSocketFactory() != null)
        {
          connectTls(paramInt2, paramInt3, paramConnectionSpecSelector);
          if ((this.protocol == Protocol.SPDY_3) || (this.protocol == Protocol.HTTP_2))
          {
            this.socket.setSoTimeout(0);
            paramConnectionSpecSelector = new FramedConnection.Builder(true).socket(this.socket, this.route.getAddress().url().host(), this.source, this.sink).protocol(this.protocol).build();
            paramConnectionSpecSelector.sendConnectionPreface();
            this.framedConnection = paramConnectionSpecSelector;
          }
          return;
        }
      }
      catch (ConnectException paramConnectionSpecSelector)
      {
        throw new ConnectException("Failed to connect to " + this.route.getSocketAddress());
      }
      this.protocol = Protocol.HTTP_1_1;
      this.socket = this.rawSocket;
    }
  }
  
  /* Error */
  private void connectTls(int paramInt1, int paramInt2, ConnectionSpecSelector paramConnectionSpecSelector)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_0
    //   10: getfield 50	com/squareup/okhttp/internal/io/RealConnection:route	Lcom/squareup/okhttp/Route;
    //   13: invokevirtual 185	com/squareup/okhttp/Route:requiresTunnel	()Z
    //   16: ifeq +9 -> 25
    //   19: aload_0
    //   20: iload_1
    //   21: iload_2
    //   22: invokespecial 189	com/squareup/okhttp/internal/io/RealConnection:createTunnel	(II)V
    //   25: aload_0
    //   26: getfield 50	com/squareup/okhttp/internal/io/RealConnection:route	Lcom/squareup/okhttp/Route;
    //   29: invokevirtual 103	com/squareup/okhttp/Route:getAddress	()Lcom/squareup/okhttp/Address;
    //   32: astore 8
    //   34: aload 8
    //   36: invokevirtual 109	com/squareup/okhttp/Address:getSslSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   39: astore 5
    //   41: aload 5
    //   43: aload_0
    //   44: getfield 59	com/squareup/okhttp/internal/io/RealConnection:rawSocket	Ljava/net/Socket;
    //   47: aload 8
    //   49: invokevirtual 192	com/squareup/okhttp/Address:getUriHost	()Ljava/lang/String;
    //   52: aload 8
    //   54: invokevirtual 196	com/squareup/okhttp/Address:getUriPort	()I
    //   57: iconst_1
    //   58: invokevirtual 202	javax/net/ssl/SSLSocketFactory:createSocket	(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;
    //   61: checkcast 204	javax/net/ssl/SSLSocket
    //   64: astore 5
    //   66: aload_3
    //   67: aload 5
    //   69: invokevirtual 210	com/squareup/okhttp/internal/ConnectionSpecSelector:configureSecureSocket	(Ljavax/net/ssl/SSLSocket;)Lcom/squareup/okhttp/ConnectionSpec;
    //   72: astore 7
    //   74: aload 7
    //   76: invokevirtual 215	com/squareup/okhttp/ConnectionSpec:supportsTlsExtensions	()Z
    //   79: ifeq +21 -> 100
    //   82: invokestatic 71	com/squareup/okhttp/internal/Platform:get	()Lcom/squareup/okhttp/internal/Platform;
    //   85: aload 5
    //   87: aload 8
    //   89: invokevirtual 192	com/squareup/okhttp/Address:getUriHost	()Ljava/lang/String;
    //   92: aload 8
    //   94: invokevirtual 219	com/squareup/okhttp/Address:getProtocols	()Ljava/util/List;
    //   97: invokevirtual 223	com/squareup/okhttp/internal/Platform:configureTlsExtensions	(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V
    //   100: aload 5
    //   102: invokevirtual 226	javax/net/ssl/SSLSocket:startHandshake	()V
    //   105: aload 5
    //   107: invokevirtual 230	javax/net/ssl/SSLSocket:getSession	()Ljavax/net/ssl/SSLSession;
    //   110: invokestatic 235	com/squareup/okhttp/Handshake:get	(Ljavax/net/ssl/SSLSession;)Lcom/squareup/okhttp/Handshake;
    //   113: astore 4
    //   115: aload 8
    //   117: invokevirtual 239	com/squareup/okhttp/Address:getHostnameVerifier	()Ljavax/net/ssl/HostnameVerifier;
    //   120: aload 8
    //   122: invokevirtual 192	com/squareup/okhttp/Address:getUriHost	()Ljava/lang/String;
    //   125: aload 5
    //   127: invokevirtual 230	javax/net/ssl/SSLSocket:getSession	()Ljavax/net/ssl/SSLSession;
    //   130: invokeinterface 245 3 0
    //   135: ifne +154 -> 289
    //   138: aload 4
    //   140: invokevirtual 248	com/squareup/okhttp/Handshake:peerCertificates	()Ljava/util/List;
    //   143: iconst_0
    //   144: invokeinterface 253 2 0
    //   149: checkcast 255	java/security/cert/X509Certificate
    //   152: astore_3
    //   153: new 257	javax/net/ssl/SSLPeerUnverifiedException
    //   156: dup
    //   157: new 159	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   164: ldc_w 259
    //   167: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload 8
    //   172: invokevirtual 192	com/squareup/okhttp/Address:getUriHost	()Ljava/lang/String;
    //   175: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: ldc_w 261
    //   181: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: ldc_w 263
    //   187: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload_3
    //   191: invokestatic 269	com/squareup/okhttp/CertificatePinner:pin	(Ljava/security/cert/Certificate;)Ljava/lang/String;
    //   194: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc_w 271
    //   200: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_3
    //   204: invokevirtual 275	java/security/cert/X509Certificate:getSubjectDN	()Ljava/security/Principal;
    //   207: invokeinterface 280 1 0
    //   212: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc_w 282
    //   218: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload_3
    //   222: invokestatic 288	com/squareup/okhttp/internal/tls/OkHostnameVerifier:allSubjectAltNames	(Ljava/security/cert/X509Certificate;)Ljava/util/List;
    //   225: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokespecial 289	javax/net/ssl/SSLPeerUnverifiedException:<init>	(Ljava/lang/String;)V
    //   234: athrow
    //   235: astore 4
    //   237: aload 5
    //   239: astore_3
    //   240: aload 4
    //   242: astore 5
    //   244: aload_3
    //   245: astore 4
    //   247: aload 5
    //   249: invokestatic 295	com/squareup/okhttp/internal/Util:isAndroidGetsocknameError	(Ljava/lang/AssertionError;)Z
    //   252: ifeq +181 -> 433
    //   255: aload_3
    //   256: astore 4
    //   258: new 55	java/io/IOException
    //   261: dup
    //   262: aload 5
    //   264: invokespecial 298	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   267: athrow
    //   268: astore_3
    //   269: aload 4
    //   271: ifnull +11 -> 282
    //   274: invokestatic 71	com/squareup/okhttp/internal/Platform:get	()Lcom/squareup/okhttp/internal/Platform;
    //   277: aload 4
    //   279: invokevirtual 302	com/squareup/okhttp/internal/Platform:afterHandshake	(Ljavax/net/ssl/SSLSocket;)V
    //   282: aload 4
    //   284: invokestatic 306	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/net/Socket;)V
    //   287: aload_3
    //   288: athrow
    //   289: aload 8
    //   291: invokevirtual 310	com/squareup/okhttp/Address:getCertificatePinner	()Lcom/squareup/okhttp/CertificatePinner;
    //   294: getstatic 314	com/squareup/okhttp/CertificatePinner:DEFAULT	Lcom/squareup/okhttp/CertificatePinner;
    //   297: if_acmpeq +41 -> 338
    //   300: new 316	com/squareup/okhttp/internal/tls/CertificateChainCleaner
    //   303: dup
    //   304: aload 8
    //   306: invokevirtual 109	com/squareup/okhttp/Address:getSslSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   309: invokestatic 320	com/squareup/okhttp/internal/io/RealConnection:trustRootIndex	(Ljavax/net/ssl/SSLSocketFactory;)Lcom/squareup/okhttp/internal/tls/TrustRootIndex;
    //   312: invokespecial 323	com/squareup/okhttp/internal/tls/CertificateChainCleaner:<init>	(Lcom/squareup/okhttp/internal/tls/TrustRootIndex;)V
    //   315: aload 4
    //   317: invokevirtual 248	com/squareup/okhttp/Handshake:peerCertificates	()Ljava/util/List;
    //   320: invokevirtual 327	com/squareup/okhttp/internal/tls/CertificateChainCleaner:clean	(Ljava/util/List;)Ljava/util/List;
    //   323: astore_3
    //   324: aload 8
    //   326: invokevirtual 310	com/squareup/okhttp/Address:getCertificatePinner	()Lcom/squareup/okhttp/CertificatePinner;
    //   329: aload 8
    //   331: invokevirtual 192	com/squareup/okhttp/Address:getUriHost	()Ljava/lang/String;
    //   334: aload_3
    //   335: invokevirtual 331	com/squareup/okhttp/CertificatePinner:check	(Ljava/lang/String;Ljava/util/List;)V
    //   338: aload 6
    //   340: astore_3
    //   341: aload 7
    //   343: invokevirtual 215	com/squareup/okhttp/ConnectionSpec:supportsTlsExtensions	()Z
    //   346: ifeq +12 -> 358
    //   349: invokestatic 71	com/squareup/okhttp/internal/Platform:get	()Lcom/squareup/okhttp/internal/Platform;
    //   352: aload 5
    //   354: invokevirtual 335	com/squareup/okhttp/internal/Platform:getSelectedProtocol	(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;
    //   357: astore_3
    //   358: aload_0
    //   359: aload 5
    //   361: putfield 125	com/squareup/okhttp/internal/io/RealConnection:socket	Ljava/net/Socket;
    //   364: aload_0
    //   365: aload_0
    //   366: getfield 125	com/squareup/okhttp/internal/io/RealConnection:socket	Ljava/net/Socket;
    //   369: invokestatic 85	okio/Okio:source	(Ljava/net/Socket;)Lokio/Source;
    //   372: invokestatic 89	okio/Okio:buffer	(Lokio/Source;)Lokio/BufferedSource;
    //   375: putfield 91	com/squareup/okhttp/internal/io/RealConnection:source	Lokio/BufferedSource;
    //   378: aload_0
    //   379: aload_0
    //   380: getfield 125	com/squareup/okhttp/internal/io/RealConnection:socket	Ljava/net/Socket;
    //   383: invokestatic 94	okio/Okio:sink	(Ljava/net/Socket;)Lokio/Sink;
    //   386: invokestatic 97	okio/Okio:buffer	(Lokio/Sink;)Lokio/BufferedSink;
    //   389: putfield 99	com/squareup/okhttp/internal/io/RealConnection:sink	Lokio/BufferedSink;
    //   392: aload_0
    //   393: aload 4
    //   395: putfield 337	com/squareup/okhttp/internal/io/RealConnection:handshake	Lcom/squareup/okhttp/Handshake;
    //   398: aload_3
    //   399: ifnull +27 -> 426
    //   402: aload_3
    //   403: invokestatic 340	com/squareup/okhttp/Protocol:get	(Ljava/lang/String;)Lcom/squareup/okhttp/Protocol;
    //   406: astore_3
    //   407: aload_0
    //   408: aload_3
    //   409: putfield 115	com/squareup/okhttp/internal/io/RealConnection:protocol	Lcom/squareup/okhttp/Protocol;
    //   412: aload 5
    //   414: ifnull +11 -> 425
    //   417: invokestatic 71	com/squareup/okhttp/internal/Platform:get	()Lcom/squareup/okhttp/internal/Platform;
    //   420: aload 5
    //   422: invokevirtual 302	com/squareup/okhttp/internal/Platform:afterHandshake	(Ljavax/net/ssl/SSLSocket;)V
    //   425: return
    //   426: getstatic 178	com/squareup/okhttp/Protocol:HTTP_1_1	Lcom/squareup/okhttp/Protocol;
    //   429: astore_3
    //   430: goto -23 -> 407
    //   433: aload_3
    //   434: astore 4
    //   436: aload 5
    //   438: athrow
    //   439: astore_3
    //   440: aload 5
    //   442: astore 4
    //   444: goto -175 -> 269
    //   447: astore 5
    //   449: aload 7
    //   451: astore_3
    //   452: goto -208 -> 244
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	455	0	this	RealConnection
    //   0	455	1	paramInt1	int
    //   0	455	2	paramInt2	int
    //   0	455	3	paramConnectionSpecSelector	ConnectionSpecSelector
    //   1	138	4	localHandshake	Handshake
    //   235	6	4	localAssertionError1	java.lang.AssertionError
    //   245	198	4	localObject1	Object
    //   39	402	5	localObject2	Object
    //   447	1	5	localAssertionError2	java.lang.AssertionError
    //   4	335	6	localObject3	Object
    //   7	443	7	localConnectionSpec	ConnectionSpec
    //   32	298	8	localAddress	Address
    // Exception table:
    //   from	to	target	type
    //   66	100	235	java/lang/AssertionError
    //   100	235	235	java/lang/AssertionError
    //   289	338	235	java/lang/AssertionError
    //   341	358	235	java/lang/AssertionError
    //   358	398	235	java/lang/AssertionError
    //   402	407	235	java/lang/AssertionError
    //   407	412	235	java/lang/AssertionError
    //   426	430	235	java/lang/AssertionError
    //   41	66	268	finally
    //   247	255	268	finally
    //   258	268	268	finally
    //   436	439	268	finally
    //   66	100	439	finally
    //   100	235	439	finally
    //   289	338	439	finally
    //   341	358	439	finally
    //   358	398	439	finally
    //   402	407	439	finally
    //   407	412	439	finally
    //   426	430	439	finally
    //   41	66	447	java/lang/AssertionError
  }
  
  private void createTunnel(int paramInt1, int paramInt2)
    throws IOException
  {
    Object localObject1 = createTunnelRequest();
    Object localObject2 = ((Request)localObject1).httpUrl();
    String str = "CONNECT " + ((HttpUrl)localObject2).host() + ":" + ((HttpUrl)localObject2).port() + " HTTP/1.1";
    do
    {
      localObject2 = new Http1xStream(null, this.source, this.sink);
      this.source.timeout().timeout(paramInt1, TimeUnit.MILLISECONDS);
      this.sink.timeout().timeout(paramInt2, TimeUnit.MILLISECONDS);
      ((Http1xStream)localObject2).writeRequest(((Request)localObject1).headers(), str);
      ((Http1xStream)localObject2).finishRequest();
      localObject1 = ((Http1xStream)localObject2).readResponse().request((Request)localObject1).build();
      long l2 = OkHeaders.contentLength((Response)localObject1);
      long l1 = l2;
      if (l2 == -1L) {
        l1 = 0L;
      }
      localObject2 = ((Http1xStream)localObject2).newFixedLengthSource(l1);
      Util.skipAll((Source)localObject2, 2147483647, TimeUnit.MILLISECONDS);
      ((Source)localObject2).close();
      switch (((Response)localObject1).code())
      {
      default: 
        throw new IOException("Unexpected response code for CONNECT: " + ((Response)localObject1).code());
      case 200: 
        if ((this.source.buffer().exhausted()) && (this.sink.buffer().exhausted())) {
          break;
        }
        throw new IOException("TLS tunnel buffered too many bytes!");
      case 407: 
        localObject2 = OkHeaders.processAuthHeader(this.route.getAddress().getAuthenticator(), (Response)localObject1, this.route.getProxy());
        localObject1 = localObject2;
      }
    } while (localObject2 != null);
    throw new IOException("Failed to authenticate with proxy");
  }
  
  private Request createTunnelRequest()
    throws IOException
  {
    return new Request.Builder().url(this.route.getAddress().url()).header("Host", Util.hostHeader(this.route.getAddress().url())).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent()).build();
  }
  
  private static TrustRootIndex trustRootIndex(SSLSocketFactory paramSSLSocketFactory)
  {
    try
    {
      if (paramSSLSocketFactory != lastSslSocketFactory)
      {
        X509TrustManager localX509TrustManager = Platform.get().trustManager(paramSSLSocketFactory);
        lastTrustRootIndex = Platform.get().trustRootIndex(localX509TrustManager);
        lastSslSocketFactory = paramSSLSocketFactory;
      }
      paramSSLSocketFactory = lastTrustRootIndex;
      return paramSSLSocketFactory;
    }
    finally {}
  }
  
  public int allocationLimit()
  {
    FramedConnection localFramedConnection = this.framedConnection;
    if (localFramedConnection != null) {
      return localFramedConnection.maxConcurrentStreams();
    }
    return 1;
  }
  
  public void cancel()
  {
    Util.closeQuietly(this.rawSocket);
  }
  
  public void connect(int paramInt1, int paramInt2, int paramInt3, List<ConnectionSpec> paramList, boolean paramBoolean)
    throws RouteException
  {
    if (this.protocol != null) {
      throw new IllegalStateException("already connected");
    }
    ConnectionSpecSelector localConnectionSpecSelector = new ConnectionSpecSelector(paramList);
    Proxy localProxy = this.route.getProxy();
    Address localAddress = this.route.getAddress();
    if ((this.route.getAddress().getSslSocketFactory() == null) && (!paramList.contains(ConnectionSpec.CLEARTEXT))) {
      throw new RouteException(new UnknownServiceException("CLEARTEXT communication not supported: " + paramList));
    }
    for (;;)
    {
      try
      {
        localObject = new Socket(localProxy);
        this.rawSocket = ((Socket)localObject);
        connectSocket(paramInt1, paramInt2, paramInt3, localConnectionSpecSelector);
      }
      catch (IOException localIOException)
      {
        Util.closeQuietly(this.socket);
        Util.closeQuietly(this.rawSocket);
        this.socket = null;
        this.rawSocket = null;
        this.source = null;
        this.sink = null;
        this.handshake = null;
        this.protocol = null;
        if (paramList != null) {
          continue;
        }
        Object localObject = new RouteException(localIOException);
        if (!paramBoolean) {
          continue;
        }
        paramList = (List<ConnectionSpec>)localObject;
        if (localConnectionSpecSelector.connectionFailed(localIOException)) {
          continue;
        }
        throw ((Throwable)localObject);
        paramList.addConnectException(localIOException);
        localObject = paramList;
        continue;
      }
      if (this.protocol == null)
      {
        if ((localProxy.type() == Proxy.Type.DIRECT) || (localProxy.type() == Proxy.Type.HTTP)) {
          localObject = localAddress.getSocketFactory().createSocket();
        }
      }
      else
      {
        return;
        paramList = null;
      }
    }
  }
  
  public Handshake getHandshake()
  {
    return this.handshake;
  }
  
  public Protocol getProtocol()
  {
    if (this.protocol != null) {
      return this.protocol;
    }
    return Protocol.HTTP_1_1;
  }
  
  public Route getRoute()
  {
    return this.route;
  }
  
  public Socket getSocket()
  {
    return this.socket;
  }
  
  boolean isConnected()
  {
    return this.protocol != null;
  }
  
  public boolean isHealthy(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((this.socket.isClosed()) || (this.socket.isInputShutdown()) || (this.socket.isOutputShutdown())) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.framedConnection != null);
      bool1 = bool2;
    } while (!paramBoolean);
    try
    {
      int i = this.socket.getSoTimeout();
      try
      {
        this.socket.setSoTimeout(1);
        paramBoolean = this.source.exhausted();
        return !paramBoolean;
      }
      finally
      {
        this.socket.setSoTimeout(i);
      }
      return true;
    }
    catch (IOException localIOException)
    {
      return false;
    }
    catch (SocketTimeoutException localSocketTimeoutException) {}
  }
  
  public boolean isMultiplexed()
  {
    return this.framedConnection != null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Connection{").append(this.route.getAddress().url().host()).append(":").append(this.route.getAddress().url().port()).append(", proxy=").append(this.route.getProxy()).append(" hostAddress=").append(this.route.getSocketAddress()).append(" cipherSuite=");
    if (this.handshake != null) {}
    for (String str = this.handshake.cipherSuite();; str = "none") {
      return str + " protocol=" + this.protocol + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.squareup.okhttp.internal.io.RealConnection
 * JD-Core Version:    0.7.0.1
 */