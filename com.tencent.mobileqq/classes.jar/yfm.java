import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.subscribe.comment.CommentBottomBar;

public class yfm
  implements Animation.AnimationListener
{
  public yfm(CommentBottomBar paramCommentBottomBar, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!this.jdField_a_of_type_Boolean) {
      CommentBottomBar.b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yfm
 * JD-Core Version:    0.7.0.1
 */