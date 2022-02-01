import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.olympic.view.ScanIconAnimateView;
import com.tencent.mobileqq.olympic.view.ScanIconAnimateView.a;

public class akrn
  implements Animator.AnimatorListener
{
  public akrn(ScanIconAnimateView paramScanIconAnimateView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ScanIconAnimateView.a(this.b, true);
    if (this.b.a != null) {
      this.b.a.onEnd();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.b.a != null) {
      this.b.a.onStart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akrn
 * JD-Core Version:    0.7.0.1
 */