import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginAnimBtnView;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;

public class aamw
  implements Animator.AnimatorListener
{
  public aamw(LoginView paramLoginView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    LoginView.c(this.this$0, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    LoginView.a(this.this$0, LoginView.b(this.this$0), LoginView.d(this.this$0), LoginView.f(this.this$0), LoginView.h(this.this$0), 1.0F);
    if (this.this$0.a != null) {
      this.this$0.a.cvt();
    }
    LoginView.c(this.this$0, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aamw
 * JD-Core Version:    0.7.0.1
 */