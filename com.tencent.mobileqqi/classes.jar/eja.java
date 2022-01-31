import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.activity.contact.newfriend.CircleGroupListView;

public class eja
  implements Animation.AnimationListener
{
  public eja(CircleGroupListView paramCircleGroupListView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.show();
    this.a.b.setAnimation(null);
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eja
 * JD-Core Version:    0.7.0.1
 */