import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.troop.widget.NearbyTroopsMapView;

public class eqj
  implements Animation.AnimationListener
{
  public eqj(NearbyTroopsMapView paramNearbyTroopsMapView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.showNearestPopView();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eqj
 * JD-Core Version:    0.7.0.1
 */