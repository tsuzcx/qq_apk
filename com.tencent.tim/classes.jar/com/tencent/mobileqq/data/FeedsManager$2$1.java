package com.tencent.mobileqq.data;

import aezb;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;
import vqo;

public class FeedsManager$2$1
  implements Runnable
{
  public FeedsManager$2$1(aezb paramaezb) {}
  
  public void run()
  {
    if (!this.a.this$0.feedInfoCache.isEmpty()) {
      FeedsManager.access$200(this.a.this$0).notifyObservers(vqo.class, 10000, true, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.FeedsManager.2.1
 * JD-Core Version:    0.7.0.1
 */