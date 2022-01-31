import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryDownloadView.5.1;

public class vay
  extends AnimatorListenerAdapter
{
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a) {
      new Handler().postDelayed(new StoryDownloadView.5.1(this), 1200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vay
 * JD-Core Version:    0.7.0.1
 */