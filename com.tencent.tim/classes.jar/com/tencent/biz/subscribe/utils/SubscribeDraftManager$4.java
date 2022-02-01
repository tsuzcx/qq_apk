package com.tencent.biz.subscribe.utils;

import aqhq;
import com.tencent.util.Pair;
import shg;
import shg.a;

public class SubscribeDraftManager$4
  implements Runnable
{
  public SubscribeDraftManager$4(shg paramshg, String paramString1, String paramString2, shg.a parama) {}
  
  public void run()
  {
    Pair localPair = shg.a(this.this$0, this.val$uin, this.aEf);
    if (localPair != null)
    {
      aqhq.deleteFile((String)localPair.first);
      aqhq.deleteFile((String)localPair.second);
      if (this.a != null) {
        this.a.b(2, true, this.aEf, new Object[0]);
      }
    }
    while (this.a == null) {
      return;
    }
    this.a.b(2, false, this.aEf, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.4
 * JD-Core Version:    0.7.0.1
 */