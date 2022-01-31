import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class vzk
  implements ValueAnimator.AnimatorUpdateListener
{
  vzk(vzj paramvzj) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    vzj.a(this.a, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vzk
 * JD-Core Version:    0.7.0.1
 */