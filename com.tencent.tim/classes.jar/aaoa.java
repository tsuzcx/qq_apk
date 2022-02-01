import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.activity.registerGuideLogin.TimLoginQQView;

public class aaoa
  implements Animator.AnimatorListener
{
  public aaoa(TimLoginQQView paramTimLoginQQView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    TimLoginQQView.c(this.this$0, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    TimLoginQQView.a(this.this$0, TimLoginQQView.b(this.this$0), TimLoginQQView.d(this.this$0), TimLoginQQView.f(this.this$0), TimLoginQQView.h(this.this$0), 1.0F);
    TimLoginQQView.c(this.this$0, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaoa
 * JD-Core Version:    0.7.0.1
 */