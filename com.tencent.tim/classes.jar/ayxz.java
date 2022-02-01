import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import dov.com.qq.im.story.view.AnimationQIMCircleProgress;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayout;

public class ayxz
  extends AnimatorListenerAdapter
{
  public ayxz(QIMCameraSegmentCaptureButtonLayout paramQIMCameraSegmentCaptureButtonLayout, boolean paramBoolean, float paramFloat) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.dBS)
    {
      this.b.b.ePg();
      return;
    }
    this.b.b.bx(this.GZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayxz
 * JD-Core Version:    0.7.0.1
 */