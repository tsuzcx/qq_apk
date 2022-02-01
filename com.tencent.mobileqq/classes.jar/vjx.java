import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.qqcircle.comment.QCircleCommentBottomBar;

public class vjx
  implements Animation.AnimationListener
{
  public vjx(QCircleCommentBottomBar paramQCircleCommentBottomBar) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    QCircleCommentBottomBar.a(this.a);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjx
 * JD-Core Version:    0.7.0.1
 */