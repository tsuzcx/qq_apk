import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordButtonView;

public class adcj
  implements ValueAnimator.AnimatorUpdateListener
{
  public adcj(ARVideoRecordButtonView paramARVideoRecordButtonView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    ARVideoRecordButtonView.b(this.this$0, paramValueAnimator.floatValue());
    ARVideoRecordButtonView.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adcj
 * JD-Core Version:    0.7.0.1
 */