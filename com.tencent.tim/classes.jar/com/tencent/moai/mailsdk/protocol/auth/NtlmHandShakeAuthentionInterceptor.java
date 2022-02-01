package com.tencent.moai.mailsdk.protocol.auth;

import android.util.Log;
import androidx.annotation.Nullable;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.io.IOException;
import java.security.AccessController;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http1.Http1Codec;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;

public class NtlmHandShakeAuthentionInterceptor
  implements Interceptor
{
  private static final String TAG = "NtlmHandShakeAuthentionInterceptor";
  private static String hostName = (String)AccessController.doPrivileged(new NtlmHandShakeAuthentionInterceptor.1());
  private final NtlmV2 ntlm;
  
  public NtlmHandShakeAuthentionInterceptor(String paramString1, String paramString2, @Nullable String paramString3, boolean paramBoolean)
  {
    this.ntlm = new NtlmV2(paramString3, hostName, paramString1, paramString2);
  }
  
  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    localObject3 = null;
    localObject5 = null;
    Object localObject7 = null;
    Object localObject1 = null;
    Request localRequest = paramChain.request();
    try
    {
      localObject4 = " NTLM " + this.ntlm.generateType1Msg();
      localObject6 = RequestBody.create(MediaType.parse(localRequest.header("Content-Type")), new byte[0]);
      localObject4 = new NtlmHankShakeCallServerInterceptor(localRequest.newBuilder().addHeader("Authorization", (String)localObject4).removeHeader("Content-Length").addHeader("Content-Length", "0").removeHeader("Connection").addHeader("Connection", "Keep-Alive").method(localRequest.method(), (RequestBody)localObject6).build()).intercept(paramChain);
      localObject3 = localObject5;
      localObject6 = localObject4;
      if (localObject4 != null)
      {
        localObject3 = localObject5;
        localObject6 = localObject4;
        localObject5 = localObject7;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        label177:
        Object localObject4 = null;
        Logger.log(6, "NtlmHandShakeAuthentionInterceptor", Log.getStackTraceString(localException1));
        Object localObject6 = localObject4;
        Object localObject2 = localObject6;
      }
    }
    try
    {
      if (((Response)localObject4).code() != 401) {
        break label366;
      }
      localObject5 = localObject7;
      localObject3 = ((Response)localObject4).headers("WWW-Authenticate").iterator();
    }
    catch (Exception localException2)
    {
      localObject3 = localObject5;
      break label351;
      break label177;
    }
    localObject5 = localObject1;
    if (((Iterator)localObject3).hasNext())
    {
      localObject5 = localObject1;
      localObject6 = (String)((Iterator)localObject3).next();
      localObject5 = localObject1;
      if (((String)localObject6).toLowerCase().startsWith("ntlm "))
      {
        localObject5 = localObject1;
        localObject1 = ((String)localObject6).substring(5);
      }
    }
    else
    {
      localObject3 = localObject1;
      localObject6 = localObject4;
      if (localObject1 != null)
      {
        localObject5 = localObject1;
        Logger.log(4, "NtlmHandShakeAuthentionInterceptor", "ntlmValue: " + (String)localObject1);
        localObject5 = localObject1;
        localObject3 = "NTLM " + this.ntlm.generateType3Msg((String)localObject1);
        localObject5 = localObject1;
        localObject3 = paramChain.proceed(localRequest.newBuilder().header("Authorization", (String)localObject3).build());
        localObject4 = localObject3;
        localObject3 = localObject1;
        localObject1 = localObject4;
        if (localObject3 == null) {
          localObject1 = paramChain.proceed(localRequest);
        }
        return localObject1;
      }
    }
  }
  
  final class NtlmHankShakeCallServerInterceptor
  {
    private final Request request;
    
    NtlmHankShakeCallServerInterceptor(Request paramRequest)
    {
      this.request = paramRequest;
    }
    
    public Response intercept(Interceptor.Chain paramChain)
      throws IOException
    {
      if ((paramChain.connection() == null) || (!(paramChain.connection() instanceof RealConnection))) {
        return null;
      }
      paramChain = (RealConnection)paramChain.connection();
      Object localObject = Okio.buffer(Okio.source(paramChain.socket()));
      BufferedSink localBufferedSink = Okio.buffer(Okio.sink(paramChain.socket()));
      paramChain = new Http1Codec(null, null, (BufferedSource)localObject, localBufferedSink);
      ((BufferedSource)localObject).timeout().timeout(50000L, TimeUnit.MILLISECONDS);
      localBufferedSink.timeout().timeout(50000L, TimeUnit.MILLISECONDS);
      localObject = this.request.method() + " " + this.request.url().encodedPath() + " HTTP/1.1";
      paramChain.writeRequest(this.request.headers(), (String)localObject);
      paramChain.finishRequest();
      localObject = paramChain.readResponseHeaders(false).request(this.request).build();
      long l2 = HttpHeaders.contentLength((Response)localObject);
      long l1 = l2;
      if (l2 == -1L) {
        l1 = 0L;
      }
      paramChain = paramChain.newFixedLengthSource(l1);
      Util.skipAll(paramChain, 2147483647, TimeUnit.MILLISECONDS);
      paramChain.close();
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.auth.NtlmHandShakeAuthentionInterceptor
 * JD-Core Version:    0.7.0.1
 */