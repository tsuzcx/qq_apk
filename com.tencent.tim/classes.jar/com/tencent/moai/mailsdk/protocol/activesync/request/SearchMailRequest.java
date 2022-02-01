package com.tencent.moai.mailsdk.protocol.activesync.request;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.activesync.model.ActiveSyncInfo;
import com.tencent.moai.mailsdk.util.DateUtils;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;

public class SearchMailRequest
  extends ActiveSyncRequest
{
  private String collectionId;
  private long endTime;
  private String keyWord;
  private long startTime;
  
  public SearchMailRequest(ActiveSyncInfo paramActiveSyncInfo)
  {
    super(paramActiveSyncInfo, "Search", "SearchMail");
  }
  
  public byte[] buildCmdData()
    throws MessageException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder.append("<Search xmlns=\"Search\" xmlns:airsync=\"AirSync\" xmlns:airsyncbase=\"AirSyncBase\" xmlns:email=\"Email\">");
    localStringBuilder.append("<Store>");
    localStringBuilder.append("<Name>Mailbox</Name>");
    localStringBuilder.append("<Query>");
    localStringBuilder.append("<And>");
    localStringBuilder.append("<airsync:Class>Email</airsync:Class>");
    if ((this.collectionId != null) && (!this.collectionId.equals("")) && (!this.collectionId.equals("-1"))) {
      localStringBuilder.append("<airsync:CollectionId>" + this.collectionId + "</airsync:CollectionId>");
    }
    localStringBuilder.append("<FreeText>" + this.keyWord + "</FreeText>");
    if (this.endTime > 0L) {
      localStringBuilder.append("<LessThan><email:DateReceived/><Value>" + DateUtils.formatTime(this.endTime) + "</Value></LessThan>");
    }
    localStringBuilder.append("</And>");
    localStringBuilder.append("</Query>");
    localStringBuilder.append("<Options>");
    localStringBuilder.append("<Range>0-19</Range>");
    localStringBuilder.append("<airsyncbase:BodyPreference>");
    localStringBuilder.append("<airsyncbase:Type>1</airsyncbase:Type>");
    localStringBuilder.append("<airsyncbase:TruncationSize>120</airsyncbase:TruncationSize>");
    localStringBuilder.append("</airsyncbase:BodyPreference>");
    localStringBuilder.append("<airsync:MIMESupport>0</airsync:MIMESupport>");
    localStringBuilder.append("<RebuildResults/><DeepTraversal/>");
    localStringBuilder.append("</Options>");
    localStringBuilder.append("</Store></Search>");
    return XmlDocumentHelper.xml2Bytes(localStringBuilder.toString());
  }
  
  public String getCollectionId()
  {
    return this.collectionId;
  }
  
  public long getEndTime()
  {
    return this.endTime;
  }
  
  public String getKeyWord()
  {
    return this.keyWord;
  }
  
  public long getStartTime()
  {
    return this.startTime;
  }
  
  public void setCollectionId(String paramString)
  {
    this.collectionId = paramString;
  }
  
  public void setEndTime(long paramLong)
  {
    this.endTime = paramLong;
  }
  
  public void setKeyWord(String paramString)
  {
    this.keyWord = paramString;
  }
  
  public void setStartTime(long paramLong)
  {
    this.startTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.request.SearchMailRequest
 * JD-Core Version:    0.7.0.1
 */