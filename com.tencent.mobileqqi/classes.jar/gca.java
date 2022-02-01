import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.maproam.widget.RoamLocalSearchBar;

public class gca
  implements Animation.AnimationListener
{
  public gca(RoamLocalSearchBar paramRoamLocalSearchBar, View paramView, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidViewView.requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gca
 * JD-Core Version:    0.7.0.1
 */