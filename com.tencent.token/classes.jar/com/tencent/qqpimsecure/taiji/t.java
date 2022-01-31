package com.tencent.qqpimsecure.taiji;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import taiji.cl;

class t
  extends Handler
{
  t(o paramo, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    cl.b("Taiji", "handleMessage :msg:" + paramMessage.what);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      cl.b("Taiji", "MSG_UPLOAD_PROFILE:" + paramMessage.arg1);
      o.a(this.a, paramMessage);
      return;
    case 1: 
      cl.b("Taiji", "MSG_PULL_DIRECTLY");
      o.b(this.a, paramMessage);
      return;
    case 2: 
      o.c(this.a, paramMessage);
      return;
    }
    j.a().a(o.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.taiji.t
 * JD-Core Version:    0.7.0.1
 */