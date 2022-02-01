import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;

public class ayls
  extends AnimatorListenerAdapter
{
  public ayls(DoodleEditView paramDoodleEditView, ayoo.a parama) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ram.d("DoodleEditView", "onAnimationEnd");
    this.d.FL = 1.0F;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ram.d("DoodleEditView", "onAnimationStart");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayls
 * JD-Core Version:    0.7.0.1
 */