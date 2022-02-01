package com.tencent.qqmail.model.mail.callback;

import com.tencent.qqmail.protocol.ProtocolInfo;

public abstract interface LoginCallback
{
  public abstract void onError(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onSuccess(ProtocolInfo[] paramArrayOfProtocolInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.callback.LoginCallback
 * JD-Core Version:    0.7.0.1
 */