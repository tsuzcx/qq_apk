package com.tencent.qqmail;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.log.AddAccountLocalLogUtil;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.attachment.model.QMSpreadAPPInfo;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.model.cache.SettingItem;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.network.filter.BackOffFilter;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.model.PopularizeAppConfig;
import com.tencent.qqmail.popularize.model.PopularizeSubItem;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.fileextention.FileDefine;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceManager;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import moai.oss.OssHelper;

public class QMAPPUpgradeManager
{
  private static final String LAST_VERSION = "lastVersion";
  private static final int MIN_VERSION = 0;
  public static final String TAG = "QMAppUpgradeManager";
  private static QMAPPUpgradeManager instance = new QMAPPUpgradeManager();
  private final int VERSION = getDigitalVersion();
  private String lastVersion = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getString("lastVersion", null);
  private SparseArray<QMAPPUpgrade> versions = new SparseArray();
  
  private QMAPPUpgradeManager()
  {
    addVersions();
  }
  
  private int addOldAppAccount(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, boolean paramBoolean)
  {
    paramString7 = new QQMailAccount();
    int j = Account.generateId(paramString3);
    paramString7.setEmail(paramString1);
    paramString7.setId(j);
    paramString7.setUin(String.valueOf(paramString3));
    paramString7.setName(paramString4);
    paramString7.setPwd(paramString5);
    paramString7.setEncryptedFolderPwd(paramString8);
    int i;
    if (paramBoolean)
    {
      i = 2;
      paramString7.setProtocol(i);
      paramString7.setEncryptedUin(paramString6);
      paramString7.setSmtpUserName("");
      paramString7.setSmtppwd("");
      paramString7.setProfileString("");
      AccountManager.shareInstance().saveAccount(paramString7);
      paramString4 = paramString7.getProfile();
      if (paramString1.split("@").length < 2) {
        break label305;
      }
    }
    label305:
    for (paramString2 = paramString1.split("@")[1];; paramString2 = "qq.com")
    {
      QMLog.log(4, "QMAppUpgradeManager", "appup. add acc. " + paramString2 + "," + paramString1 + "," + paramString5 + "," + Account.generateId(paramString3));
      if (SharedPreferenceUtil.isWtlogin()) {
        SharedPreferenceUtil.setWtlogin(false);
      }
      QMPrivateProtocolManager.sharedInstance().addAccount(paramString4, paramString2, paramString1, StringExtention.encodeURI(Aes.encode(paramString5, Aes.getServerKey())), paramString7.getId(), null, null, true, paramBoolean);
      QMSettingManager.sharedInstance().setQQAccountPswLength(paramString7.getId(), 7);
      QMSettingManager.sharedInstance().setDefaultNoteAccountID(paramString7.getId());
      QMSettingManager.sharedInstance().setDefaultFtnAccountID(paramString7.getId());
      upgradeSignature(paramString7.getId(), paramString7.getEmail());
      Threads.runInBackground(new QMAPPUpgradeManager.9(this, paramString7));
      return j;
      i = 1;
      break;
    }
  }
  
  private void addVersion(QMAPPUpgrade paramQMAPPUpgrade)
  {
    this.versions.put(paramQMAPPUpgrade.getVersion(), paramQMAPPUpgrade);
  }
  
  private void addVersions()
  {
    addVersion(new QMAPPUpgradeManager.1(this, this));
    addVersion(new QMAPPUpgradeManager.2(this, this));
    addVersion(new QMAPPUpgradeManager.3(this, this));
    addVersion(new QMAPPUpgradeManager.4(this, this));
    addVersion(new QMAPPUpgradeManager.5(this, this));
    addVersion(new QMAPPUpgradeManager.6(this, this));
    addVersion(new QMAPPUpgradeManager.7(this, this));
    addVersion(new QMAPPUpgradeManager.8(this, this));
  }
  
