package com.tencent.qqmail.model.mail.callback;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

public abstract interface RefreshTokenCallback
{
  public abstract void onError(int paramInt, QMNetworkError paramQMNetworkError);
  
  public abstract void onSuccess(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.callback.RefreshTokenCallback
 * JD-Core Version:    0.7.0.1
 */