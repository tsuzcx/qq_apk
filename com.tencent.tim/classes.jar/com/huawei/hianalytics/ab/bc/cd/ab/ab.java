package com.huawei.hianalytics.ab.bc.cd.ab;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class ab
{
  static Map<String, ef> ab = new HashMap();
  private static ab cd;
  private de bc = new de();
  
  public static ab ab()
  {
    if (cd == null) {
      de();
    }
    return cd;
  }
  
  private static void de()
  {
    try
    {
      if (cd == null) {
        cd = new ab();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public ef ab(String paramString)
  {
    return (ef)ab.get(paramString);
  }
  
  public void ab(String paramString, ef paramef)
  {
    ab.put(paramString, paramef);
  }
  
  public Set<String> bc()
  {
    return ab.keySet();
  }
  
  public de cd()
  {
    return this.bc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.cd.ab.ab
 * JD-Core Version:    0.7.0.1
 */