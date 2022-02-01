import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.medalwall.MedalGuideView;

public class ajaf
  implements ValueAnimator.AnimatorUpdateListener
{
  public ajaf(MedalGuideView paramMedalGuideView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    MedalGuideView.a(this.this$0, f);
    if (this.this$0.a != null)
    {
      this.this$0.a.setAlpha(f);
      if (f <= 0.05F) {
        this.this$0.a.stop();
      }
    }
    if (paramValueAnimator.getAnimatedFraction() >= 1.0F) {
      paramValueAnimator.removeAllUpdateListeners();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajaf
 * JD-Core Version:    0.7.0.1
 */