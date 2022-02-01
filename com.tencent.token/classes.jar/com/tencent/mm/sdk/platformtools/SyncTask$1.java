package com.tencent.mm.sdk.platformtools;

class SyncTask$1
  implements Runnable
{
  SyncTask$1(SyncTask paramSyncTask) {}
  
  public void run()
  {
    SyncTask localSyncTask = this.bk;
    SyncTask.a(localSyncTask, Util.ticksToNow(SyncTask.a(localSyncTask)));
    localSyncTask = this.bk;
    localSyncTask.setResult(localSyncTask.run());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SyncTask.1
 * JD-Core Version:    0.7.0.1
 */