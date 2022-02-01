package com.tencent.ad.tangram.loader;

import android.support.annotation.Keep;
import android.support.annotation.MainThread;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;

@Keep
public final class AdLoader
{
  private static final String TAG = "AdLoader";
  
  public static void load(Session paramSession, WeakReference<Listener> paramWeakReference)
  {
    AdThreadManager.INSTANCE.post(new AdLoader.1(paramSession, paramWeakReference), 4);
  }
  
  @Keep
  public static abstract interface Listener
  {
    @MainThread
    public abstract void onResponse(AdLoader.Session paramSession);
  }
  
  @Keep
  public static final class Session
  {
    public int httpResponseCode = -2147483648;
    public qq_ad_get.QQAdGet request;
    public qq_ad_get.QQAdGetRsp response;
    
    boolean canSend()
    {
      return this.request != null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.loader.AdLoader
 * JD-Core Version:    0.7.0.1
 */