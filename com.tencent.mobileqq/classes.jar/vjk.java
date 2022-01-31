import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity;

public class vjk
  implements Animator.AnimatorListener
{
  public vjk(QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.finish();
    this.a.overridePendingTransition(0, 2130772038);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.finish();
    this.a.overridePendingTransition(0, 2130772038);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vjk
 * JD-Core Version:    0.7.0.1
 */