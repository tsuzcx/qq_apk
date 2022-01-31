package com.tencent.component.network.utils.a;

import com.tencent.component.network.downloader.impl.ipc.Const;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

final class f
  implements ManagedClientConnection
{
  private final ClientConnectionManager a;
  private final ClientConnectionOperator b;
  private volatile d c;
  private volatile boolean d;
  private volatile long e;
  
  f(ClientConnectionManager paramClientConnectionManager, ClientConnectionOperator paramClientConnectionOperator, d paramd)
  {
    if (paramClientConnectionManager == null) {
      throw new IllegalArgumentException("Connection manager may not be null");
    }
    if (paramClientConnectionOperator == null) {
      throw new IllegalArgumentException("Connection operator may not be null");
    }
    if (paramd == null) {
      throw new IllegalArgumentException("HTTP pool entry may not be null");
    }
    this.a = paramClientConnectionManager;
    this.b = paramClientConnectionOperator;
    this.c = paramd;
    this.d = false;
    this.e = 9223372036854775807L;
  }
  
  private OperatedClientConnection c()
  {
    d locald = this.c;
    if (locald == null) {
      return null;
    }
    return (OperatedClientConnection)locald.g();
  }
  
  private OperatedClientConnection d()
  {
    d locald = this.c;
    if (locald == null) {
      throw new a();
    }
    return (OperatedClientConnection)locald.g();
  }
  
  private d e()
  {
    d locald = this.c;
    if (locald == null) {
      throw new a();
    }
    return locald;
  }
  
  final d a()
  {
    d locald = this.c;
    this.c = null;
    return locald;
  }
  
  /* Error */
  public final void abortConnection()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/tencent/component/network/utils/a/f:c	Lcom/tencent/component/network/utils/a/d;
    //   6: ifnonnull +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield 40	com/tencent/component/network/utils/a/f:d	Z
    //   17: aload_0
    //   18: getfield 38	com/tencent/component/network/utils/a/f:c	Lcom/tencent/component/network/utils/a/d;
    //   21: invokevirtual 52	com/tencent/component/network/utils/a/d:g	()Ljava/lang/Object;
    //   24: checkcast 54	org/apache/http/conn/OperatedClientConnection
    //   27: astore_1
    //   28: aload_1
    //   29: invokeinterface 64 1 0
    //   34: aload_0
    //   35: getfield 34	com/tencent/component/network/utils/a/f:a	Lorg/apache/http/conn/ClientConnectionManager;
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 44	com/tencent/component/network/utils/a/f:e	J
    //   43: getstatic 70	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   46: invokeinterface 76 5 0
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 38	com/tencent/component/network/utils/a/f:c	Lcom/tencent/component/network/utils/a/d;
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    //   64: astore_1
    //   65: goto -31 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	f
    //   27	2	1	localOperatedClientConnection	OperatedClientConnection
    //   59	4	1	localObject	Object
    //   64	1	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	11	59	finally
    //   12	28	59	finally
    //   28	34	59	finally
    //   34	58	59	finally
    //   28	34	64	java/io/IOException
  }
  
  public final ClientConnectionManager b()
  {
    return this.a;
  }
  
  public final void close()
    throws IOException
  {
    d locald = this.c;
    if (locald != null)
    {
      OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)locald.g();
      locald.b();
      localOperatedClientConnection.close();
    }
  }
  
  public final void flush()
    throws IOException
  {
    d().flush();
  }
  
  public final InetAddress getLocalAddress()
  {
    return d().getLocalAddress();
  }
  
  public final int getLocalPort()
  {
    return d().getLocalPort();
  }
  
  public final HttpConnectionMetrics getMetrics()
  {
    return d().getMetrics();
  }
  
  public final InetAddress getRemoteAddress()
  {
    return d().getRemoteAddress();
  }
  
  public final int getRemotePort()
  {
    return d().getRemotePort();
  }
  
  public final HttpRoute getRoute()
  {
    return e().c();
  }
  
  public final SSLSession getSSLSession()
  {
    Socket localSocket = d().getSocket();
    if ((localSocket instanceof SSLSocket)) {
      return ((SSLSocket)localSocket).getSession();
    }
    return null;
  }
  
  public final int getSocketTimeout()
  {
    return d().getSocketTimeout();
  }
  
  public final Object getState()
  {
    return e().h();
  }
  
  public final boolean isMarkedReusable()
  {
    return this.d;
  }
  
  public final boolean isOpen()
  {
    OperatedClientConnection localOperatedClientConnection = c();
    if (localOperatedClientConnection != null) {
      return localOperatedClientConnection.isOpen();
    }
    return false;
  }
  
  public final boolean isResponseAvailable(int paramInt)
    throws IOException
  {
    return d().isResponseAvailable(paramInt);
  }
  
  public final boolean isSecure()
  {
    return d().isSecure();
  }
  
  public final boolean isStale()
  {
    OperatedClientConnection localOperatedClientConnection = c();
    if (localOperatedClientConnection != null) {
      return localOperatedClientConnection.isStale();
    }
    return true;
  }
  
  public final void layerProtocol(HttpContext paramHttpContext, HttpParams paramHttpParams)
    throws IOException
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    try
    {
      if (this.c == null) {
        throw new a();
      }
    }
    finally {}
    Object localObject = this.c.a();
    if (!((RouteTracker)localObject).isConnected()) {
      throw new IllegalStateException("Connection not open");
    }
    if (!((RouteTracker)localObject).isTunnelled()) {
      throw new IllegalStateException("Protocol layering without a tunnel not supported");
    }
    if (((RouteTracker)localObject).isLayered()) {
      throw new IllegalStateException("Multiple protocol layering not supported");
    }
    localObject = ((RouteTracker)localObject).getTargetHost();
    OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)this.c.g();
    this.b.updateSecureConnection(localOperatedClientConnection, (HttpHost)localObject, paramHttpContext, paramHttpParams);
    try
    {
      if (this.c == null) {
        throw new InterruptedIOException();
      }
    }
    finally {}
    this.c.a().layerProtocol(localOperatedClientConnection.isSecure());
  }
  
  public final void markReusable()
  {
    this.d = true;
  }
  
  public final void open(HttpRoute paramHttpRoute, HttpContext paramHttpContext, HttpParams paramHttpParams)
    throws IOException
  {
    if (paramHttpRoute == null) {
      throw new IllegalArgumentException("Route may not be null");
    }
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    try
    {
      if (this.c == null) {
        throw new a();
      }
    }
    finally {}
    if (this.c.a().isConnected()) {
      throw new IllegalStateException("Connection already open");
    }
    OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)this.c.g();
    Const.c("http", "host:" + localOperatedClientConnection.getTargetHost() + "   " + localOperatedClientConnection.getLocalAddress() + ":" + localOperatedClientConnection.getLocalPort() + "   " + localOperatedClientConnection.getRemoteAddress() + ":" + localOperatedClientConnection.getRemotePort());
    HttpHost localHttpHost2 = paramHttpRoute.getProxyHost();
    ClientConnectionOperator localClientConnectionOperator = this.b;
    if (localHttpHost2 != null) {}
    for (HttpHost localHttpHost1 = localHttpHost2;; localHttpHost1 = paramHttpRoute.getTargetHost())
    {
      localClientConnectionOperator.openConnection(localOperatedClientConnection, localHttpHost1, paramHttpRoute.getLocalAddress(), paramHttpContext, paramHttpParams);
      try
      {
        if (this.c != null) {
          break;
        }
        throw new InterruptedIOException();
      }
      finally {}
    }
    paramHttpRoute = this.c.a();
    if (localHttpHost2 == null) {
      paramHttpRoute.connectTarget(localOperatedClientConnection.isSecure());
    }
    for (;;)
    {
      return;
      paramHttpRoute.connectProxy(localHttpHost2, localOperatedClientConnection.isSecure());
    }
  }
  
  public final void receiveResponseEntity(HttpResponse paramHttpResponse)
    throws HttpException, IOException
  {
    d().receiveResponseEntity(paramHttpResponse);
  }
  
  public final HttpResponse receiveResponseHeader()
    throws HttpException, IOException
  {
    return d().receiveResponseHeader();
  }
  
  public final void releaseConnection()
  {
    try
    {
      if (this.c == null) {
        return;
      }
      this.a.releaseConnection(this, this.e, TimeUnit.MILLISECONDS);
      this.c = null;
      return;
    }
    finally {}
  }
  
  public final void sendRequestEntity(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest)
    throws HttpException, IOException
  {
    d().sendRequestEntity(paramHttpEntityEnclosingRequest);
  }
  
  public final void sendRequestHeader(HttpRequest paramHttpRequest)
    throws HttpException, IOException
  {
    d().sendRequestHeader(paramHttpRequest);
  }
  
  public final void setIdleDuration(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong > 0L)
    {
      this.e = paramTimeUnit.toMillis(paramLong);
      return;
    }
    this.e = -1L;
  }
  
  public final void setSocketTimeout(int paramInt)
  {
    d().setSocketTimeout(paramInt);
  }
  
  public final void setState(Object paramObject)
  {
    e().a(paramObject);
  }
  
  public final void shutdown()
    throws IOException
  {
    d locald = this.c;
    if (locald != null)
    {
      OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)locald.g();
      locald.b();
      localOperatedClientConnection.shutdown();
    }
  }
  
  public final void tunnelProxy(HttpHost paramHttpHost, boolean paramBoolean, HttpParams paramHttpParams)
    throws IOException
  {
    if (paramHttpHost == null) {
      throw new IllegalArgumentException("Next proxy amy not be null");
    }
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    try
    {
      if (this.c == null) {
        throw new a();
      }
    }
    finally {}
    if (!this.c.a().isConnected()) {
      throw new IllegalStateException("Connection not open");
    }
    OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)this.c.g();
    localOperatedClientConnection.update(null, paramHttpHost, paramBoolean, paramHttpParams);
    try
    {
      if (this.c == null) {
        throw new InterruptedIOException();
      }
    }
    finally {}
    this.c.a().tunnelProxy(paramHttpHost, paramBoolean);
  }
  
  public final void tunnelTarget(boolean paramBoolean, HttpParams paramHttpParams)
    throws IOException
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    try
    {
      if (this.c == null) {
        throw new a();
      }
    }
    finally {}
    Object localObject = this.c.a();
    if (!((RouteTracker)localObject).isConnected()) {
      throw new IllegalStateException("Connection not open");
    }
    if (((RouteTracker)localObject).isTunnelled()) {
      throw new IllegalStateException("Connection is already tunnelled");
    }
    localObject = ((RouteTracker)localObject).getTargetHost();
    OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)this.c.g();
    localOperatedClientConnection.update(null, (HttpHost)localObject, paramBoolean, paramHttpParams);
    try
    {
      if (this.c == null) {
        throw new InterruptedIOException();
      }
    }
    finally {}
    this.c.a().tunnelTarget(paramBoolean);
  }
  
  public final void unmarkReusable()
  {
    this.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.a.f
 * JD-Core Version:    0.7.0.1
 */