import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.image.URLImageView;

class mxq
  implements ValueAnimator.AnimatorUpdateListener
{
  mxq(mxm parammxm, LinearLayout.LayoutParams paramLayoutParams, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ViewGroup.LayoutParams paramLayoutParams1, int paramInt5, int paramInt6, int paramInt7, ViewGroup.LayoutParams paramLayoutParams2, int paramInt8, int paramInt9) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.width = (this.val$width + (int)(paramValueAnimator.getAnimatedFraction() * this.aVE));
    this.a.height = (this.val$height + (int)(paramValueAnimator.getAnimatedFraction() * this.aVF));
    mxm.a(this.c).by.setLayoutParams(this.a);
    this.e.width = (this.aVG + (int)(paramValueAnimator.getAnimatedFraction() * this.aVH));
    this.e.height = (this.aVI + (int)(paramValueAnimator.getAnimatedFraction() * this.aVH));
    mxm.a(this.c).D.setLayoutParams(this.e);
    this.f.width = (this.aVJ + (int)(paramValueAnimator.getAnimatedFraction() * this.aVK));
    mxm.a(this.c).lS.setLayoutParams(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mxq
 * JD-Core Version:    0.7.0.1
 */