  private int getDigitalVersion()
  {
    int i = 0;
    String[] arrayOfString = AppConfig.getCodeVersionName().split("\\.");
    if (arrayOfString.length >= 3) {
      i = Integer.parseInt(arrayOfString[0]) * 1000 + Integer.parseInt(arrayOfString[1]) * 100 + Integer.parseInt(arrayOfString[2]) * 10;
    }
    return i;
  }
  
  public static QMAPPUpgradeManager getInstance()
  {
    return instance;
  }
  
  private void handleAppUpdateAccount()
  {
    upgradeAccount();
    int i = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getInt("COMPRESS_LEVEL_", 3);
    QMSettingManager.sharedInstance().setNoteImgCompressRatio(i);
    QMLog.log(4, "QMAppUpgradeManager", "handleAppUpdateAccount end.");
  }
  
  private void mergeMailPopularizeToPopularizeDB()
  {
    ArrayList localArrayList;
    Cursor localCursor;
    for (;;)
    {
      try
      {
        QMMailSQLiteHelper localQMMailSQLiteHelper = QMMailManager.sharedInstance().getSqliteHelper();
        SQLiteDatabase localSQLiteDatabase2 = localQMMailSQLiteHelper.getReadableDatabase();
        localArrayList = new ArrayList();
        localCursor = localSQLiteDatabase2.rawQuery("SELECT * FROM QM_POPULARIZE", null);
        if (localCursor == null) {
          break label1391;
        }
        if (!localCursor.moveToNext()) {
          break;
        }
        Popularize localPopularize = new Popularize();
        localPopularize.setId(localCursor.getInt(localCursor.getColumnIndex("id")));
        localPopularize.setServerId(localCursor.getInt(localCursor.getColumnIndex("serverId")));
        int i = localCursor.getColumnIndex("reportId");
        if (i != -1) {
          localPopularize.setReportId(localCursor.getInt(i));
        }
        localPopularize.setType(localCursor.getInt(localCursor.getColumnIndex("type")));
        localPopularize.setPage(localCursor.getInt(localCursor.getColumnIndex("page")));
        localPopularize.setBannerPosition(localCursor.getInt(localCursor.getColumnIndex("bannerPosition")));
        localPopularize.setBannerHeight(localCursor.getInt(localCursor.getColumnIndex("bannerHeight")));
        localPopularize.setShowType(localCursor.getInt(localCursor.getColumnIndex("showType")));
        localPopularize.setAction(localCursor.getInt(localCursor.getColumnIndex("action")));
        localPopularize.setImageUrl(localCursor.getString(localCursor.getColumnIndex("imageUrl")));
        localPopularize.setImageMd5(localCursor.getString(localCursor.getColumnIndex("imageMd5")));
        localPopularize.setOpenUrl(localCursor.getString(localCursor.getColumnIndex("openUrl")));
        localPopularize.setStartTime(localCursor.getLong(localCursor.getColumnIndex("startTime")));
        localPopularize.setEndTime(localCursor.getLong(localCursor.getColumnIndex("endTime")));
        localPopularize.setDuration(localCursor.getLong(localCursor.getColumnIndex("duration")));
        localPopularize.setSubject(localCursor.getString(localCursor.getColumnIndex("subject")));
        localPopularize.setAbstracts(localCursor.getString(localCursor.getColumnIndex("abstracts")));
        localPopularize.setContent(localCursor.getString(localCursor.getColumnIndex("content")));
        localPopularize.setSubInformation(localCursor.getString(localCursor.getColumnIndex("subInformation")));
        localPopularize.setSubInformationData(localCursor.getString(localCursor.getColumnIndex("subInformationData")));
        localPopularize.setSubImageUrl(localCursor.getString(localCursor.getColumnIndex("subImageUrl")));
        localPopularize.setSubImageMd5(localCursor.getString(localCursor.getColumnIndex("subImageMd5")));
        if (localCursor.getInt(localCursor.getColumnIndex("needQQAccount")) == 1)
        {
          bool = true;
          localPopularize.setNeedQQAccount(bool);
          if (localCursor.getInt(localCursor.getColumnIndex("isRender")) != 1) {
            break label1334;
          }
          bool = true;
          localPopularize.setRender(bool);
          if (localCursor.getInt(localCursor.getColumnIndex("isClick")) != 1) {
            break label1339;
          }
          bool = true;
          localPopularize.setClick(bool);
          if (localCursor.getInt(localCursor.getColumnIndex("isCancel")) != 1) {
            break label1344;
          }
          bool = true;
          localPopularize.setCancel(bool);
          localPopularize.setPopularizeAppName(localCursor.getString(localCursor.getColumnIndex("popularizeAppName")));
          i = localCursor.getColumnIndex("popularizeAppVersion");
          if (i != -1) {
            localPopularize.setPopularizeAppVersion(localCursor.getString(i));
          }
          localPopularize.setAppInstallAction(localCursor.getInt(localCursor.getColumnIndex("appInstallAction")));
          localPopularize.setWeight(localCursor.getInt(localCursor.getColumnIndex("weight")));
          localPopularize.setLastRenderTime(localCursor.getLong(localCursor.getColumnIndex("lastRenderTime")));
          localPopularize.setSubItems(querySubItem(localSQLiteDatabase2, localPopularize.getId(), false));
          localPopularize.setCondition(localCursor.getInt(localCursor.getColumnIndex("condition")));
          localPopularize.setRelatedId(localCursor.getInt(localCursor.getColumnIndex("relatedId")));
          i = localCursor.getColumnIndex("move");
          if (i != -1) {
            localPopularize.setMove(localCursor.getInt(i));
          }
          i = localCursor.getColumnIndex("isOpen");
          if (i != -1)
          {
            if (localCursor.getInt(i) != 1) {
              break label1349;
            }
            bool = true;
            localPopularize.setIsOpen(bool);
          }
          i = localCursor.getColumnIndex("resourceType");
          if (i != -1) {
            localPopularize.setResourceType(localCursor.getInt(i));
          }
          i = localCursor.getColumnIndex("commercialFromEmail");
          if (i != -1) {
            localPopularize.setCommercialFromEmail(localCursor.getString(i));
          }
          i = localCursor.getColumnIndex("commercialFromNick");
          if (i != -1) {
            localPopularize.setCommercialFromNick(localCursor.getString(i));
          }
          i = localCursor.getColumnIndex("commercialConfigHead");
          if (i != -1)
          {
            if (localCursor.getInt(i) != 1) {
              break label1354;
            }
            bool = true;
            localPopularize.setCommercialConfigHead(bool);
          }
          i = localCursor.getColumnIndex("commercialConfigTool");
          if (i != -1)
          {
            if (localCursor.getInt(i) != 1) {
              break label1359;
            }
            bool = true;
            localPopularize.setCommercialConfigTool(bool);
          }
          i = localCursor.getColumnIndex("commercialConfigList");
          if (i != -1)
          {
            if (localCursor.getInt(i) != 1) {
              break label1364;
            }
            bool = true;
            localPopularize.setCommercialConfigList(bool);
          }
          i = localCursor.getColumnIndex("commercialConfigMark");
          if (i != -1)
          {
            if (localCursor.getInt(i) != 1) {
              break label1369;
            }
            bool = true;
            localPopularize.setCommercialConfigMark(bool);
          }
          i = localCursor.getColumnIndex("isRead");
          if (i != -1)
          {
            if (localCursor.getInt(i) != 1) {
              break label1374;
            }
            bool = true;
            localPopularize.setIsRead(bool);
          }
          i = localCursor.getColumnIndex("sessionType");
          if (i != -1) {
            localPopularize.setSessionType(localCursor.getInt(i));
          }
          i = localCursor.getColumnIndex("needWifi");
          if (i != -1)
          {
            if (localCursor.getInt(i) != 1) {
              break label1379;
            }
            bool = true;
            localPopularize.setNeedWifi(bool);
          }
          PopularizeAppConfig localPopularizeAppConfig = new PopularizeAppConfig();
          i = localCursor.getColumnIndex("priority");
          if (i != -1) {
            localPopularizeAppConfig.setPriority(localCursor.getInt(i));
          }
          localPopularizeAppConfig.setSubitems(querySubItem(localSQLiteDatabase2, localPopularize.getId(), true));
          localPopularize.setAppConfig(localPopularizeAppConfig);
          localArrayList.add(localPopularize);
          continue;
        }
        bool = false;
      }
      catch (Exception localException)
      {
        QMLog.log(6, "QMAppUpgradeManager", Log.getStackTraceString(localException));
        return;
      }
      continue;
      label1334:
      boolean bool = false;
      continue;
      label1339:
      bool = false;
      continue;
      label1344:
      bool = false;
      continue;
      label1349:
      bool = false;
      continue;
      label1354:
      bool = false;
      continue;
      label1359:
      bool = false;
      continue;
      label1364:
      bool = false;
      continue;
      label1369:
      bool = false;
      continue;
      label1374:
      bool = false;
      continue;
      label1379:
      bool = false;
    }
    localCursor.close();
    label1391:
    PopularizeManager.sharedInstance().insertPopularize(localArrayList);
    QMLog.log(4, "QMAppUpgradeManager", "upgrade mergeMailPopularizeToPopularizeDB popularizes size:" + localArrayList.size());
    SQLiteDatabase localSQLiteDatabase1 = localException.getWritableDatabase();
    localSQLiteDatabase1.execSQL("DROP TABLE IF EXISTS QM_POPULARIZE");
    localSQLiteDatabase1.execSQL("DROP TABLE IF EXISTS QM_POPULARIZE_SUBITEM");
    QMLog.log(4, "QMAppUpgradeManager", "upgrade mergeMailPopularizeToPopularizeDB drop table");
  }
  
