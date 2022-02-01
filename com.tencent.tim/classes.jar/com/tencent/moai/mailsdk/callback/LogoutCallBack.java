package com.tencent.moai.mailsdk.callback;

import com.tencent.moai.mailsdk.model.Profile;

public abstract interface LogoutCallBack
{
  public abstract void onError(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onSuccess(Profile paramProfile);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.callback.LogoutCallBack
 * JD-Core Version:    0.7.0.1
 */