package com.tencent.mobileqq.activity;

import aogk;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;
import wkj;

class BaseChatPie$25$1
  implements Runnable
{
  BaseChatPie$25$1(BaseChatPie.25 param25) {}
  
  public void run()
  {
    if (aogk.a().azB()) {}
    do
    {
      return;
      this.a.this$0.sessionInfo.a.bdG = false;
    } while (!wkj.a(this.a.this$0.mContext, this.a.this$0.app.getCurrentAccountUin(), this.a.this$0.sessionInfo.aTl, true, 7, this.a.this$0.sessionInfo.a));
    this.a.this$0.uiHandler.sendMessage(this.a.this$0.uiHandler.obtainMessage(60, this.a.this$0.sessionInfo.a.img));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.25.1
 * JD-Core Version:    0.7.0.1
 */