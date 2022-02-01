package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.qmdomain.QMOffLineOperation;
import com.tencent.qqmail.protocol.CloudProtocolHelper;
import com.tencent.qqmail.protocol.CloudProtocolInfo;
import com.tencent.qqmail.protocol.CloudProtocolInfo.UserSettingA;
import com.tencent.qqmail.protocol.UMA.UserSetting.Account;
import com.tencent.qqmail.protocol.UMA.UserSetting.Global;
import com.tencent.qqmail.trd.guava.Joiner;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QMOfflineOperationManager
{
  public static final String TAG = "QMOfflineOperationManager";
  private static QMOfflineOperationManager _instance;
  private QMMailCGIManager cgiMgr;
  private QMMailProtocolManager protocolMgr;
  private QMMailSQLiteHelper sqliteHelper;
  
  private QMOfflineOperationManager(QMMailSQLiteHelper paramQMMailSQLiteHelper, QMMailCGIManager paramQMMailCGIManager, QMMailProtocolManager paramQMMailProtocolManager)
  {
    this.sqliteHelper = paramQMMailSQLiteHelper;
    this.cgiMgr = paramQMMailCGIManager;
    this.protocolMgr = paramQMMailProtocolManager;
  }
  
  public static QMOfflineOperationManager createInstance(QMMailSQLiteHelper paramQMMailSQLiteHelper, QMMailCGIManager paramQMMailCGIManager, QMMailProtocolManager paramQMMailProtocolManager)
  {
    if (_instance == null) {
      _instance = new QMOfflineOperationManager(paramQMMailSQLiteHelper, paramQMMailCGIManager, paramQMMailProtocolManager);
    }
    return _instance;
  }
  
  private List<String> getOfflineOperMailId(List<QMOffLineOperation> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localArrayList.add(((QMOffLineOperation)paramList.get(i)).getMailid());
      i += 1;
    }
    return localArrayList;
  }
  
  private List<String> getOfflineOperSvrKey(List<QMOffLineOperation> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localArrayList.add(((QMOffLineOperation)paramList.get(i)).getSvrKey());
      i += 1;
    }
    return localArrayList;
  }
  
  private UserSetting.Account getProtoAccount(int paramInt, HashMap<Integer, UserSetting.Account> paramHashMap)
  {
    if (paramHashMap.containsKey(Integer.valueOf(paramInt))) {
      return (UserSetting.Account)paramHashMap.get(Integer.valueOf(paramInt));
    }
    UserSetting.Account localAccount = new UserSetting.Account();
    localAccount.set_account_id(paramInt);
    paramHashMap.put(Integer.valueOf(paramInt), localAccount);
    return localAccount;
  }
  
  private void handleAccountOpers(List<QMOffLineOperation> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    Account localAccount;
    String str;
    do
    {
      return;
      int i = ((QMOffLineOperation)paramList.get(0)).getType();
      int j = ((QMOffLineOperation)paramList.get(0)).getAccountId();
      localAccount = AccountManager.shareInstance().getAccountList().getAccountById(j);
      switch (i)
      {
      default: 
        return;
      case 0: 
        handleUnread(paramList, localAccount);
        return;
      case 1: 
        handleStar(paramList, localAccount);
        return;
      case 2: 
        str = ((QMOffLineOperation)paramList.get(0)).getParam();
      }
    } while (str == null);
    if (str.toString().equals("1"))
    {
      handleDel(paramList, localAccount);
      return;
    }
    if (str.toString().equals("0"))
    {
      handleReject(paramList, localAccount, str.toString().equals("0"));
      return;
    }
    if (str.toString().equals("2"))
    {
      handleSpam(paramList, localAccount);
      return;
    }
    handleMove(paramList, localAccount);
    return;
    handleTag(paramList, localAccount);
    return;
    handleDel(paramList, localAccount);
    return;
    handlePushFolder(paramList, localAccount);
    return;
    handleOnlyPushMailApp(paramList, localAccount);
    return;
    handleNotifyProtocolAccountMail(paramList, localAccount);
    return;
    handleNotifyCalendarReminderMail(paramList, localAccount);
  }
  
  private void handleBatch(List<QMOffLineOperation> paramList)
  {
    if (paramList == null) {
      QMLog.log(5, "QMOfflineOperationManager", "handleBatch opers null");
    }
    ArrayList localArrayList;
    label64:
    do
    {
      return;
      Object localObject1 = null;
      localArrayList = new ArrayList();
      int i = 0;
      if (i < paramList.size())
      {
        Object localObject2;
        if (i == 0)
        {
          localObject2 = (QMOffLineOperation)paramList.get(0);
          localObject1 = (QMOffLineOperation)paramList.get(0);
          if ((((QMOffLineOperation)localObject2).getAccountId() != ((QMOffLineOperation)localObject1).getAccountId()) || (((QMOffLineOperation)localObject2).getFolderId() != ((QMOffLineOperation)localObject1).getFolderId()) || (((QMOffLineOperation)localObject2).getType() != ((QMOffLineOperation)localObject1).getType()) || (!((QMOffLineOperation)localObject2).getParam().equals(((QMOffLineOperation)localObject1).getParam()))) {
            break label158;
          }
          localArrayList.add(localObject1);
        }
        for (;;)
        {
          i += 1;
          break;
          QMOffLineOperation localQMOffLineOperation = (QMOffLineOperation)paramList.get(i);
          localObject2 = localObject1;
          localObject1 = localQMOffLineOperation;
          break label64;
          handleAccountOpers(localArrayList);
          localArrayList = new ArrayList();
          localArrayList.add(localObject1);
          try
          {
            Thread.sleep(1000L);
          }
          catch (InterruptedException localInterruptedException) {}
        }
      }
    } while ((localArrayList == null) || (localArrayList.size() == 0));
    label158:
    handleAccountOpers(localArrayList);
  }
  
  private void handleDel(List<QMOffLineOperation> paramList, Account paramAccount)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    List localList = getOfflineOperMailId(paramList);
    boolean bool = Boolean.valueOf(((QMOffLineOperation)paramList.get(0)).getParam()).booleanValue();
    int i = ((QMOffLineOperation)paramList.get(0)).getFolderId();
    if (paramAccount.isQQMail())
    {
      this.cgiMgr.deleteMails(paramAccount.getId(), bool, (String[])localList.toArray(new String[localList.size()]), null);
      return;
    }
    if (bool)
    {
      paramList = QMFolderManager.sharedInstance().getFolder(i);
      this.protocolMgr.removeMails(paramAccount, paramList, localList, null, null);
      return;
    }
    paramList = getOfflineOperSvrKey(paramList);
    int j = QMFolderManager.sharedInstance().getTrashFolderId(paramAccount.getId());
    QMFolder localQMFolder1 = QMFolderManager.sharedInstance().getFolder(i);
    QMFolder localQMFolder2 = QMFolderManager.sharedInstance().getFolder(j);
    this.protocolMgr.moveMails(paramAccount, localQMFolder1, localQMFolder2, localList, paramList, null);
  }
  
  private void handleMove(List<QMOffLineOperation> paramList, Account paramAccount)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    List localList = getOfflineOperMailId(paramList);
    int i = Integer.parseInt(((QMOffLineOperation)paramList.get(0)).getParam());
    int j = ((QMOffLineOperation)paramList.get(0)).getFolderId();
    if (paramAccount.isQQMail())
    {
      this.cgiMgr.moveMails(paramAccount.getId(), (String[])localList.toArray(new String[localList.size()]), i);
      return;
    }
    paramList = getOfflineOperSvrKey(paramList);
    QMFolder localQMFolder1 = QMFolderManager.sharedInstance().getFolder(j);
    QMFolder localQMFolder2 = QMFolderManager.sharedInstance().getFolder(i);
    this.protocolMgr.moveMails(paramAccount, localQMFolder1, localQMFolder2, localList, paramList, null);
  }
  
  private void handleNotifyCalendarReminderMail(List<QMOffLineOperation> paramList, Account paramAccount)
  {
    if ((paramList == null) || (paramList.size() <= 0) || (paramAccount == null)) {
      return;
    }
    paramList = (QMOffLineOperation)paramList.get(0);
    QMMailManager.sharedInstance().setNotifyCalendarReminderMail(paramAccount.getId(), Boolean.valueOf(paramList.getParam()).booleanValue());
  }
  
  private void handleNotifyProtocolAccountMail(List<QMOffLineOperation> paramList, Account paramAccount)
  {
    if ((paramList == null) || (paramList.size() <= 0) || (paramAccount == null)) {
      return;
    }
    paramList = (QMOffLineOperation)paramList.get(0);
    QMMailManager.sharedInstance().setNotifyProtocolAccountMail(paramAccount.getId(), Boolean.valueOf(paramList.getParam()).booleanValue());
  }
  
  private void handleOnlyPushMailApp(List<QMOffLineOperation> paramList, Account paramAccount)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    paramList = (QMOffLineOperation)paramList.get(0);
    QMMailManager.sharedInstance().setOnlyPushMailApp(paramAccount.getId(), Boolean.valueOf(paramList.getParam()).booleanValue());
  }
  
  private void handlePushFolder(List<QMOffLineOperation> paramList, Account paramAccount)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    paramList = ((QMOffLineOperation)paramList.get(0)).getParam().split("&");
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.length)
    {
      localStringBuilder.append("&flist=").append(paramList[i]);
      i += 1;
    }
    CGIManager.httpPost(paramAccount.getId(), "app_push_setting", localStringBuilder.toString(), null);
  }
  
  private void handleReject(List<QMOffLineOperation> paramList, Account paramAccount, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    List localList1 = getOfflineOperMailId(paramList);
    if (paramAccount.isQQMail())
    {
      this.cgiMgr.rejectMails(paramAccount.getId(), (String[])localList1.toArray(new String[localList1.size()]));
      return;
    }
    List localList2 = getOfflineOperSvrKey(paramList);
    paramList = QMFolderManager.sharedInstance().getFolder(((QMOffLineOperation)paramList.get(0)).getFolderId());
    int i = QMFolderManager.sharedInstance().getInboxFolderId(paramAccount.getId());
    int j = QMFolderManager.sharedInstance().getTrashFolderId(paramAccount.getId());
    Object localObject = QMFolderManager.sharedInstance();
    if (paramBoolean) {
      i = j;
    }
    for (;;)
    {
      localObject = ((QMFolderManager)localObject).getFolder(i);
      this.protocolMgr.moveMails(paramAccount, paramList, (QMFolder)localObject, localList1, localList2, null);
      return;
    }
  }
  
  private void handleSpam(List<QMOffLineOperation> paramList, Account paramAccount)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    do
    {
      return;
      paramList = getOfflineOperMailId(paramList);
    } while (!paramAccount.isQQMail());
    this.cgiMgr.spamMails(paramAccount.getId(), (String[])paramList.toArray(new String[paramList.size()]));
  }
  
  private void handleStar(List<QMOffLineOperation> paramList, Account paramAccount)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    List localList = getOfflineOperMailId(paramList);
    boolean bool = Boolean.valueOf(((QMOffLineOperation)paramList.get(0)).getParam()).booleanValue();
    int i = ((QMOffLineOperation)paramList.get(0)).getFolderId();
    if (paramAccount.isQQMail())
    {
      this.cgiMgr.starMails(paramAccount.getId(), bool, (String[])localList.toArray(new String[localList.size()]));
      return;
    }
    paramList = getOfflineOperSvrKey(paramList);
    QMFolder localQMFolder = QMFolderManager.sharedInstance().getFolder(i);
    this.protocolMgr.starMails(paramAccount, localQMFolder, bool, localList, paramList, null);
  }
  
  private void handleTag(List<QMOffLineOperation> paramList, Account paramAccount)
  {
    List localList = getOfflineOperMailId(paramList);
    if ((paramList != null) && (paramList.size() > 0)) {}
    for (String str = ((QMOffLineOperation)paramList.get(0)).getParam();; str = null)
    {
      if (str != null)
      {
        paramList = Pattern.compile("addTagIds:.*?;", 2).matcher(str);
        if (!paramList.find()) {
          break label213;
        }
      }
      label213:
      for (paramList = paramList.group(0).replace("addTagIds:", "").replace(";", "").split(",");; paramList = null)
      {
        if (paramList == null) {}
        for (Object localObject = new String[0];; localObject = paramList)
        {
          paramList = Pattern.compile("deleteTagIds:.*?;", 2).matcher(str);
          if (paramList.find()) {}
          for (paramList = paramList.group(0).replace("deleteTagIds:", "").replace(";", "").split(",");; paramList = null)
          {
            if (paramList == null) {
              paramList = new String[0];
            }
            for (;;)
            {
              if (paramAccount.isQQMail()) {
                this.cgiMgr.tagMails(paramAccount.getId(), (String[])localList.toArray(new String[localList.size()]), (String[])localObject, paramList);
              }
              return;
            }
          }
        }
      }
    }
  }
  
  private void handleUmaSetting(List<QMOffLineOperation> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    CloudProtocolInfo localCloudProtocolInfo;
    do
    {
      return;
      localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    } while (localCloudProtocolInfo == null);
    localCloudProtocolInfo.user_setting_a_ = new CloudProtocolInfo.UserSettingA();
    localCloudProtocolInfo.user_setting_a_.global_ = new UserSetting.Global();
    Object localObject2 = localCloudProtocolInfo.user_setting_a_.global_;
    Object localObject1 = new HashMap();
    int j = 0;
    int k = 0;
    if (j < paramList.size())
    {
      int i = k;
      switch (((QMOffLineOperation)paramList.get(j)).getType())
      {
      default: 
        i = k;
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        ((UserSetting.Global)localObject2).set_use_night_mode(((QMOffLineOperation)paramList.get(j)).getParam().equals("true"));
        i = 1;
        continue;
        ((UserSetting.Global)localObject2).set_only_notify_vip(((QMOffLineOperation)paramList.get(j)).getParam().equals("true"));
        i = 1;
        continue;
        ((UserSetting.Global)localObject2).set_aggregate_ad_mail(((QMOffLineOperation)paramList.get(j)).getParam().equals("true"));
        i = 1;
        continue;
        ((UserSetting.Global)localObject2).set_aggregate_subscribed_mail(((QMOffLineOperation)paramList.get(j)).getParam().equals("true"));
        i = 1;
        continue;
        ((UserSetting.Global)localObject2).set_notify_admail(((QMOffLineOperation)paramList.get(j)).getParam().equals("true"));
        i = 1;
        continue;
        ((UserSetting.Global)localObject2).set_maillist_icon(((QMOffLineOperation)paramList.get(j)).getParam().equals("true"));
        i = 1;
        continue;
        ((UserSetting.Global)localObject2).set_load_pic_function(Integer.parseInt(((QMOffLineOperation)paramList.get(j)).getParam()));
        i = 1;
        continue;
        ((UserSetting.Global)localObject2).set_enable_send_sound(((QMOffLineOperation)paramList.get(j)).getParam().equals("true"));
        i = 1;
        continue;
        ((UserSetting.Global)localObject2).set_gesture_password(((QMOffLineOperation)paramList.get(j)).getParam());
        i = 1;
        continue;
        ((UserSetting.Global)localObject2).set_newmail_shake_onusing(((QMOffLineOperation)paramList.get(j)).getParam().equals("true"));
        i = 1;
        continue;
        ((UserSetting.Global)localObject2).set_enable_sound(((QMOffLineOperation)paramList.get(j)).getParam().equals("true"));
        i = 1;
        continue;
        ((UserSetting.Global)localObject2).set_notify_newmail(((QMOffLineOperation)paramList.get(j)).getParam().equals("true"));
        i = 1;
        continue;
        ((UserSetting.Global)localObject2).set_plp_bind_uin(Long.parseLong(((QMOffLineOperation)paramList.get(j)).getParam()));
        i = 1;
        continue;
        ((UserSetting.Global)localObject2).set_enable_incremental_unread_count(((QMOffLineOperation)paramList.get(j)).getParam().equals("true"));
        i = 1;
        continue;
        Object localObject3 = ((QMOffLineOperation)paramList.get(j)).getParam();
        LinkedList localLinkedList = new LinkedList();
        if (!StringExtention.isNullOrEmpty((String)localObject3))
        {
          localObject3 = ((String)localObject3).split(",");
          if (localObject3.length > 0)
          {
            k = localObject3.length;
            i = 0;
            while (i < k)
            {
              localLinkedList.add(Integer.valueOf(Integer.parseInt(localObject3[i])));
              i += 1;
            }
          }
        }
        ((UserSetting.Global)localObject2).set_application_in_home(localLinkedList);
        i = 1;
        continue;
        ((UserSetting.Global)localObject2).set_enable_notify_detail(((QMOffLineOperation)paramList.get(j)).getParam().equals("true"));
        i = 1;
        continue;
        getProtoAccount(((QMOffLineOperation)paramList.get(j)).getAccountId(), (HashMap)localObject1).set_newmail_push_way(Integer.parseInt(((QMOffLineOperation)paramList.get(j)).getParam()));
        i = 1;
        continue;
        getProtoAccount(((QMOffLineOperation)paramList.get(j)).getAccountId(), (HashMap)localObject1).set_get_newmail_freq(Integer.parseInt(((QMOffLineOperation)paramList.get(j)).getParam()));
        i = 1;
        continue;
        getProtoAccount(((QMOffLineOperation)paramList.get(j)).getAccountId(), (HashMap)localObject1).set_personal_signature(((QMOffLineOperation)paramList.get(j)).getParam());
        i = 1;
        continue;
        getProtoAccount(((QMOffLineOperation)paramList.get(j)).getAccountId(), (HashMap)localObject1).set_sync_mail_count(Integer.parseInt(((QMOffLineOperation)paramList.get(j)).getParam()));
        i = 1;
        continue;
        getProtoAccount(((QMOffLineOperation)paramList.get(j)).getAccountId(), (HashMap)localObject1).set_aggregate_bysubject(((QMOffLineOperation)paramList.get(j)).getParam().equals("true"));
        i = 1;
      }
    }
    if (k == 0)
    {
      QMLog.log(4, "QMOfflineOperationManager", "handleUmaSetting1. no settign to sync.");
      return;
    }
    localObject2 = ((HashMap)localObject1).keySet().iterator();
    paramList = new ArrayList();
    while (((Iterator)localObject2).hasNext()) {
      paramList.add(((HashMap)localObject1).get(Integer.valueOf(((Integer)((Iterator)localObject2).next()).intValue())));
    }
    localObject1 = new UserSetting.Account[paramList.size()];
    localCloudProtocolInfo.user_setting_a_.account_list_ = ((UserSetting.Account[])paramList.toArray((Object[])localObject1));
    QMPrivateProtocolManager.sharedInstance().setUserSetting(localCloudProtocolInfo, new QMOfflineOperationManager.1(this));
  }
  
  private void handleUnread(List<QMOffLineOperation> paramList, Account paramAccount)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    List localList = getOfflineOperMailId(paramList);
    int i = ((QMOffLineOperation)paramList.get(0)).getFolderId();
    boolean bool = Boolean.valueOf(((QMOffLineOperation)paramList.get(0)).getParam()).booleanValue();
    if (paramAccount.isQQMail())
    {
      this.cgiMgr.unreadMails(paramAccount.getId(), bool, (String[])localList.toArray(new String[localList.size()]), false);
      return;
    }
    paramList = getOfflineOperSvrKey(paramList);
    QMFolder localQMFolder = QMFolderManager.sharedInstance().getFolder(i);
    this.protocolMgr.unreadMails(paramAccount, localQMFolder, bool, localList, paramList, null);
  }
  
  private HashMap<String, Boolean> parsePushFolderStr(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if ((paramString == null) || (paramString.equals(""))) {
      return localHashMap;
    }
    paramString = paramString.split("&");
    int i = 0;
    while (i < paramString.length)
    {
      String[] arrayOfString = paramString[i].split("\\|");
      localHashMap.put(arrayOfString[0], Boolean.valueOf(arrayOfString[1].equals("1")));
      i += 1;
    }
    return localHashMap;
  }
  
  private void saveMailOpers(List<String> paramList1, List<String> paramList2, int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    int k = 0;
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (paramList2 != null)
    {
      i = k;
      localObject = paramList2;
      if (paramList2.size() >= paramList1.size()) {}
    }
    else
    {
      localObject = new ArrayList();
      if ((paramList2 == null) || (paramList2.size() <= 0)) {
        break label258;
      }
    }
    label258:
    for (int i = paramList2.size();; i = 0)
    {
      int j = 0;
      if (j < paramList1.size())
      {
        if (j < i) {
          ((List)localObject).add(j, paramList2.get(j));
        }
        for (;;)
        {
          j += 1;
          break;
          ((List)localObject).add(j, "");
        }
      }
      for (;;)
      {
        if (i < paramList1.size())
        {
          paramList2 = new QMOffLineOperation();
          paramList2.setAccountId(paramInt1);
          paramList2.setFolderId(paramInt2);
          paramList2.setType(paramInt3);
          paramList2.setParam(paramObject.toString());
          paramList2.setMailid((String)paramList1.get(i));
          paramList2.setSvrKey((String)((List)localObject).get(i));
          paramList2.setCategory(1);
          localArrayList.add(paramList2);
          i += 1;
        }
        else
        {
          paramList1 = this.sqliteHelper.getWritableDatabase();
          this.sqliteHelper.offLine.insertOperations(paramList1, localArrayList);
          return;
          i = k;
        }
      }
    }
  }
  
  private void saveSettingOpers(int paramInt1, int paramInt2, Object paramObject)
  {
    ArrayList localArrayList = new ArrayList();
    QMOffLineOperation localQMOffLineOperation = new QMOffLineOperation();
    localQMOffLineOperation.setAccountId(paramInt1);
    localQMOffLineOperation.setFolderId(-1);
    localQMOffLineOperation.setMailid("");
    localQMOffLineOperation.setType(paramInt2);
    localQMOffLineOperation.setParam(paramObject.toString());
    localQMOffLineOperation.setCategory(2);
    localArrayList.add(localQMOffLineOperation);
    paramObject = this.sqliteHelper.getWritableDatabase();
    this.sqliteHelper.offLine.insertOperations(paramObject, localArrayList);
  }
  
  private void saveUmaSettingOpers(int paramInt1, int paramInt2, Object paramObject)
  {
    ArrayList localArrayList = new ArrayList();
    QMOffLineOperation localQMOffLineOperation = new QMOffLineOperation();
    localQMOffLineOperation.setAccountId(paramInt1);
    localQMOffLineOperation.setFolderId(-1);
    localQMOffLineOperation.setMailid("");
    localQMOffLineOperation.setType(paramInt2);
    localQMOffLineOperation.setParam(paramObject.toString());
    localQMOffLineOperation.setCategory(3);
    localArrayList.add(localQMOffLineOperation);
    paramObject = this.sqliteHelper.getWritableDatabase();
    this.sqliteHelper.offLine.insertOperations(paramObject, localArrayList);
  }
  
  public static QMOfflineOperationManager shareInstance()
  {
    return _instance;
  }
  
  public Set<String> getOffLineOperTypeOfUMA()
  {
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getReadableDatabase();
    return this.sqliteHelper.offLine.getOffLineOperTypeOfUMA(localSQLiteDatabase);
  }
  
  public void handleOfflineOpers()
  {
    Object localObject = this.sqliteHelper.getReadableDatabase();
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getWritableDatabase();
    List localList1 = this.sqliteHelper.offLine.readMailOper((SQLiteDatabase)localObject);
    List localList2 = this.sqliteHelper.offLine.readDelSpamOpers((SQLiteDatabase)localObject);
    List localList3 = this.sqliteHelper.offLine.readSettingOpers((SQLiteDatabase)localObject);
    localObject = this.sqliteHelper.offLine.readUMASettingOpers((SQLiteDatabase)localObject);
    this.sqliteHelper.offLine.delOffLineOpers(localSQLiteDatabase, new int[] { 1, 2 });
    handleBatch(localList1);
    handleBatch(localList2);
    handleBatch(localList3);
    handleUmaSetting((List)localObject);
  }
  
  public void saveAdMailNotify(boolean paramBoolean)
  {
    saveUmaSettingOpers(-1, 13, Boolean.valueOf(paramBoolean));
  }
  
  public void saveAggregateAd(boolean paramBoolean)
  {
    saveUmaSettingOpers(-1, 11, Boolean.valueOf(paramBoolean));
  }
  
  public void saveAggregateBySubject(int paramInt, boolean paramBoolean)
  {
    saveUmaSettingOpers(paramInt, 28, Boolean.valueOf(paramBoolean));
  }
  
  public void saveAggregateSubscribeMail(boolean paramBoolean)
  {
    saveUmaSettingOpers(-1, 12, Boolean.valueOf(paramBoolean));
  }
  
  public void saveApplicationShowInHome(LinkedList<Integer> paramLinkedList)
  {
    saveUmaSettingOpers(-1, 30, Joiner.on(",").skipNulls().join(paramLinkedList));
  }
  
  public void saveDel(int paramInt1, int paramInt2, List<String> paramList1, List<String> paramList2)
  {
    saveMailOpers(paramList1, paramList2, paramInt1, paramInt2, 2, Integer.valueOf(1));
  }
  
  public void saveEnableNotifyDetail(boolean paramBoolean)
  {
    saveUmaSettingOpers(-1, 32, Boolean.valueOf(paramBoolean));
  }
  
  public void saveGesturePwd(String paramString)
  {
    saveUmaSettingOpers(-1, 21, paramString);
  }
  
  public void saveIncrementBadge(boolean paramBoolean)
  {
    saveUmaSettingOpers(-1, 31, Boolean.valueOf(paramBoolean));
  }
  
  public void saveLoadImgType(int paramInt)
  {
    saveUmaSettingOpers(-1, 19, Integer.valueOf(paramInt));
  }
  
  public void saveMailListAvatar(boolean paramBoolean)
  {
    saveUmaSettingOpers(-1, 18, Boolean.valueOf(paramBoolean));
  }
  
  public void saveMove(int paramInt1, int paramInt2, int paramInt3, List<String> paramList1, List<String> paramList2)
  {
    saveMailOpers(paramList1, paramList2, paramInt1, paramInt2, 2, Integer.valueOf(paramInt3));
  }
  
  public void saveNewMailPushRate(int paramInt1, int paramInt2)
  {
    saveUmaSettingOpers(paramInt1, 17, Integer.valueOf(paramInt2));
  }
  
  public void saveNewMailPushSound(boolean paramBoolean)
  {
    saveUmaSettingOpers(-1, 23, Boolean.valueOf(paramBoolean));
  }
  
  public void saveNewMailPushViberate(boolean paramBoolean)
  {
    saveUmaSettingOpers(-1, 22, Boolean.valueOf(paramBoolean));
  }
  
  public void saveNewMailPushWay(int paramInt1, int paramInt2)
  {
    saveUmaSettingOpers(paramInt1, 16, Integer.valueOf(paramInt2));
  }
  
  public void saveNightMode(boolean paramBoolean)
  {
    saveUmaSettingOpers(-1, 6, Boolean.valueOf(paramBoolean));
  }
  
  public void saveNotifyCalendarReminderMail(int paramInt, boolean paramBoolean)
  {
    saveSettingOpers(paramInt, 26, Boolean.valueOf(paramBoolean));
  }
  
  public void saveNotifyProtocolAccountMail(int paramInt, boolean paramBoolean)
  {
    saveSettingOpers(paramInt, 15, Boolean.valueOf(paramBoolean));
  }
  
  public void saveOnlyPushMailApp(int paramInt, boolean paramBoolean)
  {
    saveSettingOpers(paramInt, 14, Boolean.valueOf(paramBoolean));
  }
  
  public void savePersonalizedSignature(int paramInt, String paramString)
  {
    saveUmaSettingOpers(paramInt, 24, paramString);
  }
  
  public void savePlpBindAccount(long paramLong)
  {
    saveUmaSettingOpers(-1, 27, Long.valueOf(paramLong));
  }
  
  public void savePushFolder(int paramInt, String[] paramArrayOfString, boolean[] paramArrayOfBoolean)
  {
    Object localObject1 = this.sqliteHelper.getReadableDatabase();
    Object localObject2 = this.sqliteHelper.offLine.getPushFolderStr((SQLiteDatabase)localObject1, paramInt);
    localObject1 = new HashMap();
    if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
      localObject1 = parsePushFolderStr((String)localObject2);
    }
    for (;;)
    {
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        ((HashMap)localObject1).put(paramArrayOfString[i], Boolean.valueOf(paramArrayOfBoolean[i]));
        i += 1;
      }
      paramArrayOfBoolean = new StringBuilder();
      localObject2 = ((HashMap)localObject1).keySet().iterator();
      int j = ((HashMap)localObject1).size();
      i = 0;
      if (((Iterator)localObject2).hasNext())
      {
        paramArrayOfString = (String)((Iterator)localObject2).next();
        boolean bool = ((Boolean)((HashMap)localObject1).get(paramArrayOfString)).booleanValue();
        StringBuilder localStringBuilder = new StringBuilder().append(paramArrayOfString).append("|");
        if (bool) {}
        for (paramArrayOfString = "1";; paramArrayOfString = "0")
        {
          paramArrayOfBoolean.append(paramArrayOfString);
          if (i != j - 1) {
            paramArrayOfBoolean.append("&");
          }
          i += 1;
          break;
        }
      }
      paramArrayOfString = this.sqliteHelper.getWritableDatabase();
      this.sqliteHelper.offLine.delAccountOfflinePushFolder(paramArrayOfString, paramInt);
      saveSettingOpers(paramInt, 8, paramArrayOfBoolean);
      return;
    }
  }
  
  public void savePushMode(boolean paramBoolean)
  {
    saveUmaSettingOpers(-1, 7, Boolean.valueOf(paramBoolean));
  }
  
  public void saveReject(int paramInt1, int paramInt2, List<String> paramList1, List<String> paramList2)
  {
    saveMailOpers(paramList1, paramList2, paramInt1, paramInt2, 2, Integer.valueOf(0));
  }
  
  public void saveSendMailSound(boolean paramBoolean)
  {
    saveUmaSettingOpers(-1, 20, Boolean.valueOf(paramBoolean));
  }
  
  public void saveSpam(int paramInt1, int paramInt2, List<String> paramList1, List<String> paramList2)
  {
    saveMailOpers(paramList1, paramList2, paramInt1, paramInt2, 2, Integer.valueOf(2));
  }
  
  public void saveStar(int paramInt1, int paramInt2, List<String> paramList1, List<String> paramList2, boolean paramBoolean)
  {
    saveMailOpers(paramList1, paramList2, paramInt1, paramInt2, 1, Boolean.valueOf(paramBoolean));
  }
  
  public void saveSyncMailCountORMailTime(int paramInt1, int paramInt2)
  {
    saveUmaSettingOpers(paramInt1, 25, Integer.valueOf(paramInt2));
  }
  
  public void saveTag(int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3)
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0))
    {
      localStringBuilder.append("addTagIds:");
      i = 0;
      while (i < paramArrayOfString2.length)
      {
        localStringBuilder.append(paramArrayOfString2[i] + ",");
        i += 1;
      }
      localStringBuilder.setCharAt(localStringBuilder.length() - 1, ';');
    }
    if ((paramArrayOfString3 != null) && (paramArrayOfString3.length > 0))
    {
      localStringBuilder.append("deleteTagIds:");
      i = 0;
      while (i < paramArrayOfString3.length)
      {
        localStringBuilder.append(paramArrayOfString3[i] + ",");
        i += 1;
      }
      localStringBuilder.setCharAt(localStringBuilder.length() - 1, ';');
    }
    paramArrayOfString2 = new ArrayList();
    int i = j;
    while (i < paramArrayOfString1.length)
    {
      paramArrayOfString2.add(paramArrayOfString1[i]);
      i += 1;
    }
    saveMailOpers(paramArrayOfString2, null, paramInt, -1, 4, localStringBuilder.toString());
  }
  
  public void saveUnread(int paramInt1, int paramInt2, List<String> paramList1, List<String> paramList2, boolean paramBoolean)
  {
    saveMailOpers(paramList1, paramList2, paramInt1, paramInt2, 0, Boolean.valueOf(paramBoolean));
  }
  
  public void setNewMailPush(boolean paramBoolean)
  {
    saveUmaSettingOpers(-1, 10, Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMOfflineOperationManager
 * JD-Core Version:    0.7.0.1
 */