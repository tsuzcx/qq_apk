import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class xsl
  implements ValueAnimator.AnimatorUpdateListener
{
  xsl(xsk paramxsk) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    xsk.a(this.a, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xsl
 * JD-Core Version:    0.7.0.1
 */