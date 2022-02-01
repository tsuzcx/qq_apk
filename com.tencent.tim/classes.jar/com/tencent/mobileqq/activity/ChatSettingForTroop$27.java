package com.tencent.mobileqq.activity;

import aqgx;
import com.tencent.mobileqq.app.QQAppInterface;

class ChatSettingForTroop$27
  implements Runnable
{
  ChatSettingForTroop$27(ChatSettingForTroop paramChatSettingForTroop, String paramString) {}
  
  public void run()
  {
    aqgx.v(this.this$0.app.getCurrentAccountUin(), "troop_game_feed", this.Uf, 0);
    aqgx.v(this.this$0.app.getCurrentAccountUin(), "troop_game_last_visit_time", this.Uf, this.this$0.bFM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.27
 * JD-Core Version:    0.7.0.1
 */