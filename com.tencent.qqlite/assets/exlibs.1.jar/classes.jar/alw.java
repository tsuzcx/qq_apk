import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.EmosmDetailActivity;

public class alw
  implements Animation.AnimationListener
{
  public alw(EmosmDetailActivity paramEmosmDetailActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.d = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     alw
 * JD-Core Version:    0.7.0.1
 */