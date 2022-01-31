package com.tencent.mm.sdk.platformtools;

class SyncTask$1
  implements Runnable
{
  SyncTask$1(SyncTask paramSyncTask) {}
  
  public void run()
  {
    SyncTask.a(this.bk, Util.ticksToNow(SyncTask.a(this.bk)));
    this.bk.setResult(this.bk.run());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SyncTask.1
 * JD-Core Version:    0.7.0.1
 */