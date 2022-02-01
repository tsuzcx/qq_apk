package com.tencent.qqmail.protocol;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import com.tencent.qqmail.utilities.sharedpreference.SPManager.OnChangedListener;
import moai.oss.KvHelper;
import moai.oss.OssHelper;
import moai.oss.ReportType;

public class DataCollector
{
  public static final int APP_ERROR_TYPE_CGI = 3;
  public static final int APP_ERROR_TYPE_FTN = 9;
  public static final int APP_ERROR_TYPE_GENERIC = 1;
  public static final int APP_ERROR_TYPE_HTTP = 2;
  public static final int APP_ERROR_TYPE_LOGIN = 4;
  public static final int APP_ERROR_TYPE_MAX = 10;
  public static final int APP_ERROR_TYPE_MIN = 0;
  public static final int APP_ERROR_TYPE_NETWORK_ERROR = 8;
  public static final int APP_ERROR_TYPE_PROTOCOL = 5;
  public static final int APP_ERROR_TYPE_UMASVR = 6;
  public static final int APP_ERROR_TYPE_VISIBLE = 7;
  public static final int APP_ERROR_TYPE_VISIBLE_ADDACCOUNT_EMPTY_ERR = 35;
  public static final int APP_ERROR_TYPE_VISIBLE_ADDACCOUNT_ERR = 2;
  public static final int APP_ERROR_TYPE_VISIBLE_ADDACCOUNT_EXCHANGE_SERVER_EMPTY_ERR = 37;
  public static final int APP_ERROR_TYPE_VISIBLE_ADDACCOUNT_EXIST_ERR = 3;
  public static final int APP_ERROR_TYPE_VISIBLE_ADDACCOUNT_MAIL_ADDRESS_ERR = 36;
  public static final int APP_ERROR_TYPE_VISIBLE_ADDACCOUNT_NEED_PSW = 44;
  public static final int APP_ERROR_TYPE_VISIBLE_ADDACCOUNT_NEED_SECOND_PSW = 46;
  public static final int APP_ERROR_TYPE_VISIBLE_ADDACCOUNT_NETWORK_TIPS = 52;
  public static final int APP_ERROR_TYPE_VISIBLE_ADDACCOUNT_NOT_EXIST_ERR = 43;
  public static final int APP_ERROR_TYPE_VISIBLE_ADDACCOUNT_PSW_ERR = 45;
  public static final int APP_ERROR_TYPE_VISIBLE_ADDACCOUNT_RECEIVE_PORT_EMPTY_ERR = 39;
  public static final int APP_ERROR_TYPE_VISIBLE_ADDACCOUNT_RECEIVE_SERVER_EMPTY_ERR = 38;
  public static final int APP_ERROR_TYPE_VISIBLE_ADDACCOUNT_REOPEN_ERR = 42;
  public static final int APP_ERROR_TYPE_VISIBLE_ADDACCOUNT_SAVE_NOTE_FAIL = 49;
  public static final int APP_ERROR_TYPE_VISIBLE_ADDACCOUNT_SECOND_PSW_ERR = 47;
  public static final int APP_ERROR_TYPE_VISIBLE_ADDACCOUNT_SEND_MAIL_FAIL = 48;
  public static final int APP_ERROR_TYPE_VISIBLE_ADDACCOUNT_SEND_PORT_EMPTY_ERR = 41;
  public static final int APP_ERROR_TYPE_VISIBLE_ADDACCOUNT_SEND_SERVER_EMPTY_ERR = 40;
  public static final int APP_ERROR_TYPE_VISIBLE_ADD_VIP_FAIL = 50;
  public static final int APP_ERROR_TYPE_VISIBLE_ATTACHUTIL_ATTACH_NOT_EXIST_ERR = 32;
  public static final int APP_ERROR_TYPE_VISIBLE_BIGATTACH_DEL_ERR = 20;
  public static final int APP_ERROR_TYPE_VISIBLE_BIGATTACH_DOWNLOAD_ERR = 19;
  public static final int APP_ERROR_TYPE_VISIBLE_BIGATTACH_PREVIEW_ERR = 18;
  public static final int APP_ERROR_TYPE_VISIBLE_COMPOSEMAIL = 10;
  public static final int APP_ERROR_TYPE_VISIBLE_COMPOSENOTE = 7;
  public static final int APP_ERROR_TYPE_VISIBLE_FILEERR_GO_REDOWNLOAD = 21;
  public static final int APP_ERROR_TYPE_VISIBLE_FILE_PREVIEW_UNSUPPORT_ERR = 27;
  public static final int APP_ERROR_TYPE_VISIBLE_FILE_TOO_BIG_PLEASE_REDOWNLOAD = 25;
  public static final int APP_ERROR_TYPE_VISIBLE_FTN_LIST_LOAD_ERR = 15;
  public static final int APP_ERROR_TYPE_VISIBLE_FTN_RENEW_ERR = 14;
  public static final int APP_ERROR_TYPE_VISIBLE_FTN_SAVE_FAIL_ERR = 28;
  public static final int APP_ERROR_TYPE_VISIBLE_LOADMAIL_ERR = 1;
  public static final int APP_ERROR_TYPE_VISIBLE_LOAD_FOLDERLIST_ERR = 11;
  public static final int APP_ERROR_TYPE_VISIBLE_LOAD_MAILLIST_ERR = 12;
  public static final int APP_ERROR_TYPE_VISIBLE_MEMORY_LOW_ERR = 30;
  public static final int APP_ERROR_TYPE_VISIBLE_NEED_VERIFY_CODE = 51;
  public static final int APP_ERROR_TYPE_VISIBLE_NETWORK_BUSY_TIPS = 22;
  public static final int APP_ERROR_TYPE_VISIBLE_NETWORK_TIPS = 5;
  public static final int APP_ERROR_TYPE_VISIBLE_NOTELIST = 6;
  public static final int APP_ERROR_TYPE_VISIBLE_OPEN_WITH_COMPATIBLE_MODE = 24;
  public static final int APP_ERROR_TYPE_VISIBLE_OPEN_WITH_OTHERAPP = 23;
  public static final int APP_ERROR_TYPE_VISIBLE_PREVIEW_IMG_ERR = 26;
  public static final int APP_ERROR_TYPE_VISIBLE_READMAIL_DELETE_ERR = 34;
  public static final int APP_ERROR_TYPE_VISIBLE_READMAIL_FILE_OVERSIZE_ERR = 33;
  public static final int APP_ERROR_TYPE_VISIBLE_READNOTE = 8;
  public static final int APP_ERROR_TYPE_VISIBLE_SAVE_FILE_ERR = 31;
  public static final int APP_ERROR_TYPE_VISIBLE_SAVE_IMAGE_ATTACH_ERR = 17;
  public static final int APP_ERROR_TYPE_VISIBLE_SD_SPACE_NOT_ENOUGH_ERR = 29;
  public static final int APP_ERROR_TYPE_VISIBLE_SEARCHNOTE = 9;
  public static final int APP_ERROR_TYPE_VISIBLE_TENCENT_AUTH_ERR = 13;
  public static final int APP_ERROR_TYPE_VISIBLE_VERIFYACCOUNT_ERR = 4;
  public static final int APP_ERROR_TYPE_VISIBLE_VERIFY_CODE_INPUT_ERR = 16;
  private static final String KEY_ENABLE = "enable";
  private static final String SP_NAME = "umadatacollector_info";
  private static final String TAG = "DataCollector";
  private static boolean sEnable = true;
  private static SPManager.OnChangedListener sSPChangedListener = new DataCollector.1();
  
