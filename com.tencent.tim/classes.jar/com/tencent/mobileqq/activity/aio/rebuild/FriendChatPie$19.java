package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import xys;
import yrv;

public class FriendChatPie$19
  implements Runnable
{
  public FriendChatPie$19(xys paramxys) {}
  
  public void run()
  {
    if (yrv.t(this.this$0.app, this.this$0.sessionInfo.aTl))
    {
      xys.b(this.this$0, true);
      yrv.z(this.this$0.app, this.this$0.sessionInfo.aTl);
      this.this$0.app.reportClickEvent("CliOper", "", "", "0X8008072", "0X8008072", 0, 0, "", "", "", "");
      return;
    }
    xys.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.19
 * JD-Core Version:    0.7.0.1
 */