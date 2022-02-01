package com.tencent.mobileqq.widget;

import acfp;
import aldf;
import anot;
import aqgq;
import aqoa;
import com.tencent.mobileqq.app.BaseActivity;

class ProfileCardMoreInfoView$13
  implements Runnable
{
  ProfileCardMoreInfoView$13(ProfileCardMoreInfoView paramProfileCardMoreInfoView) {}
  
  public void run()
  {
    int i;
    if ((this.this$0.mActivity != null) && (!this.this$0.mActivity.isFinishing()))
    {
      i = aldf.a().a(ProfileCardMoreInfoView.a(this.this$0), ProfileCardMoreInfoView.b(this.this$0), ProfileCardMoreInfoView.c(this.this$0), ProfileCardMoreInfoView.a(this.this$0), ProfileCardMoreInfoView.a(this.this$0), ProfileCardMoreInfoView.b(this.this$0));
      if (i != -2147483648) {}
    }
    else
    {
      return;
    }
    aqoa localaqoa = new aqoa();
    localaqoa.Z(0, acfp.m(2131709953), 0);
    aqgq.a(ProfileCardMoreInfoView.a(this.this$0), 0 - i, 0, localaqoa);
    aldf.a().dD(this.this$0.app);
    anot.a(null, "dc00898", "", "", "0X800A4D1", "0X800A4D1", 0, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardMoreInfoView.13
 * JD-Core Version:    0.7.0.1
 */