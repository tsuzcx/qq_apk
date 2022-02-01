package com.huawei.hianalytics.ab.bc.hi;

import java.util.HashMap;
import java.util.Map;

public final class ab
{
  private static ab ab;
  private volatile Map<String, bc> bc = new HashMap();
  
  public static ab ab()
  {
    if (ab == null) {
      bc();
    }
    return ab;
  }
  
  private bc bc(String paramString)
  {
    if (!this.bc.containsKey(paramString))
    {
      bc localbc = new bc();
      this.bc.put(paramString, localbc);
    }
    return (bc)this.bc.get(paramString);
  }
  
  private static void bc()
  {
    try
    {
      if (ab == null) {
        ab = new ab();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public bc ab(String paramString, long paramLong)
  {
    paramString = bc(paramString);
    paramString.ab(paramLong);
    return paramString;
  }
  
  public void ab(String paramString)
  {
    bc(paramString).cd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.hi.ab
 * JD-Core Version:    0.7.0.1
 */