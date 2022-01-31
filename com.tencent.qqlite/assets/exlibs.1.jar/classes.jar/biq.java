import android.widget.Button;
import android.widget.EditText;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import com.tencent.mobileqq.util.Utils;

public class biq
  implements Runnable
{
  public biq(RegisterVerifyCodeActivity paramRegisterVerifyCodeActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = Utils.a(this.jdField_a_of_type_JavaLangString, this.b);
    if ((str != null) && (str.length() > 0) && (RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity) != null))
    {
      RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity).setText(str);
      RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity).setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     biq
 * JD-Core Version:    0.7.0.1
 */