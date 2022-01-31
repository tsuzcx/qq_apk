package com.tencent.token.utils;

import android.os.Process;

final class w
  extends ab
{
  w(UserTask paramUserTask) {}
  
  public final Object call()
  {
    try
    {
      Process.setThreadPriority(10);
      label5:
      return this.a.b();
    }
    catch (SecurityException localSecurityException)
    {
      break label5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.w
 * JD-Core Version:    0.7.0.1
 */