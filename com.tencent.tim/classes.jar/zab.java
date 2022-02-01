import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;

public class zab
  implements ValueAnimator.AnimatorUpdateListener
{
  public zab(SimpleSlidingIndicator paramSimpleSlidingIndicator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.b.aYV = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zab
 * JD-Core Version:    0.7.0.1
 */