package com.tencent.moai.mailsdk.protocol.exchange;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.net.http.HttpCallBack;
import com.tencent.moai.mailsdk.net.http.HttpClient;
import com.tencent.moai.mailsdk.net.http.HttpResponse;
import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeInfo;
import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeRule;
import com.tencent.moai.mailsdk.protocol.exchange.request.CreateRuleRequest;
import com.tencent.moai.mailsdk.protocol.exchange.request.FindFolderRequest;
import com.tencent.moai.mailsdk.protocol.exchange.request.FindItemRequest;
import com.tencent.moai.mailsdk.protocol.exchange.request.FolderCreateRequest;
import com.tencent.moai.mailsdk.protocol.exchange.request.FolderDeleteRequest;
import com.tencent.moai.mailsdk.protocol.exchange.request.FolderUpdateRequest;
import com.tencent.moai.mailsdk.protocol.exchange.request.GetAttachmentRequest;
import com.tencent.moai.mailsdk.protocol.exchange.request.GetFolderIdRequest;
import com.tencent.moai.mailsdk.protocol.exchange.request.GetFolderRequest;
import com.tencent.moai.mailsdk.protocol.exchange.request.GetItemRequest;
import com.tencent.moai.mailsdk.protocol.exchange.request.GetItemRequest.FetchType;
import com.tencent.moai.mailsdk.protocol.exchange.request.ItemCreateRequest;
import com.tencent.moai.mailsdk.protocol.exchange.request.ItemDeleteRequest;
import com.tencent.moai.mailsdk.protocol.exchange.request.ItemMoveRequest;
import com.tencent.moai.mailsdk.protocol.exchange.request.ItemUpdateRequest;
import com.tencent.moai.mailsdk.protocol.exchange.request.SyncFolderItemRequest;
import com.tencent.moai.mailsdk.protocol.exchange.response.CreateRuleResponse;
import com.tencent.moai.mailsdk.protocol.exchange.response.FindFolderResponse;
import com.tencent.moai.mailsdk.protocol.exchange.response.FindItemResponse;
import com.tencent.moai.mailsdk.protocol.exchange.response.FolderCreateResponse;
import com.tencent.moai.mailsdk.protocol.exchange.response.FolderDeleteResponse;
import com.tencent.moai.mailsdk.protocol.exchange.response.FolderUpdateResponse;
import com.tencent.moai.mailsdk.protocol.exchange.response.GetFolderIdResponse;
import com.tencent.moai.mailsdk.protocol.exchange.response.GetFolderResponse;
import com.tencent.moai.mailsdk.protocol.exchange.response.GetItemResponse;
import com.tencent.moai.mailsdk.protocol.exchange.response.ItemDeleteResponse;
import com.tencent.moai.mailsdk.protocol.exchange.response.ItemMoveResponse;
import com.tencent.moai.mailsdk.protocol.exchange.response.ItemUpdateResponse;
import com.tencent.moai.mailsdk.protocol.exchange.response.SyncFolderItemResponse;
import com.tencent.moai.mailsdk.protocol.mime.model.MimeMessage;
import java.util.ArrayList;
import java.util.HashMap;

public class ExchangeHandler
{
  private static ExchangeHandler instance = new ExchangeHandler();
  
  public static ExchangeHandler getInstance()
  {
    return instance;
  }
  
  public FolderCreateResponse createFolder(ExchangeInfo paramExchangeInfo, String paramString)
    throws MessageException
  {
    paramExchangeInfo = new FolderCreateRequest(paramExchangeInfo);
    paramExchangeInfo.setFolderName(paramString);
    paramString = HttpClient.fetchResponse(HttpClient.buildRequest(paramExchangeInfo));
    paramExchangeInfo = new FolderCreateResponse(paramExchangeInfo.getCmdType(), paramString);
    paramExchangeInfo.parseResponse();
    return paramExchangeInfo;
  }
  
  public void createItem(ExchangeInfo paramExchangeInfo, String paramString1, String paramString2, MimeMessage paramMimeMessage, HttpCallBack paramHttpCallBack)
    throws MessageException
  {
    paramExchangeInfo = new ItemCreateRequest(paramExchangeInfo);
    paramExchangeInfo.setItemId(paramString1);
    paramExchangeInfo.setTmpFilePath(paramString2);
    paramExchangeInfo.setMimeMessage(paramMimeMessage);
    HttpClient.fetchResponse(HttpClient.buildStreamRequest(paramExchangeInfo), paramHttpCallBack);
  }
  
