package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.os.Message;
import aqgx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

class ChatSettingForTroop$22
  implements Runnable
{
  ChatSettingForTroop$22(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    int i = aqgx.m(this.this$0.app.getCurrentAccountUin(), "troop_game_feed", this.this$0.a.troopUin);
    Message localMessage = this.this$0.mUIHandler.obtainMessage(19);
    localMessage.arg1 = i;
    localMessage.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.22
 * JD-Core Version:    0.7.0.1
 */