import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.profile.view.BreatheEffectView;

public class alge
  implements ValueAnimator.AnimatorUpdateListener
{
  public alge(BreatheEffectView paramBreatheEffectView, Drawable paramDrawable) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Rect)paramValueAnimator.getAnimatedValue();
    this.val$drawable.setBounds(paramValueAnimator);
    this.a.invalidate(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alge
 * JD-Core Version:    0.7.0.1
 */