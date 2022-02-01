import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;

public class qqq
  implements Animation.AnimationListener
{
  public qqq(QQStoryBaseActivity paramQQStoryBaseActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.this$0.mW != null)
    {
      this.this$0.mW.clearAnimation();
      ((ViewGroup)((ViewGroup)this.this$0.findViewById(16908290)).getChildAt(0)).removeView(this.this$0.mW);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqq
 * JD-Core Version:    0.7.0.1
 */