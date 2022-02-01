package com.tencent.mobileqq.activity.richmedia;

import aavi;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

class NewFlowCameraActivity$52
  implements Runnable
{
  NewFlowCameraActivity$52(NewFlowCameraActivity paramNewFlowCameraActivity, boolean paramBoolean, String paramString, int paramInt) {}
  
  public void run()
  {
    NewFlowCameraActivity.b(this.this$0, null);
    NewFlowCameraActivity.a(this.this$0, -1);
    if (this.py) {
      if (this.this$0.zW.isShown())
      {
        NewFlowCameraActivity.b(this.this$0, this.bdW);
        NewFlowCameraActivity.a(this.this$0, this.val$type);
      }
    }
    do
    {
      return;
      if (this.val$type == 1) {}
      for (long l = 1500L;; l = 3000L)
      {
        if (this.val$type == 3) {
          l = aavi.eN();
        }
        if (this.bdW == null) {
          break;
        }
        this.this$0.Ou.setText(this.bdW);
        this.this$0.Ou.setVisibility(0);
        if (this.this$0.mUIHandler == null) {
          break;
        }
        this.this$0.mUIHandler.removeCallbacks(NewFlowCameraActivity.a(this.this$0));
        if (l < 0L) {
          break;
        }
        this.this$0.mUIHandler.postDelayed(NewFlowCameraActivity.a(this.this$0), l);
        return;
      }
      this.this$0.Ou.setText("");
      this.this$0.Ou.setVisibility(8);
    } while (this.this$0.mUIHandler == null);
    this.this$0.mUIHandler.removeCallbacks(NewFlowCameraActivity.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.52
 * JD-Core Version:    0.7.0.1
 */