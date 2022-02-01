import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.troop.widget.RedDotAnimateView;

public class apvc
  implements ValueAnimator.AnimatorUpdateListener
{
  public apvc(RedDotAnimateView paramRedDotAnimateView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.b.Az = (((Float)paramValueAnimator.getAnimatedValue()).floatValue() * this.b.viewWidth / 2.0F);
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apvc
 * JD-Core Version:    0.7.0.1
 */