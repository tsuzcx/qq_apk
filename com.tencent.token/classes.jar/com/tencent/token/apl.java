package com.tencent.token;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class apl
  extends Handler
{
  apl(aqr paramaqr, Looper paramLooper)
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
      paramMessage = (aqf)paramMessage.obj;
      aqr.a(this.a, paramMessage);
      return;
    }
    aqr.a((aqe)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.apl
 * JD-Core Version:    0.7.0.1
 */