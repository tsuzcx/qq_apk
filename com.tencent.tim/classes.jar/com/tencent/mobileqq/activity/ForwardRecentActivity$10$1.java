package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import anot;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import uxh;

public class ForwardRecentActivity$10$1
  implements Runnable
{
  public ForwardRecentActivity$10$1(uxh paramuxh, Intent paramIntent) {}
  
  public void run()
  {
    ForwardRecentActivity.a(this.a.this$0, this.val$intent);
    this.val$intent.setClass(this.a.this$0, PhoneFrameActivity.class);
    this.val$intent.putExtra("key_req_type", 2);
    Intent localIntent = this.a.this$0.getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("forward_type"))) {
      this.val$intent.putExtra("forward_type", localIntent.getIntExtra("forward_type", 2147483647));
    }
    this.a.this$0.startActivityForResult(this.val$intent, 20000);
    anot.a(this.a.this$0.app, "CliOper", "", "", "0X8007011", "0X8007011", 0, 0, "", "", "", "");
    this.a.this$0.getSharedPreferences(this.a.this$0.app.getCurrentAccountUin(), 0).edit().putBoolean("forward_share_card", false).commit();
    ForwardRecentActivity.a(this.a.this$0).findViewById(2131369485).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.10.1
 * JD-Core Version:    0.7.0.1
 */