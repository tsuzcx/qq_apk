package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

import android.net.Uri;
import android.support.annotation.CallSuper;
import android.support.annotation.GuardedBy;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Map;

public class Request
  implements Comparable<Request>
{
  private static final int DEFAULT_TIMEOUT_MILLIS = 8000;
  public static final int PRIORITY_HIGH = 3;
  public static final int PRIORITY_IMMEDIATE = 4;
  public static final int PRIORITY_LOW = 1;
  public static final int PRIORITY_NORMAL = 2;
  @GuardedBy("mLock")
  private boolean mCanceled = false;
  private final int mDefaultTrafficStatsTag;
  private final Map<String, String> mHttpHeaders;
  private int mHttpMethod;
  private final Object mLock = new Object();
  private final byte[] mPostBody;
  @GuardedBy("mLock")
  private NetworkRequestCompleteListener mRequestCompleteListener;
  private RequestQueue mRequestQueue;
  private Integer mSequence;
  private Object mTag;
  private final int mTimeoutMs;
  private final String mUrl;
  
  public Request(int paramInt, @Nullable String paramString, @Nullable NetworkRequestCompleteListener paramNetworkRequestCompleteListener)
  {
    this(paramInt, paramString, null, 8000, paramNetworkRequestCompleteListener);
  }
  
  public Request(int paramInt1, @Nullable String paramString, Map<String, String> paramMap, int paramInt2, @Nullable NetworkRequestCompleteListener paramNetworkRequestCompleteListener)
  {
    this(paramInt1, paramString, paramMap, null, paramInt2, paramNetworkRequestCompleteListener);
  }
  
  public Request(int paramInt1, @Nullable String paramString, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt2, NetworkRequestCompleteListener paramNetworkRequestCompleteListener)
  {
    this.mHttpMethod = paramInt1;
    this.mUrl = paramString;
    this.mPostBody = paramArrayOfByte;
    if (paramInt2 > 0) {}
    for (;;)
    {
      this.mTimeoutMs = paramInt2;
      this.mHttpHeaders = paramMap;
      this.mRequestCompleteListener = paramNetworkRequestCompleteListener;
      this.mDefaultTrafficStatsTag = findDefaultTrafficStatsTag(paramString);
      return;
      paramInt2 = 8000;
    }
  }
  
  private static int findDefaultTrafficStatsTag(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = paramString.getHost();
        if (paramString != null) {
          return paramString.hashCode();
        }
      }
    }
    return 0;
  }
  
  @CallSuper
  public void cancel()
  {
    synchronized (this.mLock)
    {
      this.mCanceled = true;
      this.mRequestCompleteListener = null;
      return;
    }
  }
  
  public int compareTo(Request paramRequest)
  {
    int i = getPriority();
    int j = paramRequest.getPriority();
    if (i == j) {
      return this.mSequence.intValue() - paramRequest.mSequence.intValue();
    }
    return j - i;
  }
  
  public void deliverError(IOException paramIOException)
  {
    synchronized (this.mLock)
    {
      NetworkRequestCompleteListener localNetworkRequestCompleteListener = this.mRequestCompleteListener;
      if (localNetworkRequestCompleteListener != null) {
        localNetworkRequestCompleteListener.onErrorResponse(this, paramIOException);
      }
      return;
    }
  }
  
  public void deliverResponse(Response paramResponse)
  {
    synchronized (this.mLock)
    {
      NetworkRequestCompleteListener localNetworkRequestCompleteListener = this.mRequestCompleteListener;
      if (localNetworkRequestCompleteListener != null) {
        localNetworkRequestCompleteListener.onResponseReceived(this, paramResponse);
      }
      return;
    }
  }
  
  void finish()
  {
    if (this.mRequestQueue != null) {
      this.mRequestQueue.finish(this);
    }
  }
  
  public Map<String, String> getHeaders()
  {
    return this.mHttpHeaders;
  }
  
  public int getHttpMethod()
  {
    return this.mHttpMethod;
  }
  
  public byte[] getPostBody()
  {
    return this.mPostBody;
  }
  
  @Priority
  public int getPriority()
  {
    return 2;
  }
  
  public final int getSequence()
  {
    if (this.mSequence == null) {
      throw new IllegalStateException("getSequence called before setSequence");
    }
    return this.mSequence.intValue();
  }
  
  public Object getTag()
  {
    return this.mTag;
  }
  
  public int getTimeoutMs()
  {
    return this.mTimeoutMs;
  }
  
  public int getTrafficStatsTag()
  {
    return this.mDefaultTrafficStatsTag;
  }
  
  public String getUrl()
  {
    return this.mUrl;
  }
  
  public boolean isCanceled()
  {
    synchronized (this.mLock)
    {
      boolean bool = this.mCanceled;
      return bool;
    }
  }
  
  public Request setRequestQueue(RequestQueue paramRequestQueue)
  {
    this.mRequestQueue = paramRequestQueue;
    return this;
  }
  
  public final Request setSequence(int paramInt)
  {
    this.mSequence = Integer.valueOf(paramInt);
    return this;
  }
  
  public Request setTag(Object paramObject)
  {
    this.mTag = paramObject;
    return this;
  }
  
  public String toString()
  {
    String str2 = "0x" + Integer.toHexString(getTrafficStatsTag());
    StringBuilder localStringBuilder = new StringBuilder();
    if (isCanceled()) {}
    for (String str1 = "[X] ";; str1 = "[ ] ") {
      return str1 + getUrl() + " " + str2 + " " + getPriority() + " " + this.mSequence;
    }
  }
  
  public static abstract interface NetworkRequestCompleteListener
  {
    public abstract void onErrorResponse(Request paramRequest, IOException paramIOException);
    
    public abstract void onResponseReceived(Request paramRequest, Response paramResponse);
  }
  
  public static @interface Priority {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.Request
 * JD-Core Version:    0.7.0.1
 */