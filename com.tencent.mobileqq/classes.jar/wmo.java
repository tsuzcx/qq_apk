import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.subscribe.comment.CommentBottomBar;

public class wmo
  implements Animation.AnimationListener
{
  public wmo(CommentBottomBar paramCommentBottomBar) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    CommentBottomBar.a(this.a, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wmo
 * JD-Core Version:    0.7.0.1
 */