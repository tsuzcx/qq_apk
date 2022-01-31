import android.content.Intent;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.activity.phone.PhoneMatchView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class xau
  extends ContactBindObserver
{
  public xau(PhoneMatchView paramPhoneMatchView) {}
  
  protected void b(boolean paramBoolean, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.a.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.a.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    this.a.g();
    if (paramBoolean)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.a.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
        this.a.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
      }
      if (this.a.jdField_a_of_type_Int == 2)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1);
        this.a.f();
        return;
      }
      Intent localIntent = new Intent(this.a.getContext(), ContactListView.class);
      this.a.a(localIntent);
      return;
    }
    this.a.a("更新失败，请稍后重试。");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xau
 * JD-Core Version:    0.7.0.1
 */