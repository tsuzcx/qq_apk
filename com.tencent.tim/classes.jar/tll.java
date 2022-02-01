import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppBtnData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtBaseAdItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;

public class tll
{
  public static boolean J(Context paramContext, String paramString)
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = null;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramContext != null)
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label25;
      }
      bool2 = bool1;
    }
    label25:
    DownloadInfo localDownloadInfo;
    Object localObject;
    do
    {
      return bool2;
      if (QLog.isColorLevel()) {
        QLog.d("GdtAppOpenUtil", 2, " packageName:" + paramString);
      }
      localDownloadInfo = arvv.a().f(paramString);
      if (localDownloadInfo == null)
      {
        QLog.e("GdtAppOpenUtil", 2, " DownloadInfo == null");
        return false;
      }
      localObject = "";
      if (TextUtils.isEmpty(localDownloadInfo.filePath)) {
        break;
      }
      localObject = localDownloadInfo.filePath;
      bool1 = bool3;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        bool1 = bool3;
        if (new File((String)localObject).exists()) {
          bool1 = true;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("GdtAppOpenUtil", 2, "isPkgExist(" + bool1 + ")  packageName:" + paramString + ", path:" + (String)localObject);
    return bool1;
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
    if (localDownloadInfo.downloadType == 0)
    {
      localTMAssistantDownloadTaskInfo2 = arvv.a().b(localDownloadInfo.urlStr);
      paramContext = (Context)localObject;
      if (localTMAssistantDownloadTaskInfo2 != null)
      {
        paramContext = (Context)localObject;
        if (localTMAssistantDownloadTaskInfo2.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
        }
      }
      localObject = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localTMAssistantDownloadTaskInfo1 = arvv.a().a(localDownloadInfo);
        localObject = paramContext;
      }
    }
    for (;;)
    {
      paramContext = (Context)localObject;
      if (localTMAssistantDownloadTaskInfo1 != null)
      {
        paramContext = (Context)localObject;
        if (localTMAssistantDownloadTaskInfo1.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo1.mSavePath;
        }
      }
      localObject = paramContext;
      if (TextUtils.isEmpty(paramContext)) {
        break;
      }
      localDownloadInfo.filePath = paramContext;
      localDownloadInfo.setState(4);
      arvv.a().j(localDownloadInfo);
      localObject = paramContext;
      break;
      localTMAssistantDownloadTaskInfo2 = arvv.a().a(localDownloadInfo);
      paramContext = (Context)localObject;
      if (localTMAssistantDownloadTaskInfo2 != null)
      {
        paramContext = (Context)localObject;
        if (localTMAssistantDownloadTaskInfo2.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
        }
      }
      localObject = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localTMAssistantDownloadTaskInfo1 = arvv.a().b(localDownloadInfo.urlStr);
        localObject = paramContext;
      }
    }
  }
  
  public static boolean K(Context paramContext, String paramString)
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = null;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramContext != null)
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label25;
      }
      bool2 = bool1;
    }
    label25:
    DownloadInfo localDownloadInfo;
    Object localObject;
    do
    {
      do
      {
        return bool2;
        if (QLog.isColorLevel()) {
          QLog.d("GdtAppOpenUtil", 2, " apkUrlhttp :" + paramString);
        }
        localDownloadInfo = arvv.a().e(paramString);
        bool2 = bool1;
      } while (localDownloadInfo == null);
      localObject = "";
      if (TextUtils.isEmpty(localDownloadInfo.filePath)) {
        break;
      }
      localObject = localDownloadInfo.filePath;
      bool1 = bool3;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        bool1 = bool3;
        if (new File((String)localObject).exists()) {
          bool1 = true;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("GdtAppOpenUtil", 2, "isPkgExist(" + bool1 + ")  apkUrlhttp :" + paramString + ", path:" + (String)localObject);
    return bool1;
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
    if (localDownloadInfo.downloadType == 0)
    {
      localTMAssistantDownloadTaskInfo2 = arvv.a().b(localDownloadInfo.urlStr);
      paramContext = (Context)localObject;
      if (localTMAssistantDownloadTaskInfo2 != null)
      {
        paramContext = (Context)localObject;
        if (localTMAssistantDownloadTaskInfo2.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
        }
      }
      localObject = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localTMAssistantDownloadTaskInfo1 = arvv.a().a(localDownloadInfo);
        localObject = paramContext;
      }
    }
    for (;;)
    {
      paramContext = (Context)localObject;
      if (localTMAssistantDownloadTaskInfo1 != null)
      {
        paramContext = (Context)localObject;
        if (localTMAssistantDownloadTaskInfo1.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo1.mSavePath;
        }
      }
      localObject = paramContext;
      if (TextUtils.isEmpty(paramContext)) {
        break;
      }
      localDownloadInfo.filePath = paramContext;
      localDownloadInfo.setState(4);
      arvv.a().j(localDownloadInfo);
      localObject = paramContext;
      break;
      localTMAssistantDownloadTaskInfo2 = arvv.a().a(localDownloadInfo);
      paramContext = (Context)localObject;
      if (localTMAssistantDownloadTaskInfo2 != null)
      {
        paramContext = (Context)localObject;
        if (localTMAssistantDownloadTaskInfo2.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
        }
      }
      localObject = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localTMAssistantDownloadTaskInfo1 = arvv.a().b(localDownloadInfo.urlStr);
        localObject = paramContext;
      }
    }
  }
  
  public static int a(Context paramContext, AdAppBtnData paramAdAppBtnData)
  {
    if ((paramContext == null) || (paramAdAppBtnData == null)) {}
    do
    {
      do
      {
        return -1;
        paramContext = paramAdAppBtnData.packageName;
        paramAdAppBtnData = paramAdAppBtnData.apkUrlhttp;
      } while ((TextUtils.isEmpty(paramContext)) || (TextUtils.isEmpty(paramAdAppBtnData)));
      paramContext = arvv.a().e(paramAdAppBtnData);
    } while ((paramContext == null) || ((paramContext.getState() != 2) && (paramContext.getState() != 3)));
    return paramContext.progress;
  }
  
  private static Intent a(String paramString, Uri paramUri)
  {
    Intent localIntent = new Intent();
    if (paramUri != null) {
      localIntent.setData(paramUri);
    }
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.setPackage(paramString);
    }
    localIntent.putExtra("big_brother_source_key", "biz_src_ads");
    return localIntent;
  }
  
  public static boolean a(Context paramContext, GdtBaseAdItem paramGdtBaseAdItem)
  {
    if (!b(paramContext, paramGdtBaseAdItem)) {
      return c(paramContext, paramGdtBaseAdItem);
    }
    return true;
  }
  
  @Deprecated
  public static void b(GdtBaseAdItem paramGdtBaseAdItem)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      ((tkx)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(110)).a(BaseApplicationImpl.getContext(), paramGdtBaseAdItem);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(GdtBaseAdItem.class.getClassLoader());
    localBundle.putParcelable("gdtBaseAdItem", paramGdtBaseAdItem);
    QIPCClientHelper.getInstance().callServer("gdt_ipc", "do_app_jump", localBundle, null);
  }
  
  private static boolean b(Context paramContext, GdtBaseAdItem paramGdtBaseAdItem)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (f(paramContext, paramGdtBaseAdItem.packageName, paramGdtBaseAdItem.aJn))
    {
      Object localObject = Uri.parse(paramGdtBaseAdItem.aJn);
      localObject = a(paramGdtBaseAdItem.packageName, (Uri)localObject);
      if (paramGdtBaseAdItem.extra != null) {
        ((Intent)localObject).putExtras(paramGdtBaseAdItem.extra);
      }
      if (localObject != null) {
        bool1 = bool2;
      }
      try
      {
        paramContext.startActivity((Intent)localObject);
        boolean bool3 = true;
        bool2 = true;
        bool1 = bool3;
        tlg.n(137, paramGdtBaseAdItem.traceId, paramGdtBaseAdItem.productId);
        bool1 = bool3;
        s(paramContext, paramGdtBaseAdItem.aJm, paramGdtBaseAdItem.packageName);
        bool1 = bool3;
        tkw.d("GdtAppOpenUtil", "launchAPPDeepLink report " + paramGdtBaseAdItem.toString());
        bool1 = bool2;
        return bool1;
      }
      catch (Exception paramContext)
      {
        tkw.e("GdtAppOpenUtil", "launchAPPDeepLink failed", paramContext);
        return bool1;
      }
    }
    tkw.d("GdtAppOpenUtil", "launchAPPDeepLink isDLURISupported false");
    return false;
  }
  
  public static void bl(Bundle paramBundle)
  {
    arug.elJ();
    Object localObject1 = paramBundle.getString("schemaUrl");
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).contains("&"))) {
      if (!((String)localObject1).startsWith("http://")) {}
    }
    for (;;)
    {
      Object localObject4;
      try
      {
        String str = new URL((String)localObject1).getQuery();
        Object localObject5 = arug.y(str);
        localObject4 = (String)((HashMap)localObject5).get("appid");
        localObject1 = localObject4;
        localObject3 = str;
        if (TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject1 = (String)((HashMap)localObject5).get(aryv.PARAM_SNG_APPID);
          localObject3 = str;
        }
        str = arug.Dj() + File.separator + "qapp_center_detail.htm";
        localObject4 = new File(str);
        if (!((File)localObject4).exists()) {
          arwq.iH("Page/system", arug.Dk());
        }
        localObject5 = new Intent();
        Bundle localBundle = new Bundle();
        if (!((File)localObject4).exists()) {
          break label467;
        }
        str = "file:///" + str;
        localObject4 = "&from=-10&id=" + (String)localObject1 + "&channelId=" + "2410";
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!((String)localObject3).equals(localObject1))) {
          break label499;
        }
        localObject1 = localObject4;
        localObject3 = localObject1;
        if ("1".equals((String)arug.y(paramBundle.getString("schemaUrl")).get("auto_download")))
        {
          localObject3 = localObject1;
          if (!((String)localObject1).contains("auto_download")) {
            localObject3 = (String)localObject1 + "&auto_download=1";
          }
        }
        ((Intent)localObject5).setClass(aroi.a().getContext(), QZoneAppListActivity.class);
        localBundle.putString("APP_URL", str);
        localBundle.putBoolean("FROM_FEED", true);
        localBundle.putString("APP_PARAMS", (String)localObject3);
        localBundle.putInt("goto_type", 2);
        if (paramBundle.getInt("process_id") == 2) {
          localBundle.putInt("process_id", 2);
        }
        ((Intent)localObject5).putExtras(localBundle);
        ((Intent)localObject5).putExtra("adapter_action", "action_app_detail");
        ((Intent)localObject5).putExtra("big_brother_source_key", "biz_src_ads");
        ((Intent)localObject5).putExtra("big_brother_ref_source_key", paramBundle.getString("big_brother_ref_source_key"));
        ((Intent)localObject5).addFlags(872415232);
        aroi.a().getContext().startActivity((Intent)localObject5);
        return;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
      }
      Object localObject2 = localObject1;
      continue;
      Object localObject3 = localObject1;
      continue;
      label467:
      localObject2 = arug.Dp() + File.separator + "qapp_center_detail.htm";
      continue;
      label499:
      localObject1 = (String)localObject4 + "&" + (String)localObject3;
    }
  }
  
  public static boolean c(Context paramContext, GdtBaseAdItem paramGdtBaseAdItem)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool2;
    Intent localIntent;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramGdtBaseAdItem.packageName))
      {
        localIntent = g(paramGdtBaseAdItem.packageName);
        bool1 = bool2;
        if (localIntent != null)
        {
          localIntent.putExtra("big_brother_source_key", "biz_src_ads");
          if (paramGdtBaseAdItem.extra != null) {
            localIntent.putExtras(paramGdtBaseAdItem.extra);
          }
          bool1 = bool3;
        }
      }
    }
    try
    {
      paramContext.startActivity(localIntent);
      bool3 = true;
      bool2 = true;
      bool1 = bool3;
      tlg.n(138, paramGdtBaseAdItem.traceId, paramGdtBaseAdItem.productId);
      bool1 = bool3;
      s(paramContext, paramGdtBaseAdItem.aJm, paramGdtBaseAdItem.packageName);
      bool1 = bool3;
      tkw.d("GdtAppOpenUtil", "launchAPPMain report " + paramGdtBaseAdItem.toString());
      bool1 = bool2;
      return bool1;
    }
    catch (Exception paramContext)
    {
      tkw.e("GdtAppOpenUtil", "launchApp failed", paramContext);
    }
    return bool1;
  }
  
  public static boolean f(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString2))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString1))
        {
          paramString2 = Uri.parse(paramString2);
          bool1 = bool2;
          if (!"http".equalsIgnoreCase(paramString2.getScheme()))
          {
            bool1 = bool2;
            if (!"https".equalsIgnoreCase(paramString2.getScheme()))
            {
              paramString1 = a(paramString1, paramString2);
              bool1 = bool2;
              if (paramContext.getPackageManager().resolveActivity(paramString1, 65536) != null) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private static Intent g(String paramString)
  {
    return BaseApplicationImpl.getContext().getPackageManager().getLaunchIntentForPackage(paramString);
  }
  
  public static boolean gI(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (!"http".equalsIgnoreCase(paramString.getScheme()))
      {
        bool1 = bool2;
        if (!"https".equalsIgnoreCase(paramString.getScheme())) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static int getCurrentPkgDownloadProgress(Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return -1;
      paramContext = arvv.a().e(paramString2);
    } while ((paramContext == null) || ((paramContext.getState() != 2) && (paramContext.getState() != 3)));
    return paramContext.progress;
  }
  
  public static int isPkgDownloadPaused(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return -1;
            if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("GdtAppOpenUtil", 2, "isPkgDownloading pkg:" + paramString1 + ", apkUrlhttp :" + paramString2 + " false");
          return -1;
          paramContext = arvv.a().e(paramString2);
          if (paramContext != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("GdtAppOpenUtil", 2, "isPkgDownloading pkg:" + paramString1 + ", apkUrlhttp :" + paramString2 + " false");
        return -1;
        if (paramContext.getState() != 3) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("GdtAppOpenUtil", 2, "isPkgDownloading pkg:" + paramString1 + ", apkUrlhttp :" + paramString2 + " true");
        }
      } while ((TextUtils.isEmpty(paramContext.filePath)) || (!new File(paramContext.filePath + ".temp").exists()));
      return paramContext.progress;
    } while (!QLog.isColorLevel());
    QLog.d("GdtAppOpenUtil", 2, "isPkgDownloading pkg:" + paramString1 + ", apkUrlhttp :" + paramString2 + " false");
    return -1;
  }
  
  public static int isPkgDownloading(Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      if (QLog.isColorLevel()) {
        QLog.d("GdtAppOpenUtil", 2, "isPkgDownloading pkg:" + paramString1 + ", apkUrlhttp :" + paramString2 + " false");
      }
    }
    do
    {
      do
      {
        return -1;
        paramContext = arvv.a().e(paramString2);
        if (paramContext != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("GdtAppOpenUtil", 2, "isPkgDownloading pkg:" + paramString1 + ", apkUrlhttp :" + paramString2 + " false");
      return -1;
      if (paramContext.getState() == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GdtAppOpenUtil", 2, "isPkgDownloading pkg:" + paramString1 + ", apkUrlhttp :" + paramString2 + " true");
        }
        return paramContext.progress;
      }
    } while (!QLog.isColorLevel());
    QLog.d("GdtAppOpenUtil", 2, "isPkgDownloading pkg:" + paramString1 + ", apkUrlhttp :" + paramString2 + " false");
    return -1;
  }
  
  public static boolean isWifiConnected()
  {
    return aqiw.isWifiConnected(BaseApplicationImpl.getContext());
  }
  
  public static HashMap<String, String> n(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (paramString != null)
    {
      int i = paramString.indexOf("?");
      Object localObject = paramString;
      if (i >= 0) {
        localObject = paramString.substring(i + 1);
      }
      paramString = ((String)localObject).split("&");
      if (paramString != null)
      {
        int j = paramString.length;
        i = 0;
        while (i < j)
        {
          localObject = paramString[i].split("=");
          if (localObject.length > 1)
          {
            String str = URLDecoder.decode(localObject[1]);
            localHashMap.put(localObject[0], str);
          }
          i += 1;
        }
      }
    }
    return localHashMap;
  }
  
  private static void s(Context paramContext, String paramString1, String paramString2)
  {
    acly.j("scheme", paramString1, paramString2, "4", "gdtAppAd", paramContext.getClass().getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tll
 * JD-Core Version:    0.7.0.1
 */