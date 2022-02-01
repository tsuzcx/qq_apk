import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ayjq
  implements ValueAnimator.AnimatorUpdateListener
{
  ayjq(ayjn.b paramb) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.b.nJ = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.b.this$0.notifyChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayjq
 * JD-Core Version:    0.7.0.1
 */