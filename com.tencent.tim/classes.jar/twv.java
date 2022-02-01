import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class twv
  implements ValueAnimator.AnimatorUpdateListener
{
  twv(twt paramtwt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    twt.a(this.b, Float.parseFloat(String.valueOf(paramValueAnimator.getAnimatedValue())));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     twv
 * JD-Core Version:    0.7.0.1
 */