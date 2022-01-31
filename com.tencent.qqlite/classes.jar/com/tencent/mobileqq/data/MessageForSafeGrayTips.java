package com.tencent.mobileqq.data;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import localpb.richMsg.SafeMsg.SafeMoreInfo;

public class MessageForSafeGrayTips
  extends ChatMessage
{
  private String TAG = "Q.msg.SafeGrayTips";
  public SafeMsg.SafeMoreInfo safeInfo;
  
  public void doParse()
  {
    this.safeInfo = new SafeMsg.SafeMoreInfo();
    QLog.d(this.TAG, 2, "doParse versionCode:" + this.versionCode);
    if (this.versionCode < 3)
    {
      super.postRead();
      QLog.d(this.TAG, 2, "doParse oldversion");
      return;
    }
    try
    {
      this.safeInfo.mergeFrom(this.msgData);
      this.msg = this.safeInfo.strMsgTxt.get();
      QLog.d(this.TAG, 2, "doParse msg:");
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      localInvalidProtocolBufferMicroException.printStackTrace();
      QLog.d(this.TAG, 2, "dopase exception:" + localInvalidProtocolBufferMicroException.getMessage());
    }
  }
  
  protected void postRead()
  {
    this.msgId = getLogicMsgID(getId(), this.versionCode);
    parse();
  }
  
  protected void prewrite()
  {
    QLog.d(this.TAG, 2, "prewrite versionCode:" + this.versionCode);
    if (this.versionCode < 3) {
      super.prewrite();
    }
    while (this.safeInfo == null) {
      return;
    }
    this.safeInfo.strMsgTxt.set(this.msg);
    this.msgData = this.safeInfo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForSafeGrayTips
 * JD-Core Version:    0.7.0.1
 */