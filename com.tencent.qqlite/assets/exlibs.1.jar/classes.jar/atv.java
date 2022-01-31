import android.widget.AutoCompleteTextView;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.widget.ClearableEditText.OnTextClearedListener;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.Collection;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class atv
  implements ClearableEditText.OnTextClearedListener
{
  public atv(LoginActivity paramLoginActivity) {}
  
  public void a()
  {
    libsafeedit.clearPassBuffer();
    this.a.getAppRuntime().stopPCActivePolling("clearPassInput");
    if ((this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_JavaUtilList.size() <= 0) || (this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView == null) || (this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText() == null) || (this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString() == null)) {}
    label82:
    Object localObject;
    label140:
    do
    {
      return;
      int i = 0;
      SimpleAccount localSimpleAccount;
      if (i < this.a.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
        localSimpleAccount = (SimpleAccount)this.a.jdField_a_of_type_JavaUtilList.get(i);
        if (localSimpleAccount != null) {
          break label140;
        }
      }
      while (!((String)localObject).equals(this.a.app.b(localSimpleAccount.getUin())))
      {
        i += 1;
        break label82;
        break;
      }
      this.a.app.updateSubAccountLogin(localSimpleAccount.getUin(), false);
      this.a.e = null;
      this.a.app.getApplication().refreAccountList();
      localObject = this.a.getAppRuntime().getApplication().getAllAccounts();
    } while ((localObject == null) || (this.a.jdField_a_of_type_JavaUtilList == null));
    this.a.jdField_a_of_type_JavaUtilList.clear();
    this.a.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     atv
 * JD-Core Version:    0.7.0.1
 */