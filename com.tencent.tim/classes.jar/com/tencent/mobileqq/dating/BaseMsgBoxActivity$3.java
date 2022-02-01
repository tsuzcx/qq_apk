package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;

class BaseMsgBoxActivity$3
  implements Runnable
{
  BaseMsgBoxActivity$3(BaseMsgBoxActivity paramBaseMsgBoxActivity, String paramString, int paramInt) {}
  
  public void run()
  {
    ((MessageHandler)this.this$0.app.getBusinessHandler(0)).k(this.val$uin, this.val$type, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.BaseMsgBoxActivity.3
 * JD-Core Version:    0.7.0.1
 */