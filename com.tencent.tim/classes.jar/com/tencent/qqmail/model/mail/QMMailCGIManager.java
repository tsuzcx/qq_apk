package com.tencent.qqmail.model.mail;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.calendar.fragment.CalendarMainFragment.CreditCardDetailCallback;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.download.AttachDownloadManager;
import com.tencent.qqmail.download.loader.BigAttachDownloader;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.folderlist.QMFolderManager.FolderOperationType;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.model.MailManagerDefines;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.callback.CheckMailCallback;
import com.tencent.qqmail.model.mail.callback.FolderOperationCallback;
import com.tencent.qqmail.model.mail.callback.IListCallback;
import com.tencent.qqmail.model.mail.cursor.QMSearchCursor;
import com.tencent.qqmail.model.mail.cursor.QMSearchCursor.Util;
import com.tencent.qqmail.model.mail.cursor.QMSortedSearchCursor;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.qmdomain.SearchInfo;
import com.tencent.qqmail.model.qmdomain.SubscribeMail;
import com.tencent.qqmail.model.verify.QMVerify;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.encryptionalgorithm.RsaEncryption;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkConfig;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import moai.oss.KvHelper;
import org.apache.commons.lang3.StringUtils;

public class QMMailCGIManager
{
  private static final String TAG = "QMMailCGIManager";
  private QMFolderManager folderMgr;
  private QMMailManager mailMgr;
  private QMMailSQLiteHelper sqliteHelper;
  
  public QMMailCGIManager(QMMailSQLiteHelper paramQMMailSQLiteHelper, QMMailManager paramQMMailManager, QMFolderManager paramQMFolderManager)
  {
    this.sqliteHelper = paramQMMailSQLiteHelper;
    this.mailMgr = paramQMMailManager;
    this.folderMgr = paramQMFolderManager;
  }
  
