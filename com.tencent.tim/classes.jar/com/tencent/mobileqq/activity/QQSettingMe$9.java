package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class QQSettingMe$9
  implements Runnable
{
  QQSettingMe$9(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    int i = (int)this.this$0.c.getResources().getDimension(2131297155);
    Object localObject = new int[2];
    this.this$0.qT.getLocationOnScreen((int[])localObject);
    int j = this.this$0.ui.getWidth();
    int k = this.this$0.qT.getWidth();
    if ((j != 0) && (k != 0)) {
      i -= (j - k) / 2;
    }
    for (;;)
    {
      localObject = this.this$0.uj.getLayoutParams();
      if ((i > 0) && ((localObject instanceof RelativeLayout.LayoutParams)))
      {
        ((RelativeLayout.LayoutParams)localObject).leftMargin = i;
        this.this$0.uj.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "setBottomBtnMarginLeft, diffMargin = " + i);
      }
      return;
      i = (int)this.this$0.c.getResources().getDimension(2131297160);
      QLog.e("QQSettingRedesign", 1, "setBottomBtnMarginLeft, but getWidth return 0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.9
 * JD-Core Version:    0.7.0.1
 */