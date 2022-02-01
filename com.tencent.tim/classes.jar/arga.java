import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class arga
  implements ValueAnimator.AnimatorUpdateListener
{
  arga(arfz paramarfz) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    arfz.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.a.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arga
 * JD-Core Version:    0.7.0.1
 */