package com.tencent.thumbplayer.core.downloadproxy.utils;

import java.util.TimerTask;
import java.util.concurrent.LinkedBlockingQueue;

class TPCGIRequester$1
  extends TimerTask
{
  TPCGIRequester$1(TPCGIRequester paramTPCGIRequester) {}
  
  public void run()
  {
    while ((TPCGIRequester.access$000(this.this$0).peek() != null) && (System.currentTimeMillis() - ((TPRequestItem)TPCGIRequester.access$000(this.this$0).peek()).getRequestFailedTime() > 3000L)) {
      TPCGIRequester.access$100(this.this$0, (TPRequestItem)TPCGIRequester.access$000(this.this$0).poll());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.utils.TPCGIRequester.1
 * JD-Core Version:    0.7.0.1
 */