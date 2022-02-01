package com.tencent.ad.tangram.ipc;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@Keep
public enum AdIPCManager
{
  INSTANCE;
  
  private static final String TAG = "AdIPCManager";
  private WeakReference<Adapter> adapter;
  private volatile boolean initialized = false;
  private Map<String, Handler> map = new HashMap();
  
  private AdIPCManager() {}
  
  public Handler getHandler(String paramString)
  {
    if ((this.adapter != null) && (this.adapter.get() != null)) {
      return ((Adapter)this.adapter.get()).getHandler(paramString);
    }
    return null;
  }
  
  public void init(Context paramContext, WeakReference<Adapter> paramWeakReference)
  {
    AdLog.i("AdIPCManager", String.format("init %b", new Object[] { Boolean.valueOf(this.initialized) }));
    if (this.initialized) {}
    do
    {
      return;
      try
      {
        if (this.initialized) {
          return;
        }
      }
      finally {}
      this.initialized = true;
      this.adapter = paramWeakReference;
    } while ((paramWeakReference == null) || (paramWeakReference.get() == null));
    ((Adapter)paramWeakReference.get()).init(paramContext);
  }
  
  public boolean register(String paramString, Handler paramHandler)
  {
    if ((this.adapter != null) && (this.adapter.get() != null)) {
      return ((Adapter)this.adapter.get()).register(paramString, paramHandler);
    }
    return false;
  }
  
  public Result send(Context paramContext, Params paramParams)
  {
    if ((this.adapter != null) && (this.adapter.get() != null)) {
      return ((Adapter)this.adapter.get()).send(paramContext, paramParams);
    }
    return null;
  }
  
  public void send(Context paramContext, Params paramParams, WeakReference<Callback> paramWeakReference)
  {
    if ((this.adapter != null) && (this.adapter.get() != null)) {
      ((Adapter)this.adapter.get()).send(paramContext, paramParams, paramWeakReference);
    }
  }
  
  @Keep
  public static abstract interface Adapter
  {
    public abstract AdIPCManager.Handler getHandler(String paramString);
    
    public abstract void init(Context paramContext);
    
    public abstract boolean register(String paramString, AdIPCManager.Handler paramHandler);
    
    public abstract AdIPCManager.Result send(Context paramContext, AdIPCManager.Params paramParams);
    
    public abstract void send(Context paramContext, AdIPCManager.Params paramParams, WeakReference<AdIPCManager.Callback> paramWeakReference);
  }
  
  @Keep
  public static abstract interface Callback
  {
    public abstract void onCallback(AdIPCManager.Params paramParams, AdIPCManager.Result paramResult);
  }
  
  @Keep
  public static abstract interface Handler
  {
    public abstract AdIPCManager.Result handle(AdIPCManager.Params paramParams);
  }
  
  @Keep
  public static final class Params
  {
    public static final String KEY_ACTION = "IPC_ACTION";
    public static final String KEY_TO_PROCESS_NAME = "IPC_TO_PROCESS_NAME";
    public Bundle bundle;
    
    public Params(Bundle paramBundle)
    {
      this.bundle = paramBundle;
    }
    
    public String getAction()
    {
      if (this.bundle != null) {
        return this.bundle.getString("IPC_ACTION");
      }
      return null;
    }
    
    public String getToProcessName()
    {
      if (this.bundle != null) {
        return this.bundle.getString("IPC_TO_PROCESS_NAME");
      }
      return null;
    }
    
    public boolean isValid()
    {
      return (!TextUtils.isEmpty(getAction())) && (!TextUtils.isEmpty(getToProcessName()));
    }
  }
  
  @Keep
  public static final class Result
  {
    public Bundle bundle;
    public boolean success = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.ipc.AdIPCManager
 * JD-Core Version:    0.7.0.1
 */