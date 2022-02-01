package com.tencent.qqmail.model.mail;

import alld;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.attachment.util.AttachToolbox;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.utilities.exception.DevRuntimeException;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.widget.calendar.CalendarWidgetManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import org.apache.commons.lang3.StringUtils;

public class QMSettingManager
{
  private static final int SHOW_BOTTLE_SERVER_CLOSE = 8;
  private static final int SHOW_BOTTLE_SERVER_MASK = 12;
  private static final int SHOW_BOTTLE_SERVER_OPEN = 4;
  private static final int SHOW_BOTTLE_USER_CLOSE = 2;
  private static final int SHOW_BOTTLE_USER_MASK = 3;
  private static final int SHOW_BOTTLE_USER_OPEN = 1;
  private static final String TAG = "QMSettingManager";
  private static QMSettingManager _instance = new QMSettingManager(new QMSettingSQLiteHelper(QMApplicationContext.sharedInstance()));
  private static Future<Void> _instanceWithCached = Threads.submitTask(new QMSettingManager.1());
  private QMSettingSQLiteHelper sqliteHelper;
  
  private QMSettingManager(QMSettingSQLiteHelper paramQMSettingSQLiteHelper)
  {
    this.sqliteHelper = paramQMSettingSQLiteHelper;
  }
  
  private final void dumpSystemSetting(Uri paramUri, StringBuilder paramStringBuilder)
  {
    paramUri = alld.query(QMApplicationContext.sharedInstance().getContentResolver(), paramUri, null, null, null, null);
    if (paramUri != null)
    {
      int i = 0;
      while (i < paramUri.getCount())
      {
        paramUri.moveToPosition(i);
        paramStringBuilder.append(" - " + paramUri.getString(1) + " => " + paramUri.getString(2) + "\n");
        i += 1;
      }
      paramUri.close();
    }
  }
  
  private String getContactSyncKeyPrefix(MailContact.ContactType paramContactType)
  {
    if (paramContactType == MailContact.ContactType.NormalContact) {}
    do
    {
      return "CONTACT_SYNC_KEY_NORMAL_";
      if (paramContactType == MailContact.ContactType.HistoryContact) {
        return "CONTACT_SYNC_KEY_HISTORY_";
      }
      if (paramContactType == MailContact.ContactType.QQFriendContact) {
        return "CONTACT_SYNC_KEY_QQ_";
      }
      if (paramContactType == MailContact.ContactType.DomainContact) {
        return "CONTACT_SYNC_KEY_DOMAIN_";
      }
    } while (paramContactType != MailContact.ContactType.ProtocolContact);
    return "CONTACT_SYNC_KEY_PROTOCOL_";
  }
  
