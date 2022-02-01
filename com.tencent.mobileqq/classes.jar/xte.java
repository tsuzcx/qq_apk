import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.tencent.biz.qqstory.playvideo.player.ExploreAnimalView;

public class xte
  implements Animation.AnimationListener
{
  public xte(ExploreAnimalView paramExploreAnimalView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.startAnimation(this.a.b);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xte
 * JD-Core Version:    0.7.0.1
 */