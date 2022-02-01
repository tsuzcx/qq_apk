package com.tencent.qqmail.attachment.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Parcelable;
import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.compose.ComposeNoteActivity;
import com.tencent.qqmail.activity.compose.LocalDraftUtils;
import com.tencent.qqmail.attachment.model.AttachPreviewType;
import com.tencent.qqmail.attachment.model.QMSpreadAPPInfo;
import com.tencent.qqmail.attachment.model.QMqqBrowserInfo;
import com.tencent.qqmail.marcos.ChannelDefine;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.channelmarket.ChannelMarketUtil;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.otherapprule.OtherAppConfigUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import moai.oss.KvHelper;
import moai.oss.OssHelper;

public class IntentUtil
{
  private static final String[][] MIME_MapTable;
  public static int OPEN_FILE_FAIL = 0;
  public static int OPEN_FILE_NORMAL = 0;
  private static final String TAG = "IntentUtil";
  private static final String[] supportFormat = { "mp4", "mp3", "jpg", "gif", "jpeg", "png", "bmp", "org", "wav", "mid", "avi", "webp", "webm", "txt", "xml", "cpp", "c", "java", "html", "htm", "ico", "eml", "ics" };
  private static final String[] webViewSupportFormat = { "jpg", "gif", "jpeg", "png", "bmp", "txt", "xml", "cpp", "c", "java", "html", "htm", "ico" };
  
  static
  {
    OPEN_FILE_FAIL = 1;
    String[] arrayOfString1 = { ".avi", "video/x-msvideo" };
    String[] arrayOfString2 = { ".mpg", "video/mpeg" };
    String[] arrayOfString3 = { ".rm", "video/rm" };
    String[] arrayOfString4 = { ".m3u", "audio/x-mpegurl" };
    String[] arrayOfString5 = { ".wav", "audio/x-wav" };
    String[] arrayOfString6 = { ".tiff", "image/tiff" };
    String[] arrayOfString7 = { ".gif", "image/gif" };
    String[] arrayOfString8 = { ".html", "text/html" };
    String[] arrayOfString9 = { ".msg", "application/vnd.ms-outlook" };
    String[] arrayOfString10 = { ".pot", "application/vnd.ms-powerpoint" };
    String[] arrayOfString11 = { ".pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation" };
    String[] arrayOfString12 = { ".xls", "application/vnd.ms-excel" };
    String[] arrayOfString13 = { ".xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" };
    String[] arrayOfString14 = { ".jar", "application/java-archive" };
    String[] arrayOfString15 = { ".7z", "application/7z" };
    String[] arrayOfString16 = { ".rar", "application/rar" };
    String[] arrayOfString17 = { ".eps", "application/postscript" };
    String[] arrayOfString18 = { ".flash", "application/fla" };
    MIME_MapTable = new String[][] { { ".apk", "application/vnd.android.package-archive" }, { ".3gp", "video/3gpp" }, { ".asf", "video/x-ms-asf" }, arrayOfString1, { ".m4v", "video/x-m4v" }, { ".mov", "video/quicktime" }, { ".m4u", "video/vnd.mpegurl" }, { ".mp4", "video/mp4" }, { ".mpe", "video/mpeg" }, { ".mpeg", "video/mpeg" }, arrayOfString2, { ".mpg4", "video/mp4" }, { ".flv", "video/flv" }, { ".wmv", "video/wmv" }, { ".rmvb", "video/rmvb" }, arrayOfString3, { ".swf", "video/swf" }, { ".mkv", "video/mkv" }, arrayOfString4, { ".m4a", "audio/mp4a-latm" }, { ".m4b", "audio/mp4a-latm" }, { ".m4p", "audio/mp4a-latm" }, { ".ogg", "audio/ogg" }, { ".mp2", "audio/x-mpeg" }, { ".mp3", "audio/x-mpeg" }, arrayOfString5, { ".wma", "audio/x-ms-wma" }, { ".mpga", "audio/mpeg" }, { ".aiff", "audio/aiff" }, { ".bmp", "image/bmp" }, arrayOfString6, { ".tif", "image/tif" }, arrayOfString7, { ".jpeg", "image/jpeg" }, { ".jpg", "image/jpeg" }, { ".png", "image/png" }, { ".psd", "image/psd" }, { ".ico", "image/ico" }, { ".c", "text/plain" }, { ".conf", "text/plain" }, { ".cpp", "text/plain" }, { ".h", "text/plain" }, { ".htm", "text/html" }, arrayOfString8, { ".log", "text/plain" }, { ".java", "text/plain" }, { ".txt", "text/plain" }, { ".prop", "text/plain" }, { ".rc", "text/plain" }, { ".sh", "text/plain" }, { ".xml", "text/plain" }, { ".chm", "application/x-chm" }, { ".ini", "text/plain" }, { ".m", "text/plain" }, { ".plist", "text/plain" }, { ".mpc", "application/vnd.mpohun.certificate" }, arrayOfString9, { ".pdf", "application/pdf" }, { ".pptm", "application/vnd.ms-powerpoint" }, { ".pps", "application/vnd.ms-powerpoint" }, { ".ppt", "application/vnd.ms-powerpoint" }, arrayOfString10, { ".potx", "application/vnd.ms-powerpoint" }, arrayOfString11, { ".docm", "application/msword" }, { ".rtf", "application/msword" }, { ".doc", "application/msword" }, { ".docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document" }, { ".dotx", "application/msword" }, arrayOfString12, { ".xlt", "application/vnd.ms-excel" }, { ".xltx", "application/vnd.ms-excel" }, arrayOfString13, { ".wps", "application/vnd.ms-works" }, { ".csv", "application/vnd.ms-works" }, { ".xlsm", "application/vnd.ms-excel" }, { ".gtar", "application/gtar" }, { ".gz", "application/gzip" }, arrayOfString14, { ".js", "application/javascript" }, { ".rtf", "application/rtf" }, { ".tar", "application/tar" }, { ".tgz", "application/tgz" }, { ".z", "application/z" }, { ".zip", "application/zip" }, arrayOfString15, { ".bz2", "application/bz2" }, arrayOfString16, arrayOfString17, { ".js", "application/x-javascript" }, arrayOfString18, { ".eml", "application/eml" }, { ".ics", "application/calendar" } };
  }
  
