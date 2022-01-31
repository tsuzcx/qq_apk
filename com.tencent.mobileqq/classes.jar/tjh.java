import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.QQSettingMe;

class tjh
  implements Animator.AnimatorListener
{
  tjh(tjg paramtjg) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QQSettingMe.a(this.a.a) != null) {
      QQSettingMe.a(this.a.a).setVisibility(4);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tjh
 * JD-Core Version:    0.7.0.1
 */