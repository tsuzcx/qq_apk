import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class yrm
  implements ValueAnimator.AnimatorUpdateListener
{
  yrm(yrk paramyrk) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.p = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yrm
 * JD-Core Version:    0.7.0.1
 */