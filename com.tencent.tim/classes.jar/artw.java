import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.PublicFragmentActivityForOpenSDK;
import com.tencent.open.agent.util.AuthorityUtil.1;
import com.tencent.qconn.protofile.appType.LoginSig;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.request.Ticket;
import tencent.im.login.GatewayVerify.ReqBody;
import tencent.im.login.GatewayVerify.ReqConnectLogin;

public class artw
{
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    paramContext = paramBitmap;
    if (paramBitmap == null) {
      paramContext = null;
    }
    return paramContext;
  }
  
  public static Bundle a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("platform", "1");
    localBundle.putString("result", paramString1);
    localBundle.putString("code", paramString2);
    localBundle.putString("tmcost", paramString3);
    localBundle.putString("rate", paramString4);
    localBundle.putString("cmd", paramString5);
    localBundle.putString("uin", paramString6);
    localBundle.putString("appid", paramString7);
    localBundle.putString("share_type", paramString8);
    localBundle.putString("detail", paramString9);
    localBundle.putString("os_ver", Build.VERSION.RELEASE);
    localBundle.putString("network", arwo.bE(aroi.a().getContext()));
    localBundle.putString("apn", arwo.K(aroi.a().getContext()));
    localBundle.putString("model_name", Build.MODEL);
    localBundle.putString("qq_ver", aroi.a().getAppVersionName());
    return localBundle;
  }
  
  public static Bundle a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString1);
    localBundle.putString("openid", paramString2);
    localBundle.putString("report_type", paramString3);
    localBundle.putString("act_type", paramString4);
    localBundle.putString("via", "2");
    localBundle.putString("app_id", paramString5);
    localBundle.putString("result", paramString6);
    localBundle.putString("type", paramString7);
    localBundle.putString("login_status", paramString8);
    localBundle.putString("need_user_auth", paramString9);
    localBundle.putString("to_uin", paramString10);
    localBundle.putString("to_type", paramString11);
    localBundle.putString("platform", "4");
    localBundle.putString("app_type", Integer.toString(2));
    return localBundle;
  }
  
  public static String a(Intent paramIntent, String paramString)
  {
    try
    {
      paramIntent = paramIntent.getStringExtra(paramString);
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      QLog.e("AuthorityUtil", 1, "getStringExtra :", paramIntent);
    }
    return null;
  }
  
  public static String a(AppRuntime paramAppRuntime, asav paramasav, appType.LoginSig paramLoginSig, String paramString1, String paramString2)
  {
    Object localObject = paramAppRuntime.getAccount();
    String str = paramasav.uin;
    boolean bool2 = ((OpenSDKAppInterface)paramAppRuntime).a().sD(str);
    boolean bool1;
    if ((!bool2) && (TextUtils.equals((CharSequence)localObject, str))) {
      if (a(paramasav.uin, paramAppRuntime, true) != null)
      {
        bool1 = true;
        boolean bool3 = a(paramasav.uin, paramAppRuntime);
        QLog.d("AuthorityUtil", 1, new Object[] { "getMsfCommand qq current account hasA2=", Boolean.valueOf(bool1), ", hasDa2=", Boolean.valueOf(bool3) });
        if ((!bool1) || (!bool3)) {
          break label122;
        }
        paramAppRuntime = paramString1;
      }
    }
    label122:
    do
    {
      return paramAppRuntime;
      bool1 = false;
      break;
      paramString1 = new appType.LoginSig();
      paramString1.type.set(8);
      localObject = a(paramasav.uin, paramAppRuntime, true);
      if ((!bool2) && (localObject != null) && (a(paramasav.uin, paramAppRuntime)))
      {
        QLog.d("AuthorityUtil", 1, "getMsfCommand use qq cache");
        paramString1.appid.set(16);
        paramString1.sig.set(ByteStringMicro.copyFrom((byte[])localObject));
        paramLoginSig.set(paramString1);
        return paramString2;
      }
      paramasav = a(paramasav.uin, paramAppRuntime, false);
      paramAppRuntime = paramString2;
    } while (paramasav == null);
    QLog.d("AuthorityUtil", 1, "getMsfCommand use opensdk cache");
    paramString1.appid.set(1600001540);
    paramString1.sig.set(ByteStringMicro.copyFrom(paramasav));
    paramLoginSig.set(paramString1);
    return paramString2;
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong, int paramInt2, int paramInt3, String paramString5)
  {
    try
    {
      aryb.a().b(paramInt1, paramString1, paramString2, paramString3, paramString4, paramLong, paramInt2, paramInt3, paramString5);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("AuthorityUtil", 1, "Exception", paramString1);
    }
  }
  
  public static void a(PBStringField paramPBStringField, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramPBStringField.set("support_110537=1");
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    try
    {
      arts.a().a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramBoolean, true);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("AuthorityUtil", 1, "Exception", paramString1);
    }
  }
  
  public static boolean a(String paramString, AppRuntime paramAppRuntime)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("AuthorityUtil", 1, "getDA2 false, currentAccount empty");
    }
    do
    {
      return false;
      if (paramAppRuntime == null)
      {
        QLog.e("AuthorityUtil", 1, "getDA2 false appInterface is null");
        return false;
      }
      paramAppRuntime = (TicketManager)paramAppRuntime.getManager(2);
      if (paramAppRuntime == null)
      {
        QLog.e("AuthorityUtil", 1, "getDA2 false TicketManager is null");
        return false;
      }
      paramString = paramAppRuntime.GetLocalTicket(paramString, 262144);
    } while (paramString == null);
    paramString = paramString._sig;
    if ((paramString != null) && (paramString.length != 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(WtloginManager paramWtloginManager, String paramString)
  {
    if (paramWtloginManager.IsNeedLoginWithPasswd(paramString, 16))
    {
      QLog.d("AuthorityUtil", 1, "IsNeedLoginWithPasswd appid=16, uin=" + qx(paramString));
      if (paramWtloginManager.IsNeedLoginWithPasswd(paramString, 1600001540))
      {
        QLog.d("AuthorityUtil", 1, "IsNeedLoginWithPasswd appid=1600001540, uin=" + qx(paramString));
        return true;
      }
    }
    QLog.d("AuthorityUtil", 1, "IsNeedLoginWithPasswd false uin=" + qx(paramString));
    return false;
  }
  
  public static byte[] a(String paramString, AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AuthorityUtil", 1, "getA2 false, currentAccount empty");
      return null;
    }
    if (paramAppRuntime == null)
    {
      QLog.e("AuthorityUtil", 1, "getA2 false appInterface is null");
      return null;
    }
    paramAppRuntime = (TicketManager)paramAppRuntime.getManager(2);
    if (paramAppRuntime == null)
    {
      QLog.e("AuthorityUtil", 1, "getA2 false TicketManager is null");
      return null;
    }
    String str;
    if (paramBoolean)
    {
      paramAppRuntime = paramAppRuntime.getA2(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      if (!paramBoolean) {
        break label151;
      }
      str = "host";
      label86:
      QLog.d("AuthorityUtil", 1, str + " getA2 uin=" + qx(paramString) + "  " + qx(paramAppRuntime));
      if (!TextUtils.isEmpty(paramAppRuntime)) {
        break label158;
      }
    }
    label151:
    label158:
    for (paramString = null;; paramString = aqhs.hexStr2Bytes(paramAppRuntime))
    {
      return paramString;
      paramAppRuntime = paramAppRuntime.getOpenSdkKey(paramString, 64);
      break;
      str = "opensdk";
      break label86;
    }
  }
  
  public static byte[] ah(String paramString)
  {
    GatewayVerify.ReqBody localReqBody = new GatewayVerify.ReqBody();
    GatewayVerify.ReqConnectLogin localReqConnectLogin = new GatewayVerify.ReqConnectLogin();
    localReqConnectLogin.str_connect_data.set("appid=" + paramString + "&sdkp=a");
    localReqBody.msg_req_connect_login.set(localReqConnectLogin);
    QLog.e("AuthorityUtil", 1, "getConnectData appid=" + paramString + "&sdkp=a");
    return localReqBody.toByteArray();
  }
  
  public static String b(Bundle paramBundle, String paramString1, String paramString2)
  {
    if (paramBundle == null)
    {
      QLog.e("AuthorityUtil", 1, "getString error, params==null");
      return paramString2;
    }
    if (!paramBundle.containsKey(paramString1))
    {
      QLog.e("AuthorityUtil", 1, "getString error, not comtain : " + paramString1);
      return paramString2;
    }
    paramBundle = paramBundle.get(paramString1);
    if ((paramBundle instanceof String)) {}
    for (paramBundle = (String)paramBundle;; paramBundle = paramString2) {
      return paramBundle;
    }
  }
  
  public static boolean b(WtloginManager paramWtloginManager, String paramString)
  {
    if (paramWtloginManager == null)
    {
      QLog.d("AuthorityUtil", 1, "isUserHaveA1 null == wtManager, uin=" + qx(paramString));
      return false;
    }
    if (paramWtloginManager.IsUserHaveA1(paramString, 16L))
    {
      QLog.d("AuthorityUtil", 1, "isUserHaveA1 appid=16, uin=" + qx(paramString));
      return true;
    }
    if (paramWtloginManager.IsUserHaveA1(paramString, 1600001540L))
    {
      QLog.d("AuthorityUtil", 1, "isUserHaveA1 appid=*540, uin=" + qx(paramString));
      return true;
    }
    QLog.d("AuthorityUtil", 1, "isUserHaveA1 false uin=" + qx(paramString));
    return false;
  }
  
  public static boolean d(AppRuntime paramAppRuntime, String paramString)
  {
    Object localObject = paramAppRuntime.getAccount();
    boolean bool2 = ((OpenSDKAppInterface)paramAppRuntime).a().sD(paramString);
    if ((!bool2) && (TextUtils.equals((CharSequence)localObject, paramString)))
    {
      if (a(paramString, paramAppRuntime, true) != null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        boolean bool3 = a(paramString, paramAppRuntime);
        QLog.d("AuthorityUtil", 1, new Object[] { "isUse540Ticket qq current account hasA2=", Boolean.valueOf(bool1), ", hasDa2=", Boolean.valueOf(bool3) });
        if ((!bool1) || (!bool3)) {
          break;
        }
        return false;
      }
    }
    localObject = a(paramString, paramAppRuntime, true);
    if ((!bool2) && (localObject != null) && (a(paramString, paramAppRuntime)))
    {
      QLog.d("AuthorityUtil", 1, "isUse540Ticket use qq cache");
      return false;
    }
    if (a(paramString, paramAppRuntime, false) != null)
    {
      QLog.d("AuthorityUtil", 1, "isUse540Ticket use opensdk cache");
      return true;
    }
    QLog.d("AuthorityUtil", 1, "isUse540Ticket use qq skey cache");
    return false;
  }
  
  public static void f(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()))
    {
      QLog.e("AuthorityUtil", 1, "showToast activity is null/finished");
      return;
    }
    paramActivity.runOnUiThread(new AuthorityUtil.1(paramActivity, paramBoolean, paramString));
  }
  
  public static String i(Activity paramActivity)
  {
    if (paramActivity == null) {
      if (QLog.isColorLevel()) {
        QLog.i("AuthorityUtil", 2, "getSrcPackageName activity is null");
      }
    }
    do
    {
      return null;
      paramActivity = paramActivity.getIntent().getBundleExtra("key_params");
      if (paramActivity != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("AuthorityUtil", 2, "getSrcPackageName bundle is null");
    return null;
    return paramActivity.getString("packagename");
  }
  
  public static void l(AppRuntime paramAppRuntime, String paramString)
  {
    QLog.d("AuthorityUtil", 1, new Object[] { "syncLoginAccount-", qx(paramString) });
    Object localObject = paramAppRuntime.getApplication().getAllAccounts();
    if (localObject != null) {
      if (((List)localObject).size() >= 8) {
        QLog.d("AuthorityUtil", 1, new Object[] { "syncLoginAccount-max count=", Integer.valueOf(((List)localObject).size()) });
      }
    }
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramString.equals(((SimpleAccount)((Iterator)localObject).next()).getUin()))
        {
          QLog.d("AuthorityUtil", 1, "syncLoginAccount-exist!!!");
          return;
        }
      }
      anot.a(null, "dc00898", "", "", "0X800AC2F", "0X800AC2F", 0, 0, "", "", "", "");
      QLog.d("AuthorityUtil", 1, new Object[] { "同步互联账户=0X800AC2F uin=", qx(paramString) });
      MsfSdkUtils.addLoginSimpleAccount(paramString, false);
      paramAppRuntime.getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
      paramAppRuntime = paramAppRuntime.getApplication().getAllAccounts();
      if (paramAppRuntime != null)
      {
        paramAppRuntime = paramAppRuntime.iterator();
        while (paramAppRuntime.hasNext())
        {
          paramString = (SimpleAccount)paramAppRuntime.next();
          QLog.d("AuthorityUtil", 1, "after syncLoginAccount " + qx(paramString.getUin()));
        }
      }
    }
  }
  
  public static String qx(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return "0";
      }
      paramString = paramString.substring(paramString.length() - 4);
      return paramString;
    }
    catch (Exception paramString) {}
    return "0";
  }
  
  public static String r(Context paramContext, String paramString1, String paramString2)
  {
    arwt.i("AuthorityUtil", "getOpenId uin = " + paramString1 + ", appid = " + paramString2);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    return asbf.getGlobalPreference(paramContext, "uin_openid_store").getString(paramString2 + ":" + paramString1, null);
  }
  
  public static boolean y(Activity paramActivity)
  {
    return ((paramActivity instanceof AuthorityActivity)) || ((paramActivity instanceof PublicFragmentActivityForOpenSDK));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     artw
 * JD-Core Version:    0.7.0.1
 */