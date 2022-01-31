import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

public class dwn
  implements Animation.AnimationListener
{
  public dwn(TroopMemberListActivity paramTroopMemberListActivity, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.b) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dwn
 * JD-Core Version:    0.7.0.1
 */