import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView.4;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;

public class aanl
  implements Animation.AnimationListener
{
  public aanl(LoginView.4 param4) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.this$0.rn.setVisibility(0);
    this.a.this$0.rn.clearAnimation();
    this.a.this$0.rn.setAnimation(null);
    this.a.this$0.a.invalidate();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aanl
 * JD-Core Version:    0.7.0.1
 */