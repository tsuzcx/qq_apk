import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView.UIHandler;
import com.tencent.mobileqq.troop.widget.NearbyTroopsMapView;

public class esb
  implements Animation.AnimationListener
{
  public esb(NearbyTroopsMapView paramNearbyTroopsMapView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.a != null)
    {
      this.a.a.sendEmptyMessage(5);
      this.a.a.sendEmptyMessage(7);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     esb
 * JD-Core Version:    0.7.0.1
 */