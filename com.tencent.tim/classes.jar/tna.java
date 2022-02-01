import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import com.tencent.gdtad.views.videoimax.GdtVideoImaxEnterImageView;
import com.tencent.gdtad.views.videoimax.TransitionContext;

public class tna
  implements ValueAnimator.AnimatorUpdateListener
{
  public tna(TransitionContext paramTransitionContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Rect paramRect) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    int j = this.bCo;
    int k = Math.round((0 - this.bCo) * f);
    int m = this.bCp;
    int n = Math.round((0 - this.bCp) * f);
    int i1 = this.bCq;
    int i2 = Math.round((this.bCr - this.bCq) * f);
    if (this.bCs < TransitionContext.a(this.a).getHeight()) {}
    for (int i = TransitionContext.a(this.a).getHeight();; i = this.bCs)
    {
      int i3 = this.bCt;
      i = Math.round((i - this.bCt) * f);
      this.aR.set(k + j, n + m, i2 + i1, i + i3);
      TransitionContext.a(this.a).setClipBoundsCompact(this.aR);
      TransitionContext.a(this.a).invalidate();
      tkw.d("TransitionContext", "onAnimationUpdate() mPreviewView.getHeight = [" + TransitionContext.a(this.a).getHeight() + "]");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tna
 * JD-Core Version:    0.7.0.1
 */