package com.tencent.qqmail.model.mail;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.mailsdk.callback.IdleCallback;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.MailServiceManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachProtocol;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.download.util.DownloadUtil;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.callback.CheckMailCallback;
import com.tencent.qqmail.model.mail.callback.FolderListCallback;
import com.tencent.qqmail.model.mail.callback.FolderListCompleteCallback;
import com.tencent.qqmail.model.mail.callback.FolderOperationCallback;
import com.tencent.qqmail.model.mail.callback.IListCallback;
import com.tencent.qqmail.model.mail.callback.IListStatusCallback;
import com.tencent.qqmail.model.mail.callback.ListCompleteCallback;
import com.tencent.qqmail.model.mail.callback.ListStatusCompleteCallback;
import com.tencent.qqmail.model.mail.callback.LoadMailAbstractCallback;
import com.tencent.qqmail.model.mail.callback.LoginCallback;
import com.tencent.qqmail.model.mail.callback.LogoutCallback;
import com.tencent.qqmail.model.mail.cursor.QMSearchCursor;
import com.tencent.qqmail.model.mail.cursor.QMSyncAccountCursor;
import com.tencent.qqmail.model.mail.cursor.QMSyncFolderCursor;
import com.tencent.qqmail.model.mail.loader.ProtocolInlineImgCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.qmdomain.MailEditAttach;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.qmdomain.SearchInfo;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.protocol.Exchange.ExchangeRule;
import com.tencent.qqmail.protocol.ItemBodyStructureHelper.MailItemBodyStructureInfo;
import com.tencent.qqmail.protocol.MailUtil;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.provider.MailServiceProvider;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMGeneralCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import moai.oss.OssHelper;
import org.apache.commons.lang3.StringUtils;

public class QMMailProtocolManager
{
  private static final int PRELOAD_MAIL_COUNT = 5;
  private static final String TAG = "QMMailProtocolManager";
  private final ConcurrentHashMap<String, Boolean> appendMap = new ConcurrentHashMap();
  private QMFolderManager folderMgr;
  private Set<String> gmailNewMailSet = new HashSet();
  private QMMailManager mailMgr;
  private HashMap<Long, Long> popInMailIdMap = new HashMap();
  private QMMailProtocolService service;
  private QMMailSQLiteHelper sqliteHelper;
  
  public QMMailProtocolManager(QMMailSQLiteHelper paramQMMailSQLiteHelper, QMMailManager paramQMMailManager, QMFolderManager paramQMFolderManager)
  {
    this.sqliteHelper = paramQMMailSQLiteHelper;
    this.mailMgr = paramQMMailManager;
    this.folderMgr = paramQMFolderManager;
    this.service = new QMMailProtocolService();
  }
  
  private boolean accountNeedAppendAfterSync(Account paramAccount, QMFolder paramQMFolder)
  {
    if ((paramAccount != null) && (paramQMFolder != null) && (paramQMFolder.getType() == 3) && (paramAccount.getProfile().protocolType == 1) && (!needAppendAfterSend(paramAccount)))
    {
      if ((!MailServiceManager.getInstance().isLocalDomain(paramAccount.getProfile().getDomain())) || (QMSettingManager.sharedInstance().isEnableDomainAppend()))
      {
        QMLog.log(4, "QMMailProtocolManager", "account need append:" + paramAccount.getId());
        return true;
      }
      QMLog.log(4, "QMMailProtocolManager", "account no append:" + paramAccount.getId());
      reportNoAppendInDomain(paramAccount);
    }
    return false;
  }
  
  private void addPopInMailId(long paramLong)
  {
    this.popInMailIdMap.put(Long.valueOf(paramLong), Long.valueOf(System.currentTimeMillis()));
  }
  
  private void appendMailToServerAfterSend(ComposeMailUI paramComposeMailUI, Account paramAccount)
  {
    if ((paramComposeMailUI != null) && (needAppendAfterSend(paramAccount))) {
      Threads.runInBackground(new QMMailProtocolManager.18(this, paramAccount, paramComposeMailUI));
    }
  }
  
