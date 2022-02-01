package com.tencent.av.ui;

import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class AVActivity$3
  implements Runnable
{
  AVActivity$3(AVActivity paramAVActivity) {}
  
  public void run()
  {
    if (this.this$0.isDestroyed()) {}
    long l;
    View localView;
    RelativeLayout localRelativeLayout;
    do
    {
      return;
      l = AudioHelper.hG();
      localView = this.this$0.b(l);
      localRelativeLayout = (RelativeLayout)this.this$0.findViewById(2131374039);
    } while ((localView == null) || (localRelativeLayout.getVisibility() == 0));
    QLog.w(this.this$0.TAG, 1, "qav_UserGuide_for_more, 计划显示, seq[" + l + "]");
    localView.setAlpha(0.01F);
    localView.setVisibility(0);
    if (this.this$0.mControlUI != null) {
      this.this$0.mControlUI.dE(l);
    }
    this.this$0.mApp.getHandler().postDelayed(new AVActivity.3.1(this, l), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.3
 * JD-Core Version:    0.7.0.1
 */