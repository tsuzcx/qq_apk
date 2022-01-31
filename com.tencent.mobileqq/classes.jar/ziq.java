import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.PhoneUnityIntroductionActivity;
import com.tencent.mobileqq.activity.ThemeNoviceGuideActivity;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.os.MqqHandler;

public class ziq
  extends ContactBindObserver
{
  public ziq(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  void a()
  {
    boolean bool4 = false;
    int i = this.a.c();
    boolean bool5 = LoginWelcomeManager.a(PhoneContactManagerImp.a(this.a)).jdField_a_of_type_Boolean;
    boolean bool2 = PhoneContactManagerImp.a(this.a);
    long l = this.a.jdField_a_of_type_AndroidContentSharedPreferences.getLong("last_pop_time_for_switchphone", 0L);
    boolean bool1;
    Object localObject;
    BaseActivity localBaseActivity;
    boolean bool3;
    if ((PhoneContactManagerImp.b(this.a)) && (System.currentTimeMillis() - l > 86400000L))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "onFirstRespQueryNotBindState bindState = " + i + ", needToJumpBind = " + bool2 + ", phoneSwitchBefit = " + bool1 + l + ",showNewUserGuide = " + bool5);
      }
      if ((bool2) || (bool1))
      {
        localObject = null;
        localBaseActivity = null;
        bool3 = bool2;
        if (PhoneContactManagerImp.a(this.a).isLogin())
        {
          localObject = localBaseActivity;
          bool1 = bool2;
          if (i == 3)
          {
            localObject = localBaseActivity;
            bool1 = bool2;
            if (this.a.a() != null)
            {
              localObject = localBaseActivity;
              bool1 = bool2;
              if (this.a.a().lastUsedFlag == 3L)
              {
                localObject = new Intent(PhoneContactManagerImp.a(this.a).getApp().getApplicationContext(), PhoneMatchActivity.class);
                ((Intent)localObject).putExtra("kSrouce", 16);
                bool1 = false;
              }
            }
          }
          bool3 = bool1;
          if (bool1)
          {
            localObject = new Intent(PhoneContactManagerImp.a(this.a).getApp().getApplicationContext(), BindNumberActivity.class);
            ((Intent)localObject).putExtra("kSrouce", -1);
            bool3 = bool1;
          }
        }
        localBaseActivity = BaseActivity.sTopActivity;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("topActivity is:").append(localBaseActivity).append(",isFinishing is:");
          bool1 = bool4;
          if (localBaseActivity != null) {
            bool1 = localBaseActivity.isFinishing();
          }
          QLog.d("PhoneContact.Manager", 2, bool1 + ",i is:" + localObject);
        }
        if ((localBaseActivity != null) && (!localBaseActivity.isFinishing()) && (localBaseActivity.getAppRuntime() == PhoneContactManagerImp.a(this.a)) && (!(localBaseActivity instanceof UserguideActivity)) && (!bool5) && (!UserguideActivity.jdField_a_of_type_Boolean)) {
          break label426;
        }
      }
    }
    label426:
    while (localObject == null)
    {
      return;
      bool1 = false;
      break;
    }
    localBaseActivity.startActivity((Intent)localObject);
    localBaseActivity.overridePendingTransition(2131034380, 2131034131);
    if (bool3)
    {
      PhoneContactManagerImp.b(this.a);
      return;
    }
    this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("last_pop_time_for_switchphone", System.currentTimeMillis()).commit();
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (PhoneContactManagerImp.a(this.a) == null) {
      PhoneContactManagerImp.a(this.a, new zji(this.a, null));
    }
    PhoneContactManagerImp.a(this.a).a(paramInt1, paramInt2);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      PhoneContactManagerImp.a(this.a, 2);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "onUpdateContact, isSuc = " + paramBoolean + ", reason = " + paramInt);
    }
    this.a.jdField_d_of_type_Boolean = false;
    if (paramBoolean)
    {
      PhoneContactManagerImp.a(this.a, 1);
      PhoneContactManagerImp.a(this.a, 0L, 0L);
    }
    for (;;)
    {
      PhoneContactManagerImp.a(this.a, true, true);
      return;
      if ((paramInt == 2) || (paramInt == 3)) {
        this.a.h = true;
      }
      this.a.jdField_d_of_type_Long = System.currentTimeMillis();
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      MqqHandler localMqqHandler = PhoneContactManagerImp.a(this.a).getHandler(Conversation.class);
      if (localMqqHandler != null)
      {
        Message localMessage = Message.obtain();
        localMessage.what = 1041;
        localMqqHandler.sendMessage(localMessage);
      }
    }
    this.a.jdField_c_of_type_Boolean = false;
    this.a.jdField_b_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "onQueryBindState isSuccess=" + paramBoolean1 + ",isFirst=" + this.a.jdField_a_of_type_Boolean);
    }
    if (paramBoolean1)
    {
      PhoneContactManagerImp.a(this.a, this.a.jdField_a_of_type_Boolean);
      if (this.a.jdField_a_of_type_Boolean) {
        ThreadManager.getSubThreadHandler().post(new zis(this));
      }
      this.a.jdField_a_of_type_Boolean = false;
    }
  }
  
  void b()
  {
    if (PhoneContactManagerImp.g) {}
    label155:
    label308:
    label834:
    label839:
    label868:
    do
    {
      boolean bool3;
      do
      {
        int i;
        boolean bool1;
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (!UserguideActivity.a(PhoneContactManagerImp.a(this.a).getApp(), PhoneContactManagerImp.a(this.a).getCurrentAccountUin())) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("PhoneContact", 2, "UserguideActivity.showUserGuideThisTime = ture");
              return;
            } while (PhoneNumLoginImpl.a().a());
            if (!PortalManager.e()) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("PhoneContact", 2, "hongbao forbid alert");
          return;
          i = this.a.c();
          bool1 = LoginWelcomeManager.a(PhoneContactManagerImp.a(this.a)).jdField_a_of_type_Boolean;
          bool3 = PhoneContactManagerImp.c(this.a);
          long l = this.a.jdField_a_of_type_AndroidContentSharedPreferences.getLong("last_pop_time_for_switchphone", 0L);
          if ((!PhoneContactManagerImp.b(this.a)) || (System.currentTimeMillis() - l <= 86400000L)) {
            break;
          }
          bool2 = true;
          if (QLog.isColorLevel()) {
            QLog.d("PhoneContact.Manager", 2, "bindState = " + i + ", isFristRun = " + bool3 + ", attempPop = " + bool2 + l + ",showNewUserGuide = " + bool1);
          }
        } while ((!bool3) && (!bool2));
        Object localObject3 = null;
        Object localObject2 = null;
        localObject1 = localObject2;
        if (PhoneContactManagerImp.a(this.a).isLogin()) {
          localObject1 = localObject2;
        }
        switch (i)
        {
        default: 
          localObject1 = localObject2;
        case 2: 
        case 3: 
        case 4: 
          localObject2 = BaseActivity.sTopActivity;
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder().append("topActivity is:").append(localObject2).append(",isFinishing is:");
            if (localObject2 == null) {
              break label834;
            }
          }
          break;
        }
        for (boolean bool2 = ((AppActivity)localObject2).isFinishing();; bool2 = false)
        {
          QLog.d("PhoneContact.Manager", 2, bool2 + ",i is:" + localObject1);
          if ((localObject2 == null) || (((AppActivity)localObject2).isFinishing()) || (((AppActivity)localObject2).getAppRuntime() != PhoneContactManagerImp.a(this.a)) || ((localObject2 instanceof UserguideActivity)) || (bool1) || (UserguideActivity.jdField_a_of_type_Boolean)) {
            break;
          }
          if (localObject1 == null) {
            break label868;
          }
          ((AppActivity)localObject2).startActivity((Intent)localObject1);
          ((AppActivity)localObject2).overridePendingTransition(2131034380, 2131034131);
          if (!bool3) {
            break label839;
          }
          PhoneContactManagerImp.c(this.a);
          return;
          bool2 = false;
          break label155;
          localObject1 = localObject2;
          if (!bool3) {
            break label308;
          }
          if (this.a.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_bind_style", 0) == 0)
          {
            localObject1 = new Intent(PhoneContactManagerImp.a(this.a).getApp().getApplicationContext(), PhoneUnityIntroductionActivity.class);
            ((Intent)localObject1).putExtra("kSrouce", 9);
            ReportController.b(PhoneContactManagerImp.a(this.a), "CliOper", "", "", "0X8006EF7", "0X8006EF7", 0, 0, "", "", "", "");
            break label308;
          }
          localObject1 = localObject2;
          if (this.a.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_bind_style", 0) != 1) {
            break label308;
          }
          localObject1 = new Intent(PhoneContactManagerImp.a(this.a).getApp().getApplicationContext(), BindNumberActivity.class);
          ((Intent)localObject1).putExtra("kSrouce", 11);
          ReportController.b(PhoneContactManagerImp.a(this.a), "CliOper", "", "", "0X8006EF8", "0X8006EF8", 0, 0, "", "", "", "");
          break label308;
          localObject1 = localObject2;
          if (this.a.a() == null) {
            break label308;
          }
          localObject1 = localObject2;
          if (this.a.a().lastUsedFlag != 3L) {
            break label308;
          }
          localObject1 = new Intent(PhoneContactManagerImp.a(this.a).getApp().getApplicationContext(), PhoneMatchActivity.class);
          break label308;
          localObject3 = this.a.a();
          localObject1 = localObject2;
          if (this.a.e()) {
            break label308;
          }
          localObject1 = localObject2;
          if (localObject3 == null) {
            break label308;
          }
          localObject1 = localObject2;
          if (((RespondQueryQQBindingStat)localObject3).isStopFindMatch) {
            break label308;
          }
          localObject2 = new Intent(PhoneContactManagerImp.a(this.a).getApp().getApplicationContext(), PhoneMatchActivity.class);
          localObject1 = localObject2;
          if (!bool3) {
            break label308;
          }
          ((Intent)localObject2).putExtra("key_from_contact_first", true);
          localObject1 = localObject2;
          break label308;
          bool1 = true;
          localObject1 = localObject3;
          break label308;
        }
        this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("last_pop_time_for_switchphone", System.currentTimeMillis()).commit();
        return;
      } while (!bool3);
      localObject1 = PhoneContactManagerImp.a(this.a).getPreferences();
    } while ((localObject1 == null) || (((SharedPreferences)localObject1).getBoolean("THEME_NOVICE_GUIDE_RUNED", false)) || (!BaseApplicationImpl.IS_SUPPORT_THEME));
    ((SharedPreferences)localObject1).edit().putBoolean("THEME_NOVICE_GUIDE_RUNED", true).commit();
    Object localObject1 = new Intent(BaseActivity.sTopActivity, ThemeNoviceGuideActivity.class);
    BaseActivity.sTopActivity.startActivity((Intent)localObject1);
    BaseActivity.sTopActivity.overridePendingTransition(2131034123, 2131034124);
    PhoneContactManagerImp.c(this.a);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((MyBusinessManager)PhoneContactManagerImp.a(this.a).getManager(48)).a("", 0, "", false);
      PhoneContactManagerImp.a(this.a, true, true);
      this.a.jdField_a_of_type_Int = 1;
      PhoneContactManagerImp.d(this.a);
      PhoneContactManagerImp.a(this.a).getPreferences().edit().putInt("system_msg_list_showcount", 0).commit();
    }
  }
  
  protected void b(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "onUploadContact, isSuc = " + paramBoolean + ", reason = " + paramInt + ", currentState=" + this.a.jdField_a_of_type_Int);
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if ((localBaseApplication != null) && (this.a.f))
    {
      if (this.a.jdField_a_of_type_Int != 1)
      {
        if (paramBoolean) {
          QQToast.a(localBaseApplication, 0, "手机通讯录匹配完成。", 0).b(localBaseApplication.getResources().getDimensionPixelSize(2131558448));
        }
      }
      else {
        this.a.f = false;
      }
    }
    else
    {
      if (PhoneContactManagerImp.a(this.a) != null)
      {
        PhoneContactManagerImp.a(this.a).b();
        PhoneContactManagerImp.a(this.a, null);
      }
      if (!paramBoolean) {
        break label224;
      }
      this.a.jdField_a_of_type_Int = 9;
      PhoneContactManagerImp.a(this.a, 0L, 0L);
      PhoneContactManagerImp.a(this.a, 15);
    }
    for (;;)
    {
      PhoneContactManagerImp.d(this.a);
      PhoneContactManagerImp.a(this.a, true, true);
      return;
      QQToast.a(localBaseApplication, 0, "手机通讯录匹配失败。", 0).b(localBaseApplication.getResources().getDimensionPixelSize(2131558448));
      break;
      label224:
      this.a.jdField_c_of_type_Long = System.currentTimeMillis();
      if (paramInt == 2)
      {
        this.a.jdField_a_of_type_Int = 7;
      }
      else if (paramInt == 3)
      {
        this.a.jdField_a_of_type_Int = 9;
        this.a.h = true;
      }
      else if (paramInt == 1)
      {
        this.a.jdField_a_of_type_Int = 1;
        this.a.jdField_c_of_type_Long = 0L;
      }
    }
  }
  
  protected void c(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (paramInt == 0))
    {
      if (this.a.jdField_a_of_type_Int == 4) {}
      PhoneContactManagerImp.a(this.a, true, true);
    }
  }
  
  protected void c(boolean paramBoolean, Bundle paramBundle)
  {
    this.a.jdField_c_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "onQueryBindStateNotBind isSuccess=" + paramBoolean + ",isFirst=" + this.a.jdField_b_of_type_Boolean);
    }
    if (paramBoolean)
    {
      PhoneContactManagerImp.a(this.a, false);
      if (!this.a.jdField_b_of_type_Boolean) {}
    }
    int i;
    do
    {
      ThreadManager.getSubThreadHandler().post(new zir(this));
      do
      {
        return;
      } while (paramBundle == null);
      i = paramBundle.getInt("param_fail_reason");
    } while ((i != 5) && (i != 4));
    PhoneContactManagerImp.a(this.a, true, true);
  }
  
  protected void d(boolean paramBoolean)
  {
    PhoneContactManagerImp.a(this.a, false);
    if (paramBoolean) {
      PhoneContactManagerImp.a(this.a, 2);
    }
  }
  
  protected void d(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "onQueryContactList, isSuc = " + paramBoolean + ", updateFlag = " + paramInt);
    }
    if (paramBoolean) {
      PhoneContactManagerImp.a(this.a, paramInt);
    }
    if (this.a.d() >= 7) {
      ThreadManager.getSubThreadHandler().postDelayed(PhoneContactManagerImp.a(this.a), PhoneContactManagerImp.jdField_a_of_type_Long);
    }
    PhoneContactManagerImp.e(this.a);
  }
  
  protected void e(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "onUploadContactNotBind, isSuc = " + paramBoolean + ", reason = " + paramInt + ", currentState=" + this.a.jdField_a_of_type_Int);
    }
    if (PhoneContactManagerImp.a(this.a) != null)
    {
      PhoneContactManagerImp.a(this.a).b();
      PhoneContactManagerImp.a(this.a, null);
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_Int = 2;
      PhoneContactManagerImp.a(this.a, 0L, 0L);
      PhoneContactManagerImp.a(this.a, 15);
    }
    for (;;)
    {
      PhoneContactManagerImp.d(this.a);
      PhoneContactManagerImp.b(this.a, true);
      return;
      this.a.jdField_c_of_type_Long = System.currentTimeMillis();
      if ((paramInt != 2) && (paramInt != 3)) {
        break;
      }
      this.a.jdField_a_of_type_Int = 0;
      this.a.h = true;
    }
    if (paramInt == 5)
    {
      this.a.jdField_a_of_type_Int = 1;
      this.a.jdField_c_of_type_Long = 0L;
      PhoneContactManagerImp.d(this.a);
      PhoneContactManagerImp.a(this.a, true, true);
      return;
    }
    if (paramInt == 4)
    {
      this.a.jdField_a_of_type_Int = 9;
      this.a.h = true;
      PhoneContactManagerImp.d(this.a);
      PhoneContactManagerImp.a(this.a, true, true);
      return;
    }
    this.a.jdField_a_of_type_Int = 0;
    PhoneContactManagerImp.d(this.a);
    PhoneContactManagerImp.a(this.a, true, true);
  }
  
  protected void f(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "onUpdateContactNotBind, isSuc = " + paramBoolean + ", reason = " + paramInt);
    }
    this.a.jdField_d_of_type_Boolean = false;
    if (paramBoolean)
    {
      PhoneContactManagerImp.a(this.a, 1);
      PhoneContactManagerImp.a(this.a, 0L);
      PhoneContactManagerImp.b(this.a, true);
    }
    do
    {
      return;
      this.a.jdField_d_of_type_Long = System.currentTimeMillis();
      if ((paramInt == 2) || (paramInt == 3))
      {
        this.a.h = true;
        break;
      }
      if ((paramInt != 5) && (paramInt != 4)) {
        break;
      }
    } while (this.a.jdField_a_of_type_Int == 8);
    PhoneContactManagerImp.a(this.a, true, true);
  }
  
  protected void g(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "onQueryContactListNotBind, isSuc = " + paramBoolean + ", updateFlag = " + paramInt);
    }
    if (paramBoolean) {
      PhoneContactManagerImp.a(this.a, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ziq
 * JD-Core Version:    0.7.0.1
 */