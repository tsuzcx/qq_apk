package com.tencent.mobileqq.msf.sdk;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.concurrent.ConcurrentLinkedQueue;

class u
  extends Thread
{
  u(s params) {}
  
  public void run()
  {
    while (!s.f.isEmpty())
    {
      ToServiceMsg localToServiceMsg = (ToServiceMsg)s.f.poll();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.u
 * JD-Core Version:    0.7.0.1
 */