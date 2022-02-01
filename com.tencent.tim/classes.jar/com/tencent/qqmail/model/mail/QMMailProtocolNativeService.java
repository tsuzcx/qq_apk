package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.MailAccount;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachProtocol;
import com.tencent.qqmail.attachment.model.AttachProtocol.MailItemBodyInfo;
import com.tencent.qqmail.attachment.model.AttachState;
import com.tencent.qqmail.download.util.DownloadUtil;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.callback.FolderListCallback;
import com.tencent.qqmail.model.mail.callback.FolderOperationCallback;
import com.tencent.qqmail.model.mail.callback.IListStatusCallback;
import com.tencent.qqmail.model.mail.callback.LoadMailAbstractCallback;
import com.tencent.qqmail.model.mail.callback.LoadMailAttachCallBack;
import com.tencent.qqmail.model.mail.callback.LoadMailCallback;
import com.tencent.qqmail.model.mail.callback.LoginCallback;
import com.tencent.qqmail.model.mail.callback.LogoutCallback;
import com.tencent.qqmail.model.mail.callback.MailListCallback;
import com.tencent.qqmail.model.mail.callback.SearchAddressCallback;
import com.tencent.qqmail.model.mail.callback.SearchMailCallback;
import com.tencent.qqmail.model.mail.cursor.QMSearchCursor;
import com.tencent.qqmail.model.protocol.QMSyncManager;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.qmdomain.SearchInfo;
import com.tencent.qqmail.model.sendmail.SendMailHelper;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.CloudProtocolHelper;
import com.tencent.qqmail.protocol.CloudProtocolInfo;
import com.tencent.qqmail.protocol.CloudProtocolService;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.protocol.Exchange.ExchangeContent;
import com.tencent.qqmail.protocol.Exchange.ExchangeRule;
import com.tencent.qqmail.protocol.ItemBodyStructureHelper;
import com.tencent.qqmail.protocol.ItemBodyStructureHelper.MailItemBodyStructureInfo;
import com.tencent.qqmail.protocol.Mail.Folder;
import com.tencent.qqmail.protocol.MailAttachment;
import com.tencent.qqmail.protocol.MailUtil;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.protocol.ProtocolFolder;
import com.tencent.qqmail.protocol.ProtocolInfo;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.protocol.ProtocolService;
import com.tencent.qqmail.protocol.ReceiveState;
import com.tencent.qqmail.protocol.UMA.TranslationReq;
import com.tencent.qqmail.utilities.QMUtilities;
import com.tencent.qqmail.utilities.common.CommUtils;
import com.tencent.qqmail.utilities.contacts.ContactsHelper;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.LogPathManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMGeneralCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import moai.oss.OssHelper;

public class QMMailProtocolNativeService
{
  private static final String ALREADY_DOWNLOAD_SIZE = "already_download_size";
  private static final String DOWNLOAD_SIZE_IN_SECTION = "download_size_in_section";
  private static final int SEARCH_EXCHANGE_ADDR_TIMEOUT = 0;
  private static final int SEARCH_EXCHANGE_LIMIT = 30;
  private static final String SECTION = "section";
  private static final String TAG = "QMMailProtocolNativeService";
  private final int SEARCH_MAX_COUNT = 20;
  
  private String getDomain(Account paramAccount)
  {
    if (paramAccount != null) {
      return getDomain(paramAccount.getEmail());
    }
    return "";
  }
  
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
  
  private int getFolderType(Mail.Folder paramFolder)
  {
    int i = 1;
    paramFolder.folderType = paramFolder.remoteFolderType;
    switch (paramFolder.folderType)
    {
    case 6: 
    case 7: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      i = QMFolderManager.sharedInstance().getFolderType(paramFolder.showname);
      if ((i != 1) && (i != 4) && (i != 3) && (i != 5) && (i != 6)) {
        i = 0;
      }
      break;
    case 2: 
      return i;
    case 3: 
      return 4;
    case 4: 
      return 5;
    case 5: 
      return 3;
    case 8: 
    case 13: 
      return 9;
    }
    return i;
  }
  
  private int loadMailStrategy(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    do
    {
      do
      {
        return 0;
      } while (paramInt != 0);
      if (QMNetworkUtils.isWifiConnected()) {
        return 2;
      }
    } while (!QMNetworkUtils.isMobileConnected());
    return 1;
  }
  
