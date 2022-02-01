package com.tencent.mobileqq.nearby.interestTag;

import ajut;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.widget.MonitorSizeChangeHSV;

public class ChooseInterestTagActivity$9$1
  implements Runnable
{
  public ChooseInterestTagActivity$9$1(ajut paramajut, int paramInt) {}
  
  public void run()
  {
    if (this.val$w >= 0)
    {
      ((RelativeLayout.LayoutParams)ChooseInterestTagActivity.a(this.a.this$0).getLayoutParams()).leftMargin = ((int)(this.val$w + ChooseInterestTagActivity.a(this.a.this$0) * 7.0F));
      ChooseInterestTagActivity.a(this.a.this$0).requestLayout();
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if (ChooseInterestTagActivity.a(this.a.this$0).getChildCount() <= 0)
    {
      ChooseInterestTagActivity.a(this.a.this$0).setVisibility(8);
      if (ChooseInterestTagActivity.b(this.a.this$0))
      {
        localLayoutParams = (RelativeLayout.LayoutParams)ChooseInterestTagActivity.a(this.a.this$0).getLayoutParams();
        localLayoutParams.height = 1;
        if (!ChooseInterestTagActivity.a(this.a.this$0)) {
          break label183;
        }
      }
    }
    label183:
    for (int i = (int)(ChooseInterestTagActivity.a(this.a.this$0) * 7.0F + 0.5D);; i = 0)
    {
      localLayoutParams.topMargin = i;
      localLayoutParams.bottomMargin = i;
      ChooseInterestTagActivity.a(this.a.this$0).setLayoutParams(localLayoutParams);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity.9.1
 * JD-Core Version:    0.7.0.1
 */