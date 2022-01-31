import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingLandView;
import com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment;

public class zbw
  implements ValueAnimator.AnimatorUpdateListener
{
  public zbw(GdtVideoImaxFragment paramGdtVideoImaxFragment, float paramFloat1, float paramFloat2, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    f = this.jdField_a_of_type_Float + f * (this.b - this.jdField_a_of_type_Float);
    yxp.a("GdtVideoImaxFragment", "onAnimationUpdate() called with: current = [" + f + "]");
    paramValueAnimator = GdtVideoImaxFragment.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtVideoImaxFragment).getLayoutParams();
    paramValueAnimator.height = ((int)f);
    GdtVideoImaxFragment.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtVideoImaxFragment).setLayoutParams(paramValueAnimator);
    paramValueAnimator = (ViewGroup.MarginLayoutParams)GdtVideoImaxFragment.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtVideoImaxFragment).getLayoutParams();
    paramValueAnimator.height = Math.abs((int)(this.jdField_a_of_type_Int - f));
    GdtVideoImaxFragment.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoimaxGdtVideoImaxFragment).setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     zbw
 * JD-Core Version:    0.7.0.1
 */