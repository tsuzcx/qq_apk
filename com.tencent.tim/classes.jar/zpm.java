import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;

public class zpm
  implements Animator.AnimatorListener
{
  public zpm(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.this$0.cee = AvatarPendantActivity.cec;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.this$0.cee = AvatarPendantActivity.cea;
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.this$0.cee = AvatarPendantActivity.ced;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zpm
 * JD-Core Version:    0.7.0.1
 */