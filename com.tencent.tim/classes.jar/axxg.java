import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMCircleProgress;

public class axxg
  extends AnimatorListenerAdapter
{
  public axxg(QIMCircleProgress paramQIMCircleProgress) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.dwZ = false;
    if (QLog.isColorLevel()) {
      QLog.d("QIMCircleProgress", 2, "[segmentCapture] capturedSegmentBlinkAnimator cancel");
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.dwZ = false;
    if ((this.a.dxb) && (this.a.aW != null)) {
      this.a.aW.start();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMCircleProgress", 2, "[segmentCapture] capturedSegmentBlinkAnimator end");
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.dwZ = true;
    if (QLog.isColorLevel()) {
      QLog.d("QIMCircleProgress", 2, "capturedSegmentBlinkAnimator start");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axxg
 * JD-Core Version:    0.7.0.1
 */