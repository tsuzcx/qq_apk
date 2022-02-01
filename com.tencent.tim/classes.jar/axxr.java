import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.qq.im.capture.view.QIMSlidingTabView;

public class axxr
  implements ValueAnimator.AnimatorUpdateListener
{
  public axxr(QIMSlidingTabView paramQIMSlidingTabView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    QIMSlidingTabView.a(this.d, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.d.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axxr
 * JD-Core Version:    0.7.0.1
 */