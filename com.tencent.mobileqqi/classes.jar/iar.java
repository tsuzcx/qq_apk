import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import cooperation.qlink.QlinkDialogActivity;

public class iar
  implements Runnable
{
  public iar(QlinkDialogActivity paramQlinkDialogActivity, Activity paramActivity, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void run()
  {
    this.jdField_a_of_type_CooperationQlinkQlinkDialogActivity.a = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getString(2131560849), this.jdField_a_of_type_JavaLangString, 2131560847, 2131560848, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.b);
    this.jdField_a_of_type_CooperationQlinkQlinkDialogActivity.a.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    this.jdField_a_of_type_CooperationQlinkQlinkDialogActivity.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     iar
 * JD-Core Version:    0.7.0.1
 */