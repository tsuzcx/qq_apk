import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class yqn
  implements ValueAnimator.AnimatorUpdateListener
{
  yqn(yqm paramyqm) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    yqm.a(this.a, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yqn
 * JD-Core Version:    0.7.0.1
 */