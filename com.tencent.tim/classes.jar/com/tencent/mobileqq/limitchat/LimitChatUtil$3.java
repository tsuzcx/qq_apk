package com.tencent.mobileqq.limitchat;

import afsg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public final class LimitChatUtil$3
  implements Runnable
{
  public LimitChatUtil$3(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    afsg localafsg = (afsg)this.n.getBusinessHandler(127);
    if (localafsg != null) {
      localafsg.al(this.g);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.limitchat.LimitChatUtil.3
 * JD-Core Version:    0.7.0.1
 */