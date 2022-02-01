import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.ocr.view.ScanOcrView;

public class akov
  extends AnimatorListenerAdapter
{
  public akov(ScanOcrView paramScanOcrView, int paramInt) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.b.ctx) {
      ScanOcrView.a(this.b, this.dor + 1);
    }
    if (this.dor == 2) {
      this.b.dCt();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akov
 * JD-Core Version:    0.7.0.1
 */