import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

public class vah
  extends auqs.a
{
  public vah(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.this$0.centerView == null) {
      return;
    }
    if (paramAnimation == FriendProfileCardActivity.b(this.this$0)) {
      this.this$0.AS(1);
    }
    this.this$0.centerView.clearAnimation();
    this.this$0.g.clearAnimation();
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (this.this$0.centerView == null) {}
    while (paramAnimation != FriendProfileCardActivity.a(this.this$0)) {
      return;
    }
    this.this$0.AS(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vah
 * JD-Core Version:    0.7.0.1
 */