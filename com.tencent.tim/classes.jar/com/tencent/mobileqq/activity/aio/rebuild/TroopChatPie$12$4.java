package com.tencent.mobileqq.activity.aio.rebuild;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import yeh;

public class TroopChatPie$12$4
  implements Runnable
{
  public TroopChatPie$12$4(yeh paramyeh, long paramLong) {}
  
  public void run()
  {
    if ((this.a.this$0.mActivity != null) && (this.a.this$0.mActivity.isResume())) {
      ThreadManager.getSubThreadHandler().postDelayed(TroopChatPie.a(this.a.this$0), this.val$delay);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.12.4
 * JD-Core Version:    0.7.0.1
 */