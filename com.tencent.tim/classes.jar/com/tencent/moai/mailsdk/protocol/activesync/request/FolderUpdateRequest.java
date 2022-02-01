package com.tencent.moai.mailsdk.protocol.activesync.request;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.activesync.model.ActiveSyncInfo;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;

public class FolderUpdateRequest
  extends ActiveSyncRequest
{
  private String newName;
  private String parentId;
  private String serverId;
  private String syncKey;
  
  public FolderUpdateRequest(ActiveSyncInfo paramActiveSyncInfo)
  {
    super(paramActiveSyncInfo, "FolderUpdate", "");
  }
  
  public byte[] buildCmdData()
    throws MessageException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder.append("<FolderUpdate xmlns=\"FolderHierarchy\">");
    localStringBuilder.append("<SyncKey>").append(this.syncKey).append("</SyncKey>");
    localStringBuilder.append("<ServerId>").append(this.serverId).append("</ServerId>");
    localStringBuilder.append("<ParentId>").append(this.parentId).append("</ParentId>");
    localStringBuilder.append("<DisplayName>").append(this.newName).append("</DisplayName>");
    localStringBuilder.append("</FolderUpdate>");
    return XmlDocumentHelper.xml2Bytes(localStringBuilder.toString());
  }
  
  public String getNewName()
  {
    return this.newName;
  }
  
  public String getParentId()
  {
    return this.parentId;
  }
  
  public String getServerId()
  {
    return this.serverId;
  }
  
  public String getSyncKey()
  {
    return this.syncKey;
  }
  
  public void setNewName(String paramString)
  {
    this.newName = paramString;
  }
  
  public void setParentId(String paramString)
  {
    this.parentId = paramString;
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
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.request.FolderUpdateRequest
 * JD-Core Version:    0.7.0.1
 */