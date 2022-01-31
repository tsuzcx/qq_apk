package com.tencent.mobileqq.msf.core.net.a;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class f
  extends Handler
{
  f(e parame) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = (String)paramMessage.obj;
    QLog.d("WifiDetector", 1, "WIFI detect delayed try!");
    e.a(this.a, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.a.f
 * JD-Core Version:    0.7.0.1
 */