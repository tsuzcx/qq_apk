import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.HeartCombolEffectView;
import com.tencent.mobileqq.activity.aio.item.HeartCombolEffectView.a;

public class xdz
  implements ValueAnimator.AnimatorUpdateListener
{
  public xdz(HeartCombolEffectView paramHeartCombolEffectView, HeartCombolEffectView.a parama) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.b.mScale = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if ((!this.b.bgX) && (this.b.mScale > 0.0F)) {
      this.b.bgX = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xdz
 * JD-Core Version:    0.7.0.1
 */