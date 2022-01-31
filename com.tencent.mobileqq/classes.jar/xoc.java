import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class xoc
  implements ValueAnimator.AnimatorUpdateListener
{
  xoc(xob paramxob) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    xob.a(this.a, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xoc
 * JD-Core Version:    0.7.0.1
 */