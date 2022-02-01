package com.tencent.wework.api;

import android.content.Intent;
import com.tencent.wework.api.model.BaseMessage;

public abstract interface IWWAPI
{
  public abstract void detach();
  
  public abstract int getWWAppSupportAPI();
  
  public abstract boolean handleIntent(Intent paramIntent, IWWAPIEventHandler paramIWWAPIEventHandler);
  
  public abstract boolean isWWAppInstalled();
  
  public abstract boolean isWWAppSupportAPI();
  
  public abstract boolean openWWApp();
  
  public abstract boolean registerApp(String paramString);
  
  public abstract boolean sendMessage(BaseMessage paramBaseMessage);
  
  public abstract void unregisterApp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.wework.api.IWWAPI
 * JD-Core Version:    0.7.0.1
 */