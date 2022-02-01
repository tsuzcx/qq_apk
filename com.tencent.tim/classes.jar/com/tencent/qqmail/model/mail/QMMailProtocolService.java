package com.tencent.qqmail.model.mail;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.moai.mailsdk.callback.IdleCallback;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.MailServiceManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.callback.CheckMailCallback;
import com.tencent.qqmail.model.mail.callback.FolderListCallback;
import com.tencent.qqmail.model.mail.callback.FolderOperationCallback;
import com.tencent.qqmail.model.mail.callback.IListStatusCallback;
import com.tencent.qqmail.model.mail.callback.LoadEmlCallback;
import com.tencent.qqmail.model.mail.callback.LoadMailAbstractCallback;
import com.tencent.qqmail.model.mail.callback.LoadMailAttachCallBack;
import com.tencent.qqmail.model.mail.callback.LoadMailCallback;
import com.tencent.qqmail.model.mail.callback.LoginCallback;
import com.tencent.qqmail.model.mail.callback.LogoutCallback;
import com.tencent.qqmail.model.mail.callback.MailListCallback;
import com.tencent.qqmail.model.mail.callback.SearchAddressCallback;
import com.tencent.qqmail.model.mail.callback.SearchMailCallback;
import com.tencent.qqmail.model.mail.cursor.QMSearchCursor;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.qmdomain.SearchInfo;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.protocol.Exchange.ExchangeRule;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.provider.ConnectSelector;
import com.tencent.qqmail.provider.MailServiceProvider;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMGeneralCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;
import com.tencent.qqmail.utilities.qmnetwork.QMProxyUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import moai.oss.OssHelper;

public class QMMailProtocolService
{
  private static final String TAG = "QMMailProtocolService";
  private static boolean isEnableEasService = QMSettingManager.sharedInstance().isEnableJavaEasService();
  private static boolean isEnableEwsService = QMSettingManager.sharedInstance().isEnableJavaEwsService();
  private static boolean isEnableImapIdle = QMSettingManager.sharedInstance().isEnableJavaImapIdle();
  private static boolean isEnableImapService;
  private static boolean isEnablePop3Service = QMSettingManager.sharedInstance().isEnableJavaPop3Service();
  private static boolean isEnableSmtpService;
  private volatile QMMailProtocolJavaService javaService;
  private volatile QMMailProtocolNativeService nativeService;
  
  static
  {
    isEnableImapService = QMSettingManager.sharedInstance().isEnableJavaImapService();
    isEnableSmtpService = QMSettingManager.sharedInstance().isEnableJavaSmtpService();
  }
  
  public QMMailProtocolService()
  {
    getJavaService();
    initProfile();
  }
  
  private static boolean enableEasService()
  {
    return true;
  }
  
  private static boolean enableEwsService()
  {
    return true;
  }
  
  private static boolean enableImapService()
  {
    return true;
  }
  
  private static boolean enablePop3Service()
  {
    return true;
  }
  
  private static boolean enableSmtpService()
  {
    return true;
  }
  
  private void fillActiveSyncProvider(MailServiceProvider paramMailServiceProvider, String paramString, ArrayList<DomainConfig> paramArrayList)
  {
    if (!StringExtention.isNullOrEmpty(paramMailServiceProvider.getExchangeServer()))
    {
      paramString = new DomainConfig(null);
      paramString.isUsingSSL = false;
      paramString.server = paramMailServiceProvider.getPop3Server();
      paramString.port = 80;
      paramString.protocol = "ACTIVESYNC";
      paramArrayList.add(paramString);
      paramString = new DomainConfig(null);
      paramString.isUsingSSL = true;
      paramString.server = paramMailServiceProvider.getPop3Server();
      paramString.port = 443;
      paramString.protocol = "ACTIVESYNC";
      paramArrayList.add(paramString);
      return;
    }
    paramMailServiceProvider = "mail." + paramString;
    paramString = new DomainConfig(null);
    paramString.isUsingSSL = true;
    paramString.server = paramMailServiceProvider;
    paramString.port = 443;
    paramString.protocol = "ACTIVESYNC";
    paramArrayList.add(paramString);
  }
  
  private void fillImapProvider(MailServiceProvider paramMailServiceProvider, String paramString, ArrayList<DomainConfig> paramArrayList)
  {
    Object localObject;
    if (!StringExtention.isNullOrEmpty(paramMailServiceProvider.getImapServer()))
    {
      localObject = new DomainConfig(null);
      ((DomainConfig)localObject).isUsingSSL = false;
      ((DomainConfig)localObject).server = paramMailServiceProvider.getImapServer();
      ((DomainConfig)localObject).port = paramMailServiceProvider.getImapPort();
      ((DomainConfig)localObject).protocol = "IMAP";
      paramArrayList.add(localObject);
      localObject = new DomainConfig(null);
      ((DomainConfig)localObject).isUsingSSL = true;
      ((DomainConfig)localObject).server = paramMailServiceProvider.getImapServer();
      ((DomainConfig)localObject).port = paramMailServiceProvider.getImapSSLPort();
      ((DomainConfig)localObject).protocol = "IMAP";
      paramArrayList.add(localObject);
    }
    paramMailServiceProvider = new String[2];
    paramMailServiceProvider[0] = "imap";
    paramMailServiceProvider[1] = "mail";
    int j = paramMailServiceProvider.length;
    int i = 0;
    while (i < j)
    {
      localObject = paramMailServiceProvider[i];
      localObject = (String)localObject + "." + paramString;
      DomainConfig localDomainConfig = new DomainConfig(null);
      localDomainConfig.isUsingSSL = false;
      localDomainConfig.server = ((String)localObject);
      localDomainConfig.port = 143;
      localDomainConfig.protocol = "IMAP";
      paramArrayList.add(localDomainConfig);
      localDomainConfig = new DomainConfig(null);
      localDomainConfig.isUsingSSL = true;
      localDomainConfig.server = ((String)localObject);
      localDomainConfig.port = 993;
      localDomainConfig.protocol = "IMAP";
      paramArrayList.add(localDomainConfig);
      i += 1;
    }
  }
  
