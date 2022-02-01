import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.medalwall.MedalGuideView;

public class ajag
  implements ValueAnimator.AnimatorUpdateListener
{
  public ajag(MedalGuideView paramMedalGuideView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = ((Integer)this.this$0.mArgbEvaluator.evaluate(f, Integer.valueOf(this.this$0.mBgColor), Integer.valueOf(0))).intValue();
    this.this$0.mContentView.setBackgroundColor(i);
    if (paramValueAnimator.getAnimatedFraction() >= 1.0F) {
      paramValueAnimator.removeAllUpdateListeners();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajag
 * JD-Core Version:    0.7.0.1
 */