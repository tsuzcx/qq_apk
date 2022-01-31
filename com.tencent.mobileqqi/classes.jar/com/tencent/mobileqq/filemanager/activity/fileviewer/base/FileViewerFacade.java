package com.tencent.mobileqq.filemanager.activity.fileviewer.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.os.StrictMode.VmPolicy.Builder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FMConfig.eOfflineFuntion;
import com.tencent.mobileqq.filemanager.data.FMConfig.eOpenForQQAppSubKey;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fxo;
import fxp;
import fxq;
import fxr;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class FileViewerFacade
{
  static final String a = "<FileAssistant>FileViewerFacade";
  
  public static int a(String paramString)
  {
    Iterator localIterator = BaseApplication.getContext().getPackageManager().getInstalledPackages(0).iterator();
    while (localIterator.hasNext())
    {
      PackageInfo localPackageInfo = (PackageInfo)localIterator.next();
      if (localPackageInfo.packageName.equalsIgnoreCase(paramString)) {
        return localPackageInfo.versionCode;
      }
    }
    return -1;
  }
  
  @SuppressLint({"NewApi"})
  static void a()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
      StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().penaltyDeath().build());
    }
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (paramQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.e("<FileAssistant>FileViewerFacade", 1, "app is null");
      }
    }
    do
    {
      return;
      if ((paramString1 == null) || (!FileUtil.a(paramString1)))
      {
        FMToastUtil.a(2131558735);
        return;
      }
      if (FileManagerUtil.b(paramQQAppInterface, paramString2) == true)
      {
        b(paramActivity, paramQQAppInterface, paramString1, paramString2);
        return;
      }
    } while (FileManagerUtil.a(paramQQAppInterface, paramString2) != true);
    c(paramActivity, paramQQAppInterface, paramString1, paramString2);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {}
    int i;
    do
    {
      String str;
      do
      {
        return false;
        str = FMConfig.a(paramQQAppInterface, FMConfig.eOfflineFuntion.OpenForQQMusic, FMConfig.eOpenForQQAppSubKey.SupportVersion);
      } while (str == null);
      i = Integer.valueOf(str).intValue();
    } while (a("com.tencent.qqmusic") < i);
    return b(paramQQAppInterface, paramString);
  }
  
  static void b(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    String str = FileUtil.a(paramString2);
    long l = FileUtil.a(paramString1);
    if (!a(paramQQAppInterface, paramString2))
    {
      paramString1 = new FileManagerReporter.fileAssistantReportData();
      paramString1.jdField_a_of_type_JavaLangString = "file_local_qqmusic_uninstall";
      paramString1.b = str;
      paramString1.jdField_a_of_type_Long = l;
      FileManagerReporter.a(paramQQAppInterface.a(), paramString1);
      a();
      DialogUtil.a(paramActivity, 233, paramActivity.getString(2131562518), paramActivity.getString(2131563273), new fxo(str, l, paramQQAppInterface, paramActivity), new fxp()).show();
      return;
    }
    paramString2 = new FileManagerReporter.fileAssistantReportData();
    paramString2.jdField_a_of_type_JavaLangString = "file_local_qqmusic_opened";
    paramString2.b = str;
    paramString2.jdField_a_of_type_Long = l;
    FileManagerReporter.a(paramQQAppInterface.a(), paramString2);
    paramQQAppInterface = new Intent("com.tencent.qqmusic.forthird.activity.PLAYER2");
    paramQQAppInterface.putExtra("file_path", paramString1);
    paramQQAppInterface.putExtra("from", 268435457);
    paramActivity.startActivity(paramQQAppInterface);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = FMConfig.a(paramQQAppInterface, FMConfig.eOfflineFuntion.OpenForQQMusic, FMConfig.eOpenForQQAppSubKey.FormatSupport);
    String str = FileUtil.a(paramString);
    if ((paramQQAppInterface != null) && (str != null) && (str.length() > 0) && (paramQQAppInterface.indexOf(str) >= 0)) {}
    while (FileManagerUtil.a(paramString) == 1) {
      return true;
    }
    return false;
  }
  
  static void c(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    String str = FileUtil.a(paramString2);
    long l = FileUtil.a(paramString1);
    if (!c(paramQQAppInterface, paramString2))
    {
      paramString1 = new FileManagerReporter.fileAssistantReportData();
      paramString1.jdField_a_of_type_JavaLangString = "file_local_qqbrowse_uninstall";
      paramString1.b = str;
      paramString1.jdField_a_of_type_Long = l;
      FileManagerReporter.a(paramQQAppInterface.a(), paramString1);
      a();
      DialogUtil.a(paramActivity, 233, paramActivity.getString(2131562563), paramActivity.getString(2131563272), new fxq(str, l, paramQQAppInterface, paramActivity), new fxr()).show();
      return;
    }
    paramString2 = new FileManagerReporter.fileAssistantReportData();
    paramString2.jdField_a_of_type_JavaLangString = "file_local_qqbrowse_opened";
    paramString2.b = str;
    paramString2.jdField_a_of_type_Long = l;
    FileManagerReporter.a(paramQQAppInterface.a(), paramString2);
    new Intent("com.tencent.QQBrowser.action.sdk.document");
    paramQQAppInterface = new Intent("com.tencent.QQBrowser.action.sdk.document");
    paramQQAppInterface.setFlags(268435456);
    paramString2 = new File(paramString1);
    paramQQAppInterface.putExtra("key_reader_sdk_id", 2);
    paramQQAppInterface.putExtra("key_reader_sdk_path", paramString1);
    paramQQAppInterface.putExtra("key_reader_sdk_type", 0);
    paramQQAppInterface.setData(Uri.fromFile(paramString2));
    paramActivity.startActivity(paramQQAppInterface);
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {}
    while (a("com.tencent.mtt") < 510000) {
      return false;
    }
    return d(paramQQAppInterface, paramString);
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = FileUtil.a(paramString);
    return (paramQQAppInterface != null) && (paramQQAppInterface.length() > 0) && (".txt|.doc|.docx|.ppt|.pdf|.epub|.zip|.rar|.mp4|.flv|.avi|.3gp|.3gpp|.webm|.ts|.ogv|.m3u8|.asf|.wmv|.rmvb|.rm|.f4v|.mkv|.dat|.mov|.mpg|.xls|.xlsx|.pptx|".indexOf(paramQQAppInterface) >= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileviewer.base.FileViewerFacade
 * JD-Core Version:    0.7.0.1
 */