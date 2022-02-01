package com.tencent.mobileqq.search;

import amjp;
import android.os.Message;
import aurf;

public class HistorySearchEntryModel$4
  implements Runnable
{
  public HistorySearchEntryModel$4(amjp paramamjp) {}
  
  public void run()
  {
    this.this$0.FD = amjp.a(this.this$0);
    Message localMessage = this.this$0.b.obtainMessage();
    localMessage.what = 1;
    this.this$0.b.removeMessages(1);
    this.this$0.b.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.HistorySearchEntryModel.4
 * JD-Core Version:    0.7.0.1
 */