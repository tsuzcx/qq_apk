import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;

class aupk
  implements ValueAnimator.AnimatorUpdateListener
{
  aupk(aupf paramaupf, ViewGroup paramViewGroup, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (paramValueAnimator.getAnimatedFraction() >= 1.0F)
    {
      this.val$parent.getLayoutParams().height = -2;
      this.val$parent.setAlpha(1.0F);
    }
    for (;;)
    {
      this.val$parent.requestLayout();
      return;
      this.val$parent.getLayoutParams().height = ((int)(this.val$height * paramValueAnimator.getAnimatedFraction()));
      this.val$parent.setAlpha((float)Math.pow(paramValueAnimator.getAnimatedFraction(), 3.0D));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aupk
 * JD-Core Version:    0.7.0.1
 */