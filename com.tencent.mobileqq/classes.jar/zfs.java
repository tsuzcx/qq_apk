import SecurityAccountServer.RespondQueryQQBindingStat;
import android.text.TextUtils;
import com.tencent.mobileqq.app.PhoneContactManagerImp;

public class zfs
  implements Runnable
{
  public zfs(PhoneContactManagerImp paramPhoneContactManagerImp, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
    if ((localRespondQueryQQBindingStat != null) && (TextUtils.isEmpty(localRespondQueryQQBindingStat.mobileNo)) && (localRespondQueryQQBindingStat.noBindUploadContacts == true))
    {
      PhoneContactManagerImp.b(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp, this.jdField_a_of_type_Boolean);
      return;
    }
    PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp, this.jdField_a_of_type_Boolean, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zfs
 * JD-Core Version:    0.7.0.1
 */