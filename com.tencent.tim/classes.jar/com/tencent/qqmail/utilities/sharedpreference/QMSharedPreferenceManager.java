package com.tencent.qqmail.utilities.sharedpreference;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

public class QMSharedPreferenceManager
{
  private static final String TAG = "QMSharedPreferenceManager";
  private static QMSharedPreferenceManager instance = new QMSharedPreferenceManager();
  private String mDeviceId;
  private boolean mIsGmailErrorMsgShow;
  private boolean mIsSetGmailErrorMsgShow;
  private QMSharedPreferenceSQLite mSqLiteHelper = new QMSharedPreferenceSQLite(QMApplicationContext.sharedInstance());
  private long mVid;
  private String mVidPwd;
  
  @NonNull
  public static QMSharedPreferenceManager getInstance()
  {
    return instance;
  }
  
  public long getAdvertiseMailReadTime()
  {
    String str = this.mSqLiteHelper.getSetting(this.mSqLiteHelper.getWritableDatabase(), "advertise_mail_read_time");
    if (TextUtils.isEmpty(str)) {
      return 0L;
    }
    return Long.parseLong(str);
  }
  
  public long getClearAttachmentCacheTimeByUser()
  {
    String str = this.mSqLiteHelper.getSetting(this.mSqLiteHelper.getWritableDatabase(), "user_set_clear_attachment_time");
    if ((str == null) || (str.equals(""))) {
      return 864000000L;
    }
    return Long.valueOf(str).longValue();
  }
  
  public String getClearCacheConfig()
  {
    return this.mSqLiteHelper.getSetting(this.mSqLiteHelper.getWritableDatabase(), "clear_cache_config");
  }
  
  public boolean getClearCacheDebug()
  {
    String str = this.mSqLiteHelper.getSetting(this.mSqLiteHelper.getWritableDatabase(), "clear_cache_debug");
    if ((str == null) || (str.equals(""))) {
      return false;
    }
    return Boolean.valueOf(str).booleanValue();
  }
  
  public long getClearCacheReportTime()
  {
    String str = this.mSqLiteHelper.getSetting(this.mSqLiteHelper.getWritableDatabase(), "clear_cache_report_time");
    if ((str == null) || (str.equals(""))) {
      return 0L;
    }
    return Long.valueOf(str).longValue();
  }
  
  public long getClearCacheTime()
  {
    String str = this.mSqLiteHelper.getSetting(this.mSqLiteHelper.getWritableDatabase(), "clear_cache_time");
    if ((str == null) || (str.equals(""))) {
      return 0L;
    }
    return Long.valueOf(str).longValue();
  }
  
  public String getDeviceId()
  {
    if (!StringExtention.isNullOrEmpty(this.mDeviceId)) {
      return this.mDeviceId;
    }
    String str = this.mSqLiteHelper.getUserInfo(this.mSqLiteHelper.getReadableDatabase(), "deviceid");
    if (StringExtention.isNullOrEmpty(str)) {
      return "";
    }
    this.mDeviceId = str;
    return this.mDeviceId;
  }
  
  public long getEnterCardTime()
  {
    String str = this.mSqLiteHelper.getSetting(this.mSqLiteHelper.getWritableDatabase(), "enter_card_time");
    if ((str == null) || (str.equals(""))) {
      return 0L;
    }
    return Long.parseLong(str);
  }
  
