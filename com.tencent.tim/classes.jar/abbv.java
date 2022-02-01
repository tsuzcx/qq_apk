import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;

public class abbv
  implements Animation.AnimationListener
{
  public abbv(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.nn.clearAnimation();
    ((FrameLayout)this.this$0.getWindow().getDecorView()).removeView(this.this$0.nn);
    this.this$0.nn = null;
    if (this.this$0.d != null)
    {
      this.this$0.d.destroy();
      this.this$0.d = null;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abbv
 * JD-Core Version:    0.7.0.1
 */