import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.recent.RecentOptionBar;

public class eov
  implements Animation.AnimationListener
{
  public eov(RecentOptionBar paramRecentOptionBar) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    RecentOptionBar.a(this.a).setVisibility(8);
    RecentOptionBar.b(this.a).setVisibility(8);
    RecentOptionBar.b(this.a).setOnClickListener(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eov
 * JD-Core Version:    0.7.0.1
 */