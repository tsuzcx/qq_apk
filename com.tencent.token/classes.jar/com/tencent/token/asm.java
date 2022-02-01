package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

final class asm
  extends Handler
{
  WeakReference a = null;
  
  public asm(atm paramatm, Context paramContext)
  {
    super(paramContext.getMainLooper());
    this.a = new WeakReference(paramatm);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    atm localatm = (atm)this.a.get();
    if (localatm == null) {
      return;
    }
    if (paramMessage.what != 0) {
      return;
    }
    int i = localatm.c + 1;
    localatm.c = i;
    if (i < 20)
    {
      if (localatm.d()) {
        localatm.c = 0;
      }
    }
    else {
      localatm.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.asm
 * JD-Core Version:    0.7.0.1
 */