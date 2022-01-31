import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.qqstory.playvideo.StoryPlayerActivity;

public class tht
  extends AnimatorListenerAdapter
{
  public tht(StoryPlayerActivity paramStoryPlayerActivity) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    StoryPlayerActivity.a(this.a);
    StoryPlayerActivity.a(this.a, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tht
 * JD-Core Version:    0.7.0.1
 */