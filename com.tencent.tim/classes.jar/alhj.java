import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.profile.view.VipProfileSimpleView;

public class alhj
  implements Animation.AnimationListener
{
  public alhj(VipProfileSimpleView paramVipProfileSimpleView, alcn paramalcn) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    VipProfileSimpleView.a(this.a, true);
    this.a.l(this.b);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alhj
 * JD-Core Version:    0.7.0.1
 */