package com.tencent.qqmail.account.fragment;

import android.content.Intent;
import com.tencent.qqmail.activity.setting.SettingGestureActivity;
import moai.fragment.app.FragmentActivity;

class LoginTaskFragment$6
  implements Runnable
{
  LoginTaskFragment$6(LoginTaskFragment paramLoginTaskFragment) {}
  
  public void run()
  {
    Intent localIntent = SettingGestureActivity.createIntent(0);
    this.this$0.startActivity(localIntent);
    this.this$0.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginTaskFragment.6
 * JD-Core Version:    0.7.0.1
 */