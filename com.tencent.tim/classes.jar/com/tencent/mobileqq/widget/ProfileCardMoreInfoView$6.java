package com.tencent.mobileqq.widget;

import acfp;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageRecord;
import slz;

class ProfileCardMoreInfoView$6
  implements Runnable
{
  ProfileCardMoreInfoView$6(ProfileCardMoreInfoView paramProfileCardMoreInfoView) {}
  
  public void run()
  {
    Object localObject = this.this$0.g();
    if (localObject != null) {}
    for (localObject = acfp.m(2131709917) + slz.a(((MessageRecord)localObject).time, true, false, true).toString();; localObject = null)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.this$0.a.bVm = ((String)localObject);
      }
      this.this$0.mActivity.runOnUiThread(new ProfileCardMoreInfoView.6.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardMoreInfoView.6
 * JD-Core Version:    0.7.0.1
 */