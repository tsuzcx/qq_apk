import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoySlidingIndicator;

public class nhx
  implements ValueAnimator.AnimatorUpdateListener
{
  public nhx(ReadinjoySlidingIndicator paramReadinjoySlidingIndicator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ReadinjoySlidingIndicator.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nhx
 * JD-Core Version:    0.7.0.1
 */