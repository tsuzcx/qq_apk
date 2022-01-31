import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.os.Build.VERSION;
import com.tencent.biz.qqcircle.transition.QCircleTransitionLayout;

public class uav
  implements Animator.AnimatorListener
{
  public uav(QCircleTransitionLayout paramQCircleTransitionLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.a.setBackground(null);
      return;
    }
    this.a.setBackgroundColor(0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QCircleTransitionLayout.a(this.a) != null) {
      QCircleTransitionLayout.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uav
 * JD-Core Version:    0.7.0.1
 */