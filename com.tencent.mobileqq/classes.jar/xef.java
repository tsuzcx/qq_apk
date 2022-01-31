import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class xef
  implements ValueAnimator.AnimatorUpdateListener
{
  xef(xed paramxed) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.p = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xef
 * JD-Core Version:    0.7.0.1
 */