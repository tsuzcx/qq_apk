import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.multiaio.MultiAIOFragment;

public class ajho
  implements ValueAnimator.AnimatorUpdateListener
{
  public ajho(MultiAIOFragment paramMultiAIOFragment, ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = (ViewGroup.MarginLayoutParams)this.Be.getLayoutParams();
    paramValueAnimator.leftMargin = (this.djb + Math.round((0.0F - this.djb) * f));
    paramValueAnimator.topMargin = (this.djd + Math.round((this.djh - this.djd) * f));
    paramValueAnimator.width = (this.coe + Math.round((this.djf - this.coe) * f));
    int i = this.val$initialHeight;
    paramValueAnimator.height = (Math.round(f * (this.djg - this.val$initialHeight)) + i);
    this.Be.setLayoutParams(paramValueAnimator);
    this.Be.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajho
 * JD-Core Version:    0.7.0.1
 */