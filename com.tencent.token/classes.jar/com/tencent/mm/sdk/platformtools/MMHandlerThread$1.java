package com.tencent.mm.sdk.platformtools;

import android.os.HandlerThread;

class MMHandlerThread$1
  implements MMHandlerThread.IWaitWorkThread
{
  MMHandlerThread$1(MMHandlerThread paramMMHandlerThread, MMHandlerThread.IWaitWorkThread paramIWaitWorkThread) {}
  
  public boolean doInBackground()
  {
    if (this.aq != null) {
      return this.aq.doInBackground();
    }
    MMHandlerThread.a(this.ar).quit();
    MMHandlerThread.b(this.ar);
    return true;
  }
  
  public boolean onPostExecute()
  {
    if (this.aq != null) {
      return this.aq.onPostExecute();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMHandlerThread.1
 * JD-Core Version:    0.7.0.1
 */