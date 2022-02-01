import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.olympic.view.ScanIconAnimateView;

public class akrg
  implements ValueAnimator.AnimatorUpdateListener
{
  public akrg(ScanIconAnimateView paramScanIconAnimateView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.b.yg = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akrg
 * JD-Core Version:    0.7.0.1
 */