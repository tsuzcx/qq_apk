import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.widget.AntiphingToast;

public class exm
  implements Animation.AnimationListener
{
  public exm(AntiphingToast paramAntiphingToast) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AntiphingToast.a(this.a, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     exm
 * JD-Core Version:    0.7.0.1
 */