  private String _getColIdParams(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return null;
    }
    return "&colid=" + StringUtils.join(paramArrayOfString, "@book.qq.com&colid=") + "@book.qq.com";
  }
  
  private String _getRejectGroupParams(SparseArray<String> paramSparseArray)
  {
    if ((paramSparseArray == null) || (paramSparseArray.size() == 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramSparseArray.size())
    {
      int j = paramSparseArray.keyAt(i);
      localStringBuilder.append("&gid=").append(j).append("@groupmail.qq.com");
      localStringBuilder.append("&mailid=").append((String)paramSparseArray.get(j));
      i += 1;
    }
    paramSparseArray.clear();
    return localStringBuilder.toString();
  }
  
  private QMNetworkRequest execTag(int paramInt, String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    paramString = StringExtention.replaceWithEncodeURIValue("ef=js&t=mobile_mgr.json&mailaction=mail_tag&fun=$fun$", "fun", paramString);
    paramString = paramString + getTagIdParams(paramArrayOfString2);
    return CGIManager.httpPost(paramInt, "mail_mgr", paramString + getMailIdParams(paramArrayOfString1), null);
  }
  
  private boolean folder_mgr(QMFolderManager.FolderOperationType paramFolderOperationType, int paramInt, String paramString1, String paramString2, FolderOperationCallback paramFolderOperationCallback)
  {
    ValidateHelper.notNull(paramFolderOperationCallback);
    String str;
    if (paramFolderOperationType == QMFolderManager.FolderOperationType.ADD_FOLDER) {
      str = "folder_mgr_add_folder_";
    }
    for (;;)
    {
      str = str + paramInt;
      if (!RequestFilter.isRequestOnRunning(str)) {
        break label132;
      }
      if (paramFolderOperationCallback != null) {
        paramFolderOperationCallback.onComplete(null, null);
      }
      return false;
      if (paramFolderOperationType == QMFolderManager.FolderOperationType.RENAME_FOLDER)
      {
        str = "folder_mgr_rename_folder_";
      }
      else if (paramFolderOperationType == QMFolderManager.FolderOperationType.REMOVE_FOLDER)
      {
        str = "folder_mgr_remove_folder_";
      }
      else if (paramFolderOperationType == QMFolderManager.FolderOperationType.REMOVE_TAG)
      {
        str = "folder_mgr_remove_tag_";
      }
      else if (paramFolderOperationType == QMFolderManager.FolderOperationType.ADD_TAG)
      {
        str = "folder_mgr_add_tag_";
      }
      else
      {
        if (paramFolderOperationType != QMFolderManager.FolderOperationType.RENAME_TAG) {
          break;
        }
        str = "folder_mgr_rename_tag_";
      }
    }
    return false;
    label132:
    RequestFilter.setRequestRunningState(str);
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnBeforeSend(new QMMailCGIManager.12(this));
    localQMCallback.setOnSuccess(new QMMailCGIManager.13(this, paramFolderOperationType, paramString2, paramInt, paramFolderOperationCallback));
    localQMCallback.setOnError(new QMMailCGIManager.14(this, paramFolderOperationCallback));
    localQMCallback.setOnComplete(new QMMailCGIManager.15(this, str, paramFolderOperationCallback));
    CGIManager.httpPost(paramInt, "foldermgr", paramString1, localQMCallback);
    return true;
  }
  
  private String generateRemoteIdForTop(QMFolder paramQMFolder)
  {
    if (paramQMFolder.getType() == 14) {
      return "tag" + paramQMFolder.getRemoteId();
    }
    if (paramQMFolder.getType() == 18) {
      return "unread";
    }
    if (paramQMFolder.getType() == 17) {
      return "vip";
    }
    if (paramQMFolder.getType() == 16) {
      return "star";
    }
    return paramQMFolder.getRemoteId();
  }
  
  private String getMailIdParams(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return null;
    }
    return "&mailid=" + StringUtils.join(paramArrayOfString, "&mailid=");
  }
  
  private String getStatus(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "true";
    }
    return "false";
  }
  
  private String getTagIdParams(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return null;
    }
    return "&tagid=" + StringUtils.join(paramArrayOfString, "&tagid=");
  }
  
  private String getTouserParams(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return null;
    }
    return "&touser=" + StringUtils.join(paramArrayOfString, "&touser=");
  }
  
  private void handleCharSet(int paramInt, String paramString)
  {
    if ("1".equals(paramString))
    {
      QMSettingManager.sharedInstance().setCharSet(paramInt, 1);
      return;
    }
    QMSettingManager.sharedInstance().setCharSet(paramInt, 0);
  }
  
  private void handleFolderLockState(int paramInt, HashMap<String, String> paramHashMap)
  {
    boolean bool1 = StringUtils.equals("1", (CharSequence)paramHashMap.get("fldnote"));
    boolean bool2 = StringUtils.equals("1", (CharSequence)paramHashMap.get("fldpop"));
    boolean bool3 = StringUtils.equals("1", (CharSequence)paramHashMap.get("fldmy"));
    int j = 0;
    if (bool1) {
      j = 4;
    }
    int i = j;
    if (bool2) {
      i = j | 0x1;
    }
    j = i;
    if (bool3) {
      j = i | 0x2;
    }
    AccountManager.shareInstance().setAccountLockState(paramInt, j);
  }
  
  private void handleMobileSetting(JSONObject paramJSONObject, int paramInt)
  {
    SharedPreferences localSharedPreferences = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    paramJSONObject = (String)paramJSONObject.get("savesendbox");
    if ((paramJSONObject != null) && (!paramJSONObject.equals("")))
    {
      if (!localSharedPreferences.getString(paramInt + "_" + "is_save_sendbox", "1").equals(paramJSONObject)) {
        QMLog.log(4, "QMMailCGIManager", "accountId[" + paramInt + "] change savesendbox[" + paramJSONObject + "]");
      }
      localEditor.putString(paramInt + "_" + "is_save_sendbox", paramJSONObject);
    }
    localEditor.commit();
  }
  
  private void handleMobilesyncPushSetting(JSONObject paramJSONObject, int paramInt)
  {
    boolean bool2 = true;
    paramJSONObject = paramJSONObject.getJSONObject("pushsetting");
    Object localObject1;
    if (paramJSONObject != null)
    {
      localObject1 = (String)paramJSONObject.get("folderids");
      setAccountFoldersNotPush(paramInt);
      if ((localObject1 != null) && (!((String)localObject1).equals("")))
      {
        localObject2 = ((String)localObject1).split(",");
        localObject1 = new int[localObject2.length];
        int i = 0;
        while (i < localObject2.length)
        {
          localObject1[i] = QMFolder.generateId(paramInt, localObject2[i], false);
          i += 1;
        }
        localObject2 = new boolean[localObject1.length];
        i = 0;
        while (i < localObject1.length)
        {
          localObject2[i] = 1;
          i += 1;
        }
        this.folderMgr.updateFolderPushStatus((int[])localObject1, (boolean[])localObject2);
      }
      localObject1 = (String)paramJSONObject.get("onlypushmailapp");
      if ((localObject1 != null) && (!((String)localObject1).equals("")))
      {
        if (!((String)localObject1).equals("1")) {
          break label250;
        }
        QMSettingManager.sharedInstance().setOnlyPushMailApp(paramInt, true);
      }
      localObject2 = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0);
      if (!((SharedPreferences)localObject2).getBoolean("app_up_is_pushmode_set", true))
      {
        localObject1 = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
        if (localObject1 != null) {
          break label261;
        }
        QMLog.log(5, "QMMailCGIManager", "handleMobilesyncPushSetting. acc is null:" + paramInt);
      }
    }
    label250:
    while (!((Account)localObject1).getUin().equals(QMSettingManager.sharedInstance().getAppUpgradeMasterUin()))
    {
      return;
      QMSettingManager.sharedInstance().setOnlyPushMailApp(paramInt, false);
      break;
    }
    label261:
    Object localObject2 = ((SharedPreferences)localObject2).edit();
    ((SharedPreferences.Editor)localObject2).putBoolean("app_up_is_pushmode_set", true);
    ((SharedPreferences.Editor)localObject2).commit();
    localObject2 = paramJSONObject.get("nightmodel");
    Object localObject3;
    if (localObject2 != null)
    {
      localObject2 = String.valueOf(localObject2);
      localObject3 = QMSettingManager.sharedInstance();
      if (((String)localObject2).equals("0")) {
        break label491;
      }
      bool1 = true;
      label347:
      ((QMSettingManager)localObject3).setUseNightMode(bool1);
      localObject3 = new StringBuilder().append("nightmode inited : ");
      if (((String)localObject2).equals("0")) {
        break label497;
      }
    }
    label491:
    label497:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QMLog.log(4, "QMMailCGIManager", bool1 + ", uin: " + ((Account)localObject1).getUin());
      paramJSONObject = paramJSONObject.get("pushmood");
      if (paramJSONObject == null) {
        break;
      }
      paramJSONObject = String.valueOf(paramJSONObject);
      QMSettingManager.sharedInstance().setOnlyNotifyVIP(paramJSONObject.equals("1"));
      QMLog.log(4, "QMMailCGIManager", "pushmode inited : " + paramJSONObject.equals("1") + ", uin: " + ((Account)localObject1).getUin());
      return;
      bool1 = false;
      break label347;
    }
  }
  
  private void increaseSequence(ArrayList<QMFolder> paramArrayList, int paramInt)
  {
    paramInt += 1;
    while (paramInt < paramArrayList.size())
    {
      QMFolder localQMFolder = (QMFolder)paramArrayList.get(paramInt);
      localQMFolder.setSequence(localQMFolder.getSequence() + 1);
      paramInt += 1;
    }
  }
  
  private boolean isNormalFolder(int paramInt1, int paramInt2)
  {
    return ((paramInt1 == -7) || (paramInt1 == -6)) && (paramInt2 != 17);
  }
  
  private boolean loadListAll(int paramInt)
  {
    String str = "load_list_all_" + paramInt;
    if (RequestFilter.isRequestOnRunning(str)) {
      return false;
    }
    RequestFilter.setRequestRunningState(str);
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    QMMailUrlBuilder.createAllListUrl(localStringBuilder1, localStringBuilder2, paramInt);
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new QMMailCGIManager.21(this, paramInt));
    localQMCallback.setOnError(new QMMailCGIManager.22(this));
    localQMCallback.setOnComplete(new QMMailCGIManager.23(this, str));
    CGIManager.httpGet(paramInt, localStringBuilder1.toString(), localStringBuilder2.toString(), localQMCallback);
    return true;
  }
  
  private void parseFolder(int paramInt, JSONObject paramJSONObject)
  {
    Object localObject1 = this.sqliteHelper.getWritableDatabase();
    ArrayList localArrayList = QMMailParser.parseFolder(paramInt, paramJSONObject);
    updateFolderSequence(localArrayList);
    ((SQLiteDatabase)localObject1).beginTransactionNonExclusive();
    for (;;)
    {
      int i;
      try
      {
        arrayOfInt = new int[localArrayList.size()];
        localStringBuilder = new StringBuilder();
        i = 0;
        if (i >= localArrayList.size()) {
          continue;
        }
        localQMFolder = (QMFolder)localArrayList.get(i);
        localObject2 = localQMFolder.getRemoteId();
        if (localQMFolder.getType() != 14) {
          break label617;
        }
        bool = true;
        j = QMFolder.generateId(paramInt, (String)localObject2, bool);
        arrayOfInt[i] = j;
        localQMFolder.setId(j);
        localObject2 = this.sqliteHelper.folder.getFolderById(j);
        if (localObject2 == null)
        {
          if (localQMFolder.getType() == 15)
          {
            if (QMSettingManager.sharedInstance().getAggregateSubscribeMail()) {
              break label623;
            }
            bool = true;
            localQMFolder.setDisplay(bool);
          }
          localStringBuilder.append(localQMFolder.getName()).append(",");
          this.sqliteHelper.folder.insertFolder((SQLiteDatabase)localObject1, localQMFolder);
          break label610;
        }
        if ((localQMFolder.getSvrCount() == ((QMFolder)localObject2).getSvrCount()) && (localQMFolder.getSvrUnreadCount() == ((QMFolder)localObject2).getSvrUnreadCount()) && (localQMFolder.getFromTime() == ((QMFolder)localObject2).getFromTime())) {
          continue;
        }
        localQMFolderSQLite = this.sqliteHelper.folder;
        k = ((QMFolder)localObject2).getId();
        m = localQMFolder.getCliUnreadCount();
        n = localQMFolder.getSvrCount();
        if (localQMFolder.getSvrUnreadCount() <= ((QMFolder)localObject2).getSvrUnreadCount()) {
          continue;
        }
        bool = true;
      }
      catch (Exception localException)
      {
        int[] arrayOfInt;
        StringBuilder localStringBuilder;
        QMFolder localQMFolder;
        Object localObject2;
        int j;
        QMFolderSQLite localQMFolderSQLite;
        int k;
        int m;
        int n;
        QMLog.log(6, "QMMailCGIManager", "parseFolder err:" + paramInt + "," + localException);
        ((SQLiteDatabase)localObject1).endTransaction();
        paramJSONObject = QMMailParser.parseLockState(paramInt, paramJSONObject);
        if (paramJSONObject == null) {
          continue;
        }
        localObject1 = (QQMailAccount)AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
        if (localObject1 == null) {
          continue;
        }
        ((QQMailAccount)localObject1).saveUserLock(paramJSONObject);
        return;
        bool = false;
        continue;
        QMLog.log(4, "QMMailCGIManager", "parseFolder:" + localStringBuilder.toString());
        this.folderMgr.resetFolders(paramInt, arrayOfInt);
        ((SQLiteDatabase)localObject1).setTransactionSuccessful();
        ((SQLiteDatabase)localObject1).endTransaction();
        continue;
      }
      finally
      {
        ((SQLiteDatabase)localObject1).endTransaction();
      }
      localQMFolderSQLite.updateFolder((SQLiteDatabase)localObject1, k, m, n, bool, true);
      this.sqliteHelper.folder.updateFolderFromTime((SQLiteDatabase)localObject1, ((QMFolder)localObject2).getId(), true, localQMFolder.getFromTime());
      if (!localQMFolder.getName().equals(((QMFolder)localObject2).getName()))
      {
        localStringBuilder.append("rename[").append(localQMFolder.getName()).append(",").append(((QMFolder)localObject2).getName()).append("],");
        this.sqliteHelper.folder.renameFolder((SQLiteDatabase)localObject1, j, localQMFolder.getName());
      }
      if (localQMFolder.getSequence() != ((QMFolder)localObject2).getSequence())
      {
        localStringBuilder.append("updateSeq[").append(localQMFolder.getName()).append(":").append(localQMFolder.getSequence()).append("],");
        this.sqliteHelper.folder.updateFolderSequence((SQLiteDatabase)localObject1, j, localQMFolder.getSequence());
      }
      label610:
      i += 1;
      continue;
      label617:
      boolean bool = false;
      continue;
      label623:
      bool = false;
    }
  }
  
  private String[] parseIncrementalList(SQLiteDatabase paramSQLiteDatabase, int paramInt, ArrayList<Object[]> paramArrayList, String[] paramArrayOfString, IDelMailAfterSync paramIDelMailAfterSync)
  {
    int j = 0;
    ArrayList localArrayList;
    int i;
    boolean bool;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localArrayList = new ArrayList();
      List localList = Arrays.asList(paramArrayOfString);
      i = 0;
      bool = false;
      if (i < paramArrayList.size())
      {
        Object[] arrayOfObject = (Object[])paramArrayList.get(i);
        if (localList.contains(arrayOfObject[1])) {
          break label264;
        }
        localArrayList.add((Long)arrayOfObject[0]);
        if ((bool) || (!((Boolean)arrayOfObject[2]).booleanValue())) {
          break label264;
        }
        bool = true;
      }
    }
    label264:
    for (;;)
    {
      i += 1;
      break;
      if (localArrayList.size() > 0)
      {
        paramArrayList = new long[localArrayList.size()];
        i = 0;
        while (i < localArrayList.size())
        {
          paramArrayList[i] = ((Long)localArrayList.get(i)).longValue();
          i += 1;
        }
        if (paramIDelMailAfterSync != null) {
          paramIDelMailAfterSync.run(paramArrayList, false, bool);
        }
      }
      paramArrayList = new long[paramArrayOfString.length];
      i = j;
      while (i < paramArrayOfString.length)
      {
        paramArrayList[i] = Mail.generateId(paramInt, paramArrayOfString[i]);
        i += 1;
      }
      this.sqliteHelper.mail.updateNotChildConvMailType(paramSQLiteDatabase, paramArrayList);
      this.sqliteHelper.mail.updateNeedSyncAttr(paramSQLiteDatabase, paramArrayList, true);
      return this.sqliteHelper.mail.remoteIdNotIncludes(paramSQLiteDatabase, paramInt, paramArrayOfString);
    }
  }
  
  private Object[] parseMails(int paramInt1, int paramInt2, JSONObject paramJSONObject)
    throws Exception
  {
    if (paramJSONObject != null) {
      return parseMails(QMMailParser.parseMails(paramInt1, paramJSONObject), paramInt2, paramInt1, paramJSONObject, false);
    }
    throw new Exception("parseMails Error: json is null.");
  }
  
  /* Error */
  private Object[] parseMails(ArrayList<Mail> paramArrayList, int paramInt1, int paramInt2, JSONObject paramJSONObject, boolean paramBoolean)
    throws Exception
  {
    // Byte code:
    //   0: new 33	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   7: astore 17
    //   9: new 521	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 669	java/util/ArrayList:<init>	()V
    //   16: astore 16
    //   18: aload 4
    //   20: invokestatic 733	com/tencent/qqmail/model/mail/QMMailParser:parseIndexes	(Lcom/alibaba/fastjson/JSONObject;)Ljava/util/HashMap;
    //   23: astore 20
    //   25: aload 4
    //   27: invokestatic 737	com/tencent/qqmail/model/mail/QMMailParser:parseIndexSinceRemoteId	(Lcom/alibaba/fastjson/JSONObject;)Ljava/lang/String;
    //   30: astore 18
    //   32: iconst_0
    //   33: istore 7
    //   35: iconst_0
    //   36: istore 8
    //   38: iconst_0
    //   39: istore 9
    //   41: iconst_0
    //   42: istore 6
    //   44: aload_1
    //   45: invokevirtual 522	java/util/ArrayList:size	()I
    //   48: ifle +1358 -> 1406
    //   51: aload_0
    //   52: getfield 24	com/tencent/qqmail/model/mail/QMMailCGIManager:sqliteHelper	Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   55: invokevirtual 562	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:getWritableDatabase	()Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   58: astore 19
    //   60: aload 19
    //   62: invokevirtual 576	com/tencent/moai/database/sqlite/SQLiteDatabase:beginTransactionNonExclusive	()V
    //   65: aload_0
    //   66: getfield 24	com/tencent/qqmail/model/mail/QMMailCGIManager:sqliteHelper	Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   69: getfield 583	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:folder	Lcom/tencent/qqmail/model/mail/QMFolderSQLite;
    //   72: iload_3
    //   73: bipush 15
    //   75: invokevirtual 741	com/tencent/qqmail/model/mail/QMFolderSQLite:getFoldersByAccountAndType	(II)Ljava/util/ArrayList;
    //   78: astore 4
    //   80: aload 4
    //   82: ifnull +1318 -> 1400
    //   85: aload 4
    //   87: invokeinterface 742 1 0
    //   92: ifle +1308 -> 1400
    //   95: aload 4
    //   97: iconst_0
    //   98: invokeinterface 743 2 0
    //   103: checkcast 306	com/tencent/qqmail/model/qmdomain/QMFolder
    //   106: invokevirtual 615	com/tencent/qqmail/model/qmdomain/QMFolder:getId	()I
    //   109: istore 10
    //   111: aload_1
    //   112: invokevirtual 522	java/util/ArrayList:size	()I
    //   115: newarray long
    //   117: astore 4
    //   119: iconst_0
    //   120: istore 9
    //   122: iload 7
    //   124: istore 8
    //   126: aload_0
    //   127: getfield 28	com/tencent/qqmail/model/mail/QMMailCGIManager:folderMgr	Lcom/tencent/qqmail/folderlist/QMFolderManager;
    //   130: iload_3
    //   131: invokevirtual 746	com/tencent/qqmail/folderlist/QMFolderManager:getDraftFolderId	(I)I
    //   134: istore 12
    //   136: iload 7
    //   138: istore 8
    //   140: aload_1
    //   141: invokevirtual 750	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   144: astore 21
    //   146: iconst_0
    //   147: istore 11
    //   149: iload 9
    //   151: istore 7
    //   153: iload 6
    //   155: istore 8
    //   157: aload 21
    //   159: invokeinterface 755 1 0
    //   164: ifeq +1105 -> 1269
    //   167: iload 6
    //   169: istore 8
    //   171: aload 21
    //   173: invokeinterface 759 1 0
    //   178: checkcast 701	com/tencent/qqmail/model/qmdomain/Mail
    //   181: astore 22
    //   183: iload 6
    //   185: istore 8
    //   187: aload 22
    //   189: invokevirtual 762	com/tencent/qqmail/model/qmdomain/Mail:getStatus	()Lcom/tencent/qqmail/model/qmdomain/MailStatus;
    //   192: astore 23
    //   194: iload 6
    //   196: istore 8
    //   198: aload 22
    //   200: invokevirtual 766	com/tencent/qqmail/model/qmdomain/Mail:getInformation	()Lcom/tencent/qqmail/model/qmdomain/MailInformation;
    //   203: astore 24
    //   205: iload 6
    //   207: istore 8
    //   209: aload 4
    //   211: iload 11
    //   213: aload 22
    //   215: invokevirtual 766	com/tencent/qqmail/model/qmdomain/Mail:getInformation	()Lcom/tencent/qqmail/model/qmdomain/MailInformation;
    //   218: invokevirtual 770	com/tencent/qqmail/model/qmdomain/MailInformation:getId	()J
    //   221: lastore
    //   222: iload 6
    //   224: istore 8
    //   226: aload 24
    //   228: invokevirtual 773	com/tencent/qqmail/model/qmdomain/MailInformation:getFolderId	()I
    //   231: iload_3
    //   232: ldc_w 775
    //   235: iconst_0
    //   236: invokestatic 449	com/tencent/qqmail/model/qmdomain/QMFolder:generateId	(ILjava/lang/String;Z)I
    //   239: if_icmpne +39 -> 278
    //   242: iload 6
    //   244: istore 8
    //   246: aload 17
    //   248: aload 24
    //   250: invokevirtual 776	com/tencent/qqmail/model/qmdomain/MailInformation:getRemoteId	()Ljava/lang/String;
    //   253: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: ldc_w 778
    //   259: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: iload 6
    //   265: istore 8
    //   267: iload 7
    //   269: istore 6
    //   271: iload 8
    //   273: istore 7
    //   275: goto +1143 -> 1418
    //   278: iload 6
    //   280: istore 8
    //   282: aload 23
    //   284: invokevirtual 783	com/tencent/qqmail/model/qmdomain/MailStatus:isConversation	()Z
    //   287: ifeq +53 -> 340
    //   290: iload 6
    //   292: istore 8
    //   294: aload 16
    //   296: iconst_3
    //   297: anewarray 4	java/lang/Object
    //   300: dup
    //   301: iconst_0
    //   302: aload 22
    //   304: invokevirtual 766	com/tencent/qqmail/model/qmdomain/Mail:getInformation	()Lcom/tencent/qqmail/model/qmdomain/MailInformation;
    //   307: invokevirtual 776	com/tencent/qqmail/model/qmdomain/MailInformation:getRemoteId	()Ljava/lang/String;
    //   310: aastore
    //   311: dup
    //   312: iconst_1
    //   313: aload 22
    //   315: invokevirtual 766	com/tencent/qqmail/model/qmdomain/Mail:getInformation	()Lcom/tencent/qqmail/model/qmdomain/MailInformation;
    //   318: invokevirtual 786	com/tencent/qqmail/model/qmdomain/MailInformation:getQQTid	()Ljava/lang/String;
    //   321: aastore
    //   322: dup
    //   323: iconst_2
    //   324: aload 22
    //   326: invokevirtual 766	com/tencent/qqmail/model/qmdomain/Mail:getInformation	()Lcom/tencent/qqmail/model/qmdomain/MailInformation;
    //   329: invokevirtual 773	com/tencent/qqmail/model/qmdomain/MailInformation:getFolderId	()I
    //   332: invokestatic 791	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   335: aastore
    //   336: invokevirtual 687	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   339: pop
    //   340: iload 6
    //   342: istore 8
    //   344: aload 23
    //   346: iconst_1
    //   347: invokevirtual 794	com/tencent/qqmail/model/qmdomain/MailStatus:setContentComplete	(Z)V
    //   350: iload 6
    //   352: istore 8
    //   354: aload 23
    //   356: iconst_0
    //   357: invokevirtual 797	com/tencent/qqmail/model/qmdomain/MailStatus:setLocalMail	(Z)V
    //   360: iload 6
    //   362: istore 8
    //   364: aload 24
    //   366: invokevirtual 773	com/tencent/qqmail/model/qmdomain/MailInformation:getFolderId	()I
    //   369: iload 12
    //   371: if_icmpne +13 -> 384
    //   374: iload 6
    //   376: istore 8
    //   378: aload 23
    //   380: iconst_0
    //   381: invokevirtual 800	com/tencent/qqmail/model/qmdomain/MailStatus:setUnread	(Z)V
    //   384: iload 7
    //   386: istore 9
    //   388: iload 6
    //   390: istore 8
    //   392: aload 24
    //   394: invokevirtual 773	com/tencent/qqmail/model/qmdomain/MailInformation:getFolderId	()I
    //   397: iload 10
    //   399: if_icmpne +67 -> 466
    //   402: iload 7
    //   404: istore 9
    //   406: iload 6
    //   408: istore 8
    //   410: aload 24
    //   412: invokevirtual 803	com/tencent/qqmail/model/qmdomain/MailInformation:getColId	()Ljava/lang/String;
    //   415: ifnull +51 -> 466
    //   418: iload 6
    //   420: istore 8
    //   422: aload 24
    //   424: invokevirtual 803	com/tencent/qqmail/model/qmdomain/MailInformation:getColId	()Ljava/lang/String;
    //   427: invokestatic 807	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   430: istore 13
    //   432: iload 7
    //   434: istore 9
    //   436: iload 6
    //   438: istore 8
    //   440: aload 24
    //   442: invokevirtual 776	com/tencent/qqmail/model/qmdomain/MailInformation:getRemoteId	()Ljava/lang/String;
    //   445: iload 13
    //   447: invokestatic 811	com/tencent/qqmail/model/qmdomain/Mail:isSubscribeByColid	(Ljava/lang/String;I)Z
    //   450: ifeq +16 -> 466
    //   453: iload 6
    //   455: istore 8
    //   457: aload 23
    //   459: iconst_1
    //   460: invokevirtual 814	com/tencent/qqmail/model/qmdomain/MailStatus:setSubscribeMail	(Z)V
    //   463: iconst_1
    //   464: istore 9
    //   466: iload 9
    //   468: istore 7
    //   470: iload 6
    //   472: istore 8
    //   474: aload 24
    //   476: invokevirtual 818	com/tencent/qqmail/model/qmdomain/MailInformation:getFrom	()Lcom/tencent/qqmail/model/qmdomain/MailContact;
    //   479: ifnull +172 -> 651
    //   482: iload 9
    //   484: istore 7
    //   486: iload 6
    //   488: istore 8
    //   490: ldc_w 820
    //   493: aload 24
    //   495: invokevirtual 818	com/tencent/qqmail/model/qmdomain/MailInformation:getFrom	()Lcom/tencent/qqmail/model/qmdomain/MailContact;
    //   498: invokevirtual 823	com/tencent/qqmail/model/qmdomain/MailContact:getName	()Ljava/lang/String;
    //   501: invokevirtual 337	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   504: ifeq +147 -> 651
    //   507: iload 9
    //   509: istore 7
    //   511: iload 6
    //   513: istore 8
    //   515: aload 24
    //   517: invokevirtual 776	com/tencent/qqmail/model/qmdomain/MailInformation:getRemoteId	()Ljava/lang/String;
    //   520: ifnull +131 -> 651
    //   523: iload 9
    //   525: istore 7
    //   527: iload 6
    //   529: istore 8
    //   531: aload 24
    //   533: invokevirtual 776	com/tencent/qqmail/model/qmdomain/MailInformation:getRemoteId	()Ljava/lang/String;
    //   536: ldc_w 825
    //   539: invokevirtual 828	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   542: ifeq +109 -> 651
    //   545: iload 6
    //   547: istore 8
    //   549: ldc_w 830
    //   552: invokestatic 836	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   555: aload 24
    //   557: invokevirtual 818	com/tencent/qqmail/model/qmdomain/MailInformation:getFrom	()Lcom/tencent/qqmail/model/qmdomain/MailContact;
    //   560: invokevirtual 839	com/tencent/qqmail/model/qmdomain/MailContact:getAddress	()Ljava/lang/String;
    //   563: invokevirtual 843	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   566: astore 25
    //   568: iload 9
    //   570: istore 7
    //   572: iload 6
    //   574: istore 8
    //   576: aload 25
    //   578: invokevirtual 848	java/util/regex/Matcher:find	()Z
    //   581: ifeq +70 -> 651
    //   584: iload 6
    //   586: istore 8
    //   588: aload 25
    //   590: iconst_1
    //   591: invokevirtual 852	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   594: astore 25
    //   596: iload 6
    //   598: istore 8
    //   600: ldc 11
    //   602: new 33	java/lang/StringBuilder
    //   605: dup
    //   606: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   609: ldc_w 854
    //   612: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: aload 25
    //   617: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   623: invokestatic 860	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   626: pop
    //   627: iload 6
    //   629: istore 8
    //   631: aload 24
    //   633: aload 25
    //   635: invokevirtual 863	com/tencent/qqmail/model/qmdomain/MailInformation:setColId	(Ljava/lang/String;)V
    //   638: iload 6
    //   640: istore 8
    //   642: aload 23
    //   644: iconst_1
    //   645: invokevirtual 814	com/tencent/qqmail/model/qmdomain/MailStatus:setSubscribeMail	(Z)V
    //   648: iconst_1
    //   649: istore 7
    //   651: iload 6
    //   653: istore 8
    //   655: aload 23
    //   657: invokevirtual 866	com/tencent/qqmail/model/qmdomain/MailStatus:isSystemMail	()Z
    //   660: ifeq +37 -> 697
    //   663: iload 6
    //   665: istore 8
    //   667: aload 23
    //   669: invokevirtual 869	com/tencent/qqmail/model/qmdomain/MailStatus:isSubscribeMail	()Z
    //   672: ifne +15 -> 687
    //   675: iload 6
    //   677: istore 8
    //   679: aload 23
    //   681: invokevirtual 872	com/tencent/qqmail/model/qmdomain/MailStatus:isAdMail	()Z
    //   684: ifeq +13 -> 697
    //   687: iload 6
    //   689: istore 8
    //   691: aload 23
    //   693: iconst_0
    //   694: invokevirtual 875	com/tencent/qqmail/model/qmdomain/MailStatus:setSystemMail	(Z)V
    //   697: iconst_0
    //   698: istore 14
    //   700: iload 5
    //   702: ifeq +232 -> 934
    //   705: iload 6
    //   707: istore 8
    //   709: aload 22
    //   711: invokevirtual 878	com/tencent/qqmail/model/qmdomain/Mail:canContentChange	()Z
    //   714: ifne +740 -> 1454
    //   717: iconst_1
    //   718: istore 14
    //   720: iload 6
    //   722: istore 8
    //   724: iload 14
    //   726: istore 15
    //   728: aload 23
    //   730: invokevirtual 783	com/tencent/qqmail/model/qmdomain/MailStatus:isConversation	()Z
    //   733: ifeq +660 -> 1393
    //   736: iload 6
    //   738: istore 8
    //   740: iload 14
    //   742: istore 15
    //   744: aload 22
    //   746: invokevirtual 878	com/tencent/qqmail/model/qmdomain/Mail:canContentChange	()Z
    //   749: ifeq +644 -> 1393
    //   752: iload 6
    //   754: istore 8
    //   756: aload_0
    //   757: getfield 24	com/tencent/qqmail/model/mail/QMMailCGIManager:sqliteHelper	Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   760: getfield 708	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:mail	Lcom/tencent/qqmail/model/mail/QMMailSQLite;
    //   763: aload_0
    //   764: getfield 24	com/tencent/qqmail/model/mail/QMMailCGIManager:sqliteHelper	Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   767: invokevirtual 562	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:getWritableDatabase	()Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   770: aload 22
    //   772: invokevirtual 766	com/tencent/qqmail/model/qmdomain/Mail:getInformation	()Lcom/tencent/qqmail/model/qmdomain/MailInformation;
    //   775: invokevirtual 770	com/tencent/qqmail/model/qmdomain/MailInformation:getId	()J
    //   778: iconst_0
    //   779: invokevirtual 882	com/tencent/qqmail/model/mail/QMMailSQLite:updateMailLoaded	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;JZ)V
    //   782: iload 6
    //   784: istore 8
    //   786: aload 22
    //   788: invokevirtual 762	com/tencent/qqmail/model/qmdomain/Mail:getStatus	()Lcom/tencent/qqmail/model/qmdomain/MailStatus;
    //   791: iload 14
    //   793: invokevirtual 885	com/tencent/qqmail/model/qmdomain/MailStatus:setLoaded	(Z)V
    //   796: iload 6
    //   798: istore 8
    //   800: aload 24
    //   802: invokevirtual 773	com/tencent/qqmail/model/qmdomain/MailInformation:getFolderId	()I
    //   805: aload_0
    //   806: getfield 28	com/tencent/qqmail/model/mail/QMMailCGIManager:folderMgr	Lcom/tencent/qqmail/folderlist/QMFolderManager;
    //   809: aload 24
    //   811: invokevirtual 888	com/tencent/qqmail/model/qmdomain/MailInformation:getAccountId	()I
    //   814: invokevirtual 746	com/tencent/qqmail/folderlist/QMFolderManager:getDraftFolderId	(I)I
    //   817: if_icmpne +49 -> 866
    //   820: iload 14
    //   822: ifne +44 -> 866
    //   825: iload 6
    //   827: istore 8
    //   829: aload 24
    //   831: invokevirtual 892	com/tencent/qqmail/model/qmdomain/MailInformation:getDate	()Ljava/util/Date;
    //   834: ifnull +32 -> 866
    //   837: iload 6
    //   839: istore 8
    //   841: aload_0
    //   842: getfield 24	com/tencent/qqmail/model/mail/QMMailCGIManager:sqliteHelper	Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   845: getfield 708	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:mail	Lcom/tencent/qqmail/model/mail/QMMailSQLite;
    //   848: aload 19
    //   850: aload 24
    //   852: invokevirtual 770	com/tencent/qqmail/model/qmdomain/MailInformation:getId	()J
    //   855: aload 24
    //   857: invokevirtual 892	com/tencent/qqmail/model/qmdomain/MailInformation:getDate	()Ljava/util/Date;
    //   860: invokevirtual 897	java/util/Date:getTime	()J
    //   863: invokevirtual 901	com/tencent/qqmail/model/mail/QMMailSQLite:updateMailLoadedWhenUTCChanged	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;JJ)V
    //   866: iload 6
    //   868: istore 8
    //   870: aload 23
    //   872: invokevirtual 904	com/tencent/qqmail/model/qmdomain/MailStatus:isGroupMail	()Z
    //   875: ifeq +334 -> 1209
    //   878: iload 6
    //   880: istore 8
    //   882: aload_0
    //   883: getfield 26	com/tencent/qqmail/model/mail/QMMailCGIManager:mailMgr	Lcom/tencent/qqmail/model/mail/QMMailManager;
    //   886: aload 19
    //   888: aload 22
    //   890: aload_1
    //   891: invokevirtual 910	com/tencent/qqmail/model/mail/QMMailManager:saveGroupMail	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;Lcom/tencent/qqmail/model/qmdomain/Mail;Ljava/util/ArrayList;)Z
    //   894: istore 15
    //   896: iload 15
    //   898: ifeq +235 -> 1133
    //   901: iload_2
    //   902: sipush 128
    //   905: iand
    //   906: ifeq +133 -> 1039
    //   909: iload 6
    //   911: istore 8
    //   913: aload_0
    //   914: getfield 24	com/tencent/qqmail/model/mail/QMMailCGIManager:sqliteHelper	Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   917: getfield 708	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:mail	Lcom/tencent/qqmail/model/mail/QMMailSQLite;
    //   920: aload 19
    //   922: aload 24
    //   924: invokevirtual 770	com/tencent/qqmail/model/qmdomain/MailInformation:getId	()J
    //   927: iconst_1
    //   928: invokevirtual 913	com/tencent/qqmail/model/mail/QMMailSQLite:updateSearchMailLoaded	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;JZ)V
    //   931: goto +508 -> 1439
    //   934: iload 6
    //   936: istore 8
    //   938: aload 23
    //   940: invokevirtual 783	com/tencent/qqmail/model/qmdomain/MailStatus:isConversation	()Z
    //   943: ifeq +30 -> 973
    //   946: iload 6
    //   948: istore 8
    //   950: iload 14
    //   952: istore 15
    //   954: aload 20
    //   956: aload 24
    //   958: invokevirtual 776	com/tencent/qqmail/model/qmdomain/MailInformation:getRemoteId	()Ljava/lang/String;
    //   961: invokevirtual 916	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   964: ifeq +429 -> 1393
    //   967: iconst_1
    //   968: istore 14
    //   970: goto -188 -> 782
    //   973: iload 6
    //   975: istore 8
    //   977: iload 14
    //   979: istore 15
    //   981: aload 22
    //   983: invokevirtual 920	com/tencent/qqmail/model/qmdomain/Mail:getContent	()Lcom/tencent/qqmail/model/qmdomain/MailContent;
    //   986: ifnull +407 -> 1393
    //   989: iload 6
    //   991: istore 8
    //   993: iload 14
    //   995: istore 15
    //   997: aload 22
    //   999: invokevirtual 920	com/tencent/qqmail/model/qmdomain/Mail:getContent	()Lcom/tencent/qqmail/model/qmdomain/MailContent;
    //   1002: invokevirtual 925	com/tencent/qqmail/model/qmdomain/MailContent:getBody	()Ljava/lang/String;
    //   1005: ifnull +388 -> 1393
    //   1008: iload 6
    //   1010: istore 8
    //   1012: iload 14
    //   1014: istore 15
    //   1016: aload 22
    //   1018: invokevirtual 920	com/tencent/qqmail/model/qmdomain/Mail:getContent	()Lcom/tencent/qqmail/model/qmdomain/MailContent;
    //   1021: invokevirtual 925	com/tencent/qqmail/model/qmdomain/MailContent:getBody	()Ljava/lang/String;
    //   1024: ldc_w 397
    //   1027: invokevirtual 337	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1030: ifne +363 -> 1393
    //   1033: iconst_1
    //   1034: istore 14
    //   1036: goto -254 -> 782
    //   1039: iload 6
    //   1041: istore 8
    //   1043: aload_0
    //   1044: getfield 24	com/tencent/qqmail/model/mail/QMMailCGIManager:sqliteHelper	Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   1047: getfield 708	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:mail	Lcom/tencent/qqmail/model/mail/QMMailSQLite;
    //   1050: aload 19
    //   1052: aload 24
    //   1054: invokevirtual 770	com/tencent/qqmail/model/qmdomain/MailInformation:getId	()J
    //   1057: iconst_1
    //   1058: invokevirtual 882	com/tencent/qqmail/model/mail/QMMailSQLite:updateMailLoaded	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;JZ)V
    //   1061: goto +378 -> 1439
    //   1064: astore_1
    //   1065: aload_1
    //   1066: astore 16
    //   1068: aload 4
    //   1070: astore_1
    //   1071: bipush 6
    //   1073: ldc 11
    //   1075: ldc_w 927
    //   1078: aload 16
    //   1080: invokestatic 930	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1083: aload 19
    //   1085: invokevirtual 649	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   1088: iconst_0
    //   1089: istore 5
    //   1091: iload 8
    //   1093: istore 6
    //   1095: iconst_5
    //   1096: anewarray 4	java/lang/Object
    //   1099: dup
    //   1100: iconst_0
    //   1101: aload 18
    //   1103: aastore
    //   1104: dup
    //   1105: iconst_1
    //   1106: aload_1
    //   1107: aastore
    //   1108: dup
    //   1109: iconst_2
    //   1110: iload 5
    //   1112: invokestatic 933	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1115: aastore
    //   1116: dup
    //   1117: iconst_3
    //   1118: iload 6
    //   1120: invokestatic 791	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1123: aastore
    //   1124: dup
    //   1125: iconst_4
    //   1126: aload 17
    //   1128: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1131: aastore
    //   1132: areturn
    //   1133: iload 15
    //   1135: ifne +304 -> 1439
    //   1138: iload 14
    //   1140: ifne +299 -> 1439
    //   1143: iload_2
    //   1144: sipush 128
    //   1147: iand
    //   1148: ifeq +36 -> 1184
    //   1151: iload 6
    //   1153: istore 8
    //   1155: aload_0
    //   1156: getfield 24	com/tencent/qqmail/model/mail/QMMailCGIManager:sqliteHelper	Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   1159: getfield 708	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:mail	Lcom/tencent/qqmail/model/mail/QMMailSQLite;
    //   1162: aload 19
    //   1164: aload 24
    //   1166: invokevirtual 770	com/tencent/qqmail/model/qmdomain/MailInformation:getId	()J
    //   1169: iconst_0
    //   1170: invokevirtual 913	com/tencent/qqmail/model/mail/QMMailSQLite:updateSearchMailLoaded	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;JZ)V
    //   1173: goto +266 -> 1439
    //   1176: astore_1
    //   1177: aload 19
    //   1179: invokevirtual 649	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   1182: aload_1
    //   1183: athrow
    //   1184: iload 6
    //   1186: istore 8
    //   1188: aload_0
    //   1189: getfield 24	com/tencent/qqmail/model/mail/QMMailCGIManager:sqliteHelper	Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   1192: getfield 708	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:mail	Lcom/tencent/qqmail/model/mail/QMMailSQLite;
    //   1195: aload 19
    //   1197: aload 24
    //   1199: invokevirtual 770	com/tencent/qqmail/model/qmdomain/MailInformation:getId	()J
    //   1202: iconst_0
    //   1203: invokevirtual 882	com/tencent/qqmail/model/mail/QMMailSQLite:updateMailLoaded	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;JZ)V
    //   1206: goto +233 -> 1439
    //   1209: iload 6
    //   1211: istore 8
    //   1213: aload 23
    //   1215: invokevirtual 936	com/tencent/qqmail/model/qmdomain/MailStatus:isGroupChild	()Z
    //   1218: ifne +160 -> 1378
    //   1221: iload 6
    //   1223: istore 8
    //   1225: aload_0
    //   1226: getfield 26	com/tencent/qqmail/model/mail/QMMailCGIManager:mailMgr	Lcom/tencent/qqmail/model/mail/QMMailManager;
    //   1229: aload 19
    //   1231: aload 22
    //   1233: iload_2
    //   1234: invokevirtual 940	com/tencent/qqmail/model/mail/QMMailManager:saveMail	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;Lcom/tencent/qqmail/model/qmdomain/Mail;I)Z
    //   1237: ifeq +141 -> 1378
    //   1240: iload 6
    //   1242: istore 8
    //   1244: aload 23
    //   1246: invokevirtual 872	com/tencent/qqmail/model/qmdomain/MailStatus:isAdMail	()Z
    //   1249: ifne +129 -> 1378
    //   1252: iload 6
    //   1254: iconst_1
    //   1255: iadd
    //   1256: istore 8
    //   1258: iload 7
    //   1260: istore 6
    //   1262: iload 8
    //   1264: istore 7
    //   1266: goto +152 -> 1418
    //   1269: iload 6
    //   1271: istore 8
    //   1273: aload 16
    //   1275: invokevirtual 522	java/util/ArrayList:size	()I
    //   1278: ifle +31 -> 1309
    //   1281: iload_2
    //   1282: sipush 128
    //   1285: iand
    //   1286: ifeq +79 -> 1365
    //   1289: iconst_1
    //   1290: istore 5
    //   1292: iload 6
    //   1294: istore 8
    //   1296: aload_0
    //   1297: aload 19
    //   1299: iload_3
    //   1300: aload 16
    //   1302: aload 20
    //   1304: iload 5
    //   1306: invokespecial 944	com/tencent/qqmail/model/mail/QMMailCGIManager:parseMailsConvHash	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;ILjava/util/ArrayList;Ljava/util/HashMap;Z)V
    //   1309: iload 7
    //   1311: ifeq +17 -> 1328
    //   1314: iload 6
    //   1316: istore 8
    //   1318: aload_0
    //   1319: getfield 26	com/tencent/qqmail/model/mail/QMMailCGIManager:mailMgr	Lcom/tencent/qqmail/model/mail/QMMailManager;
    //   1322: aload 19
    //   1324: iload_3
    //   1325: invokevirtual 948	com/tencent/qqmail/model/mail/QMMailManager:updateSubscribeEntrance	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;I)V
    //   1328: iload 6
    //   1330: istore 8
    //   1332: aload_0
    //   1333: getfield 26	com/tencent/qqmail/model/mail/QMMailCGIManager:mailMgr	Lcom/tencent/qqmail/model/mail/QMMailManager;
    //   1336: aload 19
    //   1338: iload_3
    //   1339: invokevirtual 951	com/tencent/qqmail/model/mail/QMMailManager:updateAdvertiseEntrance	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;I)V
    //   1342: iload 6
    //   1344: istore 8
    //   1346: aload 19
    //   1348: invokevirtual 668	com/tencent/moai/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   1351: aload 19
    //   1353: invokevirtual 649	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   1356: aload 4
    //   1358: astore_1
    //   1359: iconst_1
    //   1360: istore 5
    //   1362: goto -267 -> 1095
    //   1365: iconst_0
    //   1366: istore 5
    //   1368: goto -76 -> 1292
    //   1371: astore 16
    //   1373: aconst_null
    //   1374: astore_1
    //   1375: goto -304 -> 1071
    //   1378: iload 6
    //   1380: istore 8
    //   1382: iload 7
    //   1384: istore 6
    //   1386: iload 8
    //   1388: istore 7
    //   1390: goto +28 -> 1418
    //   1393: iload 15
    //   1395: istore 14
    //   1397: goto -615 -> 782
    //   1400: iconst_0
    //   1401: istore 10
    //   1403: goto -1292 -> 111
    //   1406: aconst_null
    //   1407: astore_1
    //   1408: iconst_1
    //   1409: istore 5
    //   1411: iload 9
    //   1413: istore 6
    //   1415: goto -320 -> 1095
    //   1418: iload 7
    //   1420: istore 8
    //   1422: iload 11
    //   1424: iconst_1
    //   1425: iadd
    //   1426: istore 11
    //   1428: iload 6
    //   1430: istore 7
    //   1432: iload 8
    //   1434: istore 6
    //   1436: goto -1283 -> 153
    //   1439: iload 6
    //   1441: istore 8
    //   1443: iload 7
    //   1445: istore 6
    //   1447: iload 8
    //   1449: istore 7
    //   1451: goto -33 -> 1418
    //   1454: iconst_0
    //   1455: istore 14
    //   1457: goto -737 -> 720
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1460	0	this	QMMailCGIManager
    //   0	1460	1	paramArrayList	ArrayList<Mail>
    //   0	1460	2	paramInt1	int
    //   0	1460	3	paramInt2	int
    //   0	1460	4	paramJSONObject	JSONObject
    //   0	1460	5	paramBoolean	boolean
    //   42	1404	6	i	int
    //   33	1417	7	j	int
    //   36	1412	8	k	int
    //   39	1373	9	m	int
    //   109	1293	10	n	int
    //   147	1280	11	i1	int
    //   134	238	12	i2	int
    //   430	16	13	i3	int
    //   698	758	14	bool1	boolean
    //   726	668	15	bool2	boolean
    //   16	1285	16	localObject1	Object
    //   1371	1	16	localException	Exception
    //   7	1120	17	localStringBuilder	StringBuilder
    //   30	1072	18	str	String
    //   58	1294	19	localSQLiteDatabase	SQLiteDatabase
    //   23	1280	20	localHashMap	HashMap
    //   144	28	21	localIterator	Iterator
    //   181	1051	22	localMail	Mail
    //   192	1053	23	localMailStatus	com.tencent.qqmail.model.qmdomain.MailStatus
    //   203	995	24	localMailInformation	MailInformation
    //   566	68	25	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   126	136	1064	java/lang/Exception
    //   140	146	1064	java/lang/Exception
    //   157	167	1064	java/lang/Exception
    //   171	183	1064	java/lang/Exception
    //   187	194	1064	java/lang/Exception
    //   198	205	1064	java/lang/Exception
    //   209	222	1064	java/lang/Exception
    //   226	242	1064	java/lang/Exception
    //   246	263	1064	java/lang/Exception
    //   282	290	1064	java/lang/Exception
    //   294	340	1064	java/lang/Exception
    //   344	350	1064	java/lang/Exception
    //   354	360	1064	java/lang/Exception
    //   364	374	1064	java/lang/Exception
    //   378	384	1064	java/lang/Exception
    //   392	402	1064	java/lang/Exception
    //   410	418	1064	java/lang/Exception
    //   422	432	1064	java/lang/Exception
    //   440	453	1064	java/lang/Exception
    //   457	463	1064	java/lang/Exception
    //   474	482	1064	java/lang/Exception
    //   490	507	1064	java/lang/Exception
    //   515	523	1064	java/lang/Exception
    //   531	545	1064	java/lang/Exception
    //   549	568	1064	java/lang/Exception
    //   576	584	1064	java/lang/Exception
    //   588	596	1064	java/lang/Exception
    //   600	627	1064	java/lang/Exception
    //   631	638	1064	java/lang/Exception
    //   642	648	1064	java/lang/Exception
    //   655	663	1064	java/lang/Exception
    //   667	675	1064	java/lang/Exception
    //   679	687	1064	java/lang/Exception
    //   691	697	1064	java/lang/Exception
    //   709	717	1064	java/lang/Exception
    //   728	736	1064	java/lang/Exception
    //   744	752	1064	java/lang/Exception
    //   756	782	1064	java/lang/Exception
    //   786	796	1064	java/lang/Exception
    //   800	820	1064	java/lang/Exception
    //   829	837	1064	java/lang/Exception
    //   841	866	1064	java/lang/Exception
    //   870	878	1064	java/lang/Exception
    //   882	896	1064	java/lang/Exception
    //   913	931	1064	java/lang/Exception
    //   938	946	1064	java/lang/Exception
    //   954	967	1064	java/lang/Exception
    //   981	989	1064	java/lang/Exception
    //   997	1008	1064	java/lang/Exception
    //   1016	1033	1064	java/lang/Exception
    //   1043	1061	1064	java/lang/Exception
    //   1155	1173	1064	java/lang/Exception
    //   1188	1206	1064	java/lang/Exception
    //   1213	1221	1064	java/lang/Exception
    //   1225	1240	1064	java/lang/Exception
    //   1244	1252	1064	java/lang/Exception
    //   1273	1281	1064	java/lang/Exception
    //   1296	1309	1064	java/lang/Exception
    //   1318	1328	1064	java/lang/Exception
    //   1332	1342	1064	java/lang/Exception
    //   1346	1351	1064	java/lang/Exception
    //   65	80	1176	finally
    //   85	111	1176	finally
    //   111	119	1176	finally
    //   126	136	1176	finally
    //   140	146	1176	finally
    //   157	167	1176	finally
    //   171	183	1176	finally
    //   187	194	1176	finally
    //   198	205	1176	finally
    //   209	222	1176	finally
    //   226	242	1176	finally
    //   246	263	1176	finally
    //   282	290	1176	finally
    //   294	340	1176	finally
    //   344	350	1176	finally
    //   354	360	1176	finally
    //   364	374	1176	finally
    //   378	384	1176	finally
    //   392	402	1176	finally
    //   410	418	1176	finally
    //   422	432	1176	finally
    //   440	453	1176	finally
    //   457	463	1176	finally
    //   474	482	1176	finally
    //   490	507	1176	finally
    //   515	523	1176	finally
    //   531	545	1176	finally
    //   549	568	1176	finally
    //   576	584	1176	finally
    //   588	596	1176	finally
    //   600	627	1176	finally
    //   631	638	1176	finally
    //   642	648	1176	finally
    //   655	663	1176	finally
    //   667	675	1176	finally
    //   679	687	1176	finally
    //   691	697	1176	finally
    //   709	717	1176	finally
    //   728	736	1176	finally
    //   744	752	1176	finally
    //   756	782	1176	finally
    //   786	796	1176	finally
    //   800	820	1176	finally
    //   829	837	1176	finally
    //   841	866	1176	finally
    //   870	878	1176	finally
    //   882	896	1176	finally
    //   913	931	1176	finally
    //   938	946	1176	finally
    //   954	967	1176	finally
    //   981	989	1176	finally
    //   997	1008	1176	finally
    //   1016	1033	1176	finally
    //   1043	1061	1176	finally
    //   1071	1083	1176	finally
    //   1155	1173	1176	finally
    //   1188	1206	1176	finally
    //   1213	1221	1176	finally
    //   1225	1240	1176	finally
    //   1244	1252	1176	finally
    //   1273	1281	1176	finally
    //   1296	1309	1176	finally
    //   1318	1328	1176	finally
    //   1332	1342	1176	finally
    //   1346	1351	1176	finally
    //   65	80	1371	java/lang/Exception
    //   85	111	1371	java/lang/Exception
    //   111	119	1371	java/lang/Exception
  }
  
  private void parseMailsConvHash(SQLiteDatabase paramSQLiteDatabase, int paramInt, ArrayList<Object[]> paramArrayList, HashMap<String, String[]> paramHashMap, boolean paramBoolean)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = (Object[])paramArrayList.next();
      String str = (String)localObject[0];
      if (paramHashMap.containsKey(str))
      {
        String[] arrayOfString = (String[])paramHashMap.get(str);
        long[] arrayOfLong1 = new long[arrayOfString.length + 1];
        long[] arrayOfLong2 = new long[arrayOfString.length];
        int i = 0;
        while (i < arrayOfString.length)
        {
          arrayOfLong1[i] = Mail.generateId(paramInt, arrayOfString[i]);
          arrayOfLong2[i] = arrayOfLong1[i];
          i += 1;
        }
        arrayOfLong1[(arrayOfLong1.length - 1)] = Mail.generateId(paramInt, str);
        i = Mail.generateConvQQTidHash(paramInt, (String)localObject[1]);
        int j = ((Integer)localObject[2]).intValue();
        this.sqliteHelper.mail.updateQQMailConvHash(paramSQLiteDatabase, arrayOfLong1, paramInt, j, i, paramBoolean);
        localObject = this.sqliteHelper.mail.getExpireConvMailIds(paramSQLiteDatabase, i, arrayOfLong1);
        if ((localObject != null) && (localObject.length > 0))
        {
          int k = localObject.length;
          i = 0;
          while (i < k)
          {
            long l = localObject[i];
            this.sqliteHelper.mail.updateMailConvHash(paramSQLiteDatabase, l, Mail.generateConvQQIdHash(paramInt, l), paramBoolean);
            i += 1;
          }
        }
        this.sqliteHelper.mail.updateConvMailType(paramSQLiteDatabase, j, new long[] { arrayOfLong1[(arrayOfLong1.length - 1)] }, 1, paramBoolean);
        this.sqliteHelper.mail.updateConvMailType(paramSQLiteDatabase, j, arrayOfLong2, -1, paramBoolean);
        if (paramBoolean) {
          this.sqliteHelper.mail.updateSearchNeedSyncAttr(paramSQLiteDatabase, arrayOfLong2, false);
        } else {
          this.sqliteHelper.mail.updateNeedSyncAttr(paramSQLiteDatabase, arrayOfLong2, false);
        }
      }
    }
  }
  
  private void parseStatus(SQLiteDatabase paramSQLiteDatabase, int paramInt, boolean paramBoolean, JSONObject paramJSONObject)
  {
    paramJSONObject = QMMailParser.parseStatus(paramInt, paramJSONObject).iterator();
    if (paramJSONObject.hasNext())
    {
      QMFolder localQMFolder = (QMFolder)paramJSONObject.next();
      label56:
      Object localObject;
      QMFolderSQLite localQMFolderSQLite;
      int i;
      int j;
      boolean bool;
      if (localQMFolder.getType() == 16)
      {
        paramInt = this.folderMgr.getQQMailStarredFolderId(localQMFolder.getAccountId());
        localObject = this.folderMgr.getFolder(paramInt);
        localQMFolderSQLite = this.sqliteHelper.folder;
        paramInt = ((QMFolder)localObject).getId();
        i = localQMFolder.getCliUnreadCount();
        j = localQMFolder.getSvrCount();
        if (!paramBoolean) {
          break label240;
        }
        bool = ((QMFolder)localObject).hasNewMail();
      }
      for (;;)
      {
        localQMFolderSQLite.updateFolder(paramSQLiteDatabase, paramInt, i, j, bool, false);
        this.sqliteHelper.folder.updateFolderPersonalCnt(paramSQLiteDatabase, ((QMFolder)localObject).getId(), localQMFolder.getPersonalCount());
        break;
        if (localQMFolder.getType() == 18)
        {
          paramInt = this.folderMgr.getQQMailUnreadFolderId(localQMFolder.getAccountId());
          break label56;
        }
        if (localQMFolder.getType() == 17)
        {
          paramInt = this.folderMgr.getQQMailVipFolderId(localQMFolder.getAccountId());
          break label56;
        }
        paramInt = localQMFolder.getAccountId();
        localObject = localQMFolder.getRemoteId();
        if (localQMFolder.getType() == 14) {}
        for (bool = true;; bool = false)
        {
          paramInt = QMFolder.generateId(paramInt, (String)localObject, bool);
          break;
        }
        label240:
        if (localQMFolder.getSvrUnreadCount() > ((QMFolder)localObject).getSvrUnreadCount()) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
  }
  
  private ArrayList<SubscribeMail> processSubscribeMail(int paramInt, ArrayList<SubscribeMail> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      SubscribeMail localSubscribeMail = (SubscribeMail)localIterator.next();
      long l = Mail.generateId(paramInt, localSubscribeMail.getRemoteId());
      localSubscribeMail.setAccountId(paramInt);
      localSubscribeMail.setMid(l);
      localSubscribeMail.setId(SubscribeMail.generateId(l, localSubscribeMail.getIndex()));
      localArrayList.add(localSubscribeMail);
    }
    paramArrayList.clear();
    return localArrayList;
  }
  
  private void setAccountFoldersNotPush(int paramInt)
  {
    ArrayList localArrayList = this.folderMgr.getFoldersByAccountId(paramInt);
    int[] arrayOfInt = new int[localArrayList.size()];
    boolean[] arrayOfBoolean = new boolean[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      if (localArrayList.get(i) == null)
      {
        QMLog.log(3, "QMMailCGIManager", "setAccountFoldersNotPush folder is null:" + i + ", accountid:" + paramInt);
        return;
      }
      arrayOfInt[i] = ((QMFolder)localArrayList.get(i)).getId();
      arrayOfBoolean[i] = false;
      i += 1;
    }
    this.folderMgr.updateFolderPushStatus(arrayOfInt, arrayOfBoolean);
  }
  
  private QMNetworkRequest subscribeMails(int paramInt, Mail paramMail, boolean paramBoolean)
  {
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnError(new QMMailCGIManager.43(this, paramInt));
    localQMCallback.setOnSuccess(new QMMailCGIManager.44(this, paramInt, paramMail, paramBoolean));
    return CGIManager.httpGet(paramInt, "readmail", MailManagerDefines.PARAM_READMAIL_PREFIX_DATA + "&s=read&showreplyhead=1&disptype=html&mode=pre&readtype=readCol&mailid=$mailid$&screen=200.000000*350.000000".replace("$mailid$", paramMail.getInformation().getRemoteId()), localQMCallback);
  }
  
  private void syncCalendarAccountAfterLoadMail(int paramInt, long[] paramArrayOfLong)
  {
    paramArrayOfLong = this.sqliteHelper.mail.getMailAttrByIds(this.sqliteHelper.getReadableDatabase(), paramArrayOfLong, "attr");
    int j;
    int i;
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
    {
      j = paramArrayOfLong.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if (Mail.isCalendar(paramArrayOfLong[i]))
        {
          paramArrayOfLong = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
          QMCalendarManager.getInstance().syncCalendarAfterSync(paramArrayOfLong, null);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  private void updateFolderSequence(ArrayList<QMFolder> paramArrayList)
  {
    int i1 = 0;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    if (i < paramArrayList.size())
    {
      if (((QMFolder)paramArrayList.get(i)).getTopPos() != 0) {
        localArrayList1.add(paramArrayList.get(i));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList2.add(paramArrayList.get(i));
      }
    }
    if ((localArrayList1.size() == 0) || (localArrayList2.size() == 0)) {
      return;
    }
    Collections.sort(localArrayList1, new QMMailCGIManager.5(this));
    int k = localArrayList1.size() - 1;
    int j = 0;
    i = 0;
    label120:
    int m;
    int n;
    if (k >= 0)
    {
      paramArrayList = (QMFolder)localArrayList1.get(k);
      m = paramArrayList.getTopPos();
      n = paramArrayList.getParentId();
      if ((isNormalFolder(n, paramArrayList.getType())) && (m != 0) && (i == 0))
      {
        i = j;
        j = k;
      }
    }
    for (;;)
    {
      k -= 1;
      m = j;
      j = i;
      i = m;
      break label120;
      if ((n == -8) && (j == 0))
      {
        j = k;
        m = i;
        i = j;
        j = m;
        continue;
        Log.i("QMMailCGIManager", "userFolderTopPosEnd:" + i + ", popFolderrTopPosEnd:" + j);
        k = 0;
        m = 0;
        label259:
        int i2;
        if (i1 < localArrayList2.size())
        {
          paramArrayList = (QMFolder)localArrayList2.get(i1);
          i2 = paramArrayList.getParentId();
          if (!isNormalFolder(i2, paramArrayList.getType())) {
            break label360;
          }
          increaseSequence(localArrayList1, i);
          n = m + 1;
          paramArrayList.setSequence(((QMFolder)localArrayList1.get(i)).getSequence() + n);
          m = k;
          k = n;
        }
        for (;;)
        {
          i1 += 1;
          n = k;
          k = m;
          m = n;
          break label259;
          break;
          label360:
          n = k;
          if (i2 == -8)
          {
            increaseSequence(localArrayList1, j);
            n = k + 1;
            paramArrayList.setSequence(((QMFolder)localArrayList1.get(j)).getSequence() + n);
          }
          k = m;
          m = n;
        }
      }
      else
      {
        m = i;
        i = j;
        j = m;
      }
    }
  }
  
  private boolean updateListAll(int paramInt)
  {
    String str = "update_list_all_" + paramInt;
    if (RequestFilter.isRequestOnRunning(str)) {
      return false;
    }
    RequestFilter.setRequestRunningState(str);
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    QMMailUrlBuilder.createAllListUrl(localStringBuilder1, localStringBuilder2, paramInt);
    QMMailUrlBuilder.getCursorUrl(localStringBuilder2, this.sqliteHelper.mail.getRecentMail(this.sqliteHelper.getReadableDatabase(), paramInt), false);
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new QMMailCGIManager.24(this, paramInt));
    localQMCallback.setOnError(new QMMailCGIManager.25(this));
    localQMCallback.setOnComplete(new QMMailCGIManager.26(this, str));
    CGIManager.httpGet(paramInt, localStringBuilder1.toString(), localStringBuilder2.toString(), localQMCallback);
    return true;
  }
  
  private void updatePopularizeSubInfomationData(JSONObject paramJSONObject)
  {
    Object localObject = PopularizeManager.sharedInstance().getAllPopularize();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Popularize localPopularize = (Popularize)((Iterator)localObject).next();
        if ((localPopularize.getSubInformation() != null) && (!localPopularize.getSubInformation().equals("")))
        {
          String str1 = paramJSONObject.getString(localPopularize.getSubInformation());
          String str2 = localPopularize.getSubInformationData();
          if ((str1 != null) && (!str1.equals(str2)))
          {
            PopularizeManager.sharedInstance().updatePopularizeClick(localPopularize.getId(), false);
            PopularizeManager.sharedInstance().updatePopularizeSubInformationData(localPopularize.getSubInformation(), str1);
          }
        }
      }
    }
  }
  
  private void xQQWeChatPublicAccount(int paramInt, JSONObject paramJSONObject)
  {
    if ((StringExtention.containInheritKey(paramJSONObject, new String[] { "tipscloseqqwx", "st" })) && (paramJSONObject.getJSONObject("tipscloseqqwx").getIntValue("st") == 1)) {
      QMWatcherCenter.triggerXqqwx(paramInt, paramJSONObject.getJSONObject("tipscloseqqwx").getString("msg"));
    }
  }
  
  public QMNetworkRequest addFilter(int paramInt1, String[] paramArrayOfString, int paramInt2)
  {
    Object localObject = this.folderMgr.getFolder(paramInt2);
    StringBuilder localStringBuilder = new StringBuilder("ef=js&t=setting2.json");
    localStringBuilder.append(StringExtention.replaceWithEncodeURIValue("&Fun=AddDone&CurFilterID=0&IsValid=1&Type=0&OptionCode=0&movefolder=$folderid$&sender=0", "folderid", ((QMFolder)localObject).getRemoteId()));
    int i = paramArrayOfString.length;
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      localObject = paramArrayOfString[paramInt2];
      localStringBuilder.append("&sendercontent=").append(StringExtention.encodeURI((String)localObject));
      paramInt2 += 1;
    }
    paramArrayOfString = new QMCallback();
    paramArrayOfString.setOnSuccess(new QMMailCGIManager.42(this, paramInt1));
    return CGIManager.httpPost(paramInt1, "setting2", localStringBuilder.toString(), paramArrayOfString);
  }
  
  public boolean addFolder(int paramInt, String paramString, FolderOperationCallback paramFolderOperationCallback)
  {
    String str = MailManagerDefines.PARAM_PREFIX_FOLDERMGR + "&name=$foldername$&fun=new".replace("$foldername$", URLEncoder.encode(paramString));
    return folder_mgr(QMFolderManager.FolderOperationType.ADD_FOLDER, paramInt, str, paramString, paramFolderOperationCallback);
  }
  
  public boolean addTag(int paramInt, String paramString, FolderOperationCallback paramFolderOperationCallback)
  {
    String str = MailManagerDefines.PARAM_PREFIX_FOLDERMGR + "&tagname=$tagname$&fun=newtag".replace("$tagname$", URLEncoder.encode(paramString));
    return folder_mgr(QMFolderManager.FolderOperationType.ADD_TAG, paramInt, str, paramString, paramFolderOperationCallback);
  }
  
  public void checkAppleIdVerifyCode(int paramInt, String paramString1, String paramString2, MailManagerDelegate paramMailManagerDelegate)
  {
    paramString1 = StringExtention.replaceWithEncodeURIValue(StringExtention.replaceWithEncodeURIValue("type=appleid_check&mailid=$mailid$&safecode=$safecode$", "mailid", paramString1), "safecode", paramString2);
    paramString2 = new QMCallback();
    paramString2.setOnSuccess(new QMMailCGIManager.76(this, paramMailManagerDelegate));
    paramString2.setOnError(new QMMailCGIManager.77(this, paramMailManagerDelegate));
    CGIManager.httpGet(paramInt, "gen_safecode", paramString1, paramString2);
  }
  
  public void checkMail(int paramInt, Map<QMFolder, List<Pair<String, Long>>> paramMap, boolean paramBoolean, CheckMailCallback paramCheckMailCallback)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if (localAccount == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkMail, account: ").append(localAccount.getEmail()).append(", folderSize: ").append(paramMap.size());
    Iterator localIterator = paramMap.keySet().iterator();
    String str = "check_mail?showmail=1";
    if (localIterator.hasNext())
    {
      QMFolder localQMFolder = (QMFolder)localIterator.next();
      List localList = (List)paramMap.get(localQMFolder);
      if (localList.size() > 0) {}
      for (long l = ((Long)((Pair)localList.get(localList.size() - 1)).second).longValue() / 1000L;; l = 0L)
      {
        ((StringBuilder)localObject).append(", [").append(localQMFolder.getName()).append("/").append(localQMFolder.getRemoteId()).append("/").append(l).append("]");
        str = str + "&folder=" + localQMFolder.getRemoteId() + "_" + l;
        break;
      }
    }
    QMLog.log(4, "QMMailCGIManager", ((StringBuilder)localObject).toString());
    localObject = new QMCallback();
    ((QMCallback)localObject).setOnSuccess(new QMMailCGIManager.16(this, paramMap, localAccount, paramCheckMailCallback));
    ((QMCallback)localObject).setOnError(new QMMailCGIManager.17(this, paramCheckMailCallback));
    CGIManager.httpGet(paramInt, str, null, paramBoolean, (QMCallback)localObject);
  }
  
  public QMNetworkRequest delFilter(int paramInt, String paramString)
  {
    return CGIManager.httpPost(paramInt, "mail_mgr", StringExtention.replaceWithEncodeURIValue("ef=js&t=mobile_mgr.json&mailaction=filter_del&folder=$folderid$", "folderid", paramString), null);
  }
  
  public QMNetworkRequest deleteMails(int paramInt, boolean paramBoolean, String[] paramArrayOfString, MailManagerDelegate paramMailManagerDelegate)
  {
    Object localObject = "ef=js&t=mobile_mgr.json&s=del&mailaction=mail_del";
    if (paramBoolean) {
      localObject = "ef=js&t=mobile_mgr.json&s=del&mailaction=mail_del" + "&Fun=PerDel";
    }
    paramArrayOfString = (String)localObject + getMailIdParams(paramArrayOfString);
    localObject = new QMCallback();
    ((QMCallback)localObject).setOnBeforeSend(new QMMailCGIManager.39(this, paramMailManagerDelegate));
    ((QMCallback)localObject).setOnSuccess(new QMMailCGIManager.40(this, paramMailManagerDelegate));
    ((QMCallback)localObject).setOnError(new QMMailCGIManager.41(this, paramMailManagerDelegate));
    return CGIManager.httpPost(paramInt, "mail_mgr", paramArrayOfString, (QMCallback)localObject);
  }
  
  public void downloadSendMailAttach(Attach paramAttach, boolean paramBoolean, MailManagerDelegate paramMailManagerDelegate)
  {
    Object localObject2 = paramAttach.getPreview().getDownloadUrl().replace("&amp;", "&");
    Object localObject1 = localObject2;
    if (((String)localObject2).startsWith("/cgi-bin/")) {
      localObject1 = QMNetworkConfig.getCgiRequestHost(paramAttach.getAccountId()) + (String)localObject2;
    }
    localObject2 = new DownloadInfo();
    ((DownloadInfo)localObject2).setAttachId(paramAttach.getHashId());
    ((DownloadInfo)localObject2).setAccountId(paramAttach.getAccountId());
    ((DownloadInfo)localObject2).setKey((String)localObject1);
    ((DownloadInfo)localObject2).setUrl((String)localObject1);
    ((DownloadInfo)localObject2).setFileSize(StringExtention.sizeStrToLong(paramAttach.getSize()));
    ((DownloadInfo)localObject2).setFileName(paramAttach.getName());
    ((DownloadInfo)localObject2).setFilePath(paramAttach.getPreview().getMyDisk());
    ((DownloadInfo)localObject2).setIsNotify(false);
    ((DownloadInfo)localObject2).setIsFixProcess(false);
    ((DownloadInfo)localObject2).setDownloadType(1);
    ((DownloadInfo)localObject2).setAttachType(0);
    ((DownloadInfo)localObject2).setShouldUpdateInfo(paramBoolean);
    ((DownloadInfo)localObject2).setAttachDownloadListener(new QMMailCGIManager.47(this, paramMailManagerDelegate, paramAttach));
    AttachDownloadManager.shareInstance().fetchAttach((DownloadInfo)localObject2);
  }
  
  public void downloadSendMailBigAttach(MailBigAttach paramMailBigAttach, boolean paramBoolean, MailManagerDelegate paramMailManagerDelegate)
  {
    new BigAttachDownloader(paramMailBigAttach, paramBoolean, paramMailManagerDelegate).download();
  }
  
  public void followShareCalendarFolder(int paramInt, boolean paramBoolean, String paramString1, String paramString2, MailManagerDelegate paramMailManagerDelegate)
  {
    String str = "fun=follow&code=$code$&email=$email$" + paramString1 + "_" + paramString2;
    if (RequestFilter.isRequestOnRunning(str)) {
      return;
    }
    RequestFilter.setRequestRunningState(str);
    if (paramBoolean) {}
    for (Object localObject = "fun=follow_wx&code=$code$&email=$email$";; localObject = "fun=follow&code=$code$&email=$email$")
    {
      paramString1 = StringExtention.replaceWithEncodeURIValue(StringExtention.replaceWithEncodeURIValue((String)localObject, "code", String.valueOf(paramString1)), "email", String.valueOf(paramString2));
      localObject = new QMCallback();
      ((QMCallback)localObject).setOnBeforeSend(new QMMailCGIManager.78(this, paramMailManagerDelegate, paramString2));
      ((QMCallback)localObject).setOnSuccess(new QMMailCGIManager.79(this, paramMailManagerDelegate));
      ((QMCallback)localObject).setOnError(new QMMailCGIManager.80(this, paramMailManagerDelegate));
      ((QMCallback)localObject).setOnComplete(new QMMailCGIManager.81(this, paramMailManagerDelegate, str));
      CGIManager.httpGet(paramInt, "calendar", paramString1, (QMCallback)localObject);
      return;
    }
  }
  
  public void genAppleIdVerifyCode(int paramInt1, String paramString, int paramInt2, MailManagerDelegate paramMailManagerDelegate)
  {
    String str = "gen_safecode" + paramInt1;
    if (RequestFilter.isRequestOnRunning(str))
    {
      paramMailManagerDelegate.handleComplete(null);
      return;
    }
    RequestFilter.setRequestRunningState(str);
    if (paramInt2 == 0) {}
    for (Object localObject = "appleid";; localObject = "appleid_wx")
    {
      paramString = StringExtention.replaceWithEncodeURIValue(StringExtention.replaceWithEncodeURIValue("type=$type$&mailid=$mailid$", "type", (String)localObject), "mailid", paramString);
      localObject = new QMCallback();
      ((QMCallback)localObject).setOnSuccess(new QMMailCGIManager.73(this, paramMailManagerDelegate));
      ((QMCallback)localObject).setOnError(new QMMailCGIManager.74(this, paramMailManagerDelegate));
      ((QMCallback)localObject).setOnComplete(new QMMailCGIManager.75(this, str));
      CGIManager.httpGet(paramInt1, "gen_safecode", paramString, (QMCallback)localObject);
      return;
    }
  }
  
  public void getMailReminderCreditDetail(int paramInt, String paramString, CalendarMainFragment.CreditCardDetailCallback paramCreditCardDetailCallback)
  {
    QMLog.log(4, "QMMailCGIManager", "accountId = " + paramInt + " id " + paramString);
    paramString = "fun=getcreditinfo&t=remind_setting.json&id=$id".replace("$id", paramString);
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new QMMailCGIManager.35(this, paramCreditCardDetailCallback));
    localQMCallback.setOnError(new QMMailCGIManager.36(this, paramCreditCardDetailCallback));
    CGIManager.httpGet(paramInt, "remind_setting", paramString, localQMCallback);
  }
  
  public void getMailReminderSetting(boolean paramBoolean, Mail paramMail, QMCallback paramQMCallback)
  {
    int i = paramMail.getInformation().getAccountId();
    paramMail = paramMail.getInformation().getRemoteId();
    if (paramBoolean) {}
    for (paramMail = "t=remind_setting.json&fun=getcreditsetting&mailid=$mailid";; paramMail = "t=remind_setting.json&fun=getjourneysetting&mailid=$mailid".replace("$mailid", paramMail))
    {
      CGIManager.httpGet(i, "remind_setting", paramMail, paramQMCallback);
      return;
    }
  }
  
  public void getMailWeatherParseResult(int paramInt, String paramString, QMCallback paramQMCallback)
  {
    CGIManager.httpGet(paramInt, "remind_setting", "t=remind_setting.json&fun=getjourneyinfo&mailid=$mailid".replace("$mailid", paramString), paramQMCallback);
  }
  
  public void getShareCalendarFolderQRUrl(int paramInt, String paramString, MailManagerDelegate paramMailManagerDelegate)
  {
    String str1 = "fun=qr_share&easid=$easid$&ret=url" + paramString;
    if (RequestFilter.isRequestOnRunning(str1)) {
      return;
    }
    RequestFilter.setRequestRunningState(str1);
    String str2 = StringExtention.replaceWithEncodeURIValue("fun=qr_share&easid=$easid$&ret=url", "easid", String.valueOf(paramString));
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnBeforeSend(new QMMailCGIManager.82(this, paramMailManagerDelegate, paramString));
    localQMCallback.setOnSuccess(new QMMailCGIManager.83(this, paramMailManagerDelegate));
    localQMCallback.setOnError(new QMMailCGIManager.84(this, paramMailManagerDelegate));
    localQMCallback.setOnComplete(new QMMailCGIManager.85(this, paramMailManagerDelegate, str1));
    CGIManager.httpGet(paramInt, "calendar", str2, localQMCallback);
  }
  
  public void getShareCalendarFolderWXUrl(int paramInt, String paramString, MailManagerDelegate paramMailManagerDelegate)
  {
    String str1 = "fun=wx_share&easid=$easid$&ret=url" + paramString;
    if (RequestFilter.isRequestOnRunning(str1)) {
      return;
    }
    RequestFilter.setRequestRunningState(str1);
    String str2 = StringExtention.replaceWithEncodeURIValue("fun=wx_share&easid=$easid$&ret=url", "easid", String.valueOf(paramString));
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnBeforeSend(new QMMailCGIManager.86(this, paramMailManagerDelegate, paramString));
    localQMCallback.setOnSuccess(new QMMailCGIManager.87(this, paramMailManagerDelegate));
    localQMCallback.setOnError(new QMMailCGIManager.88(this, paramMailManagerDelegate));
    localQMCallback.setOnComplete(new QMMailCGIManager.89(this, paramMailManagerDelegate, str1));
    CGIManager.httpGet(paramInt, "calendar", str2, localQMCallback);
  }
  
  public void getVerifyImage(int paramInt, String paramString, MailManagerDelegate paramMailManagerDelegate)
  {
    String str1 = "ret=json&verifykey=$verifykey$" + paramString;
    if (RequestFilter.isRequestOnRunning(str1)) {
      return;
    }
    RequestFilter.setRequestRunningState(str1);
    String str2 = StringExtention.replaceWithEncodeURIValue("ret=json&verifykey=$verifykey$", "verifykey", String.valueOf(paramString));
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnBeforeSend(new QMMailCGIManager.69(this, paramMailManagerDelegate, paramString));
    localQMCallback.setOnSuccess(new QMMailCGIManager.70(this, paramString, paramMailManagerDelegate));
    localQMCallback.setOnError(new QMMailCGIManager.71(this, paramMailManagerDelegate));
    localQMCallback.setOnComplete(new QMMailCGIManager.72(this, paramMailManagerDelegate, str1));
    CGIManager.httpGet(paramInt, "getverifyimage", str2, localQMCallback);
  }
  
  public void initSync(Account paramAccount)
  {
    sync(paramAccount.getId(), null);
  }
  
  public void loadList(int paramInt)
  {
    loadList(paramInt, null);
  }
  
  public void loadList(int paramInt, IListCallback paramIListCallback)
  {
    QMFolder localQMFolder = this.sqliteHelper.folder.getFolderById(paramInt);
    int i = localQMFolder.getAccountId();
    String str = "load_list_" + paramInt;
    if ((RequestFilter.isRequestOnRunning(str)) || (RequestFilter.isRequestOnRunning("load_list_all_" + i)))
    {
      if (paramIListCallback != null) {
        paramIListCallback.success(new long[0], false);
      }
      return;
    }
    RequestFilter.setRequestRunningState(str);
    Threads.runInBackground(new QMMailCGIManager.18(this, localQMFolder, paramIListCallback, paramInt, i, str));
  }
  
  public void loadMail(int paramInt1, long paramLong, String paramString1, String paramString2, int paramInt2, MailManagerDelegate paramMailManagerDelegate)
  {
    Object localObject = MailManagerDefines.PARAM_READMAIL_PREFIX_DATA + "&s=read&showreplyhead=1&disptype=html&nofold=true";
    localObject = (String)localObject + "&mode=pre";
    String str = StringExtention.replaceWithEncodeURIValue("&mailid=$id$", "id", paramString1);
    str = (String)localObject + str;
    localObject = str;
    if (paramString2 != null) {
      localObject = str + StringExtention.replaceWithEncodeURIValue("&safecode=$safecode$", "safecode", paramString2);
    }
    paramString2 = new QMCallback();
    paramString2.setOnBeforeSend(new QMMailCGIManager.28(this, paramLong, paramMailManagerDelegate));
    paramString2.setOnSuccess(new QMMailCGIManager.29(this, paramInt2, paramInt1, paramString1, paramLong, paramMailManagerDelegate));
    paramString2.setOnError(new QMMailCGIManager.30(this, paramLong, paramMailManagerDelegate));
    CGIManager.httpGet(paramInt1, "readmail", (String)localObject, paramString2);
  }
  
  public void loadMail(Mail paramMail, int paramInt, MailManagerDelegate paramMailManagerDelegate)
  {
    long l = paramMail.getInformation().getId();
    loadMail(paramMail.getInformation().getAccountId(), l, paramMail.getInformation().getRemoteId(), paramMail.getAppleIdVerifyCode(), paramInt, paramMailManagerDelegate);
  }
  
  public void loadMore(QMFolder paramQMFolder)
  {
    loadMore(paramQMFolder, null);
  }
  
  public void loadMore(QMFolder paramQMFolder, IListCallback paramIListCallback)
  {
    String str = "load_list_" + paramQMFolder.getId();
    if ((RequestFilter.isRequestOnRunning(str)) || (RequestFilter.isRequestOnRunning("load_list_all_" + paramQMFolder.getAccountId())))
    {
      if (paramIListCallback != null) {
        paramIListCallback.success(new long[0], false);
      }
      return;
    }
    RequestFilter.setRequestRunningState(str);
    Threads.runInBackground(new QMMailCGIManager.20(this, paramQMFolder, paramIListCallback, str));
  }
  
  public void loadTranslateMail(Mail paramMail, MailManagerDelegate paramMailManagerDelegate)
  {
    int i = paramMail.getInformation().getAccountId();
    String str = paramMail.getInformation().getRemoteId();
    long l = paramMail.getInformation().getId();
    paramMail = StringExtention.replaceWithEncodeURIValue(MailManagerDefines.PARAM_TRANSLATE, "id", str);
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new QMMailCGIManager.31(this, l, paramMailManagerDelegate, str));
    localQMCallback.setOnError(new QMMailCGIManager.32(this, l, paramMailManagerDelegate));
    CGIManager.httpGet(i, "fanyi", paramMail, localQMCallback);
  }
  
  public QMNetworkRequest markMailReadAll(int paramInt, String[] paramArrayOfString)
  {
    return CGIManager.httpPost(paramInt, "mail_mgr", StringExtention.replaceWithURIValue("ef=js&t=mobile_mgr.json" + MailManagerDefines.PARAM_READ, "folderid", StringExtention.join(StringExtention.encodeURIArray(paramArrayOfString), "&folderid=")), null);
  }
  
  public void mobileCancelBar(int paramInt, String paramString, MailManagerDelegate paramMailManagerDelegate)
  {
    if (TextUtils.isEmpty(paramString)) {
      QMLog.log(4, "mobileCancelBar", "mailIds is null");
    }
    String str;
    do
    {
      return;
      str = "mobilecanclebar=true&mailid=$mailid$&t=mobile_mgr.json" + paramString;
    } while (RequestFilter.isRequestOnRunning(str));
    RequestFilter.setRequestRunningState(str);
    paramString = StringExtention.replaceWithEncodeURIValue("mobilecanclebar=true&mailid=$mailid$&t=mobile_mgr.json", "mailid", String.valueOf(paramString));
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new QMMailCGIManager.62(this, paramMailManagerDelegate));
    localQMCallback.setOnError(new QMMailCGIManager.63(this, paramMailManagerDelegate));
    localQMCallback.setOnComplete(new QMMailCGIManager.64(this, paramMailManagerDelegate, str));
    CGIManager.httpPost(paramInt, "mail_mgr", paramString, localQMCallback);
  }
  
  public void modifySendUtc(int paramInt, long paramLong1, String paramString, long paramLong2, MailManagerDelegate paramMailManagerDelegate)
  {
    String str1 = "modify_send_utc_" + paramLong1;
    if (RequestFilter.isRequestOnRunning(str1))
    {
      if (paramMailManagerDelegate != null) {
        paramMailManagerDelegate.handleComplete(null);
      }
      return;
    }
    RequestFilter.setRequestRunningState(str1);
    String str2 = "ef=js&t=mobile_mgr.json&mailaction=mdy_sendtime&sendtimeyear=$sendtimeyear$&sendtimemonth=$sendtimemonth$&sendtimeday=$sendtimeday$&sendtimehour=$sendtimehour$&sendtimemin=$sendtimemin$" + getMailIdParams(new String[] { paramString });
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong2);
    str2 = StringExtention.replaceWithEncodeURIValue(StringExtention.replaceWithEncodeURIValue(StringExtention.replaceWithEncodeURIValue(StringExtention.replaceWithEncodeURIValue(StringExtention.replaceWithEncodeURIValue(str2, "sendtimeyear", String.valueOf(((Calendar)localObject).get(1))), "sendtimemonth", String.valueOf(((Calendar)localObject).get(2) + 1)), "sendtimeday", String.valueOf(((Calendar)localObject).get(5))), "sendtimehour", String.valueOf(((Calendar)localObject).get(11))), "sendtimemin", String.valueOf(((Calendar)localObject).get(12)));
    localObject = new QMCallback();
    ((QMCallback)localObject).setOnBeforeSend(new QMMailCGIManager.58(this, paramMailManagerDelegate, paramLong1));
    ((QMCallback)localObject).setOnSuccess(new QMMailCGIManager.59(this, paramLong1, paramString, paramLong2, paramMailManagerDelegate));
    ((QMCallback)localObject).setOnError(new QMMailCGIManager.60(this, paramMailManagerDelegate, paramLong1));
    ((QMCallback)localObject).setOnComplete(new QMMailCGIManager.61(this, paramMailManagerDelegate, str1));
    CGIManager.httpPost(paramInt, "mail_mgr", str2, (QMCallback)localObject);
  }
  
  public QMNetworkRequest moveHistoryMail(int paramInt1, int paramInt2)
  {
    return CGIManager.httpPost(paramInt1, "mail_mgr", StringExtention.replaceWithEncodeURIValue("ef=js&t=mobile_mgr.json&mailaction=filter_move&filterid=$filterid$", "filterid", String.valueOf(paramInt2)), null);
  }
  
  public QMNetworkRequest moveMails(int paramInt1, String[] paramArrayOfString, int paramInt2)
  {
    String str = StringExtention.replaceWithEncodeURIValue("ef=js&t=mobile_mgr.json&mailaction=mail_move&destfolderid=$destid$", "destid", String.valueOf(this.folderMgr.getFolder(paramInt2).getRemoteId()));
    return CGIManager.httpPost(paramInt1, "mail_mgr", str + getMailIdParams(paramArrayOfString), null);
  }
  
  public void preloadMails(int paramInt, ArrayList<Mail> paramArrayList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(((Mail)paramArrayList.next()).getInformation().getRemoteId());
    }
    preloadMails(paramInt, (String[])localArrayList.toArray(new String[0]), paramBoolean);
  }
  
  public void preloadMails(int paramInt, String[] paramArrayOfString, boolean paramBoolean)
  {
    Object localObject = MailManagerDefines.PARAM_READMAIL_PREFIX_DATA + "&s=read&showreplyhead=1&disptype=html&nofold=true";
    localObject = (String)localObject + "&mode=pre&mailprefetch=1";
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(StringExtention.replaceWithEncodeURIValue("&mailid=$id$", "id", paramArrayOfString[i]));
      i += 1;
    }
    paramArrayOfString = (String)localObject + localStringBuilder;
    localObject = new QMCallback();
    ((QMCallback)localObject).setOnSuccess(new QMMailCGIManager.27(this, paramInt));
    CGIManager.httpGet(paramInt, "readmail", paramArrayOfString, paramBoolean, (QMCallback)localObject);
  }
  
  public void preloadSubscribes(int paramInt1, int paramInt2)
  {
    Cursor localCursor = this.sqliteHelper.mail.getUnloadSubscribeMails(this.sqliteHelper.getReadableDatabase(), paramInt1, paramInt2);
    Iterator localIterator = QMMailSQLite.getMailsFromCursor(localCursor).iterator();
    while (localIterator.hasNext()) {
      subscribeMails(paramInt1, (Mail)localIterator.next(), true);
    }
    localCursor.close();
  }
  
  public void recallMail(int paramInt, long paramLong, MailManagerDelegate paramMailManagerDelegate)
  {
    String str1 = "recall_mail_" + paramLong;
    if (RequestFilter.isRequestOnRunning(str1))
    {
      if (paramMailManagerDelegate != null) {
        paramMailManagerDelegate.handleComplete(null);
      }
      return;
    }
    RequestFilter.setRequestRunningState(str1);
    String str2 = StringExtention.replaceWithEncodeURIValue(MailManagerDefines.PARAM_PREFIX_SEND_STATUS + "&f=xhtml&s=mailrecallv2&mailid=$id$", "id", String.valueOf(this.sqliteHelper.mail.getRemoteIds(this.sqliteHelper.getReadableDatabase(), new long[] { paramLong })[0]));
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnBeforeSend(new QMMailCGIManager.50(this, paramMailManagerDelegate, paramLong));
    localQMCallback.setOnSuccess(new QMMailCGIManager.51(this, paramLong, paramMailManagerDelegate));
    localQMCallback.setOnError(new QMMailCGIManager.52(this, paramLong, paramMailManagerDelegate));
    localQMCallback.setOnComplete(new QMMailCGIManager.53(this, paramMailManagerDelegate, str1));
    CGIManager.httpGet(paramInt, "send_status", str2, localQMCallback);
  }
  
  public void recallMailQuery(int paramInt, long paramLong1, long paramLong2, MailManagerDelegate paramMailManagerDelegate)
  {
    String str = "recall_mail_query_" + paramLong1;
    if (RequestFilter.isRequestOnRunning(str))
    {
      if (paramMailManagerDelegate != null) {
        paramMailManagerDelegate.handleComplete(null);
      }
      return;
    }
    RequestFilter.setRequestRunningState(str);
    Object localObject1 = this.sqliteHelper.mail.getRemoteIds(this.sqliteHelper.getReadableDatabase(), new long[] { paramLong1 });
    Object localObject2 = MailManagerDefines.PARAM_PREFIX_SEND_STATUS;
    if (paramLong2 != 0L) {}
    for (localObject1 = StringExtention.replaceWithEncodeURIValue(StringExtention.replaceWithEncodeURIValue((String)localObject2 + "&f=xhtml&s=mailrecall_queryv2&mailid=$id$&taskid=$taskid$", "id", String.valueOf(localObject1[0])), "taskid", String.valueOf(paramLong2));; localObject1 = StringExtention.replaceWithEncodeURIValue((String)localObject2 + "&f=xhtml&s=mailrecall_queryv2&mailid=$id$", "id", String.valueOf(localObject1[0])))
    {
      localObject2 = new QMCallback();
      ((QMCallback)localObject2).setOnBeforeSend(new QMMailCGIManager.54(this, paramMailManagerDelegate, paramLong1));
      ((QMCallback)localObject2).setOnSuccess(new QMMailCGIManager.55(this, paramLong1, paramMailManagerDelegate));
      ((QMCallback)localObject2).setOnError(new QMMailCGIManager.56(this, paramMailManagerDelegate, paramLong1));
      ((QMCallback)localObject2).setOnComplete(new QMMailCGIManager.57(this, paramMailManagerDelegate, str));
      CGIManager.httpGet(paramInt, "send_status", (String)localObject1, (QMCallback)localObject2);
      return;
    }
  }
  
  public QMNetworkRequest rejectGroupMails(int paramInt, SparseArray<String> paramSparseArray)
  {
    return CGIManager.httpPost(paramInt, "mail_mgr", "ef=js&t=mobile_mgr.json&mailaction=mail_spam&isspam=true&s=readmail_reject&s_reject_what=10&location=readmail&srcfolderid=1" + _getRejectGroupParams(paramSparseArray), null);
  }
  
  public QMNetworkRequest rejectMails(int paramInt, String[] paramArrayOfString)
  {
    return CGIManager.httpPost(paramInt, "mail_mgr", "ef=js&t=mobile_mgr.json&mailaction=mail_spam&isspam=true&s=readmail_reject&s_reject_what=10&location=readmail&srcfolderid=1" + getMailIdParams(paramArrayOfString), null);
  }
  
  public boolean removeFolder(int paramInt, String paramString1, String paramString2, FolderOperationCallback paramFolderOperationCallback)
  {
    paramString1 = MailManagerDefines.PARAM_PREFIX_FOLDERMGR + "&folderid=$folderid$&savefolderid=$savefolderid$&fun=delete".replace("$folderid$", paramString1).replace("$savefolderid$", paramString2);
    return folder_mgr(QMFolderManager.FolderOperationType.REMOVE_FOLDER, paramInt, paramString1, null, paramFolderOperationCallback);
  }
  
  public boolean removeTag(int paramInt, String paramString, FolderOperationCallback paramFolderOperationCallback)
  {
    paramString = MailManagerDefines.PARAM_PREFIX_FOLDERMGR + "&tagid=$tagid$&fun=deltag".replace("$tagid$", paramString);
    return folder_mgr(QMFolderManager.FolderOperationType.REMOVE_TAG, paramInt, paramString, null, paramFolderOperationCallback);
  }
  
  public boolean renameFolder(int paramInt, String paramString1, String paramString2, FolderOperationCallback paramFolderOperationCallback)
  {
    paramString1 = MailManagerDefines.PARAM_PREFIX_FOLDERMGR + "&folderid=$folderid$&name=$foldername$&fun=rename".replace("$folderid$", paramString1).replace("$foldername$", URLEncoder.encode(paramString2));
    return folder_mgr(QMFolderManager.FolderOperationType.RENAME_FOLDER, paramInt, paramString1, paramString2, paramFolderOperationCallback);
  }
  
  public boolean renameTag(int paramInt, String paramString1, String paramString2, FolderOperationCallback paramFolderOperationCallback)
  {
    paramString1 = MailManagerDefines.PARAM_PREFIX_FOLDERMGR + "&tagid=$tagid$&tagname=$tagname$&fun=renametag".replace("$tagid$", paramString1).replace("$tagname$", URLEncoder.encode(paramString2));
    return folder_mgr(QMFolderManager.FolderOperationType.RENAME_TAG, paramInt, paramString1, paramString2, paramFolderOperationCallback);
  }
  
  public QMNetworkRequest searchMails(QMSearchCursor paramQMSearchCursor, SearchInfo paramSearchInfo, SearchMailQueueHandler.SearchMailCallback paramSearchMailCallback, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder(MailManagerDefines.PARAM_MAIL_LIST_PREFIX_DATA);
    localStringBuilder.append("&s=search&cursorsearch=1&cursorcount=20&pagesize=20&decsub=1");
    ArrayList localArrayList;
    if (paramBoolean) {
      localArrayList = new ArrayList();
    }
    for (boolean bool = QMMailUrlBuilder.getIncrementalUrl(localStringBuilder, new QMSortedSearchCursor(paramQMSearchCursor), localArrayList, true);; bool = false)
    {
      if ((!paramBoolean) || (!bool)) {
        QMSearchCursor.Util.appendPageUrl(localStringBuilder, paramQMSearchCursor.getLastRemoteItem(paramSearchInfo.getAccountId()));
      }
      QMSearchCursor.Util.appendLockUrl(localStringBuilder, paramSearchInfo.getAccountId());
      int i = paramSearchInfo.getFlag();
      if (paramSearchInfo.getSearchType() == 3) {
        localStringBuilder.append("&folderid=$id$&flag=&tagid=".replace("$id$", "all"));
      }
      try
      {
        if (paramSearchInfo.getSearchType() == 3) {}
        for (paramQMSearchCursor = paramSearchInfo.getKeyword();; paramQMSearchCursor = StringExtention.urlEncode(paramSearchInfo.getKeyword()))
        {
          if (paramSearchInfo.getSearchType() != 4) {
            break label509;
          }
          localStringBuilder.append("&searchmode=advance&subject=$keyword$&sender=&receiver=".replace("$keyword$", paramQMSearchCursor));
          paramQMSearchCursor = new QMCallback();
          paramQMSearchCursor.setOnError(new QMMailCGIManager.45(this, paramSearchMailCallback, paramSearchInfo));
          paramQMSearchCursor.setOnSuccess(new QMMailCGIManager.46(this, paramSearchMailCallback, paramSearchInfo));
          return CGIManager.httpGet(paramSearchInfo.getAccountId(), "mail_list", localStringBuilder.toString(), paramQMSearchCursor);
          if (i == -2)
          {
            localStringBuilder.append("&folderid=all&flag=star&tagid=");
            break;
          }
          if (i == -9)
          {
            localStringBuilder.append("&folderid=all&flag=new&tagid=");
            break;
          }
          if (i == -3)
          {
            localStringBuilder.append("&folderid=all&flag=vip&tagid=");
            break;
          }
          if (paramSearchInfo.getArea() == 8)
          {
            if ((paramSearchInfo.getTagIds() == null) || (paramSearchInfo.getTagIds().length <= 0)) {
              break;
            }
            localStringBuilder.append("&folderid=all&flag=tag&tagid=$id$".replace("$id$", this.folderMgr.getFolder(Integer.parseInt(paramSearchInfo.getTagIds()[0])).getRemoteId()));
            break;
          }
          if (paramSearchInfo.getFolderIds().length > 1)
          {
            localStringBuilder.append("&folderid=$id$&flag=&tagid=".replace("$id$", "all"));
            break;
          }
          if (paramSearchInfo.getFolderIds().length != 1) {
            break;
          }
          paramQMSearchCursor = this.folderMgr.getFolder(Integer.parseInt(paramSearchInfo.getFolderIds()[0]));
          localStringBuilder.append("&folderid=$id$&flag=&tagid=".replace("$id$", paramQMSearchCursor.getRemoteId()));
          if ((paramQMSearchCursor.getType() != 1) || (!QMSettingManager.sharedInstance().getAggregateSubscribeMail())) {
            break;
          }
          paramQMSearchCursor = this.folderMgr.getFoldersByAccountAndType(paramQMSearchCursor.getAccountId(), 15);
          if ((paramQMSearchCursor == null) || (paramQMSearchCursor.size() <= 0) || (paramQMSearchCursor.get(0) == null)) {
            break;
          }
          localStringBuilder.append("&folderid=");
          localStringBuilder.append(((QMFolder)paramQMSearchCursor.get(0)).getRemoteId());
          break;
        }
      }
      catch (UnsupportedEncodingException paramQMSearchCursor)
      {
        for (;;)
        {
          paramQMSearchCursor.printStackTrace();
          paramQMSearchCursor = paramSearchInfo.getKeyword();
          continue;
          label509:
          if (paramSearchInfo.getSearchType() == 1) {
            localStringBuilder.append("&searchmode=advance&sender=$keyword$&receiver=&subject=".replace("$keyword$", paramQMSearchCursor));
          } else if (paramSearchInfo.getSearchType() == 2) {
            localStringBuilder.append("&searchmode=advance&receiver=$keyword$&subject=&sender=".replace("$keyword$", paramQMSearchCursor));
          } else if (paramSearchInfo.getSearchType() == 3) {
            localStringBuilder.append("&searchmode=advance$keyword$&subject=".replace("$keyword$", paramQMSearchCursor));
          } else {
            localStringBuilder.append("&subject=$keyword$".replace("$keyword$", paramQMSearchCursor));
          }
        }
      }
    }
  }
  
  public void setFolderTop(int paramInt, QMFolder paramQMFolder, MailManagerDelegate paramMailManagerDelegate)
  {
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new QMMailCGIManager.6(this, paramMailManagerDelegate));
    localQMCallback.setOnError(new QMMailCGIManager.7(this, paramMailManagerDelegate));
    CGIManager.httpGet(paramInt, "mobile_syn", StringExtention.replace("setfoldertop=$folderid$", "folderid", generateRemoteIdForTop(paramQMFolder)), localQMCallback);
  }
  
  public void setMailReminder(Mail paramMail, String paramString, int paramInt1, int paramInt2)
  {
    int i = paramMail.getInformation().getAccountId();
    paramMail = "t=remind_setting.json&fun=$fun&ahead=$ahead&mailid=$mailid&open=$open".replace("$mailid", paramMail.getInformation().getRemoteId()).replace("$fun", paramString).replace("$ahead", paramInt1 + "").replace("$open", paramInt2 + "");
    paramString = new QMCallback();
    paramString.setOnSuccess(new QMMailCGIManager.33(this));
    paramString.setOnError(new QMMailCGIManager.34(this));
    CGIManager.httpGet(i, "remind_setting", paramMail, paramString);
  }
  
  public void setMailReminderRequestState(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    QMLog.log(4, "QMMailCGIManager", "setMailReminderRequestState accountId = " + paramInt1 + " dialog = " + paramInt2 + " agree = " + paramInt3);
    if (paramBoolean) {}
    for (String str = "t=remind_setting.json&fun=setflag&credit_agree=$agree&credit_dialog=$dialog";; str = "t=remind_setting.json&fun=setflag&credit_agree=$agree&credit_dialog=$dialog".replace("$dialog", paramInt2 + "").replace("$agree", paramInt3 + ""))
    {
      QMCallback localQMCallback = new QMCallback();
      localQMCallback.setOnSuccess(new QMMailCGIManager.37(this));
      localQMCallback.setOnError(new QMMailCGIManager.38(this));
      CGIManager.httpGet(paramInt1, "remind_setting", str, localQMCallback);
      return;
    }
  }
  
  public void setOnlyPushMailApp(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("&pushapponly=");
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      CGIManager.httpPost(paramInt, "app_push_setting", str, null);
      return;
    }
  }
  
  public void shareCalendarFolder(int paramInt, String paramString, String[] paramArrayOfString, QMVerify paramQMVerify, MailManagerDelegate paramMailManagerDelegate)
  {
    String str = "fun=mail_share&easid=$easid$" + paramString + "_" + StringUtils.join(paramArrayOfString, "^");
    if (RequestFilter.isRequestOnRunning(str)) {
      return;
    }
    RequestFilter.setRequestRunningState(str);
    if (paramQMVerify != null) {}
    for (Object localObject = StringExtention.replaceWithEncodeURIValue(StringExtention.replaceWithEncodeURIValue(StringExtention.replaceWithEncodeURIValue(StringExtention.replaceWithEncodeURIValue(StringExtention.replaceWithEncodeURIValue("fun=mail_share&easid=$easid$&verifycode=$verifycode$&verifykey=$verifykey$&mverifysession=$mverifysession$&qm_authimgs_id=$qm_authimgs_id$", "easid", String.valueOf(paramString)), "verifycode", String.valueOf(paramQMVerify.getVerifyCode())), "verifykey", String.valueOf(paramQMVerify.getVerifyKey())), "mverifysession", String.valueOf(paramQMVerify.getVerifySession())), "qm_authimgs_id", String.valueOf(paramQMVerify.getAuthImagesId()));; localObject = StringExtention.replaceWithEncodeURIValue("fun=mail_share&easid=$easid$", "easid", String.valueOf(paramString)))
    {
      paramArrayOfString = (String)localObject + getTouserParams(paramArrayOfString);
      localObject = new QMCallback();
      ((QMCallback)localObject).setOnBeforeSend(new QMMailCGIManager.65(this, paramMailManagerDelegate, paramString));
      ((QMCallback)localObject).setOnSuccess(new QMMailCGIManager.66(this, paramMailManagerDelegate));
      ((QMCallback)localObject).setOnError(new QMMailCGIManager.67(this, paramMailManagerDelegate, paramQMVerify));
      ((QMCallback)localObject).setOnComplete(new QMMailCGIManager.68(this, paramMailManagerDelegate, str));
      CGIManager.httpGet(paramInt, "calendar", paramArrayOfString, (QMCallback)localObject);
      return;
    }
  }
  
  public QMNetworkRequest spamMails(int paramInt, String[] paramArrayOfString)
  {
    return CGIManager.httpPost(paramInt, "mail_mgr", "ef=js&t=mobile_mgr.json&mailaction=mail_spam&reporttype=$spamid$&isspam=true" + getMailIdParams(paramArrayOfString), null);
  }
  
  public QMNetworkRequest starMails(int paramInt, boolean paramBoolean, String[] paramArrayOfString)
  {
    String str = StringExtention.replaceWithEncodeURIValue("ef=js&t=mobile_mgr.json&mailaction=mail_flag&flag=star&status=$status$", "status", getStatus(paramBoolean));
    return CGIManager.httpPost(paramInt, "mail_mgr", str + getMailIdParams(paramArrayOfString), null);
  }
  
  public QMNetworkRequest subscribeMails(int paramInt, Mail paramMail)
  {
    return subscribeMails(paramInt, paramMail, false);
  }
  
  public boolean sync(int paramInt, Runnable paramRunnable)
  {
    String str2 = "sync_" + paramInt;
    if (RequestFilter.isRequestOnRunning(str2))
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      return false;
    }
    RequestFilter.setRequestRunningState(str2);
    long l = QMSettingManager.sharedInstance().getAddrVipLoadUTC(paramInt);
    boolean bool = QMSettingManager.sharedInstance().isBottleEnabled();
    int i = QMSettingManager.sharedInstance().getDefaultBottleAccountID();
    String str1;
    if ((bool) && (i == paramInt))
    {
      i = 1;
      Object localObject = new StringBuilder().append(MailManagerDefines.PARAM_PREFIX_DATA).append("&s=syn&folder=1&set=1&note=1&app=yes").append("&ntup=").append(0).append("&verupdate=$update$".replace("$update$", AppConfig.getCodeVersionName())).append("&addrupt=").append(l).append("&plpunread=$unreadBit$".replace("$unreadBit$", "" + i));
      if (!AppStatusUtil.isAppOnForeground()) {
        break label305;
      }
      str1 = "0";
      label183:
      str1 = "&isbackground=$isBackground$".replace("$isBackground$", str1);
      localObject = new QMCallback();
      ((QMCallback)localObject).setOnBeforeSend(new QMMailCGIManager.1(this, paramInt));
      ((QMCallback)localObject).setOnSuccess(new QMMailCGIManager.2(this, paramInt, l));
      ((QMCallback)localObject).setOnError(new QMMailCGIManager.3(this, paramInt));
      ((QMCallback)localObject).setOnComplete(new QMMailCGIManager.4(this, str2, paramInt, paramRunnable));
      CGIManager.httpGet(paramInt, "mobile_syn", str1, (QMCallback)localObject);
      if (!AppStatusUtil.isAppOnForeground()) {
        break label313;
      }
      KvHelper.mobileSyncF(new double[0]);
    }
    for (;;)
    {
      return true;
      i = 0;
      break;
      label305:
      str1 = "1";
      break label183;
      label313:
      KvHelper.mobileSyncB(new double[0]);
    }
  }
  
  public void syncFolderOrder(int paramInt, List<QMFolder> paramList, MailManagerDelegate paramMailManagerDelegate)
  {
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new QMMailCGIManager.8(this, paramMailManagerDelegate));
    localQMCallback.setOnError(new QMMailCGIManager.9(this, paramMailManagerDelegate));
    paramMailManagerDelegate = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramMailManagerDelegate.append(generateRemoteIdForTop((QMFolder)paramList.next())).append("_");
    }
    paramMailManagerDelegate.deleteCharAt(paramMailManagerDelegate.length() - 1);
    CGIManager.httpGet(paramInt, "mobile_syn", StringExtention.replace("foldertop=$foldertop$", "foldertop", paramMailManagerDelegate.toString()), localQMCallback);
  }
  
  public List<QMNetworkRequest> tagMails(int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0)) {
      localArrayList.add(execTag(paramInt, "add", paramArrayOfString1, paramArrayOfString2));
    }
    if ((paramArrayOfString3 != null) && (paramArrayOfString3.length > 0)) {
      localArrayList.add(execTag(paramInt, "del", paramArrayOfString1, paramArrayOfString3));
    }
    return localArrayList;
  }
  
  public QMNetworkRequest unSubscribeMails(int paramInt, String[] paramArrayOfString)
  {
    return CGIManager.httpPost(paramInt, "setting10", "ef=js&t=mobile_mgr.json&action=desubscribe" + _getColIdParams(paramArrayOfString), null);
  }
  
  public void unlockFolder(int paramInt1, int paramInt2, String paramString)
  {
    String str = StringExtention.replaceWithEncodeURIValue("ef=js&t=mobile_mgr.json&fun=checkpwd&p=$pwd$", "pwd", RsaEncryption.encryptPwdBeforeSend(paramString));
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new QMMailCGIManager.48(this, paramString, paramInt1, paramInt2));
    localQMCallback.setOnError(new QMMailCGIManager.49(this, paramInt1, paramInt2));
    CGIManager.httpGet(paramInt1, "foldermgr", str, localQMCallback);
  }
  
  public QMNetworkRequest unreadMails(int paramInt, boolean paramBoolean1, String[] paramArrayOfString, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (paramBoolean2)) {}
    for (String str = "ef=js&t=mobile_mgr.json&mailaction=mail_flag&flag=new&status=$status$&isBatch=1";; str = "ef=js&t=mobile_mgr.json&mailaction=mail_flag&flag=new&status=$status$")
    {
      str = StringExtention.replaceWithEncodeURIValue(str, "status", getStatus(paramBoolean1));
      return CGIManager.httpPost(paramInt, "mail_mgr", str + getMailIdParams(paramArrayOfString), null);
    }
  }
  
  public QMNetworkRequest unreadSubscribe(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "mail_flagunread";; str = "read_all") {
      return CGIManager.httpPost(paramInt, "mail_mgr", StringExtention.replace(StringExtention.replace("ef=js&t=mobile_mgr.json&mailaction=$isUnread$&folderid=$folderId$", "isUnread", str), "folderId", this.folderMgr.getFolder(this.folderMgr.getQQMailSubFolderId(paramInt)).getRemoteId()), null);
    }
  }
  
  public void unsetFolderTop(int paramInt, QMFolder paramQMFolder, MailManagerDelegate paramMailManagerDelegate)
  {
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new QMMailCGIManager.10(this, paramMailManagerDelegate));
    localQMCallback.setOnError(new QMMailCGIManager.11(this, paramMailManagerDelegate));
    CGIManager.httpGet(paramInt, "mobile_syn", StringExtention.replace("unsetfoldertop=$folderid$", "folderid", generateRemoteIdForTop(paramQMFolder)), localQMCallback);
  }
  
  public void updateFolderPushStatus(int paramInt, String[] paramArrayOfString, boolean[] paramArrayOfBoolean)
  {
    String str = "";
    int i = 0;
    if (i < paramArrayOfString.length)
    {
      if (paramArrayOfBoolean[i] != 0) {}
      for (str = str + "&flist=" + paramArrayOfString[i] + "|1";; str = str + "&flist=" + paramArrayOfString[i] + "|0")
      {
        i += 1;
        break;
      }
    }
    CGIManager.httpPost(paramInt, "app_push_setting", str, null);
  }
  
  public void updateList(QMFolder paramQMFolder, boolean paramBoolean)
  {
    updateList(paramQMFolder, paramBoolean, null);
  }
  
  public void updateList(QMFolder paramQMFolder, boolean paramBoolean, IListCallback paramIListCallback)
  {
    updateList(paramQMFolder, paramBoolean, false, -1, paramIListCallback);
  }
  
  public void updateList(QMFolder paramQMFolder, boolean paramBoolean1, boolean paramBoolean2, int paramInt, IListCallback paramIListCallback)
  {
    String str = "update_list_" + paramQMFolder.getId();
    if ((RequestFilter.isRequestOnRunning(str)) || (RequestFilter.isRequestOnRunning("update_list_all_" + paramQMFolder.getAccountId())))
    {
      QMLog.log(5, "QMMailCGIManager", "updateList, isRequesting, folder: " + paramQMFolder);
      if (paramIListCallback != null) {
        paramIListCallback.success(new long[0], false);
      }
      return;
    }
    RequestFilter.setRequestRunningState(str);
    Integer localInteger;
    if (paramQMFolder.getType() == 17) {
      localInteger = Integer.valueOf(-3);
    }
    for (;;)
    {
      Threads.runInBackground(new QMMailCGIManager.19(this, paramQMFolder, paramInt, paramIListCallback, localInteger, paramBoolean2, paramBoolean1, str));
      return;
      if (paramQMFolder.getType() == 18) {
        localInteger = Integer.valueOf(-9);
      } else if (paramQMFolder.getType() == 16) {
        localInteger = Integer.valueOf(-2);
      } else {
        localInteger = Integer.valueOf(paramQMFolder.getId());
      }
    }
  }
  
  public void voteGroupMail(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, QMCallback paramQMCallback)
  {
    paramString1 = StringExtention.replaceWithEncodeURIValue(StringExtention.replaceWithEncodeURIValue(StringExtention.replaceWithEncodeURIValue(StringExtention.replaceWithEncodeURIValue("&s=groupsend&vote=$voteOpionId$&mailid=$groupMailId$&actiontype=vote&groupid=$groupId$&topicid=$topicId$", "voteOpionId", paramString4), "groupMailId", paramString1), "groupId", paramString2), "topicId", paramString3);
    CGIManager.httpPost(paramInt, "groupmail_send", "ef=js&t=mobile_mgr.json" + paramString1, paramQMCallback);
  }
  
  static abstract interface IDelMailAfterSync
  {
    public abstract void run(long[] paramArrayOfLong, boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager
 * JD-Core Version:    0.7.0.1
 */