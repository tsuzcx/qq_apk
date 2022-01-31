import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordButtonView;

public class zye
  implements ValueAnimator.AnimatorUpdateListener
{
  public zye(ARVideoRecordButtonView paramARVideoRecordButtonView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    ARVideoRecordButtonView.b(this.a, paramValueAnimator.floatValue());
    ARVideoRecordButtonView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zye
 * JD-Core Version:    0.7.0.1
 */