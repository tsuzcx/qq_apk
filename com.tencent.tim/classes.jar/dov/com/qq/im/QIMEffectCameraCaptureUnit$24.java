package dov.com.qq.im;

import android.widget.RelativeLayout;
import axoo;
import axov;
import axpa;
import ayzs;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;

class QIMEffectCameraCaptureUnit$24
  implements Runnable
{
  QIMEffectCameraCaptureUnit$24(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.dsi) && (QIMEffectCameraCaptureUnit.e(this.this$0)))
    {
      this.this$0.drx = true;
      QIMEffectCameraCaptureUnit.c(this.this$0);
    }
    if (this.this$0.dro) {
      this.this$0.bottom_blackLH.setVisibility(0);
    }
    ((ayzs)axov.a(3)).aq("0", axpa.eGs, "");
    axpa.eGt = 0;
    this.this$0.a.eNA();
    this.this$0.c.setFaceEffect("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit.24
 * JD-Core Version:    0.7.0.1
 */