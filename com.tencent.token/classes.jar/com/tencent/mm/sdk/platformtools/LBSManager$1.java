package com.tencent.mm.sdk.platformtools;

class LBSManager$1
  implements MTimerHandler.CallBack
{
  LBSManager$1(LBSManager paramLBSManager) {}
  
  public boolean onTimerExpired()
  {
    Log.v("MicroMsg.LBSManager", "get location by GPS failed.");
    this.P.K = true;
    this.P.start();
    LBSManager.a(this.P);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.LBSManager.1
 * JD-Core Version:    0.7.0.1
 */