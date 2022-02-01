package com.tencent.mobileqq.activity;

import aqha;
import aqju;
import uet;

public class AddFriendVerifyActivity$30
  implements Runnable
{
  AddFriendVerifyActivity$30(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
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
      this.this$0.x.setMessage(2131721367);
      new uet(this);
    } while (this.this$0.x.isShowing());
    this.this$0.x.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.30
 * JD-Core Version:    0.7.0.1
 */