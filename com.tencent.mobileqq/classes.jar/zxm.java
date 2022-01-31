import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.ar.ARLBSPOIDialog;

public class zxm
  implements Animation.AnimationListener
{
  public zxm(ARLBSPOIDialog paramARLBSPOIDialog) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.setVisibility(8);
    this.a.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zxm
 * JD-Core Version:    0.7.0.1
 */