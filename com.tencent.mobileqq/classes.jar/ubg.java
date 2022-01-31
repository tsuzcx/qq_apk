import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;

public class ubg
  implements Animator.AnimatorListener
{
  public ubg(QCircleSlidBottomView paramQCircleSlidBottomView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.getContext() != null) {
      tra.a((Activity)this.a.getContext());
    }
    if (QCircleSlidBottomView.a(this.a) != null) {
      QCircleSlidBottomView.a(this.a).a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ubg
 * JD-Core Version:    0.7.0.1
 */