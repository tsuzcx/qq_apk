package com.tencent.mobileqq.activity.recent;

import anxk;
import com.tencent.mobileqq.app.QQAppInterface;

public final class RecentUtil$5
  implements Runnable
{
  public RecentUtil$5(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.val$app != null)
    {
      anxk.bG(this.val$app);
      anxk.d(this.val$app, true, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentUtil.5
 * JD-Core Version:    0.7.0.1
 */