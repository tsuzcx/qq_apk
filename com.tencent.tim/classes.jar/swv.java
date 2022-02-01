import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ThirdAppReportImpl.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.IBrowserThirdAppReport;
import mqq.app.IThirdAppOpenReport;

public class swv
  implements IThirdAppOpenReport
{
  public static void a(Intent paramIntent, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (!aciu.abf()) {
      return;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    String str3 = BaseApplicationImpl.processName;
    String str4 = paramIntent.getAction();
    String str1 = paramString2;
    if (paramString2 == null) {
      str1 = "";
    }
    String str2 = paramString3;
    if (paramString3 == null) {
      str2 = "";
    }
    paramString2 = paramIntent.getType();
    boolean bool1 = false;
    if (("android.intent.action.VIEW".equals(str4)) && ("application/vnd.android.package-archive".equalsIgnoreCase(paramString2)))
    {
      paramIntent = paramIntent.getData();
      paramString2 = FileProvider7Helper.getRealPathFromContentURI(localBaseApplication, paramIntent);
      bool1 = new File(paramString2).exists();
      if (QLog.isDevelopLevel()) {
        QLog.d("ThirdAppReport", 4, "install data-uri " + paramIntent.toString() + " real filePath = " + paramString2 + "isFileExists = " + bool1);
      }
      if (!bool1) {
        break label824;
      }
      paramIntent = localBaseApplication.getPackageManager().getPackageArchiveInfo(paramString2, 0);
      if (paramIntent != null) {
        paramIntent = paramIntent.packageName;
      }
    }
    for (bool1 = true;; bool1 = false)
    {
      paramString3 = "";
      boolean bool2 = true;
      Object localObject2 = "";
      Object localObject1 = paramIntent;
      paramIntent = paramString2;
      paramString2 = (String)localObject2;
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("ThirdAppReport", 4, String.format("params:sProcessName = %s,sComponentName = %s,dPkgName = %s,dAction = %s,dComponentName = %s,dScheme = %s,isInstall = %b,sInstallFilePath = = %s,fromType = %d,isValid = %b,sOriginalUrl = %s,sCurrentUrl = %s", new Object[] { str3, paramString1, localObject1, str4, paramString3, paramString2, Boolean.valueOf(bool2), paramIntent, Integer.valueOf(paramInt), Boolean.valueOf(bool1), str1, str2 }));
        }
        if ((!bool1) || (TextUtils.isEmpty((CharSequence)localObject1)) || (localBaseApplication.getPackageName().equalsIgnoreCase((String)localObject1))) {
          break;
        }
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("sComponentName", paramString1);
        ((HashMap)localObject2).put("sProcessName", str3);
        ((HashMap)localObject2).put("sFrom", String.valueOf(paramInt));
        ((HashMap)localObject2).put("dPkgName", localObject1);
        if (bool2)
        {
          ((HashMap)localObject2).put("installFilePath", paramIntent);
          label382:
          ((HashMap)localObject2).put("sOriginalUrl", str1);
          ((HashMap)localObject2).put("sCurrentUrl", str2);
          if (!bool2) {
            break label798;
          }
        }
        label652:
        label798:
        for (paramIntent = "ThirdAppInstall";; paramIntent = "ThirdAppOpen")
        {
          paramString1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          if (QLog.isColorLevel()) {
            QLog.d("ThirdAppReport", 2, "report real... ");
          }
          anpc.a(BaseApplicationImpl.getContext()).collectPerformance(paramString1, paramIntent, true, 0L, 0L, (HashMap)localObject2, null);
          return;
          paramIntent = "";
          break;
          localObject1 = paramIntent.getPackage();
          if (paramIntent.getComponent() != null)
          {
            paramString2 = paramIntent.getComponent().getClassName();
            label479:
            paramString3 = paramIntent.getDataString();
            paramIntent = localBaseApplication.getPackageManager().queryIntentActivities(paramIntent, 65536);
            QLog.d("ThirdAppReport", 4, "dPkgName = " + (String)localObject1 + " dInfoList = " + paramIntent);
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              break label652;
            }
            if ((paramIntent == null) || (paramIntent.size() <= 0)) {
              break label805;
            }
            localObject1 = (ResolveInfo)paramIntent.get(0);
            paramIntent = ((ResolveInfo)localObject1).activityInfo;
            if (paramIntent == null) {
              break label616;
            }
            paramString2 = paramIntent.name;
            paramIntent = paramIntent.packageName;
          }
          for (;;)
          {
            bool1 = true;
            localObject1 = paramIntent;
            paramIntent = "";
            bool2 = false;
            localObject2 = paramString2;
            paramString2 = paramString3;
            paramString3 = (String)localObject2;
            break;
            paramString2 = "";
            break label479;
            label616:
            if (((ResolveInfo)localObject1).serviceInfo != null)
            {
              paramIntent = ((ResolveInfo)localObject1).serviceInfo;
              paramString2 = paramIntent.name;
              paramIntent = paramIntent.packageName;
            }
            else
            {
              paramIntent = ((ResolveInfo)localObject1).resolvePackageName;
            }
          }
          if ((paramIntent == null) || (paramIntent.size() <= 0)) {
            break label805;
          }
          localObject2 = paramIntent.iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            paramIntent = (ResolveInfo)((Iterator)localObject2).next();
          } while (!((String)localObject1).equalsIgnoreCase(paramIntent.resolvePackageName));
          localObject2 = paramIntent.activityInfo;
          if (localObject2 != null) {
            paramString2 = ((ActivityInfo)localObject2).name;
          }
          for (;;)
          {
            bool1 = true;
            paramIntent = "";
            bool2 = false;
            localObject2 = paramString2;
            paramString2 = paramString3;
            paramString3 = (String)localObject2;
            break;
            if (paramIntent.serviceInfo != null) {
              paramString2 = paramIntent.serviceInfo.name;
            }
          }
          ((HashMap)localObject2).put("dActionName", str4);
          ((HashMap)localObject2).put("dCompomentName", paramString3);
          ((HashMap)localObject2).put("dSchema", paramString2);
          break label382;
        }
        label805:
        paramIntent = "";
        bool2 = false;
        localObject2 = paramString2;
        paramString2 = paramString3;
        paramString3 = (String)localObject2;
      }
      label824:
      paramIntent = "";
    }
  }
  
  public static void bBE()
  {
    Object localObject = wiq.a;
    if ((localObject != null) && (((wip)localObject).bNx == 1) && (!AppInterface.isAppOnForeground(BaseApplicationImpl.getContext())))
    {
      localObject = new Throwable("background_start_activity");
      StackTraceElement[] arrayOfStackTraceElement = ((Throwable)localObject).getStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfStackTraceElement[i].toString());
        i += 1;
      }
      annt.e((Throwable)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("ThirdAppReport", 2, QLog.getStackTraceString(new Throwable("background_start_activity")));
      }
    }
  }
  
  public void report(Context paramContext, Intent paramIntent, int paramInt)
  {
    if ((paramContext == null) || (paramIntent == null)) {}
    for (;;)
    {
      return;
      try
      {
        if (Build.VERSION.SDK_INT >= 21) {
          bBE();
        }
        Object localObject1 = paramIntent.getComponent();
        if (localObject1 != null)
        {
          localObject1 = ((ComponentName)localObject1).getPackageName();
          if (paramContext.getPackageName().equalsIgnoreCase((String)localObject1))
          {
            i = 0;
            if (i == 0) {
              continue;
            }
            if ((paramContext instanceof BaseActivity))
            {
              localObject1 = ((BaseActivity)paramContext).getCIOPageName();
              if (!(paramContext instanceof IBrowserThirdAppReport)) {
                break label175;
              }
              localObject2 = (IBrowserThirdAppReport)paramContext;
              paramContext = ((IBrowserThirdAppReport)localObject2).getOriginalUrl();
              localObject2 = ((IBrowserThirdAppReport)localObject2).getCurrentUrl();
              ThreadManager.excute(new ThirdAppReportImpl.1(this, paramIntent, (String)localObject1, paramInt, paramContext, (String)localObject2), 64, null, true);
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          int i;
          Object localObject2;
          QLog.e("ThirdAppReport", 1, localThrowable, new Object[0]);
          continue;
          String str;
          if ((paramContext instanceof PluginProxyActivity))
          {
            str = ((PluginProxyActivity)paramContext).getPluginActivity();
          }
          else
          {
            str = paramContext.getClass().getName();
            continue;
            label175:
            localObject2 = null;
            paramContext = null;
            continue;
            i = 1;
          }
        }
      }
    }
  }
  
  public void startActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    int i = 0;
    if (paramInt >= 0) {
      i = 0 + paramInt;
    }
    int j = i + 1 - 1;
    i = j;
    if (paramBundle != null) {
      i = j | 0x1;
    }
    j = i;
    if (paramActivity != null) {
      j = i >> 1;
    }
    i = j;
    if (paramIntent != null) {
      i = j + 1;
    }
    j = i;
    if (paramInt >= 0) {
      j = i + paramInt;
    }
    j = j + 1 - 1;
    i = j;
    if (paramBundle != null) {
      i = j | 0x1;
    }
    j = i;
    if (paramActivity != null) {
      j = i >> 1;
    }
    i = j;
    if (paramIntent != null) {
      i = j + 1;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ThirdAppReport", 4, i + "");
    }
    ahwd.a(paramActivity, paramIntent, paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     swv
 * JD-Core Version:    0.7.0.1
 */