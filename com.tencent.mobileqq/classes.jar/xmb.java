import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.app.BaseActivity;

public class xmb
  implements Runnable
{
  public xmb(LoginView paramLoginView, String paramString) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.a(this.jdField_a_of_type_JavaLangString, true);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.a.runOnUiThread(new xmc(this, localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xmb
 * JD-Core Version:    0.7.0.1
 */