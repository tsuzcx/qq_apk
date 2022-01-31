import android.widget.Button;
import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.ClearableEditText;

public class ccb
  implements Runnable
{
  public ccb(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = Utils.d(this.jdField_a_of_type_JavaLangString, this.b);
    if ((str != null) && (str.length() > 0) && (AuthDevVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevVerifyCodeActivity) != null))
    {
      AuthDevVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevVerifyCodeActivity).setText(str);
      AuthDevVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevVerifyCodeActivity).setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ccb
 * JD-Core Version:    0.7.0.1
 */