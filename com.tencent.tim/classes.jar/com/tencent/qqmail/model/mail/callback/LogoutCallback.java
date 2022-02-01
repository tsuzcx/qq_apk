package com.tencent.qqmail.model.mail.callback;

import com.tencent.qqmail.protocol.Profile;

public abstract interface LogoutCallback
{
  public abstract void onError(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onSuccess(Profile paramProfile);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.callback.LogoutCallback
 * JD-Core Version:    0.7.0.1
 */