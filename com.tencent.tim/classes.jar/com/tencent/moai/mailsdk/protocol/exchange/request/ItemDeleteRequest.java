package com.tencent.moai.mailsdk.protocol.exchange.request;

import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeInfo;

public class ItemDeleteRequest
  extends ExchangeRequest
{
  private String[] itemIds;
  
  public ItemDeleteRequest(ExchangeInfo paramExchangeInfo)
  {
    super(paramExchangeInfo, "DeleteItem");
  }
  
  public byte[] buildCmdData()
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder.append("<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:t=\"http://schemas.microsoft.com/exchange/services/2006/types\" xmlns:m=\"http://schemas.microsoft.com/exchange/services/2006/messages\">");
    localStringBuilder.append(String.format("<s:Header><t:RequestServerVersion s:mustUnderstand=\"1\" Version=\"%s\"></t:RequestServerVersion></s:Header>", new Object[] { this.exchangeInfo.getExchangeVersion() }));
    localStringBuilder.append("<s:Body>");
    localStringBuilder.append("<m:DeleteItem  DeleteType=\"HardDelete\" >");
    localStringBuilder.append("<m:ItemIds>");
    String[] arrayOfString = this.itemIds;
    int j = arrayOfString.length;
    while (i < j)
    {
      String str = arrayOfString[i];
      localStringBuilder.append("<t:ItemId Id=\"").append(str).append("\"/>");
      i += 1;
    }
    localStringBuilder.append("</m:ItemIds>");
    localStringBuilder.append("</m:DeleteItem>");
    localStringBuilder.append("</s:Body>");
    localStringBuilder.append("</s:Envelope>");
    return localStringBuilder.toString().getBytes();
  }
  
  public String[] getItemIds()
  {
    return this.itemIds;
  }
  
  public void setItemIds(String[] paramArrayOfString)
  {
    this.itemIds = paramArrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.request.ItemDeleteRequest
 * JD-Core Version:    0.7.0.1
 */