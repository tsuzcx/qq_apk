package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import arfy;
import com.tencent.mobileqq.richmedia.capture.view.IdentifierCameraCaptureView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout;

class QQIdentiferActivity$3
  implements Runnable
{
  QQIdentiferActivity$3(QQIdentiferActivity paramQQIdentiferActivity, View paramView) {}
  
  public void run()
  {
    int i = ImmersiveUtils.getStatusBarHeight(this.this$0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.tR.getLayoutParams();
    localLayoutParams.topMargin = (i + localLayoutParams.topMargin);
    this.tR.setLayoutParams(localLayoutParams);
    i = QQIdentiferActivity.a(this.this$0).getHeight();
    int j = QQIdentiferActivity.a(this.this$0).getWidth();
    int k = this.this$0.a.getHeight();
    localLayoutParams = (RelativeLayout.LayoutParams)QQIdentiferActivity.a(this.this$0).getLayoutParams();
    localLayoutParams.topMargin = (k / 2 - j - (i - j) / 2);
    QQIdentiferActivity.a(this.this$0).setLayoutParams(localLayoutParams);
    QQIdentiferActivity.a(this.this$0).setRadius(Math.min(i, j) / 2.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferActivity.3
 * JD-Core Version:    0.7.0.1
 */