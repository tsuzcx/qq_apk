package com.tencent.mobileqq.activity;

import android.os.Handler;
import aqgx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;

class ChatSettingForTroop$41
  implements Runnable
{
  ChatSettingForTroop$41(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    try
    {
      this.this$0.a.nUnreadMsgNum = aqgx.m(this.this$0.app.getCurrentAccountUin(), "troop_photo_message", this.this$0.a.troopUin);
      this.this$0.mUIHandler.sendEmptyMessage(4);
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "从群空间返回，更新群空间未读计数， troopuin = " + this.this$0.a.troopUin + ", unreadmsgnum = " + this.this$0.a.nUnreadMsgNum + ", newphotonum = " + this.this$0.a.nNewPhotoNum);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.41
 * JD-Core Version:    0.7.0.1
 */