import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ayjz
  implements ValueAnimator.AnimatorUpdateListener
{
  ayjz(ayjw.c paramc) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.c.nJ = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.c.a.notifyChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayjz
 * JD-Core Version:    0.7.0.1
 */