  private void mergeMailSettingToSettingDB()
  {
    Object localObject2;
    try
    {
      QMMailSQLiteHelper localQMMailSQLiteHelper = QMMailManager.sharedInstance().getSqliteHelper();
      localObject2 = localQMMailSQLiteHelper.getReadableDatabase();
      localObject1 = new ArrayList();
      localObject2 = ((SQLiteDatabase)localObject2).rawQuery("SELECT * FROM QM_SETTING", null);
      if (localObject2 != null)
      {
        while (((Cursor)localObject2).moveToNext()) {
          ((ArrayList)localObject1).add(new SettingItem(((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex("id")), ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex("val")), Integer.parseInt(((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex("accountid"))), Integer.parseInt(((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex("type")))));
        }
        ((Cursor)localObject2).close();
      }
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMAppUpgradeManager", Log.getStackTraceString(localException));
      return;
    }
    QMSettingManager.sharedInstance().insertItem((ArrayList)localObject1);
    QMSettingManager.sharedInstance().initData();
    QMLog.log(4, "QMAppUpgradeManager", "upgrade mergeMailSettingToSettingDB item size:" + ((ArrayList)localObject1).size());
    QMMailManager.sharedInstance().setAdAggregate(QMSettingManager.sharedInstance().getAggregateAdMail());
    QMMailManager.sharedInstance().setSubscribeAggregate(QMSettingManager.sharedInstance().getAggregateSubscribeMail());
    Object localObject1 = AccountManager.shareInstance().getAccountList().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Account)((Iterator)localObject1).next();
      QMMailManager.sharedInstance().setSubjectAggregate(((Account)localObject2).getId(), QMSettingManager.sharedInstance().getAggregateSubject(((Account)localObject2).getId()));
    }
    localException.getWritableDatabase().execSQL("DROP TABLE IF EXISTS QM_SETTING");
    QMLog.log(4, "QMAppUpgradeManager", "upgrade mergeMailSettingToSettingDB drop table");
  }
  
