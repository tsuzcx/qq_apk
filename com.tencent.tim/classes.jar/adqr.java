import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ark;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class adqr
{
  public static boolean bQr;
  public static int cJd = BaseChatItemLayout.bNS;
  public static int cJe = BaseChatItemLayout.bNT;
  public static int cJf = BaseChatItemLayout.displayWidth;
  public static int cJg = BaseChatItemLayout.displayWidth;
  private static int cJh;
  public static DisplayMetrics m;
  
  static
  {
    Lq(1);
  }
  
  private static void Lq(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
    int i = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    cJg = i;
    if (m == null) {
      m = localDisplayMetrics;
    }
    QLog.e("ArkApp.ArkAppCenterUtil", 1, new Object[] { "ArkFold.checkArkSize model=", Build.MODEL, ",screenWidth=", Integer.valueOf(i), ",sDisplayWith=", Integer.valueOf(cJf), ",scene=", Integer.valueOf(paramInt) });
    if ((i >= 1536) && (cJf != 840))
    {
      bQr = true;
      cJf = 840;
      cJd = (int)(cJf - 108.0F * getDensity());
      cJe = cJd - BaseChatItemLayout.bNX - BaseChatItemLayout.bNY;
      QLog.e("ArkApp.ArkAppCenterUtil", 1, new Object[] { "ArkFold.checkArkSize handle fold screen sChatBubbleMaxWidth=", Integer.valueOf(cJd), ",sDisplayWith=", Integer.valueOf(cJf), ",sChatTextViewMaxWidth=", Integer.valueOf(cJe) });
    }
  }
  
  public static String aP(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkAppCenterUtil", 2, "AAShare.CopyFileToCache appName is null or local path is null");
      }
      paramString1 = null;
    }
    String str;
    do
    {
      return paramString1;
      str = ArkEnvironmentManager.getInstance().getAppResPath(paramString1);
      int i = (int)(Math.random() * 10.0D);
      paramString1 = String.format("share_%d_%02d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i) });
      str = str + "/" + paramString1;
      paramString1 = "res:" + paramString1;
    } while (aqhq.copyFile(paramString2, str));
    return "";
  }
  
  public static boolean afw()
  {
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      Object localObject = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).a();
        if ((localObject != null) && ((localObject instanceof ycd))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static void c(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkAppCenterUtil", 2, new Object[] { "preDownloadArkApp download start,appName: ", paramString1, ",appView=", paramString2 });
    }
    ArkAppMgr.getInstance().getAppPathByName(paramString1, paramString2, "0.0.0.1", null, new adqs());
  }
  
  public static void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    if (paramConfiguration.screenWidthDp != cJh)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAppCenterUtil", 2, new Object[] { "ArkFold.BaseChatePie.onConfigurationChanged.mOldScreenDp=", Integer.valueOf(cJh), ",newScreenDp=", Integer.valueOf(paramConfiguration.screenWidthDp) });
      }
      cJh = paramConfiguration.screenWidthDp;
      Lq(2);
    }
  }
  
  public static float getDensity()
  {
    return BaseChatItemLayout.mDensity;
  }
  
  public static void k(String paramString, Context paramContext)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "ArkApp.ArkAppCenterUtil";
    }
    try
    {
      DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
      paramString = new StringBuilder("print density info:");
      paramString.append("\n model=").append(Build.MODEL).append(", ver=").append(Build.VERSION.RELEASE).append(",SDK=").append(Build.VERSION.SDK_INT).append("\n BaseChatItemLayout.density=").append(BaseChatItemLayout.mDensity).append("\n application density=").append(localDisplayMetrics.density).append("-").append(localDisplayMetrics.scaledDensity);
      if (paramContext != null)
      {
        paramContext = paramContext.getResources().getDisplayMetrics();
        paramString.append("\n activity density=").append(paramContext.density).append("-").append(paramContext.scaledDensity);
      }
      QLog.i(str, 1, paramString.toString());
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ArkApp.ArkAppCenterUtil", 1, "printScaleInfo Exception:", paramString);
    }
  }
  
  public static void onThemeChanged()
  {
    String str = sQ();
    QLog.d("ArkApp.ArkAppCenterUtil", 1, new Object[] { "onThemeChanged.appconfig=", str });
    try
    {
      ark.arkApplicationSetConfig(null, str);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      QLog.e("ArkApp.ArkAppCenterUtil", 1, "onThemeChanged.ark so not load.e=", localUnsatisfiedLinkError);
    }
  }
  
  public static String sQ()
  {
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject2 = new JSONObject();
        if (!anlm.ayn()) {
          continue;
        }
        localJSONObject2.put("mode", "concise");
        localJSONObject2.put("themeId", ThemeUtil.getCurrentThemeId());
        localJSONObject1.put("theme", localJSONObject2);
      }
      catch (JSONException localJSONException)
      {
        JSONObject localJSONObject2;
        QLog.e("ArkApp.ArkAppCenterUtil", 1, "Exception=", localJSONException);
        continue;
      }
      return localJSONObject1.toString();
      localJSONObject2.put("mode", "default");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adqr
 * JD-Core Version:    0.7.0.1
 */