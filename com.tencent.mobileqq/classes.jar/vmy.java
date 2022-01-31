import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class vmy
  implements ValueAnimator.AnimatorUpdateListener
{
  vmy(vna paramvna) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.a != null) {
      this.a.a(paramValueAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vmy
 * JD-Core Version:    0.7.0.1
 */