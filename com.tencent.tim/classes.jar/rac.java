import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.NewMessageYellowBar;

public class rac
  implements Animation.AnimationListener
{
  public rac(NewMessageYellowBar paramNewMessageYellowBar) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.this$0.mTextView.setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rac
 * JD-Core Version:    0.7.0.1
 */