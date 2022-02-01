package com.tencent.moai.mailsdk.protocol.exchange.request;

import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeInfo;

public class ItemMoveRequest
  extends ExchangeRequest
{
  private String[] changeKeys;
  private String[] itemIds;
  private String toFolderId;
  private boolean useDistinguishedFolderId;
  
  public ItemMoveRequest(ExchangeInfo paramExchangeInfo)
  {
    super(paramExchangeInfo, "MoveItem");
  }
  
  public byte[] buildCmdData()
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder.append("<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:t=\"http://schemas.microsoft.com/exchange/services/2006/types\" xmlns:m=\"http://schemas.microsoft.com/exchange/services/2006/messages\">");
    localStringBuilder.append(String.format("<s:Header><t:RequestServerVersion s:mustUnderstand=\"1\" Version=\"%s\"></t:RequestServerVersion></s:Header>", new Object[] { this.exchangeInfo.getExchangeVersion() }));
    localStringBuilder.append("<s:Body>");
    localStringBuilder.append("<m:MoveItem>");
    localStringBuilder.append("<m:ToFolderId>");
    if (this.useDistinguishedFolderId) {
      localStringBuilder.append("<t:DistinguishedFolderId Id=\"").append(this.toFolderId).append("\"/>");
    }
    for (;;)
    {
      localStringBuilder.append("</m:ToFolderId>");
      localStringBuilder.append("<m:ItemIds>");
      int j = this.itemIds.length;
      while (i < j)
      {
        localStringBuilder.append("<t:ItemId Id=\"").append(this.itemIds[i]).append("\" ChangeKey=\"").append(this.changeKeys[i]).append("\"/>");
        i += 1;
      }
      localStringBuilder.append("<t:FolderId Id=\"").append(this.toFolderId).append("\"/>");
    }
    localStringBuilder.append("</m:ItemIds>");
    localStringBuilder.append("</m:MoveItem >");
    localStringBuilder.append("</s:Body>");
    localStringBuilder.append("</s:Envelope>");
    return localStringBuilder.toString().getBytes();
  }
  
  public String[] getChangeKeys()
  {
    return this.changeKeys;
  }
  
  public String[] getItemIds()
  {
    return this.itemIds;
  }
  
  public String getToFolderId()
  {
    return this.toFolderId;
  }
  
  public boolean isUseDistinguishedFolderId()
  {
    return this.useDistinguishedFolderId;
  }
  
  public void setChangeKeys(String[] paramArrayOfString)
  {
    this.changeKeys = paramArrayOfString;
  }
  
  public void setItemIds(String[] paramArrayOfString)
  {
    this.itemIds = paramArrayOfString;
  }
  
  public void setToFolderId(String paramString)
  {
    this.toFolderId = paramString;
  }
  
  public void setUseDistinguishedFolderId(boolean paramBoolean)
  {
    this.useDistinguishedFolderId = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.request.ItemMoveRequest
 * JD-Core Version:    0.7.0.1
 */