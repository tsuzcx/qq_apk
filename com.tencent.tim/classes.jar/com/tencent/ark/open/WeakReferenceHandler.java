package com.tencent.ark.open;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.ark.ArkEnvironmentManager;
import java.lang.ref.WeakReference;

public class WeakReferenceHandler
  extends Handler
{
  private WeakReference<Handler.Callback> mWeakReferCallBack;
  
  public WeakReferenceHandler(Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper);
    this.mWeakReferCallBack = new WeakReference(paramCallback);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Handler.Callback localCallback = (Handler.Callback)this.mWeakReferCallBack.get();
    if (localCallback != null)
    {
      localCallback.handleMessage(paramMessage);
      return;
    }
    ArkEnvironmentManager.getInstance().logD("WeakReferenceHandler", "handleMessage cb is null! handler = " + this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.ark.open.WeakReferenceHandler
 * JD-Core Version:    0.7.0.1
 */