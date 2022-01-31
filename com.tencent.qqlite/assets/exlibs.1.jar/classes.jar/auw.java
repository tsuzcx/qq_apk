import android.widget.Button;
import android.widget.EditText;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity;
import com.tencent.mobileqq.util.Utils;

public class auw
  implements Runnable
{
  public auw(LoginVerifyCodeActivity paramLoginVerifyCodeActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = Utils.b(this.jdField_a_of_type_JavaLangString, this.b);
    if ((str != null) && (str.length() > 0) && (LoginVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginVerifyCodeActivity) != null))
    {
      LoginVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginVerifyCodeActivity).setText(str);
      LoginVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginVerifyCodeActivity).setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     auw
 * JD-Core Version:    0.7.0.1
 */