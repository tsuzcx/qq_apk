import QQService.DeviceItemDes;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.DevlockQuickLoginActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.VerifyDevLockManager;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;

public class afsf
{
  private static afsf a;
  public static boolean caD;
  private static byte[] lock = new byte[0];
  private String bEW;
  private String bEX;
  private String bEY = "Manually";
  String bEZ = null;
  String bFa = null;
  String bFb = null;
  byte[] bZ = null;
  private int cTL = -1;
  private boolean caA = true;
  private boolean caB = true;
  private boolean caC;
  Runnable gt = new EquipmentLockImpl.1(this);
  private Map<Integer, Handler> kp = new HashMap();
  private ArrayList<abgt> wo;
  
  public static afsf a()
  {
    if (a == null) {}
    synchronized (lock)
    {
      if (a == null) {
        a = new afsf();
      }
      return a;
    }
  }
  
  public void Ig(String paramString)
  {
    this.bEY = paramString;
  }
  
  public void Ik(boolean paramBoolean)
  {
    this.caC = paramBoolean;
  }
  
  public int a(AppInterface paramAppInterface, String paramString, WtloginObserver paramWtloginObserver)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return -1;
    }
    int i = AppSetting.getAppId();
    paramAppInterface = (WtloginManager)paramAppInterface.getManager(1);
    if (paramAppInterface == null) {
      return -1;
    }
    return paramAppInterface.CheckDevLockStatus(paramString, i, paramWtloginObserver);
  }
  
  public int a(AppInterface paramAppInterface, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver)
  {
    if (paramAppInterface == null) {
      return -1;
    }
    paramAppInterface = (VerifyDevLockManager)paramAppInterface.getManager(7);
    if (paramAppInterface == null) {
      return -1;
    }
    paramAppInterface.cancelVerify(paramVerifyDevLockObserver);
    return 0;
  }
  
  public int a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramContext == null) || (paramQQAppInterface == null)) {}
    do
    {
      do
      {
        return -1;
        paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      } while (TextUtils.isEmpty(paramQQAppInterface));
      if ((!TextUtils.isEmpty(this.bEW)) && (!this.bEW.equalsIgnoreCase(paramQQAppInterface)))
      {
        this.caA = true;
        this.cTL = -1;
      }
      if (!this.caA) {
        break;
      }
      this.caA = false;
      paramContext = paramContext.getSharedPreferences("devlock_sharedpref", 0);
    } while (paramContext == null);
    this.cTL = paramContext.getInt("devlock_status" + paramQQAppInterface, -1);
    this.bEW = paramQQAppInterface;
    return this.cTL;
  }
  
  public int a(QQAppInterface paramQQAppInterface, String paramString, WtloginObserver paramWtloginObserver)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return -1;
    }
    paramQQAppInterface = (WtloginManager)paramQQAppInterface.getManager(1);
    if (paramQQAppInterface == null) {
      return -1;
    }
    return paramQQAppInterface.CloseDevLock(paramString, AppSetting.getAppId(), paramWtloginObserver);
  }
  
  public int a(AppRuntime paramAppRuntime, Context paramContext, String paramString, boolean paramBoolean)
  {
    if ((paramContext == null) || (paramAppRuntime == null)) {}
    do
    {
      do
      {
        return -1;
      } while (TextUtils.isEmpty(paramString));
      paramContext = paramContext.getSharedPreferences("devlock_sharedpref", 0);
    } while (paramContext == null);
    paramAppRuntime = paramAppRuntime.getAccount();
    if (paramBoolean)
    {
      paramContext.edit().putInt("devlock_status" + paramString, 0).commit();
      if (paramString.equalsIgnoreCase(paramAppRuntime)) {
        this.cTL = 0;
      }
    }
    for (;;)
    {
      return 0;
      paramContext.edit().putInt("devlock_status" + paramString, 1).commit();
      if (paramString.equalsIgnoreCase(paramAppRuntime)) {
        this.cTL = 1;
      }
    }
  }
  
  public int a(AppRuntime paramAppRuntime, String paramString1, String paramString2, byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver)
  {
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramString1))) {
      return -1;
    }
    paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
    if (paramAppRuntime == null) {
      return -1;
    }
    return paramAppRuntime.CheckDevLockSms(paramString1, AppSetting.getAppId(), paramString2, paramArrayOfByte, paramWtloginObserver);
  }
  
  public int a(AppRuntime paramAppRuntime, String paramString, WtloginObserver paramWtloginObserver)
  {
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramString))) {
      return -1;
    }
    paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
    if (paramAppRuntime == null) {
      return -1;
    }
    return paramAppRuntime.AskDevLockSms(paramString, paramWtloginObserver);
  }
  
  public int a(AppRuntime paramAppRuntime, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver)
  {
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime = (VerifyDevLockManager)paramAppRuntime.getManager(7);
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime.refreshDevLockSms(paramVerifyDevLockObserver);
    return 0;
  }
  
  public int a(AppRuntime paramAppRuntime, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, String paramString)
  {
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime = (VerifyDevLockManager)paramAppRuntime.getManager(7);
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime.submitSms(paramVerifyDevLockObserver, paramString);
    return 0;
  }
  
  public int a(AppRuntime paramAppRuntime, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, byte[] paramArrayOfByte)
  {
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime = (VerifyDevLockManager)paramAppRuntime.getManager(7);
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime.gatewayVerify(paramVerifyDevLockObserver, paramArrayOfByte);
    return 0;
  }
  
  public int a(AppRuntime paramAppRuntime, byte[] paramArrayOfByte, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver)
  {
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime = (VerifyDevLockManager)paramAppRuntime.getManager(7);
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime.refreshDevLockSms(paramVerifyDevLockObserver, paramArrayOfByte);
    return 0;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    boolean bool;
    label22:
    Object localObject2;
    Object localObject1;
    if ((paramQQAppInterface.isBackground_Pause) || (paramQQAppInterface.isBackground_Stop))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("DevLock", 2, "handleQuickloginPush isInBackground=" + bool + " app.isBackground_Pause=" + paramQQAppInterface.isBackground_Pause + " app.isBackground_Stop=" + paramQQAppInterface.isBackground_Stop);
      }
      if (!bool) {
        break label455;
      }
      paramQQAppInterface = BaseApplicationImpl.getContext();
      localObject2 = paramQQAppInterface.getString(2131693234);
      String str1 = paramQQAppInterface.getString(2131693234);
      String str2 = paramString2 + "\n" + paramString3;
      localObject1 = aqcu.decodeResource(paramQQAppInterface.getResources(), 2130845074);
      localObject2 = new NotificationCompat.Builder(paramQQAppInterface).setContentTitle(str1).setContentText(str2).setAutoCancel(true).setSmallIcon(BaseApplicationImpl.appnewmsgicon).setTicker((CharSequence)localObject2).setWhen(System.currentTimeMillis());
      if (localObject1 == null) {
        break label437;
      }
      ((NotificationCompat.Builder)localObject2).setLargeIcon((Bitmap)localObject1);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT < 11) {
        ((NotificationCompat.Builder)localObject2).setSmallIcon(2130845074);
      }
      localObject1 = new Intent(paramQQAppInterface, DevlockQuickLoginActivity.class);
      ((Intent)localObject1).addFlags(268435456);
      ((Intent)localObject1).putExtra("qrcode", paramString1);
      ((Intent)localObject1).putExtra("maintip", paramString2);
      ((Intent)localObject1).putExtra("smalltip", paramString3);
      ((Intent)localObject1).putExtra("loginConfig", paramArrayOfByte);
      ((Intent)localObject1).putExtra("param_notifyid", 276);
      ((NotificationCompat.Builder)localObject2).setContentIntent(PendingIntent.getActivity(paramQQAppInterface, 0, (Intent)localObject1, 134217728));
      if ((localObject2 != null) && (Build.VERSION.SDK_INT >= 26)) {
        ((NotificationCompat.Builder)localObject2).setChannelId("CHANNEL_ID_SHOW_BADGE");
      }
      paramQQAppInterface = ((NotificationCompat.Builder)localObject2).build();
      localObject1 = QQNotificationManager.getInstance();
      if (localObject1 == null) {
        break;
      }
      ((QQNotificationManager)localObject1).cancel("EquipmentLockImpl", 276);
      caD = true;
      ((QQNotificationManager)localObject1).notify("EquipmentLockImpl", 276, paramQQAppInterface);
      this.bEZ = paramString1;
      this.bFa = paramString2;
      this.bFb = paramString3;
      this.bZ = new byte[paramArrayOfByte.length];
      System.arraycopy(paramArrayOfByte, 0, this.bZ, 0, paramArrayOfByte.length);
      ThreadManager.getUIHandler().removeCallbacks(this.gt);
      ThreadManager.getUIHandler().postDelayed(this.gt, 120000L);
      return;
      bool = false;
      break label22;
      label437:
      ((NotificationCompat.Builder)localObject2).setLargeIcon(aqcu.decodeResource(paramQQAppInterface.getResources(), 2130845074));
    }
    label455:
    paramQQAppInterface = new Intent(BaseApplicationImpl.getContext(), DevlockQuickLoginActivity.class);
    paramQQAppInterface.addFlags(268435456);
    paramQQAppInterface.putExtra("qrcode", paramString1);
    paramQQAppInterface.putExtra("maintip", paramString2);
    paramQQAppInterface.putExtra("smalltip", paramString3);
    paramQQAppInterface.putExtra("loginConfig", paramArrayOfByte);
    BaseApplicationImpl.getContext().startActivity(paramQQAppInterface);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong, byte paramByte, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return false;
      paramQQAppInterface = (FriendListHandler)paramQQAppInterface.getBusinessHandler(1);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.a(paramLong, paramByte, paramArrayOfByte, paramInt);
    return true;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (FriendListHandler)paramQQAppInterface.getBusinessHandler(1);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.f(paramLong, paramString, 0L);
      return true;
    }
    return false;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString, ArrayList<DeviceItemDes> paramArrayList, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (FriendListHandler)paramQQAppInterface.getBusinessHandler(1);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.d(paramString, paramArrayList, paramInt);
      return true;
    }
    return false;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString, ArrayList<DeviceItemDes> paramArrayList, int paramInt, boolean paramBoolean, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (FriendListHandler)paramQQAppInterface.getBusinessHandler(1);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.a(paramString, paramArrayList, paramInt, paramBoolean, paramLong);
      return true;
    }
    return false;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, ArrayList<abgt> paramArrayList)
  {
    if ((paramQQAppInterface == null) || (paramArrayList == null)) {
      return false;
    }
    long l = Long.parseLong(paramQQAppInterface.getAccount());
    String str = null;
    int i = AppSetting.getAppId();
    paramQQAppInterface.getApplication();
    Object localObject = MobileQQ.getContext();
    if (localObject != null) {
      str = ((Context)localObject).getPackageName();
    }
    if (str != null)
    {
      localObject = str;
      if (str.length() >= 1) {}
    }
    else
    {
      localObject = "com.tencent.mobileqq";
    }
    paramQQAppInterface = (FriendListHandler)paramQQAppInterface.getBusinessHandler(1);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.a(l, i, (String)localObject, 1000, paramArrayList);
      return true;
    }
    return false;
  }
  
  public boolean ajT()
  {
    return (this.wo != null) && (this.wo.size() > 0);
  }
  
  public boolean ajU()
  {
    return this.caB;
  }
  
  public boolean ajV()
  {
    return this.caC;
  }
  
  public boolean ar(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    long l = Long.parseLong(paramQQAppInterface.getAccount());
    String str = null;
    int i = AppSetting.getAppId();
    paramQQAppInterface.getApplication();
    BaseApplication localBaseApplication = MobileQQ.getContext();
    if (localBaseApplication != null) {
      str = localBaseApplication.getPackageName();
    }
    if ((str == null) || (str.length() < 1)) {
      str = "com.tencent.mobileqq";
    }
    for (;;)
    {
      paramQQAppInterface = (FriendListHandler)paramQQAppInterface.getBusinessHandler(1);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.k(l, str, i);
        return true;
      }
      return false;
    }
  }
  
  public boolean b(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (FriendListHandler)paramQQAppInterface.getBusinessHandler(1);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.g(paramLong, paramString, 0L);
      return true;
    }
    return false;
  }
  
  public boolean c(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (FriendListHandler)paramQQAppInterface.getBusinessHandler(1);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.h(paramLong, paramString, 0L);
      return true;
    }
    return false;
  }
  
  public int cR(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    this.bEX = paramString;
    return 0;
  }
  
  public ArrayList<abgt> cW()
  {
    return this.wo;
  }
  
  public void dbI()
  {
    if (this.bEZ != null)
    {
      Intent localIntent = new Intent(BaseApplicationImpl.getContext(), DevlockQuickLoginActivity.class);
      localIntent.addFlags(268435456);
      localIntent.putExtra("qrcode", this.bEZ);
      localIntent.putExtra("maintip", this.bFa);
      localIntent.putExtra("smalltip", this.bFb);
      localIntent.putExtra("loginConfig", this.bZ);
      BaseApplicationImpl.getContext().startActivity(localIntent);
      this.bEZ = null;
      this.bFa = null;
      this.bFb = null;
      this.bZ = null;
    }
  }
  
  public void dbJ()
  {
    BaseApplicationImpl.getContext();
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    if (localQQNotificationManager != null) {}
    try
    {
      ThreadManager.getUIHandler().removeCallbacks(this.gt);
      localQQNotificationManager.cancel("EquipmentLockImpl", 276);
      caD = false;
      label36:
      this.bEZ = null;
      this.bFa = null;
      this.bFb = null;
      this.bZ = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label36;
    }
  }
  
  public void dbK()
  {
    this.wo = null;
  }
  
  public void ed(ArrayList<abgt> paramArrayList)
  {
    this.wo = paramArrayList;
  }
  
  public void f(AppRuntime paramAppRuntime, int paramInt)
  {
    if (paramAppRuntime != null)
    {
      paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
      if (paramAppRuntime != null) {
        paramAppRuntime.SetDevlockMobileType(paramInt);
      }
    }
  }
  
  public void u(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) && (paramQQAppInterface != null)) {
      paramString = paramQQAppInterface.getCurrentAccountUin();
    }
    for (;;)
    {
      anot.a(paramQQAppInterface, "P_CliOper", "Safe_DeviceLock", paramString, "UserBehavior", this.bEY, 0, paramInt, "", "", "", "");
      return;
    }
  }
  
  public String uA()
  {
    return this.bEX;
  }
  
  public void v(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) && (paramQQAppInterface != null)) {
      paramString = paramQQAppInterface.getCurrentAccountUin();
    }
    for (;;)
    {
      anot.a(paramQQAppInterface, "dc00899", "Safe_DeviceLock", paramString, "H5UserBehavior", "H5_Manually", 0, paramInt, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afsf
 * JD-Core Version:    0.7.0.1
 */