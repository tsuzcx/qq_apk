import com.tencent.mobileqq.activity.RegisterSendUpSms;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class bia
  implements Runnable
{
  public bia(RegisterSendUpSms paramRegisterSendUpSms, String paramString) {}
  
  public void run()
  {
    try
    {
      if (RegisterSendUpSms.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterSendUpSms) == null) {
        RegisterSendUpSms.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterSendUpSms, new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterSendUpSms, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterSendUpSms.getTitleBarHeight()));
      }
      RegisterSendUpSms.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterSendUpSms).a(this.jdField_a_of_type_JavaLangString);
      RegisterSendUpSms.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterSendUpSms).setOnKeyListener(new bib(this));
      RegisterSendUpSms.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterSendUpSms).show();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bia
 * JD-Core Version:    0.7.0.1
 */