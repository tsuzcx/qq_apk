import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.content.res.Resources;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;

public class pdv
  implements Animator.AnimatorListener
{
  public pdv(QCircleSlidBottomView paramQCircleSlidBottomView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.b.getContext() != null) {
      ovd.k((Activity)this.b.getContext(), this.b.getResources().getColor(2131166509));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pdv
 * JD-Core Version:    0.7.0.1
 */