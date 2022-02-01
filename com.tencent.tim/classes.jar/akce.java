import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

public class akce
  implements Animation.AnimationListener
{
  public akce(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.this$0;
    paramAnimation.dmw += 1;
    if (NearbyPeopleProfileActivity.a(this.this$0) != null) {
      NearbyPeopleProfileActivity.a(this.this$0).b(NearbyPeopleProfileActivity.a(this.this$0));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akce
 * JD-Core Version:    0.7.0.1
 */