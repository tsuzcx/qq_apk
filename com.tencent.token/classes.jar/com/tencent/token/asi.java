package com.tencent.token;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class asi
  extends Handler
{
  asi(atm paramatm, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    atm.a(this.a, paramMessage.what);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.asi
 * JD-Core Version:    0.7.0.1
 */