package com.tencent.moai.mailsdk.protocol.activesync;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.net.http.HttpCallBack;
import com.tencent.moai.mailsdk.net.http.HttpClient;
import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.protocol.activesync.model.ActiveSyncInfo;
import com.tencent.moai.mailsdk.protocol.activesync.request.FolderCreateRequest;
import com.tencent.moai.mailsdk.protocol.activesync.request.FolderDeleteRequest;
import com.tencent.moai.mailsdk.protocol.activesync.request.FolderSyncRequest;
import com.tencent.moai.mailsdk.protocol.activesync.request.FolderUpdateRequest;
import com.tencent.moai.mailsdk.protocol.activesync.request.GetItemEstimateRequest;
import com.tencent.moai.mailsdk.protocol.activesync.request.ItemOperationsMailAttachRequest;
import com.tencent.moai.mailsdk.protocol.activesync.request.ItemOperationsMailFetchRequest;
import com.tencent.moai.mailsdk.protocol.activesync.request.MoveMailRequest;
import com.tencent.moai.mailsdk.protocol.activesync.request.OptionRequest;
import com.tencent.moai.mailsdk.protocol.activesync.request.PolicyKeyAckRequest;
import com.tencent.moai.mailsdk.protocol.activesync.request.PolicyKeyRequest;
import com.tencent.moai.mailsdk.protocol.activesync.request.SearchMailRequest;
import com.tencent.moai.mailsdk.protocol.activesync.request.SendMailRequest;
import com.tencent.moai.mailsdk.protocol.activesync.request.SyncMailAbstractRequest;
import com.tencent.moai.mailsdk.protocol.activesync.request.SyncMailDeleteRequest;
import com.tencent.moai.mailsdk.protocol.activesync.request.SyncMailListInitRequest;
import com.tencent.moai.mailsdk.protocol.activesync.request.SyncMailListRequest;
import com.tencent.moai.mailsdk.protocol.activesync.request.SyncMailMarkRequest;
import com.tencent.moai.mailsdk.protocol.activesync.request.SyncMailTextRequest;
import com.tencent.moai.mailsdk.protocol.activesync.response.FolderCreateResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.FolderDeleteResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.FolderSyncResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.FolderUpdateResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.GetItemEstimateResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.ItemOperationsFetchMailResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.MoveMailResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.OptionResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.PolicyKeyAckResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.PolicyKeyResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.SearchMailResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.SyncMailAbstractResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.SyncMailDeleteResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.SyncMailListResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.SyncMailMarkResponse;
import com.tencent.moai.mailsdk.protocol.activesync.response.SyncMailTextResponse;
import com.tencent.moai.mailsdk.protocol.mime.model.MimeMessage;
import java.util.ArrayList;

public class ActiveSyncHandler
{
  private static final boolean DEBUG = true;
  private static final String TAG = "ActiveSyncHandler";
  private static ActiveSyncHandler instance = new ActiveSyncHandler();
  
  public static ActiveSyncHandler getInstance()
  {
    return instance;
  }
  
  public ItemOperationsFetchMailResponse fetchMailTextCommand(ActiveSyncInfo paramActiveSyncInfo, String paramString, boolean paramBoolean)
    throws MessageException
  {
    paramActiveSyncInfo = new ItemOperationsMailFetchRequest(paramActiveSyncInfo);
    paramActiveSyncInfo.setServerId(paramString);
    paramActiveSyncInfo.setSearchMail(paramBoolean);
    paramString = HttpClient.fetchResponse(HttpClient.buildRequest(paramActiveSyncInfo));
    paramActiveSyncInfo = new ItemOperationsFetchMailResponse(paramActiveSyncInfo.getCmdType(), paramActiveSyncInfo.getCmdSubType(), paramString);
    paramActiveSyncInfo.setSearchMail(paramBoolean);
    paramActiveSyncInfo.parseResponse();
    return paramActiveSyncInfo;
  }
  
  public FolderCreateResponse folderCreateCommand(ActiveSyncInfo paramActiveSyncInfo, String paramString1, String paramString2, String paramString3)
    throws MessageException
  {
    paramActiveSyncInfo = new FolderCreateRequest(paramActiveSyncInfo);
    paramActiveSyncInfo.setSyncKey(paramString1);
    paramActiveSyncInfo.setParentId(paramString2);
    paramActiveSyncInfo.setName(paramString3);
    paramString1 = HttpClient.fetchResponse(HttpClient.buildRequest(paramActiveSyncInfo));
    paramActiveSyncInfo = new FolderCreateResponse(paramActiveSyncInfo.getCmdType(), paramActiveSyncInfo.getCmdSubType(), paramString1);
    paramActiveSyncInfo.parseResponse();
    return paramActiveSyncInfo;
  }
  
