import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity.4.1;

public class ajuo
  implements Animation.AnimationListener
{
  public ajuo(ChooseInterestTagActivity paramChooseInterestTagActivity, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ChooseInterestTagActivity.a(this.this$0).postDelayed(new ChooseInterestTagActivity.4.1(this), 100L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajuo
 * JD-Core Version:    0.7.0.1
 */