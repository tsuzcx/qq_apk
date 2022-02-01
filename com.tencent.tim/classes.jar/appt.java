import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

public class appt
  implements Animation.AnimationListener
{
  public appt(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.this$0.gt == null) {
      return;
    }
    if (paramAnimation == this.this$0.B) {
      VisitorTroopCardFragment.a(this.this$0, false);
    }
    this.this$0.gt.clearAnimation();
    this.this$0.gt.setFocusable(true);
    this.this$0.e.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((this.this$0.gt != null) && (paramAnimation == this.this$0.A)) {
      VisitorTroopCardFragment.a(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     appt
 * JD-Core Version:    0.7.0.1
 */