  public FolderDeleteResponse folderDeleteCommand(ActiveSyncInfo paramActiveSyncInfo, String paramString1, String paramString2)
    throws MessageException
  {
    paramActiveSyncInfo = new FolderDeleteRequest(paramActiveSyncInfo);
    paramActiveSyncInfo.setSyncKey(paramString1);
    paramActiveSyncInfo.setServerId(paramString2);
    paramString1 = HttpClient.fetchResponse(HttpClient.buildRequest(paramActiveSyncInfo));
    paramActiveSyncInfo = new FolderDeleteResponse(paramActiveSyncInfo.getCmdType(), paramActiveSyncInfo.getCmdSubType(), paramString1);
    paramActiveSyncInfo.parseResponse();
    return paramActiveSyncInfo;
  }
  
  public FolderSyncResponse folderSyncCommand(ActiveSyncInfo paramActiveSyncInfo, String paramString)
    throws MessageException
  {
    paramActiveSyncInfo = new FolderSyncRequest(paramActiveSyncInfo);
    paramActiveSyncInfo.setSyncKey(paramString);
    paramString = HttpClient.fetchResponse(HttpClient.buildRequest(paramActiveSyncInfo));
    paramActiveSyncInfo = new FolderSyncResponse(paramActiveSyncInfo.getCmdType(), paramActiveSyncInfo.getCmdSubType(), paramString);
    paramActiveSyncInfo.parseResponse();
    return paramActiveSyncInfo;
  }
  
  public FolderUpdateResponse folderUpdateCommand(ActiveSyncInfo paramActiveSyncInfo, String paramString1, String paramString2, String paramString3, String paramString4)
    throws MessageException
  {
    paramActiveSyncInfo = new FolderUpdateRequest(paramActiveSyncInfo);
    paramActiveSyncInfo.setSyncKey(paramString1);
    paramActiveSyncInfo.setParentId(paramString2);
    paramActiveSyncInfo.setServerId(paramString3);
    paramActiveSyncInfo.setNewName(paramString4);
    paramString1 = HttpClient.fetchResponse(HttpClient.buildRequest(paramActiveSyncInfo));
    paramActiveSyncInfo = new FolderUpdateResponse(paramActiveSyncInfo.getCmdType(), paramActiveSyncInfo.getCmdSubType(), paramString1);
    paramActiveSyncInfo.parseResponse();
    return paramActiveSyncInfo;
  }
  
  public GetItemEstimateResponse getItemEstimateCommand(ActiveSyncInfo paramActiveSyncInfo, String paramString1, String paramString2, int paramInt)
    throws MessageException
  {
    paramActiveSyncInfo = new GetItemEstimateRequest(paramActiveSyncInfo);
    paramActiveSyncInfo.setSyncKey(paramString1);
    paramActiveSyncInfo.setCollectionId(paramString2);
    paramActiveSyncInfo.setFilterType(paramInt);
    paramString1 = HttpClient.fetchResponse(HttpClient.buildRequest(paramActiveSyncInfo));
    paramActiveSyncInfo = new GetItemEstimateResponse(paramActiveSyncInfo.getCmdType(), paramActiveSyncInfo.getCmdSubType(), paramString1);
    paramActiveSyncInfo.parseResponse();
    return paramActiveSyncInfo;
  }
  
  public void itemOperationsMailAttachCommand(ActiveSyncInfo paramActiveSyncInfo, String paramString, HttpCallBack paramHttpCallBack)
    throws MessageException
  {
    paramActiveSyncInfo = new ItemOperationsMailAttachRequest(paramActiveSyncInfo);
    paramActiveSyncInfo.setAttachId(paramString);
    HttpClient.fetchStreamResponse(HttpClient.buildRequest(paramActiveSyncInfo), paramHttpCallBack);
  }
  
  public MoveMailResponse moveMailCommand(ActiveSyncInfo paramActiveSyncInfo, String paramString1, String paramString2, ArrayList<String> paramArrayList)
    throws MessageException
  {
    paramActiveSyncInfo = new MoveMailRequest(paramActiveSyncInfo);
    paramActiveSyncInfo.setSourceFolderId(paramString1);
    paramActiveSyncInfo.setDestinationFolderId(paramString2);
    paramActiveSyncInfo.setServerIdList(paramArrayList);
    paramString1 = HttpClient.fetchResponse(HttpClient.buildRequest(paramActiveSyncInfo));
    paramActiveSyncInfo = new MoveMailResponse(paramActiveSyncInfo.getCmdType(), paramActiveSyncInfo.getCmdSubType(), paramString1);
    paramActiveSyncInfo.parseResponse();
    return paramActiveSyncInfo;
  }
  
