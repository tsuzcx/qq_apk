import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class wzw
  implements ValueAnimator.AnimatorUpdateListener
{
  wzw(wzu paramwzu) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.p = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wzw
 * JD-Core Version:    0.7.0.1
 */