  public CreateRuleResponse createRule(ExchangeInfo paramExchangeInfo, ArrayList<ExchangeRule> paramArrayList)
    throws MessageException
  {
    paramExchangeInfo = new CreateRuleRequest(paramExchangeInfo);
    paramExchangeInfo.setExchangeRules(paramArrayList);
    paramArrayList = HttpClient.fetchResponse(HttpClient.buildRequest(paramExchangeInfo));
    paramExchangeInfo = new CreateRuleResponse(paramExchangeInfo.getCmdType(), paramArrayList);
    paramExchangeInfo.parseResponse();
    return paramExchangeInfo;
  }
  
  public FolderDeleteResponse deleteFolder(ExchangeInfo paramExchangeInfo, String paramString)
    throws MessageException
  {
    paramExchangeInfo = new FolderDeleteRequest(paramExchangeInfo);
    paramExchangeInfo.setFolderId(paramString);
    paramString = HttpClient.fetchResponse(HttpClient.buildRequest(paramExchangeInfo));
    paramExchangeInfo = new FolderDeleteResponse(paramExchangeInfo.getCmdType(), paramString);
    paramExchangeInfo.parseResponse();
    return paramExchangeInfo;
  }
  
  public ItemDeleteResponse deleteItem(ExchangeInfo paramExchangeInfo, String[] paramArrayOfString)
    throws MessageException
  {
    paramExchangeInfo = new ItemDeleteRequest(paramExchangeInfo);
    paramExchangeInfo.setItemIds(paramArrayOfString);
    paramArrayOfString = HttpClient.fetchResponse(HttpClient.buildRequest(paramExchangeInfo));
    paramExchangeInfo = new ItemDeleteResponse(paramExchangeInfo.getCmdType(), paramArrayOfString);
    paramExchangeInfo.parseResponse();
    return paramExchangeInfo;
  }
  
  public FindFolderResponse findFolder(ExchangeInfo paramExchangeInfo, String paramString)
    throws MessageException
  {
    paramExchangeInfo = new FindFolderRequest(paramExchangeInfo);
    paramExchangeInfo.setDistinguishedFolderId(paramString);
    paramString = HttpClient.fetchResponse(HttpClient.buildRequest(paramExchangeInfo));
    paramExchangeInfo = new FindFolderResponse(paramExchangeInfo.getCmdType(), paramString);
    paramExchangeInfo.parseResponse();
    return paramExchangeInfo;
  }
  
  public FindItemResponse findItem(ExchangeInfo paramExchangeInfo, String paramString, long paramLong1, long paramLong2, HashMap<Integer, String> paramHashMap, int paramInt)
    throws MessageException
  {
    paramExchangeInfo = new FindItemRequest(paramExchangeInfo);
    paramExchangeInfo.setFolderId(paramString);
    paramExchangeInfo.setStartTime(paramLong1);
    paramExchangeInfo.setEndTime(paramLong2);
    paramExchangeInfo.setSearchInfo(paramHashMap);
    paramExchangeInfo.setFindMaxCount(paramInt);
    paramString = HttpClient.fetchResponse(HttpClient.buildRequest(paramExchangeInfo));
    paramExchangeInfo = new FindItemResponse(paramExchangeInfo.getCmdType(), paramString);
    paramExchangeInfo.parseResponse();
    return paramExchangeInfo;
  }
  
  public void getAttachment(ExchangeInfo paramExchangeInfo, String paramString, HttpCallBack paramHttpCallBack)
    throws MessageException
  {
    paramExchangeInfo = new GetAttachmentRequest(paramExchangeInfo);
    paramExchangeInfo.setAttachmentId(paramString);
    HttpClient.fetchStreamResponse(HttpClient.buildRequest(paramExchangeInfo), paramHttpCallBack);
  }
  
  public GetFolderResponse getFolder(ExchangeInfo paramExchangeInfo, String paramString)
    throws MessageException
  {
    paramExchangeInfo = new GetFolderRequest(paramExchangeInfo);
    paramExchangeInfo.setFolderId(paramString);
    paramString = HttpClient.fetchResponse(HttpClient.buildRequest(paramExchangeInfo));
    paramExchangeInfo = new GetFolderResponse(paramExchangeInfo.getCmdType(), paramString);
    paramExchangeInfo.parseResponse();
    return paramExchangeInfo;
  }
  
  public GetFolderIdResponse getFolderId(ExchangeInfo paramExchangeInfo, String paramString)
    throws MessageException
  {
    paramExchangeInfo = new GetFolderIdRequest(paramExchangeInfo);
    paramExchangeInfo.setDistinguishedFolderId(paramString);
    paramString = HttpClient.fetchResponse(HttpClient.buildRequest(paramExchangeInfo));
    paramExchangeInfo = new GetFolderIdResponse(paramExchangeInfo.getCmdType(), paramString);
    paramExchangeInfo.parseResponse();
    return paramExchangeInfo;
  }
  
