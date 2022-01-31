package com.tencent.mobileqq.msf.sdk;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.concurrent.ConcurrentLinkedQueue;

class v
  extends Thread
{
  v(t paramt) {}
  
  public void run()
  {
    while (!t.f.isEmpty())
    {
      ToServiceMsg localToServiceMsg = (ToServiceMsg)t.f.poll();
      if (localToServiceMsg != null) {
        try
        {
          this.a.a(localToServiceMsg);
        }
        catch (Exception localException)
        {
          FromServiceMsg localFromServiceMsg = this.a.a(localToServiceMsg, localToServiceMsg.getServiceName() + "sendMsgToServiceFailed，" + localException.toString());
          this.a.c(localToServiceMsg, localFromServiceMsg);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.v
 * JD-Core Version:    0.7.0.1
 */