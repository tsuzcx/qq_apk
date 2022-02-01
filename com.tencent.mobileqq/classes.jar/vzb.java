import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.widgets.QCircleDoublePraiseView;
import com.tencent.qphone.base.util.QLog;

public class vzb
  implements Animation.AnimationListener
{
  public vzb(QCircleDoublePraiseView paramQCircleDoublePraiseView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    QCircleDoublePraiseView.a(this.a).setVisibility(8);
    QCircleDoublePraiseView.a(this.a, false);
    QLog.d("QCircleDoublePraiseView", 1, "onAnimationEnd");
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    QCircleDoublePraiseView.a(this.a, true);
    QLog.d("QCircleDoublePraiseView", 1, "onAnimationStart");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vzb
 * JD-Core Version:    0.7.0.1
 */