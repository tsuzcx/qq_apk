import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

public class ctv
  implements TextWatcher
{
  public ctv(LoginActivity paramLoginActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null) {
      LoginActivity.a(this.a, null);
    }
    do
    {
      do
      {
        return;
      } while (paramCharSequence == null);
      paramCharSequence = paramCharSequence.toString();
    } while ((paramCharSequence == null) || (paramCharSequence.length() == 0) || (this.a.jdField_a_of_type_JavaUtilList == null));
    paramInt1 = 0;
    label53:
    SimpleAccount localSimpleAccount;
    if (paramInt1 < this.a.jdField_a_of_type_JavaUtilList.size())
    {
      localSimpleAccount = (SimpleAccount)this.a.jdField_a_of_type_JavaUtilList.get(paramInt1);
      if ((localSimpleAccount != null) && (localSimpleAccount.getUin() != null)) {
        break label107;
      }
    }
    label107:
    while (!paramCharSequence.equals(this.a.b.b(localSimpleAccount.getUin())))
    {
      paramInt1 += 1;
      break label53;
      break;
    }
    if ((localSimpleAccount != null) && (localSimpleAccount.isLogined()))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText("!@#ewaGbhkc$!!=");
      this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = localSimpleAccount;
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setClearButtonVisible(false);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ctv
 * JD-Core Version:    0.7.0.1
 */