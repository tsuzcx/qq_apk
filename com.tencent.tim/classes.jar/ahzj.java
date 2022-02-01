import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpic.HotPicPageView.c;

public class ahzj
  implements Animation.AnimationListener
{
  public ahzj(HotPicPageView.c paramc) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.c.mPlayState == 3) {
      this.c.imageView.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahzj
 * JD-Core Version:    0.7.0.1
 */