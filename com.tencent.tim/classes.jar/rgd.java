import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class rgd
  implements ValueAnimator.AnimatorUpdateListener
{
  rgd(rgb.b paramb) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.c.nJ = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.c.a.notifyChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rgd
 * JD-Core Version:    0.7.0.1
 */