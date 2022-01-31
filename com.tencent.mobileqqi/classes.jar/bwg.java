import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.common.galleryactivity.GalleryPageView;

public class bwg
  implements Animation.AnimationListener
{
  public bwg(GalleryPageView paramGalleryPageView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.clearAnimation();
    this.a.a.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bwg
 * JD-Core Version:    0.7.0.1
 */