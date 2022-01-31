import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.activity.contact.CircleMemberListActivity;

public class eig
  implements DialogInterface.OnDismissListener
{
  public eig(CircleMemberListActivity paramCircleMemberListActivity, int paramInt, TranslateAnimation paramTranslateAnimation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactCircleMemberListActivity.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(-this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactCircleMemberListActivity.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactCircleMemberListActivity.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eig
 * JD-Core Version:    0.7.0.1
 */