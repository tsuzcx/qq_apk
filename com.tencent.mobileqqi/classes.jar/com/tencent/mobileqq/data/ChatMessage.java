package com.tencent.mobileqq.data;

import tencent.im.msg.im_msg_body.RichText;

public abstract class ChatMessage
  extends MessageRecord
{
  public boolean isAioAnimChecked;
  public boolean isMarketFaceFlow;
  public boolean mAnimFlag;
  public boolean mIsParsed;
  @Deprecated
  public CharSequence mMessageSource;
  @Deprecated
  public boolean mNeedGrayTips;
  public boolean mNeedTimeStamp;
  public boolean mPendantAnimatable;
  public im_msg_body.RichText richText = null;
  
  protected abstract void doParse();
  
  public void parse()
  {
    if (!this.mIsParsed) {
      try
      {
        if (!this.mIsParsed)
        {
          doParse();
          this.mIsParsed = true;
        }
        return;
      }
      finally {}
    }
  }
  
  public void reParse()
  {
    if (!this.mIsParsed) {
      return;
    }
    this.mIsParsed = false;
    parse();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.ChatMessage
 * JD-Core Version:    0.7.0.1
 */