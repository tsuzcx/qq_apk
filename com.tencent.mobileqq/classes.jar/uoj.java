import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.weishi_new.follow.joinGroup.BottomDialog.3.1;

public class uoj
  implements Animation.AnimationListener
{
  uoj(uog paramuog) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    uog.a(this.a, false);
    uog.a(this.a).post(new BottomDialog.3.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    uog.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uoj
 * JD-Core Version:    0.7.0.1
 */