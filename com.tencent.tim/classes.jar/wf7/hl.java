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
  public static final String TAG = hl.class.getSimpleName();
  private static Drawable ti = null;
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
      String str = paramContext.getPackageName();
      Intent localIntent = new Intent();
      localIntent.setClassName("com.tencent.wifimanager", "com.tencent.server.fore.QuickLoadActivity");
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.putExtra("platform_id", str);
      localIntent.putExtra("launch_param", "{'dest_view':" + paramString + ",'show_id':'0','show_channel':'" + "102769" + "'}");
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
    for (;;)
    {
      try
      {
        localObject1 = fq.cr().getPackageManager();
        String str1 = fq.cr().getPackageName();
        String str2 = (String)((PackageManager)localObject1).getApplicationLabel(((PackageManager)localObject1).getApplicationInfo(str1, 0));
        localObject2 = paramContext.getPackageName();
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
          ((Intent)localObject1).putExtra("key_security", paramInt);
          ((Intent)localObject1).putExtra("hidesplash", true);
          ((Intent)localObject1).putExtra("package_name", str1);
          ((Intent)localObject1).putExtra("game_name", str2);
          paramString1 = ti;
          if (paramString1 == null) {}
        }
      }
      catch (Throwable paramContext)
      {
        Object localObject1;
        Object localObject2;
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
        continue;
      }
      ((Intent)localObject1).putExtra("value_ui_style_color", tj);
      ((Intent)localObject1).setFlags(402653184);
      ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_wifi");
      paramContext.startActivity((Intent)localObject1);
      return;
      localObject2 = new WifiConfig();
      ((WifiConfig)localObject2).ey = paramString1;
      ((WifiConfig)localObject2).eC = true;
      ((WifiConfig)localObject2).ez = paramInt;
      ((WifiConfig)localObject2).eE = 0;
      ((WifiConfig)localObject2).a(paramString2, false, 0, 0);
      ((Intent)localObject1).putExtra("wifi_config", (Parcelable)localObject2);
    }
  }
  
  public static void a(Drawable paramDrawable, int paramInt)
  {
    ti = paramDrawable;
    tj = paramInt;
  }
  
  public static int ab(String paramString)
  {
    int j = 0;
    int i = j;
    if (!TextUtils.isEmpty(paramString))
    {
      i = j;
      if (new File(paramString).exists()) {
        i = 1;
      }
    }
    return i;
  }
  
  private static int ac(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return -1;
      paramString = paramString.split("\\.");
    } while (paramString.length < 3);
    return Integer.parseInt(paramString[0]) * 100 + Integer.parseInt(paramString[1]) * 10 + Integer.parseInt(paramString[2]);
  }
  
  public static boolean ad(String paramString)
  {
    boolean bool = false;
    Object localObject = null;
    try
    {
      paramString = gv.dE().getPackageManager().getPackageInfo(paramString, 0);
      if (paramString != null) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = localObject;
      }
    }
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
        return;
      }
    }
    catch (Throwable paramContext) {}
  }
  
  public static boolean fo()
  {
    return ad("com.tencent.wifimanager");
  }
  
  public static boolean fp()
  {
    Object localObject = null;
    try
    {
      PackageInfo localPackageInfo = gv.dE().getPackageManager().getPackageInfo("com.tencent.wifimanager", 0);
      localObject = localPackageInfo;
    }
    catch (Exception localException)
    {
      label17:
      int i;
      int j;
      break label17;
    }
    if (localObject == null) {}
    do
    {
      do
      {
        return false;
        localObject = ((PackageInfo)localObject).versionName;
      } while (TextUtils.isEmpty((CharSequence)localObject));
      i = ac((String)localObject);
      j = ac("3.3.1");
    } while ((i == -1) || (j == -1) || (i < j));
    return true;
  }
  
  public static int i(String paramString1, String paramString2)
  {
    int j = 1;
    int i;
    if (ad(paramString1)) {
      i = 3;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (TextUtils.isEmpty(paramString2));
      i = j;
    } while (ab(paramString2) == 0);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.hl
 * JD-Core Version:    0.7.0.1
 */