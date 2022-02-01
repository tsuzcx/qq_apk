import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams;

public class arkr
  implements ValueAnimator.AnimatorUpdateListener
{
  public arkr(FloatingScreenContainer paramFloatingScreenContainer, int paramInt1, int paramInt2, WindowManager.LayoutParams paramLayoutParams, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    if (this.eka >= -this.ekb) {
      this.j.x = ((int)(this.ekc + paramValueAnimator.floatValue() * (this.eka - this.ekc)));
    }
    if (this.ekd >= this.eke)
    {
      WindowManager.LayoutParams localLayoutParams = this.j;
      float f = this.ahb;
      localLayoutParams.y = ((int)(paramValueAnimator.floatValue() * (this.ekd - this.ahb) + f));
    }
    this.a.c(this.j);
    FloatingScreenContainer.a(this.a).setFloatingCenterX(this.j.x);
    FloatingScreenContainer.a(this.a).setFloatingCenterY(this.j.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arkr
 * JD-Core Version:    0.7.0.1
 */