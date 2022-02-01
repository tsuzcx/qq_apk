import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class yce
  implements ValueAnimator.AnimatorUpdateListener
{
  yce(ycd paramycd) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.d = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yce
 * JD-Core Version:    0.7.0.1
 */