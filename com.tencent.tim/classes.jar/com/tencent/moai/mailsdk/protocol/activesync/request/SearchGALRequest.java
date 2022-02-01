package com.tencent.moai.mailsdk.protocol.activesync.request;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.activesync.model.ActiveSyncInfo;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;

public class SearchGALRequest
  extends ActiveSyncRequest
{
  private int maxResult;
  private String query;
  
  public SearchGALRequest(ActiveSyncInfo paramActiveSyncInfo)
  {
    super(paramActiveSyncInfo, "Search", "SearchGAL");
  }
  
  public byte[] buildCmdData()
    throws MessageException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder.append("<Search xmlns=\"Search\">");
    localStringBuilder.append("<Store>");
    localStringBuilder.append("<Name>GAL</Name>");
    localStringBuilder.append("<Query>" + this.query + "</Query>");
    localStringBuilder.append("<Options>");
    localStringBuilder.append("<Range>0-" + this.maxResult + "</Range>");
    localStringBuilder.append("<RebuildResults/>");
    localStringBuilder.append("<DeepTraversal/>");
    localStringBuilder.append("</Options>");
    localStringBuilder.append("</Store>");
    localStringBuilder.append("</Search>");
    return XmlDocumentHelper.xml2Bytes(localStringBuilder.toString());
  }
  
  public int getMaxResult()
  {
    return this.maxResult;
  }
  
  public String getQuery()
  {
    return this.query;
  }
  
  public void setMaxResult(int paramInt)
  {
    this.maxResult = paramInt;
  }
  
  public void setQuery(String paramString)
  {
    this.query = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.request.SearchGALRequest
 * JD-Core Version:    0.7.0.1
 */