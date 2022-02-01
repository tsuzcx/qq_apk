package dov.com.qq.im;

import android.widget.TextView;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;

class QIMEffectCameraCaptureUnit$5
  implements Runnable
{
  QIMEffectCameraCaptureUnit$5(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.dsk) && (!this.this$0.c.WW()))
    {
      QIMEffectCameraCaptureUnit.a(this.this$0).setVisibility(0);
      return;
    }
    QIMEffectCameraCaptureUnit.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit.5
 * JD-Core Version:    0.7.0.1
 */