  public static boolean canDisplayByOtherApp(Context paramContext, String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    try
    {
      if (paramString.equals("apk")) {
        return true;
      }
      PackageManager localPackageManager = paramContext.getPackageManager();
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setDataAndType(Uri.fromFile(new File("")), getMIMEType("." + paramString.toLowerCase(Locale.getDefault())));
      bool1 = bool2;
      if (OtherAppConfigUtil.filterResolveInfos(localPackageManager.queryIntentActivities(localIntent, 65536), getMIMEType("." + paramString.toLowerCase(Locale.getDefault()))).size() <= 0) {
        if (QMSpreadAPPInfo.canDisplayBySpreadAPPs(paramContext, paramString))
        {
          bool1 = bool2;
          if (!QMAttachUtils.attachFileType(paramString.toLowerCase(Locale.getDefault())).equals("COMPRESS")) {}
        }
        else
        {
          bool1 = bool2;
          if (!QMSpreadAPPInfo.canOpenByX5Core(paramContext, paramString))
          {
            boolean bool3 = QMSpreadAPPInfo.canOpenByQQBrowser(paramContext, paramString);
            bool1 = bool2;
            if (!bool3) {
              return false;
            }
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      bool1 = false;
    }
    return bool1;
  }
  
  public static boolean canDisplayBySelf(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      try
      {
        if (i < supportFormat.length)
        {
          bool1 = paramString.toLowerCase(Locale.getDefault()).equals(supportFormat[i]);
          if (bool1) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      catch (Exception paramString) {}
    }
    return false;
  }
  
  public static boolean canDisplayByWebView(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      try
      {
        if (i < webViewSupportFormat.length)
        {
          bool1 = paramString.toLowerCase(Locale.getDefault()).equals(webViewSupportFormat[i]);
          if (bool1) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      catch (Exception paramString) {}
    }
    return false;
  }
  
  private static Intent generateMarketIntent(String paramString1, String paramString2)
  {
    paramString1 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + paramString1));
    paramString1.setPackage(paramString2);
    return paramString1;
  }
  
  public static String getMIMEType(File paramFile)
  {
    String str1 = "*/*";
    Object localObject;
    if (paramFile == null) {
      localObject = str1;
    }
    String str2;
    do
    {
      do
      {
        return localObject;
        paramFile = paramFile.getAbsolutePath();
        i = paramFile.lastIndexOf(".");
        localObject = str1;
      } while (i < 0);
      str2 = paramFile.substring(i, paramFile.length()).toLowerCase(Locale.getDefault());
      localObject = str1;
    } while (str2 == "");
    int i = 0;
    paramFile = str1;
    for (;;)
    {
      localObject = paramFile;
      if (i >= MIME_MapTable.length) {
        break;
      }
      if (str2.equals(MIME_MapTable[i][0])) {
        paramFile = MIME_MapTable[i][1];
      }
      i += 1;
    }
  }
  
  public static String getMIMEType(String paramString)
  {
    Object localObject = paramString.split("\\.");
    localObject = localObject[(localObject.length - 1)];
    localObject = "application/" + (String)localObject;
    String str = paramString.toLowerCase(Locale.getDefault());
    if (str.equals("")) {
      return localObject;
    }
    paramString = (String)localObject;
    int i = 0;
    while (i < MIME_MapTable.length)
    {
      if (str.equals(MIME_MapTable[i][0])) {
        paramString = MIME_MapTable[i][1];
      }
      i += 1;
    }
    return paramString;
  }
  
  public static boolean intentToMarket(Context paramContext, String paramString)
  {
    try
    {
      paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + paramString)));
      return true;
    }
    catch (Exception paramContext)
    {
      Toast.makeText(QMApplicationContext.sharedInstance(), "请安装应用市场!", 0).show();
    }
    return false;
  }
  
