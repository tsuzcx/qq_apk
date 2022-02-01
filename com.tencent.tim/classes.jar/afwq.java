import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment;
import com.tencent.mobileqq.extendfriend.wiget.MatchingView;

public class afwq
  extends AnimatorListenerAdapter
{
  public afwq(ExtendFriendLimitChatMatchFragment paramExtendFriendLimitChatMatchFragment, MatchingView paramMatchingView, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.Cm.setVisibility(4);
    ExtendFriendLimitChatMatchFragment.a(this.this$0, this.Cm);
    this.b.oo();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.b.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afwq
 * JD-Core Version:    0.7.0.1
 */