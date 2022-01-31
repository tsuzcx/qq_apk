import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;

public class apa
  implements Animation.AnimationListener
{
  public apa(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.c = false;
    this.a.finish();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     apa
 * JD-Core Version:    0.7.0.1
 */