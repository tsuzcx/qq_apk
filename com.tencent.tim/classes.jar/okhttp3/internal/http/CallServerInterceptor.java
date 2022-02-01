package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

public final class CallServerInterceptor
  implements Interceptor
{
  private final boolean forWebSocket;
  
  public CallServerInterceptor(boolean paramBoolean)
  {
    this.forWebSocket = paramBoolean;
  }
  
  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    RealInterceptorChain localRealInterceptorChain = (RealInterceptorChain)paramChain;
    HttpCodec localHttpCodec = localRealInterceptorChain.httpStream();
    StreamAllocation localStreamAllocation = localRealInterceptorChain.streamAllocation();
    Object localObject = (RealConnection)localRealInterceptorChain.connection();
    Request localRequest = localRealInterceptorChain.request();
    long l = System.currentTimeMillis();
    localRealInterceptorChain.eventListener().requestHeadersStart(localRealInterceptorChain.call());
    localHttpCodec.writeRequestHeaders(localRequest);
    localRealInterceptorChain.eventListener().requestHeadersEnd(localRealInterceptorChain.call(), localRequest);
    paramChain = null;
    if ((HttpMethod.permitsRequestBody(localRequest.method())) && (localRequest.body() != null))
    {
      if ("100-continue".equalsIgnoreCase(localRequest.header("Expect")))
      {
        localHttpCodec.flushRequest();
        localRealInterceptorChain.eventListener().responseHeadersStart(localRealInterceptorChain.call());
        paramChain = localHttpCodec.readResponseHeaders(true);
      }
      if (paramChain == null)
      {
        localRealInterceptorChain.eventListener().requestBodyStart(localRealInterceptorChain.call());
        localObject = new CountingSink(localHttpCodec.createRequestBody(localRequest, localRequest.body().contentLength()));
        BufferedSink localBufferedSink = Okio.buffer((Sink)localObject);
        localRequest.body().writeTo(localBufferedSink);
        localBufferedSink.close();
        localRealInterceptorChain.eventListener().requestBodyEnd(localRealInterceptorChain.call(), ((CountingSink)localObject).successfulCount);
      }
    }
    for (;;)
    {
      localHttpCodec.finishRequest();
      localObject = paramChain;
      if (paramChain == null)
      {
        localRealInterceptorChain.eventListener().responseHeadersStart(localRealInterceptorChain.call());
        localObject = localHttpCodec.readResponseHeaders(false);
      }
      paramChain = ((Response.Builder)localObject).request(localRequest).handshake(localStreamAllocation.connection().handshake()).sentRequestAtMillis(l).receivedResponseAtMillis(System.currentTimeMillis()).build();
      int j = paramChain.code();
      int i = j;
      if (j == 100)
      {
        paramChain = localHttpCodec.readResponseHeaders(false).request(localRequest).handshake(localStreamAllocation.connection().handshake()).sentRequestAtMillis(l).receivedResponseAtMillis(System.currentTimeMillis()).build();
        i = paramChain.code();
      }
      localRealInterceptorChain.eventListener().responseHeadersEnd(localRealInterceptorChain.call(), paramChain);
      if ((this.forWebSocket) && (i == 101)) {}
      for (paramChain = paramChain.newBuilder().body(Util.EMPTY_RESPONSE).build();; paramChain = paramChain.newBuilder().body(localHttpCodec.openResponseBody(paramChain)).build())
      {
        if (("close".equalsIgnoreCase(paramChain.request().header("Connection"))) || ("close".equalsIgnoreCase(paramChain.header("Connection")))) {
          localStreamAllocation.noNewStreams();
        }
        if (((i != 204) && (i != 205)) || (paramChain.body().contentLength() <= 0L)) {
          break label539;
        }
        throw new ProtocolException("HTTP " + i + " had non-zero Content-Length: " + paramChain.body().contentLength());
        if (!((RealConnection)localObject).isMultiplexed()) {
          localStreamAllocation.noNewStreams();
        }
        break;
      }
      label539:
      return paramChain;
      paramChain = null;
    }
  }
  
  static final class CountingSink
    extends ForwardingSink
  {
    long successfulCount;
    
    CountingSink(Sink paramSink)
    {
      super();
    }
    
    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      super.write(paramBuffer, paramLong);
      this.successfulCount += paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.internal.http.CallServerInterceptor
 * JD-Core Version:    0.7.0.1
 */