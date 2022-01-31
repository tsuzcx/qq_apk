package com.tencent.tmassistantsdk.downloadservice;

import com.tencent.tmassistantsdk.c.d;

final class o
  implements Runnable
{
  o(TMAssistantDownloadSDKService paramTMAssistantDownloadSDKService) {}
  
  public final void run()
  {
    try
    {
      Thread.sleep(10000L);
      d.a();
      d.c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.o
 * JD-Core Version:    0.7.0.1
 */