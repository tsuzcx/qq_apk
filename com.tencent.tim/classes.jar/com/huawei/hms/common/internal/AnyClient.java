package com.huawei.hms.common.internal;

import com.huawei.hms.core.aidl.IMessageEntity;

public abstract interface AnyClient
{
  public abstract void connect(int paramInt);
  
  public abstract void disconnect();
  
  public abstract String getSessionId();
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
  
  public abstract void post(IMessageEntity paramIMessageEntity, String paramString, CallBack paramCallBack);
  
  public static abstract interface CallBack
  {
    public abstract void onCallback(IMessageEntity paramIMessageEntity, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.common.internal.AnyClient
 * JD-Core Version:    0.7.0.1
 */