import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.regex.Matcher;

public class bzx
  implements View.OnClickListener
{
  public bzx(AddFriendVerifyActivity paramAddFriendVerifyActivity, StringBuffer paramStringBuffer, String paramString1, int paramInt, String paramString2) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_JavaLangStringBuffer.toString();
    int i = 0;
    String str;
    if (i < AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).size())
    {
      str = ((EditText)AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).get(i)).getText().toString().trim();
      if (!"".equals(str)) {}
    }
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, 1, this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getString(2131561421), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.d());
        return;
        paramView = paramView.replaceFirst("\\$\\{answer\\}", Matcher.quoteReplacement(str));
        i += 1;
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a(this.jdField_a_of_type_JavaLangString, AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity), true, paramView, this.jdField_a_of_type_Int, this.b, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bzx
 * JD-Core Version:    0.7.0.1
 */