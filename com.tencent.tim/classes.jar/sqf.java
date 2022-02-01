import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;

class sqf
  implements Animation.AnimationListener
{
  sqf(sqc paramsqc) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (sqc.a(this.b) != null) {
      sqc.a(this.b).setVisibility(4);
    }
    if (sqc.a(this.b) != null) {
      sqc.a(this.b).setAlpha(1.0F);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sqf
 * JD-Core Version:    0.7.0.1
 */