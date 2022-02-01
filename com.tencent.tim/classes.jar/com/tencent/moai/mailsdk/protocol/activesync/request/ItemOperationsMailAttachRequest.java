package com.tencent.moai.mailsdk.protocol.activesync.request;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.activesync.model.ActiveSyncInfo;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;

public class ItemOperationsMailAttachRequest
  extends ActiveSyncRequest
{
  private String attachId;
  
  public ItemOperationsMailAttachRequest(ActiveSyncInfo paramActiveSyncInfo)
  {
    super(paramActiveSyncInfo, "ItemOperations", "");
  }
  
  public byte[] buildCmdData()
    throws MessageException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder.append("<ItemOperations xmlns=\"ItemOperations\" xmlns:airsync=\"AirSync\" xmlns:airsyncbase=\"AirSyncBase\">");
    localStringBuilder.append("<Fetch><Store>Mailbox</Store>");
    localStringBuilder.append("<airsyncbase:FileReference>" + this.attachId + "</airsyncbase:FileReference>");
    localStringBuilder.append("</Fetch>");
    localStringBuilder.append("</ItemOperations>");
    return XmlDocumentHelper.xml2Bytes(localStringBuilder.toString());
  }
  
  public String getAttachId()
  {
    return this.attachId;
  }
  
  public void setAttachId(String paramString)
  {
    this.attachId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.request.ItemOperationsMailAttachRequest
 * JD-Core Version:    0.7.0.1
 */