package com.tencent.moai.mailsdk.callback;

import com.tencent.moai.mailsdk.model.Mail;

public abstract interface SearchMailCallback
{
  public abstract void onSearchError(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onSearchMail(Mail paramMail);
  
  public abstract void onSearchSuccess(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.callback.SearchMailCallback
 * JD-Core Version:    0.7.0.1
 */