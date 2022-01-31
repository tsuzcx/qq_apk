import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class aue
  implements Runnable
{
  public aue(LoginInfoActivity paramLoginInfoActivity, int paramInt) {}
  
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
          LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity, new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.getTitleBarHeight()));
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
        LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity).b(2131363569);
        continue;
      }
      if ((LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity) != null) && (!LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity).isShowing())) {
        LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity).show();
      }
      return;
      LoginInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity).b(2131362796);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aue
 * JD-Core Version:    0.7.0.1
 */