  public OptionResponse optionCommand(ActiveSyncInfo paramActiveSyncInfo)
    throws MessageException
  {
    paramActiveSyncInfo = new OptionRequest(paramActiveSyncInfo);
    HttpResponse localHttpResponse = HttpClient.fetchResponse(HttpClient.buildRequest(paramActiveSyncInfo));
    paramActiveSyncInfo = new OptionResponse(paramActiveSyncInfo.getCmdType(), paramActiveSyncInfo.getCmdSubType(), localHttpResponse);
    paramActiveSyncInfo.parseResponse();
    return paramActiveSyncInfo;
  }
  
  public PolicyKeyAckResponse policyKeyAckCommand(ActiveSyncInfo paramActiveSyncInfo, String paramString)
    throws MessageException
  {
    paramActiveSyncInfo = new PolicyKeyAckRequest(paramActiveSyncInfo);
    paramActiveSyncInfo.setPolicyKey(paramString);
    paramString = HttpClient.fetchResponse(HttpClient.buildRequest(paramActiveSyncInfo));
    paramActiveSyncInfo = new PolicyKeyAckResponse(paramActiveSyncInfo.getCmdType(), paramActiveSyncInfo.getCmdSubType(), paramString);
    paramActiveSyncInfo.parseResponse();
    return paramActiveSyncInfo;
  }
  
  public PolicyKeyResponse policyKeyCommand(ActiveSyncInfo paramActiveSyncInfo)
    throws MessageException
  {
    paramActiveSyncInfo = new PolicyKeyRequest(paramActiveSyncInfo);
    HttpResponse localHttpResponse = HttpClient.fetchResponse(HttpClient.buildRequest(paramActiveSyncInfo));
    paramActiveSyncInfo = new PolicyKeyResponse(paramActiveSyncInfo.getCmdType(), paramActiveSyncInfo.getCmdSubType(), localHttpResponse);
    paramActiveSyncInfo.parseResponse();
    return paramActiveSyncInfo;
  }
  
  public SearchMailResponse searchMail(ActiveSyncInfo paramActiveSyncInfo, String paramString1, long paramLong1, long paramLong2, String paramString2, int paramInt)
    throws MessageException
  {
    paramActiveSyncInfo = new SearchMailRequest(paramActiveSyncInfo);
    paramActiveSyncInfo.setCollectionId(paramString1);
    paramActiveSyncInfo.setKeyWord(paramString2);
    paramActiveSyncInfo.setStartTime(paramLong1);
    paramActiveSyncInfo.setEndTime(paramLong2);
    paramString1 = HttpClient.fetchResponse(HttpClient.buildRequest(paramActiveSyncInfo));
    paramActiveSyncInfo = new SearchMailResponse(paramActiveSyncInfo.getCmdType(), paramActiveSyncInfo.getCmdSubType(), paramString1);
    paramActiveSyncInfo.parseResponse();
    return paramActiveSyncInfo;
  }
  
  public void sendMailCommand(ActiveSyncInfo paramActiveSyncInfo, String paramString1, String paramString2, MimeMessage paramMimeMessage, HttpCallBack paramHttpCallBack)
    throws MessageException
  {
    paramActiveSyncInfo = new SendMailRequest(paramActiveSyncInfo);
    paramActiveSyncInfo.setClientId(paramString1);
    paramActiveSyncInfo.setTmpFilePath(paramString2);
    paramActiveSyncInfo.setMimeMessage(paramMimeMessage);
    HttpClient.fetchResponse(HttpClient.buildStreamRequest(paramActiveSyncInfo), paramHttpCallBack);
  }
  
  public SyncMailAbstractResponse syncMailAbstractCommand(ActiveSyncInfo paramActiveSyncInfo, String paramString1, String paramString2, ArrayList<String> paramArrayList)
    throws MessageException
  {
    paramActiveSyncInfo = new SyncMailAbstractRequest(paramActiveSyncInfo);
    paramActiveSyncInfo.setSyncKey(paramString1);
    paramActiveSyncInfo.setCollectionId(paramString2);
    paramActiveSyncInfo.setServerIdList(paramArrayList);
    paramString1 = HttpClient.fetchResponse(HttpClient.buildRequest(paramActiveSyncInfo));
    paramActiveSyncInfo = new SyncMailAbstractResponse(paramActiveSyncInfo.getCmdType(), paramActiveSyncInfo.getCmdSubType(), paramString1);
    paramActiveSyncInfo.parseResponse();
    return paramActiveSyncInfo;
  }
  
