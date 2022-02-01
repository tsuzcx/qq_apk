import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class zpr
  implements ValueAnimator.AnimatorUpdateListener
{
  zpr(zpq paramzpq) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    zpq.a(this.a, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zpr
 * JD-Core Version:    0.7.0.1
 */