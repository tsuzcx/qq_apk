package com.tencent.tmdownloader;

import android.content.Context;
import com.tencent.tmassistantbase.util.ab;

class d
  implements Runnable
{
  d(a parama) {}
  
  public void run()
  {
    ab.c("BaseIPCClient", "unInitTMAssistantDownloadSDK,clientKey:" + this.a.mClientKey + ",mServiceInterface:" + this.a.mServiceInterface + ",threadId:" + Thread.currentThread().getId());
    if ((this.a.mServiceInterface != null) && (this.a.mServiceCallback != null)) {}
    try
    {
      this.a.unRegisterServiceCallback();
      label86:
      if ((this.a.mContext != null) && (this.a != null) && (this.a.mServiceInterface != null)) {
        this.a.mContext.unbindService(this.a);
      }
      this.a.mServiceInterface = null;
      this.a.mServiceCallback = null;
      this.a.connectState = "INIT";
      return;
    }
    catch (Exception localException)
    {
      break label86;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmdownloader.d
 * JD-Core Version:    0.7.0.1
 */