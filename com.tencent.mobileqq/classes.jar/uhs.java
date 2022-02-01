import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.weishi_new.follow.joinGroup.BottomDialog.3.1;

public class uhs
  implements Animation.AnimationListener
{
  uhs(uhp paramuhp) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    uhp.a(this.a, false);
    uhp.a(this.a).post(new BottomDialog.3.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    uhp.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uhs
 * JD-Core Version:    0.7.0.1
 */