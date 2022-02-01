package com.tencent.mobileqq.activity;

import android.os.Handler;
import aqgx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;

class ChatSettingForTroop$12
  implements Runnable
{
  ChatSettingForTroop$12(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "mInitRunnable and init cardInfo");
      }
      this.this$0.bLF();
      this.this$0.a.nUnreadMsgNum = aqgx.m(this.this$0.app.getCurrentAccountUin(), "troop_photo_message", this.this$0.a.troopUin);
      this.this$0.a.nNewPhotoNum = aqgx.m(this.this$0.app.getCurrentAccountUin(), "troop_photo_new", this.this$0.a.troopUin);
      this.this$0.mUIHandler.sendEmptyMessage(4);
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "初始化，群空间未读计数， troopuin = " + this.this$0.a.troopUin + ", unreadmsgnum = " + this.this$0.a.nUnreadMsgNum + ", newphotonum = " + this.this$0.a.nNewPhotoNum);
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "init(),getTroopMemberCard,getMutiTroopInfo,refreshTroopFace");
      }
      this.this$0.a.nNewFileMsgNum = aqgx.m(this.this$0.app.getCurrentAccountUin(), "troop_file_new", this.this$0.a.troopUin);
      this.this$0.a.nUnreadFileMsgnum = 0;
      this.this$0.mUIHandler.sendEmptyMessage(8);
      this.this$0.a.mNewTroopNotificationNum = aqgx.m(this.this$0.app.getCurrentAccountUin(), "troop_notification_new", this.this$0.a.troopUin);
      this.this$0.mUIHandler.sendEmptyMessage(9);
      if (this.this$0.a.isGameTroop()) {
        this.this$0.bFM = aqgx.m(this.this$0.app.getCurrentAccountUin(), "troop_game_last_visit_time", this.this$0.a.troopUin);
      }
      this.this$0.bKU();
      this.this$0.bLv();
      ChatSettingForTroop.a(this.this$0, 0, false);
      this.this$0.mUIHandler.sendEmptyMessage(17);
      this.this$0.app.EG(this.this$0.a.troopUin);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.e("Q.chatopttroop", 4, localNumberFormatException.toString());
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.e("Q.chatopttroop", 4, localIllegalArgumentException.toString());
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.e("Q.chatopttroop", 4, localException.toString());
      return;
    }
    catch (Error localError)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.e("Q.chatopttroop", 4, localError.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.12
 * JD-Core Version:    0.7.0.1
 */