  public static boolean intentToMarketFromOutsideActivity(Context paramContext, String paramString)
  {
    try
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + paramString));
      paramString.addFlags(268435456);
      paramContext.startActivity(paramString);
      return true;
    }
    catch (Exception paramContext)
    {
      Toast.makeText(QMApplicationContext.sharedInstance(), "请安装应用市场!", 0).show();
    }
    return false;
  }
  
  public static boolean intentToPriorityMarket(Context paramContext, String paramString, boolean paramBoolean)
  {
    String str = ChannelMarketUtil.getMarketByChannelId(ChannelDefine.getChannelId());
    if (!StringExtention.isNullOrEmpty(str)) {
      try
      {
        paramContext.startActivity(generateMarketIntent(paramString, str));
        return true;
      }
      catch (Exception localException1)
      {
        QMLog.log(6, "IntentUtil", "cannot jump to original channel market:" + str);
      }
    }
    str = ChannelMarketUtil.getTopPriorityMarket();
    if (!StringExtention.isNullOrEmpty(str)) {
      try
      {
        paramContext.startActivity(generateMarketIntent(paramString, str));
        return true;
      }
      catch (Exception localException2)
      {
        QMLog.log(6, "IntentUtil", "cannot jump to any priority channel market:" + str);
      }
    }
    try
    {
      paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + paramString)));
      return true;
    }
    catch (Exception paramContext)
    {
      if (!paramBoolean) {
        Toast.makeText(QMApplicationContext.sharedInstance(), "请安装应用市场!", 0).show();
      }
    }
    return false;
  }
  
  public static boolean isExistFileBrowser(Context paramContext)
  {
    Object localObject = new Intent();
    ((Intent)localObject).setAction("android.intent.action.GET_CONTENT");
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).setDataAndType(Uri.parse("file:///mnt/sdcard"), "file/*");
    paramContext = paramContext.getPackageManager().queryIntentActivities((Intent)localObject, 65536);
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        localObject = ((ResolveInfo)paramContext.next()).activityInfo;
        if ((localObject == null) || (!((ActivityInfo)localObject).enabled) || (!((ActivityInfo)localObject).applicationInfo.enabled) || (!((ActivityInfo)localObject).exported)) {
          paramContext.remove();
        } else {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean isOpenByPackageOnlyBySuffix(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.equals(""))) {
      return false;
    }
    String str = getMIMEType("." + paramString2.toLowerCase(Locale.getDefault()));
    paramString2 = new Intent();
    paramString2.addFlags(268435456);
    paramString2.setAction("android.intent.action.VIEW");
    paramString2.setType(str);
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.queryIntentActivities(paramString2, 0);
      if (paramContext.size() == 1)
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext()) {
          if (((ResolveInfo)paramContext.next()).activityInfo.packageName.equals(paramString1)) {
            return true;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      QMLog.log(6, "IntentUtil", "queryIntentActivities failed!", paramContext);
      return false;
    }
    return false;
  }
  
  public static boolean notifyPBService(Context paramContext)
  {
    if (!OtherAppConfigUtil.shouldNotifyOtherApps()) {}
    for (;;)
    {
      return false;
      try
      {
        if (DeviceUtil.isAppInstalled("com.tencent.pb"))
        {
          Intent localIntent = new Intent("TICK_FROM_QQMAIL");
          localIntent.setClassName("com.tencent.pb", "com.tencent.pb.remote.PushService");
          paramContext.startService(localIntent);
          DataCollector.logEvent("Event_Notify_BP");
          return false;
        }
      }
      catch (Exception paramContext)
      {
        QMLog.log(6, "IntentUtil", paramContext.getMessage());
      }
    }
    return false;
  }
  
  public static boolean openApp(String paramString)
  {
    try
    {
      QMApplicationContext localQMApplicationContext = QMApplicationContext.sharedInstance();
      localQMApplicationContext.startActivity(localQMApplicationContext.getPackageManager().getLaunchIntentForPackage(paramString));
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static void openAttachFileLocation(Context paramContext, String paramString)
  {
    if (!StringExtention.isNullOrEmpty(paramString))
    {
      paramString = new File(paramString);
      if ((paramString != null) && (paramString.exists()))
      {
        paramString = paramString.getParent();
        if (!StringExtention.isNullOrEmpty(paramString)) {
          openFileLocation(paramContext, paramString);
        }
      }
    }
  }
  
  public static int openFile(Activity paramActivity, String paramString1, String paramString2, AttachPreviewType paramAttachPreviewType)
  {
    int i = OPEN_FILE_NORMAL;
    try
    {
      localFile = new File(paramString1);
      QMLog.log(4, "IntentUtil", "openFile url is " + paramString1 + ". file exist :" + localFile.exists() + ", file.getPath():" + localFile.getPath());
      if (localFile.exists())
      {
        str2 = "." + paramString2.toLowerCase(Locale.getDefault());
        str1 = getMIMEType(str2);
        if (paramAttachPreviewType == AttachPreviewType.MailBigAttachPreview) {
          OssHelper.bigattachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", paramActivity.getClass().getSimpleName(), paramString2, "" });
        }
        for (;;)
        {
          str2 = new QMqqBrowserInfo(paramActivity, QMqqBrowserInfo.qqBrowserSupportTypes).checkSupportType(str2);
          if ((StringExtention.isNullOrEmpty(str2)) || (localFile.getPath().startsWith("file://"))) {
            break label790;
          }
          KvHelper.eventOpenFileByX5Sdk(new double[0]);
          j = QQBrowserUtil.openFileReader(paramActivity, localFile.getPath(), null, new IntentUtil.1());
          QMLog.log(4, "IntentUtil", "file type:" + str2 + " default open by QQBrowser sdk, qbSdkRet:" + j + ", wechat:" + DeviceUtil.isWeChatInstalled() + ", wxversion:" + DeviceUtil.getAppVersion("com.tencent.mm") + ", qq:" + DeviceUtil.isQQInstalled() + ", qqversion:" + DeviceUtil.getAppVersion("com.tencent.mobileqq") + ", qqbrowser:" + DeviceUtil.isQQBrowserInstalled() + ", qbversion:" + DeviceUtil.getAppVersion("com.tencent.mtt"));
          if (j != 3) {
            break label754;
          }
          if (QMSpreadAPPInfo.canOpenByX5Core(paramActivity, paramString2)) {
            KvHelper.eventOpenFileByX5CoreFail(new double[0]);
          }
          i = openFileByDefault(paramActivity, paramString1, paramString2, paramAttachPreviewType, localFile, str1, str2);
          KvHelper.eventOpenFileByX5SdkUseSystemCore(new double[0]);
          return i;
          if (paramAttachPreviewType != AttachPreviewType.MailNormalAttachPreview) {
            break;
          }
          OssHelper.attachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", paramActivity.getClass().getSimpleName(), paramString2, "" });
        }
      }
    }
    catch (Exception paramString1)
    {
      File localFile;
      String str2;
      String str1;
      int j;
      if (paramAttachPreviewType == AttachPreviewType.MailBigAttachPreview)
      {
        OssHelper.bigattachOpenFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", paramActivity.getClass().getSimpleName(), paramString2, paramString1.getMessage() });
        label600:
        if ((paramAttachPreviewType != AttachPreviewType.MailBigAttachPreview) && (paramAttachPreviewType != AttachPreviewType.MailNormalAttachPreview) && (paramAttachPreviewType != AttachPreviewType.FTNBigAttachPreview) && (paramAttachPreviewType != AttachPreviewType.FTNNormalAttachPreview)) {
          break label1263;
        }
      }
      label790:
      label1263:
      for (i = OPEN_FILE_FAIL;; i = OPEN_FILE_FAIL)
      {
        QMLog.log(6, "IntentUtil", "openFile fail! error msg: " + paramString1.getMessage());
        return i;
        if (paramAttachPreviewType != AttachPreviewType.FTNBigAttachPreview) {
          break;
        }
        OssHelper.ftnattachOpenSuc(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", paramActivity.getClass().getSimpleName(), paramString2, "" });
        break;
        label754:
        if (j == 2)
        {
          KvHelper.eventOpenFileByX5CoreSuccess(new double[0]);
          return i;
        }
        if (j != 1) {
          break label1271;
        }
        KvHelper.eventOpenFileByX5SdkUseQqbrowser(new double[0]);
        DataCollector.logEvent("Event_Open_File_By_QQbrowser");
        return i;
        return openFileByDefault(paramActivity, paramString1, paramString2, paramAttachPreviewType, localFile, str1, str2);
        if (paramAttachPreviewType == AttachPreviewType.MailBigAttachPreview) {
          OssHelper.bigattachOpenFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", paramActivity.getClass().getSimpleName(), paramString2, "file not exist" });
        }
        for (;;)
        {
          Toast.makeText(QMApplicationContext.sharedInstance(), paramActivity.getString(2131692956), 0).show();
          return i;
          if (paramAttachPreviewType == AttachPreviewType.MailNormalAttachPreview) {
            OssHelper.attachOpenFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", paramActivity.getClass().getSimpleName(), paramString2, "file not exist" });
          } else if (paramAttachPreviewType == AttachPreviewType.FTNBigAttachPreview) {
            OssHelper.ftnattachOpenFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", paramActivity.getClass().getSimpleName(), paramString2, "file not exist" });
          }
        }
        if (paramAttachPreviewType == AttachPreviewType.MailNormalAttachPreview)
        {
          OssHelper.attachOpenFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", paramActivity.getClass().getSimpleName(), paramString2, paramString1.getMessage() });
          break label600;
        }
        if (paramAttachPreviewType != AttachPreviewType.FTNBigAttachPreview) {
          break label600;
        }
        OssHelper.ftnattachOpenFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", paramActivity.getClass().getSimpleName(), paramString2, paramString1.getMessage() });
        break label600;
      }
    }
    label1271:
    return i;
  }
  
  private static int openFileByDefault(Activity paramActivity, String paramString1, String paramString2, AttachPreviewType paramAttachPreviewType, File paramFile, String paramString3, String paramString4)
  {
    int i = 0;
    QMLog.log(4, "IntentUtil", "openFileByDefault, suffix:" + paramString2 + ", previewType:" + paramAttachPreviewType + ", type:" + paramString3 + ", qqBrowserType:" + paramString4 + ", wechat:" + DeviceUtil.isWeChatInstalled() + ", wxversion:" + DeviceUtil.getAppVersion("com.tencent.mm") + ", qq:" + DeviceUtil.isQQInstalled() + ", qqversion:" + DeviceUtil.getAppVersion("com.tencent.mobileqq") + ", qqbrowser:" + DeviceUtil.isQQBrowserInstalled() + ", qbversion:" + DeviceUtil.getAppVersion("com.tencent.mtt"));
    paramString4 = paramActivity.getSharedPreferences("spread", 0).getString(paramString3, "");
    paramString1 = new Intent();
    paramString1.addFlags(268435456);
    paramString1.setAction("android.intent.action.VIEW");
    paramString1.setDataAndType(Uri.fromFile(paramFile), paramString3);
    List localList = OtherAppConfigUtil.filterResolveInfos(paramActivity.getPackageManager().queryIntentActivities(paramString1, 0), paramString3);
    if (localList != null)
    {
      QMLog.log(4, "IntentUtil", "open file support app cnt: " + localList.size());
      if ((localList.size() == 0) && (!QMSpreadAPPInfo.canDisplayBySpreadAPPs(paramActivity, paramString2)))
      {
        if ((paramAttachPreviewType != AttachPreviewType.MailBigAttachPreview) && (paramAttachPreviewType != AttachPreviewType.MailNormalAttachPreview) && (paramAttachPreviewType != AttachPreviewType.FTNBigAttachPreview) && (paramAttachPreviewType == AttachPreviewType.FTNNormalAttachPreview)) {}
        QMLog.log(5, "IntentUtil", "can't open file " + paramFile.getName());
        return OPEN_FILE_FAIL;
      }
      paramAttachPreviewType = localList.iterator();
      while (paramAttachPreviewType.hasNext())
      {
        paramString2 = (ResolveInfo)paramAttachPreviewType.next();
        if (paramString4.contains(paramString2.activityInfo.packageName)) {
          paramString1.setComponent(new ComponentName(paramString2.activityInfo.packageName, paramString2.activityInfo.name));
        }
      }
    }
    for (;;)
    {
      try
      {
        paramAttachPreviewType = QMApplicationContext.sharedInstance().getPackageManager().getPackageInfo(paramString2.activityInfo.packageName, 16384);
        if (paramAttachPreviewType != null) {
          continue;
        }
      }
      catch (PackageManager.NameNotFoundException paramAttachPreviewType)
      {
        int j;
        paramAttachPreviewType.printStackTrace();
        continue;
      }
      QMLog.log(4, "IntentUtil", "file type:" + paramString3 + " default open by: " + paramString2.activityInfo.packageName + " version: " + i);
      paramActivity.startActivity(paramString1);
      return OPEN_FILE_NORMAL;
      j = paramAttachPreviewType.versionCode;
      i = j;
    }
  }
  
  public static void openFileLocation(Context paramContext, String paramString)
  {
    Intent localIntent1;
    label362:
    do
    {
      for (;;)
      {
        Object localObject2;
        Intent localIntent2;
        try
        {
          localIntent1 = new Intent();
          localIntent1.setAction("android.intent.action.GET_CONTENT");
          localIntent1.setDataAndType(Uri.fromFile(new File(paramString)), "file/*");
          Object localObject1 = paramContext.getPackageManager().queryIntentActivities(localIntent1, 0);
          paramString = new ArrayList();
          localObject1 = ((List)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          Object localObject3 = (ResolveInfo)((Iterator)localObject1).next();
          localObject2 = ((ResolveInfo)localObject3).activityInfo;
          if ((localObject2 == null) || (!((ActivityInfo)localObject2).enabled) || (!((ActivityInfo)localObject2).applicationInfo.enabled) || (!((ActivityInfo)localObject2).exported)) {
            continue;
          }
          localObject2 = ((ResolveInfo)localObject3).activityInfo.packageName;
          localObject3 = ((ResolveInfo)localObject3).activityInfo.name;
          localIntent2 = new Intent();
          localIntent2.addFlags(268435456);
          localIntent2.addFlags(32768);
          localIntent2.setDataAndType(localIntent1.getData(), "*/*");
          localIntent2.setClassName((String)localObject2, (String)localObject3);
          localIntent2.setComponent(new ComponentName((String)localObject2, (String)localObject3));
          localIntent2.setPackage((String)localObject2);
          if ((((String)localObject3).contains("rootexplorer")) || (((String)localObject2).equals("com.metago.astro")))
          {
            localIntent2.setAction("android.intent.action.VIEW");
            paramString.add(localIntent2);
            continue;
          }
          if (!((String)localObject2).equals("com.estrongs.android.pop")) {
            break label362;
          }
        }
        catch (Exception paramContext)
        {
          Toast.makeText(QMApplicationContext.sharedInstance(), "未安装文件管理器或找不到文件！", 0).show();
          QMLog.log(6, "IntentUtil", "openFileLocation error:" + paramContext.getMessage());
          return;
        }
        localIntent2.setClassName((String)localObject2, "com.estrongs.android.pop.view.FileExplorerActivity");
        localIntent2.setComponent(new ComponentName((String)localObject2, "com.estrongs.android.pop.view.FileExplorerActivity"));
        localIntent2.setPackage((String)localObject2);
        localIntent2.setAction("android.intent.action.GET_CONTENT");
        continue;
        localIntent2.setAction("android.intent.action.GET_CONTENT");
      }
      localIntent1 = Intent.createChooser((Intent)paramString.remove(0), "选择要使用的应用");
    } while (localIntent1 == null);
    localIntent1.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])paramString.toArray(new Parcelable[0]));
    paramContext.startActivity(localIntent1);
  }
  
  public static boolean openLocalFile(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    Object localObject;
    do
    {
      return false;
      localObject = new File(paramString);
      String str = getMIMEType((File)localObject);
      paramString = new Intent();
      paramString.addFlags(268435456);
      paramString.setAction("android.intent.action.VIEW");
      paramString.setDataAndType(Uri.fromFile((File)localObject), str);
      localObject = paramContext.getPackageManager().queryIntentActivities(paramString, 65536);
    } while ((localObject == null) || (((List)localObject).size() <= 0));
    try
    {
      paramContext.startActivity(paramString);
      return true;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      QMLog.log(6, "IntentUtil", "openLocalFile error:" + paramContext.getMessage());
    }
    return false;
  }
  
  public static Intent restoreComposeIntent()
  {
    QMApplicationContext localQMApplicationContext = QMApplicationContext.sharedInstance();
    ComposeMailUI localComposeMailUI = LocalDraftUtils.readLocalDraft();
    Intent localIntent = null;
    if (localComposeMailUI != null) {
      if (localComposeMailUI.getType() != ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_NOTE) {
        break label47;
      }
    }
    label47:
    for (localIntent = new Intent(localQMApplicationContext, ComposeNoteActivity.class);; localIntent = new Intent(localQMApplicationContext, ComposeMailActivity.class))
    {
      localIntent.putExtra("autologin", true);
      return localIntent;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.util.IntentUtil
 * JD-Core Version:    0.7.0.1
 */