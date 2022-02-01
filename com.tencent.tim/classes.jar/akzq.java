import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.portal.FormalView;

public class akzq
  implements Animator.AnimatorListener
{
  public akzq(FormalView paramFormalView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.this$0.dEv();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.this$0.dEv();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    FormalView.a(this.this$0).setVisibility(0);
    if (this.this$0.dqr == 1)
    {
      FormalView.b(this.this$0).setVisibility(0);
      return;
    }
    FormalView.b(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akzq
 * JD-Core Version:    0.7.0.1
 */