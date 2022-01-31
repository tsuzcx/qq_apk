import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;

class xjg
  implements Animation.AnimationListener
{
  xjg(xjf paramxjf) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.c.setVisibility(0);
    this.a.a.c.clearAnimation();
    this.a.a.c.setAnimation(null);
    this.a.a.a.invalidate();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xjg
 * JD-Core Version:    0.7.0.1
 */