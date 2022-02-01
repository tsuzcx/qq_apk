package com.tencent.mobileqq.activity.richmedia;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;

class NewFlowCameraActivity$20
  implements Runnable
{
  NewFlowCameraActivity$20(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    int i = (int)(this.this$0.a.getHeight() * 0.35F);
    ViewGroup.LayoutParams localLayoutParams = this.this$0.zY.getLayoutParams();
    localLayoutParams.height = (i - this.this$0.wu.getHeight());
    this.this$0.zY.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.20
 * JD-Core Version:    0.7.0.1
 */