  public SyncMailDeleteResponse syncMailDeleteCommand(ActiveSyncInfo paramActiveSyncInfo, String paramString1, String paramString2, boolean paramBoolean, ArrayList<String> paramArrayList)
    throws MessageException
  {
    paramActiveSyncInfo = new SyncMailDeleteRequest(paramActiveSyncInfo);
    paramActiveSyncInfo.setSyncKey(paramString1);
    paramActiveSyncInfo.setCollectionId(paramString2);
    paramActiveSyncInfo.setHardDelete(paramBoolean);
    paramActiveSyncInfo.setServerIdList(paramArrayList);
    paramString1 = HttpClient.fetchResponse(HttpClient.buildRequest(paramActiveSyncInfo));
    paramActiveSyncInfo = new SyncMailDeleteResponse(paramActiveSyncInfo.getCmdType(), paramActiveSyncInfo.getCmdSubType(), paramString1);
    paramActiveSyncInfo.parseResponse();
    return paramActiveSyncInfo;
  }
  
  public SyncMailListResponse syncMailListCommand(ActiveSyncInfo paramActiveSyncInfo, String paramString1, String paramString2, String paramString3)
    throws MessageException
  {
    paramActiveSyncInfo = new SyncMailListRequest(paramActiveSyncInfo);
    paramActiveSyncInfo.setSyncKey(paramString1);
    paramActiveSyncInfo.setCollectionId(paramString2);
    paramActiveSyncInfo.setFilterType(paramString3);
    paramString1 = HttpClient.fetchResponse(HttpClient.buildRequest(paramActiveSyncInfo));
    paramActiveSyncInfo = new SyncMailListResponse(paramActiveSyncInfo.getCmdType(), paramActiveSyncInfo.getCmdSubType(), paramString1);
    paramActiveSyncInfo.parseResponse();
    return paramActiveSyncInfo;
  }
  
  public SyncMailListResponse syncMailListInitCommand(ActiveSyncInfo paramActiveSyncInfo, String paramString1, String paramString2, String paramString3)
    throws MessageException
  {
    paramActiveSyncInfo = new SyncMailListInitRequest(paramActiveSyncInfo);
    paramActiveSyncInfo.setSyncKey(paramString1);
    paramActiveSyncInfo.setCollectionId(paramString2);
    paramActiveSyncInfo.setFilterType(paramString3);
    paramString1 = HttpClient.fetchResponse(HttpClient.buildRequest(paramActiveSyncInfo));
    paramActiveSyncInfo = new SyncMailListResponse(paramActiveSyncInfo.getCmdType(), paramActiveSyncInfo.getCmdSubType(), paramString1);
    paramActiveSyncInfo.parseResponse();
    return paramActiveSyncInfo;
  }
  
  public SyncMailMarkResponse syncMailMarkCommand(ActiveSyncInfo paramActiveSyncInfo, String paramString1, String paramString2, int paramInt1, int paramInt2, ArrayList<String> paramArrayList)
    throws MessageException
  {
    paramActiveSyncInfo = new SyncMailMarkRequest(paramActiveSyncInfo);
    paramActiveSyncInfo.setSyncKey(paramString1);
    paramActiveSyncInfo.setCollectionId(paramString2);
    paramActiveSyncInfo.setMarkType(paramInt1);
    paramActiveSyncInfo.setMarkValue(paramInt2);
    paramActiveSyncInfo.setServerIdList(paramArrayList);
    paramString1 = HttpClient.fetchResponse(HttpClient.buildRequest(paramActiveSyncInfo));
    paramActiveSyncInfo = new SyncMailMarkResponse(paramActiveSyncInfo.getCmdType(), paramActiveSyncInfo.getCmdSubType(), paramString1);
    paramActiveSyncInfo.parseResponse();
    return paramActiveSyncInfo;
  }
  
  public SyncMailTextResponse syncMailTextCommand(ActiveSyncInfo paramActiveSyncInfo, String paramString1, String paramString2, ArrayList<String> paramArrayList)
    throws MessageException
  {
    paramActiveSyncInfo = new SyncMailTextRequest(paramActiveSyncInfo);
    paramActiveSyncInfo.setSyncKey(paramString1);
    paramActiveSyncInfo.setCollectionId(paramString2);
    paramActiveSyncInfo.setServerIdList(paramArrayList);
    paramString1 = HttpClient.fetchResponse(HttpClient.buildRequest(paramActiveSyncInfo));
    paramActiveSyncInfo = new SyncMailTextResponse(paramActiveSyncInfo.getCmdType(), paramActiveSyncInfo.getCmdSubType(), paramString1);
    paramActiveSyncInfo.parseResponse();
    return paramActiveSyncInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.ActiveSyncHandler
 * JD-Core Version:    0.7.0.1
 */