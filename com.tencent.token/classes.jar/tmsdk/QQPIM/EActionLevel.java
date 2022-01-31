package tmsdk.QQPIM;

public final class EActionLevel
{
  public static final EActionLevel EAL_Common;
  public static final EActionLevel EAL_Detail;
  public static final EActionLevel EAL_None;
  public static final EActionLevel EAL_Simple;
  public static final int _EAL_Common = 2;
  public static final int _EAL_Detail = 3;
  public static final int _EAL_None = 0;
  public static final int _EAL_Simple = 1;
  private static EActionLevel[] ee;
  private int eb;
  private String ec = new String();
  
  static
  {
    if (!EActionLevel.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      ee = new EActionLevel[4];
      EAL_None = new EActionLevel(0, 0, "EAL_None");
      EAL_Simple = new EActionLevel(1, 1, "EAL_Simple");
      EAL_Common = new EActionLevel(2, 2, "EAL_Common");
      EAL_Detail = new EActionLevel(3, 3, "EAL_Detail");
      return;
    }
  }
  
  private EActionLevel(int paramInt1, int paramInt2, String paramString)
  {
    this.ec = paramString;
    this.eb = paramInt2;
    ee[paramInt1] = this;
  }
  
  public static EActionLevel convert(int paramInt)
  {
    int i = 0;
    while (i < ee.length)
    {
      if (ee[i].value() == paramInt) {
        return ee[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static EActionLevel convert(String paramString)
  {
    int i = 0;
    while (i < ee.length)
    {
      if (ee[i].toString().equals(paramString)) {
        return ee[i];
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
 * Qualified Name:     tmsdk.QQPIM.EActionLevel
 * JD-Core Version:    0.7.0.1
 */