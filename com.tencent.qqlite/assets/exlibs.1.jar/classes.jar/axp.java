import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;

public class axp
  implements Animation.AnimationListener
{
  public axp(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    NearbyPeopleProfileActivity.a(this.a).setVisibility(0);
    NearbyPeopleProfileActivity.j(this.a);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     axp
 * JD-Core Version:    0.7.0.1
 */