import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

final class muo
  implements ValueAnimator.AnimatorUpdateListener
{
  muo(int paramInt1, ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt2, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = (int)(paramValueAnimator.getAnimatedFraction() * this.val$offset);
    this.b.bottomMargin = (i + this.aUO);
    this.val$view.setLayoutParams(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     muo
 * JD-Core Version:    0.7.0.1
 */