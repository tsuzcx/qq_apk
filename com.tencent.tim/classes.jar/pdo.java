import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.os.Build.VERSION;
import com.tencent.biz.qqcircle.transition.QCircleTransitionLayout;
import com.tencent.biz.qqcircle.transition.QCircleTransitionLayout.a;

public class pdo
  implements Animator.AnimatorListener
{
  public pdo(QCircleTransitionLayout paramQCircleTransitionLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.c.setBackground(null);
      return;
    }
    this.c.setBackgroundColor(0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QCircleTransitionLayout.a(this.c) != null) {
      QCircleTransitionLayout.a(this.c).bjn();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pdo
 * JD-Core Version:    0.7.0.1
 */