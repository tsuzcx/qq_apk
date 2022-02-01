import android.app.Dialog;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

public class wbt
  implements Animation.AnimationListener
{
  public wbt(TroopMemberListActivity paramTroopMemberListActivity, TranslateAnimation paramTranslateAnimation1, TranslateAnimation paramTranslateAnimation2, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.q)
    {
      this.this$0.W.show();
      this.this$0.mRootView.setAnimation(null);
      this.this$0.mTitleBar.setVisibility(8);
    }
    while (paramAnimation != this.c) {
      return;
    }
    this.this$0.mRootView.setAnimation(null);
    this.this$0.mRootView.offsetTopAndBottom(this.dS);
    this.this$0.mRootView.requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wbt
 * JD-Core Version:    0.7.0.1
 */