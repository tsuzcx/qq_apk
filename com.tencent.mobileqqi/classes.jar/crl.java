import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.EmosmDetailActivity;

public class crl
  implements Animation.AnimationListener
{
  public crl(EmosmDetailActivity paramEmosmDetailActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    EmosmDetailActivity.b(this.a, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.b.setVisibility(0);
    paramAnimation = (RelativeLayout.LayoutParams)this.a.a.getLayoutParams();
    paramAnimation.height = (this.a.a.getHeight() - this.a.b.getHeight());
    this.a.a.setLayoutParams(paramAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     crl
 * JD-Core Version:    0.7.0.1
 */