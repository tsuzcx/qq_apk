import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import java.util.List;

class veh
  implements Animator.AnimatorListener
{
  veh(veg paramveg, DiniFlyAnimationView paramDiniFlyAnimationView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.removeAnimatorListener(this);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    veg.a(this.jdField_a_of_type_Veg).removeView(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.removeAnimatorListener(this);
    veg.a(this.jdField_a_of_type_Veg).remove(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     veh
 * JD-Core Version:    0.7.0.1
 */