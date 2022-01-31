import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.bubble.ChatXListView;

public class wca
  implements Animator.AnimatorListener
{
  public wca(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a.removeHeaderView(PublicAccountChatPie.a(this.a));
    PublicAccountChatPie.a(this.a, true);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wca
 * JD-Core Version:    0.7.0.1
 */