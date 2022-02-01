package com.tencent.thumbplayer.core.downloadproxy.utils;

import java.util.concurrent.LinkedBlockingQueue;

class TPCGIRequester$2
  implements Runnable
{
  TPCGIRequester$2(TPCGIRequester paramTPCGIRequester) {}
  
  public void run()
  {
    try
    {
      for (;;)
      {
        TPRequestItem localTPRequestItem = (TPRequestItem)TPCGIRequester.access$200(this.this$0).take();
        if (!TPCGIRequester.access$300(this.this$0, localTPRequestItem))
        {
          localTPRequestItem.updateFailedTime();
          TPCGIRequester.access$400(this.this$0, localTPRequestItem);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPCGIRequester", 0, "tpdlnative", "request queue take failed: " + localThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.utils.TPCGIRequester.2
 * JD-Core Version:    0.7.0.1
 */