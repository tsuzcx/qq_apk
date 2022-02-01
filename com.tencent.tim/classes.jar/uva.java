import android.app.Dialog;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;

public class uva
  implements Animation.AnimationListener
{
  public uva(DiscussionMemberActivity paramDiscussionMemberActivity, TranslateAnimation paramTranslateAnimation1, Dialog paramDialog, TranslateAnimation paramTranslateAnimation2, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.q)
    {
      this.n.show();
      this.a.mRootView.setAnimation(null);
      DiscussionMemberActivity.a(this.a).setVisibility(8);
    }
    while (paramAnimation != this.c) {
      return;
    }
    this.a.mRootView.setAnimation(null);
    this.a.mRootView.offsetTopAndBottom(this.dS);
    this.a.mRootView.requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uva
 * JD-Core Version:    0.7.0.1
 */