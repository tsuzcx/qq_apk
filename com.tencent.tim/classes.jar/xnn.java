import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView.c;

public class xnn
  implements ValueAnimator.AnimatorUpdateListener
{
  public xnn(SixCombolEffectView paramSixCombolEffectView, SixCombolEffectView.c paramc) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.b.mScale = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xnn
 * JD-Core Version:    0.7.0.1
 */