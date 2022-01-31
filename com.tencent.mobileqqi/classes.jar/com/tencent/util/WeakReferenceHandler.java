package com.tencent.util;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class WeakReferenceHandler
  extends Handler
{
  private WeakReference a;
  
  public WeakReferenceHandler(Handler.Callback paramCallback)
  {
    this.a = new WeakReference(paramCallback);
  }
  
  public WeakReferenceHandler(Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper);
    this.a = new WeakReference(paramCallback);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Handler.Callback localCallback = (Handler.Callback)this.a.get();
    if (localCallback != null) {
      localCallback.handleMessage(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.util.WeakReferenceHandler
 * JD-Core Version:    0.7.0.1
 */