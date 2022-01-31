import android.widget.Button;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qqconnect.wtlogin.AuthDevVerifyCodeActivity2;

public class hyf
  implements Runnable
{
  public hyf(AuthDevVerifyCodeActivity2 paramAuthDevVerifyCodeActivity2, String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = Utils.d(this.jdField_a_of_type_JavaLangString, this.b);
    if ((str != null) && (str.length() > 0) && (AuthDevVerifyCodeActivity2.a(this.jdField_a_of_type_ComTencentQqconnectWtloginAuthDevVerifyCodeActivity2) != null))
    {
      AuthDevVerifyCodeActivity2.a(this.jdField_a_of_type_ComTencentQqconnectWtloginAuthDevVerifyCodeActivity2).setText(str);
      AuthDevVerifyCodeActivity2.a(this.jdField_a_of_type_ComTencentQqconnectWtloginAuthDevVerifyCodeActivity2).setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hyf
 * JD-Core Version:    0.7.0.1
 */