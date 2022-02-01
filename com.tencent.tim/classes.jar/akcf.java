import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

public class akcf
  implements Animation.AnimationListener
{
  public akcf(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    NearbyPeopleProfileActivity.a(this.this$0).removeView(NearbyPeopleProfileActivity.a(this.this$0));
    NearbyPeopleProfileActivity.a(this.this$0).dzo();
    NearbyPeopleProfileActivity.a(this.this$0, null);
    NearbyPeopleProfileActivity.a(this.this$0, null);
    if (NearbyPeopleProfileActivity.a(this.this$0) == null)
    {
      NearbyPeopleProfileActivity.a(this.this$0, this.this$0.a(this.this$0.from));
      NearbyPeopleProfileActivity.b(this.this$0, NearbyPeopleProfileActivity.a(this.this$0).getContentView());
      NearbyPeopleProfileActivity.a(this.this$0).dAH();
      NearbyPeopleProfileActivity.a(this.this$0).addView(NearbyPeopleProfileActivity.b(this.this$0), new FrameLayout.LayoutParams(-1, -1));
    }
    NearbyPeopleProfileActivity.a(this.this$0).b(NearbyPeopleProfileActivity.a(this.this$0));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akcf
 * JD-Core Version:    0.7.0.1
 */