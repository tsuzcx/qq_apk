package com.tencent.qqmail.download;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import com.alibaba.fastjson.JSONObject;
import com.tencent.androidqqmail.tim.QMAppInterface;
import com.tencent.moai.downloader.delegate.HandleErrorDelegate;
import com.tencent.moai.downloader.interceptor.RequestInterceptor;
import com.tencent.moai.downloader.listener.DownloadTaskListener;
import com.tencent.moai.downloader.model.DownloadStatus;
import com.tencent.moai.downloader.model.DownloadTask;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.download.listener.AttachDownloadListener;
import com.tencent.qqmail.download.model.BigAttachDownloadError;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.download.util.DownloadUtil;
import com.tencent.qqmail.download.watcher.ProtocolAttachDownloadWatcher;
import com.tencent.qqmail.marcos.CommonMatch;
import com.tencent.qqmail.model.mail.PasswordErrHandler;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.utilities.BrandUtil;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import com.tencent.qqmail.utilities.qmnetwork.CGIRequest;
import com.tencent.qqmail.utilities.qmnetwork.NetworkManager;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkConfig;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import moai.core.watcher.Watchers;

public class AttachDownloadManager
{
  private static final String TAG = "AttachDownloadManager";
  private static AttachDownloadManager instance;
  private final ConcurrentHashMap<Integer, Boolean> accountNeedToLogin = new ConcurrentHashMap();
  private final ConcurrentHashMap<Long, ArrayList<AttachDownloadListener>> attachListenerMap = new ConcurrentHashMap();
  private final ConcurrentHashMap<String, BigAttachDownloadError> bigAttachDownloadErrMap = new ConcurrentHashMap();
  private final ConcurrentHashMap<Long, DownloadInfo> downloadInfoMap = new ConcurrentHashMap();
  private final ConcurrentHashMap<Integer, ArrayList<DownloadInfo>> downloadInfoWaitForSession = new ConcurrentHashMap();
  private DownloadInfoManager infoManager = DownloadInfoManager.shareInstance();
  private Context mContext = QMApplicationContext.sharedInstance();
  private NotificationManager mNotifyManager = (NotificationManager)this.mContext.getSystemService("notification");
  
