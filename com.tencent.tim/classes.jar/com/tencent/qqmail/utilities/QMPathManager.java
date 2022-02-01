package com.tencent.qqmail.utilities;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.permission.PermissionUtils;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class QMPathManager
{
  private static String EXTERNAL_DOWNLOAD_CONFIG = "config.txt";
  private static String EXTERNAL_DOWNLOAD_QQMAIL_ATTACHMENT = "download/";
  private static final String EXTERNAL_QQMAIL_ADVERTISE_DECODE_GIF_DIR = "advertise_gif/";
  private static final String EXTERNAL_QQMAIL_ATTACHMENT_DIR = "attachment/";
  private static final String EXTERNAL_QQMAIL_CACHE_DIR = "cache/";
  private static final String EXTERNAL_QQMAIL_COMPOSE_CACHE_DIR = "composemail/";
  private static final String EXTERNAL_QQMAIL_COMPRESS_IMG_CACHE_DIR = "compresscache/";
  private static final String EXTERNAL_QQMAIL_EMAIL_ICON_DIR = "emailIcon/";
  private static final String EXTERNAL_QQMAIL_EML_CACHE_DIR = "emlcache/";
  private static final String EXTERNAL_QQMAIL_KV = "kv/";
  private static final String EXTERNAL_QQMAIL_LAST_PUSH_ADVERTISE_DECODE_GIF_DIR = "lastpush_advertise_gif/";
  private static final String EXTERNAL_QQMAIL_LOCAL_CACHE_DIR = "localcache/";
  private static final String EXTERNAL_QQMAIL_LOG = "log/";
  private static final String EXTERNAL_QQMAIL_MAIL_INLINE_FILE_CACHE_DIR = "inlinefile/";
  private static final String EXTERNAL_QQMAIL_NATIVE_PAGES = "native_pages/";
  private static final String EXTERNAL_QQMAIL_NICK_ICON_DIR = "nickIcon/";
  private static final String EXTERNAL_QQMAIL_OCR_DIR = "ocr/";
  private static final String EXTERNAL_QQMAIL_POP_UIDS_PATH_SDCARD = "popuids/";
  private static final String EXTERNAL_QQMAIL_PURGE_UIDS_PATH_DIR = "purge_uids/";
  private static final String EXTERNAL_QQMAIL_QMLOG = "qmlog/";
  private static final String EXTERNAL_QQMAIL_RQD_NATIVE_ERR_LOG_DIR = "qmlog/nativelog/";
  private static final String EXTERNAL_QQMAIL_SCAN_SHARE_IMAGE = "scan_share_image/";
  private static final String EXTERNAL_QQMAIL_SCAN_SHARE_PDF = "scan_share_pdf/";
  private static final String EXTERNAL_QQMAIL_THUMB_IMAGE_CACHE_DIR = "imagecache/";
  private static final String EXTERNAL_QQMAIL_TMP = "tmp/";
  private static final String EXTERNAL_QQMAIL_UPLOAD_IMAGE_DIR = "uploadimage/";
  private static final String EXTERNAL_QQMAIL_WEBVIEW_SCREENSHOT_DIR = "screenshot/";
  private static final String EXTERNAL_QQMAIL_WELCOME_SPLASH_DIR = "splash/";
  public static final String SDCARD_QQMAIL_DIR = "Tim/QQmail";
  private static final String TAG = "QMPathManager";
  private static QMPathManager _instance = new QMPathManager();
  private String externalDownloadDir;
  private String externalQQmailDir;
  
  public QMPathManager()
  {
    initDefaultDownloadDir();
    initQQMailDir();
  }
  
  @NonNull
  public static String getQQMailDirPath(@NonNull Context paramContext, @NonNull String paramString)
  {
    String str = null;
    Object localObject;
    if (FileUtil.hasSdcard()) {
      if (PermissionUtils.hasWriteExternalStoragePermission(paramContext))
      {
        localObject = Environment.getExternalStorageDirectory();
        str = ((File)localObject).getAbsolutePath() + File.separator + "tencent" + File.separator + "Tim/QQmail" + File.separator + paramString;
      }
    }
    for (;;)
    {
      if (localObject == null)
      {
        paramContext = paramContext.getCacheDir();
        str = paramContext.getAbsolutePath() + File.separator + paramString;
      }
      paramContext = new File(str);
      boolean bool = FileUtil.tryMkdirs(paramContext);
      Log.i("QMPathManager", "mkdirResult of qmlog " + bool + " path : " + str + " exist " + paramContext.exists());
      return str;
      File localFile = paramContext.getExternalFilesDir(null);
      localObject = localFile;
      if (localFile != null)
      {
        str = localFile.getAbsolutePath() + File.separator + paramString;
        localObject = localFile;
        continue;
        localObject = null;
      }
    }
  }
  
  public static void init() {}
  
  private void initDefaultDownloadDir()
  {
    String str = Environment.getExternalStorageDirectory() + "/tencent/Tim/QQmail";
    QMLog.log(4, "QMPathManager", "default download dir:" + str);
    Object localObject = str;
    if (!FileUtil.tryMkdirs(new File(str)))
    {
      str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
      localObject = str;
      if (!FileUtil.tryMkdirs(new File(str)))
      {
        localObject = QMApplicationContext.sharedInstance().getExternalFilesDir("Download");
        if (localObject == null) {
          break label166;
        }
      }
    }
    label166:
    for (str = ((File)localObject).getAbsolutePath();; str = "")
    {
      localObject = str;
      if (!str.equals(""))
      {
        FileUtil.tryMkdirs(new File(str));
        localObject = str;
      }
      QMLog.log(4, "QMPathManager", "change download dir to:" + (String)localObject);
      this.externalDownloadDir = FileUtil.toDirPath((String)localObject);
      return;
    }
  }
  
  private void initQQMailDir()
  {
    String str = Environment.getExternalStorageDirectory() + "/tencent/" + "Tim/QQmail" + "/";
    QMLog.log(4, "QMPathManager", "default QQMail dir:" + str);
    Object localObject = str;
    if (!FileUtil.tryMkdirs(new File(str)))
    {
      localObject = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getParent();
      str = FileUtil.toDirPath((String)localObject) + "tencent/" + "Tim/QQmail" + "/";
      localObject = str;
      if (!FileUtil.tryMkdirs(new File(str)))
      {
        localObject = QMApplicationContext.sharedInstance().getExternalFilesDir("QQmail");
        if (localObject == null) {
          break label207;
        }
      }
    }
    label207:
    for (str = ((File)localObject).getAbsolutePath();; str = "")
    {
      localObject = str;
      if (!str.equals(""))
      {
        FileUtil.tryMkdirs(new File(str));
        localObject = str;
      }
      QMLog.log(4, "QMPathManager", "change external qqmail dir to:" + (String)localObject);
      this.externalQQmailDir = ((String)localObject);
      return;
    }
  }
  
  public static QMPathManager sharedInstance()
  {
    return _instance;
  }
  
  public String getAttachDownloadPath()
  {
    String str = Environment.getExternalStorageDirectory() + "/Tencent/TIMfile_recv/";
    try
    {
      FileUtils.forceMkdir(new File(str));
      return str;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return str;
  }
  
  public String getDownloadConfig()
  {
    return this.externalDownloadDir + EXTERNAL_DOWNLOAD_CONFIG;
  }
  
  public String getExternalQqmailEmlCacheDir()
  {
    return this.externalQQmailDir + "emlcache/";
  }
  
  public String getExternalQqmailWebviewScreenshotDir()
  {
    return this.externalQQmailDir + "screenshot/";
  }
  
  public String getNativePagesDir()
  {
    return this.externalQQmailDir + "native_pages/";
  }
  
  public String getQQMailAdvertiseGifDir()
  {
    return this.externalQQmailDir + "advertise_gif/";
  }
  
  public String getQQMailAttachmentDir()
  {
    return Environment.getExternalStorageDirectory() + "/tencent/" + "Tim/QQmail" + "/" + "attachment/";
  }
  
  public String getQQMailCacheDir()
  {
    return this.externalQQmailDir + "cache/";
  }
  
  public String getQQMailComposeCacheDir()
  {
    return this.externalQQmailDir + "composemail/";
  }
  
  public String getQQMailCompressDir()
  {
    return this.externalQQmailDir + "compresscache/";
  }
  
  public String getQQMailDir()
  {
    return this.externalQQmailDir;
  }
  
  public String getQQMailEmailIconDir()
  {
    return this.externalQQmailDir + "emailIcon/";
  }
  
  public String getQQMailKvDir()
  {
    return this.externalQQmailDir + "kv/";
  }
  
  public String getQQMailLastAdvertiseDir()
  {
    return this.externalQQmailDir + "lastpush_advertise_gif/";
  }
  
  public String getQQMailLocalCacheDir()
  {
    return this.externalQQmailDir + "localcache/";
  }
  
  public String getQQMailLogDir()
  {
    return this.externalQQmailDir + "log/";
  }
  
  public String getQQMailMailInlineFileCacheDir()
  {
    return this.externalQQmailDir + "inlinefile/";
  }
  
  public String getQQMailNickIconDir()
  {
    return this.externalQQmailDir + "nickIcon/";
  }
  
  public String getQQMailOcrDir()
  {
    return this.externalQQmailDir + "ocr/";
  }
  
  public String getQQMailPopUidDir()
  {
    return this.externalQQmailDir + "popuids/";
  }
  
  public String getQQMailPurgeUidDir()
  {
    return this.externalQQmailDir + "purge_uids/";
  }
  
  public String getQQMailQMLogDir()
  {
    return this.externalQQmailDir + "qmlog/";
  }
  
  public String getQQMailRqdNativeDir()
  {
    return this.externalQQmailDir + "qmlog/nativelog/";
  }
  
  public String getQQMailThumbImageCacheDir()
  {
    return this.externalQQmailDir + "imagecache/";
  }
  
  public String getQQMailTmpDir()
  {
    return this.externalQQmailDir + "tmp/";
  }
  
  public String getQQMailUploadImageDir()
  {
    return this.externalQQmailDir + "uploadimage/";
  }
  
  public String getQQMailWelcomeDir()
  {
    return this.externalQQmailDir + "splash/";
  }
  
  public String getQQmailScanShareImageDir()
  {
    return this.externalQQmailDir + "scan_share_image/";
  }
  
  public String getQQmailScanSharePDFDir()
  {
    return this.externalQQmailDir + "scan_share_pdf/";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.QMPathManager
 * JD-Core Version:    0.7.0.1
 */