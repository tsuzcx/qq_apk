package com.tencent.tavcut.session;

import java.util.concurrent.Semaphore;

class TAVCutSession$21
  implements Runnable
{
  TAVCutSession$21(TAVCutSession paramTAVCutSession, Semaphore paramSemaphore) {}
  
  public void run()
  {
    this.val$lock.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutSession.21
 * JD-Core Version:    0.7.0.1
 */