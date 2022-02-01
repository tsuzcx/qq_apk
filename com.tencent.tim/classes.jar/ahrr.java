import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.gamecenter.view.FullPopVideoView.a;

public class ahrr
  extends ahrq
  implements FullPopVideoView.a
{
  private void dpt()
  {
    this.Aj.setVisibility(8);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 0.0F, 1, 0.3F);
    localScaleAnimation.setDuration(300L);
    localScaleAnimation.setAnimationListener(new ahrs(this));
    this.bI.startAnimation(localScaleAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahrr
 * JD-Core Version:    0.7.0.1
 */