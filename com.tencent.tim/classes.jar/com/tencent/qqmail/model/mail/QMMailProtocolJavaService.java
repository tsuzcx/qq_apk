package com.tencent.qqmail.model.mail;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.moai.mailsdk.MailManager;
import com.tencent.moai.mailsdk.MailParser;
import com.tencent.moai.mailsdk.callback.IdleCallback;
import com.tencent.moai.mailsdk.model.Attachment;
import com.tencent.moai.mailsdk.model.Calendar;
import com.tencent.moai.mailsdk.model.Contact;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.model.Recurrence;
import com.tencent.moai.mailsdk.model.State;
import com.tencent.moai.mailsdk.net.MailSSLUtil;
import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeRule;
import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeRule.Actions;
import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeRule.Conditions;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPBodyStructure;
import com.tencent.moai.mailsdk.protocol.mime.model.MimeMessage;
import com.tencent.moai.mailsdk.util.FileUtility;
import com.tencent.moai.mailsdk.util.SPUtility;
import com.tencent.moai.mailsdk.util.StringUtility;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachProtocol;
import com.tencent.qqmail.attachment.model.AttachProtocol.MailItemBodyInfo;
import com.tencent.qqmail.attachment.model.AttachState;
import com.tencent.qqmail.calendar.model.CCalendar;
import com.tencent.qqmail.calendar.model.CRecurrence;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.marcos.AppConfig;
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
import com.tencent.qqmail.model.mail.callback.SearchMailCallback;
import com.tencent.qqmail.model.mail.cursor.QMSearchCursor;
import com.tencent.qqmail.model.protocol.QMSyncManager;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.model.qmdomain.ContactEmail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.qmdomain.SearchInfo;
import com.tencent.qqmail.model.sendmail.SendMailHelper;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.protocol.Exchange.ExchangeRule;
import com.tencent.qqmail.protocol.Exchange.ExchangeRule.Actions;
import com.tencent.qqmail.protocol.Exchange.ExchangeRule.Conditions;
import com.tencent.qqmail.protocol.ItemBodyStructureHelper.MailItemBodyStructureInfo;
import com.tencent.qqmail.protocol.MailUtil;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.service.QMAckIntervalDetector;
import com.tencent.qqmail.utilities.qmnetwork.ssl.SSLStrategyFactory;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import moai.oss.OssHelper;

public class QMMailProtocolJavaService
{
  private static final String TAG = "QMMailProtocolJavaService";
  
  private String getDomain(String paramString)
  {
    if (!StringExtention.isNullOrEmpty(paramString))
    {
      int i = paramString.indexOf("@");
      if (i != -1) {
        return paramString.substring(i + 1, paramString.length());
      }
    }
    return "";
  }
  
  private int getFolderType(Folder paramFolder)
  {
    switch (paramFolder.getType())
    {
    case 6: 
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 4;
    case 4: 
      return 3;
    case 3: 
      return 5;
    case 5: 
      return 6;
    case 7: 
      return 9;
    case 10: 
      return 150;
    case 9: 
      return 151;
    }
    return 152;
  }
  
  private int getProtocolFolderType(QMFolder paramQMFolder)
  {
    switch (paramQMFolder.getType())
    {
    case 0: 
    default: 
      return 6;
    case 1: 
      return 1;
    case 4: 
      return 2;
    case 3: 
      return 4;
    case 5: 
      return 3;
    case 6: 
      return 5;
    case 9: 
      return 7;
    case 150: 
      return 10;
    case 151: 
      return 9;
    }
    return 8;
  }
  
  private static String parseAbstract(com.tencent.moai.mailsdk.model.Mail paramMail)
  {
    String str2 = "";
    String str1;
    if ((paramMail.getHtmlContent() != null) && (!paramMail.getHtmlContent().equals(""))) {
      str1 = paramMail.getHtmlContent();
    }
    for (;;)
    {
      paramMail = MailUtil.getMailAbstract(QMMailParser.removeMailEditAttachArea(QMMailParser.removeFoxmailContentAttachArea(QMMailParser.removeNtesContentAttachArea(str1))));
      return paramMail.substring(0, Math.min(200, paramMail.length()));
      str1 = str2;
      if (paramMail.getPlainContent() != null)
      {
        str1 = str2;
        if (!paramMail.getPlainContent().equals("")) {
          str1 = paramMail.getPlainContent();
        }
      }
    }
  }
  
  private com.tencent.qqmail.model.qmdomain.Mail parseAbstractMail(int paramInt1, int paramInt2, com.tencent.moai.mailsdk.model.Mail paramMail, int paramInt3)
  {
    paramMail.setId(com.tencent.qqmail.model.qmdomain.Mail.generateId(paramInt1, paramInt2, paramMail.getRemoteId()));
    return processMail(paramInt1, paramInt2, paramMail, paramInt3, true);
  }
  
