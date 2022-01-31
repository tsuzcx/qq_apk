import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.contact.newfriend.CircleGroupListView;

public class edy
  implements Animation.AnimationListener
{
  public edy(CircleGroupListView paramCircleGroupListView, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendCircleGroupListView.b.setAnimation(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendCircleGroupListView.b.offsetTopAndBottom(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendCircleGroupListView.b.requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     edy
 * JD-Core Version:    0.7.0.1
 */