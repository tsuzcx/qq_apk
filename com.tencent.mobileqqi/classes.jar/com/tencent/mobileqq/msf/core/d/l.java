package com.tencent.mobileqq.msf.core.d;

import com.tencent.feedback.eup.CrashHandleListener;

class l
  implements CrashHandleListener
{
  l(j paramj) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.d.l
 * JD-Core Version:    0.7.0.1
 */