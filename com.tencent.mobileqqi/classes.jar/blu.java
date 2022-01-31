import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.widget.RotateLayout;

public class blu
  implements Animation.AnimationListener
{
  public blu(VideoLayerUI paramVideoLayerUI) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     blu
 * JD-Core Version:    0.7.0.1
 */