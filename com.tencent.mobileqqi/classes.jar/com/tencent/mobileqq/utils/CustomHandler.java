package com.tencent.mobileqq.utils;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import java.lang.ref.WeakReference;

public class CustomHandler
  extends Handler
{
  private final WeakReference a;
  
  public CustomHandler(Handler.Callback paramCallback)
  {
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
 * Qualified Name:     com.tencent.mobileqq.utils.CustomHandler
 * JD-Core Version:    0.7.0.1
 */