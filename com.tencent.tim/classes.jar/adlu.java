import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class adlu
  implements ValueAnimator.AnimatorUpdateListener
{
  adlu(adlt paramadlt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.Lm(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adlu
 * JD-Core Version:    0.7.0.1
 */