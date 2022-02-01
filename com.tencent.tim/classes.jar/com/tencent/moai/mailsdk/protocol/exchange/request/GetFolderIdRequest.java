package com.tencent.moai.mailsdk.protocol.exchange.request;

import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeInfo;

public class GetFolderIdRequest
  extends ExchangeRequest
{
  private String distinguishedFolderId;
  
  public GetFolderIdRequest(ExchangeInfo paramExchangeInfo)
  {
    super(paramExchangeInfo, "GetFolder");
  }
  
  public byte[] buildCmdData()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder.append("<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:t=\"http://schemas.microsoft.com/exchange/services/2006/types\" xmlns:m=\"http://schemas.microsoft.com/exchange/services/2006/messages\">");
    localStringBuilder.append(String.format("<s:Header><t:RequestServerVersion s:mustUnderstand=\"1\" Version=\"%s\"></t:RequestServerVersion></s:Header>", new Object[] { this.exchangeInfo.getExchangeVersion() }));
    localStringBuilder.append("<s:Body>");
    localStringBuilder.append("<m:GetFolder>");
    localStringBuilder.append("<m:FolderShape><t:BaseShape>IdOnly</t:BaseShape>");
    localStringBuilder.append("<t:AdditionalProperties>");
    localStringBuilder.append("<t:FieldURI FieldURI=\"folder:").append("DistinguishedFolderId").append("\" />");
    localStringBuilder.append("</t:AdditionalProperties>");
    localStringBuilder.append("</m:FolderShape>");
    localStringBuilder.append("<m:FolderIds>");
    localStringBuilder.append("<t:DistinguishedFolderId Id=\"").append(this.distinguishedFolderId).append("\"></t:DistinguishedFolderId>");
    localStringBuilder.append("</m:FolderIds>");
    localStringBuilder.append("</m:GetFolder>");
    localStringBuilder.append("</s:Body>");
    localStringBuilder.append("</s:Envelope>");
    return localStringBuilder.toString().getBytes();
  }
  
  public String getDistinguishedFolderId()
  {
    return this.distinguishedFolderId;
  }
  
  public void setDistinguishedFolderId(String paramString)
  {
    this.distinguishedFolderId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.request.GetFolderIdRequest
 * JD-Core Version:    0.7.0.1
 */