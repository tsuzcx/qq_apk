import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class rfw
  implements ValueAnimator.AnimatorUpdateListener
{
  rfw(rft.b paramb) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.b.nJ = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.b.a.notifyChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rfw
 * JD-Core Version:    0.7.0.1
 */