import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ptv.LightWeightCaptureButtonLayout;

public class aybi
  extends AnimatorListenerAdapter
{
  public aybi(LightWeightCaptureButtonLayout paramLightWeightCaptureButtonLayout) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "startDeleteAdsorptionAnimation  140ms translate end");
    }
    this.this$0.a.status = 4;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.this$0.a.aCE = SystemClock.uptimeMillis();
    this.this$0.a.duration = 140L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aybi
 * JD-Core Version:    0.7.0.1
 */