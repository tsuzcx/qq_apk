package eipc;

import android.os.Bundle;

public abstract class EIPCModule
{
  int[] listenMessages = new int[0];
  EIPCModuleManager mgr;
  public String name;
  
  public EIPCModule(String paramString)
  {
    this.name = paramString;
  }
  
  public EIPCModule(String paramString, int[] paramArrayOfInt)
  {
    this.name = paramString;
    this.listenMessages = paramArrayOfInt;
  }
  
  public void callbackResult(int paramInt, EIPCResult paramEIPCResult)
  {
    this.mgr.callbackResult(paramInt, paramEIPCResult);
  }
  
  public abstract EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt);
  
  public void onReceiveMsg(int paramInt, Bundle paramBundle) {}
  
  public String toString()
  {
    return "name:" + this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     eipc.EIPCModule
 * JD-Core Version:    0.7.0.1
 */