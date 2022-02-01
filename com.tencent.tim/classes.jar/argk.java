import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.widget.PaFlashLightView;
import com.tencent.mobileqq.widget.PaFlashLightView.a;

public class argk
  implements Animation.AnimationListener
{
  public argk(PaFlashLightView paramPaFlashLightView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.daw = false;
    if (this.a.mIndex == 0) {
      this.a.a.sendEmptyMessage(0);
    }
    if (this.a.mIndex == 2) {
      this.a.a.sendEmptyMessage(2);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     argk
 * JD-Core Version:    0.7.0.1
 */