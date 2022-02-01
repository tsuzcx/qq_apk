package tmsdk.QQPIM;

public final class EConfirmType
{
  public static final EConfirmType ECT_Confirm_Type_End = new EConfirmType(2, 2, "ECT_Confirm_Type_End");
  public static final EConfirmType ECT_Confirm_Type_None;
  public static final EConfirmType ECT_Confirm_Type_SecondChk;
  public static final int _ECT_Confirm_Type_End = 2;
  public static final int _ECT_Confirm_Type_None = 0;
  public static final int _ECT_Confirm_Type_SecondChk = 1;
  private static EConfirmType[] ek = new EConfirmType[3];
  private int eb;
  private String ec = new String();
  
  static
  {
    ECT_Confirm_Type_None = new EConfirmType(0, 0, "ECT_Confirm_Type_None");
    ECT_Confirm_Type_SecondChk = new EConfirmType(1, 1, "ECT_Confirm_Type_SecondChk");
  }
  
  private EConfirmType(int paramInt1, int paramInt2, String paramString)
  {
    this.ec = paramString;
    this.eb = paramInt2;
    ek[paramInt1] = this;
  }
  
  public static EConfirmType convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      EConfirmType[] arrayOfEConfirmType = ek;
      if (i >= arrayOfEConfirmType.length) {
        break;
      }
      if (arrayOfEConfirmType[i].value() == paramInt) {
        return ek[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static EConfirmType convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      EConfirmType[] arrayOfEConfirmType = ek;
      if (i >= arrayOfEConfirmType.length) {
        break;
      }
      if (arrayOfEConfirmType[i].toString().equals(paramString)) {
        return ek[i];
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
 * Qualified Name:     tmsdk.QQPIM.EConfirmType
 * JD-Core Version:    0.7.0.1
 */