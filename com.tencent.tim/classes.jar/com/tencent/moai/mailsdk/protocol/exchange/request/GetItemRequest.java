package com.tencent.moai.mailsdk.protocol.exchange.request;

import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeInfo;
import com.tencent.moai.mailsdk.util.StringUtility;

public class GetItemRequest
  extends ExchangeRequest
{
  public static final long DOWNLOAD_SIZE_MOBILE = 200L;
  private String[] changeKeys;
  private FetchType fetchType;
  private String[] itemIds;
  
  public GetItemRequest(ExchangeInfo paramExchangeInfo)
  {
    super(paramExchangeInfo, "GetItem");
  }
  
  public static long getDownloadSizeMobile()
  {
    return 200L;
  }
  
  public byte[] buildCmdData()
  {
    boolean bool = true;
    int i = 0;
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder1.append("<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:t=\"http://schemas.microsoft.com/exchange/services/2006/types\" xmlns:m=\"http://schemas.microsoft.com/exchange/services/2006/messages\">");
    localStringBuilder1.append(String.format("<s:Header><t:RequestServerVersion s:mustUnderstand=\"1\" Version=\"%s\"></t:RequestServerVersion></s:Header>", new Object[] { this.exchangeInfo.getExchangeVersion() }));
    localStringBuilder1.append("<s:Body>");
    localStringBuilder1.append("<m:GetItem>");
    localStringBuilder1.append("<m:ItemShape>");
    localStringBuilder1.append("<t:BaseShape>IdOnly</t:BaseShape>");
    StringBuilder localStringBuilder2 = localStringBuilder1.append("<t:IncludeMimeContent>");
    if (this.fetchType == FetchType.FETCH_ALL)
    {
      localStringBuilder2.append(bool).append("</t:IncludeMimeContent>");
      if (this.fetchType != FetchType.FETCH_SUMMARY) {
        break label465;
      }
      localStringBuilder1.append("<t:BodyType>").append("Text").append("</t:BodyType>");
    }
    for (;;)
    {
      localStringBuilder1.append("<t:AdditionalProperties>");
      localStringBuilder1.append("<t:FieldURI FieldURI=\"item:ItemId\"/>");
      localStringBuilder1.append("<t:FieldURI FieldURI=\"item:Subject\"/>");
      localStringBuilder1.append("<t:FieldURI FieldURI=\"item:Size\"/>");
      localStringBuilder1.append("<t:FieldURI FieldURI=\"item:HasAttachments\"/>");
      localStringBuilder1.append("<t:FieldURI FieldURI=\"item:Attachments\"/>");
      localStringBuilder1.append("<t:FieldURI FieldURI=\"item:DateTimeSent\"/>");
      localStringBuilder1.append("<t:FieldURI FieldURI=\"item:DisplayTo\"/>");
      localStringBuilder1.append("<t:FieldURI FieldURI=\"item:Body\"/>");
      localStringBuilder1.append("<t:FieldURI FieldURI=\"message:ToRecipients\"/>");
      localStringBuilder1.append("<t:FieldURI FieldURI=\"message:CcRecipients\"/>");
      localStringBuilder1.append("<t:FieldURI FieldURI=\"message:BccRecipients\"/>");
      localStringBuilder1.append("<t:FieldURI FieldURI=\"message:ReplyTo\"/>");
      localStringBuilder1.append("<t:FieldURI FieldURI=\"message:From\"/>");
      localStringBuilder1.append("<t:FieldURI FieldURI=\"message:IsRead\"/>");
      localStringBuilder1.append("<t:FieldURI FieldURI=\"message:Sender\"/>");
      localStringBuilder1.append("<t:FieldURI FieldURI=\"message:InternetMessageId\"/>");
      localStringBuilder1.append("<t:FieldURI FieldURI=\"message:IsReadReceiptRequested\"/>");
      localStringBuilder1.append("<t:ExtendedFieldURI PropertyType=\"Integer\" PropertyTag=\"").append("0x1090").append("\" />");
      localStringBuilder1.append("<t:ExtendedFieldURI PropertyType=\"Integer\" PropertyTag=\"").append("0x1095").append("\" />");
      localStringBuilder1.append("</t:AdditionalProperties>");
      if (this.fetchType == FetchType.FETCH_SUMMARY) {
        localStringBuilder1.append("<t:MaximumBodySize>").append(200L).append("</t:MaximumBodySize>");
      }
      localStringBuilder1.append("</m:ItemShape>");
      localStringBuilder1.append("<m:ItemIds>");
      int j = this.itemIds.length;
      while (i < j)
      {
        localStringBuilder1.append("<t:ItemId Id=\"").append(this.itemIds[i]).append("\" ");
        if (!StringUtility.isNullOrEmpty(this.changeKeys[i])) {
          localStringBuilder1.append("ChangeKey=\"").append(this.changeKeys[i]).append("\" ");
        }
        localStringBuilder1.append("></t:ItemId>");
        i += 1;
      }
      bool = false;
      break;
      label465:
      localStringBuilder1.append("<t:BodyType>").append("Best").append("</t:BodyType>");
    }
    localStringBuilder1.append("</m:ItemIds>");
    localStringBuilder1.append("</m:GetItem>");
    localStringBuilder1.append("</s:Body>");
    localStringBuilder1.append("</s:Envelope>");
    return localStringBuilder1.toString().getBytes();
  }
  
  public String[] getChangeKeys()
  {
    return this.changeKeys;
  }
  
  public FetchType getFetchType()
  {
    return this.fetchType;
  }
  
  public String[] getItemIds()
  {
    return this.itemIds;
  }
  
  public void setChangeKeys(String[] paramArrayOfString)
  {
    this.changeKeys = paramArrayOfString;
  }
  
  public void setFetchType(FetchType paramFetchType)
  {
    this.fetchType = paramFetchType;
  }
  
  public void setItemIds(String[] paramArrayOfString)
  {
    this.itemIds = paramArrayOfString;
  }
  
  public static enum FetchType
  {
    FETCH_ALL,  FETCH_BODY,  FETCH_SUMMARY;
    
    private FetchType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.request.GetItemRequest
 * JD-Core Version:    0.7.0.1
 */