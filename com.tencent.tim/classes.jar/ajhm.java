import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.multiaio.MultiAIOFragment;
import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;

public class ajhm
  implements ValueAnimator.AnimatorUpdateListener
{
  public ajhm(MultiAIOFragment paramMultiAIOFragment, ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = (ViewGroup.MarginLayoutParams)this.Be.getLayoutParams();
    paramValueAnimator.leftMargin = (this.djb + Math.round((this.djc - this.djb) * f));
    paramValueAnimator.topMargin = (this.djd + Math.round((this.dje - this.djd) * f));
    paramValueAnimator.width = (this.coe + Math.round((this.djf - this.coe) * f));
    int i = this.djg;
    int j = MultiAIOFragment.a(this.this$0).getHeight() - MultiAIOFragment.a(this.this$0).getPaddingTop() - MultiAIOFragment.a(this.this$0).getPaddingBottom();
    if (j > 0) {
      i = j;
    }
    for (;;)
    {
      j = this.val$initialHeight;
      paramValueAnimator.height = (Math.round((i - this.val$initialHeight) * f) + j);
      this.Be.setLayoutParams(paramValueAnimator);
      this.Be.requestLayout();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajhm
 * JD-Core Version:    0.7.0.1
 */