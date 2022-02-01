package com.tencent.mobileqq.activity.pendant;

import altq;
import com.tencent.mobileqq.app.QQAppInterface;

class AvatarPendantActivity$5
  implements Runnable
{
  AvatarPendantActivity$5(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void run()
  {
    altq localaltq = (altq)this.this$0.app.getManager(36);
    this.this$0.r = localaltq.getAppInfoByPath("100100.100125.100127");
    this.this$0.runOnUiThread(new AvatarPendantActivity.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.5
 * JD-Core Version:    0.7.0.1
 */