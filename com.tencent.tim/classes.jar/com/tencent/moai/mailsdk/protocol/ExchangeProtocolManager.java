package com.tencent.moai.mailsdk.protocol;

import android.util.Log;
import com.tencent.moai.mailsdk.MailParser;
import com.tencent.moai.mailsdk.callback.AttachmentCallBack;
import com.tencent.moai.mailsdk.callback.CreateRuleCallback;
import com.tencent.moai.mailsdk.callback.FolderCallBack;
import com.tencent.moai.mailsdk.callback.FolderListCallBack;
import com.tencent.moai.mailsdk.callback.FolderSyncExchangeCallBack;
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
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.moai.mailsdk.model.Mail;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.model.State;
import com.tencent.moai.mailsdk.protocol.exchange.ExchangeHandler;
import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeInfo;
import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeReceiveInfo;
import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeRule;
import com.tencent.moai.mailsdk.protocol.exchange.request.GetItemRequest.FetchType;
import com.tencent.moai.mailsdk.protocol.exchange.response.ExchangeResponse;
import com.tencent.moai.mailsdk.protocol.exchange.response.FindFolderResponse;
import com.tencent.moai.mailsdk.protocol.exchange.response.FindItemResponse;
import com.tencent.moai.mailsdk.protocol.exchange.response.FolderCreateResponse;
import com.tencent.moai.mailsdk.protocol.exchange.response.FolderDeleteResponse;
import com.tencent.moai.mailsdk.protocol.exchange.response.FolderUpdateResponse;
import com.tencent.moai.mailsdk.protocol.exchange.response.GetFolderIdResponse;
import com.tencent.moai.mailsdk.protocol.exchange.response.GetFolderResponse;
import com.tencent.moai.mailsdk.protocol.exchange.response.GetItemResponse;
import com.tencent.moai.mailsdk.protocol.exchange.response.SyncFolderItemResponse;
import com.tencent.moai.mailsdk.util.FileUtility;
import com.tencent.moai.mailsdk.util.StringUtility;
import com.tencent.moai.mailsdk.util.log.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public class ExchangeProtocolManager
{
  private static final String TAG = "ExchangeProtocolManager";
  private static ExchangeProtocolManager instance = new ExchangeProtocolManager();
  private static final Comparator<Mail> mailComparator = new ExchangeProtocolManager.1();
  private static final String[] systemFolder = { "outbox", "inbox", "drafts", "deleteditems", "junkemail", "sentitems" };
  
  public static ExchangeProtocolManager getInstance()
  {
    return instance;
  }
  
  private ExchangeInfo parseExchangeInfo(Profile paramProfile)
  {
    ExchangeInfo localExchangeInfo = new ExchangeInfo();
    localExchangeInfo.setExchangeServer(paramProfile.getExchangeServer());
    localExchangeInfo.setExchangePassword(paramProfile.getExchangePassword());
    localExchangeInfo.setExchangeName(paramProfile.getExchangeName());
    localExchangeInfo.setExchangeUsingSSL(paramProfile.isExchangeUsingSSL());
    localExchangeInfo.setExchangeVersion(paramProfile.getExchangeVersion());
    return localExchangeInfo;
  }
  
  private ArrayList<Mail> syncMailAbstract(ExchangeInfo paramExchangeInfo, ArrayList<Mail> paramArrayList)
    throws MessageException
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return paramArrayList;
    }
    int j = paramArrayList.size();
    String[] arrayOfString1 = new String[j];
    String[] arrayOfString2 = new String[j];
    int i = 0;
    while (i < j)
    {
      arrayOfString1[i] = ((Mail)paramArrayList.get(i)).getRemoteId();
      arrayOfString2[i] = ((Mail)paramArrayList.get(i)).getSvrKey();
      i += 1;
    }
    return ExchangeHandler.getInstance().getItem(paramExchangeInfo, arrayOfString1, arrayOfString2, GetItemRequest.FetchType.FETCH_SUMMARY).getMailArrayList();
  }
  
  private void syncMailList(ExchangeInfo paramExchangeInfo, Folder paramFolder, ExchangeReceiveInfo paramExchangeReceiveInfo)
    throws MessageException
  {
    SyncFolderItemResponse localSyncFolderItemResponse = ExchangeHandler.getInstance().syncFolderItem(paramExchangeInfo, paramFolder.getRemoteId(), paramFolder.getSyncState());
    throwIfError(localSyncFolderItemResponse, "sync mail list error folder SyncState " + paramFolder.getSyncState());
    Object localObject1 = localSyncFolderItemResponse.getSyncState();
    paramFolder.setSyncState((String)localObject1);
    paramExchangeReceiveInfo.syncState = ((String)localObject1);
    localObject1 = localSyncFolderItemResponse.getAddMailList();
    Object localObject2 = localSyncFolderItemResponse.getUpdateMailList();
    ArrayList localArrayList1 = localSyncFolderItemResponse.getDeleteMailList();
    ArrayList localArrayList2 = localSyncFolderItemResponse.getChangeMailList();
    if (localObject1 != null) {
      paramExchangeReceiveInfo.addMailList.addAll((Collection)localObject1);
    }
    if (localObject2 != null) {
      paramExchangeReceiveInfo.updateMailList.addAll((Collection)localObject2);
    }
    if (localArrayList1 != null) {
      paramExchangeReceiveInfo.deleteMailList.addAll(localArrayList1);
    }
    if (localArrayList2 != null)
    {
      localObject1 = localArrayList2.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Mail)((Iterator)localObject1).next();
        if (((Mail)localObject2).isRead()) {
          paramExchangeReceiveInfo.readList.add(((Mail)localObject2).getRemoteId());
        } else {
          paramExchangeReceiveInfo.unReadList.add(((Mail)localObject2).getRemoteId());
        }
      }
    }
    if (!localSyncFolderItemResponse.isIncludesLastItemInRange()) {
      syncMailList(paramExchangeInfo, paramFolder, paramExchangeReceiveInfo);
    }
  }
  
  private void throwIfError(ExchangeResponse paramExchangeResponse, String paramString)
    throws MessageException
  {
    int i = paramExchangeResponse.getHttpCode();
    if (i == 401) {
      throw new MessageException(4, "errorMessage auth error: " + i);
    }
    if (i == 1002) {
      throw new MessageException(9, "errorMessage ssl error: " + i);
    }
    paramExchangeResponse = paramExchangeResponse.getResponseCode();
    if (!"NoError".equalsIgnoreCase(paramExchangeResponse)) {
      throw new MessageException(7, paramString + ":" + paramExchangeResponse);
    }
  }
  
  public void addFolder(Profile paramProfile, State paramState, Folder paramFolder, FolderCallBack paramFolderCallBack)
  {
    try
    {
      paramProfile = parseExchangeInfo(paramProfile);
      paramProfile = ExchangeHandler.getInstance().createFolder(paramProfile, paramFolder.getName());
      throwIfError(paramProfile, "add folder error");
      paramProfile = paramProfile.getFolder();
      paramProfile.setName(paramFolder.getName());
      Logger.log(4, "ExchangeProtocolManager", "add folder success:" + paramFolder.getName());
      if (paramFolderCallBack != null) {
        paramFolderCallBack.operateFolderSuccess(paramProfile);
      }
      return;
    }
    catch (MessageException paramProfile)
    {
      do
      {
        Logger.log(6, "ExchangeProtocolManager", "add folder error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
      } while (paramFolderCallBack == null);
      paramFolderCallBack.operateFolderError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
      return;
    }
    catch (Exception paramProfile)
    {
      do
      {
        Logger.log(6, "ExchangeProtocolManager", Log.getStackTraceString(paramProfile));
      } while (paramFolderCallBack == null);
      paramFolderCallBack.operateFolderError(1, 200001, paramProfile.getMessage());
    }
  }
  
  public void createRule(Profile paramProfile, ArrayList<ExchangeRule> paramArrayList, CreateRuleCallback paramCreateRuleCallback)
  {
    try
    {
      paramProfile = parseExchangeInfo(paramProfile);
      throwIfError(ExchangeHandler.getInstance().createRule(paramProfile, paramArrayList), "createRule error");
      if (paramCreateRuleCallback != null) {
        paramCreateRuleCallback.onSuccess();
      }
      return;
    }
    catch (MessageException paramProfile)
    {
      do
      {
        Logger.log(6, "ExchangeProtocolManager", "createRule error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
      } while (paramCreateRuleCallback == null);
      paramCreateRuleCallback.onError();
      return;
    }
    catch (Exception paramProfile)
    {
      do
      {
        Logger.log(6, "ExchangeProtocolManager", Log.getStackTraceString(paramProfile));
      } while (paramCreateRuleCallback == null);
      paramCreateRuleCallback.onError();
    }
  }
  
  public void deleteMail(Profile paramProfile, Folder paramFolder, Mail[] paramArrayOfMail, MailOperationCallback paramMailOperationCallback)
  {
    try
    {
      paramProfile = parseExchangeInfo(paramProfile);
      paramFolder = ExchangeHandler.getInstance();
      int j = paramArrayOfMail.length;
      String[] arrayOfString1 = new String[j];
      String[] arrayOfString2 = new String[j];
      int i = 0;
      while (i < j)
      {
        arrayOfString1[i] = paramArrayOfMail[i].getRemoteId();
        arrayOfString2[i] = paramArrayOfMail[i].getSvrKey();
        i += 1;
      }
      throwIfError(paramFolder.deleteItem(paramProfile, arrayOfString1), "deleteMail error");
      Logger.log(4, "ExchangeProtocolManager", "delete mail success size:" + paramArrayOfMail.length);
      if (paramMailOperationCallback != null) {
        paramMailOperationCallback.onMailOperationSuccess(paramArrayOfMail);
      }
      return;
    }
    catch (MessageException paramProfile)
    {
      do
      {
        Logger.log(6, "ExchangeProtocolManager", "delete mail error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
      } while (paramMailOperationCallback == null);
      paramMailOperationCallback.onMailOperationError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
      return;
    }
    catch (Exception paramProfile)
    {
      while (paramMailOperationCallback == null) {}
      paramMailOperationCallback.onMailOperationError(1, 200001, paramProfile.getMessage());
    }
  }
  
  public void downloadAttachment(Profile paramProfile, Folder paramFolder, Mail paramMail, Attachment paramAttachment, AttachmentCallBack paramAttachmentCallBack)
  {
    try
    {
      paramProfile = parseExchangeInfo(paramProfile);
      ExchangeHandler.getInstance().getAttachment(paramProfile, paramAttachment.getFid(), new ExchangeProtocolManager.2(this, paramAttachment, paramAttachmentCallBack));
      return;
    }
    catch (MessageException paramProfile)
    {
      do
      {
        Logger.log(6, "ExchangeProtocolManager", "download attachment error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
      } while (paramAttachmentCallBack == null);
      paramAttachmentCallBack.onError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
      return;
    }
    catch (Exception paramProfile)
    {
      while (paramAttachmentCallBack == null) {}
      paramAttachmentCallBack.onError(1, 200001, paramProfile.getMessage());
    }
  }
  
  public void downloadMailsAbstract(Profile paramProfile, Folder paramFolder, Mail[] paramArrayOfMail, MailAbstractCallBack paramMailAbstractCallBack)
  {
    try
    {
      paramProfile = parseExchangeInfo(paramProfile);
      paramFolder = ExchangeHandler.getInstance();
      int j = paramArrayOfMail.length;
      String[] arrayOfString1 = new String[j];
      String[] arrayOfString2 = new String[j];
      int i = 0;
      while (i < j)
      {
        arrayOfString1[i] = paramArrayOfMail[i].getRemoteId();
        arrayOfString2[i] = paramArrayOfMail[i].getSvrKey();
        i += 1;
      }
      paramProfile = paramFolder.getItem(paramProfile, arrayOfString1, arrayOfString2, GetItemRequest.FetchType.FETCH_SUMMARY);
      throwIfError(paramProfile, "download mail abstract error");
      paramProfile = paramProfile.getMailArrayList().iterator();
      while (paramProfile.hasNext())
      {
        paramFolder = (Mail)paramProfile.next();
        Logger.log(4, "ExchangeProtocolManager", "download mail abstract success remoteId:" + paramFolder.getRemoteId());
        if (paramMailAbstractCallBack != null) {
          paramMailAbstractCallBack.onRetrieveMailAbstractSuccess(paramFolder);
        }
      }
      return;
    }
    catch (MessageException paramProfile)
    {
      Logger.log(6, "ExchangeProtocolManager", "download mail abstract error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
      if (paramMailAbstractCallBack != null) {
        paramMailAbstractCallBack.onRetrieveMailAbstractError(0L, paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
      }
      return;
    }
    catch (Exception paramProfile)
    {
      while (paramMailAbstractCallBack == null) {}
      paramMailAbstractCallBack.onRetrieveMailAbstractError(0L, 1, 200001, paramProfile.getMessage());
    }
  }
  
  public void downloadMailsText(Profile paramProfile, Folder paramFolder, Mail[] paramArrayOfMail, boolean paramBoolean, MailCallBack paramMailCallBack)
  {
    try
    {
      paramProfile = parseExchangeInfo(paramProfile);
      paramFolder = ExchangeHandler.getInstance();
      int j = paramArrayOfMail.length;
      String[] arrayOfString1 = new String[j];
      String[] arrayOfString2 = new String[j];
      int i = 0;
      while (i < j)
      {
        arrayOfString1[i] = paramArrayOfMail[i].getRemoteId();
        arrayOfString2[i] = paramArrayOfMail[i].getSvrKey();
        i += 1;
      }
      paramProfile = paramFolder.getItem(paramProfile, arrayOfString1, arrayOfString2, GetItemRequest.FetchType.FETCH_BODY);
      throwIfError(paramProfile, "download mail text error");
      paramProfile = paramProfile.getMailArrayList().iterator();
      while (paramProfile.hasNext())
      {
        paramFolder = (Mail)paramProfile.next();
        Logger.log(4, "ExchangeProtocolManager", "download mail text success remoteId:" + paramFolder.getRemoteId());
        if (paramMailCallBack != null) {
          paramMailCallBack.onRetrieveMailSuccess(paramFolder);
        }
      }
      return;
    }
    catch (MessageException paramProfile)
    {
      Logger.log(6, "ExchangeProtocolManager", "download mail text error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
      if (paramMailCallBack != null) {
        paramMailCallBack.onRetrieveMailError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
      }
      return;
    }
    catch (Exception paramProfile)
    {
      while (paramMailCallBack == null) {}
      paramMailCallBack.onRetrieveMailError(1, 200001, paramProfile.getMessage());
    }
  }
  
  public void fetchFolderList(Profile paramProfile, State paramState, FolderListCallBack paramFolderListCallBack)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        Object localObject = parseExchangeInfo(paramProfile);
        ExchangeHandler localExchangeHandler = ExchangeHandler.getInstance();
        paramState = new HashMap();
        String[] arrayOfString = systemFolder;
        int j = arrayOfString.length;
        if (i < j)
        {
          String str1 = arrayOfString[i];
          String str2 = localExchangeHandler.getFolderId((ExchangeInfo)localObject, str1).getRemoteFolderId();
          if (str2 != null) {
            paramState.put(str2, str1);
          }
        }
        else
        {
          localObject = localExchangeHandler.findFolder((ExchangeInfo)localObject, "msgfolderroot");
          throwIfError((ExchangeResponse)localObject, "fetch folder list error");
          paramState = ((FindFolderResponse)localObject).filterFolder(((FindFolderResponse)localObject).getFolderList(), paramState);
          Logger.log(4, "ExchangeProtocolManager", "fetch folder list success name:" + paramProfile.getExchangeName() + " addFolder:" + paramState.size());
          if (paramFolderListCallBack != null) {
            paramFolderListCallBack.onRetrieveFoldersSuccess((Folder[])paramState.toArray(new Folder[0]), new Folder[0], new Folder[0]);
          }
          return;
        }
      }
      catch (MessageException paramProfile)
      {
        Logger.log(6, "ExchangeProtocolManager", "fetch folder list error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
        if (paramFolderListCallBack == null) {
          continue;
        }
        paramFolderListCallBack.onRetrieveFoldersError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
        return;
      }
      catch (Exception paramProfile)
      {
        Logger.log(6, "ExchangeProtocolManager", Log.getStackTraceString(paramProfile));
        if (paramFolderListCallBack == null) {
          continue;
        }
        paramFolderListCallBack.onRetrieveFoldersError(1, 200001, paramProfile.getMessage());
        return;
      }
      i += 1;
    }
  }
  
  public void fetchMailList(Profile paramProfile, State paramState, Folder paramFolder, MailListCallBack paramMailListCallBack)
  {
    for (;;)
    {
      try
      {
        localExchangeInfo = parseExchangeInfo(paramProfile);
        paramProfile = ExchangeHandler.getInstance();
        boolean bool = StringUtility.isNullOrEmpty(paramFolder.getSyncState());
        Logger.log(4, "ExchangeProtocolManager", "fetchMailList " + paramFolder.getFolderId() + " " + paramFolder.getSyncState());
        if ((!bool) && (!paramState.isReceiveNewOnly())) {
          continue;
        }
        localExchangeReceiveInfo = new ExchangeReceiveInfo();
        syncMailList(localExchangeInfo, paramFolder, localExchangeReceiveInfo);
        paramProfile = new ArrayList();
        localArrayList2 = new ArrayList();
        localArrayList1 = new ArrayList();
        if ((localExchangeReceiveInfo.addMailList == null) || (localExchangeReceiveInfo.addMailList.size() <= 0)) {
          continue;
        }
        paramProfile = new ArrayList();
        if ((!bool) || (localExchangeReceiveInfo.addMailList.size() <= paramState.getInitLoadCount())) {
          continue;
        }
        Collections.sort(localExchangeReceiveInfo.addMailList, mailComparator);
        i = paramState.getInitLoadCount();
      }
      catch (MessageException paramProfile)
      {
        ExchangeInfo localExchangeInfo;
        ExchangeReceiveInfo localExchangeReceiveInfo;
        ArrayList localArrayList2;
        ArrayList localArrayList1;
        int i;
        long l;
        Logger.log(6, "ExchangeProtocolManager", "fetch mail list error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
        if (paramMailListCallBack == null) {
          return;
        }
        paramMailListCallBack.onRetrieveMailsError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
        return;
      }
      catch (Exception paramProfile)
      {
        if (paramMailListCallBack == null) {
          return;
        }
        paramMailListCallBack.onRetrieveMailsError(1, 200001, paramProfile.getMessage());
        return;
        continue;
        continue;
        int j = 0;
        continue;
      }
      if (j < i)
      {
        paramProfile.add(localExchangeReceiveInfo.addMailList.get(j));
        j += 1;
        continue;
        i = localExchangeReceiveInfo.addMailList.size();
      }
      else
      {
        paramProfile = syncMailAbstract(localExchangeInfo, paramProfile);
        Logger.log(4, "ExchangeProtocolManager", "fetchMailList syncAdd " + localExchangeReceiveInfo.addMailList.size() + " final add " + paramProfile.size());
        paramState = localArrayList2;
        if (localExchangeReceiveInfo.updateMailList != null)
        {
          paramState = localArrayList2;
          if (localExchangeReceiveInfo.updateMailList.size() > 0)
          {
            paramState = syncMailAbstract(localExchangeInfo, localExchangeReceiveInfo.updateMailList);
            Logger.log(4, "ExchangeProtocolManager", "fetchMailList syncUpdate " + localExchangeReceiveInfo.updateMailList.size() + " final update " + paramState.size());
          }
        }
        if ((localExchangeReceiveInfo.deleteMailList != null) && (localExchangeReceiveInfo.deleteMailList.size() > 0))
        {
          localArrayList1 = localExchangeReceiveInfo.deleteMailList;
          Logger.log(4, "ExchangeProtocolManager", "fetchMailList syncDelete " + localArrayList1.size());
          if (paramMailListCallBack == null) {
            return;
          }
          paramMailListCallBack.onRetrieveMailsSuccess(-1, (Mail[])paramProfile.toArray(new Mail[paramProfile.size()]), (Mail[])paramState.toArray(new Mail[paramState.size()]), (Mail[])localArrayList1.toArray(new Mail[0]), false);
          paramMailListCallBack.onExchangeSyncFolderReadStatusFinished(paramFolder.getFolderId(), (String[])localExchangeReceiveInfo.readList.toArray(new String[localExchangeReceiveInfo.readList.size()]), (String[])localExchangeReceiveInfo.unReadList.toArray(new String[localExchangeReceiveInfo.unReadList.size()]), new String[0], new String[0]);
          paramMailListCallBack.onExchangeSyncFolderFinished(paramFolder.getFolderId(), localExchangeReceiveInfo.syncState);
          return;
          l = System.currentTimeMillis();
          if (paramState.getLastMailUtc() != 0L) {
            l = paramState.getLastMailUtc();
          }
          paramProfile = paramProfile.findItem(localExchangeInfo, paramFolder.getRemoteId(), 0L, l, null, paramState.getLoadMoreCount());
          throwIfError(paramProfile, "find mail item error");
          paramProfile = syncMailAbstract(localExchangeInfo, paramProfile.getMailArrayList());
          Logger.log(4, "ExchangeProtocolManager", "fetchMailList load more " + paramProfile.size());
          if (paramMailListCallBack == null) {
            return;
          }
          paramMailListCallBack.onRetrieveMailsSuccess(-1, (Mail[])paramProfile.toArray(new Mail[paramProfile.size()]), new Mail[0], new Mail[0], false);
          return;
        }
      }
    }
  }
  
  public void initProfile(Profile paramProfile) {}
  
  public void login(Profile paramProfile, LoginCallBack paramLoginCallBack)
  {
    try
    {
      localObject = parseExchangeInfo(paramProfile);
      localGetFolderIdResponse = ExchangeHandler.getInstance().getFolderId((ExchangeInfo)localObject, "inbox");
      i = localGetFolderIdResponse.getHttpCode();
      if (i == 401)
      {
        if ((!((ExchangeInfo)localObject).getExchangeName().contains("@")) && (!StringUtility.isNullOrEmpty(((ExchangeInfo)localObject).getExchangeDomain())))
        {
          paramProfile.setExchangeName(((ExchangeInfo)localObject).getExchangeDomain() + "\\" + localObject.getExchangeName().split("@")[0]);
          login(paramProfile, paramLoginCallBack);
          return;
        }
        throw new MessageException(4, "exchange login auth error:" + i);
      }
    }
    catch (MessageException paramProfile)
    {
      Logger.log(6, "ExchangeProtocolManager", "login error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
      if (paramLoginCallBack != null)
      {
        paramLoginCallBack.onLoginError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
        return;
        if (i == 403) {
          if (!paramProfile.isExchangeUsingSSL())
          {
            paramProfile.setExchangeUsingSSL(true);
            login(paramProfile, paramLoginCallBack);
            return;
          }
        }
      }
    }
    catch (Exception paramProfile)
    {
      Object localObject;
      GetFolderIdResponse localGetFolderIdResponse;
      int i;
      Logger.log(6, "ExchangeProtocolManager", Log.getStackTraceString(paramProfile));
      if (paramLoginCallBack != null)
      {
        paramLoginCallBack.onLoginError(1, 200001, paramProfile.getMessage());
        return;
        throw new MessageException(4, "exchange login forbidden error:" + i);
        localObject = localGetFolderIdResponse.getResponseCode();
        if (!"NoError".equalsIgnoreCase((String)localObject))
        {
          if ("Exchange2010_SP1".equals(paramProfile.getExchangeVersion()))
          {
            paramProfile.setExchangeVersion("Exchange2007_SP1");
            login(paramProfile, paramLoginCallBack);
            return;
          }
          throw new MessageException(4, "exchange login error:" + (String)localObject);
        }
        Logger.log(4, "ExchangeProtocolManager", "login success name:" + paramProfile.getExchangeName());
        if (paramLoginCallBack != null) {
          paramLoginCallBack.onLoginSuccess(paramProfile);
        }
      }
    }
  }
  
  public void logout(Profile paramProfile, LogoutCallBack paramLogoutCallBack) {}
  
  public void modifyMailFlag(Profile paramProfile, Folder paramFolder, Mail[] paramArrayOfMail, int paramInt1, int paramInt2, MailOperationCallback paramMailOperationCallback)
  {
    try
    {
      paramProfile = parseExchangeInfo(paramProfile);
      paramFolder = ExchangeHandler.getInstance();
      int j = paramArrayOfMail.length;
      String[] arrayOfString1 = new String[j];
      String[] arrayOfString2 = new String[j];
      int i = 0;
      while (i < j)
      {
        arrayOfString1[i] = paramArrayOfMail[i].getRemoteId();
        arrayOfString2[i] = paramArrayOfMail[i].getSvrKey();
        i += 1;
      }
      throwIfError(paramFolder.updateItem(paramProfile, arrayOfString1, arrayOfString2, paramInt1, paramInt2), "modifyMailFlag error");
      Logger.log(4, "ExchangeProtocolManager", "modify mail flag success size:" + paramArrayOfMail.length + " flag:" + paramInt1 + " value:" + paramInt2);
      if (paramMailOperationCallback != null) {
        paramMailOperationCallback.onMailOperationSuccess(paramArrayOfMail);
      }
      return;
    }
    catch (MessageException paramProfile)
    {
      do
      {
        Logger.log(6, "ExchangeProtocolManager", "modify mail flag error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
      } while (paramMailOperationCallback == null);
      paramMailOperationCallback.onMailOperationError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
      return;
    }
    catch (Exception paramProfile)
    {
      do
      {
        Logger.log(6, "ExchangeProtocolManager", Log.getStackTraceString(paramProfile));
      } while (paramMailOperationCallback == null);
      paramMailOperationCallback.onMailOperationError(1, 200001, paramProfile.getMessage());
    }
  }
  
  public void moveMail(Profile paramProfile, Folder paramFolder1, Folder paramFolder2, Mail[] paramArrayOfMail, MailOperationCallback paramMailOperationCallback)
  {
    try
    {
      paramProfile = parseExchangeInfo(paramProfile);
      ExchangeHandler localExchangeHandler = ExchangeHandler.getInstance();
      int j = paramArrayOfMail.length;
      String[] arrayOfString1 = new String[j];
      String[] arrayOfString2 = new String[j];
      int i = 0;
      while (i < j)
      {
        arrayOfString1[i] = paramArrayOfMail[i].getRemoteId();
        arrayOfString2[i] = paramArrayOfMail[i].getSvrKey();
        i += 1;
      }
      throwIfError(localExchangeHandler.moveItem(paramProfile, arrayOfString1, arrayOfString2, paramFolder2.getRemoteId()), "moveMail error");
      Logger.log(4, "ExchangeProtocolManager", "move mail success source:" + paramFolder1.getPath() + " dest:" + paramFolder2.getPath() + " size:" + paramArrayOfMail.length);
      if (paramMailOperationCallback != null) {
        paramMailOperationCallback.onMailOperationSuccess(paramArrayOfMail);
      }
      return;
    }
    catch (MessageException paramProfile)
    {
      do
      {
        Logger.log(6, "ExchangeProtocolManager", "move mail error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
      } while (paramMailOperationCallback == null);
      paramMailOperationCallback.onMailOperationError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
      return;
    }
    catch (Exception paramProfile)
    {
      do
      {
        Logger.log(6, "ExchangeProtocolManager", Log.getStackTraceString(paramProfile));
      } while (paramMailOperationCallback == null);
      paramMailOperationCallback.onMailOperationError(1, 200001, paramProfile.getMessage());
    }
  }
  
  public void removeFolder(Profile paramProfile, State paramState, Folder paramFolder, FolderCallBack paramFolderCallBack)
  {
    try
    {
      paramProfile = parseExchangeInfo(paramProfile);
      paramProfile = ExchangeHandler.getInstance().deleteFolder(paramProfile, paramFolder.getRemoteId());
      throwIfError(paramProfile, "remove folder error");
      if (!paramProfile.isDelete()) {
        throw new MessageException(7, "remove folder error:" + paramProfile.getResponseCode());
      }
    }
    catch (MessageException paramProfile)
    {
      Logger.log(6, "ExchangeProtocolManager", "remove folder error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
      if (paramFolderCallBack != null) {
        paramFolderCallBack.operateFolderError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
      }
      do
      {
        return;
        Logger.log(4, "ExchangeProtocolManager", "remove folder success remoteId" + paramFolder.getRemoteId() + " name:" + paramFolder.getName());
      } while (paramFolderCallBack == null);
      paramFolderCallBack.operateFolderSuccess(paramFolder);
      return;
    }
    catch (Exception paramProfile)
    {
      do
      {
        Logger.log(6, "ExchangeProtocolManager", Log.getStackTraceString(paramProfile));
      } while (paramFolderCallBack == null);
      paramFolderCallBack.operateFolderError(1, 200001, paramProfile.getMessage());
    }
  }
  
  public void renameFolder(Profile paramProfile, State paramState, Folder paramFolder, String paramString, FolderCallBack paramFolderCallBack)
  {
    try
    {
      paramProfile = parseExchangeInfo(paramProfile);
      paramProfile = ExchangeHandler.getInstance().renameFolder(paramProfile, paramFolder.getRemoteId(), paramFolder.getSvrKey(), paramString);
      throwIfError(paramProfile, "rename folder error");
      paramProfile = paramProfile.getFolder();
      paramProfile.setName(paramString);
      Logger.log(4, "ExchangeProtocolManager", "rename folder success:" + paramFolder.getName() + ":" + paramString);
      if (paramFolderCallBack != null) {
        paramFolderCallBack.operateFolderSuccess(paramProfile);
      }
      return;
    }
    catch (MessageException paramProfile)
    {
      do
      {
        Logger.log(6, "ExchangeProtocolManager", "rename folder error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
      } while (paramFolderCallBack == null);
      paramFolderCallBack.operateFolderError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
      return;
    }
    catch (Exception paramProfile)
    {
      do
      {
        Logger.log(6, "ExchangeProtocolManager", Log.getStackTraceString(paramProfile));
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
        paramProfile = parseExchangeInfo(paramProfile);
        ExchangeHandler localExchangeHandler = ExchangeHandler.getInstance();
        long l = paramState.getLastMailUtc();
        int i = 0;
        int j = 0;
        paramArrayList = paramArrayList.iterator();
        FindItemResponse localFindItemResponse;
        ArrayList localArrayList;
        if (paramArrayList.hasNext())
        {
          localFindItemResponse = localExchangeHandler.findItem(paramProfile, (String)paramArrayList.next(), 0L, l, paramHashMap, paramState.getLoadMoreCount());
          throwIfError(localFindItemResponse, "search mail error");
          localArrayList = syncMailAbstract(paramProfile, localFindItemResponse.getMailArrayList());
          Iterator localIterator = localArrayList.iterator();
          if (localIterator.hasNext()) {
            paramSearchMailCallback.onSearchMail((Mail)localIterator.next());
          } else {}
        }
      }
      catch (MessageException paramProfile)
      {
        Logger.log(6, "ExchangeProtocolManager", "search mail error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
        if (paramSearchMailCallback != null) {
          paramSearchMailCallback.onSearchError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
        }
        return;
        j = localFindItemResponse.getTotalCnt() + j;
        i = localArrayList.size() + i;
        if (i >= paramState.getLoadMoreCount())
        {
          Logger.log(4, "ExchangeProtocolManager", "search mail success size:" + i);
          if (paramSearchMailCallback == null) {
            continue;
          }
          paramSearchMailCallback.onSearchSuccess(j, i);
        }
      }
      catch (Exception paramProfile)
      {
        Logger.log(6, "ExchangeProtocolManager", Log.getStackTraceString(paramProfile));
        if (paramSearchMailCallback != null)
        {
          paramSearchMailCallback.onSearchError(1, 200001, paramProfile.getMessage());
          return;
        }
      }
    }
  }
  
  public void sendMail(Profile paramProfile, Mail paramMail, SendMailCallBack paramSendMailCallBack)
  {
    try
    {
      paramProfile = parseExchangeInfo(paramProfile);
      ExchangeHandler localExchangeHandler = ExchangeHandler.getInstance();
      String str1 = "item_" + System.currentTimeMillis();
      String str2 = FileUtility.getExchangeDirPath() + str1 + ".compose";
      localExchangeHandler.createItem(paramProfile, str1, str2, MailParser.createMessage(paramMail), new ExchangeProtocolManager.3(this, paramSendMailCallBack, paramMail, str2));
      return;
    }
    catch (MessageException paramProfile)
    {
      do
      {
        Logger.log(6, "ExchangeProtocolManager", "send mail error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
      } while (paramSendMailCallBack == null);
      paramSendMailCallBack.onError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
      return;
    }
    catch (Exception paramProfile)
    {
      do
      {
        Logger.log(6, "ExchangeProtocolManager", Log.getStackTraceString(paramProfile));
      } while (paramSendMailCallBack == null);
      paramSendMailCallBack.onError(1, 200001, paramProfile.getMessage());
    }
  }
  
  public void syncFolderStatus(Profile paramProfile, State paramState, Folder paramFolder, FolderSyncExchangeCallBack paramFolderSyncExchangeCallBack)
  {
    try
    {
      paramProfile = parseExchangeInfo(paramProfile);
      paramProfile = ExchangeHandler.getInstance().getFolder(paramProfile, paramFolder.getRemoteId());
      throwIfError(paramProfile, "sync folder status error");
      paramProfile = paramProfile.getFolder();
      if (paramProfile == null) {
        return;
      }
      Logger.log(4, "ExchangeProtocolManager", "sync folder status success path:" + paramFolder.getPath() + " name:" + paramFolder.getName() + " totalCount:" + paramFolder.getTotalCount());
      if (paramFolderSyncExchangeCallBack != null)
      {
        paramFolderSyncExchangeCallBack.onSyncStatusSuccess(paramProfile.getTotalCount());
        return;
      }
    }
    catch (MessageException paramProfile)
    {
      Logger.log(6, "ExchangeProtocolManager", "sync folder status error:" + paramProfile.getResultCode() + ":" + paramProfile.getDetailCode() + ":" + paramProfile.getDetailMessage());
      if (paramFolderSyncExchangeCallBack != null)
      {
        paramFolderSyncExchangeCallBack.onSyncStatusError(paramProfile.getResultCode(), paramProfile.getDetailCode(), paramProfile.getDetailMessage());
        return;
      }
    }
    catch (Exception paramProfile)
    {
      Logger.log(6, "ExchangeProtocolManager", Log.getStackTraceString(paramProfile));
      if (paramFolderSyncExchangeCallBack != null) {
        paramFolderSyncExchangeCallBack.onSyncStatusError(1, 200001, paramProfile.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.ExchangeProtocolManager
 * JD-Core Version:    0.7.0.1
 */