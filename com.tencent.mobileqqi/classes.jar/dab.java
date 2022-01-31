import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class dab
  implements Runnable
{
  public dab(LoginInfoActivity paramLoginInfoActivity, int paramInt) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.isFinishing())
        {
          if ((LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity) != null) && (LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity).isShowing()))
          {
            LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity).dismiss();
            LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity).cancel();
            LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity, null);
          }
          LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity, new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.a(), this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.d()));
          int i = this.jdField_a_of_type_Int;
          switch (i)
          {
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        continue;
        LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity).b(2131562645);
        continue;
      }
      if ((LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity) != null) && (!LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity).isShowing())) {
        LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity).show();
      }
      return;
      LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity).b(2131562300);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dab
 * JD-Core Version:    0.7.0.1
 */