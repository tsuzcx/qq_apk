package com.tencent.moai.mailsdk.callback;

import com.tencent.moai.mailsdk.model.Mail;

public abstract interface MailCallBack
{
  public abstract void onRetrieveMailError(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onRetrieveMailSuccess(Mail paramMail);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.callback.MailCallBack
 * JD-Core Version:    0.7.0.1
 */