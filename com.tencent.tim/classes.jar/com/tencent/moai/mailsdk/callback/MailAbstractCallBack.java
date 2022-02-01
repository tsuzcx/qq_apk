package com.tencent.moai.mailsdk.callback;

import com.tencent.moai.mailsdk.model.Mail;

public abstract interface MailAbstractCallBack
{
  public abstract void onRetrieveMailAbstractError(long paramLong, int paramInt1, int paramInt2, String paramString);
  
  public abstract void onRetrieveMailAbstractSuccess(Mail paramMail);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.callback.MailAbstractCallBack
 * JD-Core Version:    0.7.0.1
 */