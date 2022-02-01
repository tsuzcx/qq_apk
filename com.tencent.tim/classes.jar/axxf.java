import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.qq.im.capture.view.QIMCircleProgress;

public class axxf
  implements ValueAnimator.AnimatorUpdateListener
{
  public axxf(QIMCircleProgress paramQIMCircleProgress) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.Fn = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.notifyChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axxf
 * JD-Core Version:    0.7.0.1
 */