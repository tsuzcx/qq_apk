import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.ocr.view.ScanOcrView;
import com.tencent.mobileqq.ocr.view.ScanOcrView.a;

public class akox
  implements ValueAnimator.AnimatorUpdateListener
{
  public akox(ScanOcrView paramScanOcrView, ScanOcrView.a parama) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.d.dow = i;
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akox
 * JD-Core Version:    0.7.0.1
 */