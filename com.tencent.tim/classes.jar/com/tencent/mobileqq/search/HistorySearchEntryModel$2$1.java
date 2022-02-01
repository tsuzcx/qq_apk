package com.tencent.mobileqq.search;

import amjp;
import amjr;
import android.os.Message;
import aurf;
import com.tencent.mobileqq.data.SearchHistory;

public class HistorySearchEntryModel$2$1
  implements Runnable
{
  public HistorySearchEntryModel$2$1(amjr paramamjr, SearchHistory paramSearchHistory, long paramLong) {}
  
  public void run()
  {
    if (amjp.a(this.a.this$0, this.b))
    {
      Message localMessage = this.a.this$0.b.obtainMessage();
      localMessage.what = 3;
      localMessage.obj = new Long(this.aiM);
      this.a.this$0.b.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.HistorySearchEntryModel.2.1
 * JD-Core Version:    0.7.0.1
 */