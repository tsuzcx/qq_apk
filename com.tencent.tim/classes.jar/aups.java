import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;

class aups
  implements ValueAnimator.AnimatorUpdateListener
{
  aups(aupr paramaupr, ViewGroup paramViewGroup, int paramInt) {}
  
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
      this.val$parent.getLayoutParams().height = (this.val$height - (int)(this.val$height * paramValueAnimator.getAnimatedFraction()));
      this.val$parent.setAlpha((1.0F - paramValueAnimator.getAnimatedFraction()) / 5.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aups
 * JD-Core Version:    0.7.0.1
 */