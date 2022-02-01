import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class rpp
  implements ValueAnimator.AnimatorUpdateListener
{
  rpp(rpo paramrpo) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    rpo.a(this.c, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rpp
 * JD-Core Version:    0.7.0.1
 */