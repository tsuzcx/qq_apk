import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.subscribe.comment.CommentBottomBar;

public class yfn
  implements Animation.AnimationListener
{
  public yfn(CommentBottomBar paramCommentBottomBar) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    CommentBottomBar.a(this.a, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yfn
 * JD-Core Version:    0.7.0.1
 */