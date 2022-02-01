package com.tencent.moai.mailsdk.protocol.activesync.request;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.activesync.model.ActiveSyncInfo;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;

public class SyncMailListInitRequest
  extends ActiveSyncRequest
{
  private String collectionId;
  private String filterType;
  private String syncKey;
  
  public SyncMailListInitRequest(ActiveSyncInfo paramActiveSyncInfo)
  {
    super(paramActiveSyncInfo, "Sync", "SyncMailList");
  }
  
  public byte[] buildCmdData()
    throws MessageException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder.append("<Sync xmlns=\"AirSync\" xmlns:airsyncbase=\"AirSyncBase\">");
    localStringBuilder.append("<Collections><Collection>");
    if (needClassTag()) {
      localStringBuilder.append("<Class>Email</Class>");
    }
    localStringBuilder.append("<SyncKey>").append(this.syncKey).append("</SyncKey>");
    localStringBuilder.append("<CollectionId>").append(this.collectionId).append("</CollectionId>");
    localStringBuilder.append("<Options>");
    localStringBuilder.append("<FilterType>").append(this.filterType).append("</FilterType>");
    localStringBuilder.append("<MIMETruncation>0</MIMETruncation>");
    localStringBuilder.append("<MIMESupport>0</MIMESupport>");
    if (!"2.5".equals(this.activeSyncInfo.getActiveSyncVersion()))
    {
      localStringBuilder.append("<airsyncbase:BodyPreference>");
      localStringBuilder.append("<airsyncbase:Type>1</airsyncbase:Type>");
      localStringBuilder.append("<airsyncbase:TruncationSize>120</airsyncbase:TruncationSize>");
      localStringBuilder.append("</airsyncbase:BodyPreference>");
    }
    localStringBuilder.append("</Options>");
    localStringBuilder.append("</Collection>");
    localStringBuilder.append("</Collections>");
    localStringBuilder.append("</Sync>");
    return XmlDocumentHelper.xml2Bytes(localStringBuilder.toString());
  }
  
  public String getCollectionId()
  {
    return this.collectionId;
  }
  
  public String getFilterType()
  {
    return this.filterType;
  }
  
  public String getSyncKey()
  {
    return this.syncKey;
  }
  
  public void setCollectionId(String paramString)
  {
    this.collectionId = paramString;
  }
  
  public void setFilterType(String paramString)
  {
    this.filterType = paramString;
  }
  
  public void setSyncKey(String paramString)
  {
    this.syncKey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.request.SyncMailListInitRequest
 * JD-Core Version:    0.7.0.1
 */