import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ForwardRecentActivity;

public class anz
  implements DialogInterface.OnDismissListener
{
  public anz(ForwardRecentActivity paramForwardRecentActivity, int paramInt, TranslateAnimation paramTranslateAnimation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.jdField_a_of_type_AndroidWidgetLinearLayout.offsetTopAndBottom(-this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.jdField_a_of_type_AndroidAppDialog = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     anz
 * JD-Core Version:    0.7.0.1
 */