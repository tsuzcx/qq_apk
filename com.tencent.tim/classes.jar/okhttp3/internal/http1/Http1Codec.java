package okhttp3.internal.http1;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http1Codec
  implements HttpCodec
{
  private static final int HEADER_LIMIT = 262144;
  private static final int STATE_CLOSED = 6;
  private static final int STATE_IDLE = 0;
  private static final int STATE_OPEN_REQUEST_BODY = 1;
  private static final int STATE_OPEN_RESPONSE_BODY = 4;
  private static final int STATE_READING_RESPONSE_BODY = 5;
  private static final int STATE_READ_RESPONSE_HEADERS = 3;
  private static final int STATE_WRITING_REQUEST_BODY = 2;
  final OkHttpClient client;
  private long headerLimit = 262144L;
  final BufferedSink sink;
  final BufferedSource source;
  int state = 0;
  final StreamAllocation streamAllocation;
  
  public Http1Codec(OkHttpClient paramOkHttpClient, StreamAllocation paramStreamAllocation, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink)
  {
    this.client = paramOkHttpClient;
    this.streamAllocation = paramStreamAllocation;
    this.source = paramBufferedSource;
    this.sink = paramBufferedSink;
  }
  
  private String readHeaderLine()
    throws IOException
  {
    String str = this.source.readUtf8LineStrict(this.headerLimit);
    this.headerLimit -= str.length();
    return str;
  }
  
  public void cancel()
  {
    RealConnection localRealConnection = this.streamAllocation.connection();
    if (localRealConnection != null) {
      localRealConnection.cancel();
    }
  }
  
  public Sink createRequestBody(Request paramRequest, long paramLong)
  {
    if ("chunked".equalsIgnoreCase(paramRequest.header("Transfer-Encoding"))) {
      return newChunkedSink();
    }
    if (paramLong != -1L) {
      return newFixedLengthSink(paramLong);
    }
    throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
  }
  
  void detachTimeout(ForwardingTimeout paramForwardingTimeout)
  {
    Timeout localTimeout = paramForwardingTimeout.delegate();
    paramForwardingTimeout.setDelegate(Timeout.NONE);
    localTimeout.clearDeadline();
    localTimeout.clearTimeout();
  }
  
  public void finishRequest()
    throws IOException
  {
    this.sink.flush();
  }
  
  public void flushRequest()
    throws IOException
  {
    this.sink.flush();
  }
  
  public boolean isClosed()
  {
    return this.state == 6;
  }
  
  public Sink newChunkedSink()
  {
    if (this.state != 1) {
      throw new IllegalStateException("state: " + this.state);
    }
    this.state = 2;
    return new ChunkedSink();
  }
  
  public Source newChunkedSource(HttpUrl paramHttpUrl)
    throws IOException
  {
    if (this.state != 4) {
      throw new IllegalStateException("state: " + this.state);
    }
    this.state = 5;
    return new ChunkedSource(paramHttpUrl);
  }
  
  public Sink newFixedLengthSink(long paramLong)
  {
    if (this.state != 1) {
      throw new IllegalStateException("state: " + this.state);
    }
    this.state = 2;
    return new FixedLengthSink(paramLong);
  }
  
  public Source newFixedLengthSource(long paramLong)
    throws IOException
  {
    if (this.state != 4) {
      throw new IllegalStateException("state: " + this.state);
    }
    this.state = 5;
    return new FixedLengthSource(paramLong);
  }
  
  public Source newUnknownLengthSource()
    throws IOException
  {
    if (this.state != 4) {
      throw new IllegalStateException("state: " + this.state);
    }
    if (this.streamAllocation == null) {
      throw new IllegalStateException("streamAllocation == null");
    }
    this.state = 5;
    this.streamAllocation.noNewStreams();
    return new UnknownLengthSource();
  }
  
  public ResponseBody openResponseBody(Response paramResponse)
    throws IOException
  {
    this.streamAllocation.eventListener.responseBodyStart(this.streamAllocation.call);
    String str = paramResponse.header("Content-Type");
    if (!HttpHeaders.hasBody(paramResponse)) {
      return new RealResponseBody(str, 0L, Okio.buffer(newFixedLengthSource(0L)));
    }
    if ("chunked".equalsIgnoreCase(paramResponse.header("Transfer-Encoding"))) {
      return new RealResponseBody(str, -1L, Okio.buffer(newChunkedSource(paramResponse.request().url())));
    }
    long l = HttpHeaders.contentLength(paramResponse);
    if (l != -1L) {
      return new RealResponseBody(str, l, Okio.buffer(newFixedLengthSource(l)));
    }
    return new RealResponseBody(str, -1L, Okio.buffer(newUnknownLengthSource()));
  }
  
  public Headers readHeaders()
    throws IOException
  {
    Headers.Builder localBuilder = new Headers.Builder();
    for (;;)
    {
      String str = readHeaderLine();
      if (str.length() == 0) {
        break;
      }
      Internal.instance.addLenient(localBuilder, str);
    }
    return localBuilder.build();
  }
  
  public Response.Builder readResponseHeaders(boolean paramBoolean)
    throws IOException
  {
    if ((this.state != 1) && (this.state != 3)) {
      throw new IllegalStateException("state: " + this.state);
    }
    Object localObject;
    try
    {
      StatusLine localStatusLine = StatusLine.parse(readHeaderLine());
      localObject = new Response.Builder().protocol(localStatusLine.protocol).code(localStatusLine.code).message(localStatusLine.message).headers(readHeaders());
      if ((paramBoolean) && (localStatusLine.code == 100)) {
        return null;
      }
      if (localStatusLine.code == 100)
      {
        this.state = 3;
        return localObject;
      }
    }
    catch (EOFException localEOFException)
    {
      localObject = new IOException("unexpected end of stream on " + this.streamAllocation);
      ((IOException)localObject).initCause(localEOFException);
      throw ((Throwable)localObject);
    }
    this.state = 4;
    return localObject;
  }
  
  public void writeRequest(Headers paramHeaders, String paramString)
    throws IOException
  {
    if (this.state != 0) {
      throw new IllegalStateException("state: " + this.state);
    }
    this.sink.writeUtf8(paramString).writeUtf8("\r\n");
    int i = 0;
    int j = paramHeaders.size();
    while (i < j)
    {
      this.sink.writeUtf8(paramHeaders.name(i)).writeUtf8(": ").writeUtf8(paramHeaders.value(i)).writeUtf8("\r\n");
      i += 1;
    }
    this.sink.writeUtf8("\r\n");
    this.state = 1;
  }
  
  public void writeRequestHeaders(Request paramRequest)
    throws IOException
  {
    String str = RequestLine.get(paramRequest, this.streamAllocation.connection().route().proxy().type());
    writeRequest(paramRequest.headers(), str);
  }
  
  abstract class AbstractSource
    implements Source
  {
    protected long bytesRead = 0L;
    protected boolean closed;
    protected final ForwardingTimeout timeout = new ForwardingTimeout(Http1Codec.this.source.timeout());
    
    private AbstractSource() {}
    
    protected final void endOfInput(boolean paramBoolean, IOException paramIOException)
      throws IOException
    {
      if (Http1Codec.this.state == 6) {}
      do
      {
        return;
        if (Http1Codec.this.state != 5) {
          throw new IllegalStateException("state: " + Http1Codec.this.state);
        }
        Http1Codec.this.detachTimeout(this.timeout);
        Http1Codec.this.state = 6;
      } while (Http1Codec.this.streamAllocation == null);
      StreamAllocation localStreamAllocation = Http1Codec.this.streamAllocation;
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localStreamAllocation.streamFinished(paramBoolean, Http1Codec.this, this.bytesRead, paramIOException);
        return;
      }
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      try
      {
        paramLong = Http1Codec.this.source.read(paramBuffer, paramLong);
        if (paramLong > 0L) {
          this.bytesRead += paramLong;
        }
        return paramLong;
      }
      catch (IOException paramBuffer)
      {
        endOfInput(false, paramBuffer);
        throw paramBuffer;
      }
    }
    
    public Timeout timeout()
    {
      return this.timeout;
    }
  }
  
  final class ChunkedSink
    implements Sink
  {
    private boolean closed;
    private final ForwardingTimeout timeout = new ForwardingTimeout(Http1Codec.this.sink.timeout());
    
    ChunkedSink() {}
    
    /* Error */
    public void close()
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 44	okhttp3/internal/http1/Http1Codec$ChunkedSink:closed	Z
      //   6: istore_1
      //   7: iload_1
      //   8: ifeq +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: iconst_1
      //   16: putfield 44	okhttp3/internal/http1/Http1Codec$ChunkedSink:closed	Z
      //   19: aload_0
      //   20: getfield 19	okhttp3/internal/http1/Http1Codec$ChunkedSink:this$0	Lokhttp3/internal/http1/Http1Codec;
      //   23: getfield 28	okhttp3/internal/http1/Http1Codec:sink	Lokio/BufferedSink;
      //   26: ldc 46
      //   28: invokeinterface 50 2 0
      //   33: pop
      //   34: aload_0
      //   35: getfield 19	okhttp3/internal/http1/Http1Codec$ChunkedSink:this$0	Lokhttp3/internal/http1/Http1Codec;
      //   38: aload_0
      //   39: getfield 38	okhttp3/internal/http1/Http1Codec$ChunkedSink:timeout	Lokio/ForwardingTimeout;
      //   42: invokevirtual 54	okhttp3/internal/http1/Http1Codec:detachTimeout	(Lokio/ForwardingTimeout;)V
      //   45: aload_0
      //   46: getfield 19	okhttp3/internal/http1/Http1Codec$ChunkedSink:this$0	Lokhttp3/internal/http1/Http1Codec;
      //   49: iconst_3
      //   50: putfield 58	okhttp3/internal/http1/Http1Codec:state	I
      //   53: goto -42 -> 11
      //   56: astore_2
      //   57: aload_0
      //   58: monitorexit
      //   59: aload_2
      //   60: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	61	0	this	ChunkedSink
      //   6	2	1	bool	boolean
      //   56	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	56	finally
      //   14	53	56	finally
    }
    
    /* Error */
    public void flush()
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 44	okhttp3/internal/http1/Http1Codec$ChunkedSink:closed	Z
      //   6: istore_1
      //   7: iload_1
      //   8: ifeq +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: getfield 19	okhttp3/internal/http1/Http1Codec$ChunkedSink:this$0	Lokhttp3/internal/http1/Http1Codec;
      //   18: getfield 28	okhttp3/internal/http1/Http1Codec:sink	Lokio/BufferedSink;
      //   21: invokeinterface 62 1 0
      //   26: goto -15 -> 11
      //   29: astore_2
      //   30: aload_0
      //   31: monitorexit
      //   32: aload_2
      //   33: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	34	0	this	ChunkedSink
      //   6	2	1	bool	boolean
      //   29	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	29	finally
      //   14	26	29	finally
    }
    
    public Timeout timeout()
    {
      return this.timeout;
    }
    
    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (this.closed) {
        throw new IllegalStateException("closed");
      }
      if (paramLong == 0L) {
        return;
      }
      Http1Codec.this.sink.writeHexadecimalUnsignedLong(paramLong);
      Http1Codec.this.sink.writeUtf8("\r\n");
      Http1Codec.this.sink.write(paramBuffer, paramLong);
      Http1Codec.this.sink.writeUtf8("\r\n");
    }
  }
  
  class ChunkedSource
    extends Http1Codec.AbstractSource
  {
    private static final long NO_CHUNK_YET = -1L;
    private long bytesRemainingInChunk = -1L;
    private boolean hasMoreChunks = true;
    private final HttpUrl url;
    
    ChunkedSource(HttpUrl paramHttpUrl)
    {
      super(null);
      this.url = paramHttpUrl;
    }
    
    private void readChunkSize()
      throws IOException
    {
      if (this.bytesRemainingInChunk != -1L) {
        Http1Codec.this.source.readUtf8LineStrict();
      }
      try
      {
        this.bytesRemainingInChunk = Http1Codec.this.source.readHexadecimalUnsignedLong();
        String str = Http1Codec.this.source.readUtf8LineStrict().trim();
        if ((this.bytesRemainingInChunk < 0L) || ((!str.isEmpty()) && (!str.startsWith(";")))) {
          throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + str + "\"");
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new ProtocolException(localNumberFormatException.getMessage());
      }
      if (this.bytesRemainingInChunk == 0L)
      {
        this.hasMoreChunks = false;
        HttpHeaders.receiveHeaders(Http1Codec.this.client.cookieJar(), this.url, Http1Codec.this.readHeaders());
        endOfInput(true, null);
      }
    }
    
    public void close()
      throws IOException
    {
      if (this.closed) {
        return;
      }
      if ((this.hasMoreChunks) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS))) {
        endOfInput(false, null);
      }
      this.closed = true;
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      if (this.closed) {
        throw new IllegalStateException("closed");
      }
      if (!this.hasMoreChunks) {}
      do
      {
        return -1L;
        if ((this.bytesRemainingInChunk != 0L) && (this.bytesRemainingInChunk != -1L)) {
          break;
        }
        readChunkSize();
      } while (!this.hasMoreChunks);
      paramLong = super.read(paramBuffer, Math.min(paramLong, this.bytesRemainingInChunk));
      if (paramLong == -1L)
      {
        paramBuffer = new ProtocolException("unexpected end of stream");
        endOfInput(false, paramBuffer);
        throw paramBuffer;
      }
      this.bytesRemainingInChunk -= paramLong;
      return paramLong;
    }
  }
  
  final class FixedLengthSink
    implements Sink
  {
    private long bytesRemaining;
    private boolean closed;
    private final ForwardingTimeout timeout = new ForwardingTimeout(Http1Codec.this.sink.timeout());
    
    FixedLengthSink(long paramLong)
    {
      this.bytesRemaining = paramLong;
    }
    
    public void close()
      throws IOException
    {
      if (this.closed) {
        return;
      }
      this.closed = true;
      if (this.bytesRemaining > 0L) {
        throw new ProtocolException("unexpected end of stream");
      }
      Http1Codec.this.detachTimeout(this.timeout);
      Http1Codec.this.state = 3;
    }
    
    public void flush()
      throws IOException
    {
      if (this.closed) {
        return;
      }
      Http1Codec.this.sink.flush();
    }
    
    public Timeout timeout()
    {
      return this.timeout;
    }
    
    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (this.closed) {
        throw new IllegalStateException("closed");
      }
      Util.checkOffsetAndCount(paramBuffer.size(), 0L, paramLong);
      if (paramLong > this.bytesRemaining) {
        throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + paramLong);
      }
      Http1Codec.this.sink.write(paramBuffer, paramLong);
      this.bytesRemaining -= paramLong;
    }
  }
  
  class FixedLengthSource
    extends Http1Codec.AbstractSource
  {
    private long bytesRemaining;
    
    FixedLengthSource(long paramLong)
      throws IOException
    {
      super(null);
      this.bytesRemaining = paramLong;
      if (this.bytesRemaining == 0L) {
        endOfInput(true, null);
      }
    }
    
    public void close()
      throws IOException
    {
      if (this.closed) {
        return;
      }
      if ((this.bytesRemaining != 0L) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS))) {
        endOfInput(false, null);
      }
      this.closed = true;
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      if (this.closed) {
        throw new IllegalStateException("closed");
      }
      if (this.bytesRemaining == 0L) {
        return -1L;
      }
      paramLong = super.read(paramBuffer, Math.min(this.bytesRemaining, paramLong));
      if (paramLong == -1L)
      {
        paramBuffer = new ProtocolException("unexpected end of stream");
        endOfInput(false, paramBuffer);
        throw paramBuffer;
      }
      this.bytesRemaining -= paramLong;
      if (this.bytesRemaining == 0L) {
        endOfInput(true, null);
      }
      return paramLong;
    }
  }
  
  class UnknownLengthSource
    extends Http1Codec.AbstractSource
  {
    private boolean inputExhausted;
    
    UnknownLengthSource()
    {
      super(null);
    }
    
    public void close()
      throws IOException
    {
      if (this.closed) {
        return;
      }
      if (!this.inputExhausted) {
        endOfInput(false, null);
      }
      this.closed = true;
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      if (this.closed) {
        throw new IllegalStateException("closed");
      }
      if (this.inputExhausted) {
        return -1L;
      }
      paramLong = super.read(paramBuffer, paramLong);
      if (paramLong == -1L)
      {
        this.inputExhausted = true;
        endOfInput(true, null);
        return -1L;
      }
      return paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.internal.http1.Http1Codec
 * JD-Core Version:    0.7.0.1
 */