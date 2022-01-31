import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class wvn
  extends AnimatorListenerAdapter
{
  wvn(wvm paramwvm, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    wsv.b("Q.qqstory.record.EditVideoFragment", "resetAnimator cancel!");
    this.jdField_a_of_type_AndroidViewView.setTag(new Boolean(false));
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    wsv.c("Q.qqstory.record.EditVideoFragment", "resetAnimator end!");
    this.jdField_a_of_type_AndroidViewView.setTag(new Boolean(false));
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    wsv.c("Q.qqstory.record.EditVideoFragment", "resetAnimator start!");
    this.jdField_a_of_type_AndroidViewView.setTag(new Boolean(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wvn
 * JD-Core Version:    0.7.0.1
 */