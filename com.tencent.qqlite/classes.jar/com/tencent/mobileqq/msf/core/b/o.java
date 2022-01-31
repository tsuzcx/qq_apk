package com.tencent.mobileqq.msf.core.b;

import com.tencent.feedback.eup.CrashHandleListener;

class o
  implements CrashHandleListener
{
  o(m paramm) {}
  
  public byte[] getCrashExtraData()
  {
    return null;
  }
  
  public String getCrashExtraMessage()
  {
    return null;
  }
  
  public boolean onCrashFinished(Thread paramThread, Throwable paramThrowable)
  {
    return true;
  }
  
  public void onCrashHappen(Thread paramThread, Throwable paramThrowable) {}
  
  public void onNativeCrash(int paramInt1, int paramInt2, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.b.o
 * JD-Core Version:    0.7.0.1
 */