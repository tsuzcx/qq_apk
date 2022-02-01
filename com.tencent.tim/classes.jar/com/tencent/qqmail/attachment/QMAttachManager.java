package com.tencent.qqmail.attachment;

import android.util.Base64;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.attachment.cursor.AttachFolderListCursor;
import com.tencent.qqmail.attachment.cursor.AttachFolderListSearchCursor;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.model.MailManagerDefines;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.GroupAttachFolderWatcher.SyncRemoteParams;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.qmdomain.MailEditAttach;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QMAttachManager
{
  private static final String TAG = "QMAttachManager";
  private static volatile QMAttachManager _instance;
  private ArrayList<Integer> mCheckListAccounts = new ArrayList();
  private ArrayList<Integer> mLoadListAccounts = new ArrayList();
  private QMMailSQLiteHelper sqliteHelper;
  
  private QMAttachManager(QMMailSQLiteHelper paramQMMailSQLiteHelper)
  {
    this.sqliteHelper = paramQMMailSQLiteHelper;
  }
  
  private String getAttachFolderFavoriteParams(GroupAttachFolderWatcher.SyncRemoteParams[] paramArrayOfSyncRemoteParams)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfSyncRemoteParams.length) {
        break label139;
      }
      String str2 = paramArrayOfSyncRemoteParams[i].remoteId;
      Object localObject = paramArrayOfSyncRemoteParams[i].name;
      try
      {
        str1 = StringExtention.urlEncode((String)localObject);
        localObject = str1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          String str1;
          localUnsupportedEncodingException.printStackTrace();
        }
      }
      str1 = paramArrayOfSyncRemoteParams[i].groupDownKey;
      localStringBuffer.append("&mailattach=");
      localStringBuffer.append(str2);
      if ((!StringExtention.isNullOrEmpty(str2)) && (!StringExtention.isNullOrEmpty(str1)) && (str2.indexOf("@") == 0))
      {
        localStringBuffer.append("|");
        localStringBuffer.append(str1);
      }
      localStringBuffer.append("|");
      localStringBuffer.append((String)localObject);
      i += 1;
    }
    label139:
    return localStringBuffer.toString();
  }
  
  private void parseAttachFolder(int paramInt, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramJSONObject = paramJSONObject.getJSONArray("attLst");
      if ((paramJSONObject != null) && (paramJSONObject.size() != 0))
      {
        int i = 0;
        while (i < paramJSONObject.size())
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
          Attach localAttach = new Attach();
          localAttach.setAccountId(paramInt);
          localArrayList.add((Attach)Attach.fromDictionary(localJSONObject, localAttach));
          i += 1;
        }
      }
      saveAttachFolderList(paramInt, localArrayList);
    }
  }
  
  private void removeCheckListRecord(int paramInt)
  {
    synchronized (this.mCheckListAccounts)
    {
      if (this.mCheckListAccounts.contains(Integer.valueOf(paramInt))) {
        this.mCheckListAccounts.remove(Integer.valueOf(paramInt));
      }
      return;
    }
  }
  
  private void removeLoadListRecord(int paramInt)
  {
    synchronized (this.mLoadListAccounts)
    {
      if (this.mLoadListAccounts.contains(Integer.valueOf(paramInt))) {
        this.mLoadListAccounts.remove(Integer.valueOf(paramInt));
      }
      return;
    }
  }
  
  private void saveAttachFolderList(int paramInt, ArrayList<Attach> paramArrayList)
  {
    SQLiteDatabase localSQLiteDatabase;
    ArrayList localArrayList1;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localSQLiteDatabase = this.sqliteHelper.getWritableDatabase();
      localArrayList1 = this.sqliteHelper.attach.getLocalAttachIds(localSQLiteDatabase);
      localSQLiteDatabase.beginTransactionNonExclusive();
    }
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    ArrayList localArrayList4;
    for (;;)
    {
      Attach localAttach;
      try
      {
        localArrayList2 = new ArrayList();
        localArrayList3 = new ArrayList();
        localArrayList4 = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        if (!paramArrayList.hasNext()) {
          break;
        }
        localAttach = (Attach)paramArrayList.next();
        if (!localAttach.isFav())
        {
          i = localAttach.getFolderKey();
          if (i == 0) {
            continue;
          }
          localArrayList2.add(Integer.valueOf(i));
          continue;
        }
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
        return;
        localAttach.setBelongMailId(Mail.generateId(paramInt, localAttach.getRemoteId()));
        int i = Attach.generateHashId(localAttach, false);
        if (localArrayList1.contains(Integer.valueOf(i)))
        {
          localAttach.setHashId(i);
          localArrayList3.add(localAttach);
          localAttach.setAccountId(paramInt);
          continue;
        }
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
      localArrayList4.add(localAttach);
      QMLog.log(4, "QMAttachManager", "favour insert attach:" + localAttach.getName() + ",mailID:" + localAttach.getBelongMailId());
    }
    this.sqliteHelper.attach.resetAttachFavorite(localSQLiteDatabase, localArrayList2);
    this.sqliteHelper.attach.updateAttachFolder(localSQLiteDatabase, localArrayList3);
    this.sqliteHelper.attach.insertAttachFolder(localSQLiteDatabase, localArrayList4);
    this.sqliteHelper.attach.resetAttachFavorite(localSQLiteDatabase, paramInt);
    localSQLiteDatabase.setTransactionSuccessful();
    localSQLiteDatabase.endTransaction();
  }
  
  public static QMAttachManager sharedInstance()
  {
    if (_instance == null) {}
    try
    {
      if (_instance == null) {
        _instance = new QMAttachManager(QMMailManager.sharedInstance().getSqliteHelper());
      }
      return _instance;
    }
    finally {}
  }
  
  public QMNetworkRequest attachFolderFavorite(int paramInt, long[] paramArrayOfLong, boolean paramBoolean, GroupAttachFolderWatcher.SyncRemoteParams[] paramArrayOfSyncRemoteParams)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("ef=js&t=mobile_mgr.json");
    if (paramBoolean == true) {}
    for (Object localObject = "&action=setflag";; localObject = "&action=cancelflag")
    {
      localObject = (String)localObject;
      paramArrayOfSyncRemoteParams = (String)localObject + getAttachFolderFavoriteParams(paramArrayOfSyncRemoteParams);
      localObject = new QMCallback();
      ((QMCallback)localObject).setOnBeforeSend(new QMAttachManager.7(this));
      ((QMCallback)localObject).setOnSuccess(new QMAttachManager.8(this, paramArrayOfLong));
      ((QMCallback)localObject).setOnError(new QMAttachManager.9(this, paramArrayOfLong));
      ((QMCallback)localObject).setOnComplete(new QMAttachManager.10(this));
      return CGIManager.httpPost(paramInt, "attachfolder", paramArrayOfSyncRemoteParams, (QMCallback)localObject);
    }
  }
  
  public void checkAttachFolderListByAccounts(boolean paramBoolean1, boolean paramBoolean2)
  {
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    int j = 1;
    int i = 0;
    while (i < localAccountList.size())
    {
      Account localAccount = localAccountList.get(i);
      if (localAccount.isQQMail())
      {
        checkAttachFolderListUpdate(localAccount.getId(), paramBoolean1, paramBoolean2);
        j = 0;
      }
      i += 1;
    }
    if ((j != 0) && (localAccountList.size() > 0)) {
      QMWatcherCenter.triggerLoadAttachFolderListSuccess(0, false, false, false);
    }
  }
  
  public void checkAttachFolderListUpdate(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mCheckListAccounts.add(Integer.valueOf(paramInt));
    if (paramBoolean2) {}
    for (;;)
    {
      loadAttachFolderList(paramInt, paramBoolean1, paramBoolean2, new QMAttachManager.1(this, paramInt));
      return;
      paramBoolean2 = AccountManager.shareInstance().getAccountList().isAccountLocked(paramInt);
    }
  }
  
  public boolean checkListFinished()
  {
    return this.mCheckListAccounts.size() == 0;
  }
  
  public void deleteAccountAttach(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong)
  {
    this.sqliteHelper.attach.deleteAccountAttach(paramSQLiteDatabase, paramArrayOfLong);
  }
  
  public void deleteAttachDisk(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    this.sqliteHelper.attach.deletePathByMyDisk(this.sqliteHelper.getWritableDatabase(), paramArrayList, paramBoolean);
  }
  
  public final void favoriteAttach(long[] paramArrayOfLong, boolean paramBoolean)
  {
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getReadableDatabase();
    this.sqliteHelper.attach.groupFolderAttachInAccount(localSQLiteDatabase, paramArrayOfLong, new QMAttachManager.3(this, paramArrayOfLong, paramBoolean));
  }
  
  public Attach getAttach(long paramLong)
  {
    return this.sqliteHelper.attach.getAttach(this.sqliteHelper.getReadableDatabase(), paramLong);
  }
  
  public String getAttachCopyDisk(long paramLong, int paramInt)
  {
    return this.sqliteHelper.attach.getAttachCopyDisk(this.sqliteHelper.getReadableDatabase(), paramLong, paramInt);
  }
  
  public String getAttachDownloadUrl(long paramLong, boolean paramBoolean)
  {
    return this.sqliteHelper.attach.getAttachDownloadUrl(this.sqliteHelper.getReadableDatabase(), paramLong, paramBoolean);
  }
  
  public AttachFolderListCursor getAttachFolderListCursor()
  {
    return new AttachFolderListCursor(this.sqliteHelper, this);
  }
  
  public List<Attach> getAttachFolderListCursorByIds(long[] paramArrayOfLong)
  {
    return this.sqliteHelper.attach.getAttachFolderListCursorByIds(this.sqliteHelper.getReadableDatabase(), paramArrayOfLong);
  }
  
  public ArrayList<Object> getAttachList(long paramLong)
  {
    return this.sqliteHelper.attach.getAttachList(this.sqliteHelper.getReadableDatabase(), paramLong);
  }
  
  public ArrayList<Object> getAttachListByMailIds(ArrayList<Long> paramArrayList, boolean paramBoolean)
  {
    return this.sqliteHelper.attach.getAttachListByMailIds(this.sqliteHelper.getReadableDatabase(), paramArrayList, paramBoolean);
  }
  
  public String getAttachMyDisk(long paramLong, int paramInt)
  {
    return this.sqliteHelper.attach.getAttachMyDisk(this.sqliteHelper.getReadableDatabase(), paramLong, paramInt);
  }
  
  public long getAttachRefMailId(long paramLong, boolean paramBoolean)
  {
    return this.sqliteHelper.attach.getAttachRefMailId(this.sqliteHelper.getReadableDatabase(), paramLong, paramBoolean);
  }
  
  public MailBigAttach getBigAttach(long paramLong)
  {
    return this.sqliteHelper.attach.getBigAttach(this.sqliteHelper.getReadableDatabase(), paramLong);
  }
  
  public ArrayList<Object> getBigAttachList(long paramLong)
  {
    return this.sqliteHelper.attach.getBigAttachList(this.sqliteHelper.getReadableDatabase(), paramLong);
  }
  
  public MailEditAttach getEditAttach(long paramLong)
  {
    return this.sqliteHelper.attach.getEditAttach(this.sqliteHelper.getReadableDatabase(), paramLong);
  }
  
  public ArrayList<Object> getEditAttachList(long paramLong)
  {
    return this.sqliteHelper.attach.getEditAttachList(this.sqliteHelper.getReadableDatabase(), paramLong);
  }
  
  public long getFtnRefMailId(String paramString)
  {
    return FtnManager.sharedInstance().getAttachRefMailId(paramString);
  }
  
  public String getInlineImageDisk(String paramString)
  {
    String str = null;
    Object localObject = this.sqliteHelper.attach.getInlineImage(this.sqliteHelper.getReadableDatabase(), paramString);
    paramString = str;
    if (localObject != null)
    {
      str = ((Attach)localObject).getPreview().getMyDisk();
      paramString = str;
      if (StringExtention.isNullOrEmpty(str))
      {
        localObject = ((Attach)localObject).getPreview().getCopyDiskList();
        paramString = str;
        if (localObject != null)
        {
          paramString = str;
          if (((ArrayList)localObject).size() > 0) {
            paramString = (String)((ArrayList)localObject).get(0);
          }
        }
      }
    }
    return paramString;
  }
  
  public String getInlineImageMyDisk(String paramString)
  {
    paramString = this.sqliteHelper.attach.getInlineImageMyDisk(this.sqliteHelper.getReadableDatabase(), paramString);
    if (FileUtil.isFileExist(paramString)) {
      return paramString;
    }
    return "";
  }
  
  public String[] getMailAttachMatchedMailId(String paramString)
  {
    return this.sqliteHelper.attach.getAttachMatchedMailId(this.sqliteHelper.getReadableDatabase(), paramString);
  }
  
  public AttachFolderListSearchCursor getSearchAttachFolderListCursor(int paramInt1, int paramInt2, String paramString, long[] paramArrayOfLong)
  {
    AttachFolderListSearchCursor localAttachFolderListSearchCursor = new AttachFolderListSearchCursor(this.sqliteHelper);
    localAttachFolderListSearchCursor.setSearchInfo(paramInt1, paramInt2, paramString, paramArrayOfLong);
    return localAttachFolderListSearchCursor;
  }
  
  public boolean isAttachFavorite(long paramLong)
  {
    return this.sqliteHelper.attach.isAttachFavorite(this.sqliteHelper.getReadableDatabase(), paramLong);
  }
  
  public boolean isAttachFromEml(long paramLong)
  {
    return this.sqliteHelper.attach.isAttachFromEml(this.sqliteHelper.getReadableDatabase(), paramLong);
  }
  
  public boolean isMailInlineImageCached(String paramString)
  {
    return !"".equals(getInlineImageMyDisk(paramString));
  }
  
  public boolean isShowStarAttach()
  {
    boolean bool1 = false;
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
    boolean bool3 = QMSettingManager.sharedInstance().isStarAttachRemoteActivate(localArrayList);
    boolean bool2 = this.sqliteHelper.attach.hasAttachFavorite(this.sqliteHelper.getReadableDatabase());
    if ((bool3) || (bool2)) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void loadAttachFolderList(int paramInt)
  {
    this.mLoadListAccounts.add(Integer.valueOf(paramInt));
    loadAttachFolderList(paramInt, false, AccountManager.shareInstance().getAccountList().isAccountLocked(paramInt), new QMAttachManager.2(this, paramInt));
  }
  
  public void loadAttachFolderList(int paramInt, boolean paramBoolean1, boolean paramBoolean2, Runnable paramRunnable)
  {
    String str = "attach_folder_list_" + paramInt;
    if (RequestFilter.isRequestOnRunning(str))
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      return;
    }
    RequestFilter.setRequestRunningState(str);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MailManagerDefines.PARAM_PREFIX_ATTACHFOLDER);
    localStringBuilder.append("&folderid=all&flag=attach&f=xhtml&action=list&showattachtag=1&s=search&error=app");
    if (paramBoolean1)
    {
      localStringBuilder.append("&check=checkmd5");
      if (!paramBoolean2) {
        break label262;
      }
    }
    label262:
    for (Object localObject = "&lock=1";; localObject = "&lock=0")
    {
      localStringBuilder.append((String)localObject);
      localObject = new QMCallback();
      ((QMCallback)localObject).setOnBeforeSend(new QMAttachManager.4(this, paramInt));
      ((QMCallback)localObject).setOnSuccess(new QMAttachManager.5(this, str, paramBoolean2, paramInt, paramBoolean1, paramRunnable));
      ((QMCallback)localObject).setOnError(new QMAttachManager.6(this, str, paramRunnable, paramInt, paramBoolean1));
      CGIManager.httpGetExcludeHttps(paramInt, "attachfolder", localStringBuilder.toString(), (QMCallback)localObject);
      return;
      localObject = this.sqliteHelper.attach.getAttachFolderListKeys(this.sqliteHelper.getReadableDatabase(), paramInt);
      if ((localObject == null) || (localObject.length <= 0)) {
        break;
      }
      localStringBuilder.append("&keys=");
      int i = 0;
      while (i < localObject.length)
      {
        localStringBuilder.append(localObject[i]);
        localStringBuilder.append("|");
        i += 1;
      }
      break;
    }
  }
  
  public boolean loadListFinished()
  {
    return this.mLoadListAccounts.size() == 0;
  }
  
  @Nullable
  public ArrayList<Object> queryAttachsByRemoteId(String paramString)
  {
    return this.sqliteHelper.attach.getAttachListByRemoteId(this.sqliteHelper.getReadableDatabase(), paramString);
  }
  
  public void updateAttachDisk(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.sqliteHelper.attach.updateAttachDiskById(this.sqliteHelper.getWritableDatabase(), paramLong, paramString1, paramString2, paramString3, paramInt);
  }
  
  public void updateAttachDownload(long paramLong, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.sqliteHelper.attach.updateAttachIsDownload(this.sqliteHelper.getWritableDatabase(), paramLong, paramString1, paramString2, paramBoolean);
  }
  
  public void updateAttachRefMailId(SQLiteDatabase paramSQLiteDatabase, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.sqliteHelper.attach.updateAttachRefMailId(paramSQLiteDatabase, paramLong1, paramLong2, paramBoolean);
  }
  
  public void updateAttachTypeById(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString, String paramString)
  {
    this.sqliteHelper.attach.updateAttachTypeByID(paramSQLiteDatabase, paramArrayOfString, paramString);
  }
  
  public void updateBigAttachExpire(long paramLong1, long paramLong2)
  {
    this.sqliteHelper.attach.updateBigAttachExpire(this.sqliteHelper.getWritableDatabase(), paramLong1, paramLong2);
  }
  
  public void updateMailAttaches(SQLiteDatabase paramSQLiteDatabase, int paramInt, MailInformation paramMailInformation, boolean paramBoolean)
  {
    this.sqliteHelper.attach.updateMailAttaches(paramSQLiteDatabase, paramInt, paramMailInformation, paramBoolean);
  }
  
  public void updateMailBigAttachExpireTime(int paramInt1, MailBigAttach paramMailBigAttach, int paramInt2)
  {
    QMLog.log(4, "QMAttachManager", "updateMailBigAttachExpireTime");
    localObject = AccountManager.shareInstance().getAccountList().getAccountById(paramInt1);
    QMCallback localQMCallback;
    if ((localObject != null) && ((localObject instanceof QQMailAccount)))
    {
      localObject = (QQMailAccount)localObject;
      localQMCallback = new QMCallback();
      localQMCallback.setOnSuccess(new QMAttachManager.11(this, paramMailBigAttach, paramInt1, paramInt2));
      localQMCallback.setOnError(new QMAttachManager.12(this));
      localObject = StringExtention.replaceWithEncodeURIValue(MailManagerDefines.PARAM_CHECK_FTN_EXPIRE_TIME, "sid", ((QQMailAccount)localObject).getSid());
    }
    try
    {
      String str = StringExtention.replaceWithEncodeURIValue((String)localObject, "url", Base64.encodeToString(paramMailBigAttach.getPreview().getDownloadUrl().getBytes("UTF-8"), 2));
      paramMailBigAttach = str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        QMLog.log(6, "QMAttachManager", "updateMailBigAttachExpireTime encode error, url:" + paramMailBigAttach.getPreview().getDownloadUrl());
        localUnsupportedEncodingException.printStackTrace();
        paramMailBigAttach = (MailBigAttach)localObject;
      }
    }
    CGIManager.httpPost(paramInt1, "ftnExpireFile", paramMailBigAttach, localQMCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.QMAttachManager
 * JD-Core Version:    0.7.0.1
 */