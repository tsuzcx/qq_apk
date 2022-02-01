package com.tencent.av.ui;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;

class AVActivity$3$1
  implements Runnable
{
  AVActivity$3$1(AVActivity.3 param3, long paramLong) {}
  
  public void run()
  {
    if (this.a.this$0.isDestroyed()) {}
    View localView;
    do
    {
      return;
      QLog.w(this.a.this$0.TAG, 1, "qav_UserGuide_for_more, 开始显示, seq[" + this.kQ + "]");
      localView = this.a.this$0.findViewById(2131374120);
    } while ((localView == null) || (this.a.this$0.mControlUI == null) || (!this.a.this$0.mControlUI.wH()) || (((RelativeLayout)this.a.this$0.findViewById(2131374039)).getVisibility() == 0));
    this.a.this$0.mControlUI.dE(this.kQ);
    localView.setVisibility(0);
    localView.setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.3.1
 * JD-Core Version:    0.7.0.1
 */