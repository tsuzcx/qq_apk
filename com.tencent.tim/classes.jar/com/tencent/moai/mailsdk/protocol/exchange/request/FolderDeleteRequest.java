package com.tencent.moai.mailsdk.protocol.exchange.request;

import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeInfo;

public class FolderDeleteRequest
  extends ExchangeRequest
{
  private String folderId;
  
  public FolderDeleteRequest(ExchangeInfo paramExchangeInfo)
  {
    super(paramExchangeInfo, "DeleteFolder");
  }
  
  public byte[] buildCmdData()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder.append("<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:t=\"http://schemas.microsoft.com/exchange/services/2006/types\" xmlns:m=\"http://schemas.microsoft.com/exchange/services/2006/messages\">");
    localStringBuilder.append(String.format("<s:Header><t:RequestServerVersion s:mustUnderstand=\"1\" Version=\"%s\"></t:RequestServerVersion></s:Header>", new Object[] { this.exchangeInfo.getExchangeVersion() }));
    localStringBuilder.append("<s:Body>");
    localStringBuilder.append("<m:DeleteFolder DeleteType=\"HardDelete\" >");
    localStringBuilder.append("<m:FolderIds>");
    localStringBuilder.append("<t:FolderId Id=\"").append(this.folderId).append("\"/>");
    localStringBuilder.append("</m:FolderIds>");
    localStringBuilder.append("</m:DeleteFolder>");
    localStringBuilder.append("</s:Body>");
    localStringBuilder.append("</s:Envelope>");
    return localStringBuilder.toString().getBytes();
  }
  
  public String getFolderId()
  {
    return this.folderId;
  }
  
  public void setFolderId(String paramString)
  {
    this.folderId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.request.FolderDeleteRequest
 * JD-Core Version:    0.7.0.1
 */