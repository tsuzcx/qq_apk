import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ptv.LightWeightCaptureButtonHorizontalLayout;

public class ayax
  extends AnimatorListenerAdapter
{
  public ayax(LightWeightCaptureButtonHorizontalLayout paramLightWeightCaptureButtonHorizontalLayout) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "startDeleteLoosenAnim mProgressView 100ms back end");
    }
    this.a.ePV();
    ainc.dsX();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "startDeleteLoosenAnim mProgressView begin");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayax
 * JD-Core Version:    0.7.0.1
 */