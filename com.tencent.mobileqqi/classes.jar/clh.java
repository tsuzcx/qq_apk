import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;

public class clh
  implements DialogInterface.OnDismissListener
{
  public clh(ForwardFriendListActivity paramForwardFriendListActivity, int paramInt, TranslateAnimation paramTranslateAnimation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardFriendListActivity.a.offsetTopAndBottom(-this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardFriendListActivity.a.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    ForwardFriendListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardFriendListActivity, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     clh
 * JD-Core Version:    0.7.0.1
 */