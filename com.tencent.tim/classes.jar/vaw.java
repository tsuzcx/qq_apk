import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;

public class vaw
  implements Animation.AnimationListener
{
  public vaw(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.animated = false;
    this.this$0.finish();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vaw
 * JD-Core Version:    0.7.0.1
 */