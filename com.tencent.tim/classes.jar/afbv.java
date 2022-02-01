import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;

public class afbv
  implements Animator.AnimatorListener
{
  public afbv(DataReportViewer paramDataReportViewer) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.this$0.Rh.setVisibility(0);
    paramAnimator = new AlphaAnimation(0.0F, 1.0F);
    paramAnimator.setFillAfter(true);
    paramAnimator.setDuration(200L);
    this.this$0.Rh.startAnimation(paramAnimator);
    paramAnimator.setAnimationListener(new afbw(this));
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afbv
 * JD-Core Version:    0.7.0.1
 */