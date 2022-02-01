package com.tencent.qapmsdk.impl.instrumentation.okhttp2;

import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.ResponseBody;
import com.tencent.qapmsdk.common.logger.Logger;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;

public class ResponseBuilderExtension
  extends Response.Builder
{
  private static final String TAG = "QAPM_Impl_ResponseBuilderExtension";
  private Response.Builder impl;
  
  public ResponseBuilderExtension(Response.Builder paramBuilder)
  {
    this.impl = paramBuilder;
  }
  
  public Response.Builder addHeader(String paramString1, String paramString2)
  {
    return this.impl.addHeader(paramString1, paramString2);
  }
  
  public Response.Builder body(ResponseBody paramResponseBody)
  {
    if (paramResponseBody != null) {}
    try
    {
      Object localObject = paramResponseBody.source();
      if (localObject != null)
      {
        Buffer localBuffer = new Buffer();
        ((BufferedSource)localObject).readAll(localBuffer);
        localObject = this.impl.body(new QAPMPrebufferedResponseBody(paramResponseBody, localBuffer));
        return localObject;
      }
    }
    catch (IOException localIOException)
    {
      Logger.INSTANCE.exception("QAPM_Impl_ResponseBuilderExtension", "IOException reading from source: ", localIOException);
      return this.impl.body(paramResponseBody);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        Logger.INSTANCE.exception("QAPM_Impl_ResponseBuilderExtension", "IllegalStateException reading from source: ", localIllegalStateException);
      }
    }
  }
  
  public Response build()
  {
    return this.impl.build();
  }
  
  public Response.Builder cacheResponse(Response paramResponse)
  {
    return this.impl.cacheResponse(paramResponse);
  }
  
  public Response.Builder code(int paramInt)
  {
    return this.impl.code(paramInt);
  }
  
  public Response.Builder handshake(Handshake paramHandshake)
  {
    return this.impl.handshake(paramHandshake);
  }
  
  public Response.Builder header(String paramString1, String paramString2)
  {
    return this.impl.header(paramString1, paramString2);
  }
  
  public Response.Builder headers(Headers paramHeaders)
  {
    return this.impl.headers(paramHeaders);
  }
  
  public Response.Builder message(String paramString)
  {
    return this.impl.message(paramString);
  }
  
  public Response.Builder networkResponse(Response paramResponse)
  {
    return this.impl.networkResponse(paramResponse);
  }
  
  public Response.Builder priorResponse(Response paramResponse)
  {
    return this.impl.priorResponse(paramResponse);
  }
  
  public Response.Builder protocol(Protocol paramProtocol)
  {
    return this.impl.protocol(paramProtocol);
  }
  
  public Response.Builder removeHeader(String paramString)
  {
    return this.impl.removeHeader(paramString);
  }
  
  public Response.Builder request(Request paramRequest)
  {
    return this.impl.request(paramRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.okhttp2.ResponseBuilderExtension
 * JD-Core Version:    0.7.0.1
 */