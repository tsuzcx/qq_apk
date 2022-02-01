import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PointF;
import android.view.View;

class pby
  implements ValueAnimator.AnimatorUpdateListener
{
  pby(pbv parampbv, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (PointF)paramValueAnimator.getAnimatedValue();
    this.val$view.setX(paramValueAnimator.x);
    this.val$view.setY(paramValueAnimator.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pby
 * JD-Core Version:    0.7.0.1
 */