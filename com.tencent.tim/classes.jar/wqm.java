import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditScrollerView;

public class wqm
  implements Animator.AnimatorListener
{
  public wqm(VoiceTextEditScrollerView paramVoiceTextEditScrollerView, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (VoiceTextEditScrollerView.a(this.b) != null)
    {
      if (this.val$type == 0) {
        VoiceTextEditScrollerView.a(this.b).caN();
      }
    }
    else {
      return;
    }
    VoiceTextEditScrollerView.a(this.b).caO();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wqm
 * JD-Core Version:    0.7.0.1
 */