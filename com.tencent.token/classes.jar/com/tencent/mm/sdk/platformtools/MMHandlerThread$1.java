package com.tencent.mm.sdk.platformtools;

import android.os.HandlerThread;

class MMHandlerThread$1
  implements MMHandlerThread.IWaitWorkThread
{
  MMHandlerThread$1(MMHandlerThread paramMMHandlerThread, MMHandlerThread.IWaitWorkThread paramIWaitWorkThread) {}
  
  public boolean doInBackground()
  {
    MMHandlerThread.IWaitWorkThread localIWaitWorkThread = this.aq;
    if (localIWaitWorkThread != null) {
      return localIWaitWorkThread.doInBackground();
    }
    MMHandlerThread.a(this.ar).quit();
    MMHandlerThread.b(this.ar);
    return true;
  }
  
  public boolean onPostExecute()
  {
    MMHandlerThread.IWaitWorkThread localIWaitWorkThread = this.aq;
    if (localIWaitWorkThread != null) {
      return localIWaitWorkThread.onPostExecute();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMHandlerThread.1
 * JD-Core Version:    0.7.0.1
 */