import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class rcp
  extends AnimatorListenerAdapter
{
  rcp(rco paramrco, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ram.d("Q.qqstory.record.EditVideoFragment", "resetAnimator cancel!");
    this.oI.setTag(new Boolean(false));
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ram.i("Q.qqstory.record.EditVideoFragment", "resetAnimator end!");
    this.oI.setTag(new Boolean(false));
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ram.i("Q.qqstory.record.EditVideoFragment", "resetAnimator start!");
    this.oI.setTag(new Boolean(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rcp
 * JD-Core Version:    0.7.0.1
 */