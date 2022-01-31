import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;

public class coa
  implements Animation.AnimationListener
{
  public coa(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ShortVideoPlayActivity.a(this.a).setVisibility(0);
    ShortVideoPlayActivity.b(this.a).setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     coa
 * JD-Core Version:    0.7.0.1
 */