  private void bindProtocolAttachDownloadWatcher(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null)
    {
      paramDownloadInfo = new ProtocolAttachDownloadWatcher(paramDownloadInfo.getAttachId(), paramDownloadInfo.getUrl(), getDownloadTaskListener(paramDownloadInfo));
      Watchers.bind(paramDownloadInfo, true);
      QMWatcherCenter.bindDownloadAttachListener(paramDownloadInfo, true);
    }
  }
  
  private int checkLocalFile(DownloadInfo paramDownloadInfo)
  {
    int j = 0;
    int i = j;
    if (paramDownloadInfo != null)
    {
      String str = paramDownloadInfo.getUrl();
      try
      {
        File localFile = new File(new URI(str));
        if (localFile.exists())
        {
          QMLog.log(4, "AttachDownloadManager", "localFile exist: " + str);
          if (paramDownloadInfo.getAttachDownloadListener() != null) {
            paramDownloadInfo.getAttachDownloadListener().onSuccess(str, localFile, paramDownloadInfo.getSaveAsPath());
          }
        }
        else
        {
          QMLog.log(4, "AttachDownloadManager", "localFile not exist: " + str);
          i = j;
          if (paramDownloadInfo.getAttachDownloadListener() == null) {
            return i;
          }
          paramDownloadInfo.getAttachDownloadListener().onError(str, null);
          return 0;
        }
      }
      catch (URISyntaxException localURISyntaxException)
      {
        QMLog.log(6, "AttachDownloadManager", "loadFile URISyntax: " + str);
        i = j;
        if (paramDownloadInfo.getAttachDownloadListener() != null)
        {
          paramDownloadInfo.getAttachDownloadListener().onError(str, null);
          return 0;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        QMLog.log(6, "AttachDownloadManager", "localFile not exist: " + str);
        i = j;
        if (paramDownloadInfo.getAttachDownloadListener() != null)
        {
          paramDownloadInfo.getAttachDownloadListener().onError(str, null);
          return 0;
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        QMLog.log(6, "AttachDownloadManager", "localFile not exist: " + str);
        i = j;
        if (paramDownloadInfo.getAttachDownloadListener() != null)
        {
          paramDownloadInfo.getAttachDownloadListener().onError(str, null);
          return 0;
          i = 2;
        }
      }
    }
    return i;
  }
  
  private void downloadAttach(DownloadInfo paramDownloadInfo)
  {
    if (!DownloadUtil.validateDownloadInfo(paramDownloadInfo)) {
      QMLog.log(6, "AttachDownloadManager", "info invalidate");
    }
    do
    {
      return;
      localObject = new ArrayList();
      ((ArrayList)localObject).add("download");
      ((ArrayList)localObject).add("groupattachment");
      DownloadUtil.paddingDownloadInfo(paramDownloadInfo, (ArrayList)localObject);
    } while (isDownloadingUrl(paramDownloadInfo));
    Object localObject = DownloadInfoManager.shareInstance().getDownloadInfoById(paramDownloadInfo.getId());
    if ((localObject != null) && (((DownloadInfo)localObject).getStatus() == 3)) {
      paramDownloadInfo.setStatus(((DownloadInfo)localObject).getStatus());
    }
    if (paramDownloadInfo.isShouldUpdateInfo()) {
      this.infoManager.insertDownloadInfo(paramDownloadInfo);
    }
    if (paramDownloadInfo.getAttachType() == 3)
    {
      QMLog.log(4, "AttachDownloadManager", "download protocol attach:" + paramDownloadInfo.getUrl() + ",attachId:" + paramDownloadInfo.getAttachId() + ",mailId:" + paramDownloadInfo.getMailId());
      downloadProtocolAttach(paramDownloadInfo);
      return;
    }
    QMLog.log(4, "AttachDownloadManager", "download QQMail attach:" + paramDownloadInfo.getUrl() + ", attachType:" + paramDownloadInfo.getAttachType());
    downloadQQMailAttach(paramDownloadInfo);
  }
  
  private void downloadProtocolAttach(DownloadInfo paramDownloadInfo)
  {
    Attach localAttach = QMAttachManager.sharedInstance().getAttach(paramDownloadInfo.getAttachId());
    AttachPreview localAttachPreview = localAttach.getPreview();
    if (StringExtention.isNullOrEmpty(paramDownloadInfo.getSaveAsPath())) {}
    for (Object localObject = FileUtil.getAttachDownloadDir();; localObject = paramDownloadInfo.getSaveAsPath())
    {
      localAttachPreview.setMyDisk((String)localObject);
      localObject = QMMailManager.sharedInstance().readMailInfo(paramDownloadInfo.getMailId()).getInformation();
      bindProtocolAttachDownloadWatcher(paramDownloadInfo);
      QMMailManager.sharedInstance().downloadProtocolMailAttach((MailInformation)localObject, localAttach, true);
      return;
    }
  }
  
  private void downloadQQMailAttach(DownloadInfo paramDownloadInfo)
  {
    DownloadTask localDownloadTask = initDownloadTask(paramDownloadInfo);
    paramDownloadInfo.setDownloadTask(localDownloadTask);
    if (paramDownloadInfo.getAttachType() == 0) {}
    synchronized (this.accountNeedToLogin)
    {
      if (this.accountNeedToLogin.get(Integer.valueOf(paramDownloadInfo.getAccountId())) != null)
      {
        QMLog.log(4, "AttachDownloadManager", "add download info into wait queue:" + paramDownloadInfo.getUrl());
        addDownloadInfoIntoWait(paramDownloadInfo);
        return;
      }
      localDownloadTask.start();
      return;
    }
  }
  
  private DownloadTaskListener getDownloadTaskListener(DownloadInfo paramDownloadInfo)
  {
    return new AttachDownloadManager.3(this, paramDownloadInfo);
  }
  
  private HandleErrorDelegate getHandleErrorDelegate()
  {
    return new AttachDownloadManager.2(this);
  }
  
  private RequestInterceptor getRequestInterceptor(DownloadInfo paramDownloadInfo)
  {
    return new AttachDownloadManager.1(this, paramDownloadInfo);
  }
  
  private DownloadTask initDownloadTask(DownloadInfo paramDownloadInfo)
  {
    DownloadTask localDownloadTask = new DownloadTask();
    localDownloadTask.setUrl(DownloadUtil.getRequestUrl(paramDownloadInfo));
    localDownloadTask.setFileName(paramDownloadInfo.getFileName());
    localDownloadTask.setSingleTaskDownload(true);
    localDownloadTask.setFileSize(paramDownloadInfo.getFileSize());
    localDownloadTask.setId(DownloadUtil.getDownloadTaskId(paramDownloadInfo.getKey()));
    if (paramDownloadInfo.getStatus() == 3) {
      localDownloadTask.setDownloadStatus(new DownloadStatus(3));
    }
    if (paramDownloadInfo.getUrl().contains("cgi-bin/download?")) {
      localDownloadTask.setCheckHeaderCorrect(true);
    }
    if (StringExtention.isNullOrEmpty(paramDownloadInfo.getSaveAsPath())) {}
    for (String str = FileUtil.getAttachDownloadDir();; str = paramDownloadInfo.getSaveAsPath())
    {
      localDownloadTask.setFilePath(str + FileUtil.rename(str, paramDownloadInfo.getFileName()));
      paramDownloadInfo.setFilePath(localDownloadTask.getFilePath());
      localDownloadTask.setListener(getDownloadTaskListener(paramDownloadInfo));
      localDownloadTask.setRequestInterceptor(getRequestInterceptor(paramDownloadInfo));
      if ((paramDownloadInfo.getAttachType() == 1) || (paramDownloadInfo.getAttachType() == 2)) {
        localDownloadTask.setHandleErrorDelegate(getHandleErrorDelegate());
      }
      return localDownloadTask;
    }
  }
  
  private boolean isDownloadingUrl(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (!StringExtention.isNullOrEmpty(paramDownloadInfo.getKey())))
    {
      long l = DownloadUtil.getDownloadTaskId(paramDownloadInfo.getKey());
      synchronized (this.attachListenerMap)
      {
        ArrayList localArrayList2 = (ArrayList)this.attachListenerMap.get(Long.valueOf(l));
        ArrayList localArrayList1 = localArrayList2;
        if (localArrayList2 == null)
        {
          localArrayList1 = new ArrayList();
          this.attachListenerMap.put(Long.valueOf(l), localArrayList1);
        }
        if (paramDownloadInfo.getAttachDownloadListener() != null) {
          localArrayList1.add(paramDownloadInfo.getAttachDownloadListener());
        }
        if (this.downloadInfoMap.containsKey(Long.valueOf(l))) {
          return true;
        }
      }
      paramDownloadInfo.setStatus(0);
      this.downloadInfoMap.put(Long.valueOf(l), paramDownloadInfo);
    }
    return false;
  }
  
  private boolean isHandleFileSize(int paramInt)
  {
    return (paramInt != 2) && (paramInt != 3) && (paramInt != 4);
  }
  
  private QMCGIError parseError(DownloadInfo paramDownloadInfo, String paramString)
  {
    if (!paramString.contains("cgi exception"))
    {
      paramString = null;
      return paramString;
    }
    Object localObject1 = "";
    Object localObject2 = AccountManager.shareInstance().getAccountList().getAccountById(paramDownloadInfo.getAccountId());
    if (localObject2 != null) {
      localObject1 = ((Account)localObject2).getUin();
    }
    localObject2 = CommonMatch.findCgiName(paramDownloadInfo.getUrl());
    paramString = JSONReader.parse(paramString);
    if (paramString == null) {
      return new QMCGIError(0, 0, "数据格式错误", "", (String)localObject2, (String)localObject1, null);
    }
    paramString = (JSONObject)paramString;
    String str = (String)paramString.get("app_code");
    paramString.get("app_name");
    if ((str != null) && (str.matches("^(-)?[1-9]\\d*$"))) {}
    for (int i = Integer.parseInt(str);; i = 0)
    {
      if (i == 0) {
        return null;
      }
      paramString = (String)paramString.get("errmsg");
      localObject1 = new QMCGIError(i, 0, paramString, paramString, (String)localObject2, (String)localObject1, null);
      paramString = (String)localObject1;
      if (((QMCGIError)localObject1).isSessionTimeouted()) {
        break;
      }
      if ((i == 1) || (i == 7))
      {
        PasswordErrHandler.saveStateAndShowErr(paramDownloadInfo.getAccountId(), -1);
        return localObject1;
      }
      if (i == 6)
      {
        PasswordErrHandler.saveStateAndShowErr(paramDownloadInfo.getAccountId(), -2);
        return localObject1;
      }
      paramString = (String)localObject1;
      if (i != 4) {
        break;
      }
      PasswordErrHandler.saveStateAndShowErr(paramDownloadInfo.getAccountId(), -3);
      return localObject1;
    }
  }
  
  public static AttachDownloadManager shareInstance()
  {
    if (instance == null) {
      instance = new AttachDownloadManager();
    }
    return instance;
  }
  
  private void updateNotificationBar(DownloadInfo paramDownloadInfo)
  {
    long l1;
    if ((paramDownloadInfo.isNotify()) && (paramDownloadInfo.getIntent() != null))
    {
      l1 = System.currentTimeMillis();
      if (l1 - paramDownloadInfo.getLastNotifyTime() > 300L)
      {
        paramDownloadInfo.setLastNotifyTime(l1);
        if (paramDownloadInfo.getNotificationId() != 0) {
          break label106;
        }
      }
    }
    Notification.Builder localBuilder;
    label106:
    for (int i = (int)System.currentTimeMillis();; i = paramDownloadInfo.getNotificationId())
    {
      localObject = PendingIntent.getActivity(this.mContext, i, paramDownloadInfo.getIntent(), 134217728);
      localBuilder = new Notification.Builder(this.mContext);
      long l2 = paramDownloadInfo.getFileSize();
      l1 = l2;
      if (l2 == 0L) {
        l1 = paramDownloadInfo.getDownloadSize();
      }
      if (l1 != 0L) {
        break;
      }
      return;
    }
    localBuilder.setContentTitle(paramDownloadInfo.getFileName()).setContentIntent((PendingIntent)localObject).setContentText(String.format(this.mContext.getString(2131696433), new Object[] { Integer.valueOf((int)(100L * paramDownloadInfo.getDownloadSize() / l1)) })).setSmallIcon(QMAppInterface.sharedInstance().getNtId()).setOngoing(true).setProgress((int)l1, (int)paramDownloadInfo.getDownloadSize(), false);
    Object localObject = localBuilder.build();
    ((Notification)localObject).flags |= 0x20;
    ((Notification)localObject).flags |= 0x2;
    ((Notification)localObject).when = paramDownloadInfo.getCreateTime();
    ((Notification)localObject).icon = 2130850524;
    paramDownloadInfo.getIntent().setFlags(268435456);
    paramDownloadInfo.setNotificationId(i);
    this.mNotifyManager.notify(paramDownloadInfo.getNotificationId(), (Notification)localObject);
  }
  
  private void updateNotificationText(DownloadInfo paramDownloadInfo)
  {
    boolean bool2 = false;
    int i;
    PendingIntent localPendingIntent;
    boolean bool1;
    Object localObject1;
    if ((paramDownloadInfo.isNotify()) && (paramDownloadInfo.getIntent() != null))
    {
      if (paramDownloadInfo.getNotificationId() != 0) {
        break label281;
      }
      i = (int)System.currentTimeMillis();
      localPendingIntent = PendingIntent.getActivity(this.mContext, i, paramDownloadInfo.getIntent(), 134217728);
      localObject2 = "";
      bool1 = bool2;
      localObject1 = localObject2;
      switch (paramDownloadInfo.getStatus())
      {
      default: 
        localObject1 = localObject2;
        bool1 = bool2;
      case 1: 
      case 2: 
        label112:
        localObject2 = new Notification.Builder(this.mContext);
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ((Notification.Builder)localObject2).setContentTitle(paramDownloadInfo.getFileName()).setContentIntent(localPendingIntent).setContentText((CharSequence)localObject1);
        if (!BrandUtil.isColorfulNotificationIcon()) {
          continue;
        }
        j = 2130840992;
        ((Notification.Builder)localObject1).setSmallIcon(j).setOngoing(bool1).setProgress(0, 0, false);
      }
      catch (NoSuchMethodError localNoSuchMethodError)
      {
        label281:
        localNoSuchMethodError.printStackTrace();
        continue;
        int j = 2130841012;
        continue;
        ((Notification.Builder)localObject2).setLargeIcon(BitmapFactory.decodeResource(this.mContext.getResources(), 2130840992));
        ((Notification.Builder)localObject2).setSmallIcon(QMAppInterface.sharedInstance().getNtId());
        continue;
        if (paramDownloadInfo.getStatus() != 4) {
          continue;
        }
        localNoSuchMethodError.icon = 2130841003;
        continue;
        localNoSuchMethodError.icon = 2130850524;
        continue;
      }
      if (paramDownloadInfo.getStatus() == 4)
      {
        if (Build.VERSION.SDK_INT >= 21) {
          continue;
        }
        if (!BrandUtil.isColorfulNotificationIcon()) {
          continue;
        }
        j = 2130840992;
        ((Notification.Builder)localObject2).setSmallIcon(j);
      }
      localObject1 = ((Notification.Builder)localObject2).build();
      ((Notification)localObject1).flags |= 0x10;
      if ((paramDownloadInfo.getStatus() != 5) && (paramDownloadInfo.getStatus() != 3)) {
        continue;
      }
      ((Notification)localObject1).icon = 2130841014;
      paramDownloadInfo.setNotificationId(i);
      paramDownloadInfo.getIntent().setFlags(268435456);
      this.mNotifyManager.notify(paramDownloadInfo.getNotificationId(), (Notification)localObject1);
      return;
      i = paramDownloadInfo.getNotificationId();
      break;
      if (paramDownloadInfo.getIntent().getBooleanExtra("clickFileShare", false))
      {
        localObject1 = this.mContext.getString(2131696438);
        bool1 = bool2;
        break label112;
      }
      localObject1 = this.mContext.getString(2131696437);
      bool1 = bool2;
      break label112;
      localObject1 = this.mContext.getString(2131696436);
      bool1 = bool2;
      break label112;
      localObject1 = this.mContext.getString(2131696435);
      bool1 = bool2;
      break label112;
      localObject1 = this.mContext.getString(2131696439);
      bool1 = true;
      break label112;
      j = 2130841012;
    }
  }
  
  public void abort(String paramString)
  {
    QMLog.log(4, "AttachDownloadManager", "abort downloadTask:" + paramString);
    paramString = (DownloadInfo)this.downloadInfoMap.get(Long.valueOf(DownloadUtil.getDownloadTaskId(paramString)));
    if (paramString != null)
    {
      if (paramString.getAttachType() != 3) {
        break label77;
      }
      paramString = (ProtocolAttachDownloadWatcher)QMWatcherCenter.getDownloadWatcherById(paramString.getAttachId());
      if (paramString != null) {
        paramString.abort();
      }
    }
    label77:
    do
    {
      return;
      paramString = paramString.getDownloadTask();
    } while (paramString == null);
    paramString.abort();
  }
  
  public void addAttachDownloadListener(String paramString, AttachDownloadListener paramAttachDownloadListener)
  {
    if ((!StringExtention.isNullOrEmpty(paramString)) && (paramAttachDownloadListener != null)) {
      synchronized (this.attachListenerMap)
      {
        ArrayList localArrayList2 = (ArrayList)this.attachListenerMap.get(Long.valueOf(DownloadUtil.getDownloadTaskId(paramString)));
        ArrayList localArrayList1 = localArrayList2;
        if (localArrayList2 == null)
        {
          localArrayList1 = new ArrayList();
          this.attachListenerMap.put(Long.valueOf(DownloadUtil.getDownloadTaskId(paramString)), localArrayList1);
        }
        localArrayList1.add(paramAttachDownloadListener);
        return;
      }
    }
  }
  
  public void addDownloadInfoIntoWait(DownloadInfo paramDownloadInfo)
  {
    ArrayList localArrayList2 = (ArrayList)this.downloadInfoWaitForSession.get(Integer.valueOf(paramDownloadInfo.getAccountId()));
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null) {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.add(paramDownloadInfo);
    this.downloadInfoWaitForSession.put(Integer.valueOf(paramDownloadInfo.getAccountId()), localArrayList1);
  }
  
  public void autoLoginForDownload(int paramInt)
  {
    int i = 1;
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    int j;
    if ((localAccount != null) && ((localAccount instanceof QQMailAccount)))
    {
      j = localAccount.getLoginStatus();
      if ((j == 1) || (j == 4)) {
        break label91;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        QMLog.log(4, "AttachDownloadManager", "auto login for download:" + j);
        ((QQMailAccount)localAccount).autoLogin(new AttachDownloadManager.4(this, paramInt));
      }
      return;
      label91:
      i = 0;
    }
  }
  
  public int fetchAttach(DownloadInfo paramDownloadInfo)
  {
    int i = 0;
    if (!DownloadUtil.validateDownloadInfo(paramDownloadInfo)) {}
    String str;
    do
    {
      File localFile;
      do
      {
        return i;
        str = paramDownloadInfo.getUrl();
        if (str.startsWith("file://")) {
          return checkLocalFile(paramDownloadInfo);
        }
        localFile = getAttachFromLocal(paramDownloadInfo.getFilePath());
        if (localFile == null) {
          break;
        }
        i = 2;
      } while (paramDownloadInfo.getAttachDownloadListener() == null);
      paramDownloadInfo.getAttachDownloadListener().onSuccess(str, localFile, paramDownloadInfo.getSaveAsPath());
      return 2;
      try
      {
        downloadAttach(paramDownloadInfo);
        return 0;
      }
      catch (Exception localException) {}
    } while (paramDownloadInfo.getAttachDownloadListener() == null);
    paramDownloadInfo.getAttachDownloadListener().onError(str, localException);
    return 0;
  }
  
  public void fetchBigAttachData(String paramString, int paramInt, QMCallback paramQMCallback1, QMCallback paramQMCallback2)
  {
    if (StringExtention.isNullOrEmpty(paramString)) {
      return;
    }
    paramString = StringExtention.removeTokenFromUrl(StringExtention.parseUrlParam(paramString.replace("&amp", "&")), "t=");
    Object localObject = StringExtention.appendString(paramString, "&t=ftnExs_Key&from=mobile");
    localObject = new CGIRequest(paramInt, QMNetworkConfig.getCgiRequestHost(paramInt) + "/cgi-bin/" + (String)localObject);
    ((QMNetworkRequest)localObject).setRequestCallback(paramQMCallback1);
    ((QMNetworkRequest)localObject).setSuggestParseResponseToJson(false);
    NetworkManager.sharedInstance().sendRequest((QMNetworkRequest)localObject);
    CGIManager.httpGet(paramInt, StringExtention.appendString(paramString, "&t=ftnExs_download.json&from=mobile"), null, paramQMCallback2);
  }
  
  public File getAttachFromLocal(String paramString)
  {
    if (!StringExtention.isNullOrEmpty(paramString))
    {
      paramString = new File(paramString);
      if ((paramString != null) && (paramString.exists())) {
        return paramString;
      }
    }
    return null;
  }
  
  public DownloadInfo getDownloadInfoByKey(String paramString)
  {
    if (!StringExtention.isNullOrEmpty(paramString)) {
      return (DownloadInfo)this.downloadInfoMap.get(Long.valueOf(DownloadUtil.getDownloadTaskId(paramString)));
    }
    return null;
  }
  
  public int getStatusByKey(String paramString)
  {
    paramString = (DownloadInfo)this.downloadInfoMap.get(Long.valueOf(DownloadUtil.getDownloadTaskId(paramString)));
    if (paramString != null) {
      return paramString.getStatus();
    }
    return -1;
  }
  
  public void refreshBigAttach(String paramString, int paramInt, QMCallback paramQMCallback)
  {
    if (StringExtention.isNullOrEmpty(paramString)) {
      return;
    }
    CGIManager.httpGet(paramInt, StringExtention.appendString(StringExtention.removeTokenFromUrl(StringExtention.parseUrlParam(paramString.replace("&amp", "&")), "t="), "&t=ftnExs_download.json&from=mobile"), null, paramQMCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.AttachDownloadManager
 * JD-Core Version:    0.7.0.1
 */