package com.facebook.stetho.okhttp;

import com.facebook.stetho.inspector.network.DefaultResponseHandler;
import com.facebook.stetho.inspector.network.NetworkEventReporter;
import com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorRequest;
import com.facebook.stetho.inspector.network.NetworkEventReporter.InspectorResponse;
import com.facebook.stetho.inspector.network.NetworkEventReporterImpl;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Interceptor.Chain;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;

public class StethoInterceptor
  implements Interceptor
{
  private final NetworkEventReporter mEventReporter = NetworkEventReporterImpl.get();
  private final AtomicInteger mNextRequestId = new AtomicInteger(0);
  
  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    String str1 = null;
    String str2 = String.valueOf(this.mNextRequestId.getAndIncrement());
    Object localObject1 = paramChain.request();
    int j = 0;
    int i = j;
    Object localObject2;
    if (this.mEventReporter.isEnabled())
    {
      localObject2 = new OkHttpInspectorRequest(str2, (Request)localObject1);
      this.mEventReporter.requestWillBeSent((NetworkEventReporter.InspectorRequest)localObject2);
      localObject2 = ((OkHttpInspectorRequest)localObject2).body();
      i = j;
      if (localObject2 != null) {
        i = 0 + localObject2.length;
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = paramChain.proceed((Request)localObject1);
        if (this.mEventReporter.isEnabled())
        {
          if (i > 0) {
            this.mEventReporter.dataSent(str2, i, i);
          }
          paramChain = paramChain.connection();
          this.mEventReporter.responseHeadersReceived(new OkHttpInspectorResponse(str2, (Request)localObject1, (Response)localObject2, paramChain));
          ResponseBody localResponseBody = ((Response)localObject2).body();
          if (localResponseBody == null) {
            break label287;
          }
          localObject1 = localResponseBody.contentType();
          paramChain = localResponseBody.byteStream();
          NetworkEventReporter localNetworkEventReporter = this.mEventReporter;
          if (localObject1 != null) {
            str1 = ((MediaType)localObject1).toString();
          }
          paramChain = localNetworkEventReporter.interpretResponseStream(str2, str1, ((Response)localObject2).header("Content-Encoding"), paramChain, new DefaultResponseHandler(this.mEventReporter, str2));
          if (paramChain != null) {
            return ((Response)localObject2).newBuilder().body(new ForwardingResponseBody(localResponseBody, paramChain)).build();
          }
        }
      }
      catch (IOException paramChain)
      {
        if (this.mEventReporter.isEnabled()) {
          this.mEventReporter.httpExchangeFailed(str2, paramChain.toString());
        }
        throw paramChain;
      }
      return localObject2;
      label287:
      paramChain = null;
      localObject1 = null;
    }
  }
  
  static class ForwardingResponseBody
    extends ResponseBody
  {
    private final ResponseBody mBody;
    private final BufferedSource mInterceptedSource;
    
    public ForwardingResponseBody(ResponseBody paramResponseBody, InputStream paramInputStream)
    {
      this.mBody = paramResponseBody;
      this.mInterceptedSource = Okio.buffer(Okio.source(paramInputStream));
    }
    
    public long contentLength()
    {
      return this.mBody.contentLength();
    }
    
    public MediaType contentType()
    {
      return this.mBody.contentType();
    }
    
    public BufferedSource source()
    {
      return this.mInterceptedSource;
    }
  }
  
  static class OkHttpInspectorRequest
    implements NetworkEventReporter.InspectorRequest
  {
    private byte[] mBody;
    private boolean mBodyGenerated;
    private final Request mRequest;
    private final String mRequestId;
    
    public OkHttpInspectorRequest(String paramString, Request paramRequest)
    {
      this.mRequestId = paramString;
      this.mRequest = paramRequest;
    }
    
    private byte[] generateBody()
      throws IOException
    {
      RequestBody localRequestBody = this.mRequest.body();
      if (localRequestBody == null) {
        return null;
      }
      Buffer localBuffer = new Buffer();
      localRequestBody.writeTo(localBuffer);
      return localBuffer.readByteArray();
    }
    
    @Nullable
    public byte[] body()
      throws IOException
    {
      if (!this.mBodyGenerated)
      {
        this.mBodyGenerated = true;
        this.mBody = generateBody();
      }
      return this.mBody;
    }
    
    @Nullable
    public String firstHeaderValue(String paramString)
    {
      return this.mRequest.header(paramString);
    }
    
    public String friendlyName()
    {
      return null;
    }
    
    @Nullable
    public Integer friendlyNameExtra()
    {
      return null;
    }
    
    public int headerCount()
    {
      return this.mRequest.headers().size();
    }
    
    public String headerName(int paramInt)
    {
      return this.mRequest.headers().name(paramInt);
    }
    
    public String headerValue(int paramInt)
    {
      return this.mRequest.headers().value(paramInt);
    }
    
    public String id()
    {
      return this.mRequestId;
    }
    
    public String method()
    {
      return this.mRequest.method();
    }
    
    public String url()
    {
      return this.mRequest.urlString();
    }
  }
  
  static class OkHttpInspectorResponse
    implements NetworkEventReporter.InspectorResponse
  {
    private final Connection mConnection;
    private final Request mRequest;
    private final String mRequestId;
    private final Response mResponse;
    
    public OkHttpInspectorResponse(String paramString, Request paramRequest, Response paramResponse, Connection paramConnection)
    {
      this.mRequestId = paramString;
      this.mRequest = paramRequest;
      this.mResponse = paramResponse;
      this.mConnection = paramConnection;
    }
    
    public int connectionId()
    {
      return this.mConnection.hashCode();
    }
    
    public boolean connectionReused()
    {
      return false;
    }
    
    @Nullable
    public String firstHeaderValue(String paramString)
    {
      return this.mResponse.header(paramString);
    }
    
    public boolean fromDiskCache()
    {
      return this.mResponse.cacheResponse() != null;
    }
    
    public int headerCount()
    {
      return this.mResponse.headers().size();
    }
    
    public String headerName(int paramInt)
    {
      return this.mResponse.headers().name(paramInt);
    }
    
    public String headerValue(int paramInt)
    {
      return this.mResponse.headers().value(paramInt);
    }
    
    public String reasonPhrase()
    {
      return this.mResponse.message();
    }
    
    public String requestId()
    {
      return this.mRequestId;
    }
    
    public int statusCode()
    {
      return this.mResponse.code();
    }
    
    public String url()
    {
      return this.mRequest.urlString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.okhttp.StethoInterceptor
 * JD-Core Version:    0.7.0.1
 */