  private void saveNewVersion()
  {
    String str = AppConfig.getCodeVersionName();
    saveAppNewVersion(this.lastVersion, str);
    QMLog.log(4, "QMAppUpgradeManager", "appupgrade. saveAppNewVersion:" + this.lastVersion + ", " + str);
  }
  
  private void setHasForeignAccount()
  {
    Object localObject = AccountManager.shareInstance().getAccountList();
    if (((AccountList)localObject).size() == 0) {
      QMSharedPreferenceManager.getInstance().setHasForeignAccount(false);
    }
    for (;;)
    {
      return;
      localObject = ((AccountList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!((Account)((Iterator)localObject).next()).isQQMail()) {
          QMSharedPreferenceManager.getInstance().setHasForeignAccount(true);
        }
      }
      for (int i = 1; i == 0; i = 0)
      {
        QMSharedPreferenceManager.getInstance().setHasForeignAccount(false);
        return;
      }
    }
  }
  
  private int[] sortVersions()
  {
    int[] arrayOfInt = new int[this.versions.size()];
    int i = 0;
    while (i < this.versions.size())
    {
      arrayOfInt[i] = this.versions.keyAt(i);
      i += 1;
    }
    Arrays.sort(arrayOfInt);
    return arrayOfInt;
  }
  
  private void tryAlignAccountAfterUpgrade(boolean paramBoolean)
  {
    if (QMApplicationContext.sharedInstance().getVid() != 0L)
    {
      QMLog.log(4, "QMAppUpgradeManager", "tryAlignAccountAfterUpgrade vid exists. go align account");
      BackOffFilter.resetError(QMMath.hashInt("tryAlignAccountAfterUpgrade"));
      QMPrivateProtocolManager.sharedInstance().alignAccount();
      QMSettingManager.sharedInstance().setAlignAccountLatestTime(new Date().getTime());
      return;
    }
    long l = BackOffFilter.whenToRetryOrAbort(QMMath.hashInt("tryAlignAccountAfterUpgrade"), paramBoolean) * 1000L;
    if (l == 0L)
    {
      QMLog.log(4, "QMAppUpgradeManager", "tryAlignAccountAfterUpgrade go align");
      tryAlignAccountAfterUpgrade(true);
      return;
    }
    if (l > 0L)
    {
      QMLog.log(4, "QMAppUpgradeManager", "tryAlignAccountAfterUpgrade wait for " + l);
      Threads.runInBackground(new QMAPPUpgradeManager.10(this), l);
      return;
    }
    QMLog.log(4, "QMAppUpgradeManager", "tryAlignAccountAfterUpgrade wait so long. do not try again");
  }
  
