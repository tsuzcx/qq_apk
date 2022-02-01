package com.tencent.mobileqq.activity;

import aqha;
import aqju;
import uqs;

public class ChatSettingForTroop$51
  implements Runnable
{
  ChatSettingForTroop$51(ChatSettingForTroop paramChatSettingForTroop, String paramString) {}
  
  public void run()
  {
    if (this.this$0.x != null) {
      if (!this.this$0.x.isShowing()) {
        this.this$0.x.show();
      }
    }
    do
    {
      return;
      this.this$0.x = aqha.a(this.this$0, 230);
      this.this$0.x.setMessage(this.val$message);
      uqs localuqs = new uqs(this);
      this.this$0.x.setPositiveButton(2131691970, localuqs);
      this.this$0.x.setNegativeButton(2131721058, localuqs);
    } while (this.this$0.x.isShowing());
    this.this$0.x.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.51
 * JD-Core Version:    0.7.0.1
 */