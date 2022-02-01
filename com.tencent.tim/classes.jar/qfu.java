import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.qqstory.playvideo.StoryPlayerActivity;

public class qfu
  extends AnimatorListenerAdapter
{
  public qfu(StoryPlayerActivity paramStoryPlayerActivity) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    StoryPlayerActivity.a(this.this$0);
    StoryPlayerActivity.a(this.this$0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qfu
 * JD-Core Version:    0.7.0.1
 */