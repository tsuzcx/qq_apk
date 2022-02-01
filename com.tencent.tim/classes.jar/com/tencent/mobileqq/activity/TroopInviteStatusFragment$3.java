package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import wja;

class TroopInviteStatusFragment$3
  implements Runnable
{
  TroopInviteStatusFragment$3(TroopInviteStatusFragment paramTroopInviteStatusFragment) {}
  
  public void run()
  {
    if ((this.this$0.mActivity != null) && (!this.this$0.mActivity.isFinishing()))
    {
      Intent localIntent = wja.a(new Intent(this.this$0.mActivity, SplashActivity.class), null);
      localIntent.putExtra("uin", this.this$0.troopCode);
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("uinname", this.this$0.troopName);
      localIntent.putExtra("troop_uin", this.this$0.troopCode);
      this.this$0.startActivity(localIntent);
      this.this$0.mActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInviteStatusFragment.3
 * JD-Core Version:    0.7.0.1
 */