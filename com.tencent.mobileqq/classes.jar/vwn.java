import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;

public class vwn
  implements Animator.AnimatorListener
{
  public vwn(QCircleSlidBottomView paramQCircleSlidBottomView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.a.getContext() != null) {
      uzg.a((Activity)this.a.getContext(), uzg.b(true));
    }
    if (QCircleSlidBottomView.a(this.a) != null) {
      QCircleSlidBottomView.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vwn
 * JD-Core Version:    0.7.0.1
 */