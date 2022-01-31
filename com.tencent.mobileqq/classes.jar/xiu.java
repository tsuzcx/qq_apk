import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.app.BaseActivity;

public class xiu
  implements Runnable
{
  public xiu(LoginView paramLoginView, String paramString) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.a(this.jdField_a_of_type_JavaLangString, true);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.a.runOnUiThread(new xiv(this, localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xiu
 * JD-Core Version:    0.7.0.1
 */