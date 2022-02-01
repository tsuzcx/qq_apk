package dov.com.qq.im;

import android.widget.ImageView;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;

class QIMEffectCameraCaptureUnit$15
  implements Runnable
{
  QIMEffectCameraCaptureUnit$15(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void run()
  {
    QIMEffectCameraCaptureUnit.b(this.this$0).setVisibility(8);
    if (QIMEffectCameraCaptureUnit.b(this.this$0).getDrawable() != null)
    {
      LazyLoadAnimationDrawable localLazyLoadAnimationDrawable = (LazyLoadAnimationDrawable)QIMEffectCameraCaptureUnit.b(this.this$0).getDrawable();
      localLazyLoadAnimationDrawable.stop();
      localLazyLoadAnimationDrawable.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit.15
 * JD-Core Version:    0.7.0.1
 */