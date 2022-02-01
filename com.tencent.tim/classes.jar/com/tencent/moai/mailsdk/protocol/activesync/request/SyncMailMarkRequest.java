package com.tencent.moai.mailsdk.protocol.activesync.request;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.activesync.model.ActiveSyncInfo;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import java.util.ArrayList;
import java.util.Iterator;

public class SyncMailMarkRequest
  extends ActiveSyncRequest
{
  private String collectionId;
  private int markType;
  private int markValue;
  private ArrayList<String> serverIdList;
  private String syncKey;
  
  public SyncMailMarkRequest(ActiveSyncInfo paramActiveSyncInfo)
  {
    super(paramActiveSyncInfo, "Sync", "SyncMailMark");
  }
  
  public byte[] buildCmdData()
    throws MessageException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder.append("<Sync xmlns=\"AirSync\"  xmlns:airsyncbase=\"AirSyncBase\" xmlns:email=\"Email\">");
    localStringBuilder.append("<Collections><Collection>");
    if (needClassTag()) {
      localStringBuilder.append("<Class>Email</Class>");
    }
    localStringBuilder.append("<SyncKey>" + this.syncKey + "</SyncKey>");
    localStringBuilder.append("<CollectionId>" + this.collectionId + "</CollectionId>");
    if (!"2.5".equals(this.activeSyncInfo.getActiveSyncVersion())) {
      localStringBuilder.append("<GetChanges>0</GetChanges>");
    }
    localStringBuilder.append("<Options>");
    if (!"2.5".equals(this.activeSyncInfo.getActiveSyncVersion()))
    {
      localStringBuilder.append("<airsyncbase:BodyPreference>");
      localStringBuilder.append("<airsyncbase:Type>2</airsyncbase:Type>");
      localStringBuilder.append("<airsyncbase:TruncationSize>120</airsyncbase:TruncationSize>");
      localStringBuilder.append("</airsyncbase:BodyPreference>");
    }
    localStringBuilder.append("</Options>");
    localStringBuilder.append("<Commands>");
    Iterator localIterator = this.serverIdList.iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append("<Change>");
      localStringBuilder.append("<ServerId>" + str + "</ServerId>");
      localStringBuilder.append("<ApplicationData>");
      if (this.markType == 1) {
        if (this.markValue == 1)
        {
          localStringBuilder.append("<email:Flag>");
          localStringBuilder.append("<email:Status>2</email:Status>");
          localStringBuilder.append("<email:FlagType>Flag for follow up</email:FlagType>");
          localStringBuilder.append("</email:Flag>");
        }
      }
      for (;;)
      {
        localStringBuilder.append("</ApplicationData>");
        localStringBuilder.append("</Change>");
        break;
        if (this.markValue == 2)
        {
          localStringBuilder.append("<email:Flag/>");
          continue;
          if (this.markType == 2) {
            if (this.markValue == 1) {
              localStringBuilder.append("<email:Read>1</email:Read>");
            } else if (this.markValue == 2) {
              localStringBuilder.append("<email:Read>0</email:Read>");
            }
          }
        }
      }
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
  
  public int getMarkType()
  {
    return this.markType;
  }
  
  public int getMarkValue()
  {
    return this.markValue;
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
  
  public void setMarkType(int paramInt)
  {
    this.markType = paramInt;
  }
  
  public void setMarkValue(int paramInt)
  {
    this.markValue = paramInt;
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
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.request.SyncMailMarkRequest
 * JD-Core Version:    0.7.0.1
 */