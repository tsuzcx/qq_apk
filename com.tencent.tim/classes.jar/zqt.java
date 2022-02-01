import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.phone.NewStyleCountryActivity;
import com.tencent.mobileqq.activity.phone.NewStyleCountryActivity.d;

public class zqt
  implements Animation.AnimationListener
{
  public zqt(NewStyleCountryActivity paramNewStyleCountryActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!this.a.isFinishing())
    {
      this.a.a.show();
      this.a.rootView.setAnimation(null);
      this.a.yg.setVisibility(8);
      NewStyleCountryActivity.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zqt
 * JD-Core Version:    0.7.0.1
 */