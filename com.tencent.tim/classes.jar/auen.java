import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.WpsFileEditSaveDlgActivity;
import com.tencent.tim.filemanager.core.WpsFileEditManager;
import com.tencent.tim.filemanager.core.WpsFileEditManager.m;
import com.tencent.tim.filemanager.util.WpsFileEditUtil.5;
import com.tencent.tim.filemanager.widget.WpsFileEditToastStyleDlg;
import java.io.File;

public class auen
{
  public static boolean A(Activity paramActivity)
  {
    if (paramActivity == null) {
      return false;
    }
    QLog.i("WpsFileEditUtil", 1, "[WPSEDIT] openWpsInAppbaby...");
    if (isAppInstalled("com.tencent.android.qqdownloader")) {
      try
      {
        Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=cn.wps.moffice_eng"));
        localIntent.setPackage("com.tencent.android.qqdownloader");
        localIntent.addFlags(268435456);
        paramActivity.startActivity(localIntent);
        return true;
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
        return true;
      }
    }
    QLog.i("WpsFileEditUtil", 1, "[WPSEDIT] openWpsInAppbaby in web");
    paramActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://a.app.qq.com/o/simple.jsp?pkgname=cn.wps.moffice_eng")));
    return true;
  }
  
  public static PackageInfo a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo("cn.wps.moffice_eng", 0);
      return localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static boolean a(Activity paramActivity, String paramString, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramActivity == null) || (paramBundle1 == null) || (paramString == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("WpsFileEditUtil", 1, "[WPSEDIT] requestWpsEdit param error");
      QQToast.a(paramActivity, 1, paramActivity.getResources().getString(2131693888), 0).show();
      return false;
    }
    try
    {
      bool = new File(paramString).exists();
      if (!bool)
      {
        QLog.e("WpsFileEditUtil", 1, "[WPSEDIT] requestWpsEdit file not exist");
        QQToast.a(paramActivity, 1, paramActivity.getResources().getString(2131693886), 0).show();
        return false;
      }
    }
    catch (Exception paramBundle2)
    {
      for (;;)
      {
        paramBundle2.printStackTrace();
        boolean bool = false;
      }
      paramBundle2 = null;
      if ((paramActivity instanceof BaseActivity)) {
        paramBundle2 = ((BaseActivity)paramActivity).app;
      }
      Object localObject = a();
      if (localObject == null)
      {
        QLog.w("WpsFileEditUtil", 1, "[WPSEDIT] requestWpsEdit. wps not installed");
        A(paramActivity);
        return false;
      }
      if (((PackageInfo)localObject).versionCode < 212)
      {
        bl(paramBundle2, "0X8008B73");
        QLog.w("WpsFileEditUtil", 1, "[WPSEDIT] requestWpsEdit. wps ver too lower");
        aqha.a(paramActivity, 230, paramActivity.getResources().getString(2131693884), paramActivity.getResources().getString(2131693903), 2131693799, 2131693801, new aueo(paramBundle2, paramActivity), new auep(paramBundle2)).show();
        return false;
      }
      localObject = new Bundle();
      int i = WpsFileEditManager.a().a(paramString, paramBundle1, (Bundle)localObject);
      if (i != WpsFileEditManager.m.NONE)
      {
        QLog.w("WpsFileEditUtil", 1, "[WPSEDIT] requestWpsEdit. error happen. ret=" + i);
        QQToast.a(paramActivity, 1, paramActivity.getResources().getString(2131693888), 0).show();
        return false;
      }
      paramBundle2 = new Intent();
      paramBundle2.setComponent(new ComponentName("cn.wps.moffice_eng", "cn.wps.moffice.cooperation.OpenExternalDocsActivity"));
      paramBundle2.setAction("android.intent.action.VIEW");
      paramBundle2.addFlags(268435456);
      paramBundle2.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(paramString)));
      paramBundle2.putExtra("CookieData", ((Bundle)localObject).getByteArray("enCookeData"));
      paramBundle2.putExtra("CallbackUri", "timapi://wpsfileedit/callback?version=1");
      if (paramBundle1.getBoolean("IsWpsCloudFile", false))
      {
        localObject = paramBundle1.getString("WpsCloud_FileId");
        String str = paramBundle1.getString("WpsCloud_ParentId");
        paramBundle1 = paramBundle1.getString("WpsCloud_UserId");
        paramBundle2.putExtra("WpsCloud_FileId", (String)localObject);
        paramBundle2.putExtra("WpsCloud_ParentId", str);
        paramBundle2.putExtra("WpsCloud_UserId", paramBundle1);
      }
      FileProvider7Helper.intentCompatForN(paramActivity, paramBundle2);
    }
    try
    {
      paramActivity.startActivity(paramBundle2);
      QLog.i("WpsFileEditUtil", 1, "[WPSEDIT] requestWpsEdit. call wps edit. filePath:" + paramString);
      return true;
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        paramActivity.printStackTrace();
      }
    }
  }
  
  public static boolean a(BaseActivity paramBaseActivity, Intent paramIntent, Bundle paramBundle)
  {
    if ((paramBaseActivity == null) || (paramIntent == null))
    {
      QLog.e("WpsFileEditUtil", 1, "[WPSEDIT] onWpsEditResponse. param error!");
      return false;
    }
    if (paramBaseActivity.app == null)
    {
      QLog.e("WpsFileEditUtil", 1, "[WPSEDIT] onWpsEditResponse. app is null");
      return false;
    }
    if (!paramBaseActivity.app.isLogin())
    {
      QLog.e("WpsFileEditUtil", 1, "[WPSEDIT] onWpsEditResponse. no login");
      QQToast.a(paramBaseActivity, 1, paramBaseActivity.getResources().getString(2131693899), 0).show();
      return false;
    }
    if (paramIntent.getExtras() == null)
    {
      QLog.e("WpsFileEditUtil", 1, "[WPSEDIT] onWpsEditResponse. extras is null");
      return false;
    }
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("CookieData");
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      QLog.e("WpsFileEditUtil", 1, "[WPSEDIT] onWpsEditResponse. sResponseData_CookieData is null");
      QQToast.a(paramBaseActivity, 1, "数据解析出错，操作失败", 0).show();
      return false;
    }
    Object localObject = (Uri)paramIntent.getExtras().get("android.intent.extra.STREAM");
    if (localObject != null)
    {
      localObject = new File(((Uri)localObject).getPath());
      if (localObject == null) {}
    }
    for (localObject = ((File)localObject).getAbsolutePath();; localObject = null)
    {
      int i = paramIntent.getIntExtra("OpType", 0);
      boolean bool = paramIntent.getBooleanExtra("bnosave", false);
      QLog.i("WpsFileEditUtil", 1, "[WPSEDIT] onWpsEditResponse. optype:" + i + " wpsFilePath:" + (String)localObject + " bNosave:" + bool);
      paramIntent = new Bundle();
      paramIntent.putByteArray("CookieData", arrayOfByte);
      paramIntent.putInt("OpType", i);
      paramIntent.putString("WpsFilePath", (String)localObject);
      paramIntent.putBoolean("bnosave", bool);
      int j = WpsFileEditManager.a().l(paramIntent, paramBundle);
      if (j != WpsFileEditManager.m.NONE)
      {
        QLog.e("WpsFileEditUtil", 1, "[WPSEDIT] onWpsEditResponse. handle error.ret:" + j);
        if (j == WpsFileEditManager.m.eqV) {
          QQToast.a(paramBaseActivity, 1, paramBaseActivity.getResources().getString(2131693901), 0).show();
        }
        for (;;)
        {
          return false;
          if (j == WpsFileEditManager.m.DECODE_FAIL)
          {
            QQToast.a(paramBaseActivity, 1, paramBaseActivity.getResources().getString(2131693889), 0).show();
          }
          else if (j == WpsFileEditManager.m.erd)
          {
            QQToast.a(paramBaseActivity, 1, paramBaseActivity.getResources().getString(2131693900), 0).show();
          }
          else if (j == WpsFileEditManager.m.ere)
          {
            l = paramBundle.getLong("sessionid", 0L);
            aqha.a(paramBaseActivity, 230, paramBaseActivity.getResources().getString(2131693884), paramBaseActivity.getResources().getString(2131693895), 2131693887, 2131693904, new aueq(l), new auer(l)).show();
          }
          else
          {
            QQToast.a(paramBaseActivity, 1, "数据解析出错，操作失败(" + j + ")", 0).show();
          }
        }
      }
      long l = paramBundle.getLong("sessionid");
      paramBundle.getString("filePath");
      j = paramBundle.getInt("busType", 0);
      bool = paramBundle.getBoolean("fileChanged", false);
      if (i == 3)
      {
        bl(paramBaseActivity.app, "0X8008B7B");
        paramIntent = new Intent(paramBaseActivity, WpsFileEditSaveDlgActivity.class);
        paramIntent.putExtra("sessionid", l);
        paramIntent.putExtra("fileChanged", bool);
        paramIntent.putExtra("busType", j);
        paramBaseActivity.startActivity(paramIntent);
        paramBaseActivity.overridePendingTransition(0, 0);
      }
      for (;;)
      {
        return true;
        if ((i == 2) && (j != 6)) {
          WpsFileEditToastStyleDlg.a(paramBaseActivity, paramBaseActivity.getResources().getString(2131693896), WpsFileEditToastStyleDlg.ert, true);
        }
      }
    }
  }
  
  public static boolean aJn()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && ((localObject instanceof QQAppInterface))) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (!cx((QQAppInterface)localObject)) {
        return false;
      }
      long l = WpsFileEditManager.a().iy();
      if (l == 0L) {
        return false;
      }
      return System.currentTimeMillis() - l < 20000L;
    }
  }
  
  public static void bl(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("WpsFileEditUtil", 4, "[WPSEDIT] reportClick: act=" + paramString);
    }
  }
  
  public static boolean cv(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return aqmj.c(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), "disable_wps_fileedit", false);
  }
  
  public static boolean cw(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return aqmj.c(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), "disable_wps_fileedit_nowpsapp", false);
  }
  
  public static boolean cx(QQAppInterface paramQQAppInterface)
  {
    if (cv(paramQQAppInterface)) {}
    while ((cw(paramQQAppInterface)) && (a() == null)) {
      return false;
    }
    return true;
  }
  
  public static boolean dn(long paramLong)
  {
    return WpsFileEditManager.a().a().dl(paramLong);
  }
  
  public static void euK()
  {
    WpsFileEditManager.a().no(0L);
  }
  
  public static boolean isAppInstalled(String paramString)
  {
    boolean bool = false;
    PackageManager localPackageManager = BaseApplicationImpl.getApplication().getPackageManager();
    try
    {
      paramString = localPackageManager.getPackageInfo(paramString, 0);
      if (paramString != null) {
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static void n(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if ((paramInt == 6) && (!paramBoolean1) && (paramBoolean2)) {
      return;
    }
    new Handler(Looper.getMainLooper()).postDelayed(new WpsFileEditUtil.5(paramBoolean1, paramInt, paramBoolean2), 1500L);
  }
  
  public static void qw(String paramString)
  {
    QQToast.a(BaseApplicationImpl.sApplication, 1, paramString, 0).show();
  }
  
  public static boolean sW(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      int i = paramString.lastIndexOf(".");
      if (i >= 0)
      {
        paramString = paramString.substring(i).toLowerCase();
        String[] arrayOfString = ".doc&.docx&.ppt&.pptx&.xls&.xlsx&.pdf&.txt".split("&");
        int j = arrayOfString.length;
        i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(paramString)) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auen
 * JD-Core Version:    0.7.0.1
 */