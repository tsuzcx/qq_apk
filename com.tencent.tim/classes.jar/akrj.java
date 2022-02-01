import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.olympic.view.ScanIconAnimateView;

public class akrj
  implements ValueAnimator.AnimatorUpdateListener
{
  public akrj(ScanIconAnimateView paramScanIconAnimateView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.b.yj = (((Float)paramValueAnimator.getAnimatedValue()).floatValue() * -1.0F * wja.dp2px(1.5F, this.b.getResources()));
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akrj
 * JD-Core Version:    0.7.0.1
 */