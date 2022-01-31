import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.activity.PublicAccountActivity;

public class dam
  implements DialogInterface.OnDismissListener
{
  public dam(PublicAccountActivity paramPublicAccountActivity, int paramInt, TranslateAnimation paramTranslateAnimation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    PublicAccountActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountActivity).offsetTopAndBottom(-this.jdField_a_of_type_Int);
    PublicAccountActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountActivity).startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    PublicAccountActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountActivity, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dam
 * JD-Core Version:    0.7.0.1
 */