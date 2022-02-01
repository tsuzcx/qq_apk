package com.tencent.moai.mailsdk.protocol.exchange.request;

import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeInfo;

public class ItemUpdateRequest
  extends ExchangeRequest
{
  private String[] changeKeys;
  private int flagType;
  private int flagValue;
  private String[] itemIds;
  
  public ItemUpdateRequest(ExchangeInfo paramExchangeInfo)
  {
    super(paramExchangeInfo, "UpdateItem");
  }
  
  public byte[] buildCmdData()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder1.append("<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:t=\"http://schemas.microsoft.com/exchange/services/2006/types\" xmlns:m=\"http://schemas.microsoft.com/exchange/services/2006/messages\">");
    localStringBuilder1.append(String.format("<s:Header><t:RequestServerVersion s:mustUnderstand=\"1\" Version=\"%s\"></t:RequestServerVersion></s:Header>", new Object[] { this.exchangeInfo.getExchangeVersion() }));
    localStringBuilder1.append("<s:Body>");
    localStringBuilder1.append("<m:UpdateItem ConflictResolution=\"AlwaysOverwrite\" MessageDisposition=\"SaveOnly\" SendMeetingInvitationsOrCancellations=\"SendToNone\">");
    localStringBuilder1.append("<m:ItemChanges>");
    int j = this.itemIds.length;
    int i = 0;
    if (i < j)
    {
      localStringBuilder1.append("<t:ItemChange>");
      localStringBuilder1.append("<t:ItemId Id=\"").append(this.itemIds[i]).append("\" ChangeKey=\"").append(this.changeKeys[i]).append("\"/>");
      localStringBuilder1.append("<t:Updates>");
      boolean bool;
      if (this.flagType == 2)
      {
        localStringBuilder1.append("<t:SetItemField>");
        localStringBuilder1.append("<t:FieldURI FieldURI=\"message:IsRead\"/>");
        localStringBuilder1.append("<t:Message>");
        StringBuilder localStringBuilder2 = localStringBuilder1.append("<t:IsRead>");
        if (this.flagValue == 1)
        {
          bool = true;
          label190:
          localStringBuilder2.append(bool).append("</t:IsRead>");
          localStringBuilder1.append("</t:Message>");
          localStringBuilder1.append("</t:SetItemField>");
        }
      }
      for (;;)
      {
        localStringBuilder1.append("</t:Updates>");
        localStringBuilder1.append("</t:ItemChange>");
        i += 1;
        break;
        bool = false;
        break label190;
        if (this.flagType == 1) {
          if (this.flagValue == 1)
          {
            localStringBuilder1.append("<t:SetItemField>");
            localStringBuilder1.append("<t:ExtendedFieldURI PropertyTag=\"").append("0x1095").append("\" PropertyType=\"Integer\" />");
            localStringBuilder1.append("<t:Item>");
            localStringBuilder1.append("<t:ExtendedProperty>");
            localStringBuilder1.append("<t:ExtendedFieldURI PropertyTag=\"").append("0x1095").append("\" PropertyType=\"Integer\" />");
            localStringBuilder1.append("<t:Value>").append("6").append("</t:Value>");
            localStringBuilder1.append("</t:ExtendedProperty>");
            localStringBuilder1.append("</t:Item>");
            localStringBuilder1.append("</t:SetItemField>");
            localStringBuilder1.append("<t:SetItemField>");
            localStringBuilder1.append("<t:ExtendedFieldURI PropertyTag=\"").append("0x1090").append("\" PropertyType=\"Integer\" />");
            localStringBuilder1.append("<t:Item>");
            localStringBuilder1.append("<t:ExtendedProperty>");
            localStringBuilder1.append("<t:ExtendedFieldURI PropertyTag=\"").append("0x1090").append("\" PropertyType=\"Integer\" />");
            localStringBuilder1.append("<t:Value>").append("2").append("</t:Value>");
            localStringBuilder1.append("</t:ExtendedProperty>");
            localStringBuilder1.append("</t:Item>");
            localStringBuilder1.append("</t:SetItemField>");
          }
          else
          {
            localStringBuilder1.append("<t:DeleteItemField>");
            localStringBuilder1.append("<t:ExtendedFieldURI PropertyTag=\"").append("0x1095").append("\" PropertyType=\"Integer\" />");
            localStringBuilder1.append("</t:DeleteItemField>");
            localStringBuilder1.append("<t:DeleteItemField>");
            localStringBuilder1.append("<t:ExtendedFieldURI PropertyTag=\"").append("0x1090").append("\" PropertyType=\"Integer\" />");
            localStringBuilder1.append("</t:DeleteItemField>");
          }
        }
      }
    }
    localStringBuilder1.append("</m:ItemChanges>");
    localStringBuilder1.append("</m:UpdateItem>");
    localStringBuilder1.append("</s:Body>");
    localStringBuilder1.append("</s:Envelope>");
    return localStringBuilder1.toString().getBytes();
  }
  
  public String[] getChangeKeys()
  {
    return this.changeKeys;
  }
  
  public int getFlagType()
  {
    return this.flagType;
  }
  
  public int getFlagValue()
  {
    return this.flagValue;
  }
  
  public String[] getItemIds()
  {
    return this.itemIds;
  }
  
  public void setChangeKeys(String[] paramArrayOfString)
  {
    this.changeKeys = paramArrayOfString;
  }
  
  public void setFlagType(int paramInt)
  {
    this.flagType = paramInt;
  }
  
  public void setFlagValue(int paramInt)
  {
    this.flagValue = paramInt;
  }
  
  public void setItemIds(String[] paramArrayOfString)
  {
    this.itemIds = paramArrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.request.ItemUpdateRequest
 * JD-Core Version:    0.7.0.1
 */