import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class argx
  implements ValueAnimator.AnimatorUpdateListener
{
  argx(argu paramargu) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (argu.a(this.b) != null)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      argu.a(this.b).setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     argx
 * JD-Core Version:    0.7.0.1
 */