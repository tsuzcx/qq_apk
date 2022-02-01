import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qqmini.proxyimpl.KingCardProxyImpl.1;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.UpdateUIActionBridge;

public class asup
  implements Animator.AnimatorListener
{
  public asup(KingCardProxyImpl.1 param1) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ActionBridge.UpdateUIActionBridge.updateRedDot(this.a.val$miniAppContext);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ActionBridge.UpdateUIActionBridge.updateRedDot(this.a.val$miniAppContext);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asup
 * JD-Core Version:    0.7.0.1
 */