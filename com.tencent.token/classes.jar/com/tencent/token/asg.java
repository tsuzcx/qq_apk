package com.tencent.token;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class asg
  extends Handler
{
  asg(atm paramatm, Looper paramLooper)
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
      paramMessage = (ata)paramMessage.obj;
      atm.a(this.a, paramMessage);
      return;
    }
    atm.a((asz)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.asg
 * JD-Core Version:    0.7.0.1
 */