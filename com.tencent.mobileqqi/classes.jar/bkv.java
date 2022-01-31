import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageButton;
import com.tencent.av.ui.VideoControlUI;

public class bkv
  implements Animation.AnimationListener
{
  public bkv(VideoControlUI paramVideoControlUI) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.c.clearAnimation();
    this.a.f.clearAnimation();
    this.a.f.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bkv
 * JD-Core Version:    0.7.0.1
 */