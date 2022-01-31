import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;

public class axq
  implements Animation.AnimationListener
{
  public axq(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    NearbyPeopleProfileActivity.a(this.a).setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     axq
 * JD-Core Version:    0.7.0.1
 */