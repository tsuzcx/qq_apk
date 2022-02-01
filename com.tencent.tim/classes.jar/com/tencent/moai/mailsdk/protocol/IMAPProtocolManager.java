package com.tencent.moai.mailsdk.protocol;

import android.os.SystemClock;
import android.util.Log;
import com.tencent.moai.mailsdk.MailParser;
import com.tencent.moai.mailsdk.callback.AttachmentCallBack;
import com.tencent.moai.mailsdk.callback.CheckMailCallback;
import com.tencent.moai.mailsdk.callback.FolderCallBack;
import com.tencent.moai.mailsdk.callback.FolderListCallBack;
import com.tencent.moai.mailsdk.callback.FolderSyncImapCallBack;
import com.tencent.moai.mailsdk.callback.IdleCallback;
import com.tencent.moai.mailsdk.callback.LoginCallBack;
import com.tencent.moai.mailsdk.callback.LogoutCallBack;
import com.tencent.moai.mailsdk.callback.MailAbstractCallBack;
import com.tencent.moai.mailsdk.callback.MailCallBack;
import com.tencent.moai.mailsdk.callback.MailListCallBack;
import com.tencent.moai.mailsdk.callback.MailOperationCallback;
import com.tencent.moai.mailsdk.callback.SearchMailCallback;
import com.tencent.moai.mailsdk.callback.TaskCallBack;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Attachment;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.model.State;
import com.tencent.moai.mailsdk.protocol.imap.IMAPHandler;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPAttach;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPBodyStructure;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPMailboxInfo;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPResponse;
import com.tencent.moai.mailsdk.protocol.mime.model.MimeMessage;
import com.tencent.moai.mailsdk.task.TaskPool;
import com.tencent.moai.mailsdk.task.TaskPool.TaskRunnable;
import com.tencent.moai.mailsdk.util.FileUtility;
import com.tencent.moai.mailsdk.util.LoginUtility;
import com.tencent.moai.mailsdk.util.log.Logger;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IMAPProtocolManager
{
  private static final int BACK_OFF_INTERVAL = 900000;
  private static final String IDLE_CONNECTION_CLOSE = "idle connection close";
  private static final String IDLE_NOT_SUPPORT = "idle unSupport";
  private static final int IDLE_SEND_COMMAND_TIMEOUT = 90000;
  private static final String TAG = "IMAPProtocolManager";
  private static final String TASK_TAG = "IMAPTask-";
  private static IMAPProtocolManager instance = new IMAPProtocolManager();
  private final Map<String, TaskPool> attachTaskPool = new HashMap();
  private final Map<String, Long> idleAckInterval = new HashMap();
  private final Map<String, Boolean> idleSupportMap = new HashMap();
  private final ArrayList<IdleThread> idleThreads = new ArrayList();
  private final Map<String, TaskPool> userTaskPool = new HashMap();
  
  private void clearTaskPool(Profile paramProfile, boolean paramBoolean)
  {
    for (;;)
    {
      TaskPool localTaskPool;
      synchronized (this.userTaskPool)
      {
        localTaskPool = (TaskPool)this.userTaskPool.get(getKey(paramProfile));
        if (localTaskPool != null)
        {
          if (!paramBoolean) {
            break label117;
          }
          localTaskPool.shutDownNow();
          this.userTaskPool.remove(getKey(paramProfile));
        }
      }
      synchronized (this.attachTaskPool)
      {
        localTaskPool = (TaskPool)this.attachTaskPool.get(getKey(paramProfile));
        if (localTaskPool != null)
        {
          if (paramBoolean)
          {
            localTaskPool.shutDownNow();
            this.attachTaskPool.remove(getKey(paramProfile));
          }
        }
        else
        {
          return;
          label117:
          localTaskPool.shutDown();
          continue;
          paramProfile = finally;
          throw paramProfile;
        }
        localTaskPool.shutDown();
      }
    }
  }
  
  private void fetchMailListBySearch(IMAPHandler paramIMAPHandler, IMAPMailboxInfo paramIMAPMailboxInfo, Folder paramFolder, State paramState, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3)
    throws MessageException
  {
    ArrayList localArrayList = paramState.getExistUidList();
    new ArrayList();
    long l1 = -1L;
    if ((paramState.isReceiveNewOnly()) || (localArrayList.size() == 0))
    {
      l1 = paramIMAPHandler.searchNewMsgNum(paramIMAPMailboxInfo);
      Logger.log(4, "IMAPProtocolManager", "folder:" + paramFolder.getName() + ", serverLatest:" + l1);
    }
    long l2;
    if (localArrayList.size() == 0)
    {
      Logger.log(4, "IMAPProtocolManager", "fetch mail list init list");
      if (l1 > 0L)
      {
        if (l1 <= paramState.getInitLoadCount()) {
          break label166;
        }
        l2 = l1 - paramState.getInitLoadCount() + 1L;
        paramArrayList1.addAll(paramIMAPHandler.search(l2 + ":" + l1, true));
      }
    }
    label166:
    do
    {
      return;
      l2 = 1L;
      break;
      Logger.log(4, "IMAPProtocolManager", "exist:" + localArrayList.size());
      Collections.sort(localArrayList, new IMAPProtocolManager.15(this));
      paramIMAPMailboxInfo = paramIMAPHandler.search("UID " + (String)localArrayList.get(0) + ":" + (String)localArrayList.get(localArrayList.size() - 1), true);
      Logger.log(4, "IMAPProtocolManager", "validExistUidList size:" + paramIMAPMailboxInfo.size());
      paramFolder = localArrayList.iterator();
      while (paramFolder.hasNext())
      {
        String str = (String)paramFolder.next();
        if (paramIMAPMailboxInfo.indexOf(str) == -1) {
          paramArrayList3.add(str);
        }
      }
      if (paramState.isReceiveNewOnly())
      {
        Logger.log(4, "IMAPProtocolManager", "fetch mail list update new");
        paramArrayList2.addAll(paramIMAPMailboxInfo);
        if (l1 > 0L)
        {
          if (paramIMAPMailboxInfo.size() <= 0) {
            break label544;
          }
          l2 = paramIMAPHandler.searchMsgNumByUid((String)paramIMAPMailboxInfo.get(paramIMAPMailboxInfo.size() - 1));
          Logger.log(4, "IMAPProtocolManager", "server:" + l1 + ", local:" + l2);
          if ((l2 > 0L) && (l1 > l2)) {
            paramArrayList1.addAll(paramIMAPHandler.search(l2 + 1L + ":" + l1, true));
          }
        }
        for (;;)
        {
          paramIMAPHandler = paramIMAPMailboxInfo.iterator();
          while (paramIMAPHandler.hasNext())
          {
            paramIMAPMailboxInfo = (String)paramIMAPHandler.next();
            if ((localArrayList.indexOf(paramIMAPMailboxInfo) == -1) && (paramArrayList1.indexOf(paramIMAPMailboxInfo) == -1)) {
              paramArrayList1.add(paramIMAPMailboxInfo);
            }
          }
          break;
          paramArrayList1.addAll(paramIMAPHandler.search("1:" + l1, true));
        }
      }
      Logger.log(4, "IMAPProtocolManager", "fetch mail list load more");
      l2 = paramIMAPHandler.searchMsgNumByUid((String)paramIMAPMailboxInfo.get(0));
    } while (l2 <= 1L);
    label544:
    if (l2 > paramState.getLoadMoreCount() + 1) {}
    for (l1 = l2 - paramState.getLoadMoreCount() - 1L;; l1 = 1L)
    {
      paramArrayList1.addAll(paramIMAPHandler.search(l1 + ":" + (l2 - 1L), true));
      return;
    }
  }
  
  private void fetchMailListByUidAll(IMAPHandler paramIMAPHandler, State paramState, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3)
    throws MessageException
  {
    int j = 0;
    Object localObject = paramState.getExistUidList();
    ArrayList localArrayList = new ArrayList();
    paramIMAPHandler = paramIMAPHandler.search("ALL", true);
    Collections.sort(paramIMAPHandler, new IMAPProtocolManager.13(this));
    Logger.log(4, "IMAPProtocolManager", "fetch mail list all uid size:" + paramIMAPHandler.size());
    if (((ArrayList)localObject).size() == 0)
    {
      Logger.log(4, "IMAPProtocolManager", "fetch mail list init load");
      if (paramIMAPHandler.size() > 0)
      {
        i = paramIMAPHandler.size() - 1;
        while (i >= 0)
        {
          if (paramArrayList1.size() < paramState.getInitLoadCount()) {
            paramArrayList1.add(paramIMAPHandler.get(i));
          }
          i -= 1;
        }
      }
    }
    else
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (paramIMAPHandler.indexOf(str) != -1) {
          localArrayList.add(str);
        } else {
          paramArrayList3.add(str);
        }
      }
      Collections.sort(localArrayList, new IMAPProtocolManager.14(this));
      Logger.log(4, "IMAPProtocolManager", "validExistUidList size:" + localArrayList.size());
      if (paramState.isReceiveNewOnly())
      {
        Logger.log(4, "IMAPProtocolManager", "fetch mail list update new");
        if (localArrayList.size() != 0) {
          break label466;
        }
      }
    }
    label466:
    for (int i = 1;; i = 0)
    {
      paramIMAPHandler = paramIMAPHandler.iterator();
      int k;
      while (paramIMAPHandler.hasNext())
      {
        paramState = (String)paramIMAPHandler.next();
        k = localArrayList.indexOf(paramState);
        j = i;
        if (i == 0)
        {
          j = i;
          if (k != -1) {
            j = 1;
          }
        }
        i = j;
        if (j != 0) {
          if (k != -1)
          {
            paramArrayList2.add(0, paramState);
            i = j;
          }
          else
          {
            paramArrayList1.add(0, paramState);
            i = j;
            continue;
            Logger.log(4, "IMAPProtocolManager", "fetch mail list load more");
            i = paramIMAPHandler.size() - 1;
          }
        }
      }
      for (;;)
      {
        if (i >= 0)
        {
          paramArrayList2 = (String)paramIMAPHandler.get(i);
          int m = localArrayList.indexOf(paramArrayList2);
          k = j;
          if (j == 0)
          {
            k = j;
            if (m != -1) {
              k = 1;
            }
          }
          if ((k != 0) && (m == -1)) {
            paramArrayList1.add(paramArrayList2);
          }
          if (paramArrayList1.size() <= paramState.getLoadMoreCount()) {}
        }
        else
        {
          return;
        }
        i -= 1;
        j = k;
      }
    }
  }
  
  private TaskPool getAttachPoolByUser(Profile paramProfile)
  {
    synchronized (this.attachTaskPool)
    {
      String str = getKey(paramProfile);
      TaskPool localTaskPool2 = (TaskPool)this.attachTaskPool.get(str);
      TaskPool localTaskPool1 = localTaskPool2;
      if (localTaskPool2 == null)
      {
        localTaskPool1 = new TaskPool(paramProfile, 2, 4, 2);
        this.attachTaskPool.put(str, localTaskPool1);
      }
      return localTaskPool1;
    }
  }
  
  public static IMAPProtocolManager getInstance()
  {
    return instance;
  }
  
  private String getKey(Profile paramProfile)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(paramProfile.getImapName());
    localStringBuilder.append("^");
    if (paramProfile.isOauth()) {}
    for (String str = paramProfile.getAccessToken();; str = paramProfile.getImapPassword())
    {
      localStringBuilder.append(str);
      localStringBuilder.append("^");
      localStringBuilder.append(paramProfile.getImapServer());
      localStringBuilder.append("^");
      localStringBuilder.append(paramProfile.getImapPort());
      localStringBuilder.append("^");
      localStringBuilder.append(paramProfile.getImapSSLPort());
      return localStringBuilder.toString();
    }
  }
  
  private TaskPool getTaskPoolByUser(Profile paramProfile)
  {
    synchronized (this.userTaskPool)
    {
      String str = getKey(paramProfile);
      TaskPool localTaskPool2 = (TaskPool)this.userTaskPool.get(str);
      TaskPool localTaskPool1 = localTaskPool2;
      if (localTaskPool2 == null)
      {
        localTaskPool1 = new TaskPool(paramProfile, 2, 4, 1);
        this.userTaskPool.put(str, localTaskPool1);
      }
      return localTaskPool1;
    }
  }
  
  private void handleAuthError(Profile paramProfile, MessageException paramMessageException)
  {
    Object localObject = new ArrayList();
    TaskPool localTaskPool;
    synchronized (this.userTaskPool)
    {
      localTaskPool = (TaskPool)this.userTaskPool.get(getKey(paramProfile));
      if (localTaskPool != null)
      {
        ((ArrayList)localObject).addAll(localTaskPool.shutDownNow());
        this.userTaskPool.remove(getKey(paramProfile));
      }
    }
    synchronized (this.attachTaskPool)
    {
      localTaskPool = (TaskPool)this.attachTaskPool.get(getKey(paramProfile));
      if (localTaskPool != null)
      {
        ((ArrayList)localObject).addAll(localTaskPool.shutDownNow());
        this.attachTaskPool.remove(getKey(paramProfile));
      }
      paramProfile = ((ArrayList)localObject).iterator();
      while (paramProfile.hasNext())
      {
        localObject = (Runnable)paramProfile.next();
        if ((localObject instanceof TaskPool.TaskRunnable))
        {
          ((TaskPool.TaskRunnable)localObject).getCallback().onError(paramMessageException);
          continue;
          paramProfile = finally;
          throw paramProfile;
        }
      }
    }
  }
  
  private boolean isAuthError(MessageException paramMessageException)
  {
    return (paramMessageException.getResultCode() == 4) || (paramMessageException.getResultCode() == 8);
  }
  
  private boolean isIdleRunning(Profile arg1)
  {
    String str = ???.getImapName();
    synchronized (this.idleThreads)
    {
      Iterator localIterator = this.idleThreads.iterator();
      while (localIterator.hasNext()) {
        if (str.equals(((IdleThread)localIterator.next()).getKey()))
        {
          Logger.log(4, str, "idle is running:" + str);
          return true;
        }
      }
      return false;
    }
  }
  
  public void addFolder(Profile paramProfile, State paramState, Folder paramFolder, FolderCallBack paramFolderCallBack)
  {
    Logger.log(4, "IMAPProtocolManager", "add folder :" + paramFolder.getName());
    getTaskPoolByUser(paramProfile).post(new IMAPProtocolManager.5(this, "IMAPTask-addFolder", paramFolder, paramFolderCallBack), new IMAPProtocolManager.6(this, paramProfile, paramFolderCallBack));
  }
  
  public void append(Profile paramProfile, String paramString, Mail paramMail, MailOperationCallback paramMailOperationCallback)
  {
    Logger.log(4, "IMAPProtocolManager", "append mail:" + paramMail.getSubject() + "," + paramMail.getUtc());
    String str = FileUtility.generateImapAppendFilePath(paramString);
    try
    {
      MimeMessage localMimeMessage = MailParser.createMessage(paramMail);
      if (FileUtility.createFile(str))
      {
        BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str), false));
        localMimeMessage.write(localBufferedOutputStream, null);
        localBufferedOutputStream.close();
      }
      getTaskPoolByUser(paramProfile).post(new IMAPProtocolManager.33(this, "IMAPTask-append", str, paramString, paramMail, paramMailOperationCallback), new IMAPProtocolManager.34(this, paramMail, paramProfile, paramMailOperationCallback));
      return;
    }
    catch (Exception paramProfile)
    {
      while (paramMailOperationCallback == null) {}
      paramMailOperationCallback.onMailOperationError(3, 200001, "append fail.write mime file error:" + paramProfile.getMessage());
    }
  }
  
  public void appendFile(Profile paramProfile, String paramString1, String paramString2, MailOperationCallback paramMailOperationCallback)
  {
    getTaskPoolByUser(paramProfile).post(new IMAPProtocolManager.35(this, "IMAPTask-append", paramString2, paramString1, paramMailOperationCallback), new IMAPProtocolManager.36(this, paramMailOperationCallback));
  }
  
  public void checkMail(Profile paramProfile, Map<Folder, ArrayList<String>> paramMap, CheckMailCallback paramCheckMailCallback)
  {
    Logger.log(4, "IMAPProtocolManager", "check new mails:" + paramMap.size());
    getTaskPoolByUser(paramProfile).post(new IMAPProtocolManager.16(this, "IMAPTask-checkMail", paramMap, paramCheckMailCallback), new IMAPProtocolManager.17(this, paramProfile, paramCheckMailCallback));
  }
  
  public void deleteMail(Profile paramProfile, Folder paramFolder, Mail[] paramArrayOfMail, MailOperationCallback paramMailOperationCallback)
  {
    Logger.log(4, "IMAPProtocolManager", "delete mail size:" + paramArrayOfMail.length);
    getTaskPoolByUser(paramProfile).post(new IMAPProtocolManager.27(this, "IMAPTask-deleteMail", paramFolder, paramArrayOfMail, paramMailOperationCallback), new IMAPProtocolManager.28(this, paramProfile, paramMailOperationCallback));
  }
  
  public void downloadAttachment(Profile paramProfile, Folder paramFolder, Mail paramMail, Attachment paramAttachment, AttachmentCallBack paramAttachmentCallBack)
  {
    if ((paramAttachment == null) || (paramAttachment.getImapBodyStructure() == null))
    {
      if (paramAttachment != null) {
        paramAttachmentCallBack.onError(1, 200001, "attachment or bodyStructure empty:" + paramMail.getRemoteId());
      }
      return;
    }
    Logger.log(4, "IMAPProtocolManager", "download attachment remoteId:" + paramMail.getRemoteId() + " bodyId:" + paramAttachment.getImapBodyStructure().getBodyId() + " path:" + paramAttachment.getPath());
    getAttachPoolByUser(paramProfile).post(new IMAPProtocolManager.24(this, "IMAPTask-downloadAttach", paramFolder, paramAttachmentCallBack, paramMail, paramAttachment), new IMAPProtocolManager.25(this, paramProfile, paramAttachmentCallBack));
  }
  
  public void downloadMailsAbstract(Profile paramProfile, Folder paramFolder, Mail[] paramArrayOfMail, MailAbstractCallBack paramMailAbstractCallBack)
  {
    Logger.log(4, "IMAPProtocolManager", "download mail abstract size:" + paramArrayOfMail.length);
    getTaskPoolByUser(paramProfile).post(new IMAPProtocolManager.22(this, "IMAPTask-downloadMailAbstract", paramFolder, paramMailAbstractCallBack, paramArrayOfMail), new IMAPProtocolManager.23(this, paramProfile, paramMailAbstractCallBack));
  }
  
  public void downloadMailsText(Profile paramProfile, Folder paramFolder, Mail[] paramArrayOfMail, boolean paramBoolean, MailCallBack paramMailCallBack)
  {
    Logger.log(4, "IMAPProtocolManager", "download mail text size:" + paramArrayOfMail.length);
    getTaskPoolByUser(paramProfile).post(new IMAPProtocolManager.20(this, "IMAPTask-downloadMailsText", paramFolder, paramMailCallBack, paramArrayOfMail), new IMAPProtocolManager.21(this, paramProfile, paramMailCallBack));
  }
  
  public void fetchFolderList(Profile paramProfile, State paramState, FolderListCallBack paramFolderListCallBack)
  {
    Logger.log(4, "IMAPProtocolManager", "fetch folder list name:" + paramProfile.getImapName());
    getTaskPoolByUser(paramProfile).post(new IMAPProtocolManager.1(this, "IMAPTask-fetchFolderList", paramProfile, paramFolderListCallBack), new IMAPProtocolManager.2(this, paramProfile, paramFolderListCallBack));
  }
  
  public void fetchMailList(Profile paramProfile, State paramState, Folder paramFolder, MailListCallBack paramMailListCallBack)
  {
    Logger.log(4, "IMAPProtocolManager", "fetch mail list path:" + paramFolder.getPath() + " name:" + paramFolder.getName());
    getTaskPoolByUser(paramProfile).post(new IMAPProtocolManager.11(this, "IMAPTask-fetchMailList-" + paramFolder.getName(), paramFolder, paramMailListCallBack, paramState), new IMAPProtocolManager.12(this, paramProfile, paramMailListCallBack));
  }
  
  public long getIdleAckInterval(Profile arg1)
  {
    String str = getKey(???);
    synchronized (this.idleAckInterval)
    {
      long l = ((Long)this.idleAckInterval.get(str)).longValue();
      return l;
    }
  }
  
  public void initProfile(Profile paramProfile)
  {
    getTaskPoolByUser(paramProfile);
    getAttachPoolByUser(paramProfile);
  }
  
  public void login(Profile paramProfile, LoginCallBack paramLoginCallBack)
  {
    Logger.log(4, "IMAPProtocolManager", "login name:" + paramProfile.getImapName() + "," + paramProfile.getImapPassword().hashCode());
    IMAPHandler localIMAPHandler = new IMAPHandler(paramProfile);
    try
    {
      localIMAPHandler.setTag("ExtraHandler");
      localIMAPHandler.openConnection();
      localIMAPHandler.auth(true);
      Logger.log(4, "IMAPProtocolManager", "login success name:" + paramProfile.getImapName());
      if (paramLoginCallBack != null) {
        paramLoginCallBack.onLoginSuccess(paramProfile);
      }
      return;
    }
    catch (MessageException localMessageException)
    {
      Logger.log(6, "IMAPProtocolManager", "login error:" + localMessageException.getResultCode() + ":" + localMessageException.getDetailCode() + ":" + Log.getStackTraceString(localMessageException));
      clearTaskPool(paramProfile, false);
      if (localMessageException.getResultCode() == 4)
      {
        int i = LoginUtility.getProtocolLoginError(localMessageException.getDetailMessage());
        String str = paramProfile.getImapName();
        if ((i != 2) && (i != 3) && (str.contains("@")) && (!MailParser.canUseFullName(str)))
        {
          paramProfile.setImapName(MailParser.getUserName(str));
          login(paramProfile, paramLoginCallBack);
          return;
        }
      }
      if (paramLoginCallBack != null) {
        paramLoginCallBack.onLoginError(localMessageException.getResultCode(), localMessageException.getDetailCode(), localMessageException.getDetailMessage());
      }
      return;
    }
    catch (Exception localException)
    {
      Logger.log(6, "IMAPProtocolManager", "login error:" + Log.getStackTraceString(localException));
      clearTaskPool(paramProfile, false);
      if (paramLoginCallBack != null) {
        paramLoginCallBack.onLoginError(1, 200001, localException.getMessage());
      }
      return;
    }
    finally
    {
      localIMAPHandler.closeConnection();
    }
  }
  
  public void logout(Profile paramProfile, LogoutCallBack paramLogoutCallBack)
  {
    Logger.log(4, "IMAPProtocolManager", "logout name:" + paramProfile.getImapName());
    clearTaskPool(paramProfile, true);
    if (paramLogoutCallBack != null) {
      paramLogoutCallBack.onSuccess(paramProfile);
    }
  }
  
  public void modifyMailFlag(Profile paramProfile, Folder paramFolder, Mail[] paramArrayOfMail, int paramInt1, int paramInt2, MailOperationCallback paramMailOperationCallback)
  {
    Logger.log(4, "IMAPProtocolManager", "modify mail flag size:" + paramArrayOfMail.length + " flag:" + paramInt1 + " value:" + paramInt2);
    getTaskPoolByUser(paramProfile).post(new IMAPProtocolManager.31(this, "IMAPTask-modifyMailFlag", paramFolder, paramArrayOfMail, paramInt1, paramInt2, paramMailOperationCallback), new IMAPProtocolManager.32(this, paramProfile, paramMailOperationCallback));
  }
  
  public void moveMail(Profile paramProfile, Folder paramFolder1, Folder paramFolder2, Mail[] paramArrayOfMail, MailOperationCallback paramMailOperationCallback)
  {
    Logger.log(4, "IMAPProtocolManager", "move mail source:" + paramFolder1.getPath() + " dest:" + paramFolder2.getPath() + " size:" + paramArrayOfMail.length);
    getTaskPoolByUser(paramProfile).post(new IMAPProtocolManager.29(this, "IMAPTask-moveMail", paramFolder1, paramArrayOfMail, paramFolder2, paramMailOperationCallback), new IMAPProtocolManager.30(this, paramProfile, paramMailOperationCallback));
  }
  
  public void notifyIdle()
  {
    synchronized (this.idleThreads)
    {
      Logger.log(4, "IMAPProtocolManager", "wake up idle threads:" + this.idleThreads.size());
      Iterator localIterator = this.idleThreads.iterator();
      if (localIterator.hasNext()) {
        ((IdleThread)localIterator.next()).wakeIdleThread();
      }
    }
  }
  
  public void removeFolder(Profile paramProfile, State paramState, Folder paramFolder, FolderCallBack paramFolderCallBack)
  {
    Logger.log(4, "IMAPProtocolManager", "remove folder path" + paramFolder.getPath() + " name:" + paramFolder.getName());
    getTaskPoolByUser(paramProfile).post(new IMAPProtocolManager.9(this, "IMAPTask-removeFolder", paramFolder, paramFolderCallBack), new IMAPProtocolManager.10(this, paramProfile, paramFolderCallBack));
  }
  
  public void renameFolder(Profile paramProfile, State paramState, Folder paramFolder, String paramString, FolderCallBack paramFolderCallBack)
  {
    Logger.log(4, "IMAPProtocolManager", "rename folder name:" + paramFolder.getName() + " newName:" + paramString);
    getTaskPoolByUser(paramProfile).post(new IMAPProtocolManager.7(this, "IMAPTask-renameFolder", paramFolder, paramString, paramFolderCallBack), new IMAPProtocolManager.8(this, paramProfile, paramFolderCallBack));
  }
  
  public void searchMail(Profile paramProfile, ArrayList<String> paramArrayList, State paramState, HashMap<Integer, String> paramHashMap, SearchMailCallback paramSearchMailCallback)
  {
    Logger.log(4, "IMAPProtocolManager", "search mails fields:" + paramHashMap.toString());
    getTaskPoolByUser(paramProfile).post(new IMAPProtocolManager.18(this, "IMAPTask-searchMails", paramArrayList, paramSearchMailCallback, paramHashMap, paramState), new IMAPProtocolManager.19(this, paramProfile, paramSearchMailCallback));
  }
  
  public void setIdleAckInterval(Profile paramProfile, long paramLong)
  {
    String str = getKey(paramProfile);
    synchronized (this.idleAckInterval)
    {
      this.idleAckInterval.put(str, Long.valueOf(paramLong));
      Logger.log(4, "IMAPProtocolManager", paramProfile.getImapName() + " set ackInterval " + paramLong);
      return;
    }
  }
  
  public void startIdle(Profile paramProfile, Folder paramFolder, IdleCallback paramIdleCallback)
  {
    String str = paramProfile.getImapName();
    synchronized (this.idleThreads)
    {
      Iterator localIterator = this.idleThreads.iterator();
      while (localIterator.hasNext()) {
        if (str.equals(((IdleThread)localIterator.next()).getKey()))
        {
          Logger.log(4, str, "idle is running:" + str);
          return;
        }
      }
      paramProfile = new IdleThread(paramProfile, paramFolder, paramIdleCallback);
      this.idleThreads.add(paramProfile);
      paramProfile.start();
      return;
    }
  }
  
  public void stopIdle(Profile arg1)
  {
    Logger.log(4, "IMAPProtocolManager", "stop idle " + ???.getImapName());
    String str = ???.getImapName();
    synchronized (this.idleThreads)
    {
      Iterator localIterator = this.idleThreads.iterator();
      while (localIterator.hasNext())
      {
        IdleThread localIdleThread = (IdleThread)localIterator.next();
        if (str.equals(localIdleThread.getKey())) {
          this.idleThreads.remove(localIdleThread);
        }
      }
      return;
    }
  }
  
  public void syncFolderStatus(Profile paramProfile, Folder paramFolder, FolderSyncImapCallBack paramFolderSyncImapCallBack)
  {
    Logger.log(4, "IMAPProtocolManager", "sync folder status path:" + paramFolder.getPath() + " name:" + paramFolder.getName());
    getTaskPoolByUser(paramProfile).post(new IMAPProtocolManager.3(this, "IMAPTask-syncFolderStatus-" + paramFolder.getName(), paramFolder, paramFolderSyncImapCallBack), new IMAPProtocolManager.4(this, paramProfile, paramFolderSyncImapCallBack));
  }
  
  public void transformTmpAttach(String paramString1, String paramString2, String paramString3, AttachmentCallBack paramAttachmentCallBack)
  {
    try
    {
      new IMAPAttach().transferTmpAttach(paramString1, paramString2, paramString3, new IMAPProtocolManager.26(this, paramAttachmentCallBack, paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      do
      {
        Logger.log(6, "IMAPProtocolManager", Log.getStackTraceString(paramString1));
      } while (paramAttachmentCallBack == null);
      paramAttachmentCallBack.onError(1, 200001, paramString1.getMessage());
    }
  }
  
  class IdleThread
    extends Thread
  {
    private IdleCallback callback;
    private int disConnectCnt = 0;
    private Folder folder;
    private long lastConnectTime = 0L;
    private final Object mConnectBackoffWaiter = new Object();
    private Profile profile;
    private String tag;
    
    public IdleThread(Profile paramProfile, Folder paramFolder, IdleCallback paramIdleCallback)
    {
      this.profile = paramProfile;
      this.folder = paramFolder;
      this.callback = paramIdleCallback;
      this.tag = ("idle_" + getKey());
    }
    
    public String getKey()
    {
      return this.profile.getImapName();
    }
    
    public void run()
    {
      int i = this.folder.getTotalCount();
      Object localObject3;
      if ((IMAPProtocolManager.this.isIdleRunning(this.profile)) && ((IMAPProtocolManager.this.idleSupportMap.get(this.tag) == null) || (((Boolean)IMAPProtocolManager.this.idleSupportMap.get(this.tag)).booleanValue())))
      {
        Logger.log(4, this.tag, "start new connection to idle");
        localObject3 = new IMAPHandler(this.profile);
        j = i;
      }
      for (;;)
      {
        try
        {
          long l1 = SystemClock.elapsedRealtime();
          j = i;
          if (l1 - this.lastConnectTime >= 900000L) {
            break label366;
          }
          j = i;
          long l2 = Math.scalb(10000.0F, this.disConnectCnt);
          j = i;
          this.disConnectCnt += 1;
          j = i;
          Object localObject1 = this.mConnectBackoffWaiter;
          j = i;
          ((IMAPHandler)localObject3).closeConnection();
        }
        catch (Exception localException1)
        {
          try
          {
            if (this.disConnectCnt > 0)
            {
              QMLog.log(5, this.tag, "idle connect backoff, freq: " + this.disConnectCnt + ", backoff: " + l2 + "ms");
              Threads.waitNoException(this.mConnectBackoffWaiter, l2);
            }
            j = i;
            this.lastConnectTime = l1;
            j = i;
            ((IMAPHandler)localObject3).openConnection();
            j = i;
            if (((IMAPHandler)localObject3).isSupportIdle()) {
              break;
            }
            j = i;
            throw new MessageException(14, "idle unSupport");
          }
          finally
          {
            j = i;
          }
          localException1 = localException1;
          i = j;
        }
        if (!(localException1 instanceof MessageException)) {
          break label1075;
        }
        localObject3 = (MessageException)localException1;
        if (((MessageException)localObject3).getResultCode() != 14) {
          break label968;
        }
        IMAPProtocolManager.this.idleSupportMap.put(this.tag, Boolean.valueOf(false));
        Logger.log(5, this.tag, "idle unSupport");
        if (this.callback != null) {
          this.callback.onIdleError(14, ((MessageException)localObject3).getDetailCode(), "idle unSupport");
        }
        IMAPProtocolManager.this.stopIdle(this.profile);
        return;
        label366:
        j = i;
        this.disConnectCnt = 0;
      }
      int j = i;
      ((IMAPHandler)localObject3).auth(false);
      label384:
      j = i;
      int k = i;
      for (;;)
      {
        int m;
        try
        {
          if (IMAPProtocolManager.this.isIdleRunning(this.profile))
          {
            k = i;
            Object localObject2 = ((IMAPHandler)localObject3).select(this.folder.getPath());
            if (localObject2 == null)
            {
              k = i;
              throw new MessageException(15, "select " + this.folder.getPath() + " error");
            }
            k = i;
            m = ((IMAPMailboxInfo)localObject2).getTotal();
            j = i;
            if (m != i)
            {
              k = i;
              Logger.log(4, this.tag, "idle svrCnt change from " + i + " to " + m);
              k = i;
              if (this.callback == null) {
                break label1172;
              }
              k = i;
              this.callback.onSvrCountChange();
              break label1172;
            }
            k = j;
            ((IMAPHandler)localObject3).setReadTimeout(90000);
            k = j;
            localObject2 = ((IMAPHandler)localObject3).idle();
            if (localObject2 != null)
            {
              k = j;
              if (((IMAPResponse)localObject2).isNO())
              {
                k = j;
                throw new MessageException(14, "idle unSupport");
              }
            }
            if (localObject2 == null)
            {
              k = j;
              throw new MessageException(3, "idle connection close");
            }
            k = j;
            if (this.callback != null)
            {
              k = j;
              this.callback.reportDomain();
            }
            k = j;
            i = (int)IMAPProtocolManager.this.getIdleAckInterval(this.profile);
            k = j;
            Logger.log(4, this.tag, "idle ackInterval " + i);
            k = j;
            ((IMAPHandler)localObject3).setReadTimeout(i);
            i = j;
            j = i;
            try
            {
              Logger.log(4, this.tag, "idle wait for return");
              j = i;
              localObject2 = ((IMAPHandler)localObject3).readResponse();
              if (localObject2 != null) {
                continue;
              }
              j = i;
              throw new MessageException(3, "idle connection close");
            }
            catch (MessageException localMessageException)
            {
              j = i;
              if (localMessageException.getResultCode() != 13) {
                continue;
              }
            }
            j = i;
            Logger.log(4, this.tag, "idle timeout");
            j = i;
            ((IMAPHandler)localObject3).setReadTimeout(90000);
            j = i;
            if (!((IMAPHandler)localObject3).idleDone())
            {
              j = i;
              Logger.log(5, this.tag, "idleDone error");
              j = i;
              throw new MessageException(15, "idle done error");
              j = i;
              Logger.log(4, this.tag, "idle return: " + localMessageException.getContent());
              j = i;
              if (localMessageException.getKey() == null) {
                continue;
              }
              j = i;
              if (!localMessageException.getKey().toUpperCase().equals("EXISTS")) {
                continue;
              }
              j = i;
              m = localMessageException.getNumber();
              if (m == i) {
                continue;
              }
              j = i;
              Logger.log(4, this.tag, "idle svrCnt change from " + i + " to " + m);
              j = i;
              k = m;
              if (this.callback != null)
              {
                j = i;
                this.callback.onSvrCountChange();
                k = m;
              }
              i = k;
              continue;
              j = i;
              throw localMessageException;
            }
            j = i;
            if (this.callback != null)
            {
              j = i;
              this.callback.onIdleSuccess();
            }
            break label384;
            label968:
            if (((((MessageException)localObject3).getResultCode() == 4) || (((MessageException)localObject3).getResultCode() == 8)) && (LoginUtility.getProtocolLoginError(((MessageException)localObject3).getMessage()) != 3))
            {
              Logger.log(6, this.tag, "stop idle auth error " + localMessageException.getMessage());
              if (this.callback != null) {
                this.callback.onIdleError(((MessageException)localObject3).getResultCode(), ((MessageException)localObject3).getDetailCode(), ((MessageException)localObject3).getMessage());
              }
              IMAPProtocolManager.this.stopIdle(this.profile);
              return;
            }
            label1075:
            Logger.log(6, this.tag, "idle exception " + Log.getStackTraceString(localMessageException));
            if (this.callback != null) {
              this.callback.onIdleError(15, 200001, "idle error " + localMessageException.getMessage());
            }
            j = i;
          }
          i = j;
          break;
          k = i;
          continue;
        }
        catch (Exception localException2)
        {
          i = k;
        }
        label1172:
        j = m;
      }
    }
    
    public void wakeIdleThread()
    {
      synchronized (this.mConnectBackoffWaiter)
      {
        this.mConnectBackoffWaiter.notifyAll();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.IMAPProtocolManager
 * JD-Core Version:    0.7.0.1
 */