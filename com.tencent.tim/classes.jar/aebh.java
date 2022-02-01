import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.anim.EnterExitAnimHelper.1.1;
import mqq.os.MqqHandler;

public class aebh
  implements Animator.AnimatorListener
{
  aebh(aebg paramaebg, aeei paramaeei, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_b_of_type_Aeei != null) {
      this.jdField_b_of_type_Aeei.onColorNoteAnimFinish();
    }
    if ((this.bSP) && ((paramAnimator instanceof rtp))) {
      ThreadManager.getUIHandler().postDelayed(new EnterExitAnimHelper.1.1(this, paramAnimator), 200L);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aebh
 * JD-Core Version:    0.7.0.1
 */