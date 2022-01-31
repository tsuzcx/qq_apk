package com.tencent.mobileqq.msf.service;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.LinkedBlockingQueue;

public class g
  extends Thread
{
  private static String c = "MSF.S.RespHandler";
  public volatile boolean a = true;
  MsfCore b;
  
  public g(MsfCore paramMsfCore)
  {
    this.b = paramMsfCore;
  }
  
  public void run()
  {
    while (this.a)
    {
      String str;
      try
      {
        MsfMessagePair localMsfMessagePair = (MsfMessagePair)this.b.getMsfMessagePairs().take();
        if (localMsfMessagePair == null) {
          continue;
        }
        if (localMsfMessagePair.toServiceMsg == null) {
          break label111;
        }
        str = h.b(localMsfMessagePair.toServiceMsg);
        QLog.d(c, 2, str + " add resp to queue:" + localMsfMessagePair.toServiceMsg.getRequestSsoSeq() + " from:" + localMsfMessagePair.fromServiceMsg);
        d.a(str, localMsfMessagePair.toServiceMsg, localMsfMessagePair.fromServiceMsg);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      continue;
      label111:
      if (localInterruptedException.fromServiceMsg != null)
      {
        str = h.a(localInterruptedException.fromServiceMsg);
        QLog.d(c, 2, str + " add push to queue: from:" + localInterruptedException.fromServiceMsg);
        d.a(str, localInterruptedException.toServiceMsg, localInterruptedException.fromServiceMsg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.g
 * JD-Core Version:    0.7.0.1
 */