import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer;

public class arkt
  implements ValueAnimator.AnimatorUpdateListener
{
  public arkt(FloatingScreenContainer paramFloatingScreenContainer, WindowManager.LayoutParams paramLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    this.j.alpha = (paramValueAnimator.floatValue() * 1.0F + 0.0F);
    this.a.c(this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arkt
 * JD-Core Version:    0.7.0.1
 */