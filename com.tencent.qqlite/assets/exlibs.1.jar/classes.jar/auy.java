import android.widget.Button;
import android.widget.EditText;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity2;
import com.tencent.mobileqq.util.Utils;

public class auy
  implements Runnable
{
  public auy(LoginVerifyCodeActivity2 paramLoginVerifyCodeActivity2, String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = Utils.b(this.jdField_a_of_type_JavaLangString, this.b);
    if ((str != null) && (str.length() > 0) && (LoginVerifyCodeActivity2.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginVerifyCodeActivity2) != null))
    {
      LoginVerifyCodeActivity2.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginVerifyCodeActivity2).setText(str);
      LoginVerifyCodeActivity2.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginVerifyCodeActivity2).setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     auy
 * JD-Core Version:    0.7.0.1
 */