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

public class cuf
  implements ClearableEditText.OnTextClearedListener
{
  public cuf(LoginActivity paramLoginActivity) {}
  
  public void a()
  {
    
    if ((this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_JavaUtilList.size() <= 0) || (this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView == null) || (this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText() == null) || (this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString() == null)) {}
    label70:
    Object localObject;
    label128:
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
          break label128;
        }
      }
      while (!((String)localObject).equals(this.a.b.b(localSimpleAccount.getUin())))
      {
        i += 1;
        break label70;
        break;
      }
      this.a.b.updateSubAccountLogin(localSimpleAccount.getUin(), false);
      this.a.c = null;
      this.a.b.getApplication().refreAccountList();
      localObject = this.a.getAppRuntime().getApplication().getAllAccounts();
    } while ((localObject == null) || (this.a.jdField_a_of_type_JavaUtilList == null));
    this.a.jdField_a_of_type_JavaUtilList.clear();
    this.a.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cuf
 * JD-Core Version:    0.7.0.1
 */