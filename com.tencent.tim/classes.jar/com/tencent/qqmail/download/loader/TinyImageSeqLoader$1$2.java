package com.tencent.qqmail.download.loader;

import com.tencent.qqmail.protocol.DataCollector;

class TinyImageSeqLoader$1$2
  implements Runnable
{
  TinyImageSeqLoader$1$2(TinyImageSeqLoader.1 param1, String paramString) {}
  
  public void run()
  {
    this.this$1.this$0.handleDownError(this.val$url, this.val$url, -2);
    DataCollector.logDetailEvent("DetailEvent_App_Download", this.this$1.val$accountId, 1L, "attach saveas err:" + this.val$url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.loader.TinyImageSeqLoader.1.2
 * JD-Core Version:    0.7.0.1
 */