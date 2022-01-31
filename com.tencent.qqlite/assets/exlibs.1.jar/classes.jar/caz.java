import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.widget.XPanelContainer;

public class caz
  implements Animation.AnimationListener
{
  public caz(TroopChatPie paramTroopChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    TroopChatPie.a(this.a).setBackgroundResource(2130838407);
    TroopChatPie.a(this.a).setBackgroundResource(2130838407);
    this.a.f.setVisibility(8);
    this.a.g.setVisibility(8);
    this.a.d.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.f.setVisibility(0);
    this.a.g.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     caz
 * JD-Core Version:    0.7.0.1
 */