import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingLandView;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingView;

public class tms
  implements ValueAnimator.AnimatorUpdateListener
{
  public tms(GdtVideoCeilingView paramGdtVideoCeilingView, RelativeLayout.LayoutParams paramLayoutParams, int paramInt1, int paramInt2, GdtVideoCeilingLandView paramGdtVideoCeilingLandView, boolean paramBoolean) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.r;
    int i = this.val$topMargin;
    paramValueAnimator.topMargin = ((int)(f * this.bCm) + i);
    if (((this.r.topMargin < 1) || (this.r.topMargin >= GdtVideoCeilingView.a(this.jdField_b_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingView))) && (this.jdField_b_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.isAnimating)) {
      GdtVideoCeilingView.a(this.jdField_b_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingView, this.r, this.jdField_b_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView, this.aPJ);
    }
    while (this.jdField_b_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingLandView.setLayoutParams(this.r);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tms
 * JD-Core Version:    0.7.0.1
 */