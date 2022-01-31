import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;

public class ygf
  implements Animation.AnimationListener
{
  public ygf(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.clearAnimation();
    this.a.a.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ygf
 * JD-Core Version:    0.7.0.1
 */