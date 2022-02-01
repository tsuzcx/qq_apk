package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http2Stream
{
  long bytesLeftInWriteWindow;
  final Http2Connection connection;
  ErrorCode errorCode = null;
  private boolean hasResponseHeaders;
  private Header.Listener headersListener;
  private final Deque<Headers> headersQueue = new ArrayDeque();
  final int id;
  final StreamTimeout readTimeout = new StreamTimeout();
  final FramingSink sink;
  private final FramingSource source;
  long unacknowledgedBytesRead = 0L;
  final StreamTimeout writeTimeout = new StreamTimeout();
  
  static
  {
    if (!Http2Stream.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  Http2Stream(int paramInt, Http2Connection paramHttp2Connection, boolean paramBoolean1, boolean paramBoolean2, @Nullable Headers paramHeaders)
  {
    if (paramHttp2Connection == null) {
      throw new NullPointerException("connection == null");
    }
    this.id = paramInt;
    this.connection = paramHttp2Connection;
    this.bytesLeftInWriteWindow = paramHttp2Connection.peerSettings.getInitialWindowSize();
    this.source = new FramingSource(paramHttp2Connection.okHttpSettings.getInitialWindowSize());
    this.sink = new FramingSink();
    this.source.finished = paramBoolean2;
    this.sink.finished = paramBoolean1;
    if (paramHeaders != null) {
      this.headersQueue.add(paramHeaders);
    }
    if ((isLocallyInitiated()) && (paramHeaders != null)) {
      throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
    }
    if ((!isLocallyInitiated()) && (paramHeaders == null)) {
      throw new IllegalStateException("remotely-initiated streams should have headers");
    }
  }
  
  private boolean closeInternal(ErrorCode paramErrorCode)
  {
    assert (!Thread.holdsLock(this));
    try
    {
      if (this.errorCode != null) {
        return false;
      }
      if ((this.source.finished) && (this.sink.finished)) {
        return false;
      }
    }
    finally {}
    this.errorCode = paramErrorCode;
    notifyAll();
    this.connection.removeStream(this.id);
    return true;
  }
  
  void addBytesToWriteWindow(long paramLong)
  {
    this.bytesLeftInWriteWindow += paramLong;
    if (paramLong > 0L) {
      notifyAll();
    }
  }
  
  void cancelStreamIfNecessary()
    throws IOException
  {
    assert (!Thread.holdsLock(this));
    for (;;)
    {
      try
      {
        boolean bool;
        if ((!this.source.finished) && (this.source.closed))
        {
          if (this.sink.finished) {
            break label112;
          }
          if (this.sink.closed)
          {
            break label112;
            bool = isOpen();
            if (i == 0) {
              break label95;
            }
            close(ErrorCode.CANCEL);
            return;
          }
        }
        i = 0;
        continue;
        if (bool) {
          continue;
        }
      }
      finally {}
      label95:
      this.connection.removeStream(this.id);
      return;
      label112:
      int i = 1;
    }
  }
  
  void checkOutNotClosed()
    throws IOException
  {
    if (this.sink.closed) {
      throw new IOException("stream closed");
    }
    if (this.sink.finished) {
      throw new IOException("stream finished");
    }
    if (this.errorCode != null) {
      throw new StreamResetException(this.errorCode);
    }
  }
  
  public void close(ErrorCode paramErrorCode)
    throws IOException
  {
    if (!closeInternal(paramErrorCode)) {
      return;
    }
    this.connection.writeSynReset(this.id, paramErrorCode);
  }
  
  public void closeLater(ErrorCode paramErrorCode)
  {
    if (!closeInternal(paramErrorCode)) {
      return;
    }
    this.connection.writeSynResetLater(this.id, paramErrorCode);
  }
  
  public Http2Connection getConnection()
  {
    return this.connection;
  }
  
  public ErrorCode getErrorCode()
  {
    try
    {
      ErrorCode localErrorCode = this.errorCode;
      return localErrorCode;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public Sink getSink()
  {
    try
    {
      if ((!this.hasResponseHeaders) && (!isLocallyInitiated())) {
        throw new IllegalStateException("reply before requesting the sink");
      }
    }
    finally {}
    return this.sink;
  }
  
  public Source getSource()
  {
    return this.source;
  }
  
  public boolean isLocallyInitiated()
  {
    if ((this.id & 0x1) == 1) {}
    for (int i = 1; this.connection.client == i; i = 0) {
      return true;
    }
    return false;
  }
  
  /* Error */
  public boolean isOpen()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 69	okhttp3/internal/http2/Http2Stream:errorCode	Lokhttp3/internal/http2/ErrorCode;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 102	okhttp3/internal/http2/Http2Stream:source	Lokhttp3/internal/http2/Http2Stream$FramingSource;
    //   21: getfield 108	okhttp3/internal/http2/Http2Stream$FramingSource:finished	Z
    //   24: ifne +13 -> 37
    //   27: aload_0
    //   28: getfield 102	okhttp3/internal/http2/Http2Stream:source	Lokhttp3/internal/http2/Http2Stream$FramingSource;
    //   31: getfield 157	okhttp3/internal/http2/Http2Stream$FramingSource:closed	Z
    //   34: ifeq +32 -> 66
    //   37: aload_0
    //   38: getfield 105	okhttp3/internal/http2/Http2Stream:sink	Lokhttp3/internal/http2/Http2Stream$FramingSink;
    //   41: getfield 109	okhttp3/internal/http2/Http2Stream$FramingSink:finished	Z
    //   44: ifne +13 -> 57
    //   47: aload_0
    //   48: getfield 105	okhttp3/internal/http2/Http2Stream:sink	Lokhttp3/internal/http2/Http2Stream$FramingSink;
    //   51: getfield 158	okhttp3/internal/http2/Http2Stream$FramingSink:closed	Z
    //   54: ifeq +12 -> 66
    //   57: aload_0
    //   58: getfield 200	okhttp3/internal/http2/Http2Stream:hasResponseHeaders	Z
    //   61: istore_2
    //   62: iload_2
    //   63: ifne -50 -> 13
    //   66: iconst_1
    //   67: istore_1
    //   68: goto -55 -> 13
    //   71: astore_3
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_3
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	Http2Stream
    //   1	67	1	bool1	boolean
    //   61	2	2	bool2	boolean
    //   8	2	3	localErrorCode	ErrorCode
    //   71	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	71	finally
    //   17	37	71	finally
    //   37	57	71	finally
    //   57	62	71	finally
  }
  
  public Timeout readTimeout()
  {
    return this.readTimeout;
  }
  
  void receiveData(BufferedSource paramBufferedSource, int paramInt)
    throws IOException
  {
    assert (!Thread.holdsLock(this));
    this.source.receive(paramBufferedSource, paramInt);
  }
  
  void receiveFin()
  {
    assert (!Thread.holdsLock(this));
    try
    {
      this.source.finished = true;
      boolean bool = isOpen();
      notifyAll();
      if (!bool) {
        this.connection.removeStream(this.id);
      }
      return;
    }
    finally {}
  }
  
  void receiveHeaders(List<Header> paramList)
  {
    assert (!Thread.holdsLock(this));
    try
    {
      this.hasResponseHeaders = true;
      this.headersQueue.add(Util.toHeaders(paramList));
      boolean bool = isOpen();
      notifyAll();
      if (!bool) {
        this.connection.removeStream(this.id);
      }
      return;
    }
    finally {}
  }
  
  void receiveRstStream(ErrorCode paramErrorCode)
  {
    try
    {
      if (this.errorCode == null)
      {
        this.errorCode = paramErrorCode;
        notifyAll();
      }
      return;
    }
    finally
    {
      paramErrorCode = finally;
      throw paramErrorCode;
    }
  }
  
  public void setHeadersListener(Header.Listener paramListener)
  {
    try
    {
      this.headersListener = paramListener;
      if ((!this.headersQueue.isEmpty()) && (paramListener != null)) {
        notifyAll();
      }
      return;
    }
    finally {}
  }
  
  public Headers takeHeaders()
    throws IOException
  {
    try
    {
      this.readTimeout.enter();
    }
    finally
    {
      try
      {
        while ((this.headersQueue.isEmpty()) && (this.errorCode == null)) {
          waitForIo();
        }
      }
      finally
      {
        this.readTimeout.exitAndThrowIfTimedOut();
      }
    }
    this.readTimeout.exitAndThrowIfTimedOut();
    if (!this.headersQueue.isEmpty())
    {
      Headers localHeaders = (Headers)this.headersQueue.removeFirst();
      return localHeaders;
    }
    throw new StreamResetException(this.errorCode);
  }
  
  void waitForIo()
    throws InterruptedIOException
  {
    try
    {
      wait();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
      throw new InterruptedIOException();
    }
  }
  
  /* Error */
  public void writeHeaders(List<Header> paramList, boolean paramBoolean)
    throws IOException
  {
    // Byte code:
    //   0: getstatic 47	okhttp3/internal/http2/Http2Stream:$assertionsDisabled	Z
    //   3: ifne +18 -> 21
    //   6: aload_0
    //   7: invokestatic 139	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   10: ifeq +11 -> 21
    //   13: new 141	java/lang/AssertionError
    //   16: dup
    //   17: invokespecial 142	java/lang/AssertionError:<init>	()V
    //   20: athrow
    //   21: aload_1
    //   22: ifnonnull +14 -> 36
    //   25: new 71	java/lang/NullPointerException
    //   28: dup
    //   29: ldc_w 267
    //   32: invokespecial 76	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   35: athrow
    //   36: aload_0
    //   37: monitorenter
    //   38: aload_0
    //   39: iconst_1
    //   40: putfield 200	okhttp3/internal/http2/Http2Stream:hasResponseHeaders	Z
    //   43: iload_2
    //   44: ifne +95 -> 139
    //   47: aload_0
    //   48: getfield 105	okhttp3/internal/http2/Http2Stream:sink	Lokhttp3/internal/http2/Http2Stream$FramingSink;
    //   51: iconst_1
    //   52: putfield 109	okhttp3/internal/http2/Http2Stream$FramingSink:finished	Z
    //   55: iconst_1
    //   56: istore_3
    //   57: iconst_1
    //   58: istore_2
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_3
    //   62: istore 4
    //   64: iload_3
    //   65: ifne +32 -> 97
    //   68: aload_0
    //   69: getfield 80	okhttp3/internal/http2/Http2Stream:connection	Lokhttp3/internal/http2/Http2Connection;
    //   72: astore 5
    //   74: aload 5
    //   76: monitorenter
    //   77: aload_0
    //   78: getfield 80	okhttp3/internal/http2/Http2Stream:connection	Lokhttp3/internal/http2/Http2Connection;
    //   81: getfield 268	okhttp3/internal/http2/Http2Connection:bytesLeftInWriteWindow	J
    //   84: lconst_0
    //   85: lcmp
    //   86: ifne +42 -> 128
    //   89: iconst_1
    //   90: istore_3
    //   91: aload 5
    //   93: monitorexit
    //   94: iload_3
    //   95: istore 4
    //   97: aload_0
    //   98: getfield 80	okhttp3/internal/http2/Http2Stream:connection	Lokhttp3/internal/http2/Http2Connection;
    //   101: aload_0
    //   102: getfield 78	okhttp3/internal/http2/Http2Stream:id	I
    //   105: iload_2
    //   106: aload_1
    //   107: invokevirtual 272	okhttp3/internal/http2/Http2Connection:writeSynReply	(IZLjava/util/List;)V
    //   110: iload 4
    //   112: ifeq +10 -> 122
    //   115: aload_0
    //   116: getfield 80	okhttp3/internal/http2/Http2Stream:connection	Lokhttp3/internal/http2/Http2Connection;
    //   119: invokevirtual 275	okhttp3/internal/http2/Http2Connection:flush	()V
    //   122: return
    //   123: astore_1
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    //   128: iconst_0
    //   129: istore_3
    //   130: goto -39 -> 91
    //   133: astore_1
    //   134: aload 5
    //   136: monitorexit
    //   137: aload_1
    //   138: athrow
    //   139: iconst_0
    //   140: istore_3
    //   141: iconst_0
    //   142: istore_2
    //   143: goto -84 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	Http2Stream
    //   0	146	1	paramList	List<Header>
    //   0	146	2	paramBoolean	boolean
    //   56	85	3	i	int
    //   62	49	4	j	int
    // Exception table:
    //   from	to	target	type
    //   38	43	123	finally
    //   47	55	123	finally
    //   59	61	123	finally
    //   124	126	123	finally
    //   77	89	133	finally
    //   91	94	133	finally
    //   134	137	133	finally
  }
  
  public Timeout writeTimeout()
  {
    return this.writeTimeout;
  }
  
  final class FramingSink
    implements Sink
  {
    private static final long EMIT_BUFFER_SIZE = 16384L;
    boolean closed;
    boolean finished;
    private final Buffer sendBuffer = new Buffer();
    
    static
    {
      if (!Http2Stream.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    FramingSink() {}
    
    /* Error */
    private void emitFrame(boolean paramBoolean)
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 36	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
      //   4: astore 5
      //   6: aload 5
      //   8: monitorenter
      //   9: aload_0
      //   10: getfield 36	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
      //   13: getfield 51	okhttp3/internal/http2/Http2Stream:writeTimeout	Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
      //   16: invokevirtual 56	okhttp3/internal/http2/Http2Stream$StreamTimeout:enter	()V
      //   19: aload_0
      //   20: getfield 36	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
      //   23: getfield 59	okhttp3/internal/http2/Http2Stream:bytesLeftInWriteWindow	J
      //   26: lconst_0
      //   27: lcmp
      //   28: ifgt +60 -> 88
      //   31: aload_0
      //   32: getfield 61	okhttp3/internal/http2/Http2Stream$FramingSink:finished	Z
      //   35: ifne +53 -> 88
      //   38: aload_0
      //   39: getfield 63	okhttp3/internal/http2/Http2Stream$FramingSink:closed	Z
      //   42: ifne +46 -> 88
      //   45: aload_0
      //   46: getfield 36	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
      //   49: getfield 67	okhttp3/internal/http2/Http2Stream:errorCode	Lokhttp3/internal/http2/ErrorCode;
      //   52: ifnonnull +36 -> 88
      //   55: aload_0
      //   56: getfield 36	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
      //   59: invokevirtual 70	okhttp3/internal/http2/Http2Stream:waitForIo	()V
      //   62: goto -43 -> 19
      //   65: astore 6
      //   67: aload_0
      //   68: getfield 36	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
      //   71: getfield 51	okhttp3/internal/http2/Http2Stream:writeTimeout	Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
      //   74: invokevirtual 73	okhttp3/internal/http2/Http2Stream$StreamTimeout:exitAndThrowIfTimedOut	()V
      //   77: aload 6
      //   79: athrow
      //   80: astore 6
      //   82: aload 5
      //   84: monitorexit
      //   85: aload 6
      //   87: athrow
      //   88: aload_0
      //   89: getfield 36	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
      //   92: getfield 51	okhttp3/internal/http2/Http2Stream:writeTimeout	Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
      //   95: invokevirtual 73	okhttp3/internal/http2/Http2Stream$StreamTimeout:exitAndThrowIfTimedOut	()V
      //   98: aload_0
      //   99: getfield 36	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
      //   102: invokevirtual 76	okhttp3/internal/http2/Http2Stream:checkOutNotClosed	()V
      //   105: aload_0
      //   106: getfield 36	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
      //   109: getfield 59	okhttp3/internal/http2/Http2Stream:bytesLeftInWriteWindow	J
      //   112: aload_0
      //   113: getfield 43	okhttp3/internal/http2/Http2Stream$FramingSink:sendBuffer	Lokio/Buffer;
      //   116: invokevirtual 80	okio/Buffer:size	()J
      //   119: invokestatic 86	java/lang/Math:min	(JJ)J
      //   122: lstore_3
      //   123: aload_0
      //   124: getfield 36	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
      //   127: astore 6
      //   129: aload 6
      //   131: aload 6
      //   133: getfield 59	okhttp3/internal/http2/Http2Stream:bytesLeftInWriteWindow	J
      //   136: lload_3
      //   137: lsub
      //   138: putfield 59	okhttp3/internal/http2/Http2Stream:bytesLeftInWriteWindow	J
      //   141: aload 5
      //   143: monitorexit
      //   144: aload_0
      //   145: getfield 36	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
      //   148: getfield 51	okhttp3/internal/http2/Http2Stream:writeTimeout	Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
      //   151: invokevirtual 56	okhttp3/internal/http2/Http2Stream$StreamTimeout:enter	()V
      //   154: aload_0
      //   155: getfield 36	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
      //   158: getfield 90	okhttp3/internal/http2/Http2Stream:connection	Lokhttp3/internal/http2/Http2Connection;
      //   161: astore 5
      //   163: aload_0
      //   164: getfield 36	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
      //   167: getfield 94	okhttp3/internal/http2/Http2Stream:id	I
      //   170: istore_2
      //   171: iload_1
      //   172: ifeq +40 -> 212
      //   175: lload_3
      //   176: aload_0
      //   177: getfield 43	okhttp3/internal/http2/Http2Stream$FramingSink:sendBuffer	Lokio/Buffer;
      //   180: invokevirtual 80	okio/Buffer:size	()J
      //   183: lcmp
      //   184: ifne +28 -> 212
      //   187: iconst_1
      //   188: istore_1
      //   189: aload 5
      //   191: iload_2
      //   192: iload_1
      //   193: aload_0
      //   194: getfield 43	okhttp3/internal/http2/Http2Stream$FramingSink:sendBuffer	Lokio/Buffer;
      //   197: lload_3
      //   198: invokevirtual 100	okhttp3/internal/http2/Http2Connection:writeData	(IZLokio/Buffer;J)V
      //   201: aload_0
      //   202: getfield 36	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
      //   205: getfield 51	okhttp3/internal/http2/Http2Stream:writeTimeout	Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
      //   208: invokevirtual 73	okhttp3/internal/http2/Http2Stream$StreamTimeout:exitAndThrowIfTimedOut	()V
      //   211: return
      //   212: iconst_0
      //   213: istore_1
      //   214: goto -25 -> 189
      //   217: astore 5
      //   219: aload_0
      //   220: getfield 36	okhttp3/internal/http2/Http2Stream$FramingSink:this$0	Lokhttp3/internal/http2/Http2Stream;
      //   223: getfield 51	okhttp3/internal/http2/Http2Stream:writeTimeout	Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
      //   226: invokevirtual 73	okhttp3/internal/http2/Http2Stream$StreamTimeout:exitAndThrowIfTimedOut	()V
      //   229: aload 5
      //   231: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	232	0	this	FramingSink
      //   0	232	1	paramBoolean	boolean
      //   170	22	2	i	int
      //   122	76	3	l	long
      //   4	186	5	localObject1	Object
      //   217	13	5	localObject2	Object
      //   65	13	6	localObject3	Object
      //   80	6	6	localObject4	Object
      //   127	5	6	localHttp2Stream	Http2Stream
      // Exception table:
      //   from	to	target	type
      //   19	62	65	finally
      //   9	19	80	finally
      //   67	80	80	finally
      //   82	85	80	finally
      //   88	144	80	finally
      //   154	171	217	finally
      //   175	187	217	finally
      //   189	201	217	finally
    }
    
    public void close()
      throws IOException
    {
      assert (!Thread.holdsLock(Http2Stream.this));
      synchronized (Http2Stream.this)
      {
        if (this.closed) {
          return;
        }
        if (Http2Stream.this.sink.finished) {
          break label113;
        }
        if (this.sendBuffer.size() > 0L)
        {
          if (this.sendBuffer.size() <= 0L) {
            break label113;
          }
          emitFrame(true);
        }
      }
      Http2Stream.this.connection.writeData(Http2Stream.this.id, true, null, 0L);
      label113:
      synchronized (Http2Stream.this)
      {
        this.closed = true;
        Http2Stream.this.connection.flush();
        Http2Stream.this.cancelStreamIfNecessary();
        return;
      }
    }
    
    public void flush()
      throws IOException
    {
      assert (!Thread.holdsLock(Http2Stream.this));
      synchronized (Http2Stream.this)
      {
        Http2Stream.this.checkOutNotClosed();
        if (this.sendBuffer.size() > 0L)
        {
          emitFrame(false);
          Http2Stream.this.connection.flush();
        }
      }
    }
    
    public Timeout timeout()
    {
      return Http2Stream.this.writeTimeout;
    }
    
    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      assert (!Thread.holdsLock(Http2Stream.this));
      this.sendBuffer.write(paramBuffer, paramLong);
      while (this.sendBuffer.size() >= 16384L) {
        emitFrame(false);
      }
    }
  }
  
  final class FramingSource
    implements Source
  {
    boolean closed;
    boolean finished;
    private final long maxByteCount;
    private final Buffer readBuffer = new Buffer();
    private final Buffer receiveBuffer = new Buffer();
    
    static
    {
      if (!Http2Stream.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    FramingSource(long paramLong)
    {
      this.maxByteCount = paramLong;
    }
    
    private void updateConnectionFlowControl(long paramLong)
    {
      assert (!Thread.holdsLock(Http2Stream.this));
      Http2Stream.this.connection.updateConnectionFlowControl(paramLong);
    }
    
    public void close()
      throws IOException
    {
      Object localObject1 = null;
      for (;;)
      {
        synchronized (Http2Stream.this)
        {
          this.closed = true;
          long l = this.readBuffer.size();
          this.readBuffer.clear();
          if ((Http2Stream.this.headersQueue.isEmpty()) || (Http2Stream.this.headersListener == null)) {
            break label167;
          }
          localObject1 = new ArrayList(Http2Stream.this.headersQueue);
          Http2Stream.this.headersQueue.clear();
          localListener = Http2Stream.this.headersListener;
          Http2Stream.this.notifyAll();
          if (l > 0L) {
            updateConnectionFlowControl(l);
          }
          Http2Stream.this.cancelStreamIfNecessary();
          if (localListener != null)
          {
            localObject1 = ((List)localObject1).iterator();
            if (((Iterator)localObject1).hasNext()) {
              localListener.onHeaders((Headers)((Iterator)localObject1).next());
            }
          }
        }
        return;
        label167:
        Header.Listener localListener = null;
      }
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      for (;;)
      {
        Http2Stream localHttp2Stream;
        try
        {
          if ((this.finished) || (localErrorCode != null)) {
            break label392;
          }
          Http2Stream.this.waitForIo();
          label65:
          if (Http2Stream.this.headersQueue.isEmpty()) {
            break label230;
          }
        }
        finally
        {
          try
          {
            Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
            localHttp2Stream = Http2Stream.this;
            Http2Stream.this.readTimeout.enter();
            if (Http2Stream.this.errorCode == null) {
              break label415;
            }
            localErrorCode = Http2Stream.this.errorCode;
            if (!this.closed) {
              break label139;
            }
            throw new IOException("stream closed");
          }
          finally {}
          paramBuffer = finally;
          Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
        }
        label139:
        Headers localHeaders;
        Object localObject;
        long l;
        if (Http2Stream.this.headersListener != null)
        {
          localHeaders = (Headers)Http2Stream.this.headersQueue.removeFirst();
          localObject = Http2Stream.this.headersListener;
          l = -1L;
        }
        for (;;)
        {
          Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
          if ((localHeaders != null) && (localObject != null))
          {
            ((Header.Listener)localObject).onHeaders(localHeaders);
            break label65;
            label230:
            if (this.readBuffer.size() <= 0L) {
              break;
            }
            l = this.readBuffer.read(paramBuffer, Math.min(paramLong, this.readBuffer.size()));
            localObject = Http2Stream.this;
            ((Http2Stream)localObject).unacknowledgedBytesRead += l;
            if ((localErrorCode != null) || (Http2Stream.this.unacknowledgedBytesRead < Http2Stream.this.connection.okHttpSettings.getInitialWindowSize() / 2)) {
              break label406;
            }
            Http2Stream.this.connection.writeWindowUpdateLater(Http2Stream.this.id, Http2Stream.this.unacknowledgedBytesRead);
            Http2Stream.this.unacknowledgedBytesRead = 0L;
            localObject = null;
            localHeaders = null;
            continue;
          }
          if (l != -1L)
          {
            updateConnectionFlowControl(l);
            return l;
          }
          if (localErrorCode != null) {
            throw new StreamResetException(localErrorCode);
          }
          return -1L;
          label392:
          l = -1L;
          localObject = null;
          localHeaders = null;
          continue;
          label406:
          localObject = null;
          localHeaders = null;
        }
        label415:
        ErrorCode localErrorCode = null;
      }
    }
    
    void receive(BufferedSource paramBufferedSource, long paramLong)
      throws IOException
    {
      long l1 = paramLong;
      long l2;
      if (!$assertionsDisabled)
      {
        l1 = paramLong;
        if (Thread.holdsLock(Http2Stream.this))
        {
          throw new AssertionError();
          l2 = l1 - paramLong;
        }
      }
      for (;;)
      {
        synchronized (Http2Stream.this)
        {
          if (this.closed)
          {
            paramLong = this.receiveBuffer.size();
            this.receiveBuffer.clear();
            l1 = l2;
            if (paramLong > 0L)
            {
              updateConnectionFlowControl(paramLong);
              l1 = l2;
            }
            if (l1 > 0L) {}
            boolean bool;
            synchronized (Http2Stream.this)
            {
              bool = this.finished;
              if (this.readBuffer.size() + l1 > this.maxByteCount)
              {
                i = 1;
                if (i != 0)
                {
                  paramBufferedSource.skip(l1);
                  Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                }
              }
              else
              {
                i = 0;
              }
            }
            if (bool)
            {
              paramBufferedSource.skip(l1);
              return;
            }
            paramLong = paramBufferedSource.read(this.receiveBuffer, l1);
            if (paramLong != -1L) {
              break;
            }
            throw new EOFException();
          }
          if (this.readBuffer.size() != 0L) {
            break label267;
          }
          i = 1;
          this.readBuffer.writeAll(this.receiveBuffer);
          if (i != 0) {
            Http2Stream.this.notifyAll();
          }
        }
        paramLong = 0L;
        continue;
        label267:
        int i = 0;
      }
    }
    
    public Timeout timeout()
    {
      return Http2Stream.this.readTimeout;
    }
  }
  
  class StreamTimeout
    extends AsyncTimeout
  {
    StreamTimeout() {}
    
    public void exitAndThrowIfTimedOut()
      throws IOException
    {
      if (exit()) {
        throw newTimeoutException(null);
      }
    }
    
    public IOException newTimeoutException(IOException paramIOException)
    {
      SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
      if (paramIOException != null) {
        localSocketTimeoutException.initCause(paramIOException);
      }
      return localSocketTimeoutException;
    }
    
    public void timedOut()
    {
      Http2Stream.this.closeLater(ErrorCode.CANCEL);
      Http2Stream.this.connection.sendDegradedPingLater();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Stream
 * JD-Core Version:    0.7.0.1
 */