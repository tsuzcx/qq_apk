import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;

class vpv
  implements Animation.AnimationListener
{
  vpv(vpu paramvpu) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.a.q != null)
    {
      paramAnimation = AnimationUtils.loadAnimation(this.a.a.a, 2131034320);
      paramAnimation.setAnimationListener(this);
      this.a.a.q.startAnimation(paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vpv
 * JD-Core Version:    0.7.0.1
 */