  private boolean upgrade(int paramInt)
  {
    int[] arrayOfInt = sortVersions();
    int i = 0;
    boolean bool1 = false;
    if (i < arrayOfInt.length)
    {
      QMAPPUpgrade localQMAPPUpgrade = (QMAPPUpgrade)this.versions.get(arrayOfInt[i]);
      bool2 = bool1;
      if (arrayOfInt[i] > paramInt)
      {
        bool2 = bool1;
        if (arrayOfInt[i] <= getVersion()) {
          if (i <= 0) {
            break label92;
          }
        }
      }
      for (int j = arrayOfInt[(i - 1)];; j = paramInt) {
        try
        {
          localQMAPPUpgrade.onUpgrade(j);
          bool2 = true;
          i += 1;
          bool1 = bool2;
        }
        catch (Exception localException)
        {
          label92:
          localStringBuilder = new StringBuilder().append("failed execute upgrade from ");
          if (i <= 0) {
            break label171;
          }
        }
      }
      StringBuilder localStringBuilder;
      label171:
      for (j = arrayOfInt[(i - 1)];; j = paramInt)
      {
        QMLog.log(5, "APP", j + " to " + arrayOfInt[i] + ": " + localException.getMessage());
        break;
      }
    }
    i = getDigitalVersion();
    boolean bool2 = bool1;
    if (i != 0)
    {
      bool2 = bool1;
      if (i > paramInt) {
        bool2 = true;
      }
    }
    if (bool2)
    {
      QMLog.log(4, "QMAppUpgradeManager", "upgrade from " + paramInt + " to " + i);
      saveNewVersion();
      QMSpreadAPPInfo.resetSpreadCount();
      QMPrivateProtocolManager.sharedInstance().clearPopularizeAndMiscConfigVersion();
      QMPrivateProtocolManager.sharedInstance().umaLogin(null);
      if (AppConfig.isBeta()) {
        OssHelper.activeVid(new Object[] { "upgrade" });
      }
    }
    return bool2;
  }
  
