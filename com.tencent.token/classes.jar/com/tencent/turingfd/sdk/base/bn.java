package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.atomic.AtomicReference;

public class bn
  extends Handler
{
  public Context a;
  
  public bn(bm parambm, Looper paramLooper, Context paramContext)
  {
    super(paramLooper);
    this.a = paramContext;
  }
  
  public void handleMessage(Message paramMessage)
  {
    System.currentTimeMillis();
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      paramMessage = bm.a(this.b, this.a, true);
      if (paramMessage.d == 0) {
        bm.a(this.b, paramMessage);
      }
      bm.b(this.b).set(Boolean.valueOf(false));
      return;
    }
    bm.a(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bn
 * JD-Core Version:    0.7.0.1
 */