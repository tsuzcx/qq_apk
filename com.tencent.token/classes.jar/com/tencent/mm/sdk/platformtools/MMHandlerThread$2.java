package com.tencent.mm.sdk.platformtools;

import android.os.HandlerThread;

class MMHandlerThread$2
  implements MMHandlerThread.IWaitWorkThread
{
  MMHandlerThread$2(MMHandlerThread paramMMHandlerThread, MMHandlerThread.ResetCallback paramResetCallback, Object paramObject) {}
  
  public boolean doInBackground()
  {
    Log.d("MicroMsg.MMHandlerThread", "syncReset doInBackground");
    MMHandlerThread.a(this.ar).quit();
    ??? = this.as;
    if (??? != null) {
      ((MMHandlerThread.ResetCallback)???).callback();
    }
    MMHandlerThread.b(this.ar);
    synchronized (this.at)
    {
      this.at.notify();
      return true;
    }
  }
  
  public boolean onPostExecute()
  {
    Log.d("MicroMsg.MMHandlerThread", "syncReset onPostExecute");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMHandlerThread.2
 * JD-Core Version:    0.7.0.1
 */