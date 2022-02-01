package com.tencent.moai.mailsdk.protocol.activesync.request;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.activesync.model.ActiveSyncInfo;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;

public class FolderCreateRequest
  extends ActiveSyncRequest
{
  private String name;
  private String parentId;
  private String syncKey;
  
  public FolderCreateRequest(ActiveSyncInfo paramActiveSyncInfo)
  {
    super(paramActiveSyncInfo, "FolderCreate", "");
  }
  
  public byte[] buildCmdData()
    throws MessageException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder.append("<FolderCreate xmlns=\"FolderHierarchy\">");
    localStringBuilder.append("<SyncKey>").append(this.syncKey).append("</SyncKey>");
    localStringBuilder.append("<ParentId>").append(this.parentId).append("</ParentId>");
    localStringBuilder.append("<DisplayName>").append(this.name).append("</DisplayName>");
    localStringBuilder.append("<Type>12</Type>");
    localStringBuilder.append("</FolderCreate>");
    return XmlDocumentHelper.xml2Bytes(localStringBuilder.toString());
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getParentId()
  {
    return this.parentId;
  }
  
  public String getSyncKey()
  {
    return this.syncKey;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setParentId(String paramString)
  {
    this.parentId = paramString;
  }
  
  public void setSyncKey(String paramString)
  {
    this.syncKey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.request.FolderCreateRequest
 * JD-Core Version:    0.7.0.1
 */