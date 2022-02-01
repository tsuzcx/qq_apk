package com.tencent.qqmail.utilities.fileextention;

import android.content.pm.ApplicationInfo;
import android.os.Environment;
import com.tencent.qqmail.QMApplicationContext;
import java.io.File;

public class FileDefine
{
  public static final String EXTERNAL_ANDROID_DATA_ATTACHMENT_DIR;
  public static final String EXTERNAL_ANDROID_DATA_BIGATTACH_DIR;
  public static final String EXTERNAL_ANDROID_DATA_CACHE_DIR;
  public static final String EXTERNAL_ANDROID_DATA_COMPRESS_DIR;
  public static final String EXTERNAL_ANDROID_DATA_DIR;
  public static final String EXTERNAL_ANDROID_DATA_SCREENSHOT;
  public static final String EXTERNAL_ANDROID_DATA_THUMB_IMAGE_CACHE_DIR;
  public static final String EXTERNAL_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath();
  public static final String INNER_DATA_BIG_ATTACH_DIR = INNER_DATA_CACHE_DIR + "bigattach/";
  public static final String INNER_DATA_CACHE_DIR;
  public static final String INNER_DATA_DATABASES;
  public static final String INNER_DATA_DIR;
  public static final String INNER_DATA_FILE_DIR;
  public static final String INNER_DATA_MAIL_INLINE_FILE;
  public static final String INNER_DATA_THUMB_IMAGE_CACHE_DIR;
  public static final String POP_UIDS_PATH_NO_SDCARD;
  public static final String PURGE_UIDS_PATH_NO_SDCARD_DIR;
  public static final String WATCHFIEL_PUSH_WATCH;
  public static final String WATCHFIEL_UNISTALL_WATCH;
  public static final String WELCOME_SPLASH_NO_SDCARD_DIR;
  
  static
  {
    EXTERNAL_ANDROID_DATA_DIR = Environment.getExternalStorageDirectory() + "/Android/data/com.tencent.androidqqmail";
    EXTERNAL_ANDROID_DATA_CACHE_DIR = EXTERNAL_ANDROID_DATA_DIR + "/cache";
    EXTERNAL_ANDROID_DATA_COMPRESS_DIR = EXTERNAL_ANDROID_DATA_CACHE_DIR + "/compresscache/";
    EXTERNAL_ANDROID_DATA_THUMB_IMAGE_CACHE_DIR = EXTERNAL_ANDROID_DATA_CACHE_DIR + "/imagecache/";
    EXTERNAL_ANDROID_DATA_BIGATTACH_DIR = EXTERNAL_ANDROID_DATA_CACHE_DIR + "/bigattach/";
    EXTERNAL_ANDROID_DATA_ATTACHMENT_DIR = EXTERNAL_ANDROID_DATA_CACHE_DIR + "/attachment/";
    EXTERNAL_ANDROID_DATA_SCREENSHOT = EXTERNAL_ANDROID_DATA_CACHE_DIR + "/screenshot/";
    INNER_DATA_DIR = QMApplicationContext.sharedInstance().getApplicationInfo().dataDir;
    INNER_DATA_FILE_DIR = QMApplicationContext.sharedInstance().getFilesDir().getAbsolutePath();
    INNER_DATA_DATABASES = INNER_DATA_DIR + "/databases/";
    INNER_DATA_CACHE_DIR = INNER_DATA_DIR + "/cache/";
    POP_UIDS_PATH_NO_SDCARD = INNER_DATA_FILE_DIR + "/popuids/";
    PURGE_UIDS_PATH_NO_SDCARD_DIR = INNER_DATA_FILE_DIR + "/purge_uids/";
    WELCOME_SPLASH_NO_SDCARD_DIR = INNER_DATA_FILE_DIR + "/splash/";
    WATCHFIEL_PUSH_WATCH = INNER_DATA_FILE_DIR + "/watchfile/push.watch";
    WATCHFIEL_UNISTALL_WATCH = INNER_DATA_DIR + "/watchfile/uninstall.watch";
    INNER_DATA_THUMB_IMAGE_CACHE_DIR = INNER_DATA_CACHE_DIR + "imagecache/";
    INNER_DATA_MAIL_INLINE_FILE = INNER_DATA_CACHE_DIR + "inlineFile/";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.fileextention.FileDefine
 * JD-Core Version:    0.7.0.1
 */