  private void upgradeAccount()
  {
    Object localObject5 = null;
    String str = null;
    Object localObject4 = "";
    Object localObject6 = QMApplicationContext.sharedInstance().getSharedPreferences("user", 0);
    QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit().putBoolean("app_up_is_pushmode_set", false).commit();
    Object localObject1 = ((SharedPreferences)localObject6).getString("curaccnt", "");
    if ((localObject1 == null) || (((String)localObject1).equals(""))) {
      return;
    }
    String[] arrayOfString;
    Object localObject3;
    Object localObject2;
    label142:
    boolean bool;
    if ((localObject1 != null) && (((String)localObject1).length() > 0))
    {
      arrayOfString = Aes.decode((String)localObject1, Aes.getIMEIKey()).split(";", -1);
      if (arrayOfString.length == 5)
      {
        localObject3 = arrayOfString[1];
        if (arrayOfString[2].length() == 0)
        {
          localObject1 = null;
          if (arrayOfString[3].length() != 0) {
            break label431;
          }
          localObject2 = null;
          bool = "1".equals(arrayOfString[4]);
          QMLog.log(4, "QMAppUpgradeManager", "currentEmail : " + (String)localObject3 + ", currentUin : " + (String)localObject1 + ", currentEncryptedUin : " + (String)localObject2 + ", currentIsBiz : " + bool);
          localObject4 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject1;
        }
      }
    }
    for (;;)
    {
      QMSettingManager.sharedInstance().setAppUpgradeMasterUin((String)localObject3);
      localObject1 = ((SharedPreferences)localObject6).getString("autosf", "");
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        localObject6 = Aes.decode((String)localObject1, Aes.getIMEIKey()).split(";", -1);
        if (localObject6.length == 4) {
          if (localObject6[1].length() == 0)
          {
            localObject5 = null;
            label287:
            if (localObject6[2].length() != 0) {
              break label448;
            }
            localObject1 = str;
            label300:
            str = localObject6[3];
            QMLog.log(4, "QMAppUpgradeManager", "autologinEmail : " + (String)localObject5 + ", autologinUin : " + (String)localObject1 + ", autologinPwd : " + str);
          }
        }
      }
      for (localObject5 = str;; localObject5 = str)
      {
        if (localObject1 == null) {
          break label474;
        }
        if ((localObject2 != null) && (((String)localObject2).split("@").length > 1)) {}
        for (str = localObject2.split("@")[0];; str = "")
        {
          if (((String)localObject1).equals(localObject3)) {
            addOldAppAccount((String)localObject2, (String)localObject1, (String)localObject3, str, (String)localObject5, (String)localObject4, "", "", bool);
          }
          QMSettingManager.sharedInstance().setUpgradeFromOldApp();
          return;
          localObject1 = arrayOfString[2];
          break;
          label431:
          localObject2 = arrayOfString[3];
          break label142;
          localObject5 = localObject6[1];
          break label287;
          label448:
          localObject1 = localObject6[2];
          break label300;
        }
        str = null;
        localObject1 = localObject5;
      }
      label474:
      break;
      localObject3 = null;
      localObject2 = null;
      bool = false;
    }
  }
  
  private void upgradeAccountCheck()
  {
    if (SharedPreferenceUtil.needUpgradeAccountFromVersion2())
    {
      QMLog.log(4, "QMAppUpgradeManager", "mason check need upgrade");
      Object localObject = new File(FileDefine.INNER_DATA_DIR + "/databases/");
      if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
      {
        localObject = ((File)localObject).list();
        if ((localObject != null) && (localObject.length >= 1))
        {
          int i = 0;
          while (i < localObject.length)
          {
            if ((localObject[i].startsWith("QMDatabase")) || (localObject[i].startsWith("QMFtnDB")) || (localObject[i].startsWith("QMNoteDB"))) {
              QMApplicationContext.sharedInstance().deleteDatabase(localObject[i]);
            }
            i += 1;
          }
        }
      }
      handleAppUpdateAccount();
    }
  }
  
  private void upgradeSignature(int paramInt, String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return;
    }
    String str = QMApplicationContext.sharedInstance().getSharedPreferences("qqmail_preference", 0).getString(paramString, "");
    QMSettingManager.sharedInstance().setAccountSignature(paramInt, str);
    QMLog.log(4, "QMAppUpgradeManager", "upgradeSignature email:" + paramString + " sig:" + str);
  }
  
  public String getLastVersion()
  {
    return this.lastVersion;
  }
  
  public int getMinVersion()
  {
    return 0;
  }
  
  public int getVersion()
  {
    return this.VERSION;
  }
  
  public boolean isUpgrade()
  {
    return (this.lastVersion != null) && (!this.lastVersion.equals(AppConfig.getCodeVersionName()));
  }
  
  public ArrayList<PopularizeSubItem> querySubItem(SQLiteDatabase paramSQLiteDatabase, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    if (paramBoolean) {
      i = 1;
    }
    for (;;)
    {
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_POPULARIZE_SUBITEM WHERE isRelated=? AND popularizeId=?", new String[] { String.valueOf(i), String.valueOf(paramInt) });
        if (paramSQLiteDatabase != null)
        {
          if (!paramSQLiteDatabase.moveToNext()) {
            break;
          }
          PopularizeSubItem localPopularizeSubItem = new PopularizeSubItem();
          localPopularizeSubItem.setId(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("id")));
          localPopularizeSubItem.setServerId(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("serverId")));
          localPopularizeSubItem.setPopularizeId(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("popularizeId")));
          localPopularizeSubItem.setText(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("text")));
          localPopularizeSubItem.setImageUrl(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("imageUrl")));
          localPopularizeSubItem.setImageMd5(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("imageMd5")));
          localPopularizeSubItem.setPosition(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("position")));
          localPopularizeSubItem.setSequence(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("sequence")));
          localPopularizeSubItem.setShowType(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("showType")));
          localPopularizeSubItem.setCondition(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("condition")));
          localPopularizeSubItem.setAction(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("action")));
          localPopularizeSubItem.setOpenUrl(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("openUrl")));
          localPopularizeSubItem.setBottomRatio(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("bottomRadio")));
          localPopularizeSubItem.setLastRenderTime(paramSQLiteDatabase.getLong(paramSQLiteDatabase.getColumnIndex("lastRenderTime")));
          if (paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("isRender")) == 0) {
            break label502;
          }
          bool = true;
          localPopularizeSubItem.setIsRender(bool);
          if (paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("isCancel")) == 0) {
            break label508;
          }
          bool = true;
          localPopularizeSubItem.setIsCancel(bool);
          if (paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("isClick")) == 0) {
            break label514;
          }
          bool = true;
          localPopularizeSubItem.setIsClick(bool);
          paramInt = paramSQLiteDatabase.getColumnIndex("isClickMyApp");
          if (paramInt != -1)
          {
            if (paramSQLiteDatabase.getInt(paramInt) == 0) {
              break label520;
            }
            bool = true;
            localPopularizeSubItem.setIsClickMyApp(bool);
          }
          localPopularizeSubItem.setIsRelated(paramBoolean);
          localArrayList.add(localPopularizeSubItem);
          continue;
        }
        return localArrayList;
      }
      catch (Exception paramSQLiteDatabase)
      {
        QMLog.log(6, "QMAppUpgradeManager", paramSQLiteDatabase.getMessage());
      }
      i = 0;
      continue;
      label502:
      boolean bool = false;
      continue;
      label508:
      bool = false;
      continue;
      label514:
      bool = false;
      continue;
      label520:
      bool = false;
    }
    paramSQLiteDatabase.close();
    return localArrayList;
  }
  
  public void saveAppNewVersion(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder;
    if ((paramString2 != null) && (!paramString2.equals(paramString1)))
    {
      localStringBuilder = new StringBuilder().append("version. last:");
      if (paramString1 == null) {
        break label112;
      }
      str = paramString1;
      localStringBuilder = localStringBuilder.append(str).append(", now:");
      if (paramString2 == null) {
        break label118;
      }
    }
    label112:
    label118:
    for (String str = paramString2;; str = "")
    {
      AddAccountLocalLogUtil.timeLineAccountChange("OTHER", str);
      if ((paramString2 != null) && (!paramString2.equals(paramString1)))
      {
        paramString1 = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).edit();
        paramString1.putString("lastVersion", paramString2);
        paramString1.apply();
      }
      return;
      str = "";
      break;
    }
  }
  
  public void upgradeAPP()
  {
    Object localObject1 = null;
    QMLog.log(4, "QMAppUpgradeManager", "upgrade app if needed.");
    Object localObject2 = QMApplicationContext.sharedInstance().getSharedPreferences("qqmail_preference", 0);
    if ((localObject2 != null) && (((SharedPreferences)localObject2).getString("newVersion", null) != null)) {
      QMLog.log(4, "QMAppUpgradeManager", "from version two");
    }
    for (int i = 1;; i = 0)
    {
      localObject2 = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0);
      if (localObject2 != null) {
        localObject1 = ((SharedPreferences)localObject2).getString("lastVersion", null);
      }
      int j;
      if (localObject1 != null)
      {
        localObject2 = ((String)localObject1).split("\\.");
        if (localObject2.length >= 3)
        {
          i = Integer.parseInt(localObject2[0]) * 1000 + Integer.parseInt(localObject2[1]) * 100 + Integer.parseInt(localObject2[2]) * 10;
          j = 0;
          QMLog.log(4, "QMAppUpgradeManager", "upgradeAPP. lastVersion:" + (String)localObject1 + ", oldVersion:" + i);
          if (j == 0) {
            break label269;
          }
          upgradeAccountCheck();
          upgrade(3000);
        }
      }
      for (;;)
      {
        localObject1 = AccountManager.shareInstance().getAccountList();
        if ((((AccountList)localObject1).getDefaultMailAccount() == null) && (localObject1 != null) && (((AccountList)localObject1).size() > 0)) {
          AccountManager.shareInstance().setDefaultMailAccount(((AccountList)localObject1).get(0).getId());
        }
        return;
        localObject1 = "3.0.0";
        j = i;
        i = 3000;
        break;
        if (i != 0)
        {
          localObject1 = "2.0.0";
          j = i;
          i = 2000;
          break;
        }
        localObject1 = "0";
        j = i;
        i = 0;
        break;
        label269:
        if (i > 0)
        {
          QMLog.log(4, "QMAppUpgradeManager", "upgrade from:" + (String)localObject1);
          upgrade(i);
        }
        else if (i == 0)
        {
          QMLog.log(4, "QMAppUpgradeManager", "new install");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.QMAPPUpgradeManager
 * JD-Core Version:    0.7.0.1
 */