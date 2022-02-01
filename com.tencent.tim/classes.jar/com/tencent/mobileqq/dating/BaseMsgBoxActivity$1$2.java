package com.tencent.mobileqq.dating;

import aajg;
import afcb;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import java.util.Iterator;
import java.util.List;

public class BaseMsgBoxActivity$1$2
  implements Runnable
{
  public BaseMsgBoxActivity$1$2(afcb paramafcb, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void run()
  {
    if ((this.val$isSuccess) && (this.a.this$0.f != null) && (this.a.this$0.yT != null))
    {
      Iterator localIterator = this.a.this$0.yT.iterator();
      while (localIterator.hasNext())
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
        if (localRecentBaseData.qx().equals(this.val$uin))
        {
          localRecentBaseData.mTitleName = this.val$nick;
          this.a.this$0.f.cW(this.val$uin, this.a.this$0.cMA);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.BaseMsgBoxActivity.1.2
 * JD-Core Version:    0.7.0.1
 */