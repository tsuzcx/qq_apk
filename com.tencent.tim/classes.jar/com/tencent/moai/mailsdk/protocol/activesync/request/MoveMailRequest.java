package com.tencent.moai.mailsdk.protocol.activesync.request;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.activesync.model.ActiveSyncInfo;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;
import java.util.ArrayList;

public class MoveMailRequest
  extends ActiveSyncRequest
{
  private String destinationFolderId;
  private ArrayList<String> serverIdList;
  private String sourceFolderId;
  
  public MoveMailRequest(ActiveSyncInfo paramActiveSyncInfo)
  {
    super(paramActiveSyncInfo, "MoveItems", "");
  }
  
  public byte[] buildCmdData()
    throws MessageException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder.append("<MoveItems xmlns=\"Move\">");
    int i = 0;
    while (i < this.serverIdList.size())
    {
      localStringBuilder.append("<Move>");
      localStringBuilder.append("<SrcMsgId>" + (String)this.serverIdList.get(i) + "</SrcMsgId>");
      localStringBuilder.append("<SrcFldId>" + this.sourceFolderId + "</SrcFldId>");
      localStringBuilder.append("<DstFldId>" + this.destinationFolderId + "</DstFldId>");
      localStringBuilder.append("</Move>");
      i += 1;
    }
    localStringBuilder.append("</MoveItems>");
    return XmlDocumentHelper.xml2Bytes(localStringBuilder.toString());
  }
  
  public String getDestinationFolderId()
  {
    return this.destinationFolderId;
  }
  
  public ArrayList<String> getServerIdList()
  {
    return this.serverIdList;
  }
  
  public String getSourceFolderId()
  {
    return this.sourceFolderId;
  }
  
  public void setDestinationFolderId(String paramString)
  {
    this.destinationFolderId = paramString;
  }
  
  public void setServerIdList(ArrayList<String> paramArrayList)
  {
    this.serverIdList = paramArrayList;
  }
  
  public void setSourceFolderId(String paramString)
  {
    this.sourceFolderId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.request.MoveMailRequest
 * JD-Core Version:    0.7.0.1
 */