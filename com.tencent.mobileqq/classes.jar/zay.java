import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class zay
  implements ValueAnimator.AnimatorUpdateListener
{
  zay(zax paramzax) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.p = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.b.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zay
 * JD-Core Version:    0.7.0.1
 */