package com.tencent.token.utils;

import android.os.Process;

class aa
  extends af
{
  aa(UserTask paramUserTask)
  {
    super(null);
  }
  
  public Object call()
  {
    try
    {
      Process.setThreadPriority(10);
      label5:
      return this.a.a(this.b);
    }
    catch (SecurityException localSecurityException)
    {
      break label5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.aa
 * JD-Core Version:    0.7.0.1
 */