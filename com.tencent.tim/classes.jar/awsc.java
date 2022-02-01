import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class awsc
  implements Animation.AnimationListener
{
  public awsc(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEffectCameraCaptureUnit", 2, "clearAnimation end!");
    }
    if (QIMEffectCameraCaptureUnit.e(this.this$0) == null) {
      return;
    }
    this.this$0.drS = true;
    QIMEffectCameraCaptureUnit.e(this.this$0).setText(2131701704);
    QIMEffectCameraCaptureUnit.e(this.this$0).startAnimation(this.this$0.E);
    this.this$0.D.setStartOffset(3000L);
    this.this$0.D.setAnimationListener(QIMEffectCameraCaptureUnit.b(this.this$0));
    QIMEffectCameraCaptureUnit.e(this.this$0).setAnimation(this.this$0.D);
    this.this$0.D.startNow();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.this$0.drS = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awsc
 * JD-Core Version:    0.7.0.1
 */