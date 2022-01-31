import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class uxv
  implements ValueAnimator.AnimatorUpdateListener
{
  uxv(uxu paramuxu) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.d = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxv
 * JD-Core Version:    0.7.0.1
 */