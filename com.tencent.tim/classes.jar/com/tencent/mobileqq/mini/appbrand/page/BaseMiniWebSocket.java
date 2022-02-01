package com.tencent.mobileqq.mini.appbrand.page;

import android.os.Handler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class BaseMiniWebSocket
{
  public static final String TAG = "ServiceRemoteRuntime";
  protected WebSocketListener mListener;
  private OkHttpClient mOkHttpClient;
  protected Handler mThreadHandler;
  protected WebSocket mWebSocket;
  
  public void closeSocket(int paramInt, String paramString)
  {
    if (this.mWebSocket != null) {}
    try
    {
      this.mWebSocket.close(paramInt, paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void connect(String paramString)
  {
    this.mOkHttpClient = new OkHttpClient().newBuilder().connectTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).build();
    paramString = new Request.Builder().url(paramString).build();
    this.mOkHttpClient.newWebSocket(paramString, this.mListener);
  }
  
  public void destroy()
  {
    if (this.mOkHttpClient != null)
    {
      this.mOkHttpClient.dispatcher().executorService().shutdown();
      this.mOkHttpClient = null;
    }
  }
  
  public void sendStringMessage(String paramString)
  {
    if ((this.mWebSocket != null) && (this.mThreadHandler != null)) {
      this.mThreadHandler.post(new BaseMiniWebSocket.1(this, paramString));
    }
  }
  
  public void setThreadHandler(Handler paramHandler)
  {
    this.mThreadHandler = paramHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.BaseMiniWebSocket
 * JD-Core Version:    0.7.0.1
 */