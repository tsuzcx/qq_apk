package com.tencent.mobileqq.msf.core.d;

import android.content.IntentFilter;
import com.tencent.qphone.base.util.BaseApplication;

class b
  extends Thread
{
  b(a parama, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    a.a(this.a);
    BaseApplication.getContext().registerReceiver(this.a, new IntentFilter("android.intent.action.SCREEN_OFF"));
    BaseApplication.getContext().registerReceiver(this.a, new IntentFilter("android.intent.action.SCREEN_ON"));
    if (!a.b(this.a)) {
      a.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.d.b
 * JD-Core Version:    0.7.0.1
 */