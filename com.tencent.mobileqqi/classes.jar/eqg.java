import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.phone.PhoneMatchView;
import com.tencent.mobileqq.activity.voip.VoipHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class eqg
  extends ContactBindObserver
{
  public eqg(PhoneMatchView paramPhoneMatchView) {}
  
  protected void b(boolean paramBoolean)
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
      if (this.a.b)
      {
        this.a.jdField_a_of_type_AndroidAppActivity.setResult(-1);
        this.a.f();
        return;
      }
      Intent localIntent = new Intent(this.a.getContext(), VoipHistoryActivity.class);
      this.a.a(localIntent);
      return;
    }
    this.a.b(this.a.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131558981));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eqg
 * JD-Core Version:    0.7.0.1
 */