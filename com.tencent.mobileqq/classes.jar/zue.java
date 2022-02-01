import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.subscribe.comment.CommentBottomBar;

public class zue
  implements Animation.AnimationListener
{
  public zue(CommentBottomBar paramCommentBottomBar) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    CommentBottomBar.a(this.a, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zue
 * JD-Core Version:    0.7.0.1
 */