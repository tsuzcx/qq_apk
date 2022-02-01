import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Drawable;
import com.tencent.biz.qqcircle.transition.QCircleTransitionInnerLayout;

class vna
  implements ValueAnimator.AnimatorUpdateListener
{
  vna(vmw paramvmw) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 255.0F);
    if ((vmw.a(this.a) != null) && (vmw.a(this.a).getBackground() != null)) {
      vmw.a(this.a).getBackground().setAlpha(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vna
 * JD-Core Version:    0.7.0.1
 */