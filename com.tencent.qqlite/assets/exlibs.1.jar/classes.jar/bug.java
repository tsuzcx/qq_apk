import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.ViewGroup;

class bug
  implements Animator.AnimatorListener
{
  bug(buf parambuf, ViewGroup paramViewGroup) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bug
 * JD-Core Version:    0.7.0.1
 */