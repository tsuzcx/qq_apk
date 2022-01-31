import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import cooperation.qqfav.widget.LocationDetailActivity;

public class igf
  implements Animation.AnimationListener
{
  public igf(LocationDetailActivity paramLocationDetailActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.h.clearAnimation();
    this.a.h.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     igf
 * JD-Core Version:    0.7.0.1
 */