  private void fillPopProvider(MailServiceProvider paramMailServiceProvider, String paramString, ArrayList<DomainConfig> paramArrayList)
  {
    if (("hotmail.com".equals(paramString)) || ("outlook.com".equals(paramString))) {}
    for (;;)
    {
      return;
      Object localObject;
      if (!StringExtention.isNullOrEmpty(paramMailServiceProvider.getPop3Server()))
      {
        localObject = new DomainConfig(null);
        ((DomainConfig)localObject).isUsingSSL = false;
        ((DomainConfig)localObject).server = paramMailServiceProvider.getPop3Server();
        ((DomainConfig)localObject).port = paramMailServiceProvider.getPop3Port();
        ((DomainConfig)localObject).protocol = "POP";
        paramArrayList.add(localObject);
        localObject = new DomainConfig(null);
        ((DomainConfig)localObject).isUsingSSL = true;
        ((DomainConfig)localObject).server = paramMailServiceProvider.getPop3Server();
        ((DomainConfig)localObject).port = paramMailServiceProvider.getPop3SSLPort();
        ((DomainConfig)localObject).protocol = "POP";
        paramArrayList.add(localObject);
      }
      paramMailServiceProvider = new String[3];
      paramMailServiceProvider[0] = "pop";
      paramMailServiceProvider[1] = "pop3";
      paramMailServiceProvider[2] = "mail";
      int j = paramMailServiceProvider.length;
      int i = 0;
      while (i < j)
      {
        localObject = paramMailServiceProvider[i];
        localObject = (String)localObject + "." + paramString;
        DomainConfig localDomainConfig = new DomainConfig(null);
        localDomainConfig.isUsingSSL = false;
        localDomainConfig.server = ((String)localObject);
        localDomainConfig.port = 110;
        localDomainConfig.protocol = "POP";
        paramArrayList.add(localDomainConfig);
        localDomainConfig = new DomainConfig(null);
        localDomainConfig.isUsingSSL = true;
        localDomainConfig.server = ((String)localObject);
        localDomainConfig.port = 995;
        localDomainConfig.protocol = "POP";
        paramArrayList.add(localDomainConfig);
        i += 1;
      }
    }
  }
  
  private void fillSmtpProvider(MailServiceProvider paramMailServiceProvider, String paramString, ArrayList<DomainConfig> paramArrayList)
  {
    Object localObject;
    if (!StringExtention.isNullOrEmpty(paramMailServiceProvider.getSmtpServer()))
    {
      localObject = new DomainConfig(null);
      ((DomainConfig)localObject).isUsingSSL = false;
      ((DomainConfig)localObject).server = paramMailServiceProvider.getSmtpServer();
      ((DomainConfig)localObject).port = paramMailServiceProvider.getSmtpPort();
      ((DomainConfig)localObject).protocol = "SMTP";
      paramArrayList.add(localObject);
      localObject = new DomainConfig(null);
      ((DomainConfig)localObject).isUsingSSL = true;
      ((DomainConfig)localObject).server = paramMailServiceProvider.getSmtpServer();
      ((DomainConfig)localObject).port = paramMailServiceProvider.getSmtpSSLPort();
      ((DomainConfig)localObject).protocol = "SMTP";
      paramArrayList.add(localObject);
    }
    paramMailServiceProvider = new String[2];
    paramMailServiceProvider[0] = "smtp";
    paramMailServiceProvider[1] = "mail";
    int j = paramMailServiceProvider.length;
    int i = 0;
    while (i < j)
    {
      localObject = paramMailServiceProvider[i];
      localObject = (String)localObject + "." + paramString;
      DomainConfig localDomainConfig = new DomainConfig(null);
      localDomainConfig.isUsingSSL = false;
      localDomainConfig.server = ((String)localObject);
      localDomainConfig.port = 25;
      localDomainConfig.protocol = "SMTP";
      paramArrayList.add(localDomainConfig);
      localDomainConfig = new DomainConfig(null);
      localDomainConfig.isUsingSSL = true;
      localDomainConfig.server = ((String)localObject);
      localDomainConfig.port = 465;
      localDomainConfig.protocol = "SMTP";
      paramArrayList.add(localDomainConfig);
      i += 1;
    }
  }
  
  private QMMailProtocolJavaService getJavaService()
  {
    if (this.javaService == null) {}
    try
    {
      if (this.javaService == null)
      {
        this.javaService = new QMMailProtocolJavaService();
        this.javaService.initProtocolService();
      }
      return this.javaService;
    }
    finally {}
  }
  
  private QMMailProtocolNativeService getNativeService()
  {
    if (this.nativeService == null) {}
    try
    {
      if (this.nativeService == null)
      {
        this.nativeService = new QMMailProtocolNativeService();
        this.nativeService.initProtocolService();
      }
      return this.nativeService;
    }
    finally {}
  }
  
