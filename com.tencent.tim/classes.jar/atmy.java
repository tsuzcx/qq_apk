import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.tim.cloudfile.wps.WpsFilePreviewFragment;

public class atmy
  implements Animation.AnimationListener
{
  public atmy(WpsFilePreviewFragment paramWpsFilePreviewFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (WpsFilePreviewFragment.c(this.a) != null) {
      WpsFilePreviewFragment.c(this.a).setVisibility(0);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atmy
 * JD-Core Version:    0.7.0.1
 */