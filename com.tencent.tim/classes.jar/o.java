import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.hiboom.HiBoomTextView;

class o
  implements ValueAnimator.AnimatorUpdateListener
{
  o(n paramn) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (i >= this.a.M[0])
    {
      this.a.a.cancel();
      this.a.frameIndex = 0;
      n.a(this.a).ciS = n.a(this.a).aow();
      n.a(this.a).requestLayout();
      n.a(this.a).invalidate();
    }
    while (i <= this.a.frameIndex) {
      return;
    }
    this.a.frameIndex = i;
    n.a(this.a).invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     o
 * JD-Core Version:    0.7.0.1
 */