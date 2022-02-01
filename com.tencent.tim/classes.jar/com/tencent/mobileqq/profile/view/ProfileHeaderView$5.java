package com.tencent.mobileqq.profile.view;

import acfp;
import aldf;
import android.widget.TextView;
import anot;
import aqgq;
import aqoa;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.List;

class ProfileHeaderView$5
  implements Runnable
{
  ProfileHeaderView$5(ProfileHeaderView paramProfileHeaderView, RichStatus paramRichStatus, TextView paramTextView) {}
  
  public void run()
  {
    if ((this.this$0.mActivity != null) && (!this.this$0.mActivity.isFinishing()))
    {
      if ((this.f.plainText == null) || (this.f.plainText.size() <= 0)) {
        break label175;
      }
      localObject = (String)this.f.plainText.get(0);
      this.f.sortTopicPos();
      if ((this.f.topicsPos == null) || (this.f.topicsPos.size() <= 0)) {
        break label180;
      }
    }
    label175:
    label180:
    for (int i = ((Integer)((Pair)this.f.topicsPos.get(0)).second).intValue();; i = 0)
    {
      i = aldf.a().a(this.Xn, (String)((Pair)this.f.topics.get(0)).second, this.f.actionText, this.this$0.bsd, (String)localObject, i);
      if (i != -2147483648) {
        break label185;
      }
      return;
      localObject = null;
      break;
    }
    label185:
    Object localObject = new aqoa();
    ((aqoa)localObject).Z(0, acfp.m(2131709960), 0);
    aqgq.a(this.Xn, 0 - i, 0, (aqoa)localObject);
    aldf.a().dD(this.this$0.app);
    anot.a(null, "dc00898", "", "", "0X800A4D1", "0X800A4D1", 0, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileHeaderView.5
 * JD-Core Version:    0.7.0.1
 */