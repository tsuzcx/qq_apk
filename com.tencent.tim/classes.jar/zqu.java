import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.phone.NewStyleCountryActivity;

public class zqu
  implements Animation.AnimationListener
{
  public zqu(NewStyleCountryActivity paramNewStyleCountryActivity, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.rootView.setAnimation(null);
    this.a.rootView.offsetTopAndBottom(this.dS);
    this.a.rootView.requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zqu
 * JD-Core Version:    0.7.0.1
 */