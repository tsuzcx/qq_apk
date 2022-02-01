import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;

public class akwp
{
  private static akwp a;
  private static byte[] lock = new byte[0];
  private boolean cuI;
  public boolean cuJ = true;
  private HashMap<String, Long> mj = new HashMap(10);
  
  public static akwp a()
  {
    if (a == null) {}
    synchronized (lock)
    {
      if (a == null) {
        a = new akwp();
      }
      return a;
    }
  }
  
  public boolean N(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool1;
    if (paramQQAppInterface == null) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      paramQQAppInterface = (WtloginManager)paramQQAppInterface.getManager(1);
      if (paramQQAppInterface == null) {
        return true;
      }
      bool2 = paramQQAppInterface.getHasPwd(paramString);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("sp", 2, "getHasPwd return uin=" + paramString + " ret = " + bool2);
    return bool2;
  }
  
  public void Nq(boolean paramBoolean)
  {
    this.cuI = paramBoolean;
  }
  
  public int a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, WtloginObserver paramWtloginObserver)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return -1;
    }
    paramAppInterface = (WtloginManager)paramAppInterface.getManager(1);
    if (paramAppInterface == null) {
      return -1;
    }
    return paramAppInterface.VerifySMSVerifyLoginCode(paramString1, paramString2, paramString3, paramWtloginObserver);
  }
  
  public int a(AppInterface paramAppInterface, String paramString1, String paramString2, WtloginObserver paramWtloginObserver)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString2))) {
      return -1;
    }
    paramAppInterface = (WtloginManager)paramAppInterface.getManager(1);
    if (paramAppInterface == null) {
      return -1;
    }
    return paramAppInterface.RefreshSMSVerifyLoginCode(paramString1, paramString2, paramWtloginObserver);
  }
  
  public int a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, WtloginObserver paramWtloginObserver)
  {
    if (paramQQAppInterface == null) {
      return -1;
    }
    paramQQAppInterface = (WtloginManager)paramQQAppInterface.getManager(1);
    if (paramQQAppInterface == null) {
      return -1;
    }
    return paramQQAppInterface.RegGetSMSVerifyLoginAccount(paramArrayOfByte1, paramArrayOfByte2, paramString, "3.4.4", paramWtloginObserver);
  }
  
  public int a(AppRuntime paramAppRuntime, String paramString1, String paramString2, WtloginObserver paramWtloginObserver)
  {
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramString1))) {
      return -1;
    }
    paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
    if (paramAppRuntime == null) {
      return -1;
    }
    return paramAppRuntime.CheckSMSVerifyLoginAccount(paramString1, paramString2, AppSetting.getAppId(), paramWtloginObserver);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (N(paramQQAppInterface, str)) {
      return true;
    }
    aqju localaqju = aqha.a(paramActivity, 230);
    localaqju.setTitle(2131717132);
    localaqju.setMessage(2131717131);
    paramQQAppInterface = new akwq(this, str, paramActivity, paramQQAppInterface);
    paramActivity = new akwr(this);
    localaqju.setPositiveButton(2131717130, paramQQAppInterface);
    localaqju.setNegativeButton(2131721058, paramActivity);
    localaqju.show();
    return false;
  }
  
  public boolean asQ()
  {
    return this.cuI;
  }
  
  public int b(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, WtloginObserver paramWtloginObserver)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString3))) {
      return -1;
    }
    paramAppInterface = (WtloginManager)paramAppInterface.getManager(1);
    if (paramAppInterface == null) {
      return -1;
    }
    return paramAppInterface.GetSubaccountStViaSMSVerifyLogin(paramString1, paramString2, paramString3, AppSetting.getAppId(), paramWtloginObserver);
  }
  
  public int b(AppInterface paramAppInterface, String paramString1, String paramString2, WtloginObserver paramWtloginObserver)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString2))) {
      return -1;
    }
    paramAppInterface = (WtloginManager)paramAppInterface.getManager(1);
    if (paramAppInterface == null) {
      return -1;
    }
    return paramAppInterface.GetStViaSMSVerifyLogin(paramString1, paramString2, AppSetting.getAppId(), paramWtloginObserver);
  }
  
  public void b(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    int i = 1;
    if (paramAppRuntime == null) {}
    do
    {
      return;
      paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
    } while (paramAppRuntime == null);
    if (paramBoolean) {}
    for (;;)
    {
      paramAppRuntime.setRegDevLockFlag(i);
      return;
      i = 0;
    }
  }
  
  public boolean bl(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
    if (localMobileQQ == null) {
      return false;
    }
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (N(paramQQAppInterface, str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("sp", 2, "getHasPwd return true uin=" + str);
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("sp", 2, "getHasPwd return false uin=" + str);
    }
    Long localLong = (Long)this.mj.get(str);
    if (localLong != null)
    {
      paramQQAppInterface = localLong;
      if (localLong.longValue() != 0L) {}
    }
    else
    {
      paramQQAppInterface = localMobileQQ.getSharedPreferences("pwd_sharedpref", 0);
      if (paramQQAppInterface == null) {
        return false;
      }
      paramQQAppInterface = Long.valueOf(paramQQAppInterface.getLong("pwd_ts_key" + str, 0L));
      this.mj.put(str, paramQQAppInterface);
    }
    return System.currentTimeMillis() - paramQQAppInterface.longValue() > 86400000L;
  }
  
  public void dC(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    Object localObject;
    long l;
    do
    {
      do
      {
        return;
        localObject = paramQQAppInterface.getApplication();
      } while (localObject == null);
      paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      l = System.currentTimeMillis();
      this.mj.put(paramQQAppInterface, Long.valueOf(l));
      localObject = ((MobileQQ)localObject).getSharedPreferences("pwd_sharedpref", 0);
    } while (localObject == null);
    paramQQAppInterface = "pwd_ts_key" + paramQQAppInterface;
    ((SharedPreferences)localObject).edit().putLong(paramQQAppInterface, l).commit();
  }
  
  public void l(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = (WtloginManager)paramQQAppInterface.getManager(1);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.setHasPwd(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akwp
 * JD-Core Version:    0.7.0.1
 */