  public GetItemResponse getItem(ExchangeInfo paramExchangeInfo, String[] paramArrayOfString1, String[] paramArrayOfString2, GetItemRequest.FetchType paramFetchType)
    throws MessageException
  {
    paramExchangeInfo = new GetItemRequest(paramExchangeInfo);
    paramExchangeInfo.setItemIds(paramArrayOfString1);
    paramExchangeInfo.setChangeKeys(paramArrayOfString2);
    paramExchangeInfo.setFetchType(paramFetchType);
    paramArrayOfString1 = HttpClient.fetchResponse(HttpClient.buildRequest(paramExchangeInfo));
    paramExchangeInfo = new GetItemResponse(paramExchangeInfo.getCmdType(), paramArrayOfString1);
    paramExchangeInfo.parseResponse();
    return paramExchangeInfo;
  }
  
  public FindFolderResponse login(ExchangeInfo paramExchangeInfo)
    throws MessageException
  {
    paramExchangeInfo = new FindFolderRequest(paramExchangeInfo);
    paramExchangeInfo.setDistinguishedFolderId("inbox");
    HttpResponse localHttpResponse = HttpClient.fetchResponse(HttpClient.buildRequest(paramExchangeInfo));
    paramExchangeInfo = new FindFolderResponse(paramExchangeInfo.getCmdType(), localHttpResponse);
    paramExchangeInfo.parseResponse();
    return paramExchangeInfo;
  }
  
  public ItemMoveResponse moveItem(ExchangeInfo paramExchangeInfo, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString)
    throws MessageException
  {
    paramExchangeInfo = new ItemMoveRequest(paramExchangeInfo);
    paramExchangeInfo.setItemIds(paramArrayOfString1);
    paramExchangeInfo.setChangeKeys(paramArrayOfString2);
    paramExchangeInfo.setToFolderId(paramString);
    paramArrayOfString1 = HttpClient.fetchResponse(HttpClient.buildRequest(paramExchangeInfo));
    paramExchangeInfo = new ItemMoveResponse(paramExchangeInfo.getCmdType(), paramArrayOfString1);
    paramExchangeInfo.parseResponse();
    return paramExchangeInfo;
  }
  
  public FolderUpdateResponse renameFolder(ExchangeInfo paramExchangeInfo, String paramString1, String paramString2, String paramString3)
    throws MessageException
  {
    paramExchangeInfo = new FolderUpdateRequest(paramExchangeInfo);
    paramExchangeInfo.setFolderId(paramString1);
    paramExchangeInfo.setChangeKey(paramString2);
    paramExchangeInfo.setNewName(paramString3);
    paramString1 = HttpClient.fetchResponse(HttpClient.buildRequest(paramExchangeInfo));
    paramExchangeInfo = new FolderUpdateResponse(paramExchangeInfo.getCmdType(), paramString1);
    paramExchangeInfo.parseResponse();
    return paramExchangeInfo;
  }
  
  public SyncFolderItemResponse syncFolderItem(ExchangeInfo paramExchangeInfo, String paramString1, String paramString2)
    throws MessageException
  {
    paramExchangeInfo = new SyncFolderItemRequest(paramExchangeInfo);
    paramExchangeInfo.setFolderId(paramString1);
    paramExchangeInfo.setSyncState(paramString2);
    paramString1 = HttpClient.fetchResponse(HttpClient.buildRequest(paramExchangeInfo));
    paramExchangeInfo = new SyncFolderItemResponse(paramExchangeInfo.getCmdType(), paramString1);
    paramExchangeInfo.parseResponse();
    return paramExchangeInfo;
  }
  
  public ItemUpdateResponse updateItem(ExchangeInfo paramExchangeInfo, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt1, int paramInt2)
    throws MessageException
  {
    paramExchangeInfo = new ItemUpdateRequest(paramExchangeInfo);
    paramExchangeInfo.setItemIds(paramArrayOfString1);
    paramExchangeInfo.setChangeKeys(paramArrayOfString2);
    paramExchangeInfo.setFlagType(paramInt1);
    paramExchangeInfo.setFlagValue(paramInt2);
    paramArrayOfString1 = HttpClient.fetchResponse(HttpClient.buildRequest(paramExchangeInfo));
    paramExchangeInfo = new ItemUpdateResponse(paramExchangeInfo.getCmdType(), paramArrayOfString1);
    paramExchangeInfo.parseResponse();
    return paramExchangeInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.ExchangeHandler
 * JD-Core Version:    0.7.0.1
 */