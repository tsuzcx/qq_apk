package com.tencent.mobileqq.data;

import acfp;
import android.text.TextUtils;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

public class MessageForTroopPobing
  extends MessageForStructing
{
  public static final int DEFAULT_TEMPLATE = 2000;
  public static final String TAG = "MessageForTroopPobing";
  public String mBrief;
  public int mTemplateId;
  
  public static String buildCompatibleText()
  {
    return acfp.m(2131708189);
  }
  
  public void doParse()
  {
    super.doParse();
    if (this.structingMsg != null)
    {
      StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)this.structingMsg;
      this.mBrief = localStructMsgForGeneralShare.mMsgBrief;
      this.msg = this.mBrief;
      this.mTemplateId = localStructMsgForGeneralShare.pobingTemplateId;
    }
  }
  
  public String getSummaryMsg()
  {
    if (TextUtils.isEmpty(this.msg)) {
      return acfp.m(2131708148);
    }
    return this.msg;
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MessageForTroopPobing{");
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTroopPobing
 * JD-Core Version:    0.7.0.1
 */