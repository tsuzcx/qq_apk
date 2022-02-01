package com.tencent.moai.mailsdk.protocol;

import android.util.Log;
import com.tencent.moai.mailsdk.MailParser;
import com.tencent.moai.mailsdk.callback.AttachmentCallBack;
import com.tencent.moai.mailsdk.callback.FolderCallBack;
import com.tencent.moai.mailsdk.callback.FolderListCallBack;
import com.tencent.moai.mailsdk.callback.FolderSyncActiveSyncCallBack;
import com.tencent.moai.mailsdk.callback.LoginCallBack;
import com.tencent.moai.mailsdk.callback.LogoutCallBack;
import com.tencent.moai.mailsdk.callback.MailAbstractCallBack;
import com.tencent.moai.mailsdk.callback.MailCallBack;
import com.tencent.moai.mailsdk.callback.MailListCallBack;
import com.tencent.moai.mailsdk.callback.MailOperationCallback;
import com.tencent.moai.mailsdk.callback.SearchMailCallback;
import com.tencent.moai.mailsdk.callback.SendMailCallBack;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Attachment;
import com.tencent.moai.mailsdk.model.Contact;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.model.State;
import com.tencent.moai.mailsdk.protocol.activesync.ActiveSyncHandler;
import com.tencent.moai.mailsdk.protocol.activesync.DeviceInfoHandler;
import com.tencent.moai.mailsdk.protocol.activesync.Status.GetItemEstimateStatus;
import com.tencent.moai.mailsdk.protocol.activesync.Status.SyncStatus;
import com.tencent.moai.mailsdk.protocol.activesync.SyncKeyHandler;
import com.tencent.moai.mailsdk.protocol.activesync.SyncKeyHandler.SyncKeyCallback;
import com.tencent.moai.mailsdk.protocol.activesync.model.ActiveSyncInfo;
import com.tencent.moai.mailsdk.protocol.activesync.model.DeviceInfo;
import com.tencent.moai.mailsdk.protocol.activesync.response.ActiveSyncResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.FolderCreateResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.FolderDeleteResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.FolderSyncResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.FolderUpdateResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.GetItemEstimateResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.ItemOperationsFetchMailResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.OptionResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.PolicyKeyAckResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.PolicyKeyResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.SearchMailResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.SyncMailAbstractResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.SyncMailDeleteResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.SyncMailListResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.SyncMailMarkResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.SyncMailTextResponse;
import com.tencent.moai.mailsdk.util.FileUtility;
import com.tencent.moai.mailsdk.util.StringUtility;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ActiveSyncProtocolManager
{
  private static final String TAG = "ActiveSyncProtocolManager";
  private static ActiveSyncProtocolManager instance = new ActiveSyncProtocolManager();
  
  private void fetchSearchMail(Profile paramProfile, Mail[] paramArrayOfMail, MailCallBack paramMailCallBack)
  {
    int j = paramArrayOfMail.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject = paramArrayOfMail[i];
        try
        {
          Logger.log(4, "ActiveSyncProtocolManager", "fetchSearchMail text size:" + paramArrayOfMail.length);
          localObject = ActiveSyncHandler.getInstance().fetchMailTextCommand(parseActiveSyncInfo(paramProfile), ((Mail)localObject).getRemoteId(), true);
          throwIfError((ActiveSyncResponse)localObject);
          localObject = ((ItemOperationsFetchMailResponse)localObject).getMail();
          if (localObject != null)
          {
            if (paramMailCallBack == null) {
              break label243;
            }
            paramMailCallBack.onRetrieveMailSuccess((Mail)localObject);
            break label243;
          }
          throw new MessageException(1, "fetch mail null");
        }
        catch (MessageException localMessageException)
        {
          Logger.log(6, "ActiveSyncProtocolManager", "fetchSearchMail error: " + localMessageException.getResultCode() + ":" + localMessageException.getDetailCode() + ":" + localMessageException.getDetailMessage());
          Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(localMessageException));
          if (paramMailCallBack == null) {
            break label243;
          }
          paramMailCallBack.onRetrieveMailError(localMessageException.getResultCode(), localMessageException.getDetailCode(), localMessageException.getDetailMessage());
        }
        catch (Exception localException)
        {
          Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(localException));
          if (paramMailCallBack == null) {
            break label243;
          }
        }
        paramMailCallBack.onRetrieveMailError(1, 200001, localException.getMessage());
      }
      else
      {
        return;
      }
      label243:
      i += 1;
    }
  }
  
  public static ActiveSyncProtocolManager getInstance()
  {
    return instance;
  }
  
  private boolean isContainExceptContent(String paramString, Mail paramMail)
  {
    if (searchContactFilter(paramMail.getFrom(), paramString)) {
      return true;
    }
    if (paramMail.getTo() != null)
    {
      Iterator localIterator = paramMail.getTo().iterator();
      while (localIterator.hasNext()) {
        if (searchContactFilter((Contact)localIterator.next(), paramString)) {
          return true;
        }
      }
    }
    return searchStringFilter(paramMail.getSubject(), paramString);
  }
  
  private ActiveSyncInfo parseActiveSyncInfo(Profile paramProfile)
  {
    ActiveSyncInfo localActiveSyncInfo = new ActiveSyncInfo();
    localActiveSyncInfo.setActiveSyncName(paramProfile.getActiveSyncName());
    localActiveSyncInfo.setActiveSyncPassword(paramProfile.getActiveSyncPassword());
    localActiveSyncInfo.setActiveSyncServer(paramProfile.getActiveSyncServer());
    localActiveSyncInfo.setActiveSyncUsingSSL(paramProfile.isActiveSyncUsingSSL());
    localActiveSyncInfo.setActiveSyncDomain(paramProfile.getActiveSyncDomain());
    localActiveSyncInfo.setActiveSyncVersion(paramProfile.getActiveSyncVersion());
    localActiveSyncInfo.setActiveSyncPolicyKey(paramProfile.getActiveSyncPolicyKey());
    localActiveSyncInfo.setDeviceId(paramProfile.getDeviceId());
    localActiveSyncInfo.setDeviceType(paramProfile.getDeviceType());
    return localActiveSyncInfo;
  }
  
  private boolean searchContactFilter(Contact paramContact, String paramString)
  {
    return (paramString != null) && (paramContact != null) && (((paramContact.getEmail() != null) && (paramContact.getEmail().contains(paramString))) || ((paramContact.getNick() != null) && (paramContact.getNick().contains(paramString))));
  }
  
  private boolean searchContentFilter(String paramString, Mail paramMail)
  {
    String str = paramMail.getHtmlContent();
    return ((paramString != null) && (str != null) && (str.contains(paramString))) || (!isContainExceptContent(paramString, paramMail));
  }
  
  private boolean searchFilter(Mail paramMail, HashMap<Integer, String> paramHashMap)
  {
    String str = (String)paramHashMap.get(Integer.valueOf(0));
    if (searchContactFilter(paramMail.getFrom(), str)) {
      return true;
    }
    str = (String)paramHashMap.get(Integer.valueOf(1));
    if (paramMail.getTo() != null)
    {
      Iterator localIterator = paramMail.getTo().iterator();
      while (localIterator.hasNext()) {
        if (searchContactFilter((Contact)localIterator.next(), str)) {
          return true;
        }
      }
    }
    str = (String)paramHashMap.get(Integer.valueOf(2));
    if (searchStringFilter(paramMail.getSubject(), str)) {
      return true;
    }
    return searchContentFilter((String)paramHashMap.get(Integer.valueOf(3)), paramMail);
  }
  
  private boolean searchStringFilter(String paramString1, String paramString2)
  {
    return (paramString2 != null) && (paramString1 != null) && (paramString1.contains(paramString2));
  }
  
  private void throwIfError(ActiveSyncResponse paramActiveSyncResponse)
    throws MessageException
  {
    int i = paramActiveSyncResponse.getHttpCode();
    if (i == 401) {
      throw new MessageException(4, paramActiveSyncResponse.getErrorCode(), paramActiveSyncResponse.getErrorMsg());
    }
    if (i == 1002) {
      throw new MessageException(9, "errorMessage ssl error: " + i);
    }
    if (!paramActiveSyncResponse.isOk()) {
      throw new MessageException(7, paramActiveSyncResponse.getErrorCode(), paramActiveSyncResponse.getErrorMsg());
    }
  }
  
  public void addFolder(Profile paramProfile, State paramState, Folder paramFolder, FolderCallBack paramFolderCallBack)
  {
    try
    {
      Logger.log(4, "ActiveSyncProtocolManager", "add folder :" + paramFolder.getName());
      localObject = ActiveSyncHandler.getInstance();
      paramProfile = parseActiveSyncInfo(paramProfile);
      String str = SyncKeyHandler.getInstance().getAccountSyncKey(paramState.getAccountId());
      Logger.log(4, "ActiveSyncProtocolManager", "add folder syncKey:" + str);
      paramProfile = ((ActiveSyncHandler)localObject).folderCreateCommand(paramProfile, str, paramFolder.getParentId(), paramFolder.getName());
      if (!paramProfile.isOk()) {
        throw new MessageException(7, paramProfile.getErrorCode(), paramProfile.getErrorMsg());
      }
    }
    catch (MessageException paramProfile)
    {
      Object localObject;
      Logger.log(6, "ActiveSyncProtocolManager", "add folder error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
      Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
      if (paramFolderCallBack != null) {
        paramFolderCallBack.operateFolderError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
      }
      do
      {
        return;
        localObject = paramProfile.getSyncKey();
        SyncKeyHandler.getInstance().setAccountSyncKey(paramState.getAccountId(), (String)localObject);
        Logger.log(4, "ActiveSyncProtocolManager", "add folder new syncKey:" + (String)localObject);
        paramFolder.setRemoteId(paramProfile.getServerId());
        Logger.log(4, "ActiveSyncProtocolManager", "add folder success:" + paramFolder.getName());
      } while (paramFolderCallBack == null);
      paramFolderCallBack.operateFolderSuccess(paramFolder);
      return;
    }
    catch (Exception paramProfile)
    {
      do
      {
        Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
      } while (paramFolderCallBack == null);
      paramFolderCallBack.operateFolderError(1, 200001, paramProfile.getMessage());
    }
  }
  
  public void deleteMail(Profile paramProfile, Folder paramFolder, Mail[] paramArrayOfMail, MailOperationCallback paramMailOperationCallback)
  {
    try
    {
      Logger.log(4, "ActiveSyncProtocolManager", "delete mail size:" + paramArrayOfMail.length);
      ActiveSyncHandler localActiveSyncHandler = ActiveSyncHandler.getInstance();
      paramProfile = parseActiveSyncInfo(paramProfile);
      ArrayList localArrayList = new ArrayList();
      int j = paramArrayOfMail.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramArrayOfMail[i].getRemoteId());
        i += 1;
      }
      String str = SyncKeyHandler.getInstance().getFolderSyncKey(paramFolder.getFolderId());
      Logger.log(4, "ActiveSyncProtocolManager", "delete mail syncKey:" + str);
      paramProfile = localActiveSyncHandler.syncMailDeleteCommand(paramProfile, str, paramFolder.getRemoteId(), true, localArrayList);
      if ((paramProfile.getSyncStatus() != null) && (paramProfile.getSyncStatus().isSyncKeyError())) {
        SyncKeyHandler.getInstance().setFolderSyncKey(paramFolder.getFolderId(), "0");
      }
      throwIfError(paramProfile);
      paramProfile = paramProfile.getSyncKey();
      SyncKeyHandler.getInstance().setFolderSyncKey(paramFolder.getFolderId(), paramProfile);
      Logger.log(4, "ActiveSyncProtocolManager", "delete mail new syncKey:" + paramProfile);
      Logger.log(4, "ActiveSyncProtocolManager", "delete mail success size:" + paramArrayOfMail.length);
      if (paramMailOperationCallback != null) {
        paramMailOperationCallback.onMailOperationSuccess(paramArrayOfMail);
      }
      return;
    }
    catch (MessageException paramProfile)
    {
      do
      {
        Logger.log(6, "ActiveSyncProtocolManager", "delete mail error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
        Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
      } while (paramMailOperationCallback == null);
      paramMailOperationCallback.onMailOperationError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
      return;
    }
    catch (Exception paramProfile)
    {
      do
      {
        Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
      } while (paramMailOperationCallback == null);
      paramMailOperationCallback.onMailOperationError(1, 200001, paramProfile.getMessage());
    }
  }
  
  public void downloadAttachment(Profile paramProfile, Folder paramFolder, Mail paramMail, Attachment paramAttachment, AttachmentCallBack paramAttachmentCallBack)
  {
    try
    {
      Logger.log(4, "ActiveSyncProtocolManager", "download attachment remoteId:" + paramMail.getRemoteId() + " fid:" + paramAttachment.getFid());
      ActiveSyncHandler.getInstance().itemOperationsMailAttachCommand(parseActiveSyncInfo(paramProfile), paramAttachment.getFid(), new ActiveSyncProtocolManager.1(this, paramAttachment, paramAttachmentCallBack));
      return;
    }
    catch (MessageException paramProfile)
    {
      do
      {
        Logger.log(6, "ActiveSyncProtocolManager", "download attachment error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
        Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
      } while (paramAttachmentCallBack == null);
      paramAttachmentCallBack.onError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
      return;
    }
    catch (Exception paramProfile)
    {
      do
      {
        Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
      } while (paramAttachmentCallBack == null);
      paramAttachmentCallBack.onError(1, 200001, paramProfile.getMessage());
    }
  }
  
  public void downloadMailsAbstract(Profile paramProfile, Folder paramFolder, Mail[] paramArrayOfMail, MailAbstractCallBack paramMailAbstractCallBack)
  {
    try
    {
      Logger.log(4, "ActiveSyncProtocolManager", "download mail abstract size:" + paramArrayOfMail.length);
      ActiveSyncHandler localActiveSyncHandler = ActiveSyncHandler.getInstance();
      paramProfile = parseActiveSyncInfo(paramProfile);
      ArrayList localArrayList = new ArrayList();
      int j = paramArrayOfMail.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramArrayOfMail[i].getRemoteId());
        i += 1;
      }
      paramArrayOfMail = SyncKeyHandler.getInstance().getFolderSyncKey(paramFolder.getFolderId());
      Logger.log(4, "ActiveSyncProtocolManager", "download mail abstract syncKey:" + paramArrayOfMail);
      paramProfile = localActiveSyncHandler.syncMailAbstractCommand(paramProfile, paramArrayOfMail, paramFolder.getRemoteId(), localArrayList);
      if ((paramProfile.getSyncStatus() != null) && (paramProfile.getSyncStatus().isSyncKeyError())) {
        SyncKeyHandler.getInstance().setFolderSyncKey(paramFolder.getFolderId(), "0");
      }
      throwIfError(paramProfile);
      paramArrayOfMail = paramProfile.getSyncKey();
      SyncKeyHandler.getInstance().setFolderSyncKey(paramFolder.getFolderId(), paramArrayOfMail);
      Logger.log(4, "ActiveSyncProtocolManager", "download mail abstract new syncKey:" + paramArrayOfMail);
      paramProfile = paramProfile.getMailList().iterator();
      while (paramProfile.hasNext())
      {
        paramFolder = (Mail)paramProfile.next();
        Logger.log(4, "ActiveSyncProtocolManager", "download mail abstract success remoteId:" + paramFolder.getRemoteId());
        if (paramMailAbstractCallBack != null) {
          paramMailAbstractCallBack.onRetrieveMailAbstractSuccess(paramFolder);
        }
      }
      return;
    }
    catch (MessageException paramProfile)
    {
      Logger.log(6, "ActiveSyncProtocolManager", "download mail abstract error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
      Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
      if (paramMailAbstractCallBack != null) {
        paramMailAbstractCallBack.onRetrieveMailAbstractError(0L, paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
      }
      return;
    }
    catch (Exception paramProfile)
    {
      do
      {
        Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
      } while (paramMailAbstractCallBack == null);
      paramMailAbstractCallBack.onRetrieveMailAbstractError(0L, 1, 200001, paramProfile.getMessage());
    }
  }
  
  public void downloadMailsText(Profile paramProfile, Folder paramFolder, Mail[] paramArrayOfMail, boolean paramBoolean, MailCallBack paramMailCallBack)
  {
    try
    {
      Logger.log(4, "ActiveSyncProtocolManager", "download mail text size:" + paramArrayOfMail.length);
      ActiveSyncHandler localActiveSyncHandler = ActiveSyncHandler.getInstance();
      paramProfile = parseActiveSyncInfo(paramProfile);
      ArrayList localArrayList = new ArrayList();
      int j = paramArrayOfMail.length;
      int i = 0;
      while (i < j)
      {
        Mail localMail = paramArrayOfMail[i];
        localArrayList.add(localMail.getRemoteId());
        Logger.log(4, "ActiveSyncProtocolManager", "prepare to download mail:" + localMail.getRemoteId());
        i += 1;
      }
      paramArrayOfMail = SyncKeyHandler.getInstance().getFolderSyncKey(paramFolder.getFolderId());
      Logger.log(4, "ActiveSyncProtocolManager", "download mail text syncKey:" + paramArrayOfMail);
      paramProfile = localActiveSyncHandler.syncMailTextCommand(paramProfile, paramArrayOfMail, paramFolder.getRemoteId(), localArrayList);
      if (paramProfile.getSyncStatus() == null) {
        throw new MessageException(7, 200001, "getSyncStatus null");
      }
    }
    catch (MessageException paramProfile)
    {
      Logger.log(6, "ActiveSyncProtocolManager", "download mail text error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
      Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
      if (paramMailCallBack != null) {
        paramMailCallBack.onRetrieveMailError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
      }
      for (;;)
      {
        return;
        if ((paramProfile.getSyncStatus() != null) && (paramProfile.getSyncStatus().isSyncKeyError())) {
          SyncKeyHandler.getInstance().setFolderSyncKey(paramFolder.getFolderId(), "0");
        }
        throwIfError(paramProfile);
        paramArrayOfMail = paramProfile.getSyncKey();
        SyncKeyHandler.getInstance().setFolderSyncKey(paramFolder.getFolderId(), paramArrayOfMail);
        Logger.log(4, "ActiveSyncProtocolManager", "download mail text new syncKey:" + paramArrayOfMail);
        paramProfile = paramProfile.getMailList().iterator();
        while (paramProfile.hasNext())
        {
          paramFolder = (Mail)paramProfile.next();
          Logger.log(4, "ActiveSyncProtocolManager", "download mail text success remoteId:" + paramFolder.getRemoteId());
          if (paramMailCallBack != null) {
            paramMailCallBack.onRetrieveMailSuccess(paramFolder);
          }
        }
      }
    }
    catch (Exception paramProfile)
    {
      do
      {
        Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
      } while (paramMailCallBack == null);
      paramMailCallBack.onRetrieveMailError(1, 200001, paramProfile.getMessage());
    }
  }
  
  public void downloadMailsText(Profile paramProfile, Folder paramFolder, Mail[] paramArrayOfMail, boolean paramBoolean1, boolean paramBoolean2, MailCallBack paramMailCallBack)
  {
    if (paramBoolean2)
    {
      fetchSearchMail(paramProfile, paramArrayOfMail, paramMailCallBack);
      return;
    }
    downloadMailsText(paramProfile, paramFolder, paramArrayOfMail, paramBoolean1, paramMailCallBack);
  }
  
  public void fetchFolderList(Profile paramProfile, State paramState, FolderListCallBack paramFolderListCallBack)
  {
    try
    {
      Logger.log(4, "ActiveSyncProtocolManager", "fetch folder list name:" + paramProfile.getActiveSyncName());
      localObject1 = ActiveSyncHandler.getInstance();
      localObject2 = parseActiveSyncInfo(paramProfile);
      String str = SyncKeyHandler.getInstance().getAccountSyncKey(paramState.getAccountId());
      Logger.log(4, "ActiveSyncProtocolManager", "fetch folder list syncKey:" + str);
      localObject1 = ((ActiveSyncHandler)localObject1).folderSyncCommand((ActiveSyncInfo)localObject2, str);
      if (!((FolderSyncResponse)localObject1).isOk()) {
        throw new MessageException(7, ((FolderSyncResponse)localObject1).getErrorCode(), ((FolderSyncResponse)localObject1).getErrorMsg());
      }
    }
    catch (MessageException paramProfile)
    {
      Object localObject1;
      Object localObject2;
      Logger.log(6, "ActiveSyncProtocolManager", "fetch folder list error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
      Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
      if (paramFolderListCallBack != null) {
        paramFolderListCallBack.onRetrieveFoldersError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
      }
      do
      {
        return;
        localObject2 = ((FolderSyncResponse)localObject1).getSyncKey();
        SyncKeyHandler.getInstance().setAccountSyncKey(paramState.getAccountId(), (String)localObject2);
        Logger.log(4, "ActiveSyncProtocolManager", "fetch folder list new syncKey:" + (String)localObject2);
        paramState = ((FolderSyncResponse)localObject1).getAddFolderList();
        localObject2 = ((FolderSyncResponse)localObject1).getUpdateFolderList();
        localObject1 = ((FolderSyncResponse)localObject1).getDeleteFolderList();
        Logger.log(4, "ActiveSyncProtocolManager", "fetch folder list success name:" + paramProfile.getActiveSyncName() + " addFolder:" + paramState.size() + " updateFolder:" + ((ArrayList)localObject2).size() + " deleteFolder:" + ((ArrayList)localObject1).size());
      } while (paramFolderListCallBack == null);
      paramFolderListCallBack.onRetrieveFoldersSuccess((Folder[])paramState.toArray(new Folder[paramState.size()]), (Folder[])((ArrayList)localObject2).toArray(new Folder[((ArrayList)localObject2).size()]), (Folder[])((ArrayList)localObject1).toArray(new Folder[((ArrayList)localObject1).size()]));
      return;
    }
    catch (Exception paramProfile)
    {
      do
      {
        Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
      } while (paramFolderListCallBack == null);
      paramFolderListCallBack.onRetrieveFoldersError(1, 200001, paramProfile.getMessage());
    }
  }
  
  public void fetchMailList(Profile paramProfile, State paramState, Folder paramFolder, MailListCallBack paramMailListCallBack)
  {
    boolean bool;
    do
    {
      Object localObject1;
      Object localObject3;
      Object localObject2;
      Object localObject4;
      for (;;)
      {
        try
        {
          Logger.log(4, "ActiveSyncProtocolManager", "fetch mail list remoteId:" + paramFolder.getRemoteId() + " name:" + paramFolder.getName());
          localObject1 = ActiveSyncHandler.getInstance();
          localObject3 = parseActiveSyncInfo(paramProfile);
          localObject2 = SyncKeyHandler.getInstance().getFolderSyncKey(paramFolder.getFolderId());
          Logger.log(4, "ActiveSyncProtocolManager", "fetch mail list syncKey:" + (String)localObject2);
          if (((String)localObject2).equals("0"))
          {
            localObject4 = ((ActiveSyncHandler)localObject1).syncMailListInitCommand((ActiveSyncInfo)localObject3, (String)localObject2, paramFolder.getRemoteId(), String.valueOf(paramState.getActiveSyncFilterType()));
            if ((((SyncMailListResponse)localObject4).getSyncStatus() != null) && (((SyncMailListResponse)localObject4).getSyncStatus().isSyncKeyError())) {
              SyncKeyHandler.getInstance().setFolderSyncKey(paramFolder.getFolderId(), "0");
            }
            throwIfError((ActiveSyncResponse)localObject4);
            localObject4 = ((SyncMailListResponse)localObject4).getSyncKey();
            SyncKeyHandler.getInstance().setFolderSyncKey(paramFolder.getFolderId(), (String)localObject4);
            Logger.log(4, "ActiveSyncProtocolManager", "fetch mail list init syncKey:" + (String)localObject4);
            localObject1 = ((ActiveSyncHandler)localObject1).syncMailListCommand((ActiveSyncInfo)localObject3, (String)localObject4, paramFolder.getRemoteId(), String.valueOf(paramState.getActiveSyncFilterType()));
            if ((((SyncMailListResponse)localObject1).getSyncStatus() != null) && (((SyncMailListResponse)localObject1).getSyncStatus().isSyncKeyError())) {
              SyncKeyHandler.getInstance().setFolderSyncKey(paramFolder.getFolderId(), "0");
            }
            if (!((SyncMailListResponse)localObject1).isOk()) {
              throw new MessageException(7, ((SyncMailListResponse)localObject1).getErrorCode(), ((SyncMailListResponse)localObject1).getErrorMsg());
            }
          }
        }
        catch (MessageException paramProfile)
        {
          Logger.log(6, "ActiveSyncProtocolManager", "fetch mail list error:" + paramFolder.getName() + " " + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
          Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
          if (paramMailListCallBack != null) {
            paramMailListCallBack.onRetrieveMailsError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
          }
          return;
          localObject3 = ((SyncMailListResponse)localObject1).getSyncKey();
          SyncKeyHandler.getInstance().setFolderSyncKey(paramFolder.getFolderId(), (String)localObject3);
          Logger.log(4, "ActiveSyncProtocolManager", "fetch mail list next syncKey:" + (String)localObject2);
          localArrayList1 = paramState.getExistUidList();
          localObject2 = new ArrayList();
          localObject3 = new ArrayList();
          localObject4 = new ArrayList();
          localObject5 = ((SyncMailListResponse)localObject1).getAddMailList().iterator();
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          localObject6 = (Mail)((Iterator)localObject5).next();
          if (localArrayList1.contains(((Mail)localObject6).getRemoteId())) {
            continue;
          }
          ((ArrayList)localObject2).add(localObject6);
          continue;
        }
        catch (Exception paramProfile)
        {
          Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
          if (paramMailListCallBack == null) {
            continue;
          }
          paramMailListCallBack.onRetrieveMailsError(1, 200001, paramProfile.getMessage());
          return;
        }
        localObject1 = ((ActiveSyncHandler)localObject1).syncMailListCommand((ActiveSyncInfo)localObject3, (String)localObject2, paramFolder.getRemoteId(), String.valueOf(paramState.getActiveSyncFilterType()));
        if ((((SyncMailListResponse)localObject1).getSyncStatus() != null) && (((SyncMailListResponse)localObject1).getSyncStatus().isSyncKeyError())) {
          SyncKeyHandler.getInstance().setFolderSyncKey(paramFolder.getFolderId(), "0");
        }
        throwIfError((ActiveSyncResponse)localObject1);
        localObject2 = ((SyncMailListResponse)localObject1).getSyncKey();
        SyncKeyHandler.getInstance().setFolderSyncKey(paramFolder.getFolderId(), (String)localObject2);
        Logger.log(4, "ActiveSyncProtocolManager", "fetch mail list new syncKey:" + (String)localObject2);
      }
      Object localObject5 = ((SyncMailListResponse)localObject1).getDeleteMailList().iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (Mail)((Iterator)localObject5).next();
        if (localArrayList1.contains(((Mail)localObject6).getRemoteId())) {
          ((ArrayList)localObject4).add(localObject6);
        }
      }
      int i = localArrayList1.size() + ((ArrayList)localObject2).size() - ((ArrayList)localObject4).size();
      Logger.log(4, "ActiveSyncProtocolManager", "fetch mail list newMail:" + ((ArrayList)localObject2).size() + " update:" + ((ArrayList)localObject3).size() + " delete:" + ((ArrayList)localObject4).size() + " total:" + i);
      ArrayList localArrayList1 = ((SyncMailListResponse)localObject1).getReadList();
      localObject5 = ((SyncMailListResponse)localObject1).getUnreadList();
      Object localObject6 = ((SyncMailListResponse)localObject1).getFlagList();
      ArrayList localArrayList2 = ((SyncMailListResponse)localObject1).getUnFlagList();
      bool = ((SyncMailListResponse)localObject1).isMoreAvailable();
      Logger.log(4, "ActiveSyncProtocolManager", "fetch mail list read:" + localArrayList1.size() + " unread:" + ((ArrayList)localObject5).size() + " flag:" + ((ArrayList)localObject6).size() + " unFlag:" + localArrayList2.size());
      Logger.log(4, "ActiveSyncProtocolManager", "fetch mail list success remoteId:" + paramFolder.getRemoteId() + " name:" + paramFolder.getName());
      if (paramMailListCallBack != null)
      {
        paramMailListCallBack.onRetrieveMailsSuccess(i, (Mail[])((ArrayList)localObject2).toArray(new Mail[((ArrayList)localObject2).size()]), (Mail[])((ArrayList)localObject3).toArray(new Mail[((ArrayList)localObject3).size()]), (Mail[])((ArrayList)localObject4).toArray(new Mail[((ArrayList)localObject4).size()]), bool);
        paramMailListCallBack.onExchangeSyncFolderReadStatusFinished(paramFolder.getFolderId(), (String[])localArrayList1.toArray(new String[localArrayList1.size()]), (String[])((ArrayList)localObject5).toArray(new String[((ArrayList)localObject5).size()]), (String[])((ArrayList)localObject6).toArray(new String[((ArrayList)localObject6).size()]), (String[])localArrayList2.toArray(new String[localArrayList2.size()]));
      }
    } while (!bool);
    fetchMailList(paramProfile, paramState, paramFolder, paramMailListCallBack);
  }
  
  public void initAccountSyncKeyMapping(Map<Integer, String> paramMap)
  {
    SyncKeyHandler.getInstance().initAccountSyncKeyMapping(paramMap);
  }
  
  public void initFolderSyncKeyMapping(Map<Integer, String> paramMap)
  {
    SyncKeyHandler.getInstance().initFolderSyncKeyMapping(paramMap);
  }
  
  public void initProfile(Profile paramProfile) {}
  
  public void login(Profile paramProfile, LoginCallBack paramLoginCallBack)
  {
    ActiveSyncInfo localActiveSyncInfo = parseActiveSyncInfo(paramProfile);
    try
    {
      ActiveSyncHandler localActiveSyncHandler = ActiveSyncHandler.getInstance();
      localObject2 = localActiveSyncHandler.optionCommand(localActiveSyncInfo);
      throwIfError((ActiveSyncResponse)localObject2);
      if ((((OptionResponse)localObject2).getVersions() != null) && (((OptionResponse)localObject2).getVersions().size() > 0))
      {
        String str = (String)((OptionResponse)localObject2).getVersions().get(((OptionResponse)localObject2).getVersions().size() - 1);
        paramProfile.setActiveSyncVersion(str);
        localActiveSyncInfo.setActiveSyncVersion(str);
        Logger.log(4, "ActiveSyncProtocolManager", "login option active sync version:" + str);
      }
      if (((OptionResponse)localObject2).getCommands().size() <= 0) {
        throw new MessageException(7, ((OptionResponse)localObject2).getErrorCode(), "option commands empty");
      }
    }
    catch (MessageException localMessageException)
    {
      Object localObject2;
      Logger.log(6, "ActiveSyncProtocolManager", "login error:" + localMessageException.getResultCode() + ":" + localMessageException.getDetailCode() + ":" + localMessageException.getDetailMessage());
      Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(localMessageException));
      if ((localMessageException.getDetailCode() == 403) && (!localActiveSyncInfo.isActiveSyncUsingSSL()))
      {
        paramProfile.setActiveSyncUsingSSL(true);
        login(paramProfile, paramLoginCallBack);
        do
        {
          return;
          if (!((OptionResponse)localObject2).getCommands().contains("Provision")) {
            break;
          }
          localObject2 = localMessageException.policyKeyCommand(localActiveSyncInfo);
          throwIfError((ActiveSyncResponse)localObject2);
          localObject2 = ((PolicyKeyResponse)localObject2).getPolicyKey();
          if (localObject2 != null)
          {
            paramProfile.setActiveSyncPolicyKey((String)localObject2);
            localActiveSyncInfo.setActiveSyncPolicyKey((String)localObject2);
            Logger.log(4, "ActiveSyncProtocolManager", "login policy key:" + (String)localObject2);
            localObject1 = localMessageException.policyKeyAckCommand(localActiveSyncInfo, (String)localObject2);
            throwIfError((ActiveSyncResponse)localObject1);
            localObject1 = ((PolicyKeyAckResponse)localObject1).getPolicyKey();
            if (localObject1 != null)
            {
              paramProfile.setActiveSyncPolicyKey((String)localObject1);
              localActiveSyncInfo.setActiveSyncPolicyKey((String)localObject1);
              Logger.log(4, "ActiveSyncProtocolManager", "login policy ack key:" + (String)localObject1);
            }
          }
          Logger.log(4, "ActiveSyncProtocolManager", "login success name:" + paramProfile.getActiveSyncName());
        } while (paramLoginCallBack == null);
        paramLoginCallBack.onLoginSuccess(paramProfile);
        return;
      }
    }
    catch (Exception paramProfile)
    {
      Object localObject1;
      do
      {
        do
        {
          do
          {
            Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
          } while (paramLoginCallBack == null);
          if (!(paramProfile instanceof CertificateException)) {
            break;
          }
          paramLoginCallBack.onLoginError(9, 200001, paramProfile.getMessage());
          return;
          localObject1 = ((ActiveSyncHandler)localObject1).folderSyncCommand(localActiveSyncInfo, "0");
        } while (((FolderSyncResponse)localObject1).isOk());
        throw new MessageException(4, ((FolderSyncResponse)localObject1).getErrorCode(), ((FolderSyncResponse)localObject1).getErrorMsg());
        if ((((MessageException)localObject1).getDetailCode() == 401) && (!localActiveSyncInfo.getActiveSyncName().contains("@")) && (!StringUtility.isNullOrEmpty(localActiveSyncInfo.getActiveSyncDomain())))
        {
          paramProfile.setActiveSyncName(localActiveSyncInfo.getActiveSyncDomain() + "\\" + paramProfile.getActiveSyncName().split("@")[0]);
          login(paramProfile, paramLoginCallBack);
          return;
        }
      } while (paramLoginCallBack == null);
      paramLoginCallBack.onLoginError(((MessageException)localObject1).getResultCode(), ((MessageException)localObject1).getDetailCode(), ((MessageException)localObject1).getDetailMessage());
      return;
      paramLoginCallBack.onLoginError(1, 200001, paramProfile.getMessage());
    }
  }
  
  public void logout(Profile paramProfile, LogoutCallBack paramLogoutCallBack) {}
  
  public void modifyMailFlag(Profile paramProfile, Folder paramFolder, Mail[] paramArrayOfMail, int paramInt1, int paramInt2, MailOperationCallback paramMailOperationCallback)
  {
    try
    {
      Logger.log(4, "ActiveSyncProtocolManager", "modify mail flag size:" + paramArrayOfMail.length + " flag:" + paramInt1 + " value:" + paramInt2);
      ActiveSyncHandler localActiveSyncHandler = ActiveSyncHandler.getInstance();
      paramProfile = parseActiveSyncInfo(paramProfile);
      ArrayList localArrayList = new ArrayList();
      int j = paramArrayOfMail.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramArrayOfMail[i].getRemoteId());
        i += 1;
      }
      String str = SyncKeyHandler.getInstance().getFolderSyncKey(paramFolder.getFolderId());
      Logger.log(4, "ActiveSyncProtocolManager", "modify mail flag syncKey:" + str);
      paramProfile = localActiveSyncHandler.syncMailMarkCommand(paramProfile, str, paramFolder.getRemoteId(), paramInt1, paramInt2, localArrayList);
      if ((paramProfile.getSyncStatus() != null) && (paramProfile.getSyncStatus().isSyncKeyError())) {
        SyncKeyHandler.getInstance().setFolderSyncKey(paramFolder.getFolderId(), "0");
      }
      throwIfError(paramProfile);
      paramProfile = paramProfile.getSyncKey();
      SyncKeyHandler.getInstance().setFolderSyncKey(paramFolder.getFolderId(), paramProfile);
      Logger.log(4, "ActiveSyncProtocolManager", "modify mail flag new syncKey:" + paramProfile);
      Logger.log(4, "ActiveSyncProtocolManager", "modify mail flag success size:" + paramArrayOfMail.length + " flag:" + paramInt1 + " value:" + paramInt2);
      if (paramMailOperationCallback != null) {
        paramMailOperationCallback.onMailOperationSuccess(paramArrayOfMail);
      }
      return;
    }
    catch (MessageException paramProfile)
    {
      do
      {
        Logger.log(6, "ActiveSyncProtocolManager", "modify mail flag error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
        Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
      } while (paramMailOperationCallback == null);
      paramMailOperationCallback.onMailOperationError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
      return;
    }
    catch (Exception paramProfile)
    {
      do
      {
        Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
      } while (paramMailOperationCallback == null);
      paramMailOperationCallback.onMailOperationError(1, 200001, paramProfile.getMessage());
    }
  }
  
  public void moveMail(Profile paramProfile, Folder paramFolder1, Folder paramFolder2, Mail[] paramArrayOfMail, MailOperationCallback paramMailOperationCallback)
  {
    try
    {
      Logger.log(4, "ActiveSyncProtocolManager", "move mail source:" + paramFolder1.getPath() + " dest:" + paramFolder2.getPath() + " size:" + paramArrayOfMail.length);
      ActiveSyncHandler localActiveSyncHandler = ActiveSyncHandler.getInstance();
      paramProfile = parseActiveSyncInfo(paramProfile);
      ArrayList localArrayList = new ArrayList();
      int j = paramArrayOfMail.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramArrayOfMail[i].getRemoteId());
        i += 1;
      }
      throwIfError(localActiveSyncHandler.moveMailCommand(paramProfile, paramFolder1.getRemoteId(), paramFolder2.getRemoteId(), localArrayList));
      Logger.log(4, "ActiveSyncProtocolManager", "move mail success source:" + paramFolder1.getPath() + " dest:" + paramFolder2.getPath() + " size:" + paramArrayOfMail.length);
      if (paramMailOperationCallback != null) {
        paramMailOperationCallback.onMailOperationSuccess(paramArrayOfMail);
      }
      return;
    }
    catch (MessageException paramProfile)
    {
      do
      {
        Logger.log(6, "ActiveSyncProtocolManager", "move mail error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
        Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
      } while (paramMailOperationCallback == null);
      paramMailOperationCallback.onMailOperationError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
      return;
    }
    catch (Exception paramProfile)
    {
      do
      {
        Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
      } while (paramMailOperationCallback == null);
      paramMailOperationCallback.onMailOperationError(1, 200001, paramProfile.getMessage());
    }
  }
  
  public void removeAccountSyncKey(int paramInt)
  {
    SyncKeyHandler.getInstance().removeAccountSyncKey(paramInt);
  }
  
  public void removeFolder(Profile paramProfile, State paramState, Folder paramFolder, FolderCallBack paramFolderCallBack)
  {
    try
    {
      Logger.log(4, "ActiveSyncProtocolManager", "remove folder remoteId" + paramFolder.getRemoteId() + " name:" + paramFolder.getName());
      ActiveSyncHandler localActiveSyncHandler = ActiveSyncHandler.getInstance();
      paramProfile = parseActiveSyncInfo(paramProfile);
      String str = SyncKeyHandler.getInstance().getAccountSyncKey(paramState.getAccountId());
      Logger.log(4, "ActiveSyncProtocolManager", "remove folder syncKey:" + str);
      paramProfile = localActiveSyncHandler.folderDeleteCommand(paramProfile, str, paramFolder.getRemoteId());
      throwIfError(paramProfile);
      paramProfile = paramProfile.getSyncKey();
      SyncKeyHandler.getInstance().setAccountSyncKey(paramState.getAccountId(), paramProfile);
      Logger.log(4, "ActiveSyncProtocolManager", "remove folder new syncKey:" + paramProfile);
      Logger.log(4, "ActiveSyncProtocolManager", "remove folder success remoteId" + paramFolder.getRemoteId() + " name:" + paramFolder.getName());
      if (paramFolderCallBack != null) {
        paramFolderCallBack.operateFolderSuccess(paramFolder);
      }
      return;
    }
    catch (MessageException paramProfile)
    {
      do
      {
        Logger.log(6, "ActiveSyncProtocolManager", "remove folder error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
        Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
      } while (paramFolderCallBack == null);
      paramFolderCallBack.operateFolderError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
      return;
    }
    catch (Exception paramProfile)
    {
      do
      {
        Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
      } while (paramFolderCallBack == null);
      paramFolderCallBack.operateFolderError(1, 200001, paramProfile.getMessage());
    }
  }
  
  public void removeFolderSyncKey(int[] paramArrayOfInt)
  {
    SyncKeyHandler.getInstance().removeFolderSyncKey(paramArrayOfInt);
  }
  
  public void renameFolder(Profile paramProfile, State paramState, Folder paramFolder, String paramString, FolderCallBack paramFolderCallBack)
  {
    try
    {
      Logger.log(4, "ActiveSyncProtocolManager", "rename folder name:" + paramFolder.getName() + " newName:" + paramString);
      ActiveSyncHandler localActiveSyncHandler = ActiveSyncHandler.getInstance();
      paramProfile = parseActiveSyncInfo(paramProfile);
      String str = SyncKeyHandler.getInstance().getAccountSyncKey(paramState.getAccountId());
      Logger.log(4, "ActiveSyncProtocolManager", "rename folder syncKey:" + str);
      paramProfile = localActiveSyncHandler.folderUpdateCommand(paramProfile, str, paramFolder.getParentId(), paramFolder.getRemoteId(), paramString);
      throwIfError(paramProfile);
      paramProfile = paramProfile.getSyncKey();
      SyncKeyHandler.getInstance().setAccountSyncKey(paramState.getAccountId(), paramProfile);
      Logger.log(4, "ActiveSyncProtocolManager", "rename folder new syncKey:" + paramProfile);
      paramFolder.setName(paramString);
      Logger.log(4, "ActiveSyncProtocolManager", "rename folder success:" + paramFolder.getName() + ":" + paramString);
      if (paramFolderCallBack != null) {
        paramFolderCallBack.operateFolderSuccess(paramFolder);
      }
      return;
    }
    catch (MessageException paramProfile)
    {
      do
      {
        Logger.log(6, "ActiveSyncProtocolManager", "rename folder error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
        Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
      } while (paramFolderCallBack == null);
      paramFolderCallBack.operateFolderError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
      return;
    }
    catch (Exception paramProfile)
    {
      do
      {
        Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
      } while (paramFolderCallBack == null);
      paramFolderCallBack.operateFolderError(1, 200001, paramProfile.getMessage());
    }
  }
  
  public void searchMail(Profile paramProfile, ArrayList<String> paramArrayList, State paramState, HashMap<Integer, String> paramHashMap, SearchMailCallback paramSearchMailCallback)
  {
    for (;;)
    {
      try
      {
        ActiveSyncInfo localActiveSyncInfo = parseActiveSyncInfo(paramProfile);
        ActiveSyncHandler localActiveSyncHandler = ActiveSyncHandler.getInstance();
        Object localObject1 = "";
        Object localObject2 = paramHashMap.entrySet().iterator();
        paramProfile = (Profile)localObject1;
        if (((Iterator)localObject2).hasNext())
        {
          paramProfile = (Map.Entry)((Iterator)localObject2).next();
          if (paramProfile.getValue() == null) {
            continue;
          }
          paramProfile = (String)paramProfile.getValue();
        }
        long l = paramState.getLastMailUtc();
        paramArrayList = paramArrayList.iterator();
        i = 0;
        j = 0;
        if (paramArrayList.hasNext())
        {
          localObject1 = localActiveSyncHandler.searchMail(localActiveSyncInfo, (String)paramArrayList.next(), 0L, l, paramProfile, paramState.getLoadMoreCount());
          throwIfError((ActiveSyncResponse)localObject1);
          localObject2 = ((SearchMailResponse)localObject1).getSearchMailList();
          Logger.log(4, "ActiveSyncProtocolManager", "search mail success size:" + ((ArrayList)localObject2).size());
          j += ((SearchMailResponse)localObject1).getTotalCount();
          k = ((ArrayList)localObject2).size() + i;
          localObject1 = ((ArrayList)localObject2).iterator();
          i = j;
          j = k;
          if (!((Iterator)localObject1).hasNext()) {
            break label437;
          }
          localObject2 = (Mail)((Iterator)localObject1).next();
          if (!searchFilter((Mail)localObject2, paramHashMap)) {
            break label414;
          }
          paramSearchMailCallback.onSearchMail((Mail)localObject2);
          k = i;
          i = j;
          j = k;
        }
        else
        {
          if (paramSearchMailCallback != null) {
            paramSearchMailCallback.onSearchSuccess(j, i);
          }
          return;
        }
      }
      catch (MessageException paramProfile)
      {
        Logger.log(6, "ActiveSyncProtocolManager", "search mail error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
        Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
        if (paramSearchMailCallback == null) {
          continue;
        }
        paramSearchMailCallback.onSearchError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
        return;
      }
      catch (Exception paramProfile)
      {
        Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
        if (paramSearchMailCallback == null) {
          continue;
        }
        paramSearchMailCallback.onSearchError(1, 200001, paramProfile.getMessage());
        return;
      }
      for (;;)
      {
        k = j;
        j = i;
        i = k;
        break;
        label414:
        j -= 1;
        k = i - 1;
        i = j;
        j = k;
      }
      label437:
      int k = i;
      int i = j;
      int j = k;
    }
  }
  
  public void sendMail(Profile paramProfile, Mail paramMail, SendMailCallBack paramSendMailCallBack)
  {
    try
    {
      Logger.log(4, "ActiveSyncProtocolManager", "send mail:" + paramMail.getSubject());
      ActiveSyncHandler localActiveSyncHandler = ActiveSyncHandler.getInstance();
      paramProfile = parseActiveSyncInfo(paramProfile);
      String str1 = String.valueOf(System.currentTimeMillis());
      String str2 = FileUtility.getActiveSyncDirPath() + str1 + ".compose";
      localActiveSyncHandler.sendMailCommand(paramProfile, str1, str2, MailParser.createMessage(paramMail), new ActiveSyncProtocolManager.2(this, paramSendMailCallBack, paramMail, str2));
      return;
    }
    catch (MessageException paramProfile)
    {
      do
      {
        Logger.log(6, "ActiveSyncProtocolManager", "send mail error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
        Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
      } while (paramSendMailCallBack == null);
      paramSendMailCallBack.onError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
      return;
    }
    catch (Exception paramProfile)
    {
      do
      {
        Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
      } while (paramSendMailCallBack == null);
      paramSendMailCallBack.onError(1, 200001, paramProfile.getMessage());
    }
  }
  
  public void setAccountSyncKey(int paramInt, String paramString)
  {
    SyncKeyHandler.getInstance().setAccountSyncKey(paramInt, paramString);
  }
  
  public void setAccountSyncKeyCallback(SyncKeyHandler.SyncKeyCallback paramSyncKeyCallback)
  {
    SyncKeyHandler.getInstance().setAccountSyncKeyCallback(paramSyncKeyCallback);
  }
  
  public void setDeviceInfo(DeviceInfo paramDeviceInfo)
  {
    DeviceInfoHandler.getInstance().initDeviceInfo(paramDeviceInfo);
  }
  
  public void setFolderSyncKey(int paramInt, String paramString)
  {
    SyncKeyHandler.getInstance().setFolderSyncKey(paramInt, paramString);
  }
  
  public void setFolderSyncKeyCallback(SyncKeyHandler.SyncKeyCallback paramSyncKeyCallback)
  {
    SyncKeyHandler.getInstance().setFolderSyncKeyCallback(paramSyncKeyCallback);
  }
  
  public void syncFolderStatus(Profile paramProfile, State paramState, Folder paramFolder, FolderSyncActiveSyncCallBack paramFolderSyncActiveSyncCallBack)
  {
    try
    {
      Logger.log(4, "ActiveSyncProtocolManager", "sync folder status path:" + paramFolder.getPath() + " name:" + paramFolder.getName());
      ActiveSyncHandler localActiveSyncHandler = ActiveSyncHandler.getInstance();
      paramProfile = parseActiveSyncInfo(paramProfile);
      String str = SyncKeyHandler.getInstance().getFolderSyncKey(paramFolder.getFolderId());
      if ((str == null) || (str.equals("")) || (str.equals("0")))
      {
        Logger.log(4, "ActiveSyncProtocolManager", "sync folder status success path:" + paramFolder.getPath() + " name:" + paramFolder.getName());
        if (paramFolderSyncActiveSyncCallBack != null) {
          paramFolderSyncActiveSyncCallBack.onSyncStatusSuccess(0);
        }
      }
      else
      {
        paramProfile = localActiveSyncHandler.getItemEstimateCommand(paramProfile, SyncKeyHandler.getInstance().getFolderSyncKey(paramFolder.getFolderId()), paramFolder.getRemoteId(), paramState.getActiveSyncFilterType());
        if ((paramProfile.getGetItemEstimateStatus() != null) && (paramProfile.getGetItemEstimateStatus().isSyncKeyError())) {
          SyncKeyHandler.getInstance().setFolderSyncKey(paramFolder.getFolderId(), "0");
        }
        if (!paramProfile.isOk()) {
          throw new MessageException(7, paramProfile.getErrorCode(), paramProfile.getErrorMsg());
        }
      }
    }
    catch (MessageException paramProfile)
    {
      Logger.log(6, "ActiveSyncProtocolManager", "sync folder status error: " + paramFolder.getName() + " " + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
      Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
      if (paramFolderSyncActiveSyncCallBack != null)
      {
        paramFolderSyncActiveSyncCallBack.onSyncStatusError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
        return;
        Logger.log(4, "ActiveSyncProtocolManager", "sync folder status success path:" + paramFolder.getPath() + " name:" + paramFolder.getName() + " totalCount:" + paramFolder.getTotalCount());
        if (paramFolderSyncActiveSyncCallBack != null)
        {
          paramFolderSyncActiveSyncCallBack.onSyncStatusSuccess(paramProfile.getEstimate());
          return;
        }
      }
    }
    catch (Exception paramProfile)
    {
      Logger.log(6, "ActiveSyncProtocolManager", Log.getStackTraceString(paramProfile));
      if (paramFolderSyncActiveSyncCallBack != null) {
        paramFolderSyncActiveSyncCallBack.onSyncStatusError(1, 200001, paramProfile.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.ActiveSyncProtocolManager
 * JD-Core Version:    0.7.0.1
 */