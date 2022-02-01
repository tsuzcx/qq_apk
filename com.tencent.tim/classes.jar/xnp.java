import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView.c;

public class xnp
  implements ValueAnimator.AnimatorUpdateListener
{
  public xnp(SixCombolEffectView paramSixCombolEffectView, SixCombolEffectView.c paramc) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.b.qw = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xnp
 * JD-Core Version:    0.7.0.1
 */