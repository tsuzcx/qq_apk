import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Drawable;
import com.tencent.biz.qqcircle.transition.QCircleTransitionInnerLayout;

class vkw
  implements ValueAnimator.AnimatorUpdateListener
{
  vkw(vks paramvks) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 255.0F);
    if ((vks.a(this.a) != null) && (vks.a(this.a).getBackground() != null)) {
      vks.a(this.a).getBackground().setAlpha(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vkw
 * JD-Core Version:    0.7.0.1
 */