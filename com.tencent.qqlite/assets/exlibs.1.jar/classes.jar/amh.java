import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;

public class amh
  implements DialogInterface.OnDismissListener
{
  public amh(ForwardFriendListActivity paramForwardFriendListActivity, int paramInt, TranslateAnimation paramTranslateAnimation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardFriendListActivity.jdField_a_of_type_AndroidWidgetLinearLayout.offsetTopAndBottom(-this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardFriendListActivity.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardFriendListActivity.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    ForwardFriendListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardFriendListActivity, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     amh
 * JD-Core Version:    0.7.0.1
 */