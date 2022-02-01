package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import xys;

public class FriendChatPie$3
  implements Runnable
{
  public FriendChatPie$3(xys paramxys) {}
  
  public void run()
  {
    AVNotifyCenter localAVNotifyCenter = this.this$0.app.a();
    if (this.this$0.sessionInfo == null) {}
    for (;;)
    {
      return;
      if ((this.this$0.sessionInfo.cZ == 0) && (this.this$0.sessionInfo.aTl != null)) {
        try
        {
          long l = Long.valueOf(this.this$0.sessionInfo.aTl).longValue();
          if (localAVNotifyCenter.as(l))
          {
            this.this$0.a(this.this$0.sessionInfo.cZ, this.this$0.sessionInfo.aTl, this.this$0.sessionInfo.aTn, this.this$0.sessionInfo.phoneNum, localAVNotifyCenter.y(Long.valueOf(this.this$0.sessionInfo.aTl).longValue()));
            localAVNotifyCenter.e(Long.valueOf(this.this$0.sessionInfo.aTl).longValue(), false, -1);
            return;
          }
        }
        catch (NumberFormatException localNumberFormatException) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.3
 * JD-Core Version:    0.7.0.1
 */