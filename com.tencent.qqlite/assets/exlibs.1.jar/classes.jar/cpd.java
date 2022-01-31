import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;

public class cpd
  implements Animation.AnimationListener
{
  public cpd(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ShortVideoPlayActivity.a(this.a, true);
    ShortVideoPlayActivity.a(this.a).setVisibility(4);
    ShortVideoPlayActivity.b(this.a).setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cpd
 * JD-Core Version:    0.7.0.1
 */