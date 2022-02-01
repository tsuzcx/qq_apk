package com.tencent.token;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class ari
  extends Handler
{
  ari(aso paramaso, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 2: 
      paramMessage = (asc)paramMessage.obj;
      aso.a(this.a, paramMessage);
      return;
    }
    aso.a((asb)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ari
 * JD-Core Version:    0.7.0.1
 */