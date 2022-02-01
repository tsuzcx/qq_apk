import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.qqcircle.comment.QCircleCommentBottomBar;

public class vht
  implements Animation.AnimationListener
{
  public vht(QCircleCommentBottomBar paramQCircleCommentBottomBar) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    QCircleCommentBottomBar.a(this.a);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vht
 * JD-Core Version:    0.7.0.1
 */