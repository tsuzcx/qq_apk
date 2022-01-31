import android.widget.Button;
import android.widget.EditText;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.util.Utils;

public class eko
  implements Runnable
{
  public eko(BindVerifyActivity paramBindVerifyActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = Utils.b(this.jdField_a_of_type_JavaLangString, this.b);
    if ((str != null) && (str.length() > 0) && (BindVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBindVerifyActivity) != null))
    {
      BindVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBindVerifyActivity).setText(str);
      BindVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBindVerifyActivity).setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eko
 * JD-Core Version:    0.7.0.1
 */