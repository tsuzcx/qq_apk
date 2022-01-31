package com.tencent.component.network.utils.a;

import com.tencent.component.network.utils.a.b.a;
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

public final class g
  implements ClientConnectionManager
{
  private final SchemeRegistry a;
  private final c b;
  private final ClientConnectionOperator c;
  
  public g()
  {
    this(localSchemeRegistry);
  }
  
  private g(SchemeRegistry paramSchemeRegistry)
  {
    this(paramSchemeRegistry, -1L, TimeUnit.MILLISECONDS);
  }
  
  public g(SchemeRegistry paramSchemeRegistry, long paramLong, TimeUnit paramTimeUnit)
  {
    this(paramSchemeRegistry, paramLong, paramTimeUnit, (byte)0);
  }
  
  private g(SchemeRegistry paramSchemeRegistry, long paramLong, TimeUnit paramTimeUnit, byte paramByte)
  {
    if (paramSchemeRegistry == null) {
      throw new IllegalArgumentException("Scheme registry may not be null");
    }
    this.a = paramSchemeRegistry;
    this.c = new DefaultClientConnectionOperator(paramSchemeRegistry);
    this.b = new c(paramLong, paramTimeUnit);
  }
  
  final ManagedClientConnection a(Future<d> paramFuture, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ConnectionPoolTimeoutException
  {
    try
    {
      paramTimeUnit = (d)paramFuture.get(paramLong, paramTimeUnit);
      if ((paramTimeUnit == null) || (paramFuture.isCancelled())) {
        throw new InterruptedException();
      }
    }
    catch (ExecutionException paramFuture)
    {
      paramFuture.getCause();
      throw new InterruptedException();
      if (paramTimeUnit.g() == null) {
        throw new IllegalStateException("Pool entry with no connection");
      }
    }
    catch (TimeoutException paramFuture)
    {
      throw new ConnectionPoolTimeoutException("Timeout waiting for connection from pool");
    }
    paramFuture = new f(this, this.c, paramTimeUnit);
    return paramFuture;
  }
  
  public final void a(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public final void b(int paramInt)
  {
    this.b.b(paramInt);
  }
  
  public final void closeExpiredConnections()
  {
    this.b.b();
  }
  
  public final void closeIdleConnections(long paramLong, TimeUnit paramTimeUnit)
  {
    this.b.a(paramLong, paramTimeUnit);
  }
  
  protected final void finalize()
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
  
  public final SchemeRegistry getSchemeRegistry()
  {
    return this.a;
  }
  
  /* Error */
  public final void releaseConnection(ManagedClientConnection paramManagedClientConnection, long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 125
    //   4: ifne +13 -> 17
    //   7: new 66	java/lang/IllegalArgumentException
    //   10: dup
    //   11: ldc 158
    //   13: invokespecial 71	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: aload_1
    //   18: checkcast 125	com/tencent/component/network/utils/a/f
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 161	com/tencent/component/network/utils/a/f:b	()Lorg/apache/http/conn/ClientConnectionManager;
    //   26: aload_0
    //   27: if_acmpeq +13 -> 40
    //   30: new 117	java/lang/IllegalStateException
    //   33: dup
    //   34: ldc 163
    //   36: invokespecial 120	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   39: athrow
    //   40: aload_1
    //   41: monitorenter
    //   42: aload_1
    //   43: invokevirtual 166	com/tencent/component/network/utils/a/f:a	()Lcom/tencent/component/network/utils/a/d;
    //   46: astore 6
    //   48: aload 6
    //   50: ifnonnull +6 -> 56
    //   53: aload_1
    //   54: monitorexit
    //   55: return
    //   56: aload_1
    //   57: invokevirtual 169	com/tencent/component/network/utils/a/f:isOpen	()Z
    //   60: ifeq +18 -> 78
    //   63: aload_1
    //   64: invokevirtual 172	com/tencent/component/network/utils/a/f:isMarkedReusable	()Z
    //   67: istore 5
    //   69: iload 5
    //   71: ifne +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 173	com/tencent/component/network/utils/a/f:shutdown	()V
    //   78: aload_1
    //   79: invokevirtual 172	com/tencent/component/network/utils/a/f:isMarkedReusable	()Z
    //   82: ifeq +16 -> 98
    //   85: aload 4
    //   87: ifnull +34 -> 121
    //   90: aload 6
    //   92: lload_2
    //   93: aload 4
    //   95: invokevirtual 174	com/tencent/component/network/utils/a/d:a	(JLjava/util/concurrent/TimeUnit;)V
    //   98: aload_0
    //   99: getfield 85	com/tencent/component/network/utils/a/g:b	Lcom/tencent/component/network/utils/a/c;
    //   102: aload 6
    //   104: aload_1
    //   105: invokevirtual 172	com/tencent/component/network/utils/a/f:isMarkedReusable	()Z
    //   108: invokevirtual 177	com/tencent/component/network/utils/a/c:a	(Lcom/tencent/component/network/utils/a/b/e;Z)V
    //   111: aload_1
    //   112: monitorexit
    //   113: return
    //   114: astore 4
    //   116: aload_1
    //   117: monitorexit
    //   118: aload 4
    //   120: athrow
    //   121: getstatic 54	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   124: astore 4
    //   126: goto -36 -> 90
    //   129: astore 4
    //   131: aload_0
    //   132: getfield 85	com/tencent/component/network/utils/a/g:b	Lcom/tencent/component/network/utils/a/c;
    //   135: aload 6
    //   137: aload_1
    //   138: invokevirtual 172	com/tencent/component/network/utils/a/f:isMarkedReusable	()Z
    //   141: invokevirtual 177	com/tencent/component/network/utils/a/c:a	(Lcom/tencent/component/network/utils/a/b/e;Z)V
    //   144: aload 4
    //   146: athrow
    //   147: astore 7
    //   149: goto -71 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	g
    //   0	152	1	paramManagedClientConnection	ManagedClientConnection
    //   0	152	2	paramLong	long
    //   0	152	4	paramTimeUnit	TimeUnit
    //   67	3	5	bool	boolean
    //   46	90	6	locald	d
    //   147	1	7	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   42	48	114	finally
    //   53	55	114	finally
    //   98	113	114	finally
    //   131	147	114	finally
    //   56	69	129	finally
    //   74	78	129	finally
    //   78	85	129	finally
    //   90	98	129	finally
    //   121	126	129	finally
    //   74	78	147	java/io/IOException
  }
  
  public final ClientConnectionRequest requestConnection(HttpRoute paramHttpRoute, Object paramObject)
  {
    if (paramHttpRoute == null) {
      throw new IllegalArgumentException("HTTP route may not be null");
    }
    return new h(this, this.b.b(paramHttpRoute, paramObject));
  }
  
  public final void shutdown()
  {
    try
    {
      this.b.a();
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.a.g
 * JD-Core Version:    0.7.0.1
 */