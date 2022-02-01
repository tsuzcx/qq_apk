import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.profile.view.BreatheEffectView;

public class algc
  implements ValueAnimator.AnimatorUpdateListener
{
  public algc(BreatheEffectView paramBreatheEffectView, Drawable paramDrawable) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.val$drawable.setBounds((Rect)paramValueAnimator.getAnimatedValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     algc
 * JD-Core Version:    0.7.0.1
 */