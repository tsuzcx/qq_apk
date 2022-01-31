import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.qqcircle.widgets.QCircleRockeyPopupView;

public class uct
  implements Animation.AnimationListener
{
  public uct(QCircleRockeyPopupView paramQCircleRockeyPopupView, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uct
 * JD-Core Version:    0.7.0.1
 */