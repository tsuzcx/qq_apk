package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Bundle;

public abstract class RemoteCommand
{
  public static final String RESULT_KEY = "result_key";
  private String mCmd;
  
  public RemoteCommand(String paramString)
  {
    this.mCmd = paramString;
  }
  
  public String getCmd()
  {
    return this.mCmd;
  }
  
  public abstract Bundle invoke(Bundle paramBundle, OnInvokeFinishLinstener paramOnInvokeFinishLinstener);
  
  public boolean isSynchronized()
  {
    return true;
  }
  
  public static abstract interface OnInvokeFinishLinstener
  {
    public abstract void onInvokeFinish(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand
 * JD-Core Version:    0.7.0.1
 */