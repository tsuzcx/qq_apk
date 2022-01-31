import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.anim.friendship.FriendShipViewManager;

public class ulk
  implements Runnable
{
  public ulk(FriendShipViewManager paramFriendShipViewManager) {}
  
  public void run()
  {
    if (this.a.a != null)
    {
      this.a.a.setBackgroundColor(-1442840576);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(300L);
      this.a.a.startAnimation(localAlphaAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ulk
 * JD-Core Version:    0.7.0.1
 */