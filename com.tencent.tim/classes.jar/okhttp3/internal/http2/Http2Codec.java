package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http2Codec
  implements HttpCodec
{
  private static final String CONNECTION = "connection";
  private static final String ENCODING = "encoding";
  private static final String HOST = "host";
  private static final List<String> HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList(new String[] { "connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority" });
  private static final List<String> HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList(new String[] { "connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade" });
  private static final String KEEP_ALIVE = "keep-alive";
  private static final String PROXY_CONNECTION = "proxy-connection";
  private static final String TE = "te";
  private static final String TRANSFER_ENCODING = "transfer-encoding";
  private static final String UPGRADE = "upgrade";
  private final Interceptor.Chain chain;
  private final Http2Connection connection;
  private final Protocol protocol;
  private Http2Stream stream;
  final StreamAllocation streamAllocation;
  
  public Http2Codec(OkHttpClient paramOkHttpClient, Interceptor.Chain paramChain, StreamAllocation paramStreamAllocation, Http2Connection paramHttp2Connection)
  {
    this.chain = paramChain;
    this.streamAllocation = paramStreamAllocation;
    this.connection = paramHttp2Connection;
    if (paramOkHttpClient.protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {}
    for (paramOkHttpClient = Protocol.H2_PRIOR_KNOWLEDGE;; paramOkHttpClient = Protocol.HTTP_2)
    {
      this.protocol = paramOkHttpClient;
      return;
    }
  }
  
  public static List<Header> http2HeadersList(Request paramRequest)
  {
    Headers localHeaders = paramRequest.headers();
    ArrayList localArrayList = new ArrayList(localHeaders.size() + 4);
    localArrayList.add(new Header(Header.TARGET_METHOD, paramRequest.method()));
    localArrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(paramRequest.url())));
    String str = paramRequest.header("Host");
    if (str != null) {
      localArrayList.add(new Header(Header.TARGET_AUTHORITY, str));
    }
    localArrayList.add(new Header(Header.TARGET_SCHEME, paramRequest.url().scheme()));
    int i = 0;
    int j = localHeaders.size();
    while (i < j)
    {
      paramRequest = ByteString.encodeUtf8(localHeaders.name(i).toLowerCase(Locale.US));
      if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(paramRequest.utf8())) {
        localArrayList.add(new Header(paramRequest, localHeaders.value(i)));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static Response.Builder readHttp2HeadersList(Headers paramHeaders, Protocol paramProtocol)
    throws IOException
  {
    Headers.Builder localBuilder = new Headers.Builder();
    int j = paramHeaders.size();
    Object localObject1 = null;
    int i = 0;
    if (i < j)
    {
      String str1 = paramHeaders.name(i);
      String str2 = paramHeaders.value(i);
      Object localObject2;
      if (str1.equals(":status")) {
        localObject2 = StatusLine.parse("HTTP/1.1 " + str2);
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        localObject2 = localObject1;
        if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(str1))
        {
          Internal.instance.addLenient(localBuilder, str1, str2);
          localObject2 = localObject1;
        }
      }
    }
    if (localObject1 == null) {
      throw new ProtocolException("Expected ':status' header not present");
    }
    return new Response.Builder().protocol(paramProtocol).code(localObject1.code).message(localObject1.message).headers(localBuilder.build());
  }
  
  public void cancel()
  {
    if (this.stream != null) {
      this.stream.closeLater(ErrorCode.CANCEL);
    }
  }
  
  public Sink createRequestBody(Request paramRequest, long paramLong)
  {
    return this.stream.getSink();
  }
  
  public void finishRequest()
    throws IOException
  {
    this.stream.getSink().close();
  }
  
  public void flushRequest()
    throws IOException
  {
    this.connection.flush();
  }
  
  public ResponseBody openResponseBody(Response paramResponse)
    throws IOException
  {
    this.streamAllocation.eventListener.responseBodyStart(this.streamAllocation.call);
    return new RealResponseBody(paramResponse.header("Content-Type"), HttpHeaders.contentLength(paramResponse), Okio.buffer(new StreamFinishingSource(this.stream.getSource())));
  }
  
  public Response.Builder readResponseHeaders(boolean paramBoolean)
    throws IOException
  {
    Response.Builder localBuilder2 = readHttp2HeadersList(this.stream.takeHeaders(), this.protocol);
    Response.Builder localBuilder1 = localBuilder2;
    if (paramBoolean)
    {
      localBuilder1 = localBuilder2;
      if (Internal.instance.code(localBuilder2) == 100) {
        localBuilder1 = null;
      }
    }
    return localBuilder1;
  }
  
  public void writeRequestHeaders(Request paramRequest)
    throws IOException
  {
    if (this.stream != null) {
      return;
    }
    if (paramRequest.body() != null) {}
    for (boolean bool = true;; bool = false)
    {
      paramRequest = http2HeadersList(paramRequest);
      this.stream = this.connection.newStream(paramRequest, bool);
      this.stream.readTimeout().timeout(this.chain.readTimeoutMillis(), TimeUnit.MILLISECONDS);
      this.stream.writeTimeout().timeout(this.chain.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
      return;
    }
  }
  
  class StreamFinishingSource
    extends ForwardingSource
  {
    long bytesRead = 0L;
    boolean completed = false;
    
    StreamFinishingSource(Source paramSource)
    {
      super();
    }
    
    private void endOfInput(IOException paramIOException)
    {
      if (this.completed) {
        return;
      }
      this.completed = true;
      Http2Codec.this.streamAllocation.streamFinished(false, Http2Codec.this, this.bytesRead, paramIOException);
    }
    
    public void close()
      throws IOException
    {
      super.close();
      endOfInput(null);
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      try
      {
        paramLong = delegate().read(paramBuffer, paramLong);
        if (paramLong > 0L) {
          this.bytesRead += paramLong;
        }
        return paramLong;
      }
      catch (IOException paramBuffer)
      {
        endOfInput(paramBuffer);
        throw paramBuffer;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Codec
 * JD-Core Version:    0.7.0.1
 */