package com.tencent.qqmail.utilities.log;

import android.support.annotation.Keep;

@Keep
public abstract interface CrashHandleListener
{
  @Keep
  public abstract void onCrash(int paramInt, Error paramError);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.CrashHandleListener
 * JD-Core Version:    0.7.0.1
 */