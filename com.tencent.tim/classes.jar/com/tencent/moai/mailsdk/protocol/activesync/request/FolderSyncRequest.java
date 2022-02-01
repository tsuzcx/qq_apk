package com.tencent.moai.mailsdk.protocol.activesync.request;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.activesync.model.ActiveSyncInfo;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;

public class FolderSyncRequest
  extends ActiveSyncRequest
{
  private String syncKey;
  
  public FolderSyncRequest(ActiveSyncInfo paramActiveSyncInfo)
  {
    super(paramActiveSyncInfo, "FolderSync", "");
  }
  
  public byte[] buildCmdData()
    throws MessageException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder.append("<FolderSync xmlns=\"FolderHierarchy\">");
    localStringBuilder.append("<SyncKey>").append(this.syncKey).append("</SyncKey>");
    localStringBuilder.append("</FolderSync>");
    return XmlDocumentHelper.xml2Bytes(localStringBuilder.toString());
  }
  
  public String getSyncKey()
  {
    return this.syncKey;
  }
  
  public void setSyncKey(String paramString)
  {
    this.syncKey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.request.FolderSyncRequest
 * JD-Core Version:    0.7.0.1
 */