import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

public class vxq
  implements Animation.AnimationListener
{
  public vxq(TroopChatPie paramTroopChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.d.setBackgroundResource(2130841202);
    this.a.a.setBackgroundResource(2130841208);
    this.a.q.setVisibility(8);
    this.a.r.setVisibility(8);
    this.a.o.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.q.setVisibility(0);
    this.a.r.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vxq
 * JD-Core Version:    0.7.0.1
 */