package com.tencent.mm.sdk.plugin;

import android.content.Intent;

public class MMPluginMsg$ReceiverHelper
{
  Intent intent;
  int type;
  
  public MMPluginMsg$ReceiverHelper(Intent paramIntent)
  {
    this.type = paramIntent.getIntExtra("type", 0);
    this.intent = paramIntent;
  }
  
  public String getMsgContent()
  {
    if (isRecvNew()) {
      return this.intent.getStringExtra("recv_msg");
    }
    return null;
  }
  
  public Integer getSendErrCode()
  {
    if (isSendRet()) {
      return Integer.valueOf(this.intent.getIntExtra("send_err_code", 0));
    }
    return null;
  }
  
  public Integer getSendErrType()
  {
    if (isSendRet()) {
      return Integer.valueOf(this.intent.getIntExtra("send_err_type", 0));
    }
    return null;
  }
  
  public Long getSendMsgId()
  {
    if (isSendRet()) {
      return Long.valueOf(this.intent.getLongExtra("send_id", 0L));
    }
    return null;
  }
  
  public boolean isRecvNew()
  {
    return this.type == 2;
  }
  
  public boolean isSendRet()
  {
    return this.type == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.plugin.MMPluginMsg.ReceiverHelper
 * JD-Core Version:    0.7.0.1
 */