import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.SlidingTabStrip;

public class nsd
  implements ValueAnimator.AnimatorUpdateListener
{
  public nsd(TabLayoutCompat.SlidingTabStrip paramSlidingTabStrip, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  int lerp(int paramInt1, int paramInt2, float paramFloat)
  {
    return Math.round((paramInt2 - paramInt1) * paramFloat) + paramInt1;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    this.b.dp(lerp(this.bbY, this.bbZ, f), lerp(this.bca, this.bcb, f));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nsd
 * JD-Core Version:    0.7.0.1
 */