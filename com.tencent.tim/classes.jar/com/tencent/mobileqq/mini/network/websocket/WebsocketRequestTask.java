package com.tencent.mobileqq.mini.network.websocket;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.RequestPlugin.MiniAppWebsocketListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import okhttp3.Dispatcher;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.WebSocket;
import okio.ByteString;
import org.json.JSONObject;

public class WebsocketRequestTask
{
  public static AtomicInteger sId = new AtomicInteger();
  private RequestPlugin.MiniAppWebsocketListener listener;
  private OkHttpClient mOkHttpClient;
  private RequestParam requestParam;
  
  public WebsocketRequestTask(RequestParam paramRequestParam, RequestPlugin.MiniAppWebsocketListener paramMiniAppWebsocketListener)
  {
    paramMiniAppWebsocketListener.currSocketId = (sId.getAndIncrement() + 1);
    Object localObject = new Request.Builder().url(paramRequestParam.mUrl).build().newBuilder();
    if (paramRequestParam.mHeaders != null)
    {
      Iterator localIterator = paramRequestParam.mHeaders.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((Request.Builder)localObject).addHeader(str, (String)paramRequestParam.mHeaders.get(str));
      }
    }
    localObject = ((Request.Builder)localObject).build();
    long l = paramRequestParam.timeout / 1000 + 1;
    this.mOkHttpClient = new OkHttpClient().newBuilder().connectTimeout(l, TimeUnit.SECONDS).writeTimeout(l, TimeUnit.SECONDS).readTimeout(0L, TimeUnit.SECONDS).build();
    this.mOkHttpClient.newWebSocket((Request)localObject, paramMiniAppWebsocketListener);
    this.listener = paramMiniAppWebsocketListener;
    this.requestParam = paramRequestParam;
  }
  
  public void closeSocket(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("closeSocket listener ： ").append(this.listener).append(";  listener.webSocket : ");
      if (this.listener == null) {
        break label123;
      }
    }
    for (WebSocket localWebSocket = this.listener.webSocket;; localWebSocket = null)
    {
      QLog.d("WebsocketRequestTask", 2, localWebSocket);
      if ((this.listener != null) && (this.listener.webSocket != null)) {}
      try
      {
        this.listener.webSocket.close(paramInt, paramString);
        ThreadManager.getSubThreadHandler().postDelayed(new WebsocketRequestTask.1(this, paramInt, paramString), 1000L);
        return;
      }
      catch (Throwable localThrowable)
      {
        label123:
        QLog.e("WebsocketRequestTask", 1, "closeSocket error:", localThrowable);
        if ((localThrowable.getMessage() == null) || (!localThrowable.getMessage().contains("closed"))) {
          break;
        }
        this.listener.onClosed(this.listener.webSocket, paramInt, paramString);
        return;
      }
      finally
      {
        this.listener.webSocket = null;
      }
    }
  }
  
  public void destory()
  {
    if (this.mOkHttpClient != null)
    {
      this.mOkHttpClient.dispatcher().executorService().shutdownNow();
      this.mOkHttpClient = null;
    }
  }
  
  public RequestParam getRequestParam()
  {
    return this.requestParam;
  }
  
  public void sendBinaryMessage(byte[] paramArrayOfByte)
  {
    if ((this.listener != null) && (this.listener.webSocket != null)) {}
    try
    {
      MediaType.parse("application/vnd.okhttp.websocket+binary");
      this.listener.webSocket.send(ByteString.of(paramArrayOfByte));
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte = paramArrayOfByte;
      QLog.e("WebsocketRequestTask", 1, "sendBinaryMessage error:", paramArrayOfByte);
      return;
    }
    finally {}
  }
  
  public void sendStringMessage(String paramString)
  {
    if ((this.listener != null) && (this.listener.webSocket != null)) {}
    try
    {
      MediaType.parse("application/vnd.okhttp.websocket+text; charset=utf-8");
      this.listener.webSocket.send(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString = paramString;
      QLog.e("WebsocketRequestTask", 1, "sendStringMessage error:", paramString);
      return;
    }
    finally {}
  }
  
  public static class RequestParam
  {
    public Map<String, String> mHeaders;
    public String mOriginUrl;
    public String mUrl;
    public String method;
    public int timeout = 60000;
    
    public RequestParam(JSONObject paramJSONObject)
    {
      merge(paramJSONObject);
    }
    
    public void merge(JSONObject paramJSONObject)
    {
      if (paramJSONObject != null)
      {
        if (paramJSONObject.has("url")) {
          this.mUrl = paramJSONObject.optString("url");
        }
        if (paramJSONObject.has("origin_url")) {}
        for (this.mOriginUrl = paramJSONObject.optString("origin_url");; this.mOriginUrl = this.mUrl)
        {
          if (paramJSONObject.has("method")) {
            this.method = paramJSONObject.optString("method");
          }
          if (!paramJSONObject.has("header")) {
            break;
          }
          JSONObject localJSONObject = paramJSONObject.optJSONObject("header");
          Iterator localIterator = localJSONObject.keys();
          if (this.mHeaders == null) {
            this.mHeaders = new HashMap();
          }
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            this.mHeaders.put(str, localJSONObject.optString(str));
          }
        }
        if (paramJSONObject.has("timeout")) {
          this.timeout = paramJSONObject.optInt("timeout");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.websocket.WebsocketRequestTask
 * JD-Core Version:    0.7.0.1
 */