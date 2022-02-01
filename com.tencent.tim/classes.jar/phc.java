import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.qqcircle.widgets.QCircleRockeyPopupView;

public class phc
  implements Animation.AnimationListener
{
  public phc(QCircleRockeyPopupView paramQCircleRockeyPopupView, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.nU.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     phc
 * JD-Core Version:    0.7.0.1
 */