import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.RewardNoticeActivity;

class vsi
  implements Animation.AnimationListener
{
  vsi(vsh paramvsh) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.ra.clearAnimation();
    this.a.a.hf.setVisibility(8);
    this.a.a.he.setVisibility(0);
    this.a.a.bVh();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vsi
 * JD-Core Version:    0.7.0.1
 */