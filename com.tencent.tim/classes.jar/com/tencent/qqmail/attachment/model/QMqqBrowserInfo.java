package com.tencent.qqmail.attachment.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class QMqqBrowserInfo
  extends QMSpreadAPPInfo
{
  private static final String TAG = "QMqqBrowserInfo";
  public static final String qqBrowserAPKMD5 = "com.tencent.mtt_md5";
  public static final String qqBrowserAction = "com.tencent.QQBrowser.action.sdk.document";
  public static final String qqBrowserApkName = "qqBrowser.apk";
  public static final String qqBrowserDownloadUrl = "http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10940";
  public static final String qqBrowserDownloadUrlForWebview = "http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10979";
  public static final String qqBrowserPackageName = "com.tencent.mtt";
  public static final String qqBrowserSpreadCount = "com.tencent.mtt_spreadCount";
  public static final String[][] qqBrowserSupportTypes;
  public static final String qqBrowserWebViewSpreadCount = "com.tencent.mtt_webivew_spreadCount";
  public static final String urlType = "url";
  public static final String[][] x5SupportTypes;
  
  static
  {
    String[] arrayOfString1 = { ".tar", "mtt/tar" };
    String[] arrayOfString2 = { ".zip", "mtt/zip" };
    String[] arrayOfString3 = { ".rar", "mtt/rar" };
    String[] arrayOfString4 = { ".7z", "mtt/7z" };
    String[] arrayOfString5 = { ".doc", "mtt/doc" };
    String[] arrayOfString6 = { ".xls", "mtt/xls" };
    String[] arrayOfString7 = { ".ppt", "mtt/ppt" };
    String[] arrayOfString8 = { ".docx", "mtt/docx" };
    String[] arrayOfString9 = { ".xlsx", "mtt/xlsx" };
    String[] arrayOfString10 = { ".txt", "mtt/txt" };
    String[] arrayOfString11 = { ".pdf", "mtt/pdf" };
    String[] arrayOfString12 = { ".chm", "mtt/chm" };
    String[] arrayOfString13 = { ".html", "mtt/html" };
    String[] arrayOfString14 = { ".htm", "mtt/htm" };
    String[] arrayOfString15 = { ".mht", "mtt/mht" };
    String[] arrayOfString16 = { ".xml", "mtt/xml" };
    String[] arrayOfString17 = { ".ini", "mtt/ini" };
    String[] arrayOfString18 = { ".log", "mtt/log" };
    String[] arrayOfString19 = { ".php", "mtt/php" };
    String[] arrayOfString20 = { ".js", "mtt/js" };
    String[] arrayOfString21 = { ".lrc", "mtt/lrc" };
    String[] arrayOfString22 = { ".jpg", "mtt/jpg" };
    String[] arrayOfString23 = { ".jpeg", "mtt/jpeg" };
    String[] arrayOfString24 = { ".png", "mtt/png" };
    String[] arrayOfString25 = { ".gif", "mtt/gif" };
    String[] arrayOfString26 = { ".tiff", "mtt/tiff" };
    String[] arrayOfString27 = { ".mp3", "mtt/mp3" };
    String[] arrayOfString28 = { ".m4a", "mtt/m4a" };
    String[] arrayOfString29 = { ".amr", "mtt/amr" };
    String[] arrayOfString30 = { ".wav", "mtt/wav" };
    String[] arrayOfString31 = { ".ogg", "mtt/ogg" };
    String[] arrayOfString32 = { ".mid", "mtt/mid" };
    String[] arrayOfString33 = { ".ra", "mtt/ra" };
    String[] arrayOfString34 = { ".wma", "mtt/wma" };
    String[] arrayOfString35 = { ".mpga", "mtt/mpga" };
    String[] arrayOfString36 = { ".ape", "mtt/ape" };
    String[] arrayOfString37 = { ".flac", "mtt/flac" };
    String[] arrayOfString38 = { ".m3u8", "mtt/m3u8" };
    String[] arrayOfString39 = { ".mp4", "mtt/mp4" };
    String[] arrayOfString40 = { ".flv", "mtt/flv" };
    String[] arrayOfString41 = { ".avi", "mtt/avi" };
    String[] arrayOfString42 = { ".3gpp", "mtt/3gpp" };
    String[] arrayOfString43 = { ".webm", "mtt/webm" };
    String[] arrayOfString44 = { ".ogv", "mtt/ogv" };
    String[] arrayOfString45 = { ".asf", "mtt/asf" };
    String[] arrayOfString46 = { ".wmv", "mtt/wmv" };
    String[] arrayOfString47 = { ".rmvb", "mtt/rmvb" };
    String[] arrayOfString48 = { ".f4v", "mtt/f4v" };
    String[] arrayOfString49 = { ".vdat", "mtt/vdat" };
    String[] arrayOfString50 = { ".mov", "mtt/mov" };
    String[] arrayOfString51 = { ".mkv", "mtt/mkv" };
    String[] arrayOfString52 = { ".mpeg", "mtt/mpeg" };
    qqBrowserSupportTypes = new String[][] { { ".gz", "mtt/gz" }, arrayOfString1, { ".bz2", "mtt/bz2" }, arrayOfString2, arrayOfString3, arrayOfString4, arrayOfString5, arrayOfString6, arrayOfString7, arrayOfString8, arrayOfString9, { ".pptx", "mtt/pptx" }, arrayOfString10, { ".epub", "mtt/epub" }, arrayOfString11, arrayOfString12, arrayOfString13, arrayOfString14, arrayOfString15, arrayOfString16, arrayOfString17, arrayOfString18, { ".bat", "mtt/bat" }, arrayOfString19, arrayOfString20, arrayOfString21, arrayOfString22, arrayOfString23, arrayOfString24, arrayOfString25, { ".bmp", "mtt/bmp" }, { ".wepg", "mtt/wepg" }, { ".tif", "mtt/tif" }, arrayOfString26, arrayOfString27, arrayOfString28, arrayOfString29, arrayOfString30, arrayOfString31, arrayOfString32, arrayOfString33, arrayOfString34, arrayOfString35, arrayOfString36, arrayOfString37, arrayOfString38, arrayOfString39, arrayOfString40, arrayOfString41, { ".3gp", "mtt/3gp" }, arrayOfString42, arrayOfString43, { ".ts", "mtt/ts" }, arrayOfString44, arrayOfString45, arrayOfString46, arrayOfString47, { ".rm", "mtt/rm" }, arrayOfString48, arrayOfString49, arrayOfString50, { ".mpg", "mtt/mpg" }, arrayOfString51, arrayOfString52 };
    arrayOfString1 = new String[] { ".doc", "mtt/doc" };
    arrayOfString2 = new String[] { ".ppt", "mtt/ppt" };
    arrayOfString3 = new String[] { ".pptx", "mtt/pptx" };
    x5SupportTypes = new String[][] { arrayOfString1, { ".xls", "mtt/xls" }, arrayOfString2, { ".docx", "mtt/docx" }, { ".xlsx", "mtt/xlsx" }, arrayOfString3, { ".txt", "mtt/txt" }, { ".epub", "mtt/epub" }, { ".pdf", "mtt/pdf" } };
  }
  
  public QMqqBrowserInfo(Context paramContext, String[][] paramArrayOfString)
  {
    super(paramContext, "com.tencent.mtt", "com.tencent.QQBrowser.action.sdk.document", paramArrayOfString);
  }
  
  @Deprecated
  public static Intent createIntentForOpenFile(File paramFile, String paramString)
  {
    Intent localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document");
    localIntent.setPackage("com.tencent.mtt");
    localIntent.putExtra("key_reader_sdk_type", 0);
    localIntent.setDataAndType(Uri.fromFile(paramFile), paramString);
    localIntent.putExtra("key_reader_sdk_id", 4);
    localIntent.putExtra("key_reader_sdk_package", "com.tencent.androidqqmail");
    localIntent.putExtra("ChannelID", "com.tencent.androidqqmail");
    localIntent.putExtra("PosID", 4);
    localIntent.putExtra("key_reader_sdk_path", paramFile.getAbsolutePath());
    return localIntent;
  }
  
  public static Intent createIntentForOpenUrl(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setPackage("com.tencent.mtt");
    localIntent.setData(Uri.parse(paramString));
    localIntent.putExtra("ChannelID", "com.tencent.androidqqmail");
    localIntent.putExtra("PosID", 5);
    return localIntent;
  }
  
  public boolean isShowDownload(boolean paramBoolean)
  {
    int i = getSpreadPreferences().getInt("com.tencent.mtt_spreadCount", 1);
    QMLog.log(4, "QMqqBrowserInfo", "qqBrowser's show time:" + i + ", isTypeSupport:" + paramBoolean);
    return (i <= 5) && (paramBoolean);
  }
  
  public boolean isShowDownloadInWebview()
  {
    int i = getSpreadPreferences().getInt("com.tencent.mtt_webivew_spreadCount", 1);
    QMLog.log(4, "QMqqBrowserInfo", "qqBrowser's show time in webview:" + i);
    return i <= 5;
  }
  
  public boolean isSupportToOpen(File paramFile, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setAction(getAction());
    if ((!StringUtils.isBlank(paramString)) && (paramFile.exists()))
    {
      localIntent.setDataAndType(Uri.fromFile(paramFile), paramString);
      paramFile = getContext().getPackageManager().queryIntentActivities(localIntent, 0).iterator();
      for (;;)
      {
        if (paramFile.hasNext())
        {
          paramString = ((ResolveInfo)paramFile.next()).activityInfo.packageName;
          if (paramString.equals(getPackageName()))
          {
            try
            {
              paramFile = getContext().getPackageManager().getPackageInfo(paramString, 16384);
              if (paramFile != null) {
                QMLog.log(4, "QMqqBrowserInfo", "qqBrowser's version : " + paramFile.versionName);
              }
            }
            catch (PackageManager.NameNotFoundException paramFile)
            {
              for (;;)
              {
                paramFile.printStackTrace();
              }
            }
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public void setSpreadCount()
  {
    SharedPreferences.Editor localEditor = getSpreadPreferences().edit();
    localEditor.putInt("com.tencent.mtt_spreadCount", getSpreadPreferences().getInt("com.tencent.mtt_spreadCount", 1) + 1);
    localEditor.commit();
  }
  
  public void setWebviewSpreadCount()
  {
    SharedPreferences.Editor localEditor = getSpreadPreferences().edit();
    localEditor.putInt("com.tencent.mtt_webivew_spreadCount", getSpreadPreferences().getInt("com.tencent.mtt_webivew_spreadCount", 1) + 1);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.model.QMqqBrowserInfo
 * JD-Core Version:    0.7.0.1
 */