  static
  {
    updateEnable();
    SPManager.registerOnChangedListener("umadatacollector_info", sSPChangedListener);
  }
  
  public static void flush()
  {
    if (!sEnable) {
      return;
    }
    DataCollectorImpl.flush();
  }
  
  public static boolean getEnable()
  {
    return sEnable;
  }
  
  public static void logClickStream(String paramString)
  {
    if (!sEnable) {
      return;
    }
    DataCollectorImpl.logClickStream(paramString);
  }
  
  public static void logDetailEvent(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    if (!sEnable) {
      return;
    }
    OssHelper.report(true, 80000363, paramString1, "", ",", true, ReportType.NORMAL, "8904e67", new Object[] { paramString2 });
  }
  
  public static void logDetailEventWithDetailMessage(String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3)
  {
    if (!sEnable) {
      return;
    }
    DataCollectorImpl.logDetailEventWithDetailMessage(paramString1, paramString2, paramLong1, paramLong2, paramString3);
  }
  
  @Deprecated
  public static void logEvent(String paramString)
  {
    if (!sEnable) {
      return;
    }
    Log.v("DataCollector", paramString);
    KvHelper.report(true, 78503071, paramString, "", ReportType.NORMAL, "2caf959", new double[] { 1.0D });
  }
  
  public static void logException(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!sEnable) {
      return;
    }
    DataCollectorImpl.logException(paramInt1, paramInt2, paramString1, paramString2, paramBoolean);
  }
  
  public static void logException(String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (!sEnable) {
      return;
    }
    DataCollectorImpl.logException(paramString1, paramInt, paramString2, paramString3, paramBoolean);
  }
  
  public static void logPerformanceBegin(String paramString1, long paramLong, String paramString2)
  {
    if (!sEnable) {
      return;
    }
    DataCollectorImpl.logPerformanceBegin(paramString1, paramLong, paramString2);
  }
  
  public static void logPerformanceEnd(String paramString1, String paramString2)
  {
    if (!sEnable) {
      return;
    }
    DataCollectorImpl.logPerformanceEnd(paramString1, paramString2);
  }
  
  public static void logPerformanceRaw(String paramString, long paramLong1, long paramLong2)
  {
    if (!sEnable) {
      return;
    }
    DataCollectorImpl.logPerformanceRaw(paramString, paramLong1, paramLong2);
  }
  
  public static void logStatus(String paramString1, String paramString2)
  {
    if (!sEnable) {
      return;
    }
    DataCollectorImpl.logStatus(paramString1, paramString2);
  }
  
  public static void setEnable(boolean paramBoolean)
  {
    sEnable = paramBoolean;
    SPManager.getEditor("umadatacollector_info").putBoolean("enable", paramBoolean).commit();
    SPManager.notifyChanged("umadatacollector_info");
  }
  
  public static void submit()
  {
    if (!sEnable) {
      return;
    }
    DataCollectorImpl.submit();
  }
  
  public static void submitLog()
  {
    if (!sEnable) {
      return;
    }
    flush();
  }
  
  private static void updateEnable()
  {
    sEnable = SPManager.getSp("umadatacollector_info", true).getBoolean("enable", true);
    QMLog.log(4, "DataCollector", "updateEnable, enable: " + sEnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.DataCollector
 * JD-Core Version:    0.7.0.1
 */