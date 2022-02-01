package com.tencent.qqmail.model.task;

import android.content.Context;
import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachProtocol;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.model.FtnUserProfile;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.DownloadAttachWatcher;
import com.tencent.qqmail.model.mail.watcher.DownloadImgWatcher;
import com.tencent.qqmail.model.mail.watcher.LoadMailWatcher;
import com.tencent.qqmail.model.mail.watcher.SendMailWatcher;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.sendmail.SendMailHelper;
import com.tencent.qqmail.model.sendmail.SendMailRequest;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeState;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.model.verify.QMVerify;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.QMLogStream;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMCancelError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.qmnetwork.QMSendMailCGIError;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMSendMailNotification;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import moai.core.watcher.Watchers;
import moai.oss.KvHelper;
import org.apache.commons.lang3.StringUtils;
import rx.Observable;

public class QMSendMailTask
  extends QMTask
{
  private static final String COMPOSE_KEY_PREFIX = "composemail_";
  public static final int MAX_SEND_RETRY_TIME = 4;
  private static final String TAG = "QMSendMailTask";
  private static final ArrayList<String> mErrorMessageList = new ArrayList();
  private static final ArrayList<String> mErrorSubjectList = new ArrayList();
  private SendMailRequest currentRequest;
  private QMTaskManager downLoadAttachTaskMgr = null;
  private ArrayList<Attach> downloadAttachList = null;
  private DownloadAttachWatcher downloadAttachWatch = new QMSendMailTask.1(this);
  private AtomicInteger downloadIndex = new AtomicInteger(0);
  private AtomicInteger downloadTotalCnt = new AtomicInteger(-1);
  private boolean hasPrintedDownloadAttachLog = false;
  boolean isCancelFail = false;
  private boolean isDownloadOriginMail = false;
  private ComposeMailUI mail;
  private String originMailBody = "";
  private ArrayList<Object> originalToList;
  private LoadMailWatcher readMailWatcher = new QMSendMailTask.2(this);
  private double sendingProgress = 0.0D;
  private QMVerify verify;
  
  public QMSendMailTask()
  {
    this.taskManager = QMTaskManager.sharedInstance(1);
  }
  
  public static double calculateSendingProgress(double paramDouble1, double paramDouble2, Long paramLong, boolean paramBoolean)
  {
    double d;
    if (paramBoolean)
    {
      d = paramDouble2 / paramLong.longValue() * 0.4D + 0.5D;
      paramDouble2 = paramDouble1;
      if (d > paramDouble1) {
        paramDouble2 = d;
      }
    }
    do
    {
      return paramDouble2;
      d = paramDouble2 / paramLong.longValue() * 0.85D + 0.05D;
      paramDouble2 = paramDouble1;
    } while (d <= paramDouble1);
    return d;
  }
  
  private void changeSendStatus(ComposeMailUI.QMComposeState paramQMComposeState)
  {
    this.mail.setSendState(paramQMComposeState);
    String str = this.mail.getErrMsg();
    if ((str != null) && (!str.equals(""))) {
      this.mail.setErrMsg(str);
    }
    setTaskStateFromComposeState(paramQMComposeState);
    updateToDB();
  }
  
  public static void clearAllNotification()
  {
    QMSendMailNotification.getInstance().clearAllNotification();
  }
  
  private void doSendMail()
  {
    QMLog.log(4, "QMSendMailTask", "sendMail1");
    Object localObject1 = this.mail.getMailId();
    this.mail.getInformation().setRemoteId(getMailIdWithComposeId((String)localObject1));
    QMLog.log(4, "QMSendMailTask", "sendMail2");
    ImageUtil.CompressImage(this.mail);
    if ((!this.mail.isQuickReply()) && (!this.mail.isQuickReplyGroup()))
    {
      localObject1 = AccountManager.shareInstance().getAccountList().getAccountById(getAccountId());
      if (localObject1 != null)
      {
        if (!((Account)localObject1).isQQMail()) {
          break label281;
        }
        DataCollector.logPerformanceEnd("Performance_Send_QQ_Compose_Mail" + this.mail.getComposeId(), "");
      }
    }
    for (;;)
    {
      Log.v("QMSendMailTask", "handle/compress end " + this.mail.getComposeId());
      try
      {
        localObject1 = new MailManagerDelegate();
        ((MailManagerDelegate)localObject1).setOnBeforeSend(new QMSendMailTask.13(this));
        ((MailManagerDelegate)localObject1).setOnSuccess(new QMSendMailTask.14(this));
        ((MailManagerDelegate)localObject1).setOnError(new QMSendMailTask.15(this));
        ((MailManagerDelegate)localObject1).setOnComplete(new QMSendMailTask.16(this));
        ((MailManagerDelegate)localObject1).setOnSendData(new QMSendMailTask.17(this));
        QMLog.log(4, "QMSendMailTask", "sendMail2:" + this.mail.getSendState());
        if (this.mail.getSendState() == ComposeMailUI.QMComposeState.QMComposeStateCanceled)
        {
          QMLog.log(5, "QMSendMailTask", "QMComposeMailManager sendMail canceled before call MailManager::sendMail, just return");
          return;
          label281:
          DataCollector.logPerformanceEnd("Performance_Send_Compose_Mail" + this.mail.getComposeId(), "");
          continue;
        }
        QMLog.log(4, "QMSendMailTask", "sendMail");
        DataCollector.logPerformanceBegin("Performance_Send", getAccountId(), "Performance_Send" + this.mail.getComposeId());
        this.currentRequest = QMMailManager.sharedInstance().sendMail(AccountManager.shareInstance().getAccountList().getAccountById(getAccountId()), this.mail, false, getVerify(), getId(), (MailManagerDelegate)localObject1);
        return;
      }
      finally {}
    }
  }
  
  private ArrayList<QMDownloadTask> downloadAttachList(Mail paramMail, ArrayList<Attach> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList2 = new ArrayList();
    Collections.sort(paramArrayList, new QMSendMailTask.3(this));
    if (this.downLoadAttachTaskMgr == null)
    {
      this.downLoadAttachTaskMgr = new QMTaskManager(3);
      this.downLoadAttachTaskMgr.setRunningTaskCount(1);
    }
    ArrayList localArrayList1 = this.downLoadAttachTaskMgr.getTaskList();
    if (localArrayList1 == null)
    {
      localArrayList1 = new ArrayList();
      this.downLoadAttachTaskMgr.setTaskList(localArrayList1);
    }
    for (;;)
    {
      Iterator localIterator = paramArrayList.iterator();
      paramArrayList = paramMail;
      Attach localAttach;
      Object localObject;
      if (localIterator.hasNext())
      {
        localAttach = (Attach)localIterator.next();
        if (paramArrayList != null)
        {
          paramMail = paramArrayList;
          if (paramArrayList.getInformation().getId() == localAttach.getBelongMailId()) {}
        }
        else
        {
          if (localAttach.getBelongMailId() != 0L) {
            paramArrayList = QMMailManager.sharedInstance().readMailInfo(localAttach.getBelongMailId());
          }
          paramMail = paramArrayList;
          if (paramArrayList == null)
          {
            i = localAttach.getAccountId();
            paramMail = new MailUI();
            paramArrayList = AccountManager.shareInstance().getAccountList().getAccountById(i);
            localObject = new MailInformation();
            ((MailInformation)localObject).setAccountId(i);
            ((MailInformation)localObject).setSubject(localAttach.getMailSubject());
            ((MailInformation)localObject).setFolderId(localAttach.getFolderId());
            ((MailInformation)localObject).setRemoteId(localAttach.getRemoteId());
            ((MailInformation)localObject).setId(localAttach.getBelongMailId());
            ((MailInformation)localObject).setFrom(new MailContact(localAttach.getMailSender(), localAttach.getMailSenderAddr()));
            paramMail.setInformation((MailInformation)localObject);
            localObject = new MailStatus();
            ((MailStatus)localObject).setLocalMail(false);
            ((MailStatus)localObject).setLoaded(false);
            ((MailStatus)localObject).setConversation(false);
            if (paramArrayList.isQQMail()) {
              break label366;
            }
          }
        }
        label366:
        for (boolean bool = true;; bool = false)
        {
          ((MailStatus)localObject).setProtocolMail(bool);
          paramMail.setStatus((MailStatus)localObject);
          if ((paramMail != null) && (paramMail.getInformation() != null) && (this.mail.getOriginAccountId() != 0)) {
            break label372;
          }
          this.downloadTotalCnt.addAndGet(-1);
          paramArrayList = paramMail;
          break;
        }
        label372:
        localObject = localAttach.getHttpUrl();
        if (!StringUtils.isEmpty((CharSequence)localObject))
        {
          QMLog.log(4, "QMSendMailTask", "download img:" + (String)localObject);
          paramArrayList = getTaskInDownTaskList(localArrayList1, (String)localObject);
          if (paramArrayList != null) {
            break label810;
          }
          QMLog.log(4, "QMSendMailTask", "download img new");
          paramArrayList = new QMInlineImgDownloadTask((String)localObject, this.mail.getOriginAccountId(), this.mail.getInformation().getId());
        }
      }
      label802:
      label810:
      for (int i = 1;; i = 0)
      {
        ((QMInlineImgDownloadTask)paramArrayList).bindDownloadImageWatcher(getDownloadImageWatcher());
        localObject = paramArrayList;
        paramArrayList = paramMail;
        if (i == 0) {
          break;
        }
        this.downLoadAttachTaskMgr.addToMainLoop((QMTask)localObject);
        paramArrayList = paramMail;
        if (this.downLoadAttachTaskMgr.isRunning()) {
          break;
        }
        this.downLoadAttachTaskMgr.startMainLoop();
        paramArrayList = paramMail;
        break;
        label555:
        QMDownloadTask localQMDownloadTask;
        if (localAttach.isProtocol())
        {
          paramArrayList = "download protocol attach";
          localObject = "" + localAttach.getHashId();
          QMLog.log(4, "QMSendMailTask", paramArrayList + ":" + localAttach.getHashId());
          localQMDownloadTask = getTaskInDownTaskList(localArrayList1, localAttach.getHashId() + "");
          if (localQMDownloadTask != null) {
            break label802;
          }
          if (!this.hasPrintedDownloadAttachLog)
          {
            DataCollector.logPerformanceBegin("Performance_Send_Download_Mail", 0L, "Performance_Send_Download_Mail" + paramMail.getInformation().getRemoteId());
            this.hasPrintedDownloadAttachLog = true;
          }
          QMLog.log(4, "QMSendMailTask", new StringBuilder().append(paramArrayList).append(" new:").toString() + localAttach.getHashId() + ";" + paramMail.getInformation().getAccountId() + ";" + paramMail.getInformation().getId());
          paramArrayList = new QMSendMailDownloadAttachTask((String)localObject, paramMail, localAttach);
          i = 1;
        }
        for (;;)
        {
          ((QMSendMailDownloadAttachTask)paramArrayList).bindDownloadAttachListener(this.downloadAttachWatch, true);
          localObject = paramArrayList;
          break;
          paramArrayList = "download qq attach";
          localObject = localAttach.getPreview().getDownloadUrl();
          break label555;
          return localArrayList2;
          i = 0;
          paramArrayList = localQMDownloadTask;
        }
      }
    }
  }
  
  private void error(String paramString, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    if (!this.mail.isSaved()) {
      QMSendMailNotification.getInstance().error(paramString, 0, paramArrayList1, paramArrayList2);
    }
  }
  
  private void filterSignTag()
  {
    String str = this.mail.getContent().getBody();
    if (str != null) {
      str.replaceAll("<sign>", "").replaceAll("</sign>", "");
    }
    this.mail.getContent().setBody(str);
  }
  
  private Attach getAttachById(long paramLong, String paramString)
  {
    int i = 0;
    while (i < this.downloadAttachList.size())
    {
      Attach localAttach = (Attach)this.downloadAttachList.get(i);
      if (((paramLong != 0L) && (localAttach.getHashId() == paramLong)) || ((paramLong == 0L) && (!paramString.equals("")) && (paramString.equals(localAttach.getHttpUrl())))) {
        return localAttach;
      }
      i += 1;
    }
    return null;
  }
  
  private AttachInfo getAttachInfoById(long paramLong)
  {
    if (this.mail.getAddAttachInfoList() != null)
    {
      int i = 0;
      while (i < this.mail.getAddAttachInfoList().size())
      {
        AttachInfo localAttachInfo = (AttachInfo)this.mail.getAddAttachInfoList().get(i);
        if (localAttachInfo.getHashId() == paramLong) {
          return localAttachInfo;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private DownloadImgWatcher getDownloadImageWatcher()
  {
    return new QMSendMailTask.4(this);
  }
  
  private String getMailIdWithComposeId(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.contains("composemail_"))
      {
        String[] arrayOfString = paramString.split("_");
        str = paramString;
        if (arrayOfString.length > 1) {
          str = arrayOfString[1];
        }
      }
    }
    return str;
  }
  
  private QMDownloadTask getTaskInDownTaskList(ArrayList<QMTask> paramArrayList, String paramString)
  {
    int j = QMDownloadTask.generateId(paramString);
    int i = 0;
    while (i < paramArrayList.size())
    {
      paramString = (QMDownloadTask)paramArrayList.get(i);
      if (paramString.getId() == j) {
        return paramString;
      }
      i += 1;
    }
    return null;
  }
  
  private void handleDownloadProgress(long paramLong1, long paramLong2)
  {
    long l = paramLong2;
    if (paramLong2 > paramLong1) {
      l = paramLong1;
    }
    double d = this.downloadIndex.get() / this.downloadTotalCnt.get() * 0.5D + l / paramLong1 * (0.5D / this.downloadTotalCnt.get());
    if (d > this.sendingProgress) {}
    for (;;)
    {
      this.sendingProgress = d;
      QMNotification.postNotification("refresh_sending_progress", Integer.valueOf(getId()));
      if (getTaskState() == QMTask.QMTaskState.QMTaskStateWaiting) {
        updateProgressBarRatio(this.sendingProgress);
      }
      return;
      d = this.sendingProgress;
    }
  }
  
  private void handleDownloadSuccess(long paramLong, String paramString1, String paramString2)
  {
    QMLog.log(4, "QMSendMailTask", "handleDownloadSuccess:" + this.downloadIndex + ",path:" + paramString1 + ",totalCnt:" + this.downloadIndex);
    this.downloadIndex.addAndGet(1);
    double d = this.downloadIndex.get() / this.downloadTotalCnt.get() * 0.5D;
    if (d > this.sendingProgress)
    {
      this.sendingProgress = d;
      QMNotification.postNotification("refresh_sending_progress", Integer.valueOf(getId()));
      if (getTaskState() == QMTask.QMTaskState.QMTaskStateWaiting) {
        updateProgressBarRatio(this.sendingProgress);
      }
      paramString2 = getAttachById(paramLong, paramString2);
      if (paramString2 != null)
      {
        paramString2.getHashId();
        String str = paramString2.getHttpUrl();
        if ((str == null) || (str.equals(""))) {
          break label297;
        }
        paramString1 = SendMailHelper.copyImgToComposeCache(this.mail, paramString1);
        if (paramString2.isInline()) {
          this.mail.getContent().setBody(SendMailHelper.updateInlineImgsWithSrc(this.mail.getContent().getBody(), str, "file://localhost" + paramString1));
        }
      }
    }
    for (;;)
    {
      if (this.downloadIndex.get() == this.downloadTotalCnt.get())
      {
        DataCollector.logPerformanceEnd("Performance_Send_Download_Mail" + this.mail.getOriginMailId(), "");
        sendMail();
      }
      return;
      d = this.sendingProgress;
      break;
      label297:
      if ((paramString2.getPreview().getMyDisk() != null) && (paramString2.getPreview().getMyDisk().startsWith("http:"))) {
        paramString2.getPreview().setMyDisk(paramString1);
      }
      paramString1 = SendMailHelper.copyAttachToComposeCacheAndDelete(this.mail, paramString2);
      if (paramString2.isInline())
      {
        this.mail.getContent().setBody(SendMailHelper.updateInlineImgsByComposeCache(this.mail.getContent().getBody(), SendMailHelper.getStrFromCid(paramString2.getProtocol().getCid()), "file://localhost" + paramString1));
        this.mail.getContent().setOrigin(SendMailHelper.updateInlineImgsByComposeCache(this.mail.getContent().getOrigin(), SendMailHelper.getStrFromCid(paramString2.getProtocol().getCid()), "file://localhost" + paramString1));
      }
    }
  }
  
  private void hideProgressBar()
  {
    if (!this.mail.isSaved()) {
      QMSendMailNotification.getInstance().stopNotification();
    }
  }
  
  private static boolean isBigAttachInList(ArrayList<AttachInfo> paramArrayList, MailBigAttach paramMailBigAttach)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      AttachInfo localAttachInfo = (AttachInfo)paramArrayList.next();
      if ((localAttachInfo.getAttach() != null) && ((localAttachInfo.getAttach() instanceof MailBigAttach)) && (((MailBigAttach)localAttachInfo.getAttach()).getHashId() == paramMailBigAttach.getHashId())) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isCanceled()
  {
    return getTaskState() == QMTask.QMTaskState.QMTaskStateCanceled;
  }
  
  private void logFail()
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(getAccountId());
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (localAccount != null)
    {
      localObject1 = localObject2;
      if (localAccount.isQQMail()) {
        localObject1 = localAccount.getUin();
      }
    }
    if (this.mail.isQuickReply()) {
      DataCollector.logDetailEvent("DetailEvent_QuickReplyNormalMail", getAccountId(), 1L, "回复普通邮件失败:" + (String)localObject1);
    }
    for (;;)
    {
      QMLog.log(6, "QMSendMailTask", "submitlog for sendmail fail.");
      QMLogStream.submitLog(true, true);
      return;
      if (this.mail.isQuickReplyGroup())
      {
        DataCollector.logDetailEvent("DetailEvent_QuickReplyGroupMail", getAccountId(), 1L, "快捷回复群邮件失败:" + (String)localObject1);
      }
      else if (getVerifyKey() != null)
      {
        DataCollector.logDetailEvent("DetailEvent_QuickReplyGroupMail", getAccountId(), 1L, "需要验证码:" + (String)localObject1);
      }
      else if (this.mail.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLY)
      {
        localObject2 = QMMailManager.sharedInstance().readMailOrSearchMail(this.mail.getOriginMailId());
        if (localObject2 != null) {
          if ((((Mail)localObject2).getStatus() != null) && (((Mail)localObject2).getStatus().isGroupMail())) {
            DataCollector.logDetailEvent("DetailEvent_ReplyGroupMail", getAccountId(), 1L, "回复群邮件失败:" + (String)localObject1);
          } else {
            DataCollector.logDetailEvent("DetailEvent_ReplyMail", getAccountId(), 1L, "回复邮件失败:" + (String)localObject1);
          }
        }
      }
      else if (this.mail.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLYALL)
      {
        DataCollector.logDetailEvent("DetailEvent_QuickReplyMail", getAccountId(), 1L, "");
      }
      else if (this.mail.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_FORWARD)
      {
        DataCollector.logDetailEvent("DetailEvent_ForwardMail", getAccountId(), 1L, "转发邮件失败:" + (String)localObject1);
      }
      else if (this.mail.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_GROUP_FORWARD)
      {
        DataCollector.logDetailEvent("DetailEvent_ForwardGroupMail", getAccountId(), 1L, "转发到群邮件失败:" + (String)localObject1);
      }
      else if (this.mail.getStatus().isGroupMail())
      {
        DataCollector.logDetailEvent("DetailEvent_NewGroupMail", getAccountId(), 1L, "新建群邮件发信失败:" + (String)localObject1);
      }
      else
      {
        DataCollector.logDetailEvent("DetailEvent_NewMail", getAccountId(), 1L, "新建普通发信失败:" + (String)localObject1);
      }
    }
  }
  
  private void logSuccess(int paramInt)
  {
    if (this.mail.isQuickReply()) {
      DataCollector.logDetailEvent("DetailEvent_QuickReplyNormalMail", getAccountId(), 0L, String.valueOf(paramInt));
    }
    for (;;)
    {
      QMLog.log(4, "QMSendMailTask", "submitlog for sendmail success.");
      QMLogStream.submitLog(true, true);
      return;
      if (this.mail.isQuickReplyGroup())
      {
        DataCollector.logDetailEvent("DetailEvent_QuickReplyGroupMail", getAccountId(), 0L, String.valueOf(paramInt));
      }
      else if (this.mail.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLY)
      {
        Mail localMail = QMMailManager.sharedInstance().readMailOrSearchMail(this.mail.getOriginMailId());
        if (localMail != null) {
          if ((localMail.getStatus() != null) && (localMail.getStatus().isGroupMail())) {
            DataCollector.logDetailEvent("DetailEvent_ReplyGroupMail", getAccountId(), 0L, String.valueOf(paramInt));
          } else {
            DataCollector.logDetailEvent("DetailEvent_ReplyMail", getAccountId(), 0L, String.valueOf(paramInt));
          }
        }
      }
      else if (this.mail.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLYALL)
      {
        DataCollector.logDetailEvent("DetailEvent_QuickReplyMail", getAccountId(), 0L, String.valueOf(paramInt));
      }
      else if (this.mail.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_FORWARD)
      {
        DataCollector.logDetailEvent("DetailEvent_ForwardMail", getAccountId(), 0L, String.valueOf(paramInt));
      }
      else if (this.mail.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_GROUP_FORWARD)
      {
        DataCollector.logDetailEvent("DetailEvent_ForwardGroupMail", getAccountId(), 0L, String.valueOf(paramInt));
      }
      else if (this.mail.getStatus().isGroupMail())
      {
        DataCollector.logDetailEvent("DetailEvent_NewGroupMail", getAccountId(), 0L, String.valueOf(paramInt));
      }
      else
      {
        DataCollector.logDetailEvent("DetailEvent_NewMail", getAccountId(), 0L, String.valueOf(paramInt));
      }
    }
  }
  
  private void renewBigAttachBeforeSendMail(QQMailAccount paramQQMailAccount)
  {
    int j = 0;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FtnUserProfile localFtnUserProfile = FtnManager.sharedInstance().getUserProfile(paramQQMailAccount.getUin());
    int i = j;
    if (this.mail.getAddAttachInfoList() != null)
    {
      i = j;
      if (localFtnUserProfile != null)
      {
        j = FtnManager.sharedInstance().getUserProfile(paramQQMailAccount.getUin()).getRenewDay();
        i = 0;
        while (i < this.mail.getAddAttachInfoList().size())
        {
          paramQQMailAccount = (AttachInfo)this.mail.getAddAttachInfoList().get(i);
          if ((paramQQMailAccount.isBigAttach()) && (!paramQQMailAccount.isNeedFtnUpload()))
          {
            paramQQMailAccount = (MailBigAttach)paramQQMailAccount.getAttach();
            if (paramQQMailAccount == null)
            {
              QMLog.log(6, "QMSendMailTask", "renewBigAttachBeforeSendMail, bigAttach is null!");
              return;
            }
            if ((!paramQQMailAccount.isBizNetDiskAttach()) && (paramQQMailAccount.getExpire() != null))
            {
              long l = (paramQQMailAccount.getExpire().getTime() - System.currentTimeMillis()) / 1000L;
              if ((paramQQMailAccount.getFid() != null) && (l > 0L) && (l < (j - 1) * 3600 * 24) && (FtnManager.sharedInstance().isFtnExsit(paramQQMailAccount.getFid())))
              {
                QMLog.log(4, "QMSendMailTask", "need renew bigAttach " + paramQQMailAccount.getName() + " old expireTime " + paramQQMailAccount.getExpire().getTime());
                localArrayList1.add(paramQQMailAccount.getFid());
                localArrayList2.add(Integer.valueOf((int)(paramQQMailAccount.getExpire().getTime() / 1000L) - 2));
              }
            }
          }
          i += 1;
        }
        i = j;
      }
    }
    if (localArrayList1.size() > 0)
    {
      FtnManager.sharedInstance().renewFile(localArrayList1, localArrayList2, new QMSendMailTask.9(this, localArrayList1, i));
      return;
    }
    sendMailAfterRenewBigAttach();
  }
  
  private void sendMail()
  {
    if (this.mail == null) {}
    while (AccountManager.shareInstance().getAccountList().getAccountById(getAccountId()) == null) {
      return;
    }
    QQMailAccount localQQMailAccount = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
    if ((QMSettingManager.sharedInstance().getFtnDisplay()) && (localQQMailAccount != null) && (this.mail.getAddAttachInfoList() != null) && (FtnCommonUtils.isSupportRenew()))
    {
      renewBigAttachBeforeSendMail(localQQMailAccount);
      return;
    }
    sendMailAfterRenewBigAttach();
  }
  
  private void sendMailAfterRenewBigAttach()
  {
    ArrayList localArrayList = SendMailHelper.getPhoneAccounts(this.mail);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      MailManagerDelegate localMailManagerDelegate = new MailManagerDelegate();
      localMailManagerDelegate.setOnSuccess(new QMSendMailTask.10(this));
      localMailManagerDelegate.setOnError(new QMSendMailTask.11(this));
      localMailManagerDelegate.setOnComplete(new QMSendMailTask.12(this));
      DataCollector.logPerformanceBegin("Performance_Send_MobileNumber", this.mail.getInformation().getAccountId(), "Performance_Send_MobileNumber" + this.mail.getComposeId());
      QMPrivateProtocolManager.sharedInstance().openPhoneAccount(localArrayList, localMailManagerDelegate);
      return;
    }
    doSendMail();
  }
  
  private void setComposeStateFromTaskState(QMTask.QMTaskState paramQMTaskState)
  {
    switch (QMSendMailTask.18.$SwitchMap$com$tencent$qqmail$model$task$QMTask$QMTaskState[paramQMTaskState.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.mail.setSendState(ComposeMailUI.QMComposeState.QMComposeStateWaiting);
      return;
    case 2: 
      this.mail.setSendState(ComposeMailUI.QMComposeState.QMComposeStateReady);
      return;
    case 3: 
      this.mail.setSendState(ComposeMailUI.QMComposeState.QMComposeStateSending);
      return;
    case 4: 
      this.mail.setSendState(ComposeMailUI.QMComposeState.QMComposeStateSuccess);
      return;
    case 5: 
      this.mail.setSendState(ComposeMailUI.QMComposeState.QMComposeStateFail);
      return;
    case 6: 
      this.mail.setSendState(ComposeMailUI.QMComposeState.QMComposeStateCanceling);
      return;
    }
    this.mail.setSendState(ComposeMailUI.QMComposeState.QMComposeStateCanceled);
  }
  
  private void setTaskStateFromComposeState(ComposeMailUI.QMComposeState paramQMComposeState)
  {
    switch (QMSendMailTask.18.$SwitchMap$com$tencent$qqmail$model$uidomain$ComposeMailUI$QMComposeState[paramQMComposeState.ordinal()])
    {
    default: 
      return;
    case 1: 
      super.setTaskState(QMTask.QMTaskState.QMTaskStateWaiting);
      return;
    case 2: 
      super.setTaskState(QMTask.QMTaskState.QMTaskStateReady);
      return;
    case 3: 
      super.setTaskState(QMTask.QMTaskState.QMTaskStateRunning);
      return;
    case 4: 
      super.setTaskState(QMTask.QMTaskState.QMTaskStateSuccess);
      return;
    case 5: 
      super.setTaskState(QMTask.QMTaskState.QMTaskStateFail);
      return;
    case 6: 
      super.setTaskState(QMTask.QMTaskState.QMTaskStateCanceling);
      return;
    }
    super.setTaskState(QMTask.QMTaskState.QMTaskStateCanceled);
  }
  
  private void success(String paramString1, String paramString2)
  {
    if (!this.mail.isSaved()) {
      QMSendMailNotification.getInstance().success(paramString1, paramString2, 0);
    }
  }
  
  private void summarizeSendMailFail(Integer paramInteger1, Integer paramInteger2)
  {
    if (getTaskState() != QMTask.QMTaskState.QMTaskStateFail) {
      return;
    }
    QMApplicationContext localQMApplicationContext = QMApplicationContext.sharedInstance();
    String str1 = "";
    if (paramInteger2.intValue() > 0) {
      str1 = String.format(localQMApplicationContext.getString(2131696471), new Object[] { paramInteger2 });
    }
    String str2 = str1;
    if (paramInteger1.intValue() > 0)
    {
      str2 = str1;
      if (paramInteger2.intValue() > 0) {
        str2 = str1 + "，";
      }
      str2 = str2 + String.format(localQMApplicationContext.getString(2131696465), new Object[] { paramInteger1 });
      DataCollector.logException(7, 48, "Event_Error", str2, true);
    }
    error(str2, mErrorSubjectList, mErrorMessageList);
    mErrorSubjectList.clear();
    mErrorMessageList.clear();
  }
  
  private void summarizeSendMailSucc(int paramInt)
  {
    if (getTaskState() != QMTask.QMTaskState.QMTaskStateSuccess) {
      return;
    }
    Object localObject = QMApplicationContext.sharedInstance();
    String str;
    if (paramInt > 1)
    {
      str = ((Context)localObject).getString(2131696469);
      localObject = String.format(((Context)localObject).getString(2131696471), new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      success(str, (String)localObject);
      return;
      if ((this.mail != null) && (this.mail.getClockSendTime() > 0L))
      {
        str = ((Context)localObject).getString(2131696470);
        localObject = ((Context)localObject).getString(2131696470);
      }
      else
      {
        str = ((Context)localObject).getString(2131696469);
        localObject = ((Context)localObject).getString(2131696469);
      }
    }
  }
  
  private void updateProgressBarRatio(double paramDouble)
  {
    ((SendMailWatcher)Watchers.of(SendMailWatcher.class)).onProgress(this.mail.getComposeId(), paramDouble);
    if (!this.mail.isSaved()) {
      QMSendMailNotification.getInstance().updateSendMailProgress(paramDouble, 0);
    }
  }
  
  private void updateProgressNumber(int paramInt1, int paramInt2)
  {
    if (!this.mail.isSaved()) {
      QMSendMailNotification.getInstance().updateSendMailNumber(paramInt1, paramInt2, 0);
    }
  }
  
  private void updateRemoteId(QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkResponse = (String)((JSONObject)paramQMNetworkResponse.getResponseJson()).get("mid");
    if (!isProtocol()) {}
    for (long l = Mail.generateId(this.mail.getInformation().getAccountId(), paramQMNetworkResponse);; l = Mail.generateId(this.mail.getInformation().getAccountId(), this.mail.getInformation().getFolderId(), paramQMNetworkResponse))
    {
      this.mail.getInformation().setId(l);
      this.mail.getInformation().setRemoteId(paramQMNetworkResponse);
      return;
    }
  }
  
  public void abort()
  {
    if (this.currentRequest != null)
    {
      boolean bool = this.currentRequest.abort();
      if (!bool) {
        changeSendStatus(ComposeMailUI.QMComposeState.QMComposeStateCanceling);
      }
      for (;;)
      {
        QMLog.log(4, "sendmailtask", "requestSending:" + bool);
        return;
        if (isProtocol())
        {
          handleError(new QMCancelError(true));
          handleComplete();
        }
        changeSendStatus(ComposeMailUI.QMComposeState.QMComposeStateCanceled);
      }
    }
    if ((this.downloadTotalCnt.get() > 0) && (this.downLoadAttachTaskMgr != null))
    {
      Object localObject = this.downLoadAttachTaskMgr.getTaskList();
      if (localObject != null)
      {
        int i = 0;
        if (i < ((ArrayList)localObject).size())
        {
          QMTask localQMTask = (QMTask)((ArrayList)localObject).get(i);
          if ((localQMTask instanceof QMInlineImgDownloadTask)) {
            ((QMInlineImgDownloadTask)localQMTask).unbindDownloadImageWatcher(getDownloadImageWatcher());
          }
          for (;;)
          {
            i += 1;
            break;
            if ((localQMTask instanceof QMSendMailDownloadAttachTask)) {
              ((QMSendMailDownloadAttachTask)localQMTask).bindDownloadAttachListener(this.downloadAttachWatch, false);
            }
          }
        }
      }
      this.downLoadAttachTaskMgr.cancelAll();
      localObject = new QMCancelError(true);
      Log.d("QMSendMailTask", "abort!!!");
      handleError(localObject);
      handleComplete();
      changeSendStatus(ComposeMailUI.QMComposeState.QMComposeStateCanceled);
      return;
    }
    QMLog.log(6, "sendmailtask", "abort on no handled time");
  }
  
  public void addToMainLoop()
  {
    updateProgressNumber(this.taskManager.getTaskIndex(), this.taskManager.getTaskToDoCnt() + this.taskManager.getTaskDoneCnt());
  }
  
  public void cancel()
  {
    changeSendStatus(ComposeMailUI.QMComposeState.QMComposeStateCanceled);
    QMNotification.postNotification("refresh_sending_progress", Integer.valueOf(getId()));
    QMTaskManager localQMTaskManager = getTaskManager();
    int i = localQMTaskManager.getTaskIndex();
    int j = localQMTaskManager.getTaskToDoCnt();
    updateProgressNumber(i, localQMTaskManager.getTaskDoneCnt() + j);
  }
  
  public void delete()
  {
    QMLog.log(4, "QMSendMailTask", "taskId:" + getId() + ", accountId:" + getAccountId());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(getId()));
    getSQLite().deleteTasks(localArrayList);
    QMNotification.postNotification("refresh_sending_list", null);
  }
  
  public void deleteComposeCache()
  {
    if (this.mail != null) {
      this.mail.deleteComposeCache();
    }
  }
  
  public int generateId()
  {
    return QMMath.hashInt(getAccountId() + "^" + this.mail.getComposeId());
  }
  
  public SendMailRequest getCurrentRequest()
  {
    return this.currentRequest;
  }
  
  public QMTaskManager getDownLoadAttachTaskMgr()
  {
    return this.downLoadAttachTaskMgr;
  }
  
  public ComposeMailUI getMail()
  {
    return this.mail;
  }
  
  public double getSendingProgress()
  {
    return this.sendingProgress;
  }
  
  public QMVerify getVerify()
  {
    return this.verify;
  }
  
  protected void handleBeforeRun()
  {
    super.handleBeforeRun();
  }
  
  protected void handleComplete()
  {
    int k = 0;
    if (getTaskState() == QMTask.QMTaskState.QMTaskStateSuccess)
    {
      delete();
      this.mail.deleteComposeCache();
    }
    QMLog.log(4, "QMSendMailTask", "handle Complete");
    QMTaskManager localQMTaskManager = getTaskManager();
    int i = localQMTaskManager.getTaskIndex();
    int j = localQMTaskManager.getTaskDoneCnt();
    int m = localQMTaskManager.getTaskToDoCnt();
    int n = localQMTaskManager.getCancelCnt();
    boolean bool;
    if (i >= m + j)
    {
      bool = true;
      QMLog.log(4, "QMSendMailTask", "isFinishAllTasks:" + bool + ";mailIndex:" + i + ";mailToSend:" + m + ";mailSended:" + j + ";cancelNum:" + n);
    }
    for (;;)
    {
      try
      {
        if (this.currentRequest != null) {
          this.currentRequest = null;
        }
        if (bool)
        {
          updateProgressNumber(i, m + j);
          hideProgressBar();
          if (i <= j)
          {
            summarizeSendMailSucc(j);
            if (this.mail.getInformation() != null)
            {
              if (this.mail.getInformation().getCcList() == null)
              {
                i = 0;
                if (this.mail.getInformation().getBccList() != null) {
                  continue;
                }
                j = 0;
                if (this.mail.getInformation().getToList() != null) {
                  continue;
                }
                logSuccess(k + (j + i));
              }
            }
            else
            {
              updateToDB();
              QMNotification.postNotification("delete_local_draft", this.mail);
              super.handleComplete();
              QMNotification.postNotification("refresh_sending_list", null);
              if (!bool) {
                updateProgressNumber(localQMTaskManager.getTaskIndex(), localQMTaskManager.getTaskToDoCnt() + localQMTaskManager.getTaskDoneCnt());
              }
              return;
              bool = false;
              break;
            }
            i = this.mail.getInformation().getCcList().size();
            continue;
            j = this.mail.getInformation().getBccList().size();
            continue;
            k = this.mail.getInformation().getToList().size();
            continue;
          }
          if (this.mail.getSendState() == ComposeMailUI.QMComposeState.QMComposeStateCanceled) {
            continue;
          }
          summarizeSendMailFail(Integer.valueOf(i - j - n), Integer.valueOf(j));
          continue;
        }
        if (this.mail.getSendState() != ComposeMailUI.QMComposeState.QMComposeStateCanceled) {
          break label415;
        }
      }
      finally {}
      updateToDB();
      label415:
      this.sendingProgress = 0.03D;
      updateProgressBarRatio(this.sendingProgress);
    }
  }
  
  protected void handleError(Object paramObject)
  {
    QMNetworkError localQMNetworkError = (QMNetworkError)paramObject;
    QMApplicationContext localQMApplicationContext = QMApplicationContext.sharedInstance();
    QMTaskManager localQMTaskManager = getTaskManager();
    Object localObject1 = ComposeMailUI.QMComposeState.QMComposeStateFail;
    Object localObject2 = paramObject;
    ComposeMailUI localComposeMailUI1;
    if (this.mail != null)
    {
      localComposeMailUI1 = this.mail;
      if (localQMNetworkError == null) {
        break label465;
      }
    }
    label465:
    for (;;)
    {
      try
      {
        if (((localQMNetworkError instanceof QMCancelError)) || (getTaskState() == QMTask.QMTaskState.QMTaskStateCanceling))
        {
          localObject2 = ComposeMailUI.QMComposeState.QMComposeStateCanceled;
          ComposeMailUI localComposeMailUI2 = this.mail;
          if (this.mail.getClockSendTime() > 0L)
          {
            localObject1 = localQMApplicationContext.getString(2131696464);
            localComposeMailUI2.setErrMsg((String)localObject1);
            if (!(localQMNetworkError instanceof QMCancelError)) {
              paramObject = new QMCancelError(true);
            }
            QMLog.log(6, "QMSendMailTask", "handleError: 邮件已取消发送,cancelNum:" + localQMTaskManager.getCancelCnt());
            localObject1 = localObject2;
            QMLog.log(6, "QMSendMailTask", "handleError composeId:" + this.mail.getComposeId() + " remoteId:" + this.mail.getInformation().getRemoteId() + " retryCount:" + (this.mail.getRetryCount() + 1));
            logFail();
            setRetryCount(getRetryCount() + 1);
            changeSendStatus((ComposeMailUI.QMComposeState)localObject1);
            if (isCanceled()) {
              QMNotification.postNotification("refresh_sending_list", null);
            }
            localObject2 = paramObject;
            super.handleError(localObject2);
            return;
          }
          localObject1 = localQMApplicationContext.getString(2131696463);
          continue;
        }
        localObject2 = localQMNetworkError.desp;
        this.mail.setErrMsg((String)localObject2);
        QMLog.log(6, "QMSendMailTask", "handleError:" + (String)localObject2);
        mErrorSubjectList.add(this.mail.getInformation().getSubject());
        mErrorMessageList.add(localObject2);
        if (getVerify() != null)
        {
          KvHelper.eventSendMailWithVerifykeyError(new double[0]);
          QMLog.log(4, "QMSendMailTask", "resend with verify error");
        }
        if ((localQMNetworkError instanceof QMSendMailCGIError))
        {
          localObject2 = (QMSendMailCGIError)localQMNetworkError;
          if (((QMSendMailCGIError)localObject2).isNeedVerifyCode())
          {
            this.mail.setDraftId(((QMSendMailCGIError)localObject2).getVerifyMailId());
            this.mail.getInformation().setRemoteId(((QMSendMailCGIError)localObject2).getVerifyMailId());
            setVerifyKey(((QMSendMailCGIError)localObject2).getVerifyKey());
            KvHelper.eventSendMailNeedVerifykey(new double[0]);
            QMLog.log(4, "QMSendMailTask", "send mail need verify");
          }
          else if (((QMSendMailCGIError)localObject2).isVerifyError())
          {
            setVerify(null);
            QMLog.log(4, "QMSendMailTask", "send mail with verify is VerifyError");
          }
        }
      }
      finally {}
    }
  }
  
  protected void handleRunning(Long paramLong1, Long paramLong2)
  {
    for (;;)
    {
      synchronized (this.mail)
      {
        if ((this.mail.getSendState() == ComposeMailUI.QMComposeState.QMComposeStateSending) || (this.mail.getSendState() == ComposeMailUI.QMComposeState.QMComposeStateReady))
        {
          if (this.downloadTotalCnt.get() > 0) {
            break label135;
          }
          if (!this.isDownloadOriginMail) {
            continue;
          }
          break label135;
          this.sendingProgress = calculateSendingProgress(this.sendingProgress, paramLong1.longValue(), paramLong2, bool);
          QMNotification.postNotification("refresh_sending_progress", Integer.valueOf(getId()));
          updateProgressBarRatio(this.sendingProgress);
          if (this.mail.getSendState() == ComposeMailUI.QMComposeState.QMComposeStateReady) {
            changeSendStatus(ComposeMailUI.QMComposeState.QMComposeStateSending);
          }
        }
        super.handleRunning(paramLong1, paramLong2);
        return;
        bool = false;
      }
      label135:
      boolean bool = true;
    }
  }
  
  protected void handleSucc(Object paramObject)
  {
    QMNetworkResponse localQMNetworkResponse = (QMNetworkResponse)paramObject;
    for (;;)
    {
      synchronized (this.mail)
      {
        if (this.mail.getSendState() == ComposeMailUI.QMComposeState.QMComposeStateCanceling)
        {
          DataCollector.logEvent("Event_Send_Mail_Cancel_Failed");
          if (!isProtocol())
          {
            updateRemoteId(localQMNetworkResponse);
            Threads.runInBackground(new QMSendMailTask.7(this), 700L);
            this.isCancelFail = true;
            updateToDB(this.mail.getInformation().getRemoteId());
          }
        }
        else
        {
          this.mail.setSendState(ComposeMailUI.QMComposeState.QMComposeStateSuccess);
          setTaskStateFromComposeState(ComposeMailUI.QMComposeState.QMComposeStateSuccess);
          this.mail.setSendRequest(null);
          QMNotification.postNotification("refresh_sending_progress", Integer.valueOf(getId()));
          updateProgressBarRatio(1.0D);
          if ((getVerify() == null) || (getRetryCount() >= 2)) {
            break label179;
          }
          QMLog.log(4, "QMSendMailTask", "resend with verify first success ");
          KvHelper.eventSendMailWithVerifykeyFirstSuccess(new double[0]);
          super.handleSucc(paramObject);
          return;
        }
        Threads.runInBackground(new QMSendMailTask.8(this), 700L);
      }
      label179:
      if (getVerify() != null) {
        QMLog.log(4, "QMSendMailTask", "resend with verify try cnt " + getRetryCount());
      }
    }
  }
  
  public void initFromDB() {}
  
  public boolean isProtocol()
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.mail.getInformation().getAccountId());
    if (localAccount == null) {}
    while (localAccount.isQQMail()) {
      return false;
    }
    return true;
  }
  
  public void resetVerifyKey()
  {
    super.resetVerifyKey();
    setVerify(null);
    updateToDB();
  }
  
  public void run()
  {
    this.sendingProgress = 0.0D;
    QMTaskManager localQMTaskManager = getTaskManager();
    Mail localMail1 = SendMailHelper.generateOriginMail(this.mail);
    boolean bool;
    if ((localMail1 != null) && (localMail1.getInformation().getAccountId() != this.mail.getInformation().getAccountId()))
    {
      bool = true;
      QMLog.log(4, "QMSendMailTask", "run to sendMail");
      this.downloadAttachList = SendMailHelper.prepareUploadAttachList(this.mail, bool);
      QMLog.log(4, "QMSendMailTask", "run:" + this.downloadAttachList.size());
      if ((!this.mail.getStatus().isProtocolMail()) || (localMail1.getStatus().isContentComplete()) || (this.mail.getFwdType() != 2)) {
        break label303;
      }
      QMLog.log(4, "QMSendMailTask", "protocol mail not complete");
      changeSendStatus(ComposeMailUI.QMComposeState.QMComposeStateReady);
      QMMailManager localQMMailManager = QMMailManager.sharedInstance();
      this.isDownloadOriginMail = true;
      Watchers.bind(this.readMailWatcher);
      Mail localMail2 = localQMMailManager.readMailOrSearchMail(localMail1.getInformation().getId());
      if ((localMail2 != null) && (localMail2.getContent() != null) && (!StringUtils.isBlank(localMail2.getContent().getBody()))) {
        this.originMailBody = localMail2.getContent().getBody();
      }
      localQMMailManager.loadMailAll(localMail1.getInformation().getId());
    }
    for (;;)
    {
      if (this.sendingProgress == 0.0D)
      {
        this.sendingProgress = 0.03D;
        QMNotification.postNotification("refresh_sending_progress", Integer.valueOf(getId()));
        updateProgressBarRatio(this.sendingProgress);
      }
      QMNotification.postNotification("refresh_sending_progress", Integer.valueOf(getId()));
      updateProgressNumber(localQMTaskManager.getTaskIndex(), localQMTaskManager.getTaskToDoCnt() + localQMTaskManager.getTaskDoneCnt());
      return;
      bool = false;
      break;
      label303:
      if (this.downloadAttachList.size() > 0)
      {
        QMLog.log(4, "QMSendMailTask", "downloadAttachList.size() " + this.downloadAttachList.size());
        this.downloadTotalCnt.set(this.downloadAttachList.size());
        downloadAttachList(localMail1, this.downloadAttachList);
        QMLog.log(4, "QMSendMailTask", "downloadTaskList.size() " + this.downloadTotalCnt.get());
        QMLog.log(4, "QMSendMailTask", "downloadAttachList.size() " + this.downloadAttachList.size());
      }
      else
      {
        QMLog.log(4, "QMSendMailTask", "start sendmail!");
        DataCollector.logPerformanceEnd("Performance_Send_Download_Mail" + this.mail.getOriginRemoteId(), "");
        sendMail();
      }
    }
  }
  
  public void saveToDB()
  {
    if (!this.mail.isSaved())
    {
      this.mail.getInformation().setRemoteId(this.mail.getComposeId());
      getSQLite().saveQMSendMailTask(this);
      this.mail.getInformation().setRemoteId(this.mail.originMailId());
      QMNotification.postNotification("refresh_sending_list", null);
    }
  }
  
  public void setDownLoadAttachTaskMgr(QMTaskManager paramQMTaskManager)
  {
    this.downLoadAttachTaskMgr = paramQMTaskManager;
  }
  
  public void setMail(ComposeMailUI paramComposeMailUI)
  {
    int j = getAccountId();
    int k = paramComposeMailUI.getInformation().getAccountId();
    if ((j != -1) && (j != k))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Integer.valueOf(getId()));
      getSQLite().deleteTasks(localArrayList);
    }
    for (int i = 1;; i = 0)
    {
      setAccountId(k);
      this.mail = paramComposeMailUI;
      if (getId() != generateId()) {
        QMLog.log(4, "QMSendMailTask", "QMSendMialTask#setMail: AccountId[%d,%d], taskId[%d,%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(getId()), Integer.valueOf(generateId()) });
      }
      if ((i != 0) || (getId() == 0)) {
        setId(generateId());
      }
      return;
    }
  }
  
  public void setRetryCount(int paramInt)
  {
    super.setRetryCount(paramInt);
    if (this.mail != null) {
      this.mail.setRetryCount(paramInt);
    }
  }
  
  public void setTaskState(QMTask.QMTaskState paramQMTaskState)
  {
    setComposeStateFromTaskState(paramQMTaskState);
    super.setTaskState(paramQMTaskState);
  }
  
  public void setVerify(QMVerify paramQMVerify)
  {
    this.verify = paramQMVerify;
  }
  
  public void updateToDB()
  {
    if (!this.isCancelFail) {
      this.mail.getInformation().setRemoteId(this.mail.getComposeId());
    }
    getSQLite().updateQMSendMailTaskInObservable(this).subscribe(new QMSendMailTask.5(this));
  }
  
  public void updateToDB(String paramString)
  {
    this.mail.getInformation().setRemoteId(paramString);
    getSQLite().updateQMSendMailTaskInObservable(this).subscribe(new QMSendMailTask.6(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMSendMailTask
 * JD-Core Version:    0.7.0.1
 */