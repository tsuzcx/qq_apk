import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class ych
  implements ValueAnimator.AnimatorUpdateListener
{
  ych(ycd paramycd, View paramView, int paramInt1, int paramInt2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() / 100.0F;
    paramValueAnimator = this.xA.getLayoutParams();
    float f2 = this.val$start;
    paramValueAnimator.height = ((int)(f1 * (this.val$end - this.val$start) + f2));
    this.xA.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ych
 * JD-Core Version:    0.7.0.1
 */