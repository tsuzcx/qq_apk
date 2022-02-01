package com.tencent.moai.mailsdk.protocol.activesync.request;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.activesync.model.ActiveSyncInfo;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import java.util.ArrayList;

public class SyncMailTextRequest
  extends ActiveSyncRequest
{
  private String collectionId;
  private ArrayList<String> serverIdList;
  private String syncKey;
  
  public SyncMailTextRequest(ActiveSyncInfo paramActiveSyncInfo)
  {
    super(paramActiveSyncInfo, "Sync", "SyncMailText");
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
    localStringBuilder.append("<CollectionId>" + this.collectionId + "</CollectionId>");
    if (!"2.5".equals(this.activeSyncInfo.getActiveSyncVersion())) {
      localStringBuilder.append("<GetChanges>0</GetChanges>");
    }
    localStringBuilder.append("<Options>");
    if (!"2.5".equals(this.activeSyncInfo.getActiveSyncVersion()))
    {
      localStringBuilder.append("<MIMESupport>0</MIMESupport>");
      localStringBuilder.append("<airsyncbase:BodyPreference>");
      localStringBuilder.append("<airsyncbase:Type>2</airsyncbase:Type>");
      localStringBuilder.append("</airsyncbase:BodyPreference>");
    }
    for (;;)
    {
      localStringBuilder.append("</Options>");
      localStringBuilder.append("<Commands>");
      int i = 0;
      while (i < this.serverIdList.size())
      {
        localStringBuilder.append("<Fetch>");
        localStringBuilder.append("<ServerId>" + (String)this.serverIdList.get(i) + "</ServerId>");
        localStringBuilder.append("</Fetch>");
        i += 1;
      }
      localStringBuilder.append("<MIMESupport>2</MIMESupport>");
    }
    localStringBuilder.append("</Commands>");
    localStringBuilder.append("</Collection></Collections>");
    localStringBuilder.append("</Sync>");
    return XmlDocumentHelper.xml2Bytes(localStringBuilder.toString());
  }
  
  public String getCollectionId()
  {
    return this.collectionId;
  }
  
  public ArrayList<String> getServerIdList()
  {
    return this.serverIdList;
  }
  
  public String getSyncKey()
  {
    return this.syncKey;
  }
  
  public void setCollectionId(String paramString)
  {
    this.collectionId = paramString;
  }
  
  public void setServerIdList(ArrayList<String> paramArrayList)
  {
    this.serverIdList = paramArrayList;
  }
  
  public void setSyncKey(String paramString)
  {
    this.syncKey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.request.SyncMailTextRequest
 * JD-Core Version:    0.7.0.1
 */