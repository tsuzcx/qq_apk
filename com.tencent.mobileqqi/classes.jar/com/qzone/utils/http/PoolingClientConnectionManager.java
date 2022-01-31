package com.qzone.utils.http;

import com.qzone.common.logging.QDLog;
import com.qzone.utils.http.pool.ConnPoolControl;
import com.qzone.utils.http.pool.PoolStats;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.conn.DefaultClientConnectionOperator;

public class PoolingClientConnectionManager
  implements ClientConnectionManager, ConnPoolControl<HttpRoute>
{
  private final DnsResolver dnsResolver;
  private final ClientConnectionOperator operator;
  private final HttpConnPool pool;
  private final SchemeRegistry schemeRegistry;
  
  public PoolingClientConnectionManager()
  {
    this(SchemeRegistryFactory.createDefault());
  }
  
  public PoolingClientConnectionManager(SchemeRegistry paramSchemeRegistry)
  {
    this(paramSchemeRegistry, -1L, TimeUnit.MILLISECONDS);
  }
  
  public PoolingClientConnectionManager(SchemeRegistry paramSchemeRegistry, long paramLong, TimeUnit paramTimeUnit)
  {
    this(paramSchemeRegistry, paramLong, paramTimeUnit, new SystemDefaultDnsResolver());
  }
  
  public PoolingClientConnectionManager(SchemeRegistry paramSchemeRegistry, long paramLong, TimeUnit paramTimeUnit, DnsResolver paramDnsResolver)
  {
    if (paramSchemeRegistry == null) {
      throw new IllegalArgumentException("Scheme registry may not be null");
    }
    if (paramDnsResolver == null) {
      throw new IllegalArgumentException("DNS resolver may not be null");
    }
    this.schemeRegistry = paramSchemeRegistry;
    this.dnsResolver = paramDnsResolver;
    this.operator = createConnectionOperator(paramSchemeRegistry);
    this.pool = new HttpConnPool(null, 2, 20, paramLong, paramTimeUnit);
  }
  
  public PoolingClientConnectionManager(SchemeRegistry paramSchemeRegistry, DnsResolver paramDnsResolver)
  {
    this(paramSchemeRegistry, -1L, TimeUnit.MILLISECONDS, paramDnsResolver);
  }
  
  private String format(HttpPoolEntry paramHttpPoolEntry)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[id: ").append(paramHttpPoolEntry.getId()).append("]");
    localStringBuilder.append("[route: ").append(paramHttpPoolEntry.getRoute()).append("]");
    paramHttpPoolEntry = paramHttpPoolEntry.getState();
    if (paramHttpPoolEntry != null) {
      localStringBuilder.append("[state: ").append(paramHttpPoolEntry).append("]");
    }
    return localStringBuilder.toString();
  }
  
  private String format(HttpRoute paramHttpRoute, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[route: ").append(paramHttpRoute).append("]");
    if (paramObject != null) {
      localStringBuilder.append("[state: ").append(paramObject).append("]");
    }
    return localStringBuilder.toString();
  }
  
  private String formatStats(HttpRoute paramHttpRoute)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    PoolStats localPoolStats = this.pool.getTotalStats();
    paramHttpRoute = this.pool.getStats(paramHttpRoute);
    localStringBuilder.append("[total kept alive: ").append(localPoolStats.getAvailable()).append("; ");
    localStringBuilder.append("route allocated: ").append(paramHttpRoute.getLeased() + paramHttpRoute.getAvailable());
    localStringBuilder.append(" of ").append(paramHttpRoute.getMax()).append("; ");
    localStringBuilder.append("total allocated: ").append(localPoolStats.getLeased() + localPoolStats.getAvailable());
    localStringBuilder.append(" of ").append(localPoolStats.getMax()).append("]");
    return localStringBuilder.toString();
  }
  
  public void closeExpiredConnections()
  {
    this.pool.closeExpired();
  }
  
  public void closeIdleConnections(long paramLong, TimeUnit paramTimeUnit)
  {
    this.pool.closeIdle(paramLong, paramTimeUnit);
  }
  
  protected ClientConnectionOperator createConnectionOperator(SchemeRegistry paramSchemeRegistry)
  {
    return new DefaultClientConnectionOperator(paramSchemeRegistry);
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      shutdown();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getDefaultMaxPerRoute()
  {
    return this.pool.getDefaultMaxPerRoute();
  }
  
  public int getMaxPerRoute(HttpRoute paramHttpRoute)
  {
    return this.pool.getMaxPerRoute(paramHttpRoute);
  }
  
  public int getMaxTotal()
  {
    return this.pool.getMaxTotal();
  }
  
  public SchemeRegistry getSchemeRegistry()
  {
    return this.schemeRegistry;
  }
  
  public PoolStats getStats(HttpRoute paramHttpRoute)
  {
    return this.pool.getStats(paramHttpRoute);
  }
  
  public PoolStats getTotalStats()
  {
    return this.pool.getTotalStats();
  }
  
  ManagedClientConnection leaseConnection(Future<HttpPoolEntry> paramFuture, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ConnectionPoolTimeoutException
  {
    try
    {
      paramTimeUnit = (HttpPoolEntry)paramFuture.get(paramLong, paramTimeUnit);
      if ((paramTimeUnit == null) || (paramFuture.isCancelled())) {
        throw new InterruptedException();
      }
    }
    catch (ExecutionException paramFuture)
    {
      if (paramFuture.getCause() == null) {}
      throw new InterruptedException();
      if (paramTimeUnit.getConnection() == null) {
        throw new IllegalStateException("Pool entry with no connection");
      }
    }
    catch (TimeoutException paramFuture)
    {
      throw new ConnectionPoolTimeoutException("Timeout waiting for connection from pool");
    }
    paramFuture = new ManagedClientConnectionImpl(this, this.operator, paramTimeUnit);
    return paramFuture;
  }
  
  /* Error */
  public void releaseConnection(ManagedClientConnection paramManagedClientConnection, long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 227
    //   4: ifne +13 -> 17
    //   7: new 52	java/lang/IllegalArgumentException
    //   10: dup
    //   11: ldc 238
    //   13: invokespecial 57	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: aload_1
    //   18: checkcast 227	com/qzone/utils/http/ManagedClientConnectionImpl
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 242	com/qzone/utils/http/ManagedClientConnectionImpl:getManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   26: aload_0
    //   27: if_acmpeq +13 -> 40
    //   30: new 219	java/lang/IllegalStateException
    //   33: dup
    //   34: ldc 244
    //   36: invokespecial 222	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   39: athrow
    //   40: aload_1
    //   41: monitorenter
    //   42: aload_1
    //   43: invokevirtual 248	com/qzone/utils/http/ManagedClientConnectionImpl:detach	()Lcom/qzone/utils/http/HttpPoolEntry;
    //   46: astore 6
    //   48: aload 6
    //   50: ifnonnull +6 -> 56
    //   53: aload_1
    //   54: monitorexit
    //   55: return
    //   56: aload_1
    //   57: invokevirtual 251	com/qzone/utils/http/ManagedClientConnectionImpl:isOpen	()Z
    //   60: ifeq +18 -> 78
    //   63: aload_1
    //   64: invokevirtual 254	com/qzone/utils/http/ManagedClientConnectionImpl:isMarkedReusable	()Z
    //   67: istore 5
    //   69: iload 5
    //   71: ifne +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 255	com/qzone/utils/http/ManagedClientConnectionImpl:shutdown	()V
    //   78: aload_1
    //   79: invokevirtual 254	com/qzone/utils/http/ManagedClientConnectionImpl:isMarkedReusable	()Z
    //   82: ifeq +16 -> 98
    //   85: aload 4
    //   87: ifnull +34 -> 121
    //   90: aload 6
    //   92: lload_2
    //   93: aload 4
    //   95: invokevirtual 258	com/qzone/utils/http/HttpPoolEntry:updateExpiry	(JLjava/util/concurrent/TimeUnit;)V
    //   98: aload_0
    //   99: getfield 76	com/qzone/utils/http/PoolingClientConnectionManager:pool	Lcom/qzone/utils/http/HttpConnPool;
    //   102: aload 6
    //   104: aload_1
    //   105: invokevirtual 254	com/qzone/utils/http/ManagedClientConnectionImpl:isMarkedReusable	()Z
    //   108: invokevirtual 262	com/qzone/utils/http/HttpConnPool:release	(Lcom/qzone/utils/http/pool/PoolEntry;Z)V
    //   111: aload_1
    //   112: monitorexit
    //   113: return
    //   114: astore 4
    //   116: aload_1
    //   117: monitorexit
    //   118: aload 4
    //   120: athrow
    //   121: getstatic 39	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   124: astore 4
    //   126: goto -36 -> 90
    //   129: astore 4
    //   131: aload_0
    //   132: getfield 76	com/qzone/utils/http/PoolingClientConnectionManager:pool	Lcom/qzone/utils/http/HttpConnPool;
    //   135: aload 6
    //   137: aload_1
    //   138: invokevirtual 254	com/qzone/utils/http/ManagedClientConnectionImpl:isMarkedReusable	()Z
    //   141: invokevirtual 262	com/qzone/utils/http/HttpConnPool:release	(Lcom/qzone/utils/http/pool/PoolEntry;Z)V
    //   144: aload 4
    //   146: athrow
    //   147: astore 7
    //   149: goto -71 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	PoolingClientConnectionManager
    //   0	152	1	paramManagedClientConnection	ManagedClientConnection
    //   0	152	2	paramLong	long
    //   0	152	4	paramTimeUnit	TimeUnit
    //   67	3	5	bool	boolean
    //   46	90	6	localHttpPoolEntry	HttpPoolEntry
    //   147	1	7	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   42	48	114	finally
    //   53	55	114	finally
    //   98	113	114	finally
    //   116	118	114	finally
    //   131	147	114	finally
    //   56	69	129	finally
    //   74	78	129	finally
    //   78	85	129	finally
    //   90	98	129	finally
    //   121	126	129	finally
    //   74	78	147	java/io/IOException
  }
  
  public ClientConnectionRequest requestConnection(HttpRoute paramHttpRoute, Object paramObject)
  {
    if (paramHttpRoute == null) {
      throw new IllegalArgumentException("HTTP route may not be null");
    }
    QDLog.i("http", "Connection request: " + format(paramHttpRoute, paramObject) + formatStats(paramHttpRoute));
    new ClientConnectionRequest()
    {
      public void abortRequest()
      {
        this.val$future.cancel(true);
      }
      
      public ManagedClientConnection getConnection(long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
        throws InterruptedException, ConnectionPoolTimeoutException
      {
        return PoolingClientConnectionManager.this.leaseConnection(this.val$future, paramAnonymousLong, paramAnonymousTimeUnit);
      }
    };
  }
  
  public void setDefaultMaxPerRoute(int paramInt)
  {
    this.pool.setDefaultMaxPerRoute(paramInt);
  }
  
  public void setMaxPerRoute(HttpRoute paramHttpRoute, int paramInt)
  {
    this.pool.setMaxPerRoute(paramHttpRoute, paramInt);
  }
  
  public void setMaxTotal(int paramInt)
  {
    this.pool.setMaxTotal(paramInt);
  }
  
  public void shutdown()
  {
    try
    {
      this.pool.shutdown();
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.utils.http.PoolingClientConnectionManager
 * JD-Core Version:    0.7.0.1
 */