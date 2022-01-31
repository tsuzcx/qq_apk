import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class vkr
  implements ValueAnimator.AnimatorUpdateListener
{
  vkr(vkq paramvkq) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.p = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.b.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vkr
 * JD-Core Version:    0.7.0.1
 */