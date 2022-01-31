package com.tencent.mm.sdk.platformtools;

class MMHandlerThread$3
  implements Runnable
{
  MMHandlerThread$3(MMHandlerThread paramMMHandlerThread, MMHandlerThread.IWaitWorkThread paramIWaitWorkThread) {}
  
  public void run()
  {
    this.aq.doInBackground();
    MMHandlerThread.a(new MMHandlerThread.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMHandlerThread.3
 * JD-Core Version:    0.7.0.1
 */