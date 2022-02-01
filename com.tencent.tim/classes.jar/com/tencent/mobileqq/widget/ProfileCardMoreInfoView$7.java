package com.tencent.mobileqq.widget;

import acfp;
import aldf;
import android.widget.TextView;
import anot;
import aqgq;
import aqoa;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.util.Pair;
import java.util.List;

class ProfileCardMoreInfoView$7
  implements Runnable
{
  ProfileCardMoreInfoView$7(ProfileCardMoreInfoView paramProfileCardMoreInfoView, TextView paramTextView, RichStatus paramRichStatus) {}
  
  public void run()
  {
    int i;
    if ((this.this$0.mActivity != null) && (!this.this$0.mActivity.isFinishing()))
    {
      i = aldf.a().a(this.acn, (String)((Pair)this.e.topics.get(0)).second, this.e.actionText, ProfileCardMoreInfoView.a(this.this$0), ProfileCardMoreInfoView.a(this.this$0), ProfileCardMoreInfoView.b(this.this$0));
      if (i != -2147483648) {}
    }
    else
    {
      return;
    }
    aqoa localaqoa = new aqoa();
    localaqoa.Z(0, acfp.m(2131709940), 0);
    aqgq.a(this.acn, 0 - i, 0, localaqoa);
    aldf.a().dD(this.this$0.app);
    anot.a(null, "dc00898", "", "", "0X800A4D1", "0X800A4D1", 0, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardMoreInfoView.7
 * JD-Core Version:    0.7.0.1
 */