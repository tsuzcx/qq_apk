import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Drawable;
import com.tencent.biz.qqcircle.transition.QCircleTransitionInnerLayout;

class tyc
  implements ValueAnimator.AnimatorUpdateListener
{
  tyc(txz paramtxz) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 255.0F);
    if ((txz.a(this.a) != null) && (txz.a(this.a).getBackground() != null)) {
      txz.a(this.a).getBackground().setAlpha(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tyc
 * JD-Core Version:    0.7.0.1
 */