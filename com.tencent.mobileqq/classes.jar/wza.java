import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.qphone.base.util.QLog;

class wza
  implements DialogInterface.OnClickListener
{
  wza(wyz paramwyz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "new user guild confirm unbind");
    }
    this.a.a.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(this.a.a.jdField_a_of_type_JavaLangString, this.a.a.b, 0, BindNumberActivity.a(this.a.a), BindNumberActivity.c(this.a.a));
    this.a.a.a(2131434469, 1000L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wza
 * JD-Core Version:    0.7.0.1
 */