package com.tencent.tim.activity.profile;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class BaseProfileFragment$6
  implements Runnable
{
  BaseProfileFragment$6(BaseProfileFragment paramBaseProfileFragment, String paramString) {}
  
  public void run()
  {
    FragmentActivity localFragmentActivity = this.this$0.getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    localFragmentActivity.runOnUiThread(new BaseProfileFragment.6.1(this, this.this$0.app.a(this.val$uin, (byte)1, true)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.activity.profile.BaseProfileFragment.6
 * JD-Core Version:    0.7.0.1
 */