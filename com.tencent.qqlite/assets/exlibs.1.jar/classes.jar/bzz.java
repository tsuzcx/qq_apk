import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.widget.XPanelContainer;

public class bzz
  implements Animation.AnimationListener
{
  public bzz(TroopChatPie paramTroopChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.e.setVisibility(8);
    this.a.f.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.e.setVisibility(0);
    this.a.f.setVisibility(0);
    TroopChatPie.b(this.a).setBackgroundDrawable(TroopChatPie.O(this.a).a.a);
    TroopChatPie.b(this.a).setBackgroundResource(2130839257);
    TroopChatPie.a(this.a).setBackgroundResource(2130839181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bzz
 * JD-Core Version:    0.7.0.1
 */