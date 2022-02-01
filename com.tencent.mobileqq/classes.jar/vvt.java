import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.biz.qqcircle.transition.QCircleTransitionLayout;

public class vvt
  implements Animator.AnimatorListener
{
  public vvt(QCircleTransitionLayout paramQCircleTransitionLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QCircleTransitionLayout.a(this.a) != null) {
      QCircleTransitionLayout.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvt
 * JD-Core Version:    0.7.0.1
 */