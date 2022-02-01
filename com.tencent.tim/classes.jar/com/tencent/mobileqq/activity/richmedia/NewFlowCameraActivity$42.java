package com.tencent.mobileqq.activity.richmedia;

import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.widget.CircleProgress;
import java.util.concurrent.atomic.AtomicInteger;

class NewFlowCameraActivity$42
  implements Runnable
{
  NewFlowCameraActivity$42(NewFlowCameraActivity paramNewFlowCameraActivity, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.this$0.c.aL.get() == 3) || (this.this$0.c.aL.get() == 4))
    {
      if (this.this$0.bxL) {
        if (this.this$0.ciP >= 60000)
        {
          i = 10000;
          if (!this.this$0.byb) {
            break label142;
          }
          this.this$0.e.setProgress(i * 1.0F / (this.this$0.videoDuration * 10));
        }
      }
      for (;;)
      {
        if (this.byE) {
          this.this$0.e.setProgress(100.0F);
        }
        return;
        i = this.this$0.ciP % 10000;
        break;
        i = this.this$0.ciP;
        break;
        label142:
        if (!NewFlowCameraActivity.k(this.this$0)) {
          break label181;
        }
        this.this$0.e.setProgress(i * 1.0F / (NewFlowCameraActivity.d(this.this$0) * 10));
      }
      label181:
      CircleProgress localCircleProgress = this.this$0.e;
      float f = i;
      if (this.this$0.bxz) {}
      for (int i = this.this$0.c.yZ() + 1;; i = this.this$0.c.yZ())
      {
        localCircleProgress.setProgress(1.0F * f / i);
        break;
      }
    }
    this.this$0.e.setProgress(0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.42
 * JD-Core Version:    0.7.0.1
 */