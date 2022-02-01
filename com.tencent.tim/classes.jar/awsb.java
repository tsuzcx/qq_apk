import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class awsb
  implements Animation.AnimationListener
{
  public awsb(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QIMEffectCameraCaptureUnit.e(this.this$0) != null)
    {
      QIMEffectCameraCaptureUnit.e(this.this$0).clearAnimation();
      QIMEffectCameraCaptureUnit.e(this.this$0).setVisibility(8);
    }
    this.this$0.drS = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.this$0.drS = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awsb
 * JD-Core Version:    0.7.0.1
 */