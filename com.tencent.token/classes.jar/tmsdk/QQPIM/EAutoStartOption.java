package tmsdk.QQPIM;

public final class EAutoStartOption
{
  public static final EAutoStartOption EASO_Forbid = new EAutoStartOption(2, 2, "EASO_Forbid");
  public static final EAutoStartOption EASO_NONE;
  public static final EAutoStartOption EASO_OK;
  public static final int _EASO_Forbid = 2;
  public static final int _EASO_NONE = 0;
  public static final int _EASO_OK = 1;
  private static EAutoStartOption[] ef = new EAutoStartOption[3];
  private int eb;
  private String ec = new String();
  
  static
  {
    EASO_NONE = new EAutoStartOption(0, 0, "EASO_NONE");
    EASO_OK = new EAutoStartOption(1, 1, "EASO_OK");
  }
  
  private EAutoStartOption(int paramInt1, int paramInt2, String paramString)
  {
    this.ec = paramString;
    this.eb = paramInt2;
    ef[paramInt1] = this;
  }
  
  public static EAutoStartOption convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      EAutoStartOption[] arrayOfEAutoStartOption = ef;
      if (i >= arrayOfEAutoStartOption.length) {
        break;
      }
      if (arrayOfEAutoStartOption[i].value() == paramInt) {
        return ef[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static EAutoStartOption convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      EAutoStartOption[] arrayOfEAutoStartOption = ef;
      if (i >= arrayOfEAutoStartOption.length) {
        break;
      }
      if (arrayOfEAutoStartOption[i].toString().equals(paramString)) {
        return ef[i];
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
 * Qualified Name:     tmsdk.QQPIM.EAutoStartOption
 * JD-Core Version:    0.7.0.1
 */