package com.tencent.moai.mailsdk.protocol.exchange.request;

import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeInfo;

public class SyncFolderItemRequest
  extends ExchangeRequest
{
  private String folderId;
  private String syncState;
  
  public SyncFolderItemRequest(ExchangeInfo paramExchangeInfo)
  {
    super(paramExchangeInfo, "SyncFolderItems");
  }
  
  public byte[] buildCmdData()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder.append("<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:t=\"http://schemas.microsoft.com/exchange/services/2006/types\" xmlns:m=\"http://schemas.microsoft.com/exchange/services/2006/messages\">");
    localStringBuilder.append(String.format("<s:Header><t:RequestServerVersion s:mustUnderstand=\"1\" Version=\"%s\"></t:RequestServerVersion></s:Header>", new Object[] { this.exchangeInfo.getExchangeVersion() }));
    localStringBuilder.append("<s:Body>");
    localStringBuilder.append("<m:SyncFolderItems>");
    localStringBuilder.append("<m:ItemShape>");
    localStringBuilder.append("<t:BaseShape>IdOnly</t:BaseShape>");
    localStringBuilder.append("<t:IncludeMimeContent>false</t:IncludeMimeContent>");
    localStringBuilder.append("<t:AdditionalProperties>");
    localStringBuilder.append("<t:FieldURI FieldURI=\"item:DateTimeSent\"></t:FieldURI>");
    localStringBuilder.append("</t:AdditionalProperties>");
    localStringBuilder.append("</m:ItemShape>");
    localStringBuilder.append("<m:SyncFolderId>");
    localStringBuilder.append("<t:FolderId Id=\"").append(this.folderId).append("\"></t:FolderId>");
    localStringBuilder.append("</m:SyncFolderId>");
    if (this.syncState != null) {
      localStringBuilder.append("<m:SyncState>").append(this.syncState).append("</m:SyncState>");
    }
    localStringBuilder.append("<m:MaxChangesReturned>").append(512).append("</m:MaxChangesReturned>");
    localStringBuilder.append("</m:SyncFolderItems>");
    localStringBuilder.append("</s:Body>");
    localStringBuilder.append("</s:Envelope>");
    return localStringBuilder.toString().getBytes();
  }
  
  public String getFolderId()
  {
    return this.folderId;
  }
  
  public String getSyncState()
  {
    return this.syncState;
  }
  
  public void setFolderId(String paramString)
  {
    this.folderId = paramString;
  }
  
  public void setSyncState(String paramString)
  {
    this.syncState = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.request.SyncFolderItemRequest
 * JD-Core Version:    0.7.0.1
 */