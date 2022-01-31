import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import com.tencent.mobileqq.util.Utils;

public class tqn
  implements Runnable
{
  public tqn(RegisterVerifyCodeActivity paramRegisterVerifyCodeActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    int j = 0;
    String str = Utils.a(this.jdField_a_of_type_JavaLangString, this.b);
    if ((str != null) && (str.length() == 6) && (RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity) != null) && (!str.equals(RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity))))
    {
      RegisterVerifyCodeActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity, str);
      i = 0;
      if (i >= 6) {
        break label160;
      }
      Editable localEditable = RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity)[i].getText();
      if ((localEditable == null) || (localEditable.toString().length() <= 0)) {}
    }
    label160:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        i = j;
        for (;;)
        {
          if (i < 6)
          {
            RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity)[i].setText(str.substring(i, i + 1));
            i += 1;
            continue;
            i += 1;
            break;
          }
        }
        RegisterVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterVerifyCodeActivity)[5].setSelection(1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tqn
 * JD-Core Version:    0.7.0.1
 */