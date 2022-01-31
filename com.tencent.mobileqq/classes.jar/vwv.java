import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;

public class vwv
  implements Animation.AnimationListener
{
  public vwv(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.p = 5;
    PublicAccountChatPie.c(this.a).post(new vww(this));
    this.a.a.sendEmptyMessage(1);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vwv
 * JD-Core Version:    0.7.0.1
 */