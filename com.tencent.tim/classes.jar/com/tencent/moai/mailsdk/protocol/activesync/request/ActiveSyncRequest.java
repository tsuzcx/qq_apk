package com.tencent.moai.mailsdk.protocol.activesync.request;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.activesync.model.ActiveSyncInfo;
import com.tencent.moai.mailsdk.util.StringUtility;
import java.io.File;

public abstract class ActiveSyncRequest
{
  protected ActiveSyncInfo activeSyncInfo;
  protected String cmdSubType;
  protected String cmdType;
  
  public ActiveSyncRequest(ActiveSyncInfo paramActiveSyncInfo, String paramString1, String paramString2)
  {
    this.activeSyncInfo = paramActiveSyncInfo;
    this.cmdType = paramString1;
    this.cmdSubType = paramString2;
  }
  
  public byte[] buildCmdData()
    throws MessageException
  {
    return null;
  }
  
  public File buildCmdDataFile()
    throws MessageException
  {
    return null;
  }
  
  public ActiveSyncInfo getActiveSyncInfo()
  {
    return this.activeSyncInfo;
  }
  
  public String getCmdSubType()
  {
    return this.cmdSubType;
  }
  
  public String getCmdType()
  {
    return this.cmdType;
  }
  
  public String getPolicyType()
  {
    String str = this.activeSyncInfo.getActiveSyncVersion();
    if ((!StringUtility.isNullOrEmpty(str)) && (str.startsWith("2."))) {
      return "MS-WAP-Provisioning-XML";
    }
    return "MS-EAS-Provisioning-WBXML";
  }
  
  public boolean needClassTag()
  {
    String str = this.activeSyncInfo.getActiveSyncVersion();
    return ("2.5".equals(str)) || ("12.0".equals(str)) || ("12.1".equals(str));
  }
  
  public void setActiveSyncInfo(ActiveSyncInfo paramActiveSyncInfo)
  {
    this.activeSyncInfo = paramActiveSyncInfo;
  }
  
  public void setCmdSubType(String paramString)
  {
    this.cmdSubType = paramString;
  }
  
  public void setCmdType(String paramString)
  {
    this.cmdType = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.request.ActiveSyncRequest
 * JD-Core Version:    0.7.0.1
 */