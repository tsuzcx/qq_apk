import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView.c;

public class xnm
  implements ValueAnimator.AnimatorUpdateListener
{
  public xnm(SixCombolEffectView paramSixCombolEffectView, SixCombolEffectView.c paramc) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.b.mScale = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if ((!this.b.bgX) && (this.b.mScale < 0.52F)) {
      this.b.bgX = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xnm
 * JD-Core Version:    0.7.0.1
 */