  private void setBottleDisplay(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 4;
    String str = this.sqliteHelper.getValue("show_bottle_ver2");
    int k = 0;
    int i = k;
    if (str != null)
    {
      i = k;
      if (str.length() > 0) {
        i = Integer.parseInt(str);
      }
    }
    if (paramBoolean2) {
      if (paramBoolean1)
      {
        j = 1;
        i = j | i & 0xFFFFFFFC;
      }
    }
    label155:
    for (;;)
    {
      this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "show_bottle_ver2", i + "");
      if (isBottleEnabled()) {}
      for (i = getDefaultBottleAccountID();; i = -1)
      {
        setDefaultBottleAccountID(i);
        return;
        j = 2;
        break;
        if ((i & 0x4) == 4) {
          break label155;
        }
        if (paramBoolean1) {}
        for (;;)
        {
          i = j | i & 0xFFFFFFF3;
          break;
          j = 8;
        }
      }
    }
  }
  
  @NonNull
  public static QMSettingManager sharedInstance()
  {
    try
    {
      _instanceWithCached.get();
      return _instance;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, "QMSettingManager", Log.getStackTraceString(localException));
      }
    }
  }
  
  public void clearDefaultFtnAccountID()
  {
    this.sqliteHelper.removeKeys(this.sqliteHelper.getWritableDatabase(), new String[] { "default_ftn_account" });
  }
  
  public void deleteNoteDefaultCat(int paramInt)
  {
    this.sqliteHelper.removeKeys(this.sqliteHelper.getWritableDatabase(), new String[] { "note_default_cat__" + paramInt });
  }
  
  protected void deleteSettingByAccountId(int paramInt)
  {
    this.sqliteHelper.removeKeysByAccountId(this.sqliteHelper.getWritableDatabase(), paramInt);
  }
  
  public final List<String> dumpSystemSettings()
  {
    Object localObject = new Uri[3];
    localObject[0] = Uri.parse("content://settings/secure");
    localObject[1] = Uri.parse("content://settings/global");
    localObject[2] = Settings.System.CONTENT_URI;
    StringBuilder localStringBuilder = new StringBuilder();
    int j = localObject.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Uri localUri = localObject[i];
        try
        {
          localStringBuilder.append(localUri.toString() + "\n");
          dumpSystemSetting(localUri, localStringBuilder);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localStringBuilder.append("dump setting on " + localUri.toString() + ", " + localException.toString());
          }
        }
      }
    }
    localObject = new ArrayList();
    ((List)localObject).add(localStringBuilder.toString());
    return localObject;
  }
  
  public boolean getAboutRead()
  {
    String str = this.sqliteHelper.getValue("about_read");
    if ((str != null) && (!str.equals(""))) {
      return Integer.parseInt(str) == 1;
    }
    return false;
  }
  
  public Bitmap getAccountIconLocal(String paramString, int paramInt)
  {
    paramString = FileUtil.getEmailIconDirPath() + paramString + File.separator;
    paramString = paramString + paramInt;
    if (!new File(paramString).exists()) {
      return null;
    }
    return BitmapFactory.decodeFile(paramString);
  }
  
  public String getAccountNick(int paramInt)
  {
    String str = "nickname_" + paramInt;
    return this.sqliteHelper.getValue(str);
  }
  
  public String getAccountSignature(int paramInt)
  {
    String str = "signature_" + paramInt;
    return this.sqliteHelper.getValue(str);
  }
  
  public int getAddrVipDisplay()
  {
    String str = this.sqliteHelper.getValue("show_addrvip");
    if ((str != null) && (!str.equals(""))) {
      return Integer.valueOf(str).intValue();
    }
    return 0;
  }
  
  public long getAddrVipLoadUTC(int paramInt)
  {
    String str = "addr_load_utc_" + paramInt;
    str = this.sqliteHelper.getValue(str);
    if (StringUtils.isEmpty(str)) {
      return 0L;
    }
    try
    {
      long l = Long.parseLong(str);
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public int getAddrVipRemoteCount(int paramInt)
  {
    String str = "addrvip_remote_count_" + paramInt;
    str = this.sqliteHelper.getValue(str);
    if ((str != null) && (!str.equals(""))) {
      return Integer.valueOf(str).intValue();
    }
    return 0;
  }
  
  public boolean getAggregateAdMail()
  {
    String str = this.sqliteHelper.getValue("mail_aggregate_ad");
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return true;
  }
  
  public boolean getAggregateSubject(int paramInt)
  {
    boolean bool2 = true;
    Object localObject = "aggregate_subject_" + paramInt;
    localObject = this.sqliteHelper.getValue((String)localObject);
    boolean bool1;
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      bool1 = Boolean.valueOf((String)localObject).booleanValue();
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            localObject = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
            bool1 = bool2;
          } while (localObject == null);
          bool1 = bool2;
        } while (((Account)localObject).isQQMail());
        bool1 = bool2;
      } while (((Account)localObject).isTencentDotCom());
      bool1 = bool2;
    } while (((Account)localObject).isGMail());
    return false;
  }
  
  public boolean getAggregateSubscribeMail()
  {
    String str = this.sqliteHelper.getValue("mail_aggregate_book");
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return true;
  }
  
  public long getAlignAccountLatestTime()
  {
    String str = this.sqliteHelper.getValue("align_account_time");
    if ((str == null) || (str.equals("")))
    {
      setAlignAccountLatestTime(new Date().getTime());
      return 0L;
    }
    return Long.parseLong(str);
  }
  
  public List<String> getAllSettingItem()
  {
    return this.sqliteHelper.getAllItem(this.sqliteHelper.getReadableDatabase());
  }
  
  public boolean getAppGuideUpgradedAccount()
  {
    String str = this.sqliteHelper.getValue("guide_upgraded_add_account");
    return (str != null) && (!str.equals(""));
  }
  
  public boolean getAppTopBarGuideUpgradedAccount()
  {
    String str = this.sqliteHelper.getValue("guide_upgraded_add_account_topbar");
    return (str != null) && (!str.equals(""));
  }
  
  public String getAppUpgradeMasterUin()
  {
    String str2 = this.sqliteHelper.getValue("masteruin");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public String getAttachFolderListSyncToken(int paramInt)
  {
    String str = AttachToolbox.buildAttachFolderSyncTokenKey(paramInt);
    str = this.sqliteHelper.getValue(str);
    if ((str != null) && (!str.equals(""))) {
      return str;
    }
    return "";
  }
  
  public boolean getAttachFolderLockStatus(int paramInt)
  {
    String str = AttachToolbox.buildAttachFolderLockStatusKey(paramInt);
    str = this.sqliteHelper.getValue(str);
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return false;
  }
  
  public boolean getBonus()
  {
    boolean bool = true;
    String str = "bonus" + AppConfig.getCodeVersionName();
    str = this.sqliteHelper.getValue(str);
    if ((str == null) || (str.equals(""))) {
      bool = false;
    }
    while (Integer.parseInt(str) == 1) {
      return bool;
    }
    return false;
  }
  
  public boolean getBonusTest()
  {
    boolean bool = true;
    String str = "bonus_test" + AppConfig.getCodeVersionName();
    str = this.sqliteHelper.getValue(str);
    if ((str == null) || (str.equals(""))) {
      bool = false;
    }
    while (Integer.parseInt(str) == 1) {
      return bool;
    }
    return false;
  }
  
  public boolean getCalendarDisplay()
  {
    String str = this.sqliteHelper.getValue("show_calendar");
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return true;
  }
  
  public boolean getCalendarNew()
  {
    String str = this.sqliteHelper.getValue("show_calendar_new");
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return false;
  }
  
  public boolean getCardBirthdayRemind()
  {
    String str = this.sqliteHelper.getValue("card_birthday_remind");
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return false;
  }
  
  public boolean getCardDisplay()
  {
    String str = this.sqliteHelper.getValue("show_card");
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return true;
  }
  
  public int getCharSet()
  {
    int k = 0;
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < localAccountList.size())
      {
        String str = this.sqliteHelper.getValue("charset" + localAccountList.get(i).getId());
        if ((str != null) && (!str.equals("")) && (Integer.parseInt(str) == 1)) {
          j = 1;
        }
      }
      else
      {
        return j;
      }
      i += 1;
    }
  }
  
  public String getComposeData(int paramInt)
  {
    String str = "compose_data_prefix___" + paramInt;
    str = this.sqliteHelper.getValue(str);
    if ((str != null) && (!str.equals(""))) {
      return str;
    }
    return "";
  }
  
  public boolean getContactDisplay()
  {
    String str = this.sqliteHelper.getValue("show_contact");
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return true;
  }
  
  public String getContactGroupCheckedAccountIds()
  {
    String str2 = this.sqliteHelper.getValue("contact_group_checked_account_ids");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public String getContactSyncKey(int paramInt, MailContact.ContactType paramContactType)
  {
    paramContactType = getContactSyncKeyPrefix(paramContactType) + paramInt;
    paramContactType = this.sqliteHelper.getValue(paramContactType);
    if ((paramContactType != null) && (!paramContactType.equals(""))) {
      return paramContactType;
    }
    return "";
  }
  
  public int getDefaultBottleAccountID()
  {
    String str = this.sqliteHelper.getValue("default_bottle_account");
    int i;
    if ((str != null) && (!str.equals("")))
    {
      i = Integer.parseInt(str);
      if (AccountManager.shareInstance().getAccountList().getAccountById(i) == null) {}
    }
    int j;
    do
    {
      return i;
      j = getFirstAccountIDForBottle();
      i = j;
    } while (j <= 0);
    setDefaultBottleAccountID(0, j);
    return j;
  }
  
  public int getDefaultFtnAccountID()
  {
    if (!getFtnDisplay()) {
      return -1;
    }
    Object localObject = this.sqliteHelper.getValue("default_ftn_account");
    int j;
    try
    {
      i = Integer.parseInt((String)localObject);
      j = i;
      if (i != -1)
      {
        j = i;
        if (AccountManager.shareInstance().getAccountList().getAccountById(i) == null)
        {
          clearDefaultFtnAccountID();
          j = -1;
        }
      }
      if (j == -1)
      {
        localObject = AccountManager.shareInstance().getAccountList().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Account localAccount = (Account)((Iterator)localObject).next();
          if (localAccount.isQQMail())
          {
            i = localAccount.getId();
            setDefaultFtnAccountID(i);
            return i;
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = -1;
      }
    }
    return j;
  }
  
  public int getDefaultMailAccountID()
  {
    Object localObject = this.sqliteHelper.getValue("default_mail_account");
    try
    {
      j = Integer.parseInt((String)localObject);
      int i = j;
      if (j != 0)
      {
        i = j;
        if (AccountManager.shareInstance().getAccountList().getAccountById(j) == null)
        {
          setDefaultMailAccountID(0);
          i = 0;
        }
      }
      j = i;
      if (i == 0)
      {
        localObject = AccountManager.shareInstance().getAccountList();
        j = i;
        if (((AccountList)localObject).size() > 0)
        {
          j = ((AccountList)localObject).get(0).getId();
          setDefaultMailAccountID(j);
        }
      }
      return j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int j = 0;
      }
    }
  }
  
  public int getDefaultNoteAccountID()
  {
    if (!getNoteDisplay()) {
      return -1;
    }
    Object localObject = this.sqliteHelper.getValue("default_note_account");
    int j;
    try
    {
      i = Integer.parseInt((String)localObject);
      j = i;
      if (i != -1)
      {
        j = i;
        if (AccountManager.shareInstance().getAccountList().getAccountById(i) == null)
        {
          setDefaultNoteAccountID(-1);
          j = -1;
        }
      }
      if (j == -1)
      {
        localObject = AccountManager.shareInstance().getAccountList().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Account localAccount = (Account)((Iterator)localObject).next();
          if (localAccount.isQQMail())
          {
            i = localAccount.getId();
            setDefaultNoteAccountID(i);
            return i;
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = -1;
      }
    }
    return j;
  }
  
  public String getDownloadPath()
  {
    String str = this.sqliteHelper.getValue("download_path");
    if ((str != null) && (!str.equals(""))) {
      return str;
    }
    return "";
  }
  
  public boolean getEnablePushNewMailVibrate()
  {
    String str = this.sqliteHelper.getValue("new_mail_viberate");
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return true;
  }
  
  public boolean getEnableSendMailSound()
  {
    String str = this.sqliteHelper.getValue("send_mail_has_sound");
    if ((str == null) || (str.equals(""))) {}
    while (Integer.parseInt(str) == 1) {
      return true;
    }
    return false;
  }
  
  public boolean getEnableSoundPushNewMail()
  {
    String str = this.sqliteHelper.getValue("new_mail_sound");
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return true;
  }
  
  public int getFirstAccountIDForBottle()
  {
    if (isBottleEnabled())
    {
      AccountList localAccountList = AccountManager.shareInstance().getAccountList();
      int i = 0;
      while (i < localAccountList.size())
      {
        Account localAccount = localAccountList.get(i);
        if ((localAccount.isQQMail()) && (!localAccount.isBizMail())) {
          return localAccount.getId();
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public boolean getFtnDisplay()
  {
    String str = this.sqliteHelper.getValue("show_ftn");
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return true;
  }
  
  public String getGmailWebViewUserAgent()
  {
    String str2 = this.sqliteHelper.getValue("gmal_webview_ua");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    return str1;
  }
  
  public String getImapUserAgentId()
  {
    String str = this.sqliteHelper.getValue("imap_ua_config");
    if ((str != null) && (!str.equals(""))) {
      return str;
    }
    return "";
  }
  
  public boolean getIncrementBadge()
  {
    String str = this.sqliteHelper.getValue("badge_increment_open");
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return true;
  }
  
  public long getInquiryMailAccountEdgeTime(int paramInt)
  {
    String str = "inquiry_mail_account_edge_time" + paramInt;
    str = this.sqliteHelper.getValue(str);
    if (TextUtils.isEmpty(str)) {
      return 0L;
    }
    return Long.valueOf(str).longValue();
  }
  
  public int getInquiryMailAccountPage(int paramInt)
  {
    String str = "inquiry_mail_account_page" + paramInt;
    str = this.sqliteHelper.getValue(str);
    if (TextUtils.isEmpty(str)) {
      return 0;
    }
    return Integer.valueOf(str).intValue();
  }
  
  public long getInquiryMailTipsInterval()
  {
    String str = this.sqliteHelper.getValue("inquiry_mail_tips_interval");
    if (TextUtils.isEmpty(str)) {
      return 20000L;
    }
    return Long.valueOf(str).longValue();
  }
  
  public int getInquiryMailTipsTimes()
  {
    String str = this.sqliteHelper.getValue("inquiry_mail_tips_times");
    if (TextUtils.isEmpty(str)) {
      return 4;
    }
    return Integer.valueOf(str).intValue();
  }
  
  public boolean getIsShowTranslateProtocolMailTips()
  {
    String str = this.sqliteHelper.getValue("show_translate_protocol_mail_tips");
    if (TextUtils.isEmpty(str)) {
      return true;
    }
    return Boolean.valueOf(str).booleanValue();
  }
  
  public String getLastDownloadDirPath()
  {
    String str = this.sqliteHelper.getValue("last_download_dir_path");
    if ((str != null) && (!str.equals(""))) {
      return str;
    }
    return null;
  }
  
  public long getLastLastSSLErrorNotificationTime()
  {
    String str = this.sqliteHelper.getValue("last_ssl_error_notfication_utc");
    if ((str == null) || (str.equals(""))) {
      return 0L;
    }
    return Long.parseLong(str);
  }
  
  public long getLastLoadBlackWhiteNameListTime(int paramInt)
  {
    String str = "last_load_name_list_time" + paramInt;
    str = this.sqliteHelper.getValue(str);
    if ((str != null) && (!str.equals(""))) {
      return Long.parseLong(str);
    }
    return 0L;
  }
  
  public long getLastLoadContactTime(int paramInt)
  {
    String str = "LOAD_ACCOUNT_CONTACT_" + paramInt;
    str = this.sqliteHelper.getValue(str);
    if ((str != null) && (!str.equals(""))) {
      return Long.parseLong(str);
    }
    return 0L;
  }
  
  public int getLastMobileContactCount()
  {
    String str = this.sqliteHelper.getValue("mobile_contact_count");
    if ((str != null) && (!str.equals(""))) {
      return Integer.parseInt(str);
    }
    return 0;
  }
  
  public long getLastSync()
  {
    String str = this.sqliteHelper.getValue("last_sync");
    if ((str == null) || (str.equals(""))) {
      return 0L;
    }
    return Long.parseLong(str);
  }
  
  public long getLastSyncAdRule()
  {
    String str = this.sqliteHelper.getValue("last_sync_ad_rule");
    if ((str == null) || (str.equals(""))) {
      return 0L;
    }
    return Long.parseLong(str);
  }
  
  public long getLastUpdateGroupContactTime(int paramInt)
  {
    String str = "GROUP_MAIL_CONTACT_LAST_SYNC_TIME_" + paramInt;
    str = this.sqliteHelper.getValue(str);
    if ((str != null) && (!str.equals(""))) {
      return Long.parseLong(str);
    }
    return 0L;
  }
  
  public long getLastUpdateMobileContactTime()
  {
    String str = this.sqliteHelper.getValue("import_contact_timestamp");
    if ((str != null) && (!str.equals(""))) {
      return Long.parseLong(str);
    }
    return 0L;
  }
  
  public String getLastUploadDirPath(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "last_upload_dir_path_Sytesm";; str = "last_upload_dir_path_Sdcard")
    {
      str = this.sqliteHelper.getValue(str);
      if ((str == null) || (str.equals(""))) {
        break;
      }
      return str;
    }
    return null;
  }
  
  public long getLogAppStateLatestTime()
  {
    String str = this.sqliteHelper.getValue("log_app_state_time");
    if ((str == null) || (str.equals("")))
    {
      setLogAppStateLatestTime(new Date().getTime());
      return 0L;
    }
    return Long.parseLong(str);
  }
  
  public boolean getMailListHeadClicked()
  {
    String str = this.sqliteHelper.getValue("mail_list_head_click");
    return (str != null) && (!str.equals(""));
  }
  
  public boolean getMailListIcon()
  {
    String str = this.sqliteHelper.getValue("show_maillist_head_icon");
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return true;
  }
  
  public int getMailLoadImgType()
  {
    String str = this.sqliteHelper.getValue("mail_load_img_type");
    if ((str != null) && (!str.equals(""))) {
      return Integer.parseInt(str);
    }
    return 0;
  }
  
  public String getMiscCheckLink()
  {
    return this.sqliteHelper.getValue("misc_checklink_url");
  }
  
  public String getNameListSyncKey(int paramInt)
  {
    String str = "name_list_sync_key_" + paramInt;
    str = this.sqliteHelper.getValue(str);
    if ((str != null) && (!str.equals(""))) {
      return str;
    }
    return "";
  }
  
  public boolean getNewVersionRead()
  {
    String str = "aboud_new_version_read" + AppConfig.getCodeVersionName();
    str = this.sqliteHelper.getValue(str);
    if ((str == null) || (str.equals(""))) {}
    while (Integer.parseInt(str) == 1) {
      return true;
    }
    return false;
  }
  
  public String getNoteDefaultCat(int paramInt)
  {
    String str = "note_default_cat__" + paramInt;
    return this.sqliteHelper.getValue(str);
  }
  
  public boolean getNoteDisplay()
  {
    return false;
  }
  
  public int getNoteImgCompressRatio()
  {
    String str = this.sqliteHelper.getValue("note_img_compress_ratio");
    if ((str != null) && (!str.equals(""))) {
      return Integer.parseInt(str);
    }
    return 2;
  }
  
  public String getNoteSortType(int paramInt)
  {
    String str = "note_sort_type__" + paramInt;
    if (StringUtils.equals(this.sqliteHelper.getValue(str), "1")) {
      return "1";
    }
    return "0";
  }
  
  public boolean getNotificationShortCutEnable()
  {
    String str = this.sqliteHelper.getValue("notification_shortcut_enable");
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return false;
  }
  
  public boolean getNotifyAccountMail(int paramInt)
  {
    String str = "account_new_mail_push_suffix_" + paramInt;
    str = this.sqliteHelper.getValue(str);
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return true;
  }
  
  public boolean getNotifyAdMail()
  {
    String str = this.sqliteHelper.getValue("ad_mail_notify");
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return true;
  }
  
  public boolean getNotifyNewMail()
  {
    String str = this.sqliteHelper.getValue("new_mail_push");
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return true;
  }
  
  public boolean getOnlyNotifyVIP()
  {
    String str = this.sqliteHelper.getValue("mail_push_important_contact");
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return false;
  }
  
  public boolean getOnlyPushMailApp(int paramInt)
  {
    boolean bool = true;
    String str = "onlypushmailapp__" + paramInt;
    str = this.sqliteHelper.getValue(str);
    if ((str == null) || (str.equals(""))) {
      bool = false;
    }
    while (Integer.parseInt(str) == 1) {
      return bool;
    }
    return false;
  }
  
  public boolean getPopFolderGuideAdd(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    String str = "pop_folder_guide_" + paramInt1 + "_" + paramInt2;
    str = this.sqliteHelper.getValue(str);
    if ((str == null) || (str.equals(""))) {
      bool = false;
    }
    while (Integer.parseInt(str) == 1) {
      return bool;
    }
    return false;
  }
  
  public String getPullDownPopularizeURL()
  {
    String str = this.sqliteHelper.getValue("pull_down_popularize_url");
    if ((str != null) && (!str.equals(""))) {
      return str;
    }
    return "";
  }
  
  public boolean getPushInboxOnly(int paramInt)
  {
    String str = "push_account_inbox_only_suffix_" + paramInt;
    str = this.sqliteHelper.getValue(str);
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return false;
  }
  
  /* Error */
  public Uri getPushSoundUri(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +13 -> 14
    //   4: aload_1
    //   5: ldc_w 658
    //   8: invokevirtual 264	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: new 660	android/media/RingtoneManager
    //   19: dup
    //   20: invokestatic 38	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   23: invokespecial 661	android/media/RingtoneManager:<init>	(Landroid/content/Context;)V
    //   26: astore_3
    //   27: aload_3
    //   28: iconst_2
    //   29: invokevirtual 664	android/media/RingtoneManager:setType	(I)V
    //   32: aload_3
    //   33: invokevirtual 668	android/media/RingtoneManager:getCursor	()Landroid/database/Cursor;
    //   36: astore_3
    //   37: aload_3
    //   38: ifnull +222 -> 260
    //   41: aload_1
    //   42: iconst_0
    //   43: aload_1
    //   44: ldc_w 670
    //   47: invokevirtual 673	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   50: invokevirtual 677	java/lang/String:substring	(II)Ljava/lang/String;
    //   53: ldc_w 679
    //   56: ldc_w 681
    //   59: invokevirtual 685	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   62: invokevirtual 688	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   65: astore 4
    //   67: iconst_4
    //   68: ldc 21
    //   70: new 89	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   77: ldc_w 690
    //   80: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_1
    //   84: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc_w 692
    //   90: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload 4
    //   95: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 205	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   104: aload_3
    //   105: invokeinterface 695 1 0
    //   110: ifeq +333 -> 443
    //   113: aload_3
    //   114: iconst_0
    //   115: invokeinterface 698 2 0
    //   120: istore_2
    //   121: aload_3
    //   122: iconst_1
    //   123: invokeinterface 100 2 0
    //   128: astore 5
    //   130: aload_3
    //   131: iconst_2
    //   132: invokeinterface 100 2 0
    //   137: astore 6
    //   139: aload 5
    //   141: ldc_w 679
    //   144: ldc_w 681
    //   147: invokevirtual 685	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   150: invokevirtual 688	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   153: aload 4
    //   155: invokevirtual 264	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   158: ifeq -54 -> 104
    //   161: iconst_4
    //   162: ldc 21
    //   164: new 89	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   171: ldc_w 700
    //   174: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload 5
    //   179: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: ldc_w 702
    //   185: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload 6
    //   190: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc_w 692
    //   196: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: iload_2
    //   200: invokevirtual 167	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   203: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 205	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   209: new 89	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   216: aload 6
    //   218: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc_w 692
    //   224: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: iload_2
    //   228: invokevirtual 167	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   231: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 231	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   237: astore 4
    //   239: aload_3
    //   240: invokeinterface 111 1 0
    //   245: aload 4
    //   247: areturn
    //   248: astore_3
    //   249: bipush 6
    //   251: ldc 21
    //   253: ldc_w 704
    //   256: aload_3
    //   257: invokestatic 707	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   260: iconst_5
    //   261: ldc 21
    //   263: new 89	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   270: ldc_w 709
    //   273: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_1
    //   277: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 205	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   286: new 89	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   293: ldc_w 711
    //   296: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_1
    //   300: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: astore_3
    //   307: new 273	java/io/File
    //   310: dup
    //   311: aload_3
    //   312: invokespecial 279	java/io/File:<init>	(Ljava/lang/String;)V
    //   315: astore 4
    //   317: aload 4
    //   319: invokevirtual 714	java/io/File:isFile	()Z
    //   322: ifne +97 -> 419
    //   325: aload 4
    //   327: invokevirtual 718	java/io/File:getParentFile	()Ljava/io/File;
    //   330: new 720	com/tencent/qqmail/model/mail/QMSettingManager$4
    //   333: dup
    //   334: aload_0
    //   335: aload_1
    //   336: invokespecial 723	com/tencent/qqmail/model/mail/QMSettingManager$4:<init>	(Lcom/tencent/qqmail/model/mail/QMSettingManager;Ljava/lang/String;)V
    //   339: invokevirtual 727	java/io/File:list	(Ljava/io/FilenameFilter;)[Ljava/lang/String;
    //   342: astore_3
    //   343: aload_3
    //   344: ifnull +119 -> 463
    //   347: aload_3
    //   348: arraylength
    //   349: ifle +114 -> 463
    //   352: iconst_5
    //   353: ldc 21
    //   355: new 89	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   362: ldc_w 729
    //   365: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: aload_1
    //   369: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: ldc_w 731
    //   375: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: aload_3
    //   379: iconst_0
    //   380: aaload
    //   381: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: ldc_w 733
    //   387: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokestatic 205	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   396: new 89	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   403: ldc_w 711
    //   406: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: aload_3
    //   410: iconst_0
    //   411: aaload
    //   412: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: astore_3
    //   419: new 89	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   426: ldc_w 735
    //   429: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload_3
    //   433: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokestatic 231	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   442: areturn
    //   443: aload_3
    //   444: invokeinterface 111 1 0
    //   449: goto -189 -> 260
    //   452: astore 4
    //   454: aload_3
    //   455: invokeinterface 111 1 0
    //   460: aload 4
    //   462: athrow
    //   463: iconst_5
    //   464: ldc 21
    //   466: new 89	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   473: ldc_w 729
    //   476: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: aload_1
    //   480: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: ldc_w 737
    //   486: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokestatic 205	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   495: aconst_null
    //   496: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	497	0	this	QMSettingManager
    //   0	497	1	paramString	String
    //   120	108	2	i	int
    //   26	214	3	localObject1	Object
    //   248	9	3	localThrowable	java.lang.Throwable
    //   306	149	3	localObject2	Object
    //   65	261	4	localObject3	Object
    //   452	9	4	localObject4	Object
    //   128	50	5	str1	String
    //   137	80	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   16	37	248	java/lang/Throwable
    //   239	245	248	java/lang/Throwable
    //   443	449	248	java/lang/Throwable
    //   454	463	248	java/lang/Throwable
    //   41	104	452	finally
    //   104	239	452	finally
  }
  
  public Uri getPushSoundUri(boolean paramBoolean)
  {
    String str1;
    if (paramBoolean)
    {
      str1 = getSoundTypeKeyManFrom();
      if (!paramBoolean) {
        break label38;
      }
    }
    label38:
    for (String str2 = getSoundTypeKeyManString();; str2 = getSoundTypeNewMailString())
    {
      if (!str2.equals("default")) {
        break label46;
      }
      return null;
      str1 = getSoundTypeNewMailFrom();
      break;
    }
    label46:
    if ("0".equals(str1)) {
      return getPushSoundUri(str2);
    }
    return Uri.parse("android.resource://com.tencent.androidqqmail/raw/" + str2.toLowerCase());
  }
  
  public int getQQAccountPswLength(int paramInt)
  {
    String str = "qq_psw_len_" + paramInt;
    str = this.sqliteHelper.getValue(str);
    if ((str != null) && (!str.equals(""))) {
      return Integer.parseInt(str);
    }
    return -1;
  }
  
  public boolean getRemindSecApp()
  {
    String str = this.sqliteHelper.getValue("remind_secapp");
    return (str == null) || (str.equals(""));
  }
  
  public int getReplyForwardSubjectType()
  {
    String str = this.sqliteHelper.getValue("reply_forward_subject_type");
    if ((str != null) && (!str.equals(""))) {
      return Integer.parseInt(str);
    }
    return 0;
  }
  
  public int getReplyWithOriginType()
  {
    String str = this.sqliteHelper.getValue("reply_with_origin_type");
    if ((str != null) && (!str.equals(""))) {
      return Integer.parseInt(str);
    }
    return 0;
  }
  
  public long getSSLErrorTime()
  {
    String str = this.sqliteHelper.getValue("ssl_error_time");
    if ((str != null) && (!str.equals(""))) {
      return Long.parseLong(str);
    }
    return 0L;
  }
  
  public int getSearchDefaultType()
  {
    String str = this.sqliteHelper.getValue("search_default_type");
    if ((str == null) || (str.equals(""))) {
      return 1;
    }
    return Integer.parseInt(str);
  }
  
  public String getSearchExchangeAddress(int paramInt, String paramString)
  {
    paramString = "SEARCH_EXCHANGE_ADDR_" + paramInt + "_" + paramString;
    paramString = this.sqliteHelper.getValue(paramString);
    if ((paramString != null) && (!paramString.equals(""))) {
      return paramString;
    }
    return "";
  }
  
  public boolean getShowMailDetail()
  {
    String str = this.sqliteHelper.getValue("show_push_mail_detail");
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return true;
  }
  
  public boolean getShowSplashList()
  {
    String str = this.sqliteHelper.getValue("show_splash_list");
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return false;
  }
  
  public boolean getShownWelcomePages()
  {
    String str = "shown_welcome_" + AppConfig.getMajorVersion(QMApplicationContext.sharedInstance());
    str = this.sqliteHelper.getValue(str);
    if ((str == null) || (str.equals("")))
    {
      str = this.sqliteHelper.getValue("shown_welcome_3.0");
      if ((str != null) && (!str.equals(""))) {
        if (Integer.parseInt(str) != 1) {}
      }
    }
    while (Integer.parseInt(str) == 1)
    {
      do
      {
        return true;
        return false;
        str = this.sqliteHelper.getValue("shown_welcome_3.1.0");
        if ((str == null) || (str.equals(""))) {
          break;
        }
      } while (Integer.parseInt(str) == 1);
      return false;
      return false;
    }
    return false;
  }
  
  public boolean getShutdownBefore()
  {
    boolean bool2 = false;
    String str = this.sqliteHelper.getValue("shutdown_before");
    boolean bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if (!str.equals(""))
      {
        bool1 = bool2;
        if (str.equals("1")) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  @Nullable
  public String getSoundTypeKeyManFrom()
  {
    String str2 = this.sqliteHelper.getValue("mail_voice_key_man_from");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "0";
    }
    return str1;
  }
  
  public String getSoundTypeKeyManString()
  {
    String str = this.sqliteHelper.getValue("mail_voice_key_man_string");
    if ((str != null) && (!str.equals(""))) {
      return str;
    }
    return "default";
  }
  
  @NonNull
  public String getSoundTypeNewMailFrom()
  {
    String str2 = this.sqliteHelper.getValue("mail_voice_new_mail_from");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "0";
    }
    return str1;
  }
  
  public String getSoundTypeNewMailString()
  {
    String str = this.sqliteHelper.getValue("mail_voice_new_mail_string");
    if ((str != null) && (!str.equals(""))) {
      return str;
    }
    return "default";
  }
  
  public int getStarAttachDisplay()
  {
    String str = this.sqliteHelper.getValue("show_starattach");
    if ((str != null) && (!str.equals(""))) {
      return Integer.valueOf(str).intValue();
    }
    return 0;
  }
  
  public int getStarAttachRemoteCount(int paramInt)
  {
    String str = "starattach_remote_count_" + paramInt;
    str = this.sqliteHelper.getValue(str);
    if ((str != null) && (!str.equals(""))) {
      return Integer.valueOf(str).intValue();
    }
    return 0;
  }
  
  public String getSysConfig()
  {
    String str = this.sqliteHelper.getValue("sys_config");
    if ((str != null) && (!str.equals(""))) {
      return str;
    }
    return "";
  }
  
  public boolean getTelphonePromotionRedPoint()
  {
    String str = this.sqliteHelper.getValue("show_tel_promotion_redpoint");
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return false;
  }
  
  public long getTimeZoneLastWaken()
  {
    String str = this.sqliteHelper.getValue("time_zone_last_waken");
    try
    {
      long l = Long.parseLong(str);
      return l;
    }
    catch (Exception localException) {}
    return -9223372036854775808L;
  }
  
  public boolean getTranslatePromotionBubble()
  {
    String str = this.sqliteHelper.getValue("show_translation_promotion_bubble");
    if (TextUtils.isEmpty(str)) {
      return true;
    }
    return Boolean.valueOf(str).booleanValue();
  }
  
  public int getTryGestureTimes()
  {
    SharedPreferences localSharedPreferences = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0);
    int i = localSharedPreferences.getInt("gesture_psw_times", -1);
    if (i == -1)
    {
      localSharedPreferences.edit().putInt("gesture_psw_times", 0).commit();
      return 0;
    }
    return i;
  }
  
  public long getUpdateConfigLatestTime()
  {
    String str = this.sqliteHelper.getValue("update_config_time");
    if ((str == null) || (str.equals(""))) {
      return 0L;
    }
    return Long.parseLong(str);
  }
  
  public boolean getUpgradeFromOldApp()
  {
    String str = this.sqliteHelper.getValue("upgrade_from_old_app");
    return (str != null) && (!str.equals(""));
  }
  
  public boolean getUseNightMode()
  {
    String str = this.sqliteHelper.getValue("push_night_mode");
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return true;
  }
  
  public boolean getWipeActiveSync(int paramInt)
  {
    String str = "wipe_app_as_suffix" + paramInt;
    str = this.sqliteHelper.getValue(str);
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return false;
  }
  
  public boolean getWipeAll()
  {
    String str = this.sqliteHelper.getValue("wipe_app_all");
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return false;
  }
  
  public void initData()
  {
    this.sqliteHelper.initCache(this.sqliteHelper.getReadableDatabase());
  }
  
  /* Error */
  public void insertItem(ArrayList<com.tencent.qqmail.model.cache.SettingItem> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 63	com/tencent/qqmail/model/mail/QMSettingManager:sqliteHelper	Lcom/tencent/qqmail/model/mail/QMSettingSQLiteHelper;
    //   4: invokevirtual 164	com/tencent/qqmail/model/mail/QMSettingSQLiteHelper:getWritableDatabase	()Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   7: astore_2
    //   8: aload_2
    //   9: invokevirtual 879	com/tencent/moai/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   12: aload_1
    //   13: invokevirtual 880	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   16: astore_1
    //   17: aload_1
    //   18: invokeinterface 479 1 0
    //   23: ifeq +42 -> 65
    //   26: aload_1
    //   27: invokeinterface 482 1 0
    //   32: checkcast 882	com/tencent/qqmail/model/cache/SettingItem
    //   35: astore_3
    //   36: aload_0
    //   37: getfield 63	com/tencent/qqmail/model/mail/QMSettingManager:sqliteHelper	Lcom/tencent/qqmail/model/mail/QMSettingSQLiteHelper;
    //   40: aload_2
    //   41: aload_3
    //   42: invokevirtual 885	com/tencent/qqmail/model/mail/QMSettingSQLiteHelper:insertItem	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;Lcom/tencent/qqmail/model/cache/SettingItem;)V
    //   45: goto -28 -> 17
    //   48: astore_1
    //   49: bipush 6
    //   51: ldc 21
    //   53: aload_1
    //   54: invokevirtual 888	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   57: invokestatic 205	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   60: aload_2
    //   61: invokevirtual 891	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   64: return
    //   65: aload_2
    //   66: invokevirtual 894	com/tencent/moai/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   69: aload_2
    //   70: invokevirtual 891	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   73: return
    //   74: astore_1
    //   75: aload_2
    //   76: invokevirtual 891	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	QMSettingManager
    //   0	81	1	paramArrayList	ArrayList<com.tencent.qqmail.model.cache.SettingItem>
    //   7	69	2	localSQLiteDatabase	SQLiteDatabase
    //   35	7	3	localSettingItem	com.tencent.qqmail.model.cache.SettingItem
    // Exception table:
    //   from	to	target	type
    //   8	17	48	java/lang/Exception
    //   17	45	48	java/lang/Exception
    //   65	69	48	java/lang/Exception
    //   8	17	74	finally
    //   17	45	74	finally
    //   49	60	74	finally
    //   65	69	74	finally
  }
  
  public boolean isAddrVipRemoteActivate(ArrayList<Integer> paramArrayList)
  {
    boolean bool = false;
    int i = 0;
    int j = 0;
    while (i < paramArrayList.size())
    {
      j += getAddrVipRemoteCount(((Integer)paramArrayList.get(i)).intValue());
      i += 1;
    }
    if (j > 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isAvatarPhotoRedirect()
  {
    String str = this.sqliteHelper.getValue("avatar_use_redirect");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return Boolean.valueOf(str).booleanValue();
  }
  
  public boolean isBottleEnabled()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (AccountManager.shareInstance().getAccountList().getPureQQMailAccountNumber() == 0) {
      return false;
    }
    String str = this.sqliteHelper.getValue("show_bottle_ver2");
    if ((str != null) && (str.length() > 0)) {}
    for (int i = Integer.parseInt(str);; i = 0)
    {
      if ((i & 0x3) > 0)
      {
        if ((i & 0x1) == 1) {}
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
      }
      if ((i & 0xC) <= 0) {
        break;
      }
      if ((i & 0x4) == 4) {}
      for (bool1 = bool2;; bool1 = false) {
        return bool1;
      }
    }
  }
  
  public boolean isEnableChromeDebug()
  {
    String str = this.sqliteHelper.getValue("enable_chrome_debug_mode");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return Boolean.valueOf(str).booleanValue();
  }
  
  public boolean isEnableDomainAppend()
  {
    String str = this.sqliteHelper.getValue("enable_domain_append");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return Boolean.valueOf(str).booleanValue();
  }
  
  public boolean isEnableGmailAuth()
  {
    String str = this.sqliteHelper.getValue("enable_gmail_auth");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return Boolean.valueOf(str).booleanValue();
  }
  
  public boolean isEnableHttpsDomain()
  {
    long l = getSSLErrorTime();
    if (System.currentTimeMillis() - l <= 86400000L)
    {
      QMLog.log(5, "QMSettingManager", "Your are in the http-Forbidden period! " + l);
      return false;
    }
    return true;
  }
  
  public boolean isEnableJavaEasService()
  {
    String str = this.sqliteHelper.getValue("enable_java_eas_service");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return Boolean.valueOf(str).booleanValue();
  }
  
  public boolean isEnableJavaEwsService()
  {
    String str = this.sqliteHelper.getValue("enable_java_ews_service");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return Boolean.valueOf(str).booleanValue();
  }
  
  public boolean isEnableJavaImapIdle()
  {
    String str = this.sqliteHelper.getValue("enable_java_imap_idle");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return Boolean.valueOf(str).booleanValue();
  }
  
  public boolean isEnableJavaImapService()
  {
    String str = this.sqliteHelper.getValue("enable_java_imap_service");
    if (TextUtils.isEmpty(str)) {
      return true;
    }
    return Boolean.valueOf(str).booleanValue();
  }
  
  public boolean isEnableJavaPop3Service()
  {
    String str = this.sqliteHelper.getValue("enable_java_pop3_service");
    if (TextUtils.isEmpty(str)) {
      return true;
    }
    return Boolean.valueOf(str).booleanValue();
  }
  
  public boolean isEnableJavaSmtpService()
  {
    String str = this.sqliteHelper.getValue("enable_java_smtp_service");
    if (TextUtils.isEmpty(str)) {
      return true;
    }
    return Boolean.valueOf(str).booleanValue();
  }
  
  public boolean isEnableProtocolApiOsslog()
  {
    return true;
  }
  
  public boolean isEnableQQBrowserX5()
  {
    String str = this.sqliteHelper.getValue("enable_qq_browser_x5");
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return true;
  }
  
  public boolean isEnableSettingDomainConfig()
  {
    return true;
  }
  
  public boolean isEnableTranslate()
  {
    String str = this.sqliteHelper.getValue("enable_translation");
    if ((str == null) || (str.equals(""))) {
      return true;
    }
    return Boolean.valueOf(str).booleanValue();
  }
  
  public boolean isEnableUpgradeFts()
  {
    String str = this.sqliteHelper.getValue("enable_upgrade_fts_upgrade");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return Boolean.valueOf(str).booleanValue();
  }
  
  public boolean isFirstTimeFromTim()
  {
    String str = this.sqliteHelper.getValue("first_time_from_tim");
    if ((str == null) || (str.equals(""))) {
      return true;
    }
    return Boolean.valueOf(str).booleanValue();
  }
  
  public int isInquiryMailAccountHasMore(int paramInt)
  {
    String str = "inquiry_mail_account_has_more" + paramInt;
    str = this.sqliteHelper.getValue(str);
    if (TextUtils.isEmpty(str)) {
      return 0;
    }
    return Integer.valueOf(str).intValue();
  }
  
  public boolean isInquiryMailTipsShow()
  {
    String str = this.sqliteHelper.getValue("inquiry_mail_tips_show");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return Boolean.valueOf(str).booleanValue();
  }
  
  public boolean isNameListContactLoad(int paramInt)
  {
    String str = "name_list_load_contact_" + paramInt;
    str = this.sqliteHelper.getValue(str);
    if ((str == null) || (str.equals(""))) {
      return false;
    }
    return Boolean.valueOf(str).booleanValue();
  }
  
  public boolean isOutDomainPwdReport()
  {
    boolean bool2 = false;
    String str = this.sqliteHelper.getValue("out_domain_pwd_report");
    boolean bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if (!str.equals(""))
      {
        bool1 = bool2;
        if (str.equals("1")) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean isQuickCalendarSync()
  {
    String str = this.sqliteHelper.getValue("quick_calendar_sync");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return Boolean.valueOf(str).booleanValue();
  }
  
  public boolean isShowAddrVip()
  {
    ArrayList localArrayList = new ArrayList();
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    int i = 0;
    while (i < localAccountList.size())
    {
      Account localAccount = localAccountList.get(i);
      if ((localAccount != null) && (localAccount.isQQMail())) {
        localArrayList.add(Integer.valueOf(localAccount.getId()));
      }
      i += 1;
    }
    return sharedInstance().isAddrVipRemoteActivate(localArrayList);
  }
  
  public boolean isShowGmailBackground()
  {
    String str = this.sqliteHelper.getValue("gmail_show_background");
    if ((str != null) && (!str.equals(""))) {
      return Boolean.valueOf(str).booleanValue();
    }
    return false;
  }
  
  public boolean isStarAttachRemoteActivate(ArrayList<Integer> paramArrayList)
  {
    boolean bool = false;
    int i = 0;
    int j = 0;
    while (i < paramArrayList.size())
    {
      j += getStarAttachRemoteCount(((Integer)paramArrayList.get(i)).intValue());
      i += 1;
    }
    if (j > 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isVidWiped(long paramLong)
  {
    boolean bool = true;
    String str = "vid_wiped_" + paramLong;
    str = this.sqliteHelper.getValue(str);
    if ((str == null) || (str.equals(""))) {
      bool = false;
    }
    while (Integer.parseInt(str) == 1) {
      return bool;
    }
    return false;
  }
  
  public void removeAddrVipLoadUTC(int paramInt)
  {
    String str = "addr_load_utc_" + paramInt;
    this.sqliteHelper.removeKeys(this.sqliteHelper.getWritableDatabase(), new String[] { str });
  }
  
  public void removeAddrVipRemoteCount(int paramInt)
  {
    String str = "addrvip_remote_count_" + paramInt;
    this.sqliteHelper.removeKeys(this.sqliteHelper.getWritableDatabase(), new String[] { str });
  }
  
  public void removeContactSyncKey(int paramInt)
  {
    String str1 = "CONTACT_SYNC_KEY_NORMAL_" + paramInt;
    String str2 = "CONTACT_SYNC_KEY_HISTORY_" + paramInt;
    String str3 = "CONTACT_SYNC_KEY_QQ_" + paramInt;
    String str4 = "CONTACT_SYNC_KEY_DOMAIN_" + paramInt;
    String str5 = "CONTACT_SYNC_KEY_PROTOCOL_" + paramInt;
    this.sqliteHelper.removeKeys(this.sqliteHelper.getWritableDatabase(), new String[] { str1, str2, str3, str4, str5 });
  }
  
  public void removeSearchExchangeAddress(int paramInt, String paramString)
  {
    paramString = "SEARCH_EXCHANGE_ADDR_" + paramInt + "_" + paramString;
    this.sqliteHelper.removeKeys(this.sqliteHelper.getWritableDatabase(), new String[] { paramString });
  }
  
  public void removeStarAttachRemoteCount(int paramInt)
  {
    String str = "starattach_remote_count_" + paramInt;
    this.sqliteHelper.removeKeys(this.sqliteHelper.getWritableDatabase(), new String[] { str });
  }
  
  public void saveTryGestureTimes(int paramInt)
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit().putInt("gesture_psw_times", paramInt).commit();
  }
  
  public void setAboutRead()
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "about_read", "1");
  }
  
  public void setAccountNick(int paramInt, String paramString)
  {
    String str = "nickname_" + paramInt;
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), paramInt, str, paramString, 2);
  }
  
  public void setAccountSignature(int paramInt, String paramString)
  {
    String str = "signature_" + paramInt;
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), paramInt, str, paramString, 1);
  }
  
  public void setAdMailNotify(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "ad_mail_notify", paramBoolean + "");
  }
  
  public void setAddrVipDisplay(int paramInt)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "show_addrvip", String.valueOf(paramInt));
  }
  
  public void setAddrVipLoadUTC(int paramInt, long paramLong)
  {
    String str = "addr_load_utc_" + paramInt;
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), str, String.valueOf(paramLong));
  }
  
  public void setAddrVipRemoteCount(int paramInt1, int paramInt2)
  {
    String str = "addrvip_remote_count_" + paramInt1;
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), str, String.valueOf(paramInt2));
  }
  
  public void setAggregateAdMail(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "mail_aggregate_ad", paramBoolean + "");
    QMMailManager.sharedInstance().setAdAggregate(paramBoolean);
    QMMailManager.sharedInstance().updateAllAdvertiseEntrance();
  }
  
  public void setAggregateSubject(int paramInt, boolean paramBoolean)
  {
    String str = "aggregate_subject_" + paramInt;
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), paramInt, str, paramBoolean + "", 0);
    QMMailManager.sharedInstance().setSubjectAggregate(paramInt, paramBoolean);
  }
  
  public void setAggregateSubscribeMail(boolean paramBoolean)
  {
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getWritableDatabase();
    this.sqliteHelper.setValue(localSQLiteDatabase, "mail_aggregate_book", paramBoolean + "");
    QMMailManager.sharedInstance().setSubscribeAggregate(paramBoolean);
    QMMailManager.sharedInstance().updateAllSubscribeEntrance();
    QMMailManager.sharedInstance().initSubUnreadCache();
  }
  
  public void setAlignAccountLatestTime(long paramLong)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "align_account_time", String.valueOf(paramLong));
  }
  
  public void setAppGuideUpgradedAccount()
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "guide_upgraded_add_account", "1");
  }
  
  public void setAppTopBarGuideUpgradedAccount()
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "guide_upgraded_add_account_topbar", "1");
  }
  
  public void setAppUpgradeMasterUin(String paramString)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "masteruin", paramString);
  }
  
  public void setAttachFolderListSyncToken(int paramInt, String paramString)
  {
    String str = AttachToolbox.buildAttachFolderSyncTokenKey(paramInt);
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), str, paramString);
  }
  
  public void setAttachFolderLockStatus(int paramInt, boolean paramBoolean)
  {
    String str = AttachToolbox.buildAttachFolderLockStatusKey(paramInt);
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), str, paramBoolean + "");
  }
  
  public void setAvatarPhotoRedirect(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "avatar_use_redirect", String.valueOf(paramBoolean));
  }
  
  public void setBonus(boolean paramBoolean)
  {
    String str2 = "bonus" + AppConfig.getCodeVersionName();
    QMSettingSQLiteHelper localQMSettingSQLiteHelper = this.sqliteHelper;
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getWritableDatabase();
    if (paramBoolean) {}
    for (String str1 = "1";; str1 = "0")
    {
      localQMSettingSQLiteHelper.setValue(localSQLiteDatabase, str2, str1);
      return;
    }
  }
  
  public void setBonusTest(boolean paramBoolean)
  {
    String str2 = "bonus_test" + AppConfig.getCodeVersionName();
    QMSettingSQLiteHelper localQMSettingSQLiteHelper = this.sqliteHelper;
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getWritableDatabase();
    if (paramBoolean) {}
    for (String str1 = "1";; str1 = "0")
    {
      localQMSettingSQLiteHelper.setValue(localSQLiteDatabase, str2, str1);
      return;
    }
  }
  
  public void setBottleDisplay(boolean paramBoolean)
  {
    setBottleDisplay(paramBoolean, true);
  }
  
  public void setBottleEntry(int paramInt)
  {
    QMLog.log(4, "QMSettingManager", "setBottleEntry. entry:" + paramInt);
    if (paramInt == 2) {}
    for (boolean bool = true;; bool = false)
    {
      setBottleDisplay(bool, false);
      if ((bool) && (isBottleEnabled())) {
        Threads.runOnMainThread(new QMSettingManager.2(this));
      }
      return;
    }
  }
  
  public void setCalendarDisplay(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "show_calendar", paramBoolean + "");
    QMMailManager.sharedInstance().setCalendarDisplay(paramBoolean);
    CalendarWidgetManager.getInstance().notifyDataChange();
  }
  
  public void setCalendarNew(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "show_calendar_new", paramBoolean + "");
  }
  
  public void setCardBirthdayRemind(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "card_birthday_remind", paramBoolean + "");
  }
  
  public void setCardDisplay(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "show_card", paramBoolean + "");
  }
  
  public void setCharSet(int paramInt1, int paramInt2)
  {
    String str = "charset" + paramInt1;
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), paramInt1, str, String.valueOf(paramInt2), 7);
  }
  
  public void setComposeData(int paramInt, String paramString)
  {
    String str = "compose_data_prefix___" + paramInt;
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), str, paramString);
  }
  
  public void setContactDisplay(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "show_contact", paramBoolean + "");
  }
  
  public void setContactGroupCheckedAccountIds(String paramString)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "contact_group_checked_account_ids", paramString);
  }
  
  public void setContactSyncKey(int paramInt, MailContact.ContactType paramContactType, String paramString)
  {
    paramContactType = getContactSyncKeyPrefix(paramContactType) + paramInt;
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), paramContactType, paramString);
  }
  
  public void setDefaultBottleAccountID(int paramInt)
  {
    String str = this.sqliteHelper.getValue("default_bottle_account");
    if ((str == null) || ("".equals(str))) {}
    for (int i = 0;; i = Integer.parseInt(str))
    {
      setDefaultBottleAccountID(i, paramInt);
      return;
    }
  }
  
  public void setDefaultBottleAccountID(int paramInt1, int paramInt2)
  {
    Object localObject = paramInt2 + "";
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), paramInt2, "default_bottle_account", (String)localObject, -1);
    BottleManager.log("setDefaultBottleAccountID: newValue: " + (String)localObject + ", oldValue: " + paramInt1);
    int i;
    if ((paramInt2 == -1) && (paramInt1 == 0))
    {
      i = 1;
      if ((paramInt1 != paramInt2) && (i == 0))
      {
        QMLog.log(4, "QMSettingManager", "setPlpBindAccount: " + paramInt2);
        localObject = QMMailManager.sharedInstance();
        if (paramInt2 != -1) {
          break label162;
        }
      }
    }
    label162:
    for (paramInt1 = 0;; paramInt1 = paramInt2)
    {
      ((QMMailManager)localObject).setPlpBindAccount(paramInt1);
      Threads.runInBackground(new QMSettingManager.3(this, paramInt2), 30000L);
      return;
      i = 0;
      break;
    }
  }
  
  public void setDefaultFtnAccountID(int paramInt)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), paramInt, "default_ftn_account", paramInt + "", -1);
  }
  
  public void setDefaultMailAccountID(int paramInt)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), paramInt, "default_mail_account", paramInt + "", -1);
  }
  
  public void setDefaultNoteAccountID(int paramInt)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), paramInt, "default_note_account", paramInt + "", -1);
    QMNotification.postNotification("BROADCAST_WIDGET_ACCOUNT_CHANGE", null);
  }
  
  public void setDownloadPath(String paramString)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "download_path", paramString);
  }
  
  public void setEnableChromeDebug(boolean paramBoolean)
  {
    QMLog.log(4, "QMSettingManager", "setEnableChromeDebug:" + paramBoolean);
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "enable_chrome_debug_mode", paramBoolean + "");
  }
  
  public void setEnableDomainAppend(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "enable_domain_append", String.valueOf(paramBoolean));
  }
  
  public void setEnableGmailAuth(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "enable_gmail_auth", String.valueOf(paramBoolean));
  }
  
  public void setEnableJavaEasService(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "enable_java_eas_service", String.valueOf(paramBoolean));
  }
  
  public void setEnableJavaEwsService(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "enable_java_ews_service", String.valueOf(paramBoolean));
  }
  
  public void setEnableJavaImapIdle(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "enable_java_imap_idle", String.valueOf(paramBoolean));
    QMMailProtocolService.setIsEnableImapIdle(paramBoolean);
  }
  
  public void setEnableJavaImapService(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "enable_java_imap_service", String.valueOf(paramBoolean));
  }
  
  public void setEnableJavaPop3Service(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "enable_java_pop3_service", String.valueOf(paramBoolean));
  }
  
  public void setEnableJavaSmtpService(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "enable_java_smtp_service", String.valueOf(paramBoolean));
  }
  
  public void setEnableProtocolApiOsslog(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "enable_protocol_api_osslog", String.valueOf(paramBoolean));
  }
  
  public void setEnableQQBrowserX5(boolean paramBoolean)
  {
    QMLog.log(4, "QMSettingManager", "setEnableQQBrowserX5:" + paramBoolean);
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "enable_qq_browser_x5", paramBoolean + "");
  }
  
  public void setEnableSendMailSound(boolean paramBoolean)
  {
    QMSettingSQLiteHelper localQMSettingSQLiteHelper = this.sqliteHelper;
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getWritableDatabase();
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localQMSettingSQLiteHelper.setValue(localSQLiteDatabase, "send_mail_has_sound", str);
      return;
    }
  }
  
  public void setEnableSettingDomainConfig(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "enable_setting_domain_confg", String.valueOf(paramBoolean));
  }
  
  public void setEnableTranslate(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "enable_translation", paramBoolean + "");
  }
  
  public void setEnableUpgradeFts(boolean paramBoolean)
  {
    QMLog.log(4, "QMSettingManager", "setEnableUpgradeFts:" + paramBoolean);
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "enable_upgrade_fts_upgrade", paramBoolean + "");
  }
  
  public void setFirstTimeFromTim(boolean paramBoolean)
  {
    QMLog.log(4, "QMSettingManager", "setFirstTimeFromTim:" + paramBoolean);
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "first_time_from_tim", paramBoolean + "");
  }
  
  public void setFtnDisplay(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "show_ftn", paramBoolean + "");
  }
  
  public void setGmailWebViewUserAgent(String paramString)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "gmal_webview_ua", paramString);
  }
  
  public void setImapUserAgentId(String paramString)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "imap_ua_config", paramString);
  }
  
  public void setIncrementBadge(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "badge_increment_open", paramBoolean + "");
  }
  
  public void setInquiryMailAccountEdgeTime(int paramInt, long paramLong)
  {
    String str = "inquiry_mail_account_edge_time" + paramInt;
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), str, String.valueOf(paramLong));
  }
  
  public void setInquiryMailAccountHasMore(int paramInt1, int paramInt2)
  {
    String str = "inquiry_mail_account_has_more" + paramInt1;
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), str, String.valueOf(paramInt2));
  }
  
  public void setInquiryMailAccountPage(int paramInt1, int paramInt2)
  {
    String str = "inquiry_mail_account_page" + paramInt1;
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), str, String.valueOf(paramInt2));
  }
  
  public void setInquiryMailTipsInterval(long paramLong)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "inquiry_mail_tips_interval", String.valueOf(paramLong));
  }
  
  public void setInquiryMailTipsShow(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "inquiry_mail_tips_show", String.valueOf(paramBoolean));
  }
  
  public void setInquiryMailTipsTimes(int paramInt)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "inquiry_mail_tips_times", String.valueOf(paramInt));
  }
  
  public void setIsShowTranslateProtocolMailTips(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "show_translate_protocol_mail_tips", paramBoolean + "");
  }
  
  public void setLastDownloadDirPath(String paramString)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "last_download_dir_path", paramString);
  }
  
  public void setLastLoadBlackWhiteNameListTime(int paramInt, long paramLong)
  {
    String str = "last_load_name_list_time" + paramInt;
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), str, String.valueOf(paramLong));
  }
  
  public void setLastLoadContactTime(int paramInt)
  {
    String str = "LOAD_ACCOUNT_CONTACT_" + paramInt;
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), str, String.valueOf(System.currentTimeMillis()));
  }
  
  public void setLastMobileContactCount(int paramInt)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "mobile_contact_count", String.valueOf(paramInt));
  }
  
  public void setLastSSLErrorNotificationTime()
  {
    long l = new Date().getTime();
    QMLog.log(4, "QMSettingManager", "setLastSSLErrorNotificationTime:" + l);
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "last_ssl_error_notfication_utc", l + "");
  }
  
  public void setLastSync()
  {
    try
    {
      this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "last_sync", new Date().getTime() + "");
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      if (this.sqliteHelper == null) {
        throw new DevRuntimeException("sqliteHelper null", localNullPointerException);
      }
      if (this.sqliteHelper == null) {
        throw new DevRuntimeException("setting null", localNullPointerException);
      }
      if (this.sqliteHelper.getWritableDatabase() == null) {
        throw new DevRuntimeException("writabledb null", localNullPointerException);
      }
      if ("last_sync" == null) {
        throw new DevRuntimeException("key null", localNullPointerException);
      }
      throw localNullPointerException;
    }
  }
  
  public void setLastSyncAdRule()
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "last_sync_ad_rule", new Date().getTime() + "");
  }
  
  public void setLastUpdateGroupContactTime(int paramInt)
  {
    String str = "GROUP_MAIL_CONTACT_LAST_SYNC_TIME_" + paramInt;
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), str, String.valueOf(System.currentTimeMillis()));
  }
  
  public void setLastUpdateMobileContactTime()
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "import_contact_timestamp", String.valueOf(System.currentTimeMillis()));
  }
  
  public void setLastUploadDirPath(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "last_upload_dir_path_Sytesm";; str = "last_upload_dir_path_Sdcard")
    {
      this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), str, paramString);
      return;
    }
  }
  
  public void setLogAppStateLatestTime(long paramLong)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "log_app_state_time", String.valueOf(paramLong));
  }
  
  public void setMailListHeadClicked()
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "mail_list_head_click", "1");
  }
  
  public void setMailLoadImgType(int paramInt)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "mail_load_img_type", paramInt + "");
  }
  
  public void setMiscCheckLink(String paramString)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "misc_checklink_url", paramString);
  }
  
  public void setNameListContactHasLoad(int paramInt, boolean paramBoolean)
  {
    String str = "name_list_load_contact_" + paramInt;
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), str, paramBoolean + "");
  }
  
  public void setNameListSyncKey(int paramInt, String paramString)
  {
    String str = "name_list_sync_key_" + paramInt;
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), str, paramString);
  }
  
  public void setNewMailPush(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "new_mail_push", paramBoolean + "");
  }
  
  public void setNewMailPushSound(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "new_mail_sound", paramBoolean + "");
  }
  
  public void setNewMailPushVibrate(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "new_mail_viberate", paramBoolean + "");
  }
  
  public void setNewVersionRead(boolean paramBoolean)
  {
    String str2 = "aboud_new_version_read" + AppConfig.getCodeVersionName();
    QMSettingSQLiteHelper localQMSettingSQLiteHelper = this.sqliteHelper;
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getWritableDatabase();
    if (paramBoolean) {}
    for (String str1 = "1";; str1 = "0")
    {
      localQMSettingSQLiteHelper.setValue(localSQLiteDatabase, str2, str1);
      return;
    }
  }
  
  public void setNoteDefaultCat(int paramInt, String paramString)
  {
    String str = "note_default_cat__" + paramInt;
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), str, paramString);
  }
  
  public void setNoteDisplay(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "show_note", paramBoolean + "");
    QMNotification.postNotification("NOTE_LIST_UPDATE", null);
  }
  
  public void setNoteImgCompressRatio(int paramInt)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "note_img_compress_ratio", paramInt + "");
  }
  
  public void setNoteSortType(int paramInt, String paramString)
  {
    String str = "note_sort_type__" + paramInt;
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), str, paramString);
  }
  
  public void setNotificationShortCutEnable(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "notification_shortcut_enable", paramBoolean + "");
  }
  
  public void setNotifyAccountMail(int paramInt, boolean paramBoolean)
  {
    String str = "account_new_mail_push_suffix_" + paramInt;
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), paramInt, str, paramBoolean + "", 3);
  }
  
  public void setOnlyNotifyVIP(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "mail_push_important_contact", paramBoolean + "");
  }
  
  public void setOnlyPushMailApp(int paramInt, boolean paramBoolean)
  {
    String str2 = "onlypushmailapp__" + paramInt;
    QMSettingSQLiteHelper localQMSettingSQLiteHelper = this.sqliteHelper;
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getWritableDatabase();
    if (paramBoolean) {}
    for (String str1 = "1";; str1 = "0")
    {
      localQMSettingSQLiteHelper.setValue(localSQLiteDatabase, paramInt, str2, str1, -1);
      return;
    }
  }
  
  public void setOutDomainPwdReport(boolean paramBoolean)
  {
    QMSettingSQLiteHelper localQMSettingSQLiteHelper = this.sqliteHelper;
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getWritableDatabase();
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localQMSettingSQLiteHelper.setValue(localSQLiteDatabase, "out_domain_pwd_report", str);
      return;
    }
  }
  
  public void setPopFolderGuideAdd(int paramInt1, int paramInt2)
  {
    String str = "pop_folder_guide_" + paramInt1 + "_" + paramInt2;
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), paramInt1, str, "1", -1);
  }
  
  public void setPullDownPopularizeURL(String paramString)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "pull_down_popularize_url", paramString);
  }
  
  public void setPushInboxOnly(int paramInt, boolean paramBoolean)
  {
    String str = "push_account_inbox_only_suffix_" + paramInt;
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), paramInt, str, paramBoolean + "", 4);
  }
  
  public void setQQAccountPswLength(int paramInt1, int paramInt2)
  {
    String str = "qq_psw_len_" + paramInt1;
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), paramInt1, str, String.valueOf(paramInt2), -1);
  }
  
  public void setQuickCalendarSync(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "quick_calendar_sync", String.valueOf(paramBoolean));
  }
  
  public void setRemindSecApp()
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "remind_secapp", "1");
  }
  
  public void setReplyForwardSubjectType(int paramInt)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "reply_forward_subject_type", paramInt + "");
  }
  
  public void setReplyWithOriginType(int paramInt)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "reply_with_origin_type", paramInt + "");
  }
  
  public void setSSLErrorTime(long paramLong)
  {
    QMLog.log(5, "QMSettingManager", "Warning!! setSSLErrorTime");
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "ssl_error_time", String.valueOf(paramLong));
  }
  
  public void setSearchDefaultType(int paramInt)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "search_default_type", paramInt + "");
  }
  
  public void setSearchExchangeAddress(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = "SEARCH_EXCHANGE_ADDR_" + paramInt + "_" + paramString1;
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), paramString1, paramString2);
  }
  
  public void setShowGmailBackground(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "gmail_show_background", paramBoolean + "");
  }
  
  public void setShowMailDetail(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "show_push_mail_detail", paramBoolean + "");
  }
  
  public void setShowMailListAvatar(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "show_maillist_head_icon", paramBoolean + "");
  }
  
  public void setShowSplashList(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "show_splash_list", paramBoolean + "");
  }
  
  public void setShownWelcomePages(boolean paramBoolean)
  {
    String str2 = "shown_welcome_" + AppConfig.getMajorVersion(QMApplicationContext.sharedInstance());
    QMSettingSQLiteHelper localQMSettingSQLiteHelper = this.sqliteHelper;
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getWritableDatabase();
    if (paramBoolean) {}
    for (String str1 = "1";; str1 = "0")
    {
      localQMSettingSQLiteHelper.setValue(localSQLiteDatabase, str2, str1);
      return;
    }
  }
  
  public void setShutdownBefore(boolean paramBoolean)
  {
    QMSettingSQLiteHelper localQMSettingSQLiteHelper = this.sqliteHelper;
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getWritableDatabase();
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localQMSettingSQLiteHelper.setValue(localSQLiteDatabase, "shutdown_before", str);
      return;
    }
  }
  
  public void setSoundTypeKeyMan(String paramString, boolean paramBoolean)
  {
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getWritableDatabase();
    this.sqliteHelper.setValue(localSQLiteDatabase, "mail_voice_key_man_string", paramString);
    QMSettingSQLiteHelper localQMSettingSQLiteHelper = this.sqliteHelper;
    if (paramBoolean) {}
    for (paramString = "1";; paramString = "0")
    {
      localQMSettingSQLiteHelper.setValue(localSQLiteDatabase, "mail_voice_key_man_from", paramString);
      return;
    }
  }
  
  public void setSoundTypeNewMail(String paramString, boolean paramBoolean)
  {
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getWritableDatabase();
    this.sqliteHelper.setValue(localSQLiteDatabase, "mail_voice_new_mail_string", paramString);
    QMSettingSQLiteHelper localQMSettingSQLiteHelper = this.sqliteHelper;
    if (paramBoolean) {}
    for (paramString = "1";; paramString = "0")
    {
      localQMSettingSQLiteHelper.setValue(localSQLiteDatabase, "mail_voice_new_mail_from", paramString);
      return;
    }
  }
  
  public void setStarAttachDisplay(int paramInt)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "show_starattach", String.valueOf(paramInt));
  }
  
  public void setStarAttachRemoteCount(int paramInt1, int paramInt2)
  {
    String str = "starattach_remote_count_" + paramInt1;
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), str, String.valueOf(paramInt2));
  }
  
  public void setSysConfig(String paramString)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "sys_config", paramString);
  }
  
  public void setTelphonePromotionRedPoint(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "show_tel_promotion_redpoint", paramBoolean + "");
  }
  
  public void setTimeZoneLastWaken(long paramLong)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "time_zone_last_waken", String.valueOf(paramLong));
  }
  
  public void setTranslatePromotionBubble(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "show_translation_promotion_bubble", paramBoolean + "");
  }
  
  public void setUpdateConfigLatestTime(long paramLong)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "update_config_time", String.valueOf(paramLong));
  }
  
  public void setUpgradeFromOldApp()
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "upgrade_from_old_app", "1");
  }
  
  public void setUseNightMode(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), "push_night_mode", paramBoolean + "");
  }
  
  public void setVidWiped(long paramLong)
  {
    String str = "vid_wiped_" + paramLong;
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), str, "1");
  }
  
  public void setWipeActiveSync(int paramInt, boolean paramBoolean)
  {
    String str = "wipe_app_as_suffix" + paramInt;
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), paramInt, str, paramBoolean + "", 5);
  }
  
  public void setWipeAll(boolean paramBoolean)
  {
    this.sqliteHelper.setValue(this.sqliteHelper.getWritableDatabase(), -1, "wipe_app_all", paramBoolean + "", 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMSettingManager
 * JD-Core Version:    0.7.0.1
 */