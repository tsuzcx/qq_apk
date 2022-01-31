import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

class wty
  implements Animation.AnimationListener
{
  wty(wtw paramwtw) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    wtw.b(this.a).setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wty
 * JD-Core Version:    0.7.0.1
 */