  private ArrayList<Object> parseAttachList(com.tencent.qqmail.protocol.Mail paramMail, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramMail.attachment_set_ != null) && (paramMail.attachment_set_.length > 0))
    {
      int i = 0;
      while (i < paramMail.attachment_set_.length)
      {
        MailAttachment localMailAttachment = paramMail.attachment_set_[i];
        Attach localAttach = new Attach(true);
        localAttach.setIsProtocol(true);
        localAttach.setName(localMailAttachment.file_name_);
        localAttach.setDisplayName(localMailAttachment.display_name_);
        localAttach.setBytes(localMailAttachment.file_size_);
        localAttach.setSize(StringExtention.getHumanReadable(localMailAttachment.file_size_));
        localAttach.getProtocol().setMailId(localMailAttachment.mailId_);
        localAttach.getProtocol().setAttachId(localMailAttachment.attachment_id_);
        localAttach.getProtocol().setIsexist(localMailAttachment.file_exist_);
        localAttach.getProtocol().setProtocolType(paramInt);
        localAttach.getProtocol().setType(localMailAttachment.type_);
        localAttach.getProtocol().setData(localMailAttachment.data_);
        localAttach.getProtocol().setCid(localMailAttachment.cid_);
        localAttach.getProtocol().setExchangeFileUid(localMailAttachment.exchange_file_uid_);
        localAttach.getProtocol().setFileContentType(localMailAttachment.file_content_type_);
        localAttach.getState().setIsFavLocal(true);
        localAttach.getState().setDownloadSizeByte(0L);
        if ((paramInt == 1) && (localMailAttachment.body_structure_helper_.body_struture_info_.length > 0))
        {
          ItemBodyStructureHelper.MailItemBodyStructureInfo localMailItemBodyStructureInfo = localMailAttachment.body_structure_helper_.body_struture_info_[0];
          localAttach.getProtocol().setBodyInfo(new AttachProtocol.MailItemBodyInfo());
          localAttach.getProtocol().getBodyInfo().id = localMailItemBodyStructureInfo.id_;
          localAttach.getProtocol().getBodyInfo().mailId = localMailItemBodyStructureInfo.mailId_;
          localAttach.getProtocol().getBodyInfo().attachId = localMailItemBodyStructureInfo.attachId_;
          localAttach.getProtocol().getBodyInfo().itemId = localMailItemBodyStructureInfo.itemid_;
          localAttach.getProtocol().getBodyInfo().itemType = localMailItemBodyStructureInfo.item_type_;
          localAttach.getProtocol().getBodyInfo().bodyId = localMailItemBodyStructureInfo.body_id_;
          localAttach.getProtocol().getBodyInfo().contentType = localMailItemBodyStructureInfo.content_type_;
          localAttach.getProtocol().getBodyInfo().contentSubType = localMailItemBodyStructureInfo.content_subtype_;
          localAttach.getProtocol().getBodyInfo().contentTypeParams = localMailItemBodyStructureInfo.content_type_params_;
          localAttach.getProtocol().getBodyInfo().contentDescription = localMailItemBodyStructureInfo.content_description_;
          localAttach.getProtocol().getBodyInfo().transferEncoding = localMailItemBodyStructureInfo.content_transfer_encoding_;
          localAttach.getProtocol().getBodyInfo().contentLineSize = localMailItemBodyStructureInfo.content_line_size_;
          localAttach.getProtocol().getBodyInfo().contentDisposition = localMailItemBodyStructureInfo.content_disposition_;
        }
        if ((localMailAttachment.url_ != null) && (!localMailAttachment.url_.equals(""))) {
          localAttach.getPreview().setMyDisk(localMailAttachment.url_);
        }
        localAttach.setOrderIndex(i);
        localArrayList.add(localAttach);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private QMFolder[] parseFolderList(Mail.Folder[] paramArrayOfFolder, int paramInt1, int paramInt2)
  {
    QMFolder[] arrayOfQMFolder = new QMFolder[paramArrayOfFolder.length];
    int i = 0;
    if (i < paramArrayOfFolder.length)
    {
      Mail.Folder localFolder = paramArrayOfFolder[i];
      QMFolder localQMFolder = new QMFolder();
      arrayOfQMFolder[i] = localQMFolder;
      if (localFolder == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (paramInt2 != 1) {
          break label326;
        }
        if (!StringExtention.isNullOrEmpty(localFolder.showname_fromServer))
        {
          if (!localFolder.showname_fromServer.equals("INBOX")) {
            break label224;
          }
          localQMFolder.setType(1);
        }
        label89:
        localQMFolder.setId(QMFolder.generateId(paramInt1, localFolder.name, false));
        localQMFolder.setAccountId(paramInt1);
        localQMFolder.setRemoteId(localFolder.name);
        localQMFolder.setName(QMFolderManager.sharedInstance().getFolderNameByType(localFolder.showname, localQMFolder.getType()));
        localQMFolder.setParentName(localFolder.parentname);
        localQMFolder.setTop(localFolder.isTop);
        localQMFolder.setVirtual(localFolder.isVirtual);
        switch (paramInt2)
        {
        }
      }
      for (;;)
      {
        localQMFolder.setSvrCount(localFolder.totalCnt);
        break;
        label224:
        if (localFolder.showname_fromServer.equals("Drafts"))
        {
          localQMFolder.setType(4);
          break label89;
        }
        if (localFolder.showname_fromServer.equals("Sent Messages"))
        {
          localQMFolder.setType(3);
          break label89;
        }
        if (localFolder.showname_fromServer.equals("Deleted Messages"))
        {
          localQMFolder.setType(5);
          break label89;
        }
        if (localFolder.showname_fromServer.equals("Junk"))
        {
          localQMFolder.setType(6);
          break label89;
        }
        localQMFolder.setType(0);
        break label89;
        label326:
        localQMFolder.setType(getFolderType(localFolder));
        break label89;
        localQMFolder.setSyncKey(localFolder.svrKey);
        localQMFolder.setSyncState(localFolder.syncStatus);
      }
    }
    return arrayOfQMFolder;
  }
  
  private com.tencent.qqmail.model.qmdomain.Mail parseMail(com.tencent.qqmail.protocol.Mail paramMail, int paramInt)
  {
    paramMail.mailId = com.tencent.qqmail.model.qmdomain.Mail.generateId(paramMail.accountId, paramMail.folderId, paramMail.remoteId);
    return processMail(paramMail, paramInt);
  }
  
  private com.tencent.qqmail.protocol.Mail parseProtocolComposeMail(ComposeMailUI paramComposeMailUI)
  {
    int j = 0;
    com.tencent.qqmail.protocol.Mail localMail = new com.tencent.qqmail.protocol.Mail();
    Object localObject1 = paramComposeMailUI.getContent().getBody();
    parseProtocolMailInfo(localMail, paramComposeMailUI.getInformation());
    Object localObject2 = paramComposeMailUI.getComposeCacheFilePath() + File.separator + CommUtils.COMPOSE_MIME;
    Object localObject3 = new File((String)localObject2);
    Object localObject5;
    int i;
    label534:
    Object localObject4;
    try
    {
      ((File)localObject3).createNewFile();
      localMail.uploadFilePath = ((String)localObject2);
      localObject2 = FileUtil.getExternalQQMailDirPath();
      localObject2 = ((String)localObject1).replaceAll("file:/" + (String)localObject2, "file://localhost" + (String)localObject2);
      localArrayList2 = new ArrayList();
      localObject3 = new ArrayList();
      if ((SendMailHelper.calculateInlineImgs((String)localObject2, localArrayList2, (ArrayList)localObject3)) || (paramComposeMailUI.hasBinaryAttach()))
      {
        localArrayList1 = new ArrayList();
        localObject5 = paramComposeMailUI.getAddAttachInfoList();
        localObject1 = localObject2;
        if (localObject5 != null)
        {
          localObject1 = localObject2;
          if (((ArrayList)localObject5).size() > 0)
          {
            i = 0;
            for (localObject1 = localObject2;; localObject1 = localObject2)
            {
              if (i >= ((ArrayList)localObject5).size()) {
                break label534;
              }
              localObject7 = (AttachInfo)((ArrayList)localObject5).get(i);
              str = ((AttachInfo)localObject7).getAttachName();
              localObject6 = ((AttachInfo)localObject7).uploadDataPath;
              if (!((AttachInfo)localObject7).isBigAttach()) {
                break;
              }
              localObject2 = localObject1;
              i += 1;
            }
          }
        }
      }
    }
    catch (IOException localIOException)
    {
      ArrayList localArrayList2;
      ArrayList localArrayList1;
      Object localObject7;
      String str;
      Object localObject6;
      do
      {
        do
        {
          for (;;)
          {
            QMLog.log(6, "QMMailProtocolNativeService", "create mime file error:" + localIOException.getMessage());
          }
          localObject2 = localObject1;
        } while (((AttachInfo)localObject7).isEditAttach());
        localObject2 = localObject1;
      } while (StringExtention.isNullOrEmpty((String)localObject6));
      localObject2 = new MailAttachment();
      ((MailAttachment)localObject2).file_name_ = ((String)localObject6);
      if ((((AttachInfo)localObject7).isImage()) && (localIOException.contains(str)))
      {
        localIOException.remove(str);
        if (!localArrayList2.remove(localObject6)) {
          localArrayList2.remove(StringExtention.replaceIllegalUrl((String)localObject6));
        }
        ((MailAttachment)localObject2).type_ = "inlineandattachment";
        localObject7 = StringExtention.filterRegxpllega("file://localhost" + (String)localObject6);
        localObject6 = StringExtention.MD5With32Charactor((String)localObject6);
        localObject1 = ((String)localObject1).replaceAll((String)localObject7, "cid:" + (String)localObject6).replaceAll(StringExtention.filterRegxpllega(StringExtention.replaceIllegalUrl((String)localObject7)), "cid:" + (String)localObject6);
        ((MailAttachment)localObject2).cid_ = ((String)localObject6);
      }
      for (;;)
      {
        localArrayList1.add(localObject2);
        localObject2 = localObject1;
        break;
        ((MailAttachment)localObject2).type_ = "attachment";
      }
      if ((localArrayList2.size() > 0) && (localArrayList2.size() == localIOException.size()))
      {
        i = 0;
        localObject2 = localObject1;
        if (i < localArrayList2.size())
        {
          localObject5 = (String)localArrayList2.get(i);
          if (StringExtention.isNullOrEmpty((String)localObject5)) {}
          for (;;)
          {
            i += 1;
            break;
            localObject6 = new MailAttachment();
            ((MailAttachment)localObject6).type_ = "inline";
            localObject7 = FileUtil.getFileNameSuffix((String)localObject5);
            if ((paramComposeMailUI.getType() != ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLY) && (paramComposeMailUI.getType() != ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLYALL))
            {
              localObject2 = localObject5;
              localObject4 = localObject1;
              if (paramComposeMailUI.getType() != ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_FORWARD) {}
            }
            else
            {
              localObject2 = localObject5;
              localObject4 = localObject1;
              if (!FileUtil.isImageSuffix((String)localObject7))
              {
                localObject2 = (String)localObject5 + "." + FileUtil.getFileType((String)localObject5);
                FileUtil.renameFile((String)localObject5, (String)localObject2);
                paramComposeMailUI.getContent().setBody(paramComposeMailUI.getContent().getBody().replace((CharSequence)localObject5, (CharSequence)localObject2));
                paramComposeMailUI.getContent().setOrigin(paramComposeMailUI.getContent().getOrigin().replace((CharSequence)localObject5, (CharSequence)localObject2));
                localObject4 = ((String)localObject1).replace((CharSequence)localObject5, (CharSequence)localObject2);
              }
            }
            localObject1 = StringExtention.filterRegxpllega("file://localhost" + (String)localObject2);
            localObject5 = StringExtention.MD5With32Charactor((String)localObject2);
            localObject1 = ((String)localObject4).replaceAll((String)localObject1, "cid:" + (String)localObject5).replaceAll(StringExtention.filterRegxpllega(StringExtention.replaceIllegalUrl((String)localObject1)), "cid:" + (String)localObject5);
            ((MailAttachment)localObject6).file_name_ = StringExtention.replaceBackIllegalUrl((String)localObject2);
            ((MailAttachment)localObject6).cid_ = ((String)localObject5);
            localArrayList1.add(localObject6);
          }
        }
      }
      else
      {
        localObject2 = localObject1;
      }
      localObject1 = localObject2;
      if (localArrayList1.size() > 0)
      {
        localMail.attachment_set_ = ((MailAttachment[])localArrayList1.toArray(new MailAttachment[0]));
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (paramComposeMailUI.getAddAttachInfoList() != null)
      {
        localObject2 = new ArrayList();
        localObject4 = new ArrayList();
        i = j;
        if (i < paramComposeMailUI.getAddAttachInfoList().size())
        {
          localObject5 = (AttachInfo)paramComposeMailUI.getAddAttachInfoList().get(i);
          if (((AttachInfo)localObject5).isBigAttach())
          {
            ((Attach)((AttachInfo)localObject5).getAttach()).setSize(((AttachInfo)localObject5).getAttachSize());
            ((ArrayList)localObject2).add(((AttachInfo)localObject5).getAttach());
          }
          for (;;)
          {
            i += 1;
            break;
            if (((AttachInfo)localObject5).isEditAttach())
            {
              ((Attach)((AttachInfo)localObject5).getAttach()).setSize(((AttachInfo)localObject5).getAttachSize());
              ((ArrayList)localObject4).add(((AttachInfo)localObject5).getAttach());
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
        if (((ArrayList)localObject4).size() > 0)
        {
          localObject1 = SendMailHelper.formatEditAttaches((ArrayList)localObject4);
          localObject2 = paramComposeMailUI + (String)localObject1;
        }
      }
      localMail.content = ((String)localObject2);
      return localMail;
      localObject1 = localObject2;
    }
  }
  
  private com.tencent.qqmail.protocol.Mail parseProtocolMail(com.tencent.qqmail.model.qmdomain.Mail paramMail)
  {
    com.tencent.qqmail.protocol.Mail localMail = new com.tencent.qqmail.protocol.Mail();
    Object localObject1 = paramMail.getContent().getBody();
    parseProtocolMailInfo(localMail, paramMail.getInformation());
    localMail.receivedUtc = paramMail.getInformation().getDate().getTime();
    Object localObject2 = FileUtil.getComposeCachePath() + paramMail.getInformation().getRemoteId() + ".mime";
    Object localObject3 = new File((String)localObject2);
    try
    {
      ((File)localObject3).createNewFile();
      localMail.uploadFilePath = ((String)localObject2);
      localObject2 = FileUtil.getExternalQQMailDirPath();
      localObject2 = ((String)localObject1).replaceAll("file:/" + (String)localObject2, "file://localhost" + (String)localObject2);
      localObject3 = new ArrayList();
      localObject4 = new ArrayList();
      localObject5 = paramMail.getInformation().getAttachList();
      if (!SendMailHelper.calculateInlineImgs((String)localObject2, (ArrayList)localObject3, (ArrayList)localObject4))
      {
        localObject1 = localObject2;
        if (localObject5 != null)
        {
          localObject1 = localObject2;
          if (((ArrayList)localObject5).size() <= 0) {}
        }
      }
      else
      {
        localArrayList2 = new ArrayList();
        localObject1 = localObject2;
        if (localObject5 != null)
        {
          localObject1 = localObject2;
          if (((ArrayList)localObject5).size() > 0)
          {
            i = 0;
            localObject1 = localObject2;
            for (;;)
            {
              if (i >= ((ArrayList)localObject5).size()) {
                break label526;
              }
              localObject6 = (Attach)((ArrayList)localObject5).get(i);
              str2 = ((Attach)localObject6).getName();
              str1 = ((Attach)localObject6).getPreview().getMyDisk();
              if (!StringExtention.isNullOrEmpty(str1)) {
                break;
              }
              i += 1;
            }
          }
        }
      }
    }
    catch (IOException localIOException)
    {
      Object localObject4;
      Object localObject5;
      ArrayList localArrayList2;
      int i;
      Object localObject6;
      String str2;
      String str1;
      for (;;)
      {
        QMLog.log(6, "QMMailProtocolNativeService", "create mime file error:" + localIOException.getMessage());
      }
      localObject2 = new MailAttachment();
      ((MailAttachment)localObject2).file_name_ = str1;
      if ((((Attach)localObject6).isInline()) && (((ArrayList)localObject4).contains(str2)))
      {
        ((ArrayList)localObject4).remove(str2);
        if (!localIOException.remove(str1)) {
          localIOException.remove(StringExtention.replaceIllegalUrl(str1));
        }
        ((MailAttachment)localObject2).type_ = "inlineandattachment";
        localObject6 = StringExtention.filterRegxpllega("file://localhost" + str1);
        str1 = StringExtention.MD5With32Charactor(str1);
        localObject1 = ((String)localObject1).replaceAll((String)localObject6, "cid:" + str1).replaceAll(StringExtention.filterRegxpllega(StringExtention.replaceIllegalUrl((String)localObject6)), "cid:" + str1);
        ((MailAttachment)localObject2).cid_ = str1;
      }
      for (;;)
      {
        localArrayList2.add(localObject2);
        break;
        ((MailAttachment)localObject2).type_ = "attachment";
      }
      label526:
      if ((localIOException.size() > 0) && (localIOException.size() == ((ArrayList)localObject4).size()))
      {
        i = 0;
        localObject2 = localObject1;
        if (i < localIOException.size())
        {
          localObject2 = (String)localIOException.get(i);
          if (StringExtention.isNullOrEmpty((String)localObject2)) {}
          for (;;)
          {
            i += 1;
            break;
            localObject4 = new MailAttachment();
            ((MailAttachment)localObject4).type_ = "inline";
            str1 = StringExtention.filterRegxpllega("file://localhost" + (String)localObject2);
            localObject5 = StringExtention.MD5With32Charactor((String)localObject2);
            localObject1 = ((String)localObject1).replaceAll(str1, "cid:" + (String)localObject5).replaceAll(StringExtention.filterRegxpllega(StringExtention.replaceIllegalUrl(str1)), "cid:" + (String)localObject5);
            ((MailAttachment)localObject4).file_name_ = StringExtention.replaceBackIllegalUrl((String)localObject2);
            ((MailAttachment)localObject4).cid_ = ((String)localObject5);
            localArrayList2.add(localObject4);
          }
        }
      }
      else
      {
        localObject2 = localObject1;
      }
      if (localArrayList2.size() > 0) {
        localMail.attachment_set_ = ((MailAttachment[])localArrayList2.toArray(new MailAttachment[0]));
      }
      localObject1 = localObject2;
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
      localMail.content = ((String)localObject1);
    }
    return localMail;
  }
  
  private void parseProtocolMailInfo(com.tencent.qqmail.protocol.Mail paramMail, MailInformation paramMailInformation)
  {
    if ((paramMail != null) && (paramMailInformation != null))
    {
      paramMail.messageId = paramMailInformation.getMessageId();
      Object localObject1 = paramMailInformation.getReferences();
      if ((localObject1 != null) && (!((String)localObject1).equals(""))) {
        paramMail.references = ((String)localObject1);
      }
      localObject1 = paramMailInformation.getToList();
      Object localObject2 = new StringBuilder();
      int i;
      MailContact localMailContact;
      if (localObject1 != null)
      {
        i = 0;
        while (i < ((ArrayList)localObject1).size())
        {
          localMailContact = (MailContact)((ArrayList)localObject1).get(i);
          ((StringBuilder)localObject2).append(String.format("\"%s\"<%s>;", new Object[] { StringExtention.safeNickName(localMailContact.getNick()), localMailContact.getAddress() }));
          i += 1;
        }
      }
      paramMail.to = ((StringBuilder)localObject2).toString();
      localObject1 = paramMailInformation.getCcList();
      localObject2 = new StringBuilder();
      if (localObject1 != null)
      {
        i = 0;
        while (i < ((ArrayList)localObject1).size())
        {
          localMailContact = (MailContact)((ArrayList)localObject1).get(i);
          ((StringBuilder)localObject2).append(String.format("\"%s\"<%s>;", new Object[] { StringExtention.safeNickName(localMailContact.getNick()), localMailContact.getAddress() }));
          i += 1;
        }
      }
      paramMail.cc = ((StringBuilder)localObject2).toString();
      localObject1 = paramMailInformation.getBccList();
      localObject2 = new StringBuilder();
      if (localObject1 != null)
      {
        i = 0;
        while (i < ((ArrayList)localObject1).size())
        {
          localMailContact = (MailContact)((ArrayList)localObject1).get(i);
          ((StringBuilder)localObject2).append(String.format("\"%s\"<%s>;", new Object[] { StringExtention.safeNickName(localMailContact.getNick()), localMailContact.getAddress() }));
          i += 1;
        }
      }
      paramMail.bcc = ((StringBuilder)localObject2).toString();
      localObject2 = SendMailHelper.getSenderEmailAndNick(paramMailInformation);
      localObject1 = localObject2[0];
      localObject2 = localObject2[1];
      paramMail.sender = ((String)localObject2);
      paramMail.fromEmail = ((String)localObject1);
      paramMail.fromNick = ((String)localObject2);
      paramMail.subject = paramMailInformation.getSubject();
      paramMail.accountId = paramMailInformation.getAccountId();
    }
  }
  
  private QMFolder parseUserFolder(int paramInt1, int paramInt2, Mail.Folder paramFolder)
  {
    QMFolder localQMFolder = new QMFolder();
    if (paramFolder == null) {
      return localQMFolder;
    }
    localQMFolder.setId(QMFolder.generateId(paramInt1, paramFolder.name, false));
    localQMFolder.setAccountId(paramInt1);
    localQMFolder.setRemoteId(paramFolder.name);
    localQMFolder.setName(paramFolder.showname);
    localQMFolder.setParentName(paramFolder.parentname);
    localQMFolder.setTop(paramFolder.isTop);
    localQMFolder.setVirtual(paramFolder.isVirtual);
    localQMFolder.setType(0);
    switch (paramInt2)
    {
    case 1: 
    case 2: 
    default: 
      return localQMFolder;
    }
    for (;;)
    {
      localQMFolder.setSvrCount(paramFolder.totalCnt);
      return localQMFolder;
      localQMFolder.setSyncKey(paramFolder.svrKey);
      localQMFolder.setSyncState(paramFolder.syncStatus);
    }
  }
  
  private com.tencent.qqmail.model.qmdomain.Mail processMail(com.tencent.qqmail.protocol.Mail paramMail, int paramInt)
  {
    boolean bool = false;
    com.tencent.qqmail.model.qmdomain.Mail localMail = new com.tencent.qqmail.model.qmdomain.Mail();
    Object localObject = new MailContact();
    ((MailContact)localObject).setName(paramMail.fromNick);
    ((MailContact)localObject).setNick(paramMail.fromNick);
    ((MailContact)localObject).setAddress(paramMail.fromEmail);
    MailInformation localMailInformation = new MailInformation();
    localMailInformation.setId(paramMail.mailId);
    localMailInformation.setSubject(paramMail.subject);
    localMailInformation.setAbstractContent(paramMail.abstract_mail.substring(0, Math.min(200, paramMail.abstract_mail.length())));
    localMailInformation.setFrom((MailContact)localObject);
    localMailInformation.setToList(ContactsHelper.parseAddrs(paramMail.to));
    localMailInformation.setCcList(ContactsHelper.parseAddrs(paramMail.cc));
    localMailInformation.setBccList(ContactsHelper.parseAddrs(paramMail.bcc));
    localMailInformation.setDate(new Date(paramMail.receivedUtc * 1000L));
    localMailInformation.setRemoteId(paramMail.remoteId);
    localMailInformation.setFolderId(paramMail.folderId);
    localMailInformation.setAccountId(paramMail.accountId);
    localMailInformation.setReferences(paramMail.references);
    localMailInformation.setMessageId(paramMail.messageId);
    localMailInformation.setSvrKey(paramMail.runTimeMailServerKey);
    localMailInformation.setSize(paramMail.size);
    localMailInformation.setAttachList(parseAttachList(paramMail, paramInt));
    localMailInformation.setBodyStructureInfos(paramMail.body_structure_helper_.body_struture_info_);
    localObject = new MailStatus();
    if (!paramMail.isRead) {
      bool = true;
    }
    ((MailStatus)localObject).setUnread(bool);
    ((MailStatus)localObject).setStarred(paramMail.isStar);
    ((MailStatus)localObject).setProtocolMail(true);
    ((MailStatus)localObject).setHasAttach(paramMail.hasAttach);
    ((MailStatus)localObject).setContentComplete(paramMail.isContentCompleted);
    MailContent localMailContent = new MailContent();
    localMailContent.setBody(paramMail.content);
    localMailContent.setBodyText(MailUtil.getMailAbstract(paramMail.content));
    localMail.setInformation(localMailInformation);
    localMail.setStatus((MailStatus)localObject);
    localMail.setContent(localMailContent);
    return localMail;
  }
  
  private String renameFileToDest(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    paramString2 = DownloadUtil.fileCopyTo(paramString1, paramString2, paramString3);
    if (!StringExtention.isNullOrEmpty(paramString2))
    {
      paramBoolean = FileUtil.delFile(paramString1);
      QMLog.log(4, "QMMailProtocolNativeService", "copy attach from:" + paramString1 + " to:" + paramString2 + " success and delete:" + paramBoolean);
      paramString1 = paramString2;
    }
    do
    {
      return paramString1;
      QMLog.log(6, "QMMailProtocolNativeService", "copy attach from:" + paramString1 + " to:" + paramString2 + " fail");
    } while (paramBoolean);
    return "";
  }
  
  private void reportNativeLoginImmediately(Profile paramProfile, String paramString1, boolean paramBoolean, int paramInt, String paramString2)
  {
    String str2 = "UNKNOWN";
    String str1 = "";
    switch (paramProfile.protocolType)
    {
    }
    for (;;)
    {
      QMLog.log(4, "QMMailProtocolNativeService", "report native " + paramString1 + " " + paramProfile.mailAddress + ", " + str2 + ", isSuccess:" + paramBoolean + ", code:" + paramInt + ", error:" + paramString2);
      if (!paramBoolean) {
        break;
      }
      OssHelper.protocolMailLogin(new Object[] { paramProfile.mailAddress, str2, paramString1, Integer.valueOf(1), Integer.valueOf(1) });
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
    OssHelper.protocolMailLogin(new Object[] { paramProfile.mailAddress, str2, paramString1, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt), paramString2, str1 });
  }
  
  private void reportNativeProtocolApi(Profile paramProfile, String paramString, boolean paramBoolean)
  {
    int j = 0;
    Object localObject2 = "UNKNOWN";
    Object localObject1 = localObject2;
    switch (paramProfile.protocolType)
    {
    default: 
      localObject1 = localObject2;
    case 2: 
      localObject2 = new StringBuilder().append("report native ").append(paramString).append(" ").append(paramProfile.mailAddress).append(" ").append((String)localObject1).append(" ");
      if (!paramBoolean) {
        break;
      }
    }
    for (int i = 1;; i = 0)
    {
      QMLog.log(4, "QMMailProtocolNativeService", i);
      paramProfile = paramProfile.mailAddress;
      i = j;
      if (paramBoolean) {
        i = 1;
      }
      OssHelper.protocolMail(new Object[] { paramProfile, localObject1, paramString, Integer.valueOf(i), Integer.valueOf(1) });
      return;
      localObject1 = "IMAP";
      break;
      localObject1 = "POP";
      break;
      localObject1 = "ACTIVESYNC";
      break;
      localObject1 = "EXCHANGE";
      break;
    }
  }
  
  public void addFolder(Account paramAccount, QMFolder paramQMFolder, FolderOperationCallback paramFolderOperationCallback)
  {
    int i = paramAccount.getId();
    paramAccount = paramAccount.getProfile();
    int j = paramAccount.protocolType;
    Mail.Folder localFolder1 = new Mail.Folder();
    localFolder1.isTop = true;
    localFolder1.remoteId = paramQMFolder.getParentName();
    localFolder1.name = paramQMFolder.getParentName();
    localFolder1.showname = paramQMFolder.getParentName();
    localFolder1.accountId = i;
    Mail.Folder localFolder2 = new Mail.Folder();
    localFolder2.isTop = true;
    localFolder2.folderId = paramQMFolder.getId();
    localFolder2.remoteId = paramQMFolder.getRemoteId();
    localFolder2.name = paramQMFolder.getName();
    localFolder2.showname = paramQMFolder.getName();
    localFolder2.parentname = paramQMFolder.getParentName();
    localFolder2.accountId = i;
    ReceiveState localReceiveState = new ReceiveState();
    localReceiveState.accountId = i;
    ProtocolService.addFolder(paramAccount, localReceiveState, localFolder1, localFolder2, new QMMailProtocolNativeService.11(this, i, paramQMFolder, j, paramFolderOperationCallback, paramAccount));
  }
  
  public void addRule(Account paramAccount, Exchange.ExchangeRule[] paramArrayOfExchangeRule)
  {
    ProtocolService.AddRule(paramAccount.getProfile(), paramArrayOfExchangeRule, new QMMailProtocolNativeService.31(this));
  }
  
  public void appendMailToServer(Account paramAccount, QMFolder paramQMFolder, com.tencent.qqmail.model.qmdomain.Mail paramMail, MailManagerDelegate paramMailManagerDelegate)
  {
    paramAccount = paramAccount.getProfile();
    if (paramQMFolder != null)
    {
      Mail.Folder localFolder = new Mail.Folder();
      localFolder.folderId = paramQMFolder.getId();
      localFolder.remoteId = paramQMFolder.getRemoteId();
      localFolder.name = paramQMFolder.getRemoteId();
      localFolder.accountId = paramQMFolder.getAccountId();
      ProtocolService.syncMailToServer(paramAccount, parseProtocolMail(paramMail), localFolder, new QMMailProtocolNativeService.22(this, paramMailManagerDelegate, paramAccount));
    }
  }
  
  public void downloadAttach(MailInformation paramMailInformation, Attach paramAttach, boolean paramBoolean, LoadMailAttachCallBack paramLoadMailAttachCallBack)
  {
    MailAttachment localMailAttachment = new MailAttachment();
    localMailAttachment.file_name_ = paramAttach.getName();
    localMailAttachment.display_name_ = paramAttach.getDisplayName();
    localMailAttachment.mailId_ = paramAttach.getProtocol().getMailId();
    localMailAttachment.attachment_id_ = paramAttach.getProtocol().getAttachId();
    localMailAttachment.file_exist_ = paramAttach.getProtocol().getIsexist();
    localMailAttachment.file_size_ = paramAttach.getBytes();
    localMailAttachment.file_download_size_ = paramAttach.getState().getDownloadSizeByte();
    localMailAttachment.type_ = paramAttach.getProtocol().getType();
    localMailAttachment.data_ = paramAttach.getProtocol().getData();
    localMailAttachment.cid_ = paramAttach.getProtocol().getCid();
    localMailAttachment.exchange_file_uid_ = paramAttach.getProtocol().getExchangeFileUid();
    localMailAttachment.file_content_type_ = paramAttach.getProtocol().getFileContentType();
    if ((paramAttach.getProtocol().getProtocolType() == 1) && (paramAttach.getProtocol().getBodyInfo() != null))
    {
      if (localMailAttachment.body_structure_helper_ == null)
      {
        localMailAttachment.body_structure_helper_ = new ItemBodyStructureHelper();
        localMailAttachment.body_structure_helper_.body_struture_info_ = new ItemBodyStructureHelper.MailItemBodyStructureInfo[1];
      }
      localObject = new ItemBodyStructureHelper.MailItemBodyStructureInfo();
      ((ItemBodyStructureHelper.MailItemBodyStructureInfo)localObject).mailId_ = paramAttach.getProtocol().getBodyInfo().mailId;
      ((ItemBodyStructureHelper.MailItemBodyStructureInfo)localObject).attachId_ = paramAttach.getProtocol().getBodyInfo().attachId;
      ((ItemBodyStructureHelper.MailItemBodyStructureInfo)localObject).id_ = paramAttach.getProtocol().getBodyInfo().id;
      ((ItemBodyStructureHelper.MailItemBodyStructureInfo)localObject).itemid_ = paramAttach.getProtocol().getBodyInfo().itemId;
      ((ItemBodyStructureHelper.MailItemBodyStructureInfo)localObject).item_type_ = paramAttach.getProtocol().getBodyInfo().itemType;
      ((ItemBodyStructureHelper.MailItemBodyStructureInfo)localObject).body_id_ = paramAttach.getProtocol().getBodyInfo().bodyId;
      ((ItemBodyStructureHelper.MailItemBodyStructureInfo)localObject).content_type_ = paramAttach.getProtocol().getBodyInfo().contentType;
      ((ItemBodyStructureHelper.MailItemBodyStructureInfo)localObject).content_subtype_ = paramAttach.getProtocol().getBodyInfo().contentSubType;
      ((ItemBodyStructureHelper.MailItemBodyStructureInfo)localObject).content_type_params_ = paramAttach.getProtocol().getBodyInfo().contentTypeParams;
      ((ItemBodyStructureHelper.MailItemBodyStructureInfo)localObject).content_description_ = paramAttach.getProtocol().getBodyInfo().contentDescription;
      ((ItemBodyStructureHelper.MailItemBodyStructureInfo)localObject).content_transfer_encoding_ = paramAttach.getProtocol().getBodyInfo().transferEncoding;
      ((ItemBodyStructureHelper.MailItemBodyStructureInfo)localObject).content_line_size_ = paramAttach.getProtocol().getBodyInfo().contentLineSize;
      ((ItemBodyStructureHelper.MailItemBodyStructureInfo)localObject).content_disposition_ = paramAttach.getProtocol().getBodyInfo().contentDisposition;
      localMailAttachment.body_structure_helper_.body_struture_info_[0] = localObject;
    }
    boolean bool = localMailAttachment.type_.equals("inline");
    Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(paramMailInformation.getAccountId());
    Profile localProfile = ((Account)localObject).getProfile();
    QMFolder localQMFolder = QMFolderManager.sharedInstance().getFolder(paramMailInformation.getFolderId());
    long l = paramAttach.getHashId();
    String str2 = localMailAttachment.cid_;
    int i = ((Account)localObject).getId();
    localObject = new com.tencent.qqmail.protocol.Mail();
    ((com.tencent.qqmail.protocol.Mail)localObject).mailId = paramMailInformation.getId();
    ((com.tencent.qqmail.protocol.Mail)localObject).messageId = paramMailInformation.getMessageId();
    ((com.tencent.qqmail.protocol.Mail)localObject).remoteId = paramMailInformation.getRemoteId();
    ((com.tencent.qqmail.protocol.Mail)localObject).folderName = localQMFolder.getRemoteId();
    ((com.tencent.qqmail.protocol.Mail)localObject).attachment_set_ = new MailAttachment[] { localMailAttachment };
    if (bool)
    {
      if (!QMAttachManager.sharedInstance().isMailInlineImageCached(str2)) {
        break label829;
      }
      paramMailInformation = QMAttachManager.sharedInstance().getInlineImageDisk(str2);
      QMLog.log(4, "QMMailProtocolNativeService", "downloadAttach inline img downloaded:" + str2 + ", path:" + paramMailInformation);
      if (paramLoadMailAttachCallBack != null) {
        paramLoadMailAttachCallBack.onSuccess(paramMailInformation, QMAttachManager.sharedInstance().getAttach(l));
      }
    }
    do
    {
      String str1;
      do
      {
        return;
        if ((paramAttach.getProtocol().getProtocolType() != 1) || (paramAttach.getPreview().getCopyDiskList().size() <= 0)) {
          break label829;
        }
        str1 = (String)paramAttach.getPreview().getCopyDiskList().get(0);
        if (!FileUtil.isFileExist(str1)) {
          break label829;
        }
        paramAttach = paramAttach.getPreview().getMyDisk();
        QMLog.log(4, "QMMailProtocolNativeService", "imap attach exist:" + str1 + ", to:" + paramAttach);
        paramMailInformation = paramAttach;
        if (StringExtention.isNullOrEmpty(paramAttach)) {
          paramMailInformation = FileUtil.getAttachDownloadDir();
        }
        paramMailInformation = renameFileToDest(str1, paramMailInformation, localObject.attachment_set_[0].file_name_, false);
        if (!StringExtention.isNullOrEmpty(paramMailInformation)) {
          break;
        }
        paramMailInformation = new QMProtocolError(1);
      } while (paramLoadMailAttachCallBack == null);
      paramLoadMailAttachCallBack.onError(paramMailInformation);
      return;
      if (paramBoolean) {
        QMAttachManager.sharedInstance().updateAttachDisk(l, localObject.attachment_set_[0].file_name_, paramMailInformation, str1, 0);
      }
      paramAttach = QMAttachManager.sharedInstance().getAttach(l);
    } while (paramLoadMailAttachCallBack == null);
    paramLoadMailAttachCallBack.onSuccess(paramMailInformation, paramAttach);
    return;
    label829:
    ProtocolService.downloadAttachment(localProfile, localQMFolder.getRemoteId(), (com.tencent.qqmail.protocol.Mail)localObject, localMailAttachment, new QMMailProtocolNativeService.29(this, paramLoadMailAttachCallBack, bool, str2, paramAttach, paramBoolean, l, localProfile, i));
  }
  
  public void downloadMailAbstract(Account paramAccount, QMFolder paramQMFolder, ArrayList<com.tencent.qqmail.model.qmdomain.Mail> paramArrayList, LoadMailAbstractCallback paramLoadMailAbstractCallback)
  {
    Profile localProfile = paramAccount.getProfile();
    int j = localProfile.protocolType;
    int k = loadMailStrategy(j, false);
    com.tencent.qqmail.protocol.Mail[] arrayOfMail = new com.tencent.qqmail.protocol.Mail[paramArrayList.size()];
    int i = 0;
    if (i < paramArrayList.size())
    {
      Object localObject = (com.tencent.qqmail.model.qmdomain.Mail)paramArrayList.get(i);
      MailInformation localMailInformation = ((com.tencent.qqmail.model.qmdomain.Mail)localObject).getInformation();
      com.tencent.qqmail.protocol.Mail localMail = new com.tencent.qqmail.protocol.Mail();
      localMail.mailId = localMailInformation.getId();
      localMail.messageId = localMailInformation.getMessageId();
      localMail.remoteId = localMailInformation.getRemoteId();
      localMail.size = localMailInformation.getSize();
      localMail.folderName = paramQMFolder.getRemoteId();
      localMail.folderId = paramQMFolder.getId();
      localMail.attachment_set_ = new MailAttachment[0];
      if (((com.tencent.qqmail.model.qmdomain.Mail)localObject).getStatus().isAdConv()) {
        localMail.mailAdType = 1L;
      }
      for (;;)
      {
        if (j == 1)
        {
          localObject = QMMailManager.sharedInstance().readMailPartInfo(((com.tencent.qqmail.model.qmdomain.Mail)localObject).getInformation().getId());
          if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
          {
            localMail.body_structure_helper_ = new ItemBodyStructureHelper();
            localMail.body_structure_helper_.body_struture_info_ = new ItemBodyStructureHelper.MailItemBodyStructureInfo[((ArrayList)localObject).size()];
            localMail.body_structure_helper_.body_struture_info_ = ((ItemBodyStructureHelper.MailItemBodyStructureInfo[])((ArrayList)localObject).toArray(localMail.body_structure_helper_.body_struture_info_));
          }
        }
        arrayOfMail[i] = localMail;
        i += 1;
        break;
        if (((com.tencent.qqmail.model.qmdomain.Mail)localObject).getStatus().isConversationChild()) {
          localMail.mailAdType = -1L;
        } else {
          localMail.mailAdType = 0L;
        }
      }
    }
    if (paramLoadMailAbstractCallback != null) {
      paramLoadMailAbstractCallback.loadAbstractProcess();
    }
    ProtocolService.downloadMailsText(localProfile, paramQMFolder.getRemoteId(), k, paramQMFolder.getId(), false, arrayOfMail, new QMMailProtocolNativeService.28(this, paramLoadMailAbstractCallback, j, paramAccount, paramQMFolder, localProfile));
  }
  
  public void downloadMailText(Account paramAccount, QMFolder paramQMFolder, com.tencent.qqmail.model.qmdomain.Mail paramMail, boolean paramBoolean1, boolean paramBoolean2, LoadMailCallback paramLoadMailCallback)
  {
    Profile localProfile = paramAccount.getProfile();
    if ((paramAccount.isGMail()) && (LoginManager.shareInstance().isGMailAccessTokenExpire(paramAccount.getId())))
    {
      LoginManager.shareInstance().refreshGmailAccessToken(paramAccount.getId(), paramAccount.getRefreshToken(), new QMMailProtocolNativeService.26(this, paramQMFolder, paramMail, paramBoolean1, paramBoolean2, paramLoadMailCallback));
      return;
    }
    int i = paramAccount.getId();
    int j = localProfile.protocolType;
    int k = loadMailStrategy(j, paramBoolean1);
    double d = paramMail.getInformation().getSize();
    com.tencent.qqmail.protocol.Mail localMail = new com.tencent.qqmail.protocol.Mail();
    localMail.accountId = i;
    localMail.folderId = paramQMFolder.getId();
    localMail.folderName = paramQMFolder.getRemoteId();
    localMail.mailId = paramMail.getInformation().getId();
    localMail.messageId = paramMail.getInformation().getMessageId();
    localMail.remoteId = paramMail.getInformation().getRemoteId();
    localMail.size = paramMail.getInformation().getSize();
    localMail.attachment_set_ = new MailAttachment[0];
    localMail.isSearchMail = paramBoolean2;
    if (j == 1)
    {
      localObject = QMMailManager.sharedInstance().readMailPartInfo(paramMail.getInformation().getId());
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
      {
        localMail.body_structure_helper_ = new ItemBodyStructureHelper();
        localMail.body_structure_helper_.body_struture_info_ = new ItemBodyStructureHelper.MailItemBodyStructureInfo[((ArrayList)localObject).size()];
        localMail.body_structure_helper_.body_struture_info_ = ((ItemBodyStructureHelper.MailItemBodyStructureInfo[])((ArrayList)localObject).toArray(localMail.body_structure_helper_.body_struture_info_));
      }
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("section", "-1");
    localHashMap.put("already_download_size", Integer.valueOf(0));
    localHashMap.put("download_size_in_section", Integer.valueOf(0));
    if (paramLoadMailCallback != null) {
      paramLoadMailCallback.loadMailProcess();
    }
    Object localObject = paramQMFolder.getRemoteId();
    int m = localMail.folderId;
    paramAccount = new QMMailProtocolNativeService.27(this, j, i, paramLoadMailCallback, localProfile, paramAccount, paramQMFolder, paramMail, paramBoolean1, paramBoolean2, localHashMap, localMail, d);
    ProtocolService.downloadMailsText(localProfile, (String)localObject, k, m, false, new com.tencent.qqmail.protocol.Mail[] { localMail }, paramAccount);
  }
  
  public void feedbackMail(ComposeMailUI paramComposeMailUI, String paramString1, String paramString2, String paramString3, int paramInt, QMGeneralCallback paramQMGeneralCallback)
  {
    paramComposeMailUI = parseProtocolComposeMail(paramComposeMailUI);
    Profile localProfile = new Profile();
    localProfile.smtpName = paramString1;
    localProfile.smtpPassword = paramString2;
    localProfile.smtpPort = paramInt;
    localProfile.smtpServer = paramString3;
    localProfile.mailAddress = "";
    localProfile.usingSSL = false;
    ProtocolService.sendMail(localProfile, paramComposeMailUI, new QMMailProtocolNativeService.23(this, paramQMGeneralCallback));
  }
  
  public void fetchFolderList(Account paramAccount, FolderListCallback paramFolderListCallback)
  {
    int i = paramAccount.getId();
    Profile localProfile = paramAccount.getProfile();
    int j = localProfile.protocolType;
    if ((paramAccount.isGMail()) && (LoginManager.shareInstance().isGMailAccessTokenExpire(paramAccount.getId())))
    {
      LoginManager.shareInstance().refreshGmailAccessToken(paramAccount.getId(), paramAccount.getRefreshToken(), new QMMailProtocolNativeService.9(this, paramFolderListCallback));
      return;
    }
    ProtocolService.fetchFolderList(localProfile, i, false, 0, new QMMailProtocolNativeService.10(this, i, j, paramFolderListCallback, localProfile, paramAccount));
  }
  
  public void fetchMailList(Account paramAccount, QMFolder paramQMFolder, ArrayList<String> paramArrayList, boolean paramBoolean, MailListCallback paramMailListCallback)
  {
    Profile localProfile = paramAccount.getProfile();
    if ((paramAccount.isGMail()) && (LoginManager.shareInstance().isGMailAccessTokenExpire(paramAccount.getId())))
    {
      LoginManager.shareInstance().refreshGmailAccessToken(paramAccount.getId(), paramAccount.getRefreshToken(), new QMMailProtocolNativeService.14(this, paramQMFolder, paramArrayList, paramBoolean, paramMailListCallback));
      return;
    }
    int j = localProfile.protocolType;
    int k = paramAccount.getId();
    int i = paramQMFolder.getId();
    String str = paramQMFolder.getRemoteId();
    ReceiveState localReceiveState = new ReceiveState();
    localReceiveState.recv_new_only_ = paramBoolean;
    localReceiveState.folderId = i;
    localReceiveState.accountId = k;
    localReceiveState.check_repeat_ = false;
    localReceiveState.receive_head_only_ = true;
    localReceiveState.folderName = str;
    localReceiveState.recv_limited_count_ = true;
    if (paramBoolean) {}
    HashMap localHashMap;
    Object localObject;
    for (i = 20;; i = 40)
    {
      localReceiveState.receive_mail_count_of_load_more_ = i;
      localReceiveState.count_of_sync = 50;
      localHashMap = new HashMap();
      localObject = paramArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        localHashMap.put((String)((Iterator)localObject).next(), Boolean.valueOf(true));
      }
    }
    if (localProfile.protocolType == 3)
    {
      localObject = new ProtocolFolder();
      ((ProtocolFolder)localObject).title_ = str;
      ((ProtocolFolder)localObject).path_ = str;
      ((ProtocolFolder)localObject).sync_state_ = paramQMFolder.getSyncState();
      ((ProtocolFolder)localObject).server_key = paramQMFolder.getSyncKey();
      localReceiveState.exchange_folder_list_ = new ProtocolFolder[] { localObject };
      localReceiveState.exist_map_ = localHashMap;
    }
    for (;;)
    {
      if (paramMailListCallback != null) {
        paramMailListCallback.process();
      }
      paramAccount = new QMMailProtocolNativeService.15(this, j, paramMailListCallback, localProfile, k, paramAccount, paramQMFolder, paramArrayList, paramBoolean);
      ProtocolService.fetchMailList(localProfile, new String[] { str }, localReceiveState, paramAccount);
      return;
      if (localProfile.protocolType == 4)
      {
        localObject = new ProtocolFolder();
        ((ProtocolFolder)localObject).sync_state_ = "0";
        ((ProtocolFolder)localObject).title_ = str;
        ((ProtocolFolder)localObject).path_ = str;
        localReceiveState.exchange_folder_list_ = new ProtocolFolder[] { localObject };
        localReceiveState.recv_new_only_ = true;
        localReceiveState.exist_map_ = localHashMap;
        localReceiveState.active_sync_filter_type = QMSyncManager.sharedInstance().getActiveSyncAccFilterType(k);
      }
      else if (localProfile.protocolType == 0)
      {
        localObject = FileUtil.getPopUidsPath() + k + "_popRemoteIds.plist";
        FileUtil.createFile((String)localObject);
        localReceiveState.localDocumentPath = ((String)localObject);
        localObject = QMMailManager.sharedInstance().getPurgedPopMailIds(k).iterator();
        while (((Iterator)localObject).hasNext()) {
          localHashMap.put(((String)((Iterator)localObject).next()).trim(), Boolean.valueOf(true));
        }
        localReceiveState.exist_map_ = localHashMap;
      }
      else if (localProfile.protocolType == 1)
      {
        localReceiveState.received_uid_exist_map_ = new HashMap();
        localReceiveState.received_uid_exist_map_.put(str, localHashMap);
      }
    }
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
      initFolderListSyncKeyMapping(AccountManager.shareInstance().getAccountList(true).getFolderListSyncKeyMap());
    }
  }
  
  public void initFolderListSyncKeyMapping(Map<Integer, String> paramMap)
  {
    ProtocolService.InitFolderListSyncKeyMapping(paramMap);
  }
  
  public void initFolderSyncKeyMapping(Map<Integer, String> paramMap)
  {
    ProtocolService.InitSyncKeyMapping(paramMap);
  }
  
  public void initProfile(Profile paramProfile) {}
  
  public void initProtocolService()
  {
    ProtocolService.Init(QMApplicationContext.sharedInstance());
    QMUtilities.reCheckIsART();
    if (QMUtilities.isART()) {
      DataCollector.logEvent("Event_Boot_Art");
    }
    ProtocolService.SetIsART(QMUtilities.isOldART());
    ProtocolService.InitLogger(LogPathManager.getInstance().getQMJNILogFilePath(), 0);
    ProtocolService.SetMobileInfoCallback(new QMMailProtocolNativeService.1(this));
    ProtocolService.SetSyncKeyCallback(new QMMailProtocolNativeService.2(this));
    ProtocolService.SetFolderListSyncKeyCallback(new QMMailProtocolNativeService.3(this));
  }
  
  public void loadTranslateMail(com.tencent.qqmail.model.qmdomain.Mail paramMail, MailManagerDelegate paramMailManagerDelegate)
  {
    long l = paramMail.getInformation().getId();
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(6, "QMMailProtocolNativeService", "loadTranslateMail info null");
      return;
    }
    localCloudProtocolInfo.translate_req_ = new TranslationReq();
    localCloudProtocolInfo.translate_req_.mailcontent = ByteString.copyFromUtf8(paramMail.getContent().getBody());
    localCloudProtocolInfo.translate_req_.subject = ByteString.copyFromUtf8(paramMail.getInformation().getSubject());
    localCloudProtocolInfo.translate_req_.from = ByteString.copyFromUtf8("auto");
    localCloudProtocolInfo.translate_req_.to = ByteString.copyFromUtf8("zh");
    CloudProtocolService.Translate(localCloudProtocolInfo, new QMMailProtocolNativeService.30(this, l, paramMailManagerDelegate));
  }
  
  public void login(Profile paramProfile, LoginCallback paramLoginCallback)
  {
    ProtocolService.login(paramProfile, new QMMailProtocolNativeService.4(this, paramProfile, paramLoginCallback));
  }
  
  public void logout(Profile paramProfile, LogoutCallback paramLogoutCallback)
  {
    if (paramLogoutCallback != null) {
      paramLogoutCallback.onSuccess(paramProfile);
    }
    reportNativeProtocolApi(paramProfile, "Logout", true);
  }
  
  public void moveMails(Account paramAccount, QMFolder paramQMFolder1, QMFolder paramQMFolder2, List<String> paramList1, List<String> paramList2, MailManagerDelegate paramMailManagerDelegate)
  {
    Profile localProfile = paramAccount.getProfile();
    int i = paramAccount.getId();
    ProtocolService.moveMail(localProfile, paramQMFolder1.getRemoteId(), paramQMFolder1.getSyncKey(), paramQMFolder2.getRemoteId(), paramQMFolder2.getSyncKey(), (String[])paramList1.toArray(new String[paramList1.size()]), (String[])paramList2.toArray(new String[paramList2.size()]), new QMMailProtocolNativeService.18(this, paramMailManagerDelegate, localProfile, i));
  }
  
  public void removeFolder(Account paramAccount, QMFolder paramQMFolder, FolderOperationCallback paramFolderOperationCallback)
  {
    int i = paramAccount.getId();
    Profile localProfile = paramAccount.getProfile();
    Mail.Folder localFolder = new Mail.Folder();
    localFolder.isTop = true;
    localFolder.folderId = paramQMFolder.getId();
    localFolder.remoteId = paramQMFolder.getRemoteId();
    localFolder.name = paramQMFolder.getRemoteId();
    localFolder.showname = paramQMFolder.getName();
    localFolder.parentname = paramQMFolder.getParentName();
    localFolder.accountId = i;
    localFolder.svrKey = paramQMFolder.getSyncKey();
    localFolder.syncStatus = paramQMFolder.getSyncState();
    ReceiveState localReceiveState = new ReceiveState();
    localReceiveState.accountId = i;
    ProtocolService.removeFolder(paramAccount.getProfile(), localReceiveState, localFolder, new QMMailProtocolNativeService.13(this, i, paramQMFolder, paramFolderOperationCallback, localProfile));
  }
  
  public void removeFolderListSyncKey(int paramInt)
  {
    ProtocolService.RemoveFolderListSyncKeys(paramInt);
  }
  
  public void removeFolderSyncKey(int[] paramArrayOfInt)
  {
    ProtocolService.RemoveSyncKeys(paramArrayOfInt);
  }
  
  public void removeMails(Account paramAccount, QMFolder paramQMFolder, List<String> paramList1, List<String> paramList2, MailManagerDelegate paramMailManagerDelegate)
  {
    Profile localProfile = paramAccount.getProfile();
    int i = paramAccount.getId();
    paramAccount = paramQMFolder.getRemoteId();
    paramQMFolder = new ReceiveState();
    paramQMFolder.folder_name_ = paramAccount;
    ProtocolService.removeMail(localProfile, paramQMFolder, paramAccount, (String[])paramList1.toArray(new String[paramList1.size()]), (String[])paramList2.toArray(new String[paramList2.size()]), new QMMailProtocolNativeService.19(this, paramMailManagerDelegate, localProfile, i));
  }
  
  public void renameFolder(Account paramAccount, QMFolder paramQMFolder, String paramString, FolderOperationCallback paramFolderOperationCallback)
  {
    int i = paramAccount.getId();
    paramAccount = paramAccount.getProfile();
    int j = paramAccount.protocolType;
    Mail.Folder localFolder1 = new Mail.Folder();
    localFolder1.isTop = true;
    localFolder1.folderId = paramQMFolder.getId();
    localFolder1.remoteId = paramQMFolder.getParentName();
    localFolder1.name = paramQMFolder.getParentName();
    localFolder1.showname = paramQMFolder.getParentName();
    localFolder1.accountId = i;
    Mail.Folder localFolder2 = new Mail.Folder();
    localFolder2.isTop = true;
    localFolder2.folderId = paramQMFolder.getId();
    localFolder2.remoteId = paramQMFolder.getRemoteId();
    localFolder2.name = paramQMFolder.getRemoteId();
    localFolder2.showname = paramQMFolder.getName();
    localFolder2.parentname = paramQMFolder.getParentName();
    localFolder2.accountId = i;
    localFolder2.svrKey = paramQMFolder.getSyncKey();
    localFolder2.syncStatus = paramQMFolder.getSyncState();
    ReceiveState localReceiveState = new ReceiveState();
    localReceiveState.accountId = i;
    ProtocolService.renameFolder(paramAccount, localReceiveState, localFolder1, localFolder2, paramString, new QMMailProtocolNativeService.12(this, i, paramQMFolder, j, paramFolderOperationCallback, paramAccount));
  }
  
  public void saveActiveSync(int paramInt, ProtocolResult paramProtocolResult)
  {
    if ((paramProtocolResult != null) && (paramProtocolResult.protocol_info_list_ != null) && (paramProtocolResult.protocol_info_list_.length > 0))
    {
      MailAccount localMailAccount = (MailAccount)AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
      if (localMailAccount != null)
      {
        int i = 0;
        while (i < paramProtocolResult.protocol_info_list_.length)
        {
          ProtocolInfo localProtocolInfo = paramProtocolResult.protocol_info_list_[i];
          if (localProtocolInfo.type_ == 4)
          {
            localMailAccount.updateActiveSyncProfile(localProtocolInfo.activesync_version_, localProtocolInfo.activesync_policykey_);
            if ((paramProtocolResult.exchange_content_ != null) && (paramProtocolResult.exchange_content_.activesync_updateaccount_))
            {
              Profile localProfile = localMailAccount.getProfile();
              localProfile.activeSyncDomain = localProtocolInfo.server_domain_;
              localProfile.activeSyncName = localProtocolInfo.username_;
              localProfile.activeSyncPolicyKey = localProtocolInfo.activesync_policykey_;
              localProfile.activeSyncServer = localProtocolInfo.server_addr_;
              localProfile.activeSyncUsingSSL = localProtocolInfo.ssl_support_;
              localProfile.activeSyncVersion = localProtocolInfo.activesync_version_;
              AccountManager.shareInstance().updateProfile(paramInt, MailAccount.getProfileString(localProfile), null, null, null);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void searchExchangeGlobalAddressList(Account paramAccount, String paramString, SearchAddressCallback paramSearchAddressCallback)
  {
    Profile localProfile = paramAccount.getProfile();
    ProtocolService.searchExchangeGlobalAddressList(localProfile, paramString, 0, 30, new QMMailProtocolNativeService.25(this, paramSearchAddressCallback, localProfile, paramAccount));
  }
  
  public QMProtocolRequest searchMails(QMSearchCursor paramQMSearchCursor, SearchInfo paramSearchInfo, SearchMailCallback paramSearchMailCallback)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramSearchInfo.getAccountId());
    Profile localProfile = localAccount.getProfile();
    Object localObject2 = paramSearchInfo.getFolderIds();
    Object localObject1;
    if (localObject2.length > 1) {
      localObject1 = "-1";
    }
    ArrayList localArrayList;
    Object localObject3;
    for (;;)
    {
      localArrayList = new ArrayList();
      i = 0;
      while (i < localObject2.length)
      {
        localObject3 = QMFolderManager.sharedInstance().getFolder(Integer.parseInt(localObject2[i]));
        if ((localObject3 != null) && (!((QMFolder)localObject3).isVirtual())) {
          localArrayList.add(((QMFolder)localObject3).getRemoteId());
        }
        i += 1;
      }
      localObject1 = QMFolderManager.sharedInstance().getFolder(Integer.parseInt(localObject2[0]));
      if (localObject1 != null) {
        localObject1 = ((QMFolder)localObject1).getRemoteId();
      } else {
        localObject1 = paramSearchInfo.getFolderId() + "";
      }
    }
    localObject2 = new HashMap();
    int j = paramQMSearchCursor.getCount();
    int i = 0;
    if (i < j)
    {
      if (paramQMSearchCursor.getItem(i) == null) {}
      for (;;)
      {
        i += 1;
        break;
        ((HashMap)localObject2).put(paramQMSearchCursor.getItem(i).getInformation().getRemoteId(), Boolean.valueOf(true));
      }
    }
    paramQMSearchCursor = paramQMSearchCursor.getLastRemoteItem(localAccount.getId());
    long l;
    if (paramQMSearchCursor != null)
    {
      l = paramQMSearchCursor.getInformation().getUtc().getTime() / 1000L;
      paramQMSearchCursor = new HashMap();
      localObject3 = paramSearchInfo.getKeyword();
      if ((paramSearchInfo.getSearchType() == 1) || (paramSearchInfo.getSearchType() == 7)) {
        paramQMSearchCursor.put(Integer.valueOf(0), new String[] { localObject3 });
      }
      if ((paramSearchInfo.getSearchType() == 2) || (paramSearchInfo.getSearchType() == 7)) {
        paramQMSearchCursor.put(Integer.valueOf(1), new String[] { localObject3 });
      }
      if ((paramSearchInfo.getSearchType() == 4) || (paramSearchInfo.getSearchType() == 7)) {
        paramQMSearchCursor.put(Integer.valueOf(2), new String[] { localObject3 });
      }
      if (paramSearchInfo.getSearchType() == 7) {
        paramQMSearchCursor.put(Integer.valueOf(3), new String[] { localObject3 });
      }
      localObject3 = new ReceiveState();
      ((ReceiveState)localObject3).recv_new_only_ = true;
      ((ReceiveState)localObject3).check_repeat_ = true;
      ((ReceiveState)localObject3).receive_head_only_ = true;
      ((ReceiveState)localObject3).recv_limited_count_ = true;
      ((ReceiveState)localObject3).receive_mail_count_of_load_more_ = 20;
      ((ReceiveState)localObject3).count_of_sync = 20;
      ((ReceiveState)localObject3).accountId = paramSearchInfo.getAccountId();
      ((ReceiveState)localObject3).folderId = paramSearchInfo.getFolderId();
      ((ReceiveState)localObject3).folderName = ((String)localObject1);
      ((ReceiveState)localObject3).exist_map_ = ((HashMap)localObject2);
      if (localProfile.protocolType != 3) {
        break label633;
      }
      localObject2 = new ProtocolFolder();
      ((ProtocolFolder)localObject2).sync_state_ = "0";
      ((ProtocolFolder)localObject2).title_ = ((String)localObject1);
      ((ProtocolFolder)localObject2).path_ = ((String)localObject1);
      ((ReceiveState)localObject3).exchange_folder_list_ = new ProtocolFolder[] { localObject2 };
      ((ReceiveState)localObject3).mailTimeStamp = l;
    }
    for (;;)
    {
      localObject1 = new QMProtocolRequest();
      ProtocolService.searchMail(localProfile, (ReceiveState)localObject3, (String[])localArrayList.toArray(new String[0]), paramQMSearchCursor, false, new QMMailProtocolNativeService.24(this, (QMProtocolRequest)localObject1, l, new int[] { 20, 0 }, localProfile, paramSearchMailCallback, paramSearchInfo, localAccount));
      return localObject1;
      l = new Date().getTime() / 1000L;
      break;
      label633:
      if (localProfile.protocolType == 4)
      {
        localObject2 = new ProtocolFolder();
        ((ProtocolFolder)localObject2).sync_state_ = "0";
        ((ProtocolFolder)localObject2).title_ = ((String)localObject1);
        ((ProtocolFolder)localObject2).path_ = ((String)localObject1);
        ((ReceiveState)localObject3).exchange_folder_list_ = new ProtocolFolder[] { localObject2 };
        ((ReceiveState)localObject3).mailSearchTime = l;
      }
    }
  }
  
  public QMProtocolRequest sendMail(Account paramAccount, ComposeMailUI paramComposeMailUI, MailManagerDelegate paramMailManagerDelegate)
  {
    com.tencent.qqmail.protocol.Mail localMail = parseProtocolComposeMail(paramComposeMailUI);
    Profile localProfile = paramAccount.getProfile();
    QMProtocolRequest localQMProtocolRequest = new QMProtocolRequest();
    if ((paramAccount.isGMail()) && (LoginManager.shareInstance().isGMailAccessTokenExpire(paramAccount.getId())))
    {
      LoginManager.shareInstance().refreshGmailAccessToken(paramAccount.getId(), paramAccount.getRefreshToken(), new QMMailProtocolNativeService.20(this, paramComposeMailUI, paramMailManagerDelegate));
      return localQMProtocolRequest;
    }
    ProtocolService.sendMail(localProfile, localMail, new QMMailProtocolNativeService.21(this, paramMailManagerDelegate, localQMProtocolRequest, paramAccount, localProfile, paramComposeMailUI));
    return localQMProtocolRequest;
  }
  
  public void setFolderListSyncKey(int paramInt, String paramString)
  {
    ProtocolService.SetFolderListSyncKey(paramInt, paramString);
  }
  
  public void setFolderSyncKey(int paramInt, String paramString)
  {
    ProtocolService.SetFolderSyncKey(paramInt, paramString);
  }
  
  public void starMails(Account paramAccount, QMFolder paramQMFolder, boolean paramBoolean, List<String> paramList1, List<String> paramList2, MailManagerDelegate paramMailManagerDelegate)
  {
    Profile localProfile = paramAccount.getProfile();
    int j = paramAccount.getId();
    paramAccount = paramQMFolder.getRemoteId();
    String str = paramQMFolder.getRemoteId();
    com.tencent.qqmail.protocol.Mail[] arrayOfMail = new com.tencent.qqmail.protocol.Mail[paramList1.size()];
    int i = 0;
    while (i < paramList1.size())
    {
      com.tencent.qqmail.protocol.Mail localMail = new com.tencent.qqmail.protocol.Mail();
      localMail.remoteId = ((String)paramList1.get(i));
      arrayOfMail[i] = localMail;
      i += 1;
    }
    paramList1 = new ReceiveState();
    if (localProfile.protocolType == 3)
    {
      int k;
      for (i = 0; i < paramList2.size(); i = k + 1)
      {
        k = i + 1;
        arrayOfMail[i].runTimeMailServerKey = ((String)paramList2.get(k));
      }
    }
    if (localProfile.protocolType == 4)
    {
      paramList1.folder_name_ = paramAccount;
      paramList1.folder_remoteId = str;
      paramList1.folderId = paramQMFolder.getId();
    }
    if (paramBoolean) {}
    for (i = 1;; i = 0)
    {
      ProtocolService.modifyMailFlag(localProfile, paramList1, paramAccount, arrayOfMail, 4, i, new QMMailProtocolNativeService.16(this, paramMailManagerDelegate, localProfile, j));
      return;
    }
  }
  
  public void syncActiveSyncFolderStatus(Account paramAccount, QMFolder paramQMFolder, IListStatusCallback paramIListStatusCallback)
  {
    paramAccount = paramAccount.getProfile();
    ProtocolService.SyncActiveSyncFolderStatus(paramAccount, paramQMFolder.getRemoteId(), paramQMFolder.getId(), new QMMailProtocolNativeService.8(this, paramQMFolder, paramIListStatusCallback, paramAccount));
  }
  
  public void syncExchangeFolderStatus(Account paramAccount, QMFolder paramQMFolder, IListStatusCallback paramIListStatusCallback)
  {
    paramAccount = paramAccount.getProfile();
    ProtocolService.SyncExchangeFolderStatus(paramAccount, paramQMFolder.getRemoteId(), paramQMFolder.getSyncState(), new QMMailProtocolNativeService.7(this, paramQMFolder, paramIListStatusCallback, paramAccount));
  }
  
  public void syncImapFolderStatus(Account paramAccount, QMFolder paramQMFolder, IListStatusCallback paramIListStatusCallback)
  {
    Profile localProfile = paramAccount.getProfile();
    if ((paramAccount.isGMail()) && (LoginManager.shareInstance().isGMailAccessTokenExpire(paramAccount.getId())))
    {
      LoginManager.shareInstance().refreshGmailAccessToken(paramAccount.getId(), paramAccount.getRefreshToken(), new QMMailProtocolNativeService.5(this, paramQMFolder, paramIListStatusCallback));
      return;
    }
    ProtocolService.SyncImapFolderStatus(localProfile, paramQMFolder.getRemoteId(), new QMMailProtocolNativeService.6(this, paramQMFolder, paramIListStatusCallback, localProfile, paramAccount));
  }
  
  public void unreadMails(Account paramAccount, QMFolder paramQMFolder, boolean paramBoolean, List<String> paramList1, List<String> paramList2, MailManagerDelegate paramMailManagerDelegate)
  {
    Profile localProfile = paramAccount.getProfile();
    int j = paramAccount.getId();
    paramAccount = paramQMFolder.getRemoteId();
    String str = paramQMFolder.getRemoteId();
    com.tencent.qqmail.protocol.Mail[] arrayOfMail = new com.tencent.qqmail.protocol.Mail[paramList1.size()];
    int i = 0;
    while (i < paramList1.size())
    {
      com.tencent.qqmail.protocol.Mail localMail = new com.tencent.qqmail.protocol.Mail();
      localMail.remoteId = ((String)paramList1.get(i));
      arrayOfMail[i] = localMail;
      i += 1;
    }
    paramList1 = new ReceiveState();
    if (localProfile.protocolType == 3)
    {
      int k;
      for (i = 0; i < paramList2.size(); i = k + 1)
      {
        k = i + 1;
        arrayOfMail[i].runTimeMailServerKey = ((String)paramList2.get(k));
      }
    }
    if (localProfile.protocolType == 4)
    {
      paramList1.folder_name_ = paramAccount;
      paramList1.folder_remoteId = str;
      paramList1.folderId = paramQMFolder.getId();
    }
    if (!paramBoolean) {}
    for (i = 1;; i = 0)
    {
      ProtocolService.modifyMailFlag(localProfile, paramList1, str, arrayOfMail, 1, i, new QMMailProtocolNativeService.17(this, paramMailManagerDelegate, localProfile, j));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolNativeService
 * JD-Core Version:    0.7.0.1
 */