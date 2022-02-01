import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSearchBarView;

public class afyr
  implements Animator.AnimatorListener
{
  public afyr(ExtendFriendSearchBarView paramExtendFriendSearchBarView, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = (FrameLayout.LayoutParams)this.Co.getLayoutParams();
    paramAnimator.topMargin = (-ExtendFriendSearchBarView.a(this.b));
    this.Co.setLayoutParams(paramAnimator);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = (FrameLayout.LayoutParams)this.Co.getLayoutParams();
    paramAnimator.topMargin = (-ExtendFriendSearchBarView.a(this.b));
    this.Co.setLayoutParams(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afyr
 * JD-Core Version:    0.7.0.1
 */