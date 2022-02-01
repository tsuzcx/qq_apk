package com.tencent.mobileqq.activity.aio.rebuild;

import acms;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import ybt;

public class NearbyChatPie$14
  implements Runnable
{
  public NearbyChatPie$14(ybt paramybt) {}
  
  public void run()
  {
    if (!ybt.a(this.this$0)) {
      ((acms)this.this$0.app.getBusinessHandler(20)).getFollowStatus(this.this$0.sessionInfo.aTl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.14
 * JD-Core Version:    0.7.0.1
 */