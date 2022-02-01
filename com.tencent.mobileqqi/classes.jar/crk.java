import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.LbsBaseActivity;

public class crk
  implements DialogInterface.OnDismissListener
{
  public crk(LbsBaseActivity paramLbsBaseActivity, Runnable paramRunnable) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!LbsBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity.d();
      return;
    }
    LbsBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLbsBaseActivity, this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     crk
 * JD-Core Version:    0.7.0.1
 */