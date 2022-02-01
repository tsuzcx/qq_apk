package com.tencent.moai.mailsdk.protocol.activesync.request;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.activesync.model.ActiveSyncInfo;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import java.util.ArrayList;

public class SyncMailAbstractRequest
  extends ActiveSyncRequest
{
  private String collectionId;
  private ArrayList<String> serverIdList;
  private String syncKey;
  
  public SyncMailAbstractRequest(ActiveSyncInfo paramActiveSyncInfo)
  {
    super(paramActiveSyncInfo, "Sync", "SyncMailAbstract");
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
    localStringBuilder.append("<Commands>");
    int i = 0;
    while (i < this.serverIdList.size())
    {
      localStringBuilder.append("<Fetch>");
      localStringBuilder.append("<ServerId>" + (String)this.serverIdList.get(i) + "</ServerId>");
      localStringBuilder.append("</Fetch>");
      i += 1;
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
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.request.SyncMailAbstractRequest
 * JD-Core Version:    0.7.0.1
 */