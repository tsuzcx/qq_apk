import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.2.1;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.2.2;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.UploadProgressGenerator;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppActivity;
import mqq.os.MqqHandler;

public class yuo
  extends akwl
{
  public yuo(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  protected void AS(boolean paramBoolean)
  {
    if (PhoneContactManagerImp.a(this.this$0)) {}
    do
    {
      return;
      PhoneContactManagerImp.a(this.this$0, false);
    } while (!paramBoolean);
    PhoneContactManagerImp.a(this.this$0, 2);
  }
  
  protected void aG(boolean paramBoolean, int paramInt)
  {
    if (PhoneContactManagerImp.a(this.this$0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "onUploadContactNotBind, isSuc = " + paramBoolean + ", reason = " + paramInt + ", currentState=" + this.this$0.cbf);
    }
    if (PhoneContactManagerImp.a(this.this$0) != null)
    {
      PhoneContactManagerImp.a(this.this$0).cancel();
      PhoneContactManagerImp.a(this.this$0, null);
    }
    int i;
    if (PhoneContactManagerImp.e(this.this$0))
    {
      PhoneContactManagerImp localPhoneContactManagerImp = this.this$0;
      if (paramBoolean)
      {
        i = 3;
        PhoneContactManagerImp.a(localPhoneContactManagerImp, i, PhoneContactManagerImp.a(this.this$0).size(), 100, 100);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label192;
      }
      this.this$0.cbf = 2;
      PhoneContactManagerImp.a(this.this$0, 0L, 0L);
      PhoneContactManagerImp.a(this.this$0, 15);
    }
    for (;;)
    {
      PhoneContactManagerImp.b(this.this$0);
      PhoneContactManagerImp.a(this.this$0, true, true, 6L);
      return;
      i = 4;
      break;
      label192:
      this.this$0.KE = System.currentTimeMillis();
      if ((paramInt != 2) && (paramInt != 3)) {
        break label231;
      }
      this.this$0.cbf = 0;
      this.this$0.boQ = true;
    }
    label231:
    if (paramInt == 5)
    {
      this.this$0.cbf = 1;
      this.this$0.KE = 0L;
      PhoneContactManagerImp.b(this.this$0);
      PhoneContactManagerImp.a(this.this$0, true, true, 6L);
      return;
    }
    if (paramInt == 4)
    {
      this.this$0.cbf = 9;
      this.this$0.boQ = true;
      PhoneContactManagerImp.b(this.this$0);
      PhoneContactManagerImp.a(this.this$0, true, true, 6L);
      return;
    }
    this.this$0.cbf = 0;
    PhoneContactManagerImp.b(this.this$0);
    PhoneContactManagerImp.a(this.this$0, true, true, 6L);
  }
  
  protected void aH(boolean paramBoolean, int paramInt)
  {
    if (PhoneContactManagerImp.a(this.this$0)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "onUpdateContactNotBind, isSuc = " + paramBoolean + ", reason = " + paramInt);
      }
      this.this$0.boK = false;
      if (paramBoolean)
      {
        PhoneContactManagerImp.a(this.this$0, 1);
        PhoneContactManagerImp.a(this.this$0, 0L);
      }
      do
      {
        for (;;)
        {
          PhoneContactManagerImp.a(this.this$0, true, true, 8L);
          return;
          this.this$0.KF = System.currentTimeMillis();
          if ((paramInt != 2) && (paramInt != 3)) {
            break;
          }
          this.this$0.boQ = true;
        }
      } while ((paramInt != 5) && (paramInt != 4));
    } while (this.this$0.cbf == 8);
    PhoneContactManagerImp.a(this.this$0, true, true, 8L);
  }
  
  protected void aI(boolean paramBoolean, int paramInt)
  {
    if (PhoneContactManagerImp.a(this.this$0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "onQueryContactList, isSuc = " + paramBoolean + ", updateFlag = " + paramInt);
    }
    if (paramBoolean) {
      PhoneContactManagerImp.a(this.this$0, paramInt);
    }
    if (this.this$0.xz() >= 7) {
      ThreadManager.getSubThreadHandler().postDelayed(PhoneContactManagerImp.a(this.this$0), PhoneContactManagerImp.KA);
    }
    PhoneContactManagerImp.c(this.this$0);
  }
  
  protected void aJ(boolean paramBoolean, int paramInt)
  {
    if (PhoneContactManagerImp.a(this.this$0)) {}
    while ((!paramBoolean) || (paramInt != 0)) {
      return;
    }
    PhoneContactManagerImp.a(this.this$0, true, true, 10L);
  }
  
  protected void aJ(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (PhoneContactManagerImp.a(this.this$0)) {
      return;
    }
    if ((paramBoolean1) && (paramBoolean2))
    {
      MqqHandler localMqqHandler = PhoneContactManagerImp.a(this.this$0).getHandler(Conversation.class);
      if (localMqqHandler != null)
      {
        Message localMessage = Message.obtain();
        localMessage.what = 1041;
        localMqqHandler.sendMessage(localMessage);
      }
    }
    this.this$0.boJ = false;
    this.this$0.KD = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, String.format("onQueryBindState [%s, %s, %s, %s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(this.this$0.boI), Integer.valueOf(this.this$0.xy()) }));
    }
    PhoneContactManagerImp.a(this.this$0, 6, paramBoolean1);
    if (paramBoolean1)
    {
      PhoneContactManagerImp.a(this.this$0, this.this$0.boI);
      if (this.this$0.boI) {
        ThreadManager.excute(new PhoneContactManagerImp.2.1(this), 16, null, false);
      }
    }
    clZ();
  }
  
  protected void ao(boolean paramBoolean, int paramInt)
  {
    if (PhoneContactManagerImp.a(this.this$0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "onUploadContact, isSuc = " + paramBoolean + ", reason = " + paramInt + ", currentState=" + this.this$0.cbf);
    }
    int i;
    if (PhoneContactManagerImp.e(this.this$0))
    {
      PhoneContactManagerImp localPhoneContactManagerImp = this.this$0;
      if (paramBoolean)
      {
        i = 3;
        PhoneContactManagerImp.a(localPhoneContactManagerImp, i, PhoneContactManagerImp.a(this.this$0).size(), 100, 100);
      }
    }
    else
    {
      if (PhoneContactManagerImp.a(this.this$0) != null)
      {
        PhoneContactManagerImp.a(this.this$0).cancel();
        PhoneContactManagerImp.a(this.this$0, null);
      }
      if (!paramBoolean) {
        break label193;
      }
      this.this$0.cbf = 9;
      PhoneContactManagerImp.a(this.this$0, 0L, 0L);
      PhoneContactManagerImp.a(this.this$0, 15);
    }
    for (;;)
    {
      PhoneContactManagerImp.b(this.this$0);
      PhoneContactManagerImp.a(this.this$0, true, true, 7L);
      return;
      i = 4;
      break;
      label193:
      this.this$0.KE = System.currentTimeMillis();
      if (paramInt == 2)
      {
        this.this$0.cbf = 7;
      }
      else if (paramInt == 3)
      {
        this.this$0.cbf = 9;
        this.this$0.boQ = true;
      }
      else if (paramInt == 1)
      {
        this.this$0.cbf = 1;
        this.this$0.KE = 0L;
      }
    }
  }
  
  protected void ar(boolean paramBoolean, int paramInt)
  {
    if (PhoneContactManagerImp.a(this.this$0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "onUpdateContact, isSuc = " + paramBoolean + ", reason = " + paramInt);
    }
    this.this$0.boK = false;
    if (paramBoolean)
    {
      PhoneContactManagerImp.a(this.this$0, 1);
      PhoneContactManagerImp.a(this.this$0, 0L, 0L);
    }
    for (;;)
    {
      PhoneContactManagerImp.a(this.this$0, true, true, 9L);
      return;
      if ((paramInt == 2) || (paramInt == 3)) {
        this.this$0.boQ = true;
      }
      this.this$0.KF = System.currentTimeMillis();
    }
  }
  
  void clZ()
  {
    ThreadManager.excute(new PhoneContactManagerImp.2.2(this), 16, null, false);
  }
  
  public void cma()
  {
    boolean bool2 = false;
    if (PhoneContactManagerImp.a(this.this$0)) {
      return;
    }
    int i = this.this$0.xy();
    boolean bool3 = LoginWelcomeManager.a(PhoneContactManagerImp.a(this.this$0)).cmb;
    boolean bool4 = PhoneContactManagerImp.b(this.this$0);
    long l = this.this$0.pref.getLong("last_pop_time_for_switchphone", 0L);
    if ((PhoneContactManagerImp.c(this.this$0)) && (System.currentTimeMillis() - l > 86400000L)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "onFirstRespQueryNotBindState bindState = " + i + ", needToJumpBind = " + bool4 + ", phoneSwitchBefit = " + bool1 + l + ",showNewUserGuide = " + bool3);
      }
      if ((!bool4) && (!bool1)) {
        break;
      }
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("topActivity is:").append(localBaseActivity).append(",isFinishing is:");
        bool1 = bool2;
        if (localBaseActivity != null) {
          bool1 = localBaseActivity.isFinishing();
        }
        QLog.d("PhoneContact.Manager", 2, bool1);
      }
      if ((localBaseActivity == null) || (localBaseActivity.isFinishing()) || (localBaseActivity.getAppRuntime() != PhoneContactManagerImp.a(this.this$0)) || ((localBaseActivity instanceof UserguideActivity)) || (bool3) || (UserguideActivity.bbT)) {
        break;
      }
      PhoneContactManagerImp.b(this.this$0, true);
      return;
    }
  }
  
  public void cmb()
  {
    boolean bool1 = true;
    if (PhoneContactManagerImp.boN) {}
    boolean bool2;
    boolean bool3;
    label177:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (PhoneContactManagerImp.a(this.this$0))
            {
              QLog.e("PhoneContact", 1, "onFirstRespQueryState app is null");
              return;
            }
            if (!UserguideActivity.L(PhoneContactManagerImp.a(this.this$0).getApp(), PhoneContactManagerImp.a(this.this$0).getCurrentAccountUin())) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("PhoneContact", 2, "UserguideActivity.showUserGuideThisTime = ture");
          return;
        } while (akwp.a().asQ());
        if (!PortalManager.atg()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PhoneContact", 2, "hongbao forbid alert");
      return;
      int i = this.this$0.xy();
      bool2 = LoginWelcomeManager.a(PhoneContactManagerImp.a(this.this$0)).cmb;
      bool3 = PhoneContactManagerImp.d(this.this$0);
      long l = this.this$0.pref.getLong("last_pop_time_for_switchphone", 0L);
      if ((!PhoneContactManagerImp.c(this.this$0)) || (System.currentTimeMillis() - l <= 86400000L)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "bindState = " + i + ", isFristRun = " + bool3 + ", attempPop = " + bool1 + l + ",showNewUserGuide = " + bool2);
      }
    } while ((!bool3) && (!bool1));
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("topActivity is:").append(localBaseActivity).append(",isFinishing is:");
      if (localBaseActivity == null) {
        break label377;
      }
    }
    label377:
    for (bool1 = localBaseActivity.isFinishing();; bool1 = false)
    {
      QLog.d("PhoneContact.Manager", 2, bool1);
      if ((localBaseActivity == null) || (localBaseActivity.isFinishing()) || (localBaseActivity.getAppRuntime() != PhoneContactManagerImp.a(this.this$0)) || ((localBaseActivity instanceof UserguideActivity)) || (bool2) || (UserguideActivity.bbT)) {
        break;
      }
      PhoneContactManagerImp.b(this.this$0, false);
      return;
      bool1 = false;
      break label177;
    }
  }
  
  protected void fV(int paramInt1, int paramInt2)
  {
    if (PhoneContactManagerImp.a(this.this$0)) {}
    do
    {
      return;
      if (PhoneContactManagerImp.a(this.this$0) == null) {
        PhoneContactManagerImp.a(this.this$0, new PhoneContactManagerImp.UploadProgressGenerator(this.this$0, null));
      }
      PhoneContactManagerImp.a(this.this$0).setProgress(paramInt1, paramInt2);
    } while (!PhoneContactManagerImp.e(this.this$0));
    PhoneContactManagerImp.a(this.this$0, 2, PhoneContactManagerImp.a(this.this$0).size(), paramInt1, paramInt2);
  }
  
  protected void xM(boolean paramBoolean)
  {
    if (PhoneContactManagerImp.a(this.this$0)) {}
    while (!paramBoolean) {
      return;
    }
    PhoneContactManagerImp.a(this.this$0, true, true, 11L);
    this.this$0.cbf = 1;
    PhoneContactManagerImp.b(this.this$0);
    PhoneContactManagerImp.a(this.this$0).getPreferences().edit().putInt("system_msg_list_showcount", 0).putBoolean("contact_guide_user_close", false).putInt("new_friend_show_count_after_user_close", 0).apply();
  }
  
  protected void xp(boolean paramBoolean)
  {
    if (PhoneContactManagerImp.a(this.this$0)) {}
    while (!paramBoolean) {
      return;
    }
    PhoneContactManagerImp.a(this.this$0, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yuo
 * JD-Core Version:    0.7.0.1
 */