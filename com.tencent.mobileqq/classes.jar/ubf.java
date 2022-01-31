import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.content.res.Resources;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;

public class ubf
  implements Animator.AnimatorListener
{
  public ubf(QCircleSlidBottomView paramQCircleSlidBottomView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.a.getContext() != null) {
      tra.a((Activity)this.a.getContext(), this.a.getResources().getColor(2131166179));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ubf
 * JD-Core Version:    0.7.0.1
 */