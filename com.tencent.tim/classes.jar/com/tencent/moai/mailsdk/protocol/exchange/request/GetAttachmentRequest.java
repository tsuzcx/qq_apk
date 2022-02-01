package com.tencent.moai.mailsdk.protocol.exchange.request;

import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeInfo;

public class GetAttachmentRequest
  extends ExchangeRequest
{
  private String attachmentId;
  
  public GetAttachmentRequest(ExchangeInfo paramExchangeInfo)
  {
    super(paramExchangeInfo, "GetAttachment");
  }
  
  public byte[] buildCmdData()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder.append("<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:t=\"http://schemas.microsoft.com/exchange/services/2006/types\" xmlns:m=\"http://schemas.microsoft.com/exchange/services/2006/messages\">");
    localStringBuilder.append(String.format("<s:Header><t:RequestServerVersion s:mustUnderstand=\"1\" Version=\"%s\"></t:RequestServerVersion></s:Header>", new Object[] { this.exchangeInfo.getExchangeVersion() }));
    localStringBuilder.append("<s:Body>");
    localStringBuilder.append("<m:GetAttachment>");
    localStringBuilder.append("<m:AttachmentShape/>");
    localStringBuilder.append("<m:AttachmentIds>");
    localStringBuilder.append("<t:AttachmentId Id=\"").append(this.attachmentId).append("\" />");
    localStringBuilder.append("</m:AttachmentIds>");
    localStringBuilder.append("</m:GetAttachment>");
    localStringBuilder.append("</s:Body>");
    localStringBuilder.append("</s:Envelope>");
    return localStringBuilder.toString().getBytes();
  }
  
  public String getAttachmentId()
  {
    return this.attachmentId;
  }
  
  public void setAttachmentId(String paramString)
  {
    this.attachmentId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.request.GetAttachmentRequest
 * JD-Core Version:    0.7.0.1
 */