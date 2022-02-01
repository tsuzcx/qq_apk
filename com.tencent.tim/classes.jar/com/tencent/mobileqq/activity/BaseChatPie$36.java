package com.tencent.mobileqq.activity;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

class BaseChatPie$36
  implements Runnable
{
  BaseChatPie$36(BaseChatPie paramBaseChatPie, long paramLong1, int paramInt1, long paramLong2, int paramInt2, Runnable paramRunnable) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.this$0.app.b().b(this.this$0.sessionInfo.aTl, this.this$0.sessionInfo.cZ, this.Fw);
    this.this$0.a().runOnUiThread(new BaseChatPie.36.1(this, localMessageRecord));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.36
 * JD-Core Version:    0.7.0.1
 */