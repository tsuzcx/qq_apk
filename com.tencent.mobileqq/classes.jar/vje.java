import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.qqstory.playvideo.StoryPlayerActivity;

public class vje
  extends AnimatorListenerAdapter
{
  public vje(StoryPlayerActivity paramStoryPlayerActivity) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    StoryPlayerActivity.a(this.a);
    StoryPlayerActivity.a(this.a, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vje
 * JD-Core Version:    0.7.0.1
 */