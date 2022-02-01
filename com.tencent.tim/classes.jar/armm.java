import MWIFI.SCGet3rdCloudCheck;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.wifi.FreeWifiHelper.5;
import com.tencent.mobileqq.wifi.QWifiFloorFragment;
import com.tencent.mobileqq.wifi.QWifiListFragment;
import com.tencent.mobileqq.wifi.QWifiSecurityFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wifisdk.TMSDKCustomConfig;
import com.tencent.wifisdk.TMSDKWifiManager;
import com.wifisdk.ui.WifiSDKUIApi;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class armm
{
  private static volatile boolean dch;
  private static volatile boolean dci;
  private static boolean dcj;
  private static boolean dck;
  private static boolean dcl;
  
  private static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, armm.a parama, int paramInt)
  {
    paramActivity = new FreeWifiHelper.5(paramActivity, paramString1, paramString2, paramString3, paramString4, new armq(paramInt, paramActivity, parama), new armr(parama, paramInt), new arms(parama, paramInt), paramInt);
    paramString1 = Looper.getMainLooper();
    if (Thread.currentThread() == paramString1.getThread())
    {
      paramActivity.run();
      return;
    }
    new Handler(paramString1).post(paramActivity);
  }
  
  private static void a(Context paramContext, int paramInt, ArrayList<Integer> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WifiSdk", 2, "gotoWifiSecurityPage");
    }
    if (cl(paramContext))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("uiapi_k101", paramInt);
      if (paramArrayList != null) {
        localIntent.putIntegerArrayListExtra("uiapi_k100", paramArrayList);
      }
      localIntent.putExtra("big_brother_source_key", "biz_src_wifi");
      PublicFragmentActivity.start(paramContext, localIntent, QWifiSecurityFragment.class);
    }
  }
  
  public static void a(Context paramContext, SCGet3rdCloudCheck paramSCGet3rdCloudCheck)
  {
    try
    {
      if (!cl(paramContext.getApplicationContext())) {
        return;
      }
      if (paramSCGet3rdCloudCheck.tipsType == 1)
      {
        aV(paramContext, 3);
        aU(paramContext, 398679);
        return;
      }
      if (paramSCGet3rdCloudCheck.tipsType != 2) {
        break label103;
      }
      if (!WifiSDKUIApi.isWiFiManagerExist()) {
        break label91;
      }
      WifiSDKUIApi.gotoWifiAppSecurityPage(paramContext);
    }
    catch (Exception paramContext)
    {
      while (QLog.isColorLevel())
      {
        QLog.i("WifiSdk", 2, "onClickWifiSecurityBanner exception: " + paramContext.getMessage());
        return;
        label91:
        a(paramContext, 4, paramSCGet3rdCloudCheck.safeTypeList);
      }
      label103:
      if (paramSCGet3rdCloudCheck.tipsType != 3) {
        return;
      }
      if (TextUtils.isEmpty(paramSCGet3rdCloudCheck.h5)) {
        break label136;
      }
      cX(paramContext, paramSCGet3rdCloudCheck.h5);
      aU(paramContext, 500147);
      return;
      label136:
      aV(paramContext, 3);
      aU(paramContext, 398679);
    }
    aU(paramContext, 398681);
    return;
  }
  
  public static boolean a(Activity paramActivity, int paramInt, armm.a parama)
  {
    QLog.i("WifiSdk", 2, "shouldOverrideDialog scene: " + paramInt + ", file switch: " + dcj);
    if ((!dcj) || (!cl(paramActivity))) {}
    for (;;)
    {
      return true;
      String str1 = "";
      String str2 = "";
      int i;
      if (paramInt == 1)
      {
        str1 = paramActivity.getString(2131693877);
        str2 = paramActivity.getString(2131693880);
        i = 1;
      }
      while (i != 0)
      {
        String str5 = paramActivity.getString(2131693883);
        String str4 = arna.bC(paramActivity);
        String str3 = str4;
        if (TextUtils.isEmpty(str4)) {
          str3 = paramActivity.getString(2131693876);
        }
        QLog.i("WifiSdk", 2, "shouldOverrideDialog btn1Text: " + str3);
        a(paramActivity, str5, str1, str3, str2, parama, paramInt);
        return false;
        if ((paramInt == 2) || (paramInt == 4))
        {
          str1 = paramActivity.getString(2131693879);
          str2 = paramActivity.getString(2131693882);
          i = 1;
        }
        else if (paramInt == 3)
        {
          str1 = paramActivity.getString(2131693878);
          str2 = paramActivity.getString(2131693881);
          i = 1;
        }
        else if (paramInt == 5)
        {
          str1 = paramActivity.getString(2131693830);
          str2 = paramActivity.getString(2131693882);
          i = 1;
        }
        else
        {
          i = 0;
        }
      }
    }
  }
  
  public static void aU(Context paramContext, int paramInt)
  {
    if (cl(paramContext)) {
      WifiSDKUIApi.reportActionStat(paramInt);
    }
  }
  
  public static void aV(Context paramContext, int paramInt)
  {
    if (!cl(paramContext)) {
      return;
    }
    armz localarmz = armz.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    if (QLog.isColorLevel()) {
      QLog.i("WifiSdk", 2, "dialog click, jumpType: " + localarmz.jumpType + " jumpUrl: " + localarmz.jumpUrl);
    }
    if (WifiSDKUIApi.isWiFiManagerExist())
    {
      if (localarmz.jumpType == 4)
      {
        gotoWifiListPage(paramContext, paramInt);
        aU(paramContext, 500105);
        return;
      }
      WifiSDKUIApi.gotoWifiAppConnectPage(paramContext);
      aU(paramContext, 500101);
      return;
    }
    switch (localarmz.jumpType)
    {
    case 4: 
    default: 
      gotoWifiListPage(paramContext, paramInt);
      aU(paramContext, 500105);
      return;
    case 1: 
      cX(paramContext, localarmz.jumpUrl);
      aU(paramContext, 500102);
      return;
    case 3: 
      cX(paramContext, localarmz.jumpUrl);
      aU(paramContext, 500103);
      return;
    case 2: 
      gotoWifiListPage(paramContext, paramInt);
      aU(paramContext, 500104);
      return;
    }
    QLog.i("WifiSdk", 2, "gotoWifiFloorPage");
    if (cl(paramContext)) {
      PublicFragmentActivity.start(paramContext, new Intent(), QWifiFloorFragment.class);
    }
    aU(paramContext, 500177);
  }
  
  public static void ap(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    Object localObject;
    String str;
    if (paramBoolean)
    {
      localObject = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
      str = paramQQAppInterface.getCurrentAccountUin();
      dcj = ((SharedPreferences)localObject).getBoolean("wifi_connect_switch_file_" + str, false);
      dck = ((SharedPreferences)localObject).getBoolean("wifi_connect_switch_security_" + str, false);
      dcl = ((SharedPreferences)localObject).getBoolean("wifi_connect_switch_pdv_" + str, false);
    }
    if (QLog.isColorLevel()) {
      QLog.i("WifiSdk", 2, "startCheck start, Conversation.sConversationResumeFlag: " + Conversation.FL + ", file switch: " + dcj + ", security switch: " + dck + ", pdv switch: " + dcl);
    }
    try
    {
      if (((dck) || (dcl)) && (Conversation.FL > 0L))
      {
        localObject = paramQQAppInterface.getApp();
        str = paramQQAppInterface.getCurrentAccountUin();
        long l1 = System.currentTimeMillis();
        long l2 = arna.y((Context)localObject, str);
        long l3 = arna.bK((Context)localObject, str) * 60 * 60 * 1000L;
        if (QLog.isColorLevel()) {
          QLog.i("WifiSdk", 2, "startCheck, lastTime: " + l2 + " frequency: " + l3 + " nowTime: " + l1);
        }
        if ((l2 != -1L) && (l1 - l2 < l3))
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("WifiSdk", 2, "startCheck end, time limited");
          return;
        }
        arna.C((Context)localObject, str, l1);
        acoc localacoc = new acoc(paramQQAppInterface);
        acod localacod = new acod(paramQQAppInterface);
        localacod.a(new armn((Context)localObject, str, paramQQAppInterface, localacod));
        paramQQAppInterface.addObserver(localacod);
        localacoc.Kc(1);
      }
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel())
      {
        QLog.i("WifiSdk", 2, "startCheck exception: " + paramQQAppInterface.getMessage());
        return;
        if (dcj) {
          eI(paramQQAppInterface);
        }
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    String str = paramQQAppInterface.getCurrentUin();
    int j = aqmj.i(paramQQAppInterface.getApp(), "wifi_connect_config_version", str);
    if (QLog.isColorLevel()) {
      QLog.d("FreeWifiHelper", 2, String.format(Locale.getDefault(), "received wifi Config remote version: %d, localVersion: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    }
    if (i != j)
    {
      aqmj.g(paramQQAppInterface.getApp(), "wifi_connect_config_version", str, i);
      paramConfig = aevk.a(paramConfig, j, paramInt);
      if (!TextUtils.isEmpty(paramConfig))
      {
        QLog.d("WifiSdk", 2, "receiveAllConfigs|type: " + paramInt + ",content: " + paramConfig + ",version: " + i);
        try
        {
          paramConfig = new JSONObject(paramConfig);
          if (paramConfig.optInt("Wifi_file_and", 0) == 1)
          {
            bool = true;
            dcj = bool;
            if (paramConfig.optInt("Wifi_security_and", 0) != 1) {
              break label250;
            }
            bool = true;
            label193:
            dck = bool;
            if (paramConfig.optInt("Wifi_PDV_and", 0) != 1) {
              break label256;
            }
          }
          label256:
          for (boolean bool = true;; bool = false)
          {
            dcl = bool;
            aqmj.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), dcj, dck, dcl);
            ap(paramQQAppInterface, false);
            return;
            bool = false;
            break;
            label250:
            bool = false;
            break label193;
          }
          ap(paramQQAppInterface, true);
        }
        catch (JSONException paramConfig)
        {
          QLog.e("WifiSdk", 2, paramConfig, new Object[0]);
        }
      }
    }
  }
  
  public static void cX(Context paramContext, String paramString)
  {
    QLog.i("WifiSdk", 2, "gotoH5");
    if (cl(paramContext))
    {
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.setFlags(268435456);
      localIntent.putExtra("big_brother_source_key", "biz_src_wifi");
      paramContext.startActivity(localIntent);
    }
  }
  
  public static boolean cl(Context paramContext)
  {
    boolean bool = false;
    QLog.i("WifiSdk", 2, "init wifisdk. was: " + dch);
    if (dch) {
      return true;
    }
    if (dci)
    {
      QLog.e("WifiSdk", 2, "wifisdk last init failed");
      return false;
    }
    try
    {
      if (QLog.isDebugVersion()) {
        TMSDKWifiManager.setEnableLog(true);
      }
      if (!TMSDKWifiManager.init(paramContext.getApplicationContext(), new TMSDKCustomConfig().setCustomToast(new armw()).setCustomInstaller(new armv()).setCustomThreadPool(new armu()).setCustomReporter(new armt()))) {
        bool = true;
      }
      dci = bool;
      WifiSDKUIApi.init(new armx(), new army());
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        QLog.e("WifiSdk", 2, "wifisdk init failed: " + paramContext.getMessage());
        dci = true;
      }
    }
    if (!dci) {
      dch = true;
    }
    return dch;
  }
  
  public static void eH(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WifiSdk", 2, "registGuidIfNeed app: " + paramQQAppInterface);
    }
    if (paramQQAppInterface == null) {}
    String str;
    BaseApplication localBaseApplication;
    do
    {
      do
      {
        return;
        str = paramQQAppInterface.getCurrentAccountUin();
        localBaseApplication = paramQQAppInterface.getApp();
        localObject = arna.ao(localBaseApplication, str);
        if (QLog.isColorLevel()) {
          QLog.i("WifiSdk", 2, "registGuidIfNeed uin: " + str + " guid: " + (String)localObject);
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("WifiSdk", 2, "registGuidIfNeed uin: " + str + " guid is not null, do not regist");
      return;
      long l = arna.A(localBaseApplication, str);
      if ((l == -1L) || (System.currentTimeMillis() - l >= 86400000L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("WifiSdk", 2, "registGuidIfNeed, dont regit guid, time limit");
    return;
    if (QLog.isColorLevel()) {
      QLog.i("WifiSdk", 2, "registGuidIfNeed, start regist guid");
    }
    Object localObject = new acoc(paramQQAppInterface);
    acod localacod = new acod(paramQQAppInterface);
    localacod.a(new armo(paramQQAppInterface, localacod));
    paramQQAppInterface.addObserver(localacod);
    ((acoc)localObject).Kc(2);
    arna.E(localBaseApplication, str, System.currentTimeMillis());
  }
  
  public static void eI(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WifiSdk", 2, "requestTargetJumpInfoIfNeed app: " + paramQQAppInterface);
    }
    if (paramQQAppInterface == null) {}
    String str;
    BaseApplication localBaseApplication;
    do
    {
      return;
      str = paramQQAppInterface.getCurrentAccountUin();
      localBaseApplication = paramQQAppInterface.getApp();
      long l = arna.z(localBaseApplication, str);
      if ((l == -1L) || (System.currentTimeMillis() - l >= 86400000L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("WifiSdk", 2, "requestTargetJumpInfoIfNeed, dont request, time limit");
    return;
    if (QLog.isColorLevel()) {
      QLog.i("WifiSdk", 2, "requestTargetJumpInfoIfNeed, start request");
    }
    acoc localacoc = new acoc(paramQQAppInterface);
    acod localacod = new acod(paramQQAppInterface);
    localacod.a(new armp(paramQQAppInterface, localacod));
    paramQQAppInterface.addObserver(localacod);
    localacoc.Kc(3);
    arna.D(localBaseApplication, str, System.currentTimeMillis());
  }
  
  public static void gotoWifiListPage(Context paramContext, int paramInt)
  {
    QLog.i("WifiSdk", 2, "gotoWifiListPage");
    if (cl(paramContext))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("uiapi_k101", paramInt);
      localIntent.putExtra("big_brother_source_key", "biz_src_wifi");
      PublicFragmentActivity.start(paramContext, localIntent, QWifiListFragment.class);
    }
  }
  
  public static void iF(String paramString)
  {
    QLog.d("WifiSdk", 2, "WL_DEBUG reportClickEvent actionName = " + paramString);
    anot.a(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static abstract interface a
  {
    public abstract void callback(int paramInt);
  }
  
  public static class b
    implements acod.a
  {
    public void Kd(int paramInt) {}
    
    public void a(SCGet3rdCloudCheck paramSCGet3rdCloudCheck) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     armm
 * JD-Core Version:    0.7.0.1
 */