import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.contact.troop.BaseTroopView;

public class ccz
  implements Animation.AnimationListener
{
  public ccz(BaseTroopView paramBaseTroopView, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.c.setAnimation(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.c.offsetTopAndBottom(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.c.requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ccz
 * JD-Core Version:    0.7.0.1
 */