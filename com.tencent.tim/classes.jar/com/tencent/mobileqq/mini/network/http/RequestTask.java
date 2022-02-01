package com.tencent.mobileqq.mini.network.http;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minigame.utils.NativeBuffer;
import com.tencent.mobileqq.triton.sdk.bridge.ITNativeBufferPool;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Call;
import org.json.JSONObject;

public class RequestTask
  implements Runnable
{
  public static final String CONTENT_TYPE = "content-type";
  private static final String DEFAULT_DATA_TYPE = "application/json";
  private static final String TAG = "RequestTask";
  private static final ArrayList<String> supportMethod = new ArrayList(Arrays.asList(new String[] { "OPTIONS", "GET", "HEAD", "POST", "PUT", "DELETE", "TRACE" }));
  private RequestConfig mConfig;
  public AtomicBoolean mIsAbort = new AtomicBoolean(false);
  private Call mOkHttpCall;
  private Request mRequest;
  
  public RequestTask(Request paramRequest)
  {
    this.mRequest = paramRequest;
    this.mConfig = new RequestConfig();
    this.mConfig.mNetworkTimeOut = this.mRequest.mTimeOut;
  }
  
  public void abort()
  {
    this.mIsAbort.getAndSet(true);
    if (this.mOkHttpCall != null) {
      this.mOkHttpCall.cancel();
    }
    ThreadManagerV2.removeJobFromThreadPool(this, 128);
  }
  
  public void run()
  {
    if (this.mRequest != null)
    {
      if (!this.mIsAbort.get()) {
        break label42;
      }
      WxRequest.removeTaskInMap(this.mRequest.mTaskId);
      this.mRequest.mCallback.httpCallBack(-5, null, null);
    }
    label42:
    while (!this.mRequest.preParse()) {
      return;
    }
    String[] arrayOfString = MiniappHttpUtil.mapToString(this.mRequest.mHeaders);
    RequestTask.1 local1 = new RequestTask.1(this);
    Object localObject = this.mRequest.mMethod.toUpperCase();
    if (!supportMethod.contains(localObject))
    {
      this.mRequest.mCallback.httpCallBack(-3, null, null);
      return;
    }
    if (((String)localObject).equals("GET"))
    {
      this.mOkHttpCall = MiniappHttpUtil.httpGetV2(this.mRequest.mUrl, arrayOfString, local1, this.mConfig);
      return;
    }
    if (((String)localObject).equals("POST"))
    {
      this.mOkHttpCall = MiniappHttpUtil.httpPostV2(this.mRequest.mUrl, this.mRequest.mBody, arrayOfString, local1, this.mConfig);
      return;
    }
    String str1 = this.mRequest.mMethod;
    String str2 = this.mRequest.mUrl;
    if (this.mRequest.mBody == null) {}
    for (localObject = new byte[1];; localObject = this.mRequest.mBody)
    {
      this.mOkHttpCall = MiniappHttpUtil.httpSendV2(str1, str2, (byte[])localObject, arrayOfString, local1, this.mConfig);
      return;
    }
  }
  
  public static class Request
  {
    public static AtomicInteger sId = new AtomicInteger();
    public String mAppName;
    public byte[] mBody;
    public HttpCallBack mCallback;
    public String mDataType = "json";
    public Map<String, String> mHeaders;
    public String mMethod = "GET";
    public String mOriginUrl;
    public long mRequestCreatedMillis;
    public String mResponseType = "text";
    public int mTaskId = sId.getAndIncrement();
    public int mTimeOut;
    public String mUin;
    public String mUrl;
    public String referer = "https://appservice.qq.com/{appid}/{version}/page-frame.html";
    public String ua = "QQ/MiniApp";
    
    public Request(JSONObject paramJSONObject, String paramString1, String paramString2, ITNativeBufferPool paramITNativeBufferPool)
    {
      this.referer = paramString1;
      if (!TextUtils.isEmpty(paramString2)) {
        this.ua = paramString2;
      }
      this.mRequestCreatedMillis = SystemClock.elapsedRealtime();
      merge(paramJSONObject, paramITNativeBufferPool);
    }
    
    public void merge(JSONObject paramJSONObject, ITNativeBufferPool paramITNativeBufferPool)
    {
      String str = null;
      if (paramJSONObject != null)
      {
        if (paramJSONObject.has("url")) {
          this.mUrl = paramJSONObject.optString("url");
        }
        if (paramJSONObject.has("origin_url"))
        {
          this.mOriginUrl = paramJSONObject.optString("origin_url");
          paramITNativeBufferPool = NativeBuffer.unpackNativeBuffer(paramJSONObject, "data", paramITNativeBufferPool);
          if (paramITNativeBufferPool == null) {
            break label277;
          }
          paramITNativeBufferPool = paramITNativeBufferPool.buf;
          label61:
          this.mBody = paramITNativeBufferPool;
          if ((this.mBody == null) && (paramJSONObject.has("data")))
          {
            paramITNativeBufferPool = paramJSONObject.optString("data");
            if (paramITNativeBufferPool != null) {
              break label282;
            }
          }
        }
        label277:
        label282:
        for (paramITNativeBufferPool = str;; paramITNativeBufferPool = paramITNativeBufferPool.getBytes())
        {
          this.mBody = paramITNativeBufferPool;
          if (paramJSONObject.has("method")) {
            this.mMethod = paramJSONObject.optString("method");
          }
          if (paramJSONObject.has("dataType")) {
            this.mDataType = paramJSONObject.optString("dataType");
          }
          if (paramJSONObject.has("responseType")) {
            this.mResponseType = paramJSONObject.optString("responseType");
          }
          if (!paramJSONObject.has("header")) {
            return;
          }
          paramJSONObject = paramJSONObject.optJSONObject("header");
          paramITNativeBufferPool = paramJSONObject.keys();
          if (this.mHeaders == null)
          {
            this.mHeaders = new HashMap();
            this.mHeaders.put("Referer", this.referer);
            this.mHeaders.put("User-Agent", this.ua);
          }
          while (paramITNativeBufferPool.hasNext())
          {
            str = (String)paramITNativeBufferPool.next();
            this.mHeaders.put(str, paramJSONObject.optString(str));
          }
          this.mOriginUrl = this.mUrl;
          break;
          paramITNativeBufferPool = null;
          break label61;
        }
      }
    }
    
    public boolean preParse()
    {
      return (!TextUtils.isEmpty(this.mUrl)) && (!TextUtils.isEmpty(this.mMethod));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.http.RequestTask
 * JD-Core Version:    0.7.0.1
 */