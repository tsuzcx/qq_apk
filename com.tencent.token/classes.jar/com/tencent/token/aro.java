package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

final class aro
  extends Handler
{
  WeakReference a = null;
  
  public aro(aso paramaso, Context paramContext)
  {
    super(paramContext.getMainLooper());
    this.a = new WeakReference(paramaso);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    aso localaso = (aso)this.a.get();
    if (localaso == null) {
      return;
    }
    if (paramMessage.what != 0) {
      return;
    }
    int i = localaso.c + 1;
    localaso.c = i;
    if (i < 20)
    {
      if (localaso.d()) {
        localaso.c = 0;
      }
    }
    else {
      localaso.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aro
 * JD-Core Version:    0.7.0.1
 */