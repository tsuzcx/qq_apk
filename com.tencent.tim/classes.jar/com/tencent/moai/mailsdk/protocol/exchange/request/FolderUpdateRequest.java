package com.tencent.moai.mailsdk.protocol.exchange.request;

import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeInfo;

public class FolderUpdateRequest
  extends ExchangeRequest
{
  private String changeKey;
  private String folderId;
  private String newName;
  
  public FolderUpdateRequest(ExchangeInfo paramExchangeInfo)
  {
    super(paramExchangeInfo, "UpdateFolder");
  }
  
  public byte[] buildCmdData()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder.append("<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:t=\"http://schemas.microsoft.com/exchange/services/2006/types\" xmlns:m=\"http://schemas.microsoft.com/exchange/services/2006/messages\">");
    localStringBuilder.append(String.format("<s:Header><t:RequestServerVersion s:mustUnderstand=\"1\" Version=\"%s\"></t:RequestServerVersion></s:Header>", new Object[] { this.exchangeInfo.getExchangeVersion() }));
    localStringBuilder.append("<s:Body>");
    localStringBuilder.append("<m:UpdateFolder>");
    localStringBuilder.append("<m:FolderChanges>");
    localStringBuilder.append("<t:FolderChange>");
    localStringBuilder.append("<t:FolderId Id=\"").append(this.folderId).append("\" ChangeKey=\"").append(this.changeKey).append("\"/>");
    localStringBuilder.append("<t:Updates>");
    localStringBuilder.append("<t:SetFolderField>");
    localStringBuilder.append("<t:FieldURI FieldURI=\"folder:DisplayName\"/>");
    localStringBuilder.append("<t:Folder>");
    localStringBuilder.append("<t:DisplayName>").append(this.newName).append("</t:DisplayName>");
    localStringBuilder.append("</t:Folder>");
    localStringBuilder.append("</t:SetFolderField>");
    localStringBuilder.append("</t:Updates>");
    localStringBuilder.append("</t:FolderChange>");
    localStringBuilder.append("</m:FolderChanges>");
    localStringBuilder.append("</m:UpdateFolder>");
    localStringBuilder.append("</s:Body>");
    localStringBuilder.append("</s:Envelope>");
    return localStringBuilder.toString().getBytes();
  }
  
  public String getChangeKey()
  {
    return this.changeKey;
  }
  
  public String getFolderId()
  {
    return this.folderId;
  }
  
  public String getNewName()
  {
    return this.newName;
  }
  
  public void setChangeKey(String paramString)
  {
    this.changeKey = paramString;
  }
  
  public void setFolderId(String paramString)
  {
    this.folderId = paramString;
  }
  
  public void setNewName(String paramString)
  {
    this.newName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.request.FolderUpdateRequest
 * JD-Core Version:    0.7.0.1
 */