  public String getGmailErrorMsg()
  {
    String str2 = this.mSqLiteHelper.getSetting(this.mSqLiteHelper.getWritableDatabase(), "gmailErrorMsg");
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (!str2.equals("")) {}
    }
    else
    {
      str1 = QMApplicationContext.sharedInstance().getString(2131692446);
    }
    return str1;
  }
  
  public boolean getGmailErrorMsgShow()
  {
    boolean bool = false;
    if (this.mIsSetGmailErrorMsgShow) {
      bool = this.mIsGmailErrorMsgShow;
    }
    String str;
    do
    {
      return bool;
      str = this.mSqLiteHelper.getSetting(this.mSqLiteHelper.getReadableDatabase(), "isGmailErrorMsgShow");
    } while (StringExtention.isNullOrEmpty(str));
    try
    {
      this.mIsGmailErrorMsgShow = Boolean.parseBoolean(str);
      this.mIsSetGmailErrorMsgShow = true;
      return this.mIsGmailErrorMsgShow;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(5, "QMSharedPreferenceManager", "getGmailErrorMsgShow parse error", localException);
        this.mIsGmailErrorMsgShow = false;
      }
    }
  }
  
  public long getLastRemindClearCacheViewShowTime()
  {
    String str = this.mSqLiteHelper.getSetting(this.mSqLiteHelper.getWritableDatabase(), "remind_clear_cache_view_show_time");
    if ((str == null) || (str.equals(""))) {
      return 0L;
    }
    return Long.parseLong(str);
  }
  
  public String getPopularizeAD(String paramString)
  {
    if (paramString.equals(this.mSqLiteHelper.getSetting(this.mSqLiteHelper.getWritableDatabase(), "popularize_ad_url"))) {
      return this.mSqLiteHelper.getSetting(this.mSqLiteHelper.getWritableDatabase(), "popularize_ad_content");
    }
    return null;
  }
  
  public String getPopularizeADLastUpdateTime()
  {
    String str = this.mSqLiteHelper.getSetting(this.mSqLiteHelper.getWritableDatabase(), "popularize_ad_last_update_time");
    if ((str != null) && (!str.equals(""))) {
      return str;
    }
    return "";
  }
  
  public String getPopularizeUpdateFactor()
  {
    String str = this.mSqLiteHelper.getSetting(this.mSqLiteHelper.getWritableDatabase(), "popularize_update_factor");
    if ((str != null) && (!str.equals(""))) {
      return str;
    }
    return "";
  }
  
  public String getPullDownADHtml()
  {
    String str = this.mSqLiteHelper.getSetting(this.mSqLiteHelper.getWritableDatabase(), "pull_down_ad_html");
    if ((str != null) && (!str.equals(""))) {
      return str;
    }
    return "";
  }
  
  public String getPullDownADLastUpdateTime()
  {
    String str = this.mSqLiteHelper.getSetting(this.mSqLiteHelper.getWritableDatabase(), "pull_down_last_update_time");
    if ((str != null) && (!str.equals(""))) {
      return str;
    }
    return "";
  }
  
  public String getTranslateProviderTips()
  {
    String str2 = this.mSqLiteHelper.getSetting(this.mSqLiteHelper.getWritableDatabase(), "translate_provider_tips");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    QMLog.log(4, "QMSharedPreferenceManager", "getTranslateProviderTips : " + str1);
    return str1;
  }
  
  public long getVid()
  {
    long l = 0L;
    if (this.mVid != 0L) {
      l = this.mVid;
    }
    String str;
    do
    {
      return l;
      str = this.mSqLiteHelper.getUserInfo(this.mSqLiteHelper.getReadableDatabase(), "vid");
    } while (StringExtention.isNullOrEmpty(str));
    try
    {
      this.mVid = Long.parseLong(str);
      return this.mVid;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(5, "QMSharedPreferenceManager", "getVid parseLong error", localException);
        this.mVid = 0L;
      }
    }
  }
  
  public String getVidPwd()
  {
    if (!StringExtention.isNullOrEmpty(this.mVidPwd)) {
      return this.mVidPwd;
    }
    String str = this.mSqLiteHelper.getUserInfo(this.mSqLiteHelper.getReadableDatabase(), "vid_pwd");
    if (StringExtention.isNullOrEmpty(str)) {
      return "";
    }
    this.mVidPwd = str;
    return this.mVidPwd;
  }
  
  public boolean isClearCache()
  {
    return true;
  }
  
  public void setAdvertiseMailReadTime(long paramLong)
  {
    this.mSqLiteHelper.setSetting(this.mSqLiteHelper.getWritableDatabase(), "advertise_mail_read_time", paramLong + "");
  }
  
  public void setClearAttachmentCacheTimeByUser(long paramLong)
  {
    this.mSqLiteHelper.setSetting(this.mSqLiteHelper.getWritableDatabase(), "user_set_clear_attachment_time", String.valueOf(paramLong));
  }
  
  public void setClearCache(boolean paramBoolean)
  {
    this.mSqLiteHelper.setSetting(this.mSqLiteHelper.getWritableDatabase(), "is_clear_cache", String.valueOf(paramBoolean));
  }
  
  public void setClearCacheConfig(String paramString)
  {
    this.mSqLiteHelper.setSetting(this.mSqLiteHelper.getWritableDatabase(), "clear_cache_config", paramString);
  }
  
  public void setClearCacheDebug(boolean paramBoolean)
  {
    this.mSqLiteHelper.setSetting(this.mSqLiteHelper.getWritableDatabase(), "clear_cache_debug", String.valueOf(paramBoolean));
  }
  
  public void setClearCacheReportTime(long paramLong)
  {
    this.mSqLiteHelper.setSetting(this.mSqLiteHelper.getWritableDatabase(), "clear_cache_report_time", String.valueOf(paramLong));
  }
  
  public void setClearCacheTime(long paramLong)
  {
    this.mSqLiteHelper.setSetting(this.mSqLiteHelper.getWritableDatabase(), "clear_cache_time", String.valueOf(paramLong));
  }
  
  public void setDeviceId(String paramString)
  {
    this.mDeviceId = paramString;
    this.mSqLiteHelper.setUserInfo(this.mSqLiteHelper.getWritableDatabase(), "deviceid", paramString);
  }
  
  public void setEnterCardTime(long paramLong)
  {
    this.mSqLiteHelper.setSetting(this.mSqLiteHelper.getWritableDatabase(), "enter_card_time", String.valueOf(paramLong));
  }
  
  public void setGmailErrorMsg(String paramString)
  {
    this.mSqLiteHelper.setSetting(this.mSqLiteHelper.getWritableDatabase(), "gmailErrorMsg", paramString);
  }
  
  public void setGmailErrorMsgShow(boolean paramBoolean)
  {
    this.mIsGmailErrorMsgShow = paramBoolean;
    this.mIsSetGmailErrorMsgShow = true;
    QMSharedPreferenceSQLite localQMSharedPreferenceSQLite = this.mSqLiteHelper;
    SQLiteDatabase localSQLiteDatabase = this.mSqLiteHelper.getWritableDatabase();
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localQMSharedPreferenceSQLite.setSetting(localSQLiteDatabase, "isGmailErrorMsgShow", str);
      return;
    }
  }
  
  public void setHasForeignAccount(boolean paramBoolean)
  {
    this.mSqLiteHelper.setUserInfo(this.mSqLiteHelper.getWritableDatabase(), "has_foreign_account", Boolean.toString(paramBoolean));
  }
  
  public void setPopularizeAD(String paramString1, String paramString2)
  {
    this.mSqLiteHelper.setSetting(this.mSqLiteHelper.getWritableDatabase(), "popularize_ad_url", paramString1);
    this.mSqLiteHelper.setSetting(this.mSqLiteHelper.getWritableDatabase(), "popularize_ad_content", paramString2);
  }
  
  public void setPopularizeADLastUpdateTime(String paramString)
  {
    this.mSqLiteHelper.setSetting(this.mSqLiteHelper.getWritableDatabase(), "popularize_ad_last_update_time", paramString);
  }
  
  public void setPopularizeUpdateFactor(String paramString)
  {
    this.mSqLiteHelper.setSetting(this.mSqLiteHelper.getWritableDatabase(), "popularize_update_factor", paramString);
  }
  
  public void setPullDownADHtml(String paramString)
  {
    this.mSqLiteHelper.setSetting(this.mSqLiteHelper.getWritableDatabase(), "pull_down_ad_html", paramString);
  }
  
  public void setPullDownADLastUpdateTime(String paramString)
  {
    this.mSqLiteHelper.setSetting(this.mSqLiteHelper.getWritableDatabase(), "pull_down_last_update_time", paramString);
  }
  
  public void setRemindClearCacheViewShowTime(long paramLong)
  {
    this.mSqLiteHelper.setSetting(this.mSqLiteHelper.getWritableDatabase(), "remind_clear_cache_view_show_time", String.valueOf(paramLong));
  }
  
  public void setTranslateProviderTips(String paramString)
  {
    QMLog.log(4, "QMSharedPreferenceManager", "setTranslateProviderTips : " + paramString);
    if (paramString != null) {
      this.mSqLiteHelper.setSetting(this.mSqLiteHelper.getWritableDatabase(), "translate_provider_tips", paramString);
    }
  }
  
  public void setVid(long paramLong)
  {
    this.mVid = paramLong;
    this.mSqLiteHelper.setUserInfo(this.mSqLiteHelper.getWritableDatabase(), "vid", String.valueOf(paramLong));
  }
  
  public void setVidPwd(String paramString)
  {
    this.mVidPwd = paramString;
    this.mSqLiteHelper.setUserInfo(this.mSqLiteHelper.getWritableDatabase(), "vid_pwd", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceManager
 * JD-Core Version:    0.7.0.1
 */