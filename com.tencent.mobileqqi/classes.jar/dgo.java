import com.tencent.mobileqq.activity.RegisterSendUpSms;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class dgo
  implements Runnable
{
  public dgo(RegisterSendUpSms paramRegisterSendUpSms, String paramString) {}
  
  public void run()
  {
    try
    {
      if (RegisterSendUpSms.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterSendUpSms) == null) {
        RegisterSendUpSms.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterSendUpSms, new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterSendUpSms, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterSendUpSms.d()));
      }
      RegisterSendUpSms.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterSendUpSms).a(this.jdField_a_of_type_JavaLangString);
      RegisterSendUpSms.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterSendUpSms).setOnKeyListener(new dgp(this));
      RegisterSendUpSms.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterSendUpSms).show();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dgo
 * JD-Core Version:    0.7.0.1
 */