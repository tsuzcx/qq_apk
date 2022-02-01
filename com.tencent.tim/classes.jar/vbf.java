import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;

public class vbf
  implements Animation.AnimationListener
{
  public vbf(FriendProfileImageActivity paramFriendProfileImageActivity, TextView paramTextView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.val$textView.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (!this.this$0.animated) {
      this.val$textView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vbf
 * JD-Core Version:    0.7.0.1
 */