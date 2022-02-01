import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.weishi_new.follow.joinGroup.BottomDialog.3.1;

public class vcj
  implements Animation.AnimationListener
{
  vcj(vcg paramvcg) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    vcg.a(this.a, false);
    vcg.a(this.a).post(new BottomDialog.3.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    vcg.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcj
 * JD-Core Version:    0.7.0.1
 */