import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.qqcircle.widgets.QCircleRockeyPopupView;

public class phd
  implements Animation.AnimationListener
{
  public phd(QCircleRockeyPopupView paramQCircleRockeyPopupView, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.nU.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     phd
 * JD-Core Version:    0.7.0.1
 */