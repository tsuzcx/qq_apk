package com.tencent.mobileqq.data;

import aczw;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class MessageForHiBoom
  extends ChatMessage
{
  private static final String TAG = "MessageForHiBoom";
  public HiBoomMessage mHiBoomMessage;
  
  protected void doParse()
  {
    try
    {
      this.mHiBoomMessage = ((HiBoomMessage)aczw.c(this.msgData));
      if ((this.msg == null) && (this.mHiBoomMessage != null)) {
        this.msg = this.mHiBoomMessage.text;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MessageForHiBoom", 1, "doParse error: ", localException);
    }
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public void prewrite()
  {
    if (this.mHiBoomMessage != null) {}
    try
    {
      this.msgData = aczw.b(this.mHiBoomMessage);
      if (!TextUtils.isEmpty(this.mHiBoomMessage.text)) {
        this.msg = this.mHiBoomMessage.text;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MessageForHiBoom", 1, "prewrite error: ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForHiBoom
 * JD-Core Version:    0.7.0.1
 */