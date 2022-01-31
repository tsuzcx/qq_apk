package tmsdk.QQPIM;

import java.io.Serializable;

public final class EMessageTime
  implements Serializable
{
  public static final EMessageTime EMTI_END;
  public static final EMessageTime EMTI_Execute_Time_Zone;
  public static final EMessageTime EMTI_Get_X;
  public static final EMessageTime EMTI_Immediatly;
  public static final EMessageTime EMTI_None;
  public static final EMessageTime EMTI_Open;
  public static final EMessageTime EMTI_PB_Android_Private_Entry_Click;
  public static final EMessageTime EMTI_Sec_Android_Harass_Entry_Click;
  public static final int _EMTI_END = 420103001;
  public static final int _EMTI_Execute_Time_Zone = 4;
  public static final int _EMTI_Get_X = 3;
  public static final int _EMTI_Immediatly = 1;
  public static final int _EMTI_None = 0;
  public static final int _EMTI_Open = 2;
  public static final int _EMTI_PB_Android_Private_Entry_Click = 420103000;
  public static final int _EMTI_Sec_Android_Harass_Entry_Click = 120103000;
  private static EMessageTime[] en;
  private int eb;
  private String ec = new String();
  
  static
  {
    if (!EMessageTime.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      en = new EMessageTime[8];
      EMTI_None = new EMessageTime(0, 0, "EMTI_None");
      EMTI_Immediatly = new EMessageTime(1, 1, "EMTI_Immediatly");
      EMTI_Open = new EMessageTime(2, 2, "EMTI_Open");
      EMTI_Get_X = new EMessageTime(3, 3, "EMTI_Get_X");
      EMTI_Execute_Time_Zone = new EMessageTime(4, 4, "EMTI_Execute_Time_Zone");
      EMTI_Sec_Android_Harass_Entry_Click = new EMessageTime(5, 120103000, "EMTI_Sec_Android_Harass_Entry_Click");
      EMTI_PB_Android_Private_Entry_Click = new EMessageTime(6, 420103000, "EMTI_PB_Android_Private_Entry_Click");
      EMTI_END = new EMessageTime(7, 420103001, "EMTI_END");
      return;
    }
  }
  
  private EMessageTime(int paramInt1, int paramInt2, String paramString)
  {
    this.ec = paramString;
    this.eb = paramInt2;
    en[paramInt1] = this;
  }
  
  public static EMessageTime convert(int paramInt)
  {
    int i = 0;
    while (i < en.length)
    {
      if (en[i].value() == paramInt) {
        return en[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static EMessageTime convert(String paramString)
  {
    int i = 0;
    while (i < en.length)
    {
      if (en[i].toString().equals(paramString)) {
        return en[i];
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
 * Qualified Name:     tmsdk.QQPIM.EMessageTime
 * JD-Core Version:    0.7.0.1
 */