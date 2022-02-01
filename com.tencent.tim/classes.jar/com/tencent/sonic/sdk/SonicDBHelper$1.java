package com.tencent.sonic.sdk;

import java.util.concurrent.atomic.AtomicBoolean;

class SonicDBHelper$1
  implements Runnable
{
  SonicDBHelper$1(SonicDBHelper paramSonicDBHelper) {}
  
  public void run()
  {
    SonicUtils.removeAllSessionCache();
    SonicDBHelper.access$000().set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicDBHelper.1
 * JD-Core Version:    0.7.0.1
 */