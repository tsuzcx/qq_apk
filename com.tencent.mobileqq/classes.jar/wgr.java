import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;

public class wgr
  implements Animation.AnimationListener
{
  public wgr(QQStoryBaseActivity paramQQStoryBaseActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.c != null)
    {
      this.a.c.clearAnimation();
      ((ViewGroup)((ViewGroup)this.a.findViewById(16908290)).getChildAt(0)).removeView(this.a.c);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wgr
 * JD-Core Version:    0.7.0.1
 */