  private void appendMailToServerAfterSync(ArrayList<Mail> arg1, Account paramAccount, QMFolder paramQMFolder)
  {
    int i;
    if ((??? != null) && (???.size() > 0) && (accountNeedAppendAfterSync(paramAccount, paramQMFolder)))
    {
      QMLog.log(4, "QMMailProtocolManager", "need append after sync sent:" + ???.size());
      Iterator localIterator = ???.iterator();
      i = 0;
      Mail localMail;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label166;
        }
        localMail = (Mail)localIterator.next();
        if (!mailNeedAppendAfterSync(localMail)) {
          break label189;
        }
        synchronized (this.appendMap)
        {
          if (this.appendMap.get(localMail.getInformation().getRemoteId()) == null) {
            break;
          }
        }
      }
      this.appendMap.put(localMail.getInformation().getRemoteId(), Boolean.valueOf(true));
      Threads.runInBackground(new QMMailProtocolManager.17(this, localMail, paramAccount, paramQMFolder));
      i = 1;
    }
    label166:
    label189:
    for (;;)
    {
      break;
      if (i != 0) {
        OssHelper.appendAfterSyncSent(new Object[] { paramAccount.getProfile().getDomain() });
      }
      return;
    }
  }
  
  private boolean containAttach(Mail paramMail)
  {
    ArrayList localArrayList1 = paramMail.getInformation().getAttachList();
    ArrayList localArrayList2 = paramMail.getInformation().getBigAttachList();
    paramMail = paramMail.getInformation().getEditAttachList();
    return ((localArrayList1 != null) && (localArrayList1.size() > 0)) || ((localArrayList2 != null) && (localArrayList2.size() > 0)) || ((paramMail != null) && (paramMail.size() > 0));
  }
  
  private void copyPopAttach(Mail paramMail, int paramInt)
  {
    if (paramInt == 0)
    {
      paramMail = paramMail.getInformation().getAttachList().iterator();
      while (paramMail.hasNext())
      {
        Object localObject = paramMail.next();
        if ((localObject instanceof Attach))
        {
          localObject = (Attach)localObject;
          if (StringExtention.isNullOrEmpty(((Attach)localObject).getProtocol().getCid())) {
            try
            {
              String str1 = ((Attach)localObject).getPreview().getMyDisk();
              String str2 = DownloadUtil.fileCopyTo(str1, FileUtil.getAttachDownloadDir(), ((Attach)localObject).getDisplayName());
              ((Attach)localObject).getPreview().setMyDisk(str2);
              ArrayList localArrayList = ((Attach)localObject).getPreview().getCopyDiskList();
              localArrayList.add(str1);
              ((Attach)localObject).getPreview().setCopyDiskList(localArrayList);
              QMLog.log(4, "QMMailProtocolManager", "copy pop file to dest:" + str2 + ", from:" + str1);
            }
            catch (Exception localException)
            {
              QMLog.log(6, "QMMailProtocolManager", "copy pop file error:" + Log.getStackTraceString(localException));
            }
          }
        }
      }
    }
  }
  
  private void fetchMailList(Account paramAccount, QMFolder paramQMFolder, ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, IListCallback paramIListCallback)
  {
    int i = paramAccount.getProfile().protocolType;
    int j = paramAccount.getId();
    int k = paramQMFolder.getId();
    ArrayList localArrayList1 = new ArrayList();
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList2 = getLocalSentMailList(paramQMFolder);
    paramIListCallback = new QMMailProtocolManager.19(this, paramAccount, paramQMFolder, paramIListCallback, new int[] { 0 }, localArrayList2, new int[] { 0 }, localHashSet, localArrayList1, k, paramBoolean1, i, j);
    this.service.fetchMailList(paramAccount, paramQMFolder, paramArrayList, paramBoolean1, paramBoolean2, paramIListCallback);
  }
  
  private void fillAttachList(Mail paramMail, ArrayList<Object> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(paramArrayList.next());
    }
    if (localArrayList.size() > 0) {
      paramMail.getInformation().setAttachList(localArrayList);
    }
  }
  
  private void fillBigAttachList(Mail paramMail, ArrayList<MailBigAttach> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add((MailBigAttach)paramArrayList.next());
    }
    if (localArrayList.size() > 0) {
      paramMail.getInformation().setBigAttachList(localArrayList);
    }
  }
  
  private void fillEditAttachList(Mail paramMail, ArrayList<MailEditAttach> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add((MailEditAttach)paramArrayList.next());
    }
    if (localArrayList.size() > 0) {
      paramMail.getInformation().setEditAttachList(localArrayList);
    }
  }
  
  private QMFolder[] filter(QMFolder[] paramArrayOfQMFolder, String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      ArrayList localArrayList = new ArrayList();
      int k = paramArrayOfQMFolder.length;
      int i = 0;
      QMFolder localQMFolder;
      if (i < k)
      {
        localQMFolder = paramArrayOfQMFolder[i];
        j = 0;
        label33:
        if (j >= paramArrayOfString.length) {
          break label104;
        }
        if (!paramArrayOfString[j].equals(localQMFolder.getName())) {}
      }
      label104:
      for (int j = 1;; j = 0)
      {
        if (j == 0) {
          localArrayList.add(localQMFolder);
        }
        i += 1;
        break;
        j += 1;
        break label33;
        return (QMFolder[])localArrayList.toArray(new QMFolder[localArrayList.size()]);
      }
    }
    return paramArrayOfQMFolder;
  }
  
  private ArrayList<QMFolder> filterNotLoadedFolder(Account paramAccount, ArrayList<QMFolder> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramAccount.getProtocolType();
    int i = 0;
    if (i < paramArrayList.size())
    {
      switch (j)
      {
      default: 
        localArrayList.add(paramArrayList.get(i));
      }
      for (;;)
      {
        i += 1;
        break;
        paramAccount = ((QMFolder)paramArrayList.get(i)).getSyncKey();
        if ((paramAccount != null) && (!paramAccount.equals("")) && (!paramAccount.equals(Integer.valueOf(0)))) {
          localArrayList.add(paramArrayList.get(i));
        }
      }
    }
    return localArrayList;
  }
  
  private ArrayList<Mail> getLocalSentMailList(QMFolder paramQMFolder)
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = localArrayList2;
    if (paramQMFolder != null)
    {
      localArrayList1 = localArrayList2;
      if (paramQMFolder.getType() == 3) {
        localArrayList1 = this.sqliteHelper.mail.getLocalSentMailList(this.sqliteHelper.getReadableDatabase(), paramQMFolder.getId(), paramQMFolder.getAccountId());
      }
    }
    return localArrayList1;
  }
  
  private void handleSpamConvMail(Mail paramMail)
  {
    int i = paramMail.getInformation().getConvHash();
    paramMail = this.sqliteHelper.mail.getConvMailParentIds(this.sqliteHelper.getReadableDatabase(), i);
    if ((paramMail == null) || (paramMail.length == 0)) {}
    for (;;)
    {
      return;
      int j = paramMail.length;
      i = 0;
      while (i < j)
      {
        long l = paramMail[i];
        Mail localMail = this.sqliteHelper.mail.readMailSync(this.sqliteHelper.getReadableDatabase(), Long.valueOf(l).longValue());
        if (!localMail.getStatus().isAdMail())
        {
          localMail.getStatus().setAdMail(true);
          this.sqliteHelper.mail.updateMailAttr(this.sqliteHelper.getWritableDatabase(), localMail);
        }
        i += 1;
      }
    }
  }
  
  private void handleSpamMail(Mail paramMail)
  {
    int i = QMSpamTypeManager.sharedInstance().checkSpamType(paramMail.getInformation().getFrom().getAddress(), paramMail.getInformation().getSubject());
    int j = paramMail.getInformation().getAccountId();
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(j);
    if ((localAccount == null) || (localAccount.isQQMail())) {}
    do
    {
      return;
      if (i == 0) {
        paramMail.getStatus().setNeedCheck(true);
      }
    } while ((paramMail.getStatus().isChecked()) || (paramMail.getStatus().isNeedCheck()) || (i != 2));
    paramMail.getStatus().setAdMail(true);
    handleSpamConvMail(paramMail);
  }
  
  private boolean hasAttach(ArrayList<Object> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (!"inline".equals(((Attach)paramArrayList.next()).getProtocol().getType())) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isLocalMailMatch(Mail paramMail1, Mail paramMail2)
  {
    if (paramMail1.getInformation().getSubject().equals(paramMail2.getInformation().getSubject()))
    {
      long l = Math.abs(paramMail1.getInformation().getDate().getTime() - paramMail2.getInformation().getDate().getTime());
      if (l < 300000L) {
        return true;
      }
      OssHelper.matchSubjectNotTime(new Object[] { Long.valueOf(l / 1000L) });
    }
    return false;
  }
  
  private boolean isPopIn(long paramLong)
  {
    Long localLong = (Long)this.popInMailIdMap.get(Long.valueOf(paramLong));
    return (localLong != null) && (System.currentTimeMillis() - localLong.longValue() < 30000L);
  }
  
  private boolean mailNeedAppendAfterSync(Mail paramMail)
  {
    return (!this.sqliteHelper.mail.isMailAppended(this.sqliteHelper.getReadableDatabase(), paramMail.getInformation().getId())) && (System.currentTimeMillis() - paramMail.getInformation().getDate().getTime() > 600000L);
  }
  
  private void matchLocalSentMails(ArrayList<Mail> paramArrayList, Mail paramMail)
  {
    long[] arrayOfLong;
    if ((paramArrayList != null) && (paramArrayList.size() > 0) && (paramMail != null))
    {
      arrayOfLong = new long[paramArrayList.size()];
      paramArrayList = paramArrayList.iterator();
      int i = 0;
      if (paramArrayList.hasNext())
      {
        Mail localMail = (Mail)paramArrayList.next();
        if (!isLocalMailMatch(localMail, paramMail)) {
          break label168;
        }
        QMLog.log(4, "QMMailProtocolManager", "new mail match local mail:" + paramMail.getInformation().getId() + "," + paramMail.getInformation().getSubject());
        FileUtil.delFolder(FileUtil.getLocalMailCachePathWithKey(localMail.getInformation().getRemoteId(), false));
        arrayOfLong[i] = localMail.getInformation().getId();
        paramArrayList.remove();
        i += 1;
      }
    }
    label168:
    for (;;)
    {
      break;
      this.sqliteHelper.mail.deleteMails(this.sqliteHelper.getWritableDatabase(), arrayOfLong);
      return;
    }
  }
  
  private boolean needAppendAfterSend(Account paramAccount)
  {
    return (paramAccount != null) && (paramAccount.getProfile().protocolType == 1) && (paramAccount.getProfile().getDomain().equals("sina.com"));
  }
  
  private void parseAddedFolders(SQLiteDatabase paramSQLiteDatabase, Account paramAccount, QMFolder[] paramArrayOfQMFolder)
  {
    if ((paramArrayOfQMFolder == null) || (paramArrayOfQMFolder.length == 0)) {
      return;
    }
    QMLog.log(4, "QMMailProtocolManager", "parseAddFolders: " + paramArrayOfQMFolder.length);
    ArrayList localArrayList = new ArrayList();
    int n = paramAccount.getProtocolType();
    int m = paramAccount.getId();
    int i = Integer.valueOf(QMApplicationContext.sharedInstance().getString(2131719548)).intValue();
    Object localObject1 = Lists.newArrayList();
    int i1 = paramArrayOfQMFolder.length;
    int k = 0;
    QMFolder localQMFolder;
    Object localObject2;
    int j;
    if (k < i1)
    {
      localQMFolder = paramArrayOfQMFolder[k];
      int i2 = localQMFolder.getType();
      if (i2 == 9)
      {
        localObject2 = new QMCalendarFolder();
        ((QMCalendarFolder)localObject2).setAccountId(paramAccount.getId());
        ((QMCalendarFolder)localObject2).setName(localQMFolder.getName());
        ((QMCalendarFolder)localObject2).setCollectionId(localQMFolder.getRemoteId());
        ((QMCalendarFolder)localObject2).setType(13);
        ((QMCalendarFolder)localObject2).setId(QMCalendarFolder.generateId((QMCalendarFolder)localObject2));
        ((ArrayList)localObject1).add(localObject2);
        j = i;
      }
      do
      {
        k += 1;
        i = j;
        break;
        j = i;
      } while (localQMFolder.isVirtual());
      j = localQMFolder.getId();
      localArrayList.add(Integer.valueOf(j));
      if (this.sqliteHelper.folder.getFolderById(j) == null)
      {
        j = this.folderMgr.getFolderSequenze(i, i2);
        if (j < Integer.valueOf(QMApplicationContext.sharedInstance().getString(2131719548)).intValue()) {
          break label907;
        }
        i += 1;
      }
    }
    label907:
    for (;;)
    {
      localQMFolder.setSequence(j);
      this.sqliteHelper.folder.insertFolder(paramSQLiteDatabase, localQMFolder);
      j = i;
      for (;;)
      {
        QMLog.log(4, "QMMailProtocolManager", "parseAddedFolders: " + localQMFolder.getName() + ", success added.");
        break;
        this.sqliteHelper.folder.renameFolder(paramSQLiteDatabase, paramAccount.getId(), localQMFolder.getRemoteId(), localQMFolder.getName());
        this.sqliteHelper.folder.updateFolderType(paramSQLiteDatabase, paramAccount.getId(), localQMFolder.getRemoteId(), localQMFolder.getType());
        j = i;
        if (n == 3)
        {
          localObject2 = localQMFolder.getSyncKey();
          if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
            this.sqliteHelper.folder.updateFolderSyncKey(paramSQLiteDatabase, localQMFolder.getId(), localQMFolder.getSyncKey());
          }
          localObject2 = localQMFolder.getSyncState();
          j = i;
          if (localObject2 != null)
          {
            j = i;
            if (!((String)localObject2).equals(""))
            {
              this.sqliteHelper.folder.updateFolderSyncState(paramSQLiteDatabase, localQMFolder.getId(), (String)localObject2);
              j = i;
            }
          }
        }
      }
      if ((QMSettingManager.sharedInstance().getCalendarDisplay()) && (((ArrayList)localObject1).size() > 0))
      {
        paramArrayOfQMFolder = ((ArrayList)localObject1).iterator();
        while (paramArrayOfQMFolder.hasNext())
        {
          localObject1 = (QMCalendarFolder)paramArrayOfQMFolder.next();
          QMCalendarManager.getInstance().parseCalendarFolder(paramAccount, (QMCalendarFolder)localObject1);
        }
        QMCalendarManager.getInstance().openDefaultAccount(paramAccount);
      }
      paramArrayOfQMFolder = this.folderMgr.getFoldersByAccountAndType(m, 16);
      if ((paramArrayOfQMFolder != null) && (paramArrayOfQMFolder.size() == 0))
      {
        paramArrayOfQMFolder = new QMFolder();
        paramArrayOfQMFolder.setAccountId(m);
        paramArrayOfQMFolder.setSvrCount(-1);
        paramArrayOfQMFolder.setSvrUnreadCount(-1);
        localObject1 = QMApplicationContext.sharedInstance().getString(2131693924);
        paramArrayOfQMFolder.setRemoteId("_REMOTE_ID_" + QMMath.hashPositivetInt((String)localObject1));
        paramArrayOfQMFolder.setName((String)localObject1);
        paramArrayOfQMFolder.setSequence(this.folderMgr.getFolderSequenze(i, 16));
        paramArrayOfQMFolder.setType(16);
        paramArrayOfQMFolder.setVirtual(true);
        this.sqliteHelper.folder.insertFolder(paramSQLiteDatabase, paramArrayOfQMFolder);
        localArrayList.add(Integer.valueOf(paramArrayOfQMFolder.getId()));
        QMLog.log(4, "QMMailProtocolManager", "parseAddedFolders: insert start folder");
      }
      for (;;)
      {
        paramSQLiteDatabase = this.folderMgr.getFoldersByAccountId(m).iterator();
        while (paramSQLiteDatabase.hasNext())
        {
          paramArrayOfQMFolder = (QMFolder)paramSQLiteDatabase.next();
          if (paramArrayOfQMFolder.getType() == 14) {
            localArrayList.add(Integer.valueOf(paramArrayOfQMFolder.getId()));
          }
        }
        if ((paramArrayOfQMFolder != null) && (paramArrayOfQMFolder.size() > 0))
        {
          localArrayList.add(Integer.valueOf(((QMFolder)paramArrayOfQMFolder.get(0)).getId()));
          QMLog.log(4, "QMMailProtocolManager", "parseAddedFolders: start folder " + ((QMFolder)paramArrayOfQMFolder.get(0)).isVirtual());
        }
      }
      if (paramAccount.isActiveSyncMail()) {
        break;
      }
      paramSQLiteDatabase = new int[localArrayList.size()];
      i = 0;
      while (i < localArrayList.size())
      {
        paramSQLiteDatabase[i] = ((Integer)localArrayList.get(i)).intValue();
        i += 1;
      }
      this.folderMgr.resetFolders(m, paramSQLiteDatabase);
      return;
    }
  }
  
  private void parseDeleteFolders(SQLiteDatabase paramSQLiteDatabase, Account paramAccount, QMFolder[] paramArrayOfQMFolder)
  {
    if ((paramArrayOfQMFolder == null) || (paramArrayOfQMFolder.length == 0)) {}
    ArrayList localArrayList1;
    do
    {
      return;
      QMLog.log(4, "QMMailProtocolManager", "parseDeleteFolders: " + paramArrayOfQMFolder.length);
      ArrayList localArrayList2 = Lists.newArrayList();
      localArrayList1 = Lists.newArrayList();
      int i = 0;
      if (i < paramArrayOfQMFolder.length)
      {
        QMLog.log(4, "QMMailProtocolManager", "parseDeleteFolders: remoteId: " + paramArrayOfQMFolder[i].getRemoteId() + ", name: " + paramArrayOfQMFolder[i].getName());
        if (paramArrayOfQMFolder[i].getType() == 9) {
          localArrayList1.add(paramArrayOfQMFolder[i].getRemoteId());
        }
        for (;;)
        {
          i += 1;
          break;
          localArrayList2.add(paramArrayOfQMFolder[i].getRemoteId());
        }
      }
      if (localArrayList2.size() > 0)
      {
        paramArrayOfQMFolder = (String[])localArrayList2.toArray(new String[localArrayList2.size()]);
        paramArrayOfQMFolder = this.sqliteHelper.folder.getFolderIds(paramAccount.getId(), paramArrayOfQMFolder);
        this.sqliteHelper.mail.updateMailsFolderId(paramSQLiteDatabase, paramArrayOfQMFolder, 0, false);
        this.sqliteHelper.folder.removeFolder(paramSQLiteDatabase, paramAccount.getId(), paramArrayOfQMFolder, 0, false);
      }
    } while ((!QMSettingManager.sharedInstance().getCalendarDisplay()) || (localArrayList1.size() <= 0));
    QMCalendarManager.getInstance().deleteFoldersOnCollectionIds(localArrayList1, paramAccount.getId());
  }
  
  private void parseFolders(int paramInt, QMFolder[] paramArrayOfQMFolder1, QMFolder[] paramArrayOfQMFolder2, QMFolder[] paramArrayOfQMFolder3)
  {
    String[] arrayOfString = null;
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if (localAccount == null) {
      return;
    }
    localObject = localAccount.getEmail().toLowerCase();
    if (localAccount.isGMail()) {}
    for (arrayOfString = QMApplicationContext.sharedInstance().getResources().getString(2131694369).split("\\|");; arrayOfString = QMApplicationContext.sharedInstance().getResources().getString(2131696282).split("\\|")) {
      do
      {
        localObject = this.sqliteHelper.getWritableDatabase();
        try
        {
          ((SQLiteDatabase)localObject).beginTransactionNonExclusive();
          parseUpdateFolders((SQLiteDatabase)localObject, localAccount, filter(paramArrayOfQMFolder2, arrayOfString));
          parseDeleteFolders((SQLiteDatabase)localObject, localAccount, paramArrayOfQMFolder3);
          parseAddedFolders((SQLiteDatabase)localObject, localAccount, filter(paramArrayOfQMFolder1, arrayOfString));
          ((SQLiteDatabase)localObject).setTransactionSuccessful();
          return;
        }
        catch (Exception paramArrayOfQMFolder1)
        {
          QMLog.log(6, "QMMailProtocolManager", Log.getStackTraceString(paramArrayOfQMFolder1));
          return;
        }
        finally
        {
          ((SQLiteDatabase)localObject).endTransaction();
        }
      } while ((!((String)localObject).endsWith("@163.com")) && (!((String)localObject).endsWith("@126.com")) && (!((String)localObject).endsWith("@yeah.net")));
    }
  }
  
  /* Error */
  private Mail parseMail(Mail paramMail, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 50	com/tencent/qqmail/model/mail/QMMailProtocolManager:sqliteHelper	Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   6: invokevirtual 506	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:getWritableDatabase	()Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   9: astore 7
    //   11: aload 7
    //   13: invokevirtual 845	com/tencent/moai/database/sqlite/SQLiteDatabase:beginTransactionNonExclusive	()V
    //   16: aload_0
    //   17: aload_1
    //   18: invokespecial 872	com/tencent/qqmail/model/mail/QMMailProtocolManager:handleSpamMail	(Lcom/tencent/qqmail/model/qmdomain/Mail;)V
    //   21: aload_1
    //   22: invokevirtual 875	com/tencent/qqmail/model/qmdomain/Mail:updateConvHash	()V
    //   25: aload_1
    //   26: invokevirtual 275	com/tencent/qqmail/model/qmdomain/Mail:getInformation	()Lcom/tencent/qqmail/model/qmdomain/MailInformation;
    //   29: astore 8
    //   31: aload_1
    //   32: invokevirtual 494	com/tencent/qqmail/model/qmdomain/Mail:getStatus	()Lcom/tencent/qqmail/model/qmdomain/MailStatus;
    //   35: astore 9
    //   37: aload 8
    //   39: invokevirtual 533	com/tencent/qqmail/model/qmdomain/MailInformation:getAccountId	()I
    //   42: istore 5
    //   44: aload 8
    //   46: invokevirtual 878	com/tencent/qqmail/model/qmdomain/MailInformation:getFolderId	()I
    //   49: istore 6
    //   51: aload 8
    //   53: invokevirtual 479	com/tencent/qqmail/model/qmdomain/MailInformation:getConvHash	()I
    //   56: istore 4
    //   58: aload_0
    //   59: getfield 54	com/tencent/qqmail/model/mail/QMMailProtocolManager:folderMgr	Lcom/tencent/qqmail/folderlist/QMFolderManager;
    //   62: iload 6
    //   64: invokevirtual 881	com/tencent/qqmail/folderlist/QMFolderManager:getFolder	(I)Lcom/tencent/qqmail/model/qmdomain/QMFolder;
    //   67: astore 10
    //   69: aload 10
    //   71: invokevirtual 146	com/tencent/qqmail/model/qmdomain/QMFolder:getType	()I
    //   74: iconst_3
    //   75: if_icmpne +11 -> 86
    //   78: invokestatic 886	com/tencent/qqmail/model/contact/QMContactManager:sharedInstance	()Lcom/tencent/qqmail/model/contact/QMContactManager;
    //   81: aload 8
    //   83: invokevirtual 890	com/tencent/qqmail/model/contact/QMContactManager:syncProtocolHistoryContact	(Lcom/tencent/qqmail/model/qmdomain/MailInformation;)V
    //   86: aload 10
    //   88: invokevirtual 146	com/tencent/qqmail/model/qmdomain/QMFolder:getType	()I
    //   91: iconst_4
    //   92: if_icmpne +9 -> 101
    //   95: aload 9
    //   97: iconst_0
    //   98: invokevirtual 893	com/tencent/qqmail/model/qmdomain/MailStatus:setUnread	(Z)V
    //   101: iload_2
    //   102: ifeq +146 -> 248
    //   105: aload 9
    //   107: iconst_1
    //   108: invokevirtual 896	com/tencent/qqmail/model/qmdomain/MailStatus:setContentComplete	(Z)V
    //   111: iload 6
    //   113: aload_0
    //   114: getfield 54	com/tencent/qqmail/model/mail/QMMailProtocolManager:folderMgr	Lcom/tencent/qqmail/folderlist/QMFolderManager;
    //   117: iload 5
    //   119: invokevirtual 900	com/tencent/qqmail/folderlist/QMFolderManager:getDraftFolderId	(I)I
    //   122: if_icmpeq +60 -> 182
    //   125: iload 6
    //   127: aload_0
    //   128: getfield 54	com/tencent/qqmail/model/mail/QMMailProtocolManager:folderMgr	Lcom/tencent/qqmail/folderlist/QMFolderManager;
    //   131: iload 5
    //   133: invokevirtual 903	com/tencent/qqmail/folderlist/QMFolderManager:getSentFolderId	(I)I
    //   136: if_icmpeq +46 -> 182
    //   139: aload_0
    //   140: getfield 50	com/tencent/qqmail/model/mail/QMMailProtocolManager:sqliteHelper	Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   143: getfield 462	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:mail	Lcom/tencent/qqmail/model/mail/QMMailSQLite;
    //   146: aload 7
    //   148: iload 5
    //   150: iload 6
    //   152: invokevirtual 907	com/tencent/qqmail/model/mail/QMMailSQLite:getLocalMailsByFolderId	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;II)[J
    //   155: astore 9
    //   157: aload 9
    //   159: ifnull +23 -> 182
    //   162: aload 9
    //   164: arraylength
    //   165: ifle +17 -> 182
    //   168: aload_0
    //   169: getfield 50	com/tencent/qqmail/model/mail/QMMailProtocolManager:sqliteHelper	Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   172: getfield 462	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:mail	Lcom/tencent/qqmail/model/mail/QMMailSQLite;
    //   175: aload 7
    //   177: aload 9
    //   179: invokevirtual 630	com/tencent/qqmail/model/mail/QMMailSQLite:deleteMails	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;[J)V
    //   182: iload_2
    //   183: iconst_1
    //   184: if_icmpne +92 -> 276
    //   187: aload_1
    //   188: invokevirtual 275	com/tencent/qqmail/model/qmdomain/Mail:getInformation	()Lcom/tencent/qqmail/model/qmdomain/MailInformation;
    //   191: invokevirtual 911	com/tencent/qqmail/model/qmdomain/MailInformation:getBodyStructureInfos	()[Lcom/tencent/qqmail/protocol/ItemBodyStructureHelper$MailItemBodyStructureInfo;
    //   194: astore 9
    //   196: aload 9
    //   198: ifnull +78 -> 276
    //   201: aload 9
    //   203: arraylength
    //   204: istore 5
    //   206: iload_3
    //   207: istore_2
    //   208: iload_2
    //   209: iload 5
    //   211: if_icmpge +65 -> 276
    //   214: aload 9
    //   216: iload_2
    //   217: aaload
    //   218: astore 10
    //   220: aload_0
    //   221: getfield 50	com/tencent/qqmail/model/mail/QMMailProtocolManager:sqliteHelper	Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   224: getfield 462	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:mail	Lcom/tencent/qqmail/model/mail/QMMailSQLite;
    //   227: aload 7
    //   229: aload_1
    //   230: invokevirtual 275	com/tencent/qqmail/model/qmdomain/Mail:getInformation	()Lcom/tencent/qqmail/model/qmdomain/MailInformation;
    //   233: invokevirtual 601	com/tencent/qqmail/model/qmdomain/MailInformation:getId	()J
    //   236: aload 10
    //   238: invokevirtual 915	com/tencent/qqmail/model/mail/QMMailSQLite:insertMailPartInfo	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;JLcom/tencent/qqmail/protocol/ItemBodyStructureHelper$MailItemBodyStructureInfo;)V
    //   241: iload_2
    //   242: iconst_1
    //   243: iadd
    //   244: istore_2
    //   245: goto -37 -> 208
    //   248: aload 9
    //   250: iconst_0
    //   251: invokevirtual 896	com/tencent/qqmail/model/qmdomain/MailStatus:setContentComplete	(Z)V
    //   254: goto -143 -> 111
    //   257: astore_1
    //   258: bipush 6
    //   260: ldc 11
    //   262: aload_1
    //   263: invokestatic 384	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   266: invokestatic 209	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   269: aload 7
    //   271: invokevirtual 860	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   274: aconst_null
    //   275: areturn
    //   276: iload 4
    //   278: iconst_2
    //   279: iand
    //   280: ifne +35 -> 315
    //   283: aload 8
    //   285: aload_0
    //   286: getfield 50	com/tencent/qqmail/model/mail/QMMailProtocolManager:sqliteHelper	Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   289: getfield 462	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:mail	Lcom/tencent/qqmail/model/mail/QMMailSQLite;
    //   292: aload 7
    //   294: aload 8
    //   296: invokevirtual 918	com/tencent/qqmail/model/qmdomain/MailInformation:getConvReferenceHash	()I
    //   299: aload 8
    //   301: invokevirtual 921	com/tencent/qqmail/model/qmdomain/MailInformation:getConvContactHash	()I
    //   304: aload 8
    //   306: invokevirtual 878	com/tencent/qqmail/model/qmdomain/MailInformation:getFolderId	()I
    //   309: invokevirtual 925	com/tencent/qqmail/model/mail/QMMailSQLite:getConvHashForInfection	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;III)I
    //   312: invokevirtual 928	com/tencent/qqmail/model/qmdomain/MailInformation:setConvHash	(I)V
    //   315: aload_1
    //   316: invokevirtual 494	com/tencent/qqmail/model/qmdomain/Mail:getStatus	()Lcom/tencent/qqmail/model/qmdomain/MailStatus;
    //   319: iconst_1
    //   320: invokevirtual 931	com/tencent/qqmail/model/qmdomain/MailStatus:setNeedSync	(Z)V
    //   323: aload_0
    //   324: getfield 52	com/tencent/qqmail/model/mail/QMMailProtocolManager:mailMgr	Lcom/tencent/qqmail/model/mail/QMMailManager;
    //   327: aload 7
    //   329: aload_1
    //   330: sipush 1024
    //   333: invokevirtual 937	com/tencent/qqmail/model/mail/QMMailManager:saveMail	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;Lcom/tencent/qqmail/model/qmdomain/Mail;I)Z
    //   336: pop
    //   337: aload 7
    //   339: invokevirtual 857	com/tencent/moai/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   342: aload 7
    //   344: invokevirtual 860	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   347: aload_1
    //   348: areturn
    //   349: astore_1
    //   350: aload 7
    //   352: invokevirtual 860	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   355: aload_1
    //   356: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	this	QMMailProtocolManager
    //   0	357	1	paramMail	Mail
    //   0	357	2	paramInt	int
    //   1	206	3	i	int
    //   56	224	4	j	int
    //   42	170	5	k	int
    //   49	102	6	m	int
    //   9	342	7	localSQLiteDatabase	SQLiteDatabase
    //   29	276	8	localMailInformation	MailInformation
    //   35	214	9	localObject	Object
    //   67	170	10	localQMFolder	QMFolder
    // Exception table:
    //   from	to	target	type
    //   16	86	257	java/lang/Exception
    //   86	101	257	java/lang/Exception
    //   105	111	257	java/lang/Exception
    //   111	157	257	java/lang/Exception
    //   162	182	257	java/lang/Exception
    //   187	196	257	java/lang/Exception
    //   201	206	257	java/lang/Exception
    //   220	241	257	java/lang/Exception
    //   248	254	257	java/lang/Exception
    //   283	315	257	java/lang/Exception
    //   315	342	257	java/lang/Exception
    //   16	86	349	finally
    //   86	101	349	finally
    //   105	111	349	finally
    //   111	157	349	finally
    //   162	182	349	finally
    //   187	196	349	finally
    //   201	206	349	finally
    //   220	241	349	finally
    //   248	254	349	finally
    //   258	269	349	finally
    //   283	315	349	finally
    //   315	342	349	finally
  }
  
  private void parseMailContent(Mail paramMail1, Mail paramMail2, int paramInt)
  {
    int i = paramMail1.getInformation().getFolderId();
    long l1 = paramMail1.getInformation().getId();
    Object localObject1 = paramMail2.getContent().getBody();
    QMLog.log(4, "QMMailProtocolManager", "parseMailContent mailId:" + l1 + ", bodyLen:" + ((String)localObject1).length());
    ArrayList localArrayList1 = paramMail2.getInformation().getAttachList();
    ArrayList localArrayList2 = QMMailParser.parseBigAttachList((String)localObject1);
    ArrayList localArrayList3 = QMMailParser.parseEditAttachList((String)localObject1);
    Object localObject2 = QMMailParser.removeMailEditAttachArea(QMMailParser.removeFoxmailContentAttachArea(QMMailParser.removeNtesContentAttachArea((String)localObject1)));
    String str = MailUtil.getMailAbstract((String)localObject2);
    fillAttachList(paramMail1, localArrayList1);
    fillBigAttachList(paramMail1, localArrayList2);
    fillEditAttachList(paramMail1, localArrayList3);
    localObject1 = this.sqliteHelper.getWritableDatabase();
    this.sqliteHelper.mail.insertMailContent((SQLiteDatabase)localObject1, l1, (String)localObject2, "");
    this.sqliteHelper.mail.updateMailAbstract((SQLiteDatabase)localObject1, l1, str);
    this.folderMgr.updateLocalMailUnreadCountIntoFolder(i);
    boolean bool;
    label255:
    int j;
    long l2;
    if (!paramMail2.getStatus().isSearchMail())
    {
      this.sqliteHelper.mail.updateMailLoaded((SQLiteDatabase)localObject1, l1, true);
      if (paramMail2.getStatus().isSearchMail()) {
        break label438;
      }
      localObject2 = this.sqliteHelper.mail;
      bool = paramMail2.getStatus().isContentComplete();
      ((QMMailSQLite)localObject2).updateContentCompleteAttr((SQLiteDatabase)localObject1, new long[] { l1 }, bool);
      i = 0;
      if (paramMail2.getStatus().isIcs()) {
        i = (int)(0 | 0x20);
      }
      if ((!hasAttach(localArrayList1)) && ((localArrayList2 == null) || (localArrayList2.size() <= 0)))
      {
        j = i;
        if (localArrayList3 != null)
        {
          j = i;
          if (localArrayList3.size() <= 0) {}
        }
      }
      else
      {
        j = (int)(i | 0x200000);
      }
      if (paramMail2.getStatus().isSearchMail()) {
        break label476;
      }
      paramMail2 = this.sqliteHelper.mail;
      l2 = j;
      paramMail2.updateMailAttr((SQLiteDatabase)localObject1, new long[] { l1 }, l2);
    }
    for (;;)
    {
      if (containAttach(paramMail1))
      {
        copyPopAttach(paramMail1, paramInt);
        QMAttachManager.sharedInstance().updateMailAttaches((SQLiteDatabase)localObject1, paramMail1.getInformation().getAccountId(), paramMail1.getInformation(), false);
        this.sqliteHelper.mail.updateMailInfoFtsAttach((SQLiteDatabase)localObject1, paramMail1.getInformation());
      }
      return;
      this.sqliteHelper.mail.updateSearchMailLoaded((SQLiteDatabase)localObject1, l1, true);
      break;
      label438:
      localObject2 = this.sqliteHelper.mail;
      bool = paramMail2.getStatus().isContentComplete();
      ((QMMailSQLite)localObject2).updateSearchContentCompleteAttr((SQLiteDatabase)localObject1, new long[] { l1 }, bool);
      break label255;
      label476:
      paramMail2 = this.sqliteHelper.mail;
      l2 = j;
      paramMail2.updateSearchMailAttr((SQLiteDatabase)localObject1, new long[] { l1 }, l2);
    }
  }
  
  private void parseMailStatus(Mail[] paramArrayOfMail)
  {
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getWritableDatabase();
    localSQLiteDatabase.beginTransactionNonExclusive();
    for (;;)
    {
      try
      {
        ArrayList localArrayList = new ArrayList();
        int j = paramArrayOfMail.length;
        int i = 0;
        if (i < j)
        {
          Mail localMail = paramArrayOfMail[i];
          int k = localMail.getInformation().getFolderId();
          String str = localMail.getInformation().getRemoteId();
          boolean bool1 = localMail.getStatus().isUnread();
          boolean bool2 = localMail.getStatus().isStarred();
          this.sqliteHelper.mail.updateMailStatus(localSQLiteDatabase, k, str, bool1, bool2);
          if (!localArrayList.contains(Integer.valueOf(k))) {
            localArrayList.add(Integer.valueOf(k));
          }
        }
        else
        {
          paramArrayOfMail = localArrayList.iterator();
          if (paramArrayOfMail.hasNext())
          {
            i = ((Integer)paramArrayOfMail.next()).intValue();
            this.folderMgr.updateLocalMailUnreadCountIntoFolder(i);
            continue;
          }
        }
        i += 1;
      }
      catch (Exception paramArrayOfMail)
      {
        QMLog.log(6, "QMMailProtocolManager", Log.getStackTraceString(paramArrayOfMail));
        return;
        localSQLiteDatabase.setTransactionSuccessful();
        return;
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
    }
  }
  
  private void parseUpdateFolders(SQLiteDatabase paramSQLiteDatabase, Account paramAccount, QMFolder[] paramArrayOfQMFolder)
  {
    if ((paramArrayOfQMFolder == null) || (paramArrayOfQMFolder.length == 0)) {}
    ArrayList localArrayList2;
    do
    {
      ArrayList localArrayList1;
      do
      {
        return;
        QMLog.log(4, "QMMailProtocolManager", "parseUpdateFolders: " + paramArrayOfQMFolder.length);
        Object localObject = Lists.newArrayList();
        ArrayList localArrayList3 = Lists.newArrayList();
        localArrayList1 = Lists.newArrayList();
        localArrayList2 = Lists.newArrayList();
        QMFolder localQMFolder = this.folderMgr.getFolder(this.folderMgr.getTrashFolderId(paramAccount.getId()));
        int i = 0;
        if (i < paramArrayOfQMFolder.length)
        {
          QMLog.log(4, "QMMailProtocolManager", "parseUpdateFolders: remoteId: " + paramArrayOfQMFolder[i].getRemoteId() + ", name: " + paramArrayOfQMFolder[i].getName());
          if ((localQMFolder != null) && (StringUtils.equals(paramArrayOfQMFolder[i].getParentName(), localQMFolder.getRemoteId()))) {
            if (paramArrayOfQMFolder[i].getType() == 9) {
              localArrayList2.add(paramArrayOfQMFolder[i].getRemoteId());
            }
          }
          for (;;)
          {
            i += 1;
            break;
            localArrayList3.add(paramArrayOfQMFolder[i].getRemoteId());
            continue;
            if (paramArrayOfQMFolder[i].getType() == 9)
            {
              QMCalendarFolder localQMCalendarFolder = new QMCalendarFolder();
              localQMCalendarFolder.setAccountId(paramAccount.getId());
              localQMCalendarFolder.setName(paramArrayOfQMFolder[i].getName());
              localQMCalendarFolder.setCollectionId(paramArrayOfQMFolder[i].getRemoteId());
              localQMCalendarFolder.setType(13);
              localQMCalendarFolder.setId(QMCalendarFolder.generateId(localQMCalendarFolder));
              localArrayList1.add(localQMCalendarFolder);
            }
            else
            {
              ((ArrayList)localObject).add(paramArrayOfQMFolder[i]);
            }
          }
        }
        if (((ArrayList)localObject).size() > 0)
        {
          paramArrayOfQMFolder = ((ArrayList)localObject).iterator();
          while (paramArrayOfQMFolder.hasNext())
          {
            localObject = (QMFolder)paramArrayOfQMFolder.next();
            this.sqliteHelper.folder.renameFolder(paramSQLiteDatabase, paramAccount.getId(), ((QMFolder)localObject).getRemoteId(), ((QMFolder)localObject).getName());
          }
        }
        if (localArrayList3.size() > 0)
        {
          paramArrayOfQMFolder = (String[])localArrayList3.toArray(new String[localArrayList3.size()]);
          paramArrayOfQMFolder = this.sqliteHelper.folder.getFolderIds(paramAccount.getId(), paramArrayOfQMFolder);
          this.sqliteHelper.mail.updateMailsFolderId(paramSQLiteDatabase, paramArrayOfQMFolder, 0, false);
          this.sqliteHelper.folder.removeFolder(paramSQLiteDatabase, paramAccount.getId(), paramArrayOfQMFolder, 0, false);
        }
      } while (!QMSettingManager.sharedInstance().getCalendarDisplay());
      if (localArrayList1.size() > 0) {
        QMCalendarManager.getInstance().updateCalendarFolderAfterSync(localArrayList1);
      }
    } while (localArrayList2.size() <= 0);
    QMCalendarManager.getInstance().deleteFoldersOnCollectionIds(localArrayList2, paramAccount.getId());
  }
  
  private void preLoadMailContents(int paramInt1, String[] paramArrayOfString, int paramInt2)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0)) {
      break label9;
    }
    label9:
    label101:
    for (;;)
    {
      return;
      if (QMNetworkUtils.isWifiConnected())
      {
        SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getReadableDatabase();
        paramArrayOfString = this.sqliteHelper.mail.getNewMailIdByRemoteIds(localSQLiteDatabase, paramInt1, paramArrayOfString);
        if (paramArrayOfString == null) {
          break;
        }
        int j = paramArrayOfString.length;
        paramInt1 = 0;
        int i = 0;
        for (;;)
        {
          if (paramInt1 >= j) {
            break label101;
          }
          long l = paramArrayOfString[paramInt1];
          if (i > paramInt2) {
            break;
          }
          loadMail(this.sqliteHelper.mail.readMailSync(localSQLiteDatabase, l), 0, null);
          i += 1;
          paramInt1 += 1;
        }
      }
    }
  }
  
  private void removePopInMailId(long paramLong)
  {
    this.popInMailIdMap.remove(Long.valueOf(paramLong));
  }
  
  private void reportNoAppendInDomain(Account paramAccount)
  {
    SharedPreferences localSharedPreferences = SPManager.getSp("accounts_info");
    String str = localSharedPreferences.getString("no_append_in_domain", "");
    Object localObject = str.split(",");
    if (localObject.length > 0)
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        if (localObject[i].equals(String.valueOf(paramAccount.getId()))) {
          return;
        }
        i += 1;
      }
    }
    OssHelper.noAppendInDomain(new Object[] { paramAccount.getProfile().getDomain() });
    localObject = str;
    if (!str.equals("")) {
      localObject = str + ",";
    }
    paramAccount = (String)localObject + String.valueOf(paramAccount.getId());
    localSharedPreferences.edit().putString("no_append_in_domain", paramAccount).apply();
  }
  
  /* Error */
  private Mail saveEmlMail(Mail paramMail, long paramLong, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 50	com/tencent/qqmail/model/mail/QMMailProtocolManager:sqliteHelper	Lcom/tencent/qqmail/model/mail/QMMailSQLiteHelper;
    //   4: invokevirtual 506	com/tencent/qqmail/model/mail/QMMailSQLiteHelper:getWritableDatabase	()Lcom/tencent/moai/database/sqlite/SQLiteDatabase;
    //   7: astore 7
    //   9: aload 7
    //   11: invokevirtual 845	com/tencent/moai/database/sqlite/SQLiteDatabase:beginTransactionNonExclusive	()V
    //   14: aload_1
    //   15: invokevirtual 494	com/tencent/qqmail/model/qmdomain/Mail:getStatus	()Lcom/tencent/qqmail/model/qmdomain/MailStatus;
    //   18: iconst_0
    //   19: invokevirtual 893	com/tencent/qqmail/model/qmdomain/MailStatus:setUnread	(Z)V
    //   22: aload_1
    //   23: invokevirtual 494	com/tencent/qqmail/model/qmdomain/Mail:getStatus	()Lcom/tencent/qqmail/model/qmdomain/MailStatus;
    //   26: iconst_0
    //   27: invokevirtual 931	com/tencent/qqmail/model/qmdomain/MailStatus:setNeedSync	(Z)V
    //   30: aload_1
    //   31: invokevirtual 494	com/tencent/qqmail/model/qmdomain/Mail:getStatus	()Lcom/tencent/qqmail/model/qmdomain/MailStatus;
    //   34: iconst_1
    //   35: invokevirtual 1129	com/tencent/qqmail/model/qmdomain/MailStatus:setLoaded	(Z)V
    //   38: aload_1
    //   39: invokevirtual 494	com/tencent/qqmail/model/qmdomain/Mail:getStatus	()Lcom/tencent/qqmail/model/qmdomain/MailStatus;
    //   42: iconst_1
    //   43: invokevirtual 896	com/tencent/qqmail/model/qmdomain/MailStatus:setContentComplete	(Z)V
    //   46: aload_1
    //   47: invokevirtual 941	com/tencent/qqmail/model/qmdomain/Mail:getContent	()Lcom/tencent/qqmail/model/qmdomain/MailContent;
    //   50: invokevirtual 946	com/tencent/qqmail/model/qmdomain/MailContent:getBody	()Ljava/lang/String;
    //   53: astore 8
    //   55: aload_1
    //   56: invokevirtual 275	com/tencent/qqmail/model/qmdomain/Mail:getInformation	()Lcom/tencent/qqmail/model/qmdomain/MailInformation;
    //   59: invokevirtual 308	com/tencent/qqmail/model/qmdomain/MailInformation:getAttachList	()Ljava/util/ArrayList;
    //   62: astore 9
    //   64: aload 8
    //   66: invokestatic 959	com/tencent/qqmail/model/mail/QMMailParser:parseBigAttachList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   69: astore 10
    //   71: aload 8
    //   73: invokestatic 962	com/tencent/qqmail/model/mail/QMMailParser:parseEditAttachList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   76: astore 11
    //   78: aload_0
    //   79: aload_1
    //   80: aload 10
    //   82: invokespecial 981	com/tencent/qqmail/model/mail/QMMailProtocolManager:fillBigAttachList	(Lcom/tencent/qqmail/model/qmdomain/Mail;Ljava/util/ArrayList;)V
    //   85: aload_0
    //   86: aload_1
    //   87: aload 11
    //   89: invokespecial 983	com/tencent/qqmail/model/mail/QMMailProtocolManager:fillEditAttachList	(Lcom/tencent/qqmail/model/qmdomain/Mail;Ljava/util/ArrayList;)V
    //   92: aload 9
    //   94: ifnull +11 -> 105
    //   97: aload 9
    //   99: invokevirtual 248	java/util/ArrayList:size	()I
    //   102: ifgt +29 -> 131
    //   105: aload 10
    //   107: ifnull +11 -> 118
    //   110: aload 10
    //   112: invokevirtual 248	java/util/ArrayList:size	()I
    //   115: ifgt +16 -> 131
    //   118: aload 11
    //   120: ifnull +19 -> 139
    //   123: aload 11
    //   125: invokevirtual 248	java/util/ArrayList:size	()I
    //   128: ifle +11 -> 139
    //   131: aload_1
    //   132: invokevirtual 494	com/tencent/qqmail/model/qmdomain/Mail:getStatus	()Lcom/tencent/qqmail/model/qmdomain/MailStatus;
    //   135: iconst_1
    //   136: invokevirtual 1132	com/tencent/qqmail/model/qmdomain/MailStatus:setHasAttach	(Z)V
    //   139: aload 8
    //   141: invokestatic 966	com/tencent/qqmail/model/mail/QMMailParser:removeNtesContentAttachArea	(Ljava/lang/String;)Ljava/lang/String;
    //   144: invokestatic 969	com/tencent/qqmail/model/mail/QMMailParser:removeFoxmailContentAttachArea	(Ljava/lang/String;)Ljava/lang/String;
    //   147: invokestatic 972	com/tencent/qqmail/model/mail/QMMailParser:removeMailEditAttachArea	(Ljava/lang/String;)Ljava/lang/String;
    //   150: astore 8
    //   152: aload 8
    //   154: invokestatic 977	com/tencent/qqmail/protocol/MailUtil:getMailAbstract	(Ljava/lang/String;)Ljava/lang/String;
    //   157: astore 9
    //   159: aload_1
    //   160: invokevirtual 275	com/tencent/qqmail/model/qmdomain/Mail:getInformation	()Lcom/tencent/qqmail/model/qmdomain/MailInformation;
    //   163: aload 9
    //   165: invokevirtual 1135	com/tencent/qqmail/model/qmdomain/MailInformation:setAbstractContent	(Ljava/lang/String;)V
    //   168: aload_1
    //   169: invokevirtual 941	com/tencent/qqmail/model/qmdomain/Mail:getContent	()Lcom/tencent/qqmail/model/qmdomain/MailContent;
    //   172: aload 8
    //   174: invokevirtual 1138	com/tencent/qqmail/model/qmdomain/MailContent:setBody	(Ljava/lang/String;)V
    //   177: aload_0
    //   178: getfield 52	com/tencent/qqmail/model/mail/QMMailProtocolManager:mailMgr	Lcom/tencent/qqmail/model/mail/QMMailManager;
    //   181: aload 7
    //   183: aload_1
    //   184: sipush 1088
    //   187: invokevirtual 937	com/tencent/qqmail/model/mail/QMMailManager:saveMail	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;Lcom/tencent/qqmail/model/qmdomain/Mail;I)Z
    //   190: pop
    //   191: aload_0
    //   192: aload_1
    //   193: invokespecial 94	com/tencent/qqmail/model/mail/QMMailProtocolManager:updateAttachAttr	(Lcom/tencent/qqmail/model/qmdomain/Mail;)V
    //   196: iload 5
    //   198: ifeq +31 -> 229
    //   201: invokestatic 1143	com/tencent/qqmail/ftn/FtnManager:sharedInstance	()Lcom/tencent/qqmail/ftn/FtnManager;
    //   204: aload 6
    //   206: aload_1
    //   207: invokevirtual 275	com/tencent/qqmail/model/qmdomain/Mail:getInformation	()Lcom/tencent/qqmail/model/qmdomain/MailInformation;
    //   210: invokevirtual 601	com/tencent/qqmail/model/qmdomain/MailInformation:getId	()J
    //   213: invokevirtual 1147	com/tencent/qqmail/ftn/FtnManager:updateRefMailId	(Ljava/lang/String;J)Z
    //   216: pop
    //   217: aload 7
    //   219: invokevirtual 857	com/tencent/moai/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   222: aload 7
    //   224: invokevirtual 860	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   227: aload_1
    //   228: areturn
    //   229: invokestatic 1029	com/tencent/qqmail/attachment/QMAttachManager:sharedInstance	()Lcom/tencent/qqmail/attachment/QMAttachManager;
    //   232: aload 7
    //   234: lload_2
    //   235: aload_1
    //   236: invokevirtual 275	com/tencent/qqmail/model/qmdomain/Mail:getInformation	()Lcom/tencent/qqmail/model/qmdomain/MailInformation;
    //   239: invokevirtual 601	com/tencent/qqmail/model/qmdomain/MailInformation:getId	()J
    //   242: iload 4
    //   244: invokevirtual 1151	com/tencent/qqmail/attachment/QMAttachManager:updateAttachRefMailId	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;JJZ)V
    //   247: goto -30 -> 217
    //   250: astore 6
    //   252: bipush 6
    //   254: ldc 11
    //   256: aload 6
    //   258: invokestatic 384	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   261: invokestatic 209	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   264: aload 7
    //   266: invokevirtual 860	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   269: aload_1
    //   270: areturn
    //   271: astore_1
    //   272: aload 7
    //   274: invokevirtual 860	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   277: aload_1
    //   278: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	QMMailProtocolManager
    //   0	279	1	paramMail	Mail
    //   0	279	2	paramLong	long
    //   0	279	4	paramBoolean1	boolean
    //   0	279	5	paramBoolean2	boolean
    //   0	279	6	paramString	String
    //   7	266	7	localSQLiteDatabase	SQLiteDatabase
    //   53	120	8	str	String
    //   62	102	9	localObject	Object
    //   69	42	10	localArrayList1	ArrayList
    //   76	48	11	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   14	92	250	java/lang/Exception
    //   97	105	250	java/lang/Exception
    //   110	118	250	java/lang/Exception
    //   123	131	250	java/lang/Exception
    //   131	139	250	java/lang/Exception
    //   139	196	250	java/lang/Exception
    //   201	217	250	java/lang/Exception
    //   217	222	250	java/lang/Exception
    //   229	247	250	java/lang/Exception
    //   14	92	271	finally
    //   97	105	271	finally
    //   110	118	271	finally
    //   123	131	271	finally
    //   131	139	271	finally
    //   139	196	271	finally
    //   201	217	271	finally
    //   217	222	271	finally
    //   229	247	271	finally
    //   252	264	271	finally
  }
  
  private void updateAttachAttr(Mail paramMail)
  {
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    if (paramMail != null)
    {
      Object localObject2 = QMAttachManager.sharedInstance().getAttachList(paramMail.getInformation().getId());
      localArrayList1 = QMAttachManager.sharedInstance().getBigAttachList(paramMail.getInformation().getId());
      localArrayList2 = QMAttachManager.sharedInstance().getEditAttachList(paramMail.getInformation().getId());
      if ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0)) {
        break label352;
      }
      ArrayList localArrayList3 = new ArrayList();
      Object localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if ((localObject3 instanceof Attach))
        {
          localObject3 = (Attach)localObject3;
          if (!StringExtention.isNullOrEmpty(((Attach)localObject3).getProtocol().getCid()))
          {
            if (paramMail.getContent().getBody().contains(((Attach)localObject3).getProtocol().getCid())) {
              ((ArrayList)localObject1).add(String.valueOf(((Attach)localObject3).getHashId()));
            } else {
              localArrayList3.add(String.valueOf(((Attach)localObject3).getHashId()));
            }
          }
          else {
            localArrayList3.add(String.valueOf(((Attach)localObject3).getHashId()));
          }
        }
      }
      localObject2 = QMMailManager.sharedInstance().getSqliteHelper().getWritableDatabase();
      if (localArrayList3.size() > 0)
      {
        localObject3 = (String[])localArrayList3.toArray(new String[localArrayList3.size()]);
        QMAttachManager.sharedInstance().updateAttachTypeById((SQLiteDatabase)localObject2, (String[])localObject3, "attachment");
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject1 = (String[])((ArrayList)localObject1).toArray(new String[((ArrayList)localObject1).size()]);
        QMAttachManager.sharedInstance().updateAttachTypeById((SQLiteDatabase)localObject2, (String[])localObject1, "inline");
      }
      if ((localArrayList3.size() > 0) || ((localArrayList1 != null) && (localArrayList1.size() > 0)) || ((localArrayList2 != null) && (localArrayList2.size() > 0))) {
        QMMailManager.sharedInstance().setMailAttachAttr(paramMail.getInformation().getId());
      }
    }
    else
    {
      return;
    }
    QMMailManager.sharedInstance().resetMailAttachAttr(paramMail.getInformation().getId());
    return;
    label352:
    if (((localArrayList1 != null) && (localArrayList1.size() > 0)) || ((localArrayList2 != null) && (localArrayList2.size() > 0)))
    {
      QMMailManager.sharedInstance().setMailAttachAttr(paramMail.getInformation().getId());
      return;
    }
    QMMailManager.sharedInstance().resetMailAttachAttr(paramMail.getInformation().getId());
  }
  
  public void addFolder(Account paramAccount, QMFolder paramQMFolder, FolderOperationCallback paramFolderOperationCallback)
  {
    this.service.addFolder(paramAccount, paramQMFolder, paramFolderOperationCallback);
  }
  
  public void addRule(Account paramAccount, Exchange.ExchangeRule[] paramArrayOfExchangeRule)
  {
    this.service.addRule(paramAccount, paramArrayOfExchangeRule);
  }
  
  public void appendFile()
  {
    this.service.appendFile();
  }
  
  public MailServiceProvider autoFillMailProvider(MailServiceProvider paramMailServiceProvider, String paramString, boolean paramBoolean)
  {
    try
    {
      paramString = this.service.autoFillMailProvider(paramMailServiceProvider, paramString, paramBoolean);
      return paramString;
    }
    catch (Exception paramString)
    {
      QMLog.log(4, "QMMailProtocolManager", "autoFillMailProvider error " + paramString.getMessage());
    }
    return paramMailServiceProvider;
  }
  
  public void checkMail(Map<QMFolder, List<Pair<String, Long>>> paramMap, CheckMailCallback paramCheckMailCallback)
  {
    QMLog.log(4, "QMMailProtocolManager", "other sync");
    QMFolder[] arrayOfQMFolder = new QMFolder[paramMap.keySet().size()];
    paramMap = paramMap.keySet().iterator();
    int i = 0;
    while (paramMap.hasNext())
    {
      arrayOfQMFolder[i] = ((QMFolder)paramMap.next());
      i += 1;
    }
    if (paramCheckMailCallback != null) {
      paramCheckMailCallback.onSync(arrayOfQMFolder);
    }
  }
  
  public void downloadAttach(MailInformation paramMailInformation, Attach paramAttach, boolean paramBoolean)
  {
    long l = paramMailInformation.getId();
    QMMailProtocolManager.31 local31 = new QMMailProtocolManager.31(this, paramAttach.getHashId(), l, AccountManager.shareInstance().getAccountList().getAccountById(paramMailInformation.getAccountId()).getProfile(), paramAttach);
    this.service.downloadAttach(paramMailInformation, paramAttach, paramBoolean, local31);
  }
  
  public void downloadInlineImg(MailInformation paramMailInformation, Attach paramAttach, ProtocolInlineImgCallback paramProtocolInlineImgCallback)
  {
    paramProtocolInlineImgCallback = new QMMailProtocolManager.30(this, paramProtocolInlineImgCallback);
    this.service.downloadAttach(paramMailInformation, paramAttach, true, paramProtocolInlineImgCallback);
  }
  
  public void downloadSendMailAttach(MailInformation paramMailInformation, Attach paramAttach, boolean paramBoolean, MailManagerDelegate paramMailManagerDelegate)
  {
    paramMailManagerDelegate = new QMMailProtocolManager.29(this, paramMailManagerDelegate);
    this.service.downloadAttach(paramMailInformation, paramAttach, paramBoolean, paramMailManagerDelegate);
  }
  
  public void feedbackMail(ComposeMailUI paramComposeMailUI, String paramString1, String paramString2, String paramString3, int paramInt, QMGeneralCallback paramQMGeneralCallback)
  {
    this.service.feedbackMail(paramComposeMailUI, paramString1, paramString2, paramString3, paramInt, paramQMGeneralCallback);
  }
  
  public void fetchFolderList(Account paramAccount, FolderListCallback paramFolderListCallback)
  {
    paramFolderListCallback = new QMMailProtocolManager.10(this, paramAccount, paramFolderListCallback);
    this.service.fetchFolderList(paramAccount, paramFolderListCallback);
  }
  
  public void initActiveSync()
  {
    this.service.initActiveSync();
  }
  
  public void initFolderListSyncKeyMapping(Map<Integer, String> paramMap)
  {
    this.service.initFolderListSyncKeyMapping(paramMap);
  }
  
  public void initFolderSyncKeyMapping(Map<Integer, String> paramMap)
  {
    this.service.initFolderSyncKeyMapping(paramMap);
  }
  
  public void initList(int paramInt)
  {
    QMFolder localQMFolder = this.sqliteHelper.folder.getFolderById(paramInt);
    if (localQMFolder == null) {
      QMLog.log(5, "QMMailProtocolManager", "loadList, folder not exists!");
    }
    do
    {
      return;
      localObject = "load_list_" + paramInt;
    } while (RequestFilter.isRequestOnRunning((String)localObject));
    RequestFilter.setRequestRunningState((String)localObject);
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(localQMFolder.getAccountId());
    Object localObject = new ListCompleteCallback(new QMMailProtocolManager.13(this, paramInt), new QMMailProtocolManager.14(this, (String)localObject));
    fetchMailList(localAccount, localQMFolder, new ArrayList(), false, false, (IListCallback)localObject);
  }
  
  public void initPopFolders(int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getWritableDatabase();
    QMFolder localQMFolder = new QMFolder();
    localQMFolder.setAccountId(paramInt);
    localQMFolder.setSvrCount(-1);
    String str = QMApplicationContext.sharedInstance().getString(2131693913);
    localQMFolder.setRemoteId("_REMOTE_ID_" + QMMath.hashPositivetInt(str));
    localQMFolder.setName(str);
    localQMFolder.setSequence(this.folderMgr.getFolderSequenze(0, 1));
    localQMFolder.setType(1);
    this.sqliteHelper.folder.insertFolder(localSQLiteDatabase, localQMFolder);
    localQMFolder = new QMFolder();
    localQMFolder.setAccountId(paramInt);
    localQMFolder.setSvrCount(0);
    str = QMApplicationContext.sharedInstance().getString(2131693924);
    localQMFolder.setRemoteId("_REMOTE_ID_" + QMMath.hashPositivetInt(str));
    localQMFolder.setName(str);
    localQMFolder.setSequence(this.folderMgr.getFolderSequenze(1, 16));
    localQMFolder.setType(16);
    localQMFolder.setVirtual(true);
    this.sqliteHelper.folder.insertFolder(localSQLiteDatabase, localQMFolder);
    localQMFolder = new QMFolder();
    localQMFolder.setAccountId(paramInt);
    localQMFolder.setSvrCount(0);
    str = QMApplicationContext.sharedInstance().getString(2131693920);
    localQMFolder.setRemoteId("_REMOTE_ID_" + QMMath.hashPositivetInt(str));
    localQMFolder.setName(str);
    localQMFolder.setSequence(this.folderMgr.getFolderSequenze(2, 3));
    localQMFolder.setType(3);
    localQMFolder.setVirtual(true);
    this.sqliteHelper.folder.insertFolder(localSQLiteDatabase, localQMFolder);
    localQMFolder = new QMFolder();
    localQMFolder.setAccountId(paramInt);
    localQMFolder.setSvrCount(0);
    str = QMApplicationContext.sharedInstance().getString(2131693928);
    localQMFolder.setRemoteId("_REMOTE_ID_" + QMMath.hashPositivetInt(str));
    localQMFolder.setName(str);
    localQMFolder.setSequence(this.folderMgr.getFolderSequenze(3, 5));
    localQMFolder.setType(5);
    localQMFolder.setVirtual(true);
    this.sqliteHelper.folder.insertFolder(localSQLiteDatabase, localQMFolder);
    localQMFolder = new QMFolder();
    localQMFolder.setAccountId(paramInt);
    localQMFolder.setSvrCount(0);
    str = QMApplicationContext.sharedInstance().getString(2131693908);
    localQMFolder.setRemoteId("_REMOTE_ID_" + QMMath.hashPositivetInt(str));
    localQMFolder.setName(str);
    localQMFolder.setSequence(this.folderMgr.getFolderSequenze(4, 4));
    localQMFolder.setType(4);
    localQMFolder.setVirtual(true);
    this.sqliteHelper.folder.insertFolder(localSQLiteDatabase, localQMFolder);
    localQMFolder = new QMFolder();
    localQMFolder.setAccountId(paramInt);
    localQMFolder.setSvrCount(0);
    str = QMApplicationContext.sharedInstance().getString(2131693923);
    localQMFolder.setRemoteId("_REMOTE_ID_" + QMMath.hashPositivetInt(str));
    localQMFolder.setName(str);
    localQMFolder.setSequence(this.folderMgr.getFolderSequenze(5, 6));
    localQMFolder.setType(6);
    localQMFolder.setVirtual(true);
    this.sqliteHelper.folder.insertFolder(localSQLiteDatabase, localQMFolder);
  }
  
  public void initPopList(Account paramAccount)
  {
    QMFolder localQMFolder = this.sqliteHelper.folder.getFolderById(this.folderMgr.getInboxFolderId(paramAccount.getId()));
    int i = localQMFolder.getId();
    Object localObject = "load_list_" + localQMFolder.getId();
    if (RequestFilter.isRequestOnRunning((String)localObject)) {
      return;
    }
    RequestFilter.setRequestRunningState((String)localObject);
    localObject = new ListCompleteCallback(new QMMailProtocolManager.11(this, i), new QMMailProtocolManager.12(this, (String)localObject));
    fetchMailList(paramAccount, localQMFolder, new ArrayList(), true, false, (IListCallback)localObject);
  }
  
  public void initSync(Account paramAccount)
  {
    int i = paramAccount.getId();
    String str = "sync_" + i;
    if (RequestFilter.isRequestOnRunning(str)) {
      return;
    }
    RequestFilter.setRequestRunningState(str);
    QMWatcherCenter.triggerSyncBegin(paramAccount.getId(), false);
    fetchFolderList(paramAccount, new QMMailProtocolManager.4(this, str, i, paramAccount));
  }
  
  public boolean isPopMailComplete(long paramLong)
  {
    return this.sqliteHelper.mail.isPopMailComplete(this.sqliteHelper.getReadableDatabase(), paramLong);
  }
  
  public boolean isPopMailDeleted(long paramLong)
  {
    return this.sqliteHelper.mail.isPOPMailDeleted(this.sqliteHelper.getReadableDatabase(), paramLong);
  }
  
  public void loadMail(Mail paramMail, int paramInt, MailManagerDelegate paramMailManagerDelegate)
  {
    boolean bool1;
    boolean bool2;
    if ((paramInt & 0x1000) != 0)
    {
      bool1 = true;
      if ((paramInt & 0x100) == 0) {
        break label133;
      }
      bool2 = true;
      label22:
      if ((paramInt & 0x80) == 0) {
        break label139;
      }
    }
    label133:
    label139:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramInt = paramMail.getInformation().getAccountId();
      int i = paramMail.getInformation().getFolderId();
      long l = paramMail.getInformation().getId();
      Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
      Profile localProfile = localAccount.getProfile();
      QMFolder localQMFolder = this.folderMgr.getFolder(i);
      paramMailManagerDelegate = new QMMailProtocolManager.27(this, paramMailManagerDelegate, l, bool3, bool2, localProfile, paramInt, paramMail);
      this.service.loadMail(localAccount, localQMFolder, paramMail, bool1, bool3, paramMailManagerDelegate);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label22;
    }
  }
  
  public void loadMailFromEML(int paramInt, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    QMMailProtocolManager.35 local35 = new QMMailProtocolManager.35(this, paramLong2, paramBoolean1, paramBoolean2, paramString1, paramInt);
    QMMailProtocolService localQMMailProtocolService = this.service;
    if (paramBoolean2) {}
    for (;;)
    {
      localQMMailProtocolService.loadMailFromEML(paramInt, paramLong1, paramString1, paramString2, local35);
      return;
      paramString1 = String.valueOf(paramLong2);
    }
  }
  
  public void loadMore(QMFolder paramQMFolder, IListCallback paramIListCallback)
  {
    String str = "load_list_" + paramQMFolder.getId();
    if (RequestFilter.isRequestOnRunning(str)) {
      return;
    }
    RequestFilter.setRequestRunningState(str);
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramQMFolder.getAccountId());
    if ((localAccount != null) && (localAccount.isPopMail())) {}
    for (Object localObject = new QMSyncAccountCursor(this.sqliteHelper, localAccount.getId());; localObject = new QMSyncFolderCursor(this.sqliteHelper, paramQMFolder.getId(), true))
    {
      ArrayList localArrayList = this.mailMgr.getRemoteIds((QMMailListCursor)localObject);
      ((QMMailListCursor)localObject).close();
      fetchMailList(localAccount, paramQMFolder, localArrayList, false, false, new ListCompleteCallback(paramIListCallback, new QMMailProtocolManager.15(this, str)));
      return;
    }
  }
  
  public void loadTranslateMail(Mail paramMail, MailManagerDelegate paramMailManagerDelegate)
  {
    MailManagerDelegate localMailManagerDelegate = new MailManagerDelegate();
    localMailManagerDelegate.setOnBeforeSend(new QMMailProtocolManager.32(this, paramMailManagerDelegate));
    localMailManagerDelegate.setOnSuccess(new QMMailProtocolManager.33(this, paramMailManagerDelegate));
    localMailManagerDelegate.setOnError(new QMMailProtocolManager.34(this, paramMailManagerDelegate));
    this.service.loadTranslateMail(paramMail, localMailManagerDelegate);
  }
  
  public void login(Profile paramProfile, LoginCallback paramLoginCallback, boolean paramBoolean)
  {
    this.service.login(paramProfile, paramLoginCallback, paramBoolean);
  }
  
  public void logout(Profile paramProfile, LogoutCallback paramLogoutCallback)
  {
    this.service.logout(paramProfile, paramLogoutCallback);
  }
  
  public void moveMails(Account paramAccount, QMFolder paramQMFolder1, QMFolder paramQMFolder2, List<String> paramList1, List<String> paramList2, MailManagerDelegate paramMailManagerDelegate)
  {
    if ((paramAccount == null) || (paramQMFolder1 == null) || (paramQMFolder2 == null) || (paramList1 == null))
    {
      paramList2 = new StringBuilder().append("moveMails, illegal params, account: ");
      if (paramAccount == null) {}
      for (paramAccount = null;; paramAccount = paramAccount.getEmail())
      {
        QMLog.log(5, "QMMailProtocolManager", paramAccount + ", folder: " + paramQMFolder1 + ", toFolder: " + paramQMFolder2 + ", mailIds: " + paramList1);
        return;
      }
    }
    this.service.moveMails(paramAccount, paramQMFolder1, paramQMFolder2, paramList1, paramList2, paramMailManagerDelegate);
  }
  
  public void notifyIdle()
  {
    this.service.notifyIdle();
  }
  
  public void popIn(QMMailListCursor paramQMMailListCursor)
  {
    if (paramQMMailListCursor == null) {}
    Object localObject3;
    do
    {
      return;
      localObject3 = paramQMMailListCursor.cloneCursor();
    } while (localObject3 == null);
    Object localObject4 = new int[100];
    Arrays.fill((int[])localObject4, -2147483648);
    SparseArray localSparseArray1 = new SparseArray();
    SparseArray localSparseArray2 = new SparseArray();
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      int k;
      int m;
      try
      {
        j = ((Cursor)localObject3).getCount();
        i = 0;
        if (i < j)
        {
          localObject2 = paramQMMailListCursor.getItem((Cursor)localObject3, (int[])localObject4, ((Cursor)localObject3).moveToPosition(i));
          localObject1 = ((Mail)localObject2).getInformation();
          if ((((Mail)localObject2).getStatus().isAbstractLoaded()) || ((((MailInformation)localObject1).getAbstractContent() != null) && (!"".equals(((MailInformation)localObject1).getAbstractContent())))) {
            break label644;
          }
          k = ((MailInformation)localObject1).getAccountId();
          m = ((MailInformation)localObject1).getFolderId();
          if (((Mail)localObject2).getStatus().isAdConv())
          {
            localObject2 = this.mailMgr.getRecentAdvertiseMail(k);
            localObject1 = localObject2;
            if (!((Mail)localObject2).getStatus().isConversation()) {
              break label641;
            }
            localObject1 = this.mailMgr.getRecentConvChild(m, ((Mail)localObject2).getInformation().getConvHash());
            if (localObject1 == null) {
              break label644;
            }
            if (localSparseArray2.get(m) == null) {
              localSparseArray2.put(m, new ArrayList());
            }
            if (!((ArrayList)localSparseArray2.get(m)).contains(localObject1)) {
              ((ArrayList)localSparseArray2.get(m)).add(localObject1);
            }
            if (localSparseArray1.get(k) == null) {
              localSparseArray1.put(k, new ArrayList());
            }
            if (((ArrayList)localSparseArray1.get(k)).contains(Integer.valueOf(m))) {
              break label644;
            }
            ((ArrayList)localSparseArray1.get(k)).add(Integer.valueOf(m));
            break label644;
          }
          localObject1 = localObject2;
          if (!((Mail)localObject2).getStatus().isConversation()) {
            break label641;
          }
          localObject1 = this.mailMgr.getRecentConvChild(m, ((Mail)localObject2).getInformation().getConvHash());
          continue;
        }
      }
      catch (Exception paramQMMailListCursor)
      {
        QMLog.log(6, "QMMailProtocolManager", "", paramQMMailListCursor);
        ((Cursor)localObject3).close();
        continue;
      }
      finally
      {
        ((Cursor)localObject3).close();
      }
      int i = 0;
      if (i < localSparseArray1.size())
      {
        k = localSparseArray1.keyAt(i);
        paramQMMailListCursor = AccountManager.shareInstance().getAccountList().getAccountById(k);
        if ((paramQMMailListCursor == null) || (paramQMMailListCursor.isQQMail())) {
          i += 1;
        }
      }
      else
      {
        break;
      }
      int j = 0;
      label448:
      if (j < localSparseArray2.size())
      {
        m = localSparseArray2.keyAt(j);
        localObject1 = this.folderMgr.getFolder(m);
        if (localObject1 != null) {
          break label488;
        }
      }
      for (;;)
      {
        j += 1;
        break label448;
        break;
        label488:
        if (((ArrayList)localSparseArray1.get(k)).contains(Integer.valueOf(m)))
        {
          localObject4 = (ArrayList)localSparseArray2.get(m);
          localObject2 = new QMMailProtocolManager.28(this, m, k);
          if ((localObject4 != null) && (((ArrayList)localObject4).size() > 0))
          {
            localObject3 = new ArrayList();
            localObject4 = ((ArrayList)localObject4).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              Mail localMail = (Mail)((Iterator)localObject4).next();
              if (!isPopIn(localMail.getInformation().getId()))
              {
                addPopInMailId(localMail.getInformation().getId());
                ((ArrayList)localObject3).add(localMail);
              }
            }
            this.service.loadMailAbstract(paramQMMailListCursor, (QMFolder)localObject1, (ArrayList)localObject3, (LoadMailAbstractCallback)localObject2);
          }
        }
      }
      label641:
      continue;
      label644:
      i += 1;
    }
  }
  
  public void removeFolder(Account paramAccount, QMFolder paramQMFolder, FolderOperationCallback paramFolderOperationCallback)
  {
    this.service.removeFolder(paramAccount, paramQMFolder, paramFolderOperationCallback);
  }
  
  public void removeFolderListSyncKey(int paramInt)
  {
    this.service.removeFolderListSyncKey(paramInt);
  }
  
  public void removeFolderSyncKey(int[] paramArrayOfInt)
  {
    this.service.removeFolderSyncKey(paramArrayOfInt);
  }
  
  public void removeMails(Account paramAccount, QMFolder paramQMFolder, List<String> paramList1, List<String> paramList2, MailManagerDelegate paramMailManagerDelegate)
  {
    if ((paramAccount == null) || (paramQMFolder == null) || (paramList1 == null))
    {
      paramList2 = new StringBuilder().append("removeMails, illegal params, account: ");
      if (paramAccount == null) {}
      for (paramAccount = null;; paramAccount = paramAccount.getEmail())
      {
        QMLog.log(5, "QMMailProtocolManager", paramAccount + ", folder: " + paramQMFolder + ", mailIds: " + paramList1);
        return;
      }
    }
    if (paramAccount.isPopMail()) {
      QMMailManager.sharedInstance().savePurgedPopMailIds(paramAccount.getId(), paramList1);
    }
    this.service.removeMails(paramAccount, paramQMFolder, paramList1, paramList2, paramMailManagerDelegate);
  }
  
  public void renameFolder(Account paramAccount, QMFolder paramQMFolder, String paramString, FolderOperationCallback paramFolderOperationCallback)
  {
    this.service.renameFolder(paramAccount, paramQMFolder, paramString, paramFolderOperationCallback);
  }
  
  public void searchExchangeGlobalAddressList(Account paramAccount, String paramString)
  {
    QMMailProtocolManager.26 local26 = new QMMailProtocolManager.26(this, paramAccount, paramString);
    this.service.searchExchangeGlobalAddressList(paramAccount, paramString, local26);
  }
  
  public QMProtocolRequest searchMails(QMSearchCursor paramQMSearchCursor, SearchInfo paramSearchInfo, SearchMailQueueHandler.SearchMailCallback paramSearchMailCallback)
  {
    paramSearchMailCallback = new QMMailProtocolManager.25(this, paramSearchInfo, paramSearchMailCallback, AccountManager.shareInstance().getAccountList().getAccountById(paramSearchInfo.getAccountId()).getProfile());
    return this.service.searchMails(paramQMSearchCursor, paramSearchInfo, paramSearchMailCallback);
  }
  
  public QMProtocolRequest sendMail(Account paramAccount, ComposeMailUI paramComposeMailUI, MailManagerDelegate paramMailManagerDelegate)
  {
    MailManagerDelegate localMailManagerDelegate = new MailManagerDelegate();
    localMailManagerDelegate.setOnBeforeSend(new QMMailProtocolManager.20(this, paramMailManagerDelegate));
    localMailManagerDelegate.setOnSendData(new QMMailProtocolManager.21(this, paramMailManagerDelegate));
    localMailManagerDelegate.setOnSuccess(new QMMailProtocolManager.22(this, paramComposeMailUI, paramMailManagerDelegate, paramAccount));
    localMailManagerDelegate.setOnError(new QMMailProtocolManager.23(this, paramMailManagerDelegate));
    localMailManagerDelegate.setOnComplete(new QMMailProtocolManager.24(this, paramMailManagerDelegate));
    return this.service.sendMail(paramAccount, paramComposeMailUI, localMailManagerDelegate);
  }
  
  public void setFolderListSyncKey(int paramInt, String paramString)
  {
    this.service.setFolderListSyncKey(paramInt, paramString);
  }
  
  public void setFolderSyncKey(int paramInt, String paramString)
  {
    this.service.setFolderSyncKey(paramInt, paramString);
  }
  
  public void starMails(Account paramAccount, QMFolder paramQMFolder, boolean paramBoolean, List<String> paramList1, List<String> paramList2, MailManagerDelegate paramMailManagerDelegate)
  {
    if ((paramAccount == null) || (paramQMFolder == null) || (paramList1 == null))
    {
      paramList2 = new StringBuilder().append("starMails, illegal params, account: ");
      if (paramAccount == null) {}
      for (paramAccount = null;; paramAccount = paramAccount.getEmail())
      {
        QMLog.log(5, "QMMailProtocolManager", paramAccount + ", folder: " + paramQMFolder + ", mailIds: " + paramList1);
        return;
      }
    }
    this.service.starMails(paramAccount, paramQMFolder, paramBoolean, paramList1, paramList2, paramMailManagerDelegate);
  }
  
  public void startIdle(Account paramAccount, QMFolder paramQMFolder, IdleCallback paramIdleCallback)
  {
    this.service.startIdle(paramAccount, paramQMFolder, paramIdleCallback);
  }
  
  public void stopIdle(Account paramAccount)
  {
    this.service.stopIdle(paramAccount);
  }
  
  public boolean sync(Account paramAccount, boolean paramBoolean, Runnable paramRunnable)
  {
    int i = paramAccount.getId();
    String str = "sync_" + i;
    if (RequestFilter.isRequestOnRunning(str))
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      return false;
    }
    RequestFilter.setRequestRunningState(str);
    QMMailProtocolManager.1 local1 = new QMMailProtocolManager.1(this, i);
    QMMailProtocolManager.2 local2 = new QMMailProtocolManager.2(this, i);
    paramRunnable = new QMMailProtocolManager.3(this, i, paramRunnable, str);
    if (paramAccount.isPopMail()) {
      syncPop(paramAccount, new ListStatusCompleteCallback(local1, paramRunnable));
    }
    for (;;)
    {
      return true;
      if (paramBoolean)
      {
        syncFolder(this.sqliteHelper.folder.getFolderById(this.folderMgr.getInboxFolderId(i)), new ListStatusCompleteCallback(local1, paramRunnable));
      }
      else
      {
        syncFolders(paramAccount, new ListStatusCompleteCallback(null, null));
        fetchFolderList(paramAccount, new FolderListCompleteCallback(local2, paramRunnable));
      }
    }
  }
  
  public void syncFolder(QMFolder paramQMFolder, IListStatusCallback paramIListStatusCallback)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramQMFolder.getAccountId());
    int i = localAccount.getId();
    int j = paramQMFolder.getId();
    String str = "update_list_" + i + j;
    if (RequestFilter.isRequestOnRunning(str))
    {
      QMWatcherCenter.triggerSyncSuccess(i);
      QMWatcherCenter.triggerSyncEnd(i, true);
      if (paramIListStatusCallback != null) {
        paramIListStatusCallback.success(false, 0, 0);
      }
      return;
    }
    RequestFilter.setRequestRunningState(str);
    paramIListStatusCallback = new ListStatusCompleteCallback(new QMMailProtocolManager.7(this, i, paramIListStatusCallback, paramQMFolder, j, localAccount), new QMMailProtocolManager.8(this, i, str));
    this.service.syncFolderStatus(localAccount, paramQMFolder, paramIListStatusCallback);
  }
  
  public void syncFolders(Account paramAccount, IListStatusCallback paramIListStatusCallback)
  {
    Object localObject1 = filterNotLoadedFolder(paramAccount, this.sqliteHelper.folder.getFolders(paramAccount.getId(), true, new int[] { 16, 14 }));
    if (paramIListStatusCallback != null) {
      paramIListStatusCallback.process();
    }
    paramAccount = new ArrayList();
    Object localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      paramAccount.add(Integer.valueOf(((QMFolder)((Iterator)localObject2).next()).getId()));
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (QMFolder)((Iterator)localObject1).next();
      syncFolder((QMFolder)localObject2, new ListStatusCompleteCallback(null, new QMMailProtocolManager.9(this, paramAccount, (QMFolder)localObject2, paramIListStatusCallback)));
    }
  }
  
  public void syncPop(Account paramAccount, IListStatusCallback paramIListStatusCallback)
  {
    int i = paramAccount.getId();
    int j = this.folderMgr.getInboxFolderId(i);
    QMFolder localQMFolder = this.sqliteHelper.folder.getFolderById(j);
    if (j == 0) {}
    String str;
    do
    {
      return;
      str = "pop_list_" + i;
      if (!RequestFilter.isRequestOnRunning(str)) {
        break;
      }
      QMWatcherCenter.triggerSyncSuccess(i);
      QMWatcherCenter.triggerSyncEnd(i, true);
    } while (paramIListStatusCallback == null);
    paramIListStatusCallback.success(false, 0, 0);
    return;
    RequestFilter.setRequestRunningState(str);
    QMSyncAccountCursor localQMSyncAccountCursor = new QMSyncAccountCursor(this.sqliteHelper, i);
    ArrayList localArrayList = this.mailMgr.getRemoteIds(localQMSyncAccountCursor);
    localQMSyncAccountCursor.close();
    updateList(paramAccount, localQMFolder, localArrayList, new ListCompleteCallback(new QMMailProtocolManager.5(this, i, paramIListStatusCallback), new QMMailProtocolManager.6(this, i, str)));
  }
  
  public void unreadMails(Account paramAccount, QMFolder paramQMFolder, boolean paramBoolean, List<String> paramList1, List<String> paramList2, MailManagerDelegate paramMailManagerDelegate)
  {
    if ((paramAccount == null) || (paramQMFolder == null) || (paramList1 == null))
    {
      paramList2 = new StringBuilder().append("unreadMails, illegal params, account: ");
      if (paramAccount == null) {}
      for (paramAccount = null;; paramAccount = paramAccount.getEmail())
      {
        QMLog.log(5, "QMMailProtocolManager", paramAccount + ", folder: " + paramQMFolder + ", mailIds: " + paramList1);
        return;
      }
    }
    this.service.unreadMails(paramAccount, paramQMFolder, paramBoolean, paramList1, paramList2, paramMailManagerDelegate);
  }
  
  public void updateImapPartInfo(Mail paramMail, int paramInt)
  {
    if ((paramMail != null) && (paramInt == 1))
    {
      ItemBodyStructureHelper.MailItemBodyStructureInfo[] arrayOfMailItemBodyStructureInfo = paramMail.getInformation().getBodyStructureInfos();
      if ((!QMMailManager.sharedInstance().hasMailPartInfo(paramMail.getInformation().getId())) && (arrayOfMailItemBodyStructureInfo != null) && (arrayOfMailItemBodyStructureInfo.length > 0))
      {
        QMLog.log(4, "QMMailProtocolManager", "update imap body structure info:" + arrayOfMailItemBodyStructureInfo.length);
        int i = arrayOfMailItemBodyStructureInfo.length;
        paramInt = 0;
        while (paramInt < i)
        {
          ItemBodyStructureHelper.MailItemBodyStructureInfo localMailItemBodyStructureInfo = arrayOfMailItemBodyStructureInfo[paramInt];
          this.sqliteHelper.mail.insertMailPartInfo(this.sqliteHelper.getWritableDatabase(), paramMail.getInformation().getId(), localMailItemBodyStructureInfo);
          paramInt += 1;
        }
      }
    }
  }
  
  public void updateList(Account paramAccount, QMFolder paramQMFolder, ArrayList<String> paramArrayList, IListCallback paramIListCallback)
  {
    updateList(paramAccount, paramQMFolder, paramArrayList, false, paramIListCallback);
  }
  
  public void updateList(Account paramAccount, QMFolder paramQMFolder, ArrayList<String> paramArrayList, boolean paramBoolean, IListCallback paramIListCallback)
  {
    String str = "update_list_" + paramQMFolder.getId();
    if (RequestFilter.isRequestOnRunning(str))
    {
      QMLog.log(5, "QMMailProtocolManager", "updateList is requesting, account: " + paramAccount.getEmail() + ", folder: " + paramQMFolder);
      if (paramIListCallback != null) {
        paramIListCallback.success(new long[0], false);
      }
      return;
    }
    RequestFilter.setRequestRunningState(str);
    fetchMailList(paramAccount, paramQMFolder, paramArrayList, true, paramBoolean, new ListCompleteCallback(paramIListCallback, new QMMailProtocolManager.16(this, str)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager
 * JD-Core Version:    0.7.0.1
 */