import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.richmedia.capture.view.QQSlidingTabView;

public class alyf
  implements ValueAnimator.AnimatorUpdateListener
{
  public alyf(QQSlidingTabView paramQQSlidingTabView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    QQSlidingTabView.a(this.d, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.d.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alyf
 * JD-Core Version:    0.7.0.1
 */