package com.tencent.mobileqq.msf.service;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.LinkedBlockingQueue;

public class f
  extends Thread
{
  private static String c = "MSF.S.RespHandler";
  public volatile boolean a = true;
  MsfCore b;
  
  public f(MsfCore paramMsfCore)
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
        str = g.b(localMsfMessagePair.toServiceMsg);
        QLog.d(c, 2, str + " add resp to queue:" + localMsfMessagePair.toServiceMsg.getRequestSsoSeq() + " from:" + localMsfMessagePair.fromServiceMsg);
        c.a(str, localMsfMessagePair.toServiceMsg, localMsfMessagePair.fromServiceMsg);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      continue;
      label111:
      if (localInterruptedException.fromServiceMsg != null)
      {
        str = g.a(localInterruptedException.fromServiceMsg);
        QLog.d(c, 2, str + " add push to queue: from:" + localInterruptedException.fromServiceMsg);
        c.a(str, localInterruptedException.toServiceMsg, localInterruptedException.fromServiceMsg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.f
 * JD-Core Version:    0.7.0.1
 */