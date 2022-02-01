package com.tencent.mobileqq.msf.core.quicksend;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.concurrent.ConcurrentHashMap;

class c
  extends Handler
{
  c(b paramb) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    int i = paramMessage.arg1;
    b.a(this.a, (ToServiceMsg)b.a(this.a).get(Integer.valueOf(i)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.quicksend.c
 * JD-Core Version:    0.7.0.1
 */