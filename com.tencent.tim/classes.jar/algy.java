import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.profile.view.ProfileTagView;

public class algy
  extends AnimatorListenerAdapter
{
  public algy(ProfileTagView paramProfileTagView, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.this$0;
    paramAnimator.dtt -= 1;
    this.hI.setVisibility(4);
    this.hI.setTranslationX(0.0F);
    this.hI.setTranslationY(0.0F);
    this.this$0.cwK = false;
    if (this.this$0.dtt == 0) {
      this.this$0.atB();
    }
    ((FriendProfileCardActivity)this.this$0.mActivity).bOy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     algy
 * JD-Core Version:    0.7.0.1
 */