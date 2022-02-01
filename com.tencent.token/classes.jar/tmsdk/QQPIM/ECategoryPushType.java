package tmsdk.QQPIM;

public final class ECategoryPushType
{
  public static final ECategoryPushType CPUSH_HIS = new ECategoryPushType(2, 2, "CPUSH_HIS");
  public static final ECategoryPushType CPUSH_NONE;
  public static final ECategoryPushType CPUSH_PUSH;
  public static final int _CPUSH_HIS = 2;
  public static final int _CPUSH_NONE = 0;
  public static final int _CPUSH_PUSH = 1;
  private static ECategoryPushType[] eh = new ECategoryPushType[3];
  private int eb;
  private String ec = new String();
  
  static
  {
    CPUSH_NONE = new ECategoryPushType(0, 0, "CPUSH_NONE");
    CPUSH_PUSH = new ECategoryPushType(1, 1, "CPUSH_PUSH");
  }
  
  private ECategoryPushType(int paramInt1, int paramInt2, String paramString)
  {
    this.ec = paramString;
    this.eb = paramInt2;
    eh[paramInt1] = this;
  }
  
  public static ECategoryPushType convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      ECategoryPushType[] arrayOfECategoryPushType = eh;
      if (i >= arrayOfECategoryPushType.length) {
        break;
      }
      if (arrayOfECategoryPushType[i].value() == paramInt) {
        return eh[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static ECategoryPushType convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      ECategoryPushType[] arrayOfECategoryPushType = eh;
      if (i >= arrayOfECategoryPushType.length) {
        break;
      }
      if (arrayOfECategoryPushType[i].toString().equals(paramString)) {
        return eh[i];
      }
      i += 1;
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
 * Qualified Name:     tmsdk.QQPIM.ECategoryPushType
 * JD-Core Version:    0.7.0.1
 */