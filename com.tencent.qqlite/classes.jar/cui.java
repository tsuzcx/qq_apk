import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.phone.PhoneLaunchActivity;
import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;

public class cui
  extends ContactBindObserver
{
  public cui(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  private boolean a()
  {
    int i = this.a.d();
    boolean bool = this.a.c();
    long l2 = System.currentTimeMillis();
    long l1 = -1L;
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = this.a.a();
    if (localRespondQueryQQBindingStat != null) {
      l1 = localRespondQueryQQBindingStat.lastUsedFlag;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "isShouldQueryContacts state:" + i + ", isFirst:" + this.a.jdField_a_of_type_Boolean + ", isAccessable:" + bool + ", currentTime:" + l2 + ", uploadTime:" + this.a.jdField_d_of_type_Long + ", downloadTime:" + this.a.b + ", lastUsedFlag:" + l1 + ", mCurrentBindState:" + this.a.jdField_a_of_type_Int);
    }
    return (!this.a.jdField_a_of_type_Boolean) && (this.a.g()) && (bool) && (this.a.jdField_a_of_type_Int != 6) && (l1 != 2L) && (l2 - this.a.jdField_d_of_type_Long > 120000L);
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "phoneContactOb.onQueryBindState() is called,isOpeningShare is:" + PhoneContactManagerImp.jdField_c_of_type_Boolean);
    }
    if (PhoneContactManagerImp.jdField_c_of_type_Boolean) {}
    label392:
    label397:
    label405:
    do
    {
      do
      {
        return;
        if (!this.a.d()) {
          break;
        }
      } while (PhoneNumLoginImpl.a().a());
      Object localObject2 = null;
      StringBuilder localStringBuilder = null;
      int i;
      if (PhoneContactManagerImp.a(this.a).isLogin())
      {
        i = this.a.b();
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDownloadTrace", 2, "bindState = " + i);
        }
      }
      switch (i)
      {
      default: 
        localObject1 = localStringBuilder;
        localObject2 = localObject1;
        if (i != 1)
        {
          localObject2 = localObject1;
          if (i != 2)
          {
            ContactUtils.a(PhoneContactManagerImp.a(this.a), 1);
            localObject2 = localObject1;
          }
        }
        localObject1 = BaseActivity.sTopActivity;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("topActivity is:").append(localObject1).append(",isFinishing is:");
          if (localObject1 == null) {
            break label392;
          }
        }
        break;
      }
      for (boolean bool = ((AppActivity)localObject1).isFinishing();; bool = false)
      {
        QLog.d("ThemeDownloadTrace", 2, bool + ",i is:" + localObject2);
        if ((localObject1 == null) || (((AppActivity)localObject1).isFinishing()) || (((AppActivity)localObject1).getAppRuntime() != PhoneContactManagerImp.a(this.a))) {
          break label405;
        }
        if (localObject2 == null) {
          break label397;
        }
        ((AppActivity)localObject1).startActivity(localObject2);
        ((AppActivity)localObject1).overridePendingTransition(2130968635, 2130968589);
        return;
        localObject1 = new Intent(PhoneContactManagerImp.a(this.a).a().getApplicationContext(), PhoneLaunchActivity.class);
        ((Intent)localObject1).putExtra("needAlert", true);
        ContactUtils.a(PhoneContactManagerImp.a(this.a));
        break;
        localObject1 = localStringBuilder;
        if (this.a.a() == null) {
          break;
        }
        localObject1 = localStringBuilder;
        if (this.a.a().lastUsedFlag != 3L) {
          break;
        }
        localObject1 = new Intent(PhoneContactManagerImp.a(this.a).a().getApplicationContext(), PhoneMatchActivity.class);
        break;
      }
      this.a.h();
      return;
      this.a.h();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloadTrace", 2, "mgr.isPhoneContactFirstRun() result is false");
      }
    } while ((!PhoneContactManagerImp.a(this.a).isLogin()) || (!ContactUtils.a(this.a, PhoneContactManagerImp.a(this.a))) || (BaseActivity.sTopActivity == null));
    Object localObject1 = new Intent(PhoneContactManagerImp.a(this.a).a().getApplicationContext(), PhoneLaunchActivity.class);
    ((Intent)localObject1).putExtra("needAlert", true);
    BaseActivity.sTopActivity.startActivity((Intent)localObject1);
    BaseActivity.sTopActivity.overridePendingTransition(2130968635, 2130968589);
  }
  
  protected void a(boolean paramBoolean)
  {
    this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("contact_bind_info_upload", paramBoolean).commit();
    this.a.jdField_d_of_type_Long = 0L;
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_Int = 8;
      this.a.e();
      this.a.c();
      PhoneContactManagerImp.a(this.a, 2);
      return;
    }
    this.a.jdField_d_of_type_Boolean = true;
    this.a.jdField_a_of_type_Int = 5;
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (paramInt == 0)) {
      this.a.c();
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.a.jdField_c_of_type_Long = 0L;
    if (this.a.jdField_a_of_type_Boolean) {
      c(paramBoolean1);
    }
    if (paramBoolean3) {
      a();
    }
    if (a()) {
      PhoneContactManagerImp.a(this.a);
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.c();
      this.a.jdField_a_of_type_Int = 1;
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.b = 0L;
    if ((paramBoolean1) && (paramBoolean2)) {
      this.a.e();
    }
    if (paramBoolean1)
    {
      this.a.jdField_a_of_type_Int = 11;
      return;
    }
    this.a.jdField_a_of_type_Int = 10;
  }
  
  void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      cuj localcuj = new cuj(this);
      PhoneContactManagerImp.a(this.a).a(localcuj);
    }
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    PhoneContactManagerImp.a(this.a, true);
  }
  
  protected void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.e();
      PhoneContactManagerImp.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cui
 * JD-Core Version:    0.7.0.1
 */