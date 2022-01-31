import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class vle
  implements ValueAnimator.AnimatorUpdateListener
{
  vle(vlc paramvlc) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.p = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vle
 * JD-Core Version:    0.7.0.1
 */