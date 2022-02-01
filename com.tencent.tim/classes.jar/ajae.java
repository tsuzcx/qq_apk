import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.medalwall.MedalGuideView;

public class ajae
  implements ValueAnimator.AnimatorUpdateListener
{
  public ajae(MedalGuideView paramMedalGuideView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue("alpha")).floatValue();
    MedalGuideView.a(this.this$0, f);
    int i = ((Integer)this.this$0.mArgbEvaluator.evaluate(f, Integer.valueOf(0), Integer.valueOf(this.this$0.mBgColor))).intValue();
    this.this$0.mContentView.setBackgroundColor(i);
    if (paramValueAnimator.getAnimatedFraction() >= 1.0F) {
      paramValueAnimator.removeAllUpdateListeners();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajae
 * JD-Core Version:    0.7.0.1
 */