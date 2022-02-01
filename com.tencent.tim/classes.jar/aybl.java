import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ptv.BaseButton;
import dov.com.qq.im.ptv.LightWeightCaptureButtonLayout;

public class aybl
  extends AnimatorListenerAdapter
{
  public aybl(LightWeightCaptureButtonLayout paramLightWeightCaptureButtonLayout) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "startLockLoosenAnim  140ms end");
    }
    ainc.dsW();
    this.this$0.a.setImageResource(2130845327);
    this.this$0.a.setOnTouchListener(null);
    this.this$0.a.setOnTouchListener(new aybm(this));
    this.this$0.b.setStateful(true);
    this.this$0.b.setOnClickListener(new aybn(this));
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "startLockLoosenAnim start");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aybl
 * JD-Core Version:    0.7.0.1
 */