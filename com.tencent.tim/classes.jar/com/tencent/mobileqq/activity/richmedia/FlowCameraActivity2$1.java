package com.tencent.mobileqq.activity.richmedia;

import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.shortvideo.widget.TCProgressBar;

class FlowCameraActivity2$1
  implements Runnable
{
  FlowCameraActivity2$1(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public void run()
  {
    if ((this.this$0.ff != null) && (!this.this$0.ff.isEnabled()))
    {
      this.this$0.ff.setEnabled(true);
      this.this$0.ff.setText(2131693781);
      this.this$0.ff.setTextColor(-15550475);
    }
    int i = 0;
    if (this.this$0.a != null) {
      i = this.this$0.a.JY();
    }
    if ((!this.this$0.zT.isEnabled()) && (i > 0)) {
      this.this$0.zT.setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2.1
 * JD-Core Version:    0.7.0.1
 */