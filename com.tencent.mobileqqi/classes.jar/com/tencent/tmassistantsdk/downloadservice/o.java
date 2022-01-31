package com.tencent.tmassistantsdk.downloadservice;

import com.tencent.tmassistantsdk.c.b;
import com.tencent.tmassistantsdk.c.e;

final class o
  implements Runnable
{
  o(TMAssistantDownloadSDKService paramTMAssistantDownloadSDKService) {}
  
  public final void run()
  {
    try
    {
      Thread.sleep(10000L);
      b.a().c();
      e.a();
      e.c();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.o
 * JD-Core Version:    0.7.0.1
 */