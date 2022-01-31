import SecurityAccountServer.RespondQueryQQBindingStat;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.qphone.base.util.QLog;

public class zfj
  implements Runnable
{
  public zfj(PhoneContactManagerImp paramPhoneContactManagerImp, boolean paramBoolean) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
      StringBuilder localStringBuilder = new StringBuilder().append("checkUpdateLocalContact, bindState = ").append(i);
      if (localObject == null)
      {
        localObject = ",getSelfBindInfo is null";
        QLog.d("PhoneContact.Manager", 2, (String)localObject + ", changed = " + this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.h + ", firstQuery = " + this.jdField_a_of_type_Boolean);
      }
    }
    else
    {
      if ((i == 8) || (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.e())) {
        break label137;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.g();
    }
    label137:
    label172:
    label229:
    do
    {
      do
      {
        do
        {
          return;
          localObject = ", lastFlag = " + ((RespondQueryQQBindingStat)localObject).lastUsedFlag;
          break;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c()) {
            break label172;
          }
        } while ((!this.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.h));
        PhoneContactManagerImp.f(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp);
        return;
        if ((i != 4) && (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d()))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.h();
          return;
        }
        if (i != 1) {
          break label229;
        }
      } while ((!this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a().noBindUploadContacts));
      PhoneContactManagerImp.b(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp, true);
      return;
    } while ((i != 2) || ((!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b) && (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.h)));
    PhoneContactManagerImp.g(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zfj
 * JD-Core Version:    0.7.0.1
 */