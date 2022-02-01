package com.tencent.biz.qrcode.activity;

import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.theme.ThemeUtil;

class QRDisplayActivity$5
  implements Runnable
{
  QRDisplayActivity$5(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void run()
  {
    int i = this.this$0.mScrollView.getHeight();
    int j = this.this$0.pm.getHeight();
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    if (j < i)
    {
      localView = this.this$0.findViewById(2131375324);
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      if (this.this$0.type != 2) {
        break label96;
      }
      localLayoutParams.topMargin = 0;
      localLayoutParams.bottomMargin = 0;
    }
    for (;;)
    {
      if ("1103".equals(ThemeUtil.curThemeId)) {
        localView.setBackgroundDrawable(null);
      }
      localView.setLayoutParams(localLayoutParams);
      return;
      label96:
      if (this.this$0.type == 5)
      {
        int k = localLayoutParams.topMargin;
        localLayoutParams.topMargin = ((i - j) / 2 + k);
      }
      else
      {
        localLayoutParams.topMargin = 50;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.5
 * JD-Core Version:    0.7.0.1
 */