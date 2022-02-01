import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

public class yev
  implements Animation.AnimationListener
{
  public yev(TroopChatPie paramTroopChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.cL.setBackgroundResource(2130844446);
    this.this$0.a.setBackgroundResource(2130844452);
    this.this$0.xE.setVisibility(8);
    this.this$0.xF.setVisibility(8);
    this.this$0.xC.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.this$0.xE.setVisibility(0);
    this.this$0.xF.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yev
 * JD-Core Version:    0.7.0.1
 */