import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

class atj
  implements Runnable
{
  atj(ati paramati) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!this.a.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.isFinishing()))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     atj
 * JD-Core Version:    0.7.0.1
 */