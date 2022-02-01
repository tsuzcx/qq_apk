package com.tencent.moai.mailsdk.protocol.activesync.request;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.activesync.model.ActiveSyncInfo;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;

public class GetItemEstimateRequest
  extends ActiveSyncRequest
{
  private String collectionId;
  private int filterType;
  private String syncKey;
  
  public GetItemEstimateRequest(ActiveSyncInfo paramActiveSyncInfo)
  {
    super(paramActiveSyncInfo, "GetItemEstimate", "");
  }
  
  public byte[] buildCmdData()
    throws MessageException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder.append("<GetItemEstimate xmlns=\"GetItemEstimate\" xmlns:airsync=\"AirSync\">");
    localStringBuilder.append("<Collections>");
    localStringBuilder.append("<Collection>");
    localStringBuilder.append("<airsync:SyncKey>").append(this.syncKey).append("</airsync:SyncKey>");
    localStringBuilder.append("<CollectionId>").append(this.collectionId).append("</CollectionId>");
    localStringBuilder.append("<airsync:Options>");
    localStringBuilder.append("<airsync:FilterType>").append(this.filterType).append("</airsync:FilterType>");
    localStringBuilder.append("<airsync:Class>").append("Email").append("</airsync:Class>");
    localStringBuilder.append("</airsync:Options>");
    localStringBuilder.append("</Collection>");
    localStringBuilder.append("</Collections>");
    localStringBuilder.append("</GetItemEstimate>");
    return XmlDocumentHelper.xml2Bytes(localStringBuilder.toString());
  }
  
  public String getCollectionId()
  {
    return this.collectionId;
  }
  
  public int getFilterType()
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
  
  public void setFilterType(int paramInt)
  {
    this.filterType = paramInt;
  }
  
  public void setSyncKey(String paramString)
  {
    this.syncKey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.request.GetItemEstimateRequest
 * JD-Core Version:    0.7.0.1
 */