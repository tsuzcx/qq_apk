package com.tencent.qapmsdk.impl.httpOprate;

import android.text.TextUtils;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.util.TraceUtil;
import java.io.IOException;
import java.lang.reflect.Field;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class QAPMHttpCall
  implements Call
{
  private static final String TAG = "QAPM_Impl_Call";
  private Call call;
  
  public QAPMHttpCall(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    this.call = paramOkHttpClient.newCall(paramRequest);
  }
  
  private Request setQuitTime(Request paramRequest, long paramLong)
  {
    Request localRequest = paramRequest;
    Object localObject;
    try
    {
      if (!TraceUtil.getCanMonitorHttp()) {
        return paramRequest;
      }
      localRequest = paramRequest;
      localObject = paramRequest;
      if (TextUtils.isEmpty(paramRequest.header("X-QAPM-Qt")))
      {
        localRequest = paramRequest;
        localObject = this.call.getClass().getDeclaredField("originalRequest");
        localRequest = paramRequest;
        ((Field)localObject).setAccessible(true);
        localRequest = paramRequest;
        paramRequest = ((Request)((Field)localObject).get(this.call)).newBuilder().addHeader("X-QAPM-Qt", String.valueOf(paramLong)).build();
        localRequest = paramRequest;
        ((Field)localObject).set(this.call, paramRequest);
        return paramRequest;
      }
    }
    catch (Exception paramRequest)
    {
      Logger.INSTANCE.exception("QAPM_Impl_Call", "error ok3 addHeaderRequest e:", paramRequest);
      localObject = localRequest;
    }
    return localObject;
  }
  
  public void cancel()
  {
    this.call.cancel();
  }
  
  public Call clone()
  {
    return this.call.clone();
  }
  
  public void enqueue(Callback paramCallback)
  {
    try
    {
      setQuitTime(this.call.request(), System.currentTimeMillis());
      this.call.enqueue(paramCallback);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_Impl_Call", "addHeaderRequest error:" });
      }
    }
  }
  
  public Response execute()
    throws IOException
  {
    return this.call.execute();
  }
  
  public boolean isCanceled()
  {
    return this.call.isCanceled();
  }
  
  public boolean isExecuted()
  {
    return this.call.isExecuted();
  }
  
  public Request request()
  {
    return this.call.request();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.httpOprate.QAPMHttpCall
 * JD-Core Version:    0.7.0.1
 */