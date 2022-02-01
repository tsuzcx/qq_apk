package com.tencent.moai.mailsdk.protocol.activesync.request;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.activesync.model.ActiveSyncInfo;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;

public class ItemOperationsMailFetchRequest
  extends ActiveSyncRequest
{
  private boolean isSearchMail;
  private String serverId;
  
  public ItemOperationsMailFetchRequest(ActiveSyncInfo paramActiveSyncInfo)
  {
    super(paramActiveSyncInfo, "ItemOperations", "");
  }
  
  public byte[] buildCmdData()
    throws MessageException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder.append("<ItemOperations xmlns=\"ItemOperations\" xmlns:airsync=\"AirSync\" xmlns:airsyncbase=\"AirSyncBase\" xmlns:search=\"Search\">");
    localStringBuilder.append("<Fetch><Store>Mailbox</Store>");
    if (this.isSearchMail)
    {
      localStringBuilder.append("<search:LongId>" + this.serverId + "</search:LongId>");
      localStringBuilder.append("<Options>");
      if ("2.5".equals(this.activeSyncInfo.getActiveSyncVersion())) {
        break label182;
      }
      localStringBuilder.append("<airsync:MIMESupport>0</airsync:MIMESupport>");
      localStringBuilder.append("<airsyncbase:BodyPreference>");
      localStringBuilder.append("<airsyncbase:Type>2</airsyncbase:Type>");
      localStringBuilder.append("</airsyncbase:BodyPreference>");
    }
    for (;;)
    {
      localStringBuilder.append("</Options>");
      localStringBuilder.append("</Fetch>");
      localStringBuilder.append("</ItemOperations>");
      return XmlDocumentHelper.xml2Bytes(localStringBuilder.toString());
      localStringBuilder.append("<airsync:ServerId>" + this.serverId + "</airsync:ServerId>");
      break;
      label182:
      localStringBuilder.append("<MIMESupport>2</MIMESupport>");
    }
  }
  
  public String getServerId()
  {
    return this.serverId;
  }
  
  public void setSearchMail(boolean paramBoolean)
  {
    this.isSearchMail = paramBoolean;
  }
  
  public void setServerId(String paramString)
  {
    this.serverId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.request.ItemOperationsMailFetchRequest
 * JD-Core Version:    0.7.0.1
 */