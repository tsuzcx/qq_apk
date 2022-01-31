import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.qphone.base.util.QLog;

public class fiw
  extends ContactBindObserver
{
  boolean jdField_a_of_type_Boolean = false;
  
  public fiw(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  private boolean a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d();
    long l2 = System.currentTimeMillis();
    long l1 = -1L;
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
    if (localRespondQueryQQBindingStat != null) {
      l1 = localRespondQueryQQBindingStat.lastUsedFlag;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "isShouldQueryContacts state:" + i + ", isFirst:" + this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_Boolean + ", isAccessable:" + bool + ", currentTime:" + l2 + ", uploadTime:" + this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_d_of_type_Long + ", downloadTime:" + this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b + ", lastUsedFlag:" + l1 + ", mCurrentBindState:" + this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_Int);
    }
    return (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.h()) && (bool) && (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_Int != 6) && (l1 != 2L) && (l2 - this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_d_of_type_Long > 120000L);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((MyBusinessManager)PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp).getManager(45)).a("", 0, "");
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b();
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_Int = 1;
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (paramInt == 0))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b();
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_c_of_type_Long = 0L;
    if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_Boolean) {
      d(paramBoolean1);
    }
    if (a()) {
      PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp);
    }
    if ((this.jdField_a_of_type_Boolean) && (paramBoolean2))
    {
      RespondQueryQQBindingStat localRespondQueryQQBindingStat = ((PhoneContactManager)PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp).getManager(10)).a();
      if ((localRespondQueryQQBindingStat == null) || (TextUtils.isEmpty(localRespondQueryQQBindingStat.mobileNo))) {
        break label117;
      }
      ((MyBusinessManager)PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp).getManager(45)).a(localRespondQueryQQBindingStat.mobileNo, localRespondQueryQQBindingStat.type, "");
      this.jdField_a_of_type_Boolean = false;
    }
    label117:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("PhoneContact", 2, "mybusiness bindInfo null ");
  }
  
  protected void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("contact_bind_info_upload", paramBoolean).commit();
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_d_of_type_Long = 0L;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_Int = 8;
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d();
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b();
      PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp, 2);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_Int = 5;
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b = 0L;
    if ((paramBoolean1) && (paramBoolean2)) {
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d();
    }
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_Int = 11;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_Int = 10;
  }
  
  void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      fix localfix = new fix(this);
      PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp).a(localfix);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "phoneContactOb.onQueryBindState() is called,isOpeningShare is:" + PhoneContactManagerImp.jdField_c_of_type_Boolean);
    }
    if (PhoneContactManagerImp.jdField_c_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        if (!UserguideActivity.a(PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp).a(), PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp).a())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ThemeDownloadTrace", 2, "UserguideActivity.showUserGuideThisTime = ture");
      return;
    } while ((this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.e()) || (!QLog.isColorLevel()));
    QLog.d("ThemeDownloadTrace", 2, "mgr.isPhoneContactFirstRun() result is false");
  }
  
  protected void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp, true);
  }
  
  protected void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d();
      PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fiw
 * JD-Core Version:    0.7.0.1
 */