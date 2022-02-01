import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayout;

public class ayxy
  implements ValueAnimator.AnimatorUpdateListener
{
  public ayxy(QIMCameraSegmentCaptureButtonLayout paramQIMCameraSegmentCaptureButtonLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.b.GY = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.b.ba(this.b.GY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayxy
 * JD-Core Version:    0.7.0.1
 */