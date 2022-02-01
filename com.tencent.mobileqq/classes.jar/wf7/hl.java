package wf7;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.qqpimsecure.wificore.api.connect.WifiConfig;
import com.tencent.wifisdk.TMSDKCustomConfig;
import com.tencent.wifisdk.TMSDKCustomConfig.IInstaller;
import com.tencent.wifisdk.TMSDKWifiManager;
import java.io.File;

public class hl
{
  public static final String TAG = "hl";
  private static Drawable ti;
  private static int tj = -1;
  
  public static void H(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageName();
      Intent localIntent = new Intent();
      localIntent.setClassName("com.tencent.wifimanager", "com.tencent.server.fore.QuickLoadActivity");
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.putExtra("platform_id", str);
      localIntent.putExtra("launch_param", "{'dest_view':11993089,'show_id':'0','show_channel':'102769'}");
      localIntent.setFlags(402653184);
      localIntent.putExtra("big_brother_source_key", "biz_src_wifi");
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      Object localObject = paramContext.getPackageName();
      Intent localIntent = new Intent();
      localIntent.setClassName("com.tencent.wifimanager", "com.tencent.server.fore.QuickLoadActivity");
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.putExtra("platform_id", (String)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("{'dest_view':");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",'show_id':'0','show_channel':'");
      ((StringBuilder)localObject).append("102769");
      ((StringBuilder)localObject).append("'}");
      localIntent.putExtra("launch_param", ((StringBuilder)localObject).toString());
      localIntent.putExtra("id", paramInt);
      localIntent.setFlags(402653184);
      localIntent.putExtra("big_brother_source_key", "biz_src_wifi");
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    try
    {
      localObject1 = fq.cr().getPackageManager();
      String str1 = fq.cr().getPackageName();
      String str2 = (String)((PackageManager)localObject1).getApplicationLabel(((PackageManager)localObject1).getApplicationInfo(str1, 0));
      Object localObject2 = paramContext.getPackageName();
      localObject1 = new Intent();
      ((Intent)localObject1).setClassName("com.tencent.wifimanager", "com.tencent.server.fore.QuickLoadActivity");
      ((Intent)localObject1).setAction("android.intent.action.VIEW");
      ((Intent)localObject1).putExtra("platform_id", (String)localObject2);
      ((Intent)localObject1).putExtra("launch_param", "{'dest_view':11993147,'show_id':'1','show_channel':'102769'}");
      ((Intent)localObject1).putExtra("auto_connect_wifi", false);
      ((Intent)localObject1).putExtra("enter_main_page_src_key", 47);
      ((Intent)localObject1).putExtra("connection_affair_src", 47);
      ((Intent)localObject1).putExtra("page_transition_style", 1);
      if (TextUtils.isEmpty(paramString2))
      {
        ((Intent)localObject1).putExtra("key_session_name", paramString1);
      }
      else
      {
        localObject2 = new WifiConfig();
        ((WifiConfig)localObject2).ey = paramString1;
        ((WifiConfig)localObject2).eC = true;
        ((WifiConfig)localObject2).ez = paramInt;
        ((WifiConfig)localObject2).eE = 0;
        ((WifiConfig)localObject2).a(paramString2, false, 0, 0);
        ((Intent)localObject1).putExtra("wifi_config", (Parcelable)localObject2);
      }
      ((Intent)localObject1).putExtra("key_security", paramInt);
      ((Intent)localObject1).putExtra("hidesplash", true);
      ((Intent)localObject1).putExtra("package_name", str1);
      ((Intent)localObject1).putExtra("game_name", str2);
      paramString1 = ti;
      if (paramString1 == null) {}
    }
    catch (Throwable paramContext)
    {
      Object localObject1;
      label266:
      paramContext.printStackTrace();
      return;
    }
    try
    {
      paramString1 = hj.a(ti);
      if (paramString1 != null) {
        ((Intent)localObject1).putExtra("icon_img", hj.a(paramString1));
      }
    }
    catch (Exception paramString1)
    {
      break label266;
    }
    ((Intent)localObject1).putExtra("value_ui_style_color", tj);
    ((Intent)localObject1).setFlags(402653184);
    ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_wifi");
    paramContext.startActivity((Intent)localObject1);
  }
  
  public static void a(Drawable paramDrawable, int paramInt)
  {
    ti = paramDrawable;
    tj = paramInt;
  }
  
  public static int ab(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (new File(paramString).exists())) {
      return 1;
    }
    return 0;
  }
  
  private static int ac(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int i = -1;
    if (bool) {
      return -1;
    }
    paramString = paramString.split("\\.");
    if (paramString.length >= 3) {
      i = Integer.parseInt(paramString[0]) * 100 + Integer.parseInt(paramString[1]) * 10 + Integer.parseInt(paramString[2]);
    }
    return i;
  }
  
  public static boolean ad(String paramString)
  {
    boolean bool = false;
    try
    {
      paramString = gv.dE().getPackageManager().getPackageInfo(paramString, 0);
    }
    catch (Exception paramString)
    {
      label17:
      break label17;
    }
    paramString = null;
    if (paramString != null) {
      bool = true;
    }
    return bool;
  }
  
  public static void b(Context paramContext, int paramInt, String paramString)
  {
    hk.az(500113);
    try
    {
      if (!new File(paramString).exists()) {
        return;
      }
      TMSDKCustomConfig.IInstaller localIInstaller = TMSDKWifiManager.getCustomConfig().getCustomInstaller();
      if (localIInstaller != null)
      {
        localIInstaller.installApp(paramContext, paramString);
        paramContext = fm.dL();
        paramContext.f(System.currentTimeMillis());
        paramContext.aq(paramInt);
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static boolean fo()
  {
    return ad("com.tencent.wifimanager");
  }
  
  public static boolean fp()
  {
    boolean bool2 = false;
    try
    {
      localObject = gv.dE().getPackageManager().getPackageInfo("com.tencent.wifimanager", 0);
    }
    catch (Exception localException)
    {
      Object localObject;
      label19:
      int i;
      int j;
      boolean bool1;
      break label19;
    }
    localObject = null;
    if (localObject == null) {
      return false;
    }
    localObject = ((PackageInfo)localObject).versionName;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return false;
    }
    i = ac((String)localObject);
    j = ac("3.3.1");
    bool1 = bool2;
    if (i != -1)
    {
      if (j == -1) {
        return false;
      }
      bool1 = bool2;
      if (i >= j) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static int i(String paramString1, String paramString2)
  {
    if (ad(paramString1)) {
      return 3;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return 1;
    }
    if (ab(paramString2) != 0) {
      return 2;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.hl
 * JD-Core Version:    0.7.0.1
 */