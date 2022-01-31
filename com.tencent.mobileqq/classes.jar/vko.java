import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class vko
  implements ValueAnimator.AnimatorUpdateListener
{
  vko(vkn paramvkn) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.d = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vko
 * JD-Core Version:    0.7.0.1
 */