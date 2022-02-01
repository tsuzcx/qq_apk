package com.tencent.moai.mailsdk.protocol.activesync.request;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.activesync.DeviceInfoHandler;
import com.tencent.moai.mailsdk.protocol.activesync.model.ActiveSyncInfo;
import com.tencent.moai.mailsdk.protocol.activesync.model.DeviceInfo;
import com.tencent.moai.mailsdk.util.XmlDocumentHelper;

public class PolicyKeyRequest
  extends ActiveSyncRequest
{
  public PolicyKeyRequest(ActiveSyncInfo paramActiveSyncInfo)
  {
    super(paramActiveSyncInfo, "Provision", "PolicyKey");
  }
  
  public byte[] buildCmdData()
    throws MessageException
  {
    DeviceInfo localDeviceInfo = DeviceInfoHandler.getInstance().getDeviceInfo();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder.append("<Provision xmlns=\"Provision\" xmlns:settings=\"Settings\">");
    if ("14.1".equals(this.activeSyncInfo.getActiveSyncVersion()))
    {
      localStringBuilder.append("<settings:DeviceInformation>");
      localStringBuilder.append("<settings:Set>");
      localStringBuilder.append("<settings:Model>").append(localDeviceInfo.getModel()).append("</settings:Model>");
      localStringBuilder.append("<settings:IMEI>").append(localDeviceInfo.getImie()).append("</settings:IMEI>");
      localStringBuilder.append("<settings:FriendlyName>").append(localDeviceInfo.getDeviceBrand()).append("</settings:FriendlyName>");
      localStringBuilder.append("<settings:OS>").append(localDeviceInfo.getOs()).append("</settings:OS>");
      localStringBuilder.append("<settings:OSLanguage>").append("").append("</settings:OSLanguage>");
      localStringBuilder.append("<settings:PhoneNumber>").append("").append("</settings:PhoneNumber>");
      localStringBuilder.append("<settings:MobileOperator>").append(localDeviceInfo.getMobileOperator()).append("</settings:MobileOperator>");
      localStringBuilder.append("<settings:UserAgent>").append(localDeviceInfo.getUserAgent()).append("</settings:UserAgent>");
      localStringBuilder.append("</settings:Set>");
      localStringBuilder.append("</settings:DeviceInformation>");
    }
    localStringBuilder.append("<Policies>");
    localStringBuilder.append("<Policy>");
    localStringBuilder.append("<PolicyType>").append(getPolicyType()).append("</PolicyType>");
    localStringBuilder.append("</Policy>");
    localStringBuilder.append("</Policies>");
    localStringBuilder.append("</Provision>");
    return XmlDocumentHelper.xml2Bytes(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.request.PolicyKeyRequest
 * JD-Core Version:    0.7.0.1
 */