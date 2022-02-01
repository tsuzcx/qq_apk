package com.tencent.moai.mailsdk.protocol.exchange.request;

import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeInfo;

public class FolderCreateRequest
  extends ExchangeRequest
{
  private String folderName;
  
  public FolderCreateRequest(ExchangeInfo paramExchangeInfo)
  {
    super(paramExchangeInfo, "CreateFolder");
  }
  
  public byte[] buildCmdData()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder.append("<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:t=\"http://schemas.microsoft.com/exchange/services/2006/types\" xmlns:m=\"http://schemas.microsoft.com/exchange/services/2006/messages\">");
    localStringBuilder.append(String.format("<s:Header><t:RequestServerVersion s:mustUnderstand=\"1\" Version=\"%s\"></t:RequestServerVersion></s:Header>", new Object[] { this.exchangeInfo.getExchangeVersion() }));
    localStringBuilder.append("<s:Body>");
    localStringBuilder.append("<m:CreateFolder>");
    localStringBuilder.append("<m:ParentFolderId>");
    localStringBuilder.append("<t:DistinguishedFolderId Id=\"msgfolderroot\"/>");
    localStringBuilder.append("</m:ParentFolderId>");
    localStringBuilder.append("<m:Folders>");
    localStringBuilder.append("<t:Folder>");
    localStringBuilder.append("<t:DisplayName>").append(this.folderName).append("</t:DisplayName>");
    localStringBuilder.append("</t:Folder>");
    localStringBuilder.append("</m:Folders>");
    localStringBuilder.append("</m:CreateFolder>");
    localStringBuilder.append("</s:Body>");
    localStringBuilder.append("</s:Envelope>");
    return localStringBuilder.toString().getBytes();
  }
  
  public String getFolderName()
  {
    return this.folderName;
  }
  
  public void setFolderName(String paramString)
  {
    this.folderName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.request.FolderCreateRequest
 * JD-Core Version:    0.7.0.1
 */