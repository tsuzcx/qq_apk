package com.tencent.moai.mailsdk.protocol.activesync.request;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.activesync.model.ActiveSyncInfo;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;

public class PolicyKeyAckRequest
  extends ActiveSyncRequest
{
  private String policyKey;
  
  public PolicyKeyAckRequest(ActiveSyncInfo paramActiveSyncInfo)
  {
    super(paramActiveSyncInfo, "Provision", "PolicyKeyACK");
  }
  
  public byte[] buildCmdData()
    throws MessageException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder.append("<Provision xmlns=\"Provision\">");
    localStringBuilder.append("<Policies>");
    localStringBuilder.append("<Policy>");
    localStringBuilder.append("<PolicyType>").append(getPolicyType()).append("</PolicyType>");
    localStringBuilder.append("<PolicyKey>").append(this.policyKey).append("</PolicyKey>");
    localStringBuilder.append("<Status>1</Status>");
    localStringBuilder.append("</Policy>");
    localStringBuilder.append("</Policies>");
    localStringBuilder.append("</Provision>");
    return XmlDocumentHelper.xml2Bytes(localStringBuilder.toString());
  }
  
  public String getPolicyKey()
  {
    return this.policyKey;
  }
  
  public void setPolicyKey(String paramString)
  {
    this.policyKey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.request.PolicyKeyAckRequest
 * JD-Core Version:    0.7.0.1
 */