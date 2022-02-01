import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.widgets.QCircleDoublePraiseView;
import com.tencent.qphone.base.util.QLog;

public class pex
  implements Animation.AnimationListener
{
  public pex(QCircleDoublePraiseView paramQCircleDoublePraiseView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    QCircleDoublePraiseView.a(this.b).setVisibility(8);
    QCircleDoublePraiseView.a(this.b, false);
    QLog.d("QCircleDoublePraiseView", 1, "onAnimationEnd");
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    QCircleDoublePraiseView.a(this.b, true);
    QLog.d("QCircleDoublePraiseView", 1, "onAnimationStart");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pex
 * JD-Core Version:    0.7.0.1
 */