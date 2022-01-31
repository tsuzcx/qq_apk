package tmsdk.QQPIM;

public final class EConfirmType
{
  public static final EConfirmType ECT_Confirm_Type_End;
  public static final EConfirmType ECT_Confirm_Type_None;
  public static final EConfirmType ECT_Confirm_Type_SecondChk;
  public static final int _ECT_Confirm_Type_End = 2;
  public static final int _ECT_Confirm_Type_None = 0;
  public static final int _ECT_Confirm_Type_SecondChk = 1;
  private static EConfirmType[] ek;
  private int eb;
  private String ec = new String();
  
  static
  {
    if (!EConfirmType.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      ek = new EConfirmType[3];
      ECT_Confirm_Type_None = new EConfirmType(0, 0, "ECT_Confirm_Type_None");
      ECT_Confirm_Type_SecondChk = new EConfirmType(1, 1, "ECT_Confirm_Type_SecondChk");
      ECT_Confirm_Type_End = new EConfirmType(2, 2, "ECT_Confirm_Type_End");
      return;
    }
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
    while (i < ek.length)
    {
      if (ek[i].value() == paramInt) {
        return ek[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static EConfirmType convert(String paramString)
  {
    int i = 0;
    while (i < ek.length)
    {
      if (ek[i].toString().equals(paramString)) {
        return ek[i];
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
 * Qualified Name:     tmsdk.QQPIM.EConfirmType
 * JD-Core Version:    0.7.0.1
 */