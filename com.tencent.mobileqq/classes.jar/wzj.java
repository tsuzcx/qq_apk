import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class wzj
  implements ValueAnimator.AnimatorUpdateListener
{
  wzj(wzi paramwzi) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.p = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.b.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wzj
 * JD-Core Version:    0.7.0.1
 */