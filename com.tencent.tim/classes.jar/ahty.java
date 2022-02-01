import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ahty
{
  public static List<String> Cg = new ArrayList(3);
  public static String bLJ;
  public static int dbb = 3;
  public static int dbc = 30000;
  public static int dbd = 7000;
  public static int dbe = 7;
  
  static
  {
    bLJ = "";
  }
  
  public static int Fk()
  {
    int j = aenc.a().cNP;
    int i = j;
    if (j == 0) {
      i = dbe;
    }
    return i;
  }
  
  public static int Fl()
  {
    return aene.a().cNS;
  }
  
  public static void a(Context paramContext, FeedsItemData.GameInfo paramGameInfo)
  {
    if (paramGameInfo == null) {}
    while (aqiz.isAppInstalled(paramContext, paramGameInfo.gamePkgName)) {
      return;
    }
    awok.eEF();
    paramContext = new WadlParams();
    paramContext.from = 6;
    paramContext.setFlags(7);
    paramContext.apkChannel = "10000144";
    paramContext.apkUrl = paramGameInfo.gameApkUrl;
    paramContext.appId = paramGameInfo.gameAppId;
    paramContext.versionCode = Integer.parseInt(paramGameInfo.gameVersionCode);
    paramContext.packageName = paramGameInfo.gamePkgName;
    paramContext.sourceId = "biz_src_zf_games";
    paramContext.via = "publicAccount";
    paramContext.appName = paramGameInfo.gameName;
    paramContext.iconUrl = paramGameInfo.gameIcon;
    paramContext.ekZ = 2;
    paramContext.bLE = "publicAccount";
    awok.a().h(paramContext);
  }
  
  public static void a(Bundle paramBundle, String paramString, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfigUtil", 2, "downloadGame appId=" + paramString + ",isRes=" + paramBoolean + ",resType=" + paramInt + ",req=" + paramBundle);
    }
    String str = paramBundle.getString("pkgName");
    if ((paramBundle == null) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(str))) {
      return;
    }
    Object localObject2 = paramBundle.getString("apkChannel");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "10000144";
    }
    awok.eEF();
    localObject2 = new WadlParams();
    ((WadlParams)localObject2).from = paramBundle.getInt("from");
    ((WadlParams)localObject2).setFlags(paramBundle.getInt("flags"));
    ((WadlParams)localObject2).apkChannel = ((String)localObject1);
    ((WadlParams)localObject2).apkUrl = paramBundle.getString("apkUrl");
    ((WadlParams)localObject2).appId = paramString;
    ((WadlParams)localObject2).versionCode = paramBundle.getInt("versionCode");
    ((WadlParams)localObject2).packageName = str;
    localObject1 = paramBundle.getString("appName");
    paramString = (String)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString = ((WadlParams)localObject2).packageName;
    }
    ((WadlParams)localObject2).appName = paramString;
    ((WadlParams)localObject2).sourceId = "biz_src_zf_games";
    ((WadlParams)localObject2).via = paramBundle.getString("via");
    ((WadlParams)localObject2).ekZ = 2;
    ((WadlParams)localObject2).dqZ = paramBoolean;
    if (paramBoolean)
    {
      ((WadlParams)localObject2).resType = paramInt;
      ((WadlParams)localObject2).cII = paramBundle.getInt("resIndex");
      ((WadlParams)localObject2).resName = paramBundle.getString("resName");
      ((WadlParams)localObject2).cRP = paramBundle.getString("resVersionName");
      ((WadlParams)localObject2).resMD5 = paramBundle.getString("resMD5");
    }
    awok.a().h((WadlParams)localObject2);
  }
  
  public static boolean anY()
  {
    aenb localaenb = aenc.a();
    if ((localaenb != null) && (localaenb.cNO > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGameConfigUtil", 2, "isPubAccountSwitch = true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfigUtil", 2, "isPubAccountSwitch = false");
    }
    return false;
  }
  
  public static boolean anZ()
  {
    boolean bool2 = false;
    Object localObject = aenc.a();
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((aenb)localObject).cNQ > 0)
      {
        localObject = ((aenb)localObject).bzG;
        bool1 = bool2;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          bool1 = bool2;
          if (aurr.isValidUrl((String)localObject)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean aoa()
  {
    aend localaend = aene.a();
    if ((localaend != null) && (localaend.cNR > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGameConfigUtil", 2, "isPreloadSwitch = true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfigUtil", 2, "isPreloadSwitch = false");
    }
    return false;
  }
  
  public static void cB(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfigUtil", 2, "pauseDownload from=" + paramInt + ",appId=" + paramString);
    }
    awok.eEF();
    awok.a().eE(paramInt, paramString);
  }
  
  public static void cC(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfigUtil", 2, "deleteDownload from=" + paramInt + ",appId=" + paramString);
    }
    awok.eEF();
    awok.a().cC(paramInt, paramString);
  }
  
  public static void cX(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("game_center_sp", 0);
    String str = "sp_key_game_center_feeds_show_float_window_date" + paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = "sp_key_game_center_feeds_float_window_showed_games" + paramQQAppInterface.getCurrentAccountUin();
    bLJ = localSharedPreferences.getString(str, "");
    if (wI().equals(bLJ))
    {
      paramQQAppInterface = localSharedPreferences.getString(paramQQAppInterface, "");
      if ((TextUtils.isEmpty(paramQQAppInterface)) || (paramQQAppInterface.split(";").length == 0)) {
        Cg = new ArrayList(3);
      }
      for (;;)
      {
        return;
        paramQQAppInterface = paramQQAppInterface.split(";");
        Cg = new ArrayList(3);
        while (i < paramQQAppInterface.length)
        {
          Cg.add(paramQQAppInterface[i]);
          i += 1;
        }
      }
    }
    bLJ = wI();
    Cg = new ArrayList(3);
  }
  
  public static void d(WadlParams paramWadlParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfigUtil", 2, "installGame params=" + paramWadlParams);
    }
    awok.eEF();
    awok.a().c(paramWadlParams);
  }
  
  public static int getNetWorkType()
  {
    if (!AppNetConnInfo.isNetSupport()) {}
    do
    {
      return 0;
      if (AppNetConnInfo.isWifiConn()) {
        return 1;
      }
    } while (!AppNetConnInfo.isMobileConn());
    switch (AppNetConnInfo.getMobileInfo())
    {
    case -1: 
    default: 
      return -1;
    case 0: 
    case 1: 
      return 2;
    case 2: 
      return 3;
    case 3: 
      return 4;
    }
    return 6;
  }
  
  public static String getPreloadUrl()
  {
    String str2 = aene.a().bzI;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "https://imgcache.qq.com/ogame/sgame-official-account/precache.html";
    }
    return str1;
  }
  
  public static boolean mR(String paramString)
  {
    if (Cg == null) {
      Cg = new ArrayList(3);
    }
    return (Cg.size() < 3) && (!Cg.contains(paramString));
  }
  
  public static String wG()
  {
    String str2 = aenc.a().bzG;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    return str1;
  }
  
  public static String wH()
  {
    String str2 = aenc.a().bzH;
    String str1;
    if (TextUtils.isEmpty(str2)) {
      str1 = "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=gzh&_wv=18950115&_wwv=393";
    }
    do
    {
      do
      {
        return str1;
        if (TextUtils.isEmpty(str2)) {
          break;
        }
        str1 = str2;
      } while (str2.startsWith("http://"));
      str1 = str2;
    } while (str2.startsWith("https://"));
    return "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=gzh&_wv=18950115&_wwv=393";
  }
  
  public static String wI()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("yyyy-MM-dd").format(localDate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahty
 * JD-Core Version:    0.7.0.1
 */