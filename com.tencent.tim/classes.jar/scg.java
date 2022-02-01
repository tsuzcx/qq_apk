import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.subscribe.comment.CommentBottomBar;

public class scg
  implements Animation.AnimationListener
{
  public scg(CommentBottomBar paramCommentBottomBar) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    CommentBottomBar.a(this.b, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     scg
 * JD-Core Version:    0.7.0.1
 */