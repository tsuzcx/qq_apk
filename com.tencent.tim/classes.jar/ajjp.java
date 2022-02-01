import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.multicard.MultiCardCustomLayout;
import com.tencent.mobileqq.multicard.MultiCardFragment;
import com.tencent.mobileqq.multicard.MultiCardFragment.a;

public class ajjp
  implements ValueAnimator.AnimatorUpdateListener
{
  public ajjp(MultiCardFragment paramMultiCardFragment, MultiCardFragment.a parama, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = paramValueAnimator.getAnimatedFraction();
    if (this.b == null) {
      return;
    }
    float f2 = this.xs + (1.0F - this.xs) * f1;
    this.b.c.setScaleX(f2);
    this.b.c.setScaleY(f2);
    this.b.c.setTranslationX(0.0F);
    this.b.c.setTranslationY(this.xp * (1.0F - f1));
    paramValueAnimator = this.b.c.getLayoutParams();
    float f3 = this.xt;
    float f4 = this.xu;
    paramValueAnimator.height = ((int)((f1 * (1.0F - this.xu) + f4) / f2 * f3));
    this.b.c.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajjp
 * JD-Core Version:    0.7.0.1
 */