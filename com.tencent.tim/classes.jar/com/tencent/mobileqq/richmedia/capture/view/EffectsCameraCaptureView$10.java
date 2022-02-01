package com.tencent.mobileqq.richmedia.capture.view;

import alxu;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import java.io.File;

class EffectsCameraCaptureView$10
  implements Runnable
{
  EffectsCameraCaptureView$10(EffectsCameraCaptureView paramEffectsCameraCaptureView, boolean paramBoolean, alxu paramalxu) {}
  
  public void run()
  {
    String str1;
    String str2;
    if (this.this$0.mQQFilterRenderManager != null)
    {
      if (!this.cBe) {
        break label120;
      }
      str1 = this.a.bZq + this.a.dgStageName + File.separator;
      str2 = this.a.bZq + this.a.name + File.separator;
      this.this$0.mQQFilterRenderManager.getBusinessOperation().setFaceDanceFilter(str1, str2);
    }
    for (;;)
    {
      this.this$0.mQQFilterRenderManager.getBusinessOperation().handleDanceFilterRestoreEvent();
      return;
      label120:
      str1 = this.a.bZq + this.a.dgStageName + File.separator;
      str2 = this.a.bZq + this.a.name + File.separator;
      String str3 = this.a.bZq + this.a.dgModelName + File.separator;
      this.this$0.mQQFilterRenderManager.getBusinessOperation().setQmcfPoseFilter(str1, str2, str3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView.10
 * JD-Core Version:    0.7.0.1
 */