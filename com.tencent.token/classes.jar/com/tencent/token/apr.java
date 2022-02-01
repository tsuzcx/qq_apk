package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

final class apr
  extends Handler
{
  WeakReference a = null;
  
  public apr(aqr paramaqr, Context paramContext)
  {
    super(paramContext.getMainLooper());
    this.a = new WeakReference(paramaqr);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    aqr localaqr = (aqr)this.a.get();
    if (localaqr == null) {
      return;
    }
    if (paramMessage.what != 0) {
      return;
    }
    int i = localaqr.c + 1;
    localaqr.c = i;
    if (i < 20)
    {
      if (localaqr.d()) {
        localaqr.c = 0;
      }
    }
    else {
      localaqr.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.apr
 * JD-Core Version:    0.7.0.1
 */