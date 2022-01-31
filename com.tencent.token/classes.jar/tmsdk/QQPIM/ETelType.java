package tmsdk.QQPIM;

public final class ETelType
{
  public static final ETelType ETT_MAX;
  public static final ETelType ETT_MIN;
  public static final ETelType ETT_MISS_CALL;
  public static final ETelType ETT_RING_ONE_SOUND;
  public static final ETelType ETT_USER_CANCEL;
  public static final ETelType ETT_USER_HANG_UP;
  public static final int _ETT_MAX = 5;
  public static final int _ETT_MIN = 0;
  public static final int _ETT_MISS_CALL = 3;
  public static final int _ETT_RING_ONE_SOUND = 1;
  public static final int _ETT_USER_CANCEL = 2;
  public static final int _ETT_USER_HANG_UP = 4;
  private static ETelType[] ew;
  private int eb;
  private String ec = new String();
  
  static
  {
    if (!ETelType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      ew = new ETelType[6];
      ETT_MIN = new ETelType(0, 0, "ETT_MIN");
      ETT_RING_ONE_SOUND = new ETelType(1, 1, "ETT_RING_ONE_SOUND");
      ETT_USER_CANCEL = new ETelType(2, 2, "ETT_USER_CANCEL");
      ETT_MISS_CALL = new ETelType(3, 3, "ETT_MISS_CALL");
      ETT_USER_HANG_UP = new ETelType(4, 4, "ETT_USER_HANG_UP");
      ETT_MAX = new ETelType(5, 5, "ETT_MAX");
      return;
    }
  }
  
  private ETelType(int paramInt1, int paramInt2, String paramString)
  {
    this.ec = paramString;
    this.eb = paramInt2;
    ew[paramInt1] = this;
  }
  
  public static ETelType convert(int paramInt)
  {
    int i = 0;
    while (i < ew.length)
    {
      if (ew[i].value() == paramInt) {
        return ew[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static ETelType convert(String paramString)
  {
    int i = 0;
    while (i < ew.length)
    {
      if (ew[i].toString().equals(paramString)) {
        return ew[i];
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
 * Qualified Name:     tmsdk.QQPIM.ETelType
 * JD-Core Version:    0.7.0.1
 */