  private ArrayList<Object> parseAttachList(com.tencent.moai.mailsdk.model.Mail paramMail, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramMail.getAttachments() != null) && (paramMail.getAttachments().size() > 0))
    {
      int i = 0;
      while (i < paramMail.getAttachments().size())
      {
        long l = QMMath.hashLong(paramMail.getId() + "^" + i);
        Attachment localAttachment = (Attachment)paramMail.getAttachments().get(i);
        Attach localAttach = new Attach(true);
        localAttach.setIsProtocol(true);
        localAttach.setName(localAttachment.getName());
        localAttach.setDisplayName(localAttachment.getName());
        localAttach.setBytes(localAttachment.getSize());
        localAttach.setSize(StringExtention.getHumanReadable(localAttachment.getSize()));
        localAttach.getPreview().setMyDisk(localAttachment.getPath());
        localAttach.getProtocol().setMailId(paramMail.getId());
        localAttach.getProtocol().setAttachId(l);
        localAttach.getProtocol().setIsexist(1);
        localAttach.getProtocol().setProtocolType(paramInt);
        localAttach.getProtocol().setType(localAttachment.getType());
        localAttach.getProtocol().setData(null);
        localAttach.getProtocol().setCid(localAttachment.getCid());
        localAttach.getProtocol().setExchangeFileUid(localAttachment.getFid());
        localAttach.getProtocol().setFileContentType(null);
        localAttach.getState().setIsFavLocal(true);
        localAttach.getState().setDownloadSizeByte(0L);
        if (paramInt == 1) {
          localAttach.getProtocol().setBodyInfo(parseBodyInfo(l, paramMail.getId(), localAttachment.getImapBodyStructure()));
        }
        localAttach.setOrderIndex(i);
        localArrayList.add(localAttach);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private AttachProtocol.MailItemBodyInfo parseBodyInfo(long paramLong1, long paramLong2, IMAPBodyStructure paramIMAPBodyStructure)
  {
    AttachProtocol.MailItemBodyInfo localMailItemBodyInfo = new AttachProtocol.MailItemBodyInfo();
    if (paramIMAPBodyStructure == null) {
      return localMailItemBodyInfo;
    }
    localMailItemBodyInfo.id = QMMath.hashLong(paramLong2 + "^" + paramIMAPBodyStructure.getBodyId());
    localMailItemBodyInfo.mailId = paramLong2;
    localMailItemBodyInfo.attachId = paramLong1;
    localMailItemBodyInfo.itemId = 0L;
    localMailItemBodyInfo.itemType = "item_type_attachment";
    localMailItemBodyInfo.bodyId = paramIMAPBodyStructure.getBodyId();
    localMailItemBodyInfo.contentType = StringUtility.addQuote(paramIMAPBodyStructure.getContentType().toUpperCase(Locale.ENGLISH));
    localMailItemBodyInfo.contentSubType = StringUtility.addQuote(paramIMAPBodyStructure.getContentSubtype().toUpperCase(Locale.ENGLISH));
    localMailItemBodyInfo.contentTypeParams = paramIMAPBodyStructure.getContentParam();
    localMailItemBodyInfo.contentDescription = paramIMAPBodyStructure.getDescription();
    localMailItemBodyInfo.transferEncoding = StringUtility.addQuote(paramIMAPBodyStructure.getEncoding());
    localMailItemBodyInfo.contentLineSize = (paramIMAPBodyStructure.getLines() + "");
    localMailItemBodyInfo.contentDisposition = (paramIMAPBodyStructure.getDisposition() + " (" + paramIMAPBodyStructure.getDispositionParam() + ")");
    return localMailItemBodyInfo;
  }
  
  private ItemBodyStructureHelper.MailItemBodyStructureInfo[] parseBodyInfoList(long paramLong, ArrayList<IMAPBodyStructure> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return (ItemBodyStructureHelper.MailItemBodyStructureInfo[])localArrayList.toArray(new ItemBodyStructureHelper.MailItemBodyStructureInfo[localArrayList.size()]);
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      IMAPBodyStructure localIMAPBodyStructure = (IMAPBodyStructure)paramArrayList.next();
      ItemBodyStructureHelper.MailItemBodyStructureInfo localMailItemBodyStructureInfo = new ItemBodyStructureHelper.MailItemBodyStructureInfo();
      localMailItemBodyStructureInfo.id_ = QMMath.hashLong(paramLong + "^" + localIMAPBodyStructure.getBodyId());
      localMailItemBodyStructureInfo.mailId_ = paramLong;
      localMailItemBodyStructureInfo.itemid_ = 0L;
      localMailItemBodyStructureInfo.item_type_ = "item_type_mail";
      localMailItemBodyStructureInfo.body_id_ = localIMAPBodyStructure.getBodyId();
      localMailItemBodyStructureInfo.content_type_ = StringUtility.addQuote(localIMAPBodyStructure.getContentType().toUpperCase(Locale.ENGLISH));
      localMailItemBodyStructureInfo.content_subtype_ = StringUtility.addQuote(localIMAPBodyStructure.getContentSubtype().toUpperCase(Locale.ENGLISH));
      localMailItemBodyStructureInfo.content_type_params_ = localIMAPBodyStructure.getContentParam();
      localMailItemBodyStructureInfo.content_description_ = localIMAPBodyStructure.getDescription();
      localMailItemBodyStructureInfo.content_transfer_encoding_ = StringUtility.addQuote(localIMAPBodyStructure.getEncoding());
      localMailItemBodyStructureInfo.content_line_size_ = (localIMAPBodyStructure.getLines() + "");
      localMailItemBodyStructureInfo.content_disposition_ = (localIMAPBodyStructure.getDisposition() + " (" + localIMAPBodyStructure.getDispositionParam() + ")");
      localArrayList.add(localMailItemBodyStructureInfo);
    }
    return (ItemBodyStructureHelper.MailItemBodyStructureInfo[])localArrayList.toArray(new ItemBodyStructureHelper.MailItemBodyStructureInfo[localArrayList.size()]);
  }
  
  private IMAPBodyStructure parseBodyStructure(AttachProtocol.MailItemBodyInfo paramMailItemBodyInfo)
  {
    IMAPBodyStructure localIMAPBodyStructure = new IMAPBodyStructure();
    localIMAPBodyStructure.setBodyId(paramMailItemBodyInfo.bodyId);
    localIMAPBodyStructure.setContentType(StringUtility.removeQuote(paramMailItemBodyInfo.contentType));
    localIMAPBodyStructure.setContentSubtype(StringUtility.removeQuote(paramMailItemBodyInfo.contentSubType));
    localIMAPBodyStructure.setContentParam(paramMailItemBodyInfo.contentTypeParams);
    localIMAPBodyStructure.setDescription(paramMailItemBodyInfo.contentDescription);
    localIMAPBodyStructure.setEncoding(StringUtility.removeQuote(paramMailItemBodyInfo.transferEncoding));
    if (StringUtility.isNullOrEmpty(paramMailItemBodyInfo.contentLineSize)) {}
    for (int i = 0;; i = Integer.valueOf(paramMailItemBodyInfo.contentLineSize).intValue())
    {
      localIMAPBodyStructure.setLines(i);
      localIMAPBodyStructure.setDisposition(paramMailItemBodyInfo.contentDisposition);
      return localIMAPBodyStructure;
    }
  }
  
  private ArrayList<IMAPBodyStructure> parseBodyStructureList(ArrayList<ItemBodyStructureHelper.MailItemBodyStructureInfo> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return localArrayList;
    }
    paramArrayList = paramArrayList.iterator();
    if (paramArrayList.hasNext())
    {
      ItemBodyStructureHelper.MailItemBodyStructureInfo localMailItemBodyStructureInfo = (ItemBodyStructureHelper.MailItemBodyStructureInfo)paramArrayList.next();
      IMAPBodyStructure localIMAPBodyStructure = new IMAPBodyStructure();
      localIMAPBodyStructure.setBodyId(localMailItemBodyStructureInfo.body_id_);
      localIMAPBodyStructure.setContentType(StringUtility.removeQuote(localMailItemBodyStructureInfo.content_type_));
      localIMAPBodyStructure.setContentSubtype(StringUtility.removeQuote(localMailItemBodyStructureInfo.content_subtype_));
      localIMAPBodyStructure.setContentParam(localMailItemBodyStructureInfo.content_type_params_);
      localIMAPBodyStructure.setDescription(localMailItemBodyStructureInfo.content_description_);
      localIMAPBodyStructure.setEncoding(StringUtility.removeQuote(localMailItemBodyStructureInfo.content_transfer_encoding_));
      if (StringUtility.isNullOrEmpty(localMailItemBodyStructureInfo.content_line_size_)) {}
      for (int i = 0;; i = Integer.valueOf(localMailItemBodyStructureInfo.content_line_size_).intValue())
      {
        localIMAPBodyStructure.setLines(i);
        localIMAPBodyStructure.setDisposition(localMailItemBodyStructureInfo.content_disposition_);
        localArrayList.add(localIMAPBodyStructure);
        break;
      }
    }
    return localArrayList;
  }
  
  private CCalendar parseCalendar(Calendar paramCalendar)
  {
    CCalendar localCCalendar = new CCalendar();
    if (paramCalendar.getSubject() != null)
    {
      str = paramCalendar.getSubject();
      localCCalendar.subject = str;
      localCCalendar.allday_event = paramCalendar.isAllDayEvent();
      if (paramCalendar.getSubscribe() == null) {
        break label175;
      }
    }
    label175:
    for (String str = paramCalendar.getSubscribe();; str = "")
    {
      localCCalendar.body = str;
      localCCalendar.sensitivity = paramCalendar.getSensitivity();
      localCCalendar.response_requested = paramCalendar.isResponseRequested();
      localCCalendar.busy_status = paramCalendar.getBusyStatus();
      localCCalendar.calendar_type = paramCalendar.getCalendarType();
      localCCalendar.time_zone_ = paramCalendar.getTimeZone();
      localCCalendar.location = paramCalendar.getLocation();
      localCCalendar.start_time = paramCalendar.getStartTime();
      localCCalendar.dt_stamp = paramCalendar.getDtStamp();
      localCCalendar.end_time = paramCalendar.getEndTime();
      localCCalendar.organizer_email = paramCalendar.getOrganizer();
      localCCalendar.organizer_name = paramCalendar.getOrganizer();
      localCCalendar.reminder = paramCalendar.getReminder();
      localCCalendar.uid = paramCalendar.getUid();
      localCCalendar.recurrence = parseRecurrence(paramCalendar.getRecurrence());
      return localCCalendar;
      str = "";
      break;
    }
  }
  
  private static ArrayList<Object> parseContact(ArrayList<Contact> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return localArrayList;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Contact localContact = (Contact)paramArrayList.next();
      MailContact localMailContact = new MailContact();
      localMailContact.setName(localContact.getNick());
      localMailContact.setNick(localContact.getNick());
      localMailContact.setAddress(localContact.getEmail());
      localMailContact.setEmails(Lists.newArrayList(new ContactEmail[] { new ContactEmail(localMailContact.getAddress(), 0, 0) }));
      localArrayList.add(localMailContact);
    }
    return localArrayList;
  }
  
  private com.tencent.qqmail.model.qmdomain.Mail parseEmlMail(int paramInt, String paramString, long paramLong, com.tencent.moai.mailsdk.model.Mail paramMail)
  {
    paramMail.setId(com.tencent.qqmail.model.qmdomain.Mail.generateId(paramInt, paramLong, paramString));
    return processMail(paramInt, -1, paramMail, 7, false);
  }
  
  private Folder parseFolder(QMFolder paramQMFolder)
  {
    Folder localFolder = new Folder();
    localFolder.setFolderId(paramQMFolder.getId());
    localFolder.setRemoteId(paramQMFolder.getRemoteId());
    localFolder.setPath(paramQMFolder.getRemoteId());
    localFolder.setName(paramQMFolder.getName());
    localFolder.setType(getProtocolFolderType(paramQMFolder));
    localFolder.setSyncState(QMFolderManager.sharedInstance().getFolderSyncState(paramQMFolder.getId()));
    localFolder.setSvrKey(QMFolderManager.sharedInstance().getFolderSyncKey(paramQMFolder.getId()));
    localFolder.setTotalCount(paramQMFolder.getSvrCount());
    return localFolder;
  }
  
  private com.tencent.moai.mailsdk.model.Profile parseProfile(com.tencent.qqmail.protocol.Profile paramProfile)
  {
    com.tencent.moai.mailsdk.model.Profile localProfile = new com.tencent.moai.mailsdk.model.Profile();
    switch (paramProfile.protocolType)
    {
    case 2: 
    default: 
      localProfile.setMailAddress(paramProfile.mailAddress);
      localProfile.setProxyServer(paramProfile.proxyServer);
      localProfile.setProxyPort(paramProfile.proxyPort);
      localProfile.setProxyUserName(paramProfile.proxyUsername);
      localProfile.setProxyPassword(paramProfile.proxyPassword);
      localProfile.setSmtpName(paramProfile.smtpName);
      localProfile.setSmtpPassword(paramProfile.smtpPassword);
      localProfile.setSmtpServer(paramProfile.smtpServer);
      localProfile.setSmtpPort(paramProfile.smtpPort);
      localProfile.setSmtpSSLPort(paramProfile.smtpSSLPort);
      localProfile.setSmtpUsingSSL(paramProfile.smtpUsingSSL);
      localProfile.setImapName(paramProfile.imapName);
      localProfile.setImapPassword(paramProfile.imapPassword);
      localProfile.setImapServer(paramProfile.imapServer);
      localProfile.setImapPort(paramProfile.imapPort);
      localProfile.setImapSSLPort(paramProfile.imapSSLPort);
      localProfile.setImapUsingSSL(paramProfile.imapUsingSSL);
      localProfile.setImapUserAgent(paramProfile.imapUserAgentId);
      localProfile.setPopName(paramProfile.pop3Name);
      localProfile.setPopPassword(paramProfile.pop3Password);
      localProfile.setPopServer(paramProfile.pop3Server);
      localProfile.setPopPort(paramProfile.pop3Port);
      localProfile.setPopSSLPort(paramProfile.pop3SSLPort);
      localProfile.setPopUsingSSL(paramProfile.pop3UsingSSL);
      localProfile.setActiveSyncName(paramProfile.activeSyncName);
      localProfile.setActiveSyncPassword(paramProfile.activeSyncPassword);
      localProfile.setActiveSyncServer(paramProfile.activeSyncServer);
      localProfile.setActiveSyncUsingSSL(paramProfile.activeSyncUsingSSL);
      localProfile.setActiveSyncDomain(paramProfile.activeSyncDomain);
      localProfile.setActiveSyncVersion(paramProfile.activeSyncVersion);
      localProfile.setActiveSyncPolicyKey(paramProfile.activeSyncPolicyKey);
      localProfile.setDeviceId(paramProfile.deviceId);
      localProfile.setDeviceType(paramProfile.deviceType);
      localProfile.setOauth(paramProfile.isOauth);
      localProfile.setAccessToken(paramProfile.accessToken);
      localProfile.setRefreshToken(paramProfile.refreshToken);
      localProfile.setTokenType(paramProfile.tokenType);
      localProfile.setIdToken(paramProfile.idToken);
      localProfile.setExpiresIn(paramProfile.expiresIn);
      localProfile.setExchangeName(paramProfile.exchangeName);
      localProfile.setExchangePassword(paramProfile.exchangePassword);
      if (paramProfile.exchangeVersion == 1) {
        localProfile.setExchangeVersion("Exchange2010_SP1");
      }
      break;
    }
    for (;;)
    {
      localProfile.setExchangeServer(paramProfile.exchangeServer);
      localProfile.setExchangeDomain(paramProfile.exchangeDomain);
      localProfile.setExchangeHttpLM(paramProfile.exchangeHttpLM);
      localProfile.setExchangeUsingSSL(paramProfile.exchangeUsingSSL);
      return localProfile;
      localProfile.setProtocol(2);
      break;
      localProfile.setProtocol(3);
      break;
      localProfile.setProtocol(4);
      break;
      localProfile.setProtocol(5);
      break;
      localProfile.setExchangeVersion("Exchange2007_SP1");
    }
  }
  
  private com.tencent.moai.mailsdk.model.Mail parseProtocolComposeMail(ComposeMailUI paramComposeMailUI)
  {
    int j = 0;
    com.tencent.moai.mailsdk.model.Mail localMail = new com.tencent.moai.mailsdk.model.Mail();
    parseProtocolMailInfo(localMail, paramComposeMailUI.getInformation());
    localMail.setUtc(System.currentTimeMillis());
    Object localObject1 = paramComposeMailUI.getContent();
    ArrayList localArrayList1;
    Object localObject3;
    ArrayList localArrayList2;
    Object localObject4;
    int i;
    label189:
    Object localObject7;
    String str;
    Object localObject5;
    if (localObject1 != null)
    {
      localObject1 = ((MailContent)localObject1).getBody();
      if (localObject1 != null)
      {
        localObject2 = FileUtil.getExternalQQMailDirPath();
        localObject2 = ((String)localObject1).replaceAll("file:/" + (String)localObject2, "file://localhost" + (String)localObject2);
        localArrayList1 = new ArrayList();
        localObject3 = new ArrayList();
        if (!SendMailHelper.calculateInlineImgs((String)localObject2, localArrayList1, (ArrayList)localObject3))
        {
          localObject1 = localObject2;
          if (!paramComposeMailUI.hasBinaryAttach()) {
            break label905;
          }
        }
        localArrayList2 = new ArrayList();
        localObject4 = paramComposeMailUI.getAddAttachInfoList();
        localObject1 = localObject2;
        if (localObject4 == null) {
          break label521;
        }
        localObject1 = localObject2;
        if (((ArrayList)localObject4).size() <= 0) {
          break label521;
        }
        i = 0;
        localObject1 = localObject2;
        if (i >= ((ArrayList)localObject4).size()) {
          break label521;
        }
        localObject7 = (AttachInfo)((ArrayList)localObject4).get(i);
        str = ((AttachInfo)localObject7).getAttachName();
        localObject5 = ((AttachInfo)localObject7).uploadDataPath;
        if (!((AttachInfo)localObject7).isBigAttach()) {
          break label253;
        }
        localObject2 = localObject1;
      }
    }
    label253:
    Object localObject6;
    for (;;)
    {
      i += 1;
      localObject1 = localObject2;
      break label189;
      localObject1 = "";
      break;
      localObject2 = localObject1;
      if (!((AttachInfo)localObject7).isEditAttach())
      {
        localObject2 = localObject1;
        if (!StringExtention.isNullOrEmpty((String)localObject5))
        {
          localObject6 = new Attachment();
          ((Attachment)localObject6).setPath((String)localObject5);
          ((Attachment)localObject6).setName((String)localObject5);
          ((Attachment)localObject6).setType("attachment");
          localArrayList2.add(localObject6);
          localObject2 = localObject1;
          if (((AttachInfo)localObject7).isImage())
          {
            localObject2 = localObject1;
            if (((ArrayList)localObject3).contains(str))
            {
              ((ArrayList)localObject3).remove(str);
              if (!localArrayList1.remove(localObject5)) {
                localArrayList1.remove(StringExtention.replaceIllegalUrl((String)localObject5));
              }
              localObject7 = new Attachment();
              ((Attachment)localObject7).setPath(((Attachment)localObject6).getPath());
              ((Attachment)localObject7).setName(((Attachment)localObject6).getName());
              ((Attachment)localObject7).setType("inline");
              localObject2 = StringExtention.filterRegxpllega("file://localhost" + (String)localObject5);
              localObject5 = StringExtention.MD5With32Charactor((String)localObject5);
              localObject2 = ((String)localObject1).replaceAll((String)localObject2, "cid:" + (String)localObject5).replaceAll(StringExtention.filterRegxpllega(StringExtention.replaceIllegalUrl((String)localObject2)), "cid:" + (String)localObject5);
              ((Attachment)localObject7).setCid((String)localObject5);
              localArrayList2.add(localObject7);
            }
          }
        }
      }
    }
    label521:
    Object localObject2 = localObject1;
    if (localArrayList1.size() > 0)
    {
      localObject2 = localObject1;
      if (localArrayList1.size() == ((ArrayList)localObject3).size())
      {
        i = 0;
        if (i < localArrayList1.size())
        {
          localObject4 = (String)localArrayList1.get(i);
          if (StringExtention.isNullOrEmpty((String)localObject4)) {}
          for (;;)
          {
            i += 1;
            break;
            localObject5 = new Attachment();
            ((Attachment)localObject5).setType("inline");
            localObject6 = FileUtil.getFileNameSuffix((String)localObject4);
            if ((paramComposeMailUI.getType() != ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLY) && (paramComposeMailUI.getType() != ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLYALL))
            {
              localObject2 = localObject4;
              localObject3 = localObject1;
              if (paramComposeMailUI.getType() != ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_FORWARD) {}
            }
            else
            {
              localObject2 = localObject4;
              localObject3 = localObject1;
              if (!FileUtil.isImageSuffix((String)localObject6))
              {
                localObject2 = (String)localObject4 + "." + FileUtil.getFileType((String)localObject4);
                FileUtil.renameFile((String)localObject4, (String)localObject2);
                paramComposeMailUI.getContent().setBody(paramComposeMailUI.getContent().getBody().replace((CharSequence)localObject4, (CharSequence)localObject2));
                paramComposeMailUI.getContent().setOrigin(paramComposeMailUI.getContent().getOrigin().replace((CharSequence)localObject4, (CharSequence)localObject2));
                localObject3 = ((String)localObject1).replace((CharSequence)localObject4, (CharSequence)localObject2);
              }
            }
            localObject1 = StringExtention.filterRegxpllega("file://localhost" + (String)localObject2);
            localObject4 = StringExtention.MD5With32Charactor((String)localObject2);
            localObject1 = ((String)localObject3).replaceAll((String)localObject1, "cid:" + (String)localObject4).replaceAll(StringExtention.filterRegxpllega(StringExtention.replaceIllegalUrl((String)localObject1)), "cid:" + (String)localObject4);
            ((Attachment)localObject5).setPath(StringExtention.replaceBackIllegalUrl((String)localObject2));
            ((Attachment)localObject5).setName(StringExtention.replaceBackIllegalUrl((String)localObject2));
            ((Attachment)localObject5).setCid((String)localObject4);
            localArrayList2.add(localObject5);
          }
        }
        localObject2 = localObject1;
      }
    }
    localMail.setAttachments(localArrayList2);
    localObject1 = localObject2;
    label905:
    localObject2 = localObject1;
    if (paramComposeMailUI.getAddAttachInfoList() != null)
    {
      localObject2 = new ArrayList();
      localObject3 = new ArrayList();
      i = j;
      if (i < paramComposeMailUI.getAddAttachInfoList().size())
      {
        localObject4 = (AttachInfo)paramComposeMailUI.getAddAttachInfoList().get(i);
        if (((AttachInfo)localObject4).isBigAttach())
        {
          ((Attach)((AttachInfo)localObject4).getAttach()).setSize(((AttachInfo)localObject4).getAttachSize());
          ((ArrayList)localObject2).add(((AttachInfo)localObject4).getAttach());
        }
        for (;;)
        {
          i += 1;
          break;
          if (((AttachInfo)localObject4).isEditAttach())
          {
            ((Attach)((AttachInfo)localObject4).getAttach()).setSize(((AttachInfo)localObject4).getAttachSize());
            ((ArrayList)localObject3).add(((AttachInfo)localObject4).getAttach());
          }
        }
      }
      paramComposeMailUI = (ComposeMailUI)localObject1;
      if (((ArrayList)localObject2).size() > 0)
      {
        paramComposeMailUI = SendMailHelper.formatBigAttachs((ArrayList)localObject2);
        paramComposeMailUI = (String)localObject1 + paramComposeMailUI;
      }
      localObject2 = paramComposeMailUI;
      if (((ArrayList)localObject3).size() > 0)
      {
        localObject1 = SendMailHelper.formatEditAttaches((ArrayList)localObject3);
        localObject2 = paramComposeMailUI + (String)localObject1;
      }
    }
    localMail.setHtmlContent((String)localObject2);
    return localMail;
  }
  
  private QMFolder parseProtocolFolder(int paramInt, Folder paramFolder)
  {
    QMFolder localQMFolder = new QMFolder();
    if (paramFolder == null) {
      return localQMFolder;
    }
    int i = getFolderType(paramFolder);
    localQMFolder.setId(QMFolder.generateId(paramInt, paramFolder.getRemoteId(), false));
    localQMFolder.setAccountId(paramInt);
    localQMFolder.setRemoteId(paramFolder.getRemoteId());
    localQMFolder.setName(QMFolderManager.sharedInstance().getFolderNameByType(paramFolder.getName(), i));
    localQMFolder.setParentName(paramFolder.getParentId());
    localQMFolder.setTop(paramFolder.isTop());
    localQMFolder.setVirtual(paramFolder.isVirtual());
    localQMFolder.setType(i);
    localQMFolder.setSvrCount(paramFolder.getTotalCount());
    localQMFolder.setSvrUnreadCount(paramFolder.getUnreadCount());
    localQMFolder.setSyncKey(paramFolder.getSvrKey());
    localQMFolder.setSyncState(paramFolder.getSyncState());
    return localQMFolder;
  }
  
  private com.tencent.moai.mailsdk.model.Mail parseProtocolMail(com.tencent.qqmail.model.qmdomain.Mail paramMail)
  {
    int j = 0;
    com.tencent.moai.mailsdk.model.Mail localMail = new com.tencent.moai.mailsdk.model.Mail();
    parseProtocolMailInfo(localMail, paramMail.getInformation());
    localMail.setUtc(paramMail.getInformation().getDate().getTime());
    Object localObject1 = paramMail.getContent();
    Object localObject3;
    Object localObject4;
    ArrayList localArrayList2;
    int i;
    label209:
    Object localObject5;
    String str;
    if (localObject1 != null)
    {
      localObject1 = ((MailContent)localObject1).getBody();
      if (localObject1 != null)
      {
        localObject2 = FileUtil.getExternalQQMailDirPath();
        localObject2 = ((String)localObject1).replaceAll("file:/" + (String)localObject2, "file://localhost" + (String)localObject2);
        localArrayList1 = new ArrayList();
        localObject3 = new ArrayList();
        localObject4 = paramMail.getInformation().getAttachList();
        if (!SendMailHelper.calculateInlineImgs((String)localObject2, localArrayList1, (ArrayList)localObject3))
        {
          localObject1 = localObject2;
          if (localObject4 == null) {
            break label739;
          }
          localObject1 = localObject2;
          if (((ArrayList)localObject4).size() <= 0) {
            break label739;
          }
        }
        localArrayList2 = new ArrayList();
        localObject1 = localObject2;
        if (localObject4 == null) {
          break label508;
        }
        localObject1 = localObject2;
        if (((ArrayList)localObject4).size() <= 0) {
          break label508;
        }
        i = 0;
        localObject1 = localObject2;
        if (i >= ((ArrayList)localObject4).size()) {
          break label508;
        }
        localObject2 = (Attach)((ArrayList)localObject4).get(i);
        localObject5 = ((Attach)localObject2).getName();
        str = ((Attach)localObject2).getPreview().getMyDisk();
        if (!StringExtention.isNullOrEmpty(str)) {
          break label276;
        }
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      i += 1;
      localObject1 = localObject2;
      break label209;
      localObject1 = "";
      break;
      label276:
      Attachment localAttachment = new Attachment();
      localAttachment.setPath(str);
      localAttachment.setName(str);
      localAttachment.setType("attachment");
      localArrayList2.add(localAttachment);
      localObject2 = localObject1;
      if (((ArrayList)localObject3).contains(localObject5))
      {
        ((ArrayList)localObject3).remove(localObject5);
        if (!localArrayList1.remove(str)) {
          localArrayList1.remove(StringExtention.replaceIllegalUrl(str));
        }
        localObject5 = new Attachment();
        ((Attachment)localObject5).setPath(localAttachment.getPath());
        ((Attachment)localObject5).setName(localAttachment.getName());
        ((Attachment)localObject5).setType("inline");
        localObject2 = StringExtention.filterRegxpllega("file://localhost" + str);
        str = StringExtention.MD5With32Charactor(str);
        localObject2 = ((String)localObject1).replaceAll((String)localObject2, "cid:" + str).replaceAll(StringExtention.filterRegxpllega(StringExtention.replaceIllegalUrl((String)localObject2)), "cid:" + str);
        ((Attachment)localObject5).setCid(str);
        localArrayList2.add(localObject5);
      }
    }
    label508:
    Object localObject2 = localObject1;
    if (localArrayList1.size() > 0)
    {
      localObject2 = localObject1;
      if (localArrayList1.size() == ((ArrayList)localObject3).size())
      {
        i = j;
        if (i < localArrayList1.size())
        {
          localObject2 = (String)localArrayList1.get(i);
          if (StringExtention.isNullOrEmpty((String)localObject2)) {}
          for (;;)
          {
            i += 1;
            break;
            localObject3 = new Attachment();
            ((Attachment)localObject3).setType("inline");
            str = StringExtention.filterRegxpllega("file://localhost" + (String)localObject2);
            localObject4 = StringExtention.MD5With32Charactor((String)localObject2);
            localObject1 = ((String)localObject1).replaceAll(str, "cid:" + (String)localObject4).replaceAll(StringExtention.filterRegxpllega(StringExtention.replaceIllegalUrl(str)), "cid:" + (String)localObject4);
            ((Attachment)localObject3).setPath(StringExtention.replaceBackIllegalUrl((String)localObject2));
            ((Attachment)localObject3).setName(StringExtention.replaceBackIllegalUrl((String)localObject2));
            ((Attachment)localObject3).setCid((String)localObject4);
            localArrayList2.add(localObject3);
          }
        }
        localObject2 = localObject1;
      }
    }
    localMail.setAttachments(localArrayList2);
    localObject1 = localObject2;
    label739:
    ArrayList localArrayList1 = paramMail.getInformation().getBigAttachList();
    localObject2 = paramMail.getInformation().getEditAttachList();
    paramMail = (com.tencent.qqmail.model.qmdomain.Mail)localObject1;
    if (localArrayList1 != null)
    {
      paramMail = (com.tencent.qqmail.model.qmdomain.Mail)localObject1;
      if (localArrayList1.size() > 0)
      {
        paramMail = SendMailHelper.formatBigAttachs(localArrayList1);
        paramMail = (String)localObject1 + paramMail;
      }
    }
    localObject1 = paramMail;
    if (localObject2 != null)
    {
      localObject1 = paramMail;
      if (((ArrayList)localObject2).size() > 0)
      {
        localObject1 = SendMailHelper.formatEditAttaches((ArrayList)localObject2);
        localObject1 = paramMail + (String)localObject1;
      }
    }
    localMail.setHtmlContent((String)localObject1);
    return localMail;
  }
  
  private void parseProtocolMailInfo(com.tencent.moai.mailsdk.model.Mail paramMail, MailInformation paramMailInformation)
  {
    if ((paramMail != null) && (paramMailInformation != null))
    {
      paramMail.setMessageId(paramMailInformation.getMessageId());
      paramMail.setReference(paramMailInformation.getReferences());
      Object localObject = paramMailInformation.getToList();
      ArrayList localArrayList = new ArrayList();
      int i;
      MailContact localMailContact;
      if (localObject != null)
      {
        i = 0;
        while (i < ((ArrayList)localObject).size())
        {
          localMailContact = (MailContact)((ArrayList)localObject).get(i);
          localArrayList.add(new Contact(localMailContact.getAddress(), StringExtention.safeNickName(localMailContact.getNick())));
          i += 1;
        }
      }
      paramMail.setTo(localArrayList);
      localObject = paramMailInformation.getCcList();
      localArrayList = new ArrayList();
      if (localObject != null)
      {
        i = 0;
        while (i < ((ArrayList)localObject).size())
        {
          localMailContact = (MailContact)((ArrayList)localObject).get(i);
          localArrayList.add(new Contact(localMailContact.getAddress(), StringExtention.safeNickName(localMailContact.getNick())));
          i += 1;
        }
      }
      paramMail.setCc(localArrayList);
      localObject = paramMailInformation.getBccList();
      localArrayList = new ArrayList();
      if (localObject != null)
      {
        i = 0;
        while (i < ((ArrayList)localObject).size())
        {
          localMailContact = (MailContact)((ArrayList)localObject).get(i);
          localArrayList.add(new Contact(localMailContact.getAddress(), StringExtention.safeNickName(localMailContact.getNick())));
          i += 1;
        }
      }
      paramMail.setBcc(localArrayList);
      localObject = SendMailHelper.getSenderEmailAndNick(paramMailInformation);
      paramMail.setFrom(new Contact(localObject[0], localObject[1]));
      paramMail.setSubject(paramMailInformation.getSubject());
    }
  }
  
  private com.tencent.qqmail.protocol.Profile parseProtocolProfile(com.tencent.moai.mailsdk.model.Profile paramProfile)
  {
    com.tencent.qqmail.protocol.Profile localProfile = new com.tencent.qqmail.protocol.Profile();
    switch (paramProfile.getProtocol())
    {
    default: 
      localProfile.proxyServer = paramProfile.getProxyServer();
      localProfile.proxyPort = paramProfile.getProxyPort();
      localProfile.proxyUsername = paramProfile.getProxyUserName();
      localProfile.proxyPassword = paramProfile.getProxyPassword();
      localProfile.smtpName = paramProfile.getSmtpName();
      localProfile.smtpPassword = paramProfile.getSmtpPassword();
      localProfile.smtpServer = paramProfile.getSmtpServer();
      localProfile.smtpPort = paramProfile.getSmtpPort();
      localProfile.smtpSSLPort = paramProfile.getSmtpSSLPort();
      localProfile.smtpUsingSSL = paramProfile.isSmtpUsingSSL();
      localProfile.imapName = paramProfile.getImapName();
      localProfile.imapPassword = paramProfile.getImapPassword();
      localProfile.imapServer = paramProfile.getImapServer();
      localProfile.imapPort = paramProfile.getImapPort();
      localProfile.imapSSLPort = paramProfile.getImapSSLPort();
      localProfile.imapUsingSSL = paramProfile.isImapUsingSSL();
      localProfile.imapUserAgentId = paramProfile.getImapUserAgent();
      localProfile.pop3Name = paramProfile.getPopName();
      localProfile.pop3Password = paramProfile.getPopPassword();
      localProfile.pop3Server = paramProfile.getPopServer();
      localProfile.pop3Port = paramProfile.getPopPort();
      localProfile.pop3SSLPort = paramProfile.getPopSSLPort();
      localProfile.pop3UsingSSL = paramProfile.isPopUsingSSL();
      localProfile.activeSyncName = paramProfile.getActiveSyncName();
      localProfile.activeSyncPassword = paramProfile.getActiveSyncPassword();
      localProfile.activeSyncServer = paramProfile.getActiveSyncServer();
      localProfile.activeSyncUsingSSL = paramProfile.isActiveSyncUsingSSL();
      localProfile.activeSyncDomain = paramProfile.getActiveSyncDomain();
      localProfile.activeSyncVersion = paramProfile.getActiveSyncVersion();
      localProfile.activeSyncPolicyKey = paramProfile.getActiveSyncPolicyKey();
      localProfile.deviceId = paramProfile.getDeviceId();
      localProfile.deviceType = paramProfile.getDeviceType();
      localProfile.isOauth = paramProfile.isOauth();
      localProfile.accessToken = paramProfile.getAccessToken();
      localProfile.refreshToken = paramProfile.getRefreshToken();
      localProfile.tokenType = paramProfile.getTokenType();
      localProfile.idToken = paramProfile.getIdToken();
      localProfile.expiresIn = paramProfile.getExpiresIn();
      localProfile.exchangeName = paramProfile.getExchangeName();
      localProfile.exchangePassword = paramProfile.getExchangePassword();
      localProfile.exchangeServer = paramProfile.getExchangeServer();
      if (!"Exchange2010_SP1".equals(paramProfile.getExchangeVersion())) {
        break;
      }
    }
    for (localProfile.exchangeVersion = 1;; localProfile.exchangeVersion = 0)
    {
      localProfile.exchangeDomain = paramProfile.getExchangeDomain();
      localProfile.exchangeHttpLM = paramProfile.isExchangeHttpLM();
      localProfile.exchangeUsingSSL = paramProfile.isExchangeUsingSSL();
      return localProfile;
      localProfile.protocolType = 1;
      break;
      localProfile.protocolType = 0;
      break;
      localProfile.protocolType = 4;
      break;
      localProfile.protocolType = 3;
      break;
    }
  }
  
  private CRecurrence parseRecurrence(Recurrence paramRecurrence)
  {
    if (paramRecurrence == null) {
      return null;
    }
    CRecurrence localCRecurrence = new CRecurrence();
    localCRecurrence.type = paramRecurrence.getType();
    localCRecurrence.week_of_month = paramRecurrence.getWeek_of_month();
    localCRecurrence.day_of_month = paramRecurrence.getDay_of_month();
    localCRecurrence.month_of_year = paramRecurrence.getMonth_of_year();
    localCRecurrence.is_leap_month = paramRecurrence.is_leap_month();
    localCRecurrence.interval = paramRecurrence.getInterval();
    localCRecurrence.calendar_type = paramRecurrence.getCalendar_type();
    localCRecurrence.first_day_of_week = paramRecurrence.getFirst_day_of_week();
    localCRecurrence.occurrences = paramRecurrence.getOccurrences();
    localCRecurrence.until = paramRecurrence.getUntil();
    return localCRecurrence;
  }
  
  private com.tencent.qqmail.model.qmdomain.Mail processMail(int paramInt1, int paramInt2, com.tencent.moai.mailsdk.model.Mail paramMail, int paramInt3, boolean paramBoolean)
  {
    com.tencent.qqmail.model.qmdomain.Mail localMail = new com.tencent.qqmail.model.qmdomain.Mail();
    Object localObject = new MailContact();
    if (paramMail.getFrom() != null)
    {
      ((MailContact)localObject).setName(paramMail.getFrom().getNick());
      ((MailContact)localObject).setNick(paramMail.getFrom().getNick());
      ((MailContact)localObject).setAddress(paramMail.getFrom().getEmail());
    }
    MailInformation localMailInformation = new MailInformation();
    localMailInformation.setId(paramMail.getId());
    localMailInformation.setSubject(paramMail.getSubject());
    localMailInformation.setAbstractContent(parseAbstract(paramMail));
    localMailInformation.setFrom((MailContact)localObject);
    localMailInformation.setToList(parseContact(paramMail.getTo()));
    localMailInformation.setCcList(parseContact(paramMail.getCc()));
    localMailInformation.setBccList(parseContact(paramMail.getBcc()));
    localMailInformation.setDate(new Date(paramMail.getUtc()));
    localMailInformation.setRemoteId(paramMail.getRemoteId());
    localMailInformation.setFolderId(paramInt2);
    localMailInformation.setAccountId(paramInt1);
    localMailInformation.setReferences("");
    localMailInformation.setMessageId("");
    localMailInformation.setSvrKey(paramMail.getSvrKey());
    localMailInformation.setSize(paramMail.getSize());
    localMailInformation.setAttachList(parseAttachList(paramMail, paramInt3));
    if (paramInt3 == 1) {
      localMailInformation.setBodyStructureInfos(parseBodyInfoList(paramMail.getId(), paramMail.getBodyStructures()));
    }
    MailStatus localMailStatus = new MailStatus();
    boolean bool;
    String str;
    if (!paramMail.isRead())
    {
      bool = true;
      localMailStatus.setUnread(bool);
      localMailStatus.setStarred(paramMail.isStar());
      localMailStatus.setProtocolMail(true);
      localMailStatus.setHasAttach(paramMail.isHasAttach());
      localMailStatus.setContentComplete(paramMail.isContentComplete());
      localMailStatus.setIsSearchMail(paramMail.isSearchMail());
      str = "";
      localObject = str;
      if (!paramBoolean)
      {
        if ((paramMail.getHtmlContent() == null) || (paramMail.getHtmlContent().equals(""))) {
          break label400;
        }
        localObject = paramMail.getHtmlContent();
      }
    }
    for (;;)
    {
      paramMail = new MailContent();
      paramMail.setBody((String)localObject);
      paramMail.setBodyText((String)localObject);
      localMail.setInformation(localMailInformation);
      localMail.setStatus(localMailStatus);
      localMail.setContent(paramMail);
      return localMail;
      bool = false;
      break;
      label400:
      localObject = str;
      if (paramMail.getPlainContent() != null)
      {
        localObject = str;
        if (!paramMail.getPlainContent().equals("")) {
          localObject = paramMail.getPlainContent();
        }
      }
    }
  }
  
  private void reportIdleSupportDomain(Account paramAccount)
  {
    SharedPreferences localSharedPreferences = SPManager.getSp("accounts_info");
    String str = localSharedPreferences.getString("idle_support_domain", "");
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
    OssHelper.idleSupport(new Object[] { paramAccount.getProfile().getDomain(), paramAccount.getProfile().imapServer });
    localObject = str;
    if (!str.equals("")) {
      localObject = str + ",";
    }
    paramAccount = (String)localObject + String.valueOf(paramAccount.getId());
    localSharedPreferences.edit().putString("idle_support_domain", paramAccount).apply();
  }
  
  private void reportJavaLoginImmediately(com.tencent.qqmail.protocol.Profile paramProfile, int paramInt1, String paramString1, boolean paramBoolean, int paramInt2, String paramString2)
  {
    String str2 = "UNKNOWN";
    String str1 = "";
    switch (paramInt1)
    {
    }
    for (;;)
    {
      QMLog.log(4, "QMMailProtocolJavaService", "report java " + paramString1 + " " + paramProfile.mailAddress + ", " + str2 + ", isSuccess:" + paramBoolean + ", code:" + paramInt2 + ", error:" + paramString2);
      if (!paramBoolean) {
        break;
      }
      OssHelper.protocolMailLogin(new Object[] { paramProfile.mailAddress, str2, paramString1, Integer.valueOf(1), Integer.valueOf(0) });
      return;
      str2 = "IMAP";
      str1 = paramProfile.imapServer;
      continue;
      str2 = "POP";
      str1 = paramProfile.pop3Server;
      continue;
      str2 = "EXCHANGE";
      str1 = paramProfile.exchangeServer;
      continue;
      str2 = "ACTIVESYNC";
      str1 = paramProfile.activeSyncServer;
      continue;
      str2 = "SMTP";
      str1 = paramProfile.smtpServer;
    }
    OssHelper.protocolMailLogin(new Object[] { paramProfile.mailAddress, str2, paramString1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt2), paramString2, str1 });
  }
  
  private void reportJavaProtocolError(com.tencent.qqmail.protocol.Profile paramProfile, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    String str = "UNKNOWN";
    switch (paramInt1)
    {
    }
    for (;;)
    {
      QMLog.log(4, "QMMailProtocolJavaService", "report java " + paramString1 + " " + paramProfile.mailAddress + ", " + str + ", code:" + paramInt2 + ", error:" + paramString2);
      OssHelper.protocolMail(new Object[] { paramProfile.mailAddress, str, paramString1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt2), paramString2 });
      return;
      str = "IMAP";
      continue;
      str = "POP";
      continue;
      str = "EXCHANGE";
      continue;
      str = "ACTIVESYNC";
      continue;
      str = "SMTP";
    }
  }
  
  private void reportJavaProtocolSuccess(String paramString1, int paramInt, String paramString2)
  {
    String str = "UNKNOWN";
    switch (paramInt)
    {
    }
    for (;;)
    {
      QMLog.log(4, "QMMailProtocolJavaService", "report java " + paramString2 + " " + paramString1 + " " + str + " success");
      OssHelper.protocolMail(new Object[] { paramString1, str, paramString2, Integer.valueOf(1), Integer.valueOf(0) });
      return;
      str = "IMAP";
      continue;
      str = "POP";
      continue;
      str = "EXCHANGE";
      continue;
      str = "ACTIVESYNC";
      continue;
      str = "SMTP";
    }
  }
  
  private void reportUseUserName(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    int i;
    if ((!StringExtention.isNullOrEmpty(paramString2)) && (!paramString2.contains("@")))
    {
      i = 1;
      if (i != 0) {
        switch (paramInt)
        {
        default: 
          paramString2 = "";
        }
      }
    }
    for (;;)
    {
      OssHelper.protocolMail(new Object[] { paramString1, paramString2, "LoginUserName", paramString3 });
      return;
      i = 0;
      break;
      paramString2 = "IMAP";
      continue;
      paramString2 = "POP";
      continue;
      paramString2 = "SMTP";
    }
  }
  
  private boolean unableIdle(Account paramAccount)
  {
    return (paramAccount.isGMail()) || (paramAccount.getEmail().endsWith("@sohu.com"));
  }
  
  public void addFolder(Account paramAccount, QMFolder paramQMFolder, FolderOperationCallback paramFolderOperationCallback)
  {
    com.tencent.qqmail.protocol.Profile localProfile1 = paramAccount.getProfile();
    com.tencent.moai.mailsdk.model.Profile localProfile = parseProfile(localProfile1);
    Folder localFolder = new Folder();
    localFolder.setFolderId(paramQMFolder.getId());
    localFolder.setRemoteId(paramQMFolder.getRemoteId());
    localFolder.setParentId(paramQMFolder.getParentName());
    localFolder.setPath(paramQMFolder.getRemoteId());
    localFolder.setName(paramQMFolder.getName());
    localFolder.setSyncState(QMFolderManager.sharedInstance().getFolderSyncState(paramQMFolder.getId()));
    localFolder.setSvrKey(QMFolderManager.sharedInstance().getFolderSyncKey(paramQMFolder.getId()));
    State localState = new State();
    localState.setAccountId(paramAccount.getId());
    paramAccount = new QMMailProtocolJavaService.13(this, paramFolderOperationCallback, paramAccount, localProfile1, localProfile, paramQMFolder);
    MailManager.getInstance().addFolder(localProfile, localState, localFolder, paramAccount);
  }
  
  public void addRule(Account paramAccount, Exchange.ExchangeRule[] paramArrayOfExchangeRule)
  {
    paramAccount = parseProfile(paramAccount.getProfile());
    paramArrayOfExchangeRule = parseExchangeRule(paramArrayOfExchangeRule);
    QMMailProtocolJavaService.34 local34 = new QMMailProtocolJavaService.34(this);
    MailManager.getInstance().addRule(paramAccount, paramArrayOfExchangeRule, local34);
  }
  
  public void appendFile()
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getDefaultMailAccount();
    if ((localAccount != null) && (localAccount.isImapMail()))
    {
      int i = QMFolderManager.sharedInstance().getSentFolderId(localAccount.getId());
      if (i != -1)
      {
        QMFolder localQMFolder = QMFolderManager.sharedInstance().getFolder(i);
        if (localQMFolder != null) {
          MailManager.getInstance().appendFile(parseProfile(localAccount.getProfile()), String.valueOf(localQMFolder.getRemoteId()), "/sdcard/tencent/QQmail/tmp/test.eml", null);
        }
      }
    }
  }
  
  public void appendMailToServer(Account paramAccount, QMFolder paramQMFolder, com.tencent.qqmail.model.qmdomain.Mail paramMail, MailManagerDelegate paramMailManagerDelegate)
  {
    paramAccount = paramAccount.getProfile();
    com.tencent.moai.mailsdk.model.Profile localProfile = parseProfile(paramAccount);
    com.tencent.moai.mailsdk.model.Mail localMail = parseProtocolMail(paramMail);
    String str = paramQMFolder.getRemoteId();
    MailManager.getInstance().appendMailToServer(localProfile, localMail, str, new QMMailProtocolJavaService.32(this, paramMail, paramQMFolder, paramMailManagerDelegate, paramAccount, localProfile));
  }
  
  public void checkMail(Account paramAccount, Map<QMFolder, ArrayList<String>> paramMap, CheckMailCallback paramCheckMailCallback)
  {
    if ((paramAccount.isGMail()) && (LoginManager.shareInstance().isGMailAccessTokenExpire(paramAccount.getId())))
    {
      LoginManager.shareInstance().refreshGmailAccessToken(paramAccount.getId(), paramAccount.getRefreshToken(), new QMMailProtocolJavaService.16(this, paramMap, paramCheckMailCallback));
      return;
    }
    com.tencent.qqmail.protocol.Profile localProfile1 = paramAccount.getProfile();
    com.tencent.moai.mailsdk.model.Profile localProfile = parseProfile(localProfile1);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      QMFolder localQMFolder = (QMFolder)localIterator.next();
      localHashMap.put(parseFolder(localQMFolder), paramMap.get(localQMFolder));
    }
    paramAccount = new QMMailProtocolJavaService.17(this, paramAccount, localProfile1, localProfile, paramCheckMailCallback, paramMap);
    MailManager.getInstance().checkMail(localProfile, localHashMap, paramAccount);
  }
  
  public void downloadAttach(MailInformation paramMailInformation, Attach paramAttach, boolean paramBoolean, LoadMailAttachCallBack paramLoadMailAttachCallBack)
  {
    long l2 = paramAttach.getHashId();
    boolean bool = paramAttach.getProtocol().getType().equals("inline");
    Object localObject1 = AccountManager.shareInstance().getAccountList().getAccountById(paramMailInformation.getAccountId());
    int i = ((Account)localObject1).getId();
    com.tencent.qqmail.protocol.Profile localProfile = ((Account)localObject1).getProfile();
    com.tencent.moai.mailsdk.model.Profile localProfile1 = parseProfile(localProfile);
    Object localObject2;
    Object localObject3;
    label116:
    String str1;
    String str2;
    if (bool)
    {
      localObject1 = FileUtil.getThumbImageCacheDir();
      localObject2 = localObject1;
      if (StringExtention.isNullOrEmpty((String)localObject1)) {
        localObject2 = FileUtil.getAttachDownloadDir();
      }
      localObject3 = new StringBuilder().append((String)localObject2);
      if (!bool) {
        break label495;
      }
      localObject1 = StringExtention.hashKeyForDisk(paramAttach.getProtocol().getCid());
      localObject1 = (String)localObject1;
      localObject3 = QMFolderManager.sharedInstance().getFolder(paramMailInformation.getFolderId());
      localObject2 = new Folder();
      ((Folder)localObject2).setFolderId(((QMFolder)localObject3).getId());
      ((Folder)localObject2).setRemoteId(((QMFolder)localObject3).getRemoteId());
      ((Folder)localObject2).setPath(((QMFolder)localObject3).getRemoteId());
      ((Folder)localObject2).setName(((QMFolder)localObject3).getName());
      ((Folder)localObject2).setSyncState(QMFolderManager.sharedInstance().getFolderSyncState(((QMFolder)localObject3).getId()));
      ((Folder)localObject2).setSvrKey(QMFolderManager.sharedInstance().getFolderSyncKey(((QMFolder)localObject3).getId()));
      localObject3 = new com.tencent.moai.mailsdk.model.Mail();
      str1 = paramMailInformation.getRemoteId();
      str2 = paramMailInformation.getSvrKey();
      ((com.tencent.moai.mailsdk.model.Mail)localObject3).setRemoteId(str1);
      ((com.tencent.moai.mailsdk.model.Mail)localObject3).setSvrKey(str2);
      ((com.tencent.moai.mailsdk.model.Mail)localObject3).setId(paramMailInformation.getId());
      paramMailInformation = new Attachment();
      paramMailInformation.setName(paramAttach.getName());
      paramMailInformation.setCid(paramAttach.getProtocol().getCid());
      paramMailInformation.setType(paramAttach.getProtocol().getType());
      if (!StringUtility.isNullOrEmpty(paramAttach.getSize())) {
        break label509;
      }
    }
    label495:
    label509:
    for (long l1 = 0L;; l1 = StringExtention.sizeStrToLong(paramAttach.getSize()))
    {
      paramMailInformation.setSize(l1);
      paramMailInformation.setPath((String)localObject1);
      paramMailInformation.setFid(paramAttach.getProtocol().getExchangeFileUid());
      if ((paramAttach.getProtocol().getProtocolType() == 1) && (paramAttach.getProtocol().getBodyInfo() != null)) {
        paramMailInformation.setImapBodyStructure(parseBodyStructure(paramAttach.getProtocol().getBodyInfo()));
      }
      if (!bool) {
        break label521;
      }
      QMLog.log(4, "QMMailProtocolJavaService", "protocol download inline image");
      if (!QMAttachManager.sharedInstance().isMailInlineImageCached(paramAttach.getProtocol().getCid())) {
        break label641;
      }
      paramMailInformation = QMAttachManager.sharedInstance().getInlineImageDisk(paramAttach.getProtocol().getCid());
      QMLog.log(4, "QMMailProtocolJavaService", "downloadAttach inline img downloaded:" + paramAttach.getProtocol().getCid() + ", path:" + paramMailInformation);
      if (paramLoadMailAttachCallBack != null) {
        paramLoadMailAttachCallBack.onSuccess(paramMailInformation, QMAttachManager.sharedInstance().getAttach(l2));
      }
      return;
      localObject1 = paramAttach.getPreview().getMyDisk();
      break;
      localObject1 = FileUtil.rename((String)localObject2, paramAttach.getName());
      break label116;
    }
    label521:
    if ((paramAttach.getProtocol().getProtocolType() == 1) && (paramMailInformation.getImapBodyStructure() != null) && (paramAttach.getPreview().getCopyDiskList().size() > 0))
    {
      str2 = (String)paramAttach.getPreview().getCopyDiskList().get(0);
      if (FileUtility.isFileExist(str2))
      {
        QMLog.log(4, "QMMailProtocolJavaService", "imap tmp attach file exist:" + str2);
        MailManager.getInstance().transformTmpAttach(str2, paramMailInformation.getPath(), paramMailInformation.getImapBodyStructure().getEncoding(), new QMMailProtocolJavaService.29(this, str2, paramBoolean, l2, paramMailInformation, paramLoadMailAttachCallBack, (String)localObject1));
        return;
      }
    }
    label641:
    MailManager.getInstance().downloadAttachment(localProfile1, (Folder)localObject2, (com.tencent.moai.mailsdk.model.Mail)localObject3, paramMailInformation, new QMMailProtocolJavaService.30(this, paramMailInformation, paramLoadMailAttachCallBack, paramBoolean, l2, localProfile, localProfile1, i, paramAttach, str1));
  }
  
  public void downloadMailAbstract(Account paramAccount, QMFolder paramQMFolder, ArrayList<com.tencent.qqmail.model.qmdomain.Mail> paramArrayList, LoadMailAbstractCallback paramLoadMailAbstractCallback)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    com.tencent.qqmail.protocol.Profile localProfile = paramAccount.getProfile();
    int j = localProfile.protocolType;
    paramAccount = parseProfile(localProfile);
    Folder localFolder = new Folder();
    localFolder.setFolderId(paramQMFolder.getId());
    localFolder.setRemoteId(paramQMFolder.getRemoteId());
    localFolder.setPath(paramQMFolder.getRemoteId());
    localFolder.setName(paramQMFolder.getName());
    localFolder.setSyncState(QMFolderManager.sharedInstance().getFolderSyncState(paramQMFolder.getId()));
    localFolder.setSvrKey(QMFolderManager.sharedInstance().getFolderSyncKey(paramQMFolder.getId()));
    com.tencent.moai.mailsdk.model.Mail[] arrayOfMail = new com.tencent.moai.mailsdk.model.Mail[paramArrayList.size()];
    int i = 0;
    if (i < paramArrayList.size())
    {
      com.tencent.qqmail.model.qmdomain.Mail localMail = (com.tencent.qqmail.model.qmdomain.Mail)paramArrayList.get(i);
      com.tencent.moai.mailsdk.model.Mail localMail1 = new com.tencent.moai.mailsdk.model.Mail();
      localMail1.setId(localMail.getInformation().getId());
      localMail1.setRemoteId(localMail.getInformation().getRemoteId());
      localMail1.setSvrKey(localMail.getInformation().getSvrKey());
      if (j == 1) {
        localMail1.setBodyStructures(parseBodyStructureList(QMMailManager.sharedInstance().readMailPartInfo(localMail.getInformation().getId())));
      }
      if (localMail.getStatus().isAdConv()) {
        localMail1.setType(1);
      }
      for (;;)
      {
        arrayOfMail[i] = localMail1;
        i += 1;
        break;
        if (localMail.getStatus().isConversationChild()) {
          localMail1.setType(-1);
        } else {
          localMail1.setType(0);
        }
      }
    }
    if (paramLoadMailAbstractCallback != null) {
      paramLoadMailAbstractCallback.loadAbstractProcess();
    }
    paramQMFolder = new QMMailProtocolJavaService.28(this, paramLoadMailAbstractCallback, localProfile, paramAccount, paramQMFolder);
    MailManager.getInstance().downloadMailsAbstract(paramAccount, localFolder, arrayOfMail, paramQMFolder);
  }
  
  public void downloadMailText(Account paramAccount, QMFolder paramQMFolder, com.tencent.qqmail.model.qmdomain.Mail paramMail, boolean paramBoolean1, boolean paramBoolean2, LoadMailCallback paramLoadMailCallback)
  {
    if (paramMail == null) {
      return;
    }
    if ((paramAccount.isGMail()) && (LoginManager.shareInstance().isGMailAccessTokenExpire(paramAccount.getId())))
    {
      LoginManager.shareInstance().refreshGmailAccessToken(paramAccount.getId(), paramAccount.getRefreshToken(), new QMMailProtocolJavaService.26(this, paramQMFolder, paramMail, paramBoolean1, paramBoolean2, paramLoadMailCallback));
      return;
    }
    com.tencent.qqmail.protocol.Profile localProfile1 = paramAccount.getProfile();
    int i = localProfile1.protocolType;
    int j = paramAccount.getId();
    int k = paramQMFolder.getId();
    long l = paramMail.getInformation().getId();
    com.tencent.moai.mailsdk.model.Profile localProfile = parseProfile(localProfile1);
    Folder localFolder = new Folder();
    localFolder.setFolderId(paramQMFolder.getId());
    localFolder.setRemoteId(paramQMFolder.getRemoteId());
    localFolder.setPath(paramQMFolder.getRemoteId());
    localFolder.setName(paramQMFolder.getName());
    localFolder.setSyncState(QMFolderManager.sharedInstance().getFolderSyncState(paramQMFolder.getId()));
    localFolder.setSvrKey(QMFolderManager.sharedInstance().getFolderSyncKey(paramQMFolder.getId()));
    com.tencent.moai.mailsdk.model.Mail localMail = new com.tencent.moai.mailsdk.model.Mail();
    localMail.setId(paramMail.getInformation().getId());
    localMail.setRemoteId(paramMail.getInformation().getRemoteId());
    localMail.setSvrKey(paramMail.getInformation().getSvrKey());
    if (i == 1) {
      localMail.setBodyStructures(parseBodyStructureList(QMMailManager.sharedInstance().readMailPartInfo(paramMail.getInformation().getId())));
    }
    if (paramLoadMailCallback != null) {
      paramLoadMailCallback.loadMailProcess();
    }
    paramAccount = new QMMailProtocolJavaService.27(this, j, k, i, paramLoadMailCallback, l, localProfile1, localProfile, paramAccount, paramQMFolder, paramMail, paramBoolean1, paramBoolean2);
    MailManager.getInstance().downloadMailsText(localProfile, localFolder, new com.tencent.moai.mailsdk.model.Mail[] { localMail }, paramBoolean1, paramBoolean2, paramAccount);
  }
  
  public void fetchFolderList(Account paramAccount, FolderListCallback paramFolderListCallback)
  {
    if ((paramAccount.isGMail()) && (LoginManager.shareInstance().isGMailAccessTokenExpire(paramAccount.getId())))
    {
      LoginManager.shareInstance().refreshGmailAccessToken(paramAccount.getId(), paramAccount.getRefreshToken(), new QMMailProtocolJavaService.11(this, paramFolderListCallback));
      return;
    }
    int i = paramAccount.getId();
    com.tencent.qqmail.protocol.Profile localProfile1 = paramAccount.getProfile();
    com.tencent.moai.mailsdk.model.Profile localProfile = parseProfile(localProfile1);
    State localState = new State();
    localState.setAccountId(i);
    paramAccount = new QMMailProtocolJavaService.12(this, i, paramFolderListCallback, localProfile1, localProfile, paramAccount);
    MailManager.getInstance().fetchFolderList(localProfile, localState, paramAccount);
  }
  
  public void fetchMailList(Account paramAccount, QMFolder paramQMFolder, ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, MailListCallback paramMailListCallback)
  {
    if ((paramAccount.isGMail()) && (LoginManager.shareInstance().isGMailAccessTokenExpire(paramAccount.getId())))
    {
      LoginManager.shareInstance().refreshGmailAccessToken(paramAccount.getId(), paramAccount.getRefreshToken(), new QMMailProtocolJavaService.18(this, paramQMFolder, paramArrayList, paramBoolean1, paramBoolean2, paramMailListCallback));
      return;
    }
    int i = paramAccount.getId();
    int j = paramQMFolder.getId();
    long l = paramQMFolder.getSince();
    com.tencent.qqmail.protocol.Profile localProfile1 = paramAccount.getProfile();
    int k = localProfile1.protocolType;
    com.tencent.moai.mailsdk.model.Profile localProfile = parseProfile(localProfile1);
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    State localState;
    if (localProfile1.protocolType == 0)
    {
      ((ArrayList)localObject).addAll(paramArrayList);
      localArrayList.addAll(QMMailManager.sharedInstance().getPurgedPopMailIds(paramAccount.getId()));
      localState = new State();
      localState.setAccountId(i);
      localState.setReceiveNewOnly(paramBoolean1);
      localState.setInitLoadCount(20);
      localState.setLoadMoreCount(20);
      localState.setUpdateCount(20);
      localState.setExistUidList((ArrayList)localObject);
      localState.setDeleteUidList(localArrayList);
      localState.setActiveSyncFilterType(QMSyncManager.sharedInstance().getActiveSyncAccFilterType(i));
      if ((paramBoolean1) || (localProfile1.protocolType != 3)) {
        break label436;
      }
    }
    label436:
    for (l = QMMailManager.sharedInstance().getSinceMailUtc(j, l);; l = 0L)
    {
      localState.setLastMailUtc(l);
      localState.setIsWithoutSession(paramBoolean2);
      localObject = new Folder();
      ((Folder)localObject).setFolderId(paramQMFolder.getId());
      ((Folder)localObject).setRemoteId(paramQMFolder.getRemoteId());
      ((Folder)localObject).setPath(paramQMFolder.getRemoteId());
      ((Folder)localObject).setName(paramQMFolder.getName());
      ((Folder)localObject).setSyncState(QMFolderManager.sharedInstance().getFolderSyncState(paramQMFolder.getId()));
      ((Folder)localObject).setSvrKey(QMFolderManager.sharedInstance().getFolderSyncKey(paramQMFolder.getId()));
      if (paramMailListCallback != null) {
        paramMailListCallback.process();
      }
      paramAccount = new QMMailProtocolJavaService.19(this, i, j, k, paramMailListCallback, localProfile1, localProfile, paramAccount, paramQMFolder, paramArrayList, paramBoolean1, paramBoolean2);
      MailManager.getInstance().fetchMailList(localProfile, localState, (Folder)localObject, paramAccount);
      return;
      if (localProfile1.protocolType == 1)
      {
        ((ArrayList)localObject).addAll(paramArrayList);
        break;
      }
      if (localProfile1.protocolType == 4)
      {
        ((ArrayList)localObject).addAll(paramArrayList);
        break;
      }
      if (localProfile1.protocolType != 3) {
        break;
      }
      ((ArrayList)localObject).addAll(paramArrayList);
      break;
    }
  }
  
  public void initAccountSyncKeyMapping(Map<Integer, String> paramMap)
  {
    MailManager.getInstance().initAccountSyncKeyMapping(paramMap);
  }
  
  public void initActiveSync()
  {
    Object localObject2 = new ArrayList();
    Object localObject1 = AccountManager.shareInstance().getAccountList().iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Account)((Iterator)localObject1).next();
      if (((Account)localObject3).isActiveSyncMail()) {
        ((ArrayList)localObject2).add(Integer.valueOf(((Account)localObject3).getId()));
      }
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Integer)((Iterator)localObject2).next();
        ((ArrayList)localObject1).addAll(QMFolderManager.sharedInstance().getFoldersByAccountId(((Integer)localObject3).intValue()));
      }
      localObject2 = new HashMap();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (QMFolder)((Iterator)localObject1).next();
        ((HashMap)localObject2).put(Integer.valueOf(((QMFolder)localObject3).getId()), ((QMFolder)localObject3).getSyncKey());
      }
      initFolderSyncKeyMapping((Map)localObject2);
      initAccountSyncKeyMapping(AccountManager.shareInstance().getAccountList(true).getFolderListSyncKeyMap());
    }
  }
  
  public void initFolderSyncKeyMapping(Map<Integer, String> paramMap)
  {
    MailManager.getInstance().initFolderSyncKeyMapping(paramMap);
  }
  
  public void initProfile(com.tencent.qqmail.protocol.Profile paramProfile)
  {
    paramProfile = parseProfile(paramProfile);
    MailManager.getInstance().initProfile(paramProfile);
  }
  
  public void initProtocolService()
  {
    MailManager.init(QMApplicationContext.sharedInstance());
    MailManager.initLogger(new QMMailProtocolJavaService.1(this));
    MailManager.setDefaultTmpFileDir(FileUtil.getDownloadTmpFileDir());
    Object localObject = DeviceUtil.getDeviceInfos();
    com.tencent.moai.mailsdk.protocol.activesync.model.DeviceInfo localDeviceInfo = new com.tencent.moai.mailsdk.protocol.activesync.model.DeviceInfo();
    localDeviceInfo.setModel(((com.tencent.qqmail.utilities.deviceid.DeviceInfo)localObject).MODEL);
    localDeviceInfo.setDeviceBrand(((com.tencent.qqmail.utilities.deviceid.DeviceInfo)localObject).BRAND);
    localDeviceInfo.setOs("Android " + ((com.tencent.qqmail.utilities.deviceid.DeviceInfo)localObject).releaseVersion);
    localDeviceInfo.setOsLang(Locale.getDefault().getLanguage());
    localDeviceInfo.setPhoneNumber(((com.tencent.qqmail.utilities.deviceid.DeviceInfo)localObject).PHONE_NUMBER);
    localDeviceInfo.setMobileOperator(((com.tencent.qqmail.utilities.deviceid.DeviceInfo)localObject).MANUFACTURER);
    localDeviceInfo.setImie(((com.tencent.qqmail.utilities.deviceid.DeviceInfo)localObject).IMEI);
    StringBuilder localStringBuilder = new StringBuilder().append("QQMail/Android/").append(AppConfig.getCodeVersion()).append("/");
    if (Build.VERSION.RELEASE == null) {}
    for (localObject = "";; localObject = Build.VERSION.RELEASE)
    {
      localDeviceInfo.setUserAgent((String)localObject);
      localObject = SSLStrategyFactory.getSSLStrategy();
      MailSSLUtil.setDelegateSSLSocketFactory((SSLSocketFactory)localObject);
      MailSSLUtil.setHostnameVerifier((HostnameVerifier)localObject);
      MailManager.getInstance().setDeviceInfo(localDeviceInfo);
      MailManager.getInstance().setFolderSyncKeyCallback(new QMMailProtocolJavaService.2(this));
      MailManager.getInstance().setAccountSyncKeyCallback(new QMMailProtocolJavaService.3(this));
      SPUtility.setSpDelegate(new QMMailProtocolJavaService.4(this));
      return;
    }
  }
  
  public void loadMailFromEml(int paramInt, long paramLong, String paramString1, String paramString2, LoadEmlCallback paramLoadEmlCallback)
  {
    MimeMessage localMimeMessage = new MimeMessage();
    try
    {
      localMimeMessage.read(new FileInputStream(new File(paramString2)), null);
      paramString2 = MailParser.createMail(localMimeMessage);
      if (paramLoadEmlCallback != null) {
        paramLoadEmlCallback.loadSuccess(parseEmlMail(paramInt, paramString1, paramLong, paramString2));
      }
      return;
    }
    catch (Exception paramString1)
    {
      while (paramLoadEmlCallback == null) {}
      paramLoadEmlCallback.loadFail();
    }
  }
  
  public void login(com.tencent.qqmail.protocol.Profile paramProfile, LoginCallback paramLoginCallback, boolean paramBoolean)
  {
    com.tencent.moai.mailsdk.model.Profile localProfile = parseProfile(paramProfile);
    paramProfile = new QMMailProtocolJavaService.5(this, paramProfile, paramBoolean, getDomain(paramProfile.mailAddress), paramLoginCallback, localProfile);
    MailManager.getInstance().login(localProfile, paramProfile, paramBoolean);
  }
  
  public void logout(com.tencent.qqmail.protocol.Profile paramProfile, LogoutCallback paramLogoutCallback)
  {
    com.tencent.moai.mailsdk.model.Profile localProfile = parseProfile(paramProfile);
    paramProfile = new QMMailProtocolJavaService.6(this, paramLogoutCallback, paramProfile, localProfile);
    MailManager.getInstance().logout(localProfile, paramProfile);
  }
  
  public void moveMails(Account paramAccount, QMFolder paramQMFolder1, QMFolder paramQMFolder2, List<String> paramList1, List<String> paramList2, MailManagerDelegate paramMailManagerDelegate)
  {
    int j = paramAccount.getId();
    com.tencent.qqmail.protocol.Profile localProfile = paramAccount.getProfile();
    paramAccount = parseProfile(localProfile);
    Folder localFolder = new Folder();
    localFolder.setFolderId(paramQMFolder1.getId());
    localFolder.setRemoteId(paramQMFolder1.getRemoteId());
    localFolder.setPath(paramQMFolder1.getRemoteId());
    localFolder.setName(paramQMFolder1.getName());
    localFolder.setSyncState(QMFolderManager.sharedInstance().getFolderSyncState(paramQMFolder1.getId()));
    localFolder.setSvrKey(QMFolderManager.sharedInstance().getFolderSyncKey(paramQMFolder1.getId()));
    paramQMFolder1 = new Folder();
    paramQMFolder1.setFolderId(paramQMFolder2.getId());
    paramQMFolder1.setRemoteId(paramQMFolder2.getRemoteId());
    paramQMFolder1.setPath(paramQMFolder2.getRemoteId());
    paramQMFolder1.setName(paramQMFolder2.getName());
    paramQMFolder1.setSyncState(QMFolderManager.sharedInstance().getFolderSyncState(paramQMFolder2.getId()));
    paramQMFolder1.setSvrKey(QMFolderManager.sharedInstance().getFolderSyncKey(paramQMFolder2.getId()));
    paramQMFolder2 = new com.tencent.moai.mailsdk.model.Mail[paramList1.size()];
    int i = 0;
    while (i < paramList1.size())
    {
      com.tencent.moai.mailsdk.model.Mail localMail = new com.tencent.moai.mailsdk.model.Mail();
      localMail.setRemoteId((String)paramList1.get(i));
      localMail.setSvrKey((String)paramList2.get(i));
      paramQMFolder2[i] = localMail;
      i += 1;
    }
    paramList1 = new QMMailProtocolJavaService.22(this, paramMailManagerDelegate, localProfile, paramAccount, j);
    MailManager.getInstance().moveMail(paramAccount, localFolder, paramQMFolder1, paramQMFolder2, paramList1);
  }
  
  public void notifyIdle()
  {
    MailManager.getInstance().notifyIdle();
  }
  
  public ArrayList<ExchangeRule> parseExchangeRule(Exchange.ExchangeRule[] paramArrayOfExchangeRule)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayOfExchangeRule != null) && (paramArrayOfExchangeRule.length > 0))
    {
      int j = paramArrayOfExchangeRule.length;
      int i = 0;
      while (i < j)
      {
        Exchange.ExchangeRule localExchangeRule = paramArrayOfExchangeRule[i];
        ExchangeRule localExchangeRule1 = new ExchangeRule();
        localExchangeRule1.setDisplayName(localExchangeRule.display_name_);
        localExchangeRule1.setEnabled(localExchangeRule.is_enabled_);
        localExchangeRule1.setId(localExchangeRule.id_);
        localExchangeRule1.setPriority(localExchangeRule.priority_);
        Object localObject;
        if (localExchangeRule.actions_ != null)
        {
          localExchangeRule1.getClass();
          localObject = new ExchangeRule.Actions(localExchangeRule1);
          ((ExchangeRule.Actions)localObject).setDesFolderId_(localExchangeRule.actions_.des_folder_id_);
          ((ExchangeRule.Actions)localObject).setDesFolderType_(localExchangeRule.actions_.des_folder_type_);
          ((ExchangeRule.Actions)localObject).setMarkAsRead(localExchangeRule.actions_.mark_as_read_);
          ((ExchangeRule.Actions)localObject).setSoftDeleteMail(localExchangeRule.actions_.soft_delete_mail_);
          localExchangeRule1.setActions((ExchangeRule.Actions)localObject);
        }
        if (localExchangeRule.conditions_ != null)
        {
          localExchangeRule1.getClass();
          localObject = new ExchangeRule.Conditions(localExchangeRule1);
          ((ExchangeRule.Conditions)localObject).setSender(localExchangeRule.conditions_.sender_);
          ((ExchangeRule.Conditions)localObject).setSubject(localExchangeRule.conditions_.subject_);
          ((ExchangeRule.Conditions)localObject).setTo(localExchangeRule.conditions_.to_);
          localExchangeRule1.setConditions((ExchangeRule.Conditions)localObject);
        }
        localArrayList.add(localExchangeRule1);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public void removeAccountSyncKey(int paramInt)
  {
    MailManager.getInstance().removeAccountSyncKey(paramInt);
  }
  
  public void removeFolder(Account paramAccount, QMFolder paramQMFolder, FolderOperationCallback paramFolderOperationCallback)
  {
    com.tencent.qqmail.protocol.Profile localProfile1 = paramAccount.getProfile();
    com.tencent.moai.mailsdk.model.Profile localProfile = parseProfile(localProfile1);
    Folder localFolder = new Folder();
    localFolder.setFolderId(paramQMFolder.getId());
    localFolder.setRemoteId(paramQMFolder.getRemoteId());
    localFolder.setParentId(paramQMFolder.getParentName());
    localFolder.setPath(paramQMFolder.getRemoteId());
    localFolder.setName(paramQMFolder.getName());
    localFolder.setSyncState(QMFolderManager.sharedInstance().getFolderSyncState(paramQMFolder.getId()));
    localFolder.setSvrKey(QMFolderManager.sharedInstance().getFolderSyncKey(paramQMFolder.getId()));
    State localState = new State();
    localState.setAccountId(paramAccount.getId());
    paramAccount = new QMMailProtocolJavaService.15(this, paramFolderOperationCallback, paramQMFolder, localProfile1, localProfile);
    MailManager.getInstance().removeFolder(localProfile, localState, localFolder, paramAccount);
  }
  
  public void removeFolderSyncKey(int[] paramArrayOfInt)
  {
    MailManager.getInstance().removeFolderSyncKey(paramArrayOfInt);
  }
  
  public void removeMails(Account paramAccount, QMFolder paramQMFolder, List<String> paramList1, List<String> paramList2, MailManagerDelegate paramMailManagerDelegate)
  {
    int j = paramAccount.getId();
    com.tencent.qqmail.protocol.Profile localProfile = paramAccount.getProfile();
    paramAccount = parseProfile(localProfile);
    Folder localFolder = new Folder();
    localFolder.setFolderId(paramQMFolder.getId());
    localFolder.setRemoteId(paramQMFolder.getRemoteId());
    localFolder.setPath(paramQMFolder.getRemoteId());
    localFolder.setName(paramQMFolder.getName());
    localFolder.setSyncState(QMFolderManager.sharedInstance().getFolderSyncState(paramQMFolder.getId()));
    localFolder.setSvrKey(QMFolderManager.sharedInstance().getFolderSyncKey(paramQMFolder.getId()));
    paramQMFolder = new com.tencent.moai.mailsdk.model.Mail[paramList1.size()];
    int i = 0;
    while (i < paramList1.size())
    {
      com.tencent.moai.mailsdk.model.Mail localMail = new com.tencent.moai.mailsdk.model.Mail();
      localMail.setRemoteId((String)paramList1.get(i));
      localMail.setSvrKey((String)paramList2.get(i));
      paramQMFolder[i] = localMail;
      i += 1;
    }
    paramList1 = new QMMailProtocolJavaService.23(this, paramMailManagerDelegate, localProfile, paramAccount, j);
    MailManager.getInstance().deleteMail(paramAccount, localFolder, paramQMFolder, paramList1);
  }
  
  public void renameFolder(Account paramAccount, QMFolder paramQMFolder, String paramString, FolderOperationCallback paramFolderOperationCallback)
  {
    com.tencent.qqmail.protocol.Profile localProfile1 = paramAccount.getProfile();
    com.tencent.moai.mailsdk.model.Profile localProfile = parseProfile(localProfile1);
    Folder localFolder = new Folder();
    localFolder.setFolderId(paramQMFolder.getId());
    localFolder.setRemoteId(paramQMFolder.getRemoteId());
    localFolder.setParentId(paramQMFolder.getParentName());
    localFolder.setPath(paramQMFolder.getRemoteId());
    localFolder.setName(paramQMFolder.getName());
    localFolder.setSyncState(QMFolderManager.sharedInstance().getFolderSyncState(paramQMFolder.getId()));
    localFolder.setSvrKey(QMFolderManager.sharedInstance().getFolderSyncKey(paramQMFolder.getId()));
    State localState = new State();
    localState.setAccountId(paramAccount.getId());
    paramAccount = new QMMailProtocolJavaService.14(this, paramFolderOperationCallback, paramAccount, localProfile1, localProfile, paramQMFolder);
    MailManager.getInstance().renameFolder(localProfile, localState, localFolder, paramString, paramAccount);
  }
  
  public QMProtocolRequest searchMail(QMSearchCursor paramQMSearchCursor, SearchInfo paramSearchInfo, SearchMailCallback paramSearchMailCallback)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramSearchInfo.getAccountId());
    com.tencent.moai.mailsdk.model.Profile localProfile = parseProfile(localAccount.getProfile());
    com.tencent.qqmail.protocol.Profile localProfile1 = localAccount.getProfile();
    Object localObject1 = paramSearchInfo.getFolderIds();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Object localObject2;
    while (i < localObject1.length)
    {
      localObject2 = QMFolderManager.sharedInstance().getFolder(Integer.parseInt(localObject1[i]));
      if ((localObject2 != null) && (!((QMFolder)localObject2).isVirtual())) {
        localArrayList.add(((QMFolder)localObject2).getRemoteId());
      }
      i += 1;
    }
    localObject1 = new ArrayList();
    int j = paramQMSearchCursor.getCount();
    i = 0;
    if (i < j)
    {
      if (paramQMSearchCursor.getItem(i) == null) {}
      for (;;)
      {
        i += 1;
        break;
        ((ArrayList)localObject1).add(paramQMSearchCursor.getItem(i).getInformation().getRemoteId());
      }
    }
    paramQMSearchCursor = paramQMSearchCursor.getLastRemoteItem(paramSearchInfo.getAccountId());
    if (paramQMSearchCursor != null) {}
    for (long l = paramQMSearchCursor.getInformation().getUtc().getTime() / 1000L;; l = new Date().getTime() / 1000L)
    {
      paramQMSearchCursor = new HashMap();
      localObject2 = paramSearchInfo.getKeyword();
      if ((paramSearchInfo.getSearchType() == 1) || (paramSearchInfo.getSearchType() == 7)) {
        paramQMSearchCursor.put(Integer.valueOf(0), localObject2);
      }
      if ((paramSearchInfo.getSearchType() == 2) || (paramSearchInfo.getSearchType() == 7)) {
        paramQMSearchCursor.put(Integer.valueOf(1), localObject2);
      }
      if ((paramSearchInfo.getSearchType() == 4) || (paramSearchInfo.getSearchType() == 7)) {
        paramQMSearchCursor.put(Integer.valueOf(2), localObject2);
      }
      if (paramSearchInfo.getSearchType() == 7) {
        paramQMSearchCursor.put(Integer.valueOf(3), localObject2);
      }
      localObject2 = new State();
      ((State)localObject2).setExistUidList((ArrayList)localObject1);
      ((State)localObject2).setAccountId(paramSearchInfo.getAccountId());
      ((State)localObject2).setLastMailUtc(l);
      ((State)localObject2).setLoadMoreCount(20);
      localObject1 = new QMProtocolRequest();
      MailManager.getInstance().searchMail(localProfile, localArrayList, (State)localObject2, paramQMSearchCursor, new QMMailProtocolJavaService.31(this, (QMProtocolRequest)localObject1, l, new int[] { 20, 0 }, localAccount, paramSearchInfo, localProfile1, paramSearchMailCallback, localProfile));
      return localObject1;
    }
  }
  
  public QMProtocolRequest sendMail(Account paramAccount, ComposeMailUI paramComposeMailUI, MailManagerDelegate paramMailManagerDelegate)
  {
    QMProtocolRequest localQMProtocolRequest = new QMProtocolRequest();
    if ((paramAccount.isGMail()) && (LoginManager.shareInstance().isGMailAccessTokenExpire(paramAccount.getId())))
    {
      LoginManager.shareInstance().refreshGmailAccessToken(paramAccount.getId(), paramAccount.getRefreshToken(), new QMMailProtocolJavaService.24(this, paramComposeMailUI, paramMailManagerDelegate));
      return localQMProtocolRequest;
    }
    com.tencent.qqmail.protocol.Profile localProfile1 = paramAccount.getProfile();
    com.tencent.moai.mailsdk.model.Profile localProfile = parseProfile(localProfile1);
    com.tencent.moai.mailsdk.model.Mail localMail = parseProtocolComposeMail(paramComposeMailUI);
    paramAccount = new QMMailProtocolJavaService.25(this, paramMailManagerDelegate, localQMProtocolRequest, localProfile1, localProfile, paramAccount, paramComposeMailUI, localMail);
    MailManager.getInstance().sendMail(localProfile, localMail, paramAccount);
    return localQMProtocolRequest;
  }
  
  public void setAccountSyncKey(int paramInt, String paramString)
  {
    MailManager.getInstance().setAccountSyncKey(paramInt, paramString);
  }
  
  public void setFolderSyncKey(int paramInt, String paramString)
  {
    MailManager.getInstance().setFolderSyncKey(paramInt, paramString);
  }
  
  public void starMails(Account paramAccount, QMFolder paramQMFolder, boolean paramBoolean, List<String> paramList1, List<String> paramList2, MailManagerDelegate paramMailManagerDelegate)
  {
    int j = paramAccount.getId();
    com.tencent.qqmail.protocol.Profile localProfile = paramAccount.getProfile();
    paramAccount = parseProfile(localProfile);
    Folder localFolder = new Folder();
    localFolder.setFolderId(paramQMFolder.getId());
    localFolder.setRemoteId(paramQMFolder.getRemoteId());
    localFolder.setPath(paramQMFolder.getRemoteId());
    localFolder.setName(paramQMFolder.getName());
    localFolder.setSyncState(QMFolderManager.sharedInstance().getFolderSyncState(paramQMFolder.getId()));
    localFolder.setSvrKey(QMFolderManager.sharedInstance().getFolderSyncKey(paramQMFolder.getId()));
    paramQMFolder = new com.tencent.moai.mailsdk.model.Mail[paramList1.size()];
    int i = 0;
    while (i < paramList1.size())
    {
      com.tencent.moai.mailsdk.model.Mail localMail = new com.tencent.moai.mailsdk.model.Mail();
      localMail.setRemoteId((String)paramList1.get(i));
      localMail.setSvrKey((String)paramList2.get(i));
      paramQMFolder[i] = localMail;
      i += 1;
    }
    paramList1 = new QMMailProtocolJavaService.20(this, paramMailManagerDelegate, localProfile, paramAccount, j);
    paramList2 = MailManager.getInstance();
    if (paramBoolean) {}
    for (i = 1;; i = 2)
    {
      paramList2.modifyMailFlag(paramAccount, localFolder, paramQMFolder, 1, i, paramList1);
      return;
    }
  }
  
  public void startIdle(Account paramAccount, QMFolder paramQMFolder, IdleCallback paramIdleCallback)
  {
    if (unableIdle(paramAccount))
    {
      QMLog.log(4, "QMMailProtocolJavaService", "unable idle " + paramQMFolder.getRemoteId() + " " + paramAccount.getEmail());
      return;
    }
    com.tencent.moai.mailsdk.model.Profile localProfile = parseProfile(paramAccount.getProfile());
    Folder localFolder = parseFolder(paramQMFolder);
    QMAckIntervalDetector localQMAckIntervalDetector = new QMAckIntervalDetector("idle_ack_info_" + paramAccount.getEmail(), 180000, 1800000);
    MailManager.getInstance().setIdleAckInterval(localProfile, localQMAckIntervalDetector.getAckInterval());
    MailManager.getInstance().startIdle(localProfile, localFolder, new QMMailProtocolJavaService.33(this, paramIdleCallback, paramAccount, localQMAckIntervalDetector, paramQMFolder, localProfile));
  }
  
  public void stopIdle(Account paramAccount)
  {
    MailManager.getInstance().stopIdle(parseProfile(paramAccount.getProfile()));
  }
  
  public void syncActiveSyncFolderStatus(Account paramAccount, QMFolder paramQMFolder, IListStatusCallback paramIListStatusCallback)
  {
    int i = paramAccount.getId();
    com.tencent.qqmail.protocol.Profile localProfile = paramAccount.getProfile();
    paramAccount = parseProfile(localProfile);
    Folder localFolder = new Folder();
    localFolder.setFolderId(paramQMFolder.getId());
    localFolder.setRemoteId(paramQMFolder.getRemoteId());
    localFolder.setPath(paramQMFolder.getRemoteId());
    localFolder.setName(paramQMFolder.getName());
    localFolder.setSyncState(QMFolderManager.sharedInstance().getFolderSyncState(paramQMFolder.getId()));
    localFolder.setSvrKey(QMFolderManager.sharedInstance().getFolderSyncKey(paramQMFolder.getId()));
    State localState = new State();
    localState.setAccountId(i);
    localState.setActiveSyncFilterType(QMSyncManager.sharedInstance().getActiveSyncAccFilterType(i));
    paramQMFolder = new QMMailProtocolJavaService.10(this, paramQMFolder, paramIListStatusCallback, localProfile, paramAccount, i);
    MailManager.getInstance().syncActiveSyncFolderStatus(paramAccount, localState, localFolder, paramQMFolder);
  }
  
  public void syncExchangeFolderStatus(Account paramAccount, QMFolder paramQMFolder, IListStatusCallback paramIListStatusCallback)
  {
    int i = paramAccount.getId();
    com.tencent.qqmail.protocol.Profile localProfile = paramAccount.getProfile();
    paramAccount = parseProfile(localProfile);
    Folder localFolder = new Folder();
    localFolder.setFolderId(paramQMFolder.getId());
    localFolder.setRemoteId(paramQMFolder.getRemoteId());
    localFolder.setPath(paramQMFolder.getRemoteId());
    localFolder.setName(paramQMFolder.getName());
    localFolder.setSyncState(QMFolderManager.sharedInstance().getFolderSyncState(paramQMFolder.getId()));
    localFolder.setSvrKey(QMFolderManager.sharedInstance().getFolderSyncKey(paramQMFolder.getId()));
    State localState = new State();
    localState.setAccountId(i);
    paramQMFolder = new QMMailProtocolJavaService.9(this, paramQMFolder, paramIListStatusCallback, localProfile, paramAccount, i);
    MailManager.getInstance().syncExchangeFolderStatus(paramAccount, localState, localFolder, paramQMFolder);
  }
  
  public void syncImapFolderStatus(Account paramAccount, QMFolder paramQMFolder, IListStatusCallback paramIListStatusCallback)
  {
    if ((paramAccount.isGMail()) && (LoginManager.shareInstance().isGMailAccessTokenExpire(paramAccount.getId())))
    {
      LoginManager.shareInstance().refreshGmailAccessToken(paramAccount.getId(), paramAccount.getRefreshToken(), new QMMailProtocolJavaService.7(this, paramQMFolder, paramIListStatusCallback));
      return;
    }
    int i = paramAccount.getId();
    com.tencent.qqmail.protocol.Profile localProfile1 = paramAccount.getProfile();
    com.tencent.moai.mailsdk.model.Profile localProfile = parseProfile(localProfile1);
    Folder localFolder = new Folder();
    localFolder.setFolderId(paramQMFolder.getId());
    localFolder.setRemoteId(paramQMFolder.getRemoteId());
    localFolder.setPath(paramQMFolder.getRemoteId());
    localFolder.setName(paramQMFolder.getName());
    localFolder.setSyncState(QMFolderManager.sharedInstance().getFolderSyncState(paramQMFolder.getId()));
    localFolder.setSvrKey(QMFolderManager.sharedInstance().getFolderSyncKey(paramQMFolder.getId()));
    paramAccount = new QMMailProtocolJavaService.8(this, paramQMFolder, paramIListStatusCallback, localProfile1, localProfile, i, paramAccount);
    MailManager.getInstance().syncImapFolderStatus(localProfile, localFolder, paramAccount);
  }
  
  public void unreadMails(Account paramAccount, QMFolder paramQMFolder, boolean paramBoolean, List<String> paramList1, List<String> paramList2, MailManagerDelegate paramMailManagerDelegate)
  {
    int j = paramAccount.getId();
    com.tencent.qqmail.protocol.Profile localProfile = paramAccount.getProfile();
    paramAccount = parseProfile(localProfile);
    Folder localFolder = new Folder();
    localFolder.setFolderId(paramQMFolder.getId());
    localFolder.setRemoteId(paramQMFolder.getRemoteId());
    localFolder.setPath(paramQMFolder.getRemoteId());
    localFolder.setName(paramQMFolder.getName());
    localFolder.setSyncState(QMFolderManager.sharedInstance().getFolderSyncState(paramQMFolder.getId()));
    localFolder.setSvrKey(QMFolderManager.sharedInstance().getFolderSyncKey(paramQMFolder.getId()));
    paramQMFolder = new com.tencent.moai.mailsdk.model.Mail[paramList1.size()];
    int i = 0;
    while (i < paramList1.size())
    {
      com.tencent.moai.mailsdk.model.Mail localMail = new com.tencent.moai.mailsdk.model.Mail();
      localMail.setRemoteId((String)paramList1.get(i));
      localMail.setSvrKey((String)paramList2.get(i));
      paramQMFolder[i] = localMail;
      i += 1;
    }
    paramList1 = new QMMailProtocolJavaService.21(this, paramMailManagerDelegate, localProfile, paramAccount, j);
    paramList2 = MailManager.getInstance();
    if (!paramBoolean) {}
    for (i = 1;; i = 2)
    {
      paramList2.modifyMailFlag(paramAccount, localFolder, paramQMFolder, 2, i, paramList1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService
 * JD-Core Version:    0.7.0.1
 */