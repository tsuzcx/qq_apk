import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public class yuw
{
  yuy a;
  WeakReference<yux> eC;
  
  private void AV(boolean paramBoolean)
  {
    yux localyux;
    if (this.a != null)
    {
      this.a.result = xC();
      QLog.d("contact.PermissionChecker", 1, "onPermissionResult = " + this.a.result);
      if (this.eC != null) {
        break label78;
      }
      localyux = null;
      if (localyux == null) {
        break label92;
      }
      localyux.a(paramBoolean, this.a);
    }
    for (;;)
    {
      this.a = null;
      return;
      label78:
      localyux = (yux)this.eC.get();
      break;
      label92:
      this.a.AV(paramBoolean);
    }
  }
  
  public static boolean UB()
  {
    return (!ij("android.permission.READ_CONTACTS")) || (!ij("android.permission.WRITE_CONTACTS")) || (!ij("android.permission.GET_ACCOUNTS"));
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, Runnable paramRunnable1, Runnable paramRunnable2)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "checkReadContactPermission error");
      }
    }
    do
    {
      do
      {
        return;
        paramQQAppInterface = (PhoneContactManagerImp)paramQQAppInterface.getManager(11);
        boolean bool = paramQQAppInterface.Uw();
        if (QLog.isColorLevel()) {
          QLog.i("BindMsgConstant", 2, String.format("checkReadContactPermission [%s, %s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(VersionUtils.isM()) }));
        }
        if (!bool) {
          break;
        }
      } while (paramRunnable1 == null);
      paramRunnable1.run();
      return;
      if (VersionUtils.isM())
      {
        if ((paramRunnable2 instanceof DenyRunnable)) {
          ((DenyRunnable)paramRunnable2).crj();
        }
        yuy localyuy = new yuy();
        localyuy.eP = paramRunnable1;
        localyuy.eQ = paramRunnable2;
        localyuy.mask = 1;
        paramQQAppInterface.a().a(paramActivity, localyuy, null, new String[] { "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS" });
        return;
      }
    } while (paramRunnable2 == null);
    paramRunnable2.run();
  }
  
  public static boolean ij(String paramString)
  {
    Context localContext;
    if (VersionUtils.isM()) {
      localContext = BaseApplicationImpl.getApplication().getApplicationContext();
    }
    try
    {
      int i = localContext.checkSelfPermission(paramString);
      return i == 0;
    }
    catch (Throwable paramString)
    {
      QLog.d("contact.PermissionChecker", 1, "CheckPermission exception:" + paramString.getMessage(), paramString);
    }
    return false;
  }
  
  public static int xC()
  {
    int j = 0;
    int i = 0;
    Context localContext;
    if (VersionUtils.isM()) {
      localContext = BaseApplicationImpl.getApplication().getApplicationContext();
    }
    label67:
    label105:
    for (;;)
    {
      try
      {
        if (localContext.checkSelfPermission("android.permission.READ_CONTACTS") == 0) {
          i = 1;
        }
        j = i;
        int k = localContext.checkSelfPermission("android.permission.WRITE_CONTACTS");
        if (k != 0) {
          break label105;
        }
        i |= 0x2;
        QLog.d("contact.PermissionChecker", 1, "CheckPermission exception:" + localThrowable1.getMessage(), localThrowable1);
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          k = localContext.checkSelfPermission("android.permission.GET_ACCOUNTS");
          j = i;
          if (k == 0) {
            j = i | 0x4;
          }
          return j;
        }
        catch (Throwable localThrowable2)
        {
          break label67;
        }
        localThrowable1 = localThrowable1;
        i = j;
      }
      return i;
      return 7;
    }
  }
  
  public void a(Activity paramActivity, yuy paramyuy, yux paramyux, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    if (paramActivity == null) {}
    for (;;)
    {
      try
      {
        paramActivity = BaseActivity.sTopActivity;
        AppActivity localAppActivity = (AppActivity)paramActivity;
        paramActivity = paramyuy;
        if (paramyuy == null) {
          paramActivity = new yuy();
        }
        paramyuy = new StringBuilder(512);
        ArrayList localArrayList = new ArrayList();
        int j = paramVarArgs.length;
        int i = 0;
        if (i < j)
        {
          String str = paramVarArgs[i];
          localArrayList.add(str);
          paramyuy.append(str).append(",");
          i += 1;
        }
        else
        {
          paramActivity.requestPermissions = localArrayList;
          this.a = paramActivity;
          this.eC = null;
          if (paramyux != null) {
            this.eC = new WeakReference(paramyux);
          }
          QLog.d("contact.PermissionChecker", 1, "requestPermissions = " + paramyuy.toString());
          localAppActivity.requestPermissions(this, 1, paramVarArgs);
          return;
        }
      }
      catch (Throwable paramActivity)
      {
        QLog.d("contact.PermissionChecker", 1, "requestPermissions exception:" + paramActivity.getMessage(), paramActivity);
        return;
      }
    }
  }
  
  @QQPermissionDenied(1)
  @TargetApi(23)
  public void denied()
  {
    QLog.d("contact.PermissionChecker", 1, "CheckPermission user denied = ");
    AV(false);
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    QLog.d("contact.PermissionChecker", 1, "CheckPermission user grant = ");
    AV(true);
  }
  
  public void onDestroy()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yuw
 * JD-Core Version:    0.7.0.1
 */