import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class zbl
  implements ValueAnimator.AnimatorUpdateListener
{
  zbl(zbj paramzbj) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.p = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zbl
 * JD-Core Version:    0.7.0.1
 */