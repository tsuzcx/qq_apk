import android.os.AsyncTask;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;

public class vav
  implements Animation.AnimationListener
{
  public vav(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.c.execute(new Void[0]);
    this.this$0.animated = false;
    if (this.this$0.aWI) {
      this.this$0.qb.setVisibility(8);
    }
    while (this.this$0.aWH) {
      return;
    }
    this.this$0.qb.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vav
 * JD-Core Version:    0.7.0.1
 */