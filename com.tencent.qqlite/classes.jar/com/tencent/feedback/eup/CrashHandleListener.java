package com.tencent.feedback.eup;

public abstract interface CrashHandleListener
{
  public abstract byte[] getCrashExtraData();
  
  public abstract String getCrashExtraMessage();
  
  public abstract boolean onCrashFinished(Thread paramThread, Throwable paramThrowable);
  
  public abstract void onCrashHappen(Thread paramThread, Throwable paramThrowable);
  
  public abstract void onNativeCrash(int paramInt1, int paramInt2, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.CrashHandleListener
 * JD-Core Version:    0.7.0.1
 */