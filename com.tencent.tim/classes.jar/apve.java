import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.troop.widget.RedDotAnimateView;

public class apve
  implements ValueAnimator.AnimatorUpdateListener
{
  public apve(RedDotAnimateView paramRedDotAnimateView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.b.dXc = ((int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 255.0F));
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apve
 * JD-Core Version:    0.7.0.1
 */