package com.tencent.mm.sdk.platformtools;

import java.util.HashSet;
import java.util.Set;

public final class MMEntryLock
{
  private static Set<String> an = new HashSet();
  
  public static boolean isLocked(String paramString)
  {
    return an.contains(paramString);
  }
  
  public static boolean lock(String paramString)
  {
    if (isLocked(paramString))
    {
      Log.d("MicroMsg.MMEntryLock", "locked-" + paramString);
      return false;
    }
    Log.d("MicroMsg.MMEntryLock", "lock-" + paramString);
    return an.add(paramString);
  }
  
  public static void unlock(String paramString)
  {
    an.remove(paramString);
    Log.d("MicroMsg.MMEntryLock", "unlock-" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMEntryLock
 * JD-Core Version:    0.7.0.1
 */