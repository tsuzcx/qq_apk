package com.tencent.moai.mailsdk.callback;

import com.tencent.moai.mailsdk.model.Mail;

public abstract interface MailListCallBack
{
  public abstract void onExchangeSyncFolderFinished(int paramInt, String paramString);
  
  public abstract void onExchangeSyncFolderReadStatusFinished(int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String[] paramArrayOfString4);
  
  public abstract void onRetrieveMailsError(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onRetrieveMailsSuccess(int paramInt, Mail[] paramArrayOfMail1, Mail[] paramArrayOfMail2, Mail[] paramArrayOfMail3, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.callback.MailListCallBack
 * JD-Core Version:    0.7.0.1
 */