import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.widget.PaFlashLightView;
import com.tencent.mobileqq.widget.PaFlashLightView.a;

public class argl
  implements Animation.AnimationListener
{
  public argl(PaFlashLightView paramPaFlashLightView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.daw = false;
    this.a.a.sendEmptyMessage(1);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     argl
 * JD-Core Version:    0.7.0.1
 */