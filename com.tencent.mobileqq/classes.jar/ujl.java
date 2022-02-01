import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import java.util.List;

class ujl
  implements Animator.AnimatorListener
{
  ujl(ujk paramujk, DiniFlyAnimationView paramDiniFlyAnimationView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.removeAnimatorListener(this);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ujk.a(this.jdField_a_of_type_Ujk).removeView(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.removeAnimatorListener(this);
    ujk.a(this.jdField_a_of_type_Ujk).remove(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ujl
 * JD-Core Version:    0.7.0.1
 */