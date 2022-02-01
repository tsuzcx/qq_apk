import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ayjo
  implements ValueAnimator.AnimatorUpdateListener
{
  ayjo(ayjn.a parama) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.bqP = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.this$0.notifyChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayjo
 * JD-Core Version:    0.7.0.1
 */