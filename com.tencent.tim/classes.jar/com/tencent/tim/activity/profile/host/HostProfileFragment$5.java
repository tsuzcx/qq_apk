package com.tencent.tim.activity.profile.host;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.widget.QQToast;

class HostProfileFragment$5
  implements Runnable
{
  HostProfileFragment$5(HostProfileFragment paramHostProfileFragment) {}
  
  public void run()
  {
    if ((this.this$0.bHl == 1) || (this.this$0.bHl == 2))
    {
      HostProfileFragment.a(this.this$0);
      FragmentActivity localFragmentActivity = this.this$0.getActivity();
      if (localFragmentActivity != null) {
        QQToast.a(localFragmentActivity, 2131691963, 0).show(localFragmentActivity.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.activity.profile.host.HostProfileFragment.5
 * JD-Core Version:    0.7.0.1
 */