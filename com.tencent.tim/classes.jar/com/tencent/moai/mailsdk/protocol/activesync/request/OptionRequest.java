package com.tencent.moai.mailsdk.protocol.activesync.request;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.activesync.model.ActiveSyncInfo;

public class OptionRequest
  extends ActiveSyncRequest
{
  public OptionRequest(ActiveSyncInfo paramActiveSyncInfo)
  {
    super(paramActiveSyncInfo, "Options", "");
  }
  
  public byte[] buildCmdData()
    throws MessageException
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.request.OptionRequest
 * JD-Core Version:    0.7.0.1
 */