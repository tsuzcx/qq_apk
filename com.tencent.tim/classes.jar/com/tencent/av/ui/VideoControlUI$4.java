package com.tencent.av.ui;

import acfp;
import android.view.View;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class VideoControlUI$4
  implements Runnable
{
  VideoControlUI$4(VideoControlUI paramVideoControlUI) {}
  
  public void run()
  {
    if (this.this$0.Ya)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.this$0.TAG, 1, "HideToolbarRunnable");
      }
      if (AudioHelper.jY(1) != 1) {
        break label46;
      }
      AudioHelper.UA(acfp.m(2131716371));
    }
    label46:
    Object localObject;
    do
    {
      return;
      localObject = this.this$0.a();
      if (localObject == null) {
        break;
      }
      localObject = ((AVActivity)localObject).findViewById(2131374120);
    } while ((localObject != null) && (((View)localObject).getVisibility() == 0));
    this.this$0.ml(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.4
 * JD-Core Version:    0.7.0.1
 */