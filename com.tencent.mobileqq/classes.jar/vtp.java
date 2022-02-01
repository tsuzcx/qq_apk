import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;

public class vtp
  implements Animator.AnimatorListener
{
  public vtp(QCircleSlidBottomView paramQCircleSlidBottomView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.getContext() != null) {
      uxx.a((Activity)this.a.getContext());
    }
    if (QCircleSlidBottomView.a(this.a) != null) {
      QCircleSlidBottomView.a(this.a).b();
    }
    this.a.setVisibility(8);
    QCircleSlidBottomView.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    QCircleSlidBottomView.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtp
 * JD-Core Version:    0.7.0.1
 */