package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import java.util.ArrayList;

public class MessageForNewGrayTips
  extends ChatMessage
{
  public ArrayList spans;
  
  protected void doParse()
  {
    try
    {
      GrayTipsInfo localGrayTipsInfo = (GrayTipsInfo)MessagePkgUtils.a(this.msgData);
      if (localGrayTipsInfo != null)
      {
        this.msg = localGrayTipsInfo.text;
        this.spans = localGrayTipsInfo.spans;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  protected void prewrite()
  {
    GrayTipsInfo localGrayTipsInfo;
    if (this.msg != null)
    {
      localGrayTipsInfo = new GrayTipsInfo();
      localGrayTipsInfo.text = this.msg;
      localGrayTipsInfo.spans = this.spans;
    }
    try
    {
      this.msgData = MessagePkgUtils.a(localGrayTipsInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void updateMsgData()
  {
    prewrite();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForNewGrayTips
 * JD-Core Version:    0.7.0.1
 */