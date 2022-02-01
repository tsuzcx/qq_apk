package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.Util;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

public final class FramedConnection
  implements Closeable
{
  private static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
  private static final ExecutorService executor;
  long bytesLeftInWriteWindow;
  final boolean client;
  private final Set<Integer> currentPushRequests = new LinkedHashSet();
  final FrameWriter frameWriter;
  private final String hostName;
  private long idleStartTimeNs = System.nanoTime();
  private int lastGoodStreamId;
  private final Listener listener;
  private int nextPingId;
  private int nextStreamId;
  Settings okHttpSettings = new Settings();
  final Settings peerSettings = new Settings();
  private Map<Integer, Ping> pings;
  final Protocol protocol;
  private final ExecutorService pushExecutor;
  private final PushObserver pushObserver;
  final Reader readerRunnable;
  private boolean receivedInitialPeerSettings = false;
  private boolean shutdown;
  final Socket socket;
  private final Map<Integer, FramedStream> streams = new HashMap();
  long unacknowledgedBytesRead = 0L;
  final Variant variant;
  
  static
  {
    if (!FramedConnection.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      executor = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp FramedConnection", true));
      return;
    }
  }
  
  private FramedConnection(Builder paramBuilder)
    throws IOException
  {
    this.protocol = paramBuilder.protocol;
    this.pushObserver = paramBuilder.pushObserver;
    this.client = paramBuilder.client;
    this.listener = paramBuilder.listener;
    int i;
    if (paramBuilder.client)
    {
      i = 1;
      this.nextStreamId = i;
      if ((paramBuilder.client) && (this.protocol == Protocol.HTTP_2)) {
        this.nextStreamId += 2;
      }
      i = j;
      if (paramBuilder.client) {
        i = 1;
      }
      this.nextPingId = i;
      if (paramBuilder.client) {
        this.okHttpSettings.set(7, 0, 16777216);
      }
      this.hostName = paramBuilder.hostName;
      if (this.protocol != Protocol.HTTP_2) {
        break label370;
      }
      this.variant = new Http2();
      this.pushExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(String.format("OkHttp %s Push Observer", new Object[] { this.hostName }), true));
      this.peerSettings.set(7, 0, 65535);
      this.peerSettings.set(5, 0, 16384);
    }
    for (;;)
    {
      this.bytesLeftInWriteWindow = this.peerSettings.getInitialWindowSize(65536);
      this.socket = paramBuilder.socket;
      this.frameWriter = this.variant.newWriter(paramBuilder.sink, this.client);
      this.readerRunnable = new Reader(this.variant.newReader(paramBuilder.source, this.client), null);
      new Thread(this.readerRunnable).start();
      return;
      i = 2;
      break;
      label370:
      if (this.protocol != Protocol.SPDY_3) {
        break label399;
      }
      this.variant = new Spdy3();
      this.pushExecutor = null;
    }
    label399:
    throw new AssertionError(this.protocol);
  }
  
  /* Error */
  private void close(ErrorCode paramErrorCode1, ErrorCode paramErrorCode2)
    throws IOException
  {
    // Byte code:
    //   0: getstatic 70	com/squareup/okhttp/internal/framed/FramedConnection:$assertionsDisabled	Z
    //   3: ifne +18 -> 21
    //   6: aload_0
    //   7: invokestatic 339	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   10: ifeq +11 -> 21
    //   13: new 249	java/lang/AssertionError
    //   16: dup
    //   17: invokespecial 340	java/lang/AssertionError:<init>	()V
    //   20: athrow
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 343	com/squareup/okhttp/internal/framed/FramedConnection:shutdown	(Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
    //   26: aconst_null
    //   27: astore_1
    //   28: aload_0
    //   29: monitorenter
    //   30: aload_0
    //   31: getfield 109	com/squareup/okhttp/internal/framed/FramedConnection:streams	Ljava/util/Map;
    //   34: invokeinterface 348 1 0
    //   39: ifne +247 -> 286
    //   42: aload_0
    //   43: getfield 109	com/squareup/okhttp/internal/framed/FramedConnection:streams	Ljava/util/Map;
    //   46: invokeinterface 352 1 0
    //   51: aload_0
    //   52: getfield 109	com/squareup/okhttp/internal/framed/FramedConnection:streams	Ljava/util/Map;
    //   55: invokeinterface 356 1 0
    //   60: anewarray 358	com/squareup/okhttp/internal/framed/FramedStream
    //   63: invokeinterface 364 2 0
    //   68: checkcast 366	[Lcom/squareup/okhttp/internal/framed/FramedStream;
    //   71: astore 6
    //   73: aload_0
    //   74: getfield 109	com/squareup/okhttp/internal/framed/FramedConnection:streams	Ljava/util/Map;
    //   77: invokeinterface 369 1 0
    //   82: aload_0
    //   83: iconst_0
    //   84: invokespecial 373	com/squareup/okhttp/internal/framed/FramedConnection:setIdle	(Z)V
    //   87: aload_0
    //   88: getfield 375	com/squareup/okhttp/internal/framed/FramedConnection:pings	Ljava/util/Map;
    //   91: ifnull +189 -> 280
    //   94: aload_0
    //   95: getfield 375	com/squareup/okhttp/internal/framed/FramedConnection:pings	Ljava/util/Map;
    //   98: invokeinterface 352 1 0
    //   103: aload_0
    //   104: getfield 375	com/squareup/okhttp/internal/framed/FramedConnection:pings	Ljava/util/Map;
    //   107: invokeinterface 356 1 0
    //   112: anewarray 377	com/squareup/okhttp/internal/framed/Ping
    //   115: invokeinterface 364 2 0
    //   120: checkcast 379	[Lcom/squareup/okhttp/internal/framed/Ping;
    //   123: astore 7
    //   125: aload_0
    //   126: aconst_null
    //   127: putfield 375	com/squareup/okhttp/internal/framed/FramedConnection:pings	Ljava/util/Map;
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: astore 5
    //   135: aload 6
    //   137: ifnull +69 -> 206
    //   140: aload 6
    //   142: arraylength
    //   143: istore 4
    //   145: iconst_0
    //   146: istore_3
    //   147: iload_3
    //   148: iload 4
    //   150: if_icmpge +53 -> 203
    //   153: aload 6
    //   155: iload_3
    //   156: aaload
    //   157: astore 5
    //   159: aload 5
    //   161: aload_2
    //   162: invokevirtual 381	com/squareup/okhttp/internal/framed/FramedStream:close	(Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
    //   165: aload_1
    //   166: astore 5
    //   168: iload_3
    //   169: iconst_1
    //   170: iadd
    //   171: istore_3
    //   172: aload 5
    //   174: astore_1
    //   175: goto -28 -> 147
    //   178: astore_1
    //   179: goto -151 -> 28
    //   182: astore_1
    //   183: aload_0
    //   184: monitorexit
    //   185: aload_1
    //   186: athrow
    //   187: astore 8
    //   189: aload_1
    //   190: astore 5
    //   192: aload_1
    //   193: ifnull -25 -> 168
    //   196: aload 8
    //   198: astore 5
    //   200: goto -32 -> 168
    //   203: aload_1
    //   204: astore 5
    //   206: aload 7
    //   208: ifnull +30 -> 238
    //   211: aload 7
    //   213: arraylength
    //   214: istore 4
    //   216: iconst_0
    //   217: istore_3
    //   218: iload_3
    //   219: iload 4
    //   221: if_icmpge +17 -> 238
    //   224: aload 7
    //   226: iload_3
    //   227: aaload
    //   228: invokevirtual 384	com/squareup/okhttp/internal/framed/Ping:cancel	()V
    //   231: iload_3
    //   232: iconst_1
    //   233: iadd
    //   234: istore_3
    //   235: goto -17 -> 218
    //   238: aload_0
    //   239: getfield 220	com/squareup/okhttp/internal/framed/FramedConnection:frameWriter	Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   242: invokeinterface 388 1 0
    //   247: aload 5
    //   249: astore_1
    //   250: aload_0
    //   251: getfield 208	com/squareup/okhttp/internal/framed/FramedConnection:socket	Ljava/net/Socket;
    //   254: invokevirtual 391	java/net/Socket:close	()V
    //   257: aload_1
    //   258: ifnull +17 -> 275
    //   261: aload_1
    //   262: athrow
    //   263: astore_1
    //   264: aload 5
    //   266: ifnull -16 -> 250
    //   269: aload 5
    //   271: astore_1
    //   272: goto -22 -> 250
    //   275: return
    //   276: astore_1
    //   277: goto -20 -> 257
    //   280: aconst_null
    //   281: astore 7
    //   283: goto -153 -> 130
    //   286: aconst_null
    //   287: astore 6
    //   289: goto -202 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	FramedConnection
    //   0	292	1	paramErrorCode1	ErrorCode
    //   0	292	2	paramErrorCode2	ErrorCode
    //   146	89	3	i	int
    //   143	79	4	j	int
    //   133	137	5	localObject	Object
    //   71	217	6	arrayOfFramedStream	FramedStream[]
    //   123	159	7	arrayOfPing	Ping[]
    //   187	10	8	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   21	26	178	java/io/IOException
    //   30	87	182	finally
    //   87	130	182	finally
    //   130	132	182	finally
    //   183	185	182	finally
    //   159	165	187	java/io/IOException
    //   238	247	263	java/io/IOException
    //   250	257	276	java/io/IOException
  }
  
  private FramedStream newStream(int paramInt, List<Header> paramList, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    boolean bool2 = true;
    boolean bool1;
    if (!paramBoolean1)
    {
      bool1 = true;
      if (paramBoolean2) {
        break label65;
      }
    }
    label65:
    for (paramBoolean2 = bool2;; paramBoolean2 = false)
    {
      synchronized (this.frameWriter)
      {
        try
        {
          if (!this.shutdown) {
            break label71;
          }
          throw new IOException("shutdown");
        }
        finally {}
      }
      bool1 = false;
      break;
    }
    label71:
    int i = this.nextStreamId;
    this.nextStreamId += 2;
    FramedStream localFramedStream = new FramedStream(i, this, bool1, paramBoolean2, paramList);
    if (localFramedStream.isOpen())
    {
      this.streams.put(Integer.valueOf(i), localFramedStream);
      setIdle(false);
    }
    if (paramInt == 0) {
      this.frameWriter.synStream(bool1, paramBoolean2, i, paramInt, paramList);
    }
    for (;;)
    {
      if (!paramBoolean1) {
        this.frameWriter.flush();
      }
      return localFramedStream;
      if (this.client) {
        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
      }
      this.frameWriter.pushPromise(paramInt, i, paramList);
    }
  }
  
  private void pushDataLater(int paramInt1, BufferedSource paramBufferedSource, int paramInt2, boolean paramBoolean)
    throws IOException
  {
    Buffer localBuffer = new Buffer();
    paramBufferedSource.require(paramInt2);
    paramBufferedSource.read(localBuffer, paramInt2);
    if (localBuffer.size() != paramInt2) {
      throw new IOException(localBuffer.size() + " != " + paramInt2);
    }
    this.pushExecutor.execute(new FramedConnection.6(this, "OkHttp %s Push Data[%s]", new Object[] { this.hostName, Integer.valueOf(paramInt1) }, paramInt1, localBuffer, paramInt2, paramBoolean));
  }
  
  private void pushHeadersLater(int paramInt, List<Header> paramList, boolean paramBoolean)
  {
    this.pushExecutor.execute(new FramedConnection.5(this, "OkHttp %s Push Headers[%s]", new Object[] { this.hostName, Integer.valueOf(paramInt) }, paramInt, paramList, paramBoolean));
  }
  
  private void pushRequestLater(int paramInt, List<Header> paramList)
  {
    try
    {
      if (this.currentPushRequests.contains(Integer.valueOf(paramInt)))
      {
        writeSynResetLater(paramInt, ErrorCode.PROTOCOL_ERROR);
        return;
      }
      this.currentPushRequests.add(Integer.valueOf(paramInt));
      this.pushExecutor.execute(new FramedConnection.4(this, "OkHttp %s Push Request[%s]", new Object[] { this.hostName, Integer.valueOf(paramInt) }, paramInt, paramList));
      return;
    }
    finally {}
  }
  
  private void pushResetLater(int paramInt, ErrorCode paramErrorCode)
  {
    this.pushExecutor.execute(new FramedConnection.7(this, "OkHttp %s Push Reset[%s]", new Object[] { this.hostName, Integer.valueOf(paramInt) }, paramInt, paramErrorCode));
  }
  
  private boolean pushedStream(int paramInt)
  {
    return (this.protocol == Protocol.HTTP_2) && (paramInt != 0) && ((paramInt & 0x1) == 0);
  }
  
  /* Error */
  private Ping removePing(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 375	com/squareup/okhttp/internal/framed/FramedConnection:pings	Ljava/util/Map;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 375	com/squareup/okhttp/internal/framed/FramedConnection:pings	Ljava/util/Map;
    //   13: iload_1
    //   14: invokestatic 409	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: invokeinterface 521 2 0
    //   22: checkcast 377	com/squareup/okhttp/internal/framed/Ping
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: areturn
    //   30: aconst_null
    //   31: astore_2
    //   32: goto -6 -> 26
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	FramedConnection
    //   0	40	1	paramInt	int
    //   25	7	2	localPing	Ping
    //   35	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	35	finally
  }
  
  private void setIdle(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        l = System.nanoTime();
        this.idleStartTimeNs = l;
        return;
      }
      finally {}
      long l = 9223372036854775807L;
    }
  }
  
  private void writePing(boolean paramBoolean, int paramInt1, int paramInt2, Ping paramPing)
    throws IOException
  {
    FrameWriter localFrameWriter = this.frameWriter;
    if (paramPing != null) {}
    try
    {
      paramPing.send();
      this.frameWriter.ping(paramBoolean, paramInt1, paramInt2);
      return;
    }
    finally {}
  }
  
  private void writePingLater(boolean paramBoolean, int paramInt1, int paramInt2, Ping paramPing)
  {
    executor.execute(new FramedConnection.3(this, "OkHttp %s ping %08x%08x", new Object[] { this.hostName, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, paramBoolean, paramInt1, paramInt2, paramPing));
  }
  
  void addBytesToWriteWindow(long paramLong)
  {
    this.bytesLeftInWriteWindow += paramLong;
    if (paramLong > 0L) {
      notifyAll();
    }
  }
  
  public void close()
    throws IOException
  {
    close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
  }
  
  public void flush()
    throws IOException
  {
    this.frameWriter.flush();
  }
  
  public long getIdleStartTimeNs()
  {
    try
    {
      long l = this.idleStartTimeNs;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Protocol getProtocol()
  {
    return this.protocol;
  }
  
  FramedStream getStream(int paramInt)
  {
    try
    {
      FramedStream localFramedStream = (FramedStream)this.streams.get(Integer.valueOf(paramInt));
      return localFramedStream;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean isIdle()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 117	com/squareup/okhttp/internal/framed/FramedConnection:idleStartTimeNs	J
    //   6: lstore_1
    //   7: lload_1
    //   8: ldc2_w 522
    //   11: lcmp
    //   12: ifeq +9 -> 21
    //   15: iconst_1
    //   16: istore_3
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_3
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_3
    //   23: goto -6 -> 17
    //   26: astore 4
    //   28: aload_0
    //   29: monitorexit
    //   30: aload 4
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	FramedConnection
    //   6	2	1	l	long
    //   16	7	3	bool	boolean
    //   26	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	26	finally
  }
  
  public int maxConcurrentStreams()
  {
    try
    {
      int i = this.peerSettings.getMaxConcurrentStreams(2147483647);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public FramedStream newStream(List<Header> paramList, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    return newStream(0, paramList, paramBoolean1, paramBoolean2);
  }
  
  public int openStreamCount()
  {
    try
    {
      int i = this.streams.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Ping ping()
    throws IOException
  {
    Ping localPing = new Ping();
    try
    {
      if (this.shutdown) {
        throw new IOException("shutdown");
      }
    }
    finally {}
    int i = this.nextPingId;
    this.nextPingId += 2;
    if (this.pings == null) {
      this.pings = new HashMap();
    }
    this.pings.put(Integer.valueOf(i), localObject);
    writePing(false, i, 1330343787, localObject);
    return localObject;
  }
  
  public FramedStream pushStream(int paramInt, List<Header> paramList, boolean paramBoolean)
    throws IOException
  {
    if (this.client) {
      throw new IllegalStateException("Client cannot push requests.");
    }
    if (this.protocol != Protocol.HTTP_2) {
      throw new IllegalStateException("protocol != HTTP_2");
    }
    return newStream(paramInt, paramList, paramBoolean, false);
  }
  
  FramedStream removeStream(int paramInt)
  {
    try
    {
      FramedStream localFramedStream = (FramedStream)this.streams.remove(Integer.valueOf(paramInt));
      if ((localFramedStream != null) && (this.streams.isEmpty())) {
        setIdle(true);
      }
      notifyAll();
      return localFramedStream;
    }
    finally {}
  }
  
  public void sendConnectionPreface()
    throws IOException
  {
    this.frameWriter.connectionPreface();
    this.frameWriter.settings(this.okHttpSettings);
    int i = this.okHttpSettings.getInitialWindowSize(65536);
    if (i != 65536) {
      this.frameWriter.windowUpdate(0, i - 65536);
    }
  }
  
  public void setSettings(Settings paramSettings)
    throws IOException
  {
    synchronized (this.frameWriter)
    {
      try
      {
        if (this.shutdown) {
          throw new IOException("shutdown");
        }
      }
      finally {}
    }
    this.okHttpSettings.merge(paramSettings);
    this.frameWriter.settings(paramSettings);
  }
  
  public void shutdown(ErrorCode paramErrorCode)
    throws IOException
  {
    int i;
    synchronized (this.frameWriter) {}
  }
  
  public void writeData(int paramInt, boolean paramBoolean, Buffer paramBuffer, long paramLong)
    throws IOException
  {
    long l = paramLong;
    if (paramLong == 0L)
    {
      this.frameWriter.data(paramBoolean, paramInt, paramBuffer, 0);
      return;
    }
    for (;;)
    {
      try
      {
        int i = Math.min((int)Math.min(l, this.bytesLeftInWriteWindow), this.frameWriter.maxDataLength());
        this.bytesLeftInWriteWindow -= i;
        l -= i;
        FrameWriter localFrameWriter = this.frameWriter;
        if ((!paramBoolean) || (l != 0L)) {
          break label170;
        }
        bool = true;
        localFrameWriter.data(bool, paramInt, paramBuffer, i);
        if (l <= 0L) {
          break;
        }
        try
        {
          if (this.bytesLeftInWriteWindow > 0L) {
            continue;
          }
          if (!this.streams.containsKey(Integer.valueOf(paramInt))) {
            throw new IOException("stream closed");
          }
        }
        catch (InterruptedException paramBuffer)
        {
          throw new InterruptedIOException();
        }
        wait();
      }
      finally {}
      continue;
      label170:
      boolean bool = false;
    }
  }
  
  void writeSynReply(int paramInt, boolean paramBoolean, List<Header> paramList)
    throws IOException
  {
    this.frameWriter.synReply(paramBoolean, paramInt, paramList);
  }
  
  void writeSynReset(int paramInt, ErrorCode paramErrorCode)
    throws IOException
  {
    this.frameWriter.rstStream(paramInt, paramErrorCode);
  }
  
  void writeSynResetLater(int paramInt, ErrorCode paramErrorCode)
  {
    executor.submit(new FramedConnection.1(this, "OkHttp %s stream %d", new Object[] { this.hostName, Integer.valueOf(paramInt) }, paramInt, paramErrorCode));
  }
  
  void writeWindowUpdateLater(int paramInt, long paramLong)
  {
    executor.execute(new FramedConnection.2(this, "OkHttp Window Update %s stream %d", new Object[] { this.hostName, Integer.valueOf(paramInt) }, paramInt, paramLong));
  }
  
  public static class Builder
  {
    private boolean client;
    private String hostName;
    private FramedConnection.Listener listener = FramedConnection.Listener.REFUSE_INCOMING_STREAMS;
    private Protocol protocol = Protocol.SPDY_3;
    private PushObserver pushObserver = PushObserver.CANCEL;
    private BufferedSink sink;
    private Socket socket;
    private BufferedSource source;
    
    public Builder(boolean paramBoolean)
      throws IOException
    {
      this.client = paramBoolean;
    }
    
    public FramedConnection build()
      throws IOException
    {
      return new FramedConnection(this, null);
    }
    
    public Builder listener(FramedConnection.Listener paramListener)
    {
      this.listener = paramListener;
      return this;
    }
    
    public Builder protocol(Protocol paramProtocol)
    {
      this.protocol = paramProtocol;
      return this;
    }
    
    public Builder pushObserver(PushObserver paramPushObserver)
    {
      this.pushObserver = paramPushObserver;
      return this;
    }
    
    public Builder socket(Socket paramSocket)
      throws IOException
    {
      return socket(paramSocket, ((InetSocketAddress)paramSocket.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(paramSocket)), Okio.buffer(Okio.sink(paramSocket)));
    }
    
    public Builder socket(Socket paramSocket, String paramString, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink)
    {
      this.socket = paramSocket;
      this.hostName = paramString;
      this.source = paramBufferedSource;
      this.sink = paramBufferedSink;
      return this;
    }
  }
  
  public static abstract class Listener
  {
    public static final Listener REFUSE_INCOMING_STREAMS = new FramedConnection.Listener.1();
    
    public void onSettings(FramedConnection paramFramedConnection) {}
    
    public abstract void onStream(FramedStream paramFramedStream)
      throws IOException;
  }
  
  class Reader
    extends NamedRunnable
    implements FrameReader.Handler
  {
    final FrameReader frameReader;
    
    private Reader(FrameReader paramFrameReader)
    {
      super(new Object[] { FramedConnection.this.hostName });
      this.frameReader = paramFrameReader;
    }
    
    private void ackSettingsLater(Settings paramSettings)
    {
      FramedConnection.executor.execute(new FramedConnection.Reader.3(this, "OkHttp %s ACK Settings", new Object[] { FramedConnection.this.hostName }, paramSettings));
    }
    
    public void ackSettings() {}
    
    public void alternateService(int paramInt1, String paramString1, ByteString paramByteString, String paramString2, int paramInt2, long paramLong) {}
    
    public void data(boolean paramBoolean, int paramInt1, BufferedSource paramBufferedSource, int paramInt2)
      throws IOException
    {
      if (FramedConnection.this.pushedStream(paramInt1)) {
        FramedConnection.this.pushDataLater(paramInt1, paramBufferedSource, paramInt2, paramBoolean);
      }
      FramedStream localFramedStream;
      do
      {
        return;
        localFramedStream = FramedConnection.this.getStream(paramInt1);
        if (localFramedStream == null)
        {
          FramedConnection.this.writeSynResetLater(paramInt1, ErrorCode.INVALID_STREAM);
          paramBufferedSource.skip(paramInt2);
          return;
        }
        localFramedStream.receiveData(paramBufferedSource, paramInt2);
      } while (!paramBoolean);
      localFramedStream.receiveFin();
    }
    
    /* Error */
    public void execute()
    {
      // Byte code:
      //   0: getstatic 102	com/squareup/okhttp/internal/framed/ErrorCode:INTERNAL_ERROR	Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   3: astore_3
      //   4: getstatic 102	com/squareup/okhttp/internal/framed/ErrorCode:INTERNAL_ERROR	Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   7: astore 4
      //   9: aload_3
      //   10: astore_2
      //   11: aload_3
      //   12: astore_1
      //   13: aload_0
      //   14: getfield 17	com/squareup/okhttp/internal/framed/FramedConnection$Reader:this$0	Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   17: getfield 106	com/squareup/okhttp/internal/framed/FramedConnection:client	Z
      //   20: ifne +16 -> 36
      //   23: aload_3
      //   24: astore_2
      //   25: aload_3
      //   26: astore_1
      //   27: aload_0
      //   28: getfield 30	com/squareup/okhttp/internal/framed/FramedConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/framed/FrameReader;
      //   31: invokeinterface 111 1 0
      //   36: aload_3
      //   37: astore_2
      //   38: aload_3
      //   39: astore_1
      //   40: aload_0
      //   41: getfield 30	com/squareup/okhttp/internal/framed/FramedConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/framed/FrameReader;
      //   44: aload_0
      //   45: invokeinterface 115 2 0
      //   50: ifne -14 -> 36
      //   53: aload_3
      //   54: astore_2
      //   55: aload_3
      //   56: astore_1
      //   57: getstatic 118	com/squareup/okhttp/internal/framed/ErrorCode:NO_ERROR	Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   60: astore_3
      //   61: aload_3
      //   62: astore_2
      //   63: aload_3
      //   64: astore_1
      //   65: getstatic 121	com/squareup/okhttp/internal/framed/ErrorCode:CANCEL	Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   68: astore 5
      //   70: aload_0
      //   71: getfield 17	com/squareup/okhttp/internal/framed/FramedConnection$Reader:this$0	Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   74: aload_3
      //   75: aload 5
      //   77: invokestatic 125	com/squareup/okhttp/internal/framed/FramedConnection:access$1200	(Lcom/squareup/okhttp/internal/framed/FramedConnection;Lcom/squareup/okhttp/internal/framed/ErrorCode;Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
      //   80: aload_0
      //   81: getfield 30	com/squareup/okhttp/internal/framed/FramedConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/framed/FrameReader;
      //   84: invokestatic 131	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
      //   87: return
      //   88: astore_1
      //   89: aload_2
      //   90: astore_1
      //   91: getstatic 134	com/squareup/okhttp/internal/framed/ErrorCode:PROTOCOL_ERROR	Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   94: astore_3
      //   95: getstatic 134	com/squareup/okhttp/internal/framed/ErrorCode:PROTOCOL_ERROR	Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   98: astore_1
      //   99: aload_0
      //   100: getfield 17	com/squareup/okhttp/internal/framed/FramedConnection$Reader:this$0	Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   103: aload_3
      //   104: aload_1
      //   105: invokestatic 125	com/squareup/okhttp/internal/framed/FramedConnection:access$1200	(Lcom/squareup/okhttp/internal/framed/FramedConnection;Lcom/squareup/okhttp/internal/framed/ErrorCode;Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
      //   108: aload_0
      //   109: getfield 30	com/squareup/okhttp/internal/framed/FramedConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/framed/FrameReader;
      //   112: invokestatic 131	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
      //   115: return
      //   116: astore_2
      //   117: aload_1
      //   118: astore_3
      //   119: aload_2
      //   120: astore_1
      //   121: aload_0
      //   122: getfield 17	com/squareup/okhttp/internal/framed/FramedConnection$Reader:this$0	Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   125: aload_3
      //   126: aload 4
      //   128: invokestatic 125	com/squareup/okhttp/internal/framed/FramedConnection:access$1200	(Lcom/squareup/okhttp/internal/framed/FramedConnection;Lcom/squareup/okhttp/internal/framed/ErrorCode;Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
      //   131: aload_0
      //   132: getfield 30	com/squareup/okhttp/internal/framed/FramedConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/framed/FrameReader;
      //   135: invokestatic 131	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
      //   138: aload_1
      //   139: athrow
      //   140: astore_2
      //   141: goto -10 -> 131
      //   144: astore_1
      //   145: goto -24 -> 121
      //   148: astore_1
      //   149: goto -41 -> 108
      //   152: astore_1
      //   153: goto -73 -> 80
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	156	0	this	Reader
      //   12	53	1	localObject1	Object
      //   88	1	1	localIOException1	IOException
      //   90	49	1	localObject2	Object
      //   144	1	1	localObject3	Object
      //   148	1	1	localIOException2	IOException
      //   152	1	1	localIOException3	IOException
      //   10	80	2	localObject4	Object
      //   116	4	2	localObject5	Object
      //   140	1	2	localIOException4	IOException
      //   3	123	3	localObject6	Object
      //   7	120	4	localErrorCode1	ErrorCode
      //   68	8	5	localErrorCode2	ErrorCode
      // Exception table:
      //   from	to	target	type
      //   13	23	88	java/io/IOException
      //   27	36	88	java/io/IOException
      //   40	53	88	java/io/IOException
      //   57	61	88	java/io/IOException
      //   65	70	88	java/io/IOException
      //   13	23	116	finally
      //   27	36	116	finally
      //   40	53	116	finally
      //   57	61	116	finally
      //   65	70	116	finally
      //   91	95	116	finally
      //   121	131	140	java/io/IOException
      //   95	99	144	finally
      //   99	108	148	java/io/IOException
      //   70	80	152	java/io/IOException
    }
    
    public void goAway(int paramInt, ErrorCode arg2, ByteString paramByteString)
    {
      if (paramByteString.size() > 0) {}
      synchronized (FramedConnection.this)
      {
        paramByteString = (FramedStream[])FramedConnection.this.streams.values().toArray(new FramedStream[FramedConnection.this.streams.size()]);
        FramedConnection.access$1602(FramedConnection.this, true);
        int j = paramByteString.length;
        int i = 0;
        if (i < j)
        {
          ??? = paramByteString[i];
          if ((???.getId() > paramInt) && (???.isLocallyInitiated()))
          {
            ???.receiveRstStream(ErrorCode.REFUSED_STREAM);
            FramedConnection.this.removeStream(???.getId());
          }
          i += 1;
        }
      }
    }
    
    public void headers(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<Header> paramList, HeadersMode paramHeadersMode)
    {
      if (FramedConnection.this.pushedStream(paramInt1)) {
        FramedConnection.this.pushHeadersLater(paramInt1, paramList, paramBoolean2);
      }
      FramedStream localFramedStream;
      do
      {
        return;
        synchronized (FramedConnection.this)
        {
          if (FramedConnection.this.shutdown) {
            return;
          }
        }
        localFramedStream = FramedConnection.this.getStream(paramInt1);
        if (localFramedStream == null)
        {
          if (paramHeadersMode.failIfStreamAbsent())
          {
            FramedConnection.this.writeSynResetLater(paramInt1, ErrorCode.INVALID_STREAM);
            return;
          }
          if (paramInt1 <= FramedConnection.this.lastGoodStreamId) {
            return;
          }
          if (paramInt1 % 2 == FramedConnection.this.nextStreamId % 2) {
            return;
          }
          paramList = new FramedStream(paramInt1, FramedConnection.this, paramBoolean1, paramBoolean2, paramList);
          FramedConnection.access$1702(FramedConnection.this, paramInt1);
          FramedConnection.this.streams.put(Integer.valueOf(paramInt1), paramList);
          FramedConnection.executor.execute(new FramedConnection.Reader.1(this, "OkHttp %s stream %d", new Object[] { FramedConnection.this.hostName, Integer.valueOf(paramInt1) }, paramList));
          return;
        }
        if (paramHeadersMode.failIfStreamPresent())
        {
          localFramedStream.closeLater(ErrorCode.PROTOCOL_ERROR);
          FramedConnection.this.removeStream(paramInt1);
          return;
        }
        localFramedStream.receiveHeaders(paramList, paramHeadersMode);
      } while (!paramBoolean2);
      localFramedStream.receiveFin();
    }
    
    public void ping(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      if (paramBoolean)
      {
        Ping localPing = FramedConnection.this.removePing(paramInt1);
        if (localPing != null) {
          localPing.receive();
        }
        return;
      }
      FramedConnection.this.writePingLater(true, paramInt1, paramInt2, null);
    }
    
    public void priority(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
    
    public void pushPromise(int paramInt1, int paramInt2, List<Header> paramList)
    {
      FramedConnection.this.pushRequestLater(paramInt2, paramList);
    }
    
    public void rstStream(int paramInt, ErrorCode paramErrorCode)
    {
      if (FramedConnection.this.pushedStream(paramInt)) {
        FramedConnection.this.pushResetLater(paramInt, paramErrorCode);
      }
      FramedStream localFramedStream;
      do
      {
        return;
        localFramedStream = FramedConnection.this.removeStream(paramInt);
      } while (localFramedStream == null);
      localFramedStream.receiveRstStream(paramErrorCode);
    }
    
    public void settings(boolean paramBoolean, Settings paramSettings)
    {
      for (;;)
      {
        int i;
        synchronized (FramedConnection.this)
        {
          i = FramedConnection.this.peerSettings.getInitialWindowSize(65536);
          if (paramBoolean) {
            FramedConnection.this.peerSettings.clear();
          }
          FramedConnection.this.peerSettings.merge(paramSettings);
          if (FramedConnection.this.getProtocol() == Protocol.HTTP_2) {
            ackSettingsLater(paramSettings);
          }
          int j = FramedConnection.this.peerSettings.getInitialWindowSize(65536);
          if ((j == -1) || (j == i)) {
            break label281;
          }
          l = j - i;
          if (!FramedConnection.this.receivedInitialPeerSettings)
          {
            FramedConnection.this.addBytesToWriteWindow(l);
            FramedConnection.access$2302(FramedConnection.this, true);
          }
          if (FramedConnection.this.streams.isEmpty()) {
            break label276;
          }
          paramSettings = (FramedStream[])FramedConnection.this.streams.values().toArray(new FramedStream[FramedConnection.this.streams.size()]);
          FramedConnection.executor.execute(new FramedConnection.Reader.2(this, "OkHttp %s settings", new Object[] { FramedConnection.this.hostName }));
          if ((paramSettings == null) || (l == 0L)) {
            break label275;
          }
          j = paramSettings.length;
          i = 0;
          if (i >= j) {
            break label275;
          }
        }
        synchronized (paramSettings[i])
        {
          ???.addBytesToWriteWindow(l);
          i += 1;
          continue;
          paramSettings = finally;
          throw paramSettings;
        }
        label275:
        return;
        label276:
        paramSettings = null;
        continue;
        label281:
        paramSettings = null;
        long l = 0L;
      }
    }
    
    public void windowUpdate(int paramInt, long paramLong)
    {
      if (paramInt == 0) {
        synchronized (FramedConnection.this)
        {
          FramedConnection localFramedConnection = FramedConnection.this;
          localFramedConnection.bytesLeftInWriteWindow += paramLong;
          FramedConnection.this.notifyAll();
          return;
        }
      }
      ??? = FramedConnection.this.getStream(paramInt);
      if (??? != null) {
        try
        {
          ((FramedStream)???).addBytesToWriteWindow(paramLong);
          return;
        }
        finally {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedConnection
 * JD-Core Version:    0.7.0.1
 */