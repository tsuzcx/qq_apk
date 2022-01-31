import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.widget.AntiphingToast;

public class ezs
  implements Animation.AnimationListener
{
  public ezs(AntiphingToast paramAntiphingToast) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AntiphingToast.a(this.a, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ezs
 * JD-Core Version:    0.7.0.1
 */