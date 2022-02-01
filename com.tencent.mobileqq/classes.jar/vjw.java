import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.qqcircle.comment.QCircleCommentBottomBar;

public class vjw
  implements Animation.AnimationListener
{
  public vjw(QCircleCommentBottomBar paramQCircleCommentBottomBar) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QCircleCommentBottomBar.a(this.a) != null) {
      QCircleCommentBottomBar.a(this.a).startAnimation(QCircleCommentBottomBar.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjw
 * JD-Core Version:    0.7.0.1
 */