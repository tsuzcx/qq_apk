package com.tencent.token;

import android.content.Context;
import android.os.Debug.MemoryInfo;

public class ee
{
  public static int a(Context paramContext)
  {
    return ((android.app.ActivityManager)paramContext.getSystemService("activity")).getProcessMemoryInfo(new int[] { android.os.Process.myPid() })[0].getTotalPrivateDirty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ee
 * JD-Core Version:    0.7.0.1
 */