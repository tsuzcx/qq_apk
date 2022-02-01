import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.multicard.MultiCardCustomLayout;
import com.tencent.mobileqq.multicard.MultiCardFragment;
import com.tencent.mobileqq.multicard.MultiCardFragment.a;

public class ajjn
  implements ValueAnimator.AnimatorUpdateListener
{
  public ajjn(MultiCardFragment paramMultiCardFragment, MultiCardFragment.a parama, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = paramValueAnimator.getAnimatedFraction();
    if (this.b == null) {
      return;
    }
    float f2 = 1.0F - (1.0F - this.xo) * f1;
    this.b.c.setScaleX(f2);
    this.b.c.setScaleY(f2);
    this.b.c.setTranslationX(0.0F);
    this.b.c.setTranslationY(this.xp * f1);
    paramValueAnimator = this.b.c.getLayoutParams();
    float f3 = this.xq;
    paramValueAnimator.height = ((int)((1.0F - f1 * (1.0F - this.xr)) / f2 * f3));
    this.b.c.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajjn
 * JD-Core Version:    0.7.0.1
 */