package com.qzone.utils.http;

import com.qzone.common.logging.QDLog;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
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

class ManagedClientConnectionImpl
  implements ManagedClientConnection
{
  private volatile long duration;
  private final ClientConnectionManager manager;
  private final ClientConnectionOperator operator;
  private volatile HttpPoolEntry poolEntry;
  private volatile boolean reusable;
  
  ManagedClientConnectionImpl(ClientConnectionManager paramClientConnectionManager, ClientConnectionOperator paramClientConnectionOperator, HttpPoolEntry paramHttpPoolEntry)
  {
    if (paramClientConnectionManager == null) {
      throw new IllegalArgumentException("Connection manager may not be null");
    }
    if (paramClientConnectionOperator == null) {
      throw new IllegalArgumentException("Connection operator may not be null");
    }
    if (paramHttpPoolEntry == null) {
      throw new IllegalArgumentException("HTTP pool entry may not be null");
    }
    this.manager = paramClientConnectionManager;
    this.operator = paramClientConnectionOperator;
    this.poolEntry = paramHttpPoolEntry;
    this.reusable = false;
    this.duration = 9223372036854775807L;
  }
  
  private OperatedClientConnection ensureConnection()
  {
    HttpPoolEntry localHttpPoolEntry = this.poolEntry;
    if (localHttpPoolEntry == null) {
      throw new ConnectionShutdownException();
    }
    return (OperatedClientConnection)localHttpPoolEntry.getConnection();
  }
  
  private HttpPoolEntry ensurePoolEntry()
  {
    HttpPoolEntry localHttpPoolEntry = this.poolEntry;
    if (localHttpPoolEntry == null) {
      throw new ConnectionShutdownException();
    }
    return localHttpPoolEntry;
  }
  
  private OperatedClientConnection getConnection()
  {
    HttpPoolEntry localHttpPoolEntry = this.poolEntry;
    if (localHttpPoolEntry == null) {
      return null;
    }
    return (OperatedClientConnection)localHttpPoolEntry.getConnection();
  }
  
  /* Error */
  public void abortConnection()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/qzone/utils/http/ManagedClientConnectionImpl:poolEntry	Lcom/qzone/utils/http/HttpPoolEntry;
    //   6: ifnonnull +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield 40	com/qzone/utils/http/ManagedClientConnectionImpl:reusable	Z
    //   17: aload_0
    //   18: getfield 38	com/qzone/utils/http/ManagedClientConnectionImpl:poolEntry	Lcom/qzone/utils/http/HttpPoolEntry;
    //   21: invokevirtual 56	com/qzone/utils/http/HttpPoolEntry:getConnection	()Ljava/lang/Object;
    //   24: checkcast 58	org/apache/http/conn/OperatedClientConnection
    //   27: astore_1
    //   28: aload_1
    //   29: invokeinterface 66 1 0
    //   34: aload_0
    //   35: getfield 34	com/qzone/utils/http/ManagedClientConnectionImpl:manager	Lorg/apache/http/conn/ClientConnectionManager;
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 44	com/qzone/utils/http/ManagedClientConnectionImpl:duration	J
    //   43: getstatic 72	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   46: invokeinterface 78 5 0
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 38	com/qzone/utils/http/ManagedClientConnectionImpl:poolEntry	Lcom/qzone/utils/http/HttpPoolEntry;
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
    //   0	68	0	this	ManagedClientConnectionImpl
    //   27	2	1	localOperatedClientConnection	OperatedClientConnection
    //   59	4	1	localObject	Object
    //   64	1	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	11	59	finally
    //   12	28	59	finally
    //   28	34	59	finally
    //   34	58	59	finally
    //   60	62	59	finally
    //   28	34	64	java/io/IOException
  }
  
  public void close()
    throws IOException
  {
    HttpPoolEntry localHttpPoolEntry = this.poolEntry;
    if (localHttpPoolEntry != null)
    {
      OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)localHttpPoolEntry.getConnection();
      localHttpPoolEntry.resetTracker();
      localOperatedClientConnection.close();
    }
  }
  
  HttpPoolEntry detach()
  {
    HttpPoolEntry localHttpPoolEntry = this.poolEntry;
    this.poolEntry = null;
    return localHttpPoolEntry;
  }
  
  public void flush()
    throws IOException
  {
    ensureConnection().flush();
  }
  
  public Object getAttribute(String paramString)
  {
    OperatedClientConnection localOperatedClientConnection = ensureConnection();
    if ((localOperatedClientConnection instanceof HttpContext)) {
      return ((HttpContext)localOperatedClientConnection).getAttribute(paramString);
    }
    return null;
  }
  
  public InetAddress getLocalAddress()
  {
    return ensureConnection().getLocalAddress();
  }
  
  public int getLocalPort()
  {
    return ensureConnection().getLocalPort();
  }
  
  public ClientConnectionManager getManager()
  {
    return this.manager;
  }
  
  public HttpConnectionMetrics getMetrics()
  {
    return ensureConnection().getMetrics();
  }
  
  HttpPoolEntry getPoolEntry()
  {
    return this.poolEntry;
  }
  
  public InetAddress getRemoteAddress()
  {
    return ensureConnection().getRemoteAddress();
  }
  
  public int getRemotePort()
  {
    return ensureConnection().getRemotePort();
  }
  
  public HttpRoute getRoute()
  {
    return ensurePoolEntry().getEffectiveRoute();
  }
  
  public SSLSession getSSLSession()
  {
    Object localObject = ensureConnection();
    SSLSession localSSLSession = null;
    localObject = ((OperatedClientConnection)localObject).getSocket();
    if ((localObject instanceof SSLSocket)) {
      localSSLSession = ((SSLSocket)localObject).getSession();
    }
    return localSSLSession;
  }
  
  public int getSocketTimeout()
  {
    return ensureConnection().getSocketTimeout();
  }
  
  public Object getState()
  {
    return ensurePoolEntry().getState();
  }
  
  public boolean isMarkedReusable()
  {
    return this.reusable;
  }
  
  public boolean isOpen()
  {
    OperatedClientConnection localOperatedClientConnection = getConnection();
    if (localOperatedClientConnection != null) {
      return localOperatedClientConnection.isOpen();
    }
    return false;
  }
  
  public boolean isResponseAvailable(int paramInt)
    throws IOException
  {
    return ensureConnection().isResponseAvailable(paramInt);
  }
  
  public boolean isSecure()
  {
    return ensureConnection().isSecure();
  }
  
  public boolean isStale()
  {
    OperatedClientConnection localOperatedClientConnection = getConnection();
    if (localOperatedClientConnection != null) {
      return localOperatedClientConnection.isStale();
    }
    return true;
  }
  
  public void layerProtocol(HttpContext paramHttpContext, HttpParams paramHttpParams)
    throws IOException
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    try
    {
      if (this.poolEntry == null) {
        throw new ConnectionShutdownException();
      }
    }
    finally {}
    Object localObject = this.poolEntry.getTracker();
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
    OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)this.poolEntry.getConnection();
    this.operator.updateSecureConnection(localOperatedClientConnection, (HttpHost)localObject, paramHttpContext, paramHttpParams);
    try
    {
      if (this.poolEntry == null) {
        throw new InterruptedIOException();
      }
    }
    finally {}
    this.poolEntry.getTracker().layerProtocol(localOperatedClientConnection.isSecure());
  }
  
  public void markReusable()
  {
    this.reusable = true;
  }
  
  public void open(HttpRoute paramHttpRoute, HttpContext paramHttpContext, HttpParams paramHttpParams)
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
      if (this.poolEntry == null) {
        throw new ConnectionShutdownException();
      }
    }
    finally {}
    if (this.poolEntry.getTracker().isConnected()) {
      throw new IllegalStateException("Connection already open");
    }
    OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)this.poolEntry.getConnection();
    QDLog.i("http", "host:" + localOperatedClientConnection.getTargetHost() + "   " + localOperatedClientConnection.getLocalAddress() + ":" + localOperatedClientConnection.getLocalPort() + "   " + localOperatedClientConnection.getRemoteAddress() + ":" + localOperatedClientConnection.getRemotePort());
    HttpHost localHttpHost2 = paramHttpRoute.getProxyHost();
    ClientConnectionOperator localClientConnectionOperator = this.operator;
    if (localHttpHost2 != null) {}
    for (HttpHost localHttpHost1 = localHttpHost2;; localHttpHost1 = paramHttpRoute.getTargetHost())
    {
      localClientConnectionOperator.openConnection(localOperatedClientConnection, localHttpHost1, paramHttpRoute.getLocalAddress(), paramHttpContext, paramHttpParams);
      try
      {
        if (this.poolEntry != null) {
          break;
        }
        throw new InterruptedIOException();
      }
      finally {}
    }
    paramHttpRoute = this.poolEntry.getTracker();
    if (localHttpHost2 == null) {
      paramHttpRoute.connectTarget(localOperatedClientConnection.isSecure());
    }
    for (;;)
    {
      return;
      paramHttpRoute.connectProxy(localHttpHost2, localOperatedClientConnection.isSecure());
    }
  }
  
  public void receiveResponseEntity(HttpResponse paramHttpResponse)
    throws HttpException, IOException
  {
    ensureConnection().receiveResponseEntity(paramHttpResponse);
  }
  
  public HttpResponse receiveResponseHeader()
    throws HttpException, IOException
  {
    return ensureConnection().receiveResponseHeader();
  }
  
  public void releaseConnection()
  {
    try
    {
      if (this.poolEntry == null) {
        return;
      }
      this.manager.releaseConnection(this, this.duration, TimeUnit.MILLISECONDS);
      this.poolEntry = null;
      return;
    }
    finally {}
  }
  
  public Object removeAttribute(String paramString)
  {
    OperatedClientConnection localOperatedClientConnection = ensureConnection();
    if ((localOperatedClientConnection instanceof HttpContext)) {
      return ((HttpContext)localOperatedClientConnection).removeAttribute(paramString);
    }
    return null;
  }
  
  public void sendRequestEntity(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest)
    throws HttpException, IOException
  {
    ensureConnection().sendRequestEntity(paramHttpEntityEnclosingRequest);
  }
  
  public void sendRequestHeader(HttpRequest paramHttpRequest)
    throws HttpException, IOException
  {
    ensureConnection().sendRequestHeader(paramHttpRequest);
  }
  
  public void setAttribute(String paramString, Object paramObject)
  {
    OperatedClientConnection localOperatedClientConnection = ensureConnection();
    if ((localOperatedClientConnection instanceof HttpContext)) {
      ((HttpContext)localOperatedClientConnection).setAttribute(paramString, paramObject);
    }
  }
  
  public void setIdleDuration(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong > 0L)
    {
      this.duration = paramTimeUnit.toMillis(paramLong);
      return;
    }
    this.duration = -1L;
  }
  
  public void setSocketTimeout(int paramInt)
  {
    ensureConnection().setSocketTimeout(paramInt);
  }
  
  public void setState(Object paramObject)
  {
    ensurePoolEntry().setState(paramObject);
  }
  
  public void shutdown()
    throws IOException
  {
    HttpPoolEntry localHttpPoolEntry = this.poolEntry;
    if (localHttpPoolEntry != null)
    {
      OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)localHttpPoolEntry.getConnection();
      localHttpPoolEntry.resetTracker();
      localOperatedClientConnection.shutdown();
    }
  }
  
  public void tunnelProxy(HttpHost paramHttpHost, boolean paramBoolean, HttpParams paramHttpParams)
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
      if (this.poolEntry == null) {
        throw new ConnectionShutdownException();
      }
    }
    finally {}
    if (!this.poolEntry.getTracker().isConnected()) {
      throw new IllegalStateException("Connection not open");
    }
    OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)this.poolEntry.getConnection();
    localOperatedClientConnection.update(null, paramHttpHost, paramBoolean, paramHttpParams);
    try
    {
      if (this.poolEntry == null) {
        throw new InterruptedIOException();
      }
    }
    finally {}
    this.poolEntry.getTracker().tunnelProxy(paramHttpHost, paramBoolean);
  }
  
  public void tunnelTarget(boolean paramBoolean, HttpParams paramHttpParams)
    throws IOException
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    try
    {
      if (this.poolEntry == null) {
        throw new ConnectionShutdownException();
      }
    }
    finally {}
    Object localObject = this.poolEntry.getTracker();
    if (!((RouteTracker)localObject).isConnected()) {
      throw new IllegalStateException("Connection not open");
    }
    if (((RouteTracker)localObject).isTunnelled()) {
      throw new IllegalStateException("Connection is already tunnelled");
    }
    localObject = ((RouteTracker)localObject).getTargetHost();
    OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)this.poolEntry.getConnection();
    localOperatedClientConnection.update(null, (HttpHost)localObject, paramBoolean, paramHttpParams);
    try
    {
      if (this.poolEntry == null) {
        throw new InterruptedIOException();
      }
    }
    finally {}
    this.poolEntry.getTracker().tunnelTarget(paramBoolean);
  }
  
  public void unmarkReusable()
  {
    this.reusable = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.utils.http.ManagedClientConnectionImpl
 * JD-Core Version:    0.7.0.1
 */