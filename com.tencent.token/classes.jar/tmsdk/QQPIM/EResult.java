package tmsdk.QQPIM;

import java.io.Serializable;

public final class EResult
  implements Serializable
{
  public static final EResult ER_Fail;
  public static final EResult ER_Invalid;
  public static final EResult ER_Success;
  public static final int _ER_Fail = 0;
  public static final int _ER_Invalid = 2;
  public static final int _ER_Success = 1;
  private static EResult[] eu;
  private int eb;
  private String ec = new String();
  
  static
  {
    if (!EResult.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      eu = new EResult[3];
      ER_Fail = new EResult(0, 0, "ER_Fail");
      ER_Success = new EResult(1, 1, "ER_Success");
      ER_Invalid = new EResult(2, 2, "ER_Invalid");
      return;
    }
  }
  
  private EResult(int paramInt1, int paramInt2, String paramString)
  {
    this.ec = paramString;
    this.eb = paramInt2;
    eu[paramInt1] = this;
  }
  
  public static EResult convert(int paramInt)
  {
    int i = 0;
    while (i < eu.length)
    {
      if (eu[i].value() == paramInt) {
        return eu[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static EResult convert(String paramString)
  {
    int i = 0;
    while (i < eu.length)
    {
      if (eu[i].toString().equals(paramString)) {
        return eu[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public String toString()
  {
    return this.ec;
  }
  
  public int value()
  {
    return this.eb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.EResult
 * JD-Core Version:    0.7.0.1
 */