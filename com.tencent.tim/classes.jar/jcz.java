import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.QavPanel.e;

public class jcz
  implements Animator.AnimatorListener
{
  public jcz(QavPanel paramQavPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QavPanel.a(this.this$0))
    {
      paramAnimator = this.this$0.mApp.b().b();
      paramAnimator.O("tryPlayBtnMuteAnimation onAnimationEnd", true);
      paramAnimator.Z("tryPlayBtnMuteAnimation onAnimationEnd", 1);
      this.this$0.a("tryPlayBtnMuteAnimation onAnimationEnd", 2, 1, false);
      return;
    }
    this.this$0.mApp.b().V("tryPlayBtnMuteAnimation onAnimationEnd", 1);
    this.this$0.a("tryPlayBtnMuteAnimation onAnimationEnd", 2, 1, false);
    QavPanel.a(this.this$0).K(false, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    QavPanel.a(this.this$0).lg(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jcz
 * JD-Core Version:    0.7.0.1
 */