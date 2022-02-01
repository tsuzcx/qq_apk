package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import xys;

public class FriendChatPie$12
  implements Runnable
{
  public FriendChatPie$12(xys paramxys, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (this.a.sendFailCode == 41)
    {
      QQToast.a(this.this$0.app.getApp(), 2131693097, 0).show();
      return;
    }
    QQToast.a(this.this$0.app.getApp(), 2131720463, 0).show();
    VasWebviewUtil.reportCommercialDrainage(this.this$0.app.getCurrentUin(), "Stick", "Send", "1", 0, 6, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.12
 * JD-Core Version:    0.7.0.1
 */