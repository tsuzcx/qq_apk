package com.tencent.mobileqq.msf.sdk.utils;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.d.c;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.concurrent.LinkedBlockingQueue;

public class MonitorSocketStat
  extends Thread
{
  public static LinkedBlockingQueue dataFlow = new LinkedBlockingQueue();
  private static MsfServiceSdk msfSdk;
  private static String processName;
  private boolean running = true;
  
  public void run()
  {
    try
    {
      Thread.sleep(30000L);
      if (processName.endsWith("MSF")) {
        while (this.running) {
          try
          {
            a locala = (a)dataFlow.take();
            locala.a = processName;
            if (locala != null) {
              MsfService.getCore().getNetFlowStore().a(locala);
            }
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
          }
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
      while (this.running)
      {
        try
        {
          Object localObject = (a)dataFlow.take();
          if (localObject == null) {
            continue;
          }
          if (msfSdk == null) {
            msfSdk = MsfServiceSdk.get();
          }
          if (msfSdk == null) {
            break label143;
          }
          localObject = msfSdk.getDataFlowMsg(processName, (a)localObject);
          msfSdk.sendMsg((ToServiceMsg)localObject);
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
        continue;
        label143:
        dataFlow.put(localException2);
      }
    }
  }
  
  public void setProcessName(String paramString)
  {
    processName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.MonitorSocketStat
 * JD-Core Version:    0.7.0.1
 */