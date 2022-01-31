import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.contact.CircleMemberListActivity;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;

public class eie
  implements Animation.AnimationListener
{
  public eie(CircleMemberListActivity paramCircleMemberListActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.show();
    this.a.jdField_a_of_type_AndroidViewView.setAnimation(null);
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eie
 * JD-Core Version:    0.7.0.1
 */