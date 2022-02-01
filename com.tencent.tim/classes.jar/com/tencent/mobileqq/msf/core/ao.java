package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.Message;

class ao
  extends Handler
{
  ao(an paraman) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = (String)paramMessage.obj;
    this.a.s.refreshWebviewTickets(paramMessage, "SidExpiredPush");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ao
 * JD-Core Version:    0.7.0.1
 */