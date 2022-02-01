import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class rfu
  implements ValueAnimator.AnimatorUpdateListener
{
  rfu(rft.a parama) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.bqP = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.a.notifyChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rfu
 * JD-Core Version:    0.7.0.1
 */