  private boolean isNetworkError(Profile paramProfile, int paramInt)
  {
    if (((paramProfile.protocolType == 0) && (enablePop3Service())) || ((paramProfile.protocolType == 1) && (enableImapService()))) {}
    for (int i = 1; ((i != 0) && (paramInt == 5)) || ((i == 0) && ((paramInt == 2) || (paramInt == 3) || (paramInt == 5) || (paramInt == 10) || (paramInt == 15))); i = 0) {
      return true;
    }
    return false;
  }
  
  private boolean needProxy(Profile paramProfile, int paramInt)
  {
    boolean bool1 = isNetworkError(paramProfile, paramInt);
    boolean bool2 = QMNetworkUtils.isNetworkConnected();
    boolean bool3 = QMNetworkUtils.isNetworkAvailable();
    QMLog.log(5, "QMMailProtocolService", "needProxy, isNetworkError: " + bool1 + ", errCode: " + paramInt + ", connected: " + bool2 + ", available: " + bool3);
    return (bool2) && (bool3) && (bool1) && (QMProxyUtil.trySocket5HProxy(paramProfile));
  }
  
  private void reportConnectState(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    OssHelper.autoQueryDomainConfig(new Object[] { paramString1, "result", paramString2, paramString3, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
  }
  
  public static void setIsEnableImapIdle(boolean paramBoolean)
  {
    isEnableImapIdle = paramBoolean;
  }
  
  public void addFolder(Account paramAccount, QMFolder paramQMFolder, FolderOperationCallback paramFolderOperationCallback)
  {
    switch (paramAccount.getProfile().protocolType)
    {
    case 0: 
    case 2: 
    default: 
      return;
    case 1: 
      if (enableImapService())
      {
        getJavaService().addFolder(paramAccount, paramQMFolder, paramFolderOperationCallback);
        return;
      }
      getNativeService().addFolder(paramAccount, paramQMFolder, paramFolderOperationCallback);
      return;
    case 4: 
      if (enableEasService())
      {
        getJavaService().addFolder(paramAccount, paramQMFolder, paramFolderOperationCallback);
        return;
      }
      getNativeService().addFolder(paramAccount, paramQMFolder, paramFolderOperationCallback);
      return;
    }
    if (enableEwsService())
    {
      getJavaService().addFolder(paramAccount, paramQMFolder, paramFolderOperationCallback);
      return;
    }
    getNativeService().addFolder(paramAccount, paramQMFolder, paramFolderOperationCallback);
  }
  
  public void addRule(Account paramAccount, Exchange.ExchangeRule[] paramArrayOfExchangeRule)
  {
    if (enableEwsService())
    {
      getJavaService().addRule(paramAccount, paramArrayOfExchangeRule);
      return;
    }
    getNativeService().addRule(paramAccount, paramArrayOfExchangeRule);
  }
  
  public void appendFile()
  {
    getJavaService().appendFile();
  }
  
  public void appendMailToServer(Account paramAccount, QMFolder paramQMFolder, Mail paramMail, MailManagerDelegate paramMailManagerDelegate)
  {
    if (paramAccount.getProfile().protocolType == 1)
    {
      if (enableImapService()) {
        getJavaService().appendMailToServer(paramAccount, paramQMFolder, paramMail, paramMailManagerDelegate);
      }
    }
    else {
      return;
    }
    getNativeService().appendMailToServer(paramAccount, paramQMFolder, paramMail, paramMailManagerDelegate);
  }
  
  public MailServiceProvider autoFillMailProvider(MailServiceProvider paramMailServiceProvider, String paramString, boolean paramBoolean)
    throws Exception
  {
    Object localObject1 = MailServiceManager.getInstance().getAutoFillMailProvider(paramString);
    if (localObject1 != null) {
      return ((MailServiceProvider)localObject1).deepCopy();
    }
    long l = System.currentTimeMillis();
    if (paramMailServiceProvider == null) {
      paramMailServiceProvider = new MailServiceProvider();
    }
    for (;;)
    {
      Object localObject2 = new ArrayList();
      if (paramBoolean) {
        fillActiveSyncProvider(paramMailServiceProvider, paramString, (ArrayList)localObject2);
      }
      CountDownLatch localCountDownLatch;
      for (;;)
      {
        localObject1 = new ConnectSelector();
        localCountDownLatch = new CountDownLatch(1);
        HashMap localHashMap = new HashMap();
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          new Thread(new QMMailProtocolService.7(this, localHashMap, (DomainConfig)((Iterator)localObject2).next(), (ConnectSelector)localObject1, paramString, paramMailServiceProvider, localCountDownLatch)).start();
        }
        fillImapProvider(paramMailServiceProvider, paramString, (ArrayList)localObject2);
        fillSmtpProvider(paramMailServiceProvider, paramString, (ArrayList)localObject2);
        fillPopProvider(paramMailServiceProvider, paramString, (ArrayList)localObject2);
      }
      localCountDownLatch.await(5000L, TimeUnit.MILLISECONDS);
      ((ConnectSelector)localObject1).setCompleted();
      l = System.currentTimeMillis() - l;
      OssHelper.autoQueryDomainConfig(new Object[] { paramString, "elapse", Long.valueOf(l) });
      QMLog.log(4, "QMMailProtocolService", "autoFillMailProvider elapse " + l);
      return paramMailServiceProvider;
    }
  }
  
  public void checkMail(Account paramAccount, Map<QMFolder, ArrayList<String>> paramMap, CheckMailCallback paramCheckMailCallback)
  {
    getJavaService().checkMail(paramAccount, paramMap, paramCheckMailCallback);
  }
  
  public void createChannel(String paramString, DomainConfig paramDomainConfig, ConnectSelector paramConnectSelector, MailServiceProvider paramMailServiceProvider, HashMap<String, String> paramHashMap)
    throws IOException
  {
    paramString = (String)paramHashMap.get(paramDomainConfig.server);
    if (paramString == null)
    {
      QMLog.log(6, "QMMailProtocolService", "server " + paramDomainConfig.server + " dns fail");
      return;
    }
    paramHashMap = SocketChannel.open();
    paramHashMap.configureBlocking(false);
    paramHashMap.connect(new InetSocketAddress(paramString, paramDomainConfig.port));
    try
    {
      paramConnectSelector.addKey(paramHashMap.register(paramConnectSelector.selector, 8, new QMMailProtocolService.8(this, paramDomainConfig, paramMailServiceProvider, paramConnectSelector)));
      return;
    }
    catch (Exception paramString)
    {
      QMLog.log(6, "QMMailProtocolService", "create socket error " + paramString.getMessage());
    }
  }
  
  public void downloadAttach(MailInformation paramMailInformation, Attach paramAttach, boolean paramBoolean, @NonNull LoadMailAttachCallBack paramLoadMailAttachCallBack)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramMailInformation.getAccountId());
    if (localAccount == null) {
      return;
    }
    switch (localAccount.getProfile().protocolType)
    {
    case 2: 
    default: 
      return;
    case 0: 
      paramLoadMailAttachCallBack.onError(new QMProtocolError(-1, "Pop3 should not request attach here"));
      return;
    case 1: 
      if (enableImapService())
      {
        getJavaService().downloadAttach(paramMailInformation, paramAttach, paramBoolean, paramLoadMailAttachCallBack);
        return;
      }
      getNativeService().downloadAttach(paramMailInformation, paramAttach, paramBoolean, paramLoadMailAttachCallBack);
      return;
    case 4: 
      if (enableEasService())
      {
        getJavaService().downloadAttach(paramMailInformation, paramAttach, paramBoolean, paramLoadMailAttachCallBack);
        return;
      }
      getNativeService().downloadAttach(paramMailInformation, paramAttach, paramBoolean, paramLoadMailAttachCallBack);
      return;
    }
    if (enableEwsService())
    {
      getJavaService().downloadAttach(paramMailInformation, paramAttach, paramBoolean, paramLoadMailAttachCallBack);
      return;
    }
    getNativeService().downloadAttach(paramMailInformation, paramAttach, paramBoolean, paramLoadMailAttachCallBack);
  }
  
  public void feedbackMail(ComposeMailUI paramComposeMailUI, String paramString1, String paramString2, String paramString3, int paramInt, QMGeneralCallback paramQMGeneralCallback)
  {
    getNativeService().feedbackMail(paramComposeMailUI, paramString1, paramString2, paramString3, paramInt, paramQMGeneralCallback);
  }
  
  public void fetchFolderList(Account paramAccount, FolderListCallback paramFolderListCallback)
  {
    Object localObject = paramAccount.getProfile();
    paramFolderListCallback = new QMMailProtocolService.3(this, (Profile)localObject, paramFolderListCallback, paramAccount);
    switch (((Profile)localObject).protocolType)
    {
    case 0: 
    case 2: 
    default: 
      return;
    case 1: 
      if (enableImapService())
      {
        getJavaService().fetchFolderList(paramAccount, paramFolderListCallback);
        return;
      }
      getNativeService().fetchFolderList(paramAccount, paramFolderListCallback);
      return;
    case 4: 
      int i = paramAccount.getId();
      localObject = QMFolderManager.sharedInstance().getAllFoldersByAccountId(i);
      String str = AccountManager.shareInstance().getAccountList(true).getFolderListSyncKey(i);
      if ((((ArrayList)localObject).size() == 0) && (!StringExtention.isNullOrEmpty(str)) && (!"0".equals(str)))
      {
        setFolderListSyncKey(i, "0");
        AccountManager.shareInstance().updateFolderListSyncKey(i, "0");
      }
      if (enableEasService())
      {
        getJavaService().fetchFolderList(paramAccount, paramFolderListCallback);
        return;
      }
      getNativeService().fetchFolderList(paramAccount, paramFolderListCallback);
      return;
    }
    if (enableEwsService())
    {
      getJavaService().fetchFolderList(paramAccount, paramFolderListCallback);
      return;
    }
    getNativeService().fetchFolderList(paramAccount, paramFolderListCallback);
  }
  
  public void fetchMailList(Account paramAccount, QMFolder paramQMFolder, ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, MailListCallback paramMailListCallback)
  {
    Profile localProfile = paramAccount.getProfile();
    paramMailListCallback = new QMMailProtocolService.4(this, paramMailListCallback, localProfile, paramAccount, paramQMFolder, paramArrayList, paramBoolean1, paramBoolean2);
    switch (localProfile.protocolType)
    {
    case 2: 
    default: 
      return;
    case 0: 
      if (enablePop3Service())
      {
        getJavaService().fetchMailList(paramAccount, paramQMFolder, paramArrayList, paramBoolean1, paramBoolean2, paramMailListCallback);
        return;
      }
      getNativeService().fetchMailList(paramAccount, paramQMFolder, paramArrayList, paramBoolean1, paramMailListCallback);
      return;
    case 1: 
      if (enableImapService())
      {
        getJavaService().fetchMailList(paramAccount, paramQMFolder, paramArrayList, paramBoolean1, paramBoolean2, paramMailListCallback);
        return;
      }
      getNativeService().fetchMailList(paramAccount, paramQMFolder, paramArrayList, paramBoolean1, paramMailListCallback);
      return;
    case 4: 
      if (enableEasService())
      {
        getJavaService().fetchMailList(paramAccount, paramQMFolder, paramArrayList, paramBoolean1, paramBoolean2, paramMailListCallback);
        return;
      }
      getNativeService().fetchMailList(paramAccount, paramQMFolder, paramArrayList, paramBoolean1, paramMailListCallback);
      return;
    }
    if (enableEwsService())
    {
      getJavaService().fetchMailList(paramAccount, paramQMFolder, paramArrayList, paramBoolean1, paramBoolean2, paramMailListCallback);
      return;
    }
    getNativeService().fetchMailList(paramAccount, paramQMFolder, paramArrayList, paramBoolean1, paramMailListCallback);
  }
  
  public void initActiveSync()
  {
    if (enableEasService())
    {
      getJavaService().initActiveSync();
      return;
    }
    getNativeService().initActiveSync();
  }
  
  public void initFolderListSyncKeyMapping(Map<Integer, String> paramMap)
  {
    if (enableEasService())
    {
      getJavaService().initAccountSyncKeyMapping(paramMap);
      return;
    }
    getNativeService().initFolderListSyncKeyMapping(paramMap);
  }
  
  public void initFolderSyncKeyMapping(Map<Integer, String> paramMap)
  {
    if (enableEasService())
    {
      getJavaService().initFolderSyncKeyMapping(paramMap);
      return;
    }
    getNativeService().initFolderSyncKeyMapping(paramMap);
  }
  
  public void initProfile()
  {
    Iterator localIterator = AccountManager.shareInstance().getAccountList().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Account)localIterator.next();
      if (!((Account)localObject).isQQMail())
      {
        localObject = ((Account)localObject).getProfile();
        switch (((Profile)localObject).protocolType)
        {
        case 2: 
        default: 
          break;
        case 0: 
          if (enablePop3Service()) {
            getJavaService().initProfile((Profile)localObject);
          } else {
            getNativeService().initProfile((Profile)localObject);
          }
          break;
        case 1: 
          if (enableImapService()) {
            getJavaService().initProfile((Profile)localObject);
          } else {
            getNativeService().initProfile((Profile)localObject);
          }
          break;
        case 4: 
          if (enableEasService()) {
            getJavaService().initProfile((Profile)localObject);
          } else {
            getNativeService().initProfile((Profile)localObject);
          }
          break;
        case 3: 
          if (enableEwsService()) {
            getJavaService().initProfile((Profile)localObject);
          } else {
            getNativeService().initProfile((Profile)localObject);
          }
          break;
        }
      }
    }
  }
  
  public void loadMail(Account paramAccount, QMFolder paramQMFolder, Mail paramMail, boolean paramBoolean1, boolean paramBoolean2, LoadMailCallback paramLoadMailCallback)
  {
    switch (paramAccount.getProfile().protocolType)
    {
    case 2: 
    default: 
      return;
    case 0: 
      if (enablePop3Service())
      {
        getJavaService().downloadMailText(paramAccount, paramQMFolder, paramMail, paramBoolean1, paramBoolean2, paramLoadMailCallback);
        return;
      }
      getNativeService().downloadMailText(paramAccount, paramQMFolder, paramMail, paramBoolean1, paramBoolean2, paramLoadMailCallback);
      return;
    case 1: 
      if (enableImapService())
      {
        getJavaService().downloadMailText(paramAccount, paramQMFolder, paramMail, paramBoolean1, paramBoolean2, paramLoadMailCallback);
        return;
      }
      getNativeService().downloadMailText(paramAccount, paramQMFolder, paramMail, paramBoolean1, paramBoolean2, paramLoadMailCallback);
      return;
    case 4: 
      if (enableEasService())
      {
        getJavaService().downloadMailText(paramAccount, paramQMFolder, paramMail, paramBoolean1, paramBoolean2, paramLoadMailCallback);
        return;
      }
      getNativeService().downloadMailText(paramAccount, paramQMFolder, paramMail, paramBoolean1, paramBoolean2, paramLoadMailCallback);
      return;
    }
    if (enableEwsService())
    {
      getJavaService().downloadMailText(paramAccount, paramQMFolder, paramMail, paramBoolean1, paramBoolean2, paramLoadMailCallback);
      return;
    }
    getNativeService().downloadMailText(paramAccount, paramQMFolder, paramMail, paramBoolean1, paramBoolean2, paramLoadMailCallback);
  }
  
  public void loadMailAbstract(Account paramAccount, QMFolder paramQMFolder, ArrayList<Mail> paramArrayList, LoadMailAbstractCallback paramLoadMailAbstractCallback)
  {
    switch (paramAccount.getProfile().protocolType)
    {
    case 2: 
    default: 
      return;
    case 0: 
      if (enablePop3Service())
      {
        getJavaService().downloadMailAbstract(paramAccount, paramQMFolder, paramArrayList, paramLoadMailAbstractCallback);
        return;
      }
      getNativeService().downloadMailAbstract(paramAccount, paramQMFolder, paramArrayList, paramLoadMailAbstractCallback);
      return;
    case 1: 
      if (enableImapService())
      {
        getJavaService().downloadMailAbstract(paramAccount, paramQMFolder, paramArrayList, paramLoadMailAbstractCallback);
        return;
      }
      getNativeService().downloadMailAbstract(paramAccount, paramQMFolder, paramArrayList, paramLoadMailAbstractCallback);
      return;
    case 4: 
      if (enableEasService())
      {
        getJavaService().downloadMailAbstract(paramAccount, paramQMFolder, paramArrayList, paramLoadMailAbstractCallback);
        return;
      }
      getNativeService().downloadMailAbstract(paramAccount, paramQMFolder, paramArrayList, paramLoadMailAbstractCallback);
      return;
    }
    if (enableEwsService())
    {
      getJavaService().downloadMailAbstract(paramAccount, paramQMFolder, paramArrayList, paramLoadMailAbstractCallback);
      return;
    }
    getNativeService().downloadMailAbstract(paramAccount, paramQMFolder, paramArrayList, paramLoadMailAbstractCallback);
  }
  
  public void loadMailFromEML(int paramInt, long paramLong, String paramString1, String paramString2, LoadEmlCallback paramLoadEmlCallback)
  {
    getJavaService().loadMailFromEml(paramInt, paramLong, paramString1, paramString2, paramLoadEmlCallback);
  }
  
  public void loadTranslateMail(Mail paramMail, MailManagerDelegate paramMailManagerDelegate)
  {
    getNativeService().loadTranslateMail(paramMail, paramMailManagerDelegate);
  }
  
  public void login(Profile paramProfile, LoginCallback paramLoginCallback, boolean paramBoolean)
  {
    paramLoginCallback = new QMMailProtocolService.1(this, paramProfile, paramLoginCallback, paramBoolean);
    switch (paramProfile.protocolType)
    {
    case 2: 
    default: 
      return;
    case 0: 
      if (enablePop3Service())
      {
        getJavaService().login(paramProfile, paramLoginCallback, paramBoolean);
        return;
      }
      getNativeService().login(paramProfile, paramLoginCallback);
      return;
    case 1: 
      if (enableImapService())
      {
        getJavaService().login(paramProfile, paramLoginCallback, paramBoolean);
        return;
      }
      getNativeService().login(paramProfile, paramLoginCallback);
      return;
    case 4: 
      if (enableEasService())
      {
        getJavaService().login(paramProfile, paramLoginCallback, paramBoolean);
        return;
      }
      getNativeService().login(paramProfile, paramLoginCallback);
      return;
    }
    if (enableEwsService())
    {
      getJavaService().login(paramProfile, paramLoginCallback, paramBoolean);
      return;
    }
    getNativeService().login(paramProfile, paramLoginCallback);
  }
  
  public void logout(Profile paramProfile, LogoutCallback paramLogoutCallback)
  {
    switch (paramProfile.protocolType)
    {
    case 2: 
    default: 
      return;
    case 0: 
      if (enablePop3Service())
      {
        getJavaService().logout(paramProfile, paramLogoutCallback);
        return;
      }
      getNativeService().logout(paramProfile, paramLogoutCallback);
      return;
    case 1: 
      if (enableImapService())
      {
        getJavaService().logout(paramProfile, paramLogoutCallback);
        return;
      }
      getNativeService().logout(paramProfile, paramLogoutCallback);
      return;
    case 4: 
      if (enableEasService())
      {
        getJavaService().logout(paramProfile, paramLogoutCallback);
        return;
      }
      getNativeService().logout(paramProfile, paramLogoutCallback);
      return;
    }
    if (enableEwsService())
    {
      getJavaService().logout(paramProfile, paramLogoutCallback);
      return;
    }
    getNativeService().logout(paramProfile, paramLogoutCallback);
  }
  
  public void moveMails(Account paramAccount, QMFolder paramQMFolder1, QMFolder paramQMFolder2, List<String> paramList1, List<String> paramList2, MailManagerDelegate paramMailManagerDelegate)
  {
    switch (paramAccount.getProfile().protocolType)
    {
    case 0: 
    case 2: 
    default: 
      return;
    case 1: 
      if (enableImapService())
      {
        getJavaService().moveMails(paramAccount, paramQMFolder1, paramQMFolder2, paramList1, paramList2, paramMailManagerDelegate);
        return;
      }
      getNativeService().moveMails(paramAccount, paramQMFolder1, paramQMFolder2, paramList1, paramList2, paramMailManagerDelegate);
      return;
    case 4: 
      if (enableEasService())
      {
        getJavaService().moveMails(paramAccount, paramQMFolder1, paramQMFolder2, paramList1, paramList2, paramMailManagerDelegate);
        return;
      }
      getNativeService().moveMails(paramAccount, paramQMFolder1, paramQMFolder2, paramList1, paramList2, paramMailManagerDelegate);
      return;
    }
    if (enableEwsService())
    {
      getJavaService().moveMails(paramAccount, paramQMFolder1, paramQMFolder2, paramList1, paramList2, paramMailManagerDelegate);
      return;
    }
    getNativeService().moveMails(paramAccount, paramQMFolder1, paramQMFolder2, paramList1, paramList2, paramMailManagerDelegate);
  }
  
  public void notifyIdle()
  {
    getJavaService().notifyIdle();
  }
  
  public void removeFolder(Account paramAccount, QMFolder paramQMFolder, FolderOperationCallback paramFolderOperationCallback)
  {
    switch (paramAccount.getProfile().protocolType)
    {
    case 0: 
    case 2: 
    default: 
      return;
    case 1: 
      if (enableImapService())
      {
        getJavaService().removeFolder(paramAccount, paramQMFolder, paramFolderOperationCallback);
        return;
      }
      getNativeService().removeFolder(paramAccount, paramQMFolder, paramFolderOperationCallback);
      return;
    case 4: 
      if (enableEasService())
      {
        getJavaService().removeFolder(paramAccount, paramQMFolder, paramFolderOperationCallback);
        return;
      }
      getNativeService().removeFolder(paramAccount, paramQMFolder, paramFolderOperationCallback);
      return;
    }
    if (enableEwsService())
    {
      getJavaService().removeFolder(paramAccount, paramQMFolder, paramFolderOperationCallback);
      return;
    }
    getNativeService().removeFolder(paramAccount, paramQMFolder, paramFolderOperationCallback);
  }
  
  public void removeFolderListSyncKey(int paramInt)
  {
    if (enableEasService())
    {
      getJavaService().removeAccountSyncKey(paramInt);
      return;
    }
    getNativeService().removeFolderListSyncKey(paramInt);
  }
  
  public void removeFolderSyncKey(int[] paramArrayOfInt)
  {
    if (enableEasService())
    {
      getJavaService().removeFolderSyncKey(paramArrayOfInt);
      return;
    }
    getNativeService().removeFolderSyncKey(paramArrayOfInt);
  }
  
  public void removeMails(Account paramAccount, QMFolder paramQMFolder, List<String> paramList1, List<String> paramList2, MailManagerDelegate paramMailManagerDelegate)
  {
    switch (paramAccount.getProfile().protocolType)
    {
    case 0: 
    case 2: 
    default: 
      return;
    case 1: 
      if (enableImapService())
      {
        getJavaService().removeMails(paramAccount, paramQMFolder, paramList1, paramList2, paramMailManagerDelegate);
        return;
      }
      getNativeService().removeMails(paramAccount, paramQMFolder, paramList1, paramList2, paramMailManagerDelegate);
      return;
    case 4: 
      if (enableEasService())
      {
        getJavaService().removeMails(paramAccount, paramQMFolder, paramList1, paramList2, paramMailManagerDelegate);
        return;
      }
      getNativeService().removeMails(paramAccount, paramQMFolder, paramList1, paramList2, paramMailManagerDelegate);
      return;
    }
    if (enableEwsService())
    {
      getJavaService().removeMails(paramAccount, paramQMFolder, paramList1, paramList2, paramMailManagerDelegate);
      return;
    }
    getNativeService().removeMails(paramAccount, paramQMFolder, paramList1, paramList2, paramMailManagerDelegate);
  }
  
  public void renameFolder(Account paramAccount, QMFolder paramQMFolder, String paramString, FolderOperationCallback paramFolderOperationCallback)
  {
    switch (paramAccount.getProfile().protocolType)
    {
    case 0: 
    case 2: 
    default: 
      return;
    case 1: 
      if (enableImapService())
      {
        getJavaService().renameFolder(paramAccount, paramQMFolder, paramString, paramFolderOperationCallback);
        return;
      }
      getNativeService().renameFolder(paramAccount, paramQMFolder, paramString, paramFolderOperationCallback);
      return;
    case 4: 
      if (enableEasService())
      {
        getJavaService().renameFolder(paramAccount, paramQMFolder, paramString, paramFolderOperationCallback);
        return;
      }
      getNativeService().renameFolder(paramAccount, paramQMFolder, paramString, paramFolderOperationCallback);
      return;
    }
    if (enableEwsService())
    {
      getJavaService().renameFolder(paramAccount, paramQMFolder, paramString, paramFolderOperationCallback);
      return;
    }
    getNativeService().renameFolder(paramAccount, paramQMFolder, paramString, paramFolderOperationCallback);
  }
  
  public void searchExchangeGlobalAddressList(Account paramAccount, String paramString, SearchAddressCallback paramSearchAddressCallback)
  {
    getNativeService().searchExchangeGlobalAddressList(paramAccount, paramString, paramSearchAddressCallback);
  }
  
  @Nullable
  public QMProtocolRequest searchMails(QMSearchCursor paramQMSearchCursor, SearchInfo paramSearchInfo, SearchMailCallback paramSearchMailCallback)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramSearchInfo.getAccountId());
    if (localAccount == null) {
      return null;
    }
    switch (localAccount.getProfile().protocolType)
    {
    case 0: 
    case 2: 
    default: 
      return null;
    case 1: 
      if (enableImapService()) {
        return getJavaService().searchMail(paramQMSearchCursor, paramSearchInfo, paramSearchMailCallback);
      }
      return getNativeService().searchMails(paramQMSearchCursor, paramSearchInfo, paramSearchMailCallback);
    case 4: 
      return getNativeService().searchMails(paramQMSearchCursor, paramSearchInfo, paramSearchMailCallback);
    }
    if (enableEwsService()) {
      return getJavaService().searchMail(paramQMSearchCursor, paramSearchInfo, paramSearchMailCallback);
    }
    return getNativeService().searchMails(paramQMSearchCursor, paramSearchInfo, paramSearchMailCallback);
  }
  
  public QMProtocolRequest sendMail(Account paramAccount, ComposeMailUI paramComposeMailUI, MailManagerDelegate paramMailManagerDelegate)
  {
    Profile localProfile = paramAccount.getProfile();
    MailManagerDelegate localMailManagerDelegate = new MailManagerDelegate(paramMailManagerDelegate);
    localMailManagerDelegate.setOnSuccess(new QMMailProtocolService.5(this, localProfile, paramMailManagerDelegate));
    localMailManagerDelegate.setOnError(new QMMailProtocolService.6(this, localProfile, paramAccount, paramComposeMailUI, paramMailManagerDelegate));
    switch (localProfile.protocolType)
    {
    case 2: 
    default: 
      return null;
    case 0: 
    case 1: 
      if (enableSmtpService()) {
        return getJavaService().sendMail(paramAccount, paramComposeMailUI, localMailManagerDelegate);
      }
      return getNativeService().sendMail(paramAccount, paramComposeMailUI, localMailManagerDelegate);
    case 4: 
      if (enableEasService()) {
        return getJavaService().sendMail(paramAccount, paramComposeMailUI, localMailManagerDelegate);
      }
      return getNativeService().sendMail(paramAccount, paramComposeMailUI, localMailManagerDelegate);
    }
    if (enableEwsService()) {
      return getJavaService().sendMail(paramAccount, paramComposeMailUI, localMailManagerDelegate);
    }
    return getNativeService().sendMail(paramAccount, paramComposeMailUI, localMailManagerDelegate);
  }
  
  public void setFolderListSyncKey(int paramInt, String paramString)
  {
    if (enableEasService())
    {
      getJavaService().setAccountSyncKey(paramInt, paramString);
      return;
    }
    getNativeService().setFolderListSyncKey(paramInt, paramString);
  }
  
  public void setFolderSyncKey(int paramInt, String paramString)
  {
    if (enableEasService())
    {
      getJavaService().setFolderSyncKey(paramInt, paramString);
      return;
    }
    getNativeService().setFolderSyncKey(paramInt, paramString);
  }
  
  public void starMails(Account paramAccount, QMFolder paramQMFolder, boolean paramBoolean, List<String> paramList1, List<String> paramList2, MailManagerDelegate paramMailManagerDelegate)
  {
    switch (paramAccount.getProfile().protocolType)
    {
    case 0: 
    case 2: 
    default: 
      return;
    case 1: 
      if (enableImapService())
      {
        getJavaService().starMails(paramAccount, paramQMFolder, paramBoolean, paramList1, paramList2, paramMailManagerDelegate);
        return;
      }
      getNativeService().starMails(paramAccount, paramQMFolder, paramBoolean, paramList1, paramList2, paramMailManagerDelegate);
      return;
    case 4: 
      if (enableEasService())
      {
        getJavaService().starMails(paramAccount, paramQMFolder, paramBoolean, paramList1, paramList2, paramMailManagerDelegate);
        return;
      }
      getNativeService().starMails(paramAccount, paramQMFolder, paramBoolean, paramList1, paramList2, paramMailManagerDelegate);
      return;
    }
    if (enableEwsService())
    {
      getJavaService().starMails(paramAccount, paramQMFolder, paramBoolean, paramList1, paramList2, paramMailManagerDelegate);
      return;
    }
    getNativeService().starMails(paramAccount, paramQMFolder, paramBoolean, paramList1, paramList2, paramMailManagerDelegate);
  }
  
  public void startIdle(Account paramAccount, QMFolder paramQMFolder, IdleCallback paramIdleCallback)
  {
    if (isEnableImapIdle) {
      getJavaService().startIdle(paramAccount, paramQMFolder, paramIdleCallback);
    }
  }
  
  public void stopIdle(Account paramAccount)
  {
    getJavaService().stopIdle(paramAccount);
  }
  
  public void syncFolderStatus(Account paramAccount, QMFolder paramQMFolder, IListStatusCallback paramIListStatusCallback)
  {
    Profile localProfile = paramAccount.getProfile();
    paramIListStatusCallback = new QMMailProtocolService.2(this, paramIListStatusCallback, localProfile, paramAccount, paramQMFolder);
    switch (localProfile.protocolType)
    {
    case 0: 
    case 2: 
    default: 
      return;
    case 1: 
      if (enableImapService())
      {
        getJavaService().syncImapFolderStatus(paramAccount, paramQMFolder, paramIListStatusCallback);
        return;
      }
      getNativeService().syncImapFolderStatus(paramAccount, paramQMFolder, paramIListStatusCallback);
      return;
    case 4: 
      if (enableEasService())
      {
        getJavaService().syncActiveSyncFolderStatus(paramAccount, paramQMFolder, paramIListStatusCallback);
        return;
      }
      getNativeService().syncActiveSyncFolderStatus(paramAccount, paramQMFolder, paramIListStatusCallback);
      return;
    }
    if (enableEwsService())
    {
      getJavaService().syncExchangeFolderStatus(paramAccount, paramQMFolder, paramIListStatusCallback);
      return;
    }
    getNativeService().syncExchangeFolderStatus(paramAccount, paramQMFolder, paramIListStatusCallback);
  }
  
  public void unreadMails(Account paramAccount, QMFolder paramQMFolder, boolean paramBoolean, List<String> paramList1, List<String> paramList2, MailManagerDelegate paramMailManagerDelegate)
  {
    switch (paramAccount.getProfile().protocolType)
    {
    case 0: 
    case 2: 
    default: 
      return;
    case 1: 
      if (enableImapService())
      {
        getJavaService().unreadMails(paramAccount, paramQMFolder, paramBoolean, paramList1, paramList2, paramMailManagerDelegate);
        return;
      }
      getNativeService().unreadMails(paramAccount, paramQMFolder, paramBoolean, paramList1, paramList2, paramMailManagerDelegate);
      return;
    case 4: 
      if (enableEasService())
      {
        getJavaService().unreadMails(paramAccount, paramQMFolder, paramBoolean, paramList1, paramList2, paramMailManagerDelegate);
        return;
      }
      getNativeService().unreadMails(paramAccount, paramQMFolder, paramBoolean, paramList1, paramList2, paramMailManagerDelegate);
      return;
    }
    if (enableEwsService())
    {
      getJavaService().unreadMails(paramAccount, paramQMFolder, paramBoolean, paramList1, paramList2, paramMailManagerDelegate);
      return;
    }
    getNativeService().unreadMails(paramAccount, paramQMFolder, paramBoolean, paramList1, paramList2, paramMailManagerDelegate);
  }
  
  static class DomainConfig
  {
    public boolean isUsingSSL;
    public int port;
    public String protocol;
    public String server;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolService
 * JD-Core Version:    0.7.0.1
 */