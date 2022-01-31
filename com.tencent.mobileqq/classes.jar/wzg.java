import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class wzg
  implements ValueAnimator.AnimatorUpdateListener
{
  wzg(wzf paramwzf) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.d = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wzg
 * JD-Core Version:    0.7.0.1
 */