import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.a;

public class pdw
  implements Animator.AnimatorListener
{
  public pdw(QCircleSlidBottomView paramQCircleSlidBottomView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.b.getContext() != null) {
      ovd.bc((Activity)this.b.getContext());
    }
    if (QCircleSlidBottomView.a(this.b) != null) {
      QCircleSlidBottomView.a(this.b).onDismiss();
    }
    this.b.setVisibility(8);
    QCircleSlidBottomView.a(this.b, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    QCircleSlidBottomView.a(this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pdw
 * JD-Core Version:    0.7.0.1
 */