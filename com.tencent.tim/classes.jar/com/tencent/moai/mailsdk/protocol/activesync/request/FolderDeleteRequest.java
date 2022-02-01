package com.tencent.moai.mailsdk.protocol.activesync.request;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.activesync.model.ActiveSyncInfo;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;

public class FolderDeleteRequest
  extends ActiveSyncRequest
{
  private String serverId;
  private String syncKey;
  
  public FolderDeleteRequest(ActiveSyncInfo paramActiveSyncInfo)
  {
    super(paramActiveSyncInfo, "FolderDelete", "");
  }
  
  public byte[] buildCmdData()
    throws MessageException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder.append("<FolderDelete xmlns=\"FolderHierarchy\">");
    localStringBuilder.append("<SyncKey>").append(this.syncKey).append("</SyncKey>");
    localStringBuilder.append("<ServerId>").append(this.serverId).append("</ServerId>");
    localStringBuilder.append("</FolderDelete>");
    return XmlDocumentHelper.xml2Bytes(localStringBuilder.toString());
  }
  
  public String getServerId()
  {
    return this.serverId;
  }
  
  public String getSyncKey()
  {
    return this.syncKey;
  }
  
  public void setServerId(String paramString)
  {
    this.serverId = paramString;
  }
  
  public void setSyncKey(String paramString)
  {
    this.syncKey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.request.FolderDeleteRequest
 * JD-Core Version:    0.7.0.1
 */