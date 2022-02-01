package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

public final class StreamAllocation
{
  public final Address address;
  public final Call call;
  private final Object callStackTrace;
  private boolean canceled;
  private HttpCodec codec;
  private RealConnection connection;
  private final ConnectionPool connectionPool;
  public final EventListener eventListener;
  private int refusedStreamCount;
  private boolean released;
  private boolean reportedAcquired;
  private Route route;
  private RouteSelector.Selection routeSelection;
  private final RouteSelector routeSelector;
  
  static
  {
    if (!StreamAllocation.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public StreamAllocation(ConnectionPool paramConnectionPool, Address paramAddress, Call paramCall, EventListener paramEventListener, Object paramObject)
  {
    this.connectionPool = paramConnectionPool;
    this.address = paramAddress;
    this.call = paramCall;
    this.eventListener = paramEventListener;
    this.routeSelector = new RouteSelector(paramAddress, routeDatabase(), paramCall, paramEventListener);
    this.callStackTrace = paramObject;
  }
  
  private Socket deallocate(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject2 = null;
    assert (Thread.holdsLock(this.connectionPool));
    if (paramBoolean3) {
      this.codec = null;
    }
    if (paramBoolean2) {
      this.released = true;
    }
    Object localObject1 = localObject2;
    if (this.connection != null)
    {
      if (paramBoolean1) {
        this.connection.noNewStreams = true;
      }
      localObject1 = localObject2;
      if (this.codec == null) {
        if (!this.released)
        {
          localObject1 = localObject2;
          if (!this.connection.noNewStreams) {}
        }
        else
        {
          release(this.connection);
          if (!this.connection.allocations.isEmpty()) {
            break label167;
          }
          this.connection.idleAtNanos = System.nanoTime();
          if (!Internal.instance.connectionBecameIdle(this.connectionPool, this.connection)) {
            break label167;
          }
        }
      }
    }
    label167:
    for (localObject1 = this.connection.socket();; localObject1 = null)
    {
      this.connection = null;
      return localObject1;
    }
  }
  
  private RealConnection findConnection(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    throws IOException
  {
    int j = 0;
    Object localObject6 = null;
    Route localRoute = null;
    synchronized (this.connectionPool)
    {
      if (this.released) {
        throw new IllegalStateException("released");
      }
    }
    if (this.codec != null) {
      throw new IllegalStateException("codec != null");
    }
    if (this.canceled) {
      throw new IOException("Canceled");
    }
    Object localObject2 = this.connection;
    Socket localSocket = releaseIfNoNewStreams();
    if (this.connection != null)
    {
      localObject6 = this.connection;
      localObject2 = null;
    }
    ??? = localObject2;
    if (!this.reportedAcquired) {
      ??? = null;
    }
    Object localObject7 = localObject6;
    localObject2 = localRoute;
    int i = j;
    if (localObject6 == null)
    {
      Internal.instance.get(this.connectionPool, this.address, this, null);
      if (this.connection == null) {
        break label236;
      }
      i = 1;
      localObject7 = this.connection;
      localObject2 = localRoute;
    }
    for (;;)
    {
      Util.closeQuietly(localSocket);
      if (??? != null) {
        this.eventListener.connectionReleased(this.call, (Connection)???);
      }
      if (i != 0) {
        this.eventListener.connectionAcquired(this.call, (Connection)localObject7);
      }
      if (localObject7 == null) {
        break;
      }
      this.route = this.connection.route();
      return localObject7;
      label236:
      localObject2 = this.route;
      localObject7 = localObject6;
      i = j;
    }
    int k = 0;
    j = k;
    if (localObject2 == null) {
      if (this.routeSelection != null)
      {
        j = k;
        if (this.routeSelection.hasNext()) {}
      }
      else
      {
        j = 1;
        this.routeSelection = this.routeSelector.next();
      }
    }
    synchronized (this.connectionPool)
    {
      if (this.canceled) {
        throw new IOException("Canceled");
      }
    }
    if (j != 0)
    {
      localObject6 = this.routeSelection.getAll();
      k = ((List)localObject6).size();
      j = 0;
      if (j < k)
      {
        localRoute = (Route)((List)localObject6).get(j);
        Internal.instance.get(this.connectionPool, this.address, this, localRoute);
        if (this.connection != null)
        {
          i = 1;
          localObject6 = this.connection;
          this.route = localRoute;
        }
      }
    }
    for (;;)
    {
      Object localObject4;
      if (i == 0)
      {
        if (localObject3 != null) {
          break label634;
        }
        localObject4 = this.routeSelection.next();
      }
      label634:
      for (;;)
      {
        this.route = ((Route)localObject4);
        this.refusedStreamCount = 0;
        localObject6 = new RealConnection(this.connectionPool, (Route)localObject4);
        acquire((RealConnection)localObject6, false);
        if (i != 0)
        {
          this.eventListener.connectionAcquired(this.call, (Connection)localObject6);
          return localObject6;
          j += 1;
          break;
        }
        ((RealConnection)localObject6).connect(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, this.call, this.eventListener);
        routeDatabase().connected(((RealConnection)localObject6).route());
        localObject7 = null;
        synchronized (this.connectionPool)
        {
          this.reportedAcquired = true;
          Internal.instance.put(this.connectionPool, (RealConnection)localObject6);
          localObject4 = localObject6;
          if (((RealConnection)localObject6).isMultiplexed())
          {
            localObject7 = Internal.instance.deduplicate(this.connectionPool, this.address, this);
            localObject4 = this.connection;
          }
          Util.closeQuietly((Socket)localObject7);
          this.eventListener.connectionAcquired(this.call, (Connection)localObject4);
          return localObject4;
        }
      }
      localObject6 = localObject7;
    }
  }
  
  private RealConnection findHealthyConnection(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    for (;;)
    {
      RealConnection localRealConnection1 = findConnection(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1);
      synchronized (this.connectionPool)
      {
        if ((localRealConnection1.successCount == 0) && (!localRealConnection1.isMultiplexed())) {
          return localRealConnection1;
        }
        if (!localRealConnection1.isHealthy(paramBoolean2)) {
          noNewStreams();
        }
      }
    }
    return localRealConnection2;
  }
  
  private void release(RealConnection paramRealConnection)
  {
    int j = paramRealConnection.allocations.size();
    int i = 0;
    while (i < j)
    {
      if (((Reference)paramRealConnection.allocations.get(i)).get() == this)
      {
        paramRealConnection.allocations.remove(i);
        return;
      }
      i += 1;
    }
    throw new IllegalStateException();
  }
  
  private Socket releaseIfNoNewStreams()
  {
    assert (Thread.holdsLock(this.connectionPool));
    RealConnection localRealConnection = this.connection;
    if ((localRealConnection != null) && (localRealConnection.noNewStreams)) {
      return deallocate(false, false, true);
    }
    return null;
  }
  
  private RouteDatabase routeDatabase()
  {
    return Internal.instance.routeDatabase(this.connectionPool);
  }
  
  public void acquire(RealConnection paramRealConnection, boolean paramBoolean)
  {
    assert (Thread.holdsLock(this.connectionPool));
    if (this.connection != null) {
      throw new IllegalStateException();
    }
    this.connection = paramRealConnection;
    this.reportedAcquired = paramBoolean;
    paramRealConnection.allocations.add(new StreamAllocationReference(this, this.callStackTrace));
  }
  
  public void cancel()
  {
    RealConnection localRealConnection;
    do
    {
      synchronized (this.connectionPool)
      {
        this.canceled = true;
        HttpCodec localHttpCodec = this.codec;
        localRealConnection = this.connection;
        if (localHttpCodec != null)
        {
          localHttpCodec.cancel();
          return;
        }
      }
    } while (localRealConnection == null);
    localRealConnection.cancel();
  }
  
  public HttpCodec codec()
  {
    synchronized (this.connectionPool)
    {
      HttpCodec localHttpCodec = this.codec;
      return localHttpCodec;
    }
  }
  
  public RealConnection connection()
  {
    try
    {
      RealConnection localRealConnection = this.connection;
      return localRealConnection;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean hasMoreRoutes()
  {
    return (this.route != null) || ((this.routeSelection != null) && (this.routeSelection.hasNext())) || (this.routeSelector.hasNext());
  }
  
  /* Error */
  public HttpCodec newStream(okhttp3.OkHttpClient arg1, okhttp3.Interceptor.Chain paramChain, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokeinterface 282 1 0
    //   6: istore 4
    //   8: aload_2
    //   9: invokeinterface 285 1 0
    //   14: istore 5
    //   16: aload_2
    //   17: invokeinterface 288 1 0
    //   22: istore 6
    //   24: aload_1
    //   25: invokevirtual 293	okhttp3/OkHttpClient:pingIntervalMillis	()I
    //   28: istore 7
    //   30: aload_1
    //   31: invokevirtual 296	okhttp3/OkHttpClient:retryOnConnectionFailure	()Z
    //   34: istore 8
    //   36: aload_0
    //   37: iload 4
    //   39: iload 5
    //   41: iload 6
    //   43: iload 7
    //   45: iload 8
    //   47: iload_3
    //   48: invokespecial 298	okhttp3/internal/connection/StreamAllocation:findHealthyConnection	(IIIIZZ)Lokhttp3/internal/connection/RealConnection;
    //   51: aload_1
    //   52: aload_2
    //   53: aload_0
    //   54: invokevirtual 302	okhttp3/internal/connection/RealConnection:newCodec	(Lokhttp3/OkHttpClient;Lokhttp3/Interceptor$Chain;Lokhttp3/internal/connection/StreamAllocation;)Lokhttp3/internal/http/HttpCodec;
    //   57: astore_2
    //   58: aload_0
    //   59: getfield 51	okhttp3/internal/connection/StreamAllocation:connectionPool	Lokhttp3/ConnectionPool;
    //   62: astore_1
    //   63: aload_1
    //   64: monitorenter
    //   65: aload_0
    //   66: aload_2
    //   67: putfield 83	okhttp3/internal/connection/StreamAllocation:codec	Lokhttp3/internal/http/HttpCodec;
    //   70: aload_1
    //   71: monitorexit
    //   72: aload_2
    //   73: areturn
    //   74: astore_2
    //   75: aload_1
    //   76: monitorexit
    //   77: aload_2
    //   78: athrow
    //   79: astore_1
    //   80: new 304	okhttp3/internal/connection/RouteException
    //   83: dup
    //   84: aload_1
    //   85: invokespecial 307	okhttp3/internal/connection/RouteException:<init>	(Ljava/io/IOException;)V
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	StreamAllocation
    //   0	89	2	paramChain	okhttp3.Interceptor.Chain
    //   0	89	3	paramBoolean	boolean
    //   6	32	4	i	int
    //   14	26	5	j	int
    //   22	20	6	k	int
    //   28	16	7	m	int
    //   34	12	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   65	72	74	finally
    //   75	77	74	finally
    //   36	65	79	java/io/IOException
    //   77	79	79	java/io/IOException
  }
  
  public void noNewStreams()
  {
    synchronized (this.connectionPool)
    {
      RealConnection localRealConnection = this.connection;
      Socket localSocket = deallocate(true, false, false);
      if (this.connection != null) {
        localRealConnection = null;
      }
      Util.closeQuietly(localSocket);
      if (localRealConnection != null) {
        this.eventListener.connectionReleased(this.call, localRealConnection);
      }
      return;
    }
  }
  
  public void release()
  {
    synchronized (this.connectionPool)
    {
      RealConnection localRealConnection = this.connection;
      Socket localSocket = deallocate(false, true, false);
      if (this.connection != null) {
        localRealConnection = null;
      }
      Util.closeQuietly(localSocket);
      if (localRealConnection != null)
      {
        Internal.instance.timeoutExit(this.call, null);
        this.eventListener.connectionReleased(this.call, localRealConnection);
        this.eventListener.callEnd(this.call);
      }
      return;
    }
  }
  
  public Socket releaseAndAcquire(RealConnection paramRealConnection)
  {
    assert (Thread.holdsLock(this.connectionPool));
    if ((this.codec != null) || (this.connection.allocations.size() != 1)) {
      throw new IllegalStateException();
    }
    Reference localReference = (Reference)this.connection.allocations.get(0);
    Socket localSocket = deallocate(true, false, false);
    this.connection = paramRealConnection;
    paramRealConnection.allocations.add(localReference);
    return localSocket;
  }
  
  public Route route()
  {
    return this.route;
  }
  
  public void streamFailed(IOException paramIOException)
  {
    boolean bool2 = false;
    boolean bool1 = true;
    for (;;)
    {
      synchronized (this.connectionPool)
      {
        if ((paramIOException instanceof StreamResetException))
        {
          paramIOException = ((StreamResetException)paramIOException).errorCode;
          if (paramIOException == ErrorCode.REFUSED_STREAM)
          {
            this.refusedStreamCount += 1;
            if (this.refusedStreamCount <= 1) {
              break label209;
            }
            this.route = null;
            break label211;
            paramIOException = this.connection;
            Socket localSocket = deallocate(bool1, false, true);
            if ((this.connection != null) || (!this.reportedAcquired)) {
              break label214;
            }
            Util.closeQuietly(localSocket);
            if (paramIOException != null) {
              this.eventListener.connectionReleased(this.call, paramIOException);
            }
            return;
          }
          if (paramIOException == ErrorCode.CANCEL) {
            break label209;
          }
          this.route = null;
        }
      }
      bool1 = bool2;
      if (this.connection != null) {
        if (this.connection.isMultiplexed())
        {
          bool1 = bool2;
          if (!(paramIOException instanceof ConnectionShutdownException)) {}
        }
        else
        {
          if (this.connection.successCount == 0)
          {
            if ((this.route != null) && (paramIOException != null)) {
              this.routeSelector.connectFailed(this.route, paramIOException);
            }
            this.route = null;
          }
          bool1 = true;
          continue;
          label209:
          bool1 = false;
          label211:
          continue;
          label214:
          paramIOException = null;
        }
      }
    }
  }
  
  /* Error */
  public void streamFinished(boolean paramBoolean, HttpCodec paramHttpCodec, long paramLong, IOException paramIOException)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 57	okhttp3/internal/connection/StreamAllocation:eventListener	Lokhttp3/EventListener;
    //   4: aload_0
    //   5: getfield 55	okhttp3/internal/connection/StreamAllocation:call	Lokhttp3/Call;
    //   8: lload_3
    //   9: invokevirtual 344	okhttp3/EventListener:responseBodyEnd	(Lokhttp3/Call;J)V
    //   12: aload_0
    //   13: getfield 51	okhttp3/internal/connection/StreamAllocation:connectionPool	Lokhttp3/ConnectionPool;
    //   16: astore 6
    //   18: aload 6
    //   20: monitorenter
    //   21: aload_2
    //   22: ifnull +11 -> 33
    //   25: aload_2
    //   26: aload_0
    //   27: getfield 83	okhttp3/internal/connection/StreamAllocation:codec	Lokhttp3/internal/http/HttpCodec;
    //   30: if_acmpeq +50 -> 80
    //   33: new 135	java/lang/IllegalStateException
    //   36: dup
    //   37: new 346	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 347	java/lang/StringBuilder:<init>	()V
    //   44: ldc_w 349
    //   47: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_0
    //   51: getfield 83	okhttp3/internal/connection/StreamAllocation:codec	Lokhttp3/internal/http/HttpCodec;
    //   54: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   57: ldc_w 358
    //   60: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_2
    //   64: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokespecial 139	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   73: athrow
    //   74: astore_2
    //   75: aload 6
    //   77: monitorexit
    //   78: aload_2
    //   79: athrow
    //   80: iload_1
    //   81: ifne +18 -> 99
    //   84: aload_0
    //   85: getfield 87	okhttp3/internal/connection/StreamAllocation:connection	Lokhttp3/internal/connection/RealConnection;
    //   88: astore_2
    //   89: aload_2
    //   90: aload_2
    //   91: getfield 239	okhttp3/internal/connection/RealConnection:successCount	I
    //   94: iconst_1
    //   95: iadd
    //   96: putfield 239	okhttp3/internal/connection/RealConnection:successCount	I
    //   99: aload_0
    //   100: getfield 87	okhttp3/internal/connection/StreamAllocation:connection	Lokhttp3/internal/connection/RealConnection;
    //   103: astore_2
    //   104: aload_0
    //   105: iload_1
    //   106: iconst_0
    //   107: iconst_1
    //   108: invokespecial 256	okhttp3/internal/connection/StreamAllocation:deallocate	(ZZZ)Ljava/net/Socket;
    //   111: astore 7
    //   113: aload_0
    //   114: getfield 87	okhttp3/internal/connection/StreamAllocation:connection	Lokhttp3/internal/connection/RealConnection;
    //   117: ifnull +5 -> 122
    //   120: aconst_null
    //   121: astore_2
    //   122: aload_0
    //   123: getfield 85	okhttp3/internal/connection/StreamAllocation:released	Z
    //   126: istore_1
    //   127: aload 6
    //   129: monitorexit
    //   130: aload 7
    //   132: invokestatic 161	okhttp3/internal/Util:closeQuietly	(Ljava/net/Socket;)V
    //   135: aload_2
    //   136: ifnull +15 -> 151
    //   139: aload_0
    //   140: getfield 57	okhttp3/internal/connection/StreamAllocation:eventListener	Lokhttp3/EventListener;
    //   143: aload_0
    //   144: getfield 55	okhttp3/internal/connection/StreamAllocation:call	Lokhttp3/Call;
    //   147: aload_2
    //   148: invokevirtual 167	okhttp3/EventListener:connectionReleased	(Lokhttp3/Call;Lokhttp3/Connection;)V
    //   151: aload 5
    //   153: ifnull +29 -> 182
    //   156: getstatic 121	okhttp3/internal/Internal:instance	Lokhttp3/internal/Internal;
    //   159: aload_0
    //   160: getfield 55	okhttp3/internal/connection/StreamAllocation:call	Lokhttp3/Call;
    //   163: aload 5
    //   165: invokevirtual 311	okhttp3/internal/Internal:timeoutExit	(Lokhttp3/Call;Ljava/io/IOException;)Ljava/io/IOException;
    //   168: astore_2
    //   169: aload_0
    //   170: getfield 57	okhttp3/internal/connection/StreamAllocation:eventListener	Lokhttp3/EventListener;
    //   173: aload_0
    //   174: getfield 55	okhttp3/internal/connection/StreamAllocation:call	Lokhttp3/Call;
    //   177: aload_2
    //   178: invokevirtual 366	okhttp3/EventListener:callFailed	(Lokhttp3/Call;Ljava/io/IOException;)V
    //   181: return
    //   182: iload_1
    //   183: ifeq -2 -> 181
    //   186: getstatic 121	okhttp3/internal/Internal:instance	Lokhttp3/internal/Internal;
    //   189: aload_0
    //   190: getfield 55	okhttp3/internal/connection/StreamAllocation:call	Lokhttp3/Call;
    //   193: aconst_null
    //   194: invokevirtual 311	okhttp3/internal/Internal:timeoutExit	(Lokhttp3/Call;Ljava/io/IOException;)Ljava/io/IOException;
    //   197: pop
    //   198: aload_0
    //   199: getfield 57	okhttp3/internal/connection/StreamAllocation:eventListener	Lokhttp3/EventListener;
    //   202: aload_0
    //   203: getfield 55	okhttp3/internal/connection/StreamAllocation:call	Lokhttp3/Call;
    //   206: invokevirtual 315	okhttp3/EventListener:callEnd	(Lokhttp3/Call;)V
    //   209: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	StreamAllocation
    //   0	210	1	paramBoolean	boolean
    //   0	210	2	paramHttpCodec	HttpCodec
    //   0	210	3	paramLong	long
    //   0	210	5	paramIOException	IOException
    //   16	112	6	localConnectionPool	ConnectionPool
    //   111	20	7	localSocket	Socket
    // Exception table:
    //   from	to	target	type
    //   25	33	74	finally
    //   33	74	74	finally
    //   75	78	74	finally
    //   84	99	74	finally
    //   99	113	74	finally
    //   113	120	74	finally
    //   122	130	74	finally
  }
  
  public String toString()
  {
    RealConnection localRealConnection = connection();
    if (localRealConnection != null) {
      return localRealConnection.toString();
    }
    return this.address.toString();
  }
  
  public static final class StreamAllocationReference
    extends WeakReference<StreamAllocation>
  {
    public final Object callStackTrace;
    
    StreamAllocationReference(StreamAllocation paramStreamAllocation, Object paramObject)
    {
      super();
      this.callStackTrace = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.internal.connection.StreamAllocation
 * JD-Core Version:    0.7.0.1
 */