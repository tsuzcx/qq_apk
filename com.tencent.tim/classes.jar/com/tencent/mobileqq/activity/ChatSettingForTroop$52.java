package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.res.Resources;
import aqha;
import aqju;
import uqt;

public class ChatSettingForTroop$52
  implements Runnable
{
  ChatSettingForTroop$52(ChatSettingForTroop paramChatSettingForTroop) {}
  
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
      this.this$0.x.setMessage(this.this$0.getActivity().getResources().getString(2131721369));
      uqt localuqt = new uqt(this);
      this.this$0.x.setPositiveButton(2131691970, localuqt);
    } while (this.this$0.x.isShowing());
    this.this$0.x.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.52
 * JD-Core Version:    0.7.0.1
 */