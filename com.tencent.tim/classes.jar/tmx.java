import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingLandView;
import com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment;

public class tmx
  implements ValueAnimator.AnimatorUpdateListener
{
  public tmx(GdtVideoImaxFragment paramGdtVideoImaxFragment, float paramFloat1, float paramFloat2, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    f = this.oJ + f * (this.oK - this.oJ);
    tkw.d("GdtVideoImaxFragment", "onAnimationUpdate() called with: current = [" + f + "]");
    paramValueAnimator = GdtVideoImaxFragment.a(this.this$0).getLayoutParams();
    paramValueAnimator.height = ((int)f);
    GdtVideoImaxFragment.a(this.this$0).setLayoutParams(paramValueAnimator);
    paramValueAnimator = (ViewGroup.MarginLayoutParams)GdtVideoImaxFragment.a(this.this$0).getLayoutParams();
    paramValueAnimator.height = Math.abs((int)(this.val$total - f));
    GdtVideoImaxFragment.a(this.this$0).setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tmx
 * JD-Core Version:    0.7.0.1
 */