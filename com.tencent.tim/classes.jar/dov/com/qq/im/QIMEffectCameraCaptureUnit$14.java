package dov.com.qq.im;

import android.os.Handler;
import android.widget.ImageView;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;

class QIMEffectCameraCaptureUnit$14
  implements Runnable
{
  QIMEffectCameraCaptureUnit$14(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit, LazyLoadAnimationDrawable paramLazyLoadAnimationDrawable) {}
  
  public void run()
  {
    this.this$0.cf.postDelayed(QIMEffectCameraCaptureUnit.a(this.this$0), this.a.getTotalDuration());
    QIMEffectCameraCaptureUnit.b(this.this$0).setVisibility(0);
    QIMEffectCameraCaptureUnit.b(this.this$0).setImageDrawable(this.a);
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit.14
 * JD-Core Version:    0.7.0.1
 */