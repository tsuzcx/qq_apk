import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class yra
  implements ValueAnimator.AnimatorUpdateListener
{
  yra(yqz paramyqz) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.p = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.b.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yra
 * JD-Core Version:    0.7.0.1
 */