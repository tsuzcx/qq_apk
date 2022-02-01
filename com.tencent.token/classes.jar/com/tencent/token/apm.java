package com.tencent.token;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class apm
  extends Handler
{
  apm(aqs paramaqs, Looper paramLooper)
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
      paramMessage = (aqg)paramMessage.obj;
      aqs.a(this.a, paramMessage);
      return;
    }
    aqs.a((aqf)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.apm
 * JD-Core Version:    0.7.0.1
 */