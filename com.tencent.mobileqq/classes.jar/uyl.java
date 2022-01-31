import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class uyl
  implements ValueAnimator.AnimatorUpdateListener
{
  uyl(uyj paramuyj) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.p = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uyl
 * JD-Core Version:    0.7.0.1
 */