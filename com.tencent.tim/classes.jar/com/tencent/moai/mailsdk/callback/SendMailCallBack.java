package com.tencent.moai.mailsdk.callback;

import com.tencent.moai.mailsdk.model.Mail;

public abstract interface SendMailCallBack
{
  public abstract void onError(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onProgress(long paramLong1, long paramLong2);
  
  public abstract void onSendBefore(Mail paramMail);
  
  public abstract void onSendSuccess(Mail paramMail);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.callback.SendMailCallBack